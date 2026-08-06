package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.media.utils.XBridgePermissionUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLocationPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostSystemActionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionGrantCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.model.XGetLocationCallback;
import com.bytedance.sdk.xbridge.cn.runtime.model.XGetLocationResult;
import com.bytedance.sdk.xbridge.cn.system.AbsXGetLocationMethodIDL;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: XGetLocationMethod.kt */
@XBridgeMethod(name = "x.getLocation")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XGetLocationMethod;", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXGetLocationMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXGetLocationMethodIDL$XGetLocationParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXGetLocationMethodIDL$XGetLocationResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XGetLocationMethod extends AbsXGetLocationMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(final IBDXBridgeContext bridgeContext, AbsXGetLocationMethodIDL.XGetLocationParamModel params, final CompletionBlock<AbsXGetLocationMethodIDL.XGetLocationResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "context can not convert to activity", null, 4, null);
            return;
        }
        IHostLocationPermissionDepend locationPermissionDependInstance = RuntimeHelper.INSTANCE.getLocationPermissionDependInstance(bridgeContext);
        if (locationPermissionDependInstance == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "LocationPermissionDepend is null", null, 4, null);
        } else {
            locationPermissionDependInstance.requestPermission(ownerActivity, bridgeContext, getName(), new OnPermissionGrantCallback() { // from class: com.bytedance.sdk.xbridge.cn.system.XGetLocationMethod$handle$1
                @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionGrantCallback
                public void onAllGranted() {
                    try {
                        XBridgePermissionUtils xBridgePermissionUtils = XBridgePermissionUtils.INSTANCE;
                        Context applicationContext = ownerActivity.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
                        final boolean isLocationServiceEnabled = xBridgePermissionUtils.isLocationServiceEnabled(applicationContext);
                        IHostSystemActionDepend hostSystemActionDepend = XBaseRuntime.INSTANCE.getHostSystemActionDepend();
                        if (hostSystemActionDepend == null) {
                            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "HostSystemActionDepend is null", null, 4, null);
                            return;
                        }
                        XBridgeInjectLogger.m171d(this.getName(), "location permission all granted", "BridgeProcessing", bridgeContext.getContainerID());
                        Context applicationContext2 = ownerActivity.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext2, "activity.applicationContext");
                        final XGetLocationMethod xGetLocationMethod = this;
                        final IBDXBridgeContext iBDXBridgeContext = bridgeContext;
                        final CompletionBlock<AbsXGetLocationMethodIDL.XGetLocationResultModel> completionBlock = callback;
                        hostSystemActionDepend.getLocation(applicationContext2, new XGetLocationCallback() { // from class: com.bytedance.sdk.xbridge.cn.system.XGetLocationMethod$handle$1$onAllGranted$1
                            @Override // com.bytedance.sdk.xbridge.cn.runtime.model.XGetLocationCallback
                            public void onSuccess(XGetLocationResult locationResult) {
                                Intrinsics.checkNotNullParameter(locationResult, "locationResult");
                                XBridgeInjectLogger.m171d(XGetLocationMethod.this.getName(), "location permission all granted,enable:" + isLocationServiceEnabled + ",location:" + locationResult, "BridgeProcessing", iBDXBridgeContext.getContainerID());
                                AbsXGetLocationMethodIDL.XGetLocationResultModel xGetLocationResultModel = (AbsXGetLocationMethodIDL.XGetLocationResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXGetLocationMethodIDL.XGetLocationResultModel.class));
                                xGetLocationResultModel.setEnable(Boolean.valueOf(isLocationServiceEnabled));
                                xGetLocationResultModel.setLongitude(Double.valueOf(locationResult.getLongitude()));
                                xGetLocationResultModel.setLatitude(Double.valueOf(locationResult.getLatitude()));
                                CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, xGetLocationResultModel, null, 2, null);
                            }

                            @Override // com.bytedance.sdk.xbridge.cn.runtime.model.XGetLocationCallback
                            public void onFail(String msg) {
                                Intrinsics.checkNotNullParameter(msg, "msg");
                                XBridgeInjectLogger.m171d(XGetLocationMethod.this.getName(), "get location result is null,enable:" + isLocationServiceEnabled, "BridgeProcessing", iBDXBridgeContext.getContainerID());
                                AbsXGetLocationMethodIDL.XGetLocationResultModel xGetLocationResultModel = (AbsXGetLocationMethodIDL.XGetLocationResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXGetLocationMethodIDL.XGetLocationResultModel.class));
                                xGetLocationResultModel.setEnable(Boolean.valueOf(isLocationServiceEnabled));
                                xGetLocationResultModel.setLongitude(null);
                                xGetLocationResultModel.setLatitude(null);
                                CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, xGetLocationResultModel, null, 2, null);
                            }
                        });
                    } catch (Exception e) {
                        XBridgeInjectLogger.m171d(this.getName(), "get location err:" + e.getMessage(), "BridgeProcessing", bridgeContext.getContainerID());
                        CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "get location err:" + e.getMessage(), null, 4, null);
                    }
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionGrantCallback
                public void onNotGranted() {
                    AbsXGetLocationMethodIDL.XGetLocationResultModel xGetLocationResultModel = (AbsXGetLocationMethodIDL.XGetLocationResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXGetLocationMethodIDL.XGetLocationResultModel.class));
                    xGetLocationResultModel.setEnable(false);
                    xGetLocationResultModel.setLongitude(null);
                    xGetLocationResultModel.setLatitude(null);
                    CompletionBlock.DefaultImpls.onSuccess$default(callback, xGetLocationResultModel, null, 2, null);
                }
            });
        }
    }
}
