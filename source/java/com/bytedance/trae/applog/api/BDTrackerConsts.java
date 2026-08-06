package com.bytedance.trae.applog.api;

import kotlin.Metadata;

/* compiled from: BDTrackerConsts.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/applog/api/BDTrackerConsts;", "", "<init>", "()V", "EVENT_VERIFY_HOST", "", "EVENT_VERIFY_OVERSEA_HOST", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BDTrackerConsts {
    public static final String EVENT_VERIFY_HOST = "https://log.snssdk.com";
    public static final String EVENT_VERIFY_OVERSEA_HOST = "https://log.byteoversea.net";
    public static final BDTrackerConsts INSTANCE = new BDTrackerConsts();

    private BDTrackerConsts() {
    }
}
