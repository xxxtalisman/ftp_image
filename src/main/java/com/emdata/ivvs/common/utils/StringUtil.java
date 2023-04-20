package com.emdata.ivvs.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import sun.misc.BASE64Decoder;

/**
 * 字符串操作类
 */
public class StringUtil {

    private static AtomicInteger counter = new AtomicInteger(0);

    public static final String IP_REGEX =
        "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
            + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

    public static List<String[]> splitToList(String orgStr, String splitStr1, String splitStr2) {
        List<String[]> list = new ArrayList<String[]>();

        String[] newStr = removeLastStr(orgStr, splitStr1).split(splitStr1);
        for (String tmpStr : newStr) {
            list.add(removeLastStr(tmpStr, splitStr2).split(splitStr2));
        }
        return list;
    }

    public static String[] splitToArray(String orgStr, String splitStr) {
        return removeLastStr(orgStr, splitStr).split(splitStr);
    }

    public static String removeLastStr(String orgStr, String lastStr) {
        if (orgStr.endsWith(lastStr)) {
            orgStr = orgStr.substring(0, orgStr.lastIndexOf(lastStr));
        }
        return orgStr;
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return obj.toString();
        }
    }

    /**
     * 替换字符串
     *
     * @param str
     * @param map
     * @param tag
     * @return
     */
    public static String replaceString(String str, final Map<String, Object> map, final String tag) {
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            String key = entry.getKey();
            Object value = entry.getValue();

            String replaceStr = tag + key + tag;
            if (str.contains(replaceStr)) {
                str = str.replaceAll(replaceStr, toString(value));
            }
        }
        return str;
    }

    /**
     * 替换字符串
     *
     * @param str
     * @param map
     * @return
     */
    public static String replaceString(String str, final Map<String, Object> map) {
        return replaceString(str, map, "%");
    }

    public static List<Integer> toIntegerList(String[] sArr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < sArr.length; i++) {
            if (StringUtils.isBlank(sArr[i])) {
                continue;
            }
            list.add(Integer.valueOf(sArr[i]));
        }
        return list;
    }

    /**
     * 非空判断
     *
     * @param @param
     *            obj
     * @param @return
     * @return boolean
     * @author shaodongyang gdl
     */
    public static boolean checkNotNull(Object obj) {
        boolean isTrue = false;
        if (obj != null && !obj.equals("")) {
            isTrue = true;
        }
        return isTrue;

    }

    /**
     * 判断传入的字符串是否是数字,这个很常用的用了能减少很多恶意的bug @Title: isNumber @param @param value @param @return 设定文件 @return boolean
     * 返回类型 @author shaodongyang gdl @date
     */
    public static boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static boolean isIp(String ip) {
        if (StringUtils.isBlank(ip)) {
            return false;
        }
        Pattern p = Pattern.compile(IP_REGEX);
        Matcher m = p.matcher(ip);
        return m.matches();

    }

    /**
     * 四舍五入保存两位小数
     * 
     * @param bigDecimal
     * @return
     */
    public static BigDecimal formatRound(BigDecimal bigDecimal) {
        if (bigDecimal != null) {
            bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return bigDecimal;
    }

    private StringUtil() {}

    public static String encodeUTF8(String xmlDoc) {
        String str = "";
        try {
            xmlDoc = StringUtil.transNull(xmlDoc);
            if (!"".equals(xmlDoc)) {
                str = URLEncoder.encode(xmlDoc, "utf-8");
            }
            return str;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return str;
    }

    public static String decodeUTF8(String xmlDoc) {
        String str = "";
        try {
            xmlDoc = StringUtil.transNull(xmlDoc);
            if (!"".equals(xmlDoc)) {
                str = URLDecoder.decode(xmlDoc, "utf-8");
            }
            return str;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return str;
    }

    public static String transNull(String str) {

        String result = str;
        if (null == str || "".equals(str) || "null".equalsIgnoreCase(str)) {
            result = "";
        }
        return result;
    }

    public static byte[] strToBase64(String content) throws IOException {
        if (null == content) {
            return null;
        }
        return new BASE64Decoder().decodeBuffer(content.trim());
    }

    public static String base64ToStr(byte[] bytes) throws IOException {
        String content = "";
        content = new sun.misc.BASE64Encoder().encode(bytes);
        return content;
    }

    public static byte[] getByte(InputStream in) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            copy(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();

    }

    private static void copy(InputStream in, OutputStream out) throws IOException {
        try {
            byte[] buffer = new byte[4096];
            int nrOfBytes = -1;
            while ((nrOfBytes = in.read(buffer)) != -1) {
                out.write(buffer, 0, nrOfBytes);
            }
            out.flush();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
            }
        }
    }

    /**
     * 首字母变小写
     *
     * @param str
     * @return
     */
    public static String firstCharToLowerCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'A' && firstChar <= 'Z') {
            char[] arr = str.toCharArray();
            arr[0] += ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    /**
     * 首字母变大写
     *
     * @param str
     * @return
     */
    public static String firstCharToUpperCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'a' && firstChar <= 'z') {
            char[] arr = str.toCharArray();
            arr[0] -= ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    /**
     * 判断是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(final String str) {
        return (str == null) || (str.length() == 0);
    }

    /**
     * 判断是否不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(final String str) {
        return !isEmpty(str);
    }

    /**
     * 判断是否空白
     *
     * @param str
     * @return
     */
    public static boolean isBlank(final String str) {
        int strLen;
        if ((str == null) || ((strLen = str.length()) == 0))
            return true;
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否不是空白
     *
     * @param str
     * @return
     */
    public static boolean isNotBlank(final String str) {
        return !isBlank(str);
    }

    /**
     * 判断多个字符串全部是否为空
     *
     * @param strings
     * @return
     */
    public static boolean isAllEmpty(String... strings) {
        if (strings == null) {
            return true;
        }
        for (String str : strings) {
            if (isNotEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断多个字符串其中任意一个是否为空
     *
     * @param strings
     * @return
     */
    public static boolean isHasEmpty(String... strings) {
        if (strings == null) {
            return true;
        }
        for (String str : strings) {
            if (isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * checkValue为 null 或者为 "" 时返回 defaultValue
     *
     * @param checkValue
     * @param defaultValue
     * @return
     */
    public static String isEmpty(String checkValue, String defaultValue) {
        return isEmpty(checkValue) ? defaultValue : checkValue;
    }

    /**
     * 字符串不为 null 而且不为 "" 并且等于other
     *
     * @param str
     * @param other
     * @return
     */
    public static boolean isNotEmptyAndEquelsOther(String str, String other) {
        if (isEmpty(str)) {
            return false;
        }
        return str.equals(other);
    }

    /**
     * 字符串不为 null 而且不为 "" 并且不等于other
     *
     * @param str
     * @param other
     * @return
     */
    public static boolean isNotEmptyAndNotEquelsOther(String str, String... other) {
        if (isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < other.length; i++) {
            if (str.equals(other[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串不等于other
     *
     * @param str
     * @param other
     * @return
     */
    public static boolean isNotEquelsOther(String str, String... other) {
        for (int i = 0; i < other.length; i++) {
            if (other[i].equals(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串不为空
     *
     * @param strings
     * @return
     */
    public static boolean isNotEmpty(String... strings) {
        if (strings == null) {
            return false;
        }
        for (String str : strings) {
            if (str == null || "".equals(str.trim())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 比较字符相等
     *
     * @param value
     * @param equals
     * @return
     */
    public static boolean equals(String value, String equals) {
        if (isAllEmpty(value, equals)) {
            return true;
        }
        return value.equals(equals);
    }

    /**
     * 比较字符串不相等
     *
     * @param value
     * @param equals
     * @return
     */
    public static boolean isNotEquals(String value, String equals) {
        return !equals(value, equals);
    }

    public static String[] split(String content, String separatorChars) {
        return splitWorker(content, separatorChars, -1, false);
    }

    public static String[] split(String str, String separatorChars, int max) {
        return splitWorker(str, separatorChars, max, false);
    }

    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    private static String[] splitWorker(String str, String separatorChars, int max, boolean preserveAllTokens) {
        if (str == null) {
            return null;
        }
        int len = str.length();
        if (len == 0) {
            return EMPTY_STRING_ARRAY;
        }
        List<String> list = new ArrayList<String>();
        int sizePlus1 = 1;
        int i = 0, start = 0;
        boolean match = false;
        boolean lastMatch = false;
        if (separatorChars == null) {
            while (i < len) {
                if (Character.isWhitespace(str.charAt(i))) {
                    if (match || preserveAllTokens) {
                        lastMatch = true;
                        if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        } else if (separatorChars.length() == 1) {
            char sep = separatorChars.charAt(0);
            while (i < len) {
                if (str.charAt(i) == sep) {
                    if (match || preserveAllTokens) {
                        lastMatch = true;
                        if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        } else {
            while (i < len) {
                if (separatorChars.indexOf(str.charAt(i)) >= 0) {
                    if (match || preserveAllTokens) {
                        lastMatch = true;
                        if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        }
        if (match || (preserveAllTokens && lastMatch)) {
            list.add(str.substring(start, i));
        }
        return (String[])list.toArray(EMPTY_STRING_ARRAY);
    }

    /**
     * 消除转义字符
     *
     * @param str
     * @return
     */
    public static String escapeXML(String str) {
        if (str == null)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            switch (c) {
                case '\u00FF':
                case '\u0024':
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '\"':
                    sb.append("&quot;");
                    break;
                case '\'':
                    sb.append("&apos;");
                    break;
                default:
                    if (c >= '\u0000' && c <= '\u001F')
                        break;
                    if (c >= '\uE000' && c <= '\uF8FF')
                        break;
                    if (c >= '\uFFF0' && c <= '\uFFFF')
                        break;
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }

    /**
     * 将字符串中特定模式的字符转换成map中对应的值
     *
     * @param s
     *            需要转换的字符串
     * @param map
     *            转换所需的键值对集合
     * @return 转换后的字符串
     */
    public static String replace(String s, Map<String, Object> map) {
        StringBuilder ret = new StringBuilder((int)(s.length() * 1.5));
        int cursor = 0;
        for (int start, end; (start = s.indexOf("${", cursor)) != -1 && (end = s.indexOf("}", start)) != -1;) {
            ret.append(s.substring(cursor, start)).append(map.get(s.substring(start + 2, end)));
            cursor = end + 1;
        }
        ret.append(s.substring(cursor, s.length()));
        return ret.toString();
    }

    public static String replace(String s, Object... objs) {
        if (objs == null || objs.length == 0)
            return s;
        if (s.indexOf("{}") == -1)
            return s;
        StringBuilder ret = new StringBuilder((int)(s.length() * 1.5));
        int cursor = 0;
        int index = 0;
        for (int start; (start = s.indexOf("{}", cursor)) != -1;) {
            ret.append(s.substring(cursor, start));
            if (index < objs.length)
                ret.append(objs[index]);
            else
                ret.append("{}");
            cursor = start + 2;
            index++;
        }
        ret.append(s.substring(cursor, s.length()));
        return ret.toString();
    }

    /**
     * 字符串格式化工具,参数必须以{0}之类的样式标示出来.大括号中的数字从0开始。
     *
     * @param source
     *            源字符串
     * @param params
     *            需要替换的参数列表,写入时会调用每个参数的toString().
     * @return 替换完成的字符串。如果原始字符串为空或者参数为空那么将直接返回原始字符串。
     */
    public static String replaceArgs(String source, Object... params) {
        if (params == null || params.length == 0 || source == null || source.isEmpty()) {
            return source;
        }
        StringBuilder buff = new StringBuilder(source);
        StringBuilder temp = new StringBuilder();
        int startIndex = 0;
        int endIndex = 0;
        String param = null;
        for (int count = 0; count < params.length; count++) {
            if (params[count] == null) {
                param = null;
            } else {
                param = params[count].toString();
            }

            temp.delete(0, temp.length());
            temp.append("{");
            temp.append(count);
            temp.append("}");
            while (true) {
                startIndex = buff.indexOf(temp.toString(), endIndex);
                if (startIndex == -1) {
                    break;
                }
                endIndex = startIndex + temp.length();

                buff.replace(startIndex, endIndex, param == null ? "" : param);
            }
            startIndex = 0;
            endIndex = 0;
        }
        return buff.toString();
    }

    public static String substringBefore(final String s, final String separator) {
        if (isEmpty(s) || separator == null) {
            return s;
        }
        if (separator.isEmpty()) {
            return "";
        }
        final int pos = s.indexOf(separator);
        if (pos < 0) {
            return s;
        }
        return s.substring(0, pos);
    }

    public static String substringBetween(final String str, final String open, final String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        final int start = str.indexOf(open);
        if (start != -1) {
            final int end = str.indexOf(close, start + open.length());
            if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }

    public static String substringAfter(final String str, final String separator) {
        if (isEmpty(str)) {
            return str;
        }
        if (separator == null) {
            return "";
        }
        final int pos = str.indexOf(separator);
        if (pos == -1) {
            return "";
        }
        return str.substring(pos + separator.length());
    }

    /**
     * 转换为字节数组
     *
     * @param
     * @return
     */
    public static String toString(byte[] bytes) {
        try {
            return new String(bytes, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * 转换为字节数组
     *
     * @param str
     * @return
     */
    public static byte[] getBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes("utf-8");
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 自动生成时间序列
     * 
     * @return
     */
    public static synchronized String getGeneraterNextNumber() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderCode = formatter.format(date) + String.format("%04d", StringUtil.getCount());
        return orderCode;
    }

    /**
     * 生成序列
     * 
     * @return
     */
    public static int getCount() {
        int c = counter.incrementAndGet();
        if (c == 9999) {
            counter.set(0);
        }
        return c;
    }

    public static void main(String[] args) {
        // genSeqCode( redisTemplate, "11", 22);
        // redisTemplate.in
        for (int i = 0; i < 100; i++) {
            System.out.println(getGeneraterNextNumber() + "=====================");
        }

    }

    // public static String genSeqCode(RedisTemplate redisTemplate, String prefix, int dailyIncNumSize){
    // String thisDate = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
    // String store_key = String.join(StringUtil.class.getName(), prefix, thisDate);
    // Long inc = redisTemplate.opsForValue().increment(store_key, 1);
    // if (inc.compareTo(1L)==0) { // 第一次，设置过期时间
    // redisTemplate.expire(store_key, 2, TimeUnit.DAYS);
    // }
    // String increment = String.valueOf(Math.round(Math.pow(10,dailyIncNumSize)) +inc).substring(1);
    // return String.join("",prefix, thisDate, increment);
    // }

}
