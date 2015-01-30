package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private Player p1;
	private Player p2;
	private Console console;
	private int input= 0;
	private Scanner scanner;
	

	private int round=0;
	Game(Scanner scanner){
		this.scanner=scanner;
	}
	
	private void prepare() {

		p1 = new Player();
		p1.setName(Spe.defaultp1name);
		p2 = new Player();
		p2.setName(Spe.defaultp2name);
		console = new Console();
		gameGuide();
		
		System.out.println("在閱讀完說明首先由" + p1.getName() + "開始猜!\n");
		System.out.println(Spe.startgameTip);
		console.drawBoard(null);
		System.out.println("請您以鍵盤輸入座標:\n");
	}
	private void gameGuide() {
		System.out.println("遊戲說明:\n請輸入座標從第一個為0 如果輸入0時 00就會變成"+
		Spe.setedSymbol+"\n");
		Symbol exampleSymbol= new Symbol();
		exampleSymbol.setSymbol(Spe.setedSymbol);
		exampleSymbol.setCoordinate(0);
		console.drawBoard(exampleSymbol);
		exampleSymbol=null;
	}
	public void start() {
		prepare();
		while(input!=Spe.exitGame){
			System.out.println("第"+(round+1)+"回合"+"\n");
			input= scanner.nextInt();
			System.out.println("你輸入" + input+ "\n");
			Symbol symbol= new Symbol();
			symbol.setSymbol(Spe.setedSymbol);//被使用者選重的話 填入X
			symbol.setCoordinate(input);
			console.playerChoose(symbol);
			round++;
			
			
		}
		end();
	}

	private void end() {
		System.out.println(Spe.bye);
	}

}
