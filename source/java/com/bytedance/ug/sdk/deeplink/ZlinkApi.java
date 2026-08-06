package com.bytedance.ug.sdk.deeplink;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.ug.sdk.deeplink.api.IClipboardHandler;
import com.bytedance.ug.sdk.deeplink.api.IFissionHandler;
import com.bytedance.ug.sdk.deeplink.api.IService;
import com.bytedance.ug.sdk.deeplink.callback.CallbackManager;
import com.bytedance.ug.sdk.deeplink.helper.AppFrontBackHelper;
import com.bytedance.ug.sdk.deeplink.helper.IAppStatusListener;
import com.bytedance.ug.sdk.deeplink.resolver.AppLinkResolver;
import com.bytedance.ug.sdk.deeplink.resolver.DeepLinkResolver;
import com.bytedance.ug.sdk.deeplink.resolver.ResolverManager;
import com.bytedance.ug.sdk.deeplink.settings.ZlinkSettingsApi;
import com.bytedance.ug.sdk.deeplink.utils.CommonUtils;
import com.bytedance.ug.sdk.deeplink.utils.EventUtil;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.bytedance.ug.sdk.deeplink.utils.ThreadUtils;
import com.bytedance.ug.sdk.deeplink.utils.ZLinkToolUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ZlinkApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u0005\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ+\u0010\u001b\u001a\u00020\u0000\"\b\b\u0000\u0010\u001c*\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001f2\u0006\u0010 \u001a\u0002H\u001c¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ug/sdk/deeplink/ZlinkApi;", "", "()V", "TAG", "", "isInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "doInit", "", "zlinkDependAbility", "Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility;", "getClipboardHandler", "Lcom/bytedance/ug/sdk/deeplink/api/IClipboardHandler;", "getFissionHandler", "Lcom/bytedance/ug/sdk/deeplink/api/IFissionHandler;", "getLaunchLogManager", "Lcom/bytedance/ug/sdk/deeplink/LaunchLogManager;", EventConstants.PARAM_SOURCE_INIT, "", "isZlink", "uri", "Landroid/net/Uri;", "type", "Lcom/bytedance/ug/sdk/deeplink/SchemeType;", "parseNewIntent", "intent", "Landroid/content/Intent;", "registerApi", "T", "Lcom/bytedance/ug/sdk/deeplink/api/IService;", "clazz", "Ljava/lang/Class;", "obj", "(Ljava/lang/Class;Lcom/bytedance/ug/sdk/deeplink/api/IService;)Lcom/bytedance/ug/sdk/deeplink/ZlinkApi;", "registerLifeCycle", "application", "Landroid/app/Application;", "setForbiddenClipboardByHost", "result", "deeplink_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ZlinkApi {
    public static final String TAG = "ZlinkApi";
    public static final ZlinkApi INSTANCE = new ZlinkApi();
    private static final AtomicBoolean isInited = new AtomicBoolean(false);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SchemeType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[SchemeType.ALL.ordinal()] = 1;
            iArr[SchemeType.APP_LINK.ordinal()] = 2;
            iArr[SchemeType.SINGLE_SCHEME.ordinal()] = 3;
            iArr[SchemeType.MULTI_SCHEME.ordinal()] = 4;
        }
    }

    private ZlinkApi() {
    }

    public final void registerLifeCycle(Application application) {
        if (ZLinkToolUtils.isMainProcess(application)) {
            DebugChecker.callRegisterLifeCycle = true;
            long currentTimeMillis = System.currentTimeMillis();
            GlobalContext.INSTANCE.setSApplication(application);
            AppFrontBackHelper.getInstance().register(application);
            EventUtil.registerLifecycleCost = System.currentTimeMillis() - currentTimeMillis;
        }
    }

    public final <T extends IService> ZlinkApi registerApi(Class<T> clazz, T obj) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        Intrinsics.checkParameterIsNotNull(obj, "obj");
        UgServiceManager.INSTANCE.register(clazz, obj);
        return this;
    }

    public final void init(ZlinkDependAbility zlinkDependAbility) {
        Intrinsics.checkParameterIsNotNull(zlinkDependAbility, "zlinkDependAbility");
        if (isInited.compareAndSet(false, true)) {
            doInit(zlinkDependAbility);
        }
    }

    public final boolean isInited() {
        return isInited.get();
    }

    private final void doInit(ZlinkDependAbility zlinkDependAbility) {
        long currentTimeMillis = System.currentTimeMillis();
        DebugChecker.check(zlinkDependAbility);
        HostCommonServices.setZlinkDependAbility(zlinkDependAbility);
        GlobalContext.INSTANCE.setSApplication(zlinkDependAbility.getApplication());
        if (ZLinkToolUtils.isMainProcess(GlobalContext.INSTANCE.getApplication())) {
            ZlinkSettingsApi.updateSettingsIfNeed();
            AppFrontBackHelper.getInstance().registerAppStatusListener(new IAppStatusListener() { // from class: com.bytedance.ug.sdk.deeplink.ZlinkApi$doInit$1
                @Override // com.bytedance.ug.sdk.deeplink.helper.IAppStatusListener
                public void onFront(Activity activity) {
                    boolean canTryAutoCheck = GlobalContext.INSTANCE.canTryAutoCheck();
                    Logger.m446d(ZlinkApi.TAG, "ZlinkApi onFront, autoCheck=" + canTryAutoCheck);
                    CommonUtils.recordFromBaiduWhenColdStart(activity);
                    if (canTryAutoCheck) {
                        if (ZlinkSettingsApi.isRequestedOrHasSettingsCache()) {
                            GlobalContext.INSTANCE.doAutoCheck();
                            return;
                        } else {
                            ZlinkSettingsApi.addSettingsListener(GlobalContext.INSTANCE.getAutoCheckListener());
                            return;
                        }
                    }
                    Logger.m446d(ZlinkApi.TAG, "callBackForCheckClipboard is called when canTryAutoCheck return false");
                    CallbackManager.callBackForCheckClipboard("", "", null);
                }

                @Override // com.bytedance.ug.sdk.deeplink.helper.IAppStatusListener
                public void onBack(Activity activity) {
                    Logger.m446d(ZlinkApi.TAG, "ZlinkApi onBack reset uri type");
                    GlobalContext.INSTANCE.resetUriType();
                    UriCacheHandler.clearSchemeCache();
                }
            }, true);
            ThreadUtils.runInMainThread(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.ZlinkApi$doInit$2
                @Override // java.lang.Runnable
                public final void run() {
                    CallbackManager.notifyZlinkInit();
                    HuaWeiReferrerHelper.getInstance().referrerAndUploadForHuaWeiWithDid(GlobalContext.INSTANCE.getSApplication());
                }
            });
            EventUtil.sendZlinkSdkInitEvent(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public final LaunchLogManager getLaunchLogManager() {
        LaunchLogManager launchLogManager = LaunchLogManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(launchLogManager, "LaunchLogManager.getInstance()");
        return launchLogManager;
    }

    public final IClipboardHandler getClipboardHandler() {
        return (IClipboardHandler) UgServiceManager.get$default(UgServiceManager.INSTANCE, IClipboardHandler.class, false, 2, null);
    }

    public final IFissionHandler getFissionHandler() {
        return (IFissionHandler) UgServiceManager.get$default(UgServiceManager.INSTANCE, IFissionHandler.class, false, 2, null);
    }

    public final void parseNewIntent(Intent intent) {
        if (isInited()) {
            ResolverManager.instance().parseIntent(GlobalContext.INSTANCE.getApplication(), intent);
        }
    }

    public final boolean isZlink(Uri uri, SchemeType type) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        if (uri == null) {
            return false;
        }
        if (!isInited()) {
            Logger.m447e(TAG, "call it after init");
            return false;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            return AppLinkResolver.isAppLink(uri) || DeepLinkResolver.isSingleScheme(uri) || DeepLinkResolver.isMultiScheme(uri);
        }
        if (i == 2) {
            return AppLinkResolver.isAppLink(uri);
        }
        if (i == 3) {
            return DeepLinkResolver.isSingleScheme(uri);
        }
        if (i != 4) {
            return false;
        }
        return DeepLinkResolver.isMultiScheme(uri);
    }

    public final void setForbiddenClipboardByHost(boolean result) {
        HostCommonServices.setForbiddenClipboardByHost(result);
    }
}
