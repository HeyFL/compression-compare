package com.redis.cache.test.serializer.serializer;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.DefaultIdStrategy;
import io.protostuff.runtime.IdStrategy;
import io.protostuff.runtime.RuntimeSchema;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Description: Fst 序列化.<br>
 *
 * @author Chris Cai
 *     Created By 2019/8/20 下午3:36
 */
public class ProtostuffSerializer<T> implements RedisSerializer<T> {
    static final DefaultIdStrategy STRATEGY = new DefaultIdStrategy(IdStrategy.DEFAULT_FLAGS |
            IdStrategy.ALLOW_NULL_ARRAY_ELEMENT);
    private Class<T> clazz;
    private final BlockingQueue blockingQueue = new ArrayBlockingQueue(512);
    LinkedBuffer linkedBuffer = LinkedBuffer.allocate(512);

    Schema<T> schema;

    public ProtostuffSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
        schema= RuntimeSchema.getSchema(clazz, STRATEGY);
    }

    @Override
    public byte[] serialize(T t)  {

        LinkedBuffer buffer = null;
        byte[] bytes = null;
        try {
            buffer = LinkedBuffer.allocate(512);
            bytes = ProtostuffIOUtil.toByteArray(t, schema, buffer);
        }finally {
            buffer.clear();
        }
        return bytes;
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        T obj = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(bytes, obj, schema);
        return obj;
    }
}
