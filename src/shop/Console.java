package shop;

import java.util.ArrayList;

public class Console {
	private ConsoleTool consoleTool = new ConsoleTool();

	public void defaultSetAllPlayer(){
		Player p1 = new Player();
		 p1.setName(Spe.defaultp1name);
		 Player p2 = new Player();
		p2.setName(Spe.defaultp2name);
		Storage.allPlayer.add(p1);
		Storage.allPlayer.add(p2);
	}
	
	
	public void setAllEnemy(){
		int eCor=0;
		ArrayList<Integer> randoms = new ArrayList();
		for(int i=0;i<Spe.enemyNum;i++){
			eCor=(int)(Math.random()*Spe.cellNum);
			if(isRandDuplicate(eCor,randoms)){
				return;
			}
			randoms.add(eCor);
			Enemy enemy= new Enemy(eCor);
			Storage.allEnemy.add(enemy);
		}

	}
	private Boolean isRandDuplicate(int rnum,ArrayList<Integer> randoms){
		for(int j:randoms){
			if(rnum ==j){
				return true;
			}
		}
		return false;
		
	}
	private String printSymbolOrNum(int nownum, Symbol nowsymbol) {
		if (nowsymbol == null) {
			return consoleTool.add0IfLessTen(nownum);
		}
		if (nowsymbol.getCoordinate() == nownum) {
			return nowsymbol.getSymbol();
		}

		for(Symbol s:Storage.symbolHistory ){
			if(s.getCoordinate()==nownum){
				return s.getSymbol();
			}
		}
		return consoleTool.add0IfLessTen(nownum);

	}
	private int drawOneColLine(int num, Symbol symbol) {

		for (int j = 0; j < Spe.columNum; j++) {
			System.out.print("|" + printSymbolOrNum(num, symbol) + "|");
			num++;
		}
		System.out.println("");
		return num;
	}

	private int drawOneLine(int num, Symbol symbol) {

		consoleTool.drawOneRowLine();
		int nextnum = drawOneColLine(num, symbol);
		consoleTool.drawOneRowLine();
		return nextnum;
	}

	public void drawBoard(Symbol symbol) {
		int next = 0;
		for (int i = 0; i < Spe.rowNum; i++) {
			next = drawOneLine(next, symbol);
		}

	}


	public void playerSetSymbol(Symbol symbol) {
		if(consoleTool.isSymbolSeted(symbol,Storage.symbolHistory)){
			return ;
		}
		
		if(isEnemy(symbol)){
			//如果玩家選到船 就更換下子的符號
			addScore(symbol.getWhoSet());
			symbol.setSymbol(Spe.shopSymbol);
		}
		drawBoard(symbol);
		Storage.symbolHistory.add(symbol);
		return ;
		
	}
	private void addScore(Player player){
		for(Player p:Storage.allPlayer){
			if(player==p){
				p.addScoreOne();
				System.out.println("p.addScoreOne() getScore:"+p.getScore());
			}
			
		}
	}
	private Boolean isEnemy(Symbol symbol){
		
		for(Enemy e:Storage.allEnemy){
			if(symbol.getCoordinate()==e.getCoordinate()){
				Player p = symbol.getWhoSet();
				System.out.println(p.getName()+""+Spe.setShopTip);
				return true;
			}
		}
		
		return false;
		
	}
	public Player getRoundPlayer(){
		int playerNum = Storage.allPlayer.size();
		int size = Storage.symbolHistory.size();
		
		if(size==0){
			return Storage.allPlayer.get(0);
		}
		if(size==1){
			return Storage.allPlayer.get(1);
		}
		if(size==2){
			return Storage.allPlayer.get(0);
		}

			//System.out.println("size:"+size+"playerNum:"+playerNum+"size%playerNum:"+size%playerNum);
			return Storage.allPlayer.get((size%playerNum));

		
	}
	public void printRoundHedge(){
		for(int i =0;i<Spe.rowNum;i++){
			System.out.print(Spe.hedgeSymbol+Spe.hedgeSymbol+Spe.hedgeSymbol+Spe.hedgeSymbol);
			//════//
		}
		System.out.println("\n");
	}
	
	public Boolean checkInput(Player nowp,int input) {
		System.out.println("你輸入:" + input + "\n");

		if (input == Spe.readMyState) {
			printRoundHedge();
			System.out.println("查看個人資訊: \n");
			System.out.println("名稱:" + nowp.getName() + " \n");
			System.out.println("分數:" + nowp.getScore() + " \n");
			System.out.println("請選擇一個數字繼續遊戲\n");
			printRoundHedge();
			return false;
			
		}
		
		if (input >= Spe.cellNum) {
			System.out.println("你輸入的數字太大了! 應該要小於" + Spe.cellNum + "\n");
			return false;
		}
		if (input < 0) {
			System.out.println("你輸入的數字小於零!\n");
			return false;
		}

		return true;
	}

}
