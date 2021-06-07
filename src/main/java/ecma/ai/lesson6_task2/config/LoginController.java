package ecma.ai.lesson6_task2.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

        @RequestMapping("/user")
        public String showUserMsg()
        {
            return "User has logged in!!!";

        }

        @RequestMapping("/admin")
        public String showAdminMsg()
        {
            return "Admin has logged in!!!";
        }

}
