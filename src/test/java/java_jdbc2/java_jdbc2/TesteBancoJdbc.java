package java_jdbc2.java_jdbc2;

import org.junit.Test;


import dao.UserPosDao;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		
		UserPosDao userPosDao = new UserPosDao();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setId(1L);
		userposjava.setNome("Thati");
		userposjava.setEmail("thati@com.br");
		
		userPosDao.salvar(userposjava);
	}
	
}
