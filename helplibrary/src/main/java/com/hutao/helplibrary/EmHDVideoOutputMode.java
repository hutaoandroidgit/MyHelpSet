package com.hutao.helplibrary;


//高清分辨率输出制式
public enum EmHDVideoOutputMode
{
	emVOM_HD_ORIGIN_Api,  //0
	emVOM_HD_1080p_24_Api, //1 /<1080P 24fps
	emVOM_HD_1080p_25_Api, //2 /<1080P 25fps
	emVOM_HD_1080p_30_Api, //3 /<1080P 30fps
	emVOM_HD_1080p_50_Api, //4 /<1080P 50fps
	emVOM_HD_1080p_60Hz_Api, //5 /<1080P 60Hz
	emVOM_HD_1080p_60fps_Api, //6 /<1080P 60Fps
	emVOM_HD_1080i_50_Api, //7 /<1080I 50Hz
	emVOM_HD_1080i_60_Api, //8 /<1080I 60Hz
	emVOM_HD_720p_50_Api, //9 /<720P 50fps
	emVOM_HD_720p_60hz_Api, //10 /<720P 60Hz
	emVOM_HD_720p_60fps_Api, //11 /<720P 60fps
	emVOM_HD_576i_50_Api, //12 /<576I 50Hz
	emVOM_HD_1080p_29_Api, //13 /<1080P 29Hz
	emVOM_HD_1080p_59_Api, //14 /<1080P 59Hz
	emVOM_HD_576p_Api, //15 /<576P
	emVOM_HD_1080p_29_97_Api, //16 /<1080P 29.97fps
	emVOM_HD_1080p_59_94_Api, //17 /<1080P 59.94fps
	emVOM_HD_VGA_60_Api, //18 /<VGA 60Hz
	emVOM_HD_VGA_75_Api, //19 /<VGA 75Hz
	emVOM_HD_SVGA_60_Api, //20 /<SVGA 60Hz
	emVOM_HD_SVGA_75_Api, //21 /<SVGA 75Hz
	emVOM_HD_XGA_60_Api, //22 /<XGA 60Hz
	emVOM_HD_XGA_75_Api, //23 /<XGA 75Hz
	emVOM_HD_SXGA_60_Api, //24 /<SXGA 60Hz
	emVOM_HD_WXGA1280x768_60_Api, //25 /<WXGA 1280x768 60Hz
	emVOM_HD_WXGA1280x768_75_Api, //26 /<WXGA 1280x768 75Hz
	emVOM_HD_WXGA1280x800_60_Api, //27 /<WXGA 1280x800 60Hz
	emVOM_HD_WXGA1280x800_75_Api, //28 /<WXGA 1280x800 75Hz
	emVOM_HD_WXGA1366x768_60_Api, //29 /<WXGA 1360x768 60Hz
	emVOM_HD_UXGA1600x1200_60_Api, //30 /<UXGA 1600x1200 60Hz
	emVOM_HD_WSXGA1440x900_60_Api, //31 /<WSXGA 1440x900 60Hz
	emVOM_HD_SXGAPLUS1680x1050_60_Api, //32 /<SXGAPLUS 1680x1050 60Hz
	emVOM_HD_4k3860x2160_30_Api,       //33/<4k 3860x2160 30Hz
	emVOM_HD_4k3860x2160_60_Api        //34/<4k 3860x2160 60Hz
	;
	
	public static boolean isLessThanSixtyFPS(EmHDVideoOutputMode emHDVideoOutputMode)
	{
		boolean isLessThanSixty = false;
		if(emHDVideoOutputMode == emVOM_HD_1080p_24_Api
			|| emHDVideoOutputMode == emVOM_HD_1080p_25_Api
			|| emHDVideoOutputMode == emVOM_HD_1080p_30_Api
			|| emHDVideoOutputMode == emVOM_HD_1080p_50_Api
			|| emHDVideoOutputMode == emVOM_HD_1080i_50_Api
			|| emHDVideoOutputMode == emVOM_HD_720p_50_Api
			|| emHDVideoOutputMode == emVOM_HD_576i_50_Api
			|| emHDVideoOutputMode == emVOM_HD_1080p_29_Api
			|| emHDVideoOutputMode == emVOM_HD_1080p_59_Api
			|| emHDVideoOutputMode == emVOM_HD_1080p_29_97_Api
			|| emHDVideoOutputMode == emVOM_HD_1080p_59_94_Api
			|| emHDVideoOutputMode == emVOM_HD_576p_Api
			|| emHDVideoOutputMode == emVOM_HD_4k3860x2160_30_Api)
		{
			isLessThanSixty = true;
		} else
		{
			isLessThanSixty = false;
		}
		
		return isLessThanSixty;
	}
	
	public static boolean isVGAOutputMode(EmHDVideoOutputMode emHDVideoOutputMode)
	{
		boolean isVGAOutputMode = false;
		if(emHDVideoOutputMode == emVOM_HD_VGA_60_Api
				|| emHDVideoOutputMode == emVOM_HD_VGA_75_Api
				|| emHDVideoOutputMode == emVOM_HD_SVGA_60_Api
				|| emHDVideoOutputMode == emVOM_HD_SVGA_75_Api
				|| emHDVideoOutputMode == emVOM_HD_XGA_60_Api
				|| emHDVideoOutputMode == emVOM_HD_XGA_75_Api
				|| emHDVideoOutputMode == emVOM_HD_SXGA_60_Api
				|| emHDVideoOutputMode == emVOM_HD_WXGA1280x768_60_Api
				|| emHDVideoOutputMode == emVOM_HD_WXGA1280x768_75_Api
				|| emHDVideoOutputMode == emVOM_HD_WXGA1280x800_60_Api
				|| emHDVideoOutputMode == emVOM_HD_WXGA1280x800_75_Api
				|| emHDVideoOutputMode == emVOM_HD_WXGA1366x768_60_Api
				|| emHDVideoOutputMode == emVOM_HD_UXGA1600x1200_60_Api
				|| emHDVideoOutputMode == emVOM_HD_WSXGA1440x900_60_Api
				|| emHDVideoOutputMode == emVOM_HD_SXGAPLUS1680x1050_60_Api
				)
		{
			isVGAOutputMode = true;
		} else
		{
			isVGAOutputMode = false;
		}
		
		return isVGAOutputMode;
	}

	public HDVideoOutputParam getHDVideoOutputParam(){
		switch(this){
		    case emVOM_HD_1080p_24_Api:
				return  new HDVideoOutputParam(1920,1080,true,24);
		    case emVOM_HD_1080p_25_Api:
				return  new HDVideoOutputParam(1920,1080,true,25);
		    case emVOM_HD_1080p_30_Api:
				return  new HDVideoOutputParam(1920,1080,true,30);
			case emVOM_HD_1080p_50_Api:
				return  new HDVideoOutputParam(1920,1080,true,50);
			case emVOM_HD_1080p_60Hz_Api:
			case emVOM_HD_1080p_60fps_Api:
				return  new HDVideoOutputParam(1920,1080,true,60);
			case emVOM_HD_1080i_50_Api:
				return  new HDVideoOutputParam(1920,1080,false,50);
			case emVOM_HD_1080i_60_Api:
				return  new HDVideoOutputParam(1920,1080,false,60);
			case emVOM_HD_720p_50_Api:
				return  new HDVideoOutputParam(1280,720,true,50);
			case emVOM_HD_720p_60hz_Api:
			case emVOM_HD_720p_60fps_Api:
				return  new HDVideoOutputParam(1280,720,true,60);
			case emVOM_HD_576i_50_Api:
				return  new HDVideoOutputParam(720,576,false,50);
			case emVOM_HD_1080p_29_Api:
				return  new HDVideoOutputParam(1920,1080,true,29);
			case emVOM_HD_1080p_59_Api:
				return  new HDVideoOutputParam(1920,1080,true,59);
			case emVOM_HD_576p_Api:
				return  new HDVideoOutputParam(720,576,true,50);
			case emVOM_HD_1080p_29_97_Api:
				return  new HDVideoOutputParam(1920,1080,true,29.97f);
			case emVOM_HD_1080p_59_94_Api:
				return  new HDVideoOutputParam(1920,1080,true,59.94f);
			case emVOM_HD_VGA_60_Api:
				return  new HDVideoOutputParam(640,480,true,60);
			case emVOM_HD_VGA_75_Api:
				return  new HDVideoOutputParam(640,480,true,75);
			case emVOM_HD_SVGA_60_Api:
				return  new HDVideoOutputParam(800,600,true,60);
			case emVOM_HD_SVGA_75_Api:
				return  new HDVideoOutputParam(800,600,true,75);
			case emVOM_HD_XGA_60_Api:
				return  new HDVideoOutputParam(1024,768,true,60);
			case emVOM_HD_XGA_75_Api:
				return  new HDVideoOutputParam(1024,768,true,75);
			case emVOM_HD_SXGA_60_Api:
				return  new HDVideoOutputParam(1280,1024,true,60);
			case emVOM_HD_WXGA1280x768_60_Api:
				return  new HDVideoOutputParam(1280,768,true,60);
			case emVOM_HD_WXGA1280x768_75_Api:
				return  new HDVideoOutputParam(1280,768,true,75);
			case emVOM_HD_WXGA1280x800_60_Api:
				return  new HDVideoOutputParam(1280,800,true,60);
			case emVOM_HD_WXGA1280x800_75_Api:
				return  new HDVideoOutputParam(1280,800,true,75);
			case emVOM_HD_WXGA1366x768_60_Api:
				return  new HDVideoOutputParam(1366,768,true,60);
			case emVOM_HD_UXGA1600x1200_60_Api:
				return  new HDVideoOutputParam(1600,1200,true,60);
			case emVOM_HD_WSXGA1440x900_60_Api:
				return  new HDVideoOutputParam(1440,900,true,60);
			case emVOM_HD_SXGAPLUS1680x1050_60_Api:
				return  new HDVideoOutputParam(1680,1050,true,60);
			case emVOM_HD_4k3860x2160_30_Api:
				return  new HDVideoOutputParam(3860,2160,true,30);
			case emVOM_HD_4k3860x2160_60_Api:
				return  new HDVideoOutputParam(3860,2160,true,60);
		    default:
		        break;
		}
		return  new HDVideoOutputParam(1920,1080,true,60);
	}
}
