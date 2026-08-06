package com.bytedance.trae.push.impl;

import com.bytedance.push.frontier.FrontierPush;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;

/* compiled from: FrontierSessionUpdater.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/push/impl/FrontierSessionUpdater;", "", "<init>", "()V", "TAG", "", "notifySessionIdChanged", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FrontierSessionUpdater {
    public static final FrontierSessionUpdater INSTANCE = new FrontierSessionUpdater();
    private static final String TAG = "FrontierSessionUpdater";

    private FrontierSessionUpdater() {
    }

    public final void notifySessionIdChanged() {
        try {
            String sessionId = IApplog.Companion.getSessionId();
            FrontierPush ins = FrontierPush.getIns(AppHost.Companion.getApplication());
            if (ins != null) {
                ins.updateSessionId(sessionId);
            }
            FLogger.INSTANCE.mo428i(TAG, "notifySessionIdChanged sessionId=" + sessionId);
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e(TAG, "notifySessionIdChanged error: " + e.getMessage());
        }
    }
}
