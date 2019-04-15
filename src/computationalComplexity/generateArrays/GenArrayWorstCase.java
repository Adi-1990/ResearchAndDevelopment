package computationalComplexity.generateArrays;

import java.util.Arrays;
import java.util.Random;

public class GenArrayWorstCase {

	public static int[] generateArrayWorstCase(int size) {

		Random random = new Random();
		int temp;
		int[] arrayWorstCase = new int[size];
		for (int i = 0; i < size; i++) {
			arrayWorstCase[i] = random.nextInt(100 + 1);
		}
		Arrays.sort(arrayWorstCase);
		// System.out.println(Arrays.toString(arrayWorstCase));

		for (int i = 0; i < arrayWorstCase.length / 2; i++) {
			temp = arrayWorstCase[i];
			arrayWorstCase[i] = arrayWorstCase[arrayWorstCase.length - i - 1];
			arrayWorstCase[arrayWorstCase.length - i - 1] = temp;
		}
		// System.out.println(Arrays.toString(arrayWorstCase));
		return arrayWorstCase;
	}
}