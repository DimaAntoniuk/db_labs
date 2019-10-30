package ua.lviv.iot;

import ua.lviv.iot.view.MyView;

public class Application {

    public static void main(String[] args) {
        try {
            new MyView().show();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
