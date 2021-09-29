package BookStore;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;

public class User implements Serializable {

    private String userName;
    private String password;
    //private String userId;

    private static int minLengthLogin = 4;
    private static int maxLengthLogin = 12;


    public User() {
        this.userName = RandomStringUtils.randomAlphabetic(minLengthLogin, maxLengthLogin);
        this.password = "Zap*12345";
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
        User.minLengthLogin = minLengthLogin;
    }


    public static int getMaxLengthLogin() {
        return maxLengthLogin;
    }

    public static void setMaxLengthLogin(int maxLengthLogin) {
        User.maxLengthLogin = maxLengthLogin;
    }



    @Override
    public String toString() {
        return "UserAuthorized{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                //", userId='" + userId + '\'' +
                '}';
    }
}
