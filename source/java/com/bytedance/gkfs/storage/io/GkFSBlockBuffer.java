package com.bytedance.gkfs.storage.io;

import android.content.Context;
import android.util.LruCache;
import com.bytedance.applog.server.Api;
import com.bytedance.bdturing.EventReport;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.gkfs.GkFSLogger;
import com.bytedance.gkfs.io.BlockIdentifier;
import com.bytedance.gkfs.storage.io.GkFSBlockBuffer;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: GkFSBlockBuffer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u000e\b\u0000\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u001c\u001a\u00020\bJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0004J\b\u0010 \u001a\u00020\u001eH\u0016J\r\u0010!\u001a\u00020\bH\u0000¢\u0006\u0002\b\"J\u0019\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\bH\u0082 J)\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010$\u001a\u00020%2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0082 J\u0019\u0010+\u001a\u00020,2\u0006\u0010(\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0082 J1\u0010-\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020,H\u0082 J\u0019\u00103\u001a\u00020,2\u0006\u0010(\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0082 J1\u00104\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\b2\u0006\u00105\u001a\u00020\b2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020,H\u0082 J\u000e\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020,J&\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u0002002\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020,J\b\u0010;\u001a\u00020%H\u0016J\u001e\u0010<\u001a\u00020\u001e2\u0006\u0010:\u001a\u0002002\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020,R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\b\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/bytedance/gkfs/storage/io/GkFSBlockBuffer;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "id", "Lcom/bytedance/gkfs/io/BlockIdentifier;", "backingFile", "Ljava/io/File;", "initSize", "", "limit", "(Lcom/bytedance/gkfs/io/BlockIdentifier;Ljava/io/File;JJ)V", "getBackingFile", "()Ljava/io/File;", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getId", "()Lcom/bytedance/gkfs/io/BlockIdentifier;", "getLimit$geckox_noasanRelease", "()J", "logger", "Lcom/bytedance/gkfs/GkFSLogger;", "logger$1", "mmapLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "mmapSize", "nPtr", "posLock", "writePos", "available", EventReport.DIALOG_CLOSE, "", "finalize", "flush", "getAvailableWritePos", "getAvailableWritePos$geckox_noasanRelease", "nCreate", "path", "", "length", "nExtend", "ptr", "oldSize", "toSize", "nFlush", "", "nRead", "cursor", "bytes", "", "off", "len", "nRelease", "nWrite", "offset", "prepareToWrite", "size", "read", "start", "b", "toString", "write", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GkFSBlockBuffer implements Closeable, Flushable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "GkFSBlockBuffer";
    private static final GkFSBlockBuffer$Companion$bufferCache$1 bufferCache;
    private static final ReentrantReadWriteLock cacheLock;
    private static final GkFSLogger logger;
    private static BlockIdentifier maxBlockId;
    private static File rootDir;
    private final File backingFile;
    private final AtomicBoolean closed;
    private final BlockIdentifier id;
    private final long limit;

    /* renamed from: logger$1, reason: from kotlin metadata */
    private final GkFSLogger logger;
    private final ReentrantReadWriteLock mmapLock;
    private long mmapSize;
    private long nPtr;
    private final ReentrantReadWriteLock posLock;
    private long writePos;

    private final native long nCreate(String path, long length) throws IOException;

    private final native long nExtend(long ptr, String path, long oldSize, long toSize) throws IOException;

    private final native int nFlush(long ptr, long length) throws IOException;

    private final native void nRead(long ptr, long cursor, byte[] bytes, int off, int len);

    private final native int nRelease(long ptr, long length);

    private final native void nWrite(long ptr, long offset, byte[] bytes, int off, int len);

    private GkFSBlockBuffer(BlockIdentifier blockIdentifier, File file, long j, long j2) {
        Object obj;
        this.id = blockIdentifier;
        this.backingFile = file;
        this.limit = j2;
        this.writePos = file.length();
        this.posLock = new ReentrantReadWriteLock();
        try {
            Result.Companion companion = Result.Companion;
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "backingFile.absolutePath");
            obj = Result.constructor-impl(Long.valueOf(nCreate(absolutePath, j)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            throw new IOException("mmap failed:[blockId:" + this.id + ", initSize:" + j + ", backingFile=" + this.backingFile + ']');
        }
        ResultKt.throwOnFailure(obj);
        this.nPtr = ((Number) obj).longValue();
        this.mmapLock = new ReentrantReadWriteLock();
        this.closed = new AtomicBoolean(false);
        this.mmapSize = j;
        GkFSLogger gkFSLogger = new GkFSLogger();
        this.logger = gkFSLogger;
        GkFSLogger.d$default(gkFSLogger, TAG, "create buffer:[blockId:" + this.id + ", initSize:" + j + ", backingFile=" + this.backingFile + ']', 0, false, 12, null);
    }

    public /* synthetic */ GkFSBlockBuffer(BlockIdentifier blockIdentifier, File file, long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(blockIdentifier, file, j, j2);
    }

    public final BlockIdentifier getId() {
        return this.id;
    }

    public final File getBackingFile() {
        return this.backingFile;
    }

    /* synthetic */ GkFSBlockBuffer(BlockIdentifier blockIdentifier, File file, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(blockIdentifier, file, (i & 4) != 0 ? file.length() : j, j2);
    }

    /* renamed from: getLimit$geckox_noasanRelease, reason: from getter */
    public final long getLimit() {
        return this.limit;
    }

    /* compiled from: GkFSBlockBuffer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001-B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\rJ\u0011\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0019¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!J\u0017\u0010\"\u001a\u0004\u0018\u00010\u00162\u0006\u0010#\u001a\u00020\rH\u0000¢\u0006\u0002\b$J\u0018\u0010%\u001a\n '*\u0004\u0018\u00010&0&2\u0006\u0010(\u001a\u00020\u0016H\u0002J\n\u0010)\u001a\u00020\u000f*\u00020\u000fJ\f\u0010*\u001a\u00020\r*\u00020\u000fH\u0002J\n\u0010+\u001a\u00020\u000f*\u00020\u000fJ\f\u0010,\u001a\u0004\u0018\u00010\u000f*\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006."}, d2 = {"Lcom/bytedance/gkfs/storage/io/GkFSBlockBuffer$Companion;", "", "()V", "TAG", "", "bufferCache", "com/bytedance/gkfs/storage/io/GkFSBlockBuffer$Companion$bufferCache$1", "Lcom/bytedance/gkfs/storage/io/GkFSBlockBuffer$Companion$bufferCache$1;", "cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "logger", "Lcom/bytedance/gkfs/GkFSLogger;", "maxBlockId", "Lcom/bytedance/gkfs/io/BlockIdentifier;", "<set-?>", "Ljava/io/File;", "rootDir", "getRootDir$geckox_noasanRelease", "()Ljava/io/File;", "setRootDir", "(Ljava/io/File;)V", "getBlockBuffer", "Lcom/bytedance/gkfs/storage/io/GkFSBlockBuffer;", "id", "getExistBlocks", "", "()[Lcom/bytedance/gkfs/io/BlockIdentifier;", "init", "", "context", "Landroid/content/Context;", "obtainBlockBuffer", "writeSize", "", "removeCache", Api.KEY_ENCRYPT_RESP_KEY, "removeCache$geckox_noasanRelease", "updateCache", "Lcom/bytedance/gkfs/storage/io/GkFSBlockBuffer$Companion$CacheItem;", "kotlin.jvm.PlatformType", "buffer", "getBlockBackup", "getBlockId", "getBlockRewriteTmp", "toBlockFile", "CacheItem", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void setRootDir(File file) {
            GkFSBlockBuffer.rootDir = file;
        }

        public final File getRootDir$geckox_noasanRelease() {
            File file = GkFSBlockBuffer.rootDir;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootDir");
            }
            return file;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: GkFSBlockBuffer.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/gkfs/storage/io/GkFSBlockBuffer$Companion$CacheItem;", "", "buffer", "Lcom/bytedance/gkfs/storage/io/GkFSBlockBuffer;", "(Lcom/bytedance/gkfs/storage/io/GkFSBlockBuffer;)V", "getBuffer", "()Lcom/bytedance/gkfs/storage/io/GkFSBlockBuffer;", "size", "", "getSize", "()J", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static final /* data */ class CacheItem {
            private final GkFSBlockBuffer buffer;
            private final long size;

            public static /* synthetic */ CacheItem copy$default(CacheItem cacheItem, GkFSBlockBuffer gkFSBlockBuffer, int i, Object obj) {
                if ((i & 1) != 0) {
                    gkFSBlockBuffer = cacheItem.buffer;
                }
                return cacheItem.copy(gkFSBlockBuffer);
            }

            /* renamed from: component1, reason: from getter */
            public final GkFSBlockBuffer getBuffer() {
                return this.buffer;
            }

            public final CacheItem copy(GkFSBlockBuffer buffer) {
                Intrinsics.checkParameterIsNotNull(buffer, "buffer");
                return new CacheItem(buffer);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof CacheItem) && Intrinsics.areEqual(this.buffer, ((CacheItem) other).buffer);
                }
                return true;
            }

            public int hashCode() {
                GkFSBlockBuffer gkFSBlockBuffer = this.buffer;
                if (gkFSBlockBuffer != null) {
                    return gkFSBlockBuffer.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "CacheItem(buffer=" + this.buffer + ")";
            }

            public CacheItem(GkFSBlockBuffer gkFSBlockBuffer) {
                Intrinsics.checkParameterIsNotNull(gkFSBlockBuffer, "buffer");
                this.buffer = gkFSBlockBuffer;
                this.size = gkFSBlockBuffer.writePos;
            }

            public final GkFSBlockBuffer getBuffer() {
                return this.buffer;
            }

            public final long getSize() {
                return this.size;
            }
        }

        public final void init(Context context) {
            File file;
            BlockIdentifier no_id;
            Intrinsics.checkParameterIsNotNull(context, "context");
            File file2 = new File(context.getFilesDir(), "gkfs_chunk");
            file2.mkdirs();
            setRootDir(file2);
            File[] listFiles = getRootDir$geckox_noasanRelease().listFiles(new FileFilter() { // from class: com.bytedance.gkfs.storage.io.GkFSBlockBuffer$Companion$init$2
                @Override // java.io.FileFilter
                public final boolean accept(File file3) {
                    BlockIdentifier blockId;
                    Intrinsics.checkExpressionValueIsNotNull(file3, "file");
                    String name = file3.getName();
                    Intrinsics.checkExpressionValueIsNotNull(name, "file.name");
                    if (StringsKt.endsWith$default(name, "-rewriting", false, 2, (Object) null)) {
                        file3.delete();
                        return false;
                    }
                    String name2 = file3.getName();
                    Intrinsics.checkExpressionValueIsNotNull(name2, "file.name");
                    if (StringsKt.endsWith$default(name2, "-backup", false, 2, (Object) null)) {
                        blockId = GkFSBlockBuffer.INSTANCE.getBlockId(file3);
                        if (Intrinsics.areEqual(blockId, BlockIdentifier.INSTANCE.getNO_ID())) {
                            file3.delete();
                            return false;
                        }
                        File blockFile = GkFSBlockBuffer.INSTANCE.toBlockFile(blockId);
                        if (blockFile == null) {
                            Intrinsics.throwNpe();
                        }
                        if (blockFile.exists()) {
                            file3.delete();
                            return false;
                        }
                        String absolutePath = file3.getAbsolutePath();
                        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
                        file3.renameTo(new File(StringsKt.removeSuffix(absolutePath, "-backup")));
                        return true;
                    }
                    return Intrinsics.areEqual(FilesKt.getExtension(file3), GkFSBlockBufferKt.BLOCK_EXT);
                }
            });
            Intrinsics.checkExpressionValueIsNotNull(listFiles, "rootDir.listFiles { file…          }\n            }");
            int i = 1;
            if (listFiles.length == 0) {
                file = null;
            } else {
                File file3 = listFiles[0];
                int lastIndex = ArraysKt.getLastIndex(listFiles);
                if (lastIndex != 0) {
                    Companion companion = GkFSBlockBuffer.INSTANCE;
                    Intrinsics.checkExpressionValueIsNotNull(file3, "file");
                    int value = companion.getBlockId(file3).getValue();
                    if (1 <= lastIndex) {
                        while (true) {
                            File file4 = listFiles[i];
                            Companion companion2 = GkFSBlockBuffer.INSTANCE;
                            Intrinsics.checkExpressionValueIsNotNull(file4, "file");
                            int value2 = companion2.getBlockId(file4).getValue();
                            if (value < value2) {
                                file3 = file4;
                                value = value2;
                            }
                            if (i == lastIndex) {
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                }
                file = file3;
            }
            if (file == null || (no_id = getBlockId(file)) == null) {
                no_id = BlockIdentifier.INSTANCE.getNO_ID();
            }
            GkFSBlockBuffer.maxBlockId = no_id;
        }

        public final GkFSBlockBuffer removeCache$geckox_noasanRelease(BlockIdentifier key) {
            Intrinsics.checkParameterIsNotNull(key, Api.KEY_ENCRYPT_RESP_KEY);
            ReentrantReadWriteLock reentrantReadWriteLock = GkFSBlockBuffer.cacheLock;
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
            int i = 0;
            int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
            for (int i2 = 0; i2 < readHoldCount; i2++) {
                readLock.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                CacheItem remove = GkFSBlockBuffer.bufferCache.remove(key);
                return remove != null ? remove.getBuffer() : null;
            } finally {
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final CacheItem updateCache(GkFSBlockBuffer buffer) {
            ReentrantReadWriteLock reentrantReadWriteLock = GkFSBlockBuffer.cacheLock;
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
            int i = 0;
            int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
            for (int i2 = 0; i2 < readHoldCount; i2++) {
                readLock.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                return GkFSBlockBuffer.bufferCache.put(buffer.getId(), new CacheItem(buffer));
            } finally {
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
            }
        }

        public final GkFSBlockBuffer getBlockBuffer(BlockIdentifier id) throws IOException {
            GkFSBlockBuffer gkFSBlockBuffer;
            Intrinsics.checkParameterIsNotNull(id, "id");
            ReentrantReadWriteLock reentrantReadWriteLock = GkFSBlockBuffer.cacheLock;
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
            int i = 0;
            int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
            for (int i2 = 0; i2 < readHoldCount; i2++) {
                readLock.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                File blockFile = GkFSBlockBuffer.INSTANCE.toBlockFile(id);
                if (blockFile == null) {
                    while (i < readHoldCount) {
                        readLock.lock();
                        i++;
                    }
                    writeLock.unlock();
                    return null;
                }
                if (!blockFile.isFile()) {
                    GkFSBlockBuffer.bufferCache.remove(id);
                    return null;
                }
                CacheItem cacheItem = GkFSBlockBuffer.bufferCache.get(id);
                if (cacheItem == null || (gkFSBlockBuffer = cacheItem.getBuffer()) == null) {
                    gkFSBlockBuffer = new GkFSBlockBuffer(id, blockFile, 0L, 8388608L, 4, null);
                    GkFSBlockBuffer.bufferCache.put(id, new CacheItem(gkFSBlockBuffer));
                }
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
                return gkFSBlockBuffer;
            } finally {
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
            }
        }

        public final GkFSBlockBuffer obtainBlockBuffer(int writeSize) throws IOException {
            GkFSBlockBuffer gkFSBlockBuffer;
            ReentrantReadWriteLock reentrantReadWriteLock = GkFSBlockBuffer.cacheLock;
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
            int i = 0;
            int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
            for (int i2 = 0; i2 < readHoldCount; i2++) {
                readLock.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                BlockIdentifier blockIdentifier = GkFSBlockBuffer.maxBlockId;
                if (blockIdentifier == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("maxBlockId");
                }
                int value = blockIdentifier.getValue();
                if (value >= 0) {
                    int i3 = 0;
                    while (true) {
                        BlockIdentifier blockIdentifier2 = new BlockIdentifier(i3);
                        gkFSBlockBuffer = GkFSBlockBuffer.INSTANCE.getBlockBuffer(blockIdentifier2);
                        if (gkFSBlockBuffer != null) {
                            if (gkFSBlockBuffer.available() >= writeSize) {
                                break;
                            }
                            if (i3 == value) {
                                break;
                            }
                            i3++;
                        } else {
                            File blockFile = GkFSBlockBuffer.INSTANCE.toBlockFile(blockIdentifier2);
                            if (blockFile == null) {
                                Intrinsics.throwNpe();
                            }
                            if (!blockFile.createNewFile()) {
                                throw new IOException("can not create block file " + blockFile);
                            }
                            GkFSBlockBuffer gkFSBlockBuffer2 = new GkFSBlockBuffer(blockIdentifier2, blockFile, writeSize, 8388608L, null);
                            GkFSBlockBuffer.bufferCache.put(blockIdentifier2, new CacheItem(gkFSBlockBuffer2));
                            gkFSBlockBuffer = gkFSBlockBuffer2;
                        }
                    }
                }
                BlockIdentifier blockIdentifier3 = GkFSBlockBuffer.maxBlockId;
                if (blockIdentifier3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("maxBlockId");
                }
                BlockIdentifier blockIdentifier4 = new BlockIdentifier(blockIdentifier3.getValue() + 1);
                File blockFile2 = GkFSBlockBuffer.INSTANCE.toBlockFile(blockIdentifier4);
                if (blockFile2 == null) {
                    Intrinsics.throwNpe();
                }
                if (!blockFile2.createNewFile()) {
                    throw new IOException("can not create block file " + blockFile2);
                }
                GkFSBlockBuffer gkFSBlockBuffer3 = new GkFSBlockBuffer(blockIdentifier4, blockFile2, writeSize, 8388608L, null);
                GkFSBlockBuffer.maxBlockId = blockIdentifier4;
                GkFSBlockBuffer.bufferCache.put(blockIdentifier4, new CacheItem(gkFSBlockBuffer3));
                gkFSBlockBuffer = gkFSBlockBuffer3;
                return gkFSBlockBuffer;
            } finally {
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0066, code lost:
        
            if (r4.exists() == true) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final BlockIdentifier[] getExistBlocks() {
            BlockIdentifier blockIdentifier = GkFSBlockBuffer.maxBlockId;
            if (blockIdentifier == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxBlockId");
            }
            Iterable downTo = RangesKt.downTo(blockIdentifier.getValue(), 0);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(downTo, 10));
            IntIterator it = downTo.iterator();
            while (it.hasNext()) {
                arrayList.add(new BlockIdentifier(it.nextInt()));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                File blockFile = GkFSBlockBuffer.INSTANCE.toBlockFile((BlockIdentifier) obj);
                boolean z = blockFile != null;
                if (z) {
                    arrayList2.add(obj);
                }
            }
            Object[] array = arrayList2.toArray(new BlockIdentifier[0]);
            if (array != null) {
                return (BlockIdentifier[]) array;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BlockIdentifier getBlockId(File file) {
            String name = file.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "it");
            int indexOf$default = StringsKt.indexOf$default(name, ".", 0, false, 6, (Object) null);
            if (name == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = name.substring(0, indexOf$default);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Integer intOrNull = StringsKt.toIntOrNull(substring);
            return intOrNull != null ? new BlockIdentifier(intOrNull.intValue()) : BlockIdentifier.INSTANCE.getNO_ID();
        }

        public final File toBlockFile(BlockIdentifier blockIdentifier) {
            Intrinsics.checkParameterIsNotNull(blockIdentifier, "$this$toBlockFile");
            if (Intrinsics.areEqual(blockIdentifier, BlockIdentifier.INSTANCE.getNO_ID())) {
                return null;
            }
            return new File(getRootDir$geckox_noasanRelease(), blockIdentifier.getValue() + ".gkfsb");
        }

        public final File getBlockBackup(File file) {
            Intrinsics.checkParameterIsNotNull(file, "$this$getBlockBackup");
            return new File(file.getAbsolutePath() + "-backup");
        }

        public final File getBlockRewriteTmp(File file) {
            Intrinsics.checkParameterIsNotNull(file, "$this$getBlockRewriteTmp");
            return new File(file.getAbsolutePath() + "-rewriting");
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.gkfs.storage.io.GkFSBlockBuffer$Companion$bufferCache$1] */
    static {
        try {
            Result.Companion companion = Result.Companion;
            System.loadLibrary("gkfs");
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        logger = new GkFSLogger();
        cacheLock = new ReentrantReadWriteLock();
        final int i = 83886080;
        bufferCache = new LruCache<BlockIdentifier, Companion.CacheItem>(i) { // from class: com.bytedance.gkfs.storage.io.GkFSBlockBuffer$Companion$bufferCache$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public void entryRemoved(boolean evicted, BlockIdentifier key, GkFSBlockBuffer.Companion.CacheItem oldValue, GkFSBlockBuffer.Companion.CacheItem newValue) {
                GkFSLogger gkFSLogger;
                super.entryRemoved(evicted, (boolean) key, oldValue, newValue);
                gkFSLogger = GkFSBlockBuffer.logger;
                GkFSLogger.d$default(gkFSLogger, "GkFSBlockBuffer", (key != null ? Integer.valueOf(key.getValue()) : null) + " removed from buffer-cache, evicted:" + evicted + ", newValue=" + (newValue != null ? newValue.getBuffer() : null), 0, false, 12, null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(BlockIdentifier key, GkFSBlockBuffer.Companion.CacheItem value) {
                if (value != null) {
                    return (int) value.getSize();
                }
                return 1;
            }
        };
    }

    public final long getAvailableWritePos$geckox_noasanRelease() {
        ReentrantReadWriteLock.ReadLock readLock = this.posLock.readLock();
        readLock.lock();
        try {
            return this.writePos;
        } finally {
            readLock.unlock();
        }
    }

    public final int read(long start, byte[] b, int off, int len) {
        Intrinsics.checkParameterIsNotNull(b, "b");
        if (this.closed.get()) {
            throw new IOException("buffer " + this.id.getValue() + " closed");
        }
        if (off < 0 || len < 0 || len > b.length - off) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return 0;
        }
        ReentrantReadWriteLock.ReadLock readLock = this.posLock.readLock();
        readLock.lock();
        try {
            long j = this.writePos;
            readLock.unlock();
            long j2 = j - start;
            if (j2 <= 0) {
                GkFSLogger.d$default(this.logger, TAG, "no available bytes from " + start + " of block " + this.id.getValue() + " can be read, writePos=" + j, 0, false, 12, null);
                return -1;
            }
            int min = Math.min(len, (int) j2);
            readLock = this.mmapLock.readLock();
            readLock.lock();
            try {
                Long valueOf = Long.valueOf(this.nPtr);
                readLock.unlock();
                if (!(valueOf.longValue() != 0)) {
                    valueOf = null;
                }
                if (valueOf == null) {
                    throw new IOException("can not read bytes from buffer " + this.id.getValue() + ", ptr=0");
                }
                nRead(valueOf.longValue(), start, b, off, min);
                return min;
            } finally {
            }
        } finally {
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void write(byte[] b, int off, int len) {
        int i;
        Intrinsics.checkParameterIsNotNull(b, "b");
        if (this.closed.get()) {
            throw new IOException("buffer " + this.id.getValue() + " closed");
        }
        if (off < 0 || off > b.length || len < 0 || (i = off + len) > b.length || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = this.posLock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            if (this.nPtr == 0) {
                throw new IOException("can not read bytes from buffer " + this.id.getValue() + ", ptr=0");
            }
            prepareToWrite(len);
            nWrite(this.nPtr, this.writePos, b, off, len);
            this.writePos += len;
            Unit unit = Unit.INSTANCE;
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
            INSTANCE.updateCache(this);
        } catch (Throwable th) {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void prepareToWrite(int size) throws IOException {
        synchronized (this) {
            ReentrantReadWriteLock.ReadLock readLock = this.posLock.readLock();
            readLock.lock();
            try {
                long j = this.writePos + size;
                readLock.unlock();
                ReentrantReadWriteLock reentrantReadWriteLock = this.mmapLock;
                ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
                int i = 0;
                int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i2 = 0; i2 < readHoldCount; i2++) {
                    readLock2.unlock();
                }
                ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    if (j > this.mmapSize) {
                        long j2 = this.nPtr;
                        String absolutePath = this.backingFile.getAbsolutePath();
                        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "backingFile.absolutePath");
                        this.nPtr = nExtend(j2, absolutePath, this.mmapSize, j);
                        GkFSLogger.d$default(this.logger, TAG, "extend block " + this.id.getValue() + " from " + this.mmapSize + " to " + j + ", new ptr=" + this.nPtr, 0, false, 12, null);
                        this.mmapSize = j;
                    }
                    Unit unit = Unit.INSTANCE;
                    while (i < readHoldCount) {
                        readLock2.lock();
                        i++;
                    }
                    writeLock.unlock();
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th) {
                    while (i < readHoldCount) {
                        readLock2.lock();
                        i++;
                    }
                    writeLock.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                readLock.unlock();
                throw th2;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int i = 0;
        if (this.closed.compareAndSet(false, true)) {
            INSTANCE.removeCache$geckox_noasanRelease(this.id);
            ReentrantReadWriteLock reentrantReadWriteLock = this.mmapLock;
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
            int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
            for (int i2 = 0; i2 < readHoldCount; i2++) {
                readLock.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                nRelease(this.nPtr, this.mmapSize);
                this.nPtr = 0L;
                Unit unit = Unit.INSTANCE;
            } finally {
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
            }
        }
    }

    @Override // java.io.Flushable
    public void flush() {
        synchronized (this.mmapLock) {
            ReentrantReadWriteLock.ReadLock readLock = this.mmapLock.readLock();
            readLock.lock();
            try {
                nFlush(this.nPtr, this.mmapSize);
                readLock.unlock();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                readLock.unlock();
                throw th;
            }
        }
    }

    public final long available() {
        long j = this.limit;
        ReentrantReadWriteLock.ReadLock readLock = this.posLock.readLock();
        readLock.lock();
        try {
            long j2 = this.writePos;
            readLock.unlock();
            return j - j2;
        } catch (Throwable th) {
            readLock.unlock();
            throw th;
        }
    }

    public String toString() {
        return "GkFSBlockBuffer@" + hashCode() + "(id=" + this.id.getValue() + ", cacheSize=" + getAvailableWritePos$geckox_noasanRelease() + ", backingFile=" + this.backingFile + ')';
    }

    protected final void finalize() {
        GkFSLogger.d$default(this.logger, TAG, "release " + this + " cause finalize", 0, false, 12, null);
        long j = this.nPtr;
        if (j == 0) {
            return;
        }
        nRelease(j, this.writePos);
        this.nPtr = 0L;
    }
}
