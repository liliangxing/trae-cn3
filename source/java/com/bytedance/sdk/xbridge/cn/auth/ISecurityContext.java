package com.bytedance.sdk.xbridge.cn.auth;

import kotlin.Metadata;

/* compiled from: ISecurityContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/ISecurityContext;", "", "getAppId", "", "getAppVersion", "getAuthFeId", "getAuthUrl", "getChannel", "getContainerType", "getMethodName", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface ISecurityContext {
    String getAppId();

    String getAppVersion();

    String getAuthFeId();

    String getAuthUrl();

    String getChannel();

    String getContainerType();

    String getMethodName();
}
