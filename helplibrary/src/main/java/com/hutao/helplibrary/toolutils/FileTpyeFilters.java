package com.hutao.helplibrary.toolutils;

import java.io.File;
import java.io.FilenameFilter;
/**
 * 过滤文件类型为.mp3(暂定.MP3 功能较弱，根据要求过滤类型)
 * 
 * @author xutaisong
 *
 */

public class FileTpyeFilters implements FilenameFilter {

	@Override
	public boolean accept(File dir, String filename) {
		return (filename.endsWith(".mp3"));
	}
}
