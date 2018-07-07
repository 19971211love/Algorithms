package chapter2_1;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Comparator;

public class Selection {
//	This class should not be instantiated(สตภýปฏ)
	private Selection() {
		
	}
	

	public static void sort(Comparable[] a) {
		int N  = a.length;
		for(int i = 0; i < N; i ++) {
			int min = i;
			for(int j = i + 1;j < N;j ++) 
				if(less(a[j], a[min])) min = j;
			exchange(a, i, min);
			assert isSorted(a,0,i);
		}
		assert isSorted(a);
	}
	
	public static void sort(Object[] a,Comparator comparator) {
		int N  = a.length;
		for(int i = 0; i < N; i ++) {
			int min = i;
			for(int j = i + 1;j < N;j ++) 
				if(less(comparator,a[j], a[min])) min = j;
			exchange(a, i, min);
			assert isSorted(a,comparator,0,i);
		}
		assert isSorted(a,comparator);
	}
	
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w) < 0;
		
	}
	
	private static boolean less(Comparator comparator,Object v,Object w) {
		return comparator.compare(v,w) < 0;
		
	}
	
	private static void exchange(Object[] a,int i,int j) {
		Object t = a[i];
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
		return isSorted(a,0,a.length-1);
	}
	
	public static boolean isSorted(Comparable[] a,int lo,int hi) {
		for(int i = lo + 1; i <= hi;i ++) {
			if(less(a[i], a[i-1])) return false;
		}
		return true;
	}
	
	public static boolean isSorted(Object[] a,Comparator comparator) {
		return isSorted(a,comparator,0,a.length-1);
	}

	public static boolean isSorted(Object[] a,Comparator comparator,int lo,int hi) {
		for(int i = lo + 1; i <= hi;i ++) {
			if(less(comparator,a[i], a[i-1])) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] a = new In("src/chapter2_1/tiny.txt").readAllStrings();
		Selection.sort(a);
		show(a);
	}

}
