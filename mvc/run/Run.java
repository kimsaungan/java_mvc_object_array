package run;

import controller.MemberController;
import mvc.model.vo.Member;

public class Run {


    public static void main(String[] args) {

        MemberController memberController = new MemberController();

        memberController.sortldAsc();

    }
}
