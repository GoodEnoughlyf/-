package caiquan;
/**
 * 机器玩家 属性和方法的封装
 * @author 木子一夫
 *
 */
public class ComputerPlayer {
	public static final int MessageTypeFist=1;//出拳的信息
	public static final int MessageTypeWin=2;//胜利的信息
	public static final int MessageTypeLose=3;//失败的信息
	
	private String name;
	private int score;
	private int fist;
	
	private String[] fistWords=//出拳时语音
	{
		"111111111",
		"2222222222222",
		"3333333",
		"4444444",
		"5555555555"
	};
	
	private String[] winWords=//胜利时语音
	{
		"66666666666666",
		"7777777777777777777777777",
		"888888888888888888",
		"9999999999999999嗷嗷",
		"000000000000000呜"
	};
	
	private String[] loseWords=//失败时语音
	{
		"ssssssssss",
		"ddddddddddddddddddd！",
		"……sssssssddddd…",
		"&&&&cccccccccccccc&",
		"呃qqqqqqqqqqqqqqq呃呃d"
	};

	public void sendMessage(int msgType)//根据传入的消息类型，打印对应类型的消息
	{
		int index=(int)(Math.random()*1000)%5;//取下标0-4
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
