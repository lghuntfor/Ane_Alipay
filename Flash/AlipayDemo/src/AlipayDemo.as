package
{
	import com.xkw.ane.alipay.Alipay;
	
	import flash.display.Sprite;
	import flash.display.StageAlign;
	import flash.display.StageScaleMode;
	import flash.text.TextField;
	import flash.text.TextFormat;
	
	public class AlipayDemo extends Sprite
	{
		
		private var tf:TextField;
		public function AlipayDemo()
		{
			super();
			
			//支持 autoOrient
			stage.align = StageAlign.TOP_LEFT;
			stage.scaleMode = StageScaleMode.NO_SCALE;
			
			tf = new TextField();
			
			var alipay:Alipay = new Alipay();
			
			var PARTNER:String = alipay.getMetaData("PARTNER");
			var SELLER:String = alipay.getMetaData("SELLER");
			var RSA_PRIVATE:String = alipay.getMetaData("RSA_PRIVATE");
			var RSA_PUBLIC:String = alipay.getMetaData("RSA_PUBLIC");
			
			var outTradeNo:String = alipay.getOutTradeNo();
			var pay:String = alipay.pay(outTradeNo, "研八-支付宝支付接入调试", "研八-支付宝支付接入调试,支付0.01元", "0.01", "http://121.41.117.137:88/xueyi_ucenter/index.php/userFinance/apliyReturn");
			
			var info:String = "\n"
				+"PID:"+PARTNER +"\n"
				+"支付宝账户:"+SELLER +"\n"
				+"商户私钥:"+RSA_PRIVATE +"\n"
				+"支付宝公钥:"+RSA_PUBLIC +"\n"
				+"订单号:"+outTradeNo +"\n"
				+"支付结果:"+pay +"\n"
				;
			
			tf.text = info;
			tf.width = 1000;
			tf.height = 1500;
			var formatter:TextFormat = new TextFormat();
			formatter.size = 35;
			tf.setTextFormat(formatter);
			addChild(tf);
		}
	}
}