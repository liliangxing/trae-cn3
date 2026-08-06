package com.bytedance.gkfs.io;

import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.gkfs.cdc.GkFSCDCStatistics;
import java.io.File;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: meta.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/bytedance/gkfs/io/GkFSOutputInfo;", "", "meta", "Lcom/bytedance/gkfs/io/GkFSFileMeta;", "originFile", "Ljava/io/File;", "cdcStatistics", "Lcom/bytedance/gkfs/cdc/GkFSCDCStatistics;", "storeStatistics", "Lcom/bytedance/gkfs/io/GkFSIOStatistics;", "(Lcom/bytedance/gkfs/io/GkFSFileMeta;Ljava/io/File;Lcom/bytedance/gkfs/cdc/GkFSCDCStatistics;Lcom/bytedance/gkfs/io/GkFSIOStatistics;)V", "getCdcStatistics", "()Lcom/bytedance/gkfs/cdc/GkFSCDCStatistics;", "getMeta", "()Lcom/bytedance/gkfs/io/GkFSFileMeta;", "getOriginFile", "()Ljava/io/File;", "getStoreStatistics", "()Lcom/bytedance/gkfs/io/GkFSIOStatistics;", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class GkFSOutputInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final GkFSCDCStatistics cdcStatistics;
    private final GkFSFileMeta meta;
    private final File originFile;
    private final GkFSIOStatistics storeStatistics;

    public static /* synthetic */ GkFSOutputInfo copy$default(GkFSOutputInfo gkFSOutputInfo, GkFSFileMeta gkFSFileMeta, File file, GkFSCDCStatistics gkFSCDCStatistics, GkFSIOStatistics gkFSIOStatistics, int i, Object obj) {
        if ((i & 1) != 0) {
            gkFSFileMeta = gkFSOutputInfo.meta;
        }
        if ((i & 2) != 0) {
            file = gkFSOutputInfo.originFile;
        }
        if ((i & 4) != 0) {
            gkFSCDCStatistics = gkFSOutputInfo.cdcStatistics;
        }
        if ((i & 8) != 0) {
            gkFSIOStatistics = gkFSOutputInfo.storeStatistics;
        }
        return gkFSOutputInfo.copy(gkFSFileMeta, file, gkFSCDCStatistics, gkFSIOStatistics);
    }

    /* renamed from: component1, reason: from getter */
    public final GkFSFileMeta getMeta() {
        return this.meta;
    }

    /* renamed from: component2, reason: from getter */
    public final File getOriginFile() {
        return this.originFile;
    }

    /* renamed from: component3, reason: from getter */
    public final GkFSCDCStatistics getCdcStatistics() {
        return this.cdcStatistics;
    }

    /* renamed from: component4, reason: from getter */
    public final GkFSIOStatistics getStoreStatistics() {
        return this.storeStatistics;
    }

    public final GkFSOutputInfo copy(GkFSFileMeta meta, File originFile, GkFSCDCStatistics cdcStatistics, GkFSIOStatistics storeStatistics) {
        Intrinsics.checkParameterIsNotNull(meta, "meta");
        Intrinsics.checkParameterIsNotNull(originFile, "originFile");
        Intrinsics.checkParameterIsNotNull(cdcStatistics, "cdcStatistics");
        Intrinsics.checkParameterIsNotNull(storeStatistics, "storeStatistics");
        return new GkFSOutputInfo(meta, originFile, cdcStatistics, storeStatistics);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GkFSOutputInfo)) {
            return false;
        }
        GkFSOutputInfo gkFSOutputInfo = (GkFSOutputInfo) other;
        return Intrinsics.areEqual(this.meta, gkFSOutputInfo.meta) && Intrinsics.areEqual(this.originFile, gkFSOutputInfo.originFile) && Intrinsics.areEqual(this.cdcStatistics, gkFSOutputInfo.cdcStatistics) && Intrinsics.areEqual(this.storeStatistics, gkFSOutputInfo.storeStatistics);
    }

    public int hashCode() {
        GkFSFileMeta gkFSFileMeta = this.meta;
        int hashCode = (gkFSFileMeta != null ? gkFSFileMeta.hashCode() : 0) * 31;
        File file = this.originFile;
        int hashCode2 = (hashCode + (file != null ? file.hashCode() : 0)) * 31;
        GkFSCDCStatistics gkFSCDCStatistics = this.cdcStatistics;
        int hashCode3 = (hashCode2 + (gkFSCDCStatistics != null ? gkFSCDCStatistics.hashCode() : 0)) * 31;
        GkFSIOStatistics gkFSIOStatistics = this.storeStatistics;
        return hashCode3 + (gkFSIOStatistics != null ? gkFSIOStatistics.hashCode() : 0);
    }

    public String toString() {
        return "GkFSOutputInfo(meta=" + this.meta + ", originFile=" + this.originFile + ", cdcStatistics=" + this.cdcStatistics + ", storeStatistics=" + this.storeStatistics + ")";
    }

    public GkFSOutputInfo(GkFSFileMeta gkFSFileMeta, File file, GkFSCDCStatistics gkFSCDCStatistics, GkFSIOStatistics gkFSIOStatistics) {
        Intrinsics.checkParameterIsNotNull(gkFSFileMeta, "meta");
        Intrinsics.checkParameterIsNotNull(file, "originFile");
        Intrinsics.checkParameterIsNotNull(gkFSCDCStatistics, "cdcStatistics");
        Intrinsics.checkParameterIsNotNull(gkFSIOStatistics, "storeStatistics");
        this.meta = gkFSFileMeta;
        this.originFile = file;
        this.cdcStatistics = gkFSCDCStatistics;
        this.storeStatistics = gkFSIOStatistics;
    }

    public final GkFSFileMeta getMeta() {
        return this.meta;
    }

    public final File getOriginFile() {
        return this.originFile;
    }

    public final GkFSCDCStatistics getCdcStatistics() {
        return this.cdcStatistics;
    }

    public final GkFSIOStatistics getStoreStatistics() {
        return this.storeStatistics;
    }

    /* compiled from: meta.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSOutputInfo$Companion;", "", "()V", "error", "Lcom/bytedance/gkfs/io/GkFSOutputInfo;", "originFile", "Ljava/io/File;", "majorFile", "", AlogMonitor.ALOG_RESULT_CODE, "Lcom/bytedance/gkfs/io/GkFSError;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GkFSOutputInfo error(File originFile, File majorFile, Throwable error, GkFSError code) {
            Intrinsics.checkParameterIsNotNull(originFile, "originFile");
            Intrinsics.checkParameterIsNotNull(majorFile, "majorFile");
            Intrinsics.checkParameterIsNotNull(error, "error");
            Intrinsics.checkParameterIsNotNull(code, AlogMonitor.ALOG_RESULT_CODE);
            return new GkFSOutputInfo(new GkFSFileMeta(majorFile, new GkFSHeaderMeta(0, 0L, 0L, 7, null), CollectionsKt.emptyList()), originFile, GkFSCDCStatistics.INSTANCE.getEMPTY(), new GkFSIOStatistics(new GkFSStatus(false, error, code), 0L, 0L, null, 0L, 0L, 0L, 0L, 254, null));
        }
    }
}
