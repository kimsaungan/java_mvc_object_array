package controller;

import mvc.model.vo.Member;

import java.util.Arrays;

public class MemberController /*implements Cloneable*/{

    public int SIZE=10;  //�ִ� ȸ�� ��
    private static int memberCount=0;
    private Member[] mem = new Member[SIZE];


{
    mem[0] = new Member("user01", "pass01", "������", 20, 'M', "kim123@naver.com");
    mem[1] = new Member("user02", "pass02", "�̼���", 60, 'M', "lee2@naver.com");
    mem[2] = new Member("user03", "pass03", "������", 17, 'F', "yoo55@hanmail.net");
    mem[3] = new Member("user04", "pass04", "�����ҹ�", 57, 'M', "yeon01@gmail.com");
    mem[4] = new Member("user05", "pass05", "�Ż��Ӵ�", 45, 'F', "shin89@naver.com");
    memberCount = 5; // 5���� ȸ���� �߰��س����� memberCount�� 5�� �ʱ�ȭ
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

        if(menu==1){// foreach�����ε� ����
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
        System.out.println("�޴��� �߸� ���õǾ����ϴ�");
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
            System.out.println("�޴��� �߸� ���õǾ����ϴ�");
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
            this.mem[j] = this.mem[j + 1];  // ã�� �ε��� �� �� �ε��� ������ ��ĭ�� �̵����� �����
    }

//    public Object clone(){
//        Object obj = null;
//        try {
//            obj = super.clone();
//        } catch (CloneNotSupportedException e) {
//            //throw new RuntimeException(e);   // try/catch �ڵ��ϼ�����
//            //Member m =(Member)obj;
//            //m.setUserId();
//        }
//        return (Member)obj;
//    }
    public Member[] sortldAsc(){

        Member[] copy = new Member[memberCount];    // �迭�� ���� �����ϴ� ���� ����
//        copy=mem.clone();   // mem ��ü �迭�� ��ü�迭�� ���� ����
//        try {
//            Arrays.sort(copy);    // ���� ������ ���纻�� �����Ѵ�
//        }catch (NullPointerException e){}

        System.arraycopy(mem,0, copy,0, memberCount );

        for(int i = 0; i < memberCount; i++){
            for(int j=0 ; j<i; j++){  // copy[i] : �ε��� ������ ���� ��� , copy[j]: �ε��� ������ �� �� ���
                if(copy[i].getUserId().compareTo(copy[j].getUserId())<0){ // ���� ��Ұ� ���� ��� ���� ������
                        Member temp = copy[i];     // �ڸ��ٲ۴�
                        copy[i]= copy[j];
                        copy[j]=temp;
                }
            }
        }
        // �Ѹ���� ��������(��ü�� ����Ű�� ����)��ü�� hashcode
        System.out.println("mem�� ����������  hashcode : "+mem.hashCode());
        System.out.println("copy(��������)��  hashcode : "+copy.hashCode());

        // ���� �������� ����Ű�� ��ü�� hashcode
        System.out.println("mem�� ������(�ּҰ�)"+mem[0].getName().hashCode());
        System.out.println("copy�� ������(�ּҰ�)"+copy[0].getName().hashCode());

        System.out.println(mem.length);    //10 ���


        for(int i=0; i<memberCount; i++){
            System.out.println("����:"+mem[i].information());
        }
        for(int i=0; i<memberCount; i++){
            System.out.println("���纻:"+copy[i].information());
        }

        updateMember(copy[1],2,"������");

        for(int i=0; i<memberCount; i++){
            System.out.println("����:"+mem[i].information());
        }

        for(int i=0; i<memberCount; i++){
            System.out.println("���纻:"+copy[i].information());
        }

        return copy;
    }

    public Member[] sortIdDesc(){
        Member[] copy= new Member[memberCount];

        System.arraycopy(mem,0,copy,0,memberCount);

        for(int i = 0; i < memberCount; i++){
            for(int j=0 ; j<i; j++){  // copy>i] : �ε��� ������ ���� ��� , copy[j]: �ε��� ������ �� �� ���
                if(copy[i].getUserId().compareTo(copy[j].getUserId())>0){ // ���� ��Ұ� ���� ��� ���� ������
                    Member temp = copy[i];     // �ڸ��ٲ۴�
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
            for(int j=0 ; j<i; j++){  // copy>i] : �ε��� ������ ���� ��� , copy[j]: �ε��� ������ �� �� ���
                if((copy[i].getAge()-copy[j].getAge())<0){ // ���� ��Ұ� ���� ��� ���� ������
                    Member temp = copy[i];     // �ڸ��ٲ۴�
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
            for(int j=0 ; j<i; j++){  // copy>i] : �ε��� ������ ���� ��� , copy[j]: �ε��� ������ �� �� ���
                if((copy[i].getAge()-copy[j].getAge())>0){ // ���� ��Ұ� ���� ��� ���� ������
                    Member temp = copy[i];     // �ڸ��ٲ۴�
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
                if(copy[i].getGender()=='M'&&copy[j].getGender()=='F'){ // 'M' ������ 'F'�� ���� �Ͽ츸 ������ �ٲپ��ָ� ��
                    Member temp = copy[i];
                    copy[i]=copy[j];
                    copy[j]=temp;
                }


            }

        }
        return copy;

    }

















}
