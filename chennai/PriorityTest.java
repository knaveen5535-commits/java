package chennai;

public class PriorityTest extends Thread
{
    public void run()
    {
        for(int i=1;i<=6;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
    public static void main(String args[])
    {
        PriorityTest rp1=new PriorityTest();
        rp1.setPriority(Thread.MAX_PRIORITY);
        rp1.setName("First Thread");
        PriorityTest rp2=new PriorityTest();
        rp2.setPriority(Thread.MIN_PRIORITY);
        rp2.setName("Second Thread");
        rp2.start();
        rp1.start();
    }
}
