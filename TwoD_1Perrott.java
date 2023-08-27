public class TwoD_1Perrott {
  public static void main( String[] args ) {
    int[][] arr = { {1,2,3,4},{15,6,7,8},{9,10,11,12} };
    int[][] m1 = { {1,2,3}, {2,2,2}, {3,2,1}};
    int[][] m2 = { {7,7,7}, {7,7,7}, {7,7,7} };
    int[][] m3 = { {8,1,6}, {3,5,7}, {4,9,2} };
    System.out.println("MAX: " + max(arr) );
    System.out.println("Sum 2nd row: " + rowSum( arr, 2 ));
    System.out.println("Sum 3rd column: " + columnSum( arr, 3 ));    
    System.out.println("arr is magic? " + isMagic(arr));
    System.out.println("m1 is magic? " + isMagic(m1));    
    System.out.println("m2 is magic? " + isMagic(m2));
    System.out.println("m3 is magic? " + isMagic(m3)); 
  }
  
  public static int max(int[][] a) {
  
    int hiMax = a[0][0];
    
    for (int[] row : a) {
      for (int i : row) {
         if (i > hiMax) hiMax = i;
      }
    }
                
    return hiMax;
  }
  
  public static int rowSum(int[][] a, int x) {
    
    int sum = 0;
    
    for (int i : a[x - 1]) {
      sum += i;
    }
    
    return sum;
  }
  
  public static int columnSum(int[][] a, int x) {
    
    int sum = 0;
    
    for (int i = 0; i < a.length; i++) {
      sum += a[i][x - 1];
    }
    
    return sum;
  }
  
  public static boolean isMagic(int[][] a) {
    boolean isMagic = true;
    if (a.length != a[0].length) {
      isMagic = false;
    } else {
      int rowSum = rowSum(a, 1);
      for (int i = 1; i < a.length; i++) {
         if (rowSum != rowSum(a, i + 1)) {
            isMagic = false;
         }
      }
      
      if (isMagic) {
         int colSum = columnSum(a, 1);
         for (int i = 0; i < a[0].length; i++) {
            if (colSum != columnSum(a, i + 1)) {
               isMagic = false;
            }
         }
         
         if (isMagic) {
            int diagSum1 = 0;
            int diagSum2 = 0;

            for (int i = 0; i < a.length; i++) {
               diagSum1 += a[i][i];
               diagSum2 += a[a.length - i - 1][i];
            }
            
            if (diagSum1 != diagSum2) {
               isMagic = false;
            }
         }
      }
      
    }
    return isMagic;
  }
  
}