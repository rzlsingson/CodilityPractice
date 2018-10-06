package codi;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class OddOccurences {
	/**
	 * N is an odd integer within the range [1..1,000,000]; each element of array A
	 * is an integer within the range [1..1,000,000,000]; all but one of the values
	 * in A occur an even number of times. A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4]
	 * = 9 A[5] = 7 A[6] = 9 solution: 7
	 */
	public int solution(int[] A) {
		int odd = 0;
		HashMap<Integer, Integer> occurenceMap = new HashMap<Integer, Integer>();
		int length = A.length;
		for (int i = 0; i < length; i++) {
			int value = A[i];

			if (occurenceMap.containsKey(value)) {
				int numCount = occurenceMap.get(value);
				numCount++;
				occurenceMap.put(new Integer(value), numCount);
			} else {
				occurenceMap.put(new Integer(value), 1);
			}
		}

		Set<Integer> keySet = occurenceMap.keySet();

		for (Integer keyValue : keySet) {
			int numCount = occurenceMap.get(keyValue).intValue();

			if (numCount % 2 == 1) {
				odd = keyValue;
				System.out.println("num: " + numCount);
				System.out.println("val: " + keyValue);
				break;
			}
		}

		return odd;
	}

	public static void main(String args[]) {
		OddOccurences oo = new OddOccurences();

		int A[] = { 101, 9, 3, 9, 3, 9, 9 };
		System.out.println(oo.solution(A));

		int B[] = new int[1000000];
		int j = 500000;
		for (int i = 0; i < 500000; i++) {
			int odd = new Random().nextInt(999999 / 2) * 2 + 1;
			B[i] = odd;
			B[j] = odd;
			j++;
		}
		B[999999] = 7;

		System.out.println(oo.solution(B));

	}

}
