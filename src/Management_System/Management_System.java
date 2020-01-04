package Management_System;

import Management_System.UI.Window;

public class Management_System {
    private static Window window;

    public static void main(String[] args){
//        Branches br = new Branches();
//        System.out.println(br.branch(1, null));
////        br.addBranch("season city", "jakarta");
//        System.out.println(br.branch(2, null));

        window = new Window();
    }

    public static Window getWindow() {
        return window;
    }
}
