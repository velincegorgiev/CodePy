package com.example.diansspring.web.admin;


import com.example.diansspring.model.*;
import com.example.diansspring.model.enums.Role;
import com.example.diansspring.service.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class AdminController {

    private final PodatociService podatociService;
    private final Podatoci1Service podatoci1Service;
    private final Podatoci2Service podatoci2Service;

    private final UserService userService;

    private final EducationNatureService educationNatureService;
    private final EducationAnimalService educationAnimalService;

    private final VolunteerPeopleInAfricaService volunteerPeopleInAfricaService;
    private final VolunteerSmiljanciService volunteerSmiljanciService;
    private final AdoptBrunoService adoptBrunoService;

    public AdminController(PodatociService podatociService,
                           Podatoci1Service podatoci1Service,
                           Podatoci2Service podatoci2Service,
                           UserService userService,
                           EducationNatureService educationNatureService,
                           EducationAnimalService educationAnimalService,
                           VolunteerPeopleInAfricaService volunteerPeopleInAfricaService,
                           VolunteerSmiljanciService volunteerSmiljanciService,
                           AdoptBrunoService adoptBrunoService) {
        this.podatociService = podatociService;
        this.podatoci1Service = podatoci1Service;
        this.podatoci2Service = podatoci2Service;
        this.userService = userService;
        this.educationNatureService = educationNatureService;
        this.educationAnimalService = educationAnimalService;
        this.volunteerPeopleInAfricaService = volunteerPeopleInAfricaService;
        this.volunteerSmiljanciService = volunteerSmiljanciService;
        this.adoptBrunoService = adoptBrunoService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MOD')")
    public String getAdminPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("errorMessage", error);
        }
        return "admin/admin";
    }

    @GetMapping("/user-list")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MOD')")
    public String getUserListPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("errorMessage", error);
        }

        //adminot samo da gi gleda na lista onie shto NE se admini (mods & users)
        List<User> userList = this.userService
                .listUsers()
                .stream()
                .filter(i -> !i.getRole().equals(Role.ROLE_ADMIN))
                .collect(Collectors.toList());

        model.addAttribute("users", userList);
        return "admin/user-list";
    }

    @GetMapping("/edit-user/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        if (this.userService.findById(id).isPresent()) {
            User u = this.userService.findById(id).get();
            List<Role> roles = List.of(Role.ROLE_USER, Role.ROLE_MOD);

            model.addAttribute("user", u);
            model.addAttribute("roles", roles);
            return "admin/edit-user";
        }
        return "redirect:/admin/user-list?error=UserNotFound";
    }

    @DeleteMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        this.userService.deleteUserById(id);
        return "redirect:/admin/user-list";
    }

    @GetMapping("/natural-reports")
    public String getListOfNaturalReports(
            @RequestParam(required = false) String nameSearch,
            @RequestParam(required = false) String emailSearch,
            @RequestParam(required = false) String error,
            Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("errorMessage", error);
        }
        List<Podatoci> podatoci = this.podatociService.listPodatociByNameAndEmail(nameSearch, emailSearch);
        model.addAttribute("podatoci", podatoci);
        return "admin/natural-report";
    }

    @GetMapping("/animal-reports")
    public String getListOfAnimalReports(
            @RequestParam(required = false) String nameSearch,
            @RequestParam(required = false) String emailSearch,
            Model model) {
        List<Podatoci1> podatoci1 = this.podatoci1Service.listPodatoci1ByNameAndEmail(nameSearch, emailSearch);
        model.addAttribute("podatoci1", podatoci1);
        return "admin/animal-report";
    }

    @GetMapping("/idea-for-projects")
    public String getListOfIdeaForProjects(
            @RequestParam(required = false) String nameSearch,
            @RequestParam(required = false) String emailSearch,
            Model model) {
        List<Podatoci2> podatoci2 = this.podatoci2Service.listPodatoci2ByNameAndEmail(nameSearch, emailSearch);
        model.addAttribute("podatoci2", podatoci2);
        return "admin/idea-for-projects";
    }

    //Edit

    @GetMapping("/edit/{id}")
    public String getEditNaturalReports(@PathVariable Long id, Model model) {
        if (this.podatociService.findById(id).isPresent()) {
            Podatoci p = this.podatociService.findById(id).get();
            model.addAttribute("podatoci", p);
            return "admin/add-podatoci";
        }
        return "redirect:/admin/natural-reports?error=PodatociNotFound";
    }

    @GetMapping("/edit1/{id}")
    public String getEditAnimalReports(@PathVariable Long id, Model model) {
        if (this.podatoci1Service.findById(id).isPresent()) {
            Podatoci1 p = this.podatoci1Service.findById(id).get();
            model.addAttribute("podatoci1", p);
            return "admin/add-podatoci1";
        }
        return "redirect:/admin/animal-reports?error=Podatoci1NotFound";
    }

    @GetMapping("/edit2/{id}")
    public String getEditIdeaForProjects(@PathVariable Long id, Model model) {
        if (this.podatoci2Service.findById(id).isPresent()) {
            Podatoci2 p = this.podatoci2Service.findById(id).get();
            model.addAttribute("podatoci2", p);
            return "admin/add-podatoci2";
        }
        return "redirect:/admin/idea-for-projects?error=Podatoci2NotFound";
    }

    //Delete

    @DeleteMapping("/delete/{id}")
    public String deleteNaturalReport(@PathVariable Long id) {
        this.podatociService.deletePodatociById(id);
        return "redirect:/admin/natural-reports";
    }

    @DeleteMapping("/delete1/{id}")
    public String deleteAnimalReport(@PathVariable Long id) {
        this.podatoci1Service.deletePodatoci1ById(id);
        return "redirect:/admin/animal-reports";
    }

    @DeleteMapping("/delete2/{id}")
    public String deleteIdeaForProject(@PathVariable Long id) {
        this.podatoci2Service.deletePodatoci2ById(id);
        return "redirect:/admin/idea-for-projects";
    }

    //Add

    /**
     * zaso ovie dole na 'edit' ne rabotat ;( maaaaaaa, kje placham xD
     */
    @PostMapping("/add")
    public String savePodatoci(@RequestParam(required = false) Long id,
                               @RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String description,
                               @RequestParam String phoneNumber) {

        if (id != null) {
            this.podatociService.edit(id, name, email, description, phoneNumber);
        } else {
            this.podatociService.save(name, email, description, phoneNumber);
        }

        return "redirect:/admin/natural-reports";
    }


    @PostMapping("/add1")
    public String savePodatoci1(@RequestParam(required = false) Long id,
                                @RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String description,
                                @RequestParam String phoneNumber) {

        if (id != null) {
            this.podatoci1Service.edit(id, name, email, description, phoneNumber);
        } else {
            this.podatoci1Service.save(name, email, description, phoneNumber);
        }

        return "redirect:/admin/animal-reports";
    }

    @PostMapping("/add2")
    public String savePodatoci2(@RequestParam(required = false) Long id,
                                @RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String description,
                                @RequestParam String phoneNumber) {

        if (id != null) {
            this.podatoci2Service.edit(id, name, email, description, phoneNumber);
        } else {
            this.podatoci2Service.save(name, email, description, phoneNumber);
        }

        return "redirect:/admin/idea-for-projects";
    }

    @PostMapping("/update-profile")
    public String updateProfile(@RequestParam(required = false) Long id,
                                @RequestParam String username,
                                @RequestParam String name,
                                @RequestParam String surname,
                                @RequestParam Role role) {
        if (id != null) {
            this.userService.updateUser(id, username, name, surname, role);
        }

        return "redirect:/admin/user-list";
    }


    //Educations

    @GetMapping("/natural-registration-list")
    public String getNaturalRegistrationList(Model model) {
        List<EducationNature> educationNatureUsersList = this.educationNatureService.listAll();
        model.addAttribute("natureUsers",educationNatureUsersList);

        return "admin/natural-education-users";
    }

    @GetMapping("/animals-registration-list")
    public String getAnimalsRegistrationList(Model model) {
        List<EducationAnimals> educationAnimalsUsersList = this.educationAnimalService.listAll();
        model.addAttribute("animalsUsers",educationAnimalsUsersList);

        return "admin/animals-education-users";
    }

    @DeleteMapping("/delete-nature-user/{id}")
    public String deleteNatureUser(@PathVariable Long id) {
        this.educationNatureService.deleteNatureUserById(id);
        return "redirect:/admin/natural-registration-list";
    }

    @DeleteMapping("/delete-animals-user/{id}")
    public String deleteAnimalUser(@PathVariable Long id) {
        this.educationAnimalService.deleteAnimalsUserById(id);
        return "redirect:/admin/animals-registration-list";
    }

    //Volunteers
    @GetMapping("/volunteer-people-in-africa-list")
    public String getVolunteerPeopleInAfricaPage(Model model) {
        List<VolunteerPeopleInAfrica> volunteerPeopleInAfricaList =
                this.volunteerPeopleInAfricaService.listAll();

        model.addAttribute("africaVolunteers",volunteerPeopleInAfricaList);
        return "admin/africa-volunteers";
    }
    @GetMapping("/volunteer-smiljanci-list")
    public String getVolunteerSmiljanciPage(Model model) {
        List<VolunteerSmiljanci> volunteerSmiljanciList =
                this.volunteerSmiljanciService.listAll();

        model.addAttribute("smiljanciVolunteers",volunteerSmiljanciList);
        return "admin/smiljanci-volunteers";
    }

    @DeleteMapping("/delete-smiljanci-user/{id}")
    public String deleteSmiljanciUser(@PathVariable Long id) {
        this.volunteerSmiljanciService.deleteVolunteerSmiljanciUserById(id);

        return "redirect:/admin/volunteer-smiljanci-list";
    }

    @DeleteMapping("/delete-africa-user/{id}")
    public String deleteAfricaUser(@PathVariable Long id) {
        this.volunteerPeopleInAfricaService.deleteVolunteerPeopleInAfricaUserById(id);

        return "redirect:/admin/volunteer-people-in-africa-list";
    }

    //Adoptance - Acceptance [Bruno]

    @GetMapping("/adoptance-bruno-list")
    public String getAcceptanceBrunoPage(Model model) {
        List<AdoptBruno> adoptBrunoList = this.adoptBrunoService.listAll();

        model.addAttribute("acceptanceUsers",adoptBrunoList);

        return "admin/acceptance-bruno-users";
    }

    @DeleteMapping("/delete-acceptance-bruno-user/{id}")
    public String deleteAcceptanceUser(@PathVariable Long id) {
        this.adoptBrunoService.deleteAdoptBrunoUserById(id);

        return "redirect:/admin/adoptance-bruno-list";
    }
}
