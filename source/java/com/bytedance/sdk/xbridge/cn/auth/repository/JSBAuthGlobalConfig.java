package com.bytedance.sdk.xbridge.cn.auth.repository;

import com.bytedance.sdk.xbridge.cn.auth.RequestCheckConfig;
import kotlin.Metadata;

/* compiled from: JSBAuthGlobalConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/repository/JSBAuthGlobalConfig;", "", "()V", "requestCheck", "Lcom/bytedance/sdk/xbridge/cn/auth/RequestCheckConfig;", "getRequestCheck", "()Lcom/bytedance/sdk/xbridge/cn/auth/RequestCheckConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class JSBAuthGlobalConfig {
    public static final JSBAuthGlobalConfig INSTANCE = new JSBAuthGlobalConfig();
    private static final RequestCheckConfig requestCheck = new RequestCheckConfig();

    private JSBAuthGlobalConfig() {
    }

    public final RequestCheckConfig getRequestCheck() {
        return requestCheck;
    }
}
