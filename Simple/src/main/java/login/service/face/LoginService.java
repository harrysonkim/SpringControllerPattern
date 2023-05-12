package login.service.face;

import login.dto.Login;

public interface LoginService {

	public void addJoin(Login login);

	public Login isLogin(Login login);

}
