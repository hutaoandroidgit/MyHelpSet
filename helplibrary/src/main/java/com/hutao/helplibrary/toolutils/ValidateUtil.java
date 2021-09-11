package com.hutao.helplibrary.toolutils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 校验字符串
 * @author xutaisong
 *
 */
public class ValidateUtil
{

	/**
	 * <pre>
	 * [\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?
	 * </pre>
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		if (StringUtils.isNull(email) || !email.contains("@"))
			return false;

		if (email.length() <= 22) {
			String checkemail = "^([a-z0-9A-Z]+[_|-|\\.]?){0,}[a-z0-9A-Z]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			return validate(checkemail, email);
		} else {
			String a[] = email.split("@");
			if (a.length == 2) {
				String checkemailleft = "^([a-z0-9A-Z]+[_|-|\\.]?){0,}[a-z0-9A-Z]+$";
				String checkemailright = "^([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
				return validate(checkemailleft, a[0]) && validate(checkemailright, a[1]);
			}
		}
		return false;
	}

	public static boolean isCellphone(String cellphone) {
		String checkcellphone = "^(13[0-9]|15[0-9]|18[0-9])[0-9]{8}$";
		return validate(checkcellphone, cellphone);
	}

	public static boolean isCellphone15(String cellphone) {
		String checkcellphone = "^[0-9]{0,4}(13[0-9]|15[0-9]|18[0-9])[0-9]{8}$";
		return validate(checkcellphone, cellphone);
	}

	public static boolean isPhone(String cellphone) {
		String checkcellphone = "^[0-9\\,\\.\\#\\*\\(\\)\\+-\\;\\/\\s]+$";
		return validate(checkcellphone, cellphone);
	}

	public static boolean isE164(String e164) {
		String checkE164 = "^([0-9*#,]){1,16}$";
		return validate(checkE164, e164);
	}

	public static boolean isNumber(String number) {
		String checkE164 = "^[0-9]*$";
		return validate(checkE164, number);
	}

	public static boolean isHost(String host) {
		String checkHost = "^([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		return validate(checkHost, host);
	}

	public static boolean isIP(String ip) {
		String checkIP = "^((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))$";
		return validate(checkIP, ip);
	}

	public static boolean isVersion(String version) {
		String checkVersion = "^([0-9]*\\.)*[0-9]*$";
		return validate(checkVersion, version);
	}


	private static boolean validate(String patternStr, String matcherStr) {
		if (StringUtils.isNull(patternStr) || StringUtils.isNull(matcherStr)) {
			return false;
		}

		if (StringUtils.isNull(patternStr) || StringUtils.isNull(matcherStr)) {
			return false;
		}
		try {
			Pattern pattern = Pattern.compile(patternStr);
			Matcher matcher = pattern.matcher(matcherStr);
			return matcher.matches();
		} catch (PatternSyntaxException e) {
			e.printStackTrace();
			return false;
		}
	}


}
