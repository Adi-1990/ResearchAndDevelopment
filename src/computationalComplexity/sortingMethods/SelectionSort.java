package computationalComplexity.sortingMethods;

public class SelectionSort {

	public static int selectionSort(int[] array) {

		int counter = 0;

		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				counter++;
				if (array[j] < array[minIndex]) {
					minIndex = j;
					counter++;
				}
				
			}
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
			counter++;
		}
		return counter;
	}
}