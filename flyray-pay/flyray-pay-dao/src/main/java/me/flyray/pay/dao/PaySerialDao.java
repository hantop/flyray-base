package me.flyray.pay.dao;

import java.util.List;
import java.util.Map;

import me.flyray.pay.model.PaySerial;

/** 
* @author: bolei
* @date：2017年4月8日 下午10:42:32 
* @description：支付流水 
*/

public interface PaySerialDao {

	List<PaySerial> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PaySerial paySerial);
	
	void update(PaySerial paySerial);
	
}