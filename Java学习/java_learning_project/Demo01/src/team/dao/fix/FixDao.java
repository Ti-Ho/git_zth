package team.dao.fix;

import java.util.List;

public interface FixDao {
	List<String> getAllFixs();
	List<String> getFixByStatus3();
	
	String getWorkload(String number);
	void deleteFix(String number);
	void insertFix(String number);
	
	Fix searchFix(String number);
	List<Fix> getAllFixsInTask();
	void updateFixInTask(String number, String fix_people);
	void deleteFixIntask(String number);
	Fix getFixByNumber(String number);
	
	List<Fix> getAllFixInTech(String Fix_people);
	List<Fix> getFixByNumberInTech(String Number, String Fix_people);
	void updateFix(Fix fix);
}
