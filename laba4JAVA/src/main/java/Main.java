import java.io.*;
import java.util.*;
import java.util.concurrent.locks.*;



public class Main {

    public static void main(String[] args) throws Exception {
        //задаём три читателя
        String[] sarr = { "Вася", "Коля", "Петя" };
        ThreadReader[] trs = new ThreadReader[3];
        for(int i = 0; i < trs.length; ++i)
            trs[i] = new ThreadReader(sarr[i]);

        //задаём два писателя
        String[] sarr1 = { "Дмитрий", "Валентин" };
        ThreadWriter[] tws = new ThreadWriter[2];
        for(int i = 0; i < tws.length; ++i)
            tws[i] = new ThreadWriter(sarr1[i]);

        //для выхода enter
        System.in.read();
        for(ThreadReader r : trs)
            r.quit();
        for(ThreadWriter w : tws)
            w.quit();
    }
}