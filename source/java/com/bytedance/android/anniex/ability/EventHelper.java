package com.bytedance.android.anniex.ability;

import com.bytedance.android.anniex.utils.LynxViexExtKt;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.lynx.model.LynxCommonData;
import com.bytedance.ies.bullet.lynx.model.LynxCommonDataKt;
import com.bytedance.ies.bullet.lynx.util.JsonConvertHelper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxInitDataWrapper;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: EventHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/ability/EventHelper;", "", "()V", "ON_USER_CAPTURE_SCREEN", "", "ON_VIEW_APPEARED", "ON_VIEW_DISAPPEARED", "SCREEN_ORIENTATION_CHANGE", "sendEventCompatible", "", "eventName", "params", "lynxView", "Lcom/lynx/tasm/LynxView;", "bid", "sessionId", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class EventHelper {
    public static final EventHelper INSTANCE = new EventHelper();
    public static final String ON_USER_CAPTURE_SCREEN = "onUserCaptureScreen";
    public static final String ON_VIEW_APPEARED = "viewAppeared";
    public static final String ON_VIEW_DISAPPEARED = "viewDisappeared";
    public static final String SCREEN_ORIENTATION_CHANGE = "screenOrientationChange";

    private EventHelper() {
    }

    public final void sendEventCompatible(String eventName, Object params, LynxView lynxView, String bid, String sessionId) {
        Object obj;
        String fromMap;
        String valueOf;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        String str = null;
        if (Intrinsics.areEqual(eventName, "__updateData")) {
            if (params != null) {
                if (params instanceof CharSequence) {
                    valueOf = String.valueOf(params);
                } else if (params instanceof JSONObject) {
                    valueOf = String.valueOf(((JSONObject) params).put("bullet_update_type", 1));
                } else if (params instanceof JSONArray) {
                    valueOf = String.valueOf(params);
                } else if (params instanceof ReadableMap) {
                    valueOf = String.valueOf(JsonConvertHelper.INSTANCE.reactToJSON((ReadableMap) params).put("bullet_update_type", 1));
                } else if (params instanceof ReadableArray) {
                    valueOf = String.valueOf(JsonConvertHelper.INSTANCE.reactToJSON((ReadableArray) params));
                }
                str = valueOf;
            }
            if (str != null) {
                lynxView.updateData(str);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual("__updateTemplateData", eventName)) {
            if (params != null && (params instanceof LynxInitDataWrapper)) {
                LynxInitDataWrapper lynxInitDataWrapper = (LynxInitDataWrapper) params;
                if (lynxInitDataWrapper.getInitData() != null) {
                    fromMap = TemplateData.fromString(lynxInitDataWrapper.getInitData());
                    for (Map.Entry entry : lynxInitDataWrapper.getDataProxy().entrySet()) {
                        if (fromMap != null) {
                            fromMap.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                } else {
                    fromMap = TemplateData.fromMap(lynxInitDataWrapper.getDataProxy());
                }
                if (lynxInitDataWrapper.getReadOnly() && fromMap != null) {
                    fromMap.markReadOnly();
                }
                str = fromMap;
            }
            if (str != null) {
                str.put("bullet_update_type", 1);
            }
            lynxView.updateData(str);
            return;
        }
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        JSONObject jSONObject = new JSONObject();
        if (params != null) {
            if (params instanceof CharSequence ? true : params instanceof JSONObject ? true : params instanceof JSONArray) {
                jSONObject.put(Constants.KEY_DATA, params);
            } else if (params instanceof ReadableMap) {
                jSONObject.put(Constants.KEY_DATA, JsonConvertHelper.INSTANCE.reactToJSON((ReadableMap) params));
            } else if (params instanceof ReadableArray) {
                jSONObject.put(Constants.KEY_DATA, JsonConvertHelper.INSTANCE.reactToJSON((ReadableArray) params));
            } else {
                jSONObject.put(Constants.KEY_DATA, new JSONObject());
            }
        }
        LynxCommonDataKt.wrapLynxCommonData(jSONObject, new LynxCommonData(sessionId, (String) null, 2, (DefaultConstructorMarker) null));
        if (Intrinsics.areEqual(bid, "webcast")) {
            jSONObject.put("code", 1);
        }
        try {
            Result.Companion companion = Result.Companion;
            javaOnlyArray.pushMap(JsonConvertHelper.INSTANCE.jsonToReact(jSONObject));
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "EventHelper", "error===>" + th2.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
        }
        Unit unit = Unit.INSTANCE;
        LynxViexExtKt.sendGlobalEventInternal(lynxView, eventName, javaOnlyArray);
    }
}
