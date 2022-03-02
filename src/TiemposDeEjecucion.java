import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class TiemposDeEjecucion {
	public static void main(String[] args) throws IOException {
		ObtenerTiemposDeEjecucion();

//		graficar();

	}

	static void ObtenerTiemposDeEjecucion() throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese numero: ");
		int num = scan.nextInt();

		tiemposDeEjecucion(num);
	}

	static int[] arrayCasosAleatorios(int tam) {
		int desde = 1;
		int hasta = 98;
		int[] numeros = new int[tam];
		Random rnd = new Random();
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = rnd.nextInt(hasta - desde + 1) + desde;
		}
//        printArray(numeros);
		return numeros;
	}

	static int[] arrayPeoresCasos(int n) {
		int[] peores = new int[n];

		for (int i = 0, j = n; i < peores.length; i++, j--) {
			peores[i] = j;
		}
//		printArray(peores);
		return peores;
	}

	static void printArray(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	static void tiemposDeEjecucion(int n) throws IOException {
		String a1 = "CountingSort.txt";
		File file1 = new File(a1);
		BufferedWriter bwA1 = new BufferedWriter(new FileWriter(file1));

		String a2 = "RadixSort.txt";
		File file2 = new File(a2);
		BufferedWriter bwA2 = new BufferedWriter(new FileWriter(file2));

		String a3 = "BucketSort.txt";
		File file3 = new File(a3);
		BufferedWriter bwA3 = new BufferedWriter(new FileWriter(file3));

//		for (int i=2;i<=n;i++){
//			int[] iArray1= arrayPeoresCasos(i);
//			//printArray(iArray);
//			
//			long inicio1 = System.nanoTime();
//			Algoritmos.countingSort(iArray1); //
//			bwA1.write(iArray1.length+"\t"+(System.nanoTime()-inicio1)+"\n");
//			
//		}
		for (int i = 5; i <= n; i++) {
			System.out.println(i);
			int[] iArray1 = arrayPeoresCasos(i);
			// printArray(iArray);

			long inicio1 = System.nanoTime();
			Algoritmos.countSort(iArray1); //
			bwA1.write(iArray1.length + "\t" + (System.nanoTime() - inicio1) + "\n");
//			
			int[] iArray2 = arrayCasosAleatorios(i);

			long inicio2 = System.nanoTime();
			Algoritmos.radixsort(iArray2); //
			bwA2.write(iArray2.length + "\t" + (System.nanoTime() - inicio2) + "\n");

			int[] iArray3 = arrayCasosAleatorios(i);
			long inicio3 = System.nanoTime();
			Algoritmos.bucketSort(iArray3, i / 3);
			bwA3.write(iArray3.length + "\t" + (System.nanoTime() - inicio3) + "\n");

		}
		bwA1.close();
		bwA2.close();
		bwA3.close();
		Desktop.getDesktop().edit(file1);
		Desktop.getDesktop().edit(file2);
		Desktop.getDesktop().edit(file3);
	}

	static void graficar() {
		// Requiere JavaPlot
//		JavaPlot p = new JavaPlot();
//		
//		p.addPlot("\"./CountingSort.txt\" with lines");
//		p.addPlot("\"./RadixSort.txt\" with lines");
//		p.addPlot("\"./BucketSort.txt\" with lines");
//		p.plot();
	}
}