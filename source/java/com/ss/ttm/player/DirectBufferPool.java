package com.ss.ttm.player;

import com.ss.ttm.utils.AVLogger;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public final class DirectBufferPool {
    private static final int S_FAIL = -1;
    private static final int S_OK = 0;
    private static final String TAG = "DirectBufferPool";
    private static volatile DirectBufferPool instance;
    private int mCheckIntervalMs;
    private AtomicInteger bufferPoolSizeLimit = new AtomicInteger(2);
    private Queue<DirectBufferUnion> bufferPool = new LinkedBlockingQueue();

    private DirectBufferPool() {
        this.mCheckIntervalMs = 30000;
        setDirectBufferPoolSize(TTPlayerConfiger.getValue(84, 2));
        boolean z = TTPlayerConfiger.getValue(85, 0) != 0;
        int value = TTPlayerConfiger.getValue(86, 30000);
        this.mCheckIntervalMs = value;
        if (z && value > 0) {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            Runnable runnable = new Runnable() { // from class: com.ss.ttm.player.DirectBufferPool$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DirectBufferPool.this.checkExpireThreadPeriod();
                }
            };
            int i = this.mCheckIntervalMs;
            newScheduledThreadPool.scheduleWithFixedDelay(runnable, i, i, TimeUnit.MILLISECONDS);
        }
        AVLogger.InfoTrackLife(TAG, this, "create direct buffer pool, needCheckExpire:" + z + ", mCheckIntervalMs:" + this.mCheckIntervalMs);
    }

    public static DirectBufferPool getInstance() {
        if (instance == null) {
            synchronized (DirectBufferPool.class) {
                if (instance == null) {
                    instance = new DirectBufferPool();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkExpireThreadPeriod() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (DirectBufferUnion.class) {
            while (!this.bufferPool.isEmpty() && currentTimeMillis - this.bufferPool.peek().freeTimePoint > this.mCheckIntervalMs) {
                linkedBlockingQueue.offer(this.bufferPool.peek());
                this.bufferPool.poll();
            }
        }
        AVLogger.InfoTrackLife(TAG, this, "exist direct buffer after check expire:" + this.bufferPool.size() + ", clean size:" + linkedBlockingQueue.size());
        while (!linkedBlockingQueue.isEmpty()) {
            ByteBuffer byteBuffer = ((DirectBufferUnion) linkedBlockingQueue.poll()).buffer;
            if (byteBuffer != null) {
                clean(byteBuffer);
            }
        }
    }

    public ByteBuffer getReuseDirectBuffer(int bufferSize) {
        if (this.bufferPool.isEmpty()) {
            AVLogger.InfoTrackLife(TAG, this, "pool is empty, find match direct buffer fail");
            return null;
        }
        synchronized (this) {
            DirectBufferUnion directBufferUnion = null;
            for (DirectBufferUnion directBufferUnion2 : this.bufferPool) {
                if (directBufferUnion2.size == bufferSize) {
                    this.bufferPool.remove(directBufferUnion2);
                    AVLogger.InfoTrackLife(TAG, this, "find best-match direct buffer, after pool size:" + this.bufferPool.size());
                    return directBufferUnion2.buffer;
                }
                if (directBufferUnion2.size > bufferSize) {
                    directBufferUnion = directBufferUnion2;
                }
            }
            if (directBufferUnion != null) {
                this.bufferPool.remove(directBufferUnion);
                AVLogger.InfoTrackLife(TAG, this, "find size not-match direct buffer, after pool size:" + this.bufferPool.size());
                return directBufferUnion.buffer;
            }
            AVLogger.InfoTrackLife(TAG, this, "find match direct buffer fail, pool size:" + this.bufferPool.size());
            return null;
        }
    }

    public int pushDirectBufferBack(ByteBuffer buffer) {
        if (buffer == null) {
            return 0;
        }
        int capacity = buffer.capacity();
        buffer.clear();
        synchronized (this) {
            Iterator<DirectBufferUnion> it = this.bufferPool.iterator();
            while (it.hasNext()) {
                if (it.next().size == capacity) {
                    clean(buffer);
                    AVLogger.InfoTrackLife(TAG, this, "pool has similarity direct buffer, size:" + this.bufferPool.size());
                    return -1;
                }
            }
            DirectBufferUnion directBufferUnion = new DirectBufferUnion(buffer, capacity);
            if (this.bufferPool.size() < this.bufferPoolSizeLimit.get()) {
                if (this.bufferPool.offer(directBufferUnion)) {
                    directBufferUnion.resetFreeTimePoint();
                    AVLogger.InfoTrackLife(TAG, this, "push direct buffer success, size:" + this.bufferPool.size());
                }
            } else {
                DirectBufferUnion poll = this.bufferPool.poll();
                if (poll != null) {
                    clean(poll.buffer);
                }
                if (this.bufferPool.offer(directBufferUnion)) {
                    directBufferUnion.resetFreeTimePoint();
                    AVLogger.InfoTrackLife(TAG, this, "push direct buffer after poll success, size:" + this.bufferPool.size());
                }
            }
            return 0;
        }
    }

    public void clean(ByteBuffer buffer) {
        if (buffer == null) {
            return;
        }
        AVLogger.InfoTrackLife(TAG, this, "start clean direct buffer");
        try {
            if (buffer.isDirect()) {
                Method method = buffer.getClass().getMethod("cleaner", new Class[0]);
                method.setAccessible(true);
                Object invoke = method.invoke(buffer, new Object[0]);
                if (invoke != null) {
                    invoke.getClass().getMethod("clean", new Class[0]).invoke(invoke, new Object[0]);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void setDirectBufferPoolSize(int size) {
        AVLogger.InfoTrackLife(TAG, this, "set direct buffer pool size:" + size);
        this.bufferPoolSizeLimit.set(size);
    }
}
