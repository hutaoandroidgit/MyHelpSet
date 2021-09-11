package com.hutao.helplibrary.toolutils;

import android.content.Intent;
import android.os.Environment;
import com.hutao.helplibrary.log.OsduiLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 通用类
 * 
 * @author xutaisong
 * 
 */
public class CommonUtils
{
	public static final String TAG = CommonUtils.class.getSimpleName();
	private static final String REMOTE_FILE_SAVE_PATH = File.separator + "kedacom" + File.separator + "SkyRemote";
	
	public static int boolean2int(boolean tag)
	{
		return tag ? 1 : 0;
	}

	public static boolean int2boolean(int tag)
	{
		return 0 != tag;
	}

	public static String getObjectClassName(Object obj)
	{
		return obj == null ? "":obj.getClass().getSimpleName();
	}

	public static int max(int num1, int num2)
	{
		return num1 >= num2 ? num1 : num2;
	}

	public static int min(int num1, int num2)
	{
		return num1 <= num2 ? num1 : num2;
	}

	/**
	 * 功能 根据对象的方法名调用对应 的方法
	 * 
	 * @param obj
	 *            对象
	 * @param methodName
	 *            对象方法名
	 * @param intent
	 *            方法参数
	 */
	public static void callbackMsg(Object obj, String methodName, Intent intent)
	{
		if(obj == null || methodName == null || intent == null){
			OsduiLog.mtuiErrorLog(TAG,":::callbackMsg:::obj == null || methodName == null || intent == null!");
			return;
		}
		Class<? extends Object> clazz = obj.getClass();
		try
		{
			Method method = clazz.getDeclaredMethod(methodName, Intent.class);

			if (null != method)
			{
				method.setAccessible(true);
				method.invoke(obj, intent);
			}

		}
		catch (Exception e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			String msg = methodName + "invoke error";
			OsduiLog.mtuiErrorLog(getObjectClassName(obj), msg);
		}
	}

	public static String getFilePath(String fileUrl)
	{
		String filePath = "";
		if (!StringUtils.isEmpty(fileUrl))
		{
			filePath = fileUrl.substring(0, fileUrl.lastIndexOf("/"));
		}
		return filePath;
	}

	public static String getFileName(String fileUrl)
	{
		String fileName = "";
		if (!StringUtils.isEmpty(fileUrl))
		{
			fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1, fileUrl.length());
		}
		return fileName;
	}

	public static String getName(String fileUrl)
	{
		String name = "";
		String fileName = getFileName(fileUrl);
		if (!StringUtils.isEmpty(fileName))
		{
			name = fileName.substring(0, fileName.lastIndexOf("."));
		}
		return name;
	}

	public static long ipToLongBig(String strIp)
	{
		long ip = 0x0L;
		if(strIp == null || strIp.isEmpty()){
			OsduiLog.mtuiErrorLog(TAG,":::ipToLongBig:::strIp == null || strIp.isEmpty()!");
			return ip;
		}
		try
		{
			byte[] ipByte = InetAddress.getByName(strIp).getAddress();
			ip |= ipByte[0] & 0xFFl;
			ip |= (ipByte[1] & 0xFFl) << 8;
			ip |= (ipByte[2] & 0xFFl) << 16;
			ip |= (ipByte[3] & 0xFFl) << 24;
		}
		catch (UnknownHostException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ip;
	}

	public static long ipToLongSmall(String strIp)
	{
		long ip = 0x0L;
		
		if(strIp == null || strIp.isEmpty()){
			OsduiLog.mtuiErrorLog(TAG, ":::ipToLongSmall:::strIp == null || strIp.isEmpty()!");
			return ip;
		}
		try
		{
			byte[] ipByte = InetAddress.getByName(strIp).getAddress();
			ip |= ipByte[3] & 0xFFl;
			ip |= (ipByte[2] & 0xFFl) << 8;
			ip |= (ipByte[1] & 0xFFl) << 16;
			ip |= (ipByte[0] & 0xFFl) << 24;
		}
		catch (UnknownHostException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ip;
	}

	// 判断ip地址是否与正则表达式匹配
	public static boolean ipCheck(String text) {
		if (text != null && !text.isEmpty()) {
			// 定义正则表达式
			String regex = "(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})";
			// 判断ip地址是否与正则表达式匹配
			if (text.matches(regex)) {
				// 返回判断信息
				return true;
			} else {
				// 返回判断信息
				return false;
			}
		}else{
			// 返回判断信息
			return false;
		}
	}
	public static String intToIp(long paramLong)
	{
		return (paramLong & 0xFF) + "." + (paramLong >> 8 & 0xFF) + "." + (paramLong >> 16 & 0xFF) + "." + (paramLong >> 24 & 0xFF);
	}

	public static String intToIpSmall(long paramLong)
	{
		return (paramLong >> 24 & 0xFF) + "." + (paramLong >> 16 & 0xFF) + "." + (paramLong >> 8 & 0xFF) + "." + (paramLong & 0xFF);
	}

	public static boolean IsValidE164(String pchE164Num)
	{
		if (null == pchE164Num || 0 == pchE164Num.length())
		{
			OsduiLog.mtuiErrorLog(TAG, ":::IsValidE164:::null == pchE164Num || 0 == pchE164Num.length()!");
			return false;
		}

		int nLen = pchE164Num.length();
		for (int i = 0; i < nLen; i++)
		{
			if (pchE164Num.charAt(i) != '#' && (pchE164Num.charAt(i) < '0' || pchE164Num.charAt(i) > '9') && pchE164Num.charAt(i) != '*')
			{
				return false;
			}
		}

		return true;
	}

    public static boolean isNumeric(String value)
    {
    	if(value == null || value.isEmpty()){
    		OsduiLog.mtuiHintLog(TAG, ":::isNumeric:::value == null || value.isEmpty()!");
    		return false;
    	}
    	for(int i = 0; i < value.length(); i++)
    	{
    		if(!Character.isDigit(value.charAt(i)))
    		{
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * 深度克隆
     * @param src
     * @return
     * @throws RuntimeException
     */
	@SuppressWarnings("unchecked")
	public static <T> T cloneTo(T src) throws RuntimeException {

		ByteArrayOutputStream memoryBuffer = new ByteArrayOutputStream();
		ObjectOutputStream out = null;
		ObjectInputStream in = null;

		T dist = null;
		try {

			out = new ObjectOutputStream(memoryBuffer);
			out.writeObject(src);
			out.flush();

			in = new ObjectInputStream(new ByteArrayInputStream(memoryBuffer.toByteArray()));
			dist = (T) in.readObject();

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (out != null)
				try {
					out.close();
					out = null;
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			if (in != null)
				try {
					in.close();
					in = null;
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
		}
		return dist;
	}
	
    //判断是否包含中文，不精确；中文下的符号无效
    public static boolean isContainCH(String str)
    {
    	if(str != null){
    		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
	    	Matcher m = p.matcher(str);
	    	if(m.find())
	    	{
	    		return true;
	    	}
    	}else{
    		OsduiLog.mtuiErrorLog(TAG, ":::isContainCH:::str == null!");
    	}
    	return false;
    }
    
    // 根据Unicode编码完美的判断中文汉字和符号
    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }
 
    // 完整的判断中文汉字和符号
    public static boolean isChinese(String strName) {
    	if(strName != null){
    		char[] ch = strName.toCharArray();
	        for (int i = 0; i < ch.length; i++) {
	            char c = ch[i];
	            if (isChinese(c)) {
	                return true;
	            }
	        }
    	}
        return false;
    }

	public static boolean containIllegality(String str)
	{
		if(!StringUtils.isEmpty(str))
		{
			//\?/<>":*|不和法的字符
			StringBuffer mSB = new StringBuffer();
			mSB.append("\\");
			mSB.append("?");
			mSB.append("/");
			mSB.append("<");
			mSB.append(">");
			mSB.append("\"");
			mSB.append(":");
			mSB.append("*");
			mSB.append("|");
			
			for(int i = 0; i < mSB.length(); i++)
			{
				String v = mSB.substring(i, i+1);
				if(str.contains(v))
				{
					return true;
				}
			}
			return false;
		}
		return false;
	}

	public static String toMD5Str(String plainText)
	{
		StringBuffer buf = new StringBuffer("");
		if(plainText != null){
			try
			{
				// 生成实现指定摘要算法的 MessageDigest 对象。
				MessageDigest md = MessageDigest.getInstance("MD5");
				// 使用指定的字节数组更新摘要。
				md.update(plainText.getBytes());
				// 通过执行诸如填充之类的最终操作完成哈希计算。
				byte b[] = md.digest();
				// 生成具体的md5密码到buf数组
				int i;
				for (int offset = 0; offset < b.length; offset++)
				{
					i = b[offset];
					if (i < 0)
						i += 256;
					if (i < 16)
						buf.append("0");
					buf.append(Integer.toHexString(i));
				}
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return buf.toString();
	}
	
	public static int setConvertValue(int curValue,boolean bRound)
	{
		OsduiLog.mtuiHintLog(TAG, "setConvertValue curValue is: " + curValue);
		int value = (int) (bRound ? Math.round(curValue * 2.55):curValue);
		OsduiLog.mtuiHintLog(TAG, "setConvertValue value is: " + value);
		return value;
	}
	
	public static int getConvertValue(int curValue,boolean bRound)
	{
		OsduiLog.mtuiHintLog(TAG, "getConvertValue curValue is: " + curValue);
		int value = (int) (bRound ? Math.round((curValue / 2.55)):curValue);
		OsduiLog.mtuiHintLog(TAG, "getConvertValue value is: " + value);
		return value;
	}
	

	/**
	 * SkyRemote获取储存根路径
	 * @author kangdi
	 */
	private static String getRemotePathRoot() {
		String remotePathRoot = "";
		// SD卡正常挂载
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			remotePathRoot = Environment.getExternalStorageDirectory().getAbsolutePath();
		} else {
			// 路径是:/data/data/< package name >/files
			//remotePathRoot = AppGlobal.getApplicationContext().getFilesDir().getAbsolutePath();
		}
		return remotePathRoot;
	}

	/**
	 * 获取SkyRemote储存路径
	 * @return
	 * @author kangdi
	 */
	public static String getRemoteSavePath() {
		return getRemotePathRoot() + REMOTE_FILE_SAVE_PATH;
	}
	
	/**
	 * 获取SkyRemote储存路径
	 * @param filePath
	 * @return
	 * @author kangdi
	 */
	public static String getRemoteSavePath(String filePath){
		return getRemotePathRoot() + REMOTE_FILE_SAVE_PATH + filePath;
	}

	public static <V> boolean isEmpty(Set<V> paramSet){
	    
		return (paramSet == null) || (paramSet.size() == 0);
		
	}
	/**
	 * 会议号格式化风格
	 * 目前：7位3+4,8位4+4,9位3+3+3,10位3+3+4
	 * @param confNum
	 * @return
	 * @author kangdi
	 */
	public static String formatConfNumber(String confNum){
		if(confNum == null || confNum.isEmpty() || confNum.length() <= 3){
			OsduiLog.mtuiErrorLog(TAG,":::formatConfNumber:::error confNum=="+confNum);
		}else {
			StringBuffer sb = new StringBuffer(confNum);
			switch (sb.length()){
				case 7:
					sb.insert(3 , " ");
					break;
				case 8:
					sb.insert(4 , " ");
					break;
				case 9:
				case 10:
					sb.insert(3 , " ");
					sb.insert(7 , " ");
					break;
			}
			confNum = sb.toString();
		}
		return confNum;
	}

	/**
	 * 生成WEBMTC密码 规则：6位数字+2位随机的大写字母，不包含0、1、I、O
	 *
	 * @return
	 */
	public static String createWEBMTCPassword2() {
		char[] num = { '2', '3', '4', '5', '6', '7', '8', '9' };
		char[] letter = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		int numCount = 6;
		int letterCount = 2;
		StringBuffer pwd = new StringBuffer();
		Random ran = new Random();
		for (int i = 0; i < numCount; i++) {
			pwd.append(num[ran.nextInt(num.length)]);
		}
		for (int i = 0; i < letterCount; i++) {
			pwd.insert(ran.nextInt(pwd.length()), letter[ran.nextInt(letter.length)]);
		}
		return pwd.toString();
	}
	/**
	 * Wi-Fi默认AP名称为MTAP_4位随机数，4位随机数由字母和数字组成，字母都是大写，不包含I、O、0、1
	 *
	 * @return 默认AP名称
	 */
	public static String defaultAPName() {
		StringBuilder sb = new StringBuilder("MTAP_");
		char[] union = new char[32];
		int j = 0;
		for (int i = 0; i < 10; i++) {
			if (i == 0 || i == 1) {
				continue;
			}
			union[j] = Character.forDigit(i, 10);
			j++;
		}
		for (int i = 'A'; i <= 'Z'; i++) {
			if (i == 'I' || i == 'O') {
				continue;
			}
			union[j] = (char) i;
			j++;
		}
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			sb.append(union[random.nextInt(union.length)]);
		}
		return sb.toString();
	}
}
