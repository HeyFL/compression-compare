package com.redis.cache.test.serializer.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.ByteBufferInput;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.CollectionSerializer;
import com.esotericsoftware.kryo.serializers.CompatibleFieldSerializer;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import com.esotericsoftware.kryo.util.DefaultInstantiatorStrategy;
import com.esotericsoftware.kryo.util.Pool;
import de.javakaffee.kryoserializers.ArraysAsListSerializer;
import de.javakaffee.kryoserializers.SynchronizedCollectionsSerializer;
import de.javakaffee.kryoserializers.UUIDSerializer;
import de.javakaffee.kryoserializers.UnmodifiableCollectionsSerializer;
import org.objenesis.strategy.StdInstantiatorStrategy;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.ByteArrayInputStream;
import java.util.*;


/**
 * Description: Kryo 序列化.<br>
 *
 * @author Chris Cai
 *     Created By 2019/8/20 下午3:36
 */
public class KryoSerializer<T> implements RedisSerializer<T> {
    private static final int BUFFER_SIZE = 2048;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static Map<Class, Serializer> mCustomSerializers = new HashMap<>();
    private static Pool<Kryo> kryoPool = new Pool<Kryo>(true, false, 8) {
        @Override
        protected Kryo create() {
            Kryo kryo = new Kryo();
            kryo.setRegistrationRequired(false);//官方说false可能会导致bug
            kryo.setDefaultSerializer(JavaSerializer.class);
            kryo.setReferences(false);

            // Serialize Arrays$ArrayList
            // noinspection ArraysAsListWithZeroOrOneArgument
            kryo.register(Collections.singletonList("").getClass(), new ArraysAsListSerializer());
            UnmodifiableCollectionsSerializer.registerSerializers(kryo);
            SynchronizedCollectionsSerializer.registerSerializers(kryo);

            // Serialize inner AbstractList$SubAbstractListRandomAccess
            kryo.addDefaultSerializer(new ArrayList<>().subList(0, 0).getClass(), new CollectionSerializer());
            kryo.addDefaultSerializer(new LinkedList<>().subList(0, 0).getClass(), new CollectionSerializer());
            kryo.register(UUID.class, new UUIDSerializer());

            //常见类型
            /*kryo.register(HashMap.class);
            kryo.register(ArrayList.class);
            kryo.register(LinkedList.class);
            kryo.register(HashSet.class);
            kryo.register(TreeSet.class);
            kryo.register(Hashtable.class);
            kryo.register(Date.class);
            kryo.register(Calendar.class);
            kryo.register(ConcurrentHashMap.class);
            kryo.register(SimpleDateFormat.class);
            kryo.register(GregorianCalendar.class);
            kryo.register(Vector.class);
            kryo.register(BitSet.class);
            kryo.register(StringBuffer.class);
            kryo.register(StringBuilder.class);
            kryo.register(Object.class);
            kryo.register(Object[].class);
            kryo.register(String[].class);
            kryo.register(byte[].class);
            kryo.register(char[].class);
            kryo.register(int[].class);
            kryo.register(float[].class);
            kryo.register(double[].class);*/


            for (Class<?> clazz : mCustomSerializers.keySet()) {
                kryo.register(clazz, mCustomSerializers.get(clazz));
            }

            kryo.setInstantiatorStrategy(
                    new DefaultInstantiatorStrategy(new StdInstantiatorStrategy()));

            return kryo;
        }
    };
    private static Pool<Output> outputPool = new Pool<Output>(true, false, 16) {
        @Override
        protected Output create() {
            return new Output(BUFFER_SIZE, -1);
        }
    };
    private static Pool<Input> inputPool = new Pool<Input>(true, false, 16) {
        @Override
        protected Input create() {
            return new ByteBufferInput(BUFFER_SIZE);
        }
    };
    private Class<T> clazz;

    public KryoSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (null == t) {
            return EMPTY_BYTE_ARRAY;
        }
        Kryo kryo = null;
        Output output = null;
        byte[] bytes;
        try {
            output = outputPool.obtain();
            kryo = kryoPool.obtain();
            kryo.register(clazz,new CompatibleFieldSerializer(kryo,clazz));
            kryo.writeClassAndObject(output, t);
            output.flush();
            return output.toBytes();
        } finally {
            if (output != null) {
                outputPool.free(output);
            }
            if (kryo != null) {
                kryoPool.free(kryo);
            }
        }
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (null == bytes || bytes.length <= 0) {
            return null;
        }
        Kryo kryo = null;
        Input input = null;
        try {
            input = inputPool.obtain();
            input.setInputStream(new ByteArrayInputStream(bytes));
            kryo = kryoPool.obtain();
            kryo.register(clazz,new CompatibleFieldSerializer(kryo,clazz));
            return (T) kryo.readClassAndObject(input);
        } finally {
            if (input != null) {
                inputPool.free(input);
            }
            if (kryo != null) {
                kryoPool.free(kryo);
            }
        }
    }
}
