package com.bytedance.android.monitorV2.lynx.jsb;

import android.content.Context;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompatKt;
import com.bytedance.android.monitorV2.AnnieXMonitorConstants;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxNativeErrorData;
import com.bytedance.android.monitorV2.lynx.impl.LynxViewDataManager;
import com.bytedance.android.monitorV2.lynx.impl.LynxViewNavigationDataManager;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsConfigConvertUtils;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.salamander.anniex.SLAnnieXMonitor;
import com.bytedance.salamander.anniex.SLLynxJSExceptionParams;
import com.lynx.jsbridge.Arguments;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.LynxView;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: LynxViewMonitorModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\u000f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\u0014\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001c\u0010\u0015\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/jsb/LynxViewMonitorModule;", "Lcom/lynx/jsbridge/LynxModule;", "context", "Landroid/content/Context;", "param", "", "(Landroid/content/Context;Ljava/lang/Object;)V", "config", "", "dataMap", "Lcom/lynx/react/bridge/ReadableMap;", JsCallParser.VALUE_CALLBACK, "Lcom/lynx/react/bridge/Callback;", "convertJson", "Lorg/json/JSONObject;", "customReport", "getCanSample", "", "getError", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxNativeErrorData;", "getInfo", "reportJSError", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxViewMonitorModule extends LynxModule {
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final int FAIL = -1;
    public static final String NAME = "hybridMonitor";
    public static final int SUCCESS = 0;
    public static final String TAG = "LynxViewMonitorModule";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LynxViewMonitorModule(Context context, Object obj) {
        super(context, obj);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(obj, "param");
    }

    @LynxMethod
    public final void config(ReadableMap dataMap, final Callback callback) {
        String sessionId;
        HashMap hashMap;
        MonitorLog.m29i(TAG, "config");
        if (this.mParam == null) {
            return;
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("errorCode", -1);
        if (this.mParam instanceof LynxViewProvider) {
            Object obj = this.mParam;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.android.monitorV2.lynx.jsb.LynxViewProvider");
            LynxView view = ((LynxViewProvider) obj).getView();
            if (view != null) {
                JSONObject convert = JsConfigConvertUtils.INSTANCE.convert(convertJson(dataMap));
                LynxViewNavigationDataManager currentNavigation = LynxViewDataManager.INSTANCE.getOrCreate(view).getCurrentNavigation();
                if (currentNavigation != null) {
                    currentNavigation.onConfig("jsBase", convert);
                    createMap.putInt("errorCode", 0);
                }
                if (SLMonitorCompat.INSTANCE.enableSLMonitor()) {
                    String sessionId2 = LynxViewDataManager.INSTANCE.getOrCreate(view).getSessionId();
                    if ((sessionId2 != null && (StringsKt.isBlank(sessionId2) ^ true)) && (sessionId = LynxViewDataManager.INSTANCE.getOrCreate(view).getSessionId()) != null) {
                        SLAnnieXMonitor monitorWithSessionId = SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(sessionId);
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (dataMap != null && (hashMap = dataMap.toHashMap()) != null) {
                            linkedHashMap.putAll(hashMap);
                        }
                        monitorWithSessionId.collectJSBaseField(linkedHashMap, new Function1<Map<String, Object>, Unit>() { // from class: com.bytedance.android.monitorV2.lynx.jsb.LynxViewMonitorModule$config$2$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((Map<String, Object>) obj2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Map<String, Object> map) {
                                Intrinsics.checkNotNullParameter(map, "cbMap");
                                Callback callback2 = callback;
                                if (callback2 != null) {
                                    callback2.invoke(new Object[]{JavaOnlyMap.from(map)});
                                }
                            }
                        });
                    }
                }
            }
        }
        if (SLMonitorCompat.INSTANCE.enableSLMonitor() || callback == null) {
            return;
        }
        callback.invoke(new Object[]{createMap});
    }

    @LynxMethod
    public final void reportJSError(ReadableMap dataMap, final Callback callback) {
        String sessionId;
        String errorMsg;
        MonitorLog.m29i(TAG, "reportJSError");
        CommonEvent create$default = CommonEvent.Companion.create$default(CommonEvent.INSTANCE, ReportConst.Event.JS_EXCEPTION, null, 2, null);
        if (create$default.terminateIf(dataMap == null || this.mParam == null, HybridEvent.TerminateType.PARAM_EXCEPTION)) {
            return;
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("errorCode", -1);
        if (this.mParam instanceof LynxViewProvider) {
            Object obj = this.mParam;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.android.monitorV2.lynx.jsb.LynxViewProvider");
            LynxView view = ((LynxViewProvider) obj).getView();
            if (view != null) {
                LynxNativeErrorData error = getError(dataMap);
                create$default.setNativeInfo(error);
                LynxViewMonitor.INSTANCE.getINSTANCE().reportError(view, error, create$default);
                createMap.putInt("errorCode", 0);
                if (SLMonitorCompat.INSTANCE.enableSLMonitor()) {
                    String sessionId2 = LynxViewDataManager.INSTANCE.getOrCreate(view).getSessionId();
                    if ((sessionId2 != null && (StringsKt.isBlank(sessionId2) ^ true)) && (sessionId = LynxViewDataManager.INSTANCE.getOrCreate(view).getSessionId()) != null && (errorMsg = error.getErrorMsg()) != null) {
                        SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(sessionId).reportLynxJSException(new SLLynxJSExceptionParams(errorMsg, 201), new Function1<Map<String, Object>, Unit>() { // from class: com.bytedance.android.monitorV2.lynx.jsb.LynxViewMonitorModule$reportJSError$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((Map<String, Object>) obj2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Map<String, Object> map) {
                                Intrinsics.checkNotNullParameter(map, "cbMap");
                                Callback callback2 = callback;
                                if (callback2 != null) {
                                    callback2.invoke(new Object[]{JavaOnlyMap.from(map)});
                                }
                            }
                        });
                    }
                }
            } else {
                create$default.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
            }
        } else {
            create$default.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
        }
        if (SLMonitorCompat.INSTANCE.enableSLMonitor() || callback == null) {
            return;
        }
        callback.invoke(new Object[]{createMap});
    }

    @LynxMethod
    public final void customReport(ReadableMap dataMap, Callback callback) {
        MonitorLog.m29i(TAG, "customReport");
        if (dataMap == null || this.mParam == null) {
            return;
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("errorCode", -1);
        if (this.mParam instanceof LynxViewProvider) {
            Object obj = this.mParam;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.android.monitorV2.lynx.jsb.LynxViewProvider");
            LynxView view = ((LynxViewProvider) obj).getView();
            if (view != null) {
                try {
                    String string = dataMap.getString("eventName", "");
                    ReadableMap map = dataMap.getMap("category");
                    ReadableMap map2 = dataMap.getMap("metrics");
                    ReadableMap map3 = dataMap.getMap("timing");
                    CustomInfo build = new CustomInfo.Builder(string).setBid(dataMap.getString("bid")).setUrl(view.getTemplateUrl()).setCategory(convertJson(map)).setMetric(convertJson(map2)).setExtra(convertJson(dataMap.getMap("extra"))).setTiming(convertJson(map3)).setSample(getCanSample(dataMap)).build();
                    LynxViewMonitor instance = LynxViewMonitor.INSTANCE.getINSTANCE();
                    Intrinsics.checkNotNullExpressionValue(build, "customInfo");
                    instance.reportCustom(view, build);
                    createMap.putInt("errorCode", 0);
                } catch (Exception e) {
                    createMap.putString("errorMessage", "cause: " + e.getMessage());
                    ExceptionUtil.handleException(e);
                }
            } else {
                createMap.putString("errorMessage", "view is empty.");
            }
        } else {
            createMap.putString("errorMessage", "mParam is not LynxViewProvider.");
        }
        if (callback != null) {
            callback.invoke(new Object[]{createMap});
        }
    }

    @LynxMethod
    public final void getInfo(ReadableMap dataMap, Callback callback) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("sdk_version", AnnieXMonitorConstants.ANNIEX_VERSION);
        if (callback != null) {
            callback.invoke(new Object[]{createMap});
        }
    }

    private final int getCanSample(ReadableMap dataMap) {
        int i = dataMap.getInt("level", 2);
        int i2 = dataMap.getInt("canSample", 1);
        boolean z = dataMap.getBoolean("canSample", true);
        if (dataMap.hasKey("level")) {
            return i;
        }
        if (dataMap.hasKey("canSample")) {
            return (i2 == 0 || !z) ? 0 : 2;
        }
        return 2;
    }

    private final LynxNativeErrorData getError(ReadableMap dataMap) {
        LynxNativeErrorData lynxNativeErrorData = new LynxNativeErrorData();
        try {
            lynxNativeErrorData.setScene("lynx_error_custom");
            lynxNativeErrorData.setErrorCode(201);
            lynxNativeErrorData.setErrorMsg(String.valueOf(convertJson(dataMap)));
            return lynxNativeErrorData;
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
            return lynxNativeErrorData;
        }
    }

    private final JSONObject convertJson(ReadableMap dataMap) {
        if (dataMap == null) {
            return null;
        }
        try {
            return new JSONObject(dataMap.toHashMap());
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
            return null;
        }
    }
}
