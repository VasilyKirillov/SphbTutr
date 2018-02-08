package contacts.controllers;

import contacts.entities.Address;
import contacts.entities.Company;
import contacts.entities.Office;
import contacts.repositories.CompanyRepository;
import contacts.repositories.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OfficeComtroller {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private OfficeRepository officeRepository;

    @RequestMapping(value = "/office", params = "add", method = RequestMethod.GET)
    public String getAddOffice(@RequestParam("company_id") long companyId, Model model) {
        model.addAttribute("company", companyRepository.findOne(companyId));
        return "office/add";
    }

    @RequestMapping(value = "/office", params = "edit", method = RequestMethod.GET)
    public String getEditOffice(@RequestParam long id, Model model) {
        model.addAttribute("office", officeRepository.findOne(id));
        return "office/edit";
    }

    @RequestMapping(value = "/office", method = RequestMethod.GET)
    public String getViewOffice(@RequestParam long id, Model model) {
        model.addAttribute("office", officeRepository.findOne(id));
        return "office/view";
    }

    @RequestMapping(value = "/office", params = "add", method = RequestMethod.POST)
    public String postAddOffice(@RequestParam long company_id, @RequestParam String name,
            @RequestParam String street, @RequestParam String city,
            @RequestParam String state, @RequestParam String zip) {
        Company company = companyRepository.findOne(company_id);
        Office office = new Office(new Address(street, city, state, zip), company, name);

        office = officeRepository.save(office);
        return "redirect:office?id=" + office.getId();
    }

    @RequestMapping(value = "/office", params = "edit", method = RequestMethod.POST)
    public String postEditOffice(@RequestParam long id, @RequestParam String name,
            @RequestParam String street, @RequestParam String city,
            @RequestParam String state, @RequestParam String zip) {
        Office office = officeRepository.findOne(id);
        Address address = office.getAddress();
        office.setName(name);
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);
        address.setZip(zip);
        officeRepository.save(office);
        return "redirect:office?id=" + office.getId();
    }

    @RequestMapping(value = "/office", params = "delete", method = RequestMethod.POST)
    public String postDeleteOffice(@RequestParam long id, @RequestParam("company_id") long companyId) {
        officeRepository.delete(id);
        return "redirect:company?id=" + companyId;
    }

    public CompanyRepository getCompanyRepository() {
        return companyRepository;
    }

    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public OfficeRepository getOfficeRepository() {
        return officeRepository;
    }

    public void setOfficeRepository(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

}
