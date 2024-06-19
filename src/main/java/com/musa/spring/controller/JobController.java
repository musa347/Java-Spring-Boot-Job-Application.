package com.musa.spring.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private final List<Job> jobs = new ArrayList<>();


    @GetMapping({"/jobs", "id"})
    public List<Job> findAll(){
        return jobs;
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){
        jobs.add(job);
        return "Job added successfully";
    }
}
