package test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.SimpleTimeZone;
import java.util.Timer;

import com.kk.app.DAO.CakeDAO;
import com.kk.app.DAO.CartDAO;

import com.kk.app.DTO.Cakeuserdto;
import com.kk.app.DTO.CartDTO;

import com.kk.app.DTO.userdto;

public class test 
{
	
	
	static char[] captcha()
	{
		
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        
        String values = Capital_chars + Small_chars +
                numbers;
        
		
        Random rndm_method = new Random();
                
        char[] len=new char[6];
        
        for(int i=0; i<len.length; i++)
        {
        	len[i]=values.charAt(rndm_method.nextInt(values.length()));
        }
		return len;
		
	}
	
	
	

	public static void main(String[] args) {
		
		System.out.println(captcha());
		
//	CartDAO dao=new CartDAO();
//	
//	System.out.println(dao.search("sorry"));
//	
//
//	userdto dto=new userdto();
//	
//	
//	System.out.println(dto.getEmail());

//	CakeuserDAO dao=new CakeuserDAO();
//	
//	Cakeuserdto dto=new Cakeuserdto();
//	System.out.println(dao.login(dto));
		
//		
//	int count=0;
//	
//	for(;;)
//	{
//		int num=1;
//		count=count+num;
//		System.out.println(count);
//	}
//		
	
//		Date date = new Date();
//	       
//        // specify the date format to be used
//        SimpleDateFormat date_format1 = new SimpleDateFormat("MM/dd/yyyy");
// 
//        String date_str = date_format1.format(date);
//       
//        System.out.println("MM/dd/yyyy : " + date_str);
//       
//        // another date format
//        SimpleDateFormat date_format2 = new SimpleDateFormat("dd MMMM yyyy");
//       
//        date_str = date_format2.format(date);
//       
//        System.out.println("dd MMMM yyyy: "
//                           + date_str);
		
		
//		LocalTime time =LocalTime.now();
//		
//		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//		System.out.println(time.format(formatter));
		
//		CakeDAO dao=new CakeDAO();
//		
//		System.out.println(dao.search(5)); 
//		
//		
    }	
	
	}

