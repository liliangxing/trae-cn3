package com.bytedance.forest.utils.io;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.EventReport;
import com.bytedance.forest.model.BytesProvider;
import com.bytedance.forest.model.ForestBuffer;
import com.bytedance.forest.model.InMemoryByteBuffer;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.ThreadUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* compiled from: concurrent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0010\u0018\u0000 <2\u00020\u0001:\u0001<B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J5\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0010¢\u0006\u0002\b'J\u0019\u0010(\u001a\u00020\u001c2\b\u0010)\u001a\u0004\u0018\u00010\u001fH\u0010¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u001cH\u0010¢\u0006\u0002\b-J\r\u0010.\u001a\u00020\u001cH\u0010¢\u0006\u0002\b/J\r\u00100\u001a\u00020\u001cH\u0010¢\u0006\u0002\b1J\b\u00102\u001a\u00020\u001aH\u0002J\n\u00103\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u00104\u001a\u0004\u0018\u00010\u00162\u0006\u0010%\u001a\u00020&H\u0016J\b\u00105\u001a\u00020\u001fH\u0016J\b\u00106\u001a\u00020\u001cH\u0016J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\u001aH\u0004J\u0015\u0010:\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0010¢\u0006\u0002\b;R$\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@PX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/bytedance/forest/utils/io/ForestConcurrentBuffer;", "Lcom/bytedance/forest/model/InMemoryByteBuffer;", "bytesProvider", "Lcom/bytedance/forest/model/BytesProvider;", "ctx", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "(Lcom/bytedance/forest/model/BytesProvider;Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "value", "context", "getContext$forest_release", "()Lcom/bytedance/forest/utils/ForestPipelineContext;", "setContext$forest_release", "(Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "exception", "", "inFulFilling", "Ljava/util/concurrent/atomic/AtomicBoolean;", "logCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "meta", "Lcom/bytedance/forest/utils/io/ConcurrentIOMeta;", "originInputStream", "Ljava/io/InputStream;", "referenceCount", "Lcom/bytedance/forest/utils/io/ReferenceCount;", "clear", "", "internal", "", EventReport.DIALOG_CLOSE, "getBytesAtRange", "", "index", "bytes", "", "off", "len", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "getBytesAtRange$forest_release", "initCache", "initialSize", "initCache$forest_release", "(Ljava/lang/Integer;)Z", "isCacheClear", "isCacheClear$forest_release", "isCacheProvided", "isCacheProvided$forest_release", "isCacheReady", "isCacheReady$forest_release", "loadFinished", "provideBytes", "provideInputStream", "size", "supportReuse", "toString", "", "traceInputStreamProvide", "tryLoadToMemory", "tryLoadToMemory$forest_release", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ForestConcurrentBuffer extends InMemoryByteBuffer {
    public static final String CLASS_NAME = "ForestConcurrentBuffer";
    private ForestPipelineContext context;
    private volatile Throwable exception;
    private final AtomicBoolean inFulFilling;
    private final AtomicInteger logCounter;
    private volatile ConcurrentIOMeta meta;
    private volatile InputStream originInputStream;
    private final ReferenceCount referenceCount;

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public boolean supportReuse() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForestConcurrentBuffer(BytesProvider bytesProvider, ForestPipelineContext forestPipelineContext) {
        super(bytesProvider);
        Intrinsics.checkParameterIsNotNull(bytesProvider, "bytesProvider");
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "ctx");
        this.logCounter = new AtomicInteger(0);
        this.inFulFilling = new AtomicBoolean(false);
        this.referenceCount = new ReferenceCount(forestPipelineContext.getLogger());
        this.context = forestPipelineContext;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    /* renamed from: getContext$forest_release, reason: from getter */
    public ForestPipelineContext getContext() {
        return this.context;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public void setContext$forest_release(ForestPipelineContext forestPipelineContext) {
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "value");
        ConcurrentIOMeta concurrentIOMeta = this.meta;
        if (concurrentIOMeta != null) {
            concurrentIOMeta.setLogger(forestPipelineContext.getLogger());
        }
        this.referenceCount.setLogger(forestPipelineContext.getLogger());
        this.context = forestPipelineContext;
    }

    @Override // com.bytedance.forest.model.InMemoryByteBuffer
    public boolean initCache$forest_release(Integer initialSize) {
        Object obj;
        Unit unit;
        int coerceAtLeast;
        if (isCacheProvided$forest_release()) {
            return true;
        }
        try {
            Result.Companion companion = Result.Companion;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (isCacheClear$forest_release()) {
            throw new IllegalStateException("current buffer can use cause cleared");
        }
        if (this.originInputStream != null) {
            throw new IllegalStateException("originInputStream except NULL but receive " + this.originInputStream);
        }
        InputStream provideInputStream = getBytesProvider().provideInputStream();
        if (provideInputStream != null) {
            this.originInputStream = provideInputStream;
            if (initialSize != null) {
                coerceAtLeast = initialSize.intValue();
            } else {
                InputStream inputStream = this.originInputStream;
                if (inputStream == null) {
                    Intrinsics.throwNpe();
                }
                coerceAtLeast = RangesKt.coerceAtLeast(inputStream.available(), 4096);
            }
            this.meta = new ConcurrentIOMeta(coerceAtLeast, getContext().getLogger(), this.logCounter);
            obj = Result.constructor-impl(Unit.INSTANCE);
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                ConcurrentIOMeta concurrentIOMeta = this.meta;
                if (concurrentIOMeta != null) {
                    concurrentIOMeta.close();
                }
                try {
                    Result.Companion companion3 = Result.Companion;
                    InputStream inputStream2 = this.originInputStream;
                    if (inputStream2 != null) {
                        inputStream2.close();
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    Result.constructor-impl(unit);
                } catch (Throwable th3) {
                    Result.Companion companion4 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th3));
                }
                this.originInputStream = null;
                ForestLogger.print$default(getContext().getLogger(), 6, ForestBuffer.TAG, "initCacheBuffer failed cause by " + th2.getMessage(), true, th2, null, 32, null);
            }
            return Result.isSuccess-impl(obj);
        }
        throw new IllegalStateException("InputStream from " + getBytesProvider() + " is NULL");
    }

    @Override // com.bytedance.forest.model.InMemoryByteBuffer
    public int getBytesAtRange$forest_release(int index, byte[] bytes, int off, int len, Response response) {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        if (isCacheClear$forest_release()) {
            return -1;
        }
        tryLoadToMemory$forest_release(response);
        ForestLogger.print$default(getContext().getLogger(), 3, "Concurrent", "getBytesAtRange, meta=" + this.meta, false, null, null, 56, null);
        ConcurrentIOMeta concurrentIOMeta = this.meta;
        if (concurrentIOMeta != null) {
            return concurrentIOMeta.read(index, bytes, off, len);
        }
        return 0;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public boolean isCacheProvided$forest_release() {
        AtomicBoolean isClosed;
        ConcurrentIOMeta concurrentIOMeta = this.meta;
        return (concurrentIOMeta == null || (isClosed = concurrentIOMeta.getIsClosed()) == null || isClosed.get()) ? false : true;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public boolean isCacheReady$forest_release() {
        AtomicBoolean isFulFilled;
        ConcurrentIOMeta concurrentIOMeta;
        AtomicBoolean isClosed;
        ConcurrentIOMeta concurrentIOMeta2 = this.meta;
        return (concurrentIOMeta2 == null || (isFulFilled = concurrentIOMeta2.getIsFulFilled()) == null || !isFulFilled.get() || (concurrentIOMeta = this.meta) == null || (isClosed = concurrentIOMeta.getIsClosed()) == null || isClosed.get()) ? false : true;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public boolean isCacheClear$forest_release() {
        AtomicBoolean isClosed;
        ConcurrentIOMeta concurrentIOMeta = this.meta;
        return (concurrentIOMeta == null || (isClosed = concurrentIOMeta.getIsClosed()) == null || !isClosed.get()) ? false : true;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public void tryLoadToMemory$forest_release(Response response) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        if (!this.inFulFilling.compareAndSet(false, true)) {
            ForestLogger.print$default(getContext().getLogger(), 4, "Concurrent", "already have a loadToMemory task performed", false, null, null, 56, null);
            return;
        }
        if (isCacheClear$forest_release() || isCacheReady$forest_release()) {
            ForestLogger.print$default(getContext().getLogger(), 4, "Concurrent", "no need to perform loadToMemory task, isCacheClear:" + isCacheClear$forest_release() + ", isCacheReady:" + isCacheReady$forest_release(), false, null, null, 56, null);
            return;
        }
        if (!InMemoryByteBuffer.initCache$forest_release$default(this, null, 1, null)) {
            ForestLogger.print$default(getContext().getLogger(), 6, "Concurrent", "init cache buffer failed when load to memory", true, null, null, 48, null);
            throw new IOException("init cache buffer failed");
        }
        final InputStream inputStream = this.originInputStream;
        if (inputStream == null) {
            ForestLogger.print$default(getContext().getLogger(), 6, ForestBuffer.TAG, "response: " + response.getIsSucceed() + ", " + response.getSuccessFetcher() + ", " + response.getFilePath() + ", meta:" + this.meta, true, new IOException("origin input stream is null"), null, 32, null);
            throw new IOException("origin input stream is null");
        }
        ForestLogger.print$default(getContext().getLogger(), 4, "Concurrent", "start to perform loadToMemory task", false, null, null, 56, null);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        if (getContext().getCallFromMainThread() && !ThreadUtils.INSTANCE.isMainThread()) {
            ForestLogger.print$default(getContext().getLogger(), 4, "Concurrent", "need firstReadLock", true, null, null, 48, null);
            objectRef.element = new CountDownLatch(1);
        }
        ThreadUtils.INSTANCE.runInBackground(new Function0<Unit>() { // from class: com.bytedance.forest.utils.io.ForestConcurrentBuffer$tryLoadToMemory$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m543invoke();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:32:0x0010, code lost:
            
                r15.this$0.loadFinished();
             */
            /* renamed from: invoke, reason: collision with other method in class */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void m543invoke() {
                AtomicBoolean atomicBoolean;
                AtomicBoolean atomicBoolean2;
                AtomicBoolean atomicBoolean3;
                AtomicBoolean atomicBoolean4;
                CountDownLatch countDownLatch;
                AtomicBoolean atomicBoolean5;
                AtomicBoolean atomicBoolean6;
                AtomicBoolean atomicBoolean7;
                AtomicBoolean atomicBoolean8;
                AtomicBoolean atomicBoolean9;
                ConcurrentIOMeta concurrentIOMeta;
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read < 0) {
                            break;
                        }
                        ForestLogger.print$default(ForestConcurrentBuffer.this.getContext().getLogger(), 3, "Concurrent", "ready to write:[buffer:" + bArr + ", size:" + read + ']', false, null, null, 56, null);
                        concurrentIOMeta = ForestConcurrentBuffer.this.meta;
                        if (concurrentIOMeta == null) {
                            Intrinsics.throwNpe();
                        }
                        concurrentIOMeta.write(bArr, 0, read);
                        CountDownLatch countDownLatch2 = (CountDownLatch) objectRef.element;
                        if (countDownLatch2 != null && countDownLatch2.getCount() == 1) {
                            ForestLogger.print$default(ForestConcurrentBuffer.this.getContext().getLogger(), 4, "Concurrent", "release firstReadLock by read " + read, true, null, null, 48, null);
                        }
                        CountDownLatch countDownLatch3 = (CountDownLatch) objectRef.element;
                        if (countDownLatch3 != null) {
                            countDownLatch3.countDown();
                        }
                        if (read < 0) {
                            break;
                        }
                    }
                    atomicBoolean7 = ForestConcurrentBuffer.this.inFulFilling;
                    if (!atomicBoolean7.compareAndSet(true, false)) {
                        ForestLogger logger = ForestConcurrentBuffer.this.getContext().getLogger();
                        StringBuilder sb = new StringBuilder("incorrect state of inFulFilling:");
                        atomicBoolean8 = ForestConcurrentBuffer.this.inFulFilling;
                        ForestLogger.print$default(logger, 5, "Concurrent", sb.append(atomicBoolean8.get()).toString(), false, null, null, 56, null);
                        atomicBoolean9 = ForestConcurrentBuffer.this.inFulFilling;
                        atomicBoolean9.set(false);
                    }
                    countDownLatch = (CountDownLatch) objectRef.element;
                    if (countDownLatch == null) {
                        return;
                    }
                } catch (Throwable th) {
                    try {
                        ForestLogger.print$default(ForestConcurrentBuffer.this.getContext().getLogger(), 6, "Concurrent", "read from " + inputStream + " failed, cause by " + th.getMessage(), true, th, null, 32, null);
                        ForestConcurrentBuffer.this.exception = th;
                        ForestConcurrentBuffer.this.close(true);
                        atomicBoolean4 = ForestConcurrentBuffer.this.inFulFilling;
                        if (!atomicBoolean4.compareAndSet(true, false)) {
                            ForestLogger logger2 = ForestConcurrentBuffer.this.getContext().getLogger();
                            StringBuilder sb2 = new StringBuilder("incorrect state of inFulFilling:");
                            atomicBoolean5 = ForestConcurrentBuffer.this.inFulFilling;
                            ForestLogger.print$default(logger2, 5, "Concurrent", sb2.append(atomicBoolean5.get()).toString(), false, null, null, 56, null);
                            atomicBoolean6 = ForestConcurrentBuffer.this.inFulFilling;
                            atomicBoolean6.set(false);
                        }
                        countDownLatch = (CountDownLatch) objectRef.element;
                        if (countDownLatch == null) {
                            return;
                        }
                    } catch (Throwable th2) {
                        atomicBoolean = ForestConcurrentBuffer.this.inFulFilling;
                        if (!atomicBoolean.compareAndSet(true, false)) {
                            ForestLogger logger3 = ForestConcurrentBuffer.this.getContext().getLogger();
                            StringBuilder sb3 = new StringBuilder("incorrect state of inFulFilling:");
                            atomicBoolean2 = ForestConcurrentBuffer.this.inFulFilling;
                            ForestLogger.print$default(logger3, 5, "Concurrent", sb3.append(atomicBoolean2.get()).toString(), false, null, null, 56, null);
                            atomicBoolean3 = ForestConcurrentBuffer.this.inFulFilling;
                            atomicBoolean3.set(false);
                        }
                        CountDownLatch countDownLatch4 = (CountDownLatch) objectRef.element;
                        if (countDownLatch4 != null) {
                            countDownLatch4.countDown();
                        }
                        throw th2;
                    }
                }
                countDownLatch.countDown();
            }
        });
        CountDownLatch countDownLatch = (CountDownLatch) objectRef.element;
        if (countDownLatch != null) {
            countDownLatch.await();
        }
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public byte[] provideBytes() {
        if (isCacheReady$forest_release()) {
            ConcurrentIOMeta concurrentIOMeta = this.meta;
            if (concurrentIOMeta == null) {
                Intrinsics.throwNpe();
            }
            return concurrentIOMeta.getBuffer();
        }
        ForestLogger.print$default(getContext().getLogger(), 3, "Concurrent", "wait for meta fulfill finish by #provideBytes", false, null, null, 56, null);
        ConcurrentIOMeta concurrentIOMeta2 = this.meta;
        if (concurrentIOMeta2 != null) {
            concurrentIOMeta2.waitForFinish();
        }
        ForestLogger.print$default(getContext().getLogger(), 3, "Concurrent", "meta fulfill finished by #provideBytes", false, null, null, 56, null);
        Throwable th = this.exception;
        if (th != null) {
            throw th;
        }
        ConcurrentIOMeta concurrentIOMeta3 = this.meta;
        if (concurrentIOMeta3 != null) {
            return concurrentIOMeta3.getBuffer();
        }
        return null;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public InputStream provideInputStream(Response response) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        traceInputStreamProvide();
        try {
            Result.Companion companion = Result.Companion;
            tryLoadToMemory$forest_release(response);
            obj = Result.constructor-impl(new ForestInputStream(response, this));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            ForestLogger.print$default(getContext().getLogger(), 6, "Concurrent", "provideInputStream failed, cause by " + th2.getMessage(), true, th2, null, 32, null);
            this.referenceCount.delete("provideInputStream");
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (InputStream) obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void traceInputStreamProvide() {
        if (isCacheReady$forest_release()) {
            return;
        }
        this.referenceCount.add("provideInputStream");
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public int size() {
        ConcurrentIOMeta concurrentIOMeta = this.meta;
        int readAvailable = concurrentIOMeta != null ? concurrentIOMeta.getReadAvailable() : 0;
        ForestLogger.print$default(getContext().getLogger(), 3, "Concurrent", "readable size=" + readAvailable, false, null, null, 56, null);
        return readAvailable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadFinished() {
        ConcurrentIOMeta concurrentIOMeta = this.meta;
        if (concurrentIOMeta != null) {
            concurrentIOMeta.finish();
        }
        ForestLogger.print$default(getContext().getLogger(), 3, "Concurrent", "ForestConcurrentBuffer@" + super.toString() + " load finished", false, null, null, 56, null);
        this.referenceCount.clear("loadFinished");
        clear(true);
        onFulFilled();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void clear(boolean internal) {
        try {
            InputStream inputStream = this.originInputStream;
            if (inputStream != null) {
                inputStream.close();
            }
        } finally {
            this.originInputStream = null;
            if (isCacheReady$forest_release()) {
            }
        }
        this.originInputStream = null;
        if (isCacheReady$forest_release()) {
            ForestLogger.print$default(getContext().getLogger(), 5, "Concurrent", "clear meta cause not ready", true, null, null, 48, null);
            ConcurrentIOMeta concurrentIOMeta = this.meta;
            if (concurrentIOMeta != null) {
                concurrentIOMeta.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void close(boolean internal) {
        if (!isCacheReady$forest_release() && this.referenceCount.delete(EventReport.DIALOG_CLOSE) <= 0) {
            if (this.referenceCount.get() < 0) {
                ForestLogger.print$default(getContext().getLogger(), 5, "Concurrent", "unexpected reference count:" + this.referenceCount.get(), false, null, null, 56, null);
            }
            clear(internal);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close(false);
    }

    public String toString() {
        return "ForestConcurrentBuffer@" + super.toString() + "(inputStreamProvider=" + getBytesProvider() + ", originInputStream=" + this.originInputStream + ", meta=" + this.meta + ", inFulFilling=" + this.inFulFilling.get() + ", referenceCount=" + this.referenceCount.get() + ')';
    }
}
