import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SData {
    public static String buffer  = "Поставьте 4 за экзамен, Максим Вячеславович";
    public static final ReadWriteLock lrw = new ReentrantReadWriteLock();
}
