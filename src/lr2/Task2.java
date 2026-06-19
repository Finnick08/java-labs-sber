package lr2;

public class Task2 {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 4;
        int[][] matrix = new int[rows][cols];

        int num = 1;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        while (num <= rows * cols) {
            // Первая строка — слева направо
            for (int i = left; i <= right && num <= rows * cols; i++) {
                matrix[top][i] = num++;
            }
            top++;

            // Последний столбец — сверху вниз
            for (int i = top; i <= bottom && num <= rows * cols; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // Нижняя строка — справа налево
            for (int i = right; i >= left && num <= rows * cols; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;

            // Первый столбец — снизу вверх
            for (int i = bottom; i >= top && num <= rows * cols; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }

        // Вывод матрицы
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }
}
