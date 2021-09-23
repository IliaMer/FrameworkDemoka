package BookStore;

import java.io.Serializable;

public class UserAuthorized implements Serializable {

    private String userName;
    private String password;
    private String userId;

    private static int minLengthPassword = 8;

    public UserAuthorized() {
        this.userName = "Zap";
        this.password = "Zap*12345";
        this.userId = "b46a165f-1b21-49bc-a531-063ebace5a4a";
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

    public static int getMinLengthPassword() {
        return minLengthPassword;
    }

    public static void setMinLengthPassword(int minLengthPassword) {
        UserAuthorized.minLengthPassword = minLengthPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserAuthorized{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
