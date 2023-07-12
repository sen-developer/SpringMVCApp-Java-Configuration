package am.sen.springcourse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;


@Controller
public class AppController {

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

//        System.out.println(name + " " + surname);
        return "index";
    }

    @GetMapping("/about")
    public String home(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname, Model model) {
        model.addAttribute("message", "name: " + name + ", surname:" + surname);
//        System.out.println(name + " " + surname);
        return "about";
    }

    @GetMapping("/calculator")
    private String calc(@RequestParam(value = "x",required = false) Integer x, @RequestParam(value = "y",required = false) Integer y, @RequestParam(value = "action",required = false) String action, Model model) {

        int actionValue = 0;
        if(x == null || y == null){
            actionValue = 0;
        }else if (action.equalsIgnoreCase("multi")) {
            actionValue = x * y;
        } else if (action.equalsIgnoreCase("addition")) {
            actionValue = x + y;
        } else if (action.equalsIgnoreCase("subtraction")) {
            actionValue = x - y;
        } else if (action.equalsIgnoreCase("division")) {
            actionValue = x / y;
        } else actionValue = 0;
        model.addAttribute("value", actionValue);
        return "calculator";
    }
}
