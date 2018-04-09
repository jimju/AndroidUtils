package com.jimju.androidutils.utils;

import android.text.TextUtils;

import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HJJ on 2016/10/10.
 */

public class StringUtils {
    public static String getMD5(String info) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(info.getBytes("UTF-8"));
            byte[] encryption = md5.digest();

            StringBuffer strBuf = new StringBuffer();
            for (int i = 0; i < encryption.length; i++) {
                if (Integer.toHexString(0xff & encryption[i]).length() == 1) {
                    strBuf.append("0").append(Integer.toHexString(0xff & encryption[i]));
                } else {
                    strBuf.append(Integer.toHexString(0xff & encryption[i]));
                }
            }

            return strBuf.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public static String setDefalut(String text,String defalut){
        return TextUtils.isEmpty(text)?defalut:text;
    }

    /**
     * 对比字符串
     * @param s1
     * @param s2
     * @return
     */
    public static int compareString(String s1,String s2){
        int length = s1.length() < s2.length()?s1.length():s2.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) > s2.charAt(i)){
                result = 1;
                break;
            }else if (s1.charAt(i) == s2.charAt(i)){
                result = 0;
            }else {
                result = -1;
                break;
            }
        }
        if (result == 0){
            result = s1.length() - s2.length();
        }
        return result;
    }

    //转换成Int数字
    public static int praseInt(String str, int i) {
        try {
            String string = TextUtils.isDigitsOnly(str) ? str : i + "";
            return Integer.parseInt(string);
        }catch (Exception e) {
            return i;
        }

    }

    /**
     * 去除字符串中的换行
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static String Num2String(Number d){
        String s = String.valueOf(d);
        try {

        if (!s.contains(".")){
            s += ".00";
        }
        if (s.length() - s.lastIndexOf(".") > 3){
            s = s.substring(0,s.lastIndexOf("." + 3));
        }else if (s.length() - s.lastIndexOf(".") > 0 && s.length() - s.lastIndexOf(".") < 3){
            s += "0";
        }
        return s;
        }catch (Exception e){
            return s;
        }
    }
}
