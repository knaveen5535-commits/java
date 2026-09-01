package chennai;

class mythread extends Thread
{
    public void run ()
    {
        for(int i = 0; i<= 9; ++i)
        {
            if (i==5)
            {
                try
                {
                    Thread.sleep(5000);
                }
                catch (Exception e)
                {
                    System.out.println(e.toString());
                }
            }
            
            System.out.println(i+1);
        }
    }
    public static void main(String args[])
    {
        mythread mt = new mythread();
        System.out.println("Before starting thread");
        mt.start();
        
    }
}
