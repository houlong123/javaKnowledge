package com.houlong.crypto;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Genete {

	public static void main(String[] args) throws Exception {
		Map<String, Object> params = new TreeMap<String, Object>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// 降序排序
                return o1.compareTo(o2);
			}
		});
		
		//String encrypt = ParamsDecryptionHelper.getParamsEncrypt(params,"");
		//System.out.println(encrypt);
		System.out.println(ParamsDecryptionHelper.getParamsDecode("","312099039175holguon"));
	}
}