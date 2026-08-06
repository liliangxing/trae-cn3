package com.bytedance.gkfs.io;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.EventReport;
import com.bytedance.gkfs.GkFSLogger;
import com.bytedance.gkfs.UtilsKt$traceTime$1$1;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: meta_io.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u000bJ4\u0010\u0019\u001a\u00020\u00142\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00140\u001b2\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/gkfs/io/GkFSChunkMetaDecoder;", "Ljava/io/Closeable;", "chunkMetaBytes", "", "chunkCount", "", "logger", "Lcom/bytedance/gkfs/GkFSLogger;", "([BILcom/bytedance/gkfs/GkFSLogger;)V", "chunkInfoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/gkfs/io/GkFSChunkMeta;", "fetchIndex", "isClosed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "seqDecodeCost", "", DBHelper.BATTERY_COL_SOURCE, "Ljava/io/InputStream;", EventReport.DIALOG_CLOSE, "", "decode", "hasNext", "", "next", "startParallelDecode", "runner", "Lkotlin/Function1;", "Ljava/lang/Runnable;", "onChunkDecoded", "Lkotlin/Function2;", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GkFSChunkMetaDecoder implements Closeable {
    public static final String TAG = "ChunkMetaDecoder";
    private final int chunkCount;
    private final ConcurrentHashMap<Integer, GkFSChunkMeta> chunkInfoCache;
    private final byte[] chunkMetaBytes;
    private volatile int fetchIndex;
    private final AtomicBoolean isClosed;
    private final GkFSLogger logger;
    private long seqDecodeCost;
    private final InputStream source;

    public GkFSChunkMetaDecoder(byte[] bArr, int i, GkFSLogger gkFSLogger) {
        Intrinsics.checkParameterIsNotNull(bArr, "chunkMetaBytes");
        Intrinsics.checkParameterIsNotNull(gkFSLogger, "logger");
        this.chunkMetaBytes = bArr;
        this.chunkCount = i;
        this.logger = gkFSLogger;
        this.source = new ByteArrayInputStream(bArr);
        this.isClosed = new AtomicBoolean(false);
        this.chunkInfoCache = new ConcurrentHashMap<>();
        this.fetchIndex = -1;
    }

    public final void startParallelDecode(Function1<? super Runnable, Unit> runner, final Function2<? super Integer, ? super GkFSChunkMeta, Unit> onChunkDecoded) throws IllegalStateException {
        Intrinsics.checkParameterIsNotNull(runner, "runner");
        Intrinsics.checkParameterIsNotNull(onChunkDecoded, "onChunkDecoded");
        if (this.isClosed.get()) {
            return;
        }
        runner.invoke(new Runnable() { // from class: com.bytedance.gkfs.io.GkFSChunkMetaDecoder$startParallelDecode$1
            @Override // java.lang.Runnable
            public final void run() {
                GkFSLogger gkFSLogger;
                int i;
                int i2;
                byte[] bArr;
                int i3;
                GkFSLogger gkFSLogger2;
                AtomicBoolean atomicBoolean;
                GkFSLogger gkFSLogger3;
                ConcurrentHashMap concurrentHashMap;
                int i4;
                GkFSLogger gkFSLogger4;
                int i5;
                Object obj;
                GkFSLogger gkFSLogger5;
                ConcurrentHashMap concurrentHashMap2;
                byte[] bArr2;
                ChunkIdentifier readChunkId;
                byte[] bArr3;
                int readUInt;
                gkFSLogger = GkFSChunkMetaDecoder.this.logger;
                StringBuilder sb = new StringBuilder("start parallel decode, chunk count:");
                i = GkFSChunkMetaDecoder.this.chunkCount;
                StringBuilder append = sb.append(i).append(", fetchIndex=");
                i2 = GkFSChunkMetaDecoder.this.fetchIndex;
                GkFSLogger.d$default(gkFSLogger, GkFSChunkMetaDecoder.TAG, append.append(i2).toString(), 0, false, 12, null);
                bArr = GkFSChunkMetaDecoder.this.chunkMetaBytes;
                int length = bArr.length - 44;
                i3 = GkFSChunkMetaDecoder.this.chunkCount;
                int i6 = i3 - 1;
                int i7 = length;
                while (true) {
                    if (i6 < 0) {
                        break;
                    }
                    atomicBoolean = GkFSChunkMetaDecoder.this.isClosed;
                    if (atomicBoolean.get()) {
                        gkFSLogger3 = GkFSChunkMetaDecoder.this.logger;
                        StringBuilder sb2 = new StringBuilder("stop parallel decode cause closed, ");
                        concurrentHashMap = GkFSChunkMetaDecoder.this.chunkInfoCache;
                        GkFSLogger.w$default(gkFSLogger3, GkFSChunkMetaDecoder.TAG, sb2.append(concurrentHashMap.size()).append(" has been decoded.").toString(), 0, null, false, 28, null);
                        break;
                    }
                    i4 = GkFSChunkMetaDecoder.this.fetchIndex;
                    if (i6 <= i4) {
                        gkFSLogger4 = GkFSChunkMetaDecoder.this.logger;
                        StringBuilder append2 = new StringBuilder("quit parallel decoding, paraIndex:").append(i6).append(", fetchIndex=");
                        i5 = GkFSChunkMetaDecoder.this.fetchIndex;
                        GkFSLogger.d$default(gkFSLogger4, GkFSChunkMetaDecoder.TAG, append2.append(i5).toString(), 0, false, 12, null);
                        break;
                    }
                    try {
                        Result.Companion companion = Result.Companion;
                        bArr2 = GkFSChunkMetaDecoder.this.chunkMetaBytes;
                        readChunkId = Meta_ioKt.readChunkId(bArr2, i7);
                        bArr3 = GkFSChunkMetaDecoder.this.chunkMetaBytes;
                        readUInt = Meta_ioKt.readUInt(bArr3, i7 + 40);
                        i7 -= 44;
                        obj = Result.constructor-impl(new GkFSChunkMeta(readChunkId, readUInt & 4294967295L));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.isSuccess-impl(obj)) {
                        concurrentHashMap2 = GkFSChunkMetaDecoder.this.chunkInfoCache;
                        concurrentHashMap2.put(Integer.valueOf(i6), (GkFSChunkMeta) obj);
                    }
                    Throwable th2 = Result.exceptionOrNull-impl(obj);
                    if (th2 != null) {
                        gkFSLogger5 = GkFSChunkMetaDecoder.this.logger;
                        GkFSLogger.e$default(gkFSLogger5, GkFSChunkMetaDecoder.TAG, "parallel decode error, cause:" + th2.getMessage(), 0, th2, false, 20, null);
                        GkFSChunkMetaDecoder.this.close();
                    }
                    ResultKt.throwOnFailure(obj);
                    onChunkDecoded.invoke(Integer.valueOf(i6), (GkFSChunkMeta) obj);
                    i6--;
                }
                gkFSLogger2 = GkFSChunkMetaDecoder.this.logger;
                GkFSLogger.d$default(gkFSLogger2, GkFSChunkMetaDecoder.TAG, "parallel decode&IO finished", 0, false, 12, null);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r10.fetchIndex < (r10.chunkCount - 1)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean hasNext() {
        boolean z = this.isClosed.get() ? false : true;
        if (!z) {
            GkFSLogger.d$default(this.logger, TAG, "fetch chunk info finished, seq decode cost:" + this.seqDecodeCost, 0, false, 12, null);
        }
        return z;
    }

    public final GkFSChunkMeta next() throws IOException {
        if (this.isClosed.get()) {
            throw new IOException("decoder has been closed!");
        }
        this.fetchIndex++;
        GkFSChunkMeta gkFSChunkMeta = this.chunkInfoCache.get(Integer.valueOf(this.fetchIndex));
        if (gkFSChunkMeta != null) {
            return gkFSChunkMeta;
        }
        GkFSChunkMeta decode = decode();
        this.chunkInfoCache.put(Integer.valueOf(this.fetchIndex), decode);
        return decode;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed.compareAndSet(false, true)) {
            try {
                Result.Companion companion = Result.Companion;
                this.source.close();
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        }
    }

    private final GkFSChunkMeta decode() {
        ChunkIdentifier readChunkId;
        int readUInt;
        UtilsKt$traceTime$1$1 utilsKt$traceTime$1$1 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        readChunkId = Meta_ioKt.readChunkId(this.source);
        readUInt = Meta_ioKt.readUInt(this.source);
        long j = readUInt & 4294967295L;
        this.seqDecodeCost += ((Number) utilsKt$traceTime$1$1.invoke()).longValue();
        return new GkFSChunkMeta(readChunkId, j);
    }
}
