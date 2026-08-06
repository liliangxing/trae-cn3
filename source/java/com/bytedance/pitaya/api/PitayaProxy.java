package com.bytedance.pitaya.api;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.pitaya.api.bean.PTYProxySetting;
import com.bytedance.pitaya.api.feature.IPTYEventVerify;
import com.bytedance.pitaya.api.util.ContextContainer;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.ss.android.common.applog.GlobalEventCallback;
import com.ss.android.common.applog.TeaAgent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PitayaProxy.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014H\u0007J\b\u0010\u001b\u001a\u00020\u0010H\u0007J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\b\u0010\u001e\u001a\u00020\u0010H\u0007J\b\u0010\u001f\u001a\u00020\u0010H\u0007J\u001a\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010#H\u0007J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/pitaya/api/PitayaProxy;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "applogProxy", "Lcom/bytedance/pitaya/api/PitayaApplogProxy;", "eventVerify", "Lcom/bytedance/pitaya/api/feature/IPTYEventVerify;", "getEventVerify", "()Lcom/bytedance/pitaya/api/feature/IPTYEventVerify;", "setEventVerify", "(Lcom/bytedance/pitaya/api/feature/IPTYEventVerify;)V", "hasProxySoLoadFailed", "", "initOnce", "isProxySoLoaded", "mSetting", "Lcom/bytedance/pitaya/api/bean/PTYProxySetting;", "applogCacheSize", "", EventConstants.PARAM_SOURCE_INIT, "context", "Landroid/content/Context;", "setting", "isFeatureStoreProxyEnabled", "isValidEvent", SchemaConstants.INNER_PARAM_EVENT_NAME, "loadProxySo", "loadProxySoImpl", "onAppLogEvent", "", "extParams", "Lorg/json/JSONObject;", "processApplogCache", "callback", "Lcom/bytedance/pitaya/api/PTYApplogImplCallback;", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PitayaProxy implements ReflectionCall {
    public static final PitayaProxy INSTANCE = new PitayaProxy();
    private static final String TAG = "PTY-Proxy";
    private static volatile PitayaApplogProxy applogProxy;
    private static volatile IPTYEventVerify eventVerify;
    private static volatile boolean hasProxySoLoadFailed;
    private static volatile boolean initOnce;
    private static volatile boolean isProxySoLoaded;
    private static volatile PTYProxySetting mSetting;

    private PitayaProxy() {
    }

    public final String getTAG() {
        return TAG;
    }

    public final IPTYEventVerify getEventVerify() {
        return eventVerify;
    }

    public final void setEventVerify(IPTYEventVerify iPTYEventVerify) {
        eventVerify = iPTYEventVerify;
    }

    @JvmStatic
    public static final boolean init(Context context, PTYProxySetting setting) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(setting, "setting");
        synchronized (INSTANCE) {
            if (initOnce) {
                Log.e(TAG, "Duplicated initialization");
                return false;
            }
            initOnce = true;
            Unit unit = Unit.INSTANCE;
            ContextContainer.INSTANCE.setContext(context);
            mSetting = setting;
            if (setting.getApplogProxyEnabled()) {
                applogProxy = new PitayaApplogProxy();
                PitayaApplogProxy pitayaApplogProxy = applogProxy;
                if (Intrinsics.areEqual(pitayaApplogProxy != null ? Boolean.valueOf(pitayaApplogProxy.init(setting)) : null, false)) {
                    applogProxy = null;
                } else {
                    eventVerify = applogProxy;
                    if (!setting.getProvideAppLog()) {
                        TeaAgent.registerGlobalEventCallback(new GlobalEventCallback() { // from class: com.bytedance.pitaya.api.PitayaProxy$$ExternalSyntheticLambda1
                            public final void onEvent(String str, String str2, String str3, long j, long j2, boolean z, String str4) {
                                PitayaProxy.init$lambda$2(str, str2, str3, j, j2, z, str4);
                            }
                        });
                    }
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2(String str, String str2, String str3, long j, long j2, boolean z, String str4) {
        PitayaApplogProxy pitayaApplogProxy;
        if (str2 == null || (pitayaApplogProxy = applogProxy) == null) {
            return;
        }
        pitayaApplogProxy.onEvent(str2, str4);
    }

    @JvmStatic
    public static final boolean isFeatureStoreProxyEnabled() {
        if (!initOnce) {
            return false;
        }
        PTYProxySetting pTYProxySetting = mSetting;
        return (pTYProxySetting != null ? pTYProxySetting.getFeatureStoreProxyEnabled() : false) && loadProxySo();
    }

    @JvmStatic
    public static final void onAppLogEvent(String eventName, String extParams) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        PitayaApplogProxy pitayaApplogProxy = applogProxy;
        if (pitayaApplogProxy != null) {
            pitayaApplogProxy.onEvent(eventName, extParams);
        }
    }

    @JvmStatic
    public static final void onAppLogEvent(String eventName, JSONObject extParams) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        PitayaApplogProxy pitayaApplogProxy = applogProxy;
        if (pitayaApplogProxy != null) {
            pitayaApplogProxy.onEvent(eventName, extParams);
        }
    }

    @JvmStatic
    public static final void processApplogCache(PTYApplogImplCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        PitayaApplogProxy pitayaApplogProxy = applogProxy;
        if (pitayaApplogProxy != null) {
            pitayaApplogProxy.storeCache(callback);
        }
        applogProxy = null;
    }

    @JvmStatic
    public static final int applogCacheSize() {
        PitayaApplogProxy pitayaApplogProxy = applogProxy;
        if (pitayaApplogProxy != null) {
            return pitayaApplogProxy.cacheSize();
        }
        return 0;
    }

    @JvmStatic
    public static final boolean loadProxySo() {
        if (isProxySoLoaded) {
            return true;
        }
        if (hasProxySoLoadFailed) {
            return false;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread(new Runnable() { // from class: com.bytedance.pitaya.api.PitayaProxy$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PitayaProxy.loadProxySoImpl();
                }
            }).start();
            return false;
        }
        return loadProxySoImpl();
    }

    @JvmStatic
    public static final boolean loadProxySoImpl() {
        synchronized (INSTANCE) {
            try {
                if (!isProxySoLoaded) {
                    System.loadLibrary("AndroidPitayaProxy");
                    isProxySoLoaded = true;
                }
            } catch (Throwable th) {
                Log.e(TAG, "Load pitaya proxy with exception " + th.getMessage());
                hasProxySoLoadFailed = true;
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final boolean isValidEvent(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        IPTYEventVerify iPTYEventVerify = eventVerify;
        if (iPTYEventVerify != null) {
            return iPTYEventVerify.isValidEvent(eventName);
        }
        return false;
    }
}
