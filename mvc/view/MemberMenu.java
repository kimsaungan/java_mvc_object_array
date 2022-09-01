package view;

import controller.MemberController;
import mvc.model.vo.Member;
import java.util.Scanner;

public class MemberMenu {

    //Member 클래스 접근을 위해 필드로 선언
    private MemberController mc =new MemberController();
    private Scanner sc = new Scanner(System.in);

    public void mainMenu(){


        while(true) {
            System.out.println("====== 회원 관리 메뉴 ======");
            System.out.println("1. 신규 회원 등록 ");
            System.out.println("2. 회원 정보 검색");
            System.out.println("3. 회원 정보 수정 ");
            System.out.println("4. 회원 정보 삭제");
            System.out.println("5. 회원 정보 출력");
            System.out.println("6. 회원 정보 정렬 ");
            System.out.println("9. 프로그램 종료");
            System.out.println("메뉴선택");
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
                    System.out.println("잘못된 메뉴 선택을 하였습니다. 다시 선택해주세요. ");
            }
        }
        //sc.close();

    }
    public void insertMember(){

        sc.nextLine();
        if (mc.getMemberCount() > mc.SIZE) {
            return;
        }

        System.out.print("아이디 : ");
        String check_Id = sc.nextLine();

        if(mc.checkId(check_Id)!=null){
            System.out.println("동일한 아이디가 존재합니다. 회원등록 실패");
            return ;
        }

        System.out.print("비밀번호 : ");
        String pw= sc.nextLine();

        System.out.print("이름 : ");
        String name= sc.nextLine();

        System.out.print("나이 : ");
        int age = sc.nextInt();

        sc.nextLine();  // sc.nextLine()은 개행문자를 포함하고
                        // 그 외 next~()은 개행문자를 무시하고 값만 입력받는다

        System.out.print("성별 : ");
        char gen = sc.nextLine().charAt(0);

        System.out.print("이메일 : ");
        String email = sc.nextLine();

        Member insertmem = new Member(check_Id,pw,name,age,gen,email); //입력받은 데이터로 객체 생성
        mc.insertMember(insertmem);  // 생선된 객체를 회원 배열(memberController의 Member배열)의 요소로 추가

        System.out.println("성공적으로 회원 등록이 되었습니다. ");


    }

    public void searchMember(){

        while(true){
            System.out.println("====== 회원 정보 검색 ======");
            System.out.println("1. 아이디로 검색하기");
            System.out.println("2. 이름으로 검색하기");
            System.out.println("3. 이메일로 검색하기");
            System.out.println("9. 이전 메뉴로");

            System.out.println("메뉴 선택 : ");
            int choice_menu=sc.nextInt();

            sc.nextLine();  // 다음 입력값에 개행문자가 입력되는 것을 방지

            if(!(choice_menu==1||choice_menu==2||choice_menu==3||choice_menu==9)){
                System.out.println("잘못된 메뉴선택을 했습니다. 다시 입력해주세요.");

            } else if (choice_menu==9) {
                break;
            } else {

                System.out.println("검색 내용 :   ");
                String search_data=sc.nextLine();

                Member result_mem = mc.searchMember(choice_menu,search_data);
                if( result_mem==null) {
                    System.out.println("검색된 결과가 없습니다.");
                }else {
                    System.out.println("====== 검색결과 ======");
                    System.out.println(result_mem.information());
                }
            }

        }
    }
    public void updateMember(){

        while(true){
            System.out.println("====== 회원 정보 검색 ======");
            System.out.println("1. 비밀번호 수정");
            System.out.println("2. 이름 수정");
            System.out.println("3. 이메일 수정");
            System.out.println("9. 이전 메뉴로");

            System.out.println("메뉴 선택 : ");
            int choice_menu=sc.nextInt();

            sc.nextLine(); // 다음 입력값에 개행문자가 입력되는것을 방지

            if(!(choice_menu==1||choice_menu==2||choice_menu==3||choice_menu==9)){
                System.out.println("잘못된 메뉴선택을 했습니다. 다시 입력해주세요.");

            }else if (choice_menu==9) {
                break;
            }else {  // checkId()을 통해 id가 존재하는지 확인

                System.out.println("변경할 회원 아이디 :   ");
                String update_data_id=sc.nextLine();


                if(mc.checkId(update_data_id)==null){
                    System.out.println("변경할 회원이 존재하지 않습니다.");
                }else{
                    Member mem= new Member();
                    mem = mc.checkId(update_data_id);

                    System.out.println("==== 기존 회원 정보 ====");
                    System.out.println(mem.information());

                    System.out.print("수정할 내용을 입력해주세요 : ");
                    String update_data=sc.nextLine();

                    mc.updateMember(mem, choice_menu, update_data);

                    System.out.println("==== 수정한 회원 정보 ====");
                    System.out.println(mem.information());
                    System.out.println("회원의 정보가 변경되었습니다.");
                }
            }

        }
    }
    public void deleteMember(){

        System.out.print("삭제할 아이디 : ");
        String delete_id = sc.nextLine();

        if(mc.checkId(delete_id)==null){
            System.out.println("삭제할 회원이 존재하지 않습니다.");
            return;
        }else{
            System.out.println("정말 삭제하시겠습니까?(y/n)");
            String delete_check=sc.nextLine();
            if(delete_check.equals("y")||delete_check.equals("Y")){
                mc.deleteMember(delete_id);
                System.out.println("회원의 정보가 삭제되었습니다.");
            }else {
                System.out.println("회원 삭제가 취소되었습니다.");
            }
        }

    }

    public void printAllMember(){
        Member[] mem = mc.getMem();

        System.out.println("전체 회원정보 조회");
        try {
            for (Member m : mem) {
                System.out.println(m.information());
            }
        }catch (NullPointerException e){}

    }

    public void sortMember(){

        Member[] sortMem = null;

        while(true){
            System.out.println("1. 아이디 오름차순 정렬 ");
            System.out.println("2. 아이디 내림차순 정렬");
            System.out.println("3. 나이 오름차순 정렬");
            System.out.println("4. 나이 내림차순 정렬");
            System.out.println("5. 성별 내림차순 정렬(남여순)");
            System.out.println("9. 이전 메뉴로");

            System.out.println("메뉴 선택 : ");
            int menu = sc.nextInt();

            if(menu==1) {
                sortMem=mc.sortIdAsc();
                System.out.println("== 아이디 오름차순 정렬 조회 ==");
            }
            else if(menu==2) {
                sortMem=mc.sortIdDesc();
                System.out.println("== 아이디 내림차순 정렬 조회 ==");
            }
            else if (menu==3){
                sortMem=mc.sortAgeAsc();
                System.out.println("== 나이 오름차순 정렬 조회 ==");
            }
            else if (menu==4){
                sortMem=mc.sortAgeDesc();
                System.out.println("== 나이 내림차순 정렬 조화 ==");
            }
            else if (menu==5){
                sortMem=mc.sortGenderDesc();
                System.out.println("== 성별 내림차순 정렬(남여순) 조회 ==");
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
