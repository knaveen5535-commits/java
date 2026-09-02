package chennai;

public class StringDemo
{
    public static void main(String args[])
    {
        String s1="Hello";
        // s1 = s1.concat (" World");
        // System.out.println(s1);
        String s2="Hello";
        String s3=new String("Hello");
        //System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s1.equals(s3));
    }
}