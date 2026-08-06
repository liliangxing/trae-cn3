package com.bytedance.trae.conversation.settings;

import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.trae.conversation.LoginUtils;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IReportAlogSettings.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/settings/ReportAlogSettingsService;", "", "<init>", "()V", "TAG", "", "shouldUploadAlog", "", "api", "bizCode", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ReportAlogSettingsService {
    public static final ReportAlogSettingsService INSTANCE = new ReportAlogSettingsService();
    private static final String TAG = "ReportAlogSettings";

    private ReportAlogSettingsService() {
    }

    public final boolean shouldUploadAlog(String api, long bizCode) {
        Object obj;
        Intrinsics.checkNotNullParameter(api, "api");
        if (LoginUtils.INSTANCE.isEnterpriseLogin()) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            ReportAlogSettingsService reportAlogSettingsService = this;
            IReportAlogSettings iReportAlogSettings = (IReportAlogSettings) SettingsManager.obtain(IReportAlogSettings.class);
            obj = Result.constructor-impl(iReportAlogSettings != null ? iReportAlogSettings.getReportAlogConfig() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            TraeLogUtil.INSTANCE.w(TAG, "obtain report_alog settings failed", th2);
        }
        String str = (String) (Result.isFailure-impl(obj) ? null : obj);
        if (str == null) {
            return false;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(api);
            if (optJSONObject == null) {
                return false;
            }
            return optJSONObject.optBoolean(String.valueOf(bizCode), false);
        } catch (Throwable unused) {
            return false;
        }
    }
}
