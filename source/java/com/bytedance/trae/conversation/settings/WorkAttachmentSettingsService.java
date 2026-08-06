package com.bytedance.trae.conversation.settings;

import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.trae.conversation.imageupload.ImageUploadConstants;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* compiled from: IQuerySettings.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettingsService;", "", "<init>", "()V", "TAG", "", "getWorkAttachmentSettings", "Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class WorkAttachmentSettingsService {
    public static final WorkAttachmentSettingsService INSTANCE = new WorkAttachmentSettingsService();
    private static final String TAG = "WorkAttachmentSettings";

    private WorkAttachmentSettingsService() {
    }

    public final WorkAttachmentSettings getWorkAttachmentSettings() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            WorkAttachmentSettingsService workAttachmentSettingsService = this;
            IQuerySettings iQuerySettings = (IQuerySettings) SettingsManager.obtain(IQuerySettings.class);
            obj = Result.constructor-impl(iQuerySettings != null ? iQuerySettings.getWorkAttachmentSettings() : null);
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
                long j = 1024;
                return new WorkAttachmentSettings(jSONObject.optLong("work_attachment_total_count", 20L), jSONObject.optLong("work_attachment_total_size_MB", 1024L) * j * j, jSONObject.optLong("work_attachment_single_image_size_MB", 100L) * j * j, jSONObject.optLong("work_attachment_single_file_size_MB", 200L) * j * j, jSONObject.optLong("code_attachment_single_file_size_MB", 20L) * j * j, jSONObject.optLong("code_attachment_imgae_total_count", 5L));
            } catch (Throwable unused) {
            }
        }
        return new WorkAttachmentSettings(20L, 1073741824L, 104857600L, 209715200L, ImageUploadConstants.MAX_FILE_SIZE_BYTES, 5L);
    }
}
