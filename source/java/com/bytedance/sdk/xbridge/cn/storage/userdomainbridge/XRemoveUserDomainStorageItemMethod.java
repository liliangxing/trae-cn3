package com.bytedance.sdk.xbridge.cn.storage.userdomainbridge;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.service.IAnnieProSupport;
import com.bytedance.sdk.xbridge.cn.storage.userdomainbridge.AbsXRemoveUserDomainStorageItemMethodIDL;
import com.bytedance.sdk.xbridge.cn.storage.utils.IUserDomainNativeStorage;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainLocalStorageMonitor;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainNativeProviderFactory;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainStorageConstants;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XRemoveUserDomainStorageItemMethod.kt */
@XBridgeMethod(name = "x.removeUserDomainStorageItem")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/userdomainbridge/XRemoveUserDomainStorageItemMethod;", "Lcom/bytedance/sdk/xbridge/cn/storage/userdomainbridge/AbsXRemoveUserDomainStorageItemMethodIDL;", "()V", "methodName", "", "getMethodName", "()Ljava/lang/String;", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/storage/userdomainbridge/AbsXRemoveUserDomainStorageItemMethodIDL$XRemoveUserDomainStorageItemParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/storage/userdomainbridge/AbsXRemoveUserDomainStorageItemMethodIDL$XRemoveUserDomainStorageItemResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XRemoveUserDomainStorageItemMethod extends AbsXRemoveUserDomainStorageItemMethodIDL {
    private final String methodName = "x.removeUserDomainStorageItem";

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemParamModel params, CompletionBlock<AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel> callback) {
        Pair<Boolean, Boolean> removeUserDomainStorageItem;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Boolean enableAppIdIsolation = params.getEnableAppIdIsolation();
        boolean booleanValue = enableAppIdIsolation != null ? enableAppIdIsolation.booleanValue() : false;
        IAnnieProSupport iAnnieProSupport = (IAnnieProSupport) bridgeContext.getService(IAnnieProSupport.class);
        String annieAppID = iAnnieProSupport != null ? iAnnieProSupport.getAnnieAppID() : null;
        if (booleanValue) {
            String str = annieAppID;
            if (str == null || str.length() == 0) {
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel.class));
                ((AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel) createXModel).setStatus(UserDomainStorageConstants.APPID_IS_EMPTY);
                Unit unit = Unit.INSTANCE;
                callback.onFailure(1001, "Use Annie Pro but app_id is empty", (XBaseResultModel) createXModel);
                return;
            }
        }
        IHostUserDepend hostUserDepend = XBaseRuntime.INSTANCE.getHostUserDepend();
        Object valueOf = hostUserDepend != null ? Boolean.valueOf(hostUserDepend.hasLogin()) : null;
        if (!Intrinsics.areEqual(valueOf, true)) {
            String str2 = this.methodName;
            StringBuilder sb = new StringBuilder("isLogin:");
            if (valueOf == null) {
                valueOf = "false";
            }
            XBridgeInjectLogger.m174i(str2, sb.append(valueOf).toString(), "BridgeParam", bridgeContext.getContainerID());
            XBaseModel createXModel2 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel.class));
            ((AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel) createXModel2).setStatus(UserDomainStorageConstants.USER_NOT_LOGIN);
            callback.onSuccess((XBaseResultModel) createXModel2, "The user is not logged in");
            return;
        }
        IHostUserDepend hostUserDepend2 = XBaseRuntime.INSTANCE.getHostUserDepend();
        String userId = hostUserDepend2 != null ? hostUserDepend2.getUserId() : null;
        String str3 = userId;
        if (str3 == null || str3.length() == 0) {
            String str4 = this.methodName;
            StringBuilder sb2 = new StringBuilder("|isLogin:");
            if (valueOf == null) {
                valueOf = "false";
            }
            XBridgeInjectLogger.m174i(str4, sb2.append(valueOf).append(",uid is empty").toString(), "BridgeParam", bridgeContext.getContainerID());
            XBaseModel createXModel3 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel.class));
            ((AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel) createXModel3).setStatus(UserDomainStorageConstants.UID_IS_EMPTY);
            Unit unit2 = Unit.INSTANCE;
            callback.onFailure(0, "The user ID cannot be empty or null", (XBaseResultModel) createXModel3);
            return;
        }
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            XBaseModel createXModel4 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel.class));
            ((AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel) createXModel4).setStatus(UserDomainStorageConstants.CONTEXT_IS_NULL);
            Unit unit3 = Unit.INSTANCE;
            callback.onFailure(0, "Context not provided in host", (XBaseResultModel) createXModel4);
            return;
        }
        String key = params.getKey();
        String str5 = key;
        if (str5 == null || str5.length() == 0) {
            XBridgeInjectLogger.m174i(this.methodName, "key is exmpty,remove fail", "BridgeParam", bridgeContext.getContainerID());
            XBaseModel createXModel5 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel.class));
            ((AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel) createXModel5).setStatus(UserDomainStorageConstants.INVALID_PARAM);
            Unit unit4 = Unit.INSTANCE;
            callback.onFailure(-3, "The key should not be empty", (XBaseResultModel) createXModel5);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (booleanValue) {
            removeUserDomainStorageItem = UserDomainNativeProviderFactory.providerUserDomainNativeStorage(ownerActivity).removeUserDomainStorageItem(userId + "appId_" + annieAppID, key);
        } else {
            IUserDomainNativeStorage providerUserDomainNativeStorage = UserDomainNativeProviderFactory.providerUserDomainNativeStorage(ownerActivity);
            Intrinsics.checkNotNull(userId);
            removeUserDomainStorageItem = providerUserDomainNativeStorage.removeUserDomainStorageItem(userId, key);
        }
        boolean booleanValue2 = ((Boolean) removeUserDomainStorageItem.component1()).booleanValue();
        boolean booleanValue3 = ((Boolean) removeUserDomainStorageItem.component2()).booleanValue();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        String url = bridgeContext.getBridgeCall().getUrl();
        String name = bridgeContext.getPlatformType().name();
        if (!booleanValue2) {
            XBridgeInjectLogger.m174i(this.methodName, "Key is not exist,remove fail", "BridgeParam", bridgeContext.getContainerID());
            XBaseModel createXModel6 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel.class));
            ((AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel) createXModel6).setStatus(UserDomainStorageConstants.DATA_NOT_EXIST);
            callback.onSuccess((XBaseResultModel) createXModel6, "Key is not exist,remove fail");
            UserDomainLocalStorageMonitor.INSTANCE.report(userId, ownerActivity, url, 0L, this.methodName, name, UserDomainStorageConstants.DATA_NOT_EXIST, currentTimeMillis2);
            return;
        }
        if (booleanValue3) {
            XBridgeInjectLogger.m174i(this.methodName, "key " + key + ",removed succeed.", "BridgeParam", bridgeContext.getContainerID());
            XBaseModel createXModel7 = XBridgeKTXKt.createXModel((Class<XBaseModel>) AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel.class);
            ((AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel) createXModel7).setStatus(UserDomainStorageConstants.REMOVE_SUCCEED);
            callback.onSuccess((XBaseResultModel) createXModel7, "Remove succeed");
            UserDomainLocalStorageMonitor.INSTANCE.report(userId, ownerActivity, url, 0L, this.methodName, name, UserDomainStorageConstants.REMOVE_SUCCEED, currentTimeMillis2);
            return;
        }
        XBridgeInjectLogger.m174i(this.methodName, "key " + key + ",removed failed,unknown reason.", "BridgeParam", bridgeContext.getContainerID());
        XBaseModel createXModel8 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel.class));
        ((AbsXRemoveUserDomainStorageItemMethodIDL.XRemoveUserDomainStorageItemResultModel) createXModel8).setStatus(UserDomainStorageConstants.REMOVE_FAIL_UNKNOWEN_REASON);
        Unit unit5 = Unit.INSTANCE;
        callback.onFailure(0, "Remove fail, unknown reason", (XBaseResultModel) createXModel8);
        UserDomainLocalStorageMonitor.INSTANCE.report(userId, ownerActivity, url, 0L, this.methodName, name, UserDomainStorageConstants.REMOVE_FAIL_UNKNOWEN_REASON, currentTimeMillis2);
    }
}
