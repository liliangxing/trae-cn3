package com.bytedance.ies.web.jsbridge2;

import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ies.web.jsbridge.IESJsBridge;
import com.bytedance.ies.web.jsbridge.IJavaMethod;
import com.bytedance.ies.web.jsbridge.IOnProtectedUpdateListener;
import com.bytedance.ies.web.jsbridge.IProtectedFuncHandler;
import com.bytedance.ies.web.jsbridge.JsMsg;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class JsBridge2IESSupport implements IOnProtectedUpdateListener, ISupportBridge {
    private final AbstractBridge bridge;
    private final JsBridge2 jsBridge2;
    private final IESJsBridge legacy;
    private final LegacyMethodImpl legacyMethod;
    private final Map<String, BaseRawMethod> legacyMethodMap = new ConcurrentHashMap();
    private final Set<String> unregisteredMethodSet;

    public static JsBridge2IESSupport from(WebView webView, JsBridge2 jsBridge2) {
        return new JsBridge2IESSupport(webView, jsBridge2);
    }

    private JsBridge2IESSupport(WebView webView, JsBridge2 jsBridge2) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.unregisteredMethodSet = copyOnWriteArraySet;
        this.jsBridge2 = jsBridge2;
        AbstractBridge bridge = jsBridge2.getBridge();
        this.bridge = bridge;
        this.legacy = IESJsBridge.create(webView).disablePermissionCheck();
        if (bridge instanceof WebViewBridge) {
            this.legacyMethod = new LegacyMethodImpl((WebViewBridge) bridge, copyOnWriteArraySet);
        } else {
            this.legacyMethod = null;
        }
    }

    public JsBridge2IESSupport setWebViewClient(WebViewClient webViewClient) {
        this.legacy.setWebViewClient(webViewClient);
        return this;
    }

    public JsBridge2IESSupport setWebChromeClient(WebChromeClient webChromeClient) {
        this.legacy.setWebChromeClient(webChromeClient);
        return this;
    }

    @Deprecated
    public JsBridge2IESSupport setProtectedFuncHandler(IProtectedFuncHandler iProtectedFuncHandler) {
        this.legacy.setProtectedFuncHandler(iProtectedFuncHandler);
        return this;
    }

    @Deprecated
    public JsBridge2IESSupport setProtectedFunc(List<String> list) {
        this.legacy.setProtectedFunc(list);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            BaseRawMethod baseRawMethod = this.legacyMethodMap.get(it.next());
            if (baseRawMethod != null) {
                baseRawMethod.permissionGroup = PermissionGroup.PROTECTED;
            }
        }
        return this;
    }

    @Deprecated
    public JsBridge2IESSupport setPublicFunc(List<String> list) {
        this.legacy.setPublicFunc(list);
        this.bridge.callHandler.getPermissionChecker().addPublicMethod(list);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            BaseRawMethod baseRawMethod = this.legacyMethodMap.get(it.next());
            if (baseRawMethod != null) {
                baseRawMethod.permissionGroup = PermissionGroup.PUBLIC;
            }
        }
        return this;
    }

    @Deprecated
    public JsBridge2IESSupport setSecureFunc(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            BaseRawMethod baseRawMethod = this.legacyMethodMap.get(it.next());
            if (baseRawMethod != null) {
                baseRawMethod.permissionGroup = PermissionGroup.SECURE;
            }
        }
        return this;
    }

    @Deprecated
    public JsBridge2IESSupport setSafeHost(List<String> list) {
        this.legacy.setSafeHost(list);
        this.bridge.callHandler.getPermissionChecker().addSafeHost(list);
        return this;
    }

    public JsBridge2IESSupport setBridgeScheme(String str) {
        this.legacy.setBridgeScheme(str);
        return this;
    }

    @Deprecated
    public JsBridge2IESSupport registerJavaMethod(String str, IJavaMethod iJavaMethod) {
        LegacyMethodImpl legacyMethodImpl = this.legacyMethod;
        if (legacyMethodImpl != null) {
            this.legacy.registerJavaMethod(str, legacyMethodImpl);
        }
        IESSupportRawMethod iESSupportRawMethod = new IESSupportRawMethod(iJavaMethod);
        this.bridge.callHandler.registerRawMethod(str, iESSupportRawMethod);
        this.legacyMethodMap.put(str, iESSupportRawMethod);
        return this;
    }

    @Deprecated
    public JsBridge2IESSupport registerJavaMethod(String str, IJavaMethod iJavaMethod, PermissionGroup permissionGroup) {
        LegacyMethodImpl legacyMethodImpl = this.legacyMethod;
        if (legacyMethodImpl != null) {
            this.legacy.registerJavaMethod(str, legacyMethodImpl);
        }
        IESSupportRawMethod iESSupportRawMethod = new IESSupportRawMethod(iJavaMethod);
        iESSupportRawMethod.permissionGroup = permissionGroup;
        this.bridge.callHandler.registerRawMethod(str, iESSupportRawMethod);
        this.legacyMethodMap.put(str, iESSupportRawMethod);
        return this;
    }

    @Deprecated
    public IESJsBridge getLegacyJsBridge() {
        return this.legacy;
    }

    public void onDestroy() {
        this.legacy.onDestroy();
    }

    @Override // com.bytedance.ies.web.jsbridge.IOnProtectedUpdateListener
    public void onUpdate(List<String> list, JsMsg jsMsg, JSONObject jSONObject) {
        this.legacy.onUpdate(list, jsMsg, jSONObject);
    }

    @Deprecated
    public void invokeJsMethod(String str, String... strArr) {
        this.legacy.invokeJsMethod(str, strArr);
    }

    public boolean checkJsEventEnable(ValueCallback<Boolean> valueCallback) {
        return this.legacy.checkJsEventEnable(valueCallback);
    }

    @Deprecated
    public void sendJsEvent(String str, JSONObject jSONObject) {
        this.legacy.sendJsEvent(str, jSONObject);
    }

    @Deprecated
    public void invokeJsCallback(String str, JSONObject jSONObject) {
        this.bridge.finishCallWithId(str, jSONObject.toString());
    }

    @Deprecated
    public boolean checkBridgeSchema(String str) {
        return this.legacy.checkBridgeSchema(str);
    }

    @Deprecated
    public boolean invokeJavaMethod(String str) {
        return this.legacy.invokeJavaMethod(str);
    }

    @Deprecated
    public List<String> getProtectedFunc() {
        return this.legacy.getProtectedFunc();
    }

    @Deprecated
    public List<String> getPublicFunc() {
        return this.legacy.getPublicFunc();
    }

    @Deprecated
    public List<String> getSafeHost() {
        return this.legacy.getSafeHost();
    }

    public WebView getWebView() {
        return this.legacy.getWebView();
    }

    @Deprecated
    public IESJsBridge getLegacyBridge() {
        return this.legacy;
    }

    @Deprecated
    public boolean isSafeHost(String str) {
        return this.jsBridge2.isSafeHost(str, null);
    }

    @Override // com.bytedance.ies.web.jsbridge2.ISupportBridge
    public void onRegisterMethod(String str) {
        this.unregisteredMethodSet.remove(str);
        LegacyMethodImpl legacyMethodImpl = this.legacyMethod;
        if (legacyMethodImpl != null) {
            this.legacy.registerJavaMethod(str, legacyMethodImpl);
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.ISupportBridge
    public void onUnregisterMethod(String str) {
        this.unregisteredMethodSet.add(str);
        this.legacyMethodMap.remove(str);
    }

    @Override // com.bytedance.ies.web.jsbridge2.ISupportBridge
    public void importFrom(ISupportBridge iSupportBridge) {
        if (iSupportBridge instanceof JsBridge2IESSupport) {
            JsBridge2IESSupport jsBridge2IESSupport = (JsBridge2IESSupport) iSupportBridge;
            this.legacyMethodMap.putAll(jsBridge2IESSupport.legacyMethodMap);
            this.unregisteredMethodSet.addAll(jsBridge2IESSupport.unregisteredMethodSet);
        }
    }
}
