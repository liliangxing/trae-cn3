package com.bytedance.android.monitorV2.jsworker;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: JsWorkerModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0006\u0010\u0019\u001a\u00020\u0014J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\fJ\u0012\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/monitorV2/jsworker/JsWorkerModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", "ctx", "Landroid/content/Context;", "param", "", "(Landroid/content/Context;Ljava/lang/Object;)V", "mPendingEvents", "Ljava/util/Queue;", "Lorg/json/JSONObject;", "mViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "callbackResponse", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", AlogMonitor.ALOG_RESULT_CODE, "", "msg", "", "customReport", "", "data", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/vmsdk/jsbridge/utils/Callback;", "fireAllEvents", "onAttachView", "view", "reportInternally", "event", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class JsWorkerModule extends JSModule {
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final int FAIL = -1;
    public static final String NAME = "hybridMonitor";
    public static final int SUCCESS = 0;
    public static final String TAG = "JsWorkerModule";
    private final Queue<JSONObject> mPendingEvents;
    private WeakReference<View> mViewRef;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsWorkerModule(Context context, Object obj) {
        super(context, obj);
        Intrinsics.checkNotNullParameter(context, "ctx");
        this.mPendingEvents = new LinkedList();
    }

    private final JavaOnlyMap callbackResponse(int code, String msg) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putInt("errorCode", code);
        javaOnlyMap.putString("errorMessage", msg);
        return javaOnlyMap;
    }

    @JSMethod
    public final void customReport(ReadableMap data, Callback callback) {
        HashMap hashMap = data != null ? data.toHashMap() : null;
        if (hashMap == null) {
            if (callback != null) {
                callback.invoke(new Object[]{callbackResponse(-1, "bad parameters")});
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject(hashMap);
        if (this.mViewRef != null) {
            reportInternally(jSONObject);
        } else {
            this.mPendingEvents.add(jSONObject);
        }
        if (callback != null) {
            callback.invoke(new Object[]{callbackResponse(0, "success")});
        }
    }

    private final void reportInternally(JSONObject event) {
        if (event != null) {
            String optString = event.optString("eventName", "");
            JSONObject optJSONObject = event.optJSONObject("metrics");
            JSONObject optJSONObject2 = event.optJSONObject("category");
            int optInt = event.optInt("level", -1);
            String optString2 = event.optString("bid", "");
            if (Intrinsics.areEqual(optString, "")) {
                return;
            }
            CustomInfo.Builder builder = new CustomInfo.Builder(optString);
            if (optJSONObject != null) {
                builder.setMetric(optJSONObject);
            }
            if (optJSONObject2 != null) {
                builder.setMetric(optJSONObject2);
            }
            if (optInt != -1) {
                builder.setSample(optInt);
            }
            if (!Intrinsics.areEqual(optString2, "")) {
                builder.setBid(optString2);
            }
            WeakReference<View> weakReference = this.mViewRef;
            View view = weakReference != null ? weakReference.get() : null;
            if (view == null) {
                HybridMultiMonitor.getInstance().customReport(builder.build());
            } else {
                if (view instanceof LynxView) {
                    CustomInfo build = builder.build();
                    Intrinsics.checkNotNullExpressionValue(build, "customInfo.build()");
                    LynxViewMonitor.INSTANCE.getINSTANCE().reportCustom((LynxView) view, build);
                    return;
                }
                boolean z = view instanceof WebView;
            }
        }
    }

    public final void onAttachView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mViewRef = new WeakReference<>(view);
        fireAllEvents();
    }

    public final synchronized void fireAllEvents() {
        while (!this.mPendingEvents.isEmpty()) {
            reportInternally(this.mPendingEvents.poll());
        }
    }
}
