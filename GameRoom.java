package caiquan;

import java.util.Scanner;

/**
 * 游戏房间
 * @author 木子一夫
 *
 */
public class GameRoom {
	private HumenPlayer p1 = null;
	private ComputerPlayer p2 = null;
	private int roomId;
	private String roomName;
	private String roomPass;// 房间密码
	
	public GameRoom(String roomName,String roomPass)
	{
		if(!("李一夫的游戏".equals(roomName) && "123456".equals(roomPass)))
		{
			System.out.println("房间密码错误！游戏强制推出！");
			return;
		}
		this.setRoomName(roomName);
		initGame();
		startGame();
		endGame();
		
	}
	
	public void initGame()//进入游戏
	{
		//1、实例化游戏玩家对象
		p1 =new HumenPlayer();
		p2 =new ComputerPlayer();
		//2、初始化游戏其他属性
		for (int i = 0; i <30; i++) {
			System.out.print("*");
			try {
				Thread.sleep(50);//休眠50ms
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("游戏加载成功！");
		
	}
	
	public void startGame()//开始游戏
	{
		showMenu();
		choiceRole();
		gaming();
	}
	
	private void gaming()
	{
		while(true)
		{
			//1、双方出拳
			System.out.print(p1.getName()+"请出拳：");
			p1.setFist(new Scanner(System.in).nextInt());//设置p1出拳
			int f1=p1.getFist();//记录p1出拳
			/**
			 * 这里出拳设置也可以改成两句话
			 * scanner input=new scanner(system.in);
			 * p1.setfist(input.nextint());
			 */
			int f2=p2.getFist();//设置并记录p2出拳
			
			//2、判断输赢
			int result=judge(f1, f2);
			if(result == -1)
			{
				System.out.println("【习近平】:"+p1.getName()+"胜利");
				p1.sendMessage(HumenPlayer.MessageTypeWin);
				p2.sendMessage(ComputerPlayer.MessageTypeLose);
			}
			else if(result == 0)
				System.out.println("【习近平】:平局了！");
			else
			{
				System.out.println("【习近平】:"+p2.getName()+"胜利");
				p1.sendMessage(HumenPlayer.MessageTypeLose);
				p2.sendMessage(ComputerPlayer.MessageTypeWin);
			}
			System.out.print("是否继续游戏?(y/n)");
			String answer=new Scanner(System.in).next();
			if(!"y".equalsIgnoreCase(answer))
				break;
		}
		}
			
			//3、打印结果
			public void showMenu()//显示菜单
			{
				System.out.println("欢迎进入<<"+roomName+">>游戏房间");
				System.out.println("出拳规则：1-剪刀 2-布 3-石头");
			}
				
			public void choiceRole()//选择人物
			{
				System.out.println("对方角色：1-丑陋的冯文杰屌毛 2-李志轩 3-戴振华 4-陈云");
				System.out.print("请选择：");
				Scanner input = new Scanner(System.in);
				int choice = input.nextInt();
				String[] nameArray ={"丑陋的冯文杰屌毛","李志轩","戴振华","陈云"};
				 p2.setName(nameArray[choice-1]);
				 p1.setName("帅气的李一夫");
				 System.out.println(p1.getName()+"VS"+p2.getName());
			}
				
			public int judge(int f1,int f2)//判断输赢
			{
				if(f1==f2)
					return 0;//平局
				else if((f1==1 && f2==3) || (f1==2 && f2==1) || (f1==3 && f2==2))
				{
					//胜利后玩家一分数加一，玩家二分数减一
					p1.setScore(p1.getScore()+1);
					p2.setScore(p2.getScore()-1);
					return -1;//玩家一胜利
				}
				else
				{
					p1.setScore(p1.getScore()-1);
					p2.setScore(p2.getScore()+1);
					return 1;
				}
			}

	
	public void endGame()
	{
		System.out.println(p1.getName()+"\t"+p2.getName());
		System.out.println(p1.getScore()+"\t"+p2.getScore());
		System.out.println("游戏结束！再见了您嘞！");
	}


	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomPass() {
		return roomPass;
	}

	public void setRoomPass(String roomPass) {
		this.roomPass = roomPass;
	}
	
}
