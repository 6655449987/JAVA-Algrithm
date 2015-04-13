package math;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * Example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 *  ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB 
 * 
 * @author shengyuan
 *
 */
public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		ExcelSheetColumnTitle o = new ExcelSheetColumnTitle();
		int n = 28;
		System.out.println(String.format("number %s equals %s in ExcelColumn", n, o.convertToTitle(n)));
	}
	
	public String convertToTitle(int n){
		String s="";
		int temp = n;
		while(temp > 0){
			int mod = temp % 26;
			int divide = temp / 26;
			if(mod ==0)
				divide --;//if mod equals zero than devide should minus one
			System.out.println(String.format("temp:%s, mod:%s, divide:%s", temp, mod, divide));
			s = convertOneChar(mod) + s;
			temp  = divide;
		}
		return s;
	}
	
	/**
	 * convert 1~26 to String
	 * @param n
	 * @return
	 */
	public String convertOneChar(int n){
		if(n ==0){
			return "Z";
		} else {
			int indexOfA = (int) 'A';
			char s = ((char)(n + indexOfA -1));
			return String.valueOf(s);
		}
		
	}

}
