package com.houlong.crypto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.logging.Logger;

/**
 * 链接参数加解密辅助类
 * @author houlong
 *
 */

public class ParamsDecryptionHelper {


	/**
	 * 加密链接参数，并返回加密后链接
	 * @param params
	 * @param url
	 * @param secretkey
	 * @return
	 */
	public String getParamsEncryptUrl(HashMap<String, Object> params,String url, String secretkey) {
		try {
			//拼装参数
			String keyString = getParamsEncrypt(params,secretkey);
		    url = url+"?pkInfo="+keyString;
			return url;
		} catch (Exception e) {
		}
		return "";
	}
	

    /**
     * 参数加密，返回加密后的字符串
     * @param params
     * @param secretkey
     * @return
     */
	public static String getParamsEncrypt(Map<String, Object> params,String secretkey) throws Exception{
		StringBuilder paramStr = new StringBuilder();
		int index = 0;
		for (Entry<String,Object> entry : params.entrySet()) {
			if (index > 0) {
				paramStr.append('&').append(entry.getKey()).append('=').append(entry.getValue());
			}else {
				paramStr.append(entry.getKey()).append('=').append(entry.getValue());
			}
			index++;
		}
		
		//参数加密
		CryptoUtil.getKey(secretkey);
		return CryptoUtil.getEncString(paramStr.toString());
		
	}

	/**
     * 解密分享链接中参数，放入Map中
     * @param pkInfo
     * @param secretkey
     * @return
     */
    public static Map<String, String> getParamsDecode(String pkInfo,String secretkey) {
    	Map<String, String> paramMaps =  new TreeMap<String, String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// 降序排序
                return o1.compareTo(o2);
			}
		});
    	try {
    		CryptoUtil.getKey(secretkey);
        	String decodeParams = CryptoUtil.getDesString(pkInfo);
        	String[] params = decodeParams.split("&");
        	for (String param : params) {
        		String[] paramInfo = param.split("=");
				paramMaps.put(paramInfo[0], paramInfo[1]);
			}
		} catch (Exception e) {
			
		}
    	
		return paramMaps;
	}
}
