package caiquan;
/**
 * 人类玩家 属性和方法的封装
 * @author 木子一夫
 *
 */
public class HumenPlayer {
	public static final int MessageTypeFist=1;//出拳的信息
	public static final int MessageTypeWin=2;//胜利的信息
	public static final int MessageTypeLose=3;//失败的信息
	
	private String name;
	private int score;
	private int fist;
	
	private String[] fistWords=//出拳时语音
	{
		"动感光波~biubiubiu~~~",
		"火遁。豪火球之术",
		"螺旋丸",
		"千鸟",
		"天照"
	};
	
	private String[] winWords=//胜利时语音
	{
		"我叼你*的~~~",
		"啊啊啊啊啊啊啊啊啊啊啊啊啊",
		"噢噢噢噢噢噢噢噢噢噢噢噢",
		"嗷嗷哦嗷嗷嗷嗷嗷",
		"呜呜呜呜呜呜呜"
	};
	
	private String[] loseWords=//失败时语音
	{
		"。。。。。。",
		"！！！！！！",
		"…………………………",
		"&&&&&&&&&&&&",
		"呃呃呃呃呃呃呃呃呃d"
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
		return fist;
	}

	public void setFist(int fist) {
		this.fist = fist;
	}
	
	
}
