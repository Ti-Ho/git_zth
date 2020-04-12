package team.service.tech;

import java.util.List;

import team.dao.fix.Fix;

public interface TechService {
	List<Fix> getAllFix(String fix_people);
	List<Fix> getFixByNumber(String number, String fix_people);
	void deleteFix(String number);
	void updateFix(Fix fix);
}
