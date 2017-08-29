package com.wat.utils;

import java.security.MessageDigest;

/**
 * md5 加密工具
 * @author Wutao
 * @version 2017年8月14日 下午3:56:57
 * @see
 * @since
 */
public class MD5Util {

	private static final int INTEGER_0XF = 0xf;
    /**
     * 避免魔鬼数字
     */
    public static final int INTEGER_4 = 4;
    public static final int INTEGER_2 = 2;
    
    /**
     * 
     *〈MD5加密〉
     * @param ss 加密字符串
     * @return String
     */
    public static final  String md5(String ss)
    {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f'};
        try
        {
            byte[] strTemp = ss.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * INTEGER_2];
            int k = 0;
            for (int i = 0; i < j; i++)
            {
                byte byte0 = md[i];
                str[k++ ] = hexDigits[byte0 >>> INTEGER_4 & INTEGER_0XF];
                str[k++ ] = hexDigits[byte0 & INTEGER_0XF];
            }
            return new String(str);
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
