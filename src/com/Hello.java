package src.com;

import chennai.X;

public class Hello extends X {
   
   public static void main(String[] args) {
      Hello obj = new Hello();
      //System.out.println("private: " + obj.b);
      //System.out.println("Short Value: " + obj.s);
      System.out.println("Protected: " + obj.i);
      System.out.println("Public: " + obj.l);
   }

   
}

