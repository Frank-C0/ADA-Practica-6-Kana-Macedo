import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Algoritmos {
	
	// COUNTING SORT
	public static void countingSort(int[] arr) {
		int[] rpta = new int[arr.length];
		int max = max(arr);
		int[] aux = new int[max + 1];
		fill(arr, aux, max);
		cumulative(aux, arr);
		transcript(arr, aux, rpta);
//		System.out.println("-Respuesta counting sort-");
//		System.out.println(Arrays.toString(rpta));
	}
	private static void transcript(int[] arr, int[] aux, int[] rpta) {
		for (int i = arr.length - 1; i >= 0; i--) {
			if (aux[arr[i]] != 0)
				aux[arr[i]]--;
			rpta[aux[arr[i]]] = arr[i];
//			System.out.println("-Transcribiendo respuestas usando el array original y el auxiliar-");
//			System.out.println("Array Original: "+ Arrays.toString(arr));
//			System.out.println("Array Auxiliar: "+Arrays.toString(aux));
//			System.out.println("Array Respuesta: "+Arrays.toString(rpta));
//			System.out.println("--------");
		}
	}
	private static void cumulative(int[] aux, int[] arr) {
//		System.out.println("-Sumando los valores del array auxiliar acumuladamente-");		
//		System.out.println("Array Auxiliar: "+Arrays.toString(aux));
		for (int i = 1; i < aux.length; i++) {
			aux[i] += aux[i - 1];
		}
//		System.out.println("Array Auxiliar Acumulado: "+Arrays.toString(aux));
//		System.out.println("--------");
	}
	private static void fill(int[] arr, int[] aux, int max) {
		for (int i = 0; i < max; i++) {
			aux[arr[i]] += 1;
//		System.out.println("-Encontrado ocurrencias y colocandolas en el array auxiliar-");
//		System.out.println("Ocurrencia de: "+arr[i]);
//		System.out.println("Array Original: "+ Arrays.toString(arr));
//		System.out.println("Array Auxiliar: "+Arrays.toString(aux));
		}
	}
	private static int max(int[] arr) {
		int max = arr[0];
		for (int a : arr)
			if (max < a)
				max = a;
		return max;
	}

	// BUCKET SORT
	public static void bucketSort(int[] arr) {
//		System.out.println("--------");
//		System.out.println("-Bucket Sort-");
		int max = max(arr);
		int mod = findMod(max);
//		System.out.println("Mod: "+mod);
//		System.out.println("Array Original: "+ Arrays.toString(arr));
		ArrayList<Integer>[] bucket = new ArrayList[mod + 1];
		for (int i = 0; i < mod + 1; i++)
			bucket[i] = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			int bucketIndex = 0;
			if (arr[i] >= 10)
				bucketIndex = findMod(arr[i]);
			bucket[bucketIndex].add(arr[i]);
//	      System.out.println("Buckets: "+Arrays.deepToString(bucket));
		}

		for (int i = 0; i <= mod; i++) {
			Collections.sort((bucket[i]));
//	      System.out.println("Ordenando bucket: "+i);
//	      System.out.println("Buckets: "+Arrays.deepToString(bucket));
		}
		int[] rpta = new int[arr.length];
		int index = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i].size(); j++) {
				rpta[index] = bucket[i].get(j);
				index++;
			}
		}
//	    System.out.println("-Respuesta bucket sort-");
//	    System.out.println(Arrays.toString(rpta));

	}

	private static int findMod(int max) {
		return Integer.parseInt(Integer.toString(max).substring(0, 1));
	}

	
	//	RADIX SORT
	
	static void radixsort(int arr[], int n) {
		int m = max(arr);
		for (int exp = 1; m / exp > 0; exp *= 10) {
			countSortForRadixSort(arr, n, exp);
		}
	}
	static void countSortForRadixSort(int arr[], int n, int exp) {
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for (i = 0; i < n; i++) {
			count[(arr[i] / exp) % 10]++;
		}
		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}
		for (i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}
	static void radixsort(int arr[]) {
		radixsort(arr, arr.length);
	}
	
	

	// Algoritmos otros
	static void bucketSort(int arr[], int k) {
		int n = arr.length;
		int max_val = arr[0];
		for (int i = 1; i < n; i++) {
			max_val = Math.max(max_val, arr[i]);
			max_val++;
		}
		ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < k; i++) {
			bucket.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < n; i++) {
			int bucketI = (k * arr[i] / max_val);
			bucket.get(bucketI).add(arr[i]);
		}
		for (int i = 0; i < k; i++) {
			Collections.sort(bucket.get(i));
		}
		int index = 0;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < bucket.get(i).size(); j++) {
				arr[index++] = bucket.get(i).get(j);
			}
		}
	}

	static void countSort(int[] arr) {
		int max = max(arr);
		int[] count = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		int index = 0;
		for (int i = max; i >= 0; i--) {
			int score = count[i];
			for (int j = 0; j < score; j++) {
				arr[arr.length - index - 1] = i;
				index++;
			}
		}
//		MainTest.print(arr);
	}
}
