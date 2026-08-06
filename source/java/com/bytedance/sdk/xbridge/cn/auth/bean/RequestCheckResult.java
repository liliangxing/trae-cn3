package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.forest.model.PreloadConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestCheckResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0017\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0003J\u0017\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0001J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001b¨\u0006)"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/RequestCheckResult;", "", StrategyConstants.ACTION, "Lcom/bytedance/sdk/xbridge/cn/auth/bean/RequestCheckAction;", "checkSuccess", "", "denyReason", "", "trackingInfo", "", "trackingWarn", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/RequestCheckAction;ZLjava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getAction", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/RequestCheckAction;", "setAction", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/RequestCheckAction;)V", "getCheckSuccess", "()Z", "setCheckSuccess", "(Z)V", "getDenyReason", "()Ljava/lang/String;", "setDenyReason", "(Ljava/lang/String;)V", "getTrackingInfo", "()Ljava/util/Map;", "setTrackingInfo", "(Ljava/util/Map;)V", "getTrackingWarn", "setTrackingWarn", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RequestCheckResult {
    private RequestCheckAction action;
    private boolean checkSuccess;
    private String denyReason;
    private Map<String, String> trackingInfo;
    private Map<String, String> trackingWarn;

    public static /* synthetic */ RequestCheckResult copy$default(RequestCheckResult requestCheckResult, RequestCheckAction requestCheckAction, boolean z, String str, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            requestCheckAction = requestCheckResult.action;
        }
        if ((i & 2) != 0) {
            z = requestCheckResult.checkSuccess;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            str = requestCheckResult.denyReason;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            map = requestCheckResult.trackingInfo;
        }
        Map map3 = map;
        if ((i & 16) != 0) {
            map2 = requestCheckResult.trackingWarn;
        }
        return requestCheckResult.copy(requestCheckAction, z2, str2, map3, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final RequestCheckAction getAction() {
        return this.action;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCheckSuccess() {
        return this.checkSuccess;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDenyReason() {
        return this.denyReason;
    }

    public final Map<String, String> component4() {
        return this.trackingInfo;
    }

    public final Map<String, String> component5() {
        return this.trackingWarn;
    }

    public final RequestCheckResult copy(RequestCheckAction action, boolean checkSuccess, String denyReason, Map<String, String> trackingInfo, Map<String, String> trackingWarn) {
        Intrinsics.checkNotNullParameter(action, "action");
        return new RequestCheckResult(action, checkSuccess, denyReason, trackingInfo, trackingWarn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestCheckResult)) {
            return false;
        }
        RequestCheckResult requestCheckResult = (RequestCheckResult) other;
        return this.action == requestCheckResult.action && this.checkSuccess == requestCheckResult.checkSuccess && Intrinsics.areEqual(this.denyReason, requestCheckResult.denyReason) && Intrinsics.areEqual(this.trackingInfo, requestCheckResult.trackingInfo) && Intrinsics.areEqual(this.trackingWarn, requestCheckResult.trackingWarn);
    }

    public int hashCode() {
        int hashCode = ((this.action.hashCode() * 31) + Boolean.hashCode(this.checkSuccess)) * 31;
        String str = this.denyReason;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, String> map = this.trackingInfo;
        int hashCode3 = (hashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, String> map2 = this.trackingWarn;
        return hashCode3 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        return "RequestCheckResult(action=" + this.action + ", checkSuccess=" + this.checkSuccess + ", denyReason=" + this.denyReason + ", trackingInfo=" + this.trackingInfo + ", trackingWarn=" + this.trackingWarn + ')';
    }

    public RequestCheckResult(RequestCheckAction action, boolean z, String str, Map<String, String> map, Map<String, String> map2) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.action = action;
        this.checkSuccess = z;
        this.denyReason = str;
        this.trackingInfo = map;
        this.trackingWarn = map2;
    }

    public /* synthetic */ RequestCheckResult(RequestCheckAction requestCheckAction, boolean z, String str, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(requestCheckAction, z, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : map, (i & 16) != 0 ? null : map2);
    }

    public final RequestCheckAction getAction() {
        return this.action;
    }

    public final void setAction(RequestCheckAction requestCheckAction) {
        Intrinsics.checkNotNullParameter(requestCheckAction, "<set-?>");
        this.action = requestCheckAction;
    }

    public final boolean getCheckSuccess() {
        return this.checkSuccess;
    }

    public final void setCheckSuccess(boolean z) {
        this.checkSuccess = z;
    }

    public final String getDenyReason() {
        return this.denyReason;
    }

    public final void setDenyReason(String str) {
        this.denyReason = str;
    }

    public final Map<String, String> getTrackingInfo() {
        return this.trackingInfo;
    }

    public final void setTrackingInfo(Map<String, String> map) {
        this.trackingInfo = map;
    }

    public final Map<String, String> getTrackingWarn() {
        return this.trackingWarn;
    }

    public final void setTrackingWarn(Map<String, String> map) {
        this.trackingWarn = map;
    }
}
