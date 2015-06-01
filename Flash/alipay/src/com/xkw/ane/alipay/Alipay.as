package com.xkw.ane.alipay
{
	import flash.external.ExtensionContext;

	public class Alipay
	{
		private var extContext:ExtensionContext;
		public static const EXTENSION_ID:String = "com.xkw.ane.alipay";
		public static const FAILED_RESULT:String = "ExtensionContext创建失败";
		public static const KEY:String = "alipay";
		
		public function Alipay()
		{
			//创建扩展的上下文
			extContext = ExtensionContext.createExtensionContext(EXTENSION_ID, "");
		}
		
		
		/**
		 * 调用支付宝支付
		 * @param outTradeNo 	订单号
		 * @param productName 	产品名称
		 * @param productDes	产品描述
		 * @param price		支付金额
		 * @param notifyUrl		异步通知页面路径
		 * @return
		 */
		public function pay(outTradeNo:String, productName:String, productDes:String, price:String, notifyUrl:String):String {
			if(extContext) {
				return extContext.call(KEY, "pay", outTradeNo, productName, productDes, price, notifyUrl) as String;
			}
			return FAILED_RESULT;
		}
		
		
		/**
		 * 获取项目配置文件中meta_data数据
		 * @param key
		 * @return
		 */
		public function getMetaData(metaKey:String): String {
			if(extContext) {
				return extContext.call(KEY, "getMetaData", metaKey) as String;
			}
			return FAILED_RESULT;
		}
		
		
		/**
		 * 根据当前时间随机生成商户订单号
		 */
		public function getOutTradeNo(): String {
			if(extContext) {
				return extContext.call(KEY, "getOutTradeNo") as String;
			}
			return FAILED_RESULT;
		}
		
	}
}