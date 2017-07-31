package net.balgre.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DevicePlatform;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class DeviceAspect {
	
	@After("execution(* net.balgre.controller.*.*(..))")
	public void getDeviceCheck() throws Exception {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
		Device device = DeviceUtils.getCurrentDevice(request);   
		if (device == null) {
			System.out.println("NULL DEVICE");
        }
        String deviceType = "unknown";
        if (device.isNormal()) {
            deviceType = "nomal";
            System.out.println("NORMAL");
        } else if (device.isMobile()) {
            deviceType = "mobile";
            System.out.println(device.getDevicePlatform());
            if(device.getDevicePlatform() == DevicePlatform.ANDROID) {
            	response.sendRedirect("intent://balgeure.co.kr/#Intent;scheme=https;action=android.intent.action.VIEW;category=android.intent.category.BROWSABLE;package=sumcreative.com.beauty;end;");
            } else if(device.getDevicePlatform() == DevicePlatform.IOS) {
            	response.sendRedirect("https://appsto.re/kr/0bjijb.i");
            }
        } else if (device.isTablet()) {
            deviceType = "tablet";
            System.out.println("TABLET");
        }
        
        request.getSession().setAttribute("deviceType", deviceType);
	}
	
}
