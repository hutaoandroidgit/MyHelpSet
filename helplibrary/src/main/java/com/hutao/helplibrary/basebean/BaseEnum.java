package com.hutao.helplibrary.basebean;


import com.hutao.helplibrary.gson.GsonHelper;

public class BaseEnum extends BaseBean{
	private int basetype;

	public int getBasetype() {
		return basetype;
	}

	public void setBasetype(int basetype) {
		this.basetype = basetype;
	}
	
	public BaseEnum()
	{
		basetype = 0;
	}
	
	public BaseEnum(final BaseEnum baseEnum)
	{
		this.basetype = baseEnum.basetype;
	}
	
	public BaseEnum( final String strJson )
	{
		fromString( strJson );
	}
	
	public void fromString( String strJson )
	{
		if ( strJson.isEmpty() )
		{
			return;
		}
		
		BaseEnum baseEnum = GsonHelper.fromJson( strJson, BaseEnum.class );
		this.basetype = baseEnum.basetype;
	}
	
}
