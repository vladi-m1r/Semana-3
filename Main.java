class Main {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 6 ,4 ,5, 6, 7, 8, 9, 10, -100, -2323, 999};
		int[] simpleArr = {1, 3, 5, -9};
		System.out.println(maxValue(arr));
		System.out.println(minValue(arr));
		System.out.println(sumValues(simpleArr));
	}

	public static int maxValue(int [] vector) {
		return maxValue(vector, 0, vector.length - 1);
	}

	private static int maxValue(int [] vector, int i, int j) {
		if(j == i) {
			return vector[i];
		}else {
			
			if(j == i + 1)
				return vector[i] > vector[j] ? vector[i] : vector[j];
			
			int mid = (j - i)/2 + i;
			int max1 = maxValue(vector, i, mid);
			int max2 = maxValue(vector, mid + 1, j);
			return max1 > max2 ? max1 : max2;
		}
	}
	
	public static int minValue(int [] vector) {
		return minValue(vector, 0, vector.length - 1);
	}
	
	private static int minValue(int [] vector, int i, int j) {
		if(j == i) {
			return vector[i];
		}else {
			
			if(j == i + 1)
				return vector[i] < vector[j] ? vector[i] : vector[j];
			
			int mid = (j - i)/2 + i;
			int min1 = minValue(vector, i, mid);
			int min2 = minValue(vector, mid + 1, j);
			return min1 < min2 ? min1 : min2;
		}
	}
	
	public static int sumValues(int [] vector) {
		return sumValues(vector, 0, vector.length - 1);
	}
	
	private static int sumValues(int [] vector, int i, int j) {
		if(j == i) {
			return vector[i];
		}else {
			
			if(j == i + 1)
				return vector[i] + vector[j];
			
			int mid = (j - i)/2 + i;
			int sum1 = sumValues(vector, i, mid);
			int sum2 = sumValues(vector, mid + 1, j);
			return sum1 + sum2;
		}
	}
}