package com.bytedance.iesgurd;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IESGurdObserver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/iesgurd/IESGurdObserverCleanInfo;", "", "accessKey", "", "channel", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "getChannel", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final /* data */ class IESGurdObserverCleanInfo {
    private final String accessKey;
    private final String channel;

    public static /* synthetic */ IESGurdObserverCleanInfo copy$default(IESGurdObserverCleanInfo iESGurdObserverCleanInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iESGurdObserverCleanInfo.accessKey;
        }
        if ((i & 2) != 0) {
            str2 = iESGurdObserverCleanInfo.channel;
        }
        return iESGurdObserverCleanInfo.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAccessKey() {
        return this.accessKey;
    }

    /* renamed from: component2, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    public final IESGurdObserverCleanInfo copy(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        return new IESGurdObserverCleanInfo(accessKey, channel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IESGurdObserverCleanInfo)) {
            return false;
        }
        IESGurdObserverCleanInfo iESGurdObserverCleanInfo = (IESGurdObserverCleanInfo) other;
        return Intrinsics.areEqual(this.accessKey, iESGurdObserverCleanInfo.accessKey) && Intrinsics.areEqual(this.channel, iESGurdObserverCleanInfo.channel);
    }

    public int hashCode() {
        String str = this.accessKey;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.channel;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "IESGurdObserverCleanInfo(accessKey=" + this.accessKey + ", channel=" + this.channel + ")";
    }

    public IESGurdObserverCleanInfo(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        this.accessKey = accessKey;
        this.channel = channel;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final String getChannel() {
        return this.channel;
    }
}
