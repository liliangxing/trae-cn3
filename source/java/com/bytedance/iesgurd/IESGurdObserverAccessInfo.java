package com.bytedance.iesgurd;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IESGurdObserver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/iesgurd/IESGurdObserverAccessInfo;", "", "accessKey", "", "channel", "version", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getAccessKey", "()Ljava/lang/String;", "getChannel", "getVersion", "()J", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final /* data */ class IESGurdObserverAccessInfo {
    private final String accessKey;
    private final String channel;
    private final long version;

    public static /* synthetic */ IESGurdObserverAccessInfo copy$default(IESGurdObserverAccessInfo iESGurdObserverAccessInfo, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iESGurdObserverAccessInfo.accessKey;
        }
        if ((i & 2) != 0) {
            str2 = iESGurdObserverAccessInfo.channel;
        }
        if ((i & 4) != 0) {
            j = iESGurdObserverAccessInfo.version;
        }
        return iESGurdObserverAccessInfo.copy(str, str2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAccessKey() {
        return this.accessKey;
    }

    /* renamed from: component2, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* renamed from: component3, reason: from getter */
    public final long getVersion() {
        return this.version;
    }

    public final IESGurdObserverAccessInfo copy(String accessKey, String channel, long version) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        return new IESGurdObserverAccessInfo(accessKey, channel, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IESGurdObserverAccessInfo)) {
            return false;
        }
        IESGurdObserverAccessInfo iESGurdObserverAccessInfo = (IESGurdObserverAccessInfo) other;
        return Intrinsics.areEqual(this.accessKey, iESGurdObserverAccessInfo.accessKey) && Intrinsics.areEqual(this.channel, iESGurdObserverAccessInfo.channel) && this.version == iESGurdObserverAccessInfo.version;
    }

    public int hashCode() {
        String str = this.accessKey;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.channel;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j = this.version;
        return hashCode2 + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "IESGurdObserverAccessInfo(accessKey=" + this.accessKey + ", channel=" + this.channel + ", version=" + this.version + ")";
    }

    public IESGurdObserverAccessInfo(String accessKey, String channel, long j) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        this.accessKey = accessKey;
        this.channel = channel;
        this.version = j;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final long getVersion() {
        return this.version;
    }
}
