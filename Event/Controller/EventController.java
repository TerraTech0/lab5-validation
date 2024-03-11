package com.example.lab5.Event.Controller;

import com.example.lab5.Event.Model.Event;
import com.example.lab5.Projects.Api.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/event")
public class EventController {
    ArrayList<Event> events = new ArrayList<>();

    @GetMapping("/get")
//    public ArrayList<Event> showEvents(){
//        return events;
//    }
    public ResponseEntity showEvents() {
        return ResponseEntity.status(200).body(events);
    }


    @PostMapping("/add")
//    public ApiResponse addEvent(@RequestBody Event event){
//        events.add(event);
//        return new ApiResponse("Event added successfully!");
//    }
//    public ResponseEntity addEvent(@RequestBody @Valid Event event, Errors errors){
//        if (errors.hasErrors()){
//            String message = errors.getFieldError().getDefaultMessage();
//            return ResponseEntity.status(400).body(message);
//        }
//        events.add(event);
//        return ResponseEntity.status(200).body(new ApiResponse(" Event added successfully"));
//    }

    public ResponseEntity addEntity(@RequestBody Event event, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        events.add(event);
        return ResponseEntity.status(200).body(new ApiResponse("Event added successfully! "));
    }

    @PutMapping("/update/{index}")
//    public ApiResponse updateEvent(@PathVariable int index, @RequestBody Event event){
//        events.set(index, event);
//        return new ApiResponse("event updated successfully!");
//    }

    public ResponseEntity updateEvent(@PathVariable int index, @RequestBody Event event, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        events.set(index, event);
        return ResponseEntity.status(200).body(new ApiResponse("Event updated successfully!"));
    }

    //change only the capacity
    @PutMapping("/change-capacity/{index}/{capacity}")
//    public ApiResponse changeCapacity(@PathVariable int index, @PathVariable int capacity){
//        Event event = events.get(index);
//        event.setCapacity(capacity);
//        events.set(index, event);
//        return new ApiResponse("Capacity Changed!");
//    }

    public ResponseEntity changeCapacity(@PathVariable int index, @PathVariable @Valid int capacity, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Event event = events.get(index);
        event.setCapacity(capacity);
        events.set(index, event);
        return ResponseEntity.status(200).body(new ApiResponse("Capacity changed successfully!"));
    }


    @DeleteMapping("/delete/{index}")
//    public ApiResponse deleteEvent(@PathVariable int index){
//        events.remove(index);
//        return new ApiResponse("event deleted successfully!");
//    }

    public ResponseEntity deletedEvent(@PathVariable int index) {
        events.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("Event deteled successfully!"));
    }


    //search for event by giving id:
    @GetMapping("/search/{ID}")
//    public ArrayList<Event> search(@PathVariable String ID){
//        ArrayList<Event> event = new ArrayList<>();
//        for (Event ev : events){
//            if (ev.getID().equalsIgnoreCase(ID)){
//                event.add(ev);
//            }
//        }
//        return event;
//    }
    public ResponseEntity search(@PathVariable @Valid String ID, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        ArrayList<Event> event = new ArrayList<>();
        for (Event event1 : events) {
            if (event1.getID().equalsIgnoreCase(ID)) {
                event.add(event1);
            }
        }
        return ResponseEntity.status(200).body(event);
    }

}

