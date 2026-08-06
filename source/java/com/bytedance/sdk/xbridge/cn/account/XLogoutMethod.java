package com.bytedance.sdk.xbridge.cn.account;

import android.app.Activity;
import com.bytedance.ies.xbridge.event.AppEvent;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.model.collections.defaultimpl.DefaultXReadableMapImpl;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.account.AbsXLogoutMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* compiled from: XLogoutMethod.kt */
@XBridgeMethod(name = "x.logout")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/account/XLogoutMethod;", "Lcom/bytedance/sdk/xbridge/cn/account/AbsXLogoutMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/account/AbsXLogoutMethodIDL$XLogoutParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/account/AbsXLogoutMethodIDL$XLogoutResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XLogoutMethod extends AbsXLogoutMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXLogoutMethodIDL.XLogoutParamModel params, final CompletionBlock<AbsXLogoutMethodIDL.XLogoutResultModel> callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "context can not convert to activity", null, 4, null);
            return;
        }
        IHostUserDepend userDependInstance = RuntimeHelper.INSTANCE.getUserDependInstance();
        if (userDependInstance != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Map<String, Object> context = params.getContext();
            if (context != null) {
                Iterator<Map.Entry<String, Object>> it = context.entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    linkedHashMap.put(key, String.valueOf(context.get(key)));
                }
            }
            userDependInstance.logout(ownerActivity, new IHostUserDepend.ILogoutStatusCallback() { // from class: com.bytedance.sdk.xbridge.cn.account.XLogoutMethod$handle$1$2
                @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend.ILogoutStatusCallback
                public void onSuccess() {
                    if (AppEvent.LoginStatusChange.isActive()) {
                        EventCenter.enqueueEvent(new Event(AppEvent.LoginStatusChange.getEventName(), System.currentTimeMillis(), new DefaultXReadableMapImpl(new JSONObject(MapsKt.mapOf(TuplesKt.to("isLogin", false))))));
                    }
                    CompletionBlock<AbsXLogoutMethodIDL.XLogoutResultModel> completionBlock = callback;
                    XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXLogoutMethodIDL.XLogoutResultModel.class));
                    ((AbsXLogoutMethodIDL.XLogoutResultModel) createXModel).setStatus("loggedOut");
                    CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend.ILogoutStatusCallback
                public void onFail() {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "x.logout fail", null, 4, null);
                }
            }, linkedHashMap);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "hostUserDepend is null", null, 4, null);
        }
    }
}
