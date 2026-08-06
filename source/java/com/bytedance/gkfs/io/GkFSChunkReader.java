package com.bytedance.gkfs.io;

import com.bytedance.gkfs.GkFSExecutor;
import com.bytedance.gkfs.GkFSLogger;
import com.bytedance.gkfs.GkFSReporter;
import com.bytedance.gkfs.UtilsKt$traceTime$1$1;
import com.bytedance.gkfs.io.segmental.SegmentalByteArray;
import com.bytedance.gkfs.io.segmental.SegmentalByteArrayKt;
import com.bytedance.gkfs.storage.ChunkIndexingInfo;
import com.bytedance.gkfs.storage.GkFSChunkStorage;
import com.bytedance.gkfs.storage.GkFSChunkStorageInfo;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: chunk_reader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0018J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0018H\u0002J\r\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b)J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0013H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSChunkReader;", "", "sourceFile", "Ljava/io/File;", "decoder", "Lcom/bytedance/gkfs/io/GkFSChunkMetaDecoder;", "logger", "Lcom/bytedance/gkfs/GkFSLogger;", "(Ljava/io/File;Lcom/bytedance/gkfs/io/GkFSChunkMetaDecoder;Lcom/bytedance/gkfs/GkFSLogger;)V", "currentBuffer", "Lcom/bytedance/gkfs/io/ChunkBuffer;", "currentChunkFrom", "Lcom/bytedance/gkfs/io/ChunkFrom;", "isFinished", "Ljava/util/concurrent/atomic/AtomicBoolean;", "logTag", "", "parallelCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/gkfs/io/ChunkIdentifier;", "Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray;", "statistics", "Lcom/bytedance/gkfs/io/Statistics;", "totalReadCount", "", "obtainChunkBuffer", "meta", "Lcom/bytedance/gkfs/io/GkFSChunkMeta;", "read", "b", "", "off", "len", "reportChunkReadError", "", "msg", "t", "", "seq", "timeCost", "", "timeCost$geckox_noasanRelease", "timeCostOf", "id", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GkFSChunkReader {
    private ChunkBuffer currentBuffer;
    private ChunkFrom currentChunkFrom;
    private final GkFSChunkMetaDecoder decoder;
    private final AtomicBoolean isFinished;
    private final String logTag;
    private final GkFSLogger logger;
    private final ConcurrentHashMap<ChunkIdentifier, SegmentalByteArray> parallelCache;
    private final File sourceFile;
    private final Statistics statistics;
    private volatile int totalReadCount;

    /* compiled from: chunk_reader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Ljava/lang/Runnable;", "Lkotlin/ParameterName;", "name", "task", "invoke"}, k = 3, mv = {1, 1, 16})
    /* renamed from: com.bytedance.gkfs.io.GkFSChunkReader$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    static final /* synthetic */ class C11391 extends FunctionReference implements Function1<Runnable, Unit> {
        C11391(GkFSExecutor gkFSExecutor) {
            super(1, gkFSExecutor);
        }

        public final String getName() {
            return "parallel";
        }

        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(GkFSExecutor.class);
        }

        public final String getSignature() {
            return "parallel(Ljava/lang/Runnable;)V";
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Runnable) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(Runnable runnable) {
            Intrinsics.checkParameterIsNotNull(runnable, "p1");
            ((GkFSExecutor) this.receiver).parallel(runnable);
        }
    }

    public GkFSChunkReader(File file, GkFSChunkMetaDecoder gkFSChunkMetaDecoder, GkFSLogger gkFSLogger) {
        Intrinsics.checkParameterIsNotNull(file, "sourceFile");
        Intrinsics.checkParameterIsNotNull(gkFSChunkMetaDecoder, "decoder");
        Intrinsics.checkParameterIsNotNull(gkFSLogger, "logger");
        this.sourceFile = file;
        this.decoder = gkFSChunkMetaDecoder;
        this.logger = gkFSLogger;
        this.logTag = "GkFSChunkReader@" + hashCode();
        this.currentChunkFrom = ChunkFrom.Disk;
        this.parallelCache = new ConcurrentHashMap<>();
        this.statistics = new Statistics();
        this.isFinished = new AtomicBoolean(false);
        gkFSChunkMetaDecoder.startParallelDecode(new C11391(GkFSExecutor.INSTANCE), new Function2<Integer, GkFSChunkMeta, Unit>() { // from class: com.bytedance.gkfs.io.GkFSChunkReader.2
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).intValue(), (GkFSChunkMeta) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(int i, GkFSChunkMeta gkFSChunkMeta) {
                Object obj;
                Intrinsics.checkParameterIsNotNull(gkFSChunkMeta, "chunk");
                UtilsKt$traceTime$1$1 utilsKt$traceTime$1$1 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
                SegmentalByteArray segmentalByteArray = (SegmentalByteArray) GkFSChunkReader.this.parallelCache.get(gkFSChunkMeta.getId());
                if (segmentalByteArray == null) {
                    try {
                        Result.Companion companion = Result.Companion;
                        GkFSChunkStorageInfo findChunk = GkFSChunkStorage.INSTANCE.findChunk(gkFSChunkMeta.getId());
                        Closeable closeable = (Closeable) findChunk.getChunkReaderProvider().invoke();
                        try {
                            SegmentalByteArray readBytesSegmental = SegmentalByteArrayKt.readBytesSegmental((InputStream) closeable, findChunk.getSize());
                            CloseableKt.closeFinally(closeable, (Throwable) null);
                            obj = Result.constructor-impl(readBytesSegmental);
                        } finally {
                        }
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    Throwable th2 = Result.exceptionOrNull-impl(obj);
                    if (th2 != null) {
                        String str = "read chunk content failed, cause by " + th2.getMessage();
                        GkFSChunkReader.this.reportChunkReadError(str, new IOException(str, th2), 0);
                    }
                    segmentalByteArray = (SegmentalByteArray) (Result.isFailure-impl(obj) ? null : obj);
                }
                Statistics statistics = GkFSChunkReader.this.statistics;
                statistics.setParallelContentCost(statistics.getParallelContentCost() + ((Number) utilsKt$traceTime$1$1.invoke()).longValue());
                if (segmentalByteArray != null) {
                    GkFSChunkReader.this.parallelCache.putIfAbsent(gkFSChunkMeta.getId(), segmentalByteArray);
                }
                Statistics statistics2 = GkFSChunkReader.this.statistics;
                statistics2.setParallelIOCost(statistics2.getParallelIOCost() + ((Number) utilsKt$traceTime$1$1.invoke()).longValue());
            }
        });
    }

    public static final /* synthetic */ ChunkBuffer access$getCurrentBuffer$p(GkFSChunkReader gkFSChunkReader) {
        ChunkBuffer chunkBuffer = gkFSChunkReader.currentBuffer;
        if (chunkBuffer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentBuffer");
        }
        return chunkBuffer;
    }

    public /* synthetic */ GkFSChunkReader(File file, GkFSChunkMetaDecoder gkFSChunkMetaDecoder, GkFSLogger gkFSLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, gkFSChunkMetaDecoder, (i & 4) != 0 ? new GkFSLogger() : gkFSLogger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long timeCostOf(ChunkIdentifier id) {
        Pair<Long, Long> pair = this.statistics.getChunksTimeCost().get(id);
        if (pair != null) {
            return ((Number) pair.getSecond()).longValue() - ((Number) pair.getFirst()).longValue();
        }
        return 0L;
    }

    public final long timeCost$geckox_noasanRelease() {
        return this.statistics.getTotalTimeCost();
    }

    private final ChunkBuffer obtainChunkBuffer(GkFSChunkMeta meta) {
        this.currentChunkFrom = ChunkFrom.Disk;
        SegmentalByteArray segmentalByteArray = this.parallelCache.get(meta.getId());
        if (segmentalByteArray != null) {
            Statistics statistics = this.statistics;
            statistics.setParallelCacheHitCount(statistics.getParallelCacheHitCount() + 1);
            this.currentChunkFrom = ChunkFrom.Parallel;
        } else {
            segmentalByteArray = null;
        }
        return new ChunkBuffer(meta, segmentalByteArray, GkFSChunkStorage.INSTANCE.findChunk(meta.getId()), this.logger);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0128, code lost:
    
        com.bytedance.gkfs.GkFSLogger.d$default(r22.logger, r22.logTag, "read chunks finished, totalReadCount:" + r22.totalReadCount + ", parallelIOCost=" + r22.statistics.getParallelIOCost() + ", parallelContentCost=" + r22.statistics.getParallelContentCost() + ", parallelCacheHitCount:" + r22.statistics.getParallelCacheHitCount(), r4, false, 8, null);
        r22.isFinished.set(true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int read(byte[] b, int off, int len) throws IOException {
        Intrinsics.checkParameterIsNotNull(b, "b");
        if (this.isFinished.get()) {
            return -1;
        }
        int incrementAndGet = this.logger.getCounter().incrementAndGet();
        int min = Math.min(b.length - off, len);
        int i = 0;
        if (min == 0) {
            GkFSLogger.d$default(this.logger, this.logTag, "No need to read, arraySize:" + b.length + ", off:" + off + ", len:" + len, incrementAndGet, false, 8, null);
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            try {
                GkFSChunkReader gkFSChunkReader = this;
                if (this.currentBuffer == null) {
                    GkFSLogger.d$default(this.logger, this.logTag, "read chunk start", 0, false, 12, null);
                    this.currentBuffer = obtainChunkBuffer(this.decoder.next());
                }
                ChunkBuffer chunkBuffer = this.currentBuffer;
                if (chunkBuffer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentBuffer");
                }
                final ChunkIdentifier id = chunkBuffer.getMeta().getId();
                if (this.statistics.getChunksTimeCost().get(id) == null) {
                    this.statistics.getChunksTimeCost().put(id, TuplesKt.to(Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis)));
                }
                ChunkBuffer chunkBuffer2 = this.currentBuffer;
                if (chunkBuffer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentBuffer");
                }
                int read = chunkBuffer2.read(b, off + i, min - i);
                if (read <= 0) {
                    final ChunkBuffer chunkBuffer3 = this.currentBuffer;
                    if (chunkBuffer3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentBuffer");
                    }
                    GkFSExecutor.sequence(new Runnable() { // from class: com.bytedance.gkfs.io.GkFSChunkReader$read$3
                        @Override // java.lang.Runnable
                        public final void run() {
                            ChunkBuffer.this.close();
                        }
                    });
                    Map<ChunkIdentifier, Pair<Long, Long>> chunksTimeCost = this.statistics.getChunksTimeCost();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Pair<Long, Long> pair = this.statistics.getChunksTimeCost().get(id);
                    if (pair == null) {
                        Intrinsics.throwNpe();
                    }
                    chunksTimeCost.put(id, TuplesKt.to(pair.getFirst(), Long.valueOf(currentTimeMillis2)));
                    GkFSExecutor.sequence(new Runnable() { // from class: com.bytedance.gkfs.io.GkFSChunkReader$read$5
                        @Override // java.lang.Runnable
                        public final void run() {
                            long timeCostOf;
                            File file;
                            ChunkFrom chunkFrom;
                            GkFSChunkStorageInfo copy;
                            timeCostOf = GkFSChunkReader.this.timeCostOf(id);
                            GkFSReporter gkFSReporter = GkFSReporter.INSTANCE;
                            GkFSStatus success = GkFSStatus.INSTANCE.getSUCCESS();
                            file = GkFSChunkReader.this.sourceFile;
                            chunkFrom = GkFSChunkReader.this.currentChunkFrom;
                            GkFSChunkMeta meta = chunkBuffer3.getMeta();
                            copy = r3.copy((r24 & 1) != 0 ? r3.id : null, (r24 & 2) != 0 ? r3.chunkFile : null, (r24 & 4) != 0 ? r3.chunkReaderProvider : null, (r24 & 8) != 0 ? r3.indexing : null, (r24 & 16) != 0 ? r3.lockCost : 0L, (r24 & 32) != 0 ? r3.ioCost : timeCostOf, (r24 & 64) != 0 ? r3.timeCost : timeCostOf, (r24 & 128) != 0 ? chunkBuffer3.getChunkStorageInfo().size : 0);
                            gkFSReporter.reportChunkReadStats$geckox_noasanRelease(success, file, chunkFrom, new GkFSChunk(meta, copy));
                        }
                    });
                    if (!this.decoder.hasNext()) {
                        break;
                    }
                    this.currentBuffer = obtainChunkBuffer(this.decoder.next());
                } else {
                    i += read;
                }
                if (i >= min) {
                    break;
                }
            } finally {
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportChunkReadError(String msg, Throwable t, int seq) {
        final GkFSChunkMeta gkFSChunkMeta;
        final File file;
        this.logger.m305e(this.logTag, msg + ", cause by " + t, seq, t, true);
        final GkFSStatus gkFSStatus = new GkFSStatus(false, t, GkFSError.CHUNK_CONTENT_READ_ERROR);
        boolean z = this.currentBuffer != null;
        if (z) {
            ChunkBuffer chunkBuffer = this.currentBuffer;
            if (chunkBuffer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentBuffer");
            }
            gkFSChunkMeta = chunkBuffer.getMeta();
        } else {
            gkFSChunkMeta = new GkFSChunkMeta(ChunkIdentifier.INSTANCE.getNO_ID(), 0L);
        }
        if (z) {
            ChunkBuffer chunkBuffer2 = this.currentBuffer;
            if (chunkBuffer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentBuffer");
            }
            file = chunkBuffer2.getChunkStorageInfo().getChunkFile();
        } else {
            file = new File("");
        }
        GkFSExecutor.sequence(new Runnable() { // from class: com.bytedance.gkfs.io.GkFSChunkReader$reportChunkReadError$1
            @Override // java.lang.Runnable
            public final void run() {
                File file2;
                GkFSReporter gkFSReporter = GkFSReporter.INSTANCE;
                GkFSStatus gkFSStatus2 = gkFSStatus;
                file2 = GkFSChunkReader.this.sourceFile;
                ChunkFrom chunkFrom = ChunkFrom.Disk;
                GkFSChunkMeta gkFSChunkMeta2 = gkFSChunkMeta;
                gkFSReporter.reportChunkReadStats$geckox_noasanRelease(gkFSStatus2, file2, chunkFrom, new GkFSChunk(gkFSChunkMeta2, new GkFSChunkStorageInfo(gkFSChunkMeta2.getId(), file, null, new ChunkIndexingInfo(gkFSChunkMeta.getId(), BlockIdentifier.INSTANCE.getNO_ID(), new String[0], null, 0L, 8, null), 0L, 0L, 0L, (int) file.length(), 4, null)));
            }
        });
    }
}
