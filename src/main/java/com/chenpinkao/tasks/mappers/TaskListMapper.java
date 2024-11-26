package com.chenpinkao.tasks.mappers;

import com.chenpinkao.tasks.domain.dto.TaskListDto;
import com.chenpinkao.tasks.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}
