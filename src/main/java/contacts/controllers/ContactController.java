package contacts.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import contacts.repositories.ContactRepository;
import org.springframework.ui.Model;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String getContactList(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        return "contact/list";
        /* instead of getting requestDispatcher and forward request , just return the name of the view
        in spring-servlet.xml we define InternalResourceViewResolver bean which has properties :
        prefix and suffix which added to the name of the view so it would be  /view/contact/list.jsp */
    }
    
}
