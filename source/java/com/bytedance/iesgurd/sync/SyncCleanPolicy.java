package com.bytedance.iesgurd.sync;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SyncMsgModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/iesgurd/sync/SyncCleanPolicy;", "", "channel", "", "cleanType", "", "versions", "", "", "(Ljava/lang/String;ILjava/util/List;)V", "getChannel", "()Ljava/lang/String;", "getCleanType", "()I", "getVersions", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final /* data */ class SyncCleanPolicy {

    @SerializedName(AirActionConstant.ActionId.ACTION_ID_CALL)
    private final String channel;

    @SerializedName("clean_type")
    private final int cleanType;

    @SerializedName("version")
    private final List<Long> versions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SyncCleanPolicy copy$default(SyncCleanPolicy syncCleanPolicy, String str, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = syncCleanPolicy.channel;
        }
        if ((i2 & 2) != 0) {
            i = syncCleanPolicy.cleanType;
        }
        if ((i2 & 4) != 0) {
            list = syncCleanPolicy.versions;
        }
        return syncCleanPolicy.copy(str, i, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCleanType() {
        return this.cleanType;
    }

    public final List<Long> component3() {
        return this.versions;
    }

    public final SyncCleanPolicy copy(String channel, int cleanType, List<Long> versions) {
        return new SyncCleanPolicy(channel, cleanType, versions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncCleanPolicy)) {
            return false;
        }
        SyncCleanPolicy syncCleanPolicy = (SyncCleanPolicy) other;
        return Intrinsics.areEqual(this.channel, syncCleanPolicy.channel) && this.cleanType == syncCleanPolicy.cleanType && Intrinsics.areEqual(this.versions, syncCleanPolicy.versions);
    }

    public int hashCode() {
        String str = this.channel;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.cleanType) * 31;
        List<Long> list = this.versions;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "SyncCleanPolicy(channel=" + this.channel + ", cleanType=" + this.cleanType + ", versions=" + this.versions + ")";
    }

    public SyncCleanPolicy(String str, int i, List<Long> list) {
        this.channel = str;
        this.cleanType = i;
        this.versions = list;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final int getCleanType() {
        return this.cleanType;
    }

    public final List<Long> getVersions() {
        return this.versions;
    }
}
