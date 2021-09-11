package com.hutao.helplibrary.log;

import com.hutao.helplibrary.basebean.BaseBean;
import com.hutao.helplibrary.toolutils.TimeUtils;

/**
 * liushengru
 * 日志信息
 */
public class OsdUILogInfo {
    public static final String MTUI_TAG = "MTUI";
    //日志时间
    private long mTime;
    private String mStrTime;
    //日志模块名
    private String mStrModuleName;
    //日志级别
    private EmLogLevel mEmLevel;
    //日志内容
    private String mStrContent;
    //日志备注
    private String mStrComments;
    //主要日志Key
    private String mStrKey;
    //日志TAG
    private Object mTag;

    //日志类型
    private EmLogType emType;

    private BaseBean mBaseBean;

    private OsdUILogInfo(){}
    private OsdUILogInfo(OsdUILogInfo src)
    {
        this.mTime = src.mTime;
        this.mStrTime = src.mStrTime;
        this.mStrModuleName = src.mStrModuleName;
        this.mEmLevel = src.mEmLevel;
        this.mStrContent = src.mStrContent;
        this.mStrComments = src.mStrComments;
        this.mStrKey = src.mStrKey;
        this.mTag = src.mTag;
        this.emType = src.emType;
        this.mBaseBean = src.mBaseBean;
    }
    public long getmTime() {
        return mTime;
    }

    public String getmStrTime() {
        return mStrTime;
    }

    public String getmStrModuleName() {
        return mStrModuleName;
    }

    public EmLogLevel getmEmLevel() {
        return mEmLevel;
    }

    public String getmStrContent() {
        return mStrContent;
    }

    public String getmStrComments() {
        return mStrComments;
    }

    public String getmStrKey() {
        return mStrKey;
    }

    public Object getmTag() {
        return mTag;
    }

    public EmLogType getEmType() {
        return emType;
    }
    
    public BaseBean getmBaseBean()
	{
		return mBaseBean;
	}



	public static class Builder{
        private OsdUILogInfo target;

        public Builder(){
            target = new OsdUILogInfo();
            //默认的模块和时间格式
            String strTime = TimeUtils.TimeToString(TimeUtils.SPLIT_BACK_SLANT);
            time(strTime);
            moduleName(MTUI_TAG);
        }

        public Builder time(long time){
            target.mTime = time;
            return this;
        }

        public Builder time(String time){
            target.mStrTime = time;
            return this;
        }

        public Builder moduleName(String moduleName){
            target.mStrModuleName = moduleName;
            return this;
        }

        public Builder level(EmLogLevel level){
            target.mEmLevel = level;
            return this;
        }

        public Builder content(String content){
            target.mStrContent = content;
            return this;
        }

        public Builder comment(String comment){
            target.mStrComments = comment;
            return this;
        }

        public Builder keyname(String key){
            target.mStrKey = key;
            return this;
        }

        public Builder tag(Object tag){
            target.mTag = tag;
            return this;
        }

        public Builder logtype(EmLogType type){
            target.emType = type;
            return this;
        }
        
        public Builder setBaseBean(BaseBean baseBean){
            target.mBaseBean = baseBean;
            return this;
        }

        public OsdUILogInfo build()
        {
//            return new OsdUILogInfo(target);
            return target;
        }
    }

    public enum EmLogType
    {
        emDefault,
        emLogcat,
        emLog4j
    }

    public enum EmLogLevel
    {
        emError("ERROR"),
        emDebug("DEBUG"),
        emHint("HINT"),
        emWarning("WARNING");

        private String mStrVal;
        public String getnVal()
        {
            return mStrVal;
        }

        public void setnVal(String mVal)
        {
            this.mStrVal = mVal;
        }

        private EmLogLevel( String _mVal ) {
            this.mStrVal = _mVal;
        }
    }
}
