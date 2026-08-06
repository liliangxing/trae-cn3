package com.bytedance.ug.sdk.deeplink;

import android.app.Activity;
import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.api.internal.IClipboardInternalApi;
import com.bytedance.ug.sdk.deeplink.callback.CallbackManager;
import com.bytedance.ug.sdk.deeplink.helper.AppFrontBackHelper;
import com.bytedance.ug.sdk.deeplink.resolver.IResolver;
import com.bytedance.ug.sdk.deeplink.resolver.ResolverManager;
import com.bytedance.ug.sdk.deeplink.resolver.ResolverType;
import com.bytedance.ug.sdk.deeplink.settings.SettingsUpdateListener;
import com.bytedance.ug.sdk.deeplink.settings.ZlinkSettingsApi;
import com.bytedance.ug.sdk.deeplink.utils.EventUtil;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.bytedance.ug.sdk.deeplink.utils.ThreadUtils;
import com.bytedance.ug.sdk.deeplink.utils.UGZlinkLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: GlobalContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\u0016J\u0018\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0014J$\u0010\u001d\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/bytedance/ug/sdk/deeplink/GlobalContext;", "", "()V", "autoCheckListener", "Lcom/bytedance/ug/sdk/deeplink/settings/SettingsUpdateListener;", "getAutoCheckListener", "()Lcom/bytedance/ug/sdk/deeplink/settings/SettingsUpdateListener;", "sApplication", "Landroid/app/Application;", "getSApplication", "()Landroid/app/Application;", "setSApplication", "(Landroid/app/Application;)V", "uriType", "Lcom/bytedance/ug/sdk/deeplink/UriType;", "getUriType", "()Lcom/bytedance/ug/sdk/deeplink/UriType;", "setUriType", "(Lcom/bytedance/ug/sdk/deeplink/UriType;)V", "canTryAutoCheck", "", "doAutoCheck", "", "getApplication", "resetUriType", "setCallUri", "uri", "Landroid/net/Uri;", "autoClearClipboard", "setCallUriForAppLink", "otherParameters", "Lorg/json/JSONObject;", "deeplink_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GlobalContext {
    private static Application sApplication;
    public static final GlobalContext INSTANCE = new GlobalContext();
    private static UriType uriType = UriType.ILLEGAL;
    private static final SettingsUpdateListener autoCheckListener = new SettingsUpdateListener() { // from class: com.bytedance.ug.sdk.deeplink.GlobalContext$autoCheckListener$1
        @Override // com.bytedance.ug.sdk.deeplink.settings.SettingsUpdateListener
        public void onSettingsUpdateListener() {
            ZlinkSettingsApi.removeSettingsListener(this);
            GlobalContext.INSTANCE.doAutoCheck();
        }
    };

    private GlobalContext() {
    }

    public final Application getSApplication() {
        return sApplication;
    }

    public final void setSApplication(Application application) {
        sApplication = application;
    }

    public final UriType getUriType() {
        return uriType;
    }

    public final void setUriType(UriType uriType2) {
        Intrinsics.checkParameterIsNotNull(uriType2, "<set-?>");
        uriType = uriType2;
    }

    public final Application getApplication() {
        Application application = sApplication;
        if (application == null) {
            throw new IllegalStateException("Application has not init".toString());
        }
        if (application == null) {
            Intrinsics.throwNpe();
        }
        return application;
    }

    public final void resetUriType() {
        uriType = UriType.ILLEGAL;
    }

    public final boolean canTryAutoCheck() {
        IZlinkDepend zlinkDepend = HostCommonServices.getZlinkDepend();
        boolean isConfirmedPrivacy = zlinkDepend != null ? zlinkDepend.isConfirmedPrivacy() : true;
        Logger.m446d(ZlinkApi.TAG, "isPrivacyConfirmed is " + isConfirmedPrivacy + ",sAutoCheck is " + HostCommonServices.isAutoCheck() + ",the settings request is returned : " + ZlinkSettingsApi.isRequested() + ", isRequestedOrHasSettingsCache: " + ZlinkSettingsApi.isRequestedOrHasSettingsCache() + " when canTryAutoCheck is called");
        return isConfirmedPrivacy && HostCommonServices.isAutoCheck();
    }

    public final SettingsUpdateListener getAutoCheckListener() {
        return autoCheckListener;
    }

    public final void doAutoCheck() {
        ThreadUtils.runInMainThread(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.GlobalContext$doAutoCheck$1
            @Override // java.lang.Runnable
            public final void run() {
                UGZlinkLogger.startClipBoardInvoke();
                UGZlinkLogger.onClipBoardStart();
                if (ZlinkSettingsApi.isForbidCheckClipboard(GlobalContext.INSTANCE.getApplication())) {
                    UGZlinkLogger.onForbidCheckClipBoard();
                    Logger.m446d(ZlinkApi.TAG, "DevicePrint is activated when canTryAutoCheck return true and sForbidCheckClipboard is true");
                    FingerPrintUtil.getInstance().checkSchemeWithDevicePrint(GlobalContext.INSTANCE.getApplication(), "");
                    return;
                }
                Logger.m446d(ZlinkApi.TAG, "checkAndDistributeClipboard is activated when canTryAutoCheck return true and sForbidCheckClipboard is false");
                AppFrontBackHelper appFrontBackHelper = AppFrontBackHelper.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(appFrontBackHelper, "AppFrontBackHelper.getInstance()");
                Activity topActivity = appFrontBackHelper.getTopActivity();
                if (topActivity != null && topActivity.hasWindowFocus()) {
                    IClipboardInternalApi iClipboardInternalApi = (IClipboardInternalApi) UgServiceManager.INSTANCE.getInternalApi(IClipboardInternalApi.class);
                    if (iClipboardInternalApi != null) {
                        iClipboardInternalApi.checkAndDistributeClipboard();
                        return;
                    }
                    return;
                }
                ThreadUtils.getHandler().postDelayed(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.GlobalContext$doAutoCheck$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        IClipboardInternalApi iClipboardInternalApi2 = (IClipboardInternalApi) UgServiceManager.INSTANCE.getInternalApi(IClipboardInternalApi.class);
                        if (iClipboardInternalApi2 != null) {
                            iClipboardInternalApi2.checkAndDistributeClipboard();
                        }
                    }
                }, 500L);
            }
        });
    }

    public final void setCallUri(final Uri uri, final boolean autoClearClipboard) {
        if (ZlinkApi.INSTANCE.isInited()) {
            setCallUriForAppLink(uri, autoClearClipboard, null);
        } else {
            CallbackManager.addZlinkInitCallback(new IZlinkInitCallback() { // from class: com.bytedance.ug.sdk.deeplink.GlobalContext$setCallUri$1
                @Override // com.bytedance.ug.sdk.deeplink.IZlinkInitCallback
                public void onInitialized() {
                    CallbackManager.removeZlinkInitCallback(this);
                    GlobalContext.INSTANCE.setCallUriForAppLink(uri, autoClearClipboard, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCallUriForAppLink(Uri uri, boolean autoClearClipboard, JSONObject otherParameters) {
        if (uri != null && uriType == UriType.ILLEGAL) {
            UriType uriType2 = UriType.ILLEGAL;
            if (!TextUtils.isEmpty(uri.getScheme())) {
                IResolver resolver = ResolverManager.instance().getResolver(ResolverType.TYPE_APP_LINK);
                IResolver resolver2 = ResolverManager.instance().getResolver(ResolverType.TYPE_DEEP_LINK);
                if (resolver != null && resolver.isSelf(uri)) {
                    uriType = UriType.APP_LINKS;
                    uriType2 = UriType.APP_LINKS;
                } else {
                    if (resolver2 == null || !resolver2.isSelf(uri)) {
                        return;
                    }
                    uriType = UriType.URI_SCHEME;
                    uriType2 = UriType.URI_SCHEME;
                }
            }
            Logger.m446d(ZlinkApi.TAG, "ZlinkApi setCallUri uri=" + uri);
            EventUtil.sendActivationEvent(uriType2, uri.toString(), otherParameters);
        }
        if (autoClearClipboard && HostCommonServices.isConfirmedPrivacy()) {
            ThreadUtils.getHandler().postDelayed(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.GlobalContext$setCallUriForAppLink$1
                @Override // java.lang.Runnable
                public final void run() {
                    IClipboardInternalApi iClipboardInternalApi = (IClipboardInternalApi) UgServiceManager.INSTANCE.getInternalApi(IClipboardInternalApi.class);
                    if (iClipboardInternalApi != null) {
                        iClipboardInternalApi.clearMatchSchemeClipBoard();
                    }
                }
            }, 1000L);
        }
    }
}
