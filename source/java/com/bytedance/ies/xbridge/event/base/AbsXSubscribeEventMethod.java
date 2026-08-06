package com.bytedance.ies.xbridge.event.base;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.event.model.XSubscribeEventMethodParamModel;
import com.bytedance.ies.xbridge.model.results.XDefaultResultModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbsXSubscribeEventMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/xbridge/event/base/AbsXSubscribeEventMethod;", "Lcom/bytedance/ies/xbridge/bridgeInterfaces/XCoreBridgeMethod;", "()V", "access", "Lcom/bytedance/ies/xbridge/XBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/ies/xbridge/XBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "handle", "", "params", "Lcom/bytedance/ies/xbridge/XReadableMap;", "callback", "Lcom/bytedance/ies/xbridge/XBridgeMethod$Callback;", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "Lcom/bytedance/ies/xbridge/event/model/XSubscribeEventMethodParamModel;", "Lcom/bytedance/ies/xbridge/event/base/AbsXSubscribeEventMethod$XSubscribeEventCallback;", "provideParamModel", "Ljava/lang/Class;", "provideResultModel", "Lcom/bytedance/ies/xbridge/model/results/XDefaultResultModel;", "XSubscribeEventCallback", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsXSubscribeEventMethod extends XCoreBridgeMethod {
    private final XBridgeMethod.Access access = XBridgeMethod.Access.PUBLIC;
    private final String name = "x.subscribeEvent";

    public abstract void handle(XSubscribeEventMethodParamModel params, XSubscribeEventCallback callback, XBridgePlatformType type);

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public XBridgeMethod.Access getAccess() {
        return this.access;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public String getName() {
        return this.name;
    }

    /* compiled from: AbsXSubscribeEventMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/xbridge/event/base/AbsXSubscribeEventMethod$XSubscribeEventCallback;", "", "onFailure", "", "code", "", "msg", "", "onSuccess", "result", "Lcom/bytedance/ies/xbridge/model/results/XDefaultResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface XSubscribeEventCallback {
        void onFailure(int code, String msg);

        void onSuccess(XDefaultResultModel result, String msg);

        /* compiled from: AbsXSubscribeEventMethod.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ void onSuccess$default(XSubscribeEventCallback xSubscribeEventCallback, XDefaultResultModel xDefaultResultModel, String str, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSuccess");
                }
                if ((i & 2) != 0) {
                    str = "";
                }
                xSubscribeEventCallback.onSuccess(xDefaultResultModel, str);
            }

            public static /* synthetic */ void onFailure$default(XSubscribeEventCallback xSubscribeEventCallback, int i, String str, int i2, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailure");
                }
                if ((i2 & 2) != 0) {
                    str = "";
                }
                xSubscribeEventCallback.onFailure(i, str);
            }
        }
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public Class<XSubscribeEventMethodParamModel> provideParamModel() {
        return XSubscribeEventMethodParamModel.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public Class<XDefaultResultModel> provideResultModel() {
        return XDefaultResultModel.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public void handle(XReadableMap params, final XBridgeMethod.Callback callback, XBridgePlatformType type) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(type, "type");
        XSubscribeEventMethodParamModel convert = XSubscribeEventMethodParamModel.INSTANCE.convert(params);
        if (convert == null) {
            XCoreBridgeMethod.onFailure$default(this, callback, -3, null, null, 12, null);
        } else {
            handle(convert, new XSubscribeEventCallback() { // from class: com.bytedance.ies.xbridge.event.base.AbsXSubscribeEventMethod$handle$1
                @Override // com.bytedance.ies.xbridge.event.base.AbsXSubscribeEventMethod.XSubscribeEventCallback
                public void onSuccess(XDefaultResultModel result, String msg) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    AbsXSubscribeEventMethod.this.onSuccess(callback, XDefaultResultModel.INSTANCE.convert(result), msg);
                }

                @Override // com.bytedance.ies.xbridge.event.base.AbsXSubscribeEventMethod.XSubscribeEventCallback
                public void onFailure(int code, String msg) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    XCoreBridgeMethod.onFailure$default(AbsXSubscribeEventMethod.this, callback, code, msg, null, 8, null);
                }
            }, type);
        }
    }
}
