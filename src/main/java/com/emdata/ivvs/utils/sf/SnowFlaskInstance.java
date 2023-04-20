package com.emdata.ivvs.utils.sf;

import lombok.extern.slf4j.Slf4j;



/**
 * Key generator interface.
 *
 * @author snow
 */
@Slf4j
public class SnowFlaskInstance {
    private static SnowFlaskInstance ourInstance = new SnowFlaskInstance();
    private KeyGenerator keyGenerator = null;

    private SnowFlaskInstance() {
        if (null == keyGenerator) {
            create();
        }
    }

    public static SnowFlaskInstance getInstance() {
        return ourInstance;
    }

    private synchronized void create() {
        if (null == keyGenerator) {
            DefaultKeyGenerator.setWorkerId(2);
            keyGenerator = new DefaultKeyGenerator();
        }
    }

    public KeyGenerator GetKeyGenerator() {
        return keyGenerator;
    }
}
