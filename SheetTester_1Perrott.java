/**
   A tester class that tests the sheet class. Answer to problem P3.4
*/
public class SheetTester_1Perrott { 
   /**
      Main method.
      @param args array of strings
   */
   public static void main (String[] args) { 
      Sheet sigma = new Sheet();
      sigma = sigma.cutInHalf().cutInHalf(); // cut in half twice
      System.out.println("sheet width: " + sigma.width() + "mm");
      System.out.println("sheet height: " + sigma.height() + "mm");
      System.out.println("sheet name: " + sigma.name());
     
      System.out.println("\nExpected Result:\nsheet width: 420mm\nsheet height: 594mm\nsheet width: A2");
   }  
}

/**
   A sheet with dimensions that can be cut and follows the ISO 126 standard for paper sizes.
*/
class Sheet {
   private int w;
   private int h;
   private int aLabel;
   /**
      Sheet constructor. Default creates an A0 sheet: 841mm x 1189mm
   */
   public Sheet() {
      w = 841;
      h = 1189;
      aLabel = 0;
   }
   /**
      Provide a method cutInHalf that yields a Sheet object of half the size.
      @return sheet object of half the size.
   */
   public Sheet cutInHalf() {
      Sheet s = new Sheet();
      s.aLabel = this.aLabel + 1;
      // cuts the longer dimension in half
      if (this.h > this.w) {
         s.h = this.h/2;
         s.w = this.w;
      } else {
         s.w = this.w/2;
         s.h = this.h;
      }
      // swaps values of s.h and s.w to follow convention that width < height
      if (s.h < s.w) {
         s.h = s.h - s.w; // now s.h equals difference in height and width
         s.w = s.h + s.w; // now s.w equals what s.h was previously
         s.h = s.w - s.h; // now s.h equals
      }
      return s;
   }
   /**
      Provide method width returning width of sheet.
      @return width of sheet in mm
   */
   public int width() {
      return w;
   }
   /**
      Get height of sheet.
      @return height of sheet in mm
   */
   public int height() {
      return h;
   } 
   /**
      Get ISO 126 name of sheet.
      @return name of sheet
   */
   public String name() {
      return "A" + aLabel;
   }
}