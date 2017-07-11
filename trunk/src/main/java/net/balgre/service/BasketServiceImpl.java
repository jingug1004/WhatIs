package net.balgre.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.balgre.domain.AppBasketResponse;
import net.balgre.domain.BasketResponse;
import net.balgre.network.BasketRetroImpl;


@Service
public class BasketServiceImpl implements BasketService {

	@Override
	public AppBasketResponse basketList(String token) throws Exception {

		BasketRetroImpl basketRetroImpl = new BasketRetroImpl();

		AppBasketResponse response = basketRetroImpl.basketList(token);

		if (response == null) {
			return null;
		}
		//{1=
				//{272=
				//[{itemId=326.0, productId=272.0, itemName=★홈쇼핑★ 피부컨디션 살리는 팩 세트, price=19800.0, totalItemCnt=30.0, maxItemCnt=30.0, itemCnt=1.0, prodName=★홈쇼핑★ 스페셜 컨디션 팩 세트, brandId=1.0, prodDesc=알찬 구성, 믿을 수 없는 가격! 오직 발그레 에서, thumbUrl=/beauty/product/20170615/banner_155127000.png, sale=89.0, salePrice=19800.0, productDelivery={deliveryId=278.0, shippingType=0.0, deliveryCompany={code=01, name=우체국택배}, freeDelivery=-1.0, deliveryDate=2.0, deliveryPrice=2500.0, uniqueness=}, basketId=764.0, itemCount=1.0, brand={brandId=1.0, brandName=발그레, banner=, regDate=1.483675515E12, brandVisible=N}, stopSelling=0.0}]}, 8={39=[{itemId=31.0, productId=39.0, itemName=스파큘 울트라 더마톡스 필 크림 50ml (시트팩 5매 증정), price=9900.0, totalItemCnt=1000.0, maxItemCnt=100.0, itemCnt=998.0, prodName=스파큘 울트라 더마톡스 필 크림 (시트팩 5매 증정), brandId=8.0, prodDesc=72시간 끊임없는 미세침으로 죽은세포를 재생 촉진, thumbUrl=/beauty/product/20170627/banner_162559981.png, sale=74.0, salePrice=9900.0, productDelivery={deliveryId=30.0, shippingType=0.0, deliveryCompany={code=04, name=CJ대한통운}, freeDelivery=0.0, deliveryDate=2.0, deliveryPrice=2500.0, uniqueness=}, basketId=765.0, itemCount=1.0, brand={brandId=8.0, brandName=프라이빗21, banner=/beauty/brand/20170207/brand_173141517.png, regDate=1.486456301E12, brandVisible=Y}, stopSelling=0.0}], 200=[{itemId=231.0, productId=200.0, itemName=오크라 멜팅 토너 120ml, price=3900.0, totalItemCnt=1000.0, maxItemCnt=100.0, itemCnt=1000.0, prodName=오크라 멜팅 토너, brandId=8.0, prodDesc=거친 피부결과 각질을 정돈하고 자연주의 보습막을 형성, thumbUrl=/beauty/product/20170410/thumb_233731090.png, sale=82.0, salePrice=3900.0, productDelivery={deliveryId=206.0, shippingType=0.0, deliveryCompany={code=01, name=우체국택배}, freeDelivery=9700.0, deliveryDate=2.0, deliveryPrice=2500.0, uniqueness=}, basketId=766.0, itemCount=1.0, brand={brandId=8.0, brandName=프라이빗21, banner=/beauty/brand/20170207/brand_173141517.png, regDate=1.486456301E12, brandVisible=Y}, stopSelling=0.0}], 202=[{itemId=233.0, productId=202.0, itemName=셀 웨이커 로얄 블랙티 타임 리턴 앰플 30ml, price=7900.0, totalItemCnt=1000.0, maxItemCnt=100.0, itemCnt=1000.0, prodName=셀 웨이커 로얄 블랙티 타임 리턴 앰플, brandId=8.0, prodDesc=홍차수 + 홍차추출물 + 발효콩 함유 노안을 동안으로 가꾸는 엘리자베스 2세가 사랑한 블랙티, thumbUrl=/beauty/product/20170417/thumb_131141955.png, sale=91.0, salePrice=7900.0, productDelivery={deliveryId=208.0, shippingType=0.0, deliveryCompany={code=01, name=우체국택배}, freeDelivery=0.0, deliveryDate=2.0, deliveryPrice=2500.0, uniqueness=}, basketId=767.0, itemCount=1.0, brand={brandId=8.0, brandName=프라이빗21, banner=/beauty/brand/20170207/brand_173141517.png, regDate=1.486456301E12, brandVisible=Y}, stopSelling=0.0}]}}
		if (response.getResultCode().equals("200")) {
			//        if (response.getResultCode() == "200") {
			return response;

		} else {
			return null;
		}

	}


	@Override
	public AppBasketResponse basketAdd(String token, Long itemId, Long itemCount) throws Exception {

		BasketRetroImpl basketRetroImpl = new BasketRetroImpl();

		AppBasketResponse response = basketRetroImpl.basketAdd(token, itemId, itemCount);

		if (response == null) {
			return null;
		}

		if (response.getResultCode().equals("200")) {
			//        if (response.getResultCode() == "200") {

			return response;

		} else {
			return null;
		}

	}

	@Override
	public AppBasketResponse basketDelete(String token, Long basket_id[]) throws Exception {

		BasketRetroImpl basketRetroImpl = new BasketRetroImpl();

		AppBasketResponse response = basketRetroImpl.basketDelete(token, basket_id);
		System.out.println(response);
		if (response == null) {

			return null;

		}

		if (response.getResultCode().equals("200")) {

			return response;

		} else {

			return null;

		}

	}

	@Override
	public AppBasketResponse basketUpdate(String token, Long basket_id, int item_count) throws Exception {

		BasketRetroImpl basketRetroImpl = new BasketRetroImpl();

		AppBasketResponse response = basketRetroImpl.basketUpdate(token, basket_id, item_count);

		if (response == null) {

			return null;

		}

		if (response.getResultCode().equals("200")) {

			return response;

		} else {

			return null;

		}

	}


	@Override
	public AppBasketResponse basketUpdateCheck(String token, Long[] basket_id, int checked) throws Exception {
		BasketRetroImpl basketRetroImpl = new BasketRetroImpl();

		AppBasketResponse response = basketRetroImpl.basketUpdateCheck(token, basket_id, checked);

		if (response == null) {

			return null;

		}

		if (response.getResultCode().equals("200")) {

			return response;

		} else {

			return null;

		}
	}


	@Override
	public AppBasketResponse basketUpdateCheckAll(String token, int checked) throws Exception {
		BasketRetroImpl basketRetroImpl = new BasketRetroImpl();

		AppBasketResponse response = basketRetroImpl.basketUpdateCheckAll(token, checked);

		if (response == null) {

			return null;

		}

		if (response.getResultCode().equals("200")) {

			return response;

		} else {

			return null;

		}
	}

}