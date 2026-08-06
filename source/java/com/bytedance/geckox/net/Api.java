package com.bytedance.geckox.net;

import kotlin.Metadata;

/* compiled from: Api.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/geckox/net/Api;", "", "()V", "MONITOR_CONFIG", "", "MONITOR_REPORT", "SCHEMA_HTTPS", "SETTINGS_URL", "UPDATE_URL_COLD_START", "UPDATE_URL_CUSTOM", "UPDATE_URL_POLLING", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class Api {
    public static final Api INSTANCE = new Api();
    public static final String MONITOR_CONFIG = "/monitor/appmonitor/v2/settings";
    public static final String MONITOR_REPORT = "/monitor/collect/";
    public static final String SCHEMA_HTTPS = "https://";
    public static final String SETTINGS_URL = "/gkx/api/settings/v3";
    public static final String UPDATE_URL_COLD_START = "/gkx/api/resource/v7/coldstart";
    public static final String UPDATE_URL_CUSTOM = "/gkx/api/resource/v7/custom";
    public static final String UPDATE_URL_POLLING = "/gkx/api/resource/v7/polling";

    private Api() {
    }
}
