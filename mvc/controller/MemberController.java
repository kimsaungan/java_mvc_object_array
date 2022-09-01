package controller;

import mvc.model.vo.Member;

import java.util.Arrays;

public class MemberController /*implements Cloneable*/{

    public int SIZE=10;  //최대 회원 수
    private static int memberCount=0;
    private Member[] mem = new Member[SIZE];


{
    mem[0] = new Member("user01", "pass01", "김유신", 20, 'M', "kim123@naver.com");
    mem[1] = new Member("user02", "pass02", "이순신", 60, 'M', "lee2@naver.com");
    mem[2] = new Member("user03", "pass03", "유관순", 17, 'F', "yoo55@hanmail.net");
    mem[3] = new Member("user04", "pass04", "연개소문", 57, 'M', "yeon01@gmail.com");
    mem[4] = new Member("user05", "pass05", "신사임당", 45, 'F', "shin89@naver.com");
    memberCount = 5; // 5명의 회원을 추가해놨으니 memberCount도 5로 초기화
}


    public int getMemberCount(){
        return this.memberCount;
    }

    public Member[]  getMem(){
        return mem;
    }

    public Member checkId(String userId){

        Member m=null;

        for(int i=0; i<this.mem.length; i++){
            if(mem[i].getUserId().equals(userId))
                //return mem[i].getUserId();
                m=mem[i];
        }
        return m;
    }

    public void insertMember(Member m){
        this.mem[memberCount]=new Member(m.getUserId(),m.getUserPwd(),m.getName(),m.getAge(),m.getGender(),m.getEmail());
        memberCount++;
    }

    public Member searchMember(int menu, String search){

        Member search_mem = new Member();

        if(menu==1){// foreach문으로도 가능
            for(int i = 0; i<this.mem.length; i++)
                if(mem[i].getUserId().equals(search))
                    search_mem=mem[i];
                    return search_mem;

        }else if(menu==2){
            for(int i = 0; i<this.mem.length; i++)
                if(mem[i].getName().equals(search))
                    search_mem=mem[i];
                    return search_mem;

        }else if(menu==3){
                for(int i = 0; i<this.mem.length; i++)
                    if(mem[i].getEmail().equals(search))
                        search_mem=mem[i];
                        return search_mem;
        }
        System.out.println("메뉴가 잘못 선택되었습니다");
        return search_mem;
    }

    public void updateMember(Member m, int menu, String update){
        if(menu==1){
            m.setUserPwd(update);
        }else if(menu==2){
            m.setName(update);
        }else if(menu==3){
            m.setEmail(update);
        }else{
            System.out.println("메뉴가 잘못 선택되었습니다");
        }
    }
    public void deleteMember(String userId){
        int delete_index = 0;
        for(int i=0; i< memberCount; i++) {
            if (mem[i].getUserId().equals(userId)) {
                delete_index = i;
                memberCount--;
                break;
            }
        }
        System.out.println("delete_index : "+delete_index);
        for(int j=delete_index; j<memberCount; j++)
            this.mem[j] = this.mem[j + 1];  // 찾은 인덱스 값 뒤 인덱스 값들을 한칸씩 이동시켜 덮어쓴다
    }

//    public Object clone(){
//        Object obj = null;
//        try {
//            obj = super.clone();
//        } catch (CloneNotSupportedException e) {
//            //throw new RuntimeException(e);   // try/catch 자동완성구문
//            //Member m =(Member)obj;
//            //m.setUserId();
//        }
//        return (Member)obj;
//    }
    public Member[] sortldAsc(){

        Member[] copy = new Member[memberCount];    // 배열의 값만 복사하는 얕은 복사
//        copy=mem.clone();   // mem 객체 배열을 객체배열로 깊은 복사
//        try {
//            Arrays.sort(copy);    // 깊은 복사한 복사본은 정렬한다
//        }catch (NullPointerException e){}

        System.arraycopy(mem,0, copy,0, memberCount );

        for(int i = 0; i < memberCount; i++){
            for(int j=0 ; j<i; j++){  // copy[i] : 인덱스 순서상 뒤쪽 요소 , copy[j]: 인덱스 순서상 앞 쪽 요소
                if(copy[i].getUserId().compareTo(copy[j].getUserId())<0){ // 뒤쪽 요소가 앞쪽 요소 보다 작으면
                        Member temp = copy[i];     // 자리바꾼다
                        copy[i]= copy[j];
                        copy[j]=temp;
                }
            }
        }
        // 한마디로 참조변수(객체를 가리키는 변수)자체의 hashcode
        System.out.println("mem의 참조변수의  hashcode : "+mem.hashCode());
        System.out.println("copy(참조변수)의  hashcode : "+copy.hashCode());

        // 참조 변수들이 가리키는 객체의 hashcode
        System.out.println("mem의 참조값(주소값)"+mem[0].getName().hashCode());
        System.out.println("copy의 참조값(주소값)"+copy[0].getName().hashCode());

        System.out.println(mem.length);    //10 출력


        for(int i=0; i<memberCount; i++){
            System.out.println("원본:"+mem[i].information());
        }
        for(int i=0; i<memberCount; i++){
            System.out.println("복사본:"+copy[i].information());
        }

        updateMember(copy[1],2,"곽예영");

        for(int i=0; i<memberCount; i++){
            System.out.println("원본:"+mem[i].information());
        }

        for(int i=0; i<memberCount; i++){
            System.out.println("복사본:"+copy[i].information());
        }

        return copy;
    }

    public Member[] sortIdDesc(){
        Member[] copy= new Member[memberCount];

        System.arraycopy(mem,0,copy,0,memberCount);

        for(int i = 0; i < memberCount; i++){
            for(int j=0 ; j<i; j++){  // copy>i] : 인덱스 순서상 뒤쪽 요소 , copy[j]: 인덱스 순서상 앞 쪽 요소
                if(copy[i].getUserId().compareTo(copy[j].getUserId())>0){ // 뒤쪽 요소가 앞쪽 요소 보다 작으면
                    Member temp = copy[i];     // 자리바꾼다
                    copy[i]= copy[j];
                    copy[j]=temp;
                }
            }
        }
        return copy;

    }

    public Member[] sortAgeAsc(){

        Member[] copy = new Member[memberCount];

        System.arraycopy(mem,0,copy,0,memberCount);

        for(int i = 0; i < memberCount; i++){
            for(int j=0 ; j<i; j++){  // copy>i] : 인덱스 순서상 뒤쪽 요소 , copy[j]: 인덱스 순서상 앞 쪽 요소
                if((copy[i].getAge()-copy[j].getAge())<0){ // 뒤쪽 요소가 앞쪽 요소 보다 작으면
                    Member temp = copy[i];     // 자리바꾼다
                    copy[i]= copy[j];
                    copy[j]=temp;
                }
            }
        }

    return copy;
    }

    public Member[] sortAgeDesc(){

        Member[] copy = new Member[memberCount];

        System.arraycopy(mem,0,copy,0,memberCount);

        for(int i = 0; i < memberCount; i++){
            for(int j=0 ; j<i; j++){  // copy>i] : 인덱스 순서상 뒤쪽 요소 , copy[j]: 인덱스 순서상 앞 쪽 요소
                if((copy[i].getAge()-copy[j].getAge())>0){ // 뒤쪽 요소가 앞쪽 요소 보다 작으면
                    Member temp = copy[i];     // 자리바꾼다
                    copy[i]= copy[j];
                    copy[j]=temp;
                }
            }
        }

        return copy;
    }

    public Member[] sortGenderDesc(){
        Member[] copy = new Member[memberCount];

        System.arraycopy(mem,0,copy,0,memberCount);

        for (int i = 0; i <memberCount ; i++) {
            for (int j = 0; j <i ; j++) {
                if(copy[i].getGender()=='M'&&copy[j].getGender()=='F'){ // 'M' 다음에 'F'가 오는 겅우만 순서를 바꾸어주면 됨
                    Member temp = copy[i];
                    copy[i]=copy[j];
                    copy[j]=temp;
                }


            }

        }
        return copy;

    }

















}
