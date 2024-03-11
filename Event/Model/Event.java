package com.example.lab5.Event.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class Event {

    @NotEmpty(message = "id can't  be null!")
    @Size(min = 2, message = "id must be more than 2")
    private String ID;

    @NotEmpty(message = "description can't be empty!")
    @Size(min = 15, message = "description length has to be 15 or more")
    private String description;

    @NotNull(message = "capacity can't be empty!")
    @Pattern(regexp = "[0-9]+")
    @Min(value = 25, message = "capacity must be more than 25")
    private int capacity;


    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
