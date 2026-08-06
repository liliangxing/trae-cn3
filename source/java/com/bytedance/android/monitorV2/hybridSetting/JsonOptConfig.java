package com.bytedance.android.monitorV2.hybridSetting;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: JsonOptConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007J\b\u0010\n\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0018\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u0018\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/JsonOptConfig;", "", "()V", "TAG", "", "isCompareEnable", "", "isCompareEnable$annotations", "isDebugEnable", "isDebugEnable$annotations", "isJsonOptEnable", "isJsonOptEnable$annotations", "enableCompare", "", "enable", "enableDebug", "enableJsonOpt", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class JsonOptConfig {
    public static final JsonOptConfig INSTANCE = new JsonOptConfig();
    private static final String TAG = "Hybrid-JsonOpt";
    private static volatile boolean isCompareEnable;
    private static volatile boolean isDebugEnable;
    private static volatile boolean isJsonOptEnable;

    @JvmStatic
    private static /* synthetic */ void isCompareEnable$annotations() {
    }

    @JvmStatic
    private static /* synthetic */ void isDebugEnable$annotations() {
    }

    @JvmStatic
    private static /* synthetic */ void isJsonOptEnable$annotations() {
    }

    private JsonOptConfig() {
    }

    @JvmStatic
    public static final void enableJsonOpt(boolean enable) {
        isJsonOptEnable = enable;
    }

    @JvmStatic
    public static final boolean isJsonOptEnable() {
        return isJsonOptEnable;
    }

    @JvmStatic
    public static final void enableDebug(boolean enable) {
        isDebugEnable = enable;
    }

    @JvmStatic
    public static final boolean isDebugEnable() {
        return isDebugEnable;
    }

    @JvmStatic
    public static final void enableCompare(boolean enable) {
        isCompareEnable = enable;
    }

    @JvmStatic
    public static final boolean isCompareEnable() {
        return isCompareEnable;
    }
}
