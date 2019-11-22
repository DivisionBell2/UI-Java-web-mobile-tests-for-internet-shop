package testData;

public enum User {
    SOCIAL_LOGIN("+79154778791"),
    SOCIAL_PASS("147147@"),
    FULLNAME("Иван Петрович Сидоров"),
    NAME("Иван"),
    SURNAME("Петрович"),
    LASTNAME("Сидоров"),
    PASS("123456789"),
    PHONE("9992222222");

    private String userInfo;

    User(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getValue() {
        return userInfo;
    }
}
