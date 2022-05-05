package java_jdbc2.java_jdbc2;


import java.util.List;

import org.junit.Test;


import dao.UserPosDao;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		
		UserPosDao userPosDao = new UserPosDao();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setId(4L);
		userposjava.setNome("Samuel");
		userposjava.setEmail("samuel@com.br");
		
		userPosDao.salvar(userposjava);
	}
	
	@Test
	public void initListar () {
		UserPosDao dao = new UserPosDao();
		try {
			List<Userposjava> list = dao.listar();
			
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("--------------------------------");
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initBuscar () {
		UserPosDao dao = new UserPosDao();
		
		
		try {
			
			Userposjava userposjava = dao.buscar(4L);
			System.out.println(userposjava);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
