package login.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dept.service.face.DeptService;
import login.dao.face.LoginDao;
import login.dto.Login;
import login.service.face.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = LoggerFactory.getLogger(DeptService.class);

	@Autowired
	private LoginDao loginDao;

	@Override
	public void addJoin(Login login) {

		int res = loginDao.insertUser(login);
		if (res > 0) {
			logger.info("insert성공 res : " + res);
		} else {
			logger.info("insert실패 res : " + res);

		}

	}

	@Override
	public Login isLogin(Login login) {

		Login user = new Login();
		
		user = loginDao.selectByUserIdPw(login);
		
		return user;
		
	}

}
