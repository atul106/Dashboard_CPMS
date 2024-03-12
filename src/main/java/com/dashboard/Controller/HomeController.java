package com.dashboard.Controller;

import com.dashboard.Dao.distinctRepository;
import com.dashboard.Dao.tableRepository;
import com.dashboard.entities.Contact;
import com.dashboard.entities.Cpms;
import com.dashboard.entities.LoginData;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.aspectj.bridge.Message;
import org.jboss.logging.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private tableRepository tableRepository;
    @Autowired
    private distinctRepository distinctRepository;

//    @Autowired
//    private UserRepository userRepository;
//   @GetMapping("/test")
//   @ResponseBody
//    public String test(){
//
//       User user = new User();
//       user.setName("Atul Dubey");
//       user.setEmailString("atul@111gmail.com");
//
//       userRepository.save(user);
//
//       return"working";

    @RequestMapping("/home")
    public String home(Model model){

        model.addAttribute("title","CPMS Dashboard");
        return "home";
    }

    @RequestMapping("/about")
    public String about (Model model){

        model.addAttribute("about","About");
        return "about";
    }

    @RequestMapping("/form")
    public String form (Model model){

//        model.addAttribute("Login","login");
        model.addAttribute("loginData", new LoginData());
        return "form";
    }

    @PostMapping("/home")
    public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result){

        if(result.hasErrors()){

            System.out.println(result);
            return "form";
        }
        System.out.println(loginData);


        return "home";
    }

    @RequestMapping("/bulk")
        public String bulk(){

            return "bulk";
        }

    @RequestMapping("/wb")
    public String wb(){

        return "wb";
    }

    @RequestMapping("/OD")
    public String OD(){

        return "OD";
    }

    @RequestMapping("/PP")
    public String PP(Model m){

        List<Cpms> cpms = this.distinctRepository.findAll();
        Long rowCount =distinctRepository.cpms();

        Long city = distinctRepository.countByCityMumbai();
        m.addAttribute("Cpms2",city);

        m.addAttribute("Cpms1",rowCount);
        m.addAttribute("Cpms",cpms);
        return "PP";
    }
//    @RequestMapping("/RR")
//    public String RR(){
//
//        return "RR";
//    }
    @RequestMapping("/SNA_PJ")
    public String SNA_PJ(){

        return "SNA_PJ";
    }
    @RequestMapping("/SNA_RJ")
    public String SNA_RJ(){

        return "SNA_RJ";
    }

    @RequestMapping("/Nulm")
    public String Nulm(){

        return "Nulm";
    }

    @RequestMapping("/create-entity")
    public String create_entity(){

        return "create-entity";
    }

    @GetMapping("/RR")
    public String RR(Model m){
        m.addAttribute("title","RR");

        List<Contact> contacts=  this.tableRepository.findAll();
        m.addAttribute("contacts",contacts);


        return "RR";
    }

    @RequestMapping("/create-entity-folder")
    public String create_entity_folder(){

        return "create-entity-folder";
    }

    @PostMapping("/create-folder")
    @ResponseBody
    public String createFolder(@RequestParam String folderName) {

        String mainFolderPath = "C:\\Users\\adity\\3D Objects\\";

        // Create the main folder
        File mainFolder = new File(mainFolderPath + folderName);

        // Create the main folder
        if (!mainFolder.exists() && mainFolder.mkdir()) {

            String[] subfolders = {"subfolder1", "subfolder2", "subfolder3"};

            // Create subfolders within the main folder
            for (String subfolderName : subfolders) {
                File subfolder = new File(mainFolder.getPath() + "/" + subfolderName);
                if (!subfolder.exists() && subfolder.mkdir()) {
                    System.out.println("Subfolder created: " + subfolderName);
                } else {
                    System.out.println("Failed to create subfolder: " + subfolderName);
                }
            }
            return "Folder structure created successfully!";
        } else {
            return "Failed to create folder structure!";
        }




}
@GetMapping("/delete/{cId}")
    public String deleteContact(@PathVariable("cId")Integer cId, Model m, HttpSession session){

    Optional<Contact> contactOptional = this.tableRepository.findById(cId);
    Contact contact = contactOptional.get();
    this.tableRepository.delete(contact);

    return "redirect:/RR";

}


}
