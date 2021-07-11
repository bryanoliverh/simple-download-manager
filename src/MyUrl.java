public class MyUrl {
    public synchronized void doSomething(int i) throws Exception {
        if(i % 100 == 0) {
            MainClass.X++;
            System.out.println("File"+ MainClass.X +"Part"+Thread.currentThread().getName() +":"+ (MainClass.X-1) + " MB");
        }
    }
}

