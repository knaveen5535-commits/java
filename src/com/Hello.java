package src.com;
public class Hello {
   
   public static void main(String[] args) {
      X obj = new X();
      //System.out.println("Byte Value: " + obj.b);
      System.out.println("Short Value: " + obj.s);
      System.out.println("Int Value: " + obj.i);
      System.out.println("Long Value: " + obj.l);
   }

   
}

class X
{
   private byte b=5;
      short s=10;
   protected int i=15547777;
   public long l=2085622458l;

}