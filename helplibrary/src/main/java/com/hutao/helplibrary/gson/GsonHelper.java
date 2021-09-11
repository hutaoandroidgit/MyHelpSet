package com.hutao.helplibrary.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.Primitives;
import com.hutao.helplibrary.basebean.BaseBool;
import com.hutao.helplibrary.log.OsduiLog;

public final class GsonHelper {
	private static final String TAG = "GsonHelper";
	private static Gson gsonInstance = null;
	
	public static Gson getInstance()
	{
		if(null == gsonInstance)
		{
			synchronized (GsonHelper.class)
			{
				if(null == gsonInstance)
				{
					gsonInstance = new Gson();
				}
			}
		}
		return gsonInstance;
	}
	
	@SuppressWarnings("finally")
	public static <T> T fromJson(String json, Class<T> classOfT) {
		T resultObj = null; 
		try {
//			Gson gson = new Gson();
//			OsduiLog.mtuiErrorLog("GsonHelper", "gsonInstance: " + gsonInstance);
			Object object = getInstance().fromJson(json, (Type) classOfT);
			resultObj = Primitives.wrap(classOfT).cast(object);
		} catch (Exception e) {
			e.printStackTrace();
			if(null == resultObj){
				try{
					resultObj = classOfT.newInstance();
				} catch (Exception e1) {
					OsduiLog.mtuiErrorLog(TAG, "instance obj exception ");
					e1.printStackTrace();
				}
			}
			OsduiLog.mtuiErrorLog(TAG, "json change exception resultObj: " + resultObj);
		} finally{
			return resultObj;
		}
	}

	public static <T> List<T> fromJsonArr(String json, Class<T> classOfT, String strSubKey) {
		List<T> lstResult = new ArrayList<T>();
//		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(json).getAsJsonObject();
		JsonElement jsonElement = jsonObject.get(strSubKey);
		JsonArray jsonArray = jsonElement.getAsJsonArray();

		// JsonArray jsonArray = jsonObject.getAsJsonArray(strSubKey);

		Iterator<?> it = jsonArray.iterator();

		while (it.hasNext()) {
			jsonElement = (JsonElement) it.next();
			String strJsonBean = jsonElement.toString();
			T obj = getInstance().fromJson(strJsonBean, classOfT);
			lstResult.add(obj);
		}

		return lstResult;
	}

	public static boolean JsonBool2Bool(StringBuffer strBufferJson) {
		if (null == strBufferJson) {
			return false;
		}

		BaseBool baseType = new BaseBool(strBufferJson.toString());

		return baseType.asBool();
	}

	public static boolean StringBool2Bool(String strBoolVal) {
		if (strBoolVal.equalsIgnoreCase("true")) {
			return true;
		} else if (strBoolVal.equalsIgnoreCase("false")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean StringBoolToBool(String strBoolVal) {
		if (strBoolVal.equalsIgnoreCase("true")) {
			return true;
		} else if (strBoolVal.equalsIgnoreCase("false")) {
			return false;
		} else {
			return false;
		}
	}

}
