package com.hutao.helplibrary.log;

import android.util.Log;

import com.hutao.helplibrary.basebean.BaseBean;
import com.hutao.helplibrary.basebean.IModifyPwd;
import com.hutao.helplibrary.log.OsdUILogInfo.EmLogLevel;
import com.hutao.helplibrary.log.OsdUILogInfo.EmLogType;
import com.hutao.helplibrary.toolutils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liushengru
 * 格式要求：[时间] [模块] [等级] [自定义内容] [中/英文备注]
 * 示例：[2018/01/04 10:09:04] [MTMP] [ERROR/DEBUG/INFO] [setencparam: 106 1024 40 16 3000] [设置编码器参数]
 * 日志管理类
 * 处理日志输出的逻辑
 * 日志级别：
 * DEBUG < INFO < WARN < ERROR
 *
 * rsp/ntf的消息是需要总开关控制的
 * 默认DEBUG开关的日志是不输出的
 * INFO WARN ERROR的开关时输出的
 */
public class OsduiLogManager implements LogAsyncTask.ICallback<OsdUILogInfo>{
    private static final String TAG = "OsduiLogManager";

    //异步任务，输出日志
    private static LogAsyncTask<OsdUILogInfo> mLogAsyncTask = null;
    /**
     * 存储主要消息消息号和备注信息
     * key:主要消息消息号
     * value:主要消息备注
     */
    private Map<String,String> mMainEventMap = null;
    /**
     * 含有密码的rsp ntf消息在callback中不处理
     * 有密码的消息单独处理
     */
    private Map<String,String> mMainEventPwdMap = null;
    private static final String COMMON_SECERT = "#*#*#*#*#";
    private static volatile OsduiLogManager instance;
    private OsduiLogManager(){}
    
    private static OsduiLogManager initOsduiLogManager()
    {
        if(null == instance)
        {
            synchronized (OsduiLogManager.class)
            {
                if(null == instance)
                {
                    instance = new OsduiLogManager();
                }
            }
        }
        return instance;
    }

    private static LogAsyncTask<OsdUILogInfo> initLogAsyncTask()
    {
        if(null == mLogAsyncTask)
        {
            synchronized (OsduiLogManager.class)
            {
                if(null == mLogAsyncTask)
                {
                    mLogAsyncTask = new LogAsyncTask<OsdUILogInfo>();
                    mLogAsyncTask.setmCallback(instance);
                    mLogAsyncTask.start();
                }
            }
        }
        return mLogAsyncTask;
    }
    
    private void initMainEventMap()
    {
    	if(null == mMainEventMap)
    	{
	       	 mMainEventMap = new HashMap<String,String>();
            //添加主消息号
    	}

    	if(null == mMainEventPwdMap)
    	{
    		mMainEventPwdMap = new HashMap<String,String>();
            //添加密码消息号
    	}
    }
    /**
     * 初始化数据
     * @return
     */
    public static OsduiLogManager getInstance()
    {
        initOsduiLogManager();
        initLogAsyncTask();
        return instance;
    }
    /**
     * 构造日志格式
     * @param loginfo
     * @return
     */
    private String buildLogFormat(OsdUILogInfo loginfo)
    {
        StringBuffer contentInfo = new StringBuffer();

        if(null != loginfo)
        {
            //构造时间
            String time = loginfo.getmStrTime();
            contentInfo = buildLogFormat(contentInfo,time);

            //构造模块
            String mode = loginfo.getmStrModuleName();
            contentInfo = buildLogFormat(contentInfo,mode);

            //构造级别
            String level = loginfo.getmEmLevel().getnVal();
            contentInfo = buildLogFormat(contentInfo,level);

            //构造内容
            String content = getContent(loginfo);
            contentInfo = buildLogFormat(contentInfo,content);

            //构造备注格式
            String key = loginfo.getmStrKey();
            String comments = loginfo.getmStrComments();
            if(!StringUtils.isEmpty(key))
            {
            	if(mMainEventMap.containsKey(key))
            	{
            		comments = mMainEventMap.get(key);
            	}
                
            	if(mMainEventPwdMap.containsKey(key))
            	{
            		comments = mMainEventPwdMap.get(key);
            	}
            }
            
            contentInfo = buildLogFormat(contentInfo,comments);
        }

        return contentInfo.toString();
    }
    private StringBuffer buildLogFormat(StringBuffer contentInfo,String s)
    {
        StringBuffer strBuf = null;
        if(!StringUtils.isEmpty(s))
        {
            strBuf = new StringBuffer();
            strBuf.append("[")
                    .append(s)
                    .append("]")
                    .append(" ");
        }
        if( null != strBuf)
        {
            contentInfo.append(strBuf);
        }
        return contentInfo;
    }

    /**
     * 给Log4j 日志构造 Tag
     * @param content
     * @param tag
     * @return
     */
    private String buildLogFormat(String content,String tag)
    {
        StringBuffer strBuf = null;
        if(!StringUtils.isEmpty(tag))
        {
            strBuf = new StringBuffer();
            strBuf.append(tag)
                    .append(":")
                    .append(" ");
        }
        if( null != strBuf)
        {
            strBuf.append(content);
            return strBuf.toString();
        }
        return content;
    }
    
    /**
     * 含有密码的消息特殊处理
     * @param loginfo
     * @return
     */
    private String getContent(OsdUILogInfo loginfo)
    {
    	String content = null;
    	BaseBean bean = loginfo.getmBaseBean();
    	if(null != loginfo.getmBaseBean()
    			&& bean instanceof IModifyPwd)
    	{
    		
    		String strContent =loginfo.getmStrContent();
    		//开启debug时打印密码明文，否则打印密文
    		if(!MtuiLogcat.getInstance().isbCaptureDebug()){
                bean = ((IModifyPwd) bean).encryptPwd(COMMON_SECERT,COMMON_SECERT);
            }
    		content = bean.toJsonString();
    		if(!StringUtils.isEmpty(strContent))
    		{
    			StringBuffer contentCombine = new StringBuffer();
    			contentCombine
                .append(strContent)
                .append(": ")
                .append(content)
                .append(" ");
    			return contentCombine.toString();
    		}
    		return content;
    	}
    	else
    	{
    		content =loginfo.getmStrContent();
    	}
    	return content;
    }
    /**
     * 获取TAG
     * @param obj
     * @return
     */
    private String getTagByObj(Object obj)
    {
        String str = "TAG";
        if(null != obj)
        {
            if(obj instanceof Class)
            {
                Class<?> clz = (Class<?>)obj;
                str = clz.getSimpleName();
            }
            else if(obj instanceof String)
            {
                str = (String)obj;
            }
            else
            {
                str = obj.getClass().getSimpleName();
            }
        }

        return str;
    }

    /**
     * 是否显示rsp或者ntf回调上来的消息
     * @param key
     * @return
     */
    private boolean bShowCallbackLog(String key)
    {
        if(null == mMainEventMap)
        {
            return false;
        }

        if(mMainEventMap.containsKey(key))
        {
            return true;
        }
        return false;
    }

    /**
     * 含有密码的消息打印单独处理
     * @param key
     * @return
     */
    private boolean bShowCallbackLogWithPwd(String key)
    {
        if(null == mMainEventPwdMap)
        {
            return false;
        }
        if(mMainEventPwdMap.containsKey(key))
        {
            return false;
        }
        return true;
    }

    /**
     *
     * @param keyName
     * @param strJsonContent
     * 构造日志数据入队列
     * 输出在callback中处理
     * 备注信息
     *    主要消息，备注信息从资源文件中获取
     *    非主要消息，没有备注信息
     */
    public void excecuteCallbackPrint(String keyName,String strJsonContent,String comments,Object mTag)
    {
    	initMainEventMap();
        //开启debug时打印带有密码消息
        if(!MtuiLogcat.getInstance().isbCaptureDebug()){
            //含有密码的消息不处理
            if(!bShowCallbackLogWithPwd(keyName))
            {
                return;
            }
        }

        /**
         * 添加日志需求
         * 1.默认情况下只输出主要的Log日志
         * 2.总开关开启的时候，输出所有的Log日志
         */
        if(!MtuiLogcat.getInstance().bCaptureLogcat())
        {
            if(!bShowCallbackLog(keyName))
            {
                return;
            }
        }

        if(MtuiLogcat.getInstance().isbCaptureInfo()){
            OsdUILogInfo logInfo = new OsdUILogInfo.Builder()
                    .content(strJsonContent)
                    .keyname(keyName)
                    .level(OsdUILogInfo.EmLogLevel.emHint)
                    .logtype(EmLogType.emDefault)
                    .comment(comments)
                    .tag(mTag)
                    .build();
            mLogAsyncTask.enqueue(logInfo);
        }
    }

    /**
     * 缓存日志数据
     * @param content
     * @param comments
     * @param mTag
     */
    public void buildContent(String content,String comments,Object mTag,EmLogLevel mLevel,EmLogType mType)
    {
        buildContent(content,comments,mTag,mLevel,mType,null);
    }
    
    /**
     * 含有密码的消息，密码以密文输出
     * @param mBaseBean
     * @param comments
     * @param mTag
     * @param mLevel
     * @param mType
     */
    public void buildContent(String content,String comments,Object mTag,EmLogLevel mLevel,EmLogType mType,BaseBean mBaseBean)
    {
        switch(mLevel) {
            case emHint:
                constructTaskQueue(content,comments,mTag,mLevel,mType,mBaseBean,MtuiLogcat.getInstance().isbCaptureInfo());
                break;
            case emWarning:
                constructTaskQueue(content,comments,mTag,mLevel,mType,mBaseBean,MtuiLogcat.getInstance().isbCaptureWarn());
                break;
            case emDebug:
                constructTaskQueue(content,comments,mTag,mLevel,mType,mBaseBean,MtuiLogcat.getInstance().isbCaptureDebug());
                break;
            case emError:
                constructTaskQueue(content,comments,mTag,mLevel,mType,mBaseBean,true);
                break;
            default:
                constructTaskQueue(content,comments,mTag,mLevel,mType,mBaseBean,true);
                break;
        }
    }

    private void constructTaskQueue(String content,String comments,Object mTag,EmLogLevel mLevel,EmLogType mType,BaseBean mBaseBean,boolean bOutputPrint){
        if(bOutputPrint){
            OsdUILogInfo logInfo = new OsdUILogInfo.Builder()
                    .content(content)
                    .comment(comments)
                    .level(mLevel)
                    .logtype(mType)
                    .tag(mTag)
                    .setBaseBean(mBaseBean)
                    .build();
            mLogAsyncTask.enqueue(logInfo);
        }
    }
    /**
     * 子线程中处理日志输出，减少主线程资源占用
     * @param osdUILogInfo
     */
    @Override
    public void callback(OsdUILogInfo osdUILogInfo) {
        printLog(osdUILogInfo);
    }

    private void printLog(OsdUILogInfo mLog)
    {
        if(null != mLog)
        {
        	 EmLogType mType = mLog.getEmType();
        	if(null != mType)
        	{
        		 switch(mLog.getEmType()){
                 case emDefault:
                     defualtLog(mLog);
                     break;
                 case emLog4j:
                     log4jLog(mLog);
                     break;
                 case emLogcat:
                     logcatLog(mLog);
                     break;
                 default:
                     break;
        		 }
        	}
        	else
        	{
                Log.e(TAG, "printLog mType is null");
        	}
        }
        else
        {
            Log.e(TAG, "printLog mLog is null");
        }
    }

    /**
     * 只输出到文件中
     * @param mLog
     */
    private void log4jLog(OsdUILogInfo mLog)
    {
        if(null == mLog)
        {
            Log.e(TAG, "log4jLog mLog is null");
            return;
        }

        String content = buildLogFormat(mLog);
        String tag = getTagByObj(mLog.getmTag());
        log4jLog(mLog.getmEmLevel(),content,tag);
    }
    
    /**
     * Log4J中日志格式采用自定义的，和logcat中的保持一致
     * 级别已经包含在content
     * Debug级别的打印受开关控制
     * @param level
     * @param content
     */
    private void log4jLog(EmLogLevel level,String content,String tag)
    {

        switch(level){
        case emHint:
        case emWarning:
        case emError:
            content = buildLogFormat(content,tag);
            ConfigureLog4J.getLogger(content);
            break;
        case emDebug:
            if(MtuiLogcat.getInstance().isbCaptureDebug())
            {
                 content = buildLogFormat(content,tag);
                 ConfigureLog4J.getLogger(content);
            }
            break;
        default:
            break;
        }
    }
    /**
     * 只输出logcat中的日志
     * @param mLog
     */
    private void logcatLog(OsdUILogInfo mLog)
    {
        if(null == mLog)
        {
            Log.e(TAG, "logcatLog mLog is null");
            return;
        }

        String content = buildLogFormat(mLog);
        String tag = getTagByObj(mLog.getmTag());
        logcatLog(mLog.getmEmLevel(),content,tag);
    }
    /**
     * 输出logcat中的日志
     * @param level
     * @param content
     * @param tag
     */
    private void logcatLog(EmLogLevel level,String content,String tag)
    {
    	 switch(level){
         case emHint:
         	if(MtuiLogcat.getInstance().isbCaptureInfo())
         	{
                Log.v(tag, content);
         	}
             break;
         case emWarning:
         	if(MtuiLogcat.getInstance().isbCaptureWarn())
         	{
                Log.w(tag, content);
         	}
             break;
         case emDebug:
         	if(MtuiLogcat.getInstance().isbCaptureDebug())
         	{
                Log.d(tag, content);
         	}
             break;
         case emError:
             Log.e(tag, content);
             break;
         default:
             Log.e(tag, content);
             break;
     }
    }

    /**
     *  logcat和log4j的日志同步输出
     * @param mLog
     */
    private void defualtLog(OsdUILogInfo mLog)
    {
        if(null == mLog)
        {
            Log.e(TAG, "defualtLog mLog is null");
            return;
        }
        
        String content = buildLogFormat(mLog);
        String tag = getTagByObj(mLog.getmTag());

        logcatLog(mLog.getmEmLevel(),content,tag);
        log4jLog(mLog.getmEmLevel(),content,tag);
    }
}
