package BookStore;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;

public class UserAuthorized implements Serializable {

    private String userName;
    private String password;
    //private String userId;

    private static int minLengthLogin = 8;
    private static int maxLengthLogin = 12;


    public UserAuthorized() {
        //this.userName = RandomStringUtils.randomAlphabetic(minLengthLogin, maxLengthLogin);
        this.userName = "qlnskBeR";
        this.password = "Zap*12345";
        //this.userId = "b46a165f-1b21-49bc-a531-063ebace5a4a";
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getMinLengthLogin() {
        return minLengthLogin;
    }

    public static void setMinLengthLogin(int minLengthLogin) {
        UserAuthorized.minLengthLogin = minLengthLogin;
    }


    public static int getMaxLengthLogin() {
        return maxLengthLogin;
    }

    public static void setMaxLengthLogin(int maxLengthLogin) {
        UserAuthorized.maxLengthLogin = maxLengthLogin;
    }

    //    public String getUserId() {
//        return userId;
//    }

//    public void setUserId(String userId) {
//        this.userId = userId;
//    }

    @Override
    public String toString() {
        return "UserAuthorized{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                //", userId='" + userId + '\'' +
                '}';
    }
}
