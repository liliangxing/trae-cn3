package com.bytedance.ies.argus.api.params;

import androidx.webkit.Profile;
import kotlin.Metadata;

/* compiled from: WebLoadUrlParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/argus/api/params/WebLoadRiskTag;", "", "strValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStrValue", "()Ljava/lang/String;", Profile.DEFAULT_PROFILE_NAME, "PassInnerDomain", "PassPluginVerify", "ShowRiskUnknown", "ShowRiskGrey", "ShowRiskBlack", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum WebLoadRiskTag {
    Default("default"),
    PassInnerDomain("white_inner_list"),
    PassPluginVerify("risk_white_plugin"),
    ShowRiskUnknown("risk_unknown"),
    ShowRiskGrey("risk_grey"),
    ShowRiskBlack("risk_black");

    private final String strValue;

    WebLoadRiskTag(String str) {
        this.strValue = str;
    }

    public final String getStrValue() {
        return this.strValue;
    }
}
