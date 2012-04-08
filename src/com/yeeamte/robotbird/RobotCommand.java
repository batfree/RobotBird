package com.yeeamte.robotbird;

/**
 * @author batfree this class is for twitalker command.
 */
public class RobotCommand {
	static int id = 0;
	String command = "";
	public static final int TWEET = 0;// �� ���ƣ�ֱ�ӷ���140�����ڵ���Ϣ����
	public static final int BIND = 1;// �� ���û���-v ��֤�� ��Կ
	public static final int ON = 2;// �� ������ȫ��Ϣ����(���պ�����Ϣ��˽��)��-on
	public static final int SELF = 3;// �� ����������Ϣ����(ֻ����@����Ϣ��˽��)��-self
	public static final int OFF = 4;// �� ��ȫ�ر���Ϣ����(����������Ϣ)��-off
	public static final int LIVE = 5;// �� ֱ��ģʽ��Ϣ����(����Ĭ��Ⱥ����Ϣ)��-live
	public static final int DMSG = 6;// �� ��ĳ�˷���˽�ţ�-d �û��� ˽������
	public static final int REPLY_USER = 7;// �� �ظ�ĳ�ˣ�@�û��� ����
	public static final int FOLLOW1 = 8;
	public static final int UNFOLLOW1 = 9;
	public static final int ID_ON = 10;
	public static final int ID_OFF = 11;
	public static final int SELF_STATUS = 12;// �� ����TwiTalker��Ϣ��-status �� -st
	public static final int REFRESH_TIME = 13;// �� ������Ϣ����ˢ��ʱ�䣺-time ������
												// (ֻ��ȡ1��5������)
	public static final int GET_FAV = 14;// �� �鿴�ղأ�-fav ҳ��
											// (ҳ����ʡ�ԣ�ҳ��֮ǰҪ����ĸP����-fav p2)
	public static final int GET_DIRECT = 15;// �� �鿴˽�ţ�-d ҳ�� (ҳ����ʡ�ԣ�ҳ��֮ǰҪ����ĸP����-d
											// p2)
	public static final int GET_REPLY = 16;// �� @����Ϣ��-@ ҳ�� (ҳ����ʡ�ԣ�ҳ��֮ǰҪ����ĸP����-@
											// p2)
	public static final int GET_RT = 17;// �� ����RT��Ϣ��-rt ҳ�� (ҳ����ʡ�ԣ�ҳ��֮ǰҪ����ĸP����-rt
										// p2)
	public static final int GET_ME = 18;// �� �Լ��������Ϣ��-me ҳ��
										// (ҳ����ʡ�ԣ�ҳ��֮ǰҪ����ĸP����-me p2)
	public static final int GET_HOME = 19;// �� ������Ѹ��£�-home ҳ�� �� -ho ҳ��
											// (ҳ����ʡ�ԣ�ҳ��֮ǰҪ����ĸP����-ho p2)
	public static final int GET_USER_TWEET = 20;// �� �鿴�û����£�-tl �û��� ҳ��
												// (ҳ����ʡ�ԣ�ҳ��֮ǰҪ����ĸP����-tl
												// twi_talker p2)
	public static final int REPLY_TWEET = 21;// �� �ظ��ض���Ϣ��-@ ��Ϣid�� �ظ�����
	public static final int GET_MSG = 22;// �� �鿴�ض���Ϣ��-msg ��Ϣid��
	public static final int DEL_RECENT_TWEET = 23;// �� ɾ�����������һ����Ϣ��-del
	public static final int DEL_TWEET = 24;// �� ɾ���Լ�����Ϣ��-del ��Ϣid��
	public static final int SET_FAV = 25;// �� ��Ϣ�ղأ�-fav ��Ϣid��
	public static final int SET_UNFAV = 26;// �� ȡ����Ϣ�ղأ�-unfav ��Ϣid��
	public static final int RT = 27;// �� ��ϢRT��-rt ��Ϣid�� ������Ϣ(������Ϣ��ʡ��)
	public static final int RT_TWITTER = 28;// �� �ٷ�RT��-r ��Ϣid��
	public static final int USER_STATUS = 29;// �� �鿴ĳ����Ϣ��-status �û��� �� -st �û���
	public static final int FOLLOW = 30;// �� ��עĳ�ˣ�-follow �û��� �� -fo �û���
	public static final int UNFOLLOW = 31;// �� ȡ����עĳ��: -unfollow �û��� �� -uf �û���
	public static final int BLOCK = 32;// �� ����ĳ��: -block �û���
	public static final int IS_FOLLOW = 33;// �� ĳ���Ƿ��ע��: -if �û�
	public static final int BIND_LIST = 34;// �� �鿴���ʺ��б�: -bind
	public static final int UNBIND = 35;// �� ȡ��ָ���ʺŰ󶨣�-unbind �ʺ���
	public static final int SWITCH = 36;// �� �ʺ��л���-switch �ʺ��� �� -sw �ʺ���

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
