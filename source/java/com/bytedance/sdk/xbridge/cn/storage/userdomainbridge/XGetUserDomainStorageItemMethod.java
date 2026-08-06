package com.bytedance.sdk.xbridge.cn.storage.userdomainbridge;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.utils.JsonUtils;
import com.bytedance.sdk.xbridge.cn.service.IAnnieProSupport;
import com.bytedance.sdk.xbridge.cn.storage.userdomainbridge.AbsXGetUserDomainStorageItemMethodIDL;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainLocalStorageMonitor;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainNativeProviderFactory;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainStorageConstants;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;

/* compiled from: XGetUserDomainStorageItemMethod.kt */
@XBridgeMethod(name = "x.getUserDomainStorageItem")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J>\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/userdomainbridge/XGetUserDomainStorageItemMethod;", "Lcom/bytedance/sdk/xbridge/cn/storage/userdomainbridge/AbsXGetUserDomainStorageItemMethodIDL;", "()V", "methodName", "", "getMethodName", "()Ljava/lang/String;", "canRunInBackground", "", "getUserDomainStorageItem", "Lkotlin/Triple;", "", "context", "Landroid/content/Context;", "userId", "key", "sessionId", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/storage/userdomainbridge/AbsXGetUserDomainStorageItemMethodIDL$XGetUserDomainStorageItemParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/storage/userdomainbridge/AbsXGetUserDomainStorageItemMethodIDL$XGetUserDomainStorageItemResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XGetUserDomainStorageItemMethod extends AbsXGetUserDomainStorageItemMethodIDL {
    private final String methodName = "x.getUserDomainStorageItem";

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemParamModel params, CompletionBlock<AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel> callback) {
        Triple<Boolean, Boolean, Object> userDomainStorageItem;
        long j;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String key = params.getKey();
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        Boolean enableAppIdIsolation = params.getEnableAppIdIsolation();
        boolean booleanValue = enableAppIdIsolation != null ? enableAppIdIsolation.booleanValue() : false;
        IAnnieProSupport iAnnieProSupport = (IAnnieProSupport) bridgeContext.getService(IAnnieProSupport.class);
        String annieAppID = iAnnieProSupport != null ? iAnnieProSupport.getAnnieAppID() : null;
        if (booleanValue) {
            String str = annieAppID;
            if (str == null || str.length() == 0) {
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel.class));
                ((AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel) createXModel).setStatus(UserDomainStorageConstants.APPID_IS_EMPTY);
                Unit unit = Unit.INSTANCE;
                callback.onFailure(1001, "Use Annie Pro but app_id is empty", (XBaseResultModel) createXModel);
                return;
            }
        }
        IHostUserDepend hostUserDepend = XBaseRuntime.INSTANCE.getHostUserDepend();
        Object valueOf = hostUserDepend != null ? Boolean.valueOf(hostUserDepend.hasLogin()) : null;
        if (!Intrinsics.areEqual(valueOf, true)) {
            String str2 = this.methodName;
            StringBuilder append = new StringBuilder("key:").append(key).append("|isLogin:");
            if (valueOf == null) {
                valueOf = "false";
            }
            XBridgeInjectLogger.m174i(str2, append.append(valueOf).toString(), "BridgeParam", bridgeContext.getContainerID());
            XBaseModel createXModel2 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel.class));
            ((AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel) createXModel2).setStatus(UserDomainStorageConstants.USER_NOT_LOGIN);
            callback.onSuccess((XBaseResultModel) createXModel2, "The user is not logged in");
            return;
        }
        IHostUserDepend hostUserDepend2 = XBaseRuntime.INSTANCE.getHostUserDepend();
        String userId = hostUserDepend2 != null ? hostUserDepend2.getUserId() : null;
        String str3 = userId;
        if (str3 == null || str3.length() == 0) {
            String str4 = this.methodName;
            StringBuilder append2 = new StringBuilder("key:").append(key).append("|isLogin:");
            if (valueOf == null) {
                valueOf = "false";
            }
            XBridgeInjectLogger.m174i(str4, append2.append(valueOf).append(",uid is empty").toString(), "BridgeParam", bridgeContext.getContainerID());
            XBaseModel createXModel3 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel.class));
            ((AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel) createXModel3).setStatus(UserDomainStorageConstants.UID_IS_EMPTY);
            Unit unit2 = Unit.INSTANCE;
            callback.onFailure(0, "The user ID cannot be empty or null", (XBaseResultModel) createXModel3);
            return;
        }
        XBridgeInjectLogger.m174i(this.methodName, "context:" + (ownerActivity == null ? "null" : ownerActivity) + "|key:" + key, "BridgeParam", bridgeContext.getContainerID());
        if (ownerActivity == null) {
            XBaseModel createXModel4 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel.class));
            ((AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel) createXModel4).setStatus(UserDomainStorageConstants.CONTEXT_IS_NULL);
            Unit unit3 = Unit.INSTANCE;
            callback.onFailure(0, "Context not provided in host", (XBaseResultModel) createXModel4);
            return;
        }
        if (key.length() == 0) {
            XBaseModel createXModel5 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel.class));
            ((AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel) createXModel5).setStatus(UserDomainStorageConstants.INVALID_PARAM);
            Unit unit4 = Unit.INSTANCE;
            callback.onFailure(-3, "The key should not be empty.", (XBaseResultModel) createXModel5);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (booleanValue) {
            userDomainStorageItem = getUserDomainStorageItem(ownerActivity, userId + "appId_" + annieAppID, key, bridgeContext.getContainerID());
        } else {
            Intrinsics.checkNotNull(userId);
            userDomainStorageItem = getUserDomainStorageItem(ownerActivity, userId, key, bridgeContext.getContainerID());
        }
        boolean booleanValue2 = ((Boolean) userDomainStorageItem.component1()).booleanValue();
        boolean booleanValue3 = ((Boolean) userDomainStorageItem.component2()).booleanValue();
        Object component3 = userDomainStorageItem.component3();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        String url = bridgeContext.getBridgeCall().getUrl();
        if (component3 != null) {
            String json = JsonUtils.INSTANCE.toJson(component3);
            Charset charset = Charsets.UTF_8;
            if (json == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = json.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            j = bytes.length;
        } else {
            j = 0;
        }
        long j2 = j;
        String name = bridgeContext.getPlatformType().name();
        XBridgeInjectLogger.m174i(this.methodName, "isDataExist:" + booleanValue2 + ",isExpired:" + booleanValue3 + ",value:" + component3, "BridgeParam", bridgeContext.getContainerID());
        if (!booleanValue2) {
            XBridgeInjectLogger.m174i(this.methodName, "context:" + ownerActivity + "|key:" + key + " is not exist.", "BridgeParam", bridgeContext.getContainerID());
            XBaseModel createXModel6 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel.class));
            AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel xGetUserDomainStorageItemResultModel = (AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel) createXModel6;
            xGetUserDomainStorageItemResultModel.setStatus(UserDomainStorageConstants.DATA_NOT_EXIST);
            xGetUserDomainStorageItemResultModel.setValue(null);
            callback.onSuccess((XBaseResultModel) createXModel6, "Read Fail. Data does not exist ");
            UserDomainLocalStorageMonitor.INSTANCE.report(userId, ownerActivity, url, j2, this.methodName, name, UserDomainStorageConstants.DATA_NOT_EXIST, currentTimeMillis2);
            return;
        }
        if (booleanValue3) {
            XBaseModel createXModel7 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel.class));
            AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel xGetUserDomainStorageItemResultModel2 = (AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel) createXModel7;
            xGetUserDomainStorageItemResultModel2.setStatus(UserDomainStorageConstants.DATA_IS_EXPIRED);
            xGetUserDomainStorageItemResultModel2.setValue(null);
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel7, null, 2, null);
            UserDomainLocalStorageMonitor.INSTANCE.report(userId, ownerActivity, url, j2, this.methodName, name, UserDomainStorageConstants.DATA_IS_EXPIRED, currentTimeMillis2);
            return;
        }
        XBridgeInjectLogger.m174i(this.methodName, "storageValue:" + (component3 != null ? component3 : "null"), "BridgeResult", bridgeContext.getContainerID());
        if (component3 == null) {
            XBaseModel createXModel8 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel.class));
            AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel xGetUserDomainStorageItemResultModel3 = (AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel) createXModel8;
            xGetUserDomainStorageItemResultModel3.setStatus(UserDomainStorageConstants.READ_FAIL_UNKNOWEN_REASON);
            xGetUserDomainStorageItemResultModel3.setValue(null);
            Unit unit5 = Unit.INSTANCE;
            callback.onFailure(0, "Read Fail. Unknown reason", (XBaseResultModel) createXModel8);
            UserDomainLocalStorageMonitor.INSTANCE.report(userId, ownerActivity, url, j2, this.methodName, name, UserDomainStorageConstants.READ_FAIL_UNKNOWEN_REASON, currentTimeMillis2);
            return;
        }
        XBaseModel createXModel9 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel.class));
        AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel xGetUserDomainStorageItemResultModel4 = (AbsXGetUserDomainStorageItemMethodIDL.XGetUserDomainStorageItemResultModel) createXModel9;
        xGetUserDomainStorageItemResultModel4.setStatus(UserDomainStorageConstants.READ_SUCCEED);
        xGetUserDomainStorageItemResultModel4.setValue(XBridgeKTXKt.assignX(component3));
        callback.onSuccess((XBaseResultModel) createXModel9, "Read Succeed.");
        UserDomainLocalStorageMonitor.INSTANCE.report(userId, ownerActivity, url, j2, this.methodName, name, UserDomainStorageConstants.READ_SUCCEED, currentTimeMillis2);
    }

    private final Triple<Boolean, Boolean, Object> getUserDomainStorageItem(Context context, String userId, String key, String sessionId) {
        return UserDomainNativeProviderFactory.providerUserDomainNativeStorage(context).getUserDomainStorageItem(userId, key, this.methodName, sessionId);
    }
}
