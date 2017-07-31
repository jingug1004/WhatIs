package net.balgre.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest; 

public class NaverPayOrder  {     
	private static final String ENCODING = "UTF-8";     
	private static final String NCKEY_ITEMID = "ITEM_ID";
	private static final String NCKEY_MALLPID = "EC_MALL_PID";
	private static final String NCKEY_ITEMNAME = "ITEM_NAME";     
	private static final String NCKEY_COUNT = "ITEM_COUNT";     
	private static final String NCKEY_TPRICE = "ITEM_TPRICE";     
	private static final String NCKEY_UPRICE = "ITEM_UPRICE";     
	private static final String NCKEY_OPTION = "ITEM_OPTION";
	private static final String NCKEY_OPTION_CODE = "ITEM_OPTION_CODE";   
	private static final String NCKEY_SHIPPINGTYPE = "SHIPPING_TYPE";     
	private static final String NCKEY_SHIPPINGPRICE = "SHIPPING_PRICE";     
	private static final String NCKEY_TOTALPRICE = "TOTAL_PRICE";    
	private static final String NCKEY_SHOPID = "SHOP_ID";  
	private static final String NCKEY_CERTIKEY = "CERTI_KEY";   
	private static final String NCKEY_BACKURL = "BACK_URL"; 
	private static final String NCKEY_RESERVE1 = "RESERVE1";    
	private static final String NCKEY_RESERVE2 = "RESERVE2";   
	private static final String NCKEY_RESERVE3 = "RESERVE3";    
	private static final String NCKEY_RESERVE4 = "RESERVE4";     
	private static final String NCKEY_RESERVE5 = "RESERVE5";   
	private static final String NCKEY_SA_CLICK_ID = "SA_CLICK_ID"; //CTS     
	private static final String NCKEY_CPA_INFLOW_CODE = "CPA_INFLOW_CODE";    
	private static final String NCKEY_NAVER_INFLOW_CODE = "NAVER_INFLOW_CODE"; 
	
	public URL _url;     
	private SSLSocketFactory _sslSockFactory;          
	public NaverPayOrder(){         
		_url = null;
	}          
	public NaverPayOrder(URL url)     { 
		System.out.println(url);
		_url = url;         
		_initHttps();     
	}          
	public NaverPayOrder(String url) throws MalformedURLException {         
		this(new URL(url));     
	}          
	public void setUrl(String url) throws MalformedURLException {         
		_url = new URL(url);     
	}          
	public static class ItemStack {         
		private String _itemId;        
		private String _itemName;       
		private int _itemTPrice;       
		private int _itemUPrice;       
		private String _selectedOption;  
		private String _selectedOptionCode;
		private int _count;           
		/**          * 
		 * @param itemId Mall Item Code          
		 * * @param itemName 상품          
		 * * @param itemPrice 상품 개별 가격           
		 * * @param selectedOption 선택된 옵션. - 여러 옵션이 선택되었을 경우 '/'로 구분하는 것을 권장            
		 * * @param count 해당 상품 구매 갯수.          */         
		public ItemStack(String itemId, String itemName, int itemTPrice, int itemUPrice, String selectedOption, String selectedOptionCode, int count) {             
			_itemId = itemId;             
			_itemName = itemName;             
			_itemTPrice = itemTPrice;             
			_itemUPrice = itemUPrice;
			_selectedOption = selectedOption;
			_selectedOptionCode = selectedOptionCode;
			_count = count;   
		}                  
		public String getItemId(){             
			return _itemId;         
		}                  
		
		public String getItemName() {             
			return _itemName;         
		}                  
		
		public int getItemTotalPrice() {             
			return _itemTPrice;         
		}                  
		
		public int getItemUnitPrice() {             
			return _itemUPrice;         
		}                  
		
		public String getSelectedOption() {             
			if (_selectedOption == null) return "";             
			return _selectedOption; 
		}
		
		public String getSelectedOptionCode() {
			if (_selectedOptionCode == null) return "";
			return _selectedOptionCode;
		}
		
		public int getCount() { 
			return _count;         
		}  
	}    
	
	private void _urlEncode(StringBuffer sb, String key, String value)     {         
		try {             
			sb.append(URLEncoder.encode(key, ENCODING));             
			sb.append('=');             
			sb.append(URLEncoder.encode(value, ENCODING));         
		} catch(UnsupportedEncodingException e) {             //일어나지 않음            
			throw new Error(e);         
		}     
	}          
	
	private String _makeQueryString(String shopId, String certificationKey, ItemStack[] items, int shippingPrice, String shippingType, String backURL, String saClickId, String cpaInflowCode, String naverInflowCode) {         
		//주문 금액 = 각 상품 금액 + 배송비(단 선불일 경우)         
		int totalPrice = shippingPrice>0?shippingPrice:0;         
		StringBuffer sb = new StringBuffer();         
		_urlEncode(sb, NCKEY_SHOPID, shopId);         
		sb.append('&');         
		_urlEncode(sb, NCKEY_CERTIKEY, certificationKey);         
		sb.append('&');         
		for (ItemStack is : items) {             
			totalPrice += is.getItemTotalPrice();             
			_urlEncode(sb, NCKEY_ITEMID, is.getItemId());             
			sb.append('&');
			_urlEncode(sb, NCKEY_MALLPID, "BAL"+is.getItemId());             
			sb.append('&');
			_urlEncode(sb, NCKEY_ITEMNAME, is.getItemName());             
			sb.append('&');             
			_urlEncode(sb, NCKEY_TPRICE, String.valueOf(is.getItemTotalPrice()));             
			sb.append('&');             
			_urlEncode(sb, NCKEY_UPRICE, String.valueOf(is.getItemUnitPrice()));             
			sb.append('&');             
			_urlEncode(sb, NCKEY_COUNT, String.valueOf(is.getCount()));             
			sb.append('&');            
			_urlEncode(sb, NCKEY_OPTION, is.getSelectedOption());            
			sb.append('&');
			_urlEncode(sb, NCKEY_OPTION_CODE, is.getSelectedOptionCode());            
			sb.append('&'); 
		}          
		_urlEncode(sb, NCKEY_SHIPPINGTYPE, shippingType);  
		sb.append('&');         
		_urlEncode(sb, NCKEY_SHIPPINGPRICE, String.valueOf(shippingPrice));         
		sb.append('&');        
		_urlEncode(sb, NCKEY_TOTALPRICE, String.valueOf(totalPrice));         
		sb.append('&');         
		_urlEncode(sb, NCKEY_BACKURL, backURL);         
		sb.append('&');         
		_urlEncode(sb, NCKEY_RESERVE1, "");         
		sb.append('&');         
		_urlEncode(sb, NCKEY_RESERVE2, "");        
		sb.append('&');         
		_urlEncode(sb, NCKEY_RESERVE3, "");         
		sb.append('&');         
		_urlEncode(sb, NCKEY_RESERVE4, "");         
		sb.append('&');         
		_urlEncode(sb, NCKEY_RESERVE5, "");         
//		sb.append('&'); //CTS        
//		_urlEncode(sb, NCKEY_SA_CLICK_ID, saClickId); //CTS         
		// CPA 스크립트 가이드 설치업체는 해당 값 전달         
//		sb.append('&');         
//		_urlEncode(sb, NCKEY_CPA_INFLOW_CODE, cpaInflowCode);         
		sb.append('&'); 
		_urlEncode(sb, NCKEY_NAVER_INFLOW_CODE, naverInflowCode);         
		System.out.println(sb.toString()); 
		return sb.toString();     
	}          
	/* test 환경에서는 인증서 오류가 날 수도 있다. 이 코드를 이용해 인증서 오류를 회피한다. */     
	private void _initHttps()     {
		System.out.println("_initHTTPS");
		TrustManager[] trustAllCerts = new TrustManager[] {                 
			new X509TrustManager() {                     
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}                      
				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}                     
				public X509Certificate[] getAcceptedIssuers() {                         
					return new X509Certificate[0];                     
				}                 
			}         
		};         
		try {             
			SSLContext sslContext = SSLContext.getInstance("SSL");             
			sslContext.init(null, trustAllCerts, new SecureRandom());             
			_sslSockFactory = sslContext.getSocketFactory();         
		} catch(Exception e) {             
			RuntimeException re = new RuntimeException(e);             
			re.setStackTrace(e.getStackTrace());             
			throw re;         
		}     
	}          
	
	/**      
	 * @param items 주문 상품 목록.      
	 * @param shippingPrice 배송비.        
	 * @param shippingType 배송비결제 구분. "FREE": 무료. "PAYED": 선불. "ONDELIVERY": 착불       
	 * @return 주문키      
	 * @throws IOException      
	*/     
	public String sendOrderInfoToNC(String shopId, String certificationKey, ItemStack[] items, int shippingPrice, String shippingType, String backURL, String nvadId) throws IOException {         
		HttpURLConnection conn = (HttpURLConnection)_url.openConnection();                  
		/* test 환경에서는 인증서 오류가 날 수도 있다. 이 코드를 이용해 인증서 오류를 회피한다. */         
		if (conn instanceof HttpsURLConnection) {         
			System.out.println("CONN");
			((HttpsURLConnection)conn).setSSLSocketFactory(_sslSockFactory);             
			((HttpsURLConnection)conn).setHostnameVerifier(                     
				new HostnameVerifier() {   
					@Override                         
					public boolean verify(String hostname, SSLSession session) {         
						System.out.println(hostname);
						return true;                         
					}                     
				}             
			);         
		}         
		conn.setDoInput(true);         
		conn.setDoOutput(true);         
		conn.setUseCaches(false);         
		conn.setRequestMethod("POST");         
		conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");                  
		Writer writer = new OutputStreamWriter(conn.getOutputStream(), ENCODING);         
		writer.write(_makeQueryString(shopId, certificationKey, items, shippingPrice, shippingType, backURL, "", "", nvadId));         
		writer.flush(); 

		writer.close();                  
		int respCode = conn.getResponseCode();         
		if (respCode != 200) {             
			System.out.println(respCode);
			System.out.println(conn.getResponseMessage());
			throw new RuntimeException(String.format("NC Response fail : %d %s", respCode, conn.getResponseMessage()));         
		}                  
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));         
		String orderKey = reader.readLine();
		return orderKey;     
	} 
	
	public String getCookieValue(HttpServletRequest request, String name) {         
		if (name == null || request == null) {             
			return "";         
		} 
		Cookie[] cookies = request.getCookies();         
		if (cookies != null) {             
			for (int i = 0; i < cookies.length; i++) {                 
				if (name.equals(cookies[i].getName())) {                     
					return cookies[i].getValue();                 
				}             
			}         
		}         
		return "";     
	} 
	
	public static void main(String[] args) throws IOException {         
		//주문 상품 내역으로 items 데이터를 생성한다.         
//		List<ItemStack> items = new ArrayList<ItemStack>();          
//		items.add(new ItemStack("a1", "아이템1", 2000, 1000, "", 3));         
//		items.add(new ItemStack("a2", "아이템2", 2000, 1000, "XL/빨강", 2));                  
		int shippingPrice = 2500;         
		String shippingType = "PAYED";        
		String backURL = "http://www.naver.com";         
		String nvadId="11111+aa12345678901234";  //CTS          
		//servlet인 경우 쿠키값을 넣어야 함         
//		String nvadId = getCookieValue((HttpServletRequest)request, "NVADID");         
//		// CPA 스크립트 가이드 설치 업체는 해당 값 전달         
//		String cpaInflowCode = getCookieValue((HttpServletRequest)request, "CPAValidator");         
//		String naverInflowCode = getCookieValue((HttpServletRequest)request, "NA_CO");         
//		JavaOrderSample sample = new JavaOrderSample("https://testpay.naver.com/customer/api/order.nhn");         
//		String orderKey = sample.sendOrderInfoToNC("naver_pay", "naver_pay", items.toArray(new ItemStack[0]), shippingPrice, shippingType, backURL, nvadId, cpaInflowCode, naverInflowCode);         //여기서 얻은 orderKey로 NC 결제창에 넘겨 결제를 진행한다.         
//		System.out.println(String.format("OrderKey = %s", orderKey));     
	}  
}