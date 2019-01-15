package yarrou.app;

import java.util.Scanner;

public  class DaIliNet {
    public  boolean dailinet(String vvoddailinet) {//метод,проверяющий является ли ответ да или нет
        String da = "да";
        String net = "нет";
        while (((vvoddailinet.equals(da)) || (vvoddailinet.equals(net))) != true) {
            Scanner inputdailinet = new Scanner(System.in);
            System.out.println("введите только да или нет");
            vvoddailinet = inputdailinet.nextLine();
        }
        if (vvoddailinet.equals(da)) {
            return true;
        } else {
            return false;
        }
    }
}
