package caiquan;
/**
 * ������� ���Ժͷ����ķ�װ
 * @author ľ��һ��
 *
 */
public class ComputerPlayer {
	public static final int MessageTypeFist=1;//��ȭ����Ϣ
	public static final int MessageTypeWin=2;//ʤ������Ϣ
	public static final int MessageTypeLose=3;//ʧ�ܵ���Ϣ
	
	private String name;
	private int score;
	private int fist;
	
	private String[] fistWords=//��ȭʱ����
	{
		"111111111",
		"2222222222222",
		"3333333",
		"4444444",
		"5555555555"
	};
	
	private String[] winWords=//ʤ��ʱ����
	{
		"66666666666666",
		"7777777777777777777777777",
		"888888888888888888",
		"9999999999999999��",
		"000000000000000��"
	};
	
	private String[] loseWords=//ʧ��ʱ����
	{
		"ssssssssss",
		"ddddddddddddddddddd��",
		"����sssssssddddd��",
		"&&&&cccccccccccccc&",
		"��qqqqqqqqqqqqqqq����d"
	};

	public void sendMessage(int msgType)//���ݴ������Ϣ���ͣ���ӡ��Ӧ���͵���Ϣ
	{
		int index=(int)(Math.random()*1000)%5;//ȡ�±�0-4
		String message=null;
		switch(msgType)
		{
		case MessageTypeFist:
			message=fistWords[index];
			break;
			
		case MessageTypeWin:
			message=winWords[index];
			break;
			
		case MessageTypeLose:
			message=loseWords[index];
			break;
		}
		System.out.println(message);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getFist() {
		fist=(int)(Math.random()*1000)%4;
		return fist;
	}

}
