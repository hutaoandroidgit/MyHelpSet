package com.hutao.helplibrary.basebean;


import com.hutao.helplibrary.gson.GsonHelper;

public class BaseBool extends BaseBean{

	private boolean basetype;
	
	
	public boolean getBasetype() {
		return basetype;
	}

	public void setBasetype(int basetype) {
		this.basetype = basetype != 0 ? true : false;
	}	
	
	public void setBasetype(boolean bValue) {
		this.basetype = bValue;
	}	
	
	public boolean asBool()
	{
		return this.basetype;
	}
 
	public BaseBool()
	{
		basetype = false;
	}
	
	public BaseBool(final BaseBool baseBool)
	{
		this.basetype = baseBool.basetype;
	}
	
	public BaseBool( final String strJson )
	{
		fromString( strJson );
	}
	
	public void fromString( String strJson )
	{
		if ( strJson.isEmpty() )
		{
			return;
		}
		
		BaseBool baseBool = GsonHelper.fromJson( strJson, BaseBool.class );
		this.basetype = baseBool.basetype;
	}
	
	
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseBool b = new BaseBool();
		b.setBasetype( 1 );
		String strText = b.toJsonString();
		
		System.out.println("call:"+ strText );		

	}
*/
}


