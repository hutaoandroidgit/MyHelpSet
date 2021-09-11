/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hutao.helplibrary.toolutils;

/**
 * 字符串编码转化
 * @author xutaisong
 */
public class CharsEncodingConvertUtils
{

	private static String PREFIX = "\\u";

	/**
	 * 根据相对路径读取
	 * @param iniValue
	 * @return
	 */
	public static String iniToUTF8(String iniValue) {
		try {
			byte[] bytes = iniValue.getBytes("ISO-8859-1");
			String temp2 = new String(bytes, "GBK");
			String strUnicode = GBK2Unicode(temp2);
			String strNative = ascii2Native(strUnicode);

			// byte[] bytesUtf = gbk2utf8(temp2);
			// String temp3 = new String(bytesUtf, "utf-8");
			return strNative;
		} catch (Exception e) {
			 e.printStackTrace();
			return "";
		}

	}

	/**
	 * 把GBK的字符串转成的Unicode字符串
	 * @param str
	 * @return
	 */
	public static String GBK2Unicode(String str){
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < str.length(); i++) {
			char chr1 = str.charAt(i);
			if (!isNeedConvert(chr1)) {
				result.append(chr1);
				continue;
			}
			result.append(PREFIX + Integer.toHexString(chr1));
		}
		return result.toString();
	}

	// 把Unicode的字符串转成GBK的字符串
	public static String Unicode2GBK(String dataStr) {
		int index = 0;
		StringBuffer buffer = new StringBuffer();
		try {
			while (index < dataStr.length()) {
				if (index + 2 >= dataStr.length()
						|| (index + 2 < dataStr.length() && !PREFIX.equals(dataStr.substring(index, index + 2)))) {
					buffer.append(dataStr.charAt(index));
					index++;
					continue;
				}

				if (index + 6 > dataStr.length()) {
					buffer.append(dataStr.charAt(index + 2));
					index += 2;
					continue;
				} else {
					String charStr = "";
					charStr = dataStr.substring(index + 2, index + 6);

					char letter = (char) Integer.parseInt(charStr, 16);
					buffer.append(letter);
					index += 6;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return buffer.toString();
	}

	public static boolean isNeedConvert(char para) {
		return ((para & (0x00FF)) != para);
	}

	// 把Unicode格式的字符串转成UTF-8格式的字符串
	public static String ascii2Native(String str) {
		StringBuilder sb = new StringBuilder();
		int begin = 0;
		int index = str.indexOf(PREFIX);
		while (index != -1) {
			sb.append(str.substring(begin, index));
			sb.append(ascii2Char(str.substring(index, index + 6)));
			begin = index + 6;
			index = str.indexOf(PREFIX, begin);
		}
		sb.append(str.substring(begin));
		return sb.toString();
	}

	// 把Unicode格式的字符转成UTF-8格式的字符串
	private static char ascii2Char(String str) {
		if (str.length() != 6) {
			throw new IllegalArgumentException("Ascii string of a native character must be 6 character.");
		}
		if (!PREFIX.equals(str.substring(0, 2))) {
			throw new IllegalArgumentException("Ascii string of a native character must start with \"\\u\".");
		}
		String tmp = str.substring(2, 4);
		int code = Integer.parseInt(tmp, 16) << 8;
		tmp = str.substring(4, 6);
		code += Integer.parseInt(tmp, 16);
		return (char) code;
	}

	// 把UTF-8格式的字符串转成Unicode格式的字符串
	public static String native2Ascii(String str) {
		char[] chars = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			sb.append(char2Ascii(chars[i]));
		}
		return sb.toString();
	}

	// 把UTF-8格式的字符转成Unicode格式的字符串
	private static String char2Ascii(char c) {
		if (c > 255) {
			StringBuilder sb = new StringBuilder();
			sb.append(PREFIX);
			int code = (c >> 8);
			String tmp = Integer.toHexString(code);
			if (tmp.length() == 1) {
				sb.append("0");
			}
			sb.append(tmp);
			code = (c & 0xFF);
			tmp = Integer.toHexString(code);
			if (tmp.length() == 1) {
				sb.append("0");
			}
			sb.append(tmp);
			return sb.toString();
		} else {
			return Character.toString(c);
		}
	}

	public static String UTF82GBK(String utf8String) {
		if (utf8String == null || utf8String.length() == 0)
			return utf8String;
		try {
			String unicodeValue = native2Ascii(utf8String);
			String gbkValue = Unicode2GBK(unicodeValue);
			byte[] gbkBytes = gbkValue.getBytes("GBK");
			String gbkString = new String(gbkBytes, "ISO-8859-1");
			return gbkString;
		} catch (Exception e) {
			return utf8String;
		}
	}

}
