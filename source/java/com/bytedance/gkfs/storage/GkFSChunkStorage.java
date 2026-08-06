package com.bytedance.gkfs.storage;

import android.app.Application;
import com.bytedance.gkfs.GkFSExecutor;
import com.bytedance.gkfs.GkFSLogger;
import com.bytedance.gkfs.UtilsKt;
import com.bytedance.gkfs.UtilsKt$traceTime$1$1;
import com.bytedance.gkfs.cdc.Chunker;
import com.bytedance.gkfs.io.BlockIdentifier;
import com.bytedance.gkfs.io.ChunkIdentifier;
import com.bytedance.gkfs.io.segmental.SegmentalByteArray;
import com.bytedance.gkfs.io.segmental.SegmentalByteArrayKt;
import com.bytedance.gkfs.storage.io.CombinedChunkInputStream;
import com.bytedance.gkfs.storage.io.CombinedChunkOutputStream;
import com.bytedance.gkfs.storage.io.GkFSBlockBuffer;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.statistic.model.EventMessageModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: GkFSChunkStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0004J\r\u0010\u001c\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u001dJ\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/gkfs/storage/GkFSChunkStorage;", "", "()V", "context", "Landroid/app/Application;", "inTidyUp", "Ljava/util/concurrent/atomic/AtomicBoolean;", "indexing", "Lcom/bytedance/gkfs/storage/GkFSCombinedChunkIndexing;", "indexingLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "logger", "Lcom/bytedance/gkfs/GkFSLogger;", "addChunks", "", "Lcom/bytedance/gkfs/io/ChunkIdentifier;", "Lcom/bytedance/gkfs/storage/GkFSChunkStorageInfo;", "chunks", "", "Lcom/bytedance/gkfs/cdc/Chunker$GkFSCDCChunkInfo;", "majorFile", "Ljava/io/File;", "deleteChunk", "", "identity", "findChunk", "init", "", "isInTidyUp", "isInTidyUp$geckox_noasanRelease", "tidyUp", "Lcom/bytedance/gkfs/storage/GkFSChunkTidyInfo;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GkFSChunkStorage {
    private static Application context;
    private static GkFSCombinedChunkIndexing indexing;
    public static final GkFSChunkStorage INSTANCE = new GkFSChunkStorage();
    private static final GkFSLogger logger = new GkFSLogger();
    private static final AtomicBoolean inTidyUp = new AtomicBoolean(false);
    private static final ReentrantReadWriteLock indexingLock = new ReentrantReadWriteLock();

    private GkFSChunkStorage() {
    }

    public final void init(Application context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        context = context2;
        GkFSBlockBuffer.INSTANCE.init(context2);
        indexing = new GkFSCombinedChunkIndexing(logger, new File(context2.getFilesDir(), "keva/repo"));
    }

    public final boolean isInTidyUp$geckox_noasanRelease() {
        return inTidyUp.get();
    }

    public final boolean deleteChunk(ChunkIdentifier identity, File majorFile) {
        Intrinsics.checkParameterIsNotNull(identity, "identity");
        Intrinsics.checkParameterIsNotNull(majorFile, "majorFile");
        ReentrantReadWriteLock reentrantReadWriteLock = indexingLock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            GkFSCombinedChunkIndexing gkFSCombinedChunkIndexing = indexing;
            if (gkFSCombinedChunkIndexing == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indexing");
            }
            if (gkFSCombinedChunkIndexing.delete$geckox_noasanRelease(identity, majorFile) != null) {
                return !ArraysKt.contains(r7.getReference(), majorFile.getAbsolutePath());
            }
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
            return true;
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final GkFSChunkStorageInfo findChunk(ChunkIdentifier identity) throws IOException {
        Intrinsics.checkParameterIsNotNull(identity, "identity");
        UtilsKt$traceTime$1$1 utilsKt$traceTime$1$1 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        if (inTidyUp.get()) {
            throw new IOException("can not read GkFS file in tidyUp");
        }
        ReentrantReadWriteLock.ReadLock readLock = indexingLock.readLock();
        readLock.lock();
        try {
            long longValue = ((Number) utilsKt$traceTime$1$1.invoke()).longValue();
            GkFSCombinedChunkIndexing gkFSCombinedChunkIndexing = indexing;
            if (gkFSCombinedChunkIndexing == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indexing");
            }
            ChunkIndexingInfo find$geckox_noasanRelease = gkFSCombinedChunkIndexing.find$geckox_noasanRelease(identity);
            if (find$geckox_noasanRelease == null) {
                throw new IOException("can not find located block for chunk " + identity.getValue());
            }
            final ChunkBlockIndexingInfo blockInfo = find$geckox_noasanRelease.getBlockInfo();
            final GkFSBlockBuffer blockBuffer = GkFSBlockBuffer.INSTANCE.getBlockBuffer(find$geckox_noasanRelease.getBlockId());
            if (blockBuffer == null) {
                throw new IOException("Not exist block file for id " + find$geckox_noasanRelease.getBlockId());
            }
            return new GkFSChunkStorageInfo(identity, blockBuffer.getBackingFile(), new Function0<CombinedChunkInputStream>() { // from class: com.bytedance.gkfs.storage.GkFSChunkStorage$findChunk$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final CombinedChunkInputStream m573invoke() {
                    return new CombinedChunkInputStream(ChunkBlockIndexingInfo.this, blockBuffer);
                }
            }, find$geckox_noasanRelease, longValue, 0L, ((Number) utilsKt$traceTime$1$1.invoke()).longValue(), find$geckox_noasanRelease.getBlockInfo().getSize());
        } finally {
            readLock.unlock();
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03b4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<ChunkIdentifier, GkFSChunkStorageInfo> addChunks(final List<Chunker.GkFSCDCChunkInfo> chunks, final File majorFile) {
        int i;
        CombinedChunkOutputStream combinedChunkOutputStream;
        int i2;
        String[] strArr;
        GkFSCombinedChunkIndexing gkFSCombinedChunkIndexing;
        String[] reference;
        Set mutableSet;
        ArrayList arrayList;
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        Object obj;
        ArrayList arrayList2;
        LinkedHashMap linkedHashMap3;
        Boolean bool;
        ChunkIdentifier chunkIdentifier;
        File file = majorFile;
        Intrinsics.checkParameterIsNotNull(chunks, "chunks");
        Intrinsics.checkParameterIsNotNull(file, "majorFile");
        final UtilsKt$traceTime$1$1 utilsKt$traceTime$1$1 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        final long longValue = ((Number) utilsKt$traceTime$1$1.invoke()).longValue();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        ArrayList arrayList3 = new ArrayList();
        LinkedHashMap linkedHashMap5 = new LinkedHashMap();
        Iterator<Chunker.GkFSCDCChunkInfo> it = chunks.iterator();
        while (true) {
            Throwable th = null;
            int i3 = 1;
            if (it.hasNext()) {
                final Chunker.GkFSCDCChunkInfo next = it.next();
                final ChunkIdentifier id = next.getId();
                GkFSCombinedChunkIndexing gkFSCombinedChunkIndexing2 = indexing;
                if (gkFSCombinedChunkIndexing2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("indexing");
                }
                final ChunkIndexingInfo findGeneral$geckox_noasanRelease = gkFSCombinedChunkIndexing2.findGeneral$geckox_noasanRelease(id);
                if (findGeneral$geckox_noasanRelease != null) {
                    GkFSCombinedChunkIndexing gkFSCombinedChunkIndexing3 = indexing;
                    if (gkFSCombinedChunkIndexing3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("indexing");
                    }
                    final ChunkBlockIndexingInfo findBlock$geckox_noasanRelease = gkFSCombinedChunkIndexing3.findBlock$geckox_noasanRelease(id, findGeneral$geckox_noasanRelease.getBlockId());
                    if (findBlock$geckox_noasanRelease != null) {
                        final GkFSBlockBuffer blockBuffer = GkFSBlockBuffer.INSTANCE.getBlockBuffer(findGeneral$geckox_noasanRelease.getBlockId());
                        if (blockBuffer == null) {
                            final String str = "can not find block file " + findGeneral$geckox_noasanRelease.getBlockId().getValue() + " for chunk " + id.getValue();
                            GkFSLogger.w$default(logger, "GkFSChunkStorage", str, 0, null, false, 28, null);
                            GkFSCombinedChunkIndexing gkFSCombinedChunkIndexing4 = indexing;
                            if (gkFSCombinedChunkIndexing4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("indexing");
                            }
                            gkFSCombinedChunkIndexing4.deleteBlock$geckox_noasanRelease(id, findGeneral$geckox_noasanRelease.getBlockId());
                            arrayList3.add(next);
                            linkedHashMap5.put(id, findGeneral$geckox_noasanRelease);
                            bool = Boolean.valueOf(GkFSExecutor.sequence(new Runnable() { // from class: com.bytedance.gkfs.storage.GkFSChunkStorage$addChunks$1$1$1$1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    new EventMessageModel(EventSubType.BLOCK_FILE_NOT_EXIST, (String) null, (String) null, str, (String) null, 0L, 54, (DefaultConstructorMarker) null).upload();
                                }
                            }));
                            arrayList2 = arrayList3;
                            linkedHashMap3 = linkedHashMap5;
                            linkedHashMap2 = linkedHashMap4;
                        } else {
                            try {
                                Result.Companion companion = Result.Companion;
                                combinedChunkOutputStream = new CombinedChunkInputStream(findBlock$geckox_noasanRelease, blockBuffer);
                                try {
                                    SegmentalByteArray readBytesSegmental = SegmentalByteArrayKt.readBytesSegmental(combinedChunkOutputStream, findBlock$geckox_noasanRelease.getSize());
                                    CloseableKt.closeFinally(combinedChunkOutputStream, (Throwable) null);
                                    chunkIdentifier = new ChunkIdentifier(readBytesSegmental, 0, 2, null);
                                } finally {
                                    try {
                                        break;
                                    } finally {
                                    }
                                }
                            } catch (Throwable th2) {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th2));
                            }
                            if (!(!Intrinsics.areEqual(chunkIdentifier, id))) {
                                obj = Result.constructor-impl(Unit.INSTANCE);
                                Throwable th3 = Result.exceptionOrNull-impl(obj);
                                if (th3 != null) {
                                    final String message = th3.getMessage();
                                    if (message == null) {
                                        message = "";
                                    }
                                    GkFSLogger.w$default(logger, "GkFSChunkStorage", message, 0, null, false, 28, null);
                                    ReentrantReadWriteLock reentrantReadWriteLock = indexingLock;
                                    ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
                                    int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                                    for (int i4 = 0; i4 < readHoldCount; i4++) {
                                        readLock.unlock();
                                    }
                                    ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
                                    writeLock.lock();
                                    try {
                                        GkFSCombinedChunkIndexing gkFSCombinedChunkIndexing5 = indexing;
                                        if (gkFSCombinedChunkIndexing5 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("indexing");
                                        }
                                        gkFSCombinedChunkIndexing5.deleteBlock$geckox_noasanRelease(id, findGeneral$geckox_noasanRelease.getBlockId());
                                        Unit unit = Unit.INSTANCE;
                                        for (int i5 = 0; i5 < readHoldCount; i5++) {
                                            readLock.lock();
                                        }
                                        writeLock.unlock();
                                        arrayList3.add(next);
                                        linkedHashMap5.put(id, findGeneral$geckox_noasanRelease);
                                        GkFSExecutor.sequence(new Runnable() { // from class: com.bytedance.gkfs.storage.GkFSChunkStorage$addChunks$1$1$1$3$2
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                new EventMessageModel(EventSubType.CHUNK_CONTENT_BROKEN, (String) null, (String) null, message, (String) null, 0L, 54, (DefaultConstructorMarker) null).upload();
                                            }
                                        });
                                        Unit unit2 = Unit.INSTANCE;
                                    } catch (Throwable th4) {
                                        for (int i6 = 0; i6 < readHoldCount; i6++) {
                                            readLock.lock();
                                        }
                                        writeLock.unlock();
                                        throw th4;
                                    }
                                }
                                if (Result.isSuccess-impl(obj)) {
                                    GkFSCombinedChunkIndexing gkFSCombinedChunkIndexing6 = indexing;
                                    if (gkFSCombinedChunkIndexing6 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("indexing");
                                    }
                                    ChunkIndexingInfo copy$default = ChunkIndexingInfo.copy$default(gkFSCombinedChunkIndexing6.insertReference$geckox_noasanRelease(id, file), null, null, null, findBlock$geckox_noasanRelease, ((Number) utilsKt$traceTime$1$1.invoke()).longValue(), 7, null);
                                    final ArrayList arrayList4 = arrayList3;
                                    final LinkedHashMap linkedHashMap6 = linkedHashMap5;
                                    final LinkedHashMap linkedHashMap7 = linkedHashMap4;
                                    linkedHashMap3 = linkedHashMap5;
                                    arrayList2 = arrayList3;
                                    linkedHashMap2 = linkedHashMap4;
                                    linkedHashMap2.put(id, new GkFSChunkStorageInfo(id, blockBuffer.getBackingFile(), new Function0<CombinedChunkInputStream>() { // from class: com.bytedance.gkfs.storage.GkFSChunkStorage$addChunks$$inlined$traceTime$lambda$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                        public final CombinedChunkInputStream m572invoke() {
                                            return new CombinedChunkInputStream(ChunkBlockIndexingInfo.this, blockBuffer);
                                        }
                                    }, copy$default, longValue, 0L, ((Number) utilsKt$traceTime$1$1.invoke()).longValue(), findBlock$geckox_noasanRelease.getSize()));
                                    Unit unit3 = Unit.INSTANCE;
                                } else {
                                    arrayList2 = arrayList3;
                                    linkedHashMap3 = linkedHashMap5;
                                    linkedHashMap2 = linkedHashMap4;
                                }
                                bool = Result.box-impl(obj);
                            } else {
                                throw new IOException("content of chunk " + id.getValue() + " in block " + blockBuffer.getBackingFile() + " may broken, hash is " + chunkIdentifier.getValue());
                            }
                        }
                        arrayList = arrayList2;
                        linkedHashMap = linkedHashMap3;
                    } else {
                        linkedHashMap2 = linkedHashMap4;
                        final String str2 = "can not find block indexing for chunk " + next.getId().getValue();
                        GkFSLogger.w$default(logger, "GkFSChunkStorage", str2, 0, null, false, 28, null);
                        arrayList = arrayList3;
                        arrayList.add(next);
                        linkedHashMap = linkedHashMap5;
                        linkedHashMap.put(id, findGeneral$geckox_noasanRelease);
                        Boolean.valueOf(GkFSExecutor.sequence(new Runnable() { // from class: com.bytedance.gkfs.storage.GkFSChunkStorage$addChunks$1$1$2$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                new EventMessageModel(EventSubType.BLOCK_INDEXING_NOT_EXIST, (String) null, (String) null, str2, (String) null, 0L, 54, (DefaultConstructorMarker) null).upload();
                            }
                        }));
                    }
                } else {
                    arrayList = arrayList3;
                    linkedHashMap = linkedHashMap5;
                    linkedHashMap2 = linkedHashMap4;
                    Boolean.valueOf(arrayList.add(next));
                }
                arrayList3 = arrayList;
                linkedHashMap5 = linkedHashMap;
                linkedHashMap4 = linkedHashMap2;
                file = majorFile;
            } else {
                LinkedHashMap linkedHashMap8 = linkedHashMap5;
                LinkedHashMap linkedHashMap9 = linkedHashMap4;
                ArrayList<Chunker.GkFSCDCChunkInfo> arrayList5 = arrayList3;
                Iterator it2 = arrayList5.iterator();
                int i7 = 0;
                while (it2.hasNext()) {
                    i7 += ((Chunker.GkFSCDCChunkInfo) it2.next()).getBytes().getSize();
                }
                i = GkFSChunkStorageKt.PAGE_SIZE;
                int alignTo = UtilsKt.alignTo(i7, i);
                GkFSBlockBuffer obtainBlockBuffer = GkFSBlockBuffer.INSTANCE.obtainBlockBuffer(alignTo);
                String absolutePath = majorFile.getAbsolutePath();
                SegmentalByteArray segmentalByteArray = new SegmentalByteArray(alignTo);
                final long availableWritePos$geckox_noasanRelease = obtainBlockBuffer.getAvailableWritePos$geckox_noasanRelease();
                Ref.IntRef intRef = new Ref.IntRef();
                int i8 = 0;
                intRef.element = 0;
                for (Chunker.GkFSCDCChunkInfo gkFSCDCChunkInfo : arrayList5) {
                    int size = gkFSCDCChunkInfo.getBytes().getSize();
                    gkFSCDCChunkInfo.getBytes().copyInto(segmentalByteArray, intRef.element, i8, size);
                    ChunkIndexingInfo chunkIndexingInfo = (ChunkIndexingInfo) linkedHashMap8.get(gkFSCDCChunkInfo.getId());
                    ChunkIdentifier id2 = gkFSCDCChunkInfo.getId();
                    BlockIdentifier id3 = obtainBlockBuffer.getId();
                    if (chunkIndexingInfo != null && (reference = chunkIndexingInfo.getReference()) != null && (mutableSet = ArraysKt.toMutableSet(reference)) != null) {
                        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "reference");
                        mutableSet.add(absolutePath);
                        Unit unit4 = Unit.INSTANCE;
                        if (mutableSet != null) {
                            Object[] array = mutableSet.toArray(new String[0]);
                            if (array == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                            String[] strArr2 = (String[]) array;
                            if (strArr2 != null) {
                                strArr = strArr2;
                                i2 = 0;
                                final ChunkIndexingInfo chunkIndexingInfo2 = new ChunkIndexingInfo(id2, id3, strArr, new ChunkBlockIndexingInfo(availableWritePos$geckox_noasanRelease + intRef.element, size), ((Number) utilsKt$traceTime$1$1.invoke()).longValue());
                                gkFSCombinedChunkIndexing = indexing;
                                if (gkFSCombinedChunkIndexing != null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("indexing");
                                }
                                gkFSCombinedChunkIndexing.insertOrCover$geckox_noasanRelease(chunkIndexingInfo2);
                                ChunkIdentifier id4 = gkFSCDCChunkInfo.getId();
                                ChunkIdentifier id5 = gkFSCDCChunkInfo.getId();
                                File backingFile = obtainBlockBuffer.getBackingFile();
                                final SegmentalByteArray segmentalByteArray2 = segmentalByteArray;
                                final Ref.IntRef intRef2 = intRef;
                                final LinkedHashMap linkedHashMap10 = linkedHashMap8;
                                final GkFSBlockBuffer gkFSBlockBuffer = obtainBlockBuffer;
                                Ref.IntRef intRef3 = intRef;
                                final String str3 = absolutePath;
                                GkFSBlockBuffer gkFSBlockBuffer2 = obtainBlockBuffer;
                                final LinkedHashMap linkedHashMap11 = linkedHashMap9;
                                LinkedHashMap linkedHashMap12 = linkedHashMap9;
                                linkedHashMap12.put(id4, new GkFSChunkStorageInfo(id5, backingFile, new Function0<CombinedChunkInputStream>() { // from class: com.bytedance.gkfs.storage.GkFSChunkStorage$$special$$inlined$forEach$lambda$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final CombinedChunkInputStream m571invoke() {
                                        return new CombinedChunkInputStream(ChunkIndexingInfo.this.getBlockInfo(), gkFSBlockBuffer);
                                    }
                                }, chunkIndexingInfo2, longValue, 0L, ((Number) utilsKt$traceTime$1$1.invoke()).longValue(), size));
                                intRef3.element += size;
                                intRef = intRef3;
                                linkedHashMap9 = linkedHashMap12;
                                i3 = i3;
                                th = th;
                                alignTo = alignTo;
                                i8 = i2;
                                absolutePath = absolutePath;
                                linkedHashMap8 = linkedHashMap8;
                                segmentalByteArray = segmentalByteArray;
                                obtainBlockBuffer = gkFSBlockBuffer2;
                            }
                        }
                    }
                    String[] strArr3 = new String[i3];
                    Intrinsics.checkExpressionValueIsNotNull(absolutePath, "reference");
                    i2 = 0;
                    strArr3[0] = absolutePath;
                    strArr = strArr3;
                    final ChunkIndexingInfo chunkIndexingInfo22 = new ChunkIndexingInfo(id2, id3, strArr, new ChunkBlockIndexingInfo(availableWritePos$geckox_noasanRelease + intRef.element, size), ((Number) utilsKt$traceTime$1$1.invoke()).longValue());
                    gkFSCombinedChunkIndexing = indexing;
                    if (gkFSCombinedChunkIndexing != null) {
                    }
                    gkFSCombinedChunkIndexing.insertOrCover$geckox_noasanRelease(chunkIndexingInfo22);
                    ChunkIdentifier id42 = gkFSCDCChunkInfo.getId();
                    ChunkIdentifier id52 = gkFSCDCChunkInfo.getId();
                    File backingFile2 = obtainBlockBuffer.getBackingFile();
                    final SegmentalByteArray segmentalByteArray22 = segmentalByteArray;
                    final Ref.IntRef intRef22 = intRef;
                    final Map linkedHashMap102 = linkedHashMap8;
                    final GkFSBlockBuffer gkFSBlockBuffer3 = obtainBlockBuffer;
                    Ref.IntRef intRef32 = intRef;
                    final String str32 = absolutePath;
                    GkFSBlockBuffer gkFSBlockBuffer22 = obtainBlockBuffer;
                    final Map linkedHashMap112 = linkedHashMap9;
                    LinkedHashMap linkedHashMap122 = linkedHashMap9;
                    linkedHashMap122.put(id42, new GkFSChunkStorageInfo(id52, backingFile2, new Function0<CombinedChunkInputStream>() { // from class: com.bytedance.gkfs.storage.GkFSChunkStorage$$special$$inlined$forEach$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final CombinedChunkInputStream m571invoke() {
                            return new CombinedChunkInputStream(ChunkIndexingInfo.this.getBlockInfo(), gkFSBlockBuffer3);
                        }
                    }, chunkIndexingInfo22, longValue, 0L, ((Number) utilsKt$traceTime$1$1.invoke()).longValue(), size));
                    intRef32.element += size;
                    intRef = intRef32;
                    linkedHashMap9 = linkedHashMap122;
                    i3 = i3;
                    th = th;
                    alignTo = alignTo;
                    i8 = i2;
                    absolutePath = absolutePath;
                    linkedHashMap8 = linkedHashMap8;
                    segmentalByteArray = segmentalByteArray;
                    obtainBlockBuffer = gkFSBlockBuffer22;
                }
                Throwable th5 = th;
                SegmentalByteArray segmentalByteArray3 = segmentalByteArray;
                LinkedHashMap linkedHashMap13 = linkedHashMap9;
                combinedChunkOutputStream = new CombinedChunkOutputStream(alignTo, obtainBlockBuffer);
                try {
                    combinedChunkOutputStream.write$geckox_noasanRelease(segmentalByteArray3);
                    Unit unit5 = Unit.INSTANCE;
                    CloseableKt.closeFinally(combinedChunkOutputStream, th5);
                    return linkedHashMap13;
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:92:0x031a A[Catch: all -> 0x0496, TRY_ENTER, TryCatch #3 {all -> 0x0496, blocks: (B:7:0x001a, B:10:0x0028, B:11:0x002b, B:12:0x0054, B:14:0x005a, B:15:0x007f, B:17:0x0085, B:19:0x00a1, B:21:0x00ae, B:22:0x00b0, B:24:0x00b4, B:25:0x00b7, B:27:0x00c5, B:28:0x00c8, B:30:0x00d9, B:32:0x00f2, B:38:0x0104, B:40:0x011e, B:42:0x0126, B:43:0x012b, B:45:0x0133, B:50:0x013b, B:52:0x0158, B:54:0x0160, B:55:0x0186, B:57:0x018c, B:59:0x01a1, B:88:0x0307, B:89:0x0311, B:92:0x031a, B:93:0x034c, B:95:0x0352, B:97:0x035b, B:99:0x0361, B:100:0x0364, B:101:0x036e, B:103:0x0374, B:105:0x038c, B:107:0x038f, B:110:0x039f, B:111:0x03d5, B:167:0x0405, B:168:0x041b, B:170:0x0421, B:172:0x042d, B:173:0x0457, B:175:0x045d, B:177:0x046b, B:179:0x0472, B:183:0x0474), top: B:6:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0352 A[Catch: all -> 0x0496, TryCatch #3 {all -> 0x0496, blocks: (B:7:0x001a, B:10:0x0028, B:11:0x002b, B:12:0x0054, B:14:0x005a, B:15:0x007f, B:17:0x0085, B:19:0x00a1, B:21:0x00ae, B:22:0x00b0, B:24:0x00b4, B:25:0x00b7, B:27:0x00c5, B:28:0x00c8, B:30:0x00d9, B:32:0x00f2, B:38:0x0104, B:40:0x011e, B:42:0x0126, B:43:0x012b, B:45:0x0133, B:50:0x013b, B:52:0x0158, B:54:0x0160, B:55:0x0186, B:57:0x018c, B:59:0x01a1, B:88:0x0307, B:89:0x0311, B:92:0x031a, B:93:0x034c, B:95:0x0352, B:97:0x035b, B:99:0x0361, B:100:0x0364, B:101:0x036e, B:103:0x0374, B:105:0x038c, B:107:0x038f, B:110:0x039f, B:111:0x03d5, B:167:0x0405, B:168:0x041b, B:170:0x0421, B:172:0x042d, B:173:0x0457, B:175:0x045d, B:177:0x046b, B:179:0x0472, B:183:0x0474), top: B:6:0x001a }] */
    /* JADX WARN: Type inference failed for: r39v1 */
    /* JADX WARN: Type inference failed for: r39v10 */
    /* JADX WARN: Type inference failed for: r39v3 */
    /* JADX WARN: Type inference failed for: r39v4 */
    /* JADX WARN: Type inference failed for: r39v5 */
    /* JADX WARN: Type inference failed for: r39v6 */
    /* JADX WARN: Type inference failed for: r39v7 */
    /* JADX WARN: Type inference failed for: r39v8 */
    /* JADX WARN: Type inference failed for: r39v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final GkFSChunkTidyInfo tidyUp() {
        GkFSBlockBuffer blockBuffer;
        int i;
        UtilsKt$traceTime$1$1 utilsKt$traceTime$1$1;
        LinkedHashMap linkedHashMap;
        String str;
        Map<BlockIdentifier, Map<ChunkIdentifier, ChunkIndexingTidyUpInfo>> map;
        int i2;
        int i3;
        long j;
        Unit unit;
        Object obj;
        Throwable th;
        SegmentalByteArray segmentalByteArray;
        FileOutputStream fileOutputStream;
        long j2;
        UtilsKt$traceTime$1$1 utilsKt$traceTime$1$12 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        if (inTidyUp.compareAndSet(false, true)) {
            try {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                GkFSCombinedChunkIndexing gkFSCombinedChunkIndexing = indexing;
                String str2 = "indexing";
                if (gkFSCombinedChunkIndexing == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("indexing");
                }
                Map<BlockIdentifier, Map<ChunkIdentifier, ChunkIndexingTidyUpInfo>> tidyUp$geckox_noasanRelease = gkFSCombinedChunkIndexing.tidyUp$geckox_noasanRelease(GkFSBlockBuffer.INSTANCE.getExistBlocks());
                long longValue = ((Number) utilsKt$traceTime$1$12.invoke()).longValue();
                Iterator it = tidyUp$geckox_noasanRelease.entrySet().iterator();
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    BlockIdentifier blockIdentifier = (BlockIdentifier) entry.getKey();
                    Map map2 = (Map) entry.getValue();
                    ArrayList arrayList = new ArrayList();
                    for (ChunkIndexingTidyUpInfo chunkIndexingTidyUpInfo : map2.values()) {
                        Iterator it2 = it;
                        int size = chunkIndexingTidyUpInfo.getIndexingInfo().getBlockInfo().getSize();
                        if (chunkIndexingTidyUpInfo.getNeedDelete()) {
                            j2 = longValue;
                        } else {
                            j2 = longValue;
                            j5 += size;
                            i7++;
                            if (chunkIndexingTidyUpInfo.isTidyUp()) {
                                i6++;
                            }
                            GkFSCombinedChunkIndexing gkFSCombinedChunkIndexing2 = indexing;
                            if (gkFSCombinedChunkIndexing2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(str2);
                            }
                            ChunkIndexingInfo findGeneral$geckox_noasanRelease = gkFSCombinedChunkIndexing2.findGeneral$geckox_noasanRelease(chunkIndexingTidyUpInfo.getIndexingInfo().getId());
                            if (findGeneral$geckox_noasanRelease == null) {
                                Intrinsics.throwNpe();
                            }
                            String[] reference = findGeneral$geckox_noasanRelease.getReference();
                            int length = reference.length;
                            int i8 = i5 + length;
                            int i9 = size * length;
                            int i10 = i6;
                            j4 += i9;
                            int i11 = 0;
                            for (int length2 = reference.length; i11 < length2; length2 = length2) {
                                String str3 = reference[i11];
                                linkedHashMap2.put(str3, Long.valueOf(new File(str3).length()));
                                i11++;
                            }
                            Unit unit2 = Unit.INSTANCE;
                            arrayList.add(chunkIndexingTidyUpInfo);
                            i6 = i10;
                            i5 = i8;
                        }
                        it = it2;
                        longValue = j2;
                    }
                    Iterator it3 = it;
                    long j6 = longValue;
                    int size2 = (((Map) entry.getValue()).size() - arrayList.size()) + i4;
                    if (arrayList.isEmpty()) {
                        GkFSBlockBuffer removeCache$geckox_noasanRelease = GkFSBlockBuffer.INSTANCE.removeCache$geckox_noasanRelease(blockIdentifier);
                        if (removeCache$geckox_noasanRelease != null) {
                            removeCache$geckox_noasanRelease.close();
                            Unit unit3 = Unit.INSTANCE;
                        }
                        File blockFile = GkFSBlockBuffer.INSTANCE.toBlockFile(blockIdentifier);
                        if (blockFile != null) {
                            Boolean.valueOf(blockFile.delete());
                        }
                    } else if (arrayList.size() != map2.size() && (blockBuffer = GkFSBlockBuffer.INSTANCE.getBlockBuffer(blockIdentifier)) != null) {
                        File backingFile = blockBuffer.getBackingFile();
                        File blockBackup = GkFSBlockBuffer.INSTANCE.getBlockBackup(backingFile);
                        File blockRewriteTmp = GkFSBlockBuffer.INSTANCE.getBlockRewriteTmp(backingFile);
                        ArrayList arrayList2 = new ArrayList();
                        long currentTimeMillis = System.currentTimeMillis();
                        Iterator it4 = arrayList.iterator();
                        int i12 = 0;
                        while (it4.hasNext()) {
                            i12 += ((ChunkIndexingTidyUpInfo) it4.next()).getIndexingInfo().getBlockInfo().getSize();
                        }
                        int i13 = i5;
                        i = GkFSChunkStorageKt.PAGE_SIZE;
                        int alignTo = UtilsKt.alignTo(i12, i);
                        try {
                            Result.Companion companion = Result.Companion;
                            segmentalByteArray = new SegmentalByteArray(alignTo);
                            int size3 = arrayList.size();
                            i2 = i6;
                            int i14 = 0;
                            i3 = 0;
                            while (i14 < size3) {
                                try {
                                    ChunkIndexingTidyUpInfo chunkIndexingTidyUpInfo2 = (ChunkIndexingTidyUpInfo) arrayList.get(i14);
                                    int i15 = size3;
                                    ChunkBlockIndexingInfo blockInfo = chunkIndexingTidyUpInfo2.getIndexingInfo().getBlockInfo();
                                    map = tidyUp$geckox_noasanRelease;
                                    try {
                                        utilsKt$traceTime$1$1 = utilsKt$traceTime$1$12;
                                        try {
                                            SegmentalByteArray.copyInto$default(SegmentalByteArrayKt.readBytesSegmental(new CombinedChunkInputStream(blockInfo, blockBuffer), blockInfo.getSize()), segmentalByteArray, i3, 0, 0, 12, (Object) null);
                                            int i16 = i3;
                                            i3 = j3;
                                            try {
                                                ChunkIndexingInfo copy$default = ChunkIndexingInfo.copy$default(chunkIndexingTidyUpInfo2.getIndexingInfo(), null, null, null, ChunkBlockIndexingInfo.copy$default(blockInfo, i16, 0, 2, null), 0L, 23, null);
                                                GkFSCombinedChunkIndexing gkFSCombinedChunkIndexing3 = indexing;
                                                if (gkFSCombinedChunkIndexing3 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException(str2);
                                                }
                                                linkedHashMap = linkedHashMap2;
                                                try {
                                                    str = str2;
                                                    try {
                                                        gkFSCombinedChunkIndexing3.insertOrCoverBlock$geckox_noasanRelease(copy$default.getId(), copy$default.getBlockId(), copy$default.getBlockInfo());
                                                        arrayList2.add(copy$default);
                                                        int size4 = blockInfo.getSize() + i16;
                                                        i14++;
                                                        linkedHashMap2 = linkedHashMap;
                                                        str2 = str;
                                                        j3 = i3;
                                                        tidyUp$geckox_noasanRelease = map;
                                                        utilsKt$traceTime$1$12 = utilsKt$traceTime$1$1;
                                                        i3 = size4;
                                                        size3 = i15;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        unit = null;
                                                        Result.Companion companion2 = Result.Companion;
                                                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                                                        j = i3;
                                                        if (Result.isSuccess-impl(obj)) {
                                                        }
                                                        th = Result.exceptionOrNull-impl(obj);
                                                        if (th != null) {
                                                        }
                                                        j3 = j + (System.currentTimeMillis() - currentTimeMillis);
                                                        i5 = i13;
                                                        it = it3;
                                                        longValue = j6;
                                                        i4 = size2;
                                                        linkedHashMap2 = linkedHashMap;
                                                        str2 = str;
                                                        i6 = i2;
                                                        tidyUp$geckox_noasanRelease = map;
                                                        utilsKt$traceTime$1$12 = utilsKt$traceTime$1$1;
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    str = str2;
                                                    unit = null;
                                                    Result.Companion companion22 = Result.Companion;
                                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                                    j = i3;
                                                    if (Result.isSuccess-impl(obj)) {
                                                    }
                                                    th = Result.exceptionOrNull-impl(obj);
                                                    if (th != null) {
                                                    }
                                                    j3 = j + (System.currentTimeMillis() - currentTimeMillis);
                                                    i5 = i13;
                                                    it = it3;
                                                    longValue = j6;
                                                    i4 = size2;
                                                    linkedHashMap2 = linkedHashMap;
                                                    str2 = str;
                                                    i6 = i2;
                                                    tidyUp$geckox_noasanRelease = map;
                                                    utilsKt$traceTime$1$12 = utilsKt$traceTime$1$1;
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                linkedHashMap = linkedHashMap2;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            linkedHashMap = linkedHashMap2;
                                            str = str2;
                                            i3 = j3;
                                            unit = null;
                                            Result.Companion companion222 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                            j = i3;
                                            if (Result.isSuccess-impl(obj)) {
                                            }
                                            th = Result.exceptionOrNull-impl(obj);
                                            if (th != null) {
                                            }
                                            j3 = j + (System.currentTimeMillis() - currentTimeMillis);
                                            i5 = i13;
                                            it = it3;
                                            longValue = j6;
                                            i4 = size2;
                                            linkedHashMap2 = linkedHashMap;
                                            str2 = str;
                                            i6 = i2;
                                            tidyUp$geckox_noasanRelease = map;
                                            utilsKt$traceTime$1$12 = utilsKt$traceTime$1$1;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        utilsKt$traceTime$1$1 = utilsKt$traceTime$1$12;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    utilsKt$traceTime$1$1 = utilsKt$traceTime$1$12;
                                    linkedHashMap = linkedHashMap2;
                                    str = str2;
                                    map = tidyUp$geckox_noasanRelease;
                                }
                            }
                            utilsKt$traceTime$1$1 = utilsKt$traceTime$1$12;
                            linkedHashMap = linkedHashMap2;
                            str = str2;
                            map = tidyUp$geckox_noasanRelease;
                            i3 = j3;
                            fileOutputStream = new FileOutputStream(blockRewriteTmp);
                            unit = null;
                            try {
                            } catch (Throwable th8) {
                                th = th8;
                                Result.Companion companion2222 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                                j = i3;
                                if (Result.isSuccess-impl(obj)) {
                                }
                                th = Result.exceptionOrNull-impl(obj);
                                if (th != null) {
                                }
                                j3 = j + (System.currentTimeMillis() - currentTimeMillis);
                                i5 = i13;
                                it = it3;
                                longValue = j6;
                                i4 = size2;
                                linkedHashMap2 = linkedHashMap;
                                str2 = str;
                                i6 = i2;
                                tidyUp$geckox_noasanRelease = map;
                                utilsKt$traceTime$1$12 = utilsKt$traceTime$1$1;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            utilsKt$traceTime$1$1 = utilsKt$traceTime$1$12;
                            linkedHashMap = linkedHashMap2;
                            str = str2;
                            map = tidyUp$geckox_noasanRelease;
                            i2 = i6;
                        }
                        try {
                            SegmentalByteArrayKt.write(fileOutputStream, segmentalByteArray);
                            unit = Unit.INSTANCE;
                            unit = null;
                            CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                            blockBuffer.close();
                            if (backingFile.renameTo(blockBackup)) {
                                if (blockRewriteTmp.renameTo(backingFile)) {
                                    obj = Result.constructor-impl(Boolean.valueOf(blockBackup.delete()));
                                    j = i3;
                                    if (Result.isSuccess-impl(obj)) {
                                        ((Boolean) obj).booleanValue();
                                        GkFSLogger.d$default(logger, "GkFSChunkStorage", "tidy up block " + blockIdentifier.getValue() + " success", 0, false, 12, null);
                                        Unit unit4 = Unit.INSTANCE;
                                    }
                                    th = Result.exceptionOrNull-impl(obj);
                                    if (th != null) {
                                        blockRewriteTmp.delete();
                                        if (!backingFile.exists() && blockBackup.exists()) {
                                            blockBackup.renameTo(backingFile);
                                        }
                                        Iterator it5 = CollectionsKt.withIndex(arrayList2).iterator();
                                        while (it5.hasNext()) {
                                            ChunkIndexingInfo indexingInfo = ((ChunkIndexingTidyUpInfo) arrayList.get(((IndexedValue) it5.next()).getIndex())).getIndexingInfo();
                                            GkFSCombinedChunkIndexing gkFSCombinedChunkIndexing4 = indexing;
                                            if (gkFSCombinedChunkIndexing4 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException(str);
                                            }
                                            gkFSCombinedChunkIndexing4.insertOrCoverBlock$geckox_noasanRelease(indexingInfo.getId(), indexingInfo.getBlockId(), indexingInfo.getBlockInfo());
                                        }
                                        GkFSLogger.e$default(logger, "GkFSChunkStorage", "tidy up block " + blockIdentifier.getValue() + " failed, cause by:" + th.getMessage(), 0, null, false, 28, null);
                                        Unit unit5 = Unit.INSTANCE;
                                    }
                                    j3 = j + (System.currentTimeMillis() - currentTimeMillis);
                                    i5 = i13;
                                    it = it3;
                                    longValue = j6;
                                    i4 = size2;
                                    linkedHashMap2 = linkedHashMap;
                                    str2 = str;
                                    i6 = i2;
                                    tidyUp$geckox_noasanRelease = map;
                                    utilsKt$traceTime$1$12 = utilsKt$traceTime$1$1;
                                } else {
                                    throw new IOException("rename " + blockRewriteTmp + " to block file failed");
                                }
                            } else {
                                throw new IOException("rename " + backingFile + " to backup failed");
                            }
                        } catch (Throwable th10) {
                            unit = null;
                            try {
                                throw th10;
                                break;
                            } catch (Throwable th11) {
                                CloseableKt.closeFinally(fileOutputStream, th10);
                                throw th11;
                            }
                        }
                    }
                    utilsKt$traceTime$1$1 = utilsKt$traceTime$1$12;
                    map = tidyUp$geckox_noasanRelease;
                    i5 = i5;
                    it = it3;
                    longValue = j6;
                    i4 = size2;
                    linkedHashMap2 = linkedHashMap2;
                    str2 = str2;
                    i6 = i6;
                    j3 = j3;
                    tidyUp$geckox_noasanRelease = map;
                    utilsKt$traceTime$1$12 = utilsKt$traceTime$1$1;
                }
                UtilsKt$traceTime$1$1 utilsKt$traceTime$1$13 = utilsKt$traceTime$1$12;
                LinkedHashMap linkedHashMap3 = linkedHashMap2;
                Map<BlockIdentifier, Map<ChunkIdentifier, ChunkIndexingTidyUpInfo>> map3 = tidyUp$geckox_noasanRelease;
                long j7 = longValue;
                long j8 = j3;
                Iterator it6 = linkedHashMap3.values().iterator();
                long j9 = 0;
                while (it6.hasNext()) {
                    j9 += ((Number) it6.next()).longValue();
                }
                long longValue2 = ((Number) utilsKt$traceTime$1$13.invoke()).longValue();
                int size5 = linkedHashMap3.size();
                long size6 = (j9 - ((linkedHashMap3.size() * 13) + (i5 * 46))) + j4;
                Iterator it7 = map3.keySet().iterator();
                long j10 = 0;
                while (it7.hasNext()) {
                    File blockFile2 = GkFSBlockBuffer.INSTANCE.toBlockFile((BlockIdentifier) it7.next());
                    j10 += blockFile2 != null ? blockFile2.length() : 0L;
                }
                return new GkFSChunkTidyInfo(i4, 0L, i6, j7, j8, longValue2, new GkFSGeneralStorageInfo(size5, i7, j5, size6, j9 + j10));
            } finally {
            }
        } else {
            return null;
        }
    }
}
