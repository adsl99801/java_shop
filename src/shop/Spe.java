package shop;
import java.util.*;

public class Spe {
	public static int rowNum=4;
	public static int columNum=4;

	
	public static ArrayList <Integer> command=new ArrayList();
	
	public static String welcome="歡迎進入遊戲，請輸入數字以繼續\n";

	public static String bye="bye";
	public static String defaultp1name="p1";
	public static String defaultp2name="p2";
	public static String startTip="進入遊戲!\n";
	public static String startgameTip="遊戲開始了!\n";
	public static String setedSymbol="██";
	public static String shopSymbol= "◥◤";
	public static int defaultNumOfPlayers=2;
	public static int exitGame=9999;
	public static int startGame=1;
	public static String [] commandS={startGame+".開始",exitGame+".離開"};
	Spe(){
		command.add(startGame);
		command.add(exitGame);
	}
}
