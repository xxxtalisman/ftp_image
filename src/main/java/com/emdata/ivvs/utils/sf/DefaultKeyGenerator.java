package com.emdata.ivvs.utils.sf;


import com.google.common.base.Preconditions;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;


/**
 * Default distributed primary key generator.
 * <p>
 * <p>
 * Use snowflake algorithm. Length is 64 bit.
 * </p>
 * <p>
 * <pre>
 * 1bit   sign bit.
 * 41bits timestamp offset from 2016.11.01(Sharding-Sphere distributed primary key published data) to now.
 * 10bits worker process id.
 * 12bits auto increment offset in one mills
 * </pre>
 * <p>
 * <p>
 * Call @{@code DefaultKeyGenerator.setWorkerId} to set.
 * </p>
 *
 * @author t
 */
@Slf4j
public final class DefaultKeyGenerator implements KeyGenerator {

    public static final long EPOCH;

    private static final long SEQUENCE_BITS = 12L;

    private static final long WORKER_ID_BITS = 10L;

    private static final long SEQUENCE_MASK = (1 << SEQUENCE_BITS) - 1;

    private static final long WORKER_ID_LEFT_SHIFT_BITS = SEQUENCE_BITS;

    private static final long TIMESTAMP_LEFT_SHIFT_BITS = WORKER_ID_LEFT_SHIFT_BITS + WORKER_ID_BITS;

    private static final long WORKER_ID_MAX_VALUE = 1L << WORKER_ID_BITS;

    @Setter
    private static TimeService timeService = new TimeService();

    private static long workerId;

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.JANUARY, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        EPOCH = calendar.getTimeInMillis();
    }

    private long sequence;

    private long lastTime;

    /**
     * Set work process id.
     *
     * @param workerId work process id
     */
    public static void setWorkerId(final long workerId) {
        Preconditions.checkArgument(workerId >= 0L && workerId < WORKER_ID_MAX_VALUE);
        DefaultKeyGenerator.workerId = workerId;
    }

    /**
     * Generate key.
     *
     * @return key type is @{@link Long}.
     */
    @Override
    public synchronized Number generateKey() {
        long currentMillis = timeService.getCurrentMillis();
        Preconditions.checkState(lastTime <= currentMillis, "Clock is moving backwards, last time is %d milliseconds, current time is %d milliseconds", lastTime, currentMillis);
        if (lastTime == currentMillis) {
            if (0L == (sequence = (sequence + 1) & SEQUENCE_MASK)) {
                currentMillis = waitUntilNextTime(currentMillis);
            }
        } else {
            sequence = 0;
        }
        lastTime = currentMillis;
        //if (log.isDebugEnabled()) {
        //   log.debug("{}-{}-{}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(lastTime)), workerId, sequence);
        //}
        return ((currentMillis - EPOCH) << TIMESTAMP_LEFT_SHIFT_BITS) | (workerId << WORKER_ID_LEFT_SHIFT_BITS) | sequence;
    }

    private long waitUntilNextTime(final long lastTime) {
        long time = timeService.getCurrentMillis();
        while (time <= lastTime) {
            time = timeService.getCurrentMillis();
        }
        return time;
    }
}
