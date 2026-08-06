package com.bytedance.gkfs.io;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.EventReport;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.gkfs.GkFSExecutor;
import com.bytedance.gkfs.GkFSLogger;
import com.bytedance.gkfs.GkFSReporter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: GkFSFileInputStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010 \u001a\u00020\u001aH\u0016J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\u001aH\u0016J\"\u0010$\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001aH\u0016J\b\u0010)\u001a\u00020\"H\u0002J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u0017H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSFileInputStream;", "Ljava/io/FileInputStream;", DBHelper.BATTERY_COL_SOURCE, "Ljava/io/File;", "(Ljava/io/File;)V", "chunkReader", "Lcom/bytedance/gkfs/io/GkFSChunkReader;", "isClosed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isFinished", "logTag", "", "logger", "Lcom/bytedance/gkfs/GkFSLogger;", "meta", "Lcom/bytedance/gkfs/io/GkFSFileMeta;", "getMeta$geckox_noasanRelease", "()Lcom/bytedance/gkfs/io/GkFSFileMeta;", "meta$delegate", "Lkotlin/Lazy;", "statistics", "Lcom/bytedance/gkfs/io/GkFSIOStatistics;", "tailReadCost", "", "Ljava/lang/Long;", "totalDiskSize", "", "getTotalDiskSize", "()I", "totalDiskSize$delegate", "totalReadCost", "totalReadCount", "available", "checkFinishIllegal", "", EventReport.DIALOG_CLOSE, "read", "b", "", "off", "len", "report", "skip", "n", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GkFSFileInputStream extends FileInputStream {
    private GkFSChunkReader chunkReader;
    private final AtomicBoolean isClosed;
    private final AtomicBoolean isFinished;
    private final String logTag;
    private final GkFSLogger logger;

    /* renamed from: meta$delegate, reason: from kotlin metadata */
    private final Lazy meta;
    private final File source;
    private GkFSIOStatistics statistics;
    private volatile Long tailReadCost;

    /* renamed from: totalDiskSize$delegate, reason: from kotlin metadata */
    private final Lazy totalDiskSize;
    private volatile Long totalReadCost;
    private long totalReadCount;

    private final int getTotalDiskSize() {
        return ((Number) this.totalDiskSize.getValue()).intValue();
    }

    public final GkFSFileMeta getMeta$geckox_noasanRelease() {
        return (GkFSFileMeta) this.meta.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GkFSFileInputStream(File file) {
        super(file);
        Intrinsics.checkParameterIsNotNull(file, DBHelper.BATTERY_COL_SOURCE);
        this.source = file;
        this.logTag = "GkFSFileInputStream@" + hashCode();
        this.logger = new GkFSLogger();
        this.meta = LazyKt.lazy(new Function0<GkFSFileMeta>() { // from class: com.bytedance.gkfs.io.GkFSFileInputStream$meta$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final GkFSFileMeta m568invoke() {
                AtomicBoolean atomicBoolean;
                File file2;
                GkFSLogger gkFSLogger;
                String str;
                File file3;
                Object obj;
                Object obj2;
                GkFSLogger gkFSLogger2;
                String str2;
                File file4;
                File file5;
                File file6;
                GkFSLogger gkFSLogger3;
                File file7;
                GkFSLogger gkFSLogger4;
                GkFSLogger gkFSLogger5;
                String str3;
                atomicBoolean = GkFSFileInputStream.this.isClosed;
                if (atomicBoolean.get()) {
                    gkFSLogger5 = GkFSFileInputStream.this.logger;
                    str3 = GkFSFileInputStream.this.logTag;
                    GkFSLogger.w$default(gkFSLogger5, str3, "get meta after InputStream closed", 0, null, true, 12, null);
                    return null;
                }
                file2 = GkFSFileInputStream.this.source;
                String name = file2.getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "source.name");
                if (!StringsKt.endsWith$default(name, Meta_ioKt.GKFS_FILE_EXTENSION, false, 2, (Object) null)) {
                    return null;
                }
                gkFSLogger = GkFSFileInputStream.this.logger;
                str = GkFSFileInputStream.this.logTag;
                StringBuilder sb = new StringBuilder("start to read header from ");
                file3 = GkFSFileInputStream.this.source;
                GkFSLogger.d$default(gkFSLogger, str, sb.append(file3).toString(), 0, true, 4, null);
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    Result.Companion companion = Result.Companion;
                    file7 = GkFSFileInputStream.this.source;
                    FileInputStream fileInputStream = new FileInputStream(file7);
                    try {
                        gkFSLogger4 = GkFSFileInputStream.this.logger;
                        Pair<GkFSHeaderMeta, GkFSChunkMetaDecoder> read = GkFSFileHeaderReader.INSTANCE.read(fileInputStream, gkFSLogger4);
                        CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                        obj = Result.constructor-impl(read);
                    } finally {
                    }
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                Throwable th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null) {
                    GkFSFileInputStream.this.statistics = new GkFSIOStatistics(new GkFSStatus(false, new IOException("Exception when read header", th2), GkFSError.HEADER_READ_ERROR), 0L, 0L, null, 0L, 0L, 0L, 0L, 254, null);
                }
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) obj;
                GkFSHeaderMeta gkFSHeaderMeta = (GkFSHeaderMeta) pair.component1();
                GkFSChunkMetaDecoder gkFSChunkMetaDecoder = (GkFSChunkMetaDecoder) pair.component2();
                long size = gkFSHeaderMeta.getSize();
                super/*java.io.FileInputStream*/.skip(size);
                GkFSFileInputStream.this.totalReadCount = size;
                GkFSFileInputStream.this.statistics = new GkFSIOStatistics(null, System.currentTimeMillis() - currentTimeMillis, 0L, null, 0L, 0L, 0L, 0L, 253, null);
                GkFSFileInputStream gkFSFileInputStream = GkFSFileInputStream.this;
                try {
                    Result.Companion companion3 = Result.Companion;
                    file6 = GkFSFileInputStream.this.source;
                    gkFSLogger3 = GkFSFileInputStream.this.logger;
                    obj2 = Result.constructor-impl(new GkFSChunkReader(file6, gkFSChunkMetaDecoder, gkFSLogger3));
                } catch (Throwable th3) {
                    Result.Companion companion4 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th3));
                }
                Throwable th4 = Result.exceptionOrNull-impl(obj2);
                if (th4 != null) {
                    GkFSFileInputStream gkFSFileInputStream2 = GkFSFileInputStream.this;
                    StringBuilder sb2 = new StringBuilder("Exception when init ChunkReader from ");
                    file5 = GkFSFileInputStream.this.source;
                    gkFSFileInputStream2.statistics = new GkFSIOStatistics(new GkFSStatus(false, new IOException(sb2.append(file5).toString(), th4), GkFSError.HEADER_READ_ERROR), 0L, 0L, null, 0L, 0L, 0L, 0L, 254, null);
                }
                ResultKt.throwOnFailure(obj2);
                gkFSFileInputStream.chunkReader = (GkFSChunkReader) obj2;
                gkFSLogger2 = GkFSFileInputStream.this.logger;
                str2 = GkFSFileInputStream.this.logTag;
                GkFSLogger.d$default(gkFSLogger2, str2, "read header finish", 0, true, 4, null);
                file4 = GkFSFileInputStream.this.source;
                return new GkFSFileMeta(file4, gkFSHeaderMeta, CollectionsKt.emptyList());
            }
        });
        this.isClosed = new AtomicBoolean(false);
        this.isFinished = new AtomicBoolean(false);
        this.totalDiskSize = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.gkfs.io.GkFSFileInputStream$totalDiskSize$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m569invoke() {
                return Integer.valueOf(invoke());
            }

            public final int invoke() {
                GkFSFileMeta meta$geckox_noasanRelease = GkFSFileInputStream.this.getMeta$geckox_noasanRelease();
                if (meta$geckox_noasanRelease != null) {
                    return (int) (meta$geckox_noasanRelease.getHeader().getFileOriginSize() + meta$geckox_noasanRelease.getHeader().getSize());
                }
                return 0;
            }
        });
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        Integer valueOf = Integer.valueOf(read(bArr, 0, 1));
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf == null) {
            return -1;
        }
        valueOf.intValue();
        return bArr[0] & 255;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        Object obj;
        int i;
        Object obj2;
        if (getMeta$geckox_noasanRelease() == null) {
            return super.read(b, off, len);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.totalReadCost == null) {
            this.totalReadCost = 0L;
            GkFSLogger.d$default(this.logger, this.logTag, "start to read content from " + this.source, 0, true, 4, null);
        }
        if (this.isClosed.get()) {
            throw new IOException("Stream closed!");
        }
        if (this.isFinished.get()) {
            return -1;
        }
        if (b == null) {
            throw new NullPointerException("ByteArray is NULL!");
        }
        if (off < 0 || len < 0 || len > b.length - off) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return 0;
        }
        int min = Math.min(b.length - off, len);
        if (min == 0) {
            GkFSLogger.d$default(this.logger, this.logTag, "No need to read, arraySize:" + b.length + ", off:" + off + ", len:" + len, 0, false, 12, null);
            return 0;
        }
        try {
            Result.Companion companion = Result.Companion;
            GkFSChunkReader gkFSChunkReader = this.chunkReader;
            if (gkFSChunkReader == null) {
                Intrinsics.throwNpe();
            }
            obj = Result.constructor-impl(Integer.valueOf(gkFSChunkReader.read(b, off, len)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            String str = "error occur when read chunk, cause:" + th2.getMessage();
            GkFSLogger.e$default(this.logger, this.logTag, str, 0, th2, true, 4, null);
            this.statistics = new GkFSIOStatistics(new GkFSStatus(false, new IOException(str), GkFSError.CHUNK_CONTENT_READ_ERROR), 0L, 0L, null, 0L, 0L, 0L, 0L, 254, null);
        }
        ResultKt.throwOnFailure(obj);
        int intValue = ((Number) obj).intValue();
        if (intValue > 0) {
            this.totalReadCount += intValue;
            i = intValue;
        } else {
            i = 0;
        }
        if (i == min) {
            Long l = this.totalReadCost;
            if (l == null) {
                Intrinsics.throwNpe();
            }
            this.totalReadCost = Long.valueOf(l.longValue() + (System.currentTimeMillis() - currentTimeMillis));
            return intValue;
        }
        if (this.tailReadCost == null) {
            GkFSLogger.d$default(this.logger, this.logTag, "chunk read finished, totalReadCount=" + this.totalReadCount + ", start to read tail", 0, false, 12, null);
            this.tailReadCost = 0L;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        try {
            Result.Companion companion3 = Result.Companion;
            obj2 = Result.constructor-impl(Integer.valueOf(super.read(b, off + i, len - i)));
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th3));
        }
        Throwable th4 = Result.exceptionOrNull-impl(obj2);
        if (th4 != null) {
            String str2 = "error occur when read tail from " + this.source + ", cause:" + th4.getMessage();
            GkFSLogger.e$default(this.logger, this.logTag, str2, 0, th4, true, 4, null);
            this.statistics = new GkFSIOStatistics(new GkFSStatus(false, new IOException(str2), GkFSError.TAIL_READ_ERROR), 0L, 0L, null, 0L, 0L, 0L, 0L, 254, null);
        }
        ResultKt.throwOnFailure(obj2);
        int intValue2 = ((Number) obj2).intValue();
        Long l2 = this.tailReadCost;
        if (l2 == null) {
            Intrinsics.throwNpe();
        }
        this.tailReadCost = Long.valueOf(l2.longValue() + (System.currentTimeMillis() - currentTimeMillis2));
        if (intValue2 > 0) {
            int i2 = i + intValue2;
            this.totalReadCount += intValue2;
            return i2;
        }
        if (intValue2 == -1) {
            this.isFinished.set(true);
            Long l3 = this.totalReadCost;
            if (l3 == null) {
                Intrinsics.throwNpe();
            }
            this.totalReadCost = Long.valueOf(l3.longValue() + (System.currentTimeMillis() - currentTimeMillis));
            GkFSLogger gkFSLogger = this.logger;
            String str3 = this.logTag;
            StringBuilder append = new StringBuilder("All finish, time cost:{total:").append(this.totalReadCost).append(", header:");
            GkFSIOStatistics gkFSIOStatistics = this.statistics;
            GkFSLogger.d$default(gkFSLogger, str3, append.append(gkFSIOStatistics != null ? Long.valueOf(gkFSIOStatistics.getHeaderTimeCost()) : null).append(", tail:").append(this.tailReadCost).append("}, totalReadCount=").append(this.totalReadCount).toString(), 0, true, 4, null);
            checkFinishIllegal();
            return -1;
        }
        throw new IOException("Underlying input stream returned zero bytes when read tail");
    }

    private final void checkFinishIllegal() {
        int available = available();
        if (available != 0) {
            throw new IOException("Read finished but available is " + available);
        }
        int available2 = super.available();
        if (available2 != 0) {
            throw new IOException("Read finished but major file available is " + available2);
        }
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public long skip(long n) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public int available() {
        return getMeta$geckox_noasanRelease() == null ? super.available() : (int) (getTotalDiskSize() - this.totalReadCount);
    }

    @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed.compareAndSet(false, true)) {
            super.close();
            GkFSExecutor.sequence(new Runnable() { // from class: com.bytedance.gkfs.io.GkFSFileInputStream$close$1
                @Override // java.lang.Runnable
                public final void run() {
                    GkFSFileInputStream.this.report();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void report() {
        GkFSIOStatistics gkFSIOStatistics;
        GkFSHeaderMeta empty;
        List<GkFSChunk> emptyList;
        GkFSHeaderMeta header;
        List<GkFSChunk> chunks;
        GkFSStatus status;
        if (GkFSUtils.INSTANCE.isGkFSFile(this.source)) {
            GkFSIOStatistics gkFSIOStatistics2 = this.statistics;
            if ((gkFSIOStatistics2 == null || (status = gkFSIOStatistics2.getStatus()) == null || !status.isSuccess() || this.isFinished.get()) && (gkFSIOStatistics = this.statistics) != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                GkFSFileMeta meta$geckox_noasanRelease = getMeta$geckox_noasanRelease();
                if (meta$geckox_noasanRelease != null && (chunks = meta$geckox_noasanRelease.getChunks()) != null) {
                    for (GkFSChunk gkFSChunk : chunks) {
                        linkedHashMap.put(gkFSChunk.getId(), gkFSChunk.getStorageInfo());
                    }
                }
                GkFSStatus status2 = gkFSIOStatistics.getStatus();
                long headerTimeCost = gkFSIOStatistics.getHeaderTimeCost();
                GkFSFileMeta meta$geckox_noasanRelease2 = getMeta$geckox_noasanRelease();
                long size = (meta$geckox_noasanRelease2 == null || (header = meta$geckox_noasanRelease2.getHeader()) == null) ? 0L : header.getSize();
                GkFSChunkIOStatistics gkFSChunkIOStatistics = new GkFSChunkIOStatistics(MapsKt.emptyMap(), linkedHashMap);
                GkFSChunkReader gkFSChunkReader = this.chunkReader;
                long timeCost$geckox_noasanRelease = gkFSChunkReader != null ? gkFSChunkReader.timeCost$geckox_noasanRelease() : 0L;
                Long l = this.tailReadCost;
                long longValue = l != null ? l.longValue() : 0L;
                GkFSFileMeta meta$geckox_noasanRelease3 = getMeta$geckox_noasanRelease();
                long length = meta$geckox_noasanRelease3 != null ? meta$geckox_noasanRelease3.getMajorFile().length() - meta$geckox_noasanRelease3.getHeader().getSize() : 0L;
                Long l2 = this.totalReadCost;
                this.statistics = new GkFSIOStatistics(status2, headerTimeCost, size, gkFSChunkIOStatistics, timeCost$geckox_noasanRelease, longValue, length, l2 != null ? l2.longValue() : 0L);
                File file = this.source;
                File file2 = this.source;
                GkFSFileMeta meta$geckox_noasanRelease4 = getMeta$geckox_noasanRelease();
                if (meta$geckox_noasanRelease4 == null || (empty = meta$geckox_noasanRelease4.getHeader()) == null) {
                    empty = GkFSHeaderMeta.INSTANCE.getEMPTY();
                }
                GkFSFileMeta meta$geckox_noasanRelease5 = getMeta$geckox_noasanRelease();
                if (meta$geckox_noasanRelease5 == null || (emptyList = meta$geckox_noasanRelease5.getChunks()) == null) {
                    emptyList = CollectionsKt.emptyList();
                }
                GkFSFileMeta gkFSFileMeta = new GkFSFileMeta(file2, empty, emptyList);
                GkFSIOStatistics gkFSIOStatistics3 = this.statistics;
                if (gkFSIOStatistics3 == null) {
                    Intrinsics.throwNpe();
                }
                GkFSReporter.INSTANCE.reportFileReadStats$geckox_noasanRelease(new GkFSInputInfo(file, gkFSFileMeta, gkFSIOStatistics3));
            }
        }
    }
}
