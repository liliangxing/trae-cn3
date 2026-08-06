package com.bytedance.geckox.pcdn;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* compiled from: GeckoXOdlDownloader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0083\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/geckox/pcdn/OdlDownloadSize;", "", "p2pSize", "", "cdnSize", "(JJ)V", "getCdnSize", "()J", "getP2pSize", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
final /* data */ class OdlDownloadSize {

    @SerializedName(MonitorConstants.CDN_SIZE)
    private final long cdnSize;

    @SerializedName("p2p_size")
    private final long p2pSize;

    public static /* synthetic */ OdlDownloadSize copy$default(OdlDownloadSize odlDownloadSize, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = odlDownloadSize.p2pSize;
        }
        if ((i & 2) != 0) {
            j2 = odlDownloadSize.cdnSize;
        }
        return odlDownloadSize.copy(j, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getP2pSize() {
        return this.p2pSize;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCdnSize() {
        return this.cdnSize;
    }

    public final OdlDownloadSize copy(long p2pSize, long cdnSize) {
        return new OdlDownloadSize(p2pSize, cdnSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OdlDownloadSize)) {
            return false;
        }
        OdlDownloadSize odlDownloadSize = (OdlDownloadSize) other;
        return this.p2pSize == odlDownloadSize.p2pSize && this.cdnSize == odlDownloadSize.cdnSize;
    }

    public int hashCode() {
        long j = this.p2pSize;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.cdnSize;
        return i + ((int) ((j2 >>> 32) ^ j2));
    }

    public String toString() {
        return "OdlDownloadSize(p2pSize=" + this.p2pSize + ", cdnSize=" + this.cdnSize + ")";
    }

    public OdlDownloadSize(long j, long j2) {
        this.p2pSize = j;
        this.cdnSize = j2;
    }

    public final long getP2pSize() {
        return this.p2pSize;
    }

    public final long getCdnSize() {
        return this.cdnSize;
    }
}
