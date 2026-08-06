package com.bytedance.geckox.lock;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

/* compiled from: GeckoReadWriteLock.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/geckox/lock/GeckoReadWriteLock;", "", "()V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "readCount", "", "writeFlag", "", "readLock", "readTryLock", "readUnlock", "", "writeTryLock", "writeUnlock", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class GeckoReadWriteLock {
    private final ReentrantLock lock = new ReentrantLock();
    private volatile int readCount;
    private volatile boolean writeFlag;

    public final boolean readLock() throws Exception {
        int i = 0;
        while (i < 50) {
            this.lock.lock();
            if (this.writeFlag) {
                this.lock.unlock();
                i += 10;
                Thread.sleep(10L);
            } else {
                this.readCount++;
                this.lock.unlock();
                return true;
            }
        }
        return false;
    }

    public final boolean readTryLock() throws Exception {
        try {
            this.lock.lock();
            if (!this.writeFlag) {
                this.readCount++;
                return true;
            }
            this.lock.unlock();
            return false;
        } finally {
            this.lock.unlock();
        }
    }

    public final void readUnlock() throws Exception {
        try {
            this.lock.lock();
            if (this.readCount == 0) {
                return;
            }
            this.readCount--;
        } finally {
            this.lock.unlock();
        }
    }

    public final boolean writeTryLock() throws Exception {
        try {
            this.lock.lock();
            if (this.readCount <= 0 && !this.writeFlag) {
                this.writeFlag = true;
                return true;
            }
            this.lock.unlock();
            return false;
        } finally {
            this.lock.unlock();
        }
    }

    public final void writeUnlock() throws Exception {
        try {
            this.lock.lock();
            this.writeFlag = false;
        } finally {
            this.lock.unlock();
        }
    }
}
