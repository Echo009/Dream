
package cn.echo0.template.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/1/31 18:53
 */
public class JsonUtils {
    /**
     * 将对象转换成Json字符串，忽略 null 值
     * @param object 生成json串的对象
     * @param withPrettyFormat 是否需要格式化
     * @return json字符串
     */
    public static String toJson(Object object , boolean withPrettyFormat){
        if (object == null) {
            return "{}";
        }
        GsonBuilder gsonBuilder  = new GsonBuilder();
        // 不对html字符进行转义
        gsonBuilder.disableHtmlEscaping();
        if (withPrettyFormat) {
            gsonBuilder.setPrettyPrinting();
        }
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }

}
