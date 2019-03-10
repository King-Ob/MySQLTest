package Hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  //This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo after the application path
public class MainController {

    @Autowired //this means to get the bean called userRepository
                // which is auto-generated by Sprin, we will use it to handle the data

    private UserRepository userRepository;

    @GetMapping(path="/add") //Map Only Get request
    public @ResponseBody String AddNewUser(@RequestParam String name
                            ,@RequestParam String email) {

        //@ResponseBody means the returned String is the response, not a view name
        //@ResponseParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }
        @GetMapping(path="/all") // get all users
                public @ResponseBody Iterable<User> getAllUsers() {
            //this returns a JSON or XML with the users
              return userRepository.findall();
        }

    }

