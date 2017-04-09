package me.flyray.pay.service.pay.wechat;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import me.flyray.pay.api.PayObjectService;
import me.flyray.pay.dto.OnlinePaymentRequest;

/** 
* @author: bolei
* @date：2017年2月23日 上午11:42:34 
* @description： 微信公众号、h5支付
*/

@Service("wechatJsApiPaymentService")
public class WechatJsApiPaymentService implements PayObjectService<OnlinePaymentRequest>{

	private static final Logger logger = LoggerFactory.getLogger(WechatJsApiPaymentService.class);

	@Override
	public Map<String, Object> pay(OnlinePaymentRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	

}