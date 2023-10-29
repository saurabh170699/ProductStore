package Test1;

	import java.beans.Transient;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;

	@SuppressWarnings("serial")
	public class ProductBean1 implements Serializable
	{
		private String pCode, pName;
		private float pPrice;
		private int pQty;
		
		private InputStream is;
		
		public InputStream getIs() {
			return is;
		}



		public void setIs(InputStream is) {
			this.is = is;
		}

		
		
		
		

		public ProductBean1() {
			super();
		}
		String base64; 

		
		public String getBase64() {
			return base64;
		}


		public void setBase64(String base64) {
			this.base64 = base64;
		}

		public String getpCode() {
			return pCode;
		}

		public void setpCode(String pCode) {
			this.pCode = pCode;
		}

		public String getpName() {
			return pName;
		}

		public void setpName(String pName) {
			this.pName = pName;
		}

		public float getpPrice() {
			return pPrice;
		}

		public void setpPrice(float pPrice) {
			this.pPrice = pPrice;
		}

		public int getpQty() {
			return pQty;
		}

		public void setpQty(int pQty) {
			this.pQty = pQty;
		}
		
		
	}

