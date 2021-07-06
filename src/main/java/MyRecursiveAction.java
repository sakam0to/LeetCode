import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.lang.Thread;
import java.util.logging.Logger;

public class MyRecursiveAction extends RecursiveAction {
    Logger logger = Logger.getLogger(Thread.currentThread().toString());
    final String myString;
    MyRecursiveAction(String input) {
        this.myString = input;

        logger.info(Thread.currentThread() + " processed "+ myString);
    }

    protected void compute() {
        if (myString.length() <= THRESHOLD)
            process(myString);
        else {
            logger.info("Split" + myString);
            String sub1 = myString.substring(0, THRESHOLD);
            String sub2 = myString.substring(THRESHOLD);
            invokeAll(new MyRecursiveAction(sub1),
                    new MyRecursiveAction(sub2));
        }
    }

    static final int THRESHOLD = 10;

    void process(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(input);
        stringBuilder.reverse();
        logger.info("#"+stringBuilder.toString()+"#");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ForkJoinPool pool = new ForkJoinPool();
        System.out.print("Input String: ");
        String myString = scanner.nextLine();
        MyRecursiveAction task =  new MyRecursiveAction(myString);
        pool.invoke(task);
    }
}
