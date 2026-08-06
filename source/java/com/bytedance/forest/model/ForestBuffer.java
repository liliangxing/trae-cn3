package com.bytedance.forest.model;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.EventReport;
import com.bytedance.forest.model.ForestBuffer;
import com.bytedance.forest.pollyfill.ForestNetAPI;
import com.bytedance.forest.pollyfill.TTNetDepender;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.ThreadUtils;
import com.bytedance.forest.utils.io.ForestInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: ForestBuffer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 L2\u00020\u0001:\u0001LB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0002J\u0010\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020%H\u0002J\b\u0010+\u001a\u00020#H\u0002J5\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0010¢\u0006\u0002\b4J\u0019\u00105\u001a\u00020%2\b\u00106\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020%H\u0010¢\u0006\u0002\b:J\r\u0010;\u001a\u00020%H\u0010¢\u0006\u0002\b<J\r\u0010=\u001a\u00020%H\u0010¢\u0006\u0002\b>J\n\u0010?\u001a\u0004\u0018\u00010/H\u0016J\u0012\u0010@\u001a\u0004\u0018\u00010\u001a2\u0006\u00102\u001a\u000203H\u0016J\u0015\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020\u001aH\u0000¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\u000eH\u0016J\b\u0010E\u001a\u00020%H\u0016J\b\u0010F\u001a\u00020GH\u0016J<\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0I2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0002J\u0015\u0010J\u001a\u00020#2\u0006\u00102\u001a\u000203H\u0010¢\u0006\u0002\bKR$\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@PX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001dX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/bytedance/forest/model/ForestBuffer;", "Lcom/bytedance/forest/model/InMemoryByteBuffer;", "bytesProvider", "Lcom/bytedance/forest/model/BytesProvider;", "ctx", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "(Lcom/bytedance/forest/model/BytesProvider;Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "value", "context", "getContext$forest_release", "()Lcom/bytedance/forest/utils/ForestPipelineContext;", "setContext$forest_release", "(Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "estimatedSize", "", "exceptionHandler", "Lcom/bytedance/forest/model/ForestBuffer$Companion$ExceptionHandler;", "getExceptionHandler$forest_release", "()Lcom/bytedance/forest/model/ForestBuffer$Companion$ExceptionHandler;", "setExceptionHandler$forest_release", "(Lcom/bytedance/forest/model/ForestBuffer$Companion$ExceptionHandler;)V", "exceptionHandlerHandled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "meta", "Lcom/bytedance/forest/model/ForestBuffer$Companion$Meta;", "originInputStream", "Ljava/io/InputStream;", "ptr", "referenceCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "getReferenceCount$forest_release", "()Ljava/util/concurrent/atomic/AtomicInteger;", "state", "Lcom/bytedance/forest/model/ForestBuffer$Companion$State;", "clear", "", "closeOriginInputStream", "", EventReport.DIALOG_CLOSE, "closeInternally", "countDown", "doClose", "throwError", Timing.SUFFIX_FINISH, "getBytesAtRange", "index", "bytes", "", "off", "len", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "getBytesAtRange$forest_release", "initCache", "initialSize", "initCache$forest_release", "(Ljava/lang/Integer;)Z", "isCacheClear", "isCacheClear$forest_release", "isCacheProvided", "isCacheProvided$forest_release", "isCacheReady", "isCacheReady$forest_release", "provideBytes", "provideInputStream", "replaceOriginInputStream", "inputStream", "replaceOriginInputStream$forest_release", "size", "supportReuse", "toString", "", "tryLoadFromOriginInputStream", "Lkotlin/Pair;", "tryLoadToMemory", "tryLoadToMemory$forest_release", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ForestBuffer extends InMemoryByteBuffer {
    public static final String TAG = "ForestBuffer";
    private static final int UNDEFINED = -1;
    private ForestPipelineContext context;
    private int estimatedSize;
    private Companion.ExceptionHandler exceptionHandler;
    private final AtomicBoolean exceptionHandlerHandled;
    private volatile Companion.Meta meta;
    private InputStream originInputStream;
    private volatile int ptr;
    private final AtomicInteger referenceCount;
    private volatile Companion.State state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForestBuffer(BytesProvider bytesProvider, ForestPipelineContext forestPipelineContext) {
        super(bytesProvider);
        Intrinsics.checkParameterIsNotNull(bytesProvider, "bytesProvider");
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "ctx");
        this.context = forestPipelineContext;
        this.exceptionHandlerHandled = new AtomicBoolean(false);
        this.exceptionHandler = new Companion.ExceptionHandler() { // from class: com.bytedance.forest.model.ForestBuffer$exceptionHandler$1
            @Override // com.bytedance.forest.model.ForestBuffer.Companion.ExceptionHandler
            public boolean tryHandleException(Response response, Throwable throwable) {
                AtomicBoolean atomicBoolean;
                InputStream provideInputStream;
                Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
                Intrinsics.checkParameterIsNotNull(throwable, "throwable");
                atomicBoolean = ForestBuffer.this.exceptionHandlerHandled;
                if (!atomicBoolean.compareAndSet(false, true)) {
                    return false;
                }
                Request request = response.getRequest();
                if (ForestBuffer.this.getReferenceCount().get() <= 1 && response.getFrom() == ResourceFrom.CDN && !ThreadUtils.INSTANCE.isMainThread() && (request.getNetDepender$forest_release() instanceof TTNetDepender)) {
                    synchronized (ForestBuffer.this) {
                        if (!ForestBuffer.this.isCacheClear$forest_release()) {
                            return true;
                        }
                        ForestNetAPI.HttpRequest createHttpRequest$forest_release = TTNetDepender.Companion.createHttpRequest$forest_release(request.getUrl(), request, ForestBuffer.this.getContext());
                        ForestNetAPI.HttpResponse httpResponse$forest_release = createHttpRequest$forest_release != null ? TTNetDepender.Companion.getHttpResponse$forest_release(response, createHttpRequest$forest_release, ForestBuffer.this.getContext()) : null;
                        if (httpResponse$forest_release != null && (provideInputStream = httpResponse$forest_release.provideInputStream()) != null) {
                            if (ForestBuffer.this.replaceOriginInputStream$forest_release(provideInputStream)) {
                                return true;
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
                return false;
            }
        };
        this.estimatedSize = -1;
        this.referenceCount = new AtomicInteger(0);
        this.state = Companion.State.Initial;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    /* renamed from: getContext$forest_release, reason: from getter */
    public ForestPipelineContext getContext() {
        return this.context;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public void setContext$forest_release(ForestPipelineContext forestPipelineContext) {
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "value");
        Companion.Meta meta = this.meta;
        if (meta != null) {
            meta.setContext$forest_release(forestPipelineContext);
        }
        this.context = forestPipelineContext;
    }

    /* renamed from: getExceptionHandler$forest_release, reason: from getter */
    public final Companion.ExceptionHandler getExceptionHandler() {
        return this.exceptionHandler;
    }

    public final void setExceptionHandler$forest_release(Companion.ExceptionHandler exceptionHandler) {
        Intrinsics.checkParameterIsNotNull(exceptionHandler, "<set-?>");
        this.exceptionHandler = exceptionHandler;
    }

    /* renamed from: getReferenceCount$forest_release, reason: from getter */
    public final AtomicInteger getReferenceCount() {
        return this.referenceCount;
    }

    @Override // com.bytedance.forest.model.InMemoryByteBuffer
    public synchronized boolean initCache$forest_release(Integer initialSize) {
        Object obj;
        Unit unit;
        InputStream provideInputStream;
        int coerceAtLeast;
        if (isCacheProvided$forest_release()) {
            return true;
        }
        if (this.originInputStream != null || this.state != Companion.State.Initial || this.ptr != 0) {
            ForestLogger.printOptimize$default(getContext().getLogger(), 6, TAG, true, null, null, new Function0<String>() { // from class: com.bytedance.forest.model.ForestBuffer$initCache$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final String invoke() {
                    ForestBuffer.Companion.State state;
                    int i;
                    InputStream inputStream;
                    StringBuilder sb = new StringBuilder("initCache failed since state incorrect, [state=");
                    state = ForestBuffer.this.state;
                    StringBuilder append = sb.append(state).append("; ptr=");
                    i = ForestBuffer.this.ptr;
                    StringBuilder append2 = append.append(i).append("; originInputStream=");
                    inputStream = ForestBuffer.this.originInputStream;
                    return append2.append(inputStream).append(']').toString();
                }
            }, 24, null);
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            provideInputStream = getBytesProvider().provideInputStream();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (provideInputStream == null) {
            return false;
        }
        this.originInputStream = provideInputStream;
        if (initialSize != null) {
            coerceAtLeast = initialSize.intValue();
        } else {
            if (provideInputStream == null) {
                Intrinsics.throwNpe();
            }
            coerceAtLeast = RangesKt.coerceAtLeast(provideInputStream.available(), 4096);
        }
        this.meta = new Companion.Meta(coerceAtLeast, getContext());
        obj = Result.constructor-impl(Unit.INSTANCE);
        if (Result.isSuccess-impl(obj)) {
            this.state = Companion.State.Caching;
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            Companion.Meta meta = this.meta;
            if (meta != null) {
                meta.clear();
            }
            this.state = Companion.State.Clear;
            try {
                Result.Companion companion3 = Result.Companion;
                InputStream inputStream = this.originInputStream;
                if (inputStream != null) {
                    inputStream.close();
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
            ForestLogger.print$default(getContext().getLogger(), 6, TAG, "initCache failed", true, th2, null, 32, null);
        }
        return Result.isSuccess-impl(obj);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close(false);
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public int size() {
        if (isCacheProvided$forest_release()) {
            return RangesKt.coerceAtLeast(this.estimatedSize, 0);
        }
        return 0;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public byte[] provideBytes() {
        if (isCacheReady$forest_release()) {
            Companion.Meta meta = this.meta;
            byte[] provideBytes = meta != null ? meta.provideBytes() : null;
            if (provideBytes != null && provideBytes.length == this.ptr) {
                return provideBytes;
            }
        }
        return null;
    }

    public final synchronized boolean replaceOriginInputStream$forest_release(InputStream inputStream) {
        byte[] bArr;
        int i;
        Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
        boolean z = false;
        if (!isCacheClear$forest_release()) {
            return false;
        }
        try {
            bArr = new byte[this.ptr];
            this.originInputStream = inputStream;
            this.state = Companion.State.Caching;
            i = 0;
            do {
                int read = inputStream.read(bArr, i, this.ptr - i);
                if (read == -1) {
                    break;
                }
                i += read;
            } while (i < this.ptr);
        } catch (Throwable th) {
            ForestLogger.print$default(getContext().getLogger(), 6, TAG, "error happens when replaceOriginInputStream", true, th, null, 32, null);
            clear(true);
        }
        if (i < this.ptr) {
            throw new IOException("except read " + this.ptr + ", but receive " + i);
        }
        Companion.Meta meta = this.meta;
        if (meta == null) {
            throw new IOException("meta is null");
        }
        meta.addBytes(0, bArr, 0, this.ptr);
        ForestLogger.print$default(getContext().getLogger(), 4, TAG, "replace original input stream successfully", false, null, null, 56, null);
        z = true;
        return z;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public boolean isCacheProvided$forest_release() {
        return (this.state == Companion.State.Caching || this.state == Companion.State.Finished) && this.meta != null;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public boolean isCacheReady$forest_release() {
        if (this.state == Companion.State.Finished) {
            Companion.Meta meta = this.meta;
            if ((meta != null ? meta.getData() : null) != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public boolean isCacheClear$forest_release() {
        return this.state == Companion.State.Clear;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public boolean supportReuse() {
        return isCacheProvided$forest_release() || getBytesProvider().isMultiProvider();
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public InputStream provideInputStream(Response response) {
        Companion.Meta meta;
        byte[] provideBytes;
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        if (isCacheReady$forest_release() && (meta = this.meta) != null && (provideBytes = meta.provideBytes()) != null) {
            return new ByteArrayInputStream(provideBytes);
        }
        if (isCacheProvided$forest_release()) {
            this.referenceCount.incrementAndGet();
            return new ForestInputStream(response, this);
        }
        return getBytesProvider().provideInputStream();
    }

    @Override // com.bytedance.forest.model.InMemoryByteBuffer
    public int getBytesAtRange$forest_release(int index, byte[] bytes, int off, int len, Response response) throws IOException {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        if (isCacheClear$forest_release()) {
            synchronized (this) {
                if (isCacheClear$forest_release()) {
                    if (index == this.ptr) {
                        InputStream inputStream = this.originInputStream;
                        Integer valueOf = inputStream != null ? Integer.valueOf(inputStream.read(bytes, off, len)) : null;
                        if (valueOf != null && valueOf.intValue() != -1) {
                            this.ptr += valueOf.intValue();
                        }
                        if (valueOf != null) {
                            return valueOf.intValue();
                        }
                        throw new IOException("origin input stream and meta is null");
                    }
                    throw new IOException("origin input stream and meta is null");
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        if (isCacheReady$forest_release() && this.estimatedSize <= index) {
            return -1;
        }
        Pair<Integer, Integer> tryLoadFromOriginInputStream = tryLoadFromOriginInputStream(index, bytes, off, len, response);
        if (isCacheReady$forest_release() && this.estimatedSize <= index) {
            return -1;
        }
        if (((Number) tryLoadFromOriginInputStream.getFirst()).intValue() == index) {
            return ((Number) tryLoadFromOriginInputStream.getSecond()).intValue();
        }
        int coerceAtMost = RangesKt.coerceAtMost(len, ((Number) tryLoadFromOriginInputStream.getFirst()).intValue() - index);
        if (coerceAtMost < 0) {
            ForestLogger.print$default(getContext().getLogger(), 6, TAG, "rest size is less than 0", true, null, null, 48, null);
            throw new IOException("rest size is less than 0");
        }
        Companion.Meta meta = this.meta;
        if (meta == null) {
            throw new IOException("meta is null");
        }
        meta.readBytes(index, bytes, off, coerceAtMost);
        return coerceAtMost + ((Number) tryLoadFromOriginInputStream.getSecond()).intValue();
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public void tryLoadToMemory$forest_release(final Response response) {
        Companion.BufferedByteCache data;
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        if (isCacheClear$forest_release() || isCacheReady$forest_release()) {
            return;
        }
        synchronized (this) {
            if (!isCacheClear$forest_release() && !isCacheReady$forest_release()) {
                if (!InMemoryByteBuffer.initCache$forest_release$default(this, null, 1, null)) {
                    ForestLogger.print$default(getContext().getLogger(), 6, TAG, "init cache buffer failed when load to memory", true, null, null, 48, null);
                    throw new IOException("init cache buffer failed");
                }
                InputStream inputStream = this.originInputStream;
                if (inputStream == null) {
                    ForestLogger.print$default(getContext().getLogger(), 6, TAG, "response: " + response.getIsSucceed() + ", " + response.getSuccessFetcher() + ", " + response.getFilePath() + ", buffer: " + this.state + ", " + this.ptr, true, new IOException("origin input stream is null"), null, 32, null);
                    throw new IOException("origin input stream is null");
                }
                Companion.Meta meta = this.meta;
                if (meta == null || (data = meta.getData()) == null) {
                    throw new IOException("meta is null");
                }
                try {
                    InputStream inputStream2 = inputStream;
                    try {
                        InputStream inputStream3 = inputStream2;
                        byte[] bArr = new byte[8192];
                        for (int read = inputStream3.read(bArr); read >= 0; read = inputStream3.read(bArr)) {
                            data.write(this.ptr, bArr, 0, read);
                            this.ptr += read;
                        }
                        finish();
                        close(true);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStream2, (Throwable) null);
                        Unit unit2 = Unit.INSTANCE;
                    } finally {
                    }
                } catch (Throwable th) {
                    ForestLogger.printOptimize$default(getContext().getLogger(), 6, TAG, true, th, null, new Function0<String>() { // from class: com.bytedance.forest.model.ForestBuffer$tryLoadToMemory$$inlined$synchronized$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public final String invoke() {
                            AtomicBoolean atomicBoolean;
                            atomicBoolean = ForestBuffer.this.exceptionHandlerHandled;
                            return "read input stream to memory failed, from=".concat(atomicBoolean.get() ? "ExceptionHandler" : "Normal");
                        }
                    }, 16, null);
                    clear(true);
                    if (this.exceptionHandler.tryHandleException(response, th)) {
                        tryLoadToMemory$forest_release(response);
                    } else {
                        getContext().getReporter().reportForestConsume$forest_release(response, th);
                        throw th;
                    }
                }
            }
        }
    }

    private final Pair<Integer, Integer> tryLoadFromOriginInputStream(int index, byte[] bytes, int off, int len, Response response) {
        int i;
        Companion.Meta meta;
        if (isCacheReady$forest_release() || (i = index + len) <= this.ptr) {
            return new Pair<>(Integer.valueOf(this.ptr), 0);
        }
        synchronized (this) {
            if (!isCacheReady$forest_release() && i > this.ptr) {
                InputStream inputStream = this.originInputStream;
                if (inputStream == null) {
                    throw new IOException("origin input stream is null");
                }
                if (this.ptr >= index) {
                    int i2 = this.ptr - index;
                    int i3 = off + i2;
                    try {
                        int read = inputStream.read(bytes, i3, len - i2);
                        if (read == -1) {
                            finish();
                            return new Pair<>(Integer.valueOf(this.ptr), 0);
                        }
                        try {
                            try {
                                meta = this.meta;
                            } catch (OutOfMemoryError e) {
                                ForestLogger.print$default(getContext().getLogger(), 6, TAG, "add bytes failed", true, e, null, 32, null);
                                clear(false);
                            }
                            if (meta != null) {
                                meta.addBytes(this.ptr, bytes, i3, read);
                                this.estimatedSize = RangesKt.coerceAtLeast(this.estimatedSize, this.ptr + read);
                                this.ptr += read;
                                return new Pair<>(Integer.valueOf(this.ptr - read), Integer.valueOf(read));
                            }
                            throw new IOException("meta is null");
                        } catch (Throwable th) {
                            ForestLogger.print$default(getContext().getLogger(), 6, TAG, "add bytes failed", true, th, null, 32, null);
                            clear(true);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        clear(true);
                        this.exceptionHandler.tryHandleException(response, th2);
                        throw th2;
                    }
                }
                ForestLogger.print$default(getContext().getLogger(), 6, TAG, "read index is larger than ptr", true, null, null, 48, null);
                throw new IOException("read index is larger than ptr");
            }
            return new Pair<>(Integer.valueOf(this.ptr), 0);
        }
    }

    private final void finish() {
        this.estimatedSize = this.ptr;
        Companion.Meta meta = this.meta;
        if (meta != null) {
            meta.finish();
        }
        this.state = Companion.State.Finished;
        onFulFilled();
    }

    private final void clear(boolean closeOriginInputStream) {
        Unit unit;
        if (isCacheReady$forest_release()) {
            ForestLogger.print$default(getContext().getLogger(), 6, TAG, "clear after forest buffer finished", true, null, null, 48, null);
        }
        this.estimatedSize = -1;
        this.state = Companion.State.Clear;
        Companion.Meta meta = this.meta;
        if (meta != null) {
            meta.clear();
        }
        if (closeOriginInputStream) {
            try {
                Result.Companion companion = Result.Companion;
                InputStream inputStream = this.originInputStream;
                if (inputStream != null) {
                    inputStream.close();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                Result.constructor-impl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
            this.originInputStream = null;
        }
    }

    private final void close(boolean closeInternally) {
        if (isCacheClear$forest_release()) {
            ForestLogger.print$default(getContext().getLogger(), 6, TAG, "forest buffer is closed in Clear state", false, null, null, 56, null);
            countDown();
            return;
        }
        if (!isCacheProvided$forest_release()) {
            ForestLogger.print$default(getContext().getLogger(), 6, TAG, "forest buffer is closed in unfinished state", true, null, null, 48, null);
        }
        if (closeInternally) {
            this.referenceCount.set(0);
            doClose(false);
        } else if (countDown()) {
            doClose(true);
        }
    }

    private final void doClose(boolean throwError) {
        try {
            InputStream inputStream = this.originInputStream;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            try {
                ForestLogger.print$default(getContext().getLogger(), 6, TAG, "close origin input stream failed", true, th, null, 32, null);
                if (throwError) {
                    throw th;
                }
                if (isCacheReady$forest_release()) {
                }
            } finally {
                if (!isCacheReady$forest_release()) {
                    clear(false);
                }
            }
        }
    }

    private final boolean countDown() {
        int decrementAndGet = this.referenceCount.decrementAndGet();
        if (decrementAndGet < 0) {
            ForestLogger.print$default(getContext().getLogger(), 6, TAG, "unexpected close count, count: " + decrementAndGet + " less than 0", true, null, null, 48, null);
        }
        return decrementAndGet == 0;
    }

    public String toString() {
        return super.toString() + "(inputStreamProvider=" + getBytesProvider() + ", originInputStream=" + this.originInputStream + ", meta=" + this.meta + ", ptr=" + this.ptr + ", exceptionHandler=" + this.exceptionHandler + ", estimatedSize=" + this.estimatedSize + ", referenceCount=" + this.referenceCount + ", state=" + this.state + ')';
    }
}
