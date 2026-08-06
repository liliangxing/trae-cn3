package com.bytedance.sdk.account.impl;

import com.bytedance.sdk.account.api.OauthTokenExtraParams;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDAccountPlatformChinaImpl.kt */
@Deprecated(message = "Replace with OauthTokenExtraParams", replaceWith = @ReplaceWith(expression = "com.bytedance.sdk.account.api.OauthTokenExtraParams", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/account/impl/DouYinOauthEventParams;", "Lcom/bytedance/sdk/account/api/OauthTokenExtraParams;", "triggerScene", "", "enterFrom", "triggerPath", "clientKey", "immediate", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "account_china_adapter_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class DouYinOauthEventParams extends OauthTokenExtraParams {
    public /* synthetic */ DouYinOauthEventParams(String str, String str2, String str3, String str4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? true : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DouYinOauthEventParams(String triggerScene, String enterFrom, String triggerPath, String clientKey, boolean z) {
        super(triggerScene, enterFrom, triggerPath, clientKey, z);
        Intrinsics.checkParameterIsNotNull(triggerScene, "triggerScene");
        Intrinsics.checkParameterIsNotNull(enterFrom, "enterFrom");
        Intrinsics.checkParameterIsNotNull(triggerPath, "triggerPath");
        Intrinsics.checkParameterIsNotNull(clientKey, "clientKey");
    }
}
