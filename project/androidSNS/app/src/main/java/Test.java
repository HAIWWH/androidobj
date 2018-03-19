import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月DD日  F");
		String nowDate = sdf.format(new Date());
		System.out.println(nowDate);
	}

}
