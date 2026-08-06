package com.bytedance.ies.bullet.service.sdk.param;

import com.bytedance.upc.Constants;
import kotlin.Metadata;

/* compiled from: OutAnimationParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/OutAnimation;", "", "value", "", "aliasValue", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAliasValue", "()Ljava/lang/String;", "getValue", "AUTO", "BOTTOM", "RIGHT", "NONE", "IN_NONE_OUT_AUTO", "IN_AUTO_OUT_NONE", "LEFT", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public enum OutAnimation {
    AUTO("auto", "0"),
    BOTTOM("bottom", "1"),
    RIGHT("right", "2"),
    NONE("none", "3"),
    IN_NONE_OUT_AUTO("in_none_out_auto", Constants.RECOMMEND_BASE_ON_FOLLOW_LIST),
    IN_AUTO_OUT_NONE("in_auto_out_none", Constants.CONTENT_RICHNESS_EXPANSION_FREQUENCY),
    LEFT("left", "6");

    private final String aliasValue;
    private final String value;

    OutAnimation(String str, String str2) {
        this.value = str;
        this.aliasValue = str2;
    }

    public final String getAliasValue() {
        return this.aliasValue;
    }

    public final String getValue() {
        return this.value;
    }
}
