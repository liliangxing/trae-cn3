package com.bytedance.gkfs.io;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.gkfs.GkFSExecutor;
import com.bytedance.gkfs.GkFSLogger;
import com.bytedance.gkfs.GkFSReporter;
import com.bytedance.gkfs.UtilsKt;
import com.bytedance.gkfs.UtilsKt$traceTime$1$1;
import com.bytedance.gkfs.cdc.Chunker;
import com.bytedance.gkfs.io.segmental.SegmentalByteArrayKt;
import com.bytedance.gkfs.storage.GkFSChunkStorage;
import com.bytedance.gkfs.storage.GkFSChunkStorageInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: file_writter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0010R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSFileWriter;", "", DBHelper.BATTERY_COL_SOURCE, "Ljava/io/File;", "majorFile", "meta", "Lcom/bytedance/gkfs/cdc/Chunker$GkFSCDCInfo;", "(Ljava/io/File;Ljava/io/File;Lcom/bytedance/gkfs/cdc/Chunker$GkFSCDCInfo;)V", "<set-?>", "Lcom/bytedance/gkfs/io/GkFSHeaderMeta;", "headerMeta", "getHeaderMeta$geckox_noasanRelease", "()Lcom/bytedance/gkfs/io/GkFSHeaderMeta;", "logger", "Lcom/bytedance/gkfs/GkFSLogger;", "write", "Lcom/bytedance/gkfs/io/GkFSIOStatistics;", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GkFSFileWriter {
    private static final String TAG = "GkFSFileWriter";
    private static final String TMP_SUFFIX = "-tmp";
    private GkFSHeaderMeta headerMeta;
    private final GkFSLogger logger;
    private final File majorFile;
    private final Chunker.GkFSCDCInfo meta;
    private final File source;

    public GkFSFileWriter(File file, File file2, Chunker.GkFSCDCInfo gkFSCDCInfo) {
        Intrinsics.checkParameterIsNotNull(file, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.checkParameterIsNotNull(file2, "majorFile");
        Intrinsics.checkParameterIsNotNull(gkFSCDCInfo, "meta");
        this.source = file;
        this.majorFile = file2;
        this.meta = gkFSCDCInfo;
        this.logger = new GkFSLogger();
        this.headerMeta = GkFSHeaderMeta.INSTANCE.getEMPTY();
    }

    /* renamed from: getHeaderMeta$geckox_noasanRelease, reason: from getter */
    public final GkFSHeaderMeta getHeaderMeta() {
        return this.headerMeta;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0234  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final GkFSIOStatistics write() {
        File file;
        File file2;
        UtilsKt$traceTime$1$1 utilsKt$traceTime$1$1;
        LinkedHashMap linkedHashMap;
        Object obj;
        Throwable th;
        FileOutputStream fileOutputStream;
        ChunkIdentifier id;
        if (!this.source.exists()) {
            return new GkFSIOStatistics(new GkFSStatus(false, new IOException("source file " + this.source + " not exists!"), GkFSError.SOURCE_FILE_NOT_EXISTS), 0L, 0L, null, 0L, 0L, 0L, 0L, 254, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        final File file3 = this.majorFile;
        File file4 = new File(file3.getAbsolutePath() + TMP_SUFFIX);
        if (file4.exists()) {
            file4.delete();
        }
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = 0L;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        try {
            final UtilsKt$traceTime$1$1 utilsKt$traceTime$1$12 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
            final Map<ChunkIdentifier, GkFSChunkStorageInfo> addChunks = GkFSChunkStorage.INSTANCE.addChunks(this.meta.getChunks(), file3);
            longRef.element = ((Number) utilsKt$traceTime$1$12.invoke()).longValue();
            linkedHashMap2.putAll(addChunks);
            final LinkedHashMap linkedHashMap3 = linkedHashMap2;
            file = file4;
            file2 = file3;
            try {
                GkFSExecutor.sequence(new Runnable() { // from class: com.bytedance.gkfs.io.GkFSFileWriter$write$$inlined$traceTime$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        File file5;
                        Chunker.GkFSCDCInfo gkFSCDCInfo;
                        for (Map.Entry entry : addChunks.entrySet()) {
                            GkFSReporter gkFSReporter = GkFSReporter.INSTANCE;
                            ChunkIdentifier chunkIdentifier = (ChunkIdentifier) entry.getKey();
                            file5 = this.source;
                            GkFSStatus success = GkFSStatus.INSTANCE.getSUCCESS();
                            gkFSCDCInfo = this.meta;
                            gkFSReporter.reportChunkStoreStats$geckox_noasanRelease(chunkIdentifier, file5, success, gkFSCDCInfo.getStatistics(), (GkFSChunkStorageInfo) entry.getValue());
                        }
                    }
                });
                Unit unit = Unit.INSTANCE;
                UtilsKt$traceTime$1$1 utilsKt$traceTime$1$13 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
                try {
                    Result.Companion companion = Result.Companion;
                    List<Chunker.GkFSCDCChunkInfo> chunks = this.meta.getChunks();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(chunks, 10));
                    for (Chunker.GkFSCDCChunkInfo gkFSCDCChunkInfo : chunks) {
                        linkedHashMap = linkedHashMap3;
                        try {
                            GkFSChunkStorageInfo gkFSChunkStorageInfo = (GkFSChunkStorageInfo) linkedHashMap.get(gkFSCDCChunkInfo.getId());
                            if (gkFSChunkStorageInfo == null || (id = gkFSChunkStorageInfo.getId()) == null) {
                                throw new IllegalStateException("Can not find recorded chunk storage info for " + gkFSCDCChunkInfo.getId());
                            }
                            utilsKt$traceTime$1$1 = utilsKt$traceTime$1$13;
                            try {
                                arrayList.add(new GkFSChunkMeta(id, gkFSCDCChunkInfo.getFrom()));
                                linkedHashMap3 = linkedHashMap;
                                utilsKt$traceTime$1$13 = utilsKt$traceTime$1$1;
                            } catch (Throwable th2) {
                                th = th2;
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                                th = Result.exceptionOrNull-impl(obj);
                                if (th != null) {
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            utilsKt$traceTime$1$1 = utilsKt$traceTime$1$13;
                            Result.Companion companion22 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            th = Result.exceptionOrNull-impl(obj);
                            if (th != null) {
                            }
                        }
                    }
                    utilsKt$traceTime$1$1 = utilsKt$traceTime$1$13;
                    linkedHashMap = linkedHashMap3;
                    ArrayList arrayList2 = arrayList;
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        GkFSFileHeaderWriter.INSTANCE.write(fileOutputStream, this.source.length(), arrayList2);
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                        this.headerMeta = new GkFSHeaderMeta(0, 0L, UtilsKt.calcHeaderSize(this.meta.getChunks().size()), 3, null);
                    } finally {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    utilsKt$traceTime$1$1 = utilsKt$traceTime$1$13;
                    linkedHashMap = linkedHashMap3;
                }
                if (file.length() == this.headerMeta.getSize()) {
                    obj = Result.constructor-impl(Unit.INSTANCE);
                    th = Result.exceptionOrNull-impl(obj);
                    if (th != null) {
                        GkFSIOStatistics gkFSIOStatistics = new GkFSIOStatistics(new GkFSStatus(false, new IOException("Error occur writing header when transferring to .gkfsf file", th), GkFSError.HEADER_WRITE_ERROR), 0L, 0L, null, 0L, 0L, 0L, 0L, 254, null);
                        file.delete();
                        Unit unit3 = Unit.INSTANCE;
                        return gkFSIOStatistics;
                    }
                    long longValue = ((Number) utilsKt$traceTime$1$1.invoke()).longValue();
                    UtilsKt$traceTime$1$1 utilsKt$traceTime$1$14 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
                    if (this.meta.getTailBytes().isNotEmpty()) {
                        try {
                            fileOutputStream = new FileOutputStream(file, true);
                            try {
                                SegmentalByteArrayKt.write(fileOutputStream, this.meta.getTailBytes());
                                Unit unit4 = Unit.INSTANCE;
                                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                            } finally {
                                try {
                                    throw th;
                                } finally {
                                }
                            }
                        } catch (Throwable th5) {
                            GkFSIOStatistics gkFSIOStatistics2 = new GkFSIOStatistics(new GkFSStatus(false, new IOException("Error occur when transfer " + this.source + " to " + file2 + ", cause " + th5.getMessage(), th5), GkFSError.TAIL_WRITE_ERROR), 0L, 0L, null, 0L, 0L, 0L, 0L, 254, null);
                            file.delete();
                            Unit unit5 = Unit.INSTANCE;
                            return gkFSIOStatistics2;
                        }
                    }
                    long longValue2 = ((Number) utilsKt$traceTime$1$14.invoke()).longValue();
                    if (!this.source.exists()) {
                        file.delete();
                        return new GkFSIOStatistics(new GkFSStatus(false, new IOException("source file " + this.source + " not exists!"), GkFSError.SOURCE_FILE_NOT_EXISTS), 0L, 0L, null, 0L, 0L, 0L, 0L, 254, null);
                    }
                    if (!file.renameTo(file2)) {
                        file.delete();
                        return new GkFSIOStatistics(new GkFSStatus(false, new IOException(file + " rename failed, parent dir exists:" + file2.getParentFile().exists() + ", target file exists:" + file2.exists()), GkFSError.MAJOR_FILE_RENAME_FAILED), 0L, 0L, null, 0L, 0L, 0L, 0L, 254, null);
                    }
                    GkFSStatus success = GkFSStatus.INSTANCE.getSUCCESS();
                    long size = this.headerMeta.getSize();
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
                    Iterator it = linkedHashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        linkedHashMap4.put(((Map.Entry) it.next()).getKey(), Long.valueOf(longRef.element / linkedHashMap.size()));
                    }
                    return new GkFSIOStatistics(success, longValue, size, new GkFSChunkIOStatistics(linkedHashMap4, linkedHashMap), 0L, longValue2, this.meta.getTailBytes().getSize(), System.currentTimeMillis() - currentTimeMillis, 16, null);
                }
                throw new IOException("Except size is " + this.headerMeta.getSize() + ", but receive " + file.length() + " after writing");
            } catch (Throwable th6) {
                th = th6;
                GkFSIOStatistics gkFSIOStatistics3 = new GkFSIOStatistics(new GkFSStatus(false, new IOException("Error occur when transfer " + this.source + " to " + file2 + ", cause " + th.getMessage(), th), GkFSError.CHUNK_WRITE_ERROR), 0L, 0L, null, 0L, 0L, 0L, 0L, 254, null);
                file.delete();
                Iterator<T> it2 = this.meta.getChunks().iterator();
                while (it2.hasNext()) {
                    GkFSChunkStorage.INSTANCE.deleteChunk(((Chunker.GkFSCDCChunkInfo) it2.next()).getId(), file2);
                }
                Unit unit6 = Unit.INSTANCE;
                return gkFSIOStatistics3;
            }
        } catch (Throwable th7) {
            th = th7;
            file = file4;
            file2 = file3;
        }
    }
}
