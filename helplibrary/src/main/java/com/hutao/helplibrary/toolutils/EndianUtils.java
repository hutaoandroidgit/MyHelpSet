package com.hutao.helplibrary.toolutils;

/**
 * 网络传输中的大小端转换
 * 
 * @author xutaisong
 * 
 */
public class EndianUtils
{
	/**
	 * 小端：int-->byte[]
	 * 
	 * @param i
	 * @param len
	 * @return
	 */
	public static byte[] little_intToByte(int i, int len)
	{
		byte[] abyte = new byte[len];
		if (1 == len)
		{
			abyte[0] = (byte) (0xff & i);
		} else if (2 == len)
		{
			abyte[0] = (byte) (0xff & i);
			abyte[1] = (byte) ((0xff00 & i) >> 8);
		} else
		{
			abyte[0] = (byte) (0xff & i);
			abyte[1] = (byte) ((0xff00 & i) >> 8);
			abyte[2] = (byte) ((0xff0000 & i) >> 16);
			abyte[3] = (byte) ((0xff000000 & i) >> 24);
		}
		return abyte;
	}

	/**
	 * 小端：byte[]-->int
	 * 
	 * @param bytes
	 * @return
	 */
	public static int little_bytesToInt(byte[] bytes)
	{
		int addr = 0;
		if (1 == bytes.length)
		{
			addr = bytes[0] & 0xFF;
		} else if (2 == bytes.length)
		{
			addr = bytes[0] & 0xFF;
			addr |= (((int) bytes[1] << 8) & 0xFF00);
		} else
		{
			addr = bytes[0] & 0xFF;
			addr |= (((int) bytes[1] << 8) & 0xFF00);
			addr |= (((int) bytes[2] << 16) & 0xFF0000);
			addr |= (((int) bytes[3] << 24) & 0xFF000000);
		}
		return addr;
	}

	/**
	 * 大端：int --> byte[] 支持 1或者 4 个字节
	 * 
	 * @param i
	 * @param len
	 * @return
	 */
	public static byte[] big_intToByte(int i, int len)
	{
		byte[] abyte = new byte[len];
		if (1 == len)
		{
			abyte[0] = (byte) (0xff & i);
		} else if (2 == len)
		{
			abyte[0] = (byte) ((i >>> 8) & 0xff);
			abyte[1] = (byte) (i & 0xff);
		} else
		{
			abyte[0] = (byte) ((i >>> 24) & 0xff);
			abyte[1] = (byte) ((i >>> 16) & 0xff);
			abyte[2] = (byte) ((i >>> 8) & 0xff);
			abyte[3] = (byte) (i & 0xff);
		}
		return abyte;
	}

	/**
	 * 大端：byte[] --> int
	 * 
	 * @param bytes
	 * @return
	 */
	public static int big_bytesToInt(byte[] bytes)
	{
		int addr = 0;
		if (1 == bytes.length)
		{
			addr = bytes[0] & 0xFF;
		} else if (2 == bytes.length)
		{
			addr = bytes[0] & 0xFF;
			addr = (addr << 8) | (bytes[1] & 0xff);
		} else
		{
			addr = bytes[0] & 0xFF;
			addr = (addr << 8) | (bytes[1] & 0xff);
			addr = (addr << 8) | (bytes[2] & 0xff);
			addr = (addr << 8) | (bytes[3] & 0xff);
		}
		return addr;
	}

	/**
	 * 获得本机cpu大小端
	 * 
	 * @return
	 */
	public static boolean isBigendian()
	{
		short i = 0x1;
		boolean bRet = ((i >> 8) == 0x1);
		return bRet;
	}
}
