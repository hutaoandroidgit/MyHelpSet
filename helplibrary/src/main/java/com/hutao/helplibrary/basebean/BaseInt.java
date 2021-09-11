package com.hutao.helplibrary.basebean;

import com.hutao.helplibrary.gson.GsonHelper;

public class BaseInt extends BaseBean {
	private int basetype;

	public int getBasetype() {
		return basetype;
	}

	public void setBasetype(int basetype) {
		this.basetype = basetype;
	}
	

	public BaseInt()
	{
		basetype = 0;
	}
	
	public BaseInt(final BaseInt baseInt)
	{
		this.basetype = baseInt.basetype;
	}
	
	public BaseInt( final String strJson )
	{
		fromString( strJson );
	}
	
	public void fromString( String strJson )
	{
		if ( strJson.isEmpty() )
		{
			return;
		}
		
		BaseInt baseInt = GsonHelper.fromJson( strJson, BaseInt.class );
		this.basetype = baseInt.basetype;
	}
	
	
	public int value() {
		return basetype;
	}
}
