package shop;

import java.util.ArrayList;

public class ConsoleTool {


	public boolean isValidInpInput(int input) {

		return true;
	}

	public String add0IfLessTen(int n) {
		if (n < 10) {
			return "0" + n;
		}
		return n + "";
	}

	public void drawOneRowLine() {
		for (int i = 0; i < Spe.rowNum; i++) {
			System.out.print("----");// aCellLen
		}
		System.out.println("");
	}
	public Boolean isSymbolSeted(Symbol symbol, ArrayList<Symbol>  symbolHistory) {
		// 是否下過子
		for(Symbol s:symbolHistory ){
			if(s.getCoordinate()==symbol.getCoordinate()){
				System.out.print("這個位置被下過了\n");
				return true;
			}
		}
		
		return false;

	}
}
