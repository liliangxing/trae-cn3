package com.bytedance.trae.conversation.share;

import android.content.Context;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.ug.sdk.share.api.depend.IShareAppConfig;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: ShareAppConfigImpl.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/share/ShareAppConfigImpl;", "Lcom/bytedance/ug/sdk/share/api/depend/IShareAppConfig;", "<init>", "()V", "getAppId", "", "getDeviceId", "getExtraConfig", "Lorg/json/JSONObject;", "openPage", "", "context", "Landroid/content/Context;", "openUrl", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ShareAppConfigImpl implements IShareAppConfig {
    public void openPage(Context context, String openUrl) {
    }

    public String getAppId() {
        return String.valueOf(AppHost.INSTANCE.getAppId());
    }

    public String getDeviceId() {
        return IApplog.INSTANCE.getDeviceId();
    }

    public JSONObject getExtraConfig() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enable_hidden_watermark", false);
            jSONObject.put("hide_save_image_preview_dialog", true);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
