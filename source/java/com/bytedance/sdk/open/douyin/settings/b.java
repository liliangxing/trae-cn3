package com.bytedance.sdk.open.douyin.settings;

import android.os.SystemClock;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes5.dex */
public class b {
    private static final String f = "LockObject";
    private static ConcurrentHashMap<String, b> g = new ConcurrentHashMap<>();
    private File a;
    private FileLock b = null;
    private ReentrantLock c = new ReentrantLock();
    private RandomAccessFile d = null;
    private long e = 0;

    private b(File file) {
        this.a = file;
    }

    public static b a(File file) {
        b putIfAbsent;
        b bVar = g.get(file.getAbsolutePath());
        return (bVar != null || (putIfAbsent = g.putIfAbsent(file.getAbsolutePath(), (bVar = new b(file)))) == null) ? bVar : putIfAbsent;
    }

    public void a() {
        if (!this.c.isHeldByCurrentThread()) {
            throw new IllegalStateException("Check thread fail: not held by current thread");
        }
    }

    public boolean a(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            if (!this.c.tryLock(j, TimeUnit.MILLISECONDS)) {
                return false;
            }
        } catch (Exception unused) {
        }
        if (this.c.getHoldCount() == 1) {
            try {
                if (!this.a.exists()) {
                    this.a.createNewFile();
                }
                if (!this.a.exists()) {
                    this.c.unlock();
                    return false;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.a, "rw");
                this.d = randomAccessFile;
                this.b = randomAccessFile.getChannel().lock();
                this.e = SystemClock.elapsedRealtime();
            } catch (Exception unused2) {
                this.c.unlock();
                return false;
            }
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime2 > 200) {
            LogUtils.w(f, "LockUseTooMuchTime=" + elapsedRealtime2);
        }
        return true;
    }

    public void b() {
        a();
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.e;
        if (this.c.getHoldCount() == 1) {
            try {
                FileLock fileLock = this.b;
                if (fileLock != null) {
                    fileLock.release();
                }
                RandomAccessFile randomAccessFile = this.d;
                if (randomAccessFile != null) {
                    randomAccessFile.getChannel().close();
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.b = null;
                this.d = null;
                throw th;
            }
            this.b = null;
            this.d = null;
        }
        this.c.unlock();
        if (elapsedRealtime > 500) {
            LogUtils.w(f, "UseTooMuchTimeInLock=" + elapsedRealtime);
        }
    }
}
