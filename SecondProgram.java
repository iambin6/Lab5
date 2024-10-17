
package secondprogram;
import java.util.Scanner;

public class SecondProgram {

    public static boolean isPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num && num != 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so phan tu trong mang: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        
        System.out.println("Nhap cac phan tu cua mang:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Cac so hoan hao trong mang:");
        for (int num : array) {
            if (isPerfectNumber(num)) {
                System.out.println(num);
            }
        }

        scanner.close();
    }
}
