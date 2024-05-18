package cac.vuelosapi2.controller;

import cac.vuelosapi2.models.Company;
import cac.vuelosapi2.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Optional<Company> findCompanyById(@PathVariable Long id){
        return companyService.findCompanyById(id);
    }

     @PostMapping("/add")
    public void crateCompany(@RequestBody Company company){
        companyService.createCompany(company);
     }

     @DeleteMapping("/delete/{id}")
    public void deleteCompanyById(@PathVariable Long id){
        companyService.deleteCompanyById(id);
     }

     @PutMapping("/update")
    public Optional<Company> updateCompany(@RequestBody Company company) {
        return companyService.updateCompany(company);
     }

}
