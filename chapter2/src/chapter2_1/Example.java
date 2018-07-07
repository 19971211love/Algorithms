package chapter2_1;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//When studying sorting algorithms, we count compares and exchanges
public class Example {
	
	public static void sort(Comparable[] a) {
//	See Algorithm 2.1, 2.2, 2.3, 2.4, 2.5 or 2.7	
	}
	
//	returns an integer that is negative, zero, or positive when v < w, v = w, or v > w
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w) < 0;
		
	}
	
	private static void exchange(Comparable[] a,int i,int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static void show(Comparable[] a) {
//		Print the array, on a single line
		for(int i = 0; i < a.length; i ++) {
			StdOut.print(a[i] + " ");
		}
	}
	
	public static boolean isSorted(Comparable[] a) {
//		Test whether the array entries are in order
		for(int i = 1; i < a.length;i ++) {
			if(less(a[i], a[i-1])) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
	

}
