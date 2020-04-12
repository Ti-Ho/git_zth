package team.service.task;

import java.util.List;

import team.dao.fix.Fix;

public interface TaskService {
	Fix searchTask(String number);
	List<Fix> getAllTasks();
	void updateTask(String number, String fix_people);
	void deleteTask(String number);
	Fix getTaskByNumber(String number);
}
