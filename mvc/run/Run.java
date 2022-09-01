package run;

import controller.MemberController;
import mvc.model.vo.Member;
import view.MemberMenu;

public class Run {


    public static void main(String[] args) {

        MemberMenu memberMenu = new MemberMenu();

        memberMenu.mainMenu();

    }
}
