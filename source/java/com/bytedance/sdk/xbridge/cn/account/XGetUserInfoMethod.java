package com.bytedance.sdk.xbridge.cn.account;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.MethodModelBean;
import com.bytedance.sdk.xbridge.cn.XBridgeDynamicModel;
import com.bytedance.sdk.xbridge.cn.account.AbsXGetUserInfoMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XGetUserInfoMethod.kt */
@XBridgeMethod(name = "x.getUserInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/account/XGetUserInfoMethod;", "Lcom/bytedance/sdk/xbridge/cn/account/AbsXGetUserInfoMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/account/AbsXGetUserInfoMethodIDL$XGetUserInfoParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/account/AbsXGetUserInfoMethodIDL$XGetUserInfoResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XGetUserInfoMethod extends AbsXGetUserInfoMethodIDL {
    /* JADX WARN: Multi-variable type inference failed */
    public XGetUserInfoMethod() {
        XBridgeDynamicModel.INSTANCE.addMethodModelMap(getClass(), new MethodModelBean(AbsXGetUserInfoMethodIDL.XGetUserInfoParamModel.class, AbsXGetUserInfoMethodIDL.XGetUserInfoResultModel.class));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXGetUserInfoMethodIDL.XGetUserInfoParamModel params, CompletionBlock<AbsXGetUserInfoMethodIDL.XGetUserInfoResultModel> callback) {
        String shortID;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IHostUserDepend userDependInstance = RuntimeHelper.INSTANCE.getUserDependInstance();
        Unit unit = null;
        if (userDependInstance != null) {
            XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetUserInfoMethodIDL.XGetUserInfoResultModel.class));
            AbsXGetUserInfoMethodIDL.XGetUserInfoResultModel xGetUserInfoResultModel = (AbsXGetUserInfoMethodIDL.XGetUserInfoResultModel) createXModel;
            boolean hasLogin = userDependInstance.hasLogin();
            xGetUserInfoResultModel.setHasLoggedIn(Boolean.valueOf(hasLogin));
            xGetUserInfoResultModel.setLogin(Boolean.valueOf(hasLogin));
            if (hasLogin) {
                AbsXGetUserInfoMethodIDL.XBridgeBeanXGetUserInfoUserInfo xBridgeBeanXGetUserInfoUserInfo = (AbsXGetUserInfoMethodIDL.XBridgeBeanXGetUserInfoUserInfo) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXGetUserInfoMethodIDL.XBridgeBeanXGetUserInfoUserInfo.class));
                String userId = userDependInstance.getUserId();
                String str = "";
                if (userId == null) {
                    userId = "";
                }
                xBridgeBeanXGetUserInfoUserInfo.setUserID(userId);
                String secUid = userDependInstance.getSecUid();
                if (secUid == null) {
                    secUid = "";
                }
                xBridgeBeanXGetUserInfoUserInfo.setSecUserID(secUid);
                String uniqueID = userDependInstance.getUniqueID();
                if (uniqueID == null) {
                    uniqueID = "";
                }
                xBridgeBeanXGetUserInfoUserInfo.setUniqueID(uniqueID);
                String nickname = userDependInstance.getNickname();
                if (nickname == null) {
                    nickname = "";
                }
                xBridgeBeanXGetUserInfoUserInfo.setNickname(nickname);
                String avatarURL = userDependInstance.getAvatarURL();
                if (avatarURL == null) {
                    avatarURL = "";
                }
                xBridgeBeanXGetUserInfoUserInfo.setAvatarURL(avatarURL);
                String boundPhone = userDependInstance.getBoundPhone();
                if (boundPhone == null) {
                    boundPhone = "";
                }
                xBridgeBeanXGetUserInfoUserInfo.setHasBoundPhone(Boolean.valueOf(boundPhone.length() > 0));
                xBridgeBeanXGetUserInfoUserInfo.setBoundPhone(xBridgeBeanXGetUserInfoUserInfo.getHasBoundPhone());
                String boundPhone2 = userDependInstance.getBoundPhone();
                if (boundPhone2 == null) {
                    boundPhone2 = "";
                }
                xBridgeBeanXGetUserInfoUserInfo.setBindPhone(boundPhone2);
                if (Intrinsics.areEqual(xGetUserInfoResultModel.getHasLoggedIn(), true)) {
                    IHostUserDepend.UserModelExt userModelExt = userDependInstance.getUserModelExt();
                    if (userModelExt != null && (shortID = userModelExt.getShortID()) != null) {
                        str = shortID;
                    }
                    xBridgeBeanXGetUserInfoUserInfo.setShortID(str);
                }
                xGetUserInfoResultModel.setUserInfo(xBridgeBeanXGetUserInfoUserInfo);
            }
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "hostUserDepend is null", null, 4, null);
        }
    }
}
