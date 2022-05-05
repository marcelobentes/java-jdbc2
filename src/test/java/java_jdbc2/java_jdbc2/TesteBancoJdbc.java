package java_jdbc2.java_jdbc2;

import org.junit.Test;


import dao.UserPosDao;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		
		UserPosDao userPosDao = new UserPosDao();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setId(2L);
		userposjava.setNome("Marcelo");
		userposjava.setEmail("marcelo@com.br");
		
		userPosDao.salvar(userposjava);
	}
	
}
