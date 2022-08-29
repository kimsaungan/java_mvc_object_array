package mvc.run;

import mvc.controller.MemberController;
import mvc.model.vo.Member;

public class Run {


    public static void main(String[] args) {

        MemberController memberController = new MemberController();
        //Member[] mem = new Member[3];

        Member[] members={
                new Member("ksa","sak","김성안",27,'M',"pcpcp"),
                new Member("ksa1","sak1","김성안1",27,'M',"pcpcp"),
                new Member("ksa2","sak2","김성안2",27,'M',"pcpcp")
            };


        for(Member m : members) {
            memberController.insertMember(m);
        }

        System.out.println("현재 등록한 회원 수"+memberController.getMemberCount());

        System.out.println(memberController.mem[1].information());
        System.out.println(memberController.mem[2].information());

        memberController.deleteMember("ksa1");
        System.out.println("현재 등록한 회원 수"+memberController.getMemberCount());

        System.out.println(memberController.mem[1].information());
        System.out.println(memberController.mem[2].information());


    }
}
