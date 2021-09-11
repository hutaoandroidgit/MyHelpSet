package com.hutao.helplibrary.log;

import com.hutao.helplibrary.toolutils.CommonUtils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import de.mindpipe.android.logging.log4j.LogConfigurator;


public class ConfigureLog4J {

	private static final String TAG =  ConfigureLog4J.class.getSimpleName();
	public static String LOG_PATH = "/log/osdlog/";
	private static final String LOG_PATH_PAD = CommonUtils.getRemoteSavePath("/osdlog/");
	private static final String LOG_FILE_NAME = "osdui.log";
	public static final String LOG_PERMISSION_CMD = "chmod 777 ";
	public static final boolean isPad = true;

    public static void configure() {
	     LogConfigurator logConfigurator = new LogConfigurator();
	        
			String log_path = "";
			if(isPad){
				log_path = LOG_PATH_PAD;
			}else{
				log_path = LOG_PATH;
			}
			OsduiLog.mtuiDebugLog(TAG, "log_path: " + log_path);
			
			File dir = new File(log_path);
			boolean bDirExists = dir.exists();
			boolean bmkDirExists = false;
			if (!bDirExists)
			{
				bmkDirExists = dir.mkdir();
				if(!bmkDirExists){
					OsduiLog.mtuiErrorLog(TAG, ":::configure:::mkdirs failed!");
				}
			}
			
			String LOG_DIR_PERMISSION_CMD = LOG_PERMISSION_CMD + log_path;
			int cmdDirResult = exec(LOG_DIR_PERMISSION_CMD);
			
			String fileName = log_path + LOG_FILE_NAME;
	        File file = new File(fileName);
	        createFile(file);
	        
	        String LOG_FILE_PERMISSION_CMD = LOG_PERMISSION_CMD + fileName;
			int cmdFileResult = exec(LOG_FILE_PERMISSION_CMD);
			if (cmdFileResult != 0) {
				OsduiLog.mtuiErrorLog(TAG, "::chmod file exec failed::");
				boolean result = recreateFile(file);
				if(!result)
				{
					OsduiLog.mtuiErrorLog(TAG, "::recreateFile result failed::");
					return;
				}
			}
	        //设置文件名
	        logConfigurator.setFileName(fileName);
	        //设置root日志输出级别 默认为DEBUG
	        logConfigurator.setRootLevel(Level.INFO);
	        // 设置日志输出级别
//	        logConfigurator.setLevel("org.apache", Level.INFO);
	        //设置 输出到日志文件的文字格式 默认 %d %-5p [%c{2}]-[%L] %m%n
//	        logConfigurator.setFilePattern("[%c{2}]-[%L] %d %-5p %m%n");
//	        logConfigurator.setFilePattern("[%d{yyyy/MM/dd HH:mm:ss,SSS}] [%c] [%p] %m%n");
	        logConfigurator.setFilePattern("%m%n");
	        //设置输出到控制台的文字格式 默认%m%n
	        logConfigurator.setLogCatPattern("%m%n");
	        //设置总文件大小
	        logConfigurator.setMaxFileSize(1024*1024*10);
	        //设置最大产生的文件个数
	        logConfigurator.setMaxBackupSize(5);
	        
	        //设置所有消息是否被立刻输出 默认为true,false 不输出
	        logConfigurator.setImmediateFlush(true);
	        //是否本地控制台打印输出 默认为true ，false不输出
	        logConfigurator.setUseLogCatAppender(false);
	        //设置是否启用文件附加,默认为true。false为覆盖文件
	        logConfigurator.setUseFileAppender(true);
	        //设置是否重置配置文件，默认为true
	        logConfigurator.setResetConfiguration(true);
	        //是否显示内部初始化日志,默认为false
	        logConfigurator.setInternalDebugging(false);

//	        logConfigurator.configure();
        	try {
        		 logConfigurator.configure();
			} catch (Exception e) {
				OsduiLog.mtuiErrorLog(TAG, "::osdui.log open failed EACCES Permission denied::");
				e.printStackTrace();
			}
	    }
	    
	    public static Logger getLogger(String key,Object obj)
	    {
			Logger logger = Logger.getLogger(key);
			try
			{
				logger.info(obj);
			} catch (Exception e)
			{
				OsduiLog.mtuiErrorLog(TAG, "exception catch");
			}
			
			return logger;
	    }
	    
	    public static Logger getLogger(Object obj)
	    {
			Logger logger = Logger.getLogger("");
			try
			{
				logger.info(obj);
			} catch (Exception e)
			{
				OsduiLog.mtuiErrorLog(TAG, "exception catch no key");
			}
			
			return logger;
	    }
	    
		/**
		 * 执行Linux命令
		 * 
		 * @param command
		 * @return
		 * 备用
		 */
		private static int exec(String command) {
			OsduiLog.mtuiErrorLog(TAG, "chmod file LOG_PERMISSION_CMD:: "+ command);
	        BufferedReader reader = null;
			try {
				Process process = Runtime.getRuntime().exec(command);
				int exitValue = process.waitFor();
				return exitValue;
			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}
			finally{
				if(null != reader)
				{
					try
					{
						reader.close();
					} catch (IOException e)
					{
						OsduiLog.mtuiErrorLog(TAG, "reader close exception");
						e.printStackTrace();
					}
				}
			}

		}
		
		
		
	private static void createFile(File file)
	{
        boolean bFileExists = file.exists();
        if(!bFileExists)
        {
        	try {
				file.createNewFile();
			} catch (Exception e) {
				OsduiLog.mtuiErrorLog(TAG, "::createFile Exception::");
				e.printStackTrace();
			}
        }
	}
	
	private static boolean recreateFile(File file)
	{
		boolean createResult = false;
        boolean bFileExists = file.exists();
        boolean bFile = file.isFile();
        if(bFileExists && bFile)
        {
        	try {
        		boolean bDelete = file.delete();
        		if(bDelete)
        		{
        			createResult = file.createNewFile();
        			return createResult;
        		}
        		else
        		{
        			OsduiLog.mtuiErrorLog(TAG, "::bDelete failed:: " + bDelete);
        		}
        		return false;
				
			} catch (Exception e) {
				OsduiLog.mtuiErrorLog(TAG, "::recreateFile Exception::");
				e.printStackTrace();
			}
        }
        return false;
	}
}
