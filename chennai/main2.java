package chennai;
public class main2 extends Thread {
    public void run()
    {
        try
        {
            String name=Thread.currentThread().getName();
            if(name.equals("First"))
            {
                for(int i=20;i>=1;++i)
                {
                    if(i == 15)
                    {
                        Thread.sleep(10);
                        System.out.println(name+" Value "+i);
                    }
                }
            }
        }
        catch(InterruptedException ie)
        {
            ie.printStackTrace();
        }
    }
    public static void main(String[] args)
        {
            main2 th1 = new main2();
            th1.setName("First");
            main2 th2 = new main2();
            th2.setName("Second");
            th1.start();
            th2.start();
        }
}    