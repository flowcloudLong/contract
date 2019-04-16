package util;

import dao.IBaseDao;
import dao.impl.ContractDaoImpl;
import domain.Contract;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Randomhetong {
	
	private static String contId=null;
	private static IBaseDao<Contract> condao =new ContractDaoImpl();
	public static String getContId(){
		
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String format = sdf.format(d);
		String sb=format;

		for (int i = 0; i < 4; i++) {
			Random r= new Random();
			int rr = r.nextInt(10);
			sb=sb+rr;
		}
		contId =sb;
		Contract contract = condao.get(Long.valueOf(contId));
		if(contract == null){
			
			return contId;
		}else{
			Randomhetong.getContId(); 
		}
		return null;
		
	}

}
