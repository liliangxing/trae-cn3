package com.bytedance.trae.network;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.keva.Keva;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: DebugSettings.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b!\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050*J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0005H\u0002J\u000e\u0010.\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0005J\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012J\u001d\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010:J\u0015\u0010;\u001a\u0004\u0018\u00010 2\u0006\u00108\u001a\u00020\u0005¢\u0006\u0002\u0010<J(\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00122\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012J\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012J\u001a\u0010@\u001a\u00020,2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012J\u0016\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005J\u000e\u0010D\u001a\u00020,2\u0006\u0010C\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R$\u0010\"\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010!\"\u0004\b#\u0010$R$\u0010%\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR\u0011\u0010(\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b(\u0010!R$\u00100\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010!\"\u0004\b2\u0010$R$\u00103\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010!\"\u0004\b5\u0010$R\u000e\u00106\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R$\u0010G\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bH\u0010\u001c\"\u0004\bI\u0010\u001eR\u0011\u0010J\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\bJ\u0010!R$\u0010K\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bK\u0010!\"\u0004\bL\u0010$¨\u0006M"}, d2 = {"Lcom/bytedance/trae/network/DebugSettings;", "", "<init>", "()V", "REPO_NAME", "", "KEY_PPE_ENV", "KEY_PPE_HISTORY", "KEY_ENV_LANE", "KEY_FORCE_TOKEN_REFRESH", "KEY_MOCK_DID", "KEY_CUSTOM_HEADERS", "KEY_ENTERPRISE_ENV", "KEY_DEBUG_FLOATING_BUTTON", "KEY_NOTIFICATION_BOE", "MAX_HISTORY_SIZE", "", "cachedCustomHeaders", "", "repo", "Lcom/bytedance/keva/Keva;", "getRepo", "()Lcom/bytedance/keva/Keva;", "repo$delegate", "Lkotlin/Lazy;", "value", "ppeEnv", "getPpeEnv", "()Ljava/lang/String;", "setPpeEnv", "(Ljava/lang/String;)V", "isPpeEnabled", "", "()Z", "isDeviceManagerMockDid", "setDeviceManagerMockDid", "(Z)V", "envLane", "getEnvLane", "setEnvLane", "isEnvLaneCustomized", "getPpeHistory", "", "addPpeHistory", "", PrefetchRequestConfig.PARAM_TYPE_ENV, "removePpeHistory", "getPpeHeaders", "forceTokenRefresh", "getForceTokenRefresh", "setForceTokenRefresh", "notificationBoe", "getNotificationBoe", "setNotificationBoe", "KEY_FEATURE_OVERRIDE_PREFIX", "setFeatureOverride", "featureKey", "enabled", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getFeatureOverride", "(Ljava/lang/String;)Ljava/lang/Boolean;", "buildDefaultHeaders", "extras", "getCustomHeaders", "setCustomHeaders", "headers", "addCustomHeader", "key", "removeCustomHeader", "ENTERPRISE_ENV_ONLINE", "ENTERPRISE_ENV_TEST", "enterpriseEnv", "getEnterpriseEnv", "setEnterpriseEnv", "isEnterpriseTestEnv", "isDebugFloatingButtonEnabled", "setDebugFloatingButtonEnabled", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DebugSettings {
    public static final String ENTERPRISE_ENV_ONLINE = "ONLINE";
    public static final String ENTERPRISE_ENV_TEST = "TEST";
    private static final String KEY_CUSTOM_HEADERS = "custom_headers";
    private static final String KEY_DEBUG_FLOATING_BUTTON = "debug_floating_button_enabled";
    private static final String KEY_ENTERPRISE_ENV = "enterprise_env";
    private static final String KEY_ENV_LANE = "env_lane";
    private static final String KEY_FEATURE_OVERRIDE_PREFIX = "feature_override_";
    private static final String KEY_FORCE_TOKEN_REFRESH = "force_token_refresh";
    private static final String KEY_MOCK_DID = "device_manager_mock_did";
    private static final String KEY_NOTIFICATION_BOE = "notification_boe";
    private static final String KEY_PPE_ENV = "ppe_env";
    private static final String KEY_PPE_HISTORY = "ppe_history";
    private static final int MAX_HISTORY_SIZE = 10;
    private static final String REPO_NAME = "debug_settings";
    private static volatile Map<String, String> cachedCustomHeaders;
    public static final DebugSettings INSTANCE = new DebugSettings();

    /* renamed from: repo$delegate, reason: from kotlin metadata */
    private static final Lazy repo = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.network.DebugSettings$$ExternalSyntheticLambda0
        public final Object invoke() {
            Keva repo_delegate$lambda$0;
            repo_delegate$lambda$0 = DebugSettings.repo_delegate$lambda$0();
            return repo_delegate$lambda$0;
        }
    });

    private DebugSettings() {
    }

    private final Keva getRepo() {
        Object value = repo.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Keva) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Keva repo_delegate$lambda$0() {
        return Keva.getRepo(REPO_NAME, 0);
    }

    public final String getPpeEnv() {
        String string = getRepo().getString(KEY_PPE_ENV, "");
        return string == null ? "" : string;
    }

    public final void setPpeEnv(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        getRepo().storeString(KEY_PPE_ENV, str);
        if (str.length() > 0) {
            addPpeHistory(str);
        }
    }

    public final boolean isPpeEnabled() {
        return getPpeEnv().length() > 0;
    }

    public final boolean isDeviceManagerMockDid() {
        return getRepo().getBoolean(KEY_MOCK_DID, false);
    }

    public final void setDeviceManagerMockDid(boolean z) {
        getRepo().storeBoolean(KEY_MOCK_DID, z);
    }

    public final String getEnvLane() {
        String string = getRepo().getString(KEY_ENV_LANE, "");
        return string == null ? "" : string;
    }

    public final void setEnvLane(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        getRepo().storeString(KEY_ENV_LANE, str);
    }

    public final boolean isEnvLaneCustomized() {
        String string = getRepo().getString(KEY_ENV_LANE, "");
        return (string != null ? string : "").length() > 0;
    }

    public final List<String> getPpeHistory() {
        String string = getRepo().getString(KEY_PPE_HISTORY, "");
        String str = string != null ? string : "";
        if (str.length() == 0) {
            return CollectionsKt.emptyList();
        }
        List split$default = StringsKt.split$default(str, new String[]{"\n"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final void addPpeHistory(String env) {
        List mutableList = CollectionsKt.toMutableList(getPpeHistory());
        mutableList.remove(env);
        mutableList.add(0, env);
        if (mutableList.size() > 10) {
            mutableList.subList(10, mutableList.size()).clear();
        }
        getRepo().storeString(KEY_PPE_HISTORY, CollectionsKt.joinToString$default(mutableList, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
    }

    public final void removePpeHistory(String env) {
        Intrinsics.checkNotNullParameter(env, PrefetchRequestConfig.PARAM_TYPE_ENV);
        List mutableList = CollectionsKt.toMutableList(getPpeHistory());
        mutableList.remove(env);
        getRepo().storeString(KEY_PPE_HISTORY, CollectionsKt.joinToString$default(mutableList, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
    }

    public final Map<String, String> getPpeHeaders() {
        String ppeEnv = getPpeEnv();
        return ppeEnv.length() == 0 ? MapsKt.emptyMap() : MapsKt.mapOf(new Pair[]{TuplesKt.to("X-Use-PPE", "1"), TuplesKt.to("X-TT-ENV", ppeEnv)});
    }

    public final boolean getForceTokenRefresh() {
        return getRepo().getBoolean(KEY_FORCE_TOKEN_REFRESH, false);
    }

    public final void setForceTokenRefresh(boolean z) {
        getRepo().storeBoolean(KEY_FORCE_TOKEN_REFRESH, z);
    }

    public final boolean getNotificationBoe() {
        return getRepo().getBoolean(KEY_NOTIFICATION_BOE, false);
    }

    public final void setNotificationBoe(boolean z) {
        getRepo().storeBoolean(KEY_NOTIFICATION_BOE, z);
    }

    public final void setFeatureOverride(String featureKey, Boolean enabled) {
        Intrinsics.checkNotNullParameter(featureKey, "featureKey");
        String str = KEY_FEATURE_OVERRIDE_PREFIX + featureKey;
        if (enabled == null) {
            getRepo().storeString(str, "");
        } else {
            getRepo().storeString(str, enabled.toString());
        }
    }

    public final Boolean getFeatureOverride(String featureKey) {
        Intrinsics.checkNotNullParameter(featureKey, "featureKey");
        String string = getRepo().getString(KEY_FEATURE_OVERRIDE_PREFIX + featureKey, "");
        return StringsKt.toBooleanStrictOrNull(string != null ? string : "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Map buildDefaultHeaders$default(DebugSettings debugSettings, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        return debugSettings.buildDefaultHeaders(map);
    }

    public final Map<String, String> buildDefaultHeaders(Map<String, String> extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        return DefaultHeaderBuilder.INSTANCE.build(getPpeHeaders(), getEnvLane(), MapsKt.plus(getCustomHeaders(), extras));
    }

    public final Map<String, String> getCustomHeaders() {
        Map<String, String> map = cachedCustomHeaders;
        if (map != null) {
            return map;
        }
        String string = getRepo().getString(KEY_CUSTOM_HEADERS, "");
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return MapsKt.emptyMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
            while (keys.hasNext()) {
                String next = keys.next();
                linkedHashMap.put(next, jSONObject.optString(next, ""));
            }
            cachedCustomHeaders = linkedHashMap;
            return linkedHashMap;
        } catch (Exception unused) {
            return MapsKt.emptyMap();
        }
    }

    public final void setCustomHeaders(Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        cachedCustomHeaders = null;
        if (headers.isEmpty()) {
            getRepo().storeString(KEY_CUSTOM_HEADERS, "");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        getRepo().storeString(KEY_CUSTOM_HEADERS, jSONObject.toString());
    }

    public final void addCustomHeader(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Map<String, String> mutableMap = MapsKt.toMutableMap(getCustomHeaders());
        mutableMap.put(key, value);
        setCustomHeaders(mutableMap);
    }

    public final void removeCustomHeader(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, String> mutableMap = MapsKt.toMutableMap(getCustomHeaders());
        mutableMap.remove(key);
        setCustomHeaders(mutableMap);
    }

    public final String getEnterpriseEnv() {
        String string = getRepo().getString(KEY_ENTERPRISE_ENV, ENTERPRISE_ENV_ONLINE);
        return string == null ? ENTERPRISE_ENV_ONLINE : string;
    }

    public final void setEnterpriseEnv(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        getRepo().storeString(KEY_ENTERPRISE_ENV, str);
    }

    public final boolean isEnterpriseTestEnv() {
        return Intrinsics.areEqual(getEnterpriseEnv(), ENTERPRISE_ENV_TEST);
    }

    public final boolean isDebugFloatingButtonEnabled() {
        return getRepo().getBoolean(KEY_DEBUG_FLOATING_BUTTON, true);
    }

    public final void setDebugFloatingButtonEnabled(boolean z) {
        getRepo().storeBoolean(KEY_DEBUG_FLOATING_BUTTON, z);
    }
}
