import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderDataFromFile {

    private static final ArrayList<User> users = new ArrayList<>();
    private static BufferedReader bufferedReader;

    public void read(String nameFile){
        try {
            File file = new File(nameFile);
            if (!file.exists()){
                throw new IOException("File with data not exist!");
            }

            bufferedReader = new BufferedReader(new FileReader(nameFile));
            String line;
            ArrayList<String> data = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null){
                data.addAll(List.of(line.split(" ")));
            }

            for (int i = 0; i < data.size(); i+=4) {
                users.add(new User(data.get(i),
                        data.get(i+1),
                        data.get(i+2),
                        Integer.parseInt(data.get(i+3))));
            }
            bufferedReader.close();
        } catch (IOException | NullPointerException exception){
            System.out.println("Error -> " + exception.getMessage());
        }
    }

    public int authenticationData(String card_number, String password){
        for(User user: users){
            if (user.getBankcard_number().equals(card_number) &&
            user.getPassword().equals(password)){
                return user.getFunds();
            }
        }
        return -1;
    }

    public void setFunds(String card_number, String password, int funds){
        for(User user: users){
            if (user.getBankcard_number().equals(card_number) &&
                    user.getPassword().equals(password)){
                user.setFunds(funds);
            }
        }
    }

    public User getUser(int i){
        return users.get(i);
    }

    public int sizeUserList(){
        return users.size()/2;
    }
}
