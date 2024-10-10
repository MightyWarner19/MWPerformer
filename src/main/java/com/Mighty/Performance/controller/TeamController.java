package com.Mighty.Performance.controller;

import com.Mighty.Performance.dto.EmployeeDto;
import com.Mighty.Performance.dto.TeamDto;
import com.Mighty.Performance.service.TeamService;
import com.Mighty.Performance.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin-page/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserDetailsService userDetailsService;

    // Display all teams and form to add a new team
    @GetMapping
    public String teamPage(Model model, Principal principal) {
        // Load user details and add to model
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);

        // Adding team data to the model
        List<TeamDto> teams = teamService.getAllTeams();
//        System.out.println("Teams Data: " + teams); // Debugging output
        model.addAttribute("team", new TeamDto());
        model.addAttribute("teams", teams);

        // Adding employee data (for assigning employees by their emails)
        List<EmployeeDto> employees = employeeService.getAllEmployees();
//        System.out.println("Employees Data: " + employees); // Debugging output
        model.addAttribute("employees", employees);

        return "/sneat-1.0.0/html/teams";  // Ensure this path matches the actual template location
    }

    // Add or update a team
    @PostMapping
    public String addOrUpdateTeam(@ModelAttribute TeamDto teamDto, Model model) {
        // Save the team information (add or update logic)
        try {
            // Here teamDto should already contain employee emails
            System.out.println("Saving Team: " + teamDto); // Debugging output
            teamService.saveTeam(teamDto);
        } catch (Exception e) {
            model.addAttribute("error", "Error saving the team: " + e.getMessage());
            return "/sneat-1.0.0/html/teams";  // Return to the same page if there's an error
        }
        return "redirect:/admin-page/teams";  // Redirect on successful operation
    }

    // Delete a team by ID
    @PostMapping("/delete/{id}")
    public String deleteTeam(@PathVariable("id") String teamId, Model model) {
        try {
            teamService.deleteTeam(teamId);
        } catch (Exception e) {
            model.addAttribute("error", "Error deleting the team: " + e.getMessage());
            return "/sneat-1.0.0/html/teams";  // Return to the same page if there's an error
        }
        return "redirect:/admin-page/teams";  // Redirect after successful deletion
    }
}
