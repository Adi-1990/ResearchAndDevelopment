package computationalComplexity.sortingMethods;

public class BubbleSort {

	public static int bubbleSort(int[] array) {

		int op = 0;
		int suma = 0;
		int compare = 0;
		boolean swapped = false;
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length - i - 1; j++) {
				compare++;
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					op++;
					swapped = true;
				}
			}
			if (swapped == false) {
				break;
			}
		}
		suma = op + compare;
		return suma;
	}
}