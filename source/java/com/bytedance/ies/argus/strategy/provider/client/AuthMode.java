package com.bytedance.ies.argus.strategy.provider.client;

import kotlin.Metadata;

/* compiled from: JSBCallStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/AuthMode;", "", "desc", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "INTERNAL_H5_APPID", "INTERNAL_H5_OLD", "STANDARD_H5_V3", "STANDARD_H5_V3_FORCE_PRIVATE", "STANDARD_LYNX", "STANDARD_LYNX_FORCE_PRIVATE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum AuthMode {
    INTERNAL_H5_APPID("internal_h5_appID"),
    INTERNAL_H5_OLD("internal_h5_old"),
    STANDARD_H5_V3("standard_h5_v3"),
    STANDARD_H5_V3_FORCE_PRIVATE("standard_h5_v3_force_private"),
    STANDARD_LYNX("standard_lynx"),
    STANDARD_LYNX_FORCE_PRIVATE("standard_lynx_force_private");

    private final String desc;

    AuthMode(String str) {
        this.desc = str;
    }

    public final String getDesc() {
        return this.desc;
    }
}
