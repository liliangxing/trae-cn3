package com.bytedance.sdk.xbridge.cn.storage.userdomainbridge;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.service.IAnnieProSupport;
import com.bytedance.sdk.xbridge.cn.storage.userdomainbridge.AbsXGetUserDomainStorageInfoMethodIDL;
import com.bytedance.sdk.xbridge.cn.storage.utils.IUserDomainNativeStorage;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainLocalStorageMonitor;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainNativeProviderFactory;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainStorageConstants;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XGetUserDomainStorageInfoMethod.kt */
@XBridgeMethod(name = "x.getUserDomainStorageInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/userdomainbridge/XGetUserDomainStorageInfoMethod;", "Lcom/bytedance/sdk/xbridge/cn/storage/userdomainbridge/AbsXGetUserDomainStorageInfoMethodIDL;", "()V", "methodName", "", "getMethodName", "()Ljava/lang/String;", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/storage/userdomainbridge/AbsXGetUserDomainStorageInfoMethodIDL$XGetUserDomainStorageInfoParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/storage/userdomainbridge/AbsXGetUserDomainStorageInfoMethodIDL$XGetUserDomainStorageInfoResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XGetUserDomainStorageInfoMethod extends AbsXGetUserDomainStorageInfoMethodIDL {
    private final String methodName = "x.getUserDomainStorageInfo";

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXGetUserDomainStorageInfoMethodIDL.XGetUserDomainStorageInfoParamModel params, CompletionBlock<AbsXGetUserDomainStorageInfoMethodIDL.XGetUserDomainStorageInfoResultModel> callback) {
        Set<String> userDomainStorageInfo;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        Boolean enableAppIdIsolation = params.getEnableAppIdIsolation();
        boolean booleanValue = enableAppIdIsolation != null ? enableAppIdIsolation.booleanValue() : false;
        IAnnieProSupport iAnnieProSupport = (IAnnieProSupport) bridgeContext.getService(IAnnieProSupport.class);
        String annieAppID = iAnnieProSupport != null ? iAnnieProSupport.getAnnieAppID() : null;
        boolean z = true;
        if (booleanValue) {
            String str = annieAppID;
            if (str == null || str.length() == 0) {
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetUserDomainStorageInfoMethodIDL.XGetUserDomainStorageInfoResultModel.class));
                ((AbsXGetUserDomainStorageInfoMethodIDL.XGetUserDomainStorageInfoResultModel) createXModel).setStatus(UserDomainStorageConstants.APPID_IS_EMPTY);
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
            XBaseModel createXModel2 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetUserDomainStorageInfoMethodIDL.XGetUserDomainStorageInfoResultModel.class));
            ((AbsXGetUserDomainStorageInfoMethodIDL.XGetUserDomainStorageInfoResultModel) createXModel2).setStatus(UserDomainStorageConstants.USER_NOT_LOGIN);
            callback.onSuccess((XBaseResultModel) createXModel2, "The user is not logged in");
            return;
        }
        IHostUserDepend hostUserDepend2 = XBaseRuntime.INSTANCE.getHostUserDepend();
        String userId = hostUserDepend2 != null ? hostUserDepend2.getUserId() : null;
        String str3 = userId;
        if (str3 != null && str3.length() != 0) {
            z = false;
        }
        if (z) {
            String str4 = this.methodName;
            StringBuilder sb2 = new StringBuilder("|isLogin:");
            if (valueOf == null) {
                valueOf = "false";
            }
            XBridgeInjectLogger.m174i(str4, sb2.append(valueOf).append(",uid is empty").toString(), "BridgeParam", bridgeContext.getContainerID());
            XBaseModel createXModel3 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetUserDomainStorageInfoMethodIDL.XGetUserDomainStorageInfoResultModel.class));
            ((AbsXGetUserDomainStorageInfoMethodIDL.XGetUserDomainStorageInfoResultModel) createXModel3).setStatus(UserDomainStorageConstants.UID_IS_EMPTY);
            Unit unit2 = Unit.INSTANCE;
            callback.onFailure(0, "The user ID cannot be empty or null", (XBaseResultModel) createXModel3);
            return;
        }
        if (ownerActivity == null) {
            XBaseModel createXModel4 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetUserDomainStorageInfoMethodIDL.XGetUserDomainStorageInfoResultModel.class));
            ((AbsXGetUserDomainStorageInfoMethodIDL.XGetUserDomainStorageInfoResultModel) createXModel4).setStatus(UserDomainStorageConstants.CONTEXT_IS_NULL);
            Unit unit3 = Unit.INSTANCE;
            callback.onFailure(0, "Context not provided in host", (XBaseResultModel) createXModel4);
            return;
        }
        XBridgeInjectLogger.m174i(this.methodName, "Get all keys", "BridgeParam", bridgeContext.getContainerID());
        long currentTimeMillis = System.currentTimeMillis();
        if (booleanValue) {
            userDomainStorageInfo = UserDomainNativeProviderFactory.providerUserDomainNativeStorage(ownerActivity).getUserDomainStorageInfo(userId + "appId_" + annieAppID);
        } else {
            IUserDomainNativeStorage providerUserDomainNativeStorage = UserDomainNativeProviderFactory.providerUserDomainNativeStorage(ownerActivity);
            Intrinsics.checkNotNull(userId);
            userDomainStorageInfo = providerUserDomainNativeStorage.getUserDomainStorageInfo(userId);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        String url = bridgeContext.getBridgeCall().getUrl();
        long size = userDomainStorageInfo.size();
        String name = bridgeContext.getPlatformType().name();
        XBaseModel createModel = XBridgeResultModelArguments.INSTANCE.createModel(AbsXGetUserDomainStorageInfoMethodIDL.XGetUserDomainStorageInfoResultModel.class);
        AbsXGetUserDomainStorageInfoMethodIDL.XGetUserDomainStorageInfoResultModel xGetUserDomainStorageInfoResultModel = (AbsXGetUserDomainStorageInfoMethodIDL.XGetUserDomainStorageInfoResultModel) createModel;
        xGetUserDomainStorageInfoResultModel.setKeys(CollectionsKt.toList(userDomainStorageInfo));
        xGetUserDomainStorageInfoResultModel.setStatus(UserDomainStorageConstants.READ_SUCCEED);
        callback.onSuccess((XBaseResultModel) createModel, "Read keys Succeed.");
        UserDomainLocalStorageMonitor.INSTANCE.report(userId, ownerActivity, url, size, this.methodName, name, UserDomainStorageConstants.READ_SUCCEED, currentTimeMillis2);
    }
}
