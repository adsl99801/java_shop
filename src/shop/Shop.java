package shop;

import java.util.Scanner;

public class Shop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print(Spe.welcome);
		printMenu();
		int userInput = 0;
		while(userInput!=Spe.exitGame){
			
			
			try{
				userInput= input.nextInt();
				if(userInput==Spe.startGame){
					
					System.out.println(Spe.startTip);
					Game game= new Game(input);
					game.start();				
				}
				System.out.println("你沒有輸入符合選單的指令 如 1或777或888或999\n");
				printMenu();
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("你沒有輸入符合選單的指令 如 1或777或888或999\n");
				userInput=0;
				input.next();
			}finally{
				
			}
			
			
		}
		input.close();
		


	}
	
	private static void printMenu(){
		for(int i =0;i<Spe.menu.length;i++){
			System.out.print(Spe.menu[i]);
			System.out.println("\n");
		}
		System.out.println("\n");
	}
	private static Boolean isValidInput(int input){
		return true;
		
	}


}
