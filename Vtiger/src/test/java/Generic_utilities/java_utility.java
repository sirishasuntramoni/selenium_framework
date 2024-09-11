package Generic_utilities;

import java.util.Random;

public class java_utility {
	/**
	 * this method is used to avoid duplicates
	 * @return
	 * @author Sirisha
	 */
	public int getRandomNum()
	{
		Random ran=new Random();
		int ranNum=ran.nextInt(1000);
		return ranNum;
		
	}

}
