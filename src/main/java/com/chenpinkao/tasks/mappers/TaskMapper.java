package com.chenpinkao.tasks.mappers;

import com.chenpinkao.tasks.domain.dto.TaskDto;
import com.chenpinkao.tasks.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}
