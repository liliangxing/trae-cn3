package com.bytedance.forest.utils.io;

import com.bytedance.bdturing.EventReport;
import com.bytedance.forest.model.Timing;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ThreadUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: concurrent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u001dJ(\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\n2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003J\b\u0010$\u001a\u00020%H\u0016J\u0006\u0010&\u001a\u00020\u001dJ\"\u0010'\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\n2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/forest/utils/io/ConcurrentIOMeta;", "Ljava/io/ByteArrayOutputStream;", "initialSize", "", "logger", "Lcom/bytedance/forest/utils/ForestLogger;", "logCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "(ILcom/bytedance/forest/utils/ForestLogger;Ljava/util/concurrent/atomic/AtomicInteger;)V", "buffer", "", "getBuffer", "()[B", "finishWaiter", "Ljava/util/concurrent/CountDownLatch;", "isClosed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isFulFilled", "getLogger", "()Lcom/bytedance/forest/utils/ForestLogger;", "setLogger", "(Lcom/bytedance/forest/utils/ForestLogger;)V", "readAvailable", "getReadAvailable", "()I", "readWriteLocker", "Ljava/lang/Object;", EventReport.DIALOG_CLOSE, "", Timing.SUFFIX_FINISH, "read", "start", "bytes", "off", "len", "toString", "", "waitForFinish", "write", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ConcurrentIOMeta extends ByteArrayOutputStream {
    public static final String CLASS_NAME = "ConcurrentIOMeta";
    private final CountDownLatch finishWaiter;
    private final AtomicBoolean isClosed;
    private final AtomicBoolean isFulFilled;
    private final AtomicInteger logCounter;
    private ForestLogger logger;
    private final Object readWriteLocker;

    public final ForestLogger getLogger() {
        return this.logger;
    }

    public final void setLogger(ForestLogger forestLogger) {
        Intrinsics.checkParameterIsNotNull(forestLogger, "<set-?>");
        this.logger = forestLogger;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcurrentIOMeta(int i, ForestLogger forestLogger, AtomicInteger atomicInteger) {
        super(i);
        Intrinsics.checkParameterIsNotNull(forestLogger, "logger");
        Intrinsics.checkParameterIsNotNull(atomicInteger, "logCounter");
        this.logger = forestLogger;
        this.logCounter = atomicInteger;
        this.isFulFilled = new AtomicBoolean(false);
        this.isClosed = new AtomicBoolean(false);
        this.finishWaiter = new CountDownLatch(1);
        this.readWriteLocker = new Object();
    }

    public final byte[] getBuffer() {
        return this.buf;
    }

    public final int getReadAvailable() {
        int i;
        synchronized (this.readWriteLocker) {
            i = this.count;
        }
        return i;
    }

    /* renamed from: isFulFilled, reason: from getter */
    public final AtomicBoolean getIsFulFilled() {
        return this.isFulFilled;
    }

    /* renamed from: isClosed, reason: from getter */
    public final AtomicBoolean getIsClosed() {
        return this.isClosed;
    }

    public final int read(int start, byte[] bytes, int off, int len) throws IOException {
        if (this.isClosed.get()) {
            throw new IOException("ConcurrentIOMeta closed!");
        }
        if (bytes == null) {
            throw new IOException("ByteArray is NULL!");
        }
        Ref.IntRef intRef = new Ref.IntRef();
        int andIncrement = this.logCounter.getAndIncrement();
        synchronized (this.readWriteLocker) {
            intRef.element = this.count - start;
            while (intRef.element <= 0) {
                ForestLogger.print$default(this.logger, 3, "Concurrent", '[' + andIncrement + "]count=" + this.count + ", start=" + start + ", sizeCanRead=" + intRef.element + ", isFulFilled=" + this.isFulFilled.get() + ", isClosed=" + this.isClosed, false, null, null, 56, null);
                if (!this.isFulFilled.get() && !this.isClosed.get()) {
                    ForestLogger.print$default(this.logger, 3, "Concurrent", '[' + andIncrement + "]start to wait writing", false, null, null, 56, null);
                    this.readWriteLocker.wait(ThreadUtils.INSTANCE.isMainThread() ? 500L : 1000L);
                    ForestLogger.print$default(this.logger, 3, "Concurrent", '[' + andIncrement + "]receive write side release", false, null, null, 56, null);
                    intRef.element = this.count - start;
                }
                return -1;
            }
            if (this.isClosed.get()) {
                return -1;
            }
            Integer valueOf = Integer.valueOf(this.count);
            byte[] buffer = getBuffer();
            if (buffer == null) {
                Intrinsics.throwNpe();
            }
            Pair pair = TuplesKt.to(valueOf, buffer);
            int intValue = ((Number) pair.component1()).intValue();
            byte[] bArr = (byte[]) pair.component2();
            ForestLogger.print$default(this.logger, 4, "Concurrent", "[" + andIncrement + "]get snapshot: {maxReadableSize:" + intValue + ", buffer:" + bArr + ", sizeCanRead=" + intRef.element + '}', false, null, null, 56, null);
            int min = Integer.min(bytes.length - off, len);
            if (min <= 0) {
                return 0;
            }
            int min2 = Integer.min(intRef.element, min);
            ForestLogger.print$default(this.logger, 4, "Concurrent", "[" + andIncrement + "]read from buffer: {sizeCanRead:" + intRef.element + ", sizeToRead:" + min + ", readSize=" + min2 + '}', false, null, null, 56, null);
            ArraysKt.copyInto(bArr, bytes, off, start, start + min2);
            return min2;
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public void write(byte[] bytes, int off, int len) {
        if (bytes == null) {
            throw new IOException("ByteArray is NULL!");
        }
        synchronized (this.readWriteLocker) {
            if (this.isClosed.get()) {
                throw new IOException("ConcurrentIOMeta closed!");
            }
            if (this.isFulFilled.get()) {
                ForestLogger.print$default(this.logger, 6, "Concurrent", "buffer has been fulfilled, buffer={b:" + getBuffer() + ", size:" + this.count + "}, write={b:" + bytes + ", off:" + off + ", len:" + len + '}', true, null, null, 48, null);
            }
            ForestLogger.print$default(this.logger, 3, "Concurrent", "write (bytes:" + bytes + ", size=" + Integer.min(bytes.length - off, len) + ')', false, null, null, 56, null);
            super.write(bytes, off, len);
            this.readWriteLocker.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void waitForFinish() {
        this.finishWaiter.await();
    }

    public final void finish() {
        if (!this.isFulFilled.compareAndSet(false, true)) {
            ForestLogger.print$default(this.logger, 4, "Concurrent", "already finished when invoke finish", false, null, null, 56, null);
            return;
        }
        ForestLogger.print$default(this.logger, 4, "Concurrent", "invoke finished success, closed=" + this.isClosed.get(), false, null, null, 56, null);
        int readAvailable = getReadAvailable();
        byte[] buffer = getBuffer();
        if (buffer == null) {
            Intrinsics.throwNpe();
        }
        if (readAvailable < buffer.length) {
            byte[] bArr = ((ByteArrayOutputStream) this).buf;
            Intrinsics.checkExpressionValueIsNotNull(bArr, "super.buf");
            byte[] copyOf = Arrays.copyOf(bArr, getReadAvailable());
            Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            ((ByteArrayOutputStream) this).buf = copyOf;
        }
        synchronized (this.readWriteLocker) {
            ForestLogger.print$default(this.logger, 3, "Concurrent", "release locker for #finish", false, null, null, 56, null);
            this.readWriteLocker.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
        this.finishWaiter.countDown();
        Unit unit2 = Unit.INSTANCE;
        ForestLogger.print$default(this.logger, 3, "Concurrent", "release finishWaiter for #finish", false, null, null, 56, null);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed.compareAndSet(false, true)) {
            ForestLogger.print$default(this.logger, 4, "Concurrent", "ConcurrentIOMeta@" + super.hashCode() + " closed", false, null, null, 56, null);
            super.close();
            synchronized (this.readWriteLocker) {
                ((ByteArrayOutputStream) this).buf = null;
                ((ByteArrayOutputStream) this).count = 0;
                ForestLogger.print$default(this.logger, 3, "Concurrent", "release locker for #close", false, null, null, 56, null);
                this.readWriteLocker.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
            this.finishWaiter.countDown();
            Unit unit2 = Unit.INSTANCE;
            ForestLogger.print$default(this.logger, 3, "Concurrent", "release finishWaiter for #close", false, null, null, 56, null);
        }
    }

    @Override // java.io.ByteArrayOutputStream
    public String toString() {
        return "ConcurrentIOMeta@" + super.hashCode() + "(readAvailable=" + getReadAvailable() + ", isFulFilled=" + this.isFulFilled.get() + ", isClosed=" + this.isClosed.get() + ')';
    }
}
