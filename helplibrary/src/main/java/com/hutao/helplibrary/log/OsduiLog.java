package com.hutao.helplibrary.log;

import com.hutao.helplibrary.log.OsduiLogManager;
import com.hutao.helplibrary.log.OsdUILogInfo.EmLogLevel;
import com.hutao.helplibrary.log.OsdUILogInfo.EmLogType;
import com.hutao.helplibrary.basebean.BaseBean;

/**
 * @author liushengru
 * 界面调用输出打印
 *
 * 注：TAG不要传匿名内部内对象，否则打印不会输出
 */
public class OsduiLog {

    private static OsduiLog instance;

    public static OsduiLog getInstance()
    {
        
        return initOsduiLog();
    }
    private static OsduiLog initOsduiLog()
    {
        if(null == instance)
        {
            synchronized (OsduiLog.class)
            {
                if(null == instance)
                {
                    instance = new OsduiLog();
                }
            }
        }
        return instance;
    }
    
    /**
    *
    * @param obj:自定义TAG
    * @param Content
    * @param comments
    */
   public static void mtuiCallbackLog(Object mTag,String keyName,String strJsonContent,String comments)
   {
       OsduiLogManager.getInstance().excecuteCallbackPrint(keyName,strJsonContent,comments,mTag);
   }
   
    /**
     *
     * @param obj:自定义TAG
     * @param Content
     * @param comments
     */
    public static void mtuiHintLog(Object obj,String Content,String comments)
    {
        OsduiLogManager.getInstance().buildContent(Content,comments,obj,EmLogLevel.emHint,EmLogType.emDefault);
    }
    
    /**
     * 不需要备注
     * @param obj
     * @param Content
     */
    public static void mtuiHintLog(Object obj,String Content)
    {
        OsduiLogManager.getInstance().buildContent(Content,null,obj,EmLogLevel.emHint,EmLogType.emDefault);
    }
    /**
     * 供有密码的消息使用
     * @param obj
     * @param content
     * @param basebean
     * @param comments
     */
    public static void mtuiHintLog(Object obj,String content,BaseBean basebean,String comments)
    {
        OsduiLogManager.getInstance().buildContent(content,comments,obj,EmLogLevel.emHint,EmLogType.emDefault,basebean);
    }

    /**
     *
     * @param obj:自定义TAG
     * @param Content
     * @param comments
     */
    public static void mtuiDebugLog(Object obj,String Content,String comments)
    {
        OsduiLogManager.getInstance().buildContent(Content,comments,obj,EmLogLevel.emDebug,EmLogType.emDefault);
    }

    /**
     * 不需要备注
     * @param obj
     * @param Content
     */
    public static void mtuiDebugLog(Object obj,String Content)
    {
        OsduiLogManager.getInstance().buildContent(Content,null,obj,EmLogLevel.emDebug,EmLogType.emDefault);
    }

    /**
     * @param obj:自定义TAG
     * @param Content
     * @param comments
     */
    public static void mtuiWarnLog(Object obj,String Content,String comments)
    {
        OsduiLogManager.getInstance().buildContent(Content,comments,obj,EmLogLevel.emWarning,EmLogType.emDefault);
    }
    
    /**
     * 不需要备注
     * @param obj
     * @param Content
     */
    public static void mtuiWarnLog(Object obj,String Content)
    {
        OsduiLogManager.getInstance().buildContent(Content,null,obj,EmLogLevel.emWarning,EmLogType.emDefault);
    }

    /**
     * @param obj:自定义TAG
     * @param Content
     * @param comments
     */
    public static void mtuiErrorLog(Object obj,String Content,String comments)
    {
        OsduiLogManager.getInstance().buildContent(Content,comments,obj,EmLogLevel.emError,EmLogType.emDefault);
    }
    
    /**
     * 不需要备注
     * @param obj
     * @param Content
     */
    public static void mtuiErrorLog(Object obj,String Content)
    {
        OsduiLogManager.getInstance().buildContent(Content,null,obj,EmLogLevel.emError,EmLogType.emDefault);
    }
    
    
    /**
    *
    * @param obj:自定义TAG
    * @param Content
    * @param comments
    */
   public static void mtuiHintLogForLog4j(Object obj,String Content,String comments)
   {
       OsduiLogManager.getInstance().buildContent(Content,comments,obj,EmLogLevel.emHint,EmLogType.emLog4j);
   }
   
   /**
    * 不需要备注
    * @param obj
    * @param Content
    */
   public static void mtuiHintLogForLog4j(Object obj,String Content)
   {
       OsduiLogManager.getInstance().buildContent(Content,null,obj,EmLogLevel.emHint,EmLogType.emLog4j);
   }

   /**
    *
    * @param obj:自定义TAG
    * @param Content
    * @param comments
    */
   public static void mtuiDebugLogForLog4j(Object obj,String Content,String comments)
   {
       OsduiLogManager.getInstance().buildContent(Content,comments,obj,EmLogLevel.emDebug,EmLogType.emLog4j);
   }

   /**
    * 不需要备注
    * @param obj
    * @param Content
    */
   public static void mtuiDebugLogForLog4j(Object obj,String Content)
   {
       OsduiLogManager.getInstance().buildContent(Content,null,obj,EmLogLevel.emDebug,EmLogType.emLog4j);
   }

   /**
    *
    * @param obj:自定义TAG
    * @param Content
    * @param comments
    */
   public static void mtuiWarnLogForLog4j(Object obj,String Content,String comments)
   {
       OsduiLogManager.getInstance().buildContent(Content,comments,obj,EmLogLevel.emWarning,EmLogType.emLog4j);
   }
   
   /**
    * 不需要备注
    * @param obj
    * @param Content
    */
   public static void mtuiWarnLogForLog4j(Object obj,String Content)
   {
       OsduiLogManager.getInstance().buildContent(Content,null,obj,EmLogLevel.emWarning,EmLogType.emLog4j);
   }

   /**
    *
    * @param obj:自定义TAG
    * @param Content
    * @param comments
    */
   public static void mtuiErrorLogForLog4j(Object obj,String Content,String comments)
   {
       OsduiLogManager.getInstance().buildContent(Content,comments,obj,EmLogLevel.emError,EmLogType.emLog4j);
   }
   
   /**
    * 不需要备注
    * @param obj
    * @param Content
    */
   public static void mtuiErrorLogForLog4j(Object obj,String Content)
   {
       OsduiLogManager.getInstance().buildContent(Content,null,obj,EmLogLevel.emError,EmLogType.emLog4j);
   }

   
   /**
   *
   * @param obj:自定义TAG
   * @param Content
   * @param comments
   */
  public static void mtuiHintLogForLogcat(Object obj,String Content,String comments)
  {
      OsduiLogManager.getInstance().buildContent(Content,comments,obj,EmLogLevel.emHint,EmLogType.emLogcat);
  }
  
  /**
   * 不需要备注
   * @param obj
   * @param Content
   */
  public static void mtuiHintLogForLogcat(Object obj,String Content)
  {
      OsduiLogManager.getInstance().buildContent(Content,null,obj,EmLogLevel.emHint,EmLogType.emLogcat);
  }

  /**
   *
   * @param obj:自定义TAG
   * @param Content
   * @param comments
   */
  public static void mtuiDebugLogForLogcat(Object obj,String Content,String comments)
  {
      OsduiLogManager.getInstance().buildContent(Content,comments,obj,EmLogLevel.emDebug,EmLogType.emLogcat);
  }

  /**
   * 不需要备注
   * @param obj
   * @param Content
   */
  public static void mtuiDebugLogForLogcat(Object obj,String Content)
  {
      OsduiLogManager.getInstance().buildContent(Content,null,obj,EmLogLevel.emDebug,EmLogType.emLogcat);
  }

  /**
   *
   * @param obj:自定义TAG
   * @param Content
   * @param comments
   */
  public static void mtuiWarnLogForLogcat(Object obj,String Content,String comments)
  {
      OsduiLogManager.getInstance().buildContent(Content,comments,obj,EmLogLevel.emWarning,EmLogType.emLogcat);
  }
  
  /**
   * 不需要备注
   * @param obj
   * @param Content
   */
  public static void mtuiWarnLogForLogcat(Object obj,String Content)
  {
      OsduiLogManager.getInstance().buildContent(Content,null,obj,EmLogLevel.emWarning,EmLogType.emLogcat);
  }

  /**
   *
   * @param obj:自定义TAG
   * @param Content
   * @param comments
   */
  public static void mtuiErrorLogForLogcat(Object obj,String Content,String comments)
  {
      OsduiLogManager.getInstance().buildContent(Content,comments,obj,EmLogLevel.emError,EmLogType.emLogcat);
  }
  
  /**
   * 不需要备注
   * @param obj
   * @param Content
   */
  public static void mtuiErrorLogForLogcat(Object obj,String Content)
  {
      OsduiLogManager.getInstance().buildContent(Content,null,obj,EmLogLevel.emError,EmLogType.emLogcat);
  }
}
