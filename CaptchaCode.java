package Test1;

import javax.servlet.annotation.WebServlet;

@WebServlet("/Capcha")
public class CaptchaCode {
	
	public static String getCaptch(int n)
	{
		StringBuilder sb =new StringBuilder();
		String capcha = "abcdefghijklmnopqrstuvwxyz1234567890" +"!@#$%^&*" +"ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=1; i<=n; i++)
		{
			int indexString = (int) (capcha.length()*Math.random());
			sb.append(capcha.charAt(indexString));
		
		}
		return sb.toString();
		
	}
	public static void main(String[] args) {
		System.out.println(getCaptch(6));
	}
	

}


