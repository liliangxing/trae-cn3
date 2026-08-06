package com.bytedance.gkfs.storage;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.gkfs.io.ChunkIdentifier;
import java.io.File;
import java.io.InputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GkFSChunkStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u0013\u0010'\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003J\t\u0010,\u001a\u00020\u0011HÆ\u0003Jc\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0011HÖ\u0001J\b\u00102\u001a\u000203H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!¨\u00064"}, d2 = {"Lcom/bytedance/gkfs/storage/GkFSChunkStorageInfo;", "", "id", "Lcom/bytedance/gkfs/io/ChunkIdentifier;", "chunkFile", "Ljava/io/File;", "chunkReaderProvider", "Lkotlin/Function0;", "Ljava/io/InputStream;", "Lcom/bytedance/gkfs/storage/ChunkReaderProvider;", "indexing", "Lcom/bytedance/gkfs/storage/ChunkIndexingInfo;", "lockCost", "", "ioCost", "timeCost", "size", "", "(Lcom/bytedance/gkfs/io/ChunkIdentifier;Ljava/io/File;Lkotlin/jvm/functions/Function0;Lcom/bytedance/gkfs/storage/ChunkIndexingInfo;JJJI)V", "getChunkFile", "()Ljava/io/File;", "getChunkReaderProvider", "()Lkotlin/jvm/functions/Function0;", "dilutedSize", "getDilutedSize", "()I", "dilutedSize$delegate", "Lkotlin/Lazy;", "getId", "()Lcom/bytedance/gkfs/io/ChunkIdentifier;", "getIndexing", "()Lcom/bytedance/gkfs/storage/ChunkIndexingInfo;", "getIoCost", "()J", "getLockCost", "getSize", "getTimeCost", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class GkFSChunkStorageInfo {
    private final File chunkFile;
    private final Function0<InputStream> chunkReaderProvider;

    /* renamed from: dilutedSize$delegate, reason: from kotlin metadata */
    private final Lazy dilutedSize;
    private final ChunkIdentifier id;
    private final ChunkIndexingInfo indexing;
    private final long ioCost;
    private final long lockCost;
    private final int size;
    private final long timeCost;

    /* renamed from: component1, reason: from getter */
    public final ChunkIdentifier getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final File getChunkFile() {
        return this.chunkFile;
    }

    public final Function0<InputStream> component3() {
        return this.chunkReaderProvider;
    }

    /* renamed from: component4, reason: from getter */
    public final ChunkIndexingInfo getIndexing() {
        return this.indexing;
    }

    /* renamed from: component5, reason: from getter */
    public final long getLockCost() {
        return this.lockCost;
    }

    /* renamed from: component6, reason: from getter */
    public final long getIoCost() {
        return this.ioCost;
    }

    /* renamed from: component7, reason: from getter */
    public final long getTimeCost() {
        return this.timeCost;
    }

    /* renamed from: component8, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    public final GkFSChunkStorageInfo copy(ChunkIdentifier id, File chunkFile, Function0<? extends InputStream> chunkReaderProvider, ChunkIndexingInfo indexing, long lockCost, long ioCost, long timeCost, int size) {
        Intrinsics.checkParameterIsNotNull(id, "id");
        Intrinsics.checkParameterIsNotNull(chunkFile, "chunkFile");
        Intrinsics.checkParameterIsNotNull(chunkReaderProvider, "chunkReaderProvider");
        Intrinsics.checkParameterIsNotNull(indexing, "indexing");
        return new GkFSChunkStorageInfo(id, chunkFile, chunkReaderProvider, indexing, lockCost, ioCost, timeCost, size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GkFSChunkStorageInfo)) {
            return false;
        }
        GkFSChunkStorageInfo gkFSChunkStorageInfo = (GkFSChunkStorageInfo) other;
        return Intrinsics.areEqual(this.id, gkFSChunkStorageInfo.id) && Intrinsics.areEqual(this.chunkFile, gkFSChunkStorageInfo.chunkFile) && Intrinsics.areEqual(this.chunkReaderProvider, gkFSChunkStorageInfo.chunkReaderProvider) && Intrinsics.areEqual(this.indexing, gkFSChunkStorageInfo.indexing) && this.lockCost == gkFSChunkStorageInfo.lockCost && this.ioCost == gkFSChunkStorageInfo.ioCost && this.timeCost == gkFSChunkStorageInfo.timeCost && this.size == gkFSChunkStorageInfo.size;
    }

    public final int getDilutedSize() {
        return ((Number) this.dilutedSize.getValue()).intValue();
    }

    public int hashCode() {
        ChunkIdentifier chunkIdentifier = this.id;
        int hashCode = (chunkIdentifier != null ? chunkIdentifier.hashCode() : 0) * 31;
        File file = this.chunkFile;
        int hashCode2 = (hashCode + (file != null ? file.hashCode() : 0)) * 31;
        Function0<InputStream> function0 = this.chunkReaderProvider;
        int hashCode3 = (hashCode2 + (function0 != null ? function0.hashCode() : 0)) * 31;
        ChunkIndexingInfo chunkIndexingInfo = this.indexing;
        int hashCode4 = (hashCode3 + (chunkIndexingInfo != null ? chunkIndexingInfo.hashCode() : 0)) * 31;
        long j = this.lockCost;
        int i = (hashCode4 + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.ioCost;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.timeCost;
        return ((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GkFSChunkStorageInfo(ChunkIdentifier chunkIdentifier, File file, Function0<? extends InputStream> function0, ChunkIndexingInfo chunkIndexingInfo, long j, long j2, long j3, int i) {
        Intrinsics.checkParameterIsNotNull(chunkIdentifier, "id");
        Intrinsics.checkParameterIsNotNull(file, "chunkFile");
        Intrinsics.checkParameterIsNotNull(function0, "chunkReaderProvider");
        Intrinsics.checkParameterIsNotNull(chunkIndexingInfo, "indexing");
        this.id = chunkIdentifier;
        this.chunkFile = file;
        this.chunkReaderProvider = function0;
        this.indexing = chunkIndexingInfo;
        this.lockCost = j;
        this.ioCost = j2;
        this.timeCost = j3;
        this.size = i;
        this.dilutedSize = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.gkfs.storage.GkFSChunkStorageInfo$dilutedSize$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m574invoke() {
                return Integer.valueOf(invoke());
            }

            public final int invoke() {
                int size = GkFSChunkStorageInfo.this.getSize();
                Integer valueOf = Integer.valueOf(GkFSChunkStorageInfo.this.getIndexing().getRc());
                if (!(valueOf.intValue() > 0)) {
                    valueOf = null;
                }
                return size / (valueOf != null ? valueOf.intValue() : 1);
            }
        });
    }

    public final ChunkIdentifier getId() {
        return this.id;
    }

    public final File getChunkFile() {
        return this.chunkFile;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ GkFSChunkStorageInfo(ChunkIdentifier chunkIdentifier, File file, Function0 function0, ChunkIndexingInfo chunkIndexingInfo, long j, long j2, long j3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(chunkIdentifier, file, r4, chunkIndexingInfo, (i2 & 16) != 0 ? 0L : j, (i2 & 32) != 0 ? 0L : j2, (i2 & 64) != 0 ? 0L : j3, i);
        Function0 function02;
        Function0 function03;
        if ((i2 & 4) != 0) {
            function03 = GkFSChunkStorageKt.UnReadableChunkProvider;
            function02 = function03;
        } else {
            function02 = function0;
        }
    }

    public final Function0<InputStream> getChunkReaderProvider() {
        return this.chunkReaderProvider;
    }

    public final ChunkIndexingInfo getIndexing() {
        return this.indexing;
    }

    public final long getLockCost() {
        return this.lockCost;
    }

    public final long getIoCost() {
        return this.ioCost;
    }

    public final long getTimeCost() {
        return this.timeCost;
    }

    public final int getSize() {
        return this.size;
    }

    public String toString() {
        return "GkFSChunkStorageInfo(identity=" + this.id + ", chunkReaderProvider=" + this.chunkReaderProvider + ", indexing=" + this.indexing + ", lockCost=" + this.lockCost + ", ioCost=" + this.ioCost + ", timeCost=" + this.timeCost + ", size=" + this.size + ", dilutedSize=" + getDilutedSize() + ')';
    }
}
