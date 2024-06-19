package com.musa.spring.impl;

import com.musa.spring.entity.Job;
import com.musa.spring.repo.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImp {
    private JobRepository jobRepository;
    public JobServiceImp(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }



    void createJob(Job job){
      jobRepository.save(job);
    }

    Job getJobById(Long id){
        return jobRepository.findById(id).get();
    }

    boolean deleteJobById(Long id){
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    boolean updateJob(Job job){
        Optional<Job> jobOptional = jobRepository.findById(job.getId());
        if(jobOptional.isPresent()){
            Job jobToUpdate = jobOptional.get();
            jobToUpdate.setTitle(job.getTitle());
            jobToUpdate.setDescription(job.getDescription());
            jobToUpdate.setLocation(job.getLocation());
            jobToUpdate.setMaxSalary(job.getMaxSalary());
            jobToUpdate.setMinSalary(job.getMinSalary());
            jobRepository.save(jobToUpdate);
        }
        return false;
    }
}
