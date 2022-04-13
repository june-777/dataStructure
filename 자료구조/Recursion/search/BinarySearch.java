package search;

import java.util.Arrays;

public class BinarySearch {
	
	/**helper method
	 * 사용자의 파라미터 간소화 편의를 위함*/
	public static boolean bSearch(int[]data, int target) {
		int low = 0;
		int high = data.length-1;
		return binarySearch(data, target, low, high);
	}
	
	/**binarySearch (Recursive version*/
	private static boolean binarySearch(int[] data, int target, int low, int high) {

		/* base case: recursive case가 진행됨에 따라 막다른 골목이 어디일까 생각 * */
		if (low>high) {return false;}
		else {
			int mid = (low+high) / 2;
			if (target == data[mid]) {return true;}
		/* recursive case*/
			else if (target > data[mid]) {
				return binarySearch(data, target, mid+1, high);
			}
			else {
				return binarySearch(data, target, low, mid-1);
			}
		}
	}
			
	public static void main(String[] args) {
		int[] iarr1 = {1, 3, 5 ,7, 9};
		int[] iarr2 = {2, 4, 6, 8, 10, 12};
		
		/*target array 준비
		 * System.arraycopy(source arr, source pos, dest arr, dest pos, length) * */
		int[] target = new int[iarr1.length + iarr2.length];
		System.arraycopy(iarr1, 0, target, 0, iarr1.length);
		System.arraycopy(iarr2, 0, target, iarr1.length, iarr2.length);
		System.out.println("타겟 : " + Arrays.toString(target));
		

		for (int t: target) {
			if (bSearch(iarr1, t) == true) {System.out.println(t + " 가 iarr1에 있습니다.");}
			else {System.out.println(t + " iarr1에 없습니다.");}
			
			if (bSearch(iarr2, t) == true) {System.out.println(t + " 가 iarr2에 있습니다.\n");}
			else {System.out.println(t + " iarr2에 없습니다.\n");}

		}
	}
}
