package com.vmware.generator.service.impl;

import com.vmware.generator.model.StatusEnum;
import com.vmware.generator.model.TaskVO;
import com.vmware.generator.repository.TaskRepository;
import com.vmware.generator.service.TaskSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

@Service
public class TaskSvcImpl implements TaskSvc{
    @Autowired
    TaskRepository taskRepository;
    private String rootDir = System.getProperty("user.dir");
    private String tempDirLocation = rootDir + "/tmp";

    public TaskVO performTask(TaskVO taskVO){
        UUID uuid = UUID.randomUUID();
        taskVO.setUuid(uuid.toString());
        String fileName = taskVO.getUuid() + ".txt";
        try {
            File file = new File(tempDirLocation);
            file.mkdir();
            FileWriter fileWriter = new FileWriter(tempDirLocation + File.separator + fileName);
            taskVO.setStatus(StatusEnum.IN_PROGRESS);
            int goal = taskVO.getGoal();
            int step = taskVO.getStep();
            StringBuilder stringBuilder = new StringBuilder();
            while((goal != 0) && (goal != 1)){
                stringBuilder.append(goal).append(",");
                goal = goal - step;
                if(goal == 0 || goal == 1){
                    stringBuilder.append(goal);
                }
            }
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
            taskVO.setStatus(StatusEnum.SUCCESS);
            taskRepository.save(taskVO);
        } catch (IOException e) {
            taskVO.setStatus(StatusEnum.ERROR);
            e.printStackTrace();
        }
        return taskVO;
    }


    public StatusEnum getStatus(String uuid){
        Optional<TaskVO> taskVO = taskRepository.findById(uuid);
        return taskVO.get().getStatus();
    }


    public String getNumList(String uuid){
        String data = "";
        try {
            File file = new File(tempDirLocation + File.separator + uuid + ".txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data = scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }


}
