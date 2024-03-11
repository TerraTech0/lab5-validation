package com.example.lab5.Projects.Controller;

import com.example.lab5.Projects.Api.ApiResponse;
import com.example.lab5.Projects.Model.Project;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v2/project")
public class ProjectController {

    ArrayList<Project> projects = new ArrayList<>();

    @GetMapping("/show-projects")
//    public ArrayList<Project> showProjects(){
//        return projects;
//    }
    public ResponseEntity showProjects() {
        return ResponseEntity.status(200).body(projects);
    }


    @PostMapping("/add")
//    public ApiResponse addProject(@RequestBody Project proj){
//        projects.add(proj);
//        return new ApiResponse("project added successfully");
//    }
    public ResponseEntity addProject(@RequestBody @Valid Project proj, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        projects.add(proj);
        return ResponseEntity.status(200).body(new ApiResponse("Project added successfully"));
    }

    @PutMapping("/update/{index}")
//    public ApiResponse updateProject(@PathVariable int index, @RequestBody Project proj){
//        projects.set(index, proj);
//        return new ApiResponse("Project updated successfully");
//    }

    public ResponseEntity updateProject(@PathVariable int index, @RequestBody @Valid Project proj, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        projects.set(index, proj);
        return ResponseEntity.status(200).body(new ApiResponse("Project updated successfully!"));
    }

    @DeleteMapping("/delete/{index}")
//    public ApiResponse deleteProject(@PathVariable int index){
//        projects.remove(index);
//        return new ApiResponse("Porjcet deleted succssfully");
//    }
    public ResponseEntity deleteProject(@PathVariable int index) {
        projects.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("project deleted successfully!"));
    }

    //==============================================================
    //change status
    //requiered more search about validation pattern!!
    @PostMapping("/change-status/{id}")
//    public ApiResponse changeStatus(@PathVariable String id){
//        for (Project project : projects){
//            if (project.getID().equals(id)){
//                project.setStatus(!project.isStatus());
//                return new ApiResponse("Status Changed");
//            }
//        }
//        return new ApiResponse("Porject not found!");
//    }
    public ResponseEntity changeStatus(@PathVariable String id, @RequestBody String status) {
        for (Project project : projects) {
            if (project.getID().equals(id)) {
                project.setStatus(status);
                return ResponseEntity.status(200).body(new ApiResponse("Status Changed"));
            }
        }
        return ResponseEntity.status(400).body(new ApiResponse("Project not found!"));
    }
    //==============================================================

    //search for title
    @GetMapping("/search/{title}")
//    public ArrayList<Project> search(@PathVariable String title){
//        ArrayList<Project> res = new ArrayList<>();
//        for (Project project : projects){
//            if (project.getTitle().equalsIgnoreCase(title)){
//                res.add(project);
//            }
//        }
//        return res;
//    }
    public ResponseEntity search(@PathVariable @Valid String title, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        ArrayList<Project> res = new ArrayList<>();
        for (Project project : projects) {
            if (project.getTitle().equalsIgnoreCase(title)) {
                res.add(project);
            }
        }
        return ResponseEntity.status(200).body(res);
    }


    //display all project for one company by companyName.
    @GetMapping("/projects/{companyName}")
//    public ArrayList<Project> company(@PathVariable String companyName){
//        ArrayList<Project> proj = new ArrayList<>();
//        for (Project project : projects){
//            if (project.getCompanyName().equalsIgnoreCase(companyName)){
//                proj.add(project);
//            }
//        }
//        return proj;
//    }
    public ResponseEntity company(@PathVariable @Valid String companyName, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        ArrayList<Project> proj = new ArrayList<>();
        for (Project project : projects) {
            if (project.getCompanyName().equalsIgnoreCase(companyName)) {
                proj.add(project);
            }
        }
        return ResponseEntity.status(200).body(proj);
    }

}
