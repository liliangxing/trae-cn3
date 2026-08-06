package com.bytedance.sdk.account.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDAccountPlatformConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/account/api/OauthTokenExtraParams;", "", "triggerScene", "", "enterFrom", "triggerPath", "clientKey", "immediate", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getClientKey", "()Ljava/lang/String;", "getEnterFrom", "getImmediate", "()Z", "getTriggerPath", "getTriggerScene", "account-sdk-third-party_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public class OauthTokenExtraParams {
    private final String clientKey;
    private final String enterFrom;
    private final boolean immediate;
    private final String triggerPath;
    private final String triggerScene;

    public OauthTokenExtraParams(String triggerScene, String str, String str2, String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(triggerScene, "triggerScene");
        this.triggerScene = triggerScene;
        this.enterFrom = str;
        this.triggerPath = str2;
        this.clientKey = str3;
        this.immediate = z;
    }

    public final String getTriggerScene() {
        return this.triggerScene;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getTriggerPath() {
        return this.triggerPath;
    }

    public final String getClientKey() {
        return this.clientKey;
    }

    public /* synthetic */ OauthTokenExtraParams(String str, String str2, String str3, String str4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? true : z);
    }

    public final boolean getImmediate() {
        return this.immediate;
    }
}
