package com.bytedance.trae.applog.api;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.im.service.ModelSelectionConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IApplog.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 Q2\u00020\u0001:\u0001QJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H&J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000fH&J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H&J@\u0010\u0019\u001a\u00020\f26\u0010\u001a\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\f0\u001bH&J\b\u0010 \u001a\u00020\fH&J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020#H&J\u001c\u0010$\u001a\u00020\f2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&H&J\"\u0010)\u001a\u00020\f2\u0018\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&0+H&J.\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u0003H&J\u001c\u00101\u001a\u00020\f2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000303H&J\u0010\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\u0003H&J\u0010\u00106\u001a\u00020\f2\u0006\u00105\u001a\u00020\u0003H&J\n\u00107\u001a\u0004\u0018\u00010\u0003H&J \u00108\u001a\u00020#2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020#H&J\u0010\u0010=\u001a\u00020#2\u0006\u00109\u001a\u00020:H&J\u0010\u0010>\u001a\u00020#2\u0006\u00109\u001a\u00020:H&J\b\u0010?\u001a\u00020\fH&J\u0018\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u0001H&J\u0010\u0010C\u001a\u00020\f2\u0006\u0010A\u001a\u00020\u0003H&J \u0010D\u001a\u00020\f2\u0006\u0010A\u001a\u00020\u00032\u000e\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010+H&J\u0018\u0010F\u001a\u00020\f2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u0001H&J\b\u0010G\u001a\u00020\fH&J\b\u0010H\u001a\u00020\fH&J\u0010\u0010I\u001a\u00020\f2\u0006\u0010J\u001a\u00020KH&J\u0010\u0010L\u001a\u00020\f2\u0006\u0010J\u001a\u00020MH&J\u0012\u0010N\u001a\u0004\u0018\u00010\u00012\u0006\u0010O\u001a\u00020#H&J\n\u0010P\u001a\u0004\u0018\u00010\u0001H&¨\u0006R"}, d2 = {"Lcom/bytedance/trae/applog/api/IApplog;", "", "getInstallId", "", "getClientDid", "getSsid", "getSessionId", "getDeviceId", "getUserUniqueID", "getUserID", "getOpenUDid", "reportEvent", "", Fields.EVENT, "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "onMiscEvent", "logType", "obj", "addGetAppLogIdListener", "listener", "Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;", "removeDidListener", "doWhenIdsReady", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "did", "iid", "openETVerify", "setSwitchToBdtracker", "switchToBdtracker", "", "setBDAccountCallback", "pair", "Landroid/util/Pair;", "", "", "setBDAccountCallbackProvider", "provider", "Lkotlin/Function0;", "onAccountTypeChanged", "accountType", "userId", "tenantId", "tenantName", "putCommonParams", "params", "", "setExternalAbVersionFromSettings", "vid", "setExternalAbVersionFromAbTest", "getAbSdkVersion", "setNewUserMode", "context", "Landroid/content/Context;", "open", ModelSelectionConstants.AUTO, "isNormalNewUserMode", "isAutoNewUserMode", "flush", "setHeaderInfo", "key", "value", "removeHeaderInfo", "addEventCommonParams", "valueGenerator", "putEventCommonParams", "onBgSessionTaskResume", "onBgSessionTaskPause", "addLaunchObserver", "callback", "Lcom/bytedance/trae/applog/api/OnLaunchCallback;", "addNavigatorCallback", "Lcom/bytedance/trae/applog/api/OnNavigateCallback;", "getUriConfig", "boe", "getNetworkClient", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IApplog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void addEventCommonParams(String key, Function0<? extends Object> valueGenerator);

    void addGetAppLogIdListener(OnGetAppLogIdListener listener);

    void addLaunchObserver(OnLaunchCallback callback);

    void addNavigatorCallback(OnNavigateCallback callback);

    void doWhenIdsReady(Function2<? super String, ? super String, Unit> action);

    void flush();

    String getAbSdkVersion();

    String getClientDid();

    String getDeviceId();

    String getInstallId();

    Object getNetworkClient();

    String getOpenUDid();

    String getSessionId();

    String getSsid();

    Object getUriConfig(boolean boe);

    String getUserID();

    String getUserUniqueID();

    boolean isAutoNewUserMode(Context context);

    boolean isNormalNewUserMode(Context context);

    void onAccountTypeChanged(String accountType, String userId, String tenantId, String tenantName);

    void onBgSessionTaskPause();

    void onBgSessionTaskResume();

    void onMiscEvent(String logType, JSONObject obj);

    void openETVerify();

    void putCommonParams(Map<String, String> params);

    void putEventCommonParams(String key, Object value);

    void removeDidListener(OnGetAppLogIdListener listener);

    void removeHeaderInfo(String key);

    void reportEvent(String event);

    void reportEvent(String event, Bundle bundleParams);

    void reportEvent(String event, JSONObject jsonParams);

    void setBDAccountCallback(Pair<Integer, Long> pair);

    void setBDAccountCallbackProvider(Function0<? extends Pair<Integer, Long>> provider);

    void setExternalAbVersionFromAbTest(String vid);

    void setExternalAbVersionFromSettings(String vid);

    void setHeaderInfo(String key, Object value);

    boolean setNewUserMode(Context context, boolean open, boolean auto);

    void setSwitchToBdtracker(boolean switchToBdtracker);

    /* compiled from: IApplog.kt */
    @Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J@\u0010 \u001a\u00020\u001326\u0010!\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\n¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00130\"H\u0016J\b\u0010'\u001a\u00020\u0013H\u0016J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0016J\u001c\u0010+\u001a\u00020\u00132\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-H\u0016J(\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\nH\u0016J\"\u00105\u001a\u00020\u00132\u0018\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-07H\u0016J\u001c\u00108\u001a\u00020\u00132\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0:H\u0016J\b\u0010;\u001a\u00020\u0013H\u0016J\u0010\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020\u00132\u0006\u0010=\u001a\u00020@H\u0016J\u0012\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020*H\u0016J\n\u0010D\u001a\u0004\u0018\u00010BH\u0016J\b\u0010E\u001a\u00020\u0013H\u0016J\u0010\u0010F\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\nH\u0016J\u0010\u0010H\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\nH\u0016J\n\u0010I\u001a\u0004\u0018\u00010\nH\u0016J \u0010J\u001a\u00020*2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020*2\u0006\u0010N\u001a\u00020*H\u0016J\u0010\u0010O\u001a\u00020*2\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010P\u001a\u00020*2\u0006\u0010K\u001a\u00020LH\u0016J\b\u0010Q\u001a\u00020\u0013H\u0016J\u0018\u0010R\u001a\u00020\u00132\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020BH\u0016J\u0010\u0010U\u001a\u00020\u00132\u0006\u0010S\u001a\u00020\nH\u0016J \u0010V\u001a\u00020\u00132\u0006\u0010S\u001a\u00020\n2\u000e\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B07H\u0016J\u0018\u0010X\u001a\u00020\u00132\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020BH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006Y"}, d2 = {"Lcom/bytedance/trae/applog/api/IApplog$Companion;", "Lcom/bytedance/trae/applog/api/IApplog;", "<init>", "()V", "impl", "getImpl", "()Lcom/bytedance/trae/applog/api/IApplog;", "impl$delegate", "Lkotlin/Lazy;", "getInstallId", "", "getClientDid", "getSsid", "getSessionId", "getDeviceId", "getUserUniqueID", "getUserID", "getOpenUDid", "reportEvent", "", Fields.EVENT, "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "onMiscEvent", "logType", "obj", "addGetAppLogIdListener", "listener", "Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;", "removeDidListener", "doWhenIdsReady", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "did", "iid", "openETVerify", "setSwitchToBdtracker", "switchToBdtracker", "", "setBDAccountCallback", "pair", "Landroid/util/Pair;", "", "", "onAccountTypeChanged", "accountType", "userId", "tenantId", "tenantName", "setBDAccountCallbackProvider", "provider", "Lkotlin/Function0;", "putCommonParams", "params", "", "onBgSessionTaskPause", "addLaunchObserver", "callback", "Lcom/bytedance/trae/applog/api/OnLaunchCallback;", "addNavigatorCallback", "Lcom/bytedance/trae/applog/api/OnNavigateCallback;", "getUriConfig", "", "boe", "getNetworkClient", "onBgSessionTaskResume", "setExternalAbVersionFromSettings", "vid", "setExternalAbVersionFromAbTest", "getAbSdkVersion", "setNewUserMode", "context", "Landroid/content/Context;", "open", ModelSelectionConstants.AUTO, "isNormalNewUserMode", "isAutoNewUserMode", "flush", "setHeaderInfo", "key", "value", "removeHeaderInfo", "addEventCommonParams", "valueGenerator", "putEventCommonParams", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion implements IApplog {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* renamed from: impl$delegate, reason: from kotlin metadata */
        private static final Lazy<IApplog> impl = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.applog.api.IApplog$Companion$$ExternalSyntheticLambda0
            public final Object invoke() {
                IApplog impl_delegate$lambda$0;
                impl_delegate$lambda$0 = IApplog.Companion.impl_delegate$lambda$0();
                return impl_delegate$lambda$0;
            }
        });

        private Companion() {
        }

        private final IApplog getImpl() {
            return (IApplog) impl.getValue();
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public String getInstallId() {
            String installId;
            IApplog impl2 = getImpl();
            return (impl2 == null || (installId = impl2.getInstallId()) == null) ? "" : installId;
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public String getClientDid() {
            String clientDid;
            IApplog impl2 = getImpl();
            return (impl2 == null || (clientDid = impl2.getClientDid()) == null) ? "" : clientDid;
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public String getSsid() {
            String ssid;
            IApplog impl2 = getImpl();
            return (impl2 == null || (ssid = impl2.getSsid()) == null) ? "" : ssid;
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public String getSessionId() {
            String sessionId;
            IApplog impl2 = getImpl();
            return (impl2 == null || (sessionId = impl2.getSessionId()) == null) ? "" : sessionId;
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public String getDeviceId() {
            String deviceId;
            IApplog impl2 = getImpl();
            return (impl2 == null || (deviceId = impl2.getDeviceId()) == null) ? "" : deviceId;
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public String getUserUniqueID() {
            String userUniqueID;
            IApplog impl2 = getImpl();
            return (impl2 == null || (userUniqueID = impl2.getUserUniqueID()) == null) ? "" : userUniqueID;
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public String getUserID() {
            String userID;
            IApplog impl2 = getImpl();
            return (impl2 == null || (userID = impl2.getUserID()) == null) ? "" : userID;
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public String getOpenUDid() {
            String openUDid;
            IApplog impl2 = getImpl();
            return (impl2 == null || (openUDid = impl2.getOpenUDid()) == null) ? "" : openUDid;
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void reportEvent(String event) {
            Intrinsics.checkNotNullParameter(event, Fields.EVENT);
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.reportEvent(event);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void reportEvent(String event, JSONObject jsonParams) {
            Intrinsics.checkNotNullParameter(event, Fields.EVENT);
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.reportEvent(event, jsonParams);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void reportEvent(String event, Bundle bundleParams) {
            Intrinsics.checkNotNullParameter(event, Fields.EVENT);
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.reportEvent(event, bundleParams);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void onMiscEvent(String logType, JSONObject obj) {
            Intrinsics.checkNotNullParameter(logType, "logType");
            Intrinsics.checkNotNullParameter(obj, "obj");
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.onMiscEvent(logType, obj);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void addGetAppLogIdListener(OnGetAppLogIdListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.addGetAppLogIdListener(listener);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void removeDidListener(OnGetAppLogIdListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.removeDidListener(listener);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void doWhenIdsReady(Function2<? super String, ? super String, Unit> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.doWhenIdsReady(action);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void openETVerify() {
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.openETVerify();
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void setSwitchToBdtracker(boolean switchToBdtracker) {
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.setSwitchToBdtracker(switchToBdtracker);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void setBDAccountCallback(Pair<Integer, Long> pair) {
            Intrinsics.checkNotNullParameter(pair, "pair");
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.setBDAccountCallback(pair);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void onAccountTypeChanged(String accountType, String userId, String tenantId, String tenantName) {
            Intrinsics.checkNotNullParameter(accountType, "accountType");
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(tenantId, "tenantId");
            Intrinsics.checkNotNullParameter(tenantName, "tenantName");
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.onAccountTypeChanged(accountType, userId, tenantId, tenantName);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void setBDAccountCallbackProvider(Function0<? extends Pair<Integer, Long>> provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.setBDAccountCallbackProvider(provider);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void putCommonParams(Map<String, String> params) {
            Intrinsics.checkNotNullParameter(params, "params");
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.putCommonParams(params);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void onBgSessionTaskPause() {
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.onBgSessionTaskPause();
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void addLaunchObserver(OnLaunchCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.addLaunchObserver(callback);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void addNavigatorCallback(OnNavigateCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.addNavigatorCallback(callback);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public Object getUriConfig(boolean boe) {
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                return impl2.getUriConfig(boe);
            }
            return null;
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public Object getNetworkClient() {
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                return impl2.getNetworkClient();
            }
            return null;
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void onBgSessionTaskResume() {
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.onBgSessionTaskResume();
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void setExternalAbVersionFromSettings(String vid) {
            Intrinsics.checkNotNullParameter(vid, "vid");
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.setExternalAbVersionFromSettings(vid);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void setExternalAbVersionFromAbTest(String vid) {
            Intrinsics.checkNotNullParameter(vid, "vid");
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.setExternalAbVersionFromAbTest(vid);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public String getAbSdkVersion() {
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                return impl2.getAbSdkVersion();
            }
            return null;
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public boolean setNewUserMode(Context context, boolean open, boolean auto) {
            Intrinsics.checkNotNullParameter(context, "context");
            IApplog impl2 = getImpl();
            return impl2 != null && impl2.setNewUserMode(context, open, auto);
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public boolean isNormalNewUserMode(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            IApplog impl2 = getImpl();
            return impl2 != null && impl2.isNormalNewUserMode(context);
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public boolean isAutoNewUserMode(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            IApplog impl2 = getImpl();
            return impl2 != null && impl2.isAutoNewUserMode(context);
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void flush() {
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.flush();
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void setHeaderInfo(String key, Object value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.setHeaderInfo(key, value);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void removeHeaderInfo(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.removeHeaderInfo(key);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void addEventCommonParams(String key, Function0<? extends Object> valueGenerator) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(valueGenerator, "valueGenerator");
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.addEventCommonParams(key, valueGenerator);
            }
        }

        @Override // com.bytedance.trae.applog.api.IApplog
        public void putEventCommonParams(String key, Object value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            IApplog impl2 = getImpl();
            if (impl2 != null) {
                impl2.putEventCommonParams(key, value);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final IApplog impl_delegate$lambda$0() {
            return (IApplog) ServiceManager.get().getService(IApplog.class);
        }
    }

    /* compiled from: IApplog.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onAccountTypeChanged$default(IApplog iApplog, String str, String str2, String str3, String str4, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAccountTypeChanged");
            }
            if ((i & 2) != 0) {
                str2 = "";
            }
            if ((i & 4) != 0) {
                str3 = "";
            }
            if ((i & 8) != 0) {
                str4 = "";
            }
            iApplog.onAccountTypeChanged(str, str2, str3, str4);
        }
    }
}
