package com.bytedance.sdk.xbridge.cn.platform.web.protocol;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeCall;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol;
import com.bytedance.tobshadow.applog.encryptor.IEncryptorType;
import com.bytedance.tracing.log.Fields;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IESJSBridgeSupport.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u001a\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u001f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/web/protocol/IESJSBridgeSupport;", "Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBridgeProtocol;", LynxBridgeCall.NAME_SPACE, "", "(Ljava/lang/String;)V", "TAG", "mBridgeScheme", "checkBridgeScheme", "", IWeixinService.ResponseConstants.URL, "createBridgeCall", "Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBridgeCall;", "msg", "createCallbackMessage", "call", "data", "Lorg/json/JSONObject;", "createCallbackMsgWithoutFrame", "createCallbackParams", "createIframeCallbackMsg", "invokeJavaMethod", "onLoadResource", "", "onSetUp", "view", "Landroid/webkit/WebView;", "parseBase64EncodedMsgQueue", "parseJsonValueEncodedMsgQueue", "parseMsgQueue", "sendEvent", Fields.EVENT, "shouldOverrideUrlLoading", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IESJSBridgeSupport extends WebBridgeProtocol {
    private final String TAG;
    private final String mBridgeScheme;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IESJSBridgeSupport() {
        this(r0, 1, r0);
        String str = null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public void onSetUp(WebView view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public void sendEvent(String event, JSONObject data) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IESJSBridgeSupport(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, LynxBridgeCall.NAME_SPACE);
        this.mBridgeScheme = "bytedance";
        this.TAG = "IESJSBridgeSupport";
    }

    public /* synthetic */ IESJSBridgeSupport(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public WebBridgeCall createBridgeCall(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        JSONObject jSONObject = new JSONObject(msg);
        String optString = jSONObject.optString("__msg_type");
        String optString2 = jSONObject.optString("__callback_id");
        String optString3 = jSONObject.optString("func", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        String optString4 = jSONObject.optString("JSSDK");
        String optString5 = jSONObject.optString(LynxBridgeCall.NAME_SPACE, getDefaultNameSpace());
        long optLong = jSONObject.optLong("__timestamp", System.currentTimeMillis());
        String optString6 = jSONObject.optString("__iframe_url");
        String webViewUrlSync = getWebViewUrlSync();
        String str = webViewUrlSync != null ? webViewUrlSync : "";
        Intrinsics.checkNotNullExpressionValue(optString3, "bridgeName");
        WebBridgeCall webBridgeCall = new WebBridgeCall(optString3, optJSONObject, str);
        Intrinsics.checkNotNullExpressionValue(optString6, "frameUrl");
        webBridgeCall.setFrameUrl(optString6);
        webBridgeCall.setTimestamp(optLong);
        Intrinsics.checkNotNullExpressionValue(optString4, AccountMonitorConstants.NEW_SDK_VERSION_KEY);
        webBridgeCall.setSdkVersion(optString4);
        Intrinsics.checkNotNullExpressionValue(optString5, "nameSpace");
        webBridgeCall.setNamespace(wrapHostNamespace$anniex_release(optString5));
        webBridgeCall.setRawReq(msg);
        Intrinsics.checkNotNullExpressionValue(optString2, "callbackId");
        webBridgeCall.setCallbackId(optString2);
        Intrinsics.checkNotNullExpressionValue(optString, "msgType");
        webBridgeCall.setMsgType(optString);
        webBridgeCall.setAppId(Integer.valueOf(jSONObject.optInt("appID", 0)));
        webBridgeCall.setWebAuthUrlType(getWebAuthUrlType());
        webBridgeCall.setProtocolVersion("1");
        return webBridgeCall;
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public String createCallbackMessage(WebBridgeCall call, JSONObject data) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(data, "data");
        if (!TextUtils.isEmpty(call.getFrameUrl())) {
            return createIframeCallbackMsg(call, data);
        }
        return createCallbackMsgWithoutFrame(call, data);
    }

    private final JSONObject createCallbackParams(WebBridgeCall call, JSONObject data) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("__msg_type", "callback");
        jSONObject.put("__callback_id", call.getCallbackId());
        jSONObject.put("__params", data);
        return jSONObject;
    }

    private final String createIframeCallbackMsg(WebBridgeCall call, JSONObject data) {
        JSONObject createCallbackParams = createCallbackParams(call, data);
        String frameUrl = call.getFrameUrl();
        Charset charset = Charsets.UTF_8;
        if (frameUrl == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = frameUrl.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(bytes, 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(iFrameUrl…eArray(), Base64.NO_WRAP)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("iframe[src=\"%s\"", Arrays.copyOf(new Object[]{frameUrl}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        Charset charset2 = Charsets.UTF_8;
        if (format != null) {
            byte[] bytes2 = format.getBytes(charset2);
            Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
            String encodeToString2 = Base64.encodeToString(bytes2, 2);
            Intrinsics.checkNotNullExpressionValue(encodeToString2, "encodeToString(\n        … Base64.NO_WRAP\n        )");
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Arrays.copyOf(new Object[]{encodeToString2, createCallbackParams.toString(), encodeToString}, 3));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
            return format2;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final String createCallbackMsgWithoutFrame(WebBridgeCall call, JSONObject data) {
        return "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + createCallbackParams(call, data) + ')';
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public boolean shouldOverrideUrlLoading(String url) {
        return invokeJavaMethod(url);
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public void onLoadResource(String url) {
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        checkBridgeScheme(url);
    }

    public final boolean invokeJavaMethod(String url) {
        String str;
        if (url == null || TextUtils.isEmpty(url) || TextUtils.isEmpty(this.mBridgeScheme)) {
            return false;
        }
        Uri parse = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
        String scheme = parse.getScheme();
        if (scheme != null) {
            str = scheme.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase()");
        } else {
            str = null;
        }
        return Intrinsics.areEqual(this.mBridgeScheme, str) && checkBridgeScheme(url);
    }

    private final boolean checkBridgeScheme(String url) {
        if (!StringsKt.startsWith$default(url, this.mBridgeScheme, false, 2, (Object) null)) {
            return false;
        }
        String str = this.mBridgeScheme + "://dispatch_message/";
        String str2 = this.mBridgeScheme + "://private/setresult/";
        try {
        } catch (Exception e) {
            Log.e(this.TAG, "parse url failed,ignore=" + e);
        }
        if (!Intrinsics.areEqual(url, str)) {
            return StringsKt.startsWith$default(url, str2, false, 2, (Object) null);
        }
        safeSetV1AuthUrl();
        evaluateJavaScript("javascript:ToutiaoJSBridge._fetchQueue()", new ValueCallback() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.protocol.IESJSBridgeSupport$checkBridgeScheme$1
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(String str3) {
                IESJSBridgeSupport iESJSBridgeSupport = IESJSBridgeSupport.this;
                Intrinsics.checkNotNullExpressionValue(str3, "it");
                iESJSBridgeSupport.parseJsonValueEncodedMsgQueue(str3);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void parseJsonValueEncodedMsgQueue(String msg) {
        try {
            String optString = new JSONObject("{a=" + msg + '}').optString(IEncryptorType.DEFAULT_ENCRYPTOR, "");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"a\", \"\")");
            parseMsgQueue(optString);
        } catch (JSONException unused) {
        }
    }

    private final void parseBase64EncodedMsgQueue(String msg) {
        try {
            byte[] decode = Base64.decode(msg, 2);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(msg, Base64.NO_WRAP)");
            parseMsgQueue(new String(decode, Charsets.UTF_8));
        } catch (Exception unused) {
        }
    }

    private final void parseMsgQueue(String msg) {
        try {
            JSONArray jSONArray = new JSONArray(msg);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                handleJSMessage(jSONArray.getJSONObject(i).toString());
            }
        } catch (Exception e) {
            Log.e("JsBridge", "e =" + e);
        }
    }
}
