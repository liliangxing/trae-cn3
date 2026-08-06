package com.bytedance.trae.init.task;

import android.os.SystemClock;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.sdk.account.constants.AccountConstants;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.apm.api.IApmTrace;
import com.bytedance.trae.apm.api.IExtraParams;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.applog.api.OnNavigateCallback;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.theme.ThemeManager;
import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountType;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.utils.AppLocaleUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: TrackerCommonParams.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/init/task/TrackerCommonParams;", "", "<init>", "()V", "EVENT_PAGE_ALIVE", "", "pageResumeTimeMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "register", "", "syncHeaderCustomParams", "registerPageAliveTracker", "mapChannelToQuality", Constant.KEY_CHANNEL, "getScope", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TrackerCommonParams {
    private static final String EVENT_PAGE_ALIVE = "predefine_page_alive";
    public static final TrackerCommonParams INSTANCE = new TrackerCommonParams();
    private static final HashMap<String, Long> pageResumeTimeMap = new HashMap<>();
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object register$lambda$13() {
        return "free";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object register$lambda$14() {
        return "";
    }

    private TrackerCommonParams() {
    }

    public final void register() {
        IExtraParams.INSTANCE.registerDynamicParamsProvider(new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda10
            public final Object invoke() {
                Map register$lambda$0;
                register$lambda$0 = TrackerCommonParams.register$lambda$0();
                return register$lambda$0;
            }
        });
        IApplog.INSTANCE.addEventCommonParams("biz_user_id", new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda1
            public final Object invoke() {
                Object register$lambda$1;
                register$lambda$1 = TrackerCommonParams.register$lambda$1();
                return register$lambda$1;
            }
        });
        IApplog.INSTANCE.addEventCommonParams(AccountConstants.AccountShareCols.ACCOUNT_TYPE, new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda2
            public final Object invoke() {
                Object register$lambda$2;
                register$lambda$2 = TrackerCommonParams.register$lambda$2();
                return register$lambda$2;
            }
        });
        IApplog.INSTANCE.addEventCommonParams(Constant.KEY_APP_VERSION, new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda3
            public final Object invoke() {
                Object register$lambda$3;
                register$lambda$3 = TrackerCommonParams.register$lambda$3();
                return register$lambda$3;
            }
        });
        IApplog.INSTANCE.addEventCommonParams("scope", new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda4
            public final Object invoke() {
                Object register$lambda$4;
                register$lambda$4 = TrackerCommonParams.register$lambda$4();
                return register$lambda$4;
            }
        });
        IApplog.INSTANCE.addEventCommonParams("tenant", new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda5
            public final Object invoke() {
                Object register$lambda$5;
                register$lambda$5 = TrackerCommonParams.register$lambda$5();
                return register$lambda$5;
            }
        });
        IApplog.INSTANCE.addEventCommonParams("region", new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda6
            public final Object invoke() {
                Object register$lambda$6;
                register$lambda$6 = TrackerCommonParams.register$lambda$6();
                return register$lambda$6;
            }
        });
        IApplog.INSTANCE.addEventCommonParams("aiRegion", new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda7
            public final Object invoke() {
                Object register$lambda$7;
                register$lambda$7 = TrackerCommonParams.register$lambda$7();
                return register$lambda$7;
            }
        });
        IApplog.INSTANCE.addEventCommonParams("quality", new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda8
            public final Object invoke() {
                Object register$lambda$8;
                register$lambda$8 = TrackerCommonParams.register$lambda$8();
                return register$lambda$8;
            }
        });
        IApplog.INSTANCE.addEventCommonParams(SettingsTracker.TYPE_LANGUAGE, new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda9
            public final Object invoke() {
                Object register$lambda$9;
                register$lambda$9 = TrackerCommonParams.register$lambda$9();
                return register$lambda$9;
            }
        });
        IApplog.INSTANCE.addEventCommonParams(SettingsTracker.TYPE_THEME, new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda11
            public final Object invoke() {
                Object register$lambda$10;
                register$lambda$10 = TrackerCommonParams.register$lambda$10();
                return register$lambda$10;
            }
        });
        IApplog.INSTANCE.addEventCommonParams("is_privacy_mode", new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda12
            public final Object invoke() {
                Object register$lambda$11;
                register$lambda$11 = TrackerCommonParams.register$lambda$11();
                return register$lambda$11;
            }
        });
        IApplog.INSTANCE.addEventCommonParams("ssh_mode", new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda13
            public final Object invoke() {
                Object obj;
                obj = SubTaskRequestMessage.EXECUTOR_CLIENT;
                return obj;
            }
        });
        IApplog.INSTANCE.addEventCommonParams("user_identity", new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda14
            public final Object invoke() {
                Object register$lambda$13;
                register$lambda$13 = TrackerCommonParams.register$lambda$13();
                return register$lambda$13;
            }
        });
        IApplog.INSTANCE.addEventCommonParams("pro_period", new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda15
            public final Object invoke() {
                Object register$lambda$14;
                register$lambda$14 = TrackerCommonParams.register$lambda$14();
                return register$lambda$14;
            }
        });
        IApplog.INSTANCE.addEventCommonParams("version_code", new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda16
            public final Object invoke() {
                Object register$lambda$15;
                register$lambda$15 = TrackerCommonParams.register$lambda$15();
                return register$lambda$15;
            }
        });
        IApplog.INSTANCE.addEventCommonParams(Constant.KEY_UPDATE_VERSION_CODE, new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda17
            public final Object invoke() {
                Object register$lambda$16;
                register$lambda$16 = TrackerCommonParams.register$lambda$16();
                return register$lambda$16;
            }
        });
        IApplog.INSTANCE.addEventCommonParams("is_new_user", new Function0() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda18
            public final Object invoke() {
                Object register$lambda$17;
                register$lambda$17 = TrackerCommonParams.register$lambda$17();
                return register$lambda$17;
            }
        });
        syncHeaderCustomParams();
        registerPageAliveTracker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map register$lambda$0() {
        return MapsKt.mapOf(TuplesKt.to("scope", INSTANCE.getScope()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object register$lambda$1() {
        AccountInfo accountInfo;
        String userId;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        return (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (userId = accountInfo.getUserId()) == null) ? "" : userId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object register$lambda$2() {
        AccountInfo accountInfo;
        AccountType accountType;
        String value;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        return (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (accountType = accountInfo.getAccountType()) == null || (value = accountType.getValue()) == null) ? AccountType.UNKNOWN.getValue() : value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object register$lambda$3() {
        return AppHost.INSTANCE.getVersionName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object register$lambda$4() {
        return INSTANCE.getScope();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object register$lambda$5() {
        AccountInfo accountInfo;
        String tenantId;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        return (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (tenantId = accountInfo.getTenantId()) == null) ? "" : tenantId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object register$lambda$6() {
        return AppHost.INSTANCE.isOversea() ? "US" : "CN";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object register$lambda$7() {
        AccountInfo accountInfo;
        String aiRegion;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        return (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (aiRegion = accountInfo.getAiRegion()) == null) ? "" : aiRegion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object register$lambda$8() {
        return INSTANCE.mapChannelToQuality(AppHost.INSTANCE.getBuildChannel());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object register$lambda$9() {
        return AppLocaleUtils.INSTANCE.getAppLocale().getLanguage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object register$lambda$10() {
        return ThemeManager.INSTANCE.isDarkMode() ? "dark" : "light";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object register$lambda$11() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object register$lambda$15() {
        return String.valueOf(AppHost.INSTANCE.getVersionCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object register$lambda$16() {
        return String.valueOf(AppHost.INSTANCE.getUpdateVersionCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object register$lambda$17() {
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        boolean z = false;
        if (iLoginService != null && iLoginService.isNewUser()) {
            z = true;
        }
        return z ? "1" : "0";
    }

    public final void syncHeaderCustomParams() {
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TrackerCommonParams.syncHeaderCustomParams$lambda$18();
            }
        });
    }

    private final void registerPageAliveTracker() {
        IApplog.INSTANCE.addNavigatorCallback(new OnNavigateCallback() { // from class: com.bytedance.trae.init.task.TrackerCommonParams$registerPageAliveTracker$1
            @Override // com.bytedance.trae.applog.api.OnNavigateCallback
            public void onResume(String activityName, JSONObject flatParams) {
                HashMap hashMap;
                Intrinsics.checkNotNullParameter(activityName, "activityName");
                Intrinsics.checkNotNullParameter(flatParams, "flatParams");
                hashMap = TrackerCommonParams.pageResumeTimeMap;
                hashMap.put(activityName, Long.valueOf(SystemClock.elapsedRealtime()));
            }

            @Override // com.bytedance.trae.applog.api.OnNavigateCallback
            public void onPause(String activityName, JSONObject flatParams) {
                HashMap hashMap;
                Intrinsics.checkNotNullParameter(activityName, "activityName");
                Intrinsics.checkNotNullParameter(flatParams, "flatParams");
                hashMap = TrackerCommonParams.pageResumeTimeMap;
                Long l = (Long) hashMap.remove(activityName);
                if (l != null) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - l.longValue();
                    if (elapsedRealtime > 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("page_key", activityName);
                        jSONObject.put(ReportConstant.COMMON_INIT_DURATION, elapsedRealtime);
                        IApplog.INSTANCE.reportEvent("predefine_page_alive", jSONObject);
                    }
                }
            }
        });
    }

    private final String mapChannelToQuality(String channel) {
        String lowerCase = channel.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -1534319379:
                if (lowerCase.equals("googleplay")) {
                    return "stable";
                }
                break;
            case -334831238:
                if (lowerCase.equals("google_play")) {
                    return "stable";
                }
                break;
            case 3020272:
                if (lowerCase.equals("beta")) {
                    return "insider";
                }
                break;
            case 92909918:
                if (lowerCase.equals("alpha")) {
                    return "alpha";
                }
                break;
            case 1303362044:
                if (lowerCase.equals("local_host")) {
                    return "local";
                }
                break;
        }
        return AppHost.INSTANCE.isDebug() ? "dev" : "stable";
    }

    private final String getScope() {
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        AccountInfo accountInfo = iLoginService != null ? iLoginService.getAccountInfo() : null;
        boolean z = false;
        if (iLoginService != null && iLoginService.isTraeLoggedIn()) {
            z = true;
        }
        if (!z) {
            return "unknown";
        }
        if (Intrinsics.areEqual(accountInfo != null ? accountInfo.getLoginPlatform() : null, "enterprise")) {
            return "saas";
        }
        return Intrinsics.areEqual(accountInfo != null ? accountInfo.getLoginPlatform() : null, ThirdPartyTokenRepository.TYPE_BYTECLOUD) ? "bytedance" : AppHost.INSTANCE.isOversea() ? "marscode-us" : "marscode";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void syncHeaderCustomParams$lambda$18() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        AccountInfo accountInfo = iLoginService != null ? iLoginService.getAccountInfo() : null;
        IApplog.Companion companion = IApplog.INSTANCE;
        if (accountInfo == null || (str = accountInfo.getUserId()) == null) {
            str = "";
        }
        companion.setHeaderInfo("biz_user_id", str);
        IApplog.INSTANCE.setHeaderInfo(Constant.KEY_APP_VERSION, AppHost.INSTANCE.getVersionName());
        TrackerCommonParams trackerCommonParams = INSTANCE;
        String scope = trackerCommonParams.getScope();
        IApplog.INSTANCE.setHeaderInfo("scope", scope);
        IApmTrace.INSTANCE.traceAll("scope", scope);
        IApplog.Companion companion2 = IApplog.INSTANCE;
        if (accountInfo == null || (str2 = accountInfo.getTenantId()) == null) {
            str2 = "";
        }
        companion2.setHeaderInfo("tenant", str2);
        IApplog.Companion companion3 = IApplog.INSTANCE;
        if (accountInfo == null || (str3 = accountInfo.getTenantId()) == null) {
            str3 = "";
        }
        companion3.setHeaderInfo("tenant_id", str3);
        IApplog.Companion companion4 = IApplog.INSTANCE;
        if (accountInfo == null || (str4 = accountInfo.getTenantName()) == null) {
            str4 = "";
        }
        companion4.setHeaderInfo("tenant_name", str4);
        IApplog.INSTANCE.setHeaderInfo("region", AppHost.INSTANCE.isOversea() ? "US" : "CN");
        IApplog.Companion companion5 = IApplog.INSTANCE;
        if (accountInfo == null || (str5 = accountInfo.getAiRegion()) == null) {
            str5 = "";
        }
        companion5.setHeaderInfo("aiRegion", str5);
        IApplog.INSTANCE.setHeaderInfo("quality", trackerCommonParams.mapChannelToQuality(AppHost.INSTANCE.getBuildChannel()));
        IApplog.Companion companion6 = IApplog.INSTANCE;
        String language = AppLocaleUtils.INSTANCE.getAppLocale().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        companion6.setHeaderInfo(SettingsTracker.TYPE_LANGUAGE, language);
        IApplog.INSTANCE.setHeaderInfo(SettingsTracker.TYPE_THEME, ThemeManager.INSTANCE.isDarkMode() ? "dark" : "light");
        boolean z = false;
        IApplog.INSTANCE.setHeaderInfo("is_privacy_mode", 0);
        IApplog.INSTANCE.setHeaderInfo("ssh_mode", SubTaskRequestMessage.EXECUTOR_CLIENT);
        IApplog.INSTANCE.setHeaderInfo("user_identity", "free");
        IApplog.INSTANCE.setHeaderInfo("pro_period", "");
        IApplog.INSTANCE.setHeaderInfo("version_code", String.valueOf(AppHost.INSTANCE.getVersionCode()));
        IApplog.INSTANCE.setHeaderInfo(Constant.KEY_UPDATE_VERSION_CODE, String.valueOf(AppHost.INSTANCE.getUpdateVersionCode()));
        IApplog.Companion companion7 = IApplog.INSTANCE;
        if (iLoginService != null && iLoginService.isNewUser()) {
            z = true;
        }
        companion7.setHeaderInfo("is_new_user", z ? "1" : "0");
    }
}
