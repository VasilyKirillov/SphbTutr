package contacts.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import contacts.entities.Address;
import contacts.entities.Contact;
import contacts.repositories.ContactRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/contact", params = "add", method = RequestMethod.GET)
    public String getAddContact(Model model) {
        return "/contact/add";
    }

    @RequestMapping(value = "/contact", params = "edit", method = RequestMethod.GET)
    public String getEditContact(@RequestParam long id, Model model) {
        model.addAttribute("contact", contactRepository.findOne(id));
        return "/contact/edit";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String getViewContact(@RequestParam long id, Model model) {
        model.addAttribute("contact", contactRepository.findOne(id));
        return "/contact/view";
    }


    @RequestMapping(value = "/contact", params = "add", method = RequestMethod.POST)
    public String postAddContact(@RequestParam String name, @RequestParam String street,
            @RequestParam String city, @RequestParam String state, @RequestParam String zip) {
        Contact contact = null;//new Contact(name, new Address(street, city, state, zip));
        contact = contactRepository.save(contact);
        return "redirect:contact?id=" + contact.getId();
        /* redirect: is used to make redirect instead of forward request */
    }

    @RequestMapping(value = "/contact", params = "edit", method = RequestMethod.POST)
    public String postEditContact(@RequestParam long id, @RequestParam String name, @RequestParam String street,
            @RequestParam String city, @RequestParam String state, @RequestParam String zip) {
        Contact contact = contactRepository.findOne(id);
        Address address = null;//contact.getAddress();
        contact.setName(name);
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);
        address.setZip(zip);
        contactRepository.save(contact);
        return "redirect:contact?id=" + contact.getId();
    }

    @RequestMapping(value = "/contact", params = "delete", method = RequestMethod.POST)
    public String postDeleteContact(@RequestParam long id) {
        contactRepository.delete(id);
        return "redirect:contacts";
    }


}
