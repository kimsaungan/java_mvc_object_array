package mvc.controller;

import mvc.model.vo.Member;

public class MemberController {

    private int SIZE=10;  //�ִ� ȸ�� ��
    private static int memberCount=0;
    public Member[] mem = new Member[SIZE];


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
        if(menu==1){// foreach�����ε� ����
            for(int i = 0; i<this.mem.length; i++)
                if(mem[i].getUserId().equals(search))
                    return mem[i];

        }else if(menu==2){
            for(int i = 0; i<this.mem.length; i++)
                if(mem[i].getName().equals(search))
                    return mem[i];


        }else if(menu==3){
                for(int i = 0; i<this.mem.length; i++)
                    if(mem[i].getEmail().equals(search))
                        return mem[i];
        }
        System.out.println("�޴��� �߸� ���õǾ����ϴ�");
        return null;
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

    //public Member[] sortldAsc(){

    //}

}
