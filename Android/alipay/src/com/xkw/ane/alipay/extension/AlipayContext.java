package com.xkw.ane.alipay.extension;
import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

/**
 * FREContext的子类
 * @author anonymous
 */

public class AlipayContext extends FREContext {

	public AlipayContext() {
	}
	
	@Override
	public void dispose() {
	}
	
	@Override
	public Map<String, FREFunction> getFunctions() {
		HashMap<String, FREFunction> map = new HashMap<String, FREFunction>();  
		//暴露air里能调用的函数名,getSystemVersion在AIR中可以使用，对应的类是SystemVersionFunction 
        map.put("alipay", new AlipayFunction());  
        return map;
	}
}
