import java.util.Stack;

/*
 *	Los ejercicios del 1 al 7 han sido resueltos completamente. A excepcion del
 *	Ejercicio 3, falta el ejercicio B.
 *
 *	Link con los ejercicios 1 al 7 
 * 	https://drive.google.com/file/d/1XcvSVeqPAPB06W8W9R5C8y7cjqPho7OU/view?usp=sharing
 * 	
 */

class Main {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6};
		
		System.err.println("\nEjercicio 1");
		System.out.println("a) Result: " + maxValue(arr));
		System.out.println("b) Result: " + minValue(arr));
		System.out.println("c) Result: " + sumValues(arr));
		
		System.err.println("\nEjercicio 2");
		System.out.println("a) Result: " + sumaOneToN(4));
		System.out.println("b) Result: " + productoOneToN(3));
		System.out.println("c) Result: " + isPrimeNumber(59));
		System.out.println("d) Result: " + powTwoToN(10));
		System.out.println("Iterativos");
		System.out.println("a) Result: " + sumaOneToN2(4));
		System.out.println("b) Result: " + productoOneToN2(3));
		System.out.println("c) Result: " + isPrimeNumber2(59));
		System.out.println("d) Result: " + powTwoToN2(10));
		
		System.err.println("\nEjercicio 3");
		System.out.println("a) Result: " + powXtoN(10, 2));
		System.out.println("c) Result: " + powXtoNC(10, 4));
		
		System.err.println("\nEjercicio 4");
		System.out.println("Result: ");
		misterio(arr, arr.length);
		
		System.err.println("\nEjercicio 5");
		System.out.println("Result: " + misterio2(arr, arr.length));
		
		System.err.println("\nEjercicio 6");
		System.out.println("Result (Iterativa): " + ackermanFunc(3, 4));
		System.out.println("Result (Recursiva): " + ackermanFuncRec(3, 4));
		
		System.err.println("\nEjercicio 7");
		int num1 = 25, num2 = 10;
		System.out.println("a) Recursivo Result: " + mcd(num1, num2));
		System.out.println("a) Iterativo Result: " + mcd2(num1, num2));
		
		// Prueba de tiempo de ejecucion (Recursiva vs Iterativa)
		//tiempoDeEjecucion();
	}

	
	// EJERCICIO 1
	// A)
	public static int maxValue(int [] vector) {
		return maxValue(vector, 0, vector.length - 1);
	}

	private static int maxValue(int [] vector, int i, int j) {
		if(j == i) {
			return vector[i];
		}else {
			int mid = (j - i)/2 + i;
			int max1 = maxValue(vector, i, mid);
			int max2 = maxValue(vector, mid + 1, j);
			return max1 > max2 ? max1 : max2;
		}
	}
	
	public static int maxValueIterative(int [] vector) {
		// Version iterativa del valor mayor de un vector
		int max = vector[0];
		
		for (int i = 1; i < vector.length; i++)
			if(vector[i] > max) max = vector[i];
		
		return max;
	}
	
	// B)
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
	
	
	public static int minValueIterative(int [] vector) {
		// Version iterativa del valor menor de un vector
		int min = vector[0];
		
		for (int i = 1; i < vector.length; i++)
			if(vector[i] < min) min = vector[i];
		
		return min;
	}
	
	// C)
	public static int sumValues(int [] vector) {
		return sumValues(vector, 0, vector.length - 1);
	}
	
	private static int sumValues(int [] vector, int i, int j) {
		if(j == i) {
			return vector[i];
		}else {
			int mid = (j - i)/2 + i;
			int sum1 = sumValues(vector, i, mid);
			int sum2 = sumValues(vector, mid + 1, j);
			return sum1 + sum2;
		}
	}
	
	public static int sumValuesIterative(int [] vector) {
		
		// Version iterativa de la suma de enteros
		int suma = 0;
		
		for(int elem: vector) 
			suma += elem;
		
		return suma;
	}
	
	// EJERCICIO 2
	// A)
	public static int sumaOneToN(int n) {
		return n == 1 ? 1: n + sumaOneToN(--n);
	}
	
	public static int sumaOneToN2(int n) {
		// Version iterativa de la suma los n primeros
		int suma = 0;
		for (int i = n; i > 0; i--)
			suma += i;
		return suma;
	}
	// B)
	public static int productoOneToN(int n) {
		return n == 1 ? 1: (int)Math.pow(n, 2) + productoOneToN(--n);
	}
	
	public static int productoOneToN2(int n) {
		// Version iterativa del producto de los n primeros
		int producto = 0;
		for (int i = n; i > 0; i--)
			producto += i * i;
		return producto;
	}
	
	public static boolean isPrimeNumber(int n) {
		return isPrimeNumber(n - 1, n);
	}
	
	
	// C)
	private static boolean isPrimeNumber(int count, int n) {
		if(count == 1) {
			return true;
		}else if(n == 1 || n % count == 0) {
			return false;
		}
		else {
			return isPrimeNumber(--count, n);
		}
	}
	
	public static boolean isPrimeNumber2(int n) {
		// Version iterativa de encontrar numero primo
		for (int i = n - 1; i > 1; i--) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	// D)
	public static int powTwoToN(int n) {
		return n == 0 ? 1: 2 * powTwoToN(--n);
	}
	
	public static int powTwoToN2(int n) {
		// Version iterativa de 2 eleveado a la N
		int resultado = 1;
		
		for (int i = n; i > 0; i--)
			resultado *= 2;
		
		return resultado;
	}
	
	
	// EJERCICIO 3
	// A) 
	public static float powXtoN(int x, int n) {
		// retorna la potencia de x elevado la n o Multiplica x n veces
		return n == 0 ? 1: x * powXtoN(x, --n);
	}
	
	// B) SIN RESOLVER
	
	// C)
	public static float powXtoNC(float x, int n) {
		// retorna la potencia de x usando una formula
		if(n == 0) {
			return 1;
		}else if(n == 1) {
			return x;
		}else {
			if(n % 2 == 0) {
				return powXtoNC(x, n/2) * powXtoNC(x, n/2);
			}else {
				return x * powXtoNC(powXtoNC(x, (n - 1)/2), 2);
			}
		}
	}
	
	// EJERCICIO 4
	public static void misterio(int arr[], int size) {
		// Imprime los cada elemento de un arreglo desde el ultimo elemento
		// al primero
		if(size > 0) {
			size--;
			System.out.println(arr[size]);
			misterio(arr, size);
		}
	}
	
	// EJERCICIO 5
	public static int misterio2(int [] arr, int size) {
		// Devuelve la suma de un arreglo recursivamente
		size--;
		if(size > 0) {
			return arr[size] + misterio2(arr, size);
		}else {
			return arr[size];
		}
	}

	// EJERCICIO 6
	public static int ackermanFunc(int m, int n) {
		// Version iterativa de la funcion ackerman
		Stack<int[]> stack = new Stack<int []>();
		// El lugar 0 es para el valor M y el lugar 1 para el estado del stack
		stack.push(new int [] {m, 1});
		do {
			// Va a ejecutarse
			if(stack.lastElement()[1] == 1) {
				if(m == 0) {
					n = n + 1;
					stack.pop();
				}else if(n == 0) { // N == 0
					stack.lastElement()[1] = 0;// Establece que ya se ejecuto ese stack
					m = m - 1;
					n = 1;
					stack.push(new int [] {m, 1});
				}else {
					stack.lastElement()[1] = 0; // Establece que ya se ejecuto ese stack
					stack.push(new int [] {m - 1, 2});
					stack.push(new int [] {m, 1});
					n = n - 1; // Establece el valor del segundo stack
				}
			// Su ejecucion estaba pendiente
			}else if(stack.lastElement()[1] == 2) {
				stack.lastElement()[1] = 1;
				m = stack.lastElement()[0];
			// Ya se ejecuto
			}else {
				stack.pop();
			}
		}while(!stack.empty());
		
		return n;
	}
	
	public static int ackermanFuncRec(int m, int n) {
		// Version recursiva de ackerman Func
		if(m == 0) {
			return n + 1;
		}else if(n == 0) {
			return ackermanFuncRec(m - 1, 1);
		}else {
			return ackermanFuncRec(m - 1, ackermanFuncRec(m, n - 1));
		}
	}
	
	// Ejercico 7
	public static int mcd(int m,int n) {
		// Version Recursiva del maximo comun divisor
		if(n == 0) {
			return m;
		}else if(n > m) {
			return mcd(n, m);
		}else {
			return mcd(n, m % n);
		}
	}
	
	public static int mcd2(int m, int n) {
		// Version Iterativa del maximo comun divisor
		int temp;
		
		do {
			temp = n;
			n = m % n;
			m = temp;
		}while(n != 0);
		
		return m;
	}
	
	// Funcion adicional para probar los tiempos de ejecucion
	public static void tiempoDeEjecucion() {
		
		System.err.println("\nTiempo de ejecucion, comparacion");
		long a = 0, fin = 0;
		int m = 3, n = 3;

		a = System.nanoTime();
		sumaOneToN(100);
		fin = System.nanoTime() - a;
		System.out.println("\nSumatoria de 1 hasta n (RECURSIVO): " + fin);
		a = System.nanoTime();
		sumaOneToN2(100);
		fin = System.nanoTime() - a;
		System.out.println("Sumatoria de 1 hasta n (ITERATIVO): " + fin);
		a = System.nanoTime();
		productoOneToN(10000);
		fin = System.nanoTime() - a;
		System.out.println("\nProducto de cuadrados de 1 hasta n (RECURSIVO): " + fin);
		
		
		a = System.nanoTime();
		productoOneToN2(10000);
		fin = System.nanoTime() - a;
		System.out.println("Producto de cuadrados de 1 hasta n (ITERATIVO): " + fin);
		
		a = System.nanoTime();
		isPrimeNumber(9485);
		fin = System.nanoTime() - a;
		System.out.println("\nEncontrar numero primo (RECURSIVO): " + fin);
		a = System.nanoTime();
		isPrimeNumber2(9485);
		fin = System.nanoTime() - a;
		System.out.println("Encontrar numero primo (ITERATIVO): " + fin);
		
		
		a = System.nanoTime();
		powTwoToN(10000);
		fin = System.nanoTime() - a;
		System.out.println("\nPotencia de 2 a la N (RECURSIVO): " + fin);
		a = System.nanoTime();
		powTwoToN2(10000);
		fin = System.nanoTime() - a;
		System.out.println("Potencia de 2 a la N (ITERATIVO): " + fin);
		
		
		a = System.nanoTime();
		ackermanFunc(m, n);
		fin = System.nanoTime() - a;
		System.out.println("\nACKERMAN ITERATIVO: " + fin);
		a = System.nanoTime();
		ackermanFuncRec(m, n);
		fin = System.nanoTime() - a;
		System.out.println("ACKERMAN RECURSIVO: " + fin);
		
		
		a = System.nanoTime();
		mcd(1030040, 757884);
		fin = System.nanoTime() - a;
		System.out.println("\nMCD(RECURSIVO): " + fin);
		
		a = System.nanoTime();
		mcd2(1030040, 757884);
		fin = System.nanoTime() - a;
		System.out.println("MCD(ITERATIVO): " + fin);
		
		
		// Ejercicio 1
		int[] arr = {1, 2, 3, 4, 5, 66, 7, 8, 9, 10, 11, 12, 9, 34, 11, 10, 100, 1023, 13};
		
		a = System.nanoTime();
		maxValue(arr);
		fin = System.nanoTime() - a;
		System.out.println("\nMaxValue(RECURSIVO): " + fin);
		a = System.nanoTime();
		maxValueIterative(arr);
		fin = System.nanoTime() - a;
		System.out.println("MaxValue(ITERATIVO): " + fin);
		
		
		a = System.nanoTime();
		minValue(arr);
		fin = System.nanoTime() - a;
		System.out.println("\nMinValue(RECURSIVO): " + fin);
		a = System.nanoTime();
		minValueIterative(arr);
		fin = System.nanoTime() - a;
		System.out.println("MinValue(ITERATIVO): " + fin);
		
		
		a = System.nanoTime();
		sumValues(arr);
		fin = System.nanoTime() - a;
		System.out.println("\nSuma de array(RECURSIVO): " + fin);
		a = System.nanoTime();
		sumValuesIterative(arr);
		fin = System.nanoTime() - a;
		System.out.println("Suma de array(ITERATIVO): " + fin);
	
		// Ejercicio 3
		a = System.nanoTime();
		powXtoN(3, 500);
		fin = System.nanoTime() - a;
		System.out.println("\n(A1)Potencia de X^n: " + fin);
		a = System.nanoTime();
		powXtoN(3, 1000);
		fin = System.nanoTime() - a;
		System.out.println("\n(A2)Potencia de X^n: " + fin);
		a = System.nanoTime();
		powXtoN(3, 1500);
		fin = System.nanoTime() - a;
		System.out.println("\n(A3)Potencia de X^n: " + fin);
		
		a = System.nanoTime();
		powXtoNC(3, 500);
		fin = System.nanoTime() - a;
		System.out.println("\n(B1)Potencia de X^n: " + fin);
		
		a = System.nanoTime();
		powXtoNC(3, 1000);
		fin = System.nanoTime() - a;
		System.out.println("\n(B2)Potencia de X^n: " + fin);
		
		a = System.nanoTime();
		powXtoNC(3, 1500);
		fin = System.nanoTime() - a;
		System.out.println("\n(B3)Potencia de X^n: " + fin);
	}
	
}