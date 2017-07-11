package net.balgre.service;

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
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class NaverPayWishlist  {     
	private static final String ENCODING = "UTF-8";     
	private static final String NCKEY_ITEMID = "ITEM_ID";     
	private static final String NCKEY_ITEMNAME = "ITEM_NAME";
	private static final String NCKEY_ITEMDESC = "ITEM_DESC";
	private static final String NCKEY_UPRICE = "ITEM_UPRICE";     
	private static final String NCKEY_ITEMIMAGE = "ITEM_IMAGE";     
	private static final String NCKEY_ITEMTHUMB = "ITEM_THUMB";     
	private static final String NCKEY_ITEMURL = "ITEM_URL";     
	private static final String NCKEY_SHOPID = "SHOP_ID";     
	private static final String NCKEY_CERTIKEY = "CERTI_KEY";     
	private static final String NCKEY_RESERVE1 = "RESERVE1";     
	private static final String NCKEY_RESERVE2 = "RESERVE2";     
	private static final String NCKEY_RESERVE3 = "RESERVE3";     
	private static final String NCKEY_RESERVE4 = "RESERVE4";     
	private static final String NCKEY_RESERVE5 = "RESERVE5"; 

	public URL _url;     
	private SSLSocketFactory _sslSockFactory;          

	public NaverPayWishlist()     {         
		_url = null;     
	}          
	public NaverPayWishlist(URL url) {
		_url = url;         
		_initHttps();     
	}          

	public NaverPayWishlist(String url) throws MalformedURLException {
		this(new URL(url));     
	}          

	public void setUrl(String url) throws MalformedURLException {
		_url = new URL(url);     
	}          
	public static class WishItemStack {
		private String _itemId;         
		private String _itemName;    
		private String _itemDesc;
		private int _itemUPrice; 
		private String _itemImage;
		private String _itemThumb; 
		private String _itemUrl;           
		/**          
		 * @param itemId Mall Item Code          
		 * @param itemName 상품          
		 * @param itemPrice 상품 개별 가격          
		 */         
		public WishItemStack(String itemId, String itemName, String itemDesc, int itemUPrice, String itemImage, String itemThumb, String itemUrl) {             
			_itemId = itemId;             
			_itemName = itemName;             
			_itemDesc = itemDesc;
			_itemUPrice = itemUPrice;             
			_itemImage = itemImage;             
			_itemThumb = itemThumb;             
			_itemUrl = itemUrl;         
		}     

		public String getItemId() {             
			return _itemId;         
		}                  

		public String getItemName() {             
			return _itemName;         
		} 

		public String getItemDesc() {             
			return _itemDesc;         
		} 
		
		public int getItemUnitPrice() {             
			return _itemUPrice;         
		}                  

		public String getItemImage() {            
			return _itemImage;        
		}                  

		public String getItemThumb() {             
			return _itemThumb;         
		}                  

		public String getItemUrl() {             
			return _itemUrl;        
		}     
	} 

	private void _urlEncode(StringBuffer sb, String key, String value) {         
		try {             
			sb.append(URLEncoder.encode(key, ENCODING));             
			sb.append('=');             
			sb.append(URLEncoder.encode(value, ENCODING));         
		} catch(UnsupportedEncodingException e) {             //일어나지 않음             
			throw new Error(e);         
		}     
	}          

	private String _makeQueryString(String shopId, String certificationKey, WishItemStack[] items) {         
		StringBuffer sb = new StringBuffer();         
		_urlEncode(sb, NCKEY_SHOPID, shopId);         
		sb.append('&');         
		_urlEncode(sb, NCKEY_CERTIKEY, certificationKey);         
		sb.append('&');         
		for (WishItemStack is : items) {             
			_urlEncode(sb, NCKEY_ITEMID, is.getItemId());             
			sb.append('&');             
			_urlEncode(sb, NCKEY_ITEMNAME, is.getItemName());            
			sb.append('&');    
			_urlEncode(sb, NCKEY_ITEMDESC, is.getItemDesc());            
			sb.append('&'); 
			_urlEncode(sb, NCKEY_UPRICE, String.valueOf(is.getItemUnitPrice()));             
			sb.append('&');             
			_urlEncode(sb, NCKEY_ITEMIMAGE, String.valueOf(is.getItemImage()));           
			sb.append('&');         
			_urlEncode(sb, NCKEY_ITEMTHUMB, String.valueOf(is.getItemThumb()));           
			sb.append('&');             
			_urlEncode(sb, NCKEY_ITEMURL, String.valueOf(is.getItemUrl()));           
			sb.append('&');        
		}        
		_urlEncode(sb, NCKEY_RESERVE1, "");         
		sb.append('&');        
		_urlEncode(sb, NCKEY_RESERVE2, "");      
		sb.append('&');     
		_urlEncode(sb, NCKEY_RESERVE3, "");        
		sb.append('&');        
		_urlEncode(sb, NCKEY_RESERVE4, ""); 
		sb.append('&');       
		_urlEncode(sb, NCKEY_RESERVE5, ""); 
		System.out.println(sb.toString()); 
		return sb.toString();     
	}     

	/* test 환경에서는 인증서 오류가 날 수도 있다. 이 코드를 이용해 인증서 오류를 회피한다. */     
	private void _initHttps()     {         
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

	/**      * @param items 주문 상품 목록.       * @return 주문키      * @throws IOException      */    
	public String[] sendZzimToNC(String shopId, String certificationKey, WishItemStack[] items) throws IOException {         
		HttpURLConnection conn = (HttpURLConnection)_url.openConnection();                  
		/* test 환경에서는 인증서 오류가 날 수도 있다. 이 코드를 이용해 인증서 오류를 회피한다. */         
		if (conn instanceof HttpsURLConnection) {             
			((HttpsURLConnection)conn).setSSLSocketFactory(_sslSockFactory);          
			((HttpsURLConnection)conn).setHostnameVerifier(                   
					new HostnameVerifier() {                      
						@Override                         
						public boolean verify(String hostname, SSLSession session) {          
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
		writer.write(_makeQueryString(shopId, certificationKey, items));       
		writer.flush();         
		writer.close();       
		int respCode = conn.getResponseCode();    
		if (respCode != 200) {       
			throw new RuntimeException(String.format("NC Response fail : %d %s", respCode, conn.getResponseMessage()));         
		}              
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));     
		String retStr = reader.readLine();    
		System.out.println(retStr);
		return retStr.split(",");    
	}        
	public static void main(String[] args) throws IOException     {        
		//주문상품 내역으로 items 데이터를 생성한다.      
		List<WishItemStack> items = new ArrayList<WishItemStack>();         
		items.add(new WishItemStack("a1", "아이템1", "", 1000, "http://mymall.com/images/a1.jpg", "http://mymall.com/thumbs/a1.jpg", "http://mymall.com/iteminfo?item_id=a1"));   
		items.add(new WishItemStack("a2", "아이템2", "", 1000, "http://mymall.com/images/a2.jpg", "http://mymall.com/thumbs/a2.jpg", "http://mymall.com/iteminfo?item_id=a2"));     
		NaverPayWishlist sample = new NaverPayWishlist("https://testpay.naver.com/customer/api/wishlist.nhn");  
		String[] prodSeqs = sample.sendZzimToNC("naver_pay", "naver_pay", items.toArray(new WishItemStack[0]));         
		//여기서 얻은prodSeqs로 zzim popup을 띄운다.         
		System.out.println(Arrays.toString(prodSeqs)); 
	} 
}