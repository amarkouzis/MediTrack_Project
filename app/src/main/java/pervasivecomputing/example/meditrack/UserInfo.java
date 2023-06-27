package pervasivecomputing.example.meditrack;

public class UserInfo {

    private String userName, userFullname, userAge, userGender, userPassword;

    public UserInfo(){

    }

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserFullname(){
        return userFullname;
    }
    public void setUserFullname(String userFullname){
        this.userFullname = userFullname;
    }

    public String getUserAge(){
        return userAge;
    }
    public void setUserAge(String userAge){
        this.userAge = userAge;
    }

    public String getUserGender(){
        return userGender;
    }
    public void setUserGender(String userGender){
        this.userGender = userGender;
    }

    public String getUserPassword(){
        return userPassword;
    }
    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }

}
