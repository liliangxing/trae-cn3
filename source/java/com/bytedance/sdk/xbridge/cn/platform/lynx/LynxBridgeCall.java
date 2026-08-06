package com.bytedance.sdk.xbridge.cn.platform.lynx;

import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LynxBridgeCall.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBridgeCall;", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "Lcom/lynx/react/bridge/ReadableMap;", "methodName", "", "lynxParams", "pageUrl", "(Ljava/lang/String;Lcom/lynx/react/bridge/ReadableMap;Ljava/lang/String;)V", "getLynxParams", "()Lcom/lynx/react/bridge/ReadableMap;", "getPageUrl", "()Ljava/lang/String;", "params", "getParams", "platformType", "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "getPlatformType", "()Lcom/bytedance/sdk/xbridge/cn/PlatformType;", IWeixinService.ResponseConstants.URL, "getUrl", "convertParamsToJSONObject", "Lorg/json/JSONObject;", "unWrapperParams", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class LynxBridgeCall extends BaseBridgeCall<ReadableMap> {
    public static final String BIG_INT_STRATEGY = "bigIntStrategy";
    public static final String KEY_DATA = "data";
    public static final String NAME_SPACE = "namespace";
    private final ReadableMap lynxParams;
    private final String pageUrl;
    private final ReadableMap params;
    private final PlatformType platformType;
    private final String url;

    public final ReadableMap getLynxParams() {
        return this.lynxParams;
    }

    public final String getPageUrl() {
        return this.pageUrl;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LynxBridgeCall(String str, ReadableMap readableMap, String str2) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "methodName");
        Intrinsics.checkNotNullParameter(str2, "pageUrl");
        this.lynxParams = readableMap;
        this.pageUrl = str2;
        this.platformType = PlatformType.LYNX;
        ReadableMap unWrapperParams = unWrapperParams(readableMap);
        this.params = unWrapperParams == null ? (ReadableMap) new JavaOnlyMap() : unWrapperParams;
        this.url = str2;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall
    public PlatformType getPlatformType() {
        return this.platformType;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall
    public ReadableMap getParams() {
        return this.params;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall
    public String getUrl() {
        return this.url;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002c A[Catch: Exception -> 0x0046, TRY_LEAVE, TryCatch #0 {Exception -> 0x0046, blocks: (B:29:0x0006, B:5:0x0011, B:8:0x0021, B:12:0x002c, B:15:0x0037, B:19:0x0041), top: B:28:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041 A[Catch: Exception -> 0x0046, TRY_LEAVE, TryCatch #0 {Exception -> 0x0046, blocks: (B:29:0x0006, B:5:0x0011, B:8:0x0021, B:12:0x002c, B:15:0x0037, B:19:0x0041), top: B:28:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0011 A[Catch: Exception -> 0x0046, TRY_LEAVE, TryCatch #0 {Exception -> 0x0046, blocks: (B:29:0x0006, B:5:0x0011, B:8:0x0021, B:12:0x002c, B:15:0x0037, B:19:0x0041), top: B:28:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ReadableMap unWrapperParams(ReadableMap params) {
        boolean z;
        boolean z2 = true;
        if (params != null) {
            try {
                if (params.hasKey(NAME_SPACE)) {
                    z = true;
                    if (z) {
                        String string = params.getString(NAME_SPACE);
                        Intrinsics.checkNotNullExpressionValue(string, "params.getString(NAME_SPACE)");
                        setNamespace(string);
                    }
                    if (params == null && params.hasKey("bigIntStrategy")) {
                        setBigIntStrategy(params.getInt("bigIntStrategy", 0));
                    }
                    if (params != null || !params.hasKey("data")) {
                        z2 = false;
                    }
                    return !z2 ? params.getMap("data") : params;
                }
            } catch (Exception unused) {
                return new JavaOnlyMap();
            }
        }
        z = false;
        if (z) {
        }
        if (params == null && params.hasKey("bigIntStrategy")) {
        }
        if (params != null) {
        }
        z2 = false;
        if (!z2) {
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall
    public JSONObject convertParamsToJSONObject() {
        JavaOnlyMap params = getParams();
        JavaOnlyMap javaOnlyMap = params instanceof JavaOnlyMap ? params : null;
        JSONObject jSONObject = javaOnlyMap != null ? javaOnlyMap.toJSONObject() : null;
        return jSONObject == null ? super.convertParamsToJSONObject() : jSONObject;
    }
}
