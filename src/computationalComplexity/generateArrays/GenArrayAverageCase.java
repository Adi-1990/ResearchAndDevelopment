package computationalComplexity.generateArrays;

import java.util.Random;

public class GenArrayAverageCase {

	public static int[] generateArray(int size) {

		Random random = new Random();
		int[] arrayAverageCase = new int[size];
		for (int i = 0; i < size; i++) {
			arrayAverageCase[i] = random.nextInt(100 + 1);
		}
		return arrayAverageCase;
	}
}