package com.hutao.helplibrary.log;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 
 * @author liushengru
 *
 * @param <T>
 */
public class LogAsyncTask<T> extends Thread{
	private boolean isRunning = false;
	private Object mLock = new Object();//同步锁
	private ConcurrentLinkedQueue<T> mLinkedQueue = new ConcurrentLinkedQueue<T>();//队列存储数据
	private ICallback<T> mCallback;
	public void enqueue(T t)
	{
		mLinkedQueue.add(t);
		if (isRunning() == false)
		{
			awake();
		}
	}
	
	public boolean isRunning()
	{
		return isRunning;
	}
	public void awake()
	{
		synchronized (mLock)
		{
			mLock.notify();
		}
	}
	
	@Override
	public void run()
	{
		while (true)
		{
			synchronized (mLock)
			{
				isRunning = true;
				while (!mLinkedQueue.isEmpty())
				{
					
					try
					{
						//获取队列中的头
						T t = mLinkedQueue.poll();
						//执行回调
						execute(t);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
				}
				isRunning = false;
				try
				{
					mLock.wait();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}

		}
	}
	
	
	
	public ICallback<T> getmCallback() {
		return mCallback;
	}

	public void setmCallback(ICallback<T> mCallback) {
		this.mCallback = mCallback;
	}

	private void execute(T t)
	{
		if(null != mCallback && null != t)
		{
			mCallback.callback(t);
		}
	}

	public interface ICallback<T>{
		public void callback(T t);
	}
	
}
