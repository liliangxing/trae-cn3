package com.bytedance.gkfs.io;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.EventReport;
import com.bytedance.gkfs.GkFSLogger;
import com.bytedance.gkfs.io.segmental.SegmentalByteArray;
import com.bytedance.gkfs.io.segmental.SegmentalByteArrayInputStream;
import com.bytedance.gkfs.storage.GkFSChunkStorageInfo;
import java.io.InputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: chunk_reader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/gkfs/io/ChunkBuffer;", "", "meta", "Lcom/bytedance/gkfs/io/GkFSChunkMeta;", "content", "Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray;", "chunkStorageInfo", "Lcom/bytedance/gkfs/storage/GkFSChunkStorageInfo;", "logger", "Lcom/bytedance/gkfs/GkFSLogger;", "(Lcom/bytedance/gkfs/io/GkFSChunkMeta;Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray;Lcom/bytedance/gkfs/storage/GkFSChunkStorageInfo;Lcom/bytedance/gkfs/GkFSLogger;)V", "getChunkStorageInfo", "()Lcom/bytedance/gkfs/storage/GkFSChunkStorageInfo;", "getMeta", "()Lcom/bytedance/gkfs/io/GkFSChunkMeta;", DBHelper.BATTERY_COL_SOURCE, "Ljava/io/InputStream;", "getSource", "()Ljava/io/InputStream;", "source$delegate", "Lkotlin/Lazy;", "totalReadCount", "", "available", EventReport.DIALOG_CLOSE, "", "read", "b", "", "off", "len", "toString", "", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ChunkBuffer {
    public static final String TAG = "ChunkBuffer";
    private final GkFSChunkStorageInfo chunkStorageInfo;
    private SegmentalByteArray content;
    private final GkFSLogger logger;
    private final GkFSChunkMeta meta;

    /* renamed from: source$delegate, reason: from kotlin metadata */
    private final Lazy source;
    private volatile int totalReadCount;

    private final InputStream getSource() {
        return (InputStream) this.source.getValue();
    }

    public ChunkBuffer(GkFSChunkMeta gkFSChunkMeta, SegmentalByteArray segmentalByteArray, GkFSChunkStorageInfo gkFSChunkStorageInfo, GkFSLogger gkFSLogger) {
        Intrinsics.checkParameterIsNotNull(gkFSChunkMeta, "meta");
        Intrinsics.checkParameterIsNotNull(gkFSChunkStorageInfo, "chunkStorageInfo");
        Intrinsics.checkParameterIsNotNull(gkFSLogger, "logger");
        this.meta = gkFSChunkMeta;
        this.content = segmentalByteArray;
        this.chunkStorageInfo = gkFSChunkStorageInfo;
        this.logger = gkFSLogger;
        this.source = LazyKt.lazy(new Function0<InputStream>() { // from class: com.bytedance.gkfs.io.ChunkBuffer$source$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final InputStream m566invoke() {
                SegmentalByteArray segmentalByteArray2;
                segmentalByteArray2 = ChunkBuffer.this.content;
                return segmentalByteArray2 != null ? new SegmentalByteArrayInputStream(segmentalByteArray2) : (InputStream) ChunkBuffer.this.getChunkStorageInfo().getChunkReaderProvider().invoke();
            }
        });
    }

    public final GkFSChunkMeta getMeta() {
        return this.meta;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ChunkBuffer(GkFSChunkMeta gkFSChunkMeta, SegmentalByteArray segmentalByteArray, GkFSChunkStorageInfo gkFSChunkStorageInfo, GkFSLogger gkFSLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gkFSChunkMeta, segmentalByteArray, gkFSChunkStorageInfo, gkFSLogger);
        if ((i & 2) != 0) {
            segmentalByteArray = null;
        }
    }

    public final GkFSChunkStorageInfo getChunkStorageInfo() {
        return this.chunkStorageInfo;
    }

    public final int read(byte[] b, int off, int len) {
        Intrinsics.checkParameterIsNotNull(b, "b");
        int read = getSource().read(b, off, len);
        if (read > 0) {
            this.totalReadCount += read;
        }
        return read;
    }

    public final int available() {
        return getSource().available();
    }

    public final void close() {
        try {
            Result.Companion companion = Result.Companion;
            getSource().close();
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public String toString() {
        return "ChunkBuffer@" + super.hashCode() + '#' + this.meta.getId() + "(totalSize=" + this.chunkStorageInfo.getSize() + ", totalReadCount=" + this.totalReadCount + ", available=" + available() + ')';
    }
}
