package com.bytedance.gkfs.io;

import com.bytedance.forest.model.PreloadConfig;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: meta.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSFileMeta;", "", "majorFile", "Ljava/io/File;", "header", "Lcom/bytedance/gkfs/io/GkFSHeaderMeta;", "chunks", "", "Lcom/bytedance/gkfs/io/GkFSChunk;", "(Ljava/io/File;Lcom/bytedance/gkfs/io/GkFSHeaderMeta;Ljava/util/List;)V", "getChunks", "()Ljava/util/List;", "getHeader", "()Lcom/bytedance/gkfs/io/GkFSHeaderMeta;", "getMajorFile", "()Ljava/io/File;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class GkFSFileMeta {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final GkFSFileMeta EMPTY = new GkFSFileMeta(new File(""), GkFSHeaderMeta.INSTANCE.getEMPTY(), CollectionsKt.emptyList());
    private final List<GkFSChunk> chunks;
    private final GkFSHeaderMeta header;
    private final File majorFile;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GkFSFileMeta copy$default(GkFSFileMeta gkFSFileMeta, File file, GkFSHeaderMeta gkFSHeaderMeta, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            file = gkFSFileMeta.majorFile;
        }
        if ((i & 2) != 0) {
            gkFSHeaderMeta = gkFSFileMeta.header;
        }
        if ((i & 4) != 0) {
            list = gkFSFileMeta.chunks;
        }
        return gkFSFileMeta.copy(file, gkFSHeaderMeta, list);
    }

    /* renamed from: component1, reason: from getter */
    public final File getMajorFile() {
        return this.majorFile;
    }

    /* renamed from: component2, reason: from getter */
    public final GkFSHeaderMeta getHeader() {
        return this.header;
    }

    public final List<GkFSChunk> component3() {
        return this.chunks;
    }

    public final GkFSFileMeta copy(File majorFile, GkFSHeaderMeta header, List<GkFSChunk> chunks) {
        Intrinsics.checkParameterIsNotNull(majorFile, "majorFile");
        Intrinsics.checkParameterIsNotNull(header, "header");
        Intrinsics.checkParameterIsNotNull(chunks, "chunks");
        return new GkFSFileMeta(majorFile, header, chunks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GkFSFileMeta)) {
            return false;
        }
        GkFSFileMeta gkFSFileMeta = (GkFSFileMeta) other;
        return Intrinsics.areEqual(this.majorFile, gkFSFileMeta.majorFile) && Intrinsics.areEqual(this.header, gkFSFileMeta.header) && Intrinsics.areEqual(this.chunks, gkFSFileMeta.chunks);
    }

    public int hashCode() {
        File file = this.majorFile;
        int hashCode = (file != null ? file.hashCode() : 0) * 31;
        GkFSHeaderMeta gkFSHeaderMeta = this.header;
        int hashCode2 = (hashCode + (gkFSHeaderMeta != null ? gkFSHeaderMeta.hashCode() : 0)) * 31;
        List<GkFSChunk> list = this.chunks;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "GkFSFileMeta(majorFile=" + this.majorFile + ", header=" + this.header + ", chunks=" + this.chunks + ")";
    }

    public GkFSFileMeta(File file, GkFSHeaderMeta gkFSHeaderMeta, List<GkFSChunk> list) {
        Intrinsics.checkParameterIsNotNull(file, "majorFile");
        Intrinsics.checkParameterIsNotNull(gkFSHeaderMeta, "header");
        Intrinsics.checkParameterIsNotNull(list, "chunks");
        this.majorFile = file;
        this.header = gkFSHeaderMeta;
        this.chunks = list;
    }

    public final File getMajorFile() {
        return this.majorFile;
    }

    public final GkFSHeaderMeta getHeader() {
        return this.header;
    }

    public final List<GkFSChunk> getChunks() {
        return this.chunks;
    }

    /* compiled from: meta.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSFileMeta$Companion;", "", "()V", "EMPTY", "Lcom/bytedance/gkfs/io/GkFSFileMeta;", "getEMPTY", "()Lcom/bytedance/gkfs/io/GkFSFileMeta;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GkFSFileMeta getEMPTY() {
            return GkFSFileMeta.EMPTY;
        }
    }
}
