package com.bytedance.sdk.xbridge.cn.utils;

import com.bytedance.sdk.xbridge.cn.auth.ILocalStorage;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: JsonOptConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0001H\u0007J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u0018\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/utils/JsonOptConfig;", "", "()V", "jsonOptEnable", "", "getJsonOptEnable$annotations", "enableJsonOpt", "", "enable", "isInvalid", "config", "isJsonOptEnable", "jsonObject", "Lorg/json/JSONObject;", "localConfig", "localStorage", "Lcom/bytedance/sdk/xbridge/cn/auth/ILocalStorage;", "key", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class JsonOptConfig {
    public static final JsonOptConfig INSTANCE = new JsonOptConfig();
    private static volatile boolean jsonOptEnable;

    @JvmStatic
    private static /* synthetic */ void getJsonOptEnable$annotations() {
    }

    private JsonOptConfig() {
    }

    @JvmStatic
    public static final void enableJsonOpt(boolean enable) {
        jsonOptEnable = enable;
    }

    @JvmStatic
    public static final boolean isJsonOptEnable() {
        return jsonOptEnable;
    }

    @JvmStatic
    public static final Object localConfig(ILocalStorage localStorage, String key) {
        JSONObject readObject;
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        Intrinsics.checkNotNullParameter(key, "key");
        return (!jsonOptEnable || (readObject = localStorage.readObject(key)) == null) ? localStorage.read(key) : readObject;
    }

    @JvmStatic
    public static final boolean isInvalid(Object config) {
        if (config == null) {
            return true;
        }
        return config instanceof String ? StringsKt.isBlank((CharSequence) config) : !(config instanceof JSONObject) || ((JSONObject) config).length() == 0;
    }

    @JvmStatic
    public static final JSONObject jsonObject(Object config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return config instanceof JSONObject ? (JSONObject) config : config instanceof String ? new JSONObject((String) config) : new JSONObject();
    }
}
