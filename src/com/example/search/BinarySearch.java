package com.example.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BinarySearch {

	public static int binarySearch(int[] array, int elementToFind, int low, int high) {
		
		if(high < low) {
			return -1;
		}
		
		int mid = (low + high) /2;
		
		if(elementToFind == array[mid]) {
			return mid;
		} else if(elementToFind < array[mid]) {
			return binarySearch(array, elementToFind, low, mid-1);
		} else {
			return binarySearch(array, elementToFind, mid+1, high);
		}
	}	
	
	public static int[] generateSorted(final int length, final int minVal, final int maxVal) {
	    List<Integer> data = new ArrayList<>(length);

	    for (int i = 0; i < length; i++) {
	        int rndNum = getRandomVal(minVal, maxVal);
	        int insertionPoint = Collections.binarySearch(data, rndNum);
	        data.add(insertionPoint > -1 ? insertionPoint : - insertionPoint - 1, rndNum);
	    }

	    return data.stream().mapToInt(i -> i).toArray();
	}
	
	private static int getRandomVal(int min, int max)
    {
        int n = max - min + 1;
        int i = rand.nextInt(n);
        return min + i;
    }
	
    final static private Random rand = new Random();
	
	public static void main(String args[]) {
		
		
		int[] inputArray = generateSorted(10000, 0, 10000);
		System.out.println("Input Array: " + Arrays.toString(inputArray));
		int elementToSearch = 29; //getRandomVal(100, 5000);
		System.out.println("Element to search: " + elementToSearch);
		
		long startTime = System.currentTimeMillis();	
		
		int location = binarySearch(inputArray, elementToSearch, 0, inputArray.length);
		
		long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Element found at " + location);
        System.out.println("Time taken: " + elapsedTime);
		
	}
}
