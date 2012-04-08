package com.yeeamte.robotbird;

/**
 * @author batfree this class is for twitalker command.
 */
public class RobotCommand {
	static int id = 0;
	String command = "";
	public static final int TWEET = 0;// ● 发推：直接发送140字以内的消息即可
	public static final int BIND = 1;// ● 绑定用户：-v 认证码 密钥
	public static final int ON = 2;// ● 开启完全消息接收(接收好友消息和私信)：-on
	public static final int SELF = 3;// ● 开启自我消息接收(只接受@我消息和私信)：-self
	public static final int OFF = 4;// ● 完全关闭消息接收(屏蔽所有消息)：-off
	public static final int LIVE = 5;// ● 直播模式消息接收(接收默认群组消息)：-live
	public static final int DMSG = 6;// ● 给某人发送私信：-d 用户名 私信内容
	public static final int REPLY_USER = 7;// ● 回复某人：@用户名 内容
	public static final int FOLLOW1 = 8;
	public static final int UNFOLLOW1 = 9;
	public static final int ID_ON = 10;
	public static final int ID_OFF = 11;
	public static final int SELF_STATUS = 12;// ● 个人TwiTalker信息：-status 或 -st
	public static final int REFRESH_TIME = 13;// ● 设置消息接收刷新时间：-time 分钟数
												// (只能取1到5的整数)
	public static final int GET_FAV = 14;// ● 查看收藏：-fav 页数
											// (页数可省略，页数之前要带字母P，如-fav p2)
	public static final int GET_DIRECT = 15;// ● 查看私信：-d 页数 (页数可省略，页数之前要带字母P，如-d
											// p2)
	public static final int GET_REPLY = 16;// ● @我消息：-@ 页数 (页数可省略，页数之前要带字母P，如-@
											// p2)
	public static final int GET_RT = 17;// ● 好友RT消息：-rt 页数 (页数可省略，页数之前要带字母P，如-rt
										// p2)
	public static final int GET_ME = 18;// ● 自己发表的消息：-me 页数
										// (页数可省略，页数之前要带字母P，如-me p2)
	public static final int GET_HOME = 19;// ● 最近好友更新：-home 页数 或 -ho 页数
											// (页数可省略，页数之前要带字母P，如-ho p2)
	public static final int GET_USER_TWEET = 20;// ● 查看用户更新：-tl 用户名 页数
												// (页数可省略，页数之前要带字母P，如-tl
												// twi_talker p2)
	public static final int REPLY_TWEET = 21;// ● 回复特定消息：-@ 消息id号 回复内容
	public static final int GET_MSG = 22;// ● 查看特定消息：-msg 消息id号
	public static final int DEL_RECENT_TWEET = 23;// ● 删除最近发布的一条消息：-del
	public static final int DEL_TWEET = 24;// ● 删除自己的消息：-del 消息id号
	public static final int SET_FAV = 25;// ● 消息收藏：-fav 消息id号
	public static final int SET_UNFAV = 26;// ● 取消消息收藏：-unfav 消息id号
	public static final int RT = 27;// ● 消息RT：-rt 消息id号 附加消息(附加消息可省略)
	public static final int RT_TWITTER = 28;// ● 官方RT：-r 消息id号
	public static final int USER_STATUS = 29;// ● 查看某人信息：-status 用户名 或 -st 用户名
	public static final int FOLLOW = 30;// ● 关注某人：-follow 用户名 或 -fo 用户名
	public static final int UNFOLLOW = 31;// ● 取消关注某人: -unfollow 用户名 或 -uf 用户名
	public static final int BLOCK = 32;// ● 拉黑某人: -block 用户名
	public static final int IS_FOLLOW = 33;// ● 某人是否关注你: -if 用户
	public static final int BIND_LIST = 34;// ● 查看绑定帐号列表: -bind
	public static final int UNBIND = 35;// ● 取消指定帐号绑定：-unbind 帐号名
	public static final int SWITCH = 36;// ● 帐号切换：-switch 帐号名 或 -sw 帐号名

	public static RobotCommand getCommand(int type, String... arg) {
		RobotCommand robotCMD = new RobotCommand();
		robotCMD.id++;
		StringBuffer sb = new StringBuffer();
		for (String str : arg) {
			sb.append(" ");
			sb.append(str);
		}
		String cmd = sb.toString();
		switch (type) {
		case TWEET:
			cmd = sb.toString();
			break;
		case BIND:
			if (arg.length == 2) {
				cmd = sb.insert(0, "-v").toString();
			}
			break;
		case ON:
			cmd = "-on";
			break;
		case OFF:
			cmd = "-off";
			break;
		case SELF:
			cmd = "-self";
			break;
		case LIVE:
			cmd = "-live";
			break;
		case DMSG:
			cmd = sb.insert(0, "-d").toString();
			break;
		case REPLY_USER:
			cmd = "@" + sb.toString().trim();
			break;
		case SELF_STATUS:
			cmd = "-st";
			break;
		case REFRESH_TIME:
			cmd = "-time" + sb.toString();
			break;
		case GET_FAV:
			cmd = "-fav" + sb.toString();
			break;
		case GET_DIRECT:
			cmd = "-d" + sb.toString();
			break;
		case GET_REPLY:
			cmd = "-@" + sb.toString();
			break;
		case GET_RT:
			cmd = "-rt" + sb.toString();
			break;
		case GET_ME:
			cmd = "-me" + sb.toString();
			break;
		case GET_HOME:
			cmd = "-home" + sb.toString();
			break;
		case GET_USER_TWEET:
			cmd = "-tl" + sb.toString();
			break;
		case REPLY_TWEET:
			cmd = "-@" + sb.toString();
			break;
		case GET_MSG:
			cmd = "-msg" + sb.toString();
			break;
		case DEL_RECENT_TWEET:
			cmd = "-del";
			break;
		case DEL_TWEET:
			cmd = "-del" + sb.toString();
			break;
		case SET_FAV:
			cmd = "-fav" + sb.toString();
			break;
		case SET_UNFAV:
			cmd = "-unfav" + sb.toString();
			break;
		case RT:
			cmd = "-rt" + sb.toString();
			break;
		case RT_TWITTER:
			cmd = "-r" + sb.toString();
			break;
		case USER_STATUS:
			cmd = "-st" + sb.toString();
			break;
		case FOLLOW:
			cmd = "-fo" + sb.toString();
			break;
		case UNFOLLOW:
			cmd = "-uf" + sb.toString();
			break;
		case BLOCK:
			cmd = "-block" + sb.toString();
			break;
		case IS_FOLLOW:
			cmd = "-if" + sb.toString();
			break;
		case BIND_LIST:
			cmd = "-bind";
			break;
		case UNBIND:
			cmd = "-unbind" + sb.toString();
			break;
		case SWITCH:
			cmd = "-sw" + sb.toString();
			break;
		default:
			cmd = sb.toString();
		}
		robotCMD.command = cmd;
		return robotCMD;

	}
}
