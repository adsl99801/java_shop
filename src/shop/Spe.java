package shop;
import java.util.*;

public class Spe {
	public static int rowNum=4;
	public static int columNum=4;

	
	public static ArrayList <Integer> command=new ArrayList();
	
	public static String welcome="�w��i�J�C���A�п�J�Ʀr�H�~��\n";

	public static String bye="bye";
	public static String defaultp1name="p1";
	public static String defaultp2name="p2";
	public static String startTip="�i�J�C��!\n";
	public static String startgameTip="�C���}�l�F!\n";
	public static String setedSymbol="�i�i";
	public static String shopSymbol= "����";
	public static int defaultNumOfPlayers=2;
	public static int exitGame=9999;
	public static int startGame=1;
	public static String [] commandS={startGame+".�}�l",exitGame+".���}"};
	Spe(){
		command.add(startGame);
		command.add(exitGame);
	}
}
