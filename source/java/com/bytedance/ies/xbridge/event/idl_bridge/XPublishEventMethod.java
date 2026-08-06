package com.bytedance.ies.xbridge.event.idl_bridge;

import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.idl.AbsXPublishEventMethodIDL;
import com.bytedance.ies.xbridge.model.idl.CompletionBlock;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import com.bytedance.ies.xbridge.utils.XBridgeResultModelArguments;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XPublishEventMethod.kt */
@XBridgeMethod(name = "x.publishEvent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/xbridge/event/idl_bridge/XPublishEventMethod;", "Lcom/bytedance/ies/xbridge/event/idl/AbsXPublishEventMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "()V", "handle", "", "params", "Lcom/bytedance/ies/xbridge/event/idl/AbsXPublishEventMethodIDL$XPublishEventParamModel;", "callback", "Lcom/bytedance/ies/xbridge/model/idl/CompletionBlock;", "Lcom/bytedance/ies/xbridge/event/idl/AbsXPublishEventMethodIDL$XPublishEventResultModel;", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XPublishEventMethod extends AbsXPublishEventMethodIDL implements StatefulMethod {
    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(AbsXPublishEventMethodIDL.XPublishEventParamModel params, CompletionBlock<AbsXPublishEventMethodIDL.XPublishEventResultModel> callback, XBridgePlatformType type) {
        double asDouble;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(type, "type");
        String eventName = params.getEventName();
        Map<String, ? extends Object> params2 = params.getParams();
        Boolean isBroadcast = params.isBroadcast();
        boolean booleanValue = isBroadcast != null ? isBroadcast.booleanValue() : false;
        String str = eventName;
        if (str == null || str.length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
            return;
        }
        Number timestamp = params.getTimestamp();
        if (timestamp instanceof Number) {
            asDouble = asDouble(params.getTimestamp());
        } else {
            if (!(timestamp instanceof Integer)) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
                return;
            }
            asDouble = asDouble(params.getTimestamp());
        }
        Event event = new Event(eventName, (long) asDouble, null);
        event.setMapParams(params2);
        event.setBroadcast(booleanValue);
        EventCenter.enqueueEvent(event);
        CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(AbsXPublishEventMethodIDL.XPublishEventResultModel.class), null, 2, null);
    }
}
