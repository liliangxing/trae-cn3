package com.bytedance.sdk.xbridge.cn.info;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.info.AbsXGetAppInfoMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XGetAppInfoMethod.kt */
@XBridgeMethod(name = "x.getAppInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\u0015\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0002J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\b\u0010 \u001a\u00020\u0004H\u0002J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006$"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/info/XGetAppInfoMethod;", "Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetAppInfoMethodIDL;", "()V", "canRunInBackground", "", "getContextDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostContextDepend;", "getLogDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostLogDepend;", "getNetworkType", "", "context", "Landroid/content/Context;", "getSafeArea", "Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetAppInfoMethodIDL$XBridgeBeanXGetAppInfoSafeArea;", "activity", "Landroid/app/Activity;", "applicationContext", "getScreenHeight", "", "getScreenOrientation", "getScreenWidth", "getStatusBarHeight", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetAppInfoMethodIDL$XGetAppInfoParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetAppInfoMethodIDL$XGetAppInfoResultModel;", "is32Bit", "px2dp", "px", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XGetAppInfoMethod extends AbsXGetAppInfoMethodIDL {

    /* compiled from: XGetAppInfoMethod.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NetworkUtils.NetworkType.values().length];
            try {
                iArr[NetworkUtils.NetworkType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NetworkUtils.NetworkType.MOBILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NetworkUtils.NetworkType.MOBILE_2G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NetworkUtils.NetworkType.MOBILE_3G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[NetworkUtils.NetworkType.MOBILE_3G_H.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[NetworkUtils.NetworkType.MOBILE_3G_HP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[NetworkUtils.NetworkType.MOBILE_4G.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[NetworkUtils.NetworkType.MOBILE_5G.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[NetworkUtils.NetworkType.WIFI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[NetworkUtils.NetworkType.WIFI_24GHZ.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[NetworkUtils.NetworkType.WIFI_5GHZ.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXGetAppInfoMethodIDL.XGetAppInfoParamModel params, CompletionBlock<AbsXGetAppInfoMethodIDL.XGetAppInfoResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Unit unit = null;
        if (getContextDependInstance() != null) {
            XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetAppInfoMethodIDL.XGetAppInfoResultModel.class));
            AbsXGetAppInfoMethodIDL.XGetAppInfoResultModel xGetAppInfoResultModel = (AbsXGetAppInfoMethodIDL.XGetAppInfoResultModel) createXModel;
            IHostContextDepend contextDependInstance = getContextDependInstance();
            if (contextDependInstance != null) {
                Context applicationContext = contextDependInstance.getApplicationContext();
                xGetAppInfoResultModel.setAppID(String.valueOf(contextDependInstance.getAppId()));
                xGetAppInfoResultModel.setAppName(contextDependInstance.getAppName());
                xGetAppInfoResultModel.setAppVersion(contextDependInstance.getVersionName());
                xGetAppInfoResultModel.setChannel(contextDependInstance.getChannel());
                xGetAppInfoResultModel.setLanguage(contextDependInstance.getLanguage());
                xGetAppInfoResultModel.setTeenMode(Boolean.valueOf(contextDependInstance.isTeenMode()));
                xGetAppInfoResultModel.setBaseMode(Boolean.valueOf(contextDependInstance.isBaseMode()));
                xGetAppInfoResultModel.setAppTheme(contextDependInstance.getSkinName());
                xGetAppInfoResultModel.setOsVersion(Build.VERSION.RELEASE);
                xGetAppInfoResultModel.setDevicePlatform("android");
                xGetAppInfoResultModel.setDeviceID(contextDependInstance.getDeviceId());
                xGetAppInfoResultModel.setDeviceModel(Build.MODEL);
                xGetAppInfoResultModel.setNetType(NetworkUtils.getNetworkTypeFast(applicationContext).name());
                xGetAppInfoResultModel.setNetworkType(getNetworkType(applicationContext));
                xGetAppInfoResultModel.setScreenOrientation(getScreenOrientation(applicationContext));
                xGetAppInfoResultModel.setUpdateVersionCode(contextDependInstance.getUpdateVersion());
                xGetAppInfoResultModel.setStatusBarHeight(Integer.valueOf(px2dp(getStatusBarHeight(applicationContext), applicationContext)));
                String currentTelcomCarrier = contextDependInstance.getCurrentTelcomCarrier();
                if (currentTelcomCarrier == null) {
                    currentTelcomCarrier = "";
                }
                xGetAppInfoResultModel.setCarrier(currentTelcomCarrier);
                try {
                    Activity ownerActivity = bridgeContext.getOwnerActivity();
                    xGetAppInfoResultModel.setScreenWidth(Integer.valueOf(getScreenWidth(ownerActivity, applicationContext)));
                    xGetAppInfoResultModel.setScreenHeight(Integer.valueOf(getScreenHeight(ownerActivity, applicationContext)));
                    if (!(ownerActivity instanceof Activity)) {
                        ownerActivity = null;
                    }
                    xGetAppInfoResultModel.setSafeArea(getSafeArea(ownerActivity, applicationContext));
                } catch (Exception unused) {
                }
            }
            IHostLogDepend logDependInstance = getLogDependInstance();
            if (logDependInstance != null) {
                HashMap hashMap = new HashMap();
                logDependInstance.putCommonParams(hashMap, true);
                if (hashMap.containsKey("iid")) {
                    xGetAppInfoResultModel.setInstallID((String) hashMap.get("iid"));
                }
            }
            String installID = xGetAppInfoResultModel.getInstallID();
            xGetAppInfoResultModel.setInstallID(installID != null ? installID : "");
            xGetAppInfoResultModel.set32Bit(Boolean.valueOf(is32Bit()));
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "hostContextDepend depend is null", null, 4, null);
        }
    }

    private final int px2dp(double px, Context context) {
        return (int) ((px / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private final IHostContextDepend getContextDependInstance() {
        return XBaseRuntime.INSTANCE.getHostContextDepend();
    }

    private final IHostLogDepend getLogDependInstance() {
        return XBaseRuntime.INSTANCE.getHostLogDepend();
    }

    private final boolean is32Bit() {
        String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
        Intrinsics.checkNotNullExpressionValue(strArr, "SUPPORTED_64_BIT_ABIS");
        return strArr.length == 0;
    }

    private final String getNetworkType(Context context) {
        NetworkUtils.NetworkType networkTypeFast = NetworkUtils.getNetworkTypeFast(context);
        switch (networkTypeFast == null ? -1 : WhenMappings.$EnumSwitchMapping$0[networkTypeFast.ordinal()]) {
            case 1:
                return "none";
            case 2:
                return "mobile";
            case 3:
                return "2g";
            case 4:
            case 5:
            case 6:
                return "3g";
            case 7:
                return "4g";
            case 8:
                return "5g";
            case 9:
            case 10:
            case 11:
                return OnekeyLoginConstants.NETWORK_TYPE_WIFI_STR;
            default:
                return "unknown";
        }
    }

    private final AbsXGetAppInfoMethodIDL.XBridgeBeanXGetAppInfoSafeArea getSafeArea(Activity activity, Context applicationContext) {
        if (activity == null) {
            return null;
        }
        boolean z = activity.getResources().getConfiguration().orientation == 2;
        int px2dp = px2dp(getStatusBarHeight(applicationContext), applicationContext);
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        double height = activity.getWindow().getDecorView().getHeight();
        Activity activity2 = activity;
        int px2dp2 = px2dp(height, activity2);
        int px2dp3 = px2dp(r3.top, applicationContext);
        int px2dp4 = px2dp(r3.bottom, applicationContext);
        if (px2dp2 == 0 && px2dp3 == 0) {
            px2dp4 += px2dp;
        }
        int max = Math.max(getScreenHeight(activity2, applicationContext) - px2dp4, 0);
        if (z) {
            AbsXGetAppInfoMethodIDL.XBridgeBeanXGetAppInfoSafeArea xBridgeBeanXGetAppInfoSafeArea = (AbsXGetAppInfoMethodIDL.XBridgeBeanXGetAppInfoSafeArea) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXGetAppInfoMethodIDL.XBridgeBeanXGetAppInfoSafeArea.class));
            xBridgeBeanXGetAppInfoSafeArea.setMarginLeft(Integer.valueOf(px2dp));
            xBridgeBeanXGetAppInfoSafeArea.setMarginRight(Integer.valueOf(max));
            xBridgeBeanXGetAppInfoSafeArea.setMarginTop((Number) 0);
            xBridgeBeanXGetAppInfoSafeArea.setMarginBottom((Number) 0);
            return xBridgeBeanXGetAppInfoSafeArea;
        }
        AbsXGetAppInfoMethodIDL.XBridgeBeanXGetAppInfoSafeArea xBridgeBeanXGetAppInfoSafeArea2 = (AbsXGetAppInfoMethodIDL.XBridgeBeanXGetAppInfoSafeArea) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXGetAppInfoMethodIDL.XBridgeBeanXGetAppInfoSafeArea.class));
        xBridgeBeanXGetAppInfoSafeArea2.setMarginTop(Integer.valueOf(px2dp));
        xBridgeBeanXGetAppInfoSafeArea2.setMarginBottom(Integer.valueOf(max));
        xBridgeBeanXGetAppInfoSafeArea2.setMarginRight((Number) 0);
        xBridgeBeanXGetAppInfoSafeArea2.setMarginLeft((Number) 0);
        return xBridgeBeanXGetAppInfoSafeArea2;
    }

    private final int getStatusBarHeight(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    private final String getScreenOrientation(Context context) {
        return context.getResources().getConfiguration().orientation == 1 ? "portrait" : "landscape";
    }

    private final int getScreenHeight(Context context, Context applicationContext) {
        if (context == null) {
            context = applicationContext;
        }
        boolean z = context.getResources().getConfiguration().orientation == 2;
        int px2dp = px2dp(ScreenUtils.INSTANCE.getScreenWidth(context), context);
        int px2dp2 = px2dp(ScreenUtils.INSTANCE.getScreenHeight(context), context);
        if (z) {
            return Math.min(px2dp, px2dp2);
        }
        return Math.max(px2dp, px2dp2);
    }

    private final int getScreenWidth(Context context, Context applicationContext) {
        if (context == null) {
            context = applicationContext;
        }
        boolean z = context.getResources().getConfiguration().orientation == 2;
        int px2dp = px2dp(ScreenUtils.INSTANCE.getScreenWidth(context), context);
        int px2dp2 = px2dp(ScreenUtils.INSTANCE.getScreenHeight(context), context);
        if (z) {
            return Math.max(px2dp, px2dp2);
        }
        return Math.min(px2dp, px2dp2);
    }
}
