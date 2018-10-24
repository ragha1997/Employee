import java.util.Date;

import com.capgemini.dao.Employeedao;
import com.capgemini.dao.Employeedaoimp;
import com.capgemini.dto.EmployeeDto;


public class Empdb {
	public static void main(String[] args) {
			Employeedao edao=new Employeedaoimp();
		
		EmployeeDto edto;
		edto=new EmployeeDto();
	/* edto.setName("rvl");
		edto.setJoinDate(new Date());
		boolean a;
          a=edao.createEmployee(edto);	
          if(a){ */
		 edto= edao.findById(15);
		
		System.out.println(edto.getEmployeeid()+ " "+ edto.getName() + "/" + edto.getJoinDate());
        //  }else System.out.println("\n not created");
		
		
	}

	}
