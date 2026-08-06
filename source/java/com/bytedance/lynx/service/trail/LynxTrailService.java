package com.bytedance.lynx.service.trail;

import android.content.Context;
import com.bytedance.lynx.service.settings.LynxSettingsManager;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.service.ILynxTrailServiceExtension;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: LynxTrailService.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\bJ\u0016\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/lynx/service/trail/LynxTrailService;", "Lcom/lynx/tasm/service/ILynxTrailService;", "Lcom/lynx/tasm/service/ILynxTrailServiceExtension;", "()V", "TAG", "", "TRACE_TRAIL_PROXY_STRING_VALUE_FOR_EXPERIMENT_KEY", "abExperimentAdapter", "Lcom/bytedance/lynx/service/trail/ILynxABExperimentAdapter;", "getAllValues", "", "", "objectValueForTrailKey", "key", "objectValueForTrailKeyFromSettings", "onInitialize", "", "context", "Landroid/content/Context;", "parseLynxViewBuilder", "builder", "Lcom/lynx/tasm/LynxViewBuilder;", "setABExperimentAdapter", "adapter", "setSettingsWithTime", "jsonString", "time", "", "stringValueForTrailKey", "stringValueForTrailKeyFromLibra", "stringValueForTrailKeyFromSettings", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxTrailService implements ILynxTrailService, ILynxTrailServiceExtension {
    public static final LynxTrailService INSTANCE = new LynxTrailService();
    private static final String TAG = "LynxTrailService";
    public static final String TRACE_TRAIL_PROXY_STRING_VALUE_FOR_EXPERIMENT_KEY = "LynxTrailServiceProxy.stringValueForExperimentKey";
    private static ILynxABExperimentAdapter abExperimentAdapter;

    private LynxTrailService() {
    }

    public final void setABExperimentAdapter(ILynxABExperimentAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        abExperimentAdapter = adapter;
    }

    public void onInitialize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LynxSettingsManager.inst().initialize(context);
    }

    public String stringValueForTrailKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String stringValueForTrailKeyFromLibra = stringValueForTrailKeyFromLibra(key);
        if (stringValueForTrailKeyFromLibra == null) {
            stringValueForTrailKeyFromLibra = stringValueForTrailKeyFromSettings(key);
        }
        LLog.i(TAG, "get stringValue: " + stringValueForTrailKeyFromLibra + ", forTrailKey: " + key);
        return stringValueForTrailKeyFromLibra;
    }

    public Object objectValueForTrailKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object stringValueForTrailKeyFromLibra = stringValueForTrailKeyFromLibra(key);
        if (stringValueForTrailKeyFromLibra == null) {
            stringValueForTrailKeyFromLibra = objectValueForTrailKeyFromSettings(key);
        }
        LLog.i(TAG, "get objectValue: " + stringValueForTrailKeyFromLibra + ", forTrailKey: " + key + ", valueType: " + (stringValueForTrailKeyFromLibra != null ? Reflection.getOrCreateKotlinClass(stringValueForTrailKeyFromLibra.getClass()) : "null"));
        return stringValueForTrailKeyFromLibra;
    }

    private final String stringValueForTrailKeyFromLibra(String key) {
        ILynxABExperimentAdapter iLynxABExperimentAdapter = abExperimentAdapter;
        String stringValueForTrailKey = iLynxABExperimentAdapter != null ? iLynxABExperimentAdapter.stringValueForTrailKey(key) : null;
        LLog.i(TAG, "get ExperimentValue: " + stringValueForTrailKey + ", for key: " + key);
        if (stringValueForTrailKey == null) {
            return null;
        }
        String str = stringValueForTrailKey;
        return str.length() == 0 ? null : str;
    }

    private final String stringValueForTrailKeyFromSettings(String key) {
        return LynxSettingsManager.inst().getStringFromSettings(key);
    }

    private final Object objectValueForTrailKeyFromSettings(String key) {
        return LynxSettingsManager.inst().getObjectFromSettings(key);
    }

    public final void setSettingsWithTime(String jsonString, long time) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        LynxSettingsManager.inst().setSettingsWithTime(jsonString, time);
    }

    public Map<String, Object> getAllValues() {
        HashMap<String, Object> settingsCopy = LynxSettingsManager.inst().getSettingsCopy();
        Intrinsics.checkNotNullExpressionValue(settingsCopy, "inst().settingsCopy");
        return settingsCopy;
    }

    public void parseLynxViewBuilder(LynxViewBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        LynxViewConfigProcessor.INSTANCE.parseLynxViewBuilder(builder);
    }
}
