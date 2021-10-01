public class Main {
	
	public static void main(int[] args) {
		System.out.println("Hello world!");
		maxValue(args);
	}

	public static int maxValue(int [] vector) {
		return maxValue(vector, 0, vector.length);
	}

	// Diseñado bajo la tecnica divide y venceras
	// Divide el vector en 2 partes recursivamente y luego junta los resultados en uno solo
	private static int maxValue(int [] vector, int i, int j) {
		if(j == i) {
			return vector[i];
		}else {
			
			if(j == i + 1) {
				return vector[i] > vector[j] ? vector[i] : vector[j];
			}
			
			int mid = j/2;
			int max1 = maxValue(vector, i, mid - 1);
			int max2 = maxValue(vector, mid, j);
			return max1 > max2 ? max1 : max2;
		}
	}
	
	public static int minValue(int [] vector) {
		return 0;
	}
	
	public static int sumValues(int [] vector) {
		return 0;
	}
}