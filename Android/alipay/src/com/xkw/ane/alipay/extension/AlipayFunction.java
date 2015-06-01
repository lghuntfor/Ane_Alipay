package com.xkw.ane.alipay.extension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import android.app.Activity;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.xkw.ane.alipay.Alipay;


/**
 * FREFunction的具体实现
 * 在这里的call方法里面写调用java和android接口的代码
 * @author anonymous
 */


public class AlipayFunction implements FREFunction {

	/**
	 * 接收一个参数(需要调用方法的方法名),
	 * 使用反射通过传入的方法名执行PhoneInfo对象对应的方法,
	 * 获取所需要的返回值信息
	 */
	@Override
	public FREObject call(FREContext pContext, FREObject[] params) {
		Activity activity = pContext.getActivity();
		Alipay alipay = new Alipay(activity);
		
		FREObject result = null;
		
		try {
			String value = null;
			String methodName = params[0].getAsString();
			
			if(params.length>1){
				Object[] args = new Object[params.length-1];
				
				@SuppressWarnings("unchecked")
				Class<String>[] classes = new Class[params.length-1];
				for(int k=1; k<params.length; k++) {
					args[k-1] = params[k].getAsString();
					classes[k-1] = String.class;
				}
				Method method = Alipay.class.getMethod(methodName, classes);
				value = method.invoke(alipay,args).toString();
			} else {
				Method method = Alipay.class.getMethod(methodName);
				value = method.invoke(alipay).toString();
			}
			
			result = FREObject.newObject(value);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
			try {
				return FREObject.newObject("---Android: IllegalStateException!" +"\n"+
						"---Exception Message: " + e1.getMessage());
			} catch (FREWrongThreadException e) {
				e.printStackTrace();
			}
		} catch (FRETypeMismatchException e1) {
			e1.printStackTrace();
			try {
				return FREObject.newObject("---Android: FRETypeMismatchException!" +"\n"+
						"---Exception Message: " + e1.getMessage());
			} catch (FREWrongThreadException e) {
				e.printStackTrace();
			}
		} catch (FREInvalidObjectException e1) {
			e1.printStackTrace();
			try {
				return FREObject.newObject("---Android: FREInvalidObjectException!" +"\n"+
						"---Exception Message: " + e1.getMessage());
			} catch (FREWrongThreadException e) {
				e.printStackTrace();
			}
		} catch (FREWrongThreadException e1) {
			e1.printStackTrace();
			try {
				return FREObject.newObject("---Android: FREWrongThreadException!" +"\n"+
						"---Exception Message: " + e1.getMessage());
			} catch (FREWrongThreadException e) {
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			try {
				return FREObject.newObject("---Android: NoSuchMethodException!" +"\n"+
						"---Exception Message: " + e.getMessage());
			} catch (FREWrongThreadException e1) {
				e1.printStackTrace();
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			try {
				return FREObject.newObject("---Android: IllegalAccessException!" +"\n"+
						"---Exception Message: " + e.getMessage());
			} catch (FREWrongThreadException e1) {
				e1.printStackTrace();
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			try {
				return FREObject.newObject("---Android: IllegalArgumentException!" +"\n"+
						"---Exception Message " + e.getMessage());
			} catch (FREWrongThreadException e1) {
				e1.printStackTrace();
			}
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			try {
				return FREObject.newObject("---Android: InvocationTargetException!"+"\n"+
						"---TargetException: "+e.getTargetException()+"\n" +
						"---Exception Message: "+e.getTargetException().getMessage());
			} catch (FREWrongThreadException e1) {
				e1.printStackTrace();
			}
		}
		return result;
	}

}
