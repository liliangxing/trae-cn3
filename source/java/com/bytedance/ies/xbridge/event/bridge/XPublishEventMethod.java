package com.bytedance.ies.xbridge.event.bridge;

import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.base.AbsXPublishEventMethod;
import com.bytedance.ies.xbridge.event.model.XPublishEventMethodParamModel;
import com.bytedance.ies.xbridge.model.results.XDefaultResultModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XPublishEventMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/xbridge/event/bridge/XPublishEventMethod;", "Lcom/bytedance/ies/xbridge/event/base/AbsXPublishEventMethod;", "()V", "handle", "", "params", "Lcom/bytedance/ies/xbridge/event/model/XPublishEventMethodParamModel;", "callback", "Lcom/bytedance/ies/xbridge/event/base/AbsXPublishEventMethod$XPublishEventCallback;", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XPublishEventMethod extends AbsXPublishEventMethod {
    @Override // com.bytedance.ies.xbridge.event.base.AbsXPublishEventMethod
    public void handle(XPublishEventMethodParamModel params, AbsXPublishEventMethod.XPublishEventCallback callback, XBridgePlatformType type) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(type, "type");
        EventCenter.enqueueEvent(new Event(params.getEventName(), params.getTimestamp(), params.getParams()));
        AbsXPublishEventMethod.XPublishEventCallback.DefaultImpls.onSuccess$default(callback, new XDefaultResultModel(), null, 2, null);
    }
}
