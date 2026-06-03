import java.util.HashMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Map;

public class IDandPasswords {
    
    HashMap<String,String> loginInfo = new HashMap<String,String>();

    IDandPasswords(){
        

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("try.json"))
        {
            Object obj = jsonParser.parse(reader);
            org.json.simple.JSONArray userList = (org.json.simple.JSONArray) obj;

            for (Object userObj : userList) {
                JSONObject userJson = (JSONObject) userObj;
                String username = (String) userJson.get("username");
                String password = (String) userJson.get("password");
                loginInfo.put(username, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected HashMap getLoginInfo() {
        return loginInfo;
    }
}
