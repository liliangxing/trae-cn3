package com.bytedance.gkfs.io;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.forest.model.PreloadConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: meta.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSInputInfo;", "", DBHelper.BATTERY_COL_SOURCE, "Ljava/io/File;", "meta", "Lcom/bytedance/gkfs/io/GkFSFileMeta;", "readStatistics", "Lcom/bytedance/gkfs/io/GkFSIOStatistics;", "(Ljava/io/File;Lcom/bytedance/gkfs/io/GkFSFileMeta;Lcom/bytedance/gkfs/io/GkFSIOStatistics;)V", "getMeta", "()Lcom/bytedance/gkfs/io/GkFSFileMeta;", "getReadStatistics", "()Lcom/bytedance/gkfs/io/GkFSIOStatistics;", "getSource", "()Ljava/io/File;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class GkFSInputInfo {
    private final GkFSFileMeta meta;
    private final GkFSIOStatistics readStatistics;
    private final File source;

    public static /* synthetic */ GkFSInputInfo copy$default(GkFSInputInfo gkFSInputInfo, File file, GkFSFileMeta gkFSFileMeta, GkFSIOStatistics gkFSIOStatistics, int i, Object obj) {
        if ((i & 1) != 0) {
            file = gkFSInputInfo.source;
        }
        if ((i & 2) != 0) {
            gkFSFileMeta = gkFSInputInfo.meta;
        }
        if ((i & 4) != 0) {
            gkFSIOStatistics = gkFSInputInfo.readStatistics;
        }
        return gkFSInputInfo.copy(file, gkFSFileMeta, gkFSIOStatistics);
    }

    /* renamed from: component1, reason: from getter */
    public final File getSource() {
        return this.source;
    }

    /* renamed from: component2, reason: from getter */
    public final GkFSFileMeta getMeta() {
        return this.meta;
    }

    /* renamed from: component3, reason: from getter */
    public final GkFSIOStatistics getReadStatistics() {
        return this.readStatistics;
    }

    public final GkFSInputInfo copy(File source, GkFSFileMeta meta, GkFSIOStatistics readStatistics) {
        Intrinsics.checkParameterIsNotNull(source, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.checkParameterIsNotNull(meta, "meta");
        Intrinsics.checkParameterIsNotNull(readStatistics, "readStatistics");
        return new GkFSInputInfo(source, meta, readStatistics);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GkFSInputInfo)) {
            return false;
        }
        GkFSInputInfo gkFSInputInfo = (GkFSInputInfo) other;
        return Intrinsics.areEqual(this.source, gkFSInputInfo.source) && Intrinsics.areEqual(this.meta, gkFSInputInfo.meta) && Intrinsics.areEqual(this.readStatistics, gkFSInputInfo.readStatistics);
    }

    public int hashCode() {
        File file = this.source;
        int hashCode = (file != null ? file.hashCode() : 0) * 31;
        GkFSFileMeta gkFSFileMeta = this.meta;
        int hashCode2 = (hashCode + (gkFSFileMeta != null ? gkFSFileMeta.hashCode() : 0)) * 31;
        GkFSIOStatistics gkFSIOStatistics = this.readStatistics;
        return hashCode2 + (gkFSIOStatistics != null ? gkFSIOStatistics.hashCode() : 0);
    }

    public String toString() {
        return "GkFSInputInfo(source=" + this.source + ", meta=" + this.meta + ", readStatistics=" + this.readStatistics + ")";
    }

    public GkFSInputInfo(File file, GkFSFileMeta gkFSFileMeta, GkFSIOStatistics gkFSIOStatistics) {
        Intrinsics.checkParameterIsNotNull(file, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.checkParameterIsNotNull(gkFSFileMeta, "meta");
        Intrinsics.checkParameterIsNotNull(gkFSIOStatistics, "readStatistics");
        this.source = file;
        this.meta = gkFSFileMeta;
        this.readStatistics = gkFSIOStatistics;
    }

    public final File getSource() {
        return this.source;
    }

    public final GkFSFileMeta getMeta() {
        return this.meta;
    }

    public final GkFSIOStatistics getReadStatistics() {
        return this.readStatistics;
    }
}
