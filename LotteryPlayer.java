
public class LotteryPlayer extends CasinoPlayer {

	//win lottery by matching any number with the corresponding lottery number (+=bet each time you match)
	
	int [] nums649 = new int [6];
	
	public LotteryPlayer() {
	}
	
	public LotteryPlayer(String newName, int newMoney) {
		money = newMoney;
		name = newName;
	}
	
	public int [] play649() {
		System.out.println("Pick 6 lottery numbers.");
		for (int i = 0; i<6; i++) {
			System.out.print("Enter num " + (i+1) + ": ");
			nums649[i] = enterInt(1,6);
		}
		return nums649;
	}
		
	public int[] random649() {
		int [] random649 = new int [6];
		for (int i = 0; i<6; i++) {
			random649[i] = (int)(Math.random() * (6)) + 1;
		}
		
		return random649;	
	}
	
	public void lose(int loss) {
		super.lose(loss);
		System.out.println("Better luck next time. ");
	}
		
	
	public void playLottery() {
		
		if (!knowHowPlay()) {
			System.out.println("Select 6 numbers from 1-6.");
			System.out.println("Win by matching any number with the corresponding lottery number (+=bet each time you match)");
			enter();
		}
		
		makeBet();
		int [] lotteryNums = play649();
		int [] random = random649();
		int winnings = 0;
		System.out.println("Your numbers are:");
		for (int i = 0; i<6; i++) {
			System.out.print(lotteryNums[i] + " ");
		}
		System.out.println("\n");
		System.out.println("The lottery numbers are:");
		for (int i = 0; i<6; i++) {
			System.out.print(random[i] + " ");
		}
		System.out.println();
		for (int i = 0; i<6; i++) {
			if (lotteryNums[i] == random[i]) {
				winnings += bet;
			}
		}
		
		if (winnings > 0) 
			win(winnings);
		else 
			lose(bet);
		if (debt>0 && money >0) {
			payDebt();
		}
	}
	
		
	
}
