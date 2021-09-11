package com.hutao.helplibrary.log;

import android.util.Log;


/**
 * 
 * 日志开关
 * 
 * DEBUG <(4) INFO <(3) WARN(2) < ERROR
 * 开了DEBUG，INOF、WARN都可以打印
 */
public class MtuiLogcat
{
	private final static String TAG = "MtuiLogcat";
	private boolean bCaptureBootLogcat = true;		//true表示捕获应用启动时候的日志，false表示关闭。
	
	private boolean bCaptureAllLogcat;					//true表示开启所有开关，false表示关闭

	private boolean bCaptureDebug;					//是否开启Debug控制开关
	private boolean bCaptureInfo = true;			//是否开启Info控制开关  默认为true
	private boolean bCaptureWarn = true;			//是否开启Warn控制开关  默认为true
	
	private static MtuiLogcat instance;
	public static MtuiLogcat getInstance()
	{
        if(null == instance)
        {
            synchronized (OsduiLog.class)
            {
                if(null == instance)
                {
                    instance = new MtuiLogcat();
                }
            }
        }
        return instance;
	}
	
	public boolean isbCaptureBootLogcat()
	{
		return bCaptureBootLogcat;
	}

	public void setbCaptureBootLogcat(boolean bCaptureBootLogcat)
	{
		this.bCaptureBootLogcat = bCaptureBootLogcat;
	}


	/**
	 * 2500/2501端口下敲
	 * osdlog 1 开关开启
	 * osdlog 0 开关关闭
	 */
	public void setLogType(int logType)
	{
		EmLogType emLogTypeStart = EmLogType.values()[logType];
		Log.e(TAG, "setLogType emLogTypeStart: " + emLogTypeStart
				+ " bCaptureInfo: " + bCaptureInfo
				+ " bCaptureWarn: " + bCaptureWarn
				+ " bCaptureDebug: " + bCaptureDebug);
		switch (emLogTypeStart)
		{
		case EmLogTypeClose:
			bCaptureAllLogcat = false;
			bCaptureWarn = false;
			bCaptureInfo = false;
			bCaptureDebug = false;
			break;
		case EmLogTypeStart:
			bCaptureAllLogcat = true;
			//默认开启
			bCaptureDebug = true;
			bCaptureWarn = true;
			bCaptureInfo = true;
			break;
		case EmLogTypeWarn:
			bCaptureWarn = true;
			break;
		case EmLogTypeInfo:
			bCaptureWarn = true;
			bCaptureInfo = true;
			break;
		case EmLogTypeDebug:
			bCaptureWarn = true;
			bCaptureInfo = true;
			bCaptureDebug = true;
			break;
		default:
			break;
		}
	}
	
	public boolean bCaptureLogcat()
	{
		//启动的时候，打印一直抓着
		if(bCaptureBootLogcat)
		{
			Log.e(TAG," bCaptureBootLogcat: " + bCaptureBootLogcat);
			return true;
		}
		
		if(bCaptureAllLogcat)
		{
			return true;
		}
		return false;
	}

	public boolean isbCaptureDebug()
	{
		return bCaptureDebug;
	}

	public boolean isbCaptureInfo()
	{
		return bCaptureInfo;
	}

	public boolean isbCaptureWarn()
	{
		return bCaptureWarn;
	}
	
	
	
}
