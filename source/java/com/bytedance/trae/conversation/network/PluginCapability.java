package com.bytedance.trae.conversation.network;

import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* compiled from: PluginCapability.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0019\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/network/PluginCapability;", "", "<init>", "()V", "TAG", "", "SOLO_MIN_VERSION_KEY", "DEFAULT_TASK_PLUGIN_MIN_IDE_VERSION", "isSupported", "", "isLocalTask", "ideVersion", "minSupportedIdeVersion", "parseSettingsMinSupportedIdeVersion", "rawConfig", "parseSettingsMinSupportedIdeVersion$conversation_mainlandRelease", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginCapability {
    private static final String DEFAULT_TASK_PLUGIN_MIN_IDE_VERSION = "0.1.27";
    public static final PluginCapability INSTANCE = new PluginCapability();
    private static final String SOLO_MIN_VERSION_KEY = "solo_min_version";
    private static final String TAG = "PluginCapability";

    private PluginCapability() {
    }

    public final boolean isSupported(boolean isLocalTask, String ideVersion) {
        if (isLocalTask) {
            return IdeVersionComparator.INSTANCE.isGreaterOrEqual(ideVersion, minSupportedIdeVersion());
        }
        return true;
    }

    public final String minSupportedIdeVersion() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            PluginCapability pluginCapability = this;
            IPluginSettings iPluginSettings = (IPluginSettings) SettingsManager.obtain(IPluginSettings.class);
            obj = Result.constructor-impl(iPluginSettings != null ? iPluginSettings.getCliTaskPluginMinIdeVersion() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            TraeLogUtil.INSTANCE.w(TAG, "obtain plugin settings failed", th2);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String str = (String) obj;
        String str2 = str;
        String str3 = str2 == null || StringsKt.isBlank(str2) ? null : str;
        String str4 = str3;
        if (str4 == null || StringsKt.isBlank(str4)) {
            return DEFAULT_TASK_PLUGIN_MIN_IDE_VERSION;
        }
        String parseSettingsMinSupportedIdeVersion$conversation_mainlandRelease = parseSettingsMinSupportedIdeVersion$conversation_mainlandRelease(str3);
        String str5 = parseSettingsMinSupportedIdeVersion$conversation_mainlandRelease;
        if (!(str5 == null || StringsKt.isBlank(str5))) {
            return IdeVersionComparator.INSTANCE.isGreaterOrEqual(parseSettingsMinSupportedIdeVersion$conversation_mainlandRelease, DEFAULT_TASK_PLUGIN_MIN_IDE_VERSION) ? parseSettingsMinSupportedIdeVersion$conversation_mainlandRelease : DEFAULT_TASK_PLUGIN_MIN_IDE_VERSION;
        }
        TraeLogUtil.INSTANCE.w(TAG, "minSupportedIdeVersion: version missing, rawConfig=" + str3);
        return DEFAULT_TASK_PLUGIN_MIN_IDE_VERSION;
    }

    public final String parseSettingsMinSupportedIdeVersion$conversation_mainlandRelease(String rawConfig) {
        Object obj;
        JsonElement jsonElement;
        String asString;
        String str = rawConfig;
        if (str == null || StringsKt.isBlank(str)) {
            rawConfig = null;
        }
        if (rawConfig == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            PluginCapability pluginCapability = this;
            obj = Result.constructor-impl(JsonParser.parseString(rawConfig).getAsJsonObject());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            TraeLogUtil.INSTANCE.w(TAG, "minSupportedIdeVersion: parse settings config failed, rawConfig=" + rawConfig, th2);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        JsonObject jsonObject = (JsonObject) obj;
        if (jsonObject == null || (jsonElement = jsonObject.get(SOLO_MIN_VERSION_KEY)) == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null || (asString = jsonElement.getAsString()) == null || !(!StringsKt.isBlank(asString))) {
            return null;
        }
        return asString;
    }
}
