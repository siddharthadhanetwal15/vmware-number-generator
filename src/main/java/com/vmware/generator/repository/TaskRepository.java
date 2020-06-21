package com.vmware.generator.repository;

import com.vmware.generator.model.TaskVO;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskVO, String> {
}
