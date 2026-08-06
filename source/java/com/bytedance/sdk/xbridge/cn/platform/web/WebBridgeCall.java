package com.bytedance.sdk.xbridge.cn.platform.web;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: WebBridgeCall.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\b\u0010#\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR\u001a\u0010\u001f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\n¨\u0006%"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBridgeCall;", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "Lorg/json/JSONObject;", "methodName", "", "params", "url", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V", "callbackId", "getCallbackId", "()Ljava/lang/String;", "setCallbackId", "(Ljava/lang/String;)V", "frameUrl", "getFrameUrl", "setFrameUrl", "msgType", "getMsgType", "setMsgType", "getParams", "()Lorg/json/JSONObject;", "platformType", "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "getPlatformType", "()Lcom/bytedance/sdk/xbridge/cn/PlatformType;", SchemaConstants.INNER_PARAM_PROTOCOL_VERSION, "getProtocolVersion", "setProtocolVersion", "rawReq", "getRawReq", "setRawReq", "sdkVersion", "getSdkVersion", "setSdkVersion", "getUrl", "convertParamsToJSONObject", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class WebBridgeCall extends BaseBridgeCall<JSONObject> {
    public static final String BIG_INT_STRATEGY = "bigIntStrategy";
    private String callbackId;
    private String frameUrl;
    private String msgType;
    private final JSONObject params;
    private final PlatformType platformType;
    private String protocolVersion;
    private String rawReq;
    private String sdkVersion;
    private final String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebBridgeCall(String methodName, JSONObject params, String url) {
        super(methodName);
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(url, "url");
        this.params = params;
        this.url = url;
        int i = 0;
        try {
            i = getParams().optInt("bigIntStrategy", 0);
        } catch (Exception unused) {
        }
        setBigIntStrategy(i);
        this.platformType = PlatformType.WEB;
        this.msgType = "";
        this.sdkVersion = "";
        this.frameUrl = "";
        this.rawReq = "";
        this.callbackId = "";
        this.protocolVersion = "";
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall
    public JSONObject getParams() {
        return this.params;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall
    public String getUrl() {
        return this.url;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall
    public PlatformType getPlatformType() {
        return this.platformType;
    }

    public final String getMsgType() {
        return this.msgType;
    }

    public final void setMsgType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.msgType = str;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final void setSdkVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sdkVersion = str;
    }

    public final String getFrameUrl() {
        return this.frameUrl;
    }

    public final void setFrameUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.frameUrl = str;
    }

    public final String getRawReq() {
        return this.rawReq;
    }

    public final void setRawReq(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rawReq = str;
    }

    public final String getCallbackId() {
        return this.callbackId;
    }

    public final void setCallbackId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.callbackId = str;
    }

    public final String getProtocolVersion() {
        return this.protocolVersion;
    }

    public final void setProtocolVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.protocolVersion = str;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall
    public JSONObject convertParamsToJSONObject() {
        return getParams();
    }
}
