package com.vmware.generator.controller;

import com.vmware.generator.model.ResultVO;
import com.vmware.generator.model.StatusEnum;
import com.vmware.generator.model.TaskVO;
import com.vmware.generator.service.TaskSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class TaskController {

    private TaskSvc taskSvc;

    @Autowired
    public void setTaskSvc(TaskSvc taskSvc) {
        this.taskSvc = taskSvc;
    }

    @RequestMapping(value = "/generate", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> performTask(@RequestBody TaskVO taskVO){
        TaskVO result =  taskSvc.performTask(taskVO);
        return new ResponseEntity<Object>(result, HttpStatus.ACCEPTED);
    }

    @GetMapping("/tasks/{uuid}/status")
    public ResponseEntity<Object> getStatus(@PathVariable String uuid){
        StatusEnum statusEnum = taskSvc.getStatus(uuid);
        ResultVO resultVO = new ResultVO();
        resultVO.setResult(statusEnum.toString());
        return new ResponseEntity<Object>(resultVO, HttpStatus.OK);
    }

    @GetMapping("/tasks/{uuid}")
    public ResponseEntity<Object> getNumList(@PathVariable String uuid, @RequestParam String action){
        String data = taskSvc.getNumList(uuid);
        ResultVO resultVO = new ResultVO();
        resultVO.setResult(data);
        return new ResponseEntity<Object>(resultVO, HttpStatus.OK);
    }
}
