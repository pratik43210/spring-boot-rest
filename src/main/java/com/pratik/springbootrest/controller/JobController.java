package com.pratik.springbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.springbootrest.model.JobPost;
import com.pratik.springbootrest.service.JobService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class JobController {
	@Autowired
	private JobService service;
	
	/*CREATE*/
	@PostMapping(path="jobPost",consumes = "application/json")
	public void addJob(@RequestBody JobPost jobPost) {
		service.addJob(jobPost);
	}

	/*READ*/
	//ResponseBody Makes spring not look for the view (resolver)
	//instead it looks for data
	@GetMapping(path="jobPosts", produces = "application/json")
//	@ResponseBody
	public List<JobPost> getAllJobs() {
		return service.getAllJobs();
	}
	@GetMapping("jobPost/{postId}")
	public JobPost getJob(@PathVariable int postId) {
		return service.getJob(postId);
	}
	
	/*UPDATE*/
	@PutMapping("jobPost")
	public void updateJob(@RequestBody JobPost jobPost) {
		service.updateJob(jobPost);
	}
	
	/*DELETE*/
	@DeleteMapping("jobPost/{postId}")
	public void deleteJob(@PathVariable int postId) {
		service.deleteJob(postId);
	}
}
