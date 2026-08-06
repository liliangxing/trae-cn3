package com.bytedance.gkfs;

import android.app.Application;
import android.content.Context;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm6.cpu.collect.ProcessCpuTracer;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.gkfs.cdc.Chunker;
import com.bytedance.gkfs.io.GkFSChunk;
import com.bytedance.gkfs.io.GkFSChunkMeta;
import com.bytedance.gkfs.io.GkFSError;
import com.bytedance.gkfs.io.GkFSFileInputStream;
import com.bytedance.gkfs.io.GkFSFileMeta;
import com.bytedance.gkfs.io.GkFSFileWriter;
import com.bytedance.gkfs.io.GkFSHeaderMeta;
import com.bytedance.gkfs.io.GkFSIOStatistics;
import com.bytedance.gkfs.io.GkFSOutputInfo;
import com.bytedance.gkfs.io.Meta_ioKt;
import com.bytedance.gkfs.storage.GkFSChunkStorage;
import com.bytedance.gkfs.storage.GkFSChunkStorageInfo;
import com.bytedance.gkfs.storage.GkFSChunkTidyInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: GeckoFileSystem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u000fJ\u001e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0011J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010 \u001a\u0004\u0018\u00010!J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0011H\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/gkfs/GeckoFileSystem;", "", "()V", "EXCLUDE_FILES", "", "", "[Ljava/lang/String;", "TAG", "chunker", "Lcom/bytedance/gkfs/cdc/Chunker;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "logger", "Lcom/bytedance/gkfs/GkFSLogger;", "delete", "", DBHelper.BATTERY_COL_SOURCE, "Ljava/io/File;", "deleteSingleFile", "file", "init", "", "context", "Landroid/content/Context;", "isInitialized", "printStatistics", "outputsInfo", "", "Lcom/bytedance/gkfs/io/GkFSOutputInfo;", "read", "Ljava/io/FileInputStream;", "store", "tidyUp", "Lcom/bytedance/gkfs/storage/GkFSChunkTidyInfo;", "transferSingleFile", "majorFile", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoFileSystem {
    private static final String TAG = "GeckoFileSystem";
    public static final GeckoFileSystem INSTANCE = new GeckoFileSystem();
    private static final String[] EXCLUDE_FILES = {".so", ".dex", Meta_ioKt.GKFS_FILE_EXTENSION};
    private static final Chunker chunker = new Chunker();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final GkFSLogger logger = new GkFSLogger();

    private GeckoFileSystem() {
    }

    public final void init(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (initialized.compareAndSet(false, true)) {
            GkFSChunkStorage gkFSChunkStorage = GkFSChunkStorage.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
            }
            gkFSChunkStorage.init((Application) applicationContext);
            GkFSExecutor.INSTANCE.warmup$geckox_noasanRelease();
            GkFSUtils.INSTANCE.cleanOldExperiments(new Function0<Unit>() { // from class: com.bytedance.gkfs.GeckoFileSystem$init$1
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m554invoke() {
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m554invoke();
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final boolean isInitialized() {
        return initialized.get();
    }

    public final List<GkFSOutputInfo> store(File source) {
        Intrinsics.checkParameterIsNotNull(source, DBHelper.BATTERY_COL_SOURCE);
        if (!UtilsKt.isMainProcess()) {
            GkFSLogger.d$default(logger, TAG, "invoke store in sub-process, skip", 0, true, 4, null);
            return CollectionsKt.emptyList();
        }
        if (!initialized.get()) {
            GkFSLogger.w$default(logger, TAG, "invoke store without init", 0, null, false, 28, null);
            return CollectionsKt.emptyList();
        }
        if (!source.exists()) {
            GkFSReporter.INSTANCE.reportFileStoreStats$geckox_noasanRelease(GkFSOutputInfo.INSTANCE.error(source, new File(""), new IOException(source + " not exists"), GkFSError.CHUNK_WRITE_ERROR));
            return CollectionsKt.emptyList();
        }
        if (UtilsKt.getDebuggable()) {
            UtilsKt.showToast("开始迁移" + source + " 到GkFS");
        }
        final ArrayList arrayList = new ArrayList();
        UtilsKt.traversalSingleFiles(source, new Function1<File, Unit>() { // from class: com.bytedance.gkfs.GeckoFileSystem$store$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((File) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(File file) {
                GkFSLogger gkFSLogger;
                final GkFSOutputInfo error;
                GkFSLogger gkFSLogger2;
                GkFSLogger gkFSLogger3;
                GkFSLogger gkFSLogger4;
                String[] strArr;
                Intrinsics.checkParameterIsNotNull(file, "file");
                File file2 = new File(file.getParent(), file.getName() + Meta_ioKt.GKFS_FILE_EXTENSION);
                try {
                    GeckoFileSystem geckoFileSystem = GeckoFileSystem.INSTANCE;
                    gkFSLogger3 = GeckoFileSystem.logger;
                    GeckoFileSystem geckoFileSystem2 = GeckoFileSystem.INSTANCE;
                    gkFSLogger4 = GeckoFileSystem.logger;
                    gkFSLogger3.m304d("GeckoFileSystem", "start to transfer from " + file, gkFSLogger4.getCounter().incrementAndGet(), true);
                    GeckoFileSystem geckoFileSystem3 = GeckoFileSystem.INSTANCE;
                    strArr = GeckoFileSystem.EXCLUDE_FILES;
                } catch (Throwable th) {
                    GeckoFileSystem geckoFileSystem4 = GeckoFileSystem.INSTANCE;
                    gkFSLogger = GeckoFileSystem.logger;
                    GkFSLogger.e$default(gkFSLogger, "GeckoFileSystem", "error occur in transfer " + file + ": " + th.getMessage(), 0, th, true, 4, null);
                    error = GkFSOutputInfo.INSTANCE.error(file, file2, th, GkFSError.STORE_GENERIC_ERROR);
                }
                if (ArraysKt.contains(strArr, "." + FilesKt.getExtension(file))) {
                    throw new IllegalStateException("." + FilesKt.getExtension(file) + " in exclude list!");
                }
                if (file.exists()) {
                    error = GeckoFileSystem.INSTANCE.transferSingleFile(file, file2);
                    arrayList.add(error);
                    boolean z = error.getCdcStatistics().getStatus().isSuccess() && error.getStoreStatistics().getStatus().isSuccess();
                    if (!z) {
                        file2.delete();
                    }
                    GeckoFileSystem geckoFileSystem5 = GeckoFileSystem.INSTANCE;
                    gkFSLogger2 = GeckoFileSystem.logger;
                    GkFSLogger.d$default(gkFSLogger2, "GeckoFileSystem", "finish transferring " + error.getOriginFile().getAbsolutePath() + ", result=" + z, 0, true, 4, null);
                    GkFSExecutor.sequence(new Runnable() { // from class: com.bytedance.gkfs.GeckoFileSystem$store$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            GkFSReporter.INSTANCE.reportFileStoreStats$geckox_noasanRelease(GkFSOutputInfo.this);
                        }
                    });
                    return;
                }
                throw new IOException("origin file not exists");
            }
        });
        printStatistics(source, arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GkFSOutputInfo transferSingleFile(File source, File majorFile) {
        Chunker.GkFSCDCInfo chunkFile = chunker.chunkFile(source);
        if (!chunkFile.getStatistics().getStatus().isSuccess()) {
            GkFSLogger gkFSLogger = logger;
            StringBuilder append = new StringBuilder("cdc error on ").append(majorFile).append(" transferring, cause ");
            Throwable error = chunkFile.getStatistics().getStatus().getError();
            GkFSLogger.e$default(gkFSLogger, TAG, append.append(error != null ? error.getMessage() : null).toString(), 0, null, chunkFile.getStatistics().getStatus().getErrorCode() != GkFSError.TINY_FILE, 12, null);
            return new GkFSOutputInfo(new GkFSFileMeta(majorFile, new GkFSHeaderMeta(1, 0L, 0L, 6, null), CollectionsKt.emptyList()), source, chunkFile.getStatistics(), new GkFSIOStatistics(null, 0L, 0L, null, 0L, 0L, 0L, 0L, ProcessCpuTracer.PROC_TERM_MASK, null));
        }
        GkFSFileWriter gkFSFileWriter = new GkFSFileWriter(source, majorFile, chunkFile);
        GkFSIOStatistics write = gkFSFileWriter.write();
        if (!write.getStatus().isSuccess() || Intrinsics.areEqual(gkFSFileWriter.getHeaderMeta(), GkFSHeaderMeta.INSTANCE.getEMPTY())) {
            GkFSLogger gkFSLogger2 = logger;
            StringBuilder append2 = new StringBuilder("write error on ").append(majorFile).append(" transferring, write error=");
            Throwable error2 = write.getStatus().getError();
            GkFSLogger.e$default(gkFSLogger2, TAG, append2.append(error2 != null ? error2.getMessage() : null).append(", headerMeta is empty:").append(gkFSFileWriter.getHeaderMeta() == GkFSHeaderMeta.INSTANCE.getEMPTY()).toString(), 0, null, false, 28, null);
            return new GkFSOutputInfo(new GkFSFileMeta(majorFile, gkFSFileWriter.getHeaderMeta(), CollectionsKt.emptyList()), source, chunkFile.getStatistics(), write);
        }
        Iterable<IndexedValue> withIndex = CollectionsKt.withIndex(chunkFile.getChunks());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(withIndex, 10));
        for (IndexedValue indexedValue : withIndex) {
            GkFSChunkMeta gkFSChunkMeta = new GkFSChunkMeta(((Chunker.GkFSCDCChunkInfo) indexedValue.getValue()).getId(), ((Chunker.GkFSCDCChunkInfo) indexedValue.getValue()).getFrom());
            GkFSChunkStorageInfo gkFSChunkStorageInfo = write.getChunkStatistics().getStorageCost().get(((Chunker.GkFSCDCChunkInfo) indexedValue.getValue()).getId());
            if (gkFSChunkStorageInfo == null) {
                Intrinsics.throwNpe();
            }
            arrayList.add(new GkFSChunk(gkFSChunkMeta, gkFSChunkStorageInfo));
        }
        return new GkFSOutputInfo(new GkFSFileMeta(majorFile, gkFSFileWriter.getHeaderMeta(), arrayList), source, chunkFile.getStatistics(), write);
    }

    public final FileInputStream read(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        if (!initialized.get()) {
            String str = "try to read gkfs file:" + file + " without init";
            GkFSLogger.w$default(logger, TAG, str, 0, null, false, 28, null);
            throw new RuntimeException(str);
        }
        return new GkFSFileInputStream(file);
    }

    public final boolean delete(File source) {
        Intrinsics.checkParameterIsNotNull(source, DBHelper.BATTERY_COL_SOURCE);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        UtilsKt.traversalSingleFiles(source, new Function1<File, Unit>() { // from class: com.bytedance.gkfs.GeckoFileSystem$delete$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((File) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(File file) {
                boolean deleteSingleFile;
                Intrinsics.checkParameterIsNotNull(file, "file");
                Ref.BooleanRef booleanRef2 = booleanRef;
                boolean z = booleanRef2.element;
                deleteSingleFile = GeckoFileSystem.INSTANCE.deleteSingleFile(file);
                booleanRef2.element = deleteSingleFile & z;
            }
        });
        booleanRef.element = source.delete() & booleanRef.element;
        return booleanRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean deleteSingleFile(File file) {
        Object obj;
        String name;
        try {
            Result.Companion companion = Result.Companion;
            name = file.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "file.name");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (!StringsKt.endsWith$default(name, Meta_ioKt.GKFS_FILE_EXTENSION, false, 2, (Object) null)) {
            return file.delete();
        }
        if (!initialized.get()) {
            throw new RuntimeException("try to delete gkfs file:" + file + " without init");
        }
        if (file.exists()) {
            boolean delete = file.delete();
            if (delete) {
                obj = Result.constructor-impl(Boolean.valueOf(delete));
                Throwable th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null) {
                    GkFSLogger gkFSLogger = logger;
                    GkFSLogger.w$default(gkFSLogger, TAG, "delete " + file + " failed, " + th2.getMessage(), gkFSLogger.getCounter().incrementAndGet(), null, false, 24, null);
                    th2.printStackTrace();
                }
                if (Result.isSuccess-impl(obj)) {
                    ((Boolean) obj).booleanValue();
                    GkFSLogger gkFSLogger2 = logger;
                    GkFSLogger.d$default(gkFSLogger2, TAG, "delete " + file + " success", gkFSLogger2.getCounter().incrementAndGet(), false, 8, null);
                }
                return Result.isSuccess-impl(obj);
            }
            throw new IOException("invoke delete() return false");
        }
        throw new IOException("file not exists");
    }

    public final GkFSChunkTidyInfo tidyUp() throws Throwable {
        Object obj;
        if (!initialized.get()) {
            GkFSLogger.w$default(logger, TAG, "invoke tidyUp without init", 0, null, false, 28, null);
            return null;
        }
        if (!UtilsKt.isMainProcess()) {
            GkFSLogger.d$default(logger, TAG, "invoke tidyUp in sub-process, skip", 0, true, 4, null);
            return null;
        }
        GkFSLogger.d$default(logger, TAG, "start tidy up GkFS storage", 0, true, 4, null);
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(GkFSChunkStorage.INSTANCE.tidyUp());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            GkFSLogger.e$default(logger, TAG, "tidy up failed, cause by " + th2, 0, th2, false, 20, null);
        }
        ResultKt.throwOnFailure(obj);
        return (GkFSChunkTidyInfo) obj;
    }

    private final void printStatistics(File source, List<GkFSOutputInfo> outputsInfo) {
        GkFSLogger gkFSLogger = logger;
        GkFSLogger.d$default(gkFSLogger, TAG, "finish storing " + source, gkFSLogger.getCounter().getAndIncrement(), false, 8, null);
        if (UtilsKt.getDebuggable()) {
            UtilsKt.showToast("迁移GkFS完成:" + source);
            StringBuilder sb = new StringBuilder("chunk size:");
            List<GkFSOutputInfo> list = outputsInfo;
            Iterator<T> it = list.iterator();
            long j = 0;
            long j2 = 0;
            while (it.hasNext()) {
                long j3 = 0;
                while (((GkFSOutputInfo) it.next()).getMeta().getChunks().iterator().hasNext()) {
                    j3 += ((GkFSChunk) r5.next()).getStorageInfo().getSize();
                }
                j2 += j3;
            }
            StringBuilder append = sb.append(j2).append("\ncdcCost:");
            Iterator<T> it2 = list.iterator();
            long j4 = 0;
            while (it2.hasNext()) {
                Iterator<T> it3 = ((GkFSOutputInfo) it2.next()).getCdcStatistics().getChunkCDCTimeCost().values().iterator();
                long j5 = 0;
                while (it3.hasNext()) {
                    j5 += ((Number) it3.next()).longValue();
                }
                j4 += j5;
            }
            StringBuilder append2 = append.append(j4).append("\ncdcTotalCost:");
            Iterator<T> it4 = list.iterator();
            long j6 = 0;
            while (it4.hasNext()) {
                j6 += ((GkFSOutputInfo) it4.next()).getCdcStatistics().getTotalTimeCost();
            }
            StringBuilder append3 = append2.append(j6).append("\ntotalSize:");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it5 = list.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                GkFSOutputInfo gkFSOutputInfo = (GkFSOutputInfo) next;
                if (gkFSOutputInfo.getCdcStatistics().getStatus().isSuccess() && gkFSOutputInfo.getStoreStatistics().getStatus().isSuccess()) {
                    arrayList.add(next);
                }
            }
            Iterator it6 = arrayList.iterator();
            long j7 = 0;
            while (it6.hasNext()) {
                j7 += ((GkFSOutputInfo) it6.next()).getStoreStatistics().getFileSize();
            }
            StringBuilder append4 = append3.append(j7).append("\ntotalTimeCost:");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                GkFSOutputInfo gkFSOutputInfo2 = (GkFSOutputInfo) obj;
                if (gkFSOutputInfo2.getCdcStatistics().getStatus().isSuccess() && gkFSOutputInfo2.getStoreStatistics().getStatus().isSuccess()) {
                    arrayList2.add(obj);
                }
            }
            Iterator it7 = arrayList2.iterator();
            while (it7.hasNext()) {
                j += ((GkFSOutputInfo) it7.next()).getStoreStatistics().getTotalTimeCost();
            }
            GkFSLogger.d$default(logger, TAG, "performance=" + append4.append(j).toString(), 0, false, 12, null);
        }
    }
}
