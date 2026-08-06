package com.bytedance.ies.xbridge;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgePlatform.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u0004\u0018\u00010\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH&J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0004J6\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\u0010\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0004R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/xbridge/XBridgePlatform;", "", "()V", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "getType", "()Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "createXReadableMap", "Lcom/bytedance/ies/xbridge/XReadableMap;", EventConstants.PARAM_SOURCE, "", "", "handle", "", "name", "params", "callback", "Lcom/bytedance/ies/xbridge/XBridgeMethod$Callback;", "xBridgeRegister", "Lcom/bytedance/ies/xbridge/XBridgeRegister;", "idlHandle", "Lcom/bytedance/ies/xbridge/IDLXBridgeMethod$Callback;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class XBridgePlatform {
    public abstract XReadableMap createXReadableMap(Map<String, ? extends Object> source);

    public abstract XBridgePlatformType getType();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void handle(String name, XReadableMap params, XBridgeMethod.Callback callback, XBridgeRegister xBridgeRegister) {
        XBridgeMethod provideMethod;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(xBridgeRegister, "xBridgeRegister");
        XBridgeMethodProvider findMethod = xBridgeRegister.findMethod(name);
        if (findMethod == null || (provideMethod = findMethod.provideMethod()) == null) {
            return;
        }
        provideMethod.handle(params, callback, getType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void idlHandle(String name, Map<String, ? extends Object> params, IDLXBridgeMethod.Callback callback, XBridgeRegister xBridgeRegister) {
        IDLXBridgeMethod provideMethod;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(xBridgeRegister, "xBridgeRegister");
        IDLXBridgeMethodProvider findIDLMethod = xBridgeRegister.findIDLMethod(name);
        if (findIDLMethod == null || (provideMethod = findIDLMethod.provideMethod()) == null) {
            return;
        }
        provideMethod.realHandle(params, callback, getType());
    }
}
