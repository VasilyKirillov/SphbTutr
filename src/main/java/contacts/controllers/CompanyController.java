package contacts.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import contacts.entities.Company;
import contacts.repositories.CompanyRepository;
import java.util.HashSet;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @RequestMapping(value = "/company", params = "add", method = RequestMethod.GET)
    public String getAddCompany(Model model) {
        return "/company/add";
    }

    @RequestMapping(value = "/company", params = "edit", method = RequestMethod.GET)
    public String getEditCompany(@RequestParam long id, Model model) {
        model.addAttribute("company", companyRepository.findOne(id));
        return "/company/edit";
    }

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public String getViewCompany(@RequestParam long id, Model model) {
        model.addAttribute("company", companyRepository.findOne(id));
        return "/company/view";
    }

    @RequestMapping(value = "/company", params = "add", method = RequestMethod.POST)
    public String postAddCompany(@RequestParam String name) {
        Company company = new Company( new HashSet(), name);
        company = companyRepository.save(company);
        return "redirect:company?id=" + company.getId();
        /* redirect: is used to make redirect instead of forward request */
    }

    @RequestMapping(value = "/company", params = "edit", method = RequestMethod.POST)
    public String postEditCompany(@RequestParam long id, @RequestParam String name) {
        Company company = companyRepository.findOne(id);
        company.setName(name);
        companyRepository.save(company);
        return "redirect:company?id=" + company.getId();
    }

    @RequestMapping(value = "/company", params = "delete", method = RequestMethod.POST)
    public String postDeleteCompany(@RequestParam long id) {
        companyRepository.delete(id);
        return "redirect:contacts";
    }


}
