package com.hutao.helplibrary.toolutils;


import java.util.UUID;

/**
 * 
 * A GUID tool. This tool class exists to separate dependency of xNote code from
 * the underlying implementation of GUID generator.
 */
public class GUIDUtils
{

	/**
	 * @return a guid
	 */
	public static String guid() {
		return UUID.randomUUID().toString();
	}

	public static String guid2() {
		String uuid = UUID.randomUUID().toString();

		return uuid.replaceAll("-", "");
	}

}
