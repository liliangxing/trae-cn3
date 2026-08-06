package com.bytedance.trae.conversation.products;

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

/* compiled from: IHtmlShareSettings.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlShareSettings;", "", "<init>", "()V", "TAG", "", "getHtmlShareSettingsItem", "Lcom/bytedance/trae/conversation/products/HtmlShareSettingsItem;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HtmlShareSettings {
    public static final HtmlShareSettings INSTANCE = new HtmlShareSettings();
    private static final String TAG = "HtmlShareSettings";

    private HtmlShareSettings() {
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final HtmlShareSettingsItem getHtmlShareSettingsItem() {
        Object obj;
        Object obj2;
        String str;
        JsonElement jsonElement;
        boolean z;
        String str2;
        try {
            Result.Companion companion = Result.Companion;
            HtmlShareSettings htmlShareSettings = this;
            IHtmlShareSettings iHtmlShareSettings = (IHtmlShareSettings) SettingsManager.obtain(IHtmlShareSettings.class);
            obj = Result.constructor-impl(iHtmlShareSettings != null ? iHtmlShareSettings.getHtmlShareMinIdeVersion() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            TraeLogUtil.INSTANCE.w(TAG, "obtain html share settings failed", th2);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String str3 = (String) obj;
        String str4 = str3;
        boolean z2 = true;
        if (str4 == null || StringsKt.isBlank(str4)) {
            str3 = null;
        }
        String str5 = str3;
        if (str5 == null || StringsKt.isBlank(str5)) {
            TraeLogUtil.INSTANCE.w(TAG, "getHtmlShareSettingsItem: settings config is null");
            return new HtmlShareSettingsItem(null, false);
        }
        try {
            Result.Companion companion3 = Result.Companion;
            HtmlShareSettings htmlShareSettings2 = this;
            obj2 = Result.constructor-impl(JsonParser.parseString(str3).getAsJsonObject());
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th3));
        }
        Throwable th4 = Result.exceptionOrNull-impl(obj2);
        if (th4 != null) {
            TraeLogUtil.INSTANCE.w(TAG, "getHtmlShareSettingsItem: parse settings config failed, rawConfig=" + str3, th4);
        }
        if (Result.isFailure-impl(obj2)) {
            obj2 = null;
        }
        JsonObject jsonObject = (JsonObject) obj2;
        if (jsonObject == null) {
            return new HtmlShareSettingsItem(null, false);
        }
        JsonElement jsonElement2 = jsonObject.get("cli_min_version");
        if (jsonElement2 != null) {
            if (!jsonElement2.isJsonPrimitive()) {
                jsonElement2 = null;
            }
            if (jsonElement2 != null) {
                str = jsonElement2.getAsString();
                jsonElement = jsonObject.get("bytedance_enable");
                if (jsonElement != null) {
                    JsonElement jsonElement3 = jsonElement.isJsonPrimitive() ? jsonElement : null;
                    if (jsonElement3 != null) {
                        z = jsonElement3.getAsBoolean();
                        str2 = str;
                        if (str2 != null && !StringsKt.isBlank(str2)) {
                            z2 = false;
                        }
                        if (z2) {
                            TraeLogUtil.INSTANCE.w(TAG, "getHtmlShareSettingsItem: version missing, isOversea=" + AppHost.INSTANCE.isOversea() + ", rawConfig=" + str3);
                        }
                        return new HtmlShareSettingsItem(str, z);
                    }
                }
                z = false;
                str2 = str;
                if (str2 != null) {
                    z2 = false;
                }
                if (z2) {
                }
                return new HtmlShareSettingsItem(str, z);
            }
        }
        str = null;
        jsonElement = jsonObject.get("bytedance_enable");
        if (jsonElement != null) {
        }
        z = false;
        str2 = str;
        if (str2 != null) {
        }
        if (z2) {
        }
        return new HtmlShareSettingsItem(str, z);
    }
}
