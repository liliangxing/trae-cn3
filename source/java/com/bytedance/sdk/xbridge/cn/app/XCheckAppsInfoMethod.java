package com.bytedance.sdk.xbridge.cn.app;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.app.AbsXCheckAppsInfoMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XCheckAppsInfoMethod.kt */
@XBridgeMethod(name = "x.checkAppsInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/app/XCheckAppsInfoMethod;", "Lcom/bytedance/sdk/xbridge/cn/app/AbsXCheckAppsInfoMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/app/AbsXCheckAppsInfoMethodIDL$XCheckAppsInfoParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/app/AbsXCheckAppsInfoMethodIDL$XCheckAppsInfoResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XCheckAppsInfoMethod extends AbsXCheckAppsInfoMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXCheckAppsInfoMethodIDL.XCheckAppsInfoParamModel params, CompletionBlock<AbsXCheckAppsInfoMethodIDL.XCheckAppsInfoResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "context can not convert to activity", null, 4, null);
            return;
        }
        List<String> pkg_list = params.getPkg_list();
        Context applicationContext = ownerActivity.getApplicationContext();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (pkg_list != null) {
            try {
                for (String str : pkg_list) {
                    AppInfo appInfo = new AppInfo();
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(str, 0);
                            if (packageInfo != null) {
                                if (Build.VERSION.SDK_INT >= 28) {
                                    appInfo.setVersion_code(String.valueOf(packageInfo.getLongVersionCode()));
                                } else {
                                    appInfo.setVersion_code(String.valueOf(packageInfo.versionCode));
                                }
                                appInfo.setVersion_name(packageInfo.versionName);
                                appInfo.set_install(packageInfo.applicationInfo.enabled ? 1 : 0);
                            } else {
                                appInfo.set_install((Number) 0);
                            }
                        } catch (Exception unused) {
                            appInfo.set_install((Number) 0);
                        }
                    }
                    linkedHashMap.put(str, appInfo);
                }
            } catch (Throwable th) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "runtime exception: error message = " + th, null, 4, null);
                return;
            }
        }
        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXCheckAppsInfoMethodIDL.XCheckAppsInfoResultModel.class));
        ((AbsXCheckAppsInfoMethodIDL.XCheckAppsInfoResultModel) createXModel).setApps_info(linkedHashMap);
        CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
    }
}
