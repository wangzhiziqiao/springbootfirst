package com.dcits.system;

import java.util.List;
import java.util.Map;

public class GBean {
	/**
	 * 
	 * @param strs
	 * @return
	 */
	public static String gBean(String packageName, String className, List<Map<String, String>> list) {
		StringBuffer sb = new StringBuffer();
		sb.append("package").append(packageName).append(";");
		sb.append("public class User {");
		for (int i = 0; i < list.size(); i++) {
			Map<String, String> map = list.get(i);
			sb.append("private").append(map.get("type")).append(map.get("val")).append(";");
		}

		for (int i = 0; i < list.size(); i++) {
			Map<String, String> map = list.get(i);
			String val = map.get("val");
			val = val.substring(0, 1).toUpperCase() + val.substring(1,val.length());
			sb.append("public").append(map.get("type")).append("get");
//			public Long getId() {
//				return id;
//			}

//			public void setId(Long id) {
//				this.id = id;
//			}
		}
		sb.append("}");
		return null;
	}

	public static void main(String[] args) {

	}
}
