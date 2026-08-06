package com.bytedance.sdk.xbridge.cn.account;

import android.app.Activity;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.AppEvent;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.account.AbsXLoginMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostRouterDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeMethodHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XLoginMethod.kt */
@XBridgeMethod(name = "x.login")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/account/XLoginMethod;", "Lcom/bytedance/sdk/xbridge/cn/account/AbsXLoginMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/account/AbsXLoginMethodIDL$XLoginParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/account/AbsXLoginMethodIDL$XLoginResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XLoginMethod extends AbsXLoginMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXLoginMethodIDL.XLoginParamModel params, final CompletionBlock<AbsXLoginMethodIDL.XLoginResultModel> callback) {
        IHostRouterDepend routerDependInstance;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "context is null", null, 4, null);
            return;
        }
        Activity activity = XBridgeMethodHelper.INSTANCE.getActivity(ownerActivity);
        if (activity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "context can not convert to activity", null, 4, null);
            return;
        }
        final IHostUserDepend userDependInstance = RuntimeHelper.INSTANCE.getUserDependInstance();
        if (userDependInstance != null) {
            boolean keepOpen = params.getKeepOpen();
            Unit unit = null;
            if (userDependInstance.hasLogin()) {
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXLoginMethodIDL.XLoginResultModel.class));
                AbsXLoginMethodIDL.XLoginResultModel xLoginResultModel = (AbsXLoginMethodIDL.XLoginResultModel) createXModel;
                xLoginResultModel.setStatus("loggedIn");
                xLoginResultModel.setAlreadyLoggedIn(true);
                CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
                if (keepOpen || (routerDependInstance = RuntimeHelper.INSTANCE.getRouterDependInstance()) == null) {
                    return;
                }
                routerDependInstance.closeView(bridgeContext, "", false);
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Map<String, Object> context = params.getContext();
            if (context != null) {
                for (String str : context.keySet()) {
                    linkedHashMap.put(str, String.valueOf(context.get(str)));
                }
            }
            IHostUserDepend.ILoginStatusCallback iLoginStatusCallback = new IHostUserDepend.ILoginStatusCallback() { // from class: com.bytedance.sdk.xbridge.cn.account.XLoginMethod$handle$1$loginCallback$1
                @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend.ILoginStatusCallback
                public void onSuccess() {
                    boolean hasLogin = IHostUserDepend.this.hasLogin();
                    if (AppEvent.LoginStatusChange.isActive()) {
                        Event event = new Event(AppEvent.LoginStatusChange.getEventName(), System.currentTimeMillis(), (XReadableMap) null, 4, (DefaultConstructorMarker) null);
                        event.setMapParams(MapsKt.mapOf(TuplesKt.to("isLogin", Boolean.valueOf(hasLogin))));
                        EventCenter.enqueueEvent(event);
                    }
                    if (hasLogin) {
                        CompletionBlock<AbsXLoginMethodIDL.XLoginResultModel> completionBlock = callback;
                        XBaseModel createXModel2 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXLoginMethodIDL.XLoginResultModel.class));
                        AbsXLoginMethodIDL.XLoginResultModel xLoginResultModel2 = (AbsXLoginMethodIDL.XLoginResultModel) createXModel2;
                        xLoginResultModel2.setStatus("loggedIn");
                        xLoginResultModel2.setAlreadyLoggedIn(false);
                        CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel2, null, 2, null);
                        return;
                    }
                    CompletionBlock<AbsXLoginMethodIDL.XLoginResultModel> completionBlock2 = callback;
                    XBaseModel createXModel3 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXLoginMethodIDL.XLoginResultModel.class));
                    AbsXLoginMethodIDL.XLoginResultModel xLoginResultModel3 = (AbsXLoginMethodIDL.XLoginResultModel) createXModel3;
                    xLoginResultModel3.setStatus("cancelled");
                    xLoginResultModel3.setAlreadyLoggedIn(false);
                    CompletionBlock.DefaultImpls.onSuccess$default(completionBlock2, (XBaseResultModel) createXModel3, null, 2, null);
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend.ILoginStatusCallback
                public void onFail() {
                    if (AppEvent.LoginStatusChange.isActive()) {
                        Event event = new Event(AppEvent.LoginStatusChange.getEventName(), System.currentTimeMillis(), (XReadableMap) null, 4, (DefaultConstructorMarker) null);
                        event.setMapParams(MapsKt.mapOf(TuplesKt.to("isLogin", false)));
                        EventCenter.enqueueEvent(event);
                        Event event2 = new Event(AppEvent.LoginStatusChange.getEventName(), System.currentTimeMillis(), (XReadableMap) null, 4, (DefaultConstructorMarker) null);
                        event2.setMapParams(MapsKt.mapOf(TuplesKt.to("isLogin", false)));
                        EventCenter.enqueueEvent(event2);
                    }
                    CompletionBlock<AbsXLoginMethodIDL.XLoginResultModel> completionBlock = callback;
                    XBaseModel createXModel2 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXLoginMethodIDL.XLoginResultModel.class));
                    AbsXLoginMethodIDL.XLoginResultModel xLoginResultModel2 = (AbsXLoginMethodIDL.XLoginResultModel) createXModel2;
                    xLoginResultModel2.setStatus("cancelled");
                    xLoginResultModel2.setAlreadyLoggedIn(false);
                    CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel2, null, 2, null);
                }
            };
            if (keepOpen) {
                userDependInstance.login(activity, iLoginStatusCallback, linkedHashMap);
                unit = Unit.INSTANCE;
            } else {
                IHostUserDepend.LoginParamsExt loginParamsExt = new IHostUserDepend.LoginParamsExt();
                loginParamsExt.setKeepOpen(keepOpen);
                Unit unit2 = Unit.INSTANCE;
                userDependInstance.login(activity, iLoginStatusCallback, linkedHashMap, loginParamsExt);
                IHostRouterDepend routerDependInstance2 = RuntimeHelper.INSTANCE.getRouterDependInstance();
                if (routerDependInstance2 != null) {
                    unit = Boolean.valueOf(routerDependInstance2.closeView(bridgeContext, "", false));
                }
            }
            if (unit != null) {
                return;
            }
        }
        CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "hostUserDepend is null", null, 4, null);
        Unit unit3 = Unit.INSTANCE;
    }
}
