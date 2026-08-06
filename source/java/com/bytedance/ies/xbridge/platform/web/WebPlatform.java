package com.bytedance.ies.xbridge.platform.web;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.web.jsbridge.IESJsBridge;
import com.bytedance.ies.web.jsbridge.ISupportJavaMethod;
import com.bytedance.ies.web.jsbridge.JsMsg;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.IDLXBridgeMethodProvider;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethodProvider;
import com.bytedance.ies.xbridge.XBridgePlatform;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XBridgeRegister;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.exception.IllegalInputParamException;
import com.bytedance.ies.xbridge.exception.IllegalOperationException;
import com.bytedance.ies.xbridge.exception.IllegalOutputParamException;
import com.bytedance.ies.xbridge.platform.web.api.IH5JsBridge;
import com.bytedance.ies.xbridge.platform.web.inner.ReadableMapImpl;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: WebPlatform.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ(\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J\u001e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/xbridge/platform/web/WebPlatform;", "Lcom/bytedance/ies/xbridge/XBridgePlatform;", "()V", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "getType", "()Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "adapt", "", "h5JsBridge", "Lcom/bytedance/ies/xbridge/platform/web/api/IH5JsBridge;", "xBridgeRegister", "Lcom/bytedance/ies/xbridge/XBridgeRegister;", "callback", "code", "", "message", "", "msg", "Lcom/bytedance/ies/web/jsbridge/JsMsg;", "createXReadableMap", "Lcom/bytedance/ies/xbridge/XReadableMap;", EventConstants.PARAM_SOURCE, "", "", "sendEvent", "jsBridge", "Lcom/bytedance/ies/web/jsbridge/IESJsBridge;", SchemaConstants.INNER_PARAM_EVENT_NAME, "params", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WebPlatform extends XBridgePlatform {
    private final XBridgePlatformType type = XBridgePlatformType.WEB;

    @Override // com.bytedance.ies.xbridge.XBridgePlatform
    public XBridgePlatformType getType() {
        return this.type;
    }

    @Override // com.bytedance.ies.xbridge.XBridgePlatform
    public XReadableMap createXReadableMap(Map<String, ? extends Object> source) {
        if (source == null) {
            return null;
        }
        return new ReadableMapImpl(Utils.INSTANCE.mapToJSON(source));
    }

    public final void sendEvent(IESJsBridge jsBridge, String eventName, JSONObject params) {
        Intrinsics.checkNotNullParameter(jsBridge, "jsBridge");
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(params, "params");
        jsBridge.sendJsEvent(eventName, params);
    }

    public final void adapt(final IH5JsBridge h5JsBridge, final XBridgeRegister xBridgeRegister) {
        Intrinsics.checkNotNullParameter(h5JsBridge, "h5JsBridge");
        Intrinsics.checkNotNullParameter(xBridgeRegister, "xBridgeRegister");
        Iterator<Map.Entry<String, XBridgeMethodProvider>> it = xBridgeRegister.getMethodList().entrySet().iterator();
        while (it.hasNext()) {
            h5JsBridge.registerJavaMethod(it.next().getKey(), new ISupportJavaMethod() { // from class: com.bytedance.ies.xbridge.platform.web.WebPlatform$adapt$1$1
                private final Map<String, Object> internalMetaMap = new LinkedHashMap();

                public final Map<String, Object> getInternalMetaMap() {
                    return this.internalMetaMap;
                }

                @Override // com.bytedance.ies.web.jsbridge.IJavaMethod
                public void call(final JsMsg msg, JSONObject data) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    Intrinsics.checkNotNullParameter(data, "data");
                    this.internalMetaMap.put(ISupportJavaMethod.BRIDGE_TYPE, "WEB_BRIDGE");
                    JSONObject jSONObject = msg.params;
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("func", msg.func);
                    msg.needCallback = false;
                    WebPlatform webPlatform = WebPlatform.this;
                    String str = msg.func;
                    Intrinsics.checkNotNullExpressionValue(str, "msg.func");
                    ReadableMapImpl readableMapImpl = new ReadableMapImpl(jSONObject);
                    final IH5JsBridge iH5JsBridge = h5JsBridge;
                    webPlatform.handle(str, readableMapImpl, new XBridgeMethod.Callback() { // from class: com.bytedance.ies.xbridge.platform.web.WebPlatform$adapt$1$1$call$1
                        @Override // com.bytedance.ies.xbridge.XBridgeMethod.Callback
                        public void invoke(Map<String, Object> data2) {
                            Intrinsics.checkNotNullParameter(data2, "data");
                            IH5JsBridge.this.invokeJsCallback(msg.callback_id, new JSONObject(data2));
                        }
                    }, xBridgeRegister);
                }

                @Override // com.bytedance.ies.web.jsbridge.ISupportJavaMethod
                public Map<String, Object> getMetaInfo() {
                    return this.internalMetaMap;
                }
            });
        }
        for (final Map.Entry<String, IDLXBridgeMethodProvider> entry : xBridgeRegister.getIDLMethodList().entrySet()) {
            h5JsBridge.registerJavaMethod(entry.getKey(), new ISupportJavaMethod() { // from class: com.bytedance.ies.xbridge.platform.web.WebPlatform$adapt$2$1
                private final Map<String, Object> internalMetaMap = new LinkedHashMap();
                private final String IDL_TYPE = "IDL_XBRIDGE";

                public final String getIDL_TYPE() {
                    return this.IDL_TYPE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.bytedance.ies.web.jsbridge.IJavaMethod
                public void call(final JsMsg msg, JSONObject data) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    Intrinsics.checkNotNullParameter(data, "data");
                    this.internalMetaMap.put(ISupportJavaMethod.BRIDGE_TYPE, this.IDL_TYPE);
                    JSONObject jSONObject = msg.params;
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("func", msg.func);
                    msg.needCallback = false;
                    try {
                        Map<String, Object> transformPlatformDataToMap = new WebPlatformDataProcessor().transformPlatformDataToMap(jSONObject, entry.getValue().provideMethod().getClass());
                        if (transformPlatformDataToMap == null) {
                            this.callback(0, "Web Platform convert fail.", h5JsBridge, msg);
                        } else {
                            WebPlatform webPlatform = this;
                            String str = msg.func;
                            Intrinsics.checkNotNullExpressionValue(str, "msg.func");
                            final IH5JsBridge iH5JsBridge = h5JsBridge;
                            webPlatform.idlHandle(str, transformPlatformDataToMap, new IDLXBridgeMethod.Callback() { // from class: com.bytedance.ies.xbridge.platform.web.WebPlatform$adapt$2$1$call$1
                                @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod.Callback
                                public void invoke(Map<String, ? extends Object> data2) {
                                    Intrinsics.checkNotNullParameter(data2, "data");
                                    IH5JsBridge.this.invokeJsCallback(msg.callback_id, new JSONObject(data2));
                                }
                            }, xBridgeRegister);
                        }
                    } catch (IllegalInputParamException e) {
                        this.callback(-3, e.toString(), h5JsBridge, msg);
                    } catch (IllegalOperationException e2) {
                        this.callback(0, e2.toString(), h5JsBridge, msg);
                    } catch (IllegalOutputParamException e3) {
                        this.callback(-5, e3.toString(), h5JsBridge, msg);
                    } catch (Throwable th) {
                        this.callback(0, th.toString(), h5JsBridge, msg);
                    }
                }

                @Override // com.bytedance.ies.web.jsbridge.ISupportJavaMethod
                public Map<String, Object> getMetaInfo() {
                    Map<String, Object> map = this.internalMetaMap;
                    map.put(ISupportJavaMethod.BRIDGE_TYPE, this.IDL_TYPE);
                    return map;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callback(int code, String message, IH5JsBridge h5JsBridge, JsMsg msg) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        jSONObject.put("msg", message);
        h5JsBridge.invokeJsCallback(msg.callback_id, jSONObject);
    }
}
