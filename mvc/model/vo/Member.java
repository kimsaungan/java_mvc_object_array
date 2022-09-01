package mvc.model.vo;

public class Member implements Comparable<Member>{

    private String userId;
    private String userPwd;
    private String name;
    private int age;
    private char gender;
    private String email;


    // 기본생성자 선언
    public Member(){}

    public Member(String userId, String userPwd, String name,int age, char gender, String email){
        this.userId=userId;
        this.userPwd= userPwd;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.email=email;
    }

    public String information(){
        return "userId : "+userId+", userPwd : "+userPwd+", name : "+name+", age : "+age+
                ", gender : "+gender+", email : "+email;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Member m) {
        //return (this.userId.compareTo(m.userId));
        return (m.userId.compareTo(this.userId));
    }

}
