package view;

import controller.MemberController;
import mvc.model.vo.Member;
import java.util.Scanner;

public class MemberMenu {

    //Member Ŭ���� ������ ���� �ʵ�� ����
    private MemberController mc =new MemberController();
    private Scanner sc = new Scanner(System.in);

    public void mainMenu(){


        while(true) {
            System.out.println("====== ȸ�� ���� �޴� ======");
            System.out.println("1. �ű� ȸ�� ��� ");
            System.out.println("2. ȸ�� ���� �˻�");
            System.out.println("3. ȸ�� ���� ���� ");
            System.out.println("4. ȸ�� ���� ����");
            System.out.println("5. ȸ�� ���� ���");
            System.out.println("6. ȸ�� ���� ���� ");
            System.out.println("9. ���α׷� ����");
            System.out.println("�޴�����");
            int menu=sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    insertMember();
                    break;
                case 2:
                    searchMember();
                    break;
                case 3:
                    updateMember();
                    break;
                case 4:
                    deleteMember();
                    break;
                case 5:
                    printAllMember();
                    break;
                case 6:
                    sortMember();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("�߸��� �޴� ������ �Ͽ����ϴ�. �ٽ� �������ּ���. ");
            }
        }
        //sc.close();

    }
    public void insertMember(){

        sc.nextLine();
        if (mc.getMemberCount() > mc.SIZE) {
            return;
        }

        System.out.print("���̵� : ");
        String check_Id = sc.nextLine();

        if(mc.checkId(check_Id)!=null){
            System.out.println("������ ���̵� �����մϴ�. ȸ����� ����");
            return ;
        }

        System.out.print("��й�ȣ : ");
        String pw= sc.nextLine();

        System.out.print("�̸� : ");
        String name= sc.nextLine();

        System.out.print("���� : ");
        int age = sc.nextInt();

        sc.nextLine();  // sc.nextLine()�� ���๮�ڸ� �����ϰ�
                        // �� �� next~()�� ���๮�ڸ� �����ϰ� ���� �Է¹޴´�

        System.out.print("���� : ");
        char gen = sc.nextLine().charAt(0);

        System.out.print("�̸��� : ");
        String email = sc.nextLine();

        Member insertmem = new Member(check_Id,pw,name,age,gen,email); //�Է¹��� �����ͷ� ��ü ����
        mc.insertMember(insertmem);  // ������ ��ü�� ȸ�� �迭(memberController�� Member�迭)�� ��ҷ� �߰�

        System.out.println("���������� ȸ�� ����� �Ǿ����ϴ�. ");


    }

    public void searchMember(){

        while(true){
            System.out.println("====== ȸ�� ���� �˻� ======");
            System.out.println("1. ���̵�� �˻��ϱ�");
            System.out.println("2. �̸����� �˻��ϱ�");
            System.out.println("3. �̸��Ϸ� �˻��ϱ�");
            System.out.println("9. ���� �޴���");

            System.out.println("�޴� ���� : ");
            int choice_menu=sc.nextInt();

            sc.nextLine();  // ���� �Է°��� ���๮�ڰ� �ԷµǴ� ���� ����

            if(!(choice_menu==1||choice_menu==2||choice_menu==3||choice_menu==9)){
                System.out.println("�߸��� �޴������� �߽��ϴ�. �ٽ� �Է����ּ���.");

            } else if (choice_menu==9) {
                break;
            } else {

                System.out.println("�˻� ���� :   ");
                String search_data=sc.nextLine();

                Member result_mem = mc.searchMember(choice_menu,search_data);
                if( result_mem==null) {
                    System.out.println("�˻��� ����� �����ϴ�.");
                }else {
                    System.out.println("====== �˻���� ======");
                    System.out.println(result_mem.information());
                }
            }

        }
    }
    public void updateMember(){

        while(true){
            System.out.println("====== ȸ�� ���� �˻� ======");
            System.out.println("1. ��й�ȣ ����");
            System.out.println("2. �̸� ����");
            System.out.println("3. �̸��� ����");
            System.out.println("9. ���� �޴���");

            System.out.println("�޴� ���� : ");
            int choice_menu=sc.nextInt();

            sc.nextLine(); // ���� �Է°��� ���๮�ڰ� �ԷµǴ°��� ����

            if(!(choice_menu==1||choice_menu==2||choice_menu==3||choice_menu==9)){
                System.out.println("�߸��� �޴������� �߽��ϴ�. �ٽ� �Է����ּ���.");

            }else if (choice_menu==9) {
                break;
            }else {  // checkId()�� ���� id�� �����ϴ��� Ȯ��

                System.out.println("������ ȸ�� ���̵� :   ");
                String update_data_id=sc.nextLine();


                if(mc.checkId(update_data_id)==null){
                    System.out.println("������ ȸ���� �������� �ʽ��ϴ�.");
                }else{
                    Member mem= new Member();
                    mem = mc.checkId(update_data_id);

                    System.out.println("==== ���� ȸ�� ���� ====");
                    System.out.println(mem.information());

                    System.out.print("������ ������ �Է����ּ��� : ");
                    String update_data=sc.nextLine();

                    mc.updateMember(mem, choice_menu, update_data);

                    System.out.println("==== ������ ȸ�� ���� ====");
                    System.out.println(mem.information());
                    System.out.println("ȸ���� ������ ����Ǿ����ϴ�.");
                }
            }

        }
    }
    public void deleteMember(){

        System.out.print("������ ���̵� : ");
        String delete_id = sc.nextLine();

        if(mc.checkId(delete_id)==null){
            System.out.println("������ ȸ���� �������� �ʽ��ϴ�.");
            return;
        }else{
            System.out.println("���� �����Ͻðڽ��ϱ�?(y/n)");
            String delete_check=sc.nextLine();
            if(delete_check.equals("y")||delete_check.equals("Y")){
                mc.deleteMember(delete_id);
                System.out.println("ȸ���� ������ �����Ǿ����ϴ�.");
            }else {
                System.out.println("ȸ�� ������ ��ҵǾ����ϴ�.");
            }
        }

    }

    public void printAllMember(){
        Member[] mem = mc.getMem();

        System.out.println("��ü ȸ������ ��ȸ");
        try {
            for (Member m : mem) {
                System.out.println(m.information());
            }
        }catch (NullPointerException e){}

    }

    public void sortMember(){

        Member[] sortMem = null;

        while(true){
            System.out.println("1. ���̵� �������� ���� ");
            System.out.println("2. ���̵� �������� ����");
            System.out.println("3. ���� �������� ����");
            System.out.println("4. ���� �������� ����");
            System.out.println("5. ���� �������� ����(������)");
            System.out.println("9. ���� �޴���");

            System.out.println("�޴� ���� : ");
            int menu = sc.nextInt();

            if(menu==1) {
                sortMem=mc.sortIdAsc();
                System.out.println("== ���̵� �������� ���� ��ȸ ==");
            }
            else if(menu==2) {
                sortMem=mc.sortIdDesc();
                System.out.println("== ���̵� �������� ���� ��ȸ ==");
            }
            else if (menu==3){
                sortMem=mc.sortAgeAsc();
                System.out.println("== ���� �������� ���� ��ȸ ==");
            }
            else if (menu==4){
                sortMem=mc.sortAgeDesc();
                System.out.println("== ���� �������� ���� ��ȭ ==");
            }
            else if (menu==5){
                sortMem=mc.sortGenderDesc();
                System.out.println("== ���� �������� ����(������) ��ȸ ==");
            }
            else if (menu==9) break;

            for (int i = 0; i <mc.getMemberCount() ; i++) {

                System.out.println(sortMem[i].information());
            }
//            for(Member m : sortMem){
//                System.out.println(m.information());
//            }
        }

    }

}
