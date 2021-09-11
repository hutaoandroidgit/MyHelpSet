package com.hutao.helplibrary.toolutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

/**
 * 文件常用操作
 * 
 * @author xutaisong
 */
public final class FileUtils
{

	/**
	 * copyFile
	 * 
	 * @param srcFile
	 * @param destPath
	 * @return
	 */
	@SuppressWarnings("unused")
	public static boolean copyFile(String srcFile, String destPath)
	{
		try
		{
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(srcFile);
			if (!oldfile.exists())
			{// 文件不存在时
				System.out
						.println("mkdirs: source file not exits : " + srcFile);

				return false;
			}

			File dir = new File(destPath);
			if (!dir.exists())
			{
				dir.mkdirs();
			}

			InputStream inStream = new FileInputStream(srcFile); // 读入原文件
			FileOutputStream fs = new FileOutputStream(destPath
					+ File.separator + oldfile.getName());
			byte[] buffer = new byte[1444];
			while ((byteread = inStream.read(buffer)) != -1)
			{
				bytesum += byteread; // 字节数 文件大小
				// System.out.println(bytesum);
				fs.write(buffer, 0, byteread);
				fs.flush();
			}
			inStream.close();
			fs.close();
		} catch (Exception e)
		{
			return false;
		}

		return true;
	}

	/**
	 * 复制文件保存
	 * 
	 * @param srcFile
	 *            源文件路径---绝对路径
	 * @param fileName
	 *            保存的文件名称
	 * @param destPath
	 *            目的路径
	 * @return
	 */
	public static boolean copyFileByName(String srcFile, String fileName,
			String destPath)
	{

		File oldfile = new File(srcFile);
		if (!oldfile.exists())
		{// 文件不存在时
			System.out.println("mkdirs :source file not exits : " + srcFile);
			return false;
		}

		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try
		{
			fileInputStream = new FileInputStream(srcFile);
			fileOutputStream = new FileOutputStream(destPath + File.separator
					+ fileName);
			// 一次读取1024字节
			byte[] bytes = new byte[1024];
			while (fileInputStream.read(bytes) != -1)
			{
				fileOutputStream.write(bytes);
				fileOutputStream.flush();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		} finally
		{
			if (fileInputStream != null)
			{
				try
				{
					fileInputStream.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null)
			{
				try
				{
					fileOutputStream.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

		return true;
	}

	/**
	 * movie file
	 * 
	 * @param srcFile
	 * @param destPath
	 */
	public static boolean moveFile(String srcFile, String destPath)
	{
		if (StringUtils.isNull(srcFile))
			return false;

		File file = new File(srcFile);
		if (!file.exists())
			return false;

		File dir = new File(destPath);
		if (!dir.exists())
		{
			dir.mkdirs();
		}
		// Move file to new directory
		return file.renameTo(new File(dir, file.getName()));
	}

	/**
	 * @param aFile
	 * @return
	 */
	public static boolean deleteFile(File aFile)
	{
		if (aFile == null)
			return false;

		boolean bResult = false;
		bResult = aFile.delete();

		return bResult;
	}

	public static boolean isExist(String uri)
	{
		boolean b = false;
		if (StringUtils.isNull(uri))
			return b;
		try
		{
			return (new File(uri)).exists();
		} catch (Exception e)
		{
		}
		return b;
	}

	public static boolean createDirByShell(String path)
	{
		if (StringUtils.isNull(path))
			return false;
		File dd = new File(path);
		if (dd.exists() && !dd.isDirectory())
		{
			return dd.mkdirs();
		}

		if (dd.exists() && dd.canWrite())
			return true;

		if (dd.exists() && !dd.canWrite())
		{
			String command = "chmod 777" + path;

			return CommandUtils.runCommand(command);
		}
		String command = "mkdir " + path;

		return CommandUtils.runCommand(command);

	}

	/**
	 * 以String形式返回文件内容
	 * 
	 * @param aFile
	 * @return
	 */
	public static String getFileString(File aFile)
	{
		if (aFile == null)
			return null;

		StringBuffer sb = new StringBuffer();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(aFile));
			String line;
			while ((line = reader.readLine()) != null)
			{
				sb.append(line + "\n");
			}
			reader.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 以String形式返回文件内容
	 * 
	 * @param aFile
	 * @return
	 */
	public static String getFileString(String path)
	{
		if (path == null)
			return null;

		StringBuffer sb = new StringBuffer();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			while ((line = reader.readLine()) != null)
			{
				sb.append(line + "\n");
			}
			reader.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 用新的内容替换原有File内容
	 * 
	 * @param aFile
	 * @param newString
	 * @return
	 */
	public static boolean replaceFileContent(String filePath, String newString)
	{
		if (StringUtils.isNull(filePath))
			return false;

		boolean bResult = true;
		try
		{
			File aFile = new File(filePath);
			if (aFile.exists())
			{
				aFile.delete();
			}

			OutputStreamWriter writer = new OutputStreamWriter(
					new FileOutputStream(aFile), "utf-8");
			// /Writer writer = new FileWriter(aFile);
			writer.write(newString);
			writer.close();
		} catch (IOException e)
		{
			e.printStackTrace();
			bResult = false;
		}

		return bResult;
	}

	public static boolean replaceFileContent(String filePath, byte[] newString)
	{
		if (StringUtils.isNull(filePath))
			return false;
		boolean bResult = true;
		try
		{
			File aFile = new File(filePath);
			if (aFile.exists())
			{
				aFile.delete();
			}
			OutputStreamWriter writer = new OutputStreamWriter(
					new FileOutputStream(aFile), "utf-8");
			// /Writer writer = new FileWriter(aFile);
			writer.write(new String(newString, "utf-8"));
			writer.close();
		} catch (IOException e)
		{
			e.printStackTrace();
			bResult = false;
		}
		return bResult;
	}

	/**
	 * 删除文件夹
	 * @param path
	 */
	public static void delFolder(String folderPath)
	{
		if (StringUtils.isNull(folderPath))
			return;
		try
		{
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // 删除空文件夹

		} catch (Exception e)
		{
			e.printStackTrace();

		}
	}

	/**
	 * 删除路径下的所有文件
	 * @param path
	 */
	public static void delAllFile(String path)
	{
		File file = new File(path);
		if (!file.exists())
		{
			return;
		}
		if (!file.isDirectory())
		{
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++)
		{
			if (path.endsWith(File.separator))
			{
				temp = new File(path + tempList[i]);
			} else
			{
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile())
			{
				try
				{
					temp.delete();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			if (temp.isDirectory())
			{
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
			}
		}
	}

}
