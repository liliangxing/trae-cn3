package com.bytedance.trae.applog.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.IDataObserver;
import com.bytedance.applog.ILaunchObserver;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.batch.PackOptConfig;
import com.bytedance.applog.collector.NavigatorCallback;
import com.bytedance.applog.monitor.v3.MonitorConfigManager;
import com.bytedance.applog.util.EventsSenderUtils;
import com.bytedance.bdinstall.IExtraParams;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.news.common.settings.api.exposed.ExposedManager;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.AppLogConfigInfo;
import com.bytedance.trae.applog.api.BDTrackerConsts;
import com.bytedance.trae.applog.api.OnGetAppLogIdListener;
import com.bytedance.trae.applog.api.OnLaunchCallback;
import com.bytedance.trae.applog.api.OnNavigateCallback;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.security.api.SecurityService;
import com.bytedance.trae.network.TraeTTNet;
import com.bytedance.trae.utils.AppLocaleUtils;
import com.bytedance.trae.utils.LanguageUtil;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AppLogHelper.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c*\u0002;>\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001uB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0015J\u001a\u0010,\u001a\u00020*2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.J&\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0005J \u00106\u001a\u00020*2\u0018\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.0\"J\b\u0010A\u001a\u00020*H\u0002J\b\u0010B\u001a\u00020*H\u0002J\u000e\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020\u001fJ\u000e\u0010E\u001a\u00020*2\u0006\u0010D\u001a\u00020\u001fJ\u000e\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020HJ\u000e\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020KJ>\u0010L\u001a\u00020*26\u0010M\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(Q\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(R\u0012\u0004\u0012\u00020*0NJ$\u0010S\u001a\u00020*2\b\u0010Q\u001a\u0004\u0018\u00010\u00052\b\u0010R\u001a\u0004\u0018\u00010\u00052\u0006\u0010T\u001a\u00020\u0005H\u0002J\u0018\u0010U\u001a\u00020*2\u0006\u0010V\u001a\u00020\u00052\b\u0010W\u001a\u0004\u0018\u00010XJ\u0018\u0010U\u001a\u00020*2\u0006\u0010V\u001a\u00020\u00052\b\u0010Y\u001a\u0004\u0018\u00010ZJ\u0016\u0010[\u001a\u00020*2\u0006\u0010\\\u001a\u00020\u00052\u0006\u0010]\u001a\u00020XJ\u0006\u0010^\u001a\u00020*J\u001e\u0010_\u001a\u00020*2\u0006\u0010`\u001a\u00020\u00052\u000e\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"J\u0016\u0010b\u001a\u00020*2\u0006\u0010`\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\u0001J\u0010\u0010d\u001a\u00020*2\u0006\u0010e\u001a\u00020XH\u0002J\u0010\u0010f\u001a\u00020*2\u0006\u0010e\u001a\u00020ZH\u0002J\u0010\u0010g\u001a\u00020*2\u0006\u0010e\u001a\u00020XH\u0002J\u0010\u0010g\u001a\u00020*2\u0006\u0010e\u001a\u00020ZH\u0002J\u0018\u0010h\u001a\u00020*2\u0006\u0010V\u001a\u00020\u00052\u0006\u0010i\u001a\u00020XH\u0002J\u0018\u0010h\u001a\u00020*2\u0006\u0010V\u001a\u00020\u00052\u0006\u0010i\u001a\u00020ZH\u0002J\u0018\u0010j\u001a\u00020*2\u0006\u0010\\\u001a\u00020\u00052\u0006\u0010i\u001a\u00020XH\u0002J\u0010\u0010k\u001a\u00020X2\u0006\u0010l\u001a\u00020XH\u0002J\u0010\u0010k\u001a\u00020X2\u0006\u0010l\u001a\u00020ZH\u0002J\"\u0010m\u001a\u00020*2\u0006\u0010e\u001a\u00020X2\u0006\u0010`\u001a\u00020\u00052\b\u0010c\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010n\u001a\u00020X2\u0006\u0010l\u001a\u00020XH\u0002J\u0010\u0010o\u001a\u00020*2\u0006\u0010e\u001a\u00020XH\u0002J\b\u0010p\u001a\u00020\u001bH\u0002J \u0010q\u001a\u00020*2\u0006\u0010e\u001a\u00020X2\u0006\u0010`\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\u0001H\u0002J \u0010r\u001a\u00020*2\u0006\u0010e\u001a\u00020Z2\u0006\u0010`\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\u0005H\u0002J \u0010s\u001a\u00020*2\u0006\u0010e\u001a\u00020X2\u0006\u0010`\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\u0001H\u0002J \u0010t\u001a\u00020*2\u0006\u0010e\u001a\u00020Z2\u0006\u0010`\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\u0001H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0004\n\u0002\u0010<R\u0010\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?R\u000e\u0010@\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006v"}, d2 = {"Lcom/bytedance/trae/applog/impl/AppLogHelper;", "", "<init>", "()V", "TAG", "", "KEY_MINOR_MODE", "KEY_ACCOUNT_TYPE", "KEY_BIZ_USER_ID", "KEY_TOC_DID", "KEY_TOB_DID", "KEY_TENANT", "KEY_TENANT_ID", "KEY_TENANT_NAME", "KEY_SCOPE", "ACCOUNT_TYPE_UNKNOWN", "ACCOUNT_TYPE_TOC", "ACCOUNT_TYPE_TOB", "ACCOUNT_TYPE_BYTEDANCE", "SCOPE_SAAS", "mConfigInfo", "Lcom/bytedance/trae/applog/api/AppLogConfigInfo;", "currentAccountType", "currentAccountUserId", "currentTenantId", "currentTenantName", "tobInitialized", "", "tobInitializing", "mDidListenerCallbackList", "", "Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;", "eventCommonParamsGenerators", "", "Lkotlin/Function0;", "eventCommonParamsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "navigatorCallbackList", "Lcom/bytedance/applog/collector/NavigatorCallback;", "launchObserverList", "Lcom/bytedance/applog/ILaunchObserver;", "init", "", "configInfo", "setBDAccountCallback", "pair", "Landroid/util/Pair;", "", "", "onAccountTypeChanged", "accountType", "userId", "tenantId", "tenantName", "setBDAccountCallbackProvider", "provider", "networkClient", "Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient;", "dataObserver", "com/bytedance/trae/applog/impl/AppLogHelper$dataObserver$1", "Lcom/bytedance/trae/applog/impl/AppLogHelper$dataObserver$1;", "navigatorCallback", "com/bytedance/trae/applog/impl/AppLogHelper$navigatorCallback$1", "Lcom/bytedance/trae/applog/impl/AppLogHelper$navigatorCallback$1;", "launchObserver", "initTobAppLogIfNeeded", "updateTobAccountInfo", "addGetAppLogIdListener", "listener", "removeDidListener", "addNavigationCallback", "callback", "Lcom/bytedance/trae/applog/api/OnNavigateCallback;", "addLaunchObserver", "observer", "Lcom/bytedance/trae/applog/api/OnLaunchCallback;", "doWhenIdsReady", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "did", "iid", "updateBdTuringId", "from", "reportEvent", Fields.EVENT, "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "onMiscEvent", "logType", "obj", "openETVerify", "addEventCommonParams", "key", "valueGenerator", "putEventCommonParams", "value", "addCommonParamsToJSONObject", "params", "addCommonParamsToBundle", "addTocMappingParams", "reportTobEventIfNeeded", "tocParams", "reportTobMiscEventIfNeeded", "buildTobJSONObject", TimonPipeline.KEY_SOURCE, "putTobValue", "copyJSONObject", "addTobMappingParams", "shouldUseTobAppLog", "putJsonIfAbsent", "putBundleIfAbsent", "addToJSONObject", "addToBundle", "CommonNetworkClient", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AppLogHelper {
    private static final String ACCOUNT_TYPE_BYTEDANCE = "bytedance";
    private static final String ACCOUNT_TYPE_TOB = "tob";
    private static final String ACCOUNT_TYPE_TOC = "toc";
    private static final String ACCOUNT_TYPE_UNKNOWN = "unknown";
    private static final String KEY_ACCOUNT_TYPE = "account_type";
    private static final String KEY_BIZ_USER_ID = "biz_user_id";
    private static final String KEY_MINOR_MODE = "is_minor_mode";
    private static final String KEY_SCOPE = "scope";
    private static final String KEY_TENANT = "tenant";
    private static final String KEY_TENANT_ID = "tenant_id";
    private static final String KEY_TENANT_NAME = "tenant_name";
    private static final String KEY_TOB_DID = "tob_did";
    private static final String KEY_TOC_DID = "toc_did";
    private static final String SCOPE_SAAS = "saas";
    private static final String TAG = "AppLogHelper";
    private static AppLogConfigInfo mConfigInfo;
    private static volatile boolean tobInitialized;
    private static volatile boolean tobInitializing;
    public static final AppLogHelper INSTANCE = new AppLogHelper();
    private static volatile String currentAccountType = "unknown";
    private static volatile String currentAccountUserId = "";
    private static volatile String currentTenantId = "";
    private static volatile String currentTenantName = "";
    private static final List<OnGetAppLogIdListener> mDidListenerCallbackList = new CopyOnWriteArrayList();
    private static final Map<String, Function0<Object>> eventCommonParamsGenerators = new ConcurrentHashMap();
    private static final ConcurrentHashMap<String, Object> eventCommonParamsMap = new ConcurrentHashMap<>();
    private static final List<NavigatorCallback> navigatorCallbackList = new CopyOnWriteArrayList();
    private static final List<ILaunchObserver> launchObserverList = new CopyOnWriteArrayList();
    private static final CommonNetworkClient networkClient = new CommonNetworkClient();
    private static final AppLogHelper$dataObserver$1 dataObserver = new IDataObserver() { // from class: com.bytedance.trae.applog.impl.AppLogHelper$dataObserver$1
        public void onAbVidsChange(String vids, String extVids) {
        }

        public void onRemoteAbConfigGet(boolean changed, JSONObject abConfig) {
        }

        public void onRemoteConfigGet(boolean changed, JSONObject config) {
        }

        public void onIdLoaded(String did, String iid, String ssid) {
            List<OnGetAppLogIdListener> list;
            String str = did;
            if (!(str == null || str.length() == 0)) {
                list = AppLogHelper.mDidListenerCallbackList;
                for (OnGetAppLogIdListener onGetAppLogIdListener : list) {
                    String str2 = "";
                    String str3 = iid == null ? "" : iid;
                    if (ssid != null) {
                        str2 = ssid;
                    }
                    onGetAppLogIdListener.onGetId(did, str3, str2);
                }
            }
            AppLogHelper.INSTANCE.updateBdTuringId(did, iid, "onIdLoaded");
        }

        public void onRemoteIdGet(boolean changed, String oldDid, String newDid, String oldIid, String newIid, String oldSsid, String newSsid) {
            List<OnGetAppLogIdListener> list;
            if (changed) {
                String str = newDid;
                if (str == null || str.length() == 0) {
                    return;
                }
                list = AppLogHelper.mDidListenerCallbackList;
                for (OnGetAppLogIdListener onGetAppLogIdListener : list) {
                    String str2 = "";
                    String str3 = newIid == null ? "" : newIid;
                    if (newSsid != null) {
                        str2 = newSsid;
                    }
                    onGetAppLogIdListener.onGetId(newDid, str3, str2);
                }
                AppLogHelper.INSTANCE.updateBdTuringId(newDid, newIid, "onRemoteIdGet");
            }
        }
    };
    private static final AppLogHelper$navigatorCallback$1 navigatorCallback = new NavigatorCallback() { // from class: com.bytedance.trae.applog.impl.AppLogHelper$navigatorCallback$1
        public void onResume(String activityName, JSONObject flatParams) {
            List list;
            Intrinsics.checkNotNullParameter(flatParams, "flatParams");
            list = AppLogHelper.navigatorCallbackList;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((NavigatorCallback) it.next()).onResume(activityName, flatParams);
            }
        }

        public void onPause(String activityName, JSONObject flatParams) {
            List list;
            Intrinsics.checkNotNullParameter(flatParams, "flatParams");
            list = AppLogHelper.navigatorCallbackList;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((NavigatorCallback) it.next()).onPause(activityName, flatParams);
            }
        }
    };
    private static final ILaunchObserver launchObserver = new ILaunchObserver() { // from class: com.bytedance.trae.applog.impl.AppLogHelper$$ExternalSyntheticLambda3
        public final void onLaunch(String str, long j, boolean z) {
            AppLogHelper.launchObserver$lambda$5(str, j, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair setBDAccountCallback$lambda$2(Pair pair) {
        return pair;
    }

    private AppLogHelper() {
    }

    public final void init(AppLogConfigInfo configInfo) {
        Intrinsics.checkNotNullParameter(configInfo, "configInfo");
        AppLogInitHookHelper.INSTANCE.preInit();
        mConfigInfo = configInfo;
        InitConfig initConfig = new InitConfig(String.valueOf(configInfo.getAppId()), configInfo.getChannel());
        AppLogInitHookHelper.INSTANCE.setupInitHook(initConfig);
        initConfig.setAppName(configInfo.getAppName());
        initConfig.setUriConfig(BDTrackerConfigs.INSTANCE.uriConfig(configInfo.isBoe()));
        initConfig.setNetworkClient(networkClient);
        initConfig.setAutoStart(true);
        initConfig.setHandleLifeCycle(true);
        initConfig.setVersionCode(configInfo.getVersionCode());
        initConfig.setVersion(configInfo.getVersionName());
        initConfig.setUpdateVersionCode(configInfo.getUpdateVersionCode());
        initConfig.setEventFilterEnable(configInfo.getFilterEnable());
        initConfig.setLogger(new AppLogLogger("AppLog_" + configInfo.getAppId()));
        LanguageUtil languageUtil = LanguageUtil.INSTANCE;
        String language = AppLocaleUtils.INSTANCE.getAppLocale().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        initConfig.setLanguage(languageUtil.getLanguageForCommonParameters(language));
        BDTrackerConfigs.INSTANCE.configSensitiveApi(initConfig);
        AppLog.setEncryptAndCompress(!AppHost.INSTANCE.isDebug());
        AppLog.setEventSamplingEnable(configInfo.getSamplingEnable());
        AppLog.setNewMonitorEnabled(configInfo.getNewMonitorEnabled());
        AppLog.setNewMonitorInDebugMode(configInfo.getNewMonitorInDebugMode());
        MonitorConfigManager.defaultSentryEnabled = configInfo.getDefaultSentryEnabled();
        MonitorConfigManager.defaultSentryColdStartSamplingRate = configInfo.getDefaultSentryColdStartSamplingRate();
        MonitorConfigManager.defaultColdStartReportDelay = configInfo.getDefaultColdStartReportDelay();
        MonitorConfigManager.defaultReportInterval = configInfo.getDefaultReportInterval();
        PackOptConfig.packByLengthEnabled = configInfo.getPackByLengthEnabled();
        PackOptConfig.realtimeEventOptEnabled = configInfo.getRealtimeEventOptEnabled();
        PackOptConfig.packMultiQueryEnabled = configInfo.getPackMultiQueryEnabled();
        AppLog.setBDInstallEventTrackEnabled(true);
        SecurityService securityService = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (securityService != null) {
            securityService.initBdInstall();
        }
        AppLog.setExtraParams(new IExtraParams() { // from class: com.bytedance.trae.applog.impl.AppLogHelper$$ExternalSyntheticLambda1
            public final HashMap getExtraParams(Level level) {
                HashMap init$lambda$0;
                init$lambda$0 = AppLogHelper.init$lambda$0(level);
                return init$lambda$0;
            }
        });
        AppLogHelper$navigatorCallback$1 appLogHelper$navigatorCallback$1 = navigatorCallback;
        AppLog.setNavigatorCallback(appLogHelper$navigatorCallback$1);
        AppLog.setBgSessionTaskNavigatorCallback(appLogHelper$navigatorCallback$1);
        AppLog.addLaunchObserver(launchObserver);
        AppLog.init(AppHost.INSTANCE.getApplication(), initConfig);
        initTobAppLogIfNeeded();
        AppLog.setExternalAbVersion(ExposedManager.getInstance(AppHost.INSTANCE.getApplication()).getExposedVids());
        AppLog.addDataObserver(dataObserver);
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.trae.applog.impl.AppLogHelper$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AppLogHelper.init$lambda$1();
            }
        });
        AppLog.setBgSessionTaskEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap init$lambda$0(Level level) {
        return TraeTTNet.INSTANCE.getAppLogExtraParams(level.value());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1() {
        AppLog.setHeaderInfo(new HashMap(com.bytedance.trae.apm.api.IExtraParams.INSTANCE.getStaticParams()));
    }

    public final void setBDAccountCallback(final Pair<Integer, Long> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        AppLog.setBDAccountCallback(new IBDAccountCallback() { // from class: com.bytedance.trae.applog.impl.AppLogHelper$$ExternalSyntheticLambda0
            public final Pair getOdinUserInfo() {
                Pair bDAccountCallback$lambda$2;
                bDAccountCallback$lambda$2 = AppLogHelper.setBDAccountCallback$lambda$2(pair);
                return bDAccountCallback$lambda$2;
            }
        });
        AppLog.setEnableEventUserId(true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
    
        if (r2.equals(com.bytedance.trae.applog.impl.AppLogHelper.ACCOUNT_TYPE_TOB) == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        if (r2.equals(com.bytedance.trae.applog.impl.AppLogHelper.ACCOUNT_TYPE_BYTEDANCE) == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0032, code lost:
    
        if (r2.equals(com.bytedance.trae.applog.impl.AppLogHelper.ACCOUNT_TYPE_TOC) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onAccountTypeChanged(String accountType, String userId, String tenantId, String tenantName) {
        String str;
        Intrinsics.checkNotNullParameter(accountType, "accountType");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(tenantId, "tenantId");
        Intrinsics.checkNotNullParameter(tenantName, "tenantName");
        String lowerCase = accountType.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -2047085653:
                str = ACCOUNT_TYPE_BYTEDANCE;
                break;
            case 115015:
                str = ACCOUNT_TYPE_TOB;
                break;
            case 115016:
                str = ACCOUNT_TYPE_TOC;
                break;
            default:
                str = "unknown";
                break;
        }
        currentAccountType = str;
        currentAccountUserId = userId;
        currentTenantId = tenantId;
        currentTenantName = tenantName;
        if (shouldUseTobAppLog()) {
            initTobAppLogIfNeeded();
        }
        updateTobAccountInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair setBDAccountCallbackProvider$lambda$3(Function0 function0) {
        return (Pair) function0.invoke();
    }

    public final void setBDAccountCallbackProvider(final Function0<? extends Pair<Integer, Long>> provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        AppLog.setBDAccountCallback(new IBDAccountCallback() { // from class: com.bytedance.trae.applog.impl.AppLogHelper$$ExternalSyntheticLambda5
            public final Pair getOdinUserInfo() {
                Pair bDAccountCallbackProvider$lambda$3;
                bDAccountCallbackProvider$lambda$3 = AppLogHelper.setBDAccountCallbackProvider$lambda$3(provider);
                return bDAccountCallbackProvider$lambda$3;
            }
        });
        AppLog.setEnableEventUserId(true);
    }

    /* compiled from: AppLogHelper.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH\u0096\u0002J2\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH\u0016J&\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016J.\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u001a\u0010\u0010\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0012\u0018\u00010\u0011H\u0016J2\u0010\u0013\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient;", "Lcom/bytedance/bdinstall/INetworkClient;", "<init>", "()V", "mClient", "Lcom/bytedance/trae/applog/impl/TraeNetworkClient;", ApiRequest.METHOD_GET, "", IWeixinService.ResponseConstants.URL, "requestHeaders", "", ApiRequest.METHOD_POST, "data", "", "bytes", "contentType", "params", "", "Landroid/util/Pair;", "postStream", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class CommonNetworkClient implements INetworkClient {
        private TraeNetworkClient mClient = new TraeNetworkClient();

        /* JADX WARN: Multi-variable type inference failed */
        public String get(String url, Map<String, String> requestHeaders) {
            try {
                HashMap hashMap = new HashMap();
                Pair buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(new BDNetworkTagContextProviderAdapter() { // from class: com.bytedance.trae.applog.impl.AppLogHelper$CommonNetworkClient$get$tag$1
                    public int triggerType() {
                        return 0;
                    }
                });
                hashMap.put(buildBDNetworkTag.first, buildBDNetworkTag.second);
                if (requestHeaders == null) {
                    requestHeaders = new LinkedHashMap();
                }
                Map mutableMap = MapsKt.toMutableMap(requestHeaders);
                Object obj = buildBDNetworkTag.first;
                Intrinsics.checkNotNullExpressionValue(obj, "first");
                Object obj2 = buildBDNetworkTag.second;
                Intrinsics.checkNotNullExpressionValue(obj2, "second");
                mutableMap.put(obj, obj2);
                String str = this.mClient.get(url, mutableMap, null);
                Intrinsics.checkNotNull(str);
                return str;
            } catch (Exception e) {
                if (e instanceof CommonHttpException) {
                    throw new RangersHttpException(e.getResponseCode(), e.getCause());
                }
                throw new RangersHttpException(FConstants.DECOMPRESS_FAIL_CODE, e.getCause());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public String post(String url, byte[] data, Map<String, String> requestHeaders) {
            try {
                HashMap hashMap = new HashMap();
                Pair buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(new BDNetworkTagContextProviderAdapter() { // from class: com.bytedance.trae.applog.impl.AppLogHelper$CommonNetworkClient$post$tag$1
                    public int triggerType() {
                        return 0;
                    }
                });
                hashMap.put(buildBDNetworkTag.first, buildBDNetworkTag.second);
                if (requestHeaders == null) {
                    requestHeaders = new LinkedHashMap();
                }
                Map mutableMap = MapsKt.toMutableMap(requestHeaders);
                Object obj = buildBDNetworkTag.first;
                Intrinsics.checkNotNullExpressionValue(obj, "first");
                Object obj2 = buildBDNetworkTag.second;
                Intrinsics.checkNotNullExpressionValue(obj2, "second");
                mutableMap.put(obj, obj2);
                String post = this.mClient.post(url, data, (Map<String, String>) mutableMap, (NetworkClient.ReqContext) null);
                Intrinsics.checkNotNull(post);
                return post;
            } catch (CommonHttpException e) {
                throw new RangersHttpException(e.getResponseCode(), e.getCause());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public String post(String url, byte[] bytes, String contentType) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(contentType)) {
                hashMap.put("Content-Type", contentType);
            }
            try {
                HashMap hashMap2 = new HashMap();
                Pair buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(new BDNetworkTagContextProviderAdapter() { // from class: com.bytedance.trae.applog.impl.AppLogHelper$CommonNetworkClient$post$tag$2
                    public int triggerType() {
                        return 0;
                    }
                });
                hashMap2.put(buildBDNetworkTag.first, buildBDNetworkTag.second);
                Map mutableMap = MapsKt.toMutableMap(hashMap);
                Object obj = buildBDNetworkTag.first;
                Intrinsics.checkNotNullExpressionValue(obj, "first");
                mutableMap.put(obj, buildBDNetworkTag.second);
                String post = this.mClient.post(url, bytes, (Map<String, String>) mutableMap, (NetworkClient.ReqContext) null);
                Intrinsics.checkNotNull(post);
                return post;
            } catch (CommonHttpException e) {
                throw new RangersHttpException(e.getResponseCode(), e.getCause());
            }
        }

        public String post(String url, List<Pair<String, String>> params) {
            String post = this.mClient.post(url, params);
            Intrinsics.checkNotNullExpressionValue(post, "post(...)");
            return post;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public byte[] postStream(String url, byte[] data, Map<String, String> requestHeaders) {
            try {
                HashMap hashMap = new HashMap();
                Pair buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(new BDNetworkTagContextProviderAdapter() { // from class: com.bytedance.trae.applog.impl.AppLogHelper$CommonNetworkClient$postStream$tag$1
                    public int triggerType() {
                        return 0;
                    }
                });
                hashMap.put(buildBDNetworkTag.first, buildBDNetworkTag.second);
                if (requestHeaders == null) {
                    requestHeaders = new LinkedHashMap();
                }
                Map mutableMap = MapsKt.toMutableMap(requestHeaders);
                Object obj = buildBDNetworkTag.first;
                Intrinsics.checkNotNullExpressionValue(obj, "first");
                Object obj2 = buildBDNetworkTag.second;
                Intrinsics.checkNotNullExpressionValue(obj2, "second");
                mutableMap.put(obj, obj2);
                byte[] postDataStream = this.mClient.postDataStream(url, data, mutableMap, null);
                Intrinsics.checkNotNull(postDataStream);
                return postDataStream;
            } catch (CommonHttpException e) {
                throw new RangersHttpException(e.getResponseCode(), e.getCause());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchObserver$lambda$5(String str, long j, boolean z) {
        Iterator<T> it = launchObserverList.iterator();
        while (it.hasNext()) {
            ((ILaunchObserver) it.next()).onLaunch(str, j, z);
        }
    }

    private final synchronized void initTobAppLogIfNeeded() {
        if (shouldUseTobAppLog() && !tobInitialized && !tobInitializing) {
            AppLogConfigInfo appLogConfigInfo = mConfigInfo;
            if (appLogConfigInfo == null) {
                return;
            }
            tobInitializing = true;
            try {
                Result.Companion companion = Result.Companion;
                AppLogHelper appLogHelper = this;
                tobInitialized = TobAppLogBridge.INSTANCE.init(appLogConfigInfo);
                updateTobAccountInfo();
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
            tobInitializing = false;
        }
    }

    private final void updateTobAccountInfo() {
        if (tobInitialized) {
            try {
                Result.Companion companion = Result.Companion;
                AppLogHelper appLogHelper = this;
                TobAppLogBridge.INSTANCE.setHeaderInfo("account_type", currentAccountType);
                TobAppLogBridge.INSTANCE.setHeaderInfo(KEY_BIZ_USER_ID, currentAccountUserId);
                TobAppLogBridge.INSTANCE.setUserUniqueID(currentAccountUserId);
                TobAppLogBridge.INSTANCE.setHeaderInfo(KEY_TENANT, currentTenantId);
                TobAppLogBridge.INSTANCE.setHeaderInfo(KEY_TENANT_ID, currentTenantId);
                TobAppLogBridge.INSTANCE.setHeaderInfo(KEY_TENANT_NAME, currentTenantName);
                TobAppLogBridge.INSTANCE.setHeaderInfo("scope", Intrinsics.areEqual(currentAccountType, ACCOUNT_TYPE_TOB) ? SCOPE_SAAS : "");
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        }
    }

    public final void addGetAppLogIdListener(OnGetAppLogIdListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        mDidListenerCallbackList.add(listener);
    }

    public final void removeDidListener(OnGetAppLogIdListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        mDidListenerCallbackList.remove(listener);
    }

    public final void addNavigationCallback(final OnNavigateCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        navigatorCallbackList.add(new NavigatorCallback() { // from class: com.bytedance.trae.applog.impl.AppLogHelper$addNavigationCallback$1
            public void onResume(String activityName, JSONObject flatParams) {
                Intrinsics.checkNotNullParameter(flatParams, "flatParams");
                OnNavigateCallback onNavigateCallback = OnNavigateCallback.this;
                if (activityName == null) {
                    activityName = "";
                }
                onNavigateCallback.onResume(activityName, flatParams);
            }

            public void onPause(String activityName, JSONObject flatParams) {
                Intrinsics.checkNotNullParameter(flatParams, "flatParams");
                OnNavigateCallback onNavigateCallback = OnNavigateCallback.this;
                if (activityName == null) {
                    activityName = "";
                }
                onNavigateCallback.onPause(activityName, flatParams);
            }
        });
    }

    public final void addLaunchObserver(final OnLaunchCallback observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        launchObserverList.add(new ILaunchObserver() { // from class: com.bytedance.trae.applog.impl.AppLogHelper$$ExternalSyntheticLambda4
            public final void onLaunch(String str, long j, boolean z) {
                OnLaunchCallback.this.onLaunch(str, j, z);
            }
        });
    }

    public final void doWhenIdsReady(final Function2<? super String, ? super String, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        String did = AppLog.getDid();
        if (did == null) {
            did = "";
        }
        String iid = AppLog.getIid();
        String str = iid != null ? iid : "";
        if (did.length() > 0) {
            if (str.length() > 0) {
                updateBdTuringId(did, str, "doWhenIdsReady");
                action.invoke(did, str);
                return;
            }
        }
        addGetAppLogIdListener(new OnGetAppLogIdListener() { // from class: com.bytedance.trae.applog.impl.AppLogHelper$doWhenIdsReady$1
            @Override // com.bytedance.trae.applog.api.OnGetAppLogIdListener
            public void onGetId(String did2, String iid2, String ssid) {
                Intrinsics.checkNotNullParameter(did2, "did");
                Intrinsics.checkNotNullParameter(iid2, "iid");
                Intrinsics.checkNotNullParameter(ssid, "ssid");
                AppLogHelper.INSTANCE.updateBdTuringId(did2, iid2, "onGetId");
                action.invoke(did2, iid2);
                AppLogHelper.INSTANCE.removeDidListener(this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBdTuringId(String did, String iid, String from) {
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        if (config != null) {
            config.setDeviceId(did);
        }
        BdTuringConfig config2 = BdTuring.getInstance().getConfig();
        if (config2 != null) {
            config2.setInstallId(iid);
        }
    }

    public final void reportEvent(String event, JSONObject jsonParams) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        if (jsonParams == null) {
            jsonParams = new JSONObject();
        }
        addCommonParamsToJSONObject(jsonParams);
        addTocMappingParams(jsonParams);
        AppLog.onEventV3(event, jsonParams);
        reportTobEventIfNeeded(event, jsonParams);
    }

    public final void reportEvent(String event, Bundle bundleParams) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        if (bundleParams == null) {
            bundleParams = new Bundle();
        }
        addCommonParamsToBundle(bundleParams);
        addTocMappingParams(bundleParams);
        AppLog.onEventV3(event, bundleParams);
        reportTobEventIfNeeded(event, bundleParams);
    }

    public final void onMiscEvent(String logType, JSONObject obj) {
        Intrinsics.checkNotNullParameter(logType, "logType");
        Intrinsics.checkNotNullParameter(obj, "obj");
        AppLog.onMiscEvent(logType, obj);
        reportTobMiscEventIfNeeded(logType, obj);
    }

    public final void openETVerify() {
        AppLogConfigInfo appLogConfigInfo = mConfigInfo;
        if (appLogConfigInfo != null) {
            EventsSenderUtils.setEventsSenderEnable(String.valueOf(appLogConfigInfo.getAppId()), true, AppHost.INSTANCE.getApplication());
            if (AppHost.INSTANCE.isOversea()) {
                EventsSenderUtils.setEventVerifyHost(String.valueOf(appLogConfigInfo.getAppId()), BDTrackerConsts.EVENT_VERIFY_OVERSEA_HOST);
            } else {
                EventsSenderUtils.setEventVerifyHost(String.valueOf(appLogConfigInfo.getAppId()), BDTrackerConsts.EVENT_VERIFY_HOST);
            }
        }
    }

    public final void addEventCommonParams(String key, Function0<? extends Object> valueGenerator) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(valueGenerator, "valueGenerator");
        eventCommonParamsGenerators.put(key, valueGenerator);
    }

    public final void putEventCommonParams(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        eventCommonParamsMap.put(key, value);
    }

    private final void addCommonParamsToJSONObject(JSONObject params) {
        for (Map.Entry<String, Function0<Object>> entry : eventCommonParamsGenerators.entrySet()) {
            try {
                String key = entry.getKey();
                Object invoke = entry.getValue().invoke();
                if (!params.has(key) && invoke != null) {
                    params.put(key, invoke);
                }
            } catch (Exception unused) {
            }
        }
        for (Map.Entry<String, Object> entry2 : eventCommonParamsMap.entrySet()) {
            try {
                INSTANCE.addToJSONObject(params, entry2.getKey(), entry2.getValue());
            } catch (Exception unused2) {
            }
        }
        putJsonIfAbsent(params, "account_type", currentAccountType);
    }

    private final void addCommonParamsToBundle(Bundle params) {
        for (Map.Entry<String, Function0<Object>> entry : eventCommonParamsGenerators.entrySet()) {
            try {
                String key = entry.getKey();
                Object invoke = entry.getValue().invoke();
                if (!params.containsKey(key) && invoke != null) {
                    INSTANCE.addToBundle(params, key, invoke);
                }
            } catch (Exception unused) {
            }
        }
        for (Map.Entry<String, Object> entry2 : eventCommonParamsMap.entrySet()) {
            try {
                INSTANCE.addToBundle(params, entry2.getKey(), entry2.getValue());
            } catch (Exception unused2) {
            }
        }
        putBundleIfAbsent(params, "account_type", currentAccountType);
    }

    private final void addTocMappingParams(JSONObject params) {
        if (shouldUseTobAppLog() && tobInitialized) {
            String did = TobAppLogBridge.INSTANCE.getDid();
            if (did.length() > 0) {
                putJsonIfAbsent(params, KEY_TOB_DID, did);
            }
        }
    }

    private final void addTocMappingParams(Bundle params) {
        if (shouldUseTobAppLog() && tobInitialized) {
            String did = TobAppLogBridge.INSTANCE.getDid();
            if (did.length() > 0) {
                putBundleIfAbsent(params, KEY_TOB_DID, did);
            }
        }
    }

    private final void reportTobEventIfNeeded(String event, JSONObject tocParams) {
        if (shouldUseTobAppLog()) {
            initTobAppLogIfNeeded();
            if (tobInitialized) {
                try {
                    Result.Companion companion = Result.Companion;
                    AppLogHelper appLogHelper = this;
                    TobAppLogBridge.INSTANCE.onEventV3(event, buildTobJSONObject(tocParams));
                    Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
            }
        }
    }

    private final void reportTobEventIfNeeded(String event, Bundle tocParams) {
        if (shouldUseTobAppLog()) {
            initTobAppLogIfNeeded();
            if (tobInitialized) {
                try {
                    Result.Companion companion = Result.Companion;
                    AppLogHelper appLogHelper = this;
                    TobAppLogBridge.INSTANCE.onEventV3(event, buildTobJSONObject(tocParams));
                    Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
            }
        }
    }

    private final void reportTobMiscEventIfNeeded(String logType, JSONObject tocParams) {
        if (shouldUseTobAppLog()) {
            initTobAppLogIfNeeded();
            if (tobInitialized) {
                try {
                    Result.Companion companion = Result.Companion;
                    AppLogHelper appLogHelper = this;
                    JSONObject copyJSONObject = copyJSONObject(tocParams);
                    addCommonParamsToJSONObject(copyJSONObject);
                    addTocMappingParams(copyJSONObject);
                    TobAppLogBridge.INSTANCE.onMiscEvent(logType, buildTobJSONObject(copyJSONObject));
                    Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
            }
        }
    }

    private final JSONObject buildTobJSONObject(JSONObject source) {
        JSONObject jSONObject = new JSONObject();
        Iterator<String> keys = source.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = source.opt(next);
            Intrinsics.checkNotNull(next);
            putTobValue(jSONObject, next, opt);
        }
        addTobMappingParams(jSONObject);
        return jSONObject;
    }

    private final JSONObject buildTobJSONObject(Bundle source) {
        JSONObject jSONObject = new JSONObject();
        Set<String> keySet = source.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "keySet(...)");
        for (String str : keySet) {
            AppLogHelper appLogHelper = INSTANCE;
            Intrinsics.checkNotNull(str);
            appLogHelper.putTobValue(jSONObject, str, source.get(str));
        }
        addTobMappingParams(jSONObject);
        return jSONObject;
    }

    private final void putTobValue(JSONObject params, String key, Object value) {
        if (value == null || Intrinsics.areEqual(value, JSONObject.NULL)) {
            return;
        }
        if (value instanceof Boolean) {
            value = Integer.valueOf(((Boolean) value).booleanValue() ? 1 : 0);
        }
        params.put(key, value);
    }

    private final JSONObject copyJSONObject(JSONObject source) {
        JSONObject jSONObject = new JSONObject();
        Iterator<String> keys = source.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            jSONObject.put(next, source.opt(next));
        }
        return jSONObject;
    }

    private final void addTobMappingParams(JSONObject params) {
        putJsonIfAbsent(params, "account_type", currentAccountType);
        String did = AppLog.getDid();
        if (did == null) {
            did = "";
        }
        if (did.length() > 0) {
            putJsonIfAbsent(params, KEY_TOC_DID, did);
        }
    }

    private final boolean shouldUseTobAppLog() {
        return TobAppLogBridge.INSTANCE.isSupported() && Intrinsics.areEqual(currentAccountType, ACCOUNT_TYPE_TOB);
    }

    private final void putJsonIfAbsent(JSONObject params, String key, Object value) {
        if (params.has(key)) {
            return;
        }
        if (value.toString().length() > 0) {
            params.put(key, value);
        }
    }

    private final void putBundleIfAbsent(Bundle params, String key, String value) {
        if (params.containsKey(key)) {
            return;
        }
        if (value.length() > 0) {
            params.putString(key, value);
        }
    }

    private final void addToJSONObject(JSONObject params, String key, Object value) {
        if (params.has(key)) {
            return;
        }
        if (value instanceof String) {
            params.put(key, value);
            return;
        }
        if (value instanceof Integer) {
            params.put(key, ((Number) value).intValue());
            return;
        }
        if (value instanceof Long) {
            params.put(key, ((Number) value).longValue());
        } else if (value instanceof Boolean) {
            params.put(key, ((Boolean) value).booleanValue());
        } else {
            if (AppHost.INSTANCE.isTestChannel()) {
                throw new IllegalArgumentException("addToJSONObject -> unsupported type: " + value.getClass().getName());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void addToBundle(Bundle params, String key, Object value) {
        if (params.containsKey(key)) {
            return;
        }
        if (value instanceof String) {
            params.putString(key, (String) value);
            return;
        }
        if (value instanceof Integer) {
            params.putInt(key, ((Number) value).intValue());
            return;
        }
        if (value instanceof Long) {
            params.putLong(key, ((Number) value).longValue());
        } else if (value instanceof Boolean) {
            params.putBoolean(key, ((Boolean) value).booleanValue());
        } else if (AppHost.INSTANCE.isTestChannel()) {
            throw new IllegalArgumentException("addToBundle -> unsupported type: " + value.getClass().getName());
        }
    }
}
