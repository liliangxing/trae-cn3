package com.bytedance.trae.anniex;

import android.os.Build;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.trae.anniex.AbsAppGetAppInfoMethodIDL;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.network.NetworkMonitor;
import com.bytedance.trae.utils.TrustedDomainUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppInfoBridgeMethod.kt */
@XBridgeMethod(name = "app.getAppInfo")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/anniex/AppInfoBridgeMethod;", "Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL;", "<init>", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;", "getStatusBarHeight", "", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AppInfoBridgeMethod extends AbsAppGetAppInfoMethodIDL {
    public static final int $stable = 0;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsAppGetAppInfoMethodIDL.AppGetAppInfoParamModel params, CompletionBlock<AbsAppGetAppInfoMethodIDL.AppGetAppInfoResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!TrustedDomainUtils.INSTANCE.isTrustedUrl(bridgeContext.getBridgeCall().getUrl())) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "untrusted domain", null, 4, null);
            return;
        }
        XBaseModel createXModel = XBridgeKTXKt.createXModel((Class<XBaseModel>) AbsAppGetAppInfoMethodIDL.AppGetAppInfoResultModel.class);
        AbsAppGetAppInfoMethodIDL.AppGetAppInfoResultModel appGetAppInfoResultModel = (AbsAppGetAppInfoMethodIDL.AppGetAppInfoResultModel) createXModel;
        appGetAppInfoResultModel.setAid(String.valueOf(AppHost.INSTANCE.getAppId()));
        appGetAppInfoResultModel.setUser_id(IApplog.INSTANCE.getUserID());
        appGetAppInfoResultModel.setDevice_id(IApplog.INSTANCE.getDeviceId());
        appGetAppInfoResultModel.setStatusBarHeight(Integer.valueOf(getStatusBarHeight()));
        appGetAppInfoResultModel.setNetType(NetworkMonitor.INSTANCE.isNetworkAvailable() ? "unknown" : "none");
        appGetAppInfoResultModel.setAppVersion(AppHost.INSTANCE.getVersionName());
        appGetAppInfoResultModel.setOs_version(Build.VERSION.RELEASE);
        appGetAppInfoResultModel.setDevice_model(Build.MODEL);
        appGetAppInfoResultModel.setInstall_id(IApplog.INSTANCE.getInstallId());
        appGetAppInfoResultModel.setOpen_udid(IApplog.INSTANCE.getOpenUDid());
        appGetAppInfoResultModel.setInnerAppName(AppHost.INSTANCE.getAppName());
        appGetAppInfoResultModel.setCarrier("");
        appGetAppInfoResultModel.setDevice_platform("android");
        appGetAppInfoResultModel.setAppVersonCode(String.valueOf(AppHost.INSTANCE.getVersionCode()));
        appGetAppInfoResultModel.setChannel(AppHost.INSTANCE.getBuildChannel());
        appGetAppInfoResultModel.setAppName(AppHost.INSTANCE.getAppName());
        appGetAppInfoResultModel.setDevice_type(Build.MODEL);
        appGetAppInfoResultModel.setVersionCode(String.valueOf(AppHost.INSTANCE.getVersionCode()));
        CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
    }

    private final int getStatusBarHeight() {
        int identifier = AppHost.INSTANCE.getApplication().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return AppHost.INSTANCE.getApplication().getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
