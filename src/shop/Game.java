package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private Player p1;
	private Player p2;
	private Console console;
	private int input= 0;
	private Scanner scanner;
	ArrayList<Symbol> symbolHistory = new ArrayList();//�����w�g�U�L������
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
		
		System.out.println("�b�\Ū������������" + p1.getName() + "�}�l�q!\n");
		System.out.println(Spe.startgameTip);
		console.drawBoard(null);
		System.out.println("�бz�H��L��J�y��:\n");
	}
	private void gameGuide() {
		System.out.println("�C������:\n�п�J�y�бq�Ĥ@�Ӭ�0 �p�G��J0�� 00�N�|�ܦ�"+
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
			input= scanner.nextInt();
			System.out.println("�A��J" + input+ "\n");
			Symbol symbol= new Symbol();
			symbol.setSymbol(Spe.setedSymbol);//�Q�ϥΪ̿ﭫ���� ��JX
			symbol.setCoordinate(input);
			console.drawBoard(symbol);
			symbolHistory.add(symbol);
			
		}
		end();
	}

	private void end() {
		System.out.println(Spe.bye);
	}

}
