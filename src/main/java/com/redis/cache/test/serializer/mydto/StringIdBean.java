package com.redis.cache.test.serializer.mydto;

import java.io.Serializable;

public abstract class StringIdBean implements Serializable {
    protected abstract String getId();
}
