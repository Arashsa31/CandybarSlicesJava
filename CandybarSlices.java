import java.text.NumberFormat;

/**
 * @author Arash
 */
public class CandybarSlices {
	public static void main(String[] args) {

		for (int k = -2; k <= 15; k++) {
			System.out.println("Normal     Cut: " + NumberFormat.getInstance().format(cut(k))); // normal cuts
			System.out.println("Restricted Cut: " + NumberFormat.getInstance().format(cutLeft(k))); // restricted cuts
			System.out.println();
		} 
	}

	private static int cut(int n) {
		int tempValue = 0;
		// validate input for >= 0
		if (n >= 0) {
			if (n == 0 || n == 1)
				tempValue = 1;
			else
				tempValue = n * cut(n - 1);
		}
		return tempValue;
	}

	private static int cutLeft(int n) {
		int tempValue = 0;
		// validate input for >= 0
		if (n >= 0) {
			if (n == 0 || n == 1)
				tempValue = 1;
			else
				for (int i = 1; i <= n; i++) {
					tempValue += cutLeft(i - 1) * cutLeft(n - i);
				}
		}
		return tempValue;
	}
}
