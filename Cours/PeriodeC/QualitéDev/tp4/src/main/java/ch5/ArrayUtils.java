package ch5;

import java.util.Arrays;

class ArrayUtils {

    public static int indexOf(final int[] array, final int valueToFind, int startIndex) {
    	System.out.println(startIndex + " "+ valueToFind); 
    	System.out.println(Arrays.toString(array));
        if (array == null) {
            return -1;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return -1;
    }
}
