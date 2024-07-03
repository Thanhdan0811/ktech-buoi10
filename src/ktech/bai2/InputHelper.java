package ktech.bai2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {

    public static int InputInt(String message, Scanner sc) {
        System.out.print(message);
        int luaChon = 0;
        try {
            luaChon = sc.nextInt();
        } catch (InputMismatchException inputErr) {
            return -1;
        }

        return luaChon;
    }

}
