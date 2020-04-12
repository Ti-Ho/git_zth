package team.service.tech;

import java.util.List;

import team.dao.fix.Fix;
import team.dao.fix.FixDao;
import team.dao.fix.FixDaoImpl;

public class TechServiceImpl implements TechService{

	@Override
	public List<Fix> getAllFix(String fix_people) {
		FixDao fixDao = new FixDaoImpl();
		return fixDao.getAllFixInTech(fix_people);
	}

	@Override
	public List<Fix> getFixByNumber(String number, String fix_people) {
		FixDao fixDao = new FixDaoImpl();
		return fixDao.getFixByNumberInTech(number, fix_people);
	}

	@Override
	public void deleteFix(String number) {
		FixDao fixDao = new FixDaoImpl();
		fixDao.deleteFix(number);
		
	}

	@Override
	public void updateFix(Fix fix) {
		// TODO Auto-generated method stub
		FixDao fixDao = new FixDaoImpl();
		fixDao.updateFix(fix);
	}

}
