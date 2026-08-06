package com.bytedance.trae.conversation.settings;

import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* compiled from: ICNBusinessSettings.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/settings/BusinessSettingsService;", "", "<init>", "()V", "TAG", "", "getSettings", "Lcom/bytedance/trae/conversation/settings/BusinessSettings;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BusinessSettingsService {
    public static final BusinessSettingsService INSTANCE = new BusinessSettingsService();
    private static final String TAG = "BusinessSettingsService";

    private BusinessSettingsService() {
    }

    public final BusinessSettings getSettings() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            BusinessSettingsService businessSettingsService = this;
            ICNBusinessSettings iCNBusinessSettings = (ICNBusinessSettings) SettingsManager.obtain(ICNBusinessSettings.class);
            obj = Result.constructor-impl(iCNBusinessSettings != null ? iCNBusinessSettings.getSettings() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            TraeLogUtil.INSTANCE.w(TAG, "obtain model list settings failed", th2);
        }
        String str = (String) (Result.isFailure-impl(obj) ? null : obj);
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new BusinessSettings(jSONObject.optLong("fast_pass_notify_count", 10L), jSONObject.optLong("fast_pass_notify_interval", 72L));
            } catch (Throwable unused) {
            }
        }
        return new BusinessSettings(10L, 72L);
    }
}
