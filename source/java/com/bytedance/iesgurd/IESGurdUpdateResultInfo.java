package com.bytedance.iesgurd;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IESGurdDefines.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/iesgurd/IESGurdUpdateResultInfo;", "", "()V", "channelInfos", "", "", "Lcom/bytedance/iesgurd/IESGurdUpdateChannelInfo;", "getChannelInfos", "()Ljava/util/Map;", "setChannelInfos", "(Ljava/util/Map;)V", "errorMessage", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "success", "", "getSuccess", "()Z", "setSuccess", "(Z)V", "version", "", "getVersion", "()J", "setVersion", "(J)V", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final class IESGurdUpdateResultInfo {
    private String errorMessage;
    private long version;
    private boolean success = true;
    private Map<String, IESGurdUpdateChannelInfo> channelInfos = new LinkedHashMap();

    public final boolean getSuccess() {
        return this.success;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    public final long getVersion() {
        return this.version;
    }

    public final void setVersion(long j) {
        this.version = j;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final Map<String, IESGurdUpdateChannelInfo> getChannelInfos() {
        return this.channelInfos;
    }

    public final void setChannelInfos(Map<String, IESGurdUpdateChannelInfo> map) {
        Intrinsics.checkParameterIsNotNull(map, "<set-?>");
        this.channelInfos = map;
    }
}
