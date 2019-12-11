package com.hzq.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TestStr {

    public static void main(String[] args) {
        System.out.println(toHumanStr("1002345.11"));
    }

    public static String toHumanStr(String origin){
        StringBuffer sb = new StringBuffer();
        //1.初始化大写和单位
        String[] number = {"零", "壹", "貳", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] intUnit = {"圆", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿",
                "拾", "佰", "仟", "万", "拾", "佰", "仟"};
        String[] floatUnit = {"角", "分"};
        //2.获取整数和小数部分
        int index = origin.indexOf(".");
        String intStr = null;
        String floatStr = null;
        if(index == -1){
            intStr = origin;
        } else {
            intStr = origin.substring(0, index);
            floatStr = origin.substring(index + 1);
        }
        //3.转换整数和小数部分
        int intLen = intStr.length();
        for (int i = 0; i < intLen; i++){
            int diff = intStr.charAt(i) - '0';
            sb.append(number[diff]);
            sb.append(intUnit[intLen - 1 - i]);
        }
        int floatLen = floatStr.length();
        for (int i = 0; i < floatLen; i++){
            if(i >= 2) break;
            int diff = floatStr.charAt(i) - '0';
            sb.append(number[diff]);
            sb.append(floatUnit[1 - i]);
        }
        String result = sb.toString();
        //4.处理不合法的读法
        result = result.replaceAll("零拾", "零");
        result = result.replaceAll("零佰", "零");
        result = result.replaceAll("零仟", "零");

        result = result.replaceAll("零零", "零");

        result = result.replaceAll("零圆", "圆");
        result = result.replaceAll("零万", "万");
        result = result.replaceAll("零亿", "亿");
        return result;
    }

}
