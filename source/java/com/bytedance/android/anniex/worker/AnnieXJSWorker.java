package com.bytedance.android.anniex.worker;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.anniex.worker.AnnieXJSWorkerXBridgeModule;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.kit.service.IBridgeService;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.worker.IWorkerCallback;
import com.bytedance.vmsdk.worker.InitParams;
import com.bytedance.vmsdk.worker.JsWorker;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AnnieXJSWorker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0011J-\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015H\u0000¢\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/anniex/worker/AnnieXJSWorker;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "jSWorker", "Lcom/bytedance/vmsdk/worker/JsWorker;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "handleError", "", "errorMessage", "", "handleMessage", "message", "loadScripts", "jsBundle", "loadScripts$anniex_release", "postMessage", "eventName", "params", "", "postMessage$anniex_release", "startWorker", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXJSWorker {
    private final Context context;
    private JsWorker jSWorker;
    private ContextProviderFactory providerFactory;

    public AnnieXJSWorker(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final void startWorker() {
        JSModuleManager jSModuleManager = new JSModuleManager(this.context);
        JsWorker jsWorker = new JsWorker(new InitParams.Builder().withEngineType(JsWorker.EngineType.QUICKJS).withJSModuleManager(jSModuleManager).withBizName("annieX").build());
        jsWorker.setOnMessageCallback(new IWorkerCallback() { // from class: com.bytedance.android.anniex.worker.AnnieXJSWorker$startWorker$1$1
            public final void execute(String str) {
                Intrinsics.checkNotNullParameter(str, "p0");
                AnnieXJSWorker.this.handleMessage(str);
            }
        });
        jsWorker.setOnErrorCallback(new IWorkerCallback() { // from class: com.bytedance.android.anniex.worker.AnnieXJSWorker$startWorker$1$2
            public final void execute(String str) {
                Intrinsics.checkNotNullParameter(str, "p0");
                AnnieXJSWorker.this.handleError(str);
            }
        });
        this.jSWorker = jsWorker;
        Context context = this.context;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        final JSWorkerBDXBridge jSWorkerBDXBridge = new JSWorkerBDXBridge(context, uuid);
        jSWorkerBDXBridge.init$anniex_release();
        IBridgeService iBridgeService = ServiceCenter.Companion.instance().get("default_bid", IBridgeService.class);
        if (iBridgeService != null) {
            ContextProviderFactory contextProviderFactory = new ContextProviderFactory();
            this.providerFactory = contextProviderFactory;
            contextProviderFactory.registerHolder(Context.class, jSWorkerBDXBridge.getContext());
            ContextProviderFactory contextProviderFactory2 = this.providerFactory;
            if (contextProviderFactory2 != null) {
                contextProviderFactory2.registerHolder(AnnieXWorkerTag.class, new AnnieXWorkerTag(null, 1, null));
            }
            ContextProviderFactory contextProviderFactory3 = this.providerFactory;
            if (contextProviderFactory3 != null) {
                contextProviderFactory3.registerHolder(IDLXBridgeMethod.JSEventDelegate.class, new IDLXBridgeMethod.JSEventDelegate() { // from class: com.bytedance.android.anniex.worker.AnnieXJSWorker$startWorker$workerBDXBridge$1$1$1
                    public void sendJSEvent(String eventName, Map<String, ? extends Object> params) {
                        Intrinsics.checkNotNullParameter(eventName, "eventName");
                        JSWorkerBDXBridge.this.sendJSEvent(eventName, params);
                    }
                });
            }
            ContextProviderFactory contextProviderFactory4 = this.providerFactory;
            if (contextProviderFactory4 != null) {
                contextProviderFactory4.registerHolder(XBridgeMethod.JsEventDelegate.class, new XBridgeMethod.JsEventDelegate() { // from class: com.bytedance.android.anniex.worker.AnnieXJSWorker$startWorker$workerBDXBridge$1$1$2
                    public void sendJsEvent(String eventName, XReadableMap params) {
                        Intrinsics.checkNotNullParameter(eventName, "eventName");
                        JSWorkerBDXBridge.this.sendJSEvent(eventName, params != null ? params.toMap() : null);
                    }
                });
            }
            ContextProviderFactory contextProviderFactory5 = this.providerFactory;
            if (contextProviderFactory5 == null) {
                contextProviderFactory5 = new ContextProviderFactory();
            }
            Iterator it = iBridgeService.createMethodFinder(contextProviderFactory5).iterator();
            while (it.hasNext()) {
                jSWorkerBDXBridge.addCustomMethodFinder((MethodFinder) it.next());
            }
        }
        jSWorkerBDXBridge.setAnnieXJSWorker$anniex_release(this);
        jSModuleManager.registerModule("bridge", AnnieXJSWorkerXBridgeModule.class, new AnnieXJSWorkerXBridgeModule.Params(jSWorkerBDXBridge));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMessage(String message) {
        HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieXJSWorker", "handleMessage: " + message, (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleError(String errorMessage) {
        IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo("anniex_worker_jsError", (String) null, (String) null, (JSONObject) null, (JSONObject) null, (Boolean) null, (JSONObject) null, (JSONObject) null, 254, (DefaultConstructorMarker) null);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, errorMessage);
            reportInfo.setCategory(jSONObject);
            iMonitorReportService.report(reportInfo);
        }
        HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieXJSWorker", "handleError: " + errorMessage, (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    public final void loadScripts$anniex_release(String jsBundle) {
        Intrinsics.checkNotNullParameter(jsBundle, "jsBundle");
        if (jsBundle.length() == 0) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieXJSWorker", "js is empty", (Map) null, (LoggerContext) null, 12, (Object) null);
            return;
        }
        JsWorker jsWorker = this.jSWorker;
        if (jsWorker != null) {
            jsWorker.evaluateJavaScript(jsBundle);
        }
    }

    public final void postMessage$anniex_release(String eventName, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Gson gson = new Gson();
        JsonElement jsonObject = new JsonObject();
        jsonObject.addProperty("event_name", eventName);
        jsonObject.add(Constants.KEY_DATA, gson.toJsonTree(params));
        String json = gson.toJson(jsonObject);
        JsWorker jsWorker = this.jSWorker;
        if (jsWorker != null) {
            jsWorker.postMessage(json);
        }
    }
}
