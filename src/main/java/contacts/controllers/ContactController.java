package contacts.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public String getContactList(Model model){
        model.addAttribute("contacts", contactRepository.findAll());
        return "contact/list"; 
        /* instead of getting requestDispatcher and forward request , just return the name of the view
        in spring-servlet.xml we define InternalResourceViewResolver bean which has properties :
        prefix and suffix which added to the name of the view so it would be  /view/contact/list.jsp */
    }
    
    //    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
//    public void getContactList(HttpServletRequest request, HttpServletResponse response)
//            throws IOException, ServletException {
//
//        request.setAttribute("contacts", contactRepository.findAll());
//        RequestDispatcher view = request.getRequestDispatcher("view/contact/list.jsp");
//        view.forward(request, response);
//    }
    
    @RequestMapping(value = "/contact", params = "add", method = RequestMethod.GET) 
    public String getAddContact(Model model){
        return "/contact/add";
    }
    @RequestMapping(value = "/contact", params = "edit", method = RequestMethod.GET) 
    public String getEditContact(@RequestParam long id, Model model){
        model.addAttribute("contact", contactRepository.findOne(id));
        return "/contact/edit";
    }
    @RequestMapping(value = "/contact", method = RequestMethod.GET) 
    public String getViewContact(@RequestParam long id, Model model){
        model.addAttribute("contact", contactRepository.findOne(id));
        return "/contact/view";
    }
    
//    @RequestMapping(value = "/contact", method = RequestMethod.GET)
//    protected void getContact(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        if (request.getParameter("add") != null) {
//            request.getRequestDispatcher("view/contact/add.jsp")
//                    .forward(request, response);
//        } else {
//            // get contact id from request parameter, and populate model
//            // with the contact and address objects
//            long id = Long.parseLong(request.getParameter("id"));
//            Contact contact = contactRepository.findOne(id);
//            request.setAttribute("contact", contact);
//
//            // dispatch either to the edit page or to the view page
//            if (request.getParameter("edit") != null) {
//                request.getRequestDispatcher("view/contact/edit.jsp")
//                        .forward(request, response);
//            } else {
//                request.getRequestDispatcher("view/contact/view.jsp")
//                        .forward(request, response);
//            }
//        }
//    }
    
    
    
    
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    protected void postContact(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("add") != null) {
            // create new contact and address from form parameters, and
            // persist
            Address address = new Address(request.getParameter("street"),
                    request.getParameter("city"),
                    request.getParameter("state"),
                    request.getParameter("zip"));
            Contact contact = new Contact(request.getParameter("name"), address);
            contact = contactRepository.save(contact);

            // redirect to contact view page
            response.sendRedirect("contact?id=" + contact.getId());

        } else if (request.getParameter("edit") != null) {

            // look up existing contact and address, edit fields and persist
            long id = Long.parseLong(request.getParameter("id"));
            Contact contact = contactRepository.findOne(id);
            Address address = contact.getAddress();
            contact.setName(request.getParameter("name"));
            address.setStreet(request.getParameter("street"));
            address.setCity(request.getParameter("city"));
            address.setState(request.getParameter("state"));
            address.setZip(request.getParameter("zip"));
            contactRepository.save(contact);

            // redirect to contact view page
            response.sendRedirect("contact?id=" + contact.getId());
        } else if (request.getParameter("delete") != null) {
            // look up existing contact, and delete
            long id = Long.parseLong(request.getParameter("id"));
            Contact contact = contactRepository.findOne(id);
            contactRepository.delete(contact);

            // redirect to contact list page
            response.sendRedirect("contacts");
        }
    }
}
