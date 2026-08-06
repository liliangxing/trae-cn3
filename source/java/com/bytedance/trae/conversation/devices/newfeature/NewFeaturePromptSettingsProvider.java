package com.bytedance.trae.conversation.devices.newfeature;

import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: NewFeaturePromptSettings.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0002J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\fJ\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0014J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0017J\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u000e\u0010\u001b\u001a\u0004\u0018\u00010\u001a*\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;", "", "<init>", "()V", "TAG", "", "getConfig", "Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;", "remotePromptConfig", "getRemotePromptConfig", "parseConfig", "rawConfig", "parseConfig$conversation_mainlandRelease", "optBoolean", "", "Lcom/google/gson/JsonObject;", "key", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "optInt", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "optLong", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Long;", "optPriority", "", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "toProductTypeOrNull", "Lcom/google/gson/JsonElement;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class NewFeaturePromptSettingsProvider {
    public static final NewFeaturePromptSettingsProvider INSTANCE = new NewFeaturePromptSettingsProvider();
    private static final String TAG = "NewFeaturePromptSettings";

    public final NewFeaturePromptConfig getConfig() {
        return getConfig$default(this, null, 1, null);
    }

    private NewFeaturePromptSettingsProvider() {
    }

    public static /* synthetic */ NewFeaturePromptConfig getConfig$default(NewFeaturePromptSettingsProvider newFeaturePromptSettingsProvider, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newFeaturePromptSettingsProvider.getRemotePromptConfig();
        }
        return newFeaturePromptSettingsProvider.getConfig(str);
    }

    public final NewFeaturePromptConfig getConfig(String remotePromptConfig) {
        Object obj;
        String str = remotePromptConfig;
        if (!(str == null || StringsKt.isBlank(str))) {
            try {
                Result.Companion companion = Result.Companion;
                NewFeaturePromptSettingsProvider newFeaturePromptSettingsProvider = this;
                obj = Result.constructor-impl(parseConfig$conversation_mainlandRelease(remotePromptConfig));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                try {
                    Result.Companion companion3 = Result.Companion;
                    TraeLogUtil.INSTANCE.w(TAG, "parse mobile ide guide prompt config failed, rawConfig=" + remotePromptConfig, th2);
                    Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th3) {
                    Result.Companion companion4 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th3));
                }
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            NewFeaturePromptConfig newFeaturePromptConfig = (NewFeaturePromptConfig) obj;
            return newFeaturePromptConfig == null ? new NewFeaturePromptConfig(false, 0, null, 0L, 15, null) : newFeaturePromptConfig;
        }
        return new NewFeaturePromptConfig(false, 0, null, 0L, 15, null);
    }

    private final String getRemotePromptConfig() {
        Object obj;
        String str;
        try {
            Result.Companion companion = Result.Companion;
            NewFeaturePromptSettingsProvider newFeaturePromptSettingsProvider = this;
            IMobileIdeGuidePromptSettings iMobileIdeGuidePromptSettings = (IMobileIdeGuidePromptSettings) SettingsManager.obtain(IMobileIdeGuidePromptSettings.class);
            if (iMobileIdeGuidePromptSettings == null || (str = iMobileIdeGuidePromptSettings.getMobileIdeGuidePrompt()) == null || !(!StringsKt.isBlank(str))) {
                str = null;
            }
            obj = Result.constructor-impl(str);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            try {
                Result.Companion companion3 = Result.Companion;
                TraeLogUtil.INSTANCE.w(TAG, "obtain mobile ide guide prompt settings failed", th2);
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th3) {
                Result.Companion companion4 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th3));
            }
        }
        return (String) (Result.isFailure-impl(obj) ? null : obj);
    }

    public final NewFeaturePromptConfig parseConfig$conversation_mainlandRelease(String rawConfig) {
        long longValue;
        Intrinsics.checkNotNullParameter(rawConfig, "rawConfig");
        JsonObject asJsonObject = JsonParser.parseString(rawConfig).getAsJsonObject();
        Intrinsics.checkNotNull(asJsonObject);
        Boolean optBoolean = optBoolean(asJsonObject, "enable");
        boolean booleanValue = optBoolean != null ? optBoolean.booleanValue() : false;
        Integer optInt = optInt(asJsonObject, "campaign_version");
        int coerceAtLeast = RangesKt.coerceAtLeast((optInt == null && (optInt = optInt(asJsonObject, "version")) == null) ? 1 : optInt.intValue(), 1);
        List<DeviceProductType> optPriority = optPriority(asJsonObject, "priority");
        Long optLong = optLong(asJsonObject, "minIntervalMillis");
        if (optLong != null) {
            longValue = optLong.longValue();
        } else {
            Long optLong2 = optLong(asJsonObject, "minInterval");
            longValue = optLong2 != null ? optLong2.longValue() : 86400000L;
        }
        return new NewFeaturePromptConfig(booleanValue, coerceAtLeast, optPriority, longValue);
    }

    private final Boolean optBoolean(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement != null) {
            return Boolean.valueOf(jsonElement.getAsBoolean());
        }
        return null;
    }

    private final Integer optInt(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement != null) {
            return Integer.valueOf(jsonElement.getAsInt());
        }
        return null;
    }

    private final Long optLong(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement != null) {
            return Long.valueOf(jsonElement.getAsLong());
        }
        return null;
    }

    private final List<DeviceProductType> optPriority(JsonObject jsonObject, String str) {
        Iterable<JsonElement> asJsonArray;
        JsonElement jsonElement = jsonObject.get(str);
        ArrayList arrayList = null;
        if (jsonElement != null) {
            if (!jsonElement.isJsonArray()) {
                jsonElement = null;
            }
            if (jsonElement != null && (asJsonArray = jsonElement.getAsJsonArray()) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (JsonElement jsonElement2 : asJsonArray) {
                    NewFeaturePromptSettingsProvider newFeaturePromptSettingsProvider = INSTANCE;
                    Intrinsics.checkNotNull(jsonElement2);
                    DeviceProductType productTypeOrNull = newFeaturePromptSettingsProvider.toProductTypeOrNull(jsonElement2);
                    if (productTypeOrNull != null) {
                        arrayList2.add(productTypeOrNull);
                    }
                }
                arrayList = arrayList2;
            }
        }
        if (arrayList == null) {
            arrayList = CollectionsKt.emptyList();
        }
        List<DeviceProductType> list = arrayList;
        if (list.isEmpty()) {
            list = NewFeaturePromptConfig.INSTANCE.getDEFAULT_PRIORITY();
        }
        return list;
    }

    private final DeviceProductType toProductTypeOrNull(JsonElement jsonElement) {
        String asString;
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null || (asString = jsonElement.getAsString()) == null) {
            return null;
        }
        for (DeviceProductType deviceProductType : DeviceProductType.values()) {
            boolean z = true;
            if (!StringsKt.equals(deviceProductType.name(), asString, true) && !StringsKt.equals(deviceProductType.getCliTypeValue(), asString, true)) {
                z = false;
            }
            if (z) {
                return deviceProductType;
            }
        }
        return null;
    }
}
