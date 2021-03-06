package me.flyray.rest.controller.crm.weixin;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.flyray.crm.api.CustomerAuthService;
import me.flyray.crm.api.WeixinCommonService;
import me.flyray.crm.model.CustomerBase;
import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：2017年3月11日 下午10:55:05 
* @description：微信授权
*/

@Controller
@RequestMapping("/api/crm")
public class WxAuthController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WeixinCommonService weixinCommonService;
	@Autowired
	private CustomerAuthService customerAuthService;
	
	/**
	 * 通过code获取用户授权信息
	 * 获取到微信授权重定向时的参数
	 * 同时建立微信openid与机构商户的关系
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/getWxUser", method = RequestMethod.POST)
	public Map<String, Object> getWxCode(@RequestBody Map<String, String> param) throws Exception {
		logger.info("通过code获取用户授权信息------start------{}",param);
		String code = param.get("code");
		String merchantId = param.get("merchantId");
		String orgId = param.get("orgId");
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("code", code);
		requestMap.put("merchantId", merchantId);
		Map<String, Object> userMap = weixinCommonService.getOauthUserInfo(requestMap);
		logger.info("通过code获取用户授权信息------end------{}",userMap);
		if (userMap == null) {
			return ResponseHelper.success(userMap,null, "01", "调用微信授权失败");
		}
		
		/*wxMpUser.getCity() wxMpUser.getCountry()
		wxMpUser.getGroupId() wxMpUser.getHeadImgUrl() wxMpUser.getLanguage() wxMpUser.getNickname()
		wxMpUser.getOpenId() wxMpUser.getProvince() wxMpUser.getRemark() wxMpUser.getSex()
		wxMpUser.getSubscribe() wxMpUser.getTagIds() wxMpUser.getUnionId()*/
		
		CustomerBase customerBase = customerAuthService.customerAuth(userMap);
		//新增客户开户信息
		
		userMap.put("customerId", customerBase.getId().toString());
		return ResponseHelper.success(userMap,null, "00", "请求数据成功");
	} 
	
	
}
