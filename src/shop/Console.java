package shop;

import java.util.ArrayList;

public class Console {
	private ConsoleTool consoleTool = new ConsoleTool();
	private ArrayList<Symbol> symbolHistory = new ArrayList();
	private String printSymbolOrNum(int nownum, Symbol nowsymbol) {
		if (nowsymbol == null) {
			return consoleTool.add0IfLessTen(nownum);
		}
		if (nowsymbol.getCoordinate() == nownum) {
			return nowsymbol.getSymbol();
		}

		for(Symbol s:symbolHistory ){
			if(s.getCoordinate()==nownum){
				return nowsymbol.getSymbol();
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

	public void playerChoose(Symbol symbol) {
		if(consoleTool.isSymbolSeted(symbol,symbolHistory)){
			return;
		}
		drawBoard(symbol);
		symbolHistory.add(symbol);
		
	}
}
