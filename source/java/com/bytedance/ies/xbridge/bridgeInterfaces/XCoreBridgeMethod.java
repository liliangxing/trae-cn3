package com.bytedance.ies.xbridge.bridgeInterfaces;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.model.context.XContextProviderFactory;
import com.bytedance.ies.xbridge.model.params.XBaseParamModel;
import com.bytedance.ies.xbridge.model.results.XBaseResultModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XCoreBridgeMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J6\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00150\u0014J,\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00150\u00142\b\b\u0002\u0010\u0011\u001a\u00020\u0012J#\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\u0004\b\u0000\u0010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001aH\u0016¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001c\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/xbridge/bridgeInterfaces/XCoreBridgeMethod;", "Lcom/bytedance/ies/xbridge/XBridgeMethod;", "()V", "contextProviderFactory", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "getContextProviderFactory", "()Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "setContextProviderFactory", "(Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;)V", "canRunInBackground", "", "onFailure", "", "callback", "Lcom/bytedance/ies/xbridge/XBridgeMethod$Callback;", "code", "", "msg", "", "data", "", "", "onSuccess", "provideContext", "T", "clz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "setProviderFactory", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class XCoreBridgeMethod implements XBridgeMethod {
    private XContextProviderFactory contextProviderFactory;

    public boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public XBridgeMethod.Access getAccess() {
        return XBridgeMethod.DefaultImpls.getAccess(this);
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public Class<? extends XBaseParamModel> provideParamModel() {
        return XBridgeMethod.DefaultImpls.provideParamModel(this);
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public Class<? extends XBaseResultModel> provideResultModel() {
        return XBridgeMethod.DefaultImpls.provideResultModel(this);
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public void release() {
        XBridgeMethod.DefaultImpls.release(this);
    }

    public final XContextProviderFactory getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    public final void setContextProviderFactory(XContextProviderFactory xContextProviderFactory) {
        this.contextProviderFactory = xContextProviderFactory;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public void setProviderFactory(XContextProviderFactory contextProviderFactory) {
        this.contextProviderFactory = contextProviderFactory;
    }

    public <T> T provideContext(Class<T> clz) {
        Intrinsics.checkNotNullParameter(clz, "clz");
        XContextProviderFactory xContextProviderFactory = this.contextProviderFactory;
        if (xContextProviderFactory != null) {
            return (T) xContextProviderFactory.provideInstance(clz);
        }
        return null;
    }

    public static /* synthetic */ void onSuccess$default(XCoreBridgeMethod xCoreBridgeMethod, XBridgeMethod.Callback callback, Map map, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSuccess");
        }
        if ((i & 4) != 0) {
            str = "";
        }
        xCoreBridgeMethod.onSuccess(callback, map, str);
    }

    public final void onSuccess(XBridgeMethod.Callback callback, Map<String, Object> data, String msg) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(msg, "msg");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("code", 1);
        linkedHashMap.put("msg", msg);
        linkedHashMap.put("data", data);
        callback.invoke(linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onFailure$default(XCoreBridgeMethod xCoreBridgeMethod, XBridgeMethod.Callback callback, int i, String str, Map map, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailure");
        }
        if ((i2 & 4) != 0) {
            str = "";
        }
        if ((i2 & 8) != 0) {
            map = new LinkedHashMap();
        }
        xCoreBridgeMethod.onFailure(callback, i, str, map);
    }

    public final void onFailure(XBridgeMethod.Callback callback, int code, String msg, Map<String, Object> data) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("code", Integer.valueOf(code));
        linkedHashMap.put("msg", msg);
        linkedHashMap.put("data", data);
        callback.invoke(linkedHashMap);
    }
}
