package com.bytedance.trae.login.traeauth;

import com.bytedance.trae.network.FrontierIdGenerator;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthConfig.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u0011\u0010\u0013\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;", "", "<init>", "()V", "clientId", "", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "clientSecret", "getClientSecret", "setClientSecret", "loginChannel", "getLoginChannel", "setLoginChannel", "platform", "getPlatform", "setPlatform", "baseUrl", "getBaseUrl", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeAuthConfig {
    public static final TraeAuthConfig INSTANCE = new TraeAuthConfig();
    private static String clientId = "ono9krqynydwx5";
    private static String clientSecret = "-";
    private static String loginChannel = FrontierIdGenerator.APP_RUNTIME_TYPE_ANDROID;
    private static String platform;

    private TraeAuthConfig() {
    }

    public final String getClientId() {
        return clientId;
    }

    public final void setClientId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        clientId = str;
    }

    public final String getClientSecret() {
        return clientSecret;
    }

    public final void setClientSecret(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        clientSecret = str;
    }

    public final String getLoginChannel() {
        return loginChannel;
    }

    public final void setLoginChannel(String str) {
        loginChannel = str;
    }

    public final String getPlatform() {
        return platform;
    }

    public final void setPlatform(String str) {
        platform = str;
    }

    public final String getBaseUrl() {
        return HostResolver.INSTANCE.getBaseUrl(HostType.LOGIN);
    }
}
