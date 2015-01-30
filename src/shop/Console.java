package shop;

public class Console {
	// public static int aCellLen=3;
	public boolean isValidInpInput(int input) {

		return true;
	}

	private String add0IfLessTen(int n) {
		if (n < 10) {
			return "0" + n;
		}
		return n + "";
	}

	private void drawOneRowLine() {
		for (int i = 0; i < Spe.rowNum; i++) {
			System.out.print("----");// aCellLen
		}
		System.out.println("");
	}

	private int drawOneColLine(int num,Symbol symbol) {

		for (int j = 0; j < Spe.columNum; j++) {
			
			if(symbol==null){
				//�N���٨S���w�y��
				System.out.print("|" + add0IfLessTen(num) + "|");
			}else{
				if(symbol.getCoordinate()==num){
					//���a��J���y�е���n�e����l��
					System.out.print("|" + symbol.getSymbol() + "|");
				}else{
					System.out.print("|" + add0IfLessTen(num) + "|");
				}
			
			}
			num++;
		}
		System.out.println("");
		return num;
	}

	private int drawOneLine(int num,Symbol symbol) {
		// �Φ��@��
		drawOneRowLine();
		int nextnum = drawOneColLine(num,symbol);
		drawOneRowLine();
		return nextnum;
	}

	public void drawBoard(Symbol symbol) {
		int next = 0;
		for (int i = 0; i < Spe.rowNum; i++) {
			next = drawOneLine(next,symbol);
		}

	}

	public void playerChoose(Symbol symbol) {
		
		drawBoard(symbol);
	}
}
