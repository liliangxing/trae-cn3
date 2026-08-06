package com.bytedance.sdk.open.douyin.settings;

import android.os.SystemClock;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.bytedance.sdk.open.douyin.settings.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0126b {

    /* renamed from: f */
    private static final String f107f = "LockObject";

    /* renamed from: g */
    private static ConcurrentHashMap<String, C0126b> f108g = new ConcurrentHashMap<>();

    /* renamed from: a */
    private File f109a;

    /* renamed from: b */
    private FileLock f110b = null;

    /* renamed from: c */
    private ReentrantLock f111c = new ReentrantLock();

    /* renamed from: d */
    private RandomAccessFile f112d = null;

    /* renamed from: e */
    private long f113e = 0;

    private C0126b(File file) {
        this.f109a = file;
    }

    /* renamed from: a */
    public static C0126b m45a(File file) {
        C0126b putIfAbsent;
        C0126b c0126b = f108g.get(file.getAbsolutePath());
        return (c0126b != null || (putIfAbsent = f108g.putIfAbsent(file.getAbsolutePath(), (c0126b = new C0126b(file)))) == null) ? c0126b : putIfAbsent;
    }

    /* renamed from: a */
    public void m46a() {
        if (!this.f111c.isHeldByCurrentThread()) {
            throw new IllegalStateException("Check thread fail: not held by current thread");
        }
    }

    /* renamed from: a */
    public boolean m47a(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            if (!this.f111c.tryLock(j, TimeUnit.MILLISECONDS)) {
                return false;
            }
        } catch (Exception unused) {
        }
        if (this.f111c.getHoldCount() == 1) {
            try {
                if (!this.f109a.exists()) {
                    this.f109a.createNewFile();
                }
                if (!this.f109a.exists()) {
                    this.f111c.unlock();
                    return false;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.f109a, "rw");
                this.f112d = randomAccessFile;
                this.f110b = randomAccessFile.getChannel().lock();
                this.f113e = SystemClock.elapsedRealtime();
            } catch (Exception unused2) {
                this.f111c.unlock();
                return false;
            }
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime2 > 200) {
            LogUtils.m30w(f107f, "LockUseTooMuchTime=" + elapsedRealtime2);
        }
        return true;
    }

    /* renamed from: b */
    public void m48b() {
        m46a();
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f113e;
        if (this.f111c.getHoldCount() == 1) {
            try {
                FileLock fileLock = this.f110b;
                if (fileLock != null) {
                    fileLock.release();
                }
                RandomAccessFile randomAccessFile = this.f112d;
                if (randomAccessFile != null) {
                    randomAccessFile.getChannel().close();
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f110b = null;
                this.f112d = null;
                throw th;
            }
            this.f110b = null;
            this.f112d = null;
        }
        this.f111c.unlock();
        if (elapsedRealtime > 500) {
            LogUtils.m30w(f107f, "UseTooMuchTimeInLock=" + elapsedRealtime);
        }
    }
}
