package com.redis.cache.test.serializer.serializer;

import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;
import net.jpountz.lz4.LZ4SafeDecompressor;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class LZ4Serializer<T>  {
    private final LZ4Compressor compressor;
    LZ4FastDecompressor decompressor;
    LZ4SafeDecompressor safeDecompressor;
    private Class<T> clazz;


    public LZ4Serializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
        LZ4Factory factory = LZ4Factory.fastestInstance();
        compressor = factory.fastCompressor();
        decompressor = factory.fastDecompressor();
        safeDecompressor = factory.safeDecompressor();
    }

    public Map<byte[],byte[]> serialize(byte[] data) {
        final int decompressedLength = data.length;

        // compress data
        int maxCompressedLength = compressor.maxCompressedLength(decompressedLength);
        byte[] compressed = new byte[maxCompressedLength];
        int compressedLength = compressor.compress(data, 0, decompressedLength, compressed, 0, maxCompressedLength);
        Map<byte[],byte[]> result = new HashMap();
        result.put(String.valueOf(decompressedLength).getBytes(),compressed);
        return result;
    }

    public T deserialize(Map<byte[],byte[]> compressedMap) throws SerializationException {

        Map.Entry<byte[], byte[]> obj = compressedMap.entrySet().iterator().next();
        int deCompressedLength = Integer.parseInt(new String(obj.getKey()));

        byte[] restored = new byte[deCompressedLength];
        int decompressedLength2 = decompressor.decompress(obj.getValue(), 0, restored, 0, deCompressedLength);
        return (T) restored;
    }


    /**
     * 对象转Byte数组
     *
     * @param obj
     * @return
     */
    private static byte[] objectToByteArray(Object obj) {
        if (null != obj && obj instanceof String) {
            return ((String) obj).getBytes();
        }
        byte[] bytes = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            bytes = byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return bytes;
    }
}
