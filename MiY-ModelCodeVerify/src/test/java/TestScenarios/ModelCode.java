package TestScenarios;


import java.io.IOException;

import org.testng.annotations.Test;

import Base.Base;
import Base.ReadTestData;
import PageObjects.LoginPage;
import PageObjects.ChooseModelPage;

public class ModelCode extends Base {
	

	
	@Test
	public void chooseModel() {
		ChooseModelPage chooseModel_obj = new ChooseModelPage(driver); 
		chooseModel_obj.chooseModel(super.username,super.password,super.bikeName);
	}
	
//	@Test
//	public void readData() throws IOException {
//		ReadTestData obj = new ReadTestData(); 
//		obj.redData();
//	}
}
