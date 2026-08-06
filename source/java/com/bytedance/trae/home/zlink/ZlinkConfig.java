package com.bytedance.trae.home.zlink;

import com.bytedance.trae.common.apphost.AppHost;
import kotlin.Metadata;

/* compiled from: ZlinkConfig.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/home/zlink/ZlinkConfig;", "", "<init>", "()V", "APP_ID", "", "getAPP_ID", "()Ljava/lang/String;", "SCHEME", "getSCHEME", "APPLINK_HOST", "getAPPLINK_HOST", "ENABLE_CLIPBOARD", "", "CLIPBOARD_DELAY_MS", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ZlinkConfig {
    public static final int $stable = 0;
    public static final long CLIPBOARD_DELAY_MS = 500;
    public static final boolean ENABLE_CLIPBOARD = false;
    public static final ZlinkConfig INSTANCE = new ZlinkConfig();

    public final String getSCHEME() {
        return "traemobile";
    }

    private ZlinkConfig() {
    }

    public final String getAPP_ID() {
        return String.valueOf(AppHost.INSTANCE.getAppId());
    }

    public final String getAPPLINK_HOST() {
        return AppHost.INSTANCE.isOversea() ? "" : "traeapp.zlinkurl.cn";
    }
}
