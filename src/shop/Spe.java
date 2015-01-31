package shop;
import java.util.*;

public class Spe {
	public static int rowNum=4;
	public static int columNum=4;
	public static int cellNum=rowNum*columNum;
	public static int enemyNum=3;
	public static ArrayList <Integer> command=new ArrayList();
	
	public static String welcome="歡迎進入遊戲，請輸入數字以繼續\n";

	public static String bye="bye";
	public static String defaultp1name="p1";
	public static String defaultp2name="p2";
	public static String startTip="進入遊戲!\n";
	public static String startgameTip="遊戲開始了!\n";
	public static String setedSymbol="██";
	public static String shopSymbol= "◥";
	public static String hedgeSymbol= "═";
	public static String setShopTip="擊中目標拉!";
	public static int defaultNumOfPlayers=2;
	
	public static int exitGame=999;
	public static int startGame=1;
	public static int setting=777;
	public static int readMyState=888;
	public static String [] menu={startGame+".開始",setting+".設定遊戲",exitGame+".離開"};
	Spe(){
		command.add(startGame);
		command.add(exitGame);
		command.add(setting);
		command.add(readMyState);
	}
}
