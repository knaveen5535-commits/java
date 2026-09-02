package chennai;

class Q
{
    int n;
    boolean valueSet=false;
    synchronized int get()
    {
        while(!valueSet)
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println("InterruptedException caught");
            }
        System.out.println("Got: "+n);
        valueSet=false;
        notify();
        return(n);
    }
    synchronized void put(int n)
    {
        while(valueSet)
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println("InterruptedException caught");
            }
        this.n=n;
        valueSet=true;
        System.out.println("Put: "+n);
        notify();
    }
    public static class Pc2 extends Thread
    {
        Q q;
        Pc2(String name,Q q)
        {
            super(name);
            this.q=q;
            start();
        }
        public void run()
        {
            int i = 0;
            if(Thread.currentThread().getName().equals("Producer"))
            {
                while(true)
                {
                    q.get();
                   
                }
            }
            else
            {
                while(true)
                {
                     q.put(i++);
                }
            }
        }
    }
    public static void main(String args[])
    {
        Q q=new Q();
        new Pc2("Producer",q);
        new Pc2("Consumer",q);
        System.out.println("Press Control-C to stop.");
    }
}