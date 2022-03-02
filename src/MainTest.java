public class MainTest {
	public static void main(String args[]) {
		
		System.out.println("Numeros a ordenar");
		int[] unsortedArray = { 
				(71), (43), (42), (12), (23), (92), (92), 
				(37), (75), (61), (50), (47), (9), (81), 
				(90), (27), (83), (60), (97), (90), (51), 
				(73), (40), (60), (74), (67), (32), (78), 
				(53), (32), (38), (30), (51), (83), (6), 
				(7), (9), (74), (29), (77), (29), (12), 
				(13), (77), (59), (79), (84), (93), (60)
				};
		print(unsortedArray);
		
		System.out.println("\nCounting Sort");
		int[] copia1 = ArrayCopy(unsortedArray);
		Algoritmos.countSort(copia1);
		print(copia1);

		System.out.println("Bucket Sort");
		int[] copia2 = ArrayCopy(unsortedArray);
		Algoritmos.bucketSort(copia2, copia2.length / 3);
		print(copia2);

		System.out.println("Radix Sort");
		int[] copia3 = ArrayCopy(unsortedArray);
		Algoritmos.radixsort(copia3);
		print(copia3);

	}

	static int[] ArrayCopy(int[] a) {
		int[] r = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			r[i] = a[i];
		}
		return r;
	}
	static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
