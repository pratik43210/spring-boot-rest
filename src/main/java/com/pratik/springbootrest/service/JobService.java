package com.pratik.springbootrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratik.springbootrest.model.JobPost;
import com.pratik.springbootrest.repo.JobRepo;

@Service
public class JobService {
	@Autowired
	private JobRepo repo;
	public void addJob(JobPost job) {
		repo.addJobPost(job);
	}
	public List<JobPost> getAllJobs(){
		return repo.returnAllJobPosts();
	}
	public JobPost getJob(int jobId) {
		return repo.getJob(jobId);
	}
	public void updateJob(JobPost jobPost) {
		repo.updateJob(jobPost);
	}
	public void deleteJob(int postId) {
		repo.deleteJob(postId);
	}
}
