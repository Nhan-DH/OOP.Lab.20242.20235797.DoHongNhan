package lab1;

import java.util.Scanner;

public class MatrixAdddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập kích thước ma trận
        System.out.print("Nhập số hàng của ma trận: ");
        int rows = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận: ");
        int cols = scanner.nextInt();

        // Khai báo 3 ma trận
        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        int[][] sumMatrix = new int[rows][cols];

        // Nhập giá trị cho ma trận 1
        System.out.println("Nhập các phần tử cho ma trận 1:");
        inputMatrix(scanner, matrix1);

        // Nhập giá trị cho ma trận 2
        System.out.println("Nhập các phần tử cho ma trận 2:");
        inputMatrix(scanner, matrix2);

        // Tính tổng hai ma trận
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        // Hiển thị kết quả
        System.out.println("Ma trận tổng:");
        printMatrix(sumMatrix);

        scanner.close();
    }

    // Phương thức nhập ma trận
    private static void inputMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Nhập phần tử [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Phương thức hiển thị ma trận
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}

