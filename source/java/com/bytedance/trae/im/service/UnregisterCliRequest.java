package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IListClisService.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/im/service/UnregisterCliRequest;", "", "cliId", "", "<init>", "(Ljava/lang/String;)V", "getCliId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UnregisterCliRequest {

    @SerializedName("cli_id")
    private final String cliId;

    public static /* synthetic */ UnregisterCliRequest copy$default(UnregisterCliRequest unregisterCliRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = unregisterCliRequest.cliId;
        }
        return unregisterCliRequest.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCliId() {
        return this.cliId;
    }

    public final UnregisterCliRequest copy(String cliId) {
        Intrinsics.checkNotNullParameter(cliId, "cliId");
        return new UnregisterCliRequest(cliId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UnregisterCliRequest) && Intrinsics.areEqual(this.cliId, ((UnregisterCliRequest) other).cliId);
    }

    public int hashCode() {
        return this.cliId.hashCode();
    }

    public String toString() {
        return "UnregisterCliRequest(cliId=" + this.cliId + ')';
    }

    public UnregisterCliRequest(String cliId) {
        Intrinsics.checkNotNullParameter(cliId, "cliId");
        this.cliId = cliId;
    }

    public final String getCliId() {
        return this.cliId;
    }
}
