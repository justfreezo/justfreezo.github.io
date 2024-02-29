package tp4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TP4 {

	public static void main (String[] args) {
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Math.abs(Integer.MIN_VALUE));
	}
	
	public static <T> List<T> reverse(List<T> original) {
		List<T> clone = new ArrayList<>(original);
		Collections.reverse(clone);
		return clone;
	}
}