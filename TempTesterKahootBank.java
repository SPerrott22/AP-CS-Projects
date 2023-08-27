public class TempTesterKahootBank {
   public static void main(String[] args) {
      int[] arr = {2, 3, 4, 5, 4, 3, 2};
      int sum = 0;
      for (int i : arr) {
         if (sum < 10) {
            sum += i;
         } else break;
      }
      System.out.println(sum);
      
      int count = 0;
      int number = 20;
      while (number > 0) {
         number = number / 2;
         if ((number + 1) % 2 == 0) count++;
      }
      
      System.out.println(count);


      boolean a = true;
      boolean b = false;
      boolean c = false;
      System.out.println(!(a == b) && !b != a || !b != !c);
      
      boolean superEven = true;
      for (int i = 0; i < 100; i += 2)
         if (i%2!=0) superEven = false;
         else superEven = !superEven;
      System.out.println(superEven);
   }
}