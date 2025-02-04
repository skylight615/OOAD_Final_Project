package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.BranchService;
import com.example.demo.service.RepositoryService;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(value = "/Branch")
public class BranchController {
    String localPath = "/Users/zhuhe/Desktop/Jgit";

    String testDirectory = "/Users/zhuhe/Desktop/Jgit.md";


    @Autowired
    RepositoryService repositoryService;
    @Autowired

    BranchService branchService;



    @ResponseBody
    @RequestMapping(value ="/createBranch/{agentName}/{repoName}/{baseName}/{targetbranch}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public int createBranch(@PathVariable("agentName") String agentName,
                               @PathVariable("repoName") String repoName,
                            @PathVariable("baseName") String baseName,

                            @PathVariable("targetbranch") String targetbranch
    ) throws GitAPIException {
        Git repository = repositoryService.loadLocalRepository(localPath, agentName, repoName);
        if(branchService.createBranch(repository, baseName,targetbranch)==null){
            return 1;
        }else {
            return 0;}
    }


//
//    @ResponseBody
//    @RequestMapping(value ="/switchBranch/{agentName}/{repoName}/{branchName}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//    public String switchBranch(@PathVariable("agentName") String agentName,
//                           @PathVariable("repoName") String repoName,
//                           @PathVariable("branchName") String branchName
//    ) throws GitAPIException {
//        JSONObject result = new JSONObject();
//        Git repository = repositoryService.loadLocalRepository(localPath, agentName, repoName);
//        branchService.switchBranch(repository, branchName);
//        result.put("status", "Switch Branch: " + branchName);
//        return result.toJSONString();
//    }



    @ResponseBody
    @RequestMapping(value ="/deleteBranch/{agentName}/{repoName}/{branchName}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public int deleteBranch(@PathVariable("agentName") String agentName,
                               @PathVariable("repoName") String repoName,
                               @PathVariable("branchName") String branchName

    ) throws GitAPIException {
        Git repository = repositoryService.loadLocalRepository(localPath, agentName, repoName);
        List<String> a = branchService.deleteBranch(repository, branchName);
        if(a==null){
            return 0;
        }
        else {
            return 1;}

    }





    /**
     * 目前未测;
    * */
    @ResponseBody
    @RequestMapping(value ="/merge/{agentName}/{repoName}/{baseBranchName}/{targetBranchName}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String mergeBranch(@PathVariable("agentName") String agentName,
                               @PathVariable("repoName") String repoName,
                               @PathVariable("baseBranchName") String baseBranchName,
                              @PathVariable("targetBranchName") String targetBranchName

    ) throws GitAPIException, IOException {
        JSONObject result = new JSONObject();
        Git repository = repositoryService.loadLocalRepository(localPath, agentName, repoName);
        branchService.merge(repository, baseBranchName, targetBranchName);

        result.put("status", "Merging Branch: " + baseBranchName +" to " +targetBranchName);
        return result.toJSONString();
    }




     /*
     * pull branch
     * */
//    @ResponseBody
//    @RequestMapping(value ="/pull/{agentName}/{remoteAgentName}/{remoteRepoName}/{branchName}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//    public String pull(@PathVariable("agentName") String agentName,
//                           @PathVariable("remoteAgentName") String remoteAgentName,
//                           @PathVariable("remoteRepoName") String remoteRepoName,
//                            @PathVariable("branchName") String branchName
//
//
//    ) throws GitAPIException, IOException {
//        JSONObject result = new JSONObject();
//        Git repository = repositoryService.loadLocalRepository(localPath, agentName, remoteRepoName);
//        branchService.pull(branchName,repository,localPath + File.separator + remoteAgentName + File.separator + remoteRepoName);
//
//        result.put("status", "pull: " + remoteRepoName);
//        return result.toJSONString();
//    }


}
