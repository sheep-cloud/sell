package cn.colg.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

/**
 * 定时时间格式序列化规则
 *
 * @author colg
 */
public class DateSerializer implements ObjectSerializer {

    /**
     * 当fastjson遇到指定类型的字段时，在序列化过程中调用此回调方法。<br>
     * 
     * 毫秒转为秒
     *
     * @param serializer
     * @param object 需要转换为Json的对象
     * @param fieldName 父对象字段名称
     * @param fieldType 父对象字段类型
     * @param features
     * @throws IOException
     */
    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object instanceof Date) {
            Date date = (Date)object;
            // 毫秒转为秒，序列化
            serializer.write(date.getTime() / 1000);
        }

    }
}
