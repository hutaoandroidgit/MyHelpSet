package com.hutao.helplibrary.toolutils;

/**
 * 统信息工具类，可用于得到线程池合适的大小
 * 
 * @author xutaisong
 */
public class SystemUtils
{

	/**
	 * recommend default thread pool size according to system available
	 * processors, {@link #getDefaultThreadPoolSize()}
	 **/
	public static final int DEFAULT_THREAD_POOL_SIZE = getDefaultThreadPoolSize();

	/**
	 * get recommend default thread pool size 得到跟系统配置相符的线程池大小
	 * 
	 * @return if 2 * availableProcessors + 1 less than 8, return it, else
	 *         return 8;
	 * @see {@link #getDefaultThreadPoolSize(int)} max is 8
	 */
	public static int getDefaultThreadPoolSize()
	{
		return getDefaultThreadPoolSize(8);
	}

	/**
	 * get recommend default thread pool size 得到跟系统配置相符的线程池大小
	 * 
	 * @param max
	 * @return if 2 * availableProcessors + 1 less than max, return it, else
	 *         return max;
	 */
	public static int getDefaultThreadPoolSize(int max)
	{
		int availableProcessors = 2 * Runtime.getRuntime()
				.availableProcessors() + 1;
		return availableProcessors > max ? max : availableProcessors;
	}
}