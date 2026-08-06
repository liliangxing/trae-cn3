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
import com.bytedance.sdk.xbridge.cn.storage.userdomainbridge.AbsXSetUserDomainStorageItemMethodIDL;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainLocalStorageMonitor;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainNativeProviderFactory;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainStorageConstants;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;

/* compiled from: XSetUserDomainStorageItemMethod.kt */
@XBridgeMethod(name = "x.setUserDomainStorageItem")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016JE\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/userdomainbridge/XSetUserDomainStorageItemMethod;", "Lcom/bytedance/sdk/xbridge/cn/storage/userdomainbridge/AbsXSetUserDomainStorageItemMethodIDL;", "()V", "methodName", "", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/storage/userdomainbridge/AbsXSetUserDomainStorageItemMethodIDL$XSetUserDomainStorageItemParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/storage/userdomainbridge/AbsXSetUserDomainStorageItemMethodIDL$XSetUserDomainStorageItemResultModel;", "setUserDomainStorageItemWrapper", "context", "Landroid/content/Context;", "userId", "key", "data", "", "expectedTime", "", "sessionId", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/String;)Z", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XSetUserDomainStorageItemMethod extends AbsXSetUserDomainStorageItemMethodIDL {
    private final String methodName = "x.setUserDomainStorageItem";

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXSetUserDomainStorageItemMethodIDL.XSetUserDomainStorageItemParamModel params, CompletionBlock<AbsXSetUserDomainStorageItemMethodIDL.XSetUserDomainStorageItemResultModel> callback) {
        boolean userDomainStorageItemWrapper;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        Boolean enableAppIdIsolation = params.getEnableAppIdIsolation();
        boolean booleanValue = enableAppIdIsolation != null ? enableAppIdIsolation.booleanValue() : false;
        String key = params.getKey();
        Object data = params.getData();
        Number expiredTime = params.getExpiredTime();
        Long valueOf = expiredTime != null ? Long.valueOf(expiredTime.longValue()) : null;
        IAnnieProSupport iAnnieProSupport = (IAnnieProSupport) bridgeContext.getService(IAnnieProSupport.class);
        String annieAppID = iAnnieProSupport != null ? iAnnieProSupport.getAnnieAppID() : null;
        if (booleanValue) {
            String str = annieAppID;
            if (str == null || str.length() == 0) {
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXSetUserDomainStorageItemMethodIDL.XSetUserDomainStorageItemResultModel.class));
                ((AbsXSetUserDomainStorageItemMethodIDL.XSetUserDomainStorageItemResultModel) createXModel).setStatus(UserDomainStorageConstants.APPID_IS_EMPTY);
                Unit unit = Unit.INSTANCE;
                callback.onFailure(1001, "Use Annie Pro but app_id is empty", (XBaseResultModel) createXModel);
                return;
            }
        }
        IHostUserDepend hostUserDepend = XBaseRuntime.INSTANCE.getHostUserDepend();
        Object valueOf2 = hostUserDepend != null ? Boolean.valueOf(hostUserDepend.hasLogin()) : null;
        if (!Intrinsics.areEqual(valueOf2, true)) {
            String str2 = this.methodName;
            StringBuilder append = new StringBuilder("key:").append(key).append("|data:").append(data).append("|isLogin:");
            if (valueOf2 == null) {
                valueOf2 = "false";
            }
            XBridgeInjectLogger.m174i(str2, append.append(valueOf2).toString(), "BridgeParam", bridgeContext.getContainerID());
            XBaseModel createXModel2 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXSetUserDomainStorageItemMethodIDL.XSetUserDomainStorageItemResultModel.class));
            ((AbsXSetUserDomainStorageItemMethodIDL.XSetUserDomainStorageItemResultModel) createXModel2).setStatus(UserDomainStorageConstants.USER_NOT_LOGIN);
            callback.onSuccess((XBaseResultModel) createXModel2, "The user is not logged in");
            return;
        }
        IHostUserDepend hostUserDepend2 = XBaseRuntime.INSTANCE.getHostUserDepend();
        String userId = hostUserDepend2 != null ? hostUserDepend2.getUserId() : null;
        String str3 = userId;
        if (str3 == null || str3.length() == 0) {
            XBridgeInjectLogger.m174i(this.methodName, "key:" + key + "|data:" + data + "|isLogin:" + valueOf2 + ", but uid is empty", "BridgeParam", bridgeContext.getContainerID());
            XBaseModel createXModel3 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXSetUserDomainStorageItemMethodIDL.XSetUserDomainStorageItemResultModel.class));
            ((AbsXSetUserDomainStorageItemMethodIDL.XSetUserDomainStorageItemResultModel) createXModel3).setStatus(UserDomainStorageConstants.UID_IS_EMPTY);
            Unit unit2 = Unit.INSTANCE;
            callback.onFailure(0, "The user ID cannot be empty or null", (XBaseResultModel) createXModel3);
            return;
        }
        XBridgeInjectLogger.m174i(this.methodName, "context:" + (ownerActivity == null ? "null" : ownerActivity) + "|key:" + key, "BridgeParam", bridgeContext.getContainerID());
        if (ownerActivity == null) {
            XBaseModel createXModel4 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXSetUserDomainStorageItemMethodIDL.XSetUserDomainStorageItemResultModel.class));
            ((AbsXSetUserDomainStorageItemMethodIDL.XSetUserDomainStorageItemResultModel) createXModel4).setStatus(UserDomainStorageConstants.CONTEXT_IS_NULL);
            Unit unit3 = Unit.INSTANCE;
            callback.onFailure(0, "Context not provided in host", (XBaseResultModel) createXModel4);
            return;
        }
        if (key.length() == 0) {
            XBaseModel createXModel5 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXSetUserDomainStorageItemMethodIDL.XSetUserDomainStorageItemResultModel.class));
            ((AbsXSetUserDomainStorageItemMethodIDL.XSetUserDomainStorageItemResultModel) createXModel5).setStatus(UserDomainStorageConstants.INVALID_PARAM);
            Unit unit4 = Unit.INSTANCE;
            callback.onFailure(-3, "The key should not be empty.", (XBaseResultModel) createXModel5);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (booleanValue) {
            userDomainStorageItemWrapper = setUserDomainStorageItemWrapper(ownerActivity, userId + "appId_" + annieAppID, key, data, valueOf, bridgeContext.getContainerID());
        } else {
            Intrinsics.checkNotNull(userId);
            userDomainStorageItemWrapper = setUserDomainStorageItemWrapper(ownerActivity, userId, key, data, valueOf, bridgeContext.getContainerID());
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        String url = bridgeContext.getBridgeCall().getUrl();
        String json = JsonUtils.INSTANCE.toJson(data);
        Charset charset = Charsets.UTF_8;
        if (json == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = json.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        long length = bytes.length;
        String name = bridgeContext.getPlatformType().name();
        XBridgeInjectLogger.m174i(this.methodName, "success:" + userDomainStorageItemWrapper, "BridgeResult", bridgeContext.getContainerID());
        if (userDomainStorageItemWrapper) {
            XBaseModel createXModel6 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXSetUserDomainStorageItemMethodIDL.XSetUserDomainStorageItemResultModel.class));
            ((AbsXSetUserDomainStorageItemMethodIDL.XSetUserDomainStorageItemResultModel) createXModel6).setStatus(UserDomainStorageConstants.WRITE_SUCCESS);
            callback.onSuccess((XBaseResultModel) createXModel6, "Write succeed");
            UserDomainLocalStorageMonitor.INSTANCE.report(userId, ownerActivity, url, length, this.methodName, name, UserDomainStorageConstants.WRITE_SUCCESS, currentTimeMillis2);
            return;
        }
        XBaseModel createXModel7 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXSetUserDomainStorageItemMethodIDL.XSetUserDomainStorageItemResultModel.class));
        ((AbsXSetUserDomainStorageItemMethodIDL.XSetUserDomainStorageItemResultModel) createXModel7).setStatus(UserDomainStorageConstants.WRITE_FAIL_UNKNOWEN_REASON);
        Unit unit5 = Unit.INSTANCE;
        callback.onFailure(0, "Write failed for unknown reasons. Check data type First.", (XBaseResultModel) createXModel7);
        UserDomainLocalStorageMonitor.INSTANCE.report(userId, ownerActivity, url, length, this.methodName, name, UserDomainStorageConstants.WRITE_FAIL_UNKNOWEN_REASON, currentTimeMillis2);
    }

    private final boolean setUserDomainStorageItemWrapper(Context context, String userId, String key, Object data, Long expectedTime, String sessionId) {
        return UserDomainNativeProviderFactory.providerUserDomainNativeStorage(context).setUserDomainStorageItem(userId, key, data, expectedTime, this.methodName, sessionId);
    }
}
