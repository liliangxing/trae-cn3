package com.bytedance.ies.web.jsbridge;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.ies.web.jsbridge.hook.ISendMsgHook;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.push.interfaze.ISignalReportService;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class IESJsBridge implements IOnProtectedUpdateListener {
    public static final String KEY_CODE = "code";
    private boolean disablePermissionCheck;
    private ISendMsgHook hook;
    private String mBridgeScheme;
    private List<String> mProtectedFunc;
    private IProtectedFuncHandler mProtectedFuncHandler;
    private List<String> mPublicFunc;
    private List<String> mSafeHost;
    private WebView mWebView;
    private String fetchQueueMethodName = "_fetchQueue";
    private String handleMessageMethod = "_handleMessageFromToutiao";
    private String jsbridge = "javascript:ToutiaoJSBridge";
    private Map<String, IJavaMethod> mRegisterMethod = new ConcurrentHashMap();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.ies.web.jsbridge.IESJsBridge.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.obj instanceof JsMsg) {
                IESJsBridge.this.handleJsMsg((JsMsg) message.obj);
            }
        }
    };

    protected IESJsBridge(WebView webView) {
        this.mWebView = webView;
        if (webView != null) {
            tryInitWebView();
        }
    }

    public static IESJsBridge create(WebView webView) {
        return new IESJsBridge(webView);
    }

    public IESJsBridge setSafeHost(List<String> list) {
        this.mSafeHost = list;
        return this;
    }

    public IESJsBridge setPublicFunc(List<String> list) {
        this.mPublicFunc = list;
        return this;
    }

    public IESJsBridge setProtectedFunc(List<String> list) {
        this.mProtectedFunc = list;
        return this;
    }

    public IESJsBridge setWebView(WebView webView) {
        this.mWebView = webView;
        if (webView != null) {
            tryInitWebView();
        }
        return this;
    }

    public IESJsBridge setBridgeScheme(String str) {
        this.mBridgeScheme = str;
        return this;
    }

    public IESJsBridge setWebViewClient(WebViewClient webViewClient) {
        if (this.mWebView == null) {
            return this;
        }
        if (webViewClient instanceof IESWebViewClient) {
            ((IESWebViewClient) webViewClient).setJsBridge(this);
        }
        this.mWebView.setWebViewClient(webViewClient);
        return this;
    }

    public IESJsBridge setWebChromeClient(WebChromeClient webChromeClient) {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.setWebChromeClient(webChromeClient);
        }
        return this;
    }

    public IESJsBridge setProtectedFuncHandler(IProtectedFuncHandler iProtectedFuncHandler) {
        this.mProtectedFuncHandler = iProtectedFuncHandler;
        return this;
    }

    public IESJsBridge disablePermissionCheck() {
        this.disablePermissionCheck = true;
        return this;
    }

    public IESJsBridge registerJavaMethod(String str, IJavaMethod iJavaMethod) {
        if (!TextUtils.isEmpty(str) && iJavaMethod != null) {
            this.mRegisterMethod.put(str, iJavaMethod);
        }
        return this;
    }

    public List<String> getProtectedFunc() {
        return this.mProtectedFunc;
    }

    public List<String> getPublicFunc() {
        return this.mPublicFunc;
    }

    public List<String> getSafeHost() {
        return this.mSafeHost;
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public boolean invokeJavaMethod(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mBridgeScheme)) {
            return false;
        }
        return this.mBridgeScheme.equals(Uri.parse(str).getScheme().toLowerCase()) && checkBridgeSchema(str);
    }

    public boolean checkBridgeSchema(String str) {
        WebView webView;
        final String url;
        if (str == null || !str.startsWith(this.mBridgeScheme)) {
            return false;
        }
        String str2 = this.mBridgeScheme + "://dispatch_message/";
        String str3 = this.mBridgeScheme + "://private/setresult/";
        try {
            webView = getWebView();
            url = webView.getUrl();
        } catch (Exception unused) {
        }
        if (!str.equals(str2)) {
            return str.startsWith(str3);
        }
        if (webView != null) {
            webView.evaluateJavascript(getJsBridge() + LibrarianImpl.Constants.DOT + getFetchQueueMethodName() + "()", new ValueCallback<String>() { // from class: com.bytedance.ies.web.jsbridge.IESJsBridge.2
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str4) {
                    IESJsBridge.this.parseJsonValueEncodedMsgQueue(str4, url);
                }
            });
        }
        return true;
    }

    public void invokeJsCallback(String str, JSONObject jSONObject) {
        ISendMsgHook iSendMsgHook = this.hook;
        if ((iSendMsgHook != null ? iSendMsgHook.beforeSendJsMsg(str, jSONObject, 1) : null) != null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            sendJsMessage(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public void invokeJsCallbackToIFrame(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str2);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            sendJsMessageToIFrame(jSONObject2, str);
        } catch (Exception unused) {
        }
    }

    public void sendJsEvent(String str, JSONObject jSONObject) {
        ISendMsgHook iSendMsgHook = this.hook;
        if ((iSendMsgHook != null ? iSendMsgHook.beforeSendJsMsg(str, jSONObject, 2) : null) != null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", ISignalReportService.BODY_KEY_EVENT);
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            sendJsMessage(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public boolean checkJsEventEnable(final ValueCallback<Boolean> valueCallback) {
        if (getWebView() == null) {
            return false;
        }
        this.mWebView.evaluateJavascript(getJsBridge() + LibrarianImpl.Constants.DOT + getHandleMessageMethod() + "()", new ValueCallback<String>() { // from class: com.bytedance.ies.web.jsbridge.IESJsBridge.3
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
                if (RouterConstants.TRUE.equals(str)) {
                    valueCallback.onReceiveValue(true);
                } else {
                    valueCallback.onReceiveValue(false);
                }
            }
        });
        return true;
    }

    public void invokeJsMethod(String str, String... strArr) {
        StringBuilder sb = new StringBuilder("javascript:");
        sb.append(str).append("(");
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                sb.append(strArr[0]);
                if (i < strArr.length - 1) {
                    sb.append(",");
                }
            }
        }
        sb.append(")");
        if (this.mWebView != null) {
            LoadUrlUtil.loadUrl(this.mWebView, sb.toString());
        }
    }

    private void tryInitWebView() {
        WebView webView = this.mWebView;
        if ((webView instanceof IESWebView) && !((IESWebView) webView).hasWebChromeClient()) {
            this.mWebView.setWebChromeClient(new WebChromeClient());
        }
        try {
            this.mWebView.getSettings().setJavaScriptEnabled(true);
        } catch (Exception unused) {
            Log.e("SSWebSettings", "setJavaScriptEnabled failed");
        }
    }

    private void parseBase64EncodedMsgQueue(String str, String str2) {
        try {
            parseMsgQueue(new String(Base64.decode(str, 2)), str2);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseJsonValueEncodedMsgQueue(String str, String str2) {
        try {
            parseMsgQueue(new JSONObject("{a=" + str + "}").optString("a", ""), str2);
        } catch (JSONException unused) {
        }
    }

    private void parseMsgQueue(String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JsMsg jsMsg = new JsMsg();
                jsMsg.type = jSONObject.getString("__msg_type");
                jsMsg.callback_id = jSONObject.optString("__callback_id", null);
                jsMsg.func = jSONObject.optString("func");
                jsMsg.params = jSONObject.optJSONObject("params");
                jsMsg.version = jSONObject.optInt("JSSDK");
                jsMsg.namespace = jSONObject.optString("namespace");
                jsMsg.iFrameUrl = jSONObject.optString("__iframe_url");
                jsMsg.safeV1AuthUrl = str2;
                Log.i("IESJsBridge", "safeV1AuthUrl: " + str2);
                if (!TextUtils.isEmpty(jsMsg.type) && !TextUtils.isEmpty(jsMsg.func)) {
                    Log.d("JsBridge", "parseMsQueue:" + Thread.currentThread());
                    IProtectedFuncHandler iProtectedFuncHandler = this.mProtectedFuncHandler;
                    if (iProtectedFuncHandler != null && iProtectedFuncHandler.needUpdateConfig(jsMsg)) {
                        JSONObject jSONObject2 = new JSONObject();
                        WebView webView = getWebView();
                        this.mProtectedFuncHandler.updateProtectedFunc(jsMsg, jSONObject2, webView != null ? webView.getUrl() : null, this);
                        return;
                    } else {
                        Message obtain = Message.obtain();
                        obtain.obj = jsMsg;
                        this.mHandler.sendMessage(obtain);
                    }
                }
            }
        } catch (Exception e) {
            Log.e("JsBridge", "e =" + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleJsMsg(JsMsg jsMsg) {
        Map<String, IJavaMethod> map;
        WebView webView = getWebView();
        if (webView == null || jsMsg == null || !TextUtils.equals("call", jsMsg.type) || (map = this.mRegisterMethod) == null || map.isEmpty()) {
            return;
        }
        if (!checkJsBridgePermission(jsMsg, webView.getUrl())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", -1);
                if (!TextUtils.isEmpty(jsMsg.iFrameUrl)) {
                    invokeJsCallbackToIFrame(jsMsg.iFrameUrl, jsMsg.callback_id, jSONObject);
                } else {
                    invokeJsCallback(jsMsg.callback_id, jSONObject);
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            IJavaMethod iJavaMethod = this.mRegisterMethod.get(jsMsg.func);
            if (iJavaMethod != null) {
                iJavaMethod.call(jsMsg, jSONObject2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (jsMsg.needCallback) {
            if (!TextUtils.isEmpty(jsMsg.iFrameUrl)) {
                invokeJsCallbackToIFrame(jsMsg.iFrameUrl, jsMsg.callback_id, jSONObject2);
            } else {
                invokeJsCallback(jsMsg.callback_id, jSONObject2);
            }
        }
    }

    protected boolean checkJsBridgePermission(JsMsg jsMsg, String str) {
        return this.disablePermissionCheck || isSafeHost(str) || isFuncPublic(jsMsg.func) || isFuncProtected(jsMsg.func);
    }

    private boolean isFuncPublic(String str) {
        List<String> list = this.mPublicFunc;
        return list != null && list.contains(str);
    }

    private boolean isFuncProtected(String str) {
        List<String> list = this.mProtectedFunc;
        return list != null && list.contains(str);
    }

    private void sendJsMessage(JSONObject jSONObject) {
        WebView webView;
        if (jSONObject == null || (webView = getWebView()) == null) {
            return;
        }
        LoadUrlUtil.loadUrl(webView, getJsBridge() + LibrarianImpl.Constants.DOT + getHandleMessageMethod() + "(" + jSONObject.toString() + ")");
    }

    public void sendJsMessageToIFrame(JSONObject jSONObject, String str) {
        WebView webView;
        if (jSONObject == null || (webView = getWebView()) == null) {
            return;
        }
        LoadUrlUtil.loadUrl(webView, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str).getBytes(), 2), jSONObject.toString(), Base64.encodeToString(str.getBytes(), 2)));
    }

    protected String getJsBridge() {
        return this.jsbridge;
    }

    public void setJsBridge(String str) {
        this.jsbridge = str;
    }

    protected String getHandleMessageMethod() {
        return this.handleMessageMethod;
    }

    public void setHandleMessageMethod(String str) {
        this.handleMessageMethod = str;
    }

    public void setHook(ISendMsgHook iSendMsgHook) {
        this.hook = iSendMsgHook;
    }

    protected String getFetchQueueMethodName() {
        return this.fetchQueueMethodName;
    }

    public void setFetchQueueMethodName(String str) {
        this.fetchQueueMethodName = str;
    }

    public boolean isSafeHost(String str) {
        List<String> list;
        if (!isHttpUrl(str)) {
            return false;
        }
        try {
            String parseUriHost = SafeUtil.parseUriHost(str);
            if (parseUriHost != null && (list = this.mSafeHost) != null && !list.isEmpty()) {
                for (int i = 0; i < this.mSafeHost.size(); i++) {
                    String str2 = this.mSafeHost.get(i);
                    if (parseUriHost.equals(str2) || parseUriHost.endsWith('.' + str2)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    protected boolean isHttpUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }

    @Override // com.bytedance.ies.web.jsbridge.IOnProtectedUpdateListener
    public void onUpdate(List<String> list, JsMsg jsMsg, JSONObject jSONObject) {
        this.mProtectedFunc = list;
        if (!TextUtils.isEmpty(jsMsg.iFrameUrl)) {
            invokeJsCallbackToIFrame(jsMsg.iFrameUrl, jsMsg.callback_id, jSONObject);
        } else {
            invokeJsCallback(jsMsg.callback_id, jSONObject);
        }
    }

    public void onDestroy() {
        this.mWebView = null;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mProtectedFuncHandler = null;
        this.mRegisterMethod = null;
    }
}
