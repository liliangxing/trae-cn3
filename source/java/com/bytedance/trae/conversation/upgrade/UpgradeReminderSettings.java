package com.bytedance.trae.conversation.upgrade;

import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.trae.common.apphost.AppHost;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UpgradeReminderSettings.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;", "", "<init>", "()V", "E2E_PREF", "", "KEY_SETTINGS_OVERRIDE", "SETTINGS_INSTRUMENTATION_CLASS", "getConfig", "Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;", "parse", AccountMonitorConstants.CommonParameter.RAW, "Lcom/google/gson/JsonObject;", "e2eOverride", "isInstrumentationRun", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UpgradeReminderSettings {
    private static final String E2E_PREF = "upgrade_reminder_e2e";
    public static final UpgradeReminderSettings INSTANCE = new UpgradeReminderSettings();
    private static final String KEY_SETTINGS_OVERRIDE = "settings_override";
    private static final String SETTINGS_INSTRUMENTATION_CLASS = "androidx.test.platform.app.InstrumentationRegistry";

    private UpgradeReminderSettings() {
    }

    public final UpgradeReminderConfig getConfig() {
        Object obj;
        JsonObject e2eOverride = e2eOverride();
        if (e2eOverride == null) {
            try {
                Result.Companion companion = Result.Companion;
                UpgradeReminderSettings upgradeReminderSettings = this;
                IUpgradeReminderSettings iUpgradeReminderSettings = (IUpgradeReminderSettings) SettingsManager.obtain(IUpgradeReminderSettings.class);
                obj = Result.constructor-impl(iUpgradeReminderSettings != null ? iUpgradeReminderSettings.getUpgradeReminderConfig() : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            e2eOverride = (JsonObject) (Result.isFailure-impl(obj) ? null : obj);
        }
        return parse(e2eOverride);
    }

    private final UpgradeReminderConfig parse(JsonObject raw) {
        JsonElement jsonElement;
        JsonPrimitive asJsonPrimitive;
        JsonElement jsonElement2;
        JsonObject asJsonObject;
        JsonElement jsonElement3;
        JsonPrimitive asJsonPrimitive2;
        Long l;
        if (raw != null && (jsonElement = raw.get("enabled")) != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null && (asJsonPrimitive = jsonElement.getAsJsonPrimitive()) != null) {
                if (!asJsonPrimitive.isBoolean()) {
                    asJsonPrimitive = null;
                }
                if (asJsonPrimitive != null && asJsonPrimitive.getAsBoolean() && (jsonElement2 = raw.get("version_config")) != null) {
                    if (!jsonElement2.isJsonObject()) {
                        jsonElement2 = null;
                    }
                    if (jsonElement2 != null && (asJsonObject = jsonElement2.getAsJsonObject()) != null && (jsonElement3 = asJsonObject.get("recommended_highest")) != null) {
                        if (!jsonElement3.isJsonPrimitive()) {
                            jsonElement3 = null;
                        }
                        if (jsonElement3 != null && (asJsonPrimitive2 = jsonElement3.getAsJsonPrimitive()) != null) {
                            if (asJsonPrimitive2.isNumber()) {
                                l = Long.valueOf(asJsonPrimitive2.getAsLong());
                            } else if (asJsonPrimitive2.isString()) {
                                String asString = asJsonPrimitive2.getAsString();
                                Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
                                l = StringsKt.toLongOrNull(asString);
                            } else {
                                l = null;
                            }
                            if (l != null) {
                                if (!(l.longValue() > 0)) {
                                    l = null;
                                }
                                if (l != null) {
                                    return new UpgradeReminderConfig(true, l.longValue());
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private final JsonObject e2eOverride() {
        Object obj;
        Object obj2;
        if (!AppHost.INSTANCE.isDebug() || !isInstrumentationRun()) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            UpgradeReminderSettings upgradeReminderSettings = this;
            obj = Result.constructor-impl(AppHost.INSTANCE.getApplication().getSharedPreferences(E2E_PREF, 0).getString(KEY_SETTINGS_OVERRIDE, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String str = (String) obj;
        if (str == null) {
            return null;
        }
        if (!(!StringsKt.isBlank(str))) {
            str = null;
        }
        if (str == null) {
            return null;
        }
        try {
            Result.Companion companion3 = Result.Companion;
            UpgradeReminderSettings upgradeReminderSettings2 = this;
            JsonElement parseString = JsonParser.parseString(str);
            if (!parseString.isJsonObject()) {
                parseString = null;
            }
            obj2 = Result.constructor-impl(parseString != null ? parseString.getAsJsonObject() : null);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        return (JsonObject) (Result.isFailure-impl(obj2) ? null : obj2);
    }

    private final boolean isInstrumentationRun() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            UpgradeReminderSettings upgradeReminderSettings = this;
            Class.forName(SETTINGS_INSTRUMENTATION_CLASS);
            obj = Result.constructor-impl(true);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = false;
        }
        return ((Boolean) obj).booleanValue();
    }
}
