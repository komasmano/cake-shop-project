package test;

import com.kk.app.DAO.CakeDAO;
import com.kk.app.DAO.CakeuserDAO;
import com.kk.app.DTO.Cakeuserdto;

public class text 
{

	public static void main(String[] args) {
		
		Cakeuserdto dto=new Cakeuserdto("komas", "komas", 12345, "komas");
		CakeuserDAO dao=new CakeuserDAO();
		
		
		CakeDAO dao1=new CakeDAO();
		
		dao1.search(5);
		
		
		
//		dao.login(dto);
		
//		dao.Registration(dto);

		
		

		
		
		
	}
}
