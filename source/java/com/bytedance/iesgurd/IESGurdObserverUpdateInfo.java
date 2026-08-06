package com.bytedance.iesgurd;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IESGurdObserver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/iesgurd/IESGurdObserverUpdateInfo;", "", "accessKey", "", "channel", "version", "", "oldVersion", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "getAccessKey", "()Ljava/lang/String;", "getChannel", "getOldVersion", "()J", "getVersion", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final /* data */ class IESGurdObserverUpdateInfo {
    private final String accessKey;
    private final String channel;
    private final long oldVersion;
    private final long version;

    public static /* synthetic */ IESGurdObserverUpdateInfo copy$default(IESGurdObserverUpdateInfo iESGurdObserverUpdateInfo, String str, String str2, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iESGurdObserverUpdateInfo.accessKey;
        }
        if ((i & 2) != 0) {
            str2 = iESGurdObserverUpdateInfo.channel;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            j = iESGurdObserverUpdateInfo.version;
        }
        long j3 = j;
        if ((i & 8) != 0) {
            j2 = iESGurdObserverUpdateInfo.oldVersion;
        }
        return iESGurdObserverUpdateInfo.copy(str, str3, j3, j2);
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

    /* renamed from: component4, reason: from getter */
    public final long getOldVersion() {
        return this.oldVersion;
    }

    public final IESGurdObserverUpdateInfo copy(String accessKey, String channel, long version, long oldVersion) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        return new IESGurdObserverUpdateInfo(accessKey, channel, version, oldVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IESGurdObserverUpdateInfo)) {
            return false;
        }
        IESGurdObserverUpdateInfo iESGurdObserverUpdateInfo = (IESGurdObserverUpdateInfo) other;
        return Intrinsics.areEqual(this.accessKey, iESGurdObserverUpdateInfo.accessKey) && Intrinsics.areEqual(this.channel, iESGurdObserverUpdateInfo.channel) && this.version == iESGurdObserverUpdateInfo.version && this.oldVersion == iESGurdObserverUpdateInfo.oldVersion;
    }

    public int hashCode() {
        String str = this.accessKey;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.channel;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j = this.version;
        int i = (hashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.oldVersion;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "IESGurdObserverUpdateInfo(accessKey=" + this.accessKey + ", channel=" + this.channel + ", version=" + this.version + ", oldVersion=" + this.oldVersion + ")";
    }

    public IESGurdObserverUpdateInfo(String accessKey, String channel, long j, long j2) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        this.accessKey = accessKey;
        this.channel = channel;
        this.version = j;
        this.oldVersion = j2;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final long getOldVersion() {
        return this.oldVersion;
    }

    public final long getVersion() {
        return this.version;
    }
}
