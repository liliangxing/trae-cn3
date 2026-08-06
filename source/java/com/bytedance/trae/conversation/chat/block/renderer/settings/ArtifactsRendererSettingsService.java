package com.bytedance.trae.conversation.chat.block.renderer.settings;

import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* compiled from: IArtifactsRendererSettings.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;", "", "<init>", "()V", "TAG", "", "getArtifactsRendererSettings", "Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactsRendererSettingsService {
    public static final ArtifactsRendererSettingsService INSTANCE = new ArtifactsRendererSettingsService();
    private static final String TAG = "ArtifactsRendererSettings";

    private ArtifactsRendererSettingsService() {
    }

    public final ArtifactsRendererSettings getArtifactsRendererSettings() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            ArtifactsRendererSettingsService artifactsRendererSettingsService = this;
            IArtifactsRendererSettings iArtifactsRendererSettings = (IArtifactsRendererSettings) SettingsManager.obtain(IArtifactsRendererSettings.class);
            obj = Result.constructor-impl(iArtifactsRendererSettings != null ? iArtifactsRendererSettings.getSettings() : null);
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
                return new ArtifactsRendererSettings(jSONObject.optBoolean("image_preview", false), jSONObject.optBoolean("html_preview", false), jSONObject.optBoolean("file_preview", false));
            } catch (Throwable unused) {
            }
        }
        return new ArtifactsRendererSettings(false, false, false);
    }
}
