
public class RoulettePlayer extends CasinoPlayer{

	public RoulettePlayer() {
	
	}
	
	public RoulettePlayer(String newName, int newMoney) {
		money = newMoney;
		name = newName;
	}
	
	public int numRoulette() {
		System.out.print("Pick a number 1-36: ");
		return enterInt(1,36);
	}
	
	public int rouletteNum() {
		return (int)(Math.random() * 36) + 1;
	}
	
	public void simpleRoulette() {
		if (!knowHowPlay()) {
			System.out.println("Win by picking numbers in the same third as the roulette wheel.");
			System.out.println("For example, if you picked 3, you would win if the wheel was any number 1-12.");
			enter();
		}
			
		
		makeBet();
		int num = numRoulette();
		int rouletteNum = rouletteNum();
		System.out.println("You picked " + num + " and the computer picked " + rouletteNum + ".");
		if (num<=12 && rouletteNum<=12) 
			win(bet);
		else if (num<=24 && rouletteNum<=24 && rouletteNum>12 && num>12) 
			win(bet);
		else if (num<=36 && rouletteNum<=36 && rouletteNum>24 && num>24) 
			win(bet);
		else 
			lose(bet);
		
		if (debt>0 && money >0) {
			payDebt();
		}
	}
	
	//1-12, 13-24, 25-36
	//red black
	
	
	
}
