package computationalComplexity;

import java.io.File;
import java.io.IOException;

import computationalComplexity.generateArrays.GenArrayAverageCase;
import computationalComplexity.generateArrays.GenArrayBestCase;
import computationalComplexity.generateArrays.GenArrayWorstCase;
import computationalComplexity.sortingMethods.BubbleSort;
import computationalComplexity.sortingMethods.InsertionSort;
import computationalComplexity.sortingMethods.SelectionSort;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Main {

	public static void main(String[] args) throws IOException, WriteException {

		int arrayMininmumSize = 100;
		int arrayMaximumSize = 10_000;
		int increment = 100;
		int nrElemente = ((arrayMaximumSize - arrayMininmumSize) / increment) + 1;
		System.out.println("Nr de elemente :" + nrElemente);

		int[] numberOfElements = new int[nrElemente];

		int[] numberOfOperationsBubbleSortWorstCase = new int[nrElemente];
		int[] numberOfOperationsBubbleSortBestCase = new int[nrElemente];
		int[] numberOfOperationsBubbleSortAverageCase = new int[nrElemente];

		int[] numberOfOperationsSelectionSortWorstCase = new int[nrElemente];
		int[] numberOfOperationsSelectionSortBestCase = new int[nrElemente];
		int[] numberOfOperationsSelectionSortAverageCase = new int[nrElemente];

		int[] numberOfOperationsInsertionSortWorstCase = new int[nrElemente];
		int[] numberOfOperationsInsertionSortBestCase = new int[nrElemente];
		int[] numberOfOperationsInsertionSortAverageCase = new int[nrElemente];

		for (int i = 1; i <= nrElemente; i++) {
			int elemente = GenArrayBestCase.generateArray(i).length * increment;

			int[] arrayWorstCase = GenArrayWorstCase.generateArrayWorstCase(elemente);
			int[] arrayBestCase = GenArrayBestCase.generateArray(elemente);

			int operationsBubbleSortWorstCase = BubbleSort.bubbleSort(arrayWorstCase);
			int operationsBubbleSortBestCase = BubbleSort.bubbleSort(arrayBestCase);

			arrayWorstCase = GenArrayWorstCase.generateArrayWorstCase(elemente);
			arrayBestCase = GenArrayBestCase.generateArray(elemente);

			int operationsSelectionSortWorstCase = SelectionSort.selectionSort(arrayWorstCase);
			int operationsSelectionSortBestCase = SelectionSort.selectionSort(arrayBestCase);

			arrayWorstCase = GenArrayWorstCase.generateArrayWorstCase(elemente);
			arrayBestCase = GenArrayBestCase.generateArray(elemente);

			int operationsInsertionSortWorstCase = InsertionSort.insertionSort(arrayWorstCase);
			int operationsInsertionSortBestCase = InsertionSort.insertionSort(arrayBestCase);

//___________________________AVERAGE_CASE_________________________________
//__________________________BUBBLE_sORT__________________________________
			int operationsBubbleSortAverageCase = 0;
			int total = 0;
			int nrRepetari = 10;
			for (int j = 1; j <= nrRepetari; j++) {
				int[] arrayAverageCase = GenArrayAverageCase.generateArray(elemente);
				operationsBubbleSortAverageCase = BubbleSort.bubbleSort(arrayAverageCase);
				total += operationsBubbleSortAverageCase;
			}
			operationsBubbleSortAverageCase = total / nrRepetari;

//____________________END_BUBBLE_SORT___&__START_SELECTION_SORT_________________________
			int operationsSelectionSortAverageCase = 0;
			int total2 = 0;

			for (int j = 1; j <= nrRepetari; j++) {
				int[] arrayAverageCase = GenArrayAverageCase.generateArray(elemente);
				operationsSelectionSortAverageCase = SelectionSort.selectionSort(arrayAverageCase);
				total2 += operationsSelectionSortAverageCase;
			}
			operationsSelectionSortAverageCase = total2 / nrRepetari;

//____________________END_SELECTION_SORT___&__START_INSERTION_SORT_________________________
			int operationsInsertionSortAverageCase = 0;
			int total3 = 0;

			for (int j = 1; j <= nrRepetari; j++) {
				int[] arrayAverageCase = GenArrayAverageCase.generateArray(elemente);
				operationsInsertionSortAverageCase = InsertionSort.insertionSort(arrayAverageCase);
				total3 += operationsInsertionSortAverageCase;
			}
			operationsInsertionSortAverageCase = total3 / nrRepetari;

//____________________END_AVERAGE_CASE________________________________________________

//___________________Numbers_Of_Operations_________________________________

			numberOfElements[i - 1] = elemente;
//___________________Bubble_sort___________________________________________

			numberOfOperationsBubbleSortWorstCase[i - 1] = operationsBubbleSortWorstCase;
			numberOfOperationsBubbleSortBestCase[i - 1] = operationsBubbleSortBestCase;
			numberOfOperationsBubbleSortAverageCase[i - 1] = operationsBubbleSortAverageCase;

//___________________Selection_sort___________________________________________

			numberOfOperationsSelectionSortWorstCase[i - 1] = operationsSelectionSortWorstCase;
			numberOfOperationsSelectionSortBestCase[i - 1] = operationsSelectionSortBestCase;
			numberOfOperationsSelectionSortAverageCase[i - 1] = operationsSelectionSortAverageCase;

//___________________Insertion_sort___________________________________________

			numberOfOperationsInsertionSortWorstCase[i - 1] = operationsInsertionSortWorstCase;
			numberOfOperationsInsertionSortBestCase[i - 1] = operationsInsertionSortBestCase;
			numberOfOperationsInsertionSortAverageCase[i - 1] = operationsInsertionSortAverageCase;

		}

//______________________________EXPORTING_TO_EXCEL_______________________________________________
		try {
			String filename = "C:\\Users\\Adi\\eclipse-workspace\\R&D\\SortingMethods.xls";
			WritableWorkbook workbook = Workbook.createWorkbook(new File(filename));
			WritableSheet sheet = workbook.createSheet("SortingMethods", 0);
			int columnNumber = 0;

//________________________MERGING_HORIONTAL___________________
			sheet.mergeCells(0, 0, 0, 2);
//_________________________MERGING_VRTICAL___________________			
			sheet.mergeCells(1, 0, 9, 0);
			sheet.mergeCells(1, 1, 3, 1);
			sheet.mergeCells(4, 1, 6, 1);
			sheet.mergeCells(7, 1, 9, 1);

//sheet.mergeCells(1, 0, 9, 0); ( p(x0,x1); p(y0,y1);
			// Adding labels

//			Label label = new Label(X, Y, "NAME");
//			sheet.addCell(label);

			Label label = new Label(0, 0, "Number of Elements");
			sheet.addCell(label);

			Label label2 = new Label(1, 0, "Operations");
			sheet.addCell(label2);

			Label label3 = new Label(1, 1, "Bubble sort");
			sheet.addCell(label3);

			Label label4 = new Label(1, 2, "Best");
			sheet.addCell(label4);

			Label label5 = new Label(2, 2, "Worst");
			sheet.addCell(label5);

			Label label6 = new Label(3, 2, "Average");
			sheet.addCell(label6);

			Label label7 = new Label(4, 1, "Selection sort");
			sheet.addCell(label7);

			Label label8 = new Label(4, 2, "Best");
			sheet.addCell(label8);

			Label label9 = new Label(5, 2, "Worst");
			sheet.addCell(label9);

			Label label10 = new Label(6, 2, "Average");
			sheet.addCell(label10);

			Label label11 = new Label(7, 1, "Insertion Sort");
			sheet.addCell(label11);

			Label label12 = new Label(7, 2, "Best");
			sheet.addCell(label12);

			Label label13 = new Label(8, 2, "Worst");
			sheet.addCell(label13);

			Label label14 = new Label(9, 2, "Average");
			sheet.addCell(label14);

//_________________________________FILLING_COLUMNS________________________________________________
//_________________________________NUMBER_OF_ELMENTS______________________________________________
			for (int i = 0; i < numberOfElements.length; i++) {
				Number number = new Number(columnNumber, i + 3, numberOfElements[i]);
				sheet.addCell(number);
			}
//_________________________________BUBBLE_SORT____________________________________________________
			columnNumber++;
			for (int i = 0; i < numberOfOperationsBubbleSortBestCase.length; i++) {
				Number number = new Number(columnNumber, i + 3, numberOfOperationsBubbleSortBestCase[i]);
				sheet.addCell(number);
			}
			columnNumber++;
			for (int i = 0; i < numberOfOperationsBubbleSortWorstCase.length; i++) {
				Number number = new Number(columnNumber, i + 3, numberOfOperationsBubbleSortWorstCase[i]);
				sheet.addCell(number);
			}
			columnNumber++;
			for (int i = 0; i < numberOfOperationsBubbleSortAverageCase.length; i++) {
				Number number = new Number(columnNumber, i + 3, numberOfOperationsBubbleSortAverageCase[i]);
				sheet.addCell(number);
			}
//________________________________SELECTION_SORT__________________________________________________
			columnNumber++;
			for (int i = 0; i < numberOfOperationsSelectionSortBestCase.length; i++) {
				Number number = new Number(columnNumber, i + 3, numberOfOperationsSelectionSortBestCase[i]);
				sheet.addCell(number);
			}
			columnNumber++;
			for (int i = 0; i < numberOfOperationsSelectionSortWorstCase.length; i++) {
				Number number = new Number(columnNumber, i + 3, numberOfOperationsSelectionSortWorstCase[i]);
				sheet.addCell(number);
			}
			columnNumber++;
			for (int i = 0; i < numberOfOperationsSelectionSortAverageCase.length; i++) {
				Number number = new Number(columnNumber, i + 3, numberOfOperationsSelectionSortAverageCase[i]);
				sheet.addCell(number);
			}
//________________________________INSERTION_SORT__________________________________________________
			columnNumber++;
			for (int i = 0; i < numberOfOperationsInsertionSortBestCase.length; i++) {
				Number number = new Number(columnNumber, i + 3, numberOfOperationsInsertionSortBestCase[i]);
				sheet.addCell(number);
			}
			columnNumber++;
			for (int i = 0; i < numberOfOperationsInsertionSortWorstCase.length; i++) {
				Number number = new Number(columnNumber, i + 3, numberOfOperationsInsertionSortWorstCase[i]);
				sheet.addCell(number);
			}
			columnNumber++;
			for (int i = 0; i < numberOfOperationsInsertionSortAverageCase.length; i++) {
				Number number = new Number(columnNumber, i + 3, numberOfOperationsInsertionSortAverageCase[i]);
				sheet.addCell(number);
			}
			workbook.write();
			workbook.close();
			System.out.println("Done. Check the path to see the Excel File");
		} catch (WriteException e) {
		}
//______________________________________EXPORT_DONE________________________________________________
	}
}
