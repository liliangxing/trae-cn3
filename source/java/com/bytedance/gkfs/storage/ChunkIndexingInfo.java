package com.bytedance.gkfs.storage;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.gkfs.io.BlockIdentifier;
import com.bytedance.gkfs.io.ChunkIdentifier;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: indexing.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003JF\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010)\u001a\u00020\u0015H\u0016J\t\u0010*\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006+"}, d2 = {"Lcom/bytedance/gkfs/storage/ChunkIndexingInfo;", "", "id", "Lcom/bytedance/gkfs/io/ChunkIdentifier;", "blockId", "Lcom/bytedance/gkfs/io/BlockIdentifier;", "reference", "", "", "blockInfo", "Lcom/bytedance/gkfs/storage/ChunkBlockIndexingInfo;", "timeCost", "", "(Lcom/bytedance/gkfs/io/ChunkIdentifier;Lcom/bytedance/gkfs/io/BlockIdentifier;[Ljava/lang/String;Lcom/bytedance/gkfs/storage/ChunkBlockIndexingInfo;J)V", "getBlockId", "()Lcom/bytedance/gkfs/io/BlockIdentifier;", "getBlockInfo", "()Lcom/bytedance/gkfs/storage/ChunkBlockIndexingInfo;", "getId", "()Lcom/bytedance/gkfs/io/ChunkIdentifier;", "rc", "", "getRc", "()I", "rc$delegate", "Lkotlin/Lazy;", "getReference", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getTimeCost", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/bytedance/gkfs/io/ChunkIdentifier;Lcom/bytedance/gkfs/io/BlockIdentifier;[Ljava/lang/String;Lcom/bytedance/gkfs/storage/ChunkBlockIndexingInfo;J)Lcom/bytedance/gkfs/storage/ChunkIndexingInfo;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class ChunkIndexingInfo {
    private final BlockIdentifier blockId;
    private final transient ChunkBlockIndexingInfo blockInfo;
    private final transient ChunkIdentifier id;

    /* renamed from: rc$delegate, reason: from kotlin metadata */
    private final Lazy rc;
    private final String[] reference;
    private final transient long timeCost;

    public static /* synthetic */ ChunkIndexingInfo copy$default(ChunkIndexingInfo chunkIndexingInfo, ChunkIdentifier chunkIdentifier, BlockIdentifier blockIdentifier, String[] strArr, ChunkBlockIndexingInfo chunkBlockIndexingInfo, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            chunkIdentifier = chunkIndexingInfo.id;
        }
        if ((i & 2) != 0) {
            blockIdentifier = chunkIndexingInfo.blockId;
        }
        BlockIdentifier blockIdentifier2 = blockIdentifier;
        if ((i & 4) != 0) {
            strArr = chunkIndexingInfo.reference;
        }
        String[] strArr2 = strArr;
        if ((i & 8) != 0) {
            chunkBlockIndexingInfo = chunkIndexingInfo.blockInfo;
        }
        ChunkBlockIndexingInfo chunkBlockIndexingInfo2 = chunkBlockIndexingInfo;
        if ((i & 16) != 0) {
            j = chunkIndexingInfo.timeCost;
        }
        return chunkIndexingInfo.copy(chunkIdentifier, blockIdentifier2, strArr2, chunkBlockIndexingInfo2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final ChunkIdentifier getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final BlockIdentifier getBlockId() {
        return this.blockId;
    }

    /* renamed from: component3, reason: from getter */
    public final String[] getReference() {
        return this.reference;
    }

    /* renamed from: component4, reason: from getter */
    public final ChunkBlockIndexingInfo getBlockInfo() {
        return this.blockInfo;
    }

    /* renamed from: component5, reason: from getter */
    public final long getTimeCost() {
        return this.timeCost;
    }

    public final ChunkIndexingInfo copy(ChunkIdentifier id, BlockIdentifier blockId, String[] reference, ChunkBlockIndexingInfo blockInfo, long timeCost) {
        Intrinsics.checkParameterIsNotNull(id, "id");
        Intrinsics.checkParameterIsNotNull(blockId, "blockId");
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        Intrinsics.checkParameterIsNotNull(blockInfo, "blockInfo");
        return new ChunkIndexingInfo(id, blockId, reference, blockInfo, timeCost);
    }

    public final int getRc() {
        return ((Number) this.rc.getValue()).intValue();
    }

    public String toString() {
        return "ChunkIndexingInfo(id=" + this.id + ", blockId=" + this.blockId + ", reference=" + Arrays.toString(this.reference) + ", blockInfo=" + this.blockInfo + ", timeCost=" + this.timeCost + ")";
    }

    public ChunkIndexingInfo(ChunkIdentifier chunkIdentifier, BlockIdentifier blockIdentifier, String[] strArr, ChunkBlockIndexingInfo chunkBlockIndexingInfo, long j) {
        Intrinsics.checkParameterIsNotNull(chunkIdentifier, "id");
        Intrinsics.checkParameterIsNotNull(blockIdentifier, "blockId");
        Intrinsics.checkParameterIsNotNull(strArr, "reference");
        Intrinsics.checkParameterIsNotNull(chunkBlockIndexingInfo, "blockInfo");
        this.id = chunkIdentifier;
        this.blockId = blockIdentifier;
        this.reference = strArr;
        this.blockInfo = chunkBlockIndexingInfo;
        this.timeCost = j;
        this.rc = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.gkfs.storage.ChunkIndexingInfo$rc$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m570invoke() {
                return Integer.valueOf(invoke());
            }

            public final int invoke() {
                return ChunkIndexingInfo.this.getReference().length;
            }
        });
    }

    public final ChunkIdentifier getId() {
        return this.id;
    }

    public final BlockIdentifier getBlockId() {
        return this.blockId;
    }

    public final String[] getReference() {
        return this.reference;
    }

    public /* synthetic */ ChunkIndexingInfo(ChunkIdentifier chunkIdentifier, BlockIdentifier blockIdentifier, String[] strArr, ChunkBlockIndexingInfo chunkBlockIndexingInfo, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(chunkIdentifier, blockIdentifier, strArr, (i & 8) != 0 ? new ChunkBlockIndexingInfo(0L, 0, 3, null) : chunkBlockIndexingInfo, j);
    }

    public final ChunkBlockIndexingInfo getBlockInfo() {
        return this.blockInfo;
    }

    public final long getTimeCost() {
        return this.timeCost;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        if (other != null) {
            ChunkIndexingInfo chunkIndexingInfo = (ChunkIndexingInfo) other;
            return ((Intrinsics.areEqual(this.id, chunkIndexingInfo.id) ^ true) || (Intrinsics.areEqual(this.blockId, chunkIndexingInfo.blockId) ^ true) || (Intrinsics.areEqual(this.blockInfo, chunkIndexingInfo.blockInfo) ^ true)) ? false : true;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.gkfs.storage.ChunkIndexingInfo");
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.blockId.hashCode()) * 31) + this.blockInfo.hashCode();
    }
}
