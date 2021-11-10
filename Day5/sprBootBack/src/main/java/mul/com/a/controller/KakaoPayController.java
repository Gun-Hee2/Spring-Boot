package mul.com.a.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.json.JsonParser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mul.com.a.vo.kakaoPayVO;

@RestController
public class KakaoPayController {

	@RequestMapping(value = "/kakaopay")
	public String kakaopay() {
		System.out.println("KakaoPayController kakaopay()");
		try {
			URL address = new URL("https://kapi.kakao.com/v1/payment/ready");
			HttpURLConnection conn = (HttpURLConnection) address.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "KakaoAK 704f7b7e7e27e8835b13944d7744c8c0");
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			conn.setDoOutput(true);
			String parameter = "cid=TC0ONETIME&partner_order_id=1&partner_user_id=MultiCinema&item_name=" + "초코파이" + "&quantity=1&total_amount=8500&vat_amount=200&tax_free_amount=0&approval_url=http://localhost:8090/sprBootFront/kakaoPaySuccess.html&fail_url=https://localhost/fail&cancel_url=https://localhost/cancel";
			OutputStream give = conn.getOutputStream();
			DataOutputStream datagive = new DataOutputStream(give);
			datagive.writeBytes(parameter);
			datagive.close();
			
			int result = conn.getResponseCode();
			
			InputStream receive;
			if(result == 200) {
				receive = conn.getInputStream();
			}else {
				receive = conn.getErrorStream();
			}
			
			InputStreamReader reader = new InputStreamReader(receive);
			
			BufferedReader caster = new BufferedReader(reader);
			
			return caster.readLine();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "{\"result\":\"NO\"}";
	}
	
	@RequestMapping(value = "/kakaopayready", method = RequestMethod.GET)
	public String kakaopayready(kakaoPayVO kakaoinfo, String tid, Model model, String url) {
		
		System.out.println(tid);
		
		/*
		System.out.println(url);
		
		kakaoinfo.setTid(tid);
		
		String tidd = kakaoinfo.getTid();
		
		model.addAttribute("tid", tidd);
		*/
		
		return "redirect:" + url;
	}
	
	@RequestMapping(value = "/kakaopaysuccess", method = RequestMethod.GET)
	public String kakaopaysuccess(@RequestParam("pg_token") String pg_token, kakaoPayVO kakaoinfo) {
		System.out.println("KakaoPayController kakaopaysuccess()");
		System.out.println(pg_token);
		
		
		
		/*
		try {
			URL address = new URL("https://kapi.kakao.com/v1/payment/approve");
			HttpURLConnection conn = (HttpURLConnection) address.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "KakaoAK 704f7b7e7e27e8835b13944d7744c8c0");
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			conn.setDoOutput(true);
			String parameter = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name=초코파이&quantity=1&total_amount=2200&vat_amount=200&tax_free_amount=0&approval_url=http://localhost:3000/kakaopaysuccess&fail_url=https://localhost/fail&cancel_url=https://localhost/cancel";
			OutputStream give = conn.getOutputStream();
			DataOutputStream datagive = new DataOutputStream(give);
			datagive.writeBytes(parameter);
			datagive.close();
			
			int result = conn.getResponseCode();
			
			InputStream receive;
			if(result == 200) {
				receive = conn.getInputStream();
			}else {
				receive = conn.getErrorStream();
			}
			
			InputStreamReader reader = new InputStreamReader(receive);
			
			BufferedReader caster = new BufferedReader(reader);
			
			return caster.readLine();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "{\"result\":\"NO\"}";
		*/
		return "";
	}
}
