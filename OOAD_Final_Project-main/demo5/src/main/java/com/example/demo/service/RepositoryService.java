package com.example.demo.service;

import org.eclipse.jgit.api.Git;

public interface RepositoryService {

    Git initRepository (String path,String agentName ,String repositoryName);

    Git cloneRepository (String remotePath, String localPath, String agentName, String repositoryName);

    Git loadLocalRepository(String path, String agentName ,String repositoryName);
}
