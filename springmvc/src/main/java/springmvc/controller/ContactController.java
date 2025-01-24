package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User;

@Controller
public class ContactController {

	@ModelAttribute
	public void commonDataForModel(Model m) {
		System.out.println("Adding things");
		m.addAttribute("Header", "Krishal Form");
    	m.addAttribute("Desc", "This is the home for learner");
	}
	
    @RequestMapping("/contact")
    public String showForm(Model m) {
    	System.out.println("Doing");
    	m.addAttribute("Header", "Krishal Form");
    	m.addAttribute("Desc", "This is the home for learner");
        return "contact";  // Ensure the view name matches the JSP file name
    }
    
    // Method 3
    @RequestMapping(path = "/processform", method = RequestMethod.POST) // Be default method is GET
    public String handleForm(@ModelAttribute User user, Model model) {
    	System.out.println("Done");
    	model.addAttribute("Header", "Krishal Form");
    	model.addAttribute("Desc", "This is the home for learner");

    	return "success";
    }
}


















/* Working Code 1
 * 
 * @RequestMapping(path = "/processform", method = RequestMethod.POST) // Be
 * default method is GET public String handleForm(
 * 
 * @RequestParam(name = "email", required = false) String userEmail,
 * 
 * @RequestParam("userName") String userName,
 * 
 * @RequestParam("password") String userPassword, Model model) { // String
 * Variable // Method 1
 * 
 * // Method 2 User user = new User(); user.setEmail(userEmail);
 * user.setUserName(userName); user.setPassword(userPassword);
 * System.out.println(user);
 * 
 * 
 * // // Fetching in success.jsp // model.addAttribute("email", userEmail); //
 * model.addAttribute("name", userName); // model.addAttribute("password",
 * userPassword);
 * 
 * model.addAttribute("user", user); return "success"; }
 */
























/*
 * Working Code 2 package springmvc.controller;
 * 
 * import org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import springmvc.model.User;
 * 
 * @Controller public class ContactController {
 * 
 * @RequestMapping("/contact") public String showForm() { return "contact"; //
 * Ensure the view name matches the JSP file name }
 * 
 * // Method 3
 * 
 * @RequestMapping(path = "/processform", method = RequestMethod.POST) // Be
 * default method is GET public String handleForm(@ModelAttribute User user,
 * Model model) {
 * 
 * 
 * 
 * return "success"; } }
 */