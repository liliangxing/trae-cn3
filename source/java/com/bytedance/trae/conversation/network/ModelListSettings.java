package com.bytedance.trae.conversation.network;

import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* compiled from: IModelListSettings.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\b\u0010\t\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/network/ModelListSettings;", "", "<init>", "()V", "TAG", "", "isBelowConfiguredMinIdeVersion", "", "ideVersion", "minSupportedIdeVersion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ModelListSettings {
    public static final ModelListSettings INSTANCE = new ModelListSettings();
    private static final String TAG = "ModelListSettings";

    private ModelListSettings() {
    }

    public final boolean isBelowConfiguredMinIdeVersion(String ideVersion) {
        return IdeVersionGate.INSTANCE.shouldBlockByMinimum(ideVersion, minSupportedIdeVersion());
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0137 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String minSupportedIdeVersion() {
        Object obj;
        Object obj2;
        boolean z;
        String str;
        String str2;
        try {
            Result.Companion companion = Result.Companion;
            ModelListSettings modelListSettings = this;
            IModelListSettings iModelListSettings = (IModelListSettings) SettingsManager.obtain(IModelListSettings.class);
            obj = Result.constructor-impl(iModelListSettings != null ? iModelListSettings.getCliModelListMinIdeVersion() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            TraeLogUtil.INSTANCE.w(TAG, "obtain model list settings failed", th2);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String str3 = (String) obj;
        String str4 = str3;
        if (str4 == null || StringsKt.isBlank(str4)) {
            str3 = null;
        }
        String str5 = str3;
        if (str5 == null || StringsKt.isBlank(str5)) {
            TraeLogUtil.INSTANCE.w(TAG, "minSupportedIdeVersion: settings config is null");
            return null;
        }
        try {
            Result.Companion companion3 = Result.Companion;
            ModelListSettings modelListSettings2 = this;
            obj2 = Result.constructor-impl(JsonParser.parseString(str3).getAsJsonObject());
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th3));
        }
        Throwable th4 = Result.exceptionOrNull-impl(obj2);
        if (th4 != null) {
            TraeLogUtil.INSTANCE.w(TAG, "minSupportedIdeVersion: parse settings config failed, rawConfig=" + str3, th4);
        }
        if (Result.isFailure-impl(obj2)) {
            obj2 = null;
        }
        JsonObject jsonObject = (JsonObject) obj2;
        if (jsonObject == null) {
            return null;
        }
        JsonElement jsonElement = jsonObject.get("enable");
        if (jsonElement != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null && jsonElement.getAsBoolean()) {
                z = true;
                if (z) {
                    TraeLogUtil.INSTANCE.w(TAG, "minSupportedIdeVersion: disabled by settings, rawConfig=" + str3);
                    return null;
                }
                JsonElement jsonElement2 = jsonObject.get(AppHost.INSTANCE.isOversea() ? "i18n_solo_min_version" : "cn_solo_min_version");
                if (jsonElement2 != null) {
                    if (!jsonElement2.isJsonPrimitive()) {
                        jsonElement2 = null;
                    }
                    if (jsonElement2 != null) {
                        str = jsonElement2.getAsString();
                        str2 = str;
                        if (str2 != null || StringsKt.isBlank(str2)) {
                            return str;
                        }
                        TraeLogUtil.INSTANCE.w(TAG, "minSupportedIdeVersion: version missing, isOversea=" + AppHost.INSTANCE.isOversea() + ", rawConfig=" + str3);
                        return null;
                    }
                }
                str = null;
                str2 = str;
                if (str2 != null || StringsKt.isBlank(str2)) {
                }
            }
        }
        z = false;
        if (z) {
        }
    }
}
