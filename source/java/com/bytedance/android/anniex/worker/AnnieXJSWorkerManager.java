package com.bytedance.android.anniex.worker;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.core.app.NotificationCompat;
import bolts.Task;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.web.api.AnnieXWebModelBuilderKt;
import com.bytedance.android.anniex.worker.AnnieXJSWorkerManager;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.pollyfill.NetWorker;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeInfo;
import com.bytedance.geckox.utils.MD5Utils;
import com.bytedance.ies.bullet.base.settings.ClientAiConfig;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.sdk.xbridge.cn.storage.utils.IBizNativeStorage;
import com.bytedance.sdk.xbridge.cn.storage.utils.INativeStorage;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: AnnieXJSWorkerManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001QB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u000f\u0010(\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010)J\u0097\u0001\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-2}\u0010.\u001ay\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(3\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(4\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u00190/H\u0002J\u0097\u0001\u00106\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-2}\u0010.\u001ay\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(3\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(4\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u00190/H\u0002J\u000e\u00107\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006J\u0010\u00108\u001a\u0004\u0018\u00010\u00062\u0006\u00109\u001a\u00020\u0006J\u000e\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00060=H\u0002J\u000e\u0010>\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010?\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u001d\u0010@\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u0006H\u0000¢\u0006\u0002\bAJ\u0018\u0010B\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u0006H\u0002J\u0015\u0010C\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u0006H\u0000¢\u0006\u0002\bDJ%\u0010E\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00062\u0006\u0010F\u001a\u00020GH\u0000¢\u0006\u0002\bHJ$\u0010I\u001a\u00020\u00192\u0006\u0010J\u001a\u00020\u00062\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010LH\u0002J\u0018\u0010M\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u00062\b\u0010N\u001a\u0004\u0018\u00010\u0006J\u001a\u0010O\u001a\u00020\u00192\b\u0010;\u001a\u0004\u0018\u00010\u00062\b\u0010P\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/bytedance/android/anniex/worker/AnnieXJSWorkerManager;", "", "()V", "MAX_VALUE", "", "METHOD_NAME_GET_STORAGE", "", "METHOD_NAME_SET_STORAGE", "TAG", "annieXJSWorker", "Lcom/bytedance/android/anniex/worker/AnnieXJSWorker;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "hasDefaultInit", "", "hasInitInCard", "isInit", "isInitTaskAdded", "storage", "Lcom/bytedance/sdk/xbridge/cn/storage/utils/INativeStorage;", "addWorkerInitTask", "", "context", "Landroid/app/Application;", "enterFrom", "delayMillis", "", "compareMD5", "Lcom/bytedance/android/anniex/worker/AnnieXJSWorkerManager$CompareResult;", Constants.KEY_DATA, "", "createAnnieXJSWorkerAndRunJs", "Landroid/content/Context;", "jsBundle", "createWorkerTask", "Ljava/lang/Runnable;", "enableAnnieXWorker", "()Ljava/lang/Boolean;", "fetchJSFromGecko", StreamTrafficObservable.STREAM_URL, "params", "Lcom/bytedance/forest/model/RequestParams;", "callback", "Lkotlin/Function5;", "Lkotlin/ParameterName;", StrategyConstants.NAME, "isSuccess", NotificationCompat.CATEGORY_MESSAGE, "versionId", "md5", "fetchJSFromGeckoV2", "getMainTemplateWithoutQuery", "getUa", "key", "getUaCache", "bid", "getaMD5CheckList", "", "init", "initInCard", "initInPage", "initInPage$anniex_release", "initInPageByWhiteList", "postDestroyEvent", "postDestroyEvent$anniex_release", "postFirstVisibleEvent", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "postFirstVisibleEvent$anniex_release", "reportPageVisibleEvent", "eventName", "map", "", "saveUa", StrategyConstants.VALUE, "setUaCache", BaseHttpRequestInfo.KEY_USER_AGENT, "CompareResult", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXJSWorkerManager {
    private static final int MAX_VALUE = 100000;
    private static final String METHOD_NAME_GET_STORAGE = "x.getStorageItem";
    private static final String METHOD_NAME_SET_STORAGE = "x.setStorageItem";
    private static final String TAG = "AnnieXJSWorkerManager";
    private static AnnieXJSWorker annieXJSWorker;
    private static boolean hasDefaultInit;
    private static boolean hasInitInCard;
    private static volatile boolean isInit;
    private static boolean isInitTaskAdded;
    private static INativeStorage storage;
    public static final AnnieXJSWorkerManager INSTANCE = new AnnieXJSWorkerManager();

    /* renamed from: handler$delegate, reason: from kotlin metadata */
    private static final Lazy handler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.android.anniex.worker.AnnieXJSWorkerManager$handler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m3464invoke() {
            HandlerThread handlerThread = new HandlerThread("AnnieXJSWorkerManager", 0);
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }
    });

    private AnnieXJSWorkerManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler getHandler() {
        return (Handler) handler.getValue();
    }

    public final void setUaCache(String bid, String ua) {
        if (storage == null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "storage is null", (Map) null, (LoggerContext) null, 12, (Object) null);
        } else {
            if (bid == null || ua == null) {
                return;
            }
            synchronized (this) {
                INSTANCE.saveUa(bid, ua);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void saveUa(final String key, final String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.worker.AnnieXJSWorkerManager$saveUa$1
            @Override // java.util.concurrent.Callable
            public final Boolean call() {
                INativeStorage iNativeStorage;
                INativeStorage iNativeStorage2;
                IBizNativeStorage iBizNativeStorage;
                iNativeStorage = AnnieXJSWorkerManager.storage;
                if (iNativeStorage instanceof IBizNativeStorage) {
                    iBizNativeStorage = AnnieXJSWorkerManager.storage;
                    Intrinsics.checkNotNull(iBizNativeStorage, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.storage.utils.IBizNativeStorage");
                    return Boolean.valueOf(iBizNativeStorage.setBizStorageItem("AnnieXJSWorkerManager", key, value, (Long) null, "x.setStorageItem", (String) null));
                }
                iNativeStorage2 = AnnieXJSWorkerManager.storage;
                if (iNativeStorage2 != null) {
                    return Boolean.valueOf(iNativeStorage2.setStorageItem(key, value, (Long) null, "x.setStorageItem", (String) null));
                }
                return null;
            }
        });
    }

    public final String getUa(String key) {
        Object storageItem;
        Intrinsics.checkNotNullParameter(key, "key");
        IBizNativeStorage iBizNativeStorage = storage;
        if (iBizNativeStorage == null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "storage is null", (Map) null, (LoggerContext) null, 12, (Object) null);
            return null;
        }
        if (iBizNativeStorage instanceof IBizNativeStorage) {
            Intrinsics.checkNotNull(iBizNativeStorage, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.storage.utils.IBizNativeStorage");
            storageItem = iBizNativeStorage.getBizStorageItem(TAG, key, METHOD_NAME_GET_STORAGE, (String) null);
        } else {
            storageItem = iBizNativeStorage != null ? iBizNativeStorage.getStorageItem(key, METHOD_NAME_GET_STORAGE, (String) null) : null;
        }
        if (storageItem instanceof String) {
            return (String) storageItem;
        }
        return null;
    }

    public final String getUaCache(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        String ua = getUa(bid);
        if (ua == null) {
            ua = "";
        }
        if (!Intrinsics.areEqual(ua, "")) {
            return ua;
        }
        HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "ua is null", (Map) null, (LoggerContext) null, 12, (Object) null);
        return "";
    }

    public final synchronized void init(Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
        BulletSettings provideBulletSettings = iSettingService != null ? iSettingService.provideBulletSettings() : null;
        if (!isInit && !hasDefaultInit) {
            boolean z = false;
            if ((provideBulletSettings != null && provideBulletSettings.getAnnieXWorker()) && provideBulletSettings.getEnableDefaultInit()) {
                int delaySeconds = provideBulletSettings.getDelaySeconds();
                if (delaySeconds >= 0 && delaySeconds <= 100) {
                    z = true;
                }
                long delaySeconds2 = z ? provideBulletSettings.getDelaySeconds() * 1000 : 0L;
                hasDefaultInit = true;
                addWorkerInitTask(context, DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE, delaySeconds2);
            }
        }
    }

    public final void initInCard(Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
        BulletSettings provideBulletSettings = iSettingService != null ? iSettingService.provideBulletSettings() : null;
        if (isInit || hasInitInCard) {
            return;
        }
        boolean z = false;
        if ((provideBulletSettings != null && provideBulletSettings.getAnnieXWorker()) && provideBulletSettings.getEnableCardInit()) {
            int cardInitDelaySeconds = provideBulletSettings.getCardInitDelaySeconds();
            if (cardInitDelaySeconds >= 0 && cardInitDelaySeconds <= 100) {
                z = true;
            }
            long cardInitDelaySeconds2 = z ? provideBulletSettings.getCardInitDelaySeconds() * 1000 : 0L;
            hasInitInCard = true;
            addWorkerInitTask(context, AnnieX.CONTAINER_VIEW_TYPE_CARD, cardInitDelaySeconds2);
        }
    }

    private final void initInPageByWhiteList(final Application context, final String url) {
        if (isInit || !IConditionCallKt.enableAnnieXWorkerTaskInitImmediately()) {
            return;
        }
        getHandler().post(new Runnable() { // from class: com.bytedance.android.anniex.worker.AnnieXJSWorkerManager$initInPageByWhiteList$1
            @Override // java.lang.Runnable
            public final void run() {
                BulletSettings provideBulletSettings;
                List pageInitWorkerList;
                Handler handler2;
                Runnable createWorkerTask;
                ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
                if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null || (pageInitWorkerList = provideBulletSettings.getPageInitWorkerList()) == null) {
                    return;
                }
                String str = url;
                Application application = context;
                Iterator it = pageInitWorkerList.iterator();
                while (it.hasNext()) {
                    if (StringsKt.contains$default(str, (String) it.next(), false, 2, (Object) null)) {
                        handler2 = AnnieXJSWorkerManager.INSTANCE.getHandler();
                        createWorkerTask = AnnieXJSWorkerManager.INSTANCE.createWorkerTask(application);
                        handler2.post(createWorkerTask);
                        return;
                    }
                }
            }
        });
    }

    public final synchronized void initInPage$anniex_release(Application context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, StreamTrafficObservable.STREAM_URL);
        ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
        BulletSettings provideBulletSettings = iSettingService != null ? iSettingService.provideBulletSettings() : null;
        initInPageByWhiteList(context, url);
        if (!isInit) {
            boolean z = true;
            if ((provideBulletSettings != null && provideBulletSettings.getAnnieXWorker()) && provideBulletSettings.getEnablePageInit()) {
                int pageInitDelaySeconds = provideBulletSettings.getPageInitDelaySeconds();
                if (pageInitDelaySeconds < 0 || pageInitDelaySeconds > 100) {
                    z = false;
                }
                addWorkerInitTask(context, "page", z ? provideBulletSettings.getPageInitDelaySeconds() * 1000 : 0L);
            }
        }
    }

    private final void addWorkerInitTask(Application context, String enterFrom, long delayMillis) {
        if (isInitTaskAdded && IConditionCallKt.enableAnnieXWorkerTaskInitOnce()) {
            return;
        }
        IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo("anniex_worker_init", (String) null, (String) null, (JSONObject) null, (JSONObject) null, (Boolean) null, (JSONObject) null, (JSONObject) null, 254, (DefaultConstructorMarker) null);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("enter_from", enterFrom);
            reportInfo.setCategory(jSONObject);
            iMonitorReportService.report(reportInfo);
        }
        getHandler().postDelayed(createWorkerTask(context), delayMillis);
        isInitTaskAdded = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable createWorkerTask(final Application context) {
        return new Runnable() { // from class: com.bytedance.android.anniex.worker.AnnieXJSWorkerManager$createWorkerTask$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                z = AnnieXJSWorkerManager.isInit;
                if (z) {
                    return;
                }
                ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
                BulletSettings provideBulletSettings = iSettingService != null ? iSettingService.provideBulletSettings() : null;
                if (provideBulletSettings != null) {
                    final AnnieXJSWorkerManager annieXJSWorkerManager = AnnieXJSWorkerManager.this;
                    final Application application = context;
                    final String resUrl = provideBulletSettings.getResUrl();
                    if (resUrl != null) {
                        RequestParams requestParams = new RequestParams((Scene) null, 1, (DefaultConstructorMarker) null);
                        requestParams.setOnlyLocal(provideBulletSettings.isOnlyLocal());
                        requestParams.setNetWorker(NetWorker.TTNet);
                        annieXJSWorkerManager.fetchJSFromGeckoV2(resUrl, requestParams, new Function5<Boolean, String, String, String, String, Unit>() { // from class: com.bytedance.android.anniex.worker.AnnieXJSWorkerManager$createWorkerTask$1$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(5);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                                invoke(((Boolean) obj).booleanValue(), (String) obj2, (String) obj3, (String) obj4, (String) obj5);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z2, String str, String str2, String str3, String str4) {
                                IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(IMonitorReportService.class);
                                if (iMonitorReportService != null) {
                                    ReportInfo reportInfo = new ReportInfo("anniex_worker_fetch_js", (String) null, (String) null, (JSONObject) null, (JSONObject) null, (Boolean) null, (JSONObject) null, (JSONObject) null, 254, (DefaultConstructorMarker) null);
                                    String str5 = resUrl;
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("res_url", str5);
                                    jSONObject.put("is_success", z2);
                                    jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str2 == null ? "" : str2);
                                    jSONObject.put("version", str3 == null ? "" : str3);
                                    jSONObject.put("md5", str4 != null ? str4 : "");
                                    reportInfo.setCategory(jSONObject);
                                    iMonitorReportService.report(reportInfo);
                                }
                                if (!z2 || str == null) {
                                    return;
                                }
                                annieXJSWorkerManager.createAnnieXJSWorkerAndRunJs(application, str);
                                AnnieXJSWorkerManager annieXJSWorkerManager2 = AnnieXJSWorkerManager.INSTANCE;
                                AnnieXJSWorkerManager.isInit = true;
                            }
                        });
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchJSFromGeckoV2(String url, final RequestParams params, final Function5<? super Boolean, ? super String, ? super String, ? super String, ? super String, Unit> callback) {
        if (IConditionCallKt.enableAnnieXFixDownloadWorkerJSByCDN()) {
            ForestLoader.loadAsync$default(ForestLoader.INSTANCE, (Forest) null, url, "ttnet", Scene.OTHER, UUID.randomUUID().toString(), (TaskConfig) null, false, new Function1<RequestParams, Unit>() { // from class: com.bytedance.android.anniex.worker.AnnieXJSWorkerManager$fetchJSFromGeckoV2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((RequestParams) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(RequestParams requestParams) {
                    Intrinsics.checkNotNullParameter(requestParams, "_params");
                    requestParams.setOnlyLocal(params.getOnlyLocal());
                    requestParams.setNetWorker(params.getNetWorker());
                }
            }, new Function1<Response, Unit>() { // from class: com.bytedance.android.anniex.worker.AnnieXJSWorkerManager$fetchJSFromGeckoV2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Response) obj);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:12:0x0084  */
                /* JADX WARN: Removed duplicated region for block: B:9:0x0055  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke(Response response) {
                    byte[] bArr;
                    String str;
                    String str2;
                    Intrinsics.checkNotNullParameter(response, "response");
                    String sb = new StringBuilder().append(response.getErrorInfo().getErrorCode()).append(response.getErrorInfo()).toString();
                    try {
                        bArr = response.provideBytes();
                        if (bArr != null) {
                            try {
                                str2 = new String(bArr, Charsets.UTF_8);
                            } catch (Exception e) {
                                e = e;
                                String message = e.getMessage();
                                if (message != null) {
                                    HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieXJSWorkerManager", message, (Map) null, (LoggerContext) null, 12, (Object) null);
                                    sb = message;
                                }
                                str = null;
                                if (str == null) {
                                }
                            }
                        } else {
                            str2 = null;
                        }
                        str = str2;
                    } catch (Exception e2) {
                        e = e2;
                        bArr = null;
                    }
                    if (str == null) {
                        AnnieXJSWorkerManager.CompareResult compareMD5 = bArr != null ? AnnieXJSWorkerManager.INSTANCE.compareMD5(bArr) : null;
                        if (compareMD5 != null && true == compareMD5.getIsComparePass()) {
                            callback.invoke(true, str, (Object) null, String.valueOf(response.getVersion()), compareMD5.getActualMD5());
                            return;
                        } else {
                            HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieXJSWorkerManager", "js file md5 check failed", (Map) null, (LoggerContext) null, 12, (Object) null);
                            callback.invoke(false, (Object) null, "js file md5 check failed", String.valueOf(response.getVersion()), compareMD5 != null ? compareMD5.getActualMD5() : null);
                            return;
                        }
                    }
                    HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieXJSWorkerManager", "fetch js from gecko failed", (Map) null, (LoggerContext) null, 12, (Object) null);
                    callback.invoke(false, (Object) null, "fetch js from gecko failed msg: " + sb, (Object) null, (Object) null);
                }
            }, 97, (Object) null);
        } else {
            fetchJSFromGecko(url, params, callback);
        }
    }

    private final void fetchJSFromGecko(String url, RequestParams params, final Function5<? super Boolean, ? super String, ? super String, ? super String, ? super String, Unit> callback) {
        Forest forest = ForestLoader.INSTANCE.getDefault();
        if (forest != null) {
            forest.fetchResourceAsync(url, params, new Function1<Response, Unit>() { // from class: com.bytedance.android.anniex.worker.AnnieXJSWorkerManager$fetchJSFromGecko$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Response) obj);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:12:0x0084  */
                /* JADX WARN: Removed duplicated region for block: B:9:0x0055  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke(Response response) {
                    byte[] bArr;
                    String str;
                    String str2;
                    Intrinsics.checkNotNullParameter(response, "response");
                    String sb = new StringBuilder().append(response.getErrorInfo().getErrorCode()).append(response.getErrorInfo()).toString();
                    try {
                        bArr = response.provideBytes();
                        if (bArr != null) {
                            try {
                                str2 = new String(bArr, Charsets.UTF_8);
                            } catch (Exception e) {
                                e = e;
                                String message = e.getMessage();
                                if (message != null) {
                                    HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieXJSWorkerManager", message, (Map) null, (LoggerContext) null, 12, (Object) null);
                                    sb = message;
                                }
                                str = null;
                                if (str == null) {
                                }
                            }
                        } else {
                            str2 = null;
                        }
                        str = str2;
                    } catch (Exception e2) {
                        e = e2;
                        bArr = null;
                    }
                    if (str == null) {
                        AnnieXJSWorkerManager.CompareResult compareMD5 = bArr != null ? AnnieXJSWorkerManager.INSTANCE.compareMD5(bArr) : null;
                        if (compareMD5 != null && true == compareMD5.getIsComparePass()) {
                            callback.invoke(true, str, (Object) null, String.valueOf(response.getVersion()), compareMD5.getActualMD5());
                            return;
                        } else {
                            HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieXJSWorkerManager", "js file md5 check failed", (Map) null, (LoggerContext) null, 12, (Object) null);
                            callback.invoke(false, (Object) null, "js file md5 check failed", String.valueOf(response.getVersion()), compareMD5 != null ? compareMD5.getActualMD5() : null);
                            return;
                        }
                    }
                    HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieXJSWorkerManager", "fetch js from gecko failed", (Map) null, (LoggerContext) null, 12, (Object) null);
                    callback.invoke(false, (Object) null, "fetch js from gecko failed msg: " + sb, (Object) null, (Object) null);
                }
            });
        }
    }

    /* compiled from: AnnieXJSWorkerManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/worker/AnnieXJSWorkerManager$CompareResult;", "", "isComparePass", "", "actualMD5", "", "(ZLjava/lang/String;)V", "getActualMD5", "()Ljava/lang/String;", "()Z", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class CompareResult {
        private final String actualMD5;
        private final boolean isComparePass;

        public CompareResult(boolean z, String str) {
            Intrinsics.checkNotNullParameter(str, "actualMD5");
            this.isComparePass = z;
            this.actualMD5 = str;
        }

        public final String getActualMD5() {
            return this.actualMD5;
        }

        /* renamed from: isComparePass, reason: from getter */
        public final boolean getIsComparePass() {
            return this.isComparePass;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CompareResult compareMD5(byte[] data) {
        if (!IConditionCallKt.enableAnnieXWorkerMd5Check()) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "anniex worker md5 check not enable", (Map) null, (LoggerContext) null, 12, (Object) null);
            return new CompareResult(true, "");
        }
        String md5 = MD5Utils.INSTANCE.getMD5(new ByteArrayInputStream(data));
        List<String> list = getaMD5CheckList();
        if (list != null) {
            for (String str : list) {
                if (StringsKt.equals(md5, str, true)) {
                    HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "compareMD5 true bundle.js md5:" + str, (Map) null, (LoggerContext) null, 12, (Object) null);
                    return new CompareResult(true, md5);
                }
            }
        }
        if (BulletEnv.Companion.getInstance().getDebuggable()) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "compareMD5 always true in debuggable env", (Map) null, (LoggerContext) null, 12, (Object) null);
            return new CompareResult(true, md5);
        }
        HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "compareMD5 failed", (Map) null, (LoggerContext) null, 12, (Object) null);
        return new CompareResult(false, md5);
    }

    private final List<String> getaMD5CheckList() {
        ClientAiConfig clientAiConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        List<String> workerJsFileMd5CheckList = (iBulletSettingsService == null || (clientAiConfig = (ClientAiConfig) iBulletSettingsService.obtainSettings(ClientAiConfig.class)) == null) ? null : clientAiConfig.getWorkerJsFileMd5CheckList();
        List<String> list = workerJsFileMd5CheckList;
        return list == null || list.isEmpty() ? CollectionsKt.listOf(new String[]{"84c1a41d47b9a3b566656c5d0fd24703", "c63c98481074b27fbf0c4b45553f05d5"}) : workerJsFileMd5CheckList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createAnnieXJSWorkerAndRunJs(Context context, String jsBundle) {
        BulletSettings provideBulletSettings;
        AnnieXJSWorker annieXJSWorker2 = new AnnieXJSWorker(context);
        annieXJSWorker = annieXJSWorker2;
        annieXJSWorker2.startWorker();
        ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
        AnnieXJSWorker annieXJSWorker3 = null;
        String resUrl = (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? null : provideBulletSettings.getResUrl();
        AnnieXJSWorker annieXJSWorker4 = annieXJSWorker;
        if (annieXJSWorker4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("annieXJSWorker");
        } else {
            annieXJSWorker3 = annieXJSWorker4;
        }
        annieXJSWorker3.loadScripts$anniex_release(jsBundle);
        IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo("create_anniex_worker_success", (String) null, (String) null, (JSONObject) null, (JSONObject) null, (Boolean) null, (JSONObject) null, (JSONObject) null, 254, (DefaultConstructorMarker) null);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("res_url", resUrl);
            reportInfo.setCategory(jSONObject);
            iMonitorReportService.report(reportInfo);
        }
    }

    public final String getMainTemplateWithoutQuery(String url) {
        Intrinsics.checkNotNullParameter(url, StreamTrafficObservable.STREAM_URL);
        String uri = Uri.parse(url).buildUpon().clearQuery().build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "newUri.toString()");
        return uri;
    }

    public final void postFirstVisibleEvent$anniex_release(final String url, final String bid, final KitType kitType) {
        Intrinsics.checkNotNullParameter(url, StreamTrafficObservable.STREAM_URL);
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(kitType, "kitType");
        if (Intrinsics.areEqual(enableAnnieXWorker(), false)) {
            return;
        }
        Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.worker.AnnieXJSWorkerManager$postFirstVisibleEvent$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                String str;
                AnnieXJSWorkerManager annieXJSWorkerManager = AnnieXJSWorkerManager.INSTANCE;
                Uri parse = Uri.parse(url);
                Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
                String mainTemplateWithoutQuery = annieXJSWorkerManager.getMainTemplateWithoutQuery(String.valueOf(AnnieXWebModelBuilderKt.getSubUrl(parse)));
                KitType kitType2 = kitType;
                if (kitType2 == KitType.WEB) {
                    str = "web";
                } else {
                    if (kitType2 != KitType.LYNX) {
                        HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieXJSWorkerManager", "kit_type:" + kitType2 + " can not be identified!", (Map) null, (LoggerContext) null, 12, (Object) null);
                        return;
                    }
                    str = "lynx";
                }
                HashMap hashMap = new HashMap();
                String str2 = bid;
                hashMap.put("current_page_url", mainTemplateWithoutQuery);
                hashMap.put("engine_type", str);
                hashMap.put("bid", str2);
                Event event = new Event("page_first_visiable", System.currentTimeMillis(), (XReadableMap) null, 4, (DefaultConstructorMarker) null);
                HashMap hashMap2 = hashMap;
                event.setMapParams(hashMap2);
                EventCenter.enqueueEvent(event);
                AnnieXJSWorkerManager.INSTANCE.reportPageVisibleEvent("page_first_visiable", hashMap2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportPageVisibleEvent(String eventName, Map<String, ? extends Object> map) {
        ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
        BulletSettings provideBulletSettings = iSettingService != null ? iSettingService.provideBulletSettings() : null;
        if (!(provideBulletSettings != null && provideBulletSettings.getEnableNaEventReport())) {
            if (!(provideBulletSettings != null && true == provideBulletSettings.getEnablePageEventReport())) {
                return;
            }
        }
        IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo(eventName, (String) null, (String) null, (JSONObject) null, (JSONObject) null, (Boolean) null, (JSONObject) null, (JSONObject) null, 254, (DefaultConstructorMarker) null);
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.put("is_worker_ready", isInit);
            reportInfo.setCategory(jSONObject);
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void postDestroyEvent$anniex_release(final String url) {
        Intrinsics.checkNotNullParameter(url, StreamTrafficObservable.STREAM_URL);
        if (Intrinsics.areEqual(enableAnnieXWorker(), false)) {
            return;
        }
        Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.worker.AnnieXJSWorkerManager$postDestroyEvent$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                AnnieXJSWorkerManager annieXJSWorkerManager = AnnieXJSWorkerManager.INSTANCE;
                Uri parse = Uri.parse(url);
                Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
                String mainTemplateWithoutQuery = annieXJSWorkerManager.getMainTemplateWithoutQuery(String.valueOf(AnnieXWebModelBuilderKt.getSubUrl(parse)));
                HashMap hashMap = new HashMap();
                hashMap.put("current_page_url", mainTemplateWithoutQuery);
                Event event = new Event("page_destroy", System.currentTimeMillis(), (XReadableMap) null, 4, (DefaultConstructorMarker) null);
                HashMap hashMap2 = hashMap;
                event.setMapParams(hashMap2);
                EventCenter.enqueueEvent(event);
                AnnieXJSWorkerManager.INSTANCE.reportPageVisibleEvent("page_destroy", hashMap2);
            }
        });
    }

    private final Boolean enableAnnieXWorker() {
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
        if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
            return null;
        }
        return Boolean.valueOf(provideBulletSettings.getAnnieXWorker());
    }
}
