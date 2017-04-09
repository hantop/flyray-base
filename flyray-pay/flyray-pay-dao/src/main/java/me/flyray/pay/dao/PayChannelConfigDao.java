package me.flyray.pay.dao;

import java.util.List;
import java.util.Map;

import me.flyray.pay.model.PayChannelConfig;

/** 
* @author: bolei
* @date：2017年4月8日 下午10:39:18 
* @description：支付通道配置 
*/

public interface PayChannelConfigDao {

	PayChannelConfig queryObject(Long id);
	
	List<PayChannelConfig> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PayChannelConfig payChannelConfig);
	
	void update(PayChannelConfig payChannelConfig);
	
}