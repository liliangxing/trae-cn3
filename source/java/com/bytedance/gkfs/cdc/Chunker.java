package com.bytedance.gkfs.cdc;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.gkfs.UtilsKt$traceTimePrecise$1$1;
import com.bytedance.gkfs.io.ChunkIdentifier;
import com.bytedance.gkfs.io.GkFSError;
import com.bytedance.gkfs.io.GkFSStatus;
import com.bytedance.gkfs.io.segmental.SegmentalByteArray;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.UnsignedKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: chunker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0003\t\n\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/gkfs/cdc/Chunker;", "", "()V", "window", "Lcom/bytedance/gkfs/cdc/CDCWindow;", "chunkFile", "Lcom/bytedance/gkfs/cdc/Chunker$GkFSCDCInfo;", "file", "Ljava/io/File;", "Companion", "GkFSCDCChunkInfo", "GkFSCDCInfo", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class Chunker {
    public static final int AVG_CHUNK_SIZE = 8192;
    public static final int MAX_CHUNK_SIZE = 32768;
    public static final int MIN_CHUNK_SIZE = 2048;
    private static final String TAG = "gkfs-chunker";
    private static final int UNIT_KB = 1024;
    private final CDCWindow window = new CDCWindow();

    /* JADX WARN: Removed duplicated region for block: B:38:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0200 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0411 A[Catch: all -> 0x041c, TryCatch #7 {all -> 0x041c, blocks: (B:68:0x040d, B:70:0x0411, B:71:0x0418), top: B:67:0x040d }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0417  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final GkFSCDCInfo chunkFile(File file) {
        long j;
        BufferedInputStream bufferedInputStream;
        Unit unit;
        Unit unit2;
        SegmentalByteArray segmentalByteArray;
        int i;
        int i2;
        int i3;
        Chunker chunker;
        Iterator it;
        LinkedHashMap linkedHashMap;
        Chunker chunker2 = this;
        Intrinsics.checkParameterIsNotNull(file, "file");
        if (file.length() <= 2048) {
            return new GkFSCDCInfo(file, CollectionsKt.emptyList(), new SegmentalByteArray(0), new GkFSCDCStatistics(new GkFSStatus(false, new IllegalStateException("size " + file.length() + " is less than 2048"), GkFSError.TINY_FILE), 0, 0, null, null, 0L, 62, null));
        }
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        long currentTimeMillis = System.currentTimeMillis();
        SegmentalByteArray segmentalByteArray2 = new SegmentalByteArray(32768);
        try {
            InputStream fileInputStream = new FileInputStream(file);
            if (fileInputStream instanceof BufferedInputStream) {
                try {
                    bufferedInputStream = (BufferedInputStream) fileInputStream;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = null;
                    j = currentTimeMillis;
                    try {
                        GkFSCDCInfo gkFSCDCInfo = new GkFSCDCInfo(file, CollectionsKt.emptyList(), new SegmentalByteArray(0), new GkFSCDCStatistics(new GkFSStatus(false, th, GkFSError.CDC_ERROR), 0, 0, null, null, System.currentTimeMillis() - j, 30, null));
                        try {
                            Result.Companion companion = Result.Companion;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                                unit2 = Unit.INSTANCE;
                            } else {
                                unit2 = null;
                            }
                            Result.constructor-impl(unit2);
                        } catch (Throwable th2) {
                            Result.Companion companion2 = Result.Companion;
                            Result.constructor-impl(ResultKt.createFailure(th2));
                        }
                        return gkFSCDCInfo;
                    } catch (Throwable th3) {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                                unit = Unit.INSTANCE;
                            } else {
                                unit = null;
                            }
                            Result.constructor-impl(unit);
                            throw th3;
                        } catch (Throwable th4) {
                            Result.Companion companion4 = Result.Companion;
                            Result.constructor-impl(ResultKt.createFailure(th4));
                            throw th3;
                        }
                    }
                }
            } else {
                bufferedInputStream = new BufferedInputStream(fileInputStream, 8192);
            }
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                Iterator withIndex = CollectionsKt.withIndex(ByteStreamsKt.iterator(bufferedInputStream));
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                long j2 = 0;
                while (withIndex.hasNext()) {
                    IndexedValue indexedValue = (IndexedValue) withIndex.next();
                    byte byteValue = ((Number) indexedValue.getValue()).byteValue();
                    int index = indexedValue.getIndex() - i4;
                    segmentalByteArray2.set(index, byteValue);
                    LinkedHashMap linkedHashMap4 = linkedHashMap3;
                    UtilsKt$traceTimePrecise$1$1 utilsKt$traceTimePrecise$1$1 = new UtilsKt$traceTimePrecise$1$1(System.nanoTime());
                    long j3 = ULong.constructor-impl(chunker2.window.slide8(byteValue));
                    long longValue = j2 + ((Number) utilsKt$traceTimePrecise$1$1.invoke()).longValue();
                    Unit unit3 = Unit.INSTANCE;
                    Iterator it2 = withIndex;
                    j = currentTimeMillis;
                    try {
                        boolean z = ((int) UnsignedKt.ulongRemainder-eb3DHEI(j3, ULong.constructor-impl((long) 8192))) == 4;
                        int i8 = index + 1;
                        if (!z || i8 >= 2048) {
                            i = 32768;
                            if (i8 == 32768) {
                                i6++;
                            }
                            i2 = i5;
                            i3 = i6;
                        } else {
                            i2 = i5 + 1;
                            i3 = i6;
                            i = 32768;
                        }
                        if (z) {
                            if (i8 < 2048) {
                            }
                            chunker2.window.reset();
                            Chunker chunker3 = chunker2;
                            chunker = !(i8 <= 0) ? chunker2 : null;
                            Chunker chunker4 = chunker;
                            if (chunker == null) {
                                try {
                                    it = it2;
                                    GkFSCDCChunkInfo gkFSCDCChunkInfo = new GkFSCDCChunkInfo(new ChunkIdentifier(segmentalByteArray2, i8), i4, SegmentalByteArray.copyInto$default(segmentalByteArray2, new SegmentalByteArray(i8), 0, 0, i8, 6, (Object) null));
                                    arrayList.add(gkFSCDCChunkInfo);
                                    linkedHashMap2.put(gkFSCDCChunkInfo.getId(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    linkedHashMap = linkedHashMap4;
                                    linkedHashMap.put(gkFSCDCChunkInfo.getId(), Long.valueOf(longValue));
                                    i4 = indexedValue.getIndex() + 1;
                                    currentTimeMillis2 = System.currentTimeMillis();
                                    j2 = 0;
                                    i7 = 0;
                                    chunker2 = this;
                                    linkedHashMap3 = linkedHashMap;
                                    i5 = i2;
                                    i6 = i3;
                                    currentTimeMillis = j;
                                    withIndex = it;
                                } catch (Throwable th5) {
                                    throw new IllegalStateException("ComputeHash error:" + th5.getMessage() + ",{chunkSize:" + i8 + ", currentPos:" + indexedValue.getIndex() + ", chunkStartPos:" + i4 + ", posInChunk=" + index + '}');
                                }
                            } else {
                                throw new IllegalStateException("Divided chunk size is ZERO, {currentPos:" + indexedValue.getIndex() + ", chunkStartPos:" + i4 + ", posInChunk=" + index + '}');
                            }
                        }
                        if (i8 < i) {
                            it = it2;
                            linkedHashMap = linkedHashMap4;
                            i7 = index;
                            j2 = longValue;
                            chunker2 = this;
                            linkedHashMap3 = linkedHashMap;
                            i5 = i2;
                            i6 = i3;
                            currentTimeMillis = j;
                            withIndex = it;
                        }
                        chunker2.window.reset();
                        Chunker chunker32 = chunker2;
                        if (!(i8 <= 0)) {
                        }
                        Chunker chunker42 = chunker;
                        if (chunker == null) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        GkFSCDCInfo gkFSCDCInfo2 = new GkFSCDCInfo(file, CollectionsKt.emptyList(), new SegmentalByteArray(0), new GkFSCDCStatistics(new GkFSStatus(false, th, GkFSError.CDC_ERROR), 0, 0, null, null, System.currentTimeMillis() - j, 30, null));
                        Result.Companion companion5 = Result.Companion;
                        if (bufferedInputStream != null) {
                        }
                        Result.constructor-impl(unit2);
                        return gkFSCDCInfo2;
                    }
                }
                GkFSCDCStatistics gkFSCDCStatistics = new GkFSCDCStatistics(GkFSStatus.INSTANCE.getSUCCESS(), i5, i6, linkedHashMap3, linkedHashMap2, System.currentTimeMillis() - currentTimeMillis);
                try {
                    Result.Companion companion6 = Result.Companion;
                    bufferedInputStream.close();
                    Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th7) {
                    Result.Companion companion7 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th7));
                }
                if (arrayList.isEmpty()) {
                    return new GkFSCDCInfo(file, CollectionsKt.emptyList(), new SegmentalByteArray(0), new GkFSCDCStatistics(new GkFSStatus(false, new IOException("can not find break point and file size:" + file.length() + " is less than 32768"), GkFSError.CDC_NO_CHUNK), 0, 0, null, null, 0L, 62, null));
                }
                if (i7 > 0) {
                    int i9 = i7 + 1;
                    segmentalByteArray = SegmentalByteArray.copyInto$default(segmentalByteArray2, new SegmentalByteArray(i9), 0, 0, i9, 6, (Object) null);
                } else {
                    segmentalByteArray = new SegmentalByteArray(0);
                }
                ArrayList arrayList2 = arrayList;
                Iterator it3 = arrayList2.iterator();
                int i10 = 0;
                while (it3.hasNext()) {
                    i10 += ((GkFSCDCChunkInfo) it3.next()).getBytes().getSize();
                }
                if (i10 + segmentalByteArray.getSize() != ((int) file.length())) {
                    GkFSError gkFSError = GkFSError.CDC_ERROR;
                    StringBuilder sb = new StringBuilder("size of ");
                    Iterator it4 = arrayList2.iterator();
                    int i11 = 0;
                    while (it4.hasNext()) {
                        i11 += ((GkFSCDCChunkInfo) it4.next()).getBytes().getSize();
                    }
                    StringBuilder append = sb.append(i11 + segmentalByteArray.getSize()).append("=chunks(");
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    Iterator it5 = arrayList2.iterator();
                    while (it5.hasNext()) {
                        arrayList3.add(Integer.valueOf(((GkFSCDCChunkInfo) it5.next()).getBytes().getSize()));
                    }
                    return new GkFSCDCInfo(file, arrayList, segmentalByteArray, new GkFSCDCStatistics(new GkFSStatus(false, new IllegalStateException(append.append(CollectionsKt.joinToString$default(arrayList3, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).append(") + tail(").append(segmentalByteArray.getSize()).append(") not equals to file size ").append(file.length()).toString()), gkFSError), 0, 0, null, null, 0L, 62, null));
                }
                return new GkFSCDCInfo(file, arrayList, segmentalByteArray, gkFSCDCStatistics);
            } catch (Throwable th8) {
                th = th8;
                j = currentTimeMillis;
                GkFSCDCInfo gkFSCDCInfo22 = new GkFSCDCInfo(file, CollectionsKt.emptyList(), new SegmentalByteArray(0), new GkFSCDCStatistics(new GkFSStatus(false, th, GkFSError.CDC_ERROR), 0, 0, null, null, System.currentTimeMillis() - j, 30, null));
                Result.Companion companion52 = Result.Companion;
                if (bufferedInputStream != null) {
                }
                Result.constructor-impl(unit2);
                return gkFSCDCInfo22;
            }
        } catch (Throwable th9) {
            th = th9;
            j = currentTimeMillis;
            bufferedInputStream = null;
        }
    }

    /* compiled from: chunker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/bytedance/gkfs/cdc/Chunker$GkFSCDCInfo;", "", "file", "Ljava/io/File;", "chunks", "", "Lcom/bytedance/gkfs/cdc/Chunker$GkFSCDCChunkInfo;", "tailBytes", "Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray;", "statistics", "Lcom/bytedance/gkfs/cdc/GkFSCDCStatistics;", "(Ljava/io/File;Ljava/util/List;Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray;Lcom/bytedance/gkfs/cdc/GkFSCDCStatistics;)V", "getChunks", "()Ljava/util/List;", "getFile", "()Ljava/io/File;", "getStatistics", "()Lcom/bytedance/gkfs/cdc/GkFSCDCStatistics;", "getTailBytes", "()Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray;", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final /* data */ class GkFSCDCInfo {
        private final List<GkFSCDCChunkInfo> chunks;
        private final File file;
        private final GkFSCDCStatistics statistics;
        private final SegmentalByteArray tailBytes;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GkFSCDCInfo copy$default(GkFSCDCInfo gkFSCDCInfo, File file, List list, SegmentalByteArray segmentalByteArray, GkFSCDCStatistics gkFSCDCStatistics, int i, Object obj) {
            if ((i & 1) != 0) {
                file = gkFSCDCInfo.file;
            }
            if ((i & 2) != 0) {
                list = gkFSCDCInfo.chunks;
            }
            if ((i & 4) != 0) {
                segmentalByteArray = gkFSCDCInfo.tailBytes;
            }
            if ((i & 8) != 0) {
                gkFSCDCStatistics = gkFSCDCInfo.statistics;
            }
            return gkFSCDCInfo.copy(file, list, segmentalByteArray, gkFSCDCStatistics);
        }

        /* renamed from: component1, reason: from getter */
        public final File getFile() {
            return this.file;
        }

        public final List<GkFSCDCChunkInfo> component2() {
            return this.chunks;
        }

        /* renamed from: component3, reason: from getter */
        public final SegmentalByteArray getTailBytes() {
            return this.tailBytes;
        }

        /* renamed from: component4, reason: from getter */
        public final GkFSCDCStatistics getStatistics() {
            return this.statistics;
        }

        public final GkFSCDCInfo copy(File file, List<GkFSCDCChunkInfo> chunks, SegmentalByteArray tailBytes, GkFSCDCStatistics statistics) {
            Intrinsics.checkParameterIsNotNull(file, "file");
            Intrinsics.checkParameterIsNotNull(chunks, "chunks");
            Intrinsics.checkParameterIsNotNull(tailBytes, "tailBytes");
            Intrinsics.checkParameterIsNotNull(statistics, "statistics");
            return new GkFSCDCInfo(file, chunks, tailBytes, statistics);
        }

        public String toString() {
            return "GkFSCDCInfo(file=" + this.file + ", chunks=" + this.chunks + ", tailBytes=" + this.tailBytes + ", statistics=" + this.statistics + ")";
        }

        public GkFSCDCInfo(File file, List<GkFSCDCChunkInfo> list, SegmentalByteArray segmentalByteArray, GkFSCDCStatistics gkFSCDCStatistics) {
            Intrinsics.checkParameterIsNotNull(file, "file");
            Intrinsics.checkParameterIsNotNull(list, "chunks");
            Intrinsics.checkParameterIsNotNull(segmentalByteArray, "tailBytes");
            Intrinsics.checkParameterIsNotNull(gkFSCDCStatistics, "statistics");
            this.file = file;
            this.chunks = list;
            this.tailBytes = segmentalByteArray;
            this.statistics = gkFSCDCStatistics;
        }

        public final File getFile() {
            return this.file;
        }

        public final List<GkFSCDCChunkInfo> getChunks() {
            return this.chunks;
        }

        public final SegmentalByteArray getTailBytes() {
            return this.tailBytes;
        }

        public final GkFSCDCStatistics getStatistics() {
            return this.statistics;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GkFSCDCInfo)) {
                return false;
            }
            GkFSCDCInfo gkFSCDCInfo = (GkFSCDCInfo) other;
            return ((Intrinsics.areEqual(this.file, gkFSCDCInfo.file) ^ true) || (Intrinsics.areEqual(this.chunks, gkFSCDCInfo.chunks) ^ true) || !this.tailBytes.contentEquals(gkFSCDCInfo.tailBytes) || (Intrinsics.areEqual(this.statistics, gkFSCDCInfo.statistics) ^ true)) ? false : true;
        }

        public int hashCode() {
            return (((((this.file.hashCode() * 31) + this.chunks.hashCode()) * 31) + this.tailBytes.contentHashCode()) * 31) + this.statistics.hashCode();
        }
    }

    /* compiled from: chunker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/gkfs/cdc/Chunker$GkFSCDCChunkInfo;", "", "id", "Lcom/bytedance/gkfs/io/ChunkIdentifier;", "from", "", "bytes", "Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray;", "(Lcom/bytedance/gkfs/io/ChunkIdentifier;ILcom/bytedance/gkfs/io/segmental/SegmentalByteArray;)V", "getBytes", "()Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray;", "getFrom", "()I", "getId", "()Lcom/bytedance/gkfs/io/ChunkIdentifier;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final /* data */ class GkFSCDCChunkInfo {
        private final SegmentalByteArray bytes;
        private final int from;
        private final ChunkIdentifier id;

        public static /* synthetic */ GkFSCDCChunkInfo copy$default(GkFSCDCChunkInfo gkFSCDCChunkInfo, ChunkIdentifier chunkIdentifier, int i, SegmentalByteArray segmentalByteArray, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                chunkIdentifier = gkFSCDCChunkInfo.id;
            }
            if ((i2 & 2) != 0) {
                i = gkFSCDCChunkInfo.from;
            }
            if ((i2 & 4) != 0) {
                segmentalByteArray = gkFSCDCChunkInfo.bytes;
            }
            return gkFSCDCChunkInfo.copy(chunkIdentifier, i, segmentalByteArray);
        }

        /* renamed from: component1, reason: from getter */
        public final ChunkIdentifier getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final int getFrom() {
            return this.from;
        }

        /* renamed from: component3, reason: from getter */
        public final SegmentalByteArray getBytes() {
            return this.bytes;
        }

        public final GkFSCDCChunkInfo copy(ChunkIdentifier id, int from, SegmentalByteArray bytes) {
            Intrinsics.checkParameterIsNotNull(id, "id");
            Intrinsics.checkParameterIsNotNull(bytes, "bytes");
            return new GkFSCDCChunkInfo(id, from, bytes);
        }

        public String toString() {
            return "GkFSCDCChunkInfo(id=" + this.id + ", from=" + this.from + ", bytes=" + this.bytes + ")";
        }

        public GkFSCDCChunkInfo(ChunkIdentifier chunkIdentifier, int i, SegmentalByteArray segmentalByteArray) {
            Intrinsics.checkParameterIsNotNull(chunkIdentifier, "id");
            Intrinsics.checkParameterIsNotNull(segmentalByteArray, "bytes");
            this.id = chunkIdentifier;
            this.from = i;
            this.bytes = segmentalByteArray;
        }

        public final ChunkIdentifier getId() {
            return this.id;
        }

        public final int getFrom() {
            return this.from;
        }

        public final SegmentalByteArray getBytes() {
            return this.bytes;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GkFSCDCChunkInfo)) {
                return false;
            }
            GkFSCDCChunkInfo gkFSCDCChunkInfo = (GkFSCDCChunkInfo) other;
            return !(Intrinsics.areEqual(this.id, gkFSCDCChunkInfo.id) ^ true) && this.from == gkFSCDCChunkInfo.from;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.from;
        }
    }
}
