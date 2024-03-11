package com.example.lab5.Projects.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
    @NotEmpty(message = "id can't be empty!")
    @Size(min = 2, message = "id's length must be more than 2!")
    private String ID;

    @NotEmpty(message = "title can't be empty!")
    @Size(min = 8, message = "the title length must be more than 8!")
    private String title;

    @NotEmpty(message = "description can't be empty!")
    @Size(min = 15, message = "the length of description must be more then 15")
    private String description;

    @NotNull(message = "can't be null")
//    @Pattern() // this must be not started or in progress or completed only
    @Pattern(regexp = "^(not started|in progress|completed)$",
            message = "Status must be either 'not started', 'in progress', or 'completed'")
    private String status; // i have changed the status DT here coz it won't work with boolean!

    @NotNull(message = "company name can't be empty!")
    @Size(min = 6, message = "length of company name has to be 6 or more!")
    private String companyName;
}
