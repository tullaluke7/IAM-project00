import org.springframework.web.bind.annotation.*;
import org.json.*;
import java.nio.file.*;
import java.util.*;

@RestController
public class ProvisionController {

    @GetMapping("/provision")
    public List<User> provision() throws Exception {
        String data = new String(Files.readAllBytes(Paths.get("hr_feed.json")));
        JSONArray arr = new JSONArray(data);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            User u = new User();
            u.setId(obj.getString("id"));
            u.setName(obj.getString("name"));
            u.setDepartment(obj.getString("department"));
            u.setRole(RoleAssigner.assignRole(u.getDepartment()));
            users.add(u);
        }
        return users;
    }
}
