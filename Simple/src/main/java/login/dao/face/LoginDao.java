package login.dao.face;

import login.dto.Login;

public interface LoginDao {

	public int insertUser(Login login);

	public Login selectByUserIdPw(Login login);

}
