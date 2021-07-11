import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class MainClass
 *
 * @author Bryan Oliver
 * @version 1.6.2021
 */
public class MainClass {
    static int X = 0;
    private static int counter;
    private static int threadCounter;
    private static final ArrayList<Thread> thrcollect = new ArrayList<Thread>();
    private static final ArrayList<ObjectDownload> downloadCollection = new ArrayList<ObjectDownload>();

    public static void main(String[] args) {
        System.out.println("Selamat datang di MyDownloadAccelerator.");

        ObjectDownload down1 = new ObjectDownload();
        ObjectDownload down2 = new ObjectDownload();
        ObjectDownload down3 = new ObjectDownload();

        Scanner in = new Scanner(System.in);

        System.out.println("Silakan masukkan URL file 1 yang ingin diunduh:");
        down1.URL = in.nextLine();

        System.out.println("Silakan masukkan URL file 2 (minimal 3 URL untuk memulai proses pengunduhan):");
        down2.URL = in.nextLine();

        System.out.println("Silakan masukkan URL file 3 (minimal 3 URL untuk memulai proses pengunduhan):");
        down3.URL = in.nextLine();

        System.out.println("Mau [T]ambah URL lagi atau [M]ulai proses pengunduhan?");
        String input = in.nextLine();

        down1.filesize = ThreadLocalRandom.current().nextInt(5, 10 + 1);
        down1.awl = 1;
        down2.filesize = ThreadLocalRandom.current().nextInt(5, 10 + 1);
        down2.awl = 2;
        down3.filesize = ThreadLocalRandom.current().nextInt(5, 10 + 1);
        down3.awl = 3;

        downloadCollection.add(down1);
        downloadCollection.add(down2);
        downloadCollection.add(down3);

        for (ObjectDownload download: downloadCollection) {
            int temp = download.filesize;
            int a,b,c;
            if (temp % 3 != 0) {
                a = temp % 3;
                temp -= a;
                if (temp % 2 != 0){
                    b = temp % 2;
                }
                b = temp / 2;
                temp -= b;
                c = temp;
            } else {
                a = temp / 3;
                b = temp / 3;
                c = temp / 3;
            }
            download.arrayint[0] = a;
            download.arrayint[1] = b;
            download.arrayint[2] = c;
            String str = String.format("File %d berukuran %d MB menjadi 3 bagian = %d:%d:%d", download.awl, download.filesize, a, b, c);
            System.out.println(str);
        }

        for (ObjectDownload down: downloadCollection){
            Thread threadTemp = new Thread(() -> {
                for (int bag = 1; bag < 4; bag++){
                    for (int p = 1; p <= down.arrayint[bag - 1]; p++){
                        for (counter = 1; counter < 10000; counter ++) {
                            continue;
                        }
                        String str = String.format("File %d part %d: %d MB", down.awl, bag, p);
                        System.out.println(str);
                    }

                }
            });
            thrcollect.add(threadTemp);
        }
        thrcollect.get(0).start();



    }}