package caiquan;

import java.util.Scanner;

/**
 * ��Ϸ����
 * @author ľ��һ��
 *
 */
public class GameRoom {
	private HumenPlayer p1 = null;
	private ComputerPlayer p2 = null;
	private int roomId;
	private String roomName;
	private String roomPass;// ��������
	
	public GameRoom(String roomName,String roomPass)
	{
		if(!("��һ�����Ϸ".equals(roomName) && "123456".equals(roomPass)))
		{
			System.out.println("�������������Ϸǿ���Ƴ���");
			return;
		}
		this.setRoomName(roomName);
		initGame();
		startGame();
		endGame();
		
	}
	
	public void initGame()//������Ϸ
	{
		//1��ʵ������Ϸ��Ҷ���
		p1 =new HumenPlayer();
		p2 =new ComputerPlayer();
		//2����ʼ����Ϸ��������
		for (int i = 0; i <30; i++) {
			System.out.print("*");
			try {
				Thread.sleep(50);//����50ms
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("��Ϸ���سɹ���");
		
	}
	
	public void startGame()//��ʼ��Ϸ
	{
		showMenu();
		choiceRole();
		gaming();
	}
	
	private void gaming()
	{
		while(true)
		{
			//1��˫����ȭ
			System.out.print(p1.getName()+"���ȭ��");
			p1.setFist(new Scanner(System.in).nextInt());//����p1��ȭ
			int f1=p1.getFist();//��¼p1��ȭ
			/**
			 * �����ȭ����Ҳ���Ըĳ����仰
			 * scanner input=new scanner(system.in);
			 * p1.setfist(input.nextint());
			 */
			int f2=p2.getFist();//���ò���¼p2��ȭ
			
			//2���ж���Ӯ
			int result=judge(f1, f2);
			if(result == -1)
			{
				System.out.println("��ϰ��ƽ��:"+p1.getName()+"ʤ��");
				p1.sendMessage(HumenPlayer.MessageTypeWin);
				p2.sendMessage(ComputerPlayer.MessageTypeLose);
			}
			else if(result == 0)
				System.out.println("��ϰ��ƽ��:ƽ���ˣ�");
			else
			{
				System.out.println("��ϰ��ƽ��:"+p2.getName()+"ʤ��");
				p1.sendMessage(HumenPlayer.MessageTypeLose);
				p2.sendMessage(ComputerPlayer.MessageTypeWin);
			}
			System.out.print("�Ƿ������Ϸ?(y/n)");
			String answer=new Scanner(System.in).next();
			if(!"y".equalsIgnoreCase(answer))
				break;
		}
		}
			
			//3����ӡ���
			public void showMenu()//��ʾ�˵�
			{
				System.out.println("��ӭ����<<"+roomName+">>��Ϸ����");
				System.out.println("��ȭ����1-���� 2-�� 3-ʯͷ");
			}
				
			public void choiceRole()//ѡ������
			{
				System.out.println("�Է���ɫ��1-��ª�ķ��Ľ܌�ë 2-��־�� 3-���� 4-����");
				System.out.print("��ѡ��");
				Scanner input = new Scanner(System.in);
				int choice = input.nextInt();
				String[] nameArray ={"��ª�ķ��Ľ܌�ë","��־��","����","����"};
				 p2.setName(nameArray[choice-1]);
				 p1.setName("˧������һ��");
				 System.out.println(p1.getName()+"VS"+p2.getName());
			}
				
			public int judge(int f1,int f2)//�ж���Ӯ
			{
				if(f1==f2)
					return 0;//ƽ��
				else if((f1==1 && f2==3) || (f1==2 && f2==1) || (f1==3 && f2==2))
				{
					//ʤ�������һ������һ����Ҷ�������һ
					p1.setScore(p1.getScore()+1);
					p2.setScore(p2.getScore()-1);
					return -1;//���һʤ��
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
		System.out.println("��Ϸ�������ټ������ϣ�");
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
