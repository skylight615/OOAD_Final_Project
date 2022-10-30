package com.example.demo.service;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;

import java.io.File;
import java.util.List;

public interface CommitService {


    int checkRepoInfo(int agentId, String repoName);

    /**
     * 指定分支提交数据,多用户提交情况还未考虑
     * @param agentId
     * @param repoName
     * @param branch
     * @param file
     * @return
     */
    //可以实现对文件属性的增删改;
    int commitFiles(int agentId, String repoName, String branch, File file);

    /**
     * 返回所有提交版本的ID
     * @param agentId
     * @param repoName
     * @param branch
     * @return
     */
    List<RevCommit> getCommitsByBranch(int agentId, String repoName, String branch);

    /**
     * clone分支的最新版本
     * @param agentId
     * @param repoName
     * @param branch
     * @return
     */

}






