public class Program {
	public static void main(String[] args) {

	int number = 13765;
	int nominal0 = 5000;
	int nominal1 = 2000;
	int nominal2 = 1000;
	int nominal3 = 500;
	int nominal4 = 200;
	int nominal5 = 100;
	int nominal6 = 50;

	int count0 = 0;
	int count1 = 0;
	int count2 = 0;
	int count3 = 0;
	int count4 = 0;
	int count5 = 0;
	int count6 = 0;

	System.out.println(number);

	while (true){
		if(number > nominal0) {
			number -= nominal0;
			count0++;
		}
			else {
				break;
			}
	}
	
	System.out.println(nominal0 + " - " + count0);

	while (true){ 
		if(number > nominal1) {
			number -= nominal1;
			count1++;
		}
			else {
				break;
			}
	}
	
	System.out.println(nominal1 + " - " + count1);

	while (true){
		if(number > nominal2) {
			number -= nominal2;
			count2++;
		}
			else {
				break;
			}
	}
	
	System.out.println(nominal2 + " - " + count2);
	
	while (true){
		if(number > nominal3) {
			number -= nominal3;
			count3++;
		}
			else {
				break;
			}
	}
	
	System.out.println(nominal3 + "  - " + count3);
	
	while (true){
		if(number > nominal4) {
			number -= nominal4;
			count4++;
		}
			else {
				break;
			}
	}
		
	System.out.println(nominal4 + "  - " + count4);
	
	while (true){
		if(number > nominal5) {
			number -= nominal5;
			count5++;
		}
			else {
				break;
			}
	}
		
	System.out.println(nominal5 + "  - " + count5);
	
	while (true){
		if(number > nominal6) {
			number -= nominal6;
			count6++;
		}
			else {
				break;
			}
	}
	
	System.out.println(nominal6 + "   - " + count6);
	
	}
	
}