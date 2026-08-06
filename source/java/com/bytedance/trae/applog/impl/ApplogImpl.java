package com.bytedance.trae.applog.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Pair;
import androidx.core.os.BundleKt;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.service.NUApi;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.applog.api.OnGetAppLogIdListener;
import com.bytedance.trae.applog.api.OnLaunchCallback;
import com.bytedance.trae.applog.api.OnNavigateCallback;
import com.bytedance.trae.applog.impl.AppLogHelper;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.im.service.ModelSelectionConstants;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.common.applog.AppLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: ApplogImpl.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J@\u0010\u0012\u001a\u00020\u000e26\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000e0\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001c\u0010\u001d\u001a\u00020\u000e2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fH\u0016J(\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0016J\"\u0010'\u001a\u00020\u000e2\u0018\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f0)H\u0016J\u001c\u0010*\u001a\u00020\u000e2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050,H\u0016J\b\u0010-\u001a\u00020\u000eH\u0016J\b\u0010.\u001a\u00020\u000eH\u0016J\u0010\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u000e2\u0006\u00100\u001a\u000203H\u0016J\u0012\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\u001cH\u0016J\n\u00107\u001a\u0004\u0018\u000105H\u0016J\b\u00108\u001a\u00020\u0005H\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020\u0005H\u0016J\b\u0010<\u001a\u00020\u0005H\u0016J\b\u0010=\u001a\u00020\u0005H\u0016J\b\u0010>\u001a\u00020\u0005H\u0016J\b\u0010?\u001a\u00020\u0005H\u0016J\u0010\u0010@\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u0005H\u0016J\u001a\u0010@\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u00052\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u001a\u0010@\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u00052\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0018\u0010F\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020CH\u0016J\u0010\u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\u0005H\u0016J\u0010\u0010K\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\u0005H\u0016J\b\u0010L\u001a\u00020\u000eH\u0002J\n\u0010M\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010N\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u001c2\u0006\u0010R\u001a\u00020\u001cH\u0016J\u0010\u0010S\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010T\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020PH\u0016J\b\u0010U\u001a\u00020\u000eH\u0016J\u0018\u0010V\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u000205H\u0016J\b\u0010Y\u001a\u00020\u001cH\u0002J\u0010\u0010Z\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020\u0005H\u0016J \u0010[\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020\u00052\u000e\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050)H\u0016J\u0018\u0010]\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u000205H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006^"}, d2 = {"Lcom/bytedance/trae/applog/impl/ApplogImpl;", "Lcom/bytedance/trae/applog/api/IApplog;", "<init>", "()V", "vidsFromAbTest", "", "getVidsFromAbTest", "()Ljava/lang/String;", "setVidsFromAbTest", "(Ljava/lang/String;)V", "vidsFromSettings", "getVidsFromSettings", "setVidsFromSettings", "addGetAppLogIdListener", "", "listener", "Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;", "removeDidListener", "doWhenIdsReady", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "did", "iid", "openETVerify", "setSwitchToBdtracker", "switchToBdtracker", "", "setBDAccountCallback", "pair", "Landroid/util/Pair;", "", "", "onAccountTypeChanged", "accountType", "userId", "tenantId", "tenantName", "setBDAccountCallbackProvider", "provider", "Lkotlin/Function0;", "putCommonParams", "params", "", "onBgSessionTaskResume", "onBgSessionTaskPause", "addLaunchObserver", "callback", "Lcom/bytedance/trae/applog/api/OnLaunchCallback;", "addNavigatorCallback", "Lcom/bytedance/trae/applog/api/OnNavigateCallback;", "getUriConfig", "", "boe", "getNetworkClient", "getDeviceId", "getInstallId", "getClientDid", "getSsid", "getSessionId", "getUserUniqueID", "getUserID", "getOpenUDid", "reportEvent", Fields.EVENT, "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "onMiscEvent", "logType", "obj", "setExternalAbVersionFromSettings", "vid", "setExternalAbVersionFromAbTest", "updateExternalAbVersion", "getAbSdkVersion", "setNewUserMode", "context", "Landroid/content/Context;", "open", ModelSelectionConstants.AUTO, "isNormalNewUserMode", "isAutoNewUserMode", "flush", "setHeaderInfo", "key", "value", "isTestChannel", "removeHeaderInfo", "addEventCommonParams", "valueGenerator", "putEventCommonParams", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ApplogImpl implements IApplog {
    private String vidsFromAbTest;
    private String vidsFromSettings;

    public final String getVidsFromAbTest() {
        return this.vidsFromAbTest;
    }

    public final void setVidsFromAbTest(String str) {
        this.vidsFromAbTest = str;
    }

    public final String getVidsFromSettings() {
        return this.vidsFromSettings;
    }

    public final void setVidsFromSettings(String str) {
        this.vidsFromSettings = str;
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void addGetAppLogIdListener(OnGetAppLogIdListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        AppLogHelper.INSTANCE.addGetAppLogIdListener(listener);
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void removeDidListener(OnGetAppLogIdListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        AppLogHelper.INSTANCE.removeDidListener(listener);
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void doWhenIdsReady(Function2<? super String, ? super String, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        AppLogHelper.INSTANCE.doWhenIdsReady(action);
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void openETVerify() {
        AppLogHelper.INSTANCE.openETVerify();
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void setSwitchToBdtracker(boolean switchToBdtracker) {
        AppLog.setSwitchToBdtracker(switchToBdtracker);
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void setBDAccountCallback(Pair<Integer, Long> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        AppLogHelper.INSTANCE.setBDAccountCallback(pair);
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void onAccountTypeChanged(String accountType, String userId, String tenantId, String tenantName) {
        Intrinsics.checkNotNullParameter(accountType, "accountType");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(tenantId, "tenantId");
        Intrinsics.checkNotNullParameter(tenantName, "tenantName");
        AppLogHelper.INSTANCE.onAccountTypeChanged(accountType, userId, tenantId, tenantName);
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void setBDAccountCallbackProvider(Function0<? extends Pair<Integer, Long>> provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        AppLogHelper.INSTANCE.setBDAccountCallbackProvider(provider);
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void putCommonParams(Map<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.bytedance.applog.AppLog.putCommonParams(AppHost.INSTANCE.getApplication(), params, true, Level.L1);
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void onBgSessionTaskResume() {
        com.bytedance.applog.AppLog.onBgSessionTaskResume();
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void onBgSessionTaskPause() {
        com.bytedance.applog.AppLog.onBgSessionTaskPause();
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void addLaunchObserver(OnLaunchCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppLogHelper.INSTANCE.addLaunchObserver(callback);
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void addNavigatorCallback(OnNavigateCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppLogHelper.INSTANCE.addNavigationCallback(callback);
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public Object getUriConfig(boolean boe) {
        return BDTrackerConfigs.INSTANCE.uriConfig(boe);
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public Object getNetworkClient() {
        return new AppLogHelper.CommonNetworkClient();
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public String getDeviceId() {
        String did = com.bytedance.applog.AppLog.getDid();
        return did == null ? "" : did;
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public String getInstallId() {
        String iid = com.bytedance.applog.AppLog.getIid();
        return iid == null ? "" : iid;
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public String getClientDid() {
        String clientUdid = com.bytedance.applog.AppLog.getClientUdid();
        return clientUdid == null ? "" : clientUdid;
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public String getSsid() {
        String ssid = com.bytedance.applog.AppLog.getSsid();
        return ssid == null ? "" : ssid;
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public String getSessionId() {
        String sessionId = com.bytedance.applog.AppLog.getSessionId();
        return sessionId == null ? "" : sessionId;
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public String getUserUniqueID() {
        String userUniqueID = com.bytedance.applog.AppLog.getUserUniqueID();
        return userUniqueID == null ? "" : userUniqueID;
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public String getUserID() {
        String userID = com.bytedance.applog.AppLog.getUserID();
        return userID == null ? "" : userID;
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public String getOpenUDid() {
        String openUdid = com.bytedance.applog.AppLog.getOpenUdid();
        return openUdid == null ? "" : openUdid;
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void reportEvent(String event) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        AppLogHelper.INSTANCE.reportEvent(event, BundleKt.bundleOf());
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void reportEvent(String event, JSONObject jsonParams) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        AppLogHelper.INSTANCE.reportEvent(event, jsonParams);
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void reportEvent(String event, Bundle bundleParams) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        AppLogHelper.INSTANCE.reportEvent(event, bundleParams);
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void onMiscEvent(String logType, JSONObject obj) {
        Intrinsics.checkNotNullParameter(logType, "logType");
        Intrinsics.checkNotNullParameter(obj, "obj");
        AppLogHelper.INSTANCE.onMiscEvent(logType, obj);
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void setExternalAbVersionFromSettings(String vid) {
        Intrinsics.checkNotNullParameter(vid, "vid");
        if (Intrinsics.areEqual(vid, this.vidsFromSettings)) {
            return;
        }
        this.vidsFromSettings = vid;
        updateExternalAbVersion();
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void setExternalAbVersionFromAbTest(String vid) {
        Intrinsics.checkNotNullParameter(vid, "vid");
        if (Intrinsics.areEqual(vid, this.vidsFromAbTest)) {
            return;
        }
        this.vidsFromAbTest = vid;
        updateExternalAbVersion();
    }

    private final void updateExternalAbVersion() {
        try {
            FLogger.INSTANCE.i("ApplogImpl", "updateExternalAbVersion: vidsFromSettings=" + this.vidsFromSettings + ", vidsFromAbTest=" + this.vidsFromAbTest);
            List listOfNotNull = CollectionsKt.listOfNotNull(new String[]{this.vidsFromSettings, this.vidsFromAbTest});
            ArrayList arrayList = new ArrayList();
            for (Object obj : listOfNotNull) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            String joinToString$default = CollectionsKt.joinToString$default(arrayList, IWeiboService.Scope.EMPTY_SCOPE, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            com.bytedance.applog.AppLog.setExternalAbVersion(joinToString$default);
            FLogger.INSTANCE.i("ApplogImpl", "updateExternalAbVersion: setExternalAbVersion=" + joinToString$default);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public String getAbSdkVersion() {
        return com.bytedance.applog.AppLog.getAbSdkVersion();
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public boolean setNewUserMode(Context context, boolean open, boolean auto) {
        NUApi newUserMode;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!com.bytedance.applog.AppLog.isNewUserModeAvailable() || (newUserMode = com.bytedance.applog.AppLog.newUserMode(context)) == null) {
            return false;
        }
        newUserMode.setNUMode(open).setAutoMode(auto).done();
        return true;
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public boolean isNormalNewUserMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!com.bytedance.applog.AppLog.isNewUserMode(context)) {
            return false;
        }
        NUApi newUserMode = com.bytedance.applog.AppLog.newUserMode(context);
        return !(newUserMode != null && newUserMode.isAutoMode());
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public boolean isAutoNewUserMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!com.bytedance.applog.AppLog.isNewUserMode(context)) {
            return false;
        }
        NUApi newUserMode = com.bytedance.applog.AppLog.newUserMode(context);
        return newUserMode != null && newUserMode.isAutoMode();
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void flush() {
        com.bytedance.applog.AppLog.flush();
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void setHeaderInfo(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread()) && isTestChannel() && AppHost.INSTANCE.isOversea()) {
            throw new IllegalStateException("AppLog.setHeaderInfo MUST NOT be called in main thread (For Cici App)");
        }
        com.bytedance.applog.AppLog.setHeaderInfo(key, value);
    }

    private final boolean isTestChannel() {
        return AppHost.INSTANCE.isDebug() || AppHost.INSTANCE.isTestChannel();
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void removeHeaderInfo(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        com.bytedance.applog.AppLog.removeHeaderInfo(key);
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void addEventCommonParams(String key, Function0<? extends Object> valueGenerator) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(valueGenerator, "valueGenerator");
        AppLogHelper.INSTANCE.addEventCommonParams(key, valueGenerator);
    }

    @Override // com.bytedance.trae.applog.api.IApplog
    public void putEventCommonParams(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        AppLogHelper.INSTANCE.putEventCommonParams(key, value);
    }
}
