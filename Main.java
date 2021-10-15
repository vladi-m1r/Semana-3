import java.util.Stack;

/*
 * Solo los ejercicios 1, 6 y 7 han sido resueltos completamente
 *	Link con los ejercicios 1 y 7 
 * 	.https://drive.google.com/file/d/1V3BUXYCCHcmYpOQgtC9OO_OBV2XOy6VA/view?usp=sharing
 * 
 */

class Main {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6};
		int[] simpleArr = {1, 3, 5, -9, 8};
		
		System.err.println("\nEjercicio 1");
		System.out.println("a) Result: " + maxValue(arr));
		System.out.println("b) Result: " + minValue(arr));
		System.out.println("c) Result: " + sumValues(simpleArr));
		
		System.err.println("\nEjercicio 7");
		int num1 = 25, num2 = 10;
		System.out.println("a) Recursivo Result: " + mcd(num1, num2));
		
		System.out.println("a) Iterativo Result: " + mcd2(num1, num2));
		
		

		System.err.println("\nEjercicio 2");
		System.out.println("a) Result: " + sumaOneToN(4));
		System.out.println("b) Result: " + productoOneToN(3));
		System.out.println("c) Result: " + isPrimeNumber(59));
		System.out.println("d) Result: " + powTwoToN(10));
		
		
		System.err.println("\nEjercicio 3");
		System.out.println("a) Result: " + powXtoN(10, 2));
		//System.out.println("c) Result: " + powXtoNC(10, 2));
		
		System.err.println("\nEjercicio 4");
		System.out.println("Result: ");
		misterio(simpleArr, simpleArr.length);
		
		System.err.println("\nEjercicio 5");
		System.out.println("Result: " + misterio2(simpleArr, simpleArr.length));
		
		System.err.println("\nEjercicio 6");
		System.out.println("Result: " + ackermanFunc(3, 4));
		System.out.println("Result: " + ackermanFuncRec(3, 4));
		
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
	
	// PENDIENTES
	// EJERCICIO 2
	// A)
	public static int sumaOneToN(int n) {
		return n == 1 ? 1: n + sumaOneToN(--n);
	}
	// B)
	public static int productoOneToN(int n) {
		return n == 1 ? 1: (int)Math.pow(n, 2) + productoOneToN(--n);
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
	// D)
	public static int powTwoToN(int n) {
		return n == 0 ? 1: 2 * powTwoToN(--n);
	}
	
	
	// EJERCICIO 3
	// A) 
	public static float powXtoN(int x, int n) {
		// retorna la potencia de x elevado la n o Multiplica x n veces
		return n == 0 ? 1: x * powXtoN(x, --n);
	}
	
	// B)

	
	// C)
	// FIX ERROR
	public static float powXtoNC(float x, int n) {
		// N es la potencia y x es el numero potenciado
		// X es cualquier numero
		// n solo puede ser mayor que 1? entonces no cumple con el enunciado
		// No existe una formula en el caso de que X sea menor o igual que 1
		if(n == 0) {
			return 1;
		}else if(n == 1) {
			return x;
		}else {
			if(n % 2 == 0) {
				// Esto no tiene sentido ya que llama a la misma funcion sin realizar alguna solucion
				// crea un bucle infinito
				return powXtoNC(powXtoNC(x, n/2), 2);
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
					// El valor que tenga n no importa ya que el siguiente stack decidira su valor
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
	
}