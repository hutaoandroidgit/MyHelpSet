package com.hutao.helplibrary.basebean;

import com.google.gson.Gson;
import com.hutao.helplibrary.log.OsduiLog;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @description 基础Bean
 * @param 
 * @return 
 * @author hutao
 * @time 2021/9/9 18:56
 */
public class BaseBean implements Serializable, IDefaultData<BaseBean> {
	
	transient public final String TAG = this.getClass().getSimpleName();

	public String toJsonString()
	{
		Gson gson = new Gson();

		String json = gson.toJson( this ); 

		//System.out.print(json);
		
		return json;
	}
	
	public StringBuffer toJsonStringBuffer()
	{
		Gson gson = new Gson();
		
		StringBuffer sb = new StringBuffer( gson.toJson( this ) );
		return sb;
	}
	
	public StringBuffer toJsonStrBuf()
	{
		Gson gson = new Gson();
		
		StringBuffer sb = new StringBuffer( gson.toJson( this ) );
		
		return sb;
	}

	@Override
	public BaseBean fillDefaultData() {
		try{
			OsduiLog.mtuiDebugLog(TAG,":::fillDefaultData:::this=="+this);
			for(Field field : this.getClass().getDeclaredFields()){
				field.setAccessible(true);
				Class<?> type = field.getType();
				if(IDefaultData.class.isAssignableFrom(type)){
					field.set(this, type.newInstance());
					((IDefaultData)field.get(this)).fillDefaultData();
				}else if(String.class.isAssignableFrom(type)){
					field.set(this, type.newInstance());
				}else if(Enum.class.isAssignableFrom(type)){
					Method methodValues = type.getDeclaredMethod("values");
					methodValues.setAccessible(true);
					Object obj = methodValues.invoke(null);
					Enum<?>[] enums = (Enum[]) obj;
					if(enums.length != 0){
						field.set(this, enums[0]);
					}
				}else if(type.isArray()){
					field.set(this, Array.newInstance(type.getComponentType(), 0));
				}else if(List.class.isAssignableFrom(type)){
					field.set(this, new ArrayList<Object>());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return this;
	}
}


