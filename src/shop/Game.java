package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private Console console;
	private int input = 0;
	private Scanner scanner;
	Player nowp;
	private int round = 1;

	Game(Scanner scanner) {
		this.scanner = scanner;
	}

	private void prepare() {
		console = new Console();
		console.defaultSetAllPlayer();
		console.setAllEnemy();

		console.printRoundHedge();
		gameGuide();
		console.printRoundHedge();
		System.out.println("在閱讀完說明首先由" + Storage.allPlayer.get(0).getName()
				+ "開始猜!\n");
		System.out.println(Spe.startgameTip);
		console.drawBoard(null);
		System.out.println("請您以鍵盤輸入座標:\n");
	}

	private void gameGuide() {
		System.out.println("遊戲說明:\n請輸入座標從第一個為0 如果輸入0時 00就會變成" + Spe.setedSymbol
				+ "\n");
		Symbol exampleSymbol = new Symbol();
		exampleSymbol.setSymbol(Spe.setedSymbol);
		exampleSymbol.setCoordinate(0);
		console.drawBoard(exampleSymbol);
		exampleSymbol = null;
	}

	public void start() {
		prepare();
		while (input != Spe.exitGame) {
			if (round > Spe.cellNum) {
				System.out.println("回合到!\n");
				Player winer =whoIsWin();
				System.out.println("勝利者為:"+winer.getName()+"!\n");
				break;
			}
			console.printRoundHedge();
			System.out.println("第" + (round) + "回合" + "\n");
			nowp = console.getRoundPlayer();
			System.out.println("輪到" + nowp.getName() + "了\n");
			Symbol symbol = new Symbol();

			symbol.setWhoSet(nowp);
			try {
				System.out.println("請選擇一個數字繼續遊戲或輸入" + Spe.readMyState
						+ "查看個人資訊:\n");
				input = scanner.nextInt();

			
				if (console.checkInput(nowp,input)) {
					symbol.setSymbol(Spe.setedSymbol);// 被使用者選重的話 填入X
					symbol.setCoordinate(input);
					console.playerSetSymbol(symbol);
					round = (Storage.symbolHistory.size()) + 1;
					console.printRoundHedge();

				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("你沒有輸入符合的指令 \n");
				input = 0;
				scanner.next();
			} finally {

			}

		}
		end();
	}

	private void end() {
		
		System.out.println(Spe.bye);
	}
	private Player whoIsWin(){
		int max=0;
		Player winner = null;
		for(Player p:Storage.allPlayer){
			if(p.getScore()>max){
				max=p.getScore();
				winner=p;
			}
			
		}
		return winner;
		
	}





}
