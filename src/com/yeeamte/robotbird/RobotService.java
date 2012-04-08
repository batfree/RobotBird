package com.yeeamte.robotbird;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;

import org.jivesoftware.smack.*;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.packet.Message;

public class RobotService extends Service implements Runnable {
	public static final String RESOURCE = "twitalker_client";
	XMPPConnection xmpp = null;
	Chat chat = null;
	ChatManager chatMag = null;
	ConnectionConfiguration config = null;
	String user = "";
	String password = "";
	String server = "";
	int port = 5222;
	SharedPreferences pref = null;
	String chatRobot = "";// 对话机器人的JID

	@Override
	public IBinder onBind(Intent intent) {
		
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		pref = this.getSharedPreferences("setting", Context.MODE_PRIVATE);
		user = pref.getString("username", "username");
		password = pref.getString("password", "password");
		server = pref.getString("server", "jabber.org");
		port = pref.getInt("serverport", 5222);
		chatRobot = pref.getString("robot_jid", "test@gmail.com");
		config = new ConnectionConfiguration(server, port, RESOURCE);
		config.setSecurityMode(SecurityMode.enabled);
		xmpp = new XMPPConnection(config);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (xmpp != null && xmpp.isConnected()) {
			xmpp.disconnect();
		}
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		new Thread(this).start();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void run() {
		try {

			xmpp.addConnectionListener(new ConnectionListener() {

				@Override
				public void connectionClosed() {
					Log.d("ConnectionClosed()");

				}

				@Override
				public void connectionClosedOnError(Exception exception) {
					Log.d("ConnectionClosedOnError," + exception.getMessage());

				}

				@Override
				public void reconnectingIn(int min) {
					Log.d("reconnectionIn:" + min);

				}

				@Override
				public void reconnectionFailed(Exception except) {
					Log.d("reconnectionFailed:" + except.getMessage());

				}

				@Override
				public void reconnectionSuccessful() {
					Log.d("reconnectionSuccessful()");

				}
			});
			xmpp.connect();
			if (xmpp.isConnected()) {
				chatMag = xmpp.getChatManager();
				chat = chatMag.createChat(chatRobot, new MessageListener() {

					@Override
					public void processMessage(Chat chat, Message msg) {
						Log.d(msg.toXML());
					}
				});
			}

		} catch (XMPPException e) {
			Log.d(e.toString());
			e.printStackTrace();
		}
	}

	public Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if(chat!=null){
				try {
				    Message chatMsg=new Message();
				    chatMsg.setProperty("cmd_id", ""+msg.getData().getInt("id"));
				    chatMsg.setBody(msg.getData().getString("cmd"));
					chat.sendMessage(chatMsg);
				} catch (XMPPException e) {
					Log.d(e.getMessage());
					e.printStackTrace();
				}
			}
		}
	};
	public void sendRequest(RobotCommand cmd){
		Bundle bundle=new Bundle();
		bundle.putInt("id",cmd.id);
		bundle.putString("cmd", cmd.command);
		android.os.Message msg=handler.obtainMessage();
		msg.setData(bundle);
		handler.sendMessage(msg);
	}
}
