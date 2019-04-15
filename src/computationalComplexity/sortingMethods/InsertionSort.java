package computationalComplexity.sortingMethods;

public class InsertionSort {

	public static int insertionSort(int[] array) {

		int counter = 0;
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int k = i - 1;
			counter++;

			while (k >= 0 && array[k] > temp) {

				array[k + 1] = array[k];
				k--;
				counter++;
			}
			array[k + 1] = temp;
			counter++;
		}
		return counter;
	}
}
