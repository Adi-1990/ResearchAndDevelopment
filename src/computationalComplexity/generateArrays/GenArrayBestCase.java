package computationalComplexity.generateArrays;

import java.util.Arrays;
import java.util.Random;

public class GenArrayBestCase {

	public static int[] generateArray(int size) {

		Random random = new Random();
		int[] arrayBestCase = new int[size];
		for (int i = 0; i < size; i++) {
			arrayBestCase[i] = random.nextInt(100 + 1);
		}
		Arrays.sort(arrayBestCase);
		return arrayBestCase;
	}
}