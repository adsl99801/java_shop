package shop;

import java.util.Scanner;

public class Shop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print(Spe.welcome);
		int userInput = 0;
		while(userInput!=Spe.exitGame){
			userInput= input.nextInt();
			if(userInput==Spe.startGame){
				
				System.out.println(Spe.startTip);
				Game game= new Game(input);
				game.start();				
			}
			
		}
		input.close();
		


	}

}
