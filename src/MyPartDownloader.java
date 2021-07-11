/**
 * Class MainThread
 *
 * @author Bryan Oliver
 * @version 1.6.2021
 */
public class MyPartDownloader extends MyUrl implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            try {
                super.doSomething(i);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
