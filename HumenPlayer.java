package caiquan;
/**
 * ������� ���Ժͷ����ķ�װ
 * @author ľ��һ��
 *
 */
public class HumenPlayer {
	public static final int MessageTypeFist=1;//��ȭ����Ϣ
	public static final int MessageTypeWin=2;//ʤ������Ϣ
	public static final int MessageTypeLose=3;//ʧ�ܵ���Ϣ
	
	private String name;
	private int score;
	private int fist;
	
	private String[] fistWords=//��ȭʱ����
	{
		"���йⲨ~biubiubiu~~~",
		"��ݡ�������֮��",
		"������",
		"ǧ��",
		"����"
	};
	
	private String[] winWords=//ʤ��ʱ����
	{
		"�ҵ���*��~~~",
		"��������������������������",
		"������������������������",
		"��Ŷ�����",
		"��������������"
	};
	
	private String[] loseWords=//ʧ��ʱ����
	{
		"������������",
		"������������",
		"��������������������",
		"&&&&&&&&&&&&",
		"������������������d"
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
		return fist;
	}

	public void setFist(int fist) {
		this.fist = fist;
	}
	
	
}
