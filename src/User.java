public class User {

    private final String bankcard_number;
    private final String password;
    private int funds;
    private final String user_name;

    public User(String bankcard_number, String user_password, String user_name, int user_funds) {
        this.user_name = user_name;
        this.bankcard_number = bankcard_number;
        this.password = user_password;
        this.funds = user_funds;
    }

    public String getBankcard_number() {
        return bankcard_number;
    }

    public String getPassword() {
        return password;
    }

    public int getFunds() {
        return funds;
    }
    public String getName() {
        return user_name;
    }
    public void setFunds(int fund){
        funds = fund;
    }

    public String getInfo(){
        return bankcard_number + " " + password + " " + user_name + " " + funds;
    }

}
