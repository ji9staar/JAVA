package lab1;
// Мороз Олксандра IO-33
// Залікова №3316

public class LAB1 {
  // C5 = 1 - Дія з матрицею B:транспонування
  // C7 = 5 - тип елементів: char
  // C11 = 5 - Дія з матрицею C: Обчислити суму найбільших елементів в рядках
  // матриці з непарними номерами та найменших елементів в рядках матриці з
  // парними номерами

  private static char[][] transpose(char[][] B) {
    int rows = B.length;
    int cols = B[0].length;
    char[][] C = new char[cols][rows];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        C[j][i] = B[i][j];
      }
    }
    for (int i = 0; i < C.length; i++) {
      for (int j = 0; j < C[i].length; j++) {
        System.out.print(C[i][j] + " ");
      }
      System.out.println();
    }

    return C;
  }

  private static int calculateSpecialSum(char[][] C) {
    int sum = 0;
    for (int i = 0; i < C.length; i++) {
      char min = C[i][0];
      char max = C[i][0];
      for (int j = 1; j < C[i].length; j++) {
        if (C[i][j] < min)
          min = C[i][j];
        if (C[i][j] > max)
          max = C[i][j];
      }
      if (i % 2 == 0) {
        sum += (int) min;
        System.out.printf("Row`s %d min: %c (%d)\n", i, min, (int) min);
      } else {
        sum += (int) max;
        System.out.printf("Row`s %d max: %c (%d)\n", i, max, (int) max);
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    try {
      char[][] B = {
          { 'J', 'A', 'Z', 'A' },
          { 'M', 'A', 'V', 'A' },
          { 'N', 'A', 'Y', 'A' }
      };
      System.out.println("\nTransposed matrix C:");
      char[][] C = transpose(B);
      System.out.println();
      int result = calculateSpecialSum(C);
      System.out.println("\nСума: " + result);
    } catch (Exception e) {
      System.out.println("Сталася помилка: " + e.getMessage());
    }
  }
}