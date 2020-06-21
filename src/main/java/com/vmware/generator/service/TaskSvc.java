package com.vmware.generator.service;

import com.vmware.generator.model.StatusEnum;
import com.vmware.generator.model.TaskVO;
import org.springframework.stereotype.Service;

@Service
public interface TaskSvc {
    TaskVO performTask(TaskVO taskVO);
    StatusEnum getStatus(String uuid);
    String getNumList(String uuid);
}
