package com.cqut.tool.util;

import javax.servlet.http.HttpServletRequest;

public class JToolWeb {

	// 文件下载时文件名在ie和firefox下面表现不一致问题，乱码
	public static String processFileName(HttpServletRequest request,
			String fileNames) {
		String codedfilename = null;
		try {
			String agent = request.getHeader("USER-AGENT");
			if (null != agent && -1 != agent.indexOf("MSIE")) {// ie
				String prefix = fileNames.lastIndexOf(".") != -1 ? fileNames
						.substring(0, fileNames.lastIndexOf(".")) : fileNames;
				String extension = fileNames.lastIndexOf(".") != -1 ? fileNames
						.substring(fileNames.lastIndexOf(".")) : "";
				String name = java.net.URLEncoder.encode(fileNames, "UTF8");
				if (name.lastIndexOf("%0A") != -1) {
					name = name.substring(0, name.length() - 3);
				}
				int limit = 150 - extension.length();// 文件名超过 17 个中文字符，在 IE
														// 下会有问题
				if (name.length() > limit) {
					name = java.net.URLEncoder.encode(
							prefix.substring(0,
									Math.min(prefix.length(), limit / 9)),
							"UTF-8");
					if (name.lastIndexOf("%0A") != -1) {
						name = name.substring(0, name.length() - 3);
					}
				} else {
					return name;
				}
				codedfilename = name + extension;
			} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐
				codedfilename = "=?UTF-8?B?"
						+ (new String(
								org.apache.commons.codec.binary.Base64
										.encodeBase64(fileNames
												.getBytes("UTF-8")))) + "?=";
			} else {
				codedfilename = fileNames;
			}
		} catch (Exception e) {
			System.out.println("客户使用火狐浏览器!");
			// e.printStackTrace();
		}
		return codedfilename;
	}
}