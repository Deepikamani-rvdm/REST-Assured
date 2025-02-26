package tests;

import org.testng.annotations.DataProvider;

public class DataForTest {
	
	@DataProvider(name ="DataForProvider")
	public Object[][] dataForPost(){
		
//		Object[][] data = new Object[2][3];
//		data[0][0] = "Athiran";
//		data[0][1] = "Arian";
//		data[0][2] = 2;
//		
//		data[1][0] = "Seetha";
//		data[1][1] = "Jayseelan";
//		data[1][2] = 3;
//		
//		return data;
		
		return new Object[][] {
			{"RAJU", "Ramya", 1},
			{"Ram", "Seetha",9}
			
			
		};
		
		
	}
	
	@DataProvider (name = "DeleteObject")
	public Object[] dataForDelete() {
		return new Object[] {
				"d227"

		};
	}

}
