package com.hutao.helplibrary.basebean;

import com.hutao.helplibrary.gson.GsonHelper;

public class BaseLong extends BaseBean{
	private long basetype;

	public long getBasetype() {
		return basetype;
	}

	public void setBasetype(long basetype) {
		this.basetype = basetype;
	}
	

	public BaseLong()
	{
		basetype = 0;
	}
	
	public BaseLong(final BaseLong baseInt)
	{
		this.basetype = baseInt.basetype;
	}
	
	public BaseLong( final String strJson )
	{
		fromString( strJson );
	}
	
	public void fromString( String strJson )
	{
		if ( strJson.isEmpty() )
		{
			return;
		}
		
		BaseLong baseInt = GsonHelper.fromJson( strJson, BaseLong.class );
		this.basetype = baseInt.basetype;
	}
	
	
	public long value() {
		return basetype;
	}
}
