package com.hutao.helplibrary.log;


public enum EmLogType {
	EmLogTypeClose(0),          		///< 全部关闭
	EmLogTypeStart(1),       		///< 全部开启
	EmLogTypeWarn(2),    			///< 日志等级
	EmLogTypeInfo(3),          		///< 日志等级
	EmLogTypeDebug(4);				///< 日志等级

	
	private int nVal;

	public int getnVal() {
		return nVal;
	}

	private EmLogType( int _nVal ) {	
	    this.nVal = _nVal;	
	}
			
	public String toString() {	
	    return String.valueOf( this.nVal );
	}
}
