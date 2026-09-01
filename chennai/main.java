package chennai;

class MethodDemo extends Thread{
    public static void main(String args[]){
        MethodDemo t1=new MethodDemo();
        System.out.println("Default thread name is: "+t1.getName());
        t1.setName("Hello Thread");
        System.out.println("t1 name after assigning :"+t1.getName());
        System.out.println("Default thread priority is: "+t1.getPriority());
        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("t1 priority after assigning :"+t1.getPriority());
        System.out.println("Default thread group is: "+t1.getThreadGroup());
        System.out.println("Default t1 isDaemon thread is: "+t1.isDaemon());
        t1.setDaemon(true);
        System.out.println("After assigning t1 isDaemon thread is: "+t1.isDaemon());
        System.out.println("Default t1 isAlive thread is: "+t1.isAlive());
        System.out.println("Default t1 isInterrupted thread is: "+t1.isInterrupted());
        System.out.println("name of the current thread is: "+Thread.currentThread());

    }
}