package com.bytedance.ies.bullet.kit.resourceloader;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.GeckoConfig;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.clean.cache.CacheConfig;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.loader.GeckoResLoader;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.model.CheckRequestParamModel;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.net.DefaultNetWork;
import com.bytedance.geckox.net.INetWork;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.geckox.statistic.IStatisticMonitor;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.geckox.utils.ResVersionUtils;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLoggerConstant;
import com.bytedance.ies.bullet.kit.resourceloader.model.RLChannelBundleModel;
import com.bytedance.ies.bullet.service.base.resourceloader.config.CustomLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ILoaderDepender;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.ies.bullet.service.base.resourceloader.config.OnUpdateListener;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ResourceLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: GeckoXDepender.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 H2\u00020\u0001:\u0001HB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J(\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0018H\u0002J\u001c\u0010#\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u001eJ(\u0010$\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010%\u001a\u0004\u0018\u00010\u0018H\u0002J \u0010&\u001a\u00020'2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\"\u0010(\u001a\u0004\u0018\u00010\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u0018H\u0016J*\u0010+\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0018H\u0002J \u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u0016H\u0002J'\u00100\u001a\u0004\u0018\u00010'2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0002\u00101J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J$\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018052\u0006\u0010)\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u00106\u001a\u00020\u0018H\u0016J\u0012\u00107\u001a\u0004\u0018\u0001032\u0006\u00108\u001a\u00020\u0012H\u0002J\u0010\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u0018H\u0002J\u0018\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010>\u001a\u00020?2\b\u0010\"\u001a\u0004\u0018\u00010\u00182\u0006\u0010@\u001a\u00020\u0018H\u0002J\u0010\u0010A\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u0018H\u0002J\u0010\u0010B\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u0018H\u0002J$\u0010C\u001a\u00020\u001c*\u0002032\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J4\u0010E\u001a\u00020\u001c*\u0002032\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00180\u001e2\b\u0010G\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006I"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/GeckoXDepender;", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ILoaderDepender;", "()V", "appFileDir", "Ljava/io/File;", "geckoClientManager", "Lcom/bytedance/ies/bullet/kit/resourceloader/GeckoXClientManager;", "mStatisticMonitor", "Lcom/bytedance/geckox/statistic/IStatisticMonitor;", "service", "Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;", "getService", "()Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;", "setService", "(Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;)V", "buildChannelOptionParams", "Lcom/bytedance/geckox/OptionCheckUpdateParams;", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "listener", "Lcom/bytedance/geckox/listener/GeckoUpdateListener;", "checkIsExists", "", "rootDir", "", "accessKey", "channel", "checkUpdate", "", "channelList", "", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/OnUpdateListener;", "deleteChannel", "extraPrefix", "path", "geckoUpdateHighPriority", "getChannelPath", "outChannel", "getChannelVersion", "", "getGeckoOfflineDir", "offlineDir", "relativePath", "getGeckoResourcePath", SchemaConstants.QUERY_KEY_BUNDLE, "getGeckoXOfflineRootDirFileWithoutAccessKey", "offlineRootDir", "isRelative", "getLatestChannelVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "getNormalGeckoXClient", "Lcom/bytedance/geckox/GeckoClient;", "getPreloadConfigs", "", "getSdkVersion", "initGeckoXMultiClient", "tConfig", "isNeedServerMonitor", "ak", "mergeConfig", "uri", "Landroid/net/Uri;", "parseChannelBundle", "Lcom/bytedance/ies/bullet/kit/resourceloader/model/RLChannelBundleModel;", SchemaConstants.QUERY_KEY_PREFIX, "updateWhenInit", "useGeckoXV4", "checkUpdateMultiV4", "groupType", "checkUpdateTarget", "channels", "group", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GeckoXDepender implements ILoaderDepender {
    public static final String GECKO_HIGH_PRIORITY_GROUP = "high_priority";
    private static final String PREFIX_PATTERN = "/(([^/]+)/([^?]*))";
    public static final String TAG = "GeckoXDepender";
    public static final String TEMP_DEVICE_ID = "000";
    private File appFileDir;
    private final GeckoXClientManager geckoClientManager = new GeckoXClientManager();
    private final IStatisticMonitor mStatisticMonitor = new IStatisticMonitor() { // from class: com.bytedance.ies.bullet.kit.resourceloader.GeckoXDepender$mStatisticMonitor$1
        public final void upload(String str, JSONObject jSONObject) {
            if (TextUtils.isEmpty(str) || jSONObject == null) {
                return;
            }
            Log.d(GeckoXDepender.TAG, "event:" + str + ",data:" + jSONObject);
        }
    };
    public ResourceLoaderService service;

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.ILoaderDepender
    public String getSdkVersion() {
        return "5.1.1.3-bugfix";
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.ILoaderDepender
    public ResourceLoaderService getService() {
        ResourceLoaderService resourceLoaderService = this.service;
        if (resourceLoaderService != null) {
            return resourceLoaderService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("service");
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.ILoaderDepender
    public void setService(ResourceLoaderService resourceLoaderService) {
        Intrinsics.checkNotNullParameter(resourceLoaderService, "<set-?>");
        this.service = resourceLoaderService;
    }

    private final GeckoClient getNormalGeckoXClient(TaskConfig config) {
        if (this.service == null) {
            RLLogger.INSTANCE.m22e("RL实例未初始化，getNormalGeckoXClient未执行");
            return null;
        }
        String accessKey = config.getAccessKey();
        GeckoClient geckoClient = this.geckoClientManager.getGeckoClient(accessKey, getService().getBid());
        if (geckoClient != null) {
            return geckoClient;
        }
        GeckoClient initGeckoXMultiClient = initGeckoXMultiClient(config);
        this.geckoClientManager.putGeckoClient(accessKey, getService().getBid(), initGeckoXMultiClient);
        return initGeckoXMultiClient;
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.ILoaderDepender
    public void checkUpdate(final TaskConfig config, final List<String> channelList, final OnUpdateListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(channelList, "channelList");
        if (this.service == null || !getService().resourceConfigIsInitialized()) {
            RLLogger.INSTANCE.m22e("RL实例未初始化，checkUpdate未执行");
            if (listener != null) {
                listener.onUpdateFailed(channelList, new Throwable("RL实例未初始化，checkUpdate未执行"));
                return;
            }
            return;
        }
        GeckoUpdateListener geckoUpdateListener = new GeckoUpdateListener() { // from class: com.bytedance.ies.bullet.kit.resourceloader.GeckoXDepender$checkUpdate$updateListener$1
            private final String getResPath(String channel) {
                return GeckoXDepender.this.getGeckoOfflineDir(GeckoXDepender.this.getService().getConfig().getGeckoConfig(config.getAccessKey()).getOfflineDir(), config.getAccessKey(), channel);
            }

            public void onUpdateSuccess(UpdatePackage updatePackage, long version) {
                Log.i("GeckoXResLoadStrategy", "onUpdateSuccess channel=" + (updatePackage != null ? updatePackage.getChannel() : null));
                if (updatePackage == null) {
                    OnUpdateListener onUpdateListener = listener;
                    if (onUpdateListener != null) {
                        onUpdateListener.onUpdateFailed(channelList, new IllegalStateException("onUpdateSuccess but updatePackage is NULL"));
                        return;
                    }
                    return;
                }
                String resPath = getResPath(updatePackage.getChannel());
                OnUpdateListener onUpdateListener2 = listener;
                if (onUpdateListener2 != null) {
                    onUpdateListener2.onUpdateSuccess(channelList, resPath);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x0066 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0025 A[SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> requestMap, Map<String, List<UpdatePackage>> responseMap) {
                UpdatePackage updatePackage;
                Object obj;
                boolean z;
                Object obj2;
                super.onCheckServerVersionSuccess(requestMap, responseMap);
                if (responseMap == null || responseMap.isEmpty()) {
                    List<String> list = channelList;
                    TaskConfig taskConfig = config;
                    ArrayList<String> arrayList = new ArrayList();
                    for (Object obj3 : list) {
                        String str = (String) obj3;
                        List<Pair<String, Long>> list2 = requestMap != null ? requestMap.get(taskConfig.getAccessKey()) : null;
                        if (list2 != null) {
                            Iterator<T> it = list2.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    obj2 = it.next();
                                    if (Intrinsics.areEqual(str, ((Pair) obj2).first)) {
                                        break;
                                    }
                                } else {
                                    obj2 = null;
                                    break;
                                }
                            }
                            if (obj2 == null) {
                                z = true;
                                if (!z) {
                                    arrayList.add(obj3);
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                    OnUpdateListener onUpdateListener = listener;
                    List<String> list3 = channelList;
                    for (String str2 : arrayList) {
                        if (onUpdateListener != null) {
                            onUpdateListener.onUpdateFailed(list3, new Throwable("invalid channel"));
                        }
                    }
                    return;
                }
                List<String> list4 = channelList;
                TaskConfig taskConfig2 = config;
                ArrayList<String> arrayList2 = new ArrayList();
                for (Object obj4 : list4) {
                    String str3 = (String) obj4;
                    List<UpdatePackage> list5 = responseMap.get(taskConfig2.getAccessKey());
                    if (list5 != null) {
                        Iterator<T> it2 = list5.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                obj = it2.next();
                                if (Intrinsics.areEqual(((UpdatePackage) obj).getChannel(), str3)) {
                                    break;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        updatePackage = (UpdatePackage) obj;
                    } else {
                        updatePackage = null;
                    }
                    if (!(updatePackage != null)) {
                        arrayList2.add(obj4);
                    }
                }
                OnUpdateListener onUpdateListener2 = listener;
                List<String> list6 = channelList;
                for (String str4 : arrayList2) {
                    if (onUpdateListener2 != null) {
                        onUpdateListener2.onUpdateSuccess(list6, getResPath(str4));
                    }
                }
            }

            public void onUpdateFailed(String channel, Throwable e) {
                OnUpdateListener onUpdateListener = listener;
                if (onUpdateListener != null) {
                    List<String> list = channelList;
                    if (e == null) {
                        e = new Throwable("geckox update failed");
                    }
                    onUpdateListener.onUpdateFailed(list, e);
                }
            }

            public void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> requestMap, Throwable e) {
                OnUpdateListener onUpdateListener = listener;
                if (onUpdateListener != null) {
                    List<String> list = channelList;
                    if (e == null) {
                        e = new Throwable("geckox update failed");
                    }
                    onUpdateListener.onUpdateFailed(list, e);
                }
            }

            public void onDownloadFail(UpdatePackage updatePackage, Throwable e) {
                OnUpdateListener onUpdateListener = listener;
                if (onUpdateListener != null) {
                    List<String> list = channelList;
                    if (e == null) {
                        e = new Throwable("geckox update failed");
                    }
                    onUpdateListener.onUpdateFailed(list, e);
                }
            }

            public void onLocalNewestVersion(LocalPackageModel localPackage) {
                super.onLocalNewestVersion(localPackage);
                OnUpdateListener onUpdateListener = listener;
                if (onUpdateListener != null) {
                    List<String> list = channelList;
                    String channel = localPackage != null ? localPackage.getChannel() : null;
                    if (channel == null) {
                        channel = config.getChannel();
                    }
                    onUpdateListener.onUpdateSuccess(list, getResPath(channel));
                }
            }

            public void onActivateFail(UpdatePackage updatePackage, Throwable e) {
                OnUpdateListener onUpdateListener = listener;
                if (onUpdateListener != null) {
                    List<String> list = channelList;
                    if (e == null) {
                        e = new Throwable("geckox update failed");
                    }
                    onUpdateListener.onUpdateFailed(list, e);
                }
            }

            public void onCheckRequestIntercept(int code, Map<String, List<Pair<String, Long>>> requestMap, Throwable e) {
                super.onCheckRequestIntercept(code, requestMap, e);
                OnUpdateListener onUpdateListener = listener;
                if (onUpdateListener != null) {
                    List<String> list = channelList;
                    if (e == null) {
                        e = new Throwable("geckox request intercept");
                    }
                    onUpdateListener.onUpdateFailed(list, e);
                }
            }
        };
        GeckoClient normalGeckoXClient = getNormalGeckoXClient(config);
        if (normalGeckoXClient != null) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new CheckRequestBodyModel.TargetChannel(channelList.get(0)));
            HashMap hashMap2 = hashMap;
            hashMap2.put(config.getAccessKey(), arrayList);
            RLLogger.INSTANCE.m21d("GeckoXDepender checkUpdate:config= " + config + ",channel=" + channelList.get(0));
            normalGeckoXClient.checkUpdateMulti((String) null, hashMap2, buildChannelOptionParams(config, geckoUpdateListener));
            return;
        }
        RLLogger.INSTANCE.m21d("GeckoXDepender checkUpdate:config= " + config + ",channel=" + channelList.get(0) + " failed,create client fail");
        if (listener != null) {
            listener.onUpdateFailed(channelList, new Throwable("GeckoXClient is null"));
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.ILoaderDepender
    public void deleteChannel(TaskConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (this.service == null || !getService().resourceConfigIsInitialized()) {
            RLLogger.INSTANCE.m22e("RL实例未初始化，deleteChannel未执行");
            return;
        }
        GeckoConfig geckoConfig = getService().getConfig().getGeckoConfig(config.getAccessKey());
        RLLogger.INSTANCE.m21d("GeckoXDepender deleteChannel:config= " + config);
        ResLoadUtils.deleteChannel(getGeckoXOfflineRootDirFileWithoutAccessKey(geckoConfig.getOfflineDir(), config.getAccessKey(), geckoConfig.getIsRelativePath()), config.getAccessKey(), config.getChannel());
    }

    private final OptionCheckUpdateParams buildChannelOptionParams(TaskConfig config, GeckoUpdateListener listener) {
        OptionCheckUpdateParams listener2 = new OptionCheckUpdateParams().setListener(listener);
        Integer dynamic = config.getDynamic();
        OptionCheckUpdateParams requestWhenHasLocalVersion = listener2.setRequestWhenHasLocalVersion(dynamic != null && dynamic.intValue() == 2);
        if (config.getUseInteraction() == 1) {
            requestWhenHasLocalVersion.setChannelUpdatePriority(3);
            requestWhenHasLocalVersion.setEnableThrottle(false);
        }
        Intrinsics.checkNotNullExpressionValue(requestWhenHasLocalVersion, "result");
        return requestWhenHasLocalVersion;
    }

    private final GeckoClient initGeckoXMultiClient(TaskConfig tConfig) {
        INetWork defaultNetWork;
        if (this.service == null || !getService().resourceConfigIsInitialized()) {
            RLLogger.INSTANCE.m22e("RL实例未初始化，initGeckoXMultiClient未执行");
            return null;
        }
        ResourceLoaderConfig config = getService().getConfig();
        Application application = ResourceLoader.INSTANCE.getApplication();
        String did = config.getDid().length() == 0 ? TEMP_DEVICE_ID : config.getDid();
        String accessKey = tConfig.getAccessKey();
        File geckoXOfflineRootDirFileWithoutAccessKey = getGeckoXOfflineRootDirFileWithoutAccessKey(config.getGeckoConfig(accessKey).getOfflineDir(), accessKey, config.getGeckoConfig(accessKey).getIsRelativePath());
        Object networkImpl = config.getGeckoConfig(accessKey).getNetworkImpl();
        if (networkImpl == null) {
            networkImpl = config.getGeckoXNetworkImpl();
        }
        if (networkImpl instanceof INetWork) {
            defaultNetWork = (INetWork) networkImpl;
        } else {
            defaultNetWork = new DefaultNetWork();
        }
        TaskContext taskContext = tConfig.getTaskContext();
        CacheConfig cacheConfig = taskContext != null ? (CacheConfig) taskContext.getDependency(CacheConfig.class) : null;
        try {
            Intrinsics.checkNotNull(application);
            GeckoConfig.Builder resRootDir = new GeckoConfig.Builder(application.getApplicationContext()).host(config.getHost()).appId(Long.parseLong(config.getAppId())).netStack(defaultNetWork).statisticMonitor(this.mStatisticMonitor).needServerMonitor(isNeedServerMonitor(tConfig.getAccessKey())).region(config.getRegion()).accessKey(new String[]{accessKey}).allLocalAccessKeys(new String[]{accessKey}).deviceId(did).isLoopCheck(config.getGeckoConfig(accessKey).getLoopCheck()).resRootDir(geckoXOfflineRootDirFileWithoutAccessKey);
            if (cacheConfig != null) {
                resRootDir.cacheConfig(cacheConfig);
            }
            return GeckoClient.create(resRootDir.build());
        } catch (Exception e) {
            RLLogger.INSTANCE.m21d("GeckoXDepender registerGeckoClientSpi: " + Log.getStackTraceString(e));
            return null;
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.ILoaderDepender
    public String getGeckoOfflineDir(String offlineDir, String accessKey, String relativePath) {
        Intrinsics.checkNotNullParameter(offlineDir, "offlineDir");
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        if (this.service == null || !getService().resourceConfigIsInitialized()) {
            RLLogger.INSTANCE.m22e("RL实例未初始化，getGeckoOfflineDir未执行");
            return null;
        }
        if (!(accessKey.length() == 0)) {
            String str = relativePath;
            if (!(str.length() == 0)) {
                if (StringsKt.indexOf$default(str, "/", 0, false, 6, (Object) null) != 0) {
                    return getChannelPath(getGeckoXOfflineRootDirFileWithoutAccessKey(offlineDir, accessKey, getService().getConfig().getGeckoConfig(accessKey).getIsRelativePath()), accessKey, relativePath);
                }
                StringBuilder sb = new StringBuilder();
                Object[] array = new Regex("/").split(str, 0).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    if (strArr.length <= 1) {
                        return null;
                    }
                    String str2 = strArr[1];
                    int length = strArr.length;
                    for (int i = 2; i < length; i++) {
                        sb.append(File.separator).append(strArr[i]);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        RLLogger.INSTANCE.m21d("GeckoXDepender getGeckoOfflineDir: channel isEmpty");
                        return null;
                    }
                    try {
                        File geckoXOfflineRootDirFileWithoutAccessKey = getGeckoXOfflineRootDirFileWithoutAccessKey(offlineDir, accessKey, getService().getConfig().getGeckoConfig(accessKey).getIsRelativePath());
                        if (!geckoXOfflineRootDirFileWithoutAccessKey.exists()) {
                            geckoXOfflineRootDirFileWithoutAccessKey.mkdirs();
                        }
                        String absolutePath = new File(geckoXOfflineRootDirFileWithoutAccessKey, accessKey).getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "File(rootDir, accessKey).absolutePath");
                        File file = new File(absolutePath, str2);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        String sb2 = sb.toString();
                        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
                        String geckoResourcePath = getGeckoResourcePath(geckoXOfflineRootDirFileWithoutAccessKey, accessKey, str2, sb2);
                        RLLogger.INSTANCE.m21d("GeckoXDepender getChannelPath: rootDir=" + geckoXOfflineRootDirFileWithoutAccessKey.getAbsolutePath() + ",ak=" + accessKey + ",channel=" + str2 + ",result=" + geckoResourcePath + ",bundle=" + ((Object) sb));
                        return geckoResourcePath;
                    } catch (Throwable th) {
                        RLLogger.INSTANCE.m23e("getGeckoOfflineDir failed", th);
                        return null;
                    }
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        RLLogger.INSTANCE.m21d("GeckoXDepender getGeckoOfflineDir: ak=" + accessKey + ",bundle=" + relativePath);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0088, code lost:
    
        if (r0 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getGeckoResourcePath(File rootDir, String accessKey, String channel, String bundle) {
        Throwable th;
        GeckoResLoader geckoResLoader;
        String channelPath;
        if (!StringsKt.endsWith$default(bundle, "/template.js", false, 2, (Object) null)) {
            String channelPath2 = ResLoadUtils.getChannelPath(rootDir, accessKey, channel);
            return bundle.length() > 0 ? channelPath2 + bundle : channelPath2;
        }
        try {
            geckoResLoader = new GeckoResLoader(ResourceLoader.INSTANCE.getApplication(), accessKey);
            try {
                channelPath = geckoResLoader.getBundlePath(channel + File.separator + bundle);
            } catch (Throwable th2) {
                th = th2;
                try {
                    RLLogger.INSTANCE.m23e("GeckoXDepender check file content failed", th);
                    channelPath = ResLoadUtils.getChannelPath(rootDir, accessKey, channel);
                    if (bundle.length() > 0) {
                        channelPath = channelPath + bundle;
                    }
                } catch (Throwable th3) {
                    if (geckoResLoader != null) {
                        geckoResLoader.release();
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            geckoResLoader = null;
        }
        geckoResLoader.release();
        return channelPath;
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.ILoaderDepender
    public Map<String, String> getPreloadConfigs(String offlineDir, String accessKey) {
        File[] listFiles;
        Intrinsics.checkNotNullParameter(offlineDir, "offlineDir");
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        if (this.service == null || !getService().resourceConfigIsInitialized()) {
            RLLogger.INSTANCE.m22e("RL实例未初始化，getPreloadConfigs未执行");
            return new LinkedHashMap();
        }
        File geckoXOfflineRootDirFileWithoutAccessKey = getGeckoXOfflineRootDirFileWithoutAccessKey(offlineDir, accessKey, getService().getConfig().getGeckoConfig(accessKey).getIsRelativePath());
        File file = new File(geckoXOfflineRootDirFileWithoutAccessKey, accessKey);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (file.isDirectory() && file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    String absolutePath = geckoXOfflineRootDirFileWithoutAccessKey.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "rootDir.absolutePath");
                    String name = file2.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "_singleChannelFile.name");
                    Long latestChannelVersion = getLatestChannelVersion(absolutePath, accessKey, name);
                    if ((latestChannelVersion != null ? latestChannelVersion.longValue() : 0L) > 0) {
                        File file3 = new File(file2.getAbsolutePath() + File.separator + latestChannelVersion + File.separator + "res" + File.separator + "preload.json");
                        if (file3.exists() && file3.canRead()) {
                            String name2 = file2.getName();
                            Intrinsics.checkNotNullExpressionValue(name2, "_singleChannelFile.name");
                            String absolutePath2 = file3.getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue(absolutePath2, "preloadJsonFile.absolutePath");
                            linkedHashMap.put(name2, absolutePath2);
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private final String getChannelPath(File rootDir, String accessKey, String outChannel) {
        String str = accessKey;
        if (str == null || str.length() == 0) {
            return null;
        }
        String str2 = outChannel;
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        if (StringsKt.indexOf$default(str2, "/", 0, false, 6, (Object) null) == 0) {
            if (outChannel == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            outChannel = outChannel.substring(1);
            Intrinsics.checkNotNullExpressionValue(outChannel, "(this as java.lang.String).substring(startIndex)");
        }
        String str3 = outChannel;
        if (StringsKt.lastIndexOf$default(str3, "/", 0, false, 6, (Object) null) == outChannel.length() - 1) {
            int lastIndexOf$default = StringsKt.lastIndexOf$default(str3, "/", 0, false, 6, (Object) null);
            if (outChannel == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            outChannel = outChannel.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(outChannel, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        try {
            File file = new File(rootDir, accessKey);
            if (!file.exists()) {
                file.mkdirs();
            }
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            File file2 = new File(absolutePath, outChannel);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            String channelPath = ResLoadUtils.getChannelPath(rootDir, accessKey, outChannel);
            RLLogger.INSTANCE.m21d("GeckoXDepender private getChannelPath:" + channelPath);
            return channelPath;
        } catch (Throwable th) {
            RLLogger.INSTANCE.m23e("getChannelPath failed", th);
            return null;
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.ILoaderDepender
    public boolean checkIsExists(String rootDir, String accessKey, String channel) {
        Intrinsics.checkNotNullParameter(rootDir, "rootDir");
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        Intrinsics.checkNotNullParameter(channel, "channel");
        if (!TextUtils.isEmpty(accessKey) && !TextUtils.isEmpty(channel)) {
            if (this.service != null && getService().resourceConfigIsInitialized()) {
                return getChannelPath(getGeckoXOfflineRootDirFileWithoutAccessKey(rootDir, accessKey, getService().getConfig().getGeckoConfig(accessKey).getIsRelativePath()), accessKey, channel) != null;
            }
            RLLogger.INSTANCE.m22e("RL实例未初始化，checkIsExists未执行");
        }
        return false;
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.ILoaderDepender
    public long getChannelVersion(String rootDir, String accessKey, String channel) {
        Intrinsics.checkNotNullParameter(rootDir, "rootDir");
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        Intrinsics.checkNotNullParameter(channel, "channel");
        if (!TextUtils.isEmpty(accessKey) && !TextUtils.isEmpty(channel)) {
            if (this.service == null || !getService().resourceConfigIsInitialized()) {
                RLLogger.INSTANCE.m22e("RL实例未初始化，getChannelVersion未执行");
            } else {
                String absolutePath = getGeckoXOfflineRootDirFileWithoutAccessKey(rootDir, accessKey, getService().getConfig().getGeckoConfig(accessKey).getIsRelativePath()).getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "getGeckoXOfflineRootDirF…           ).absolutePath");
                Long latestChannelVersion = getLatestChannelVersion(absolutePath, accessKey, channel);
                if (latestChannelVersion != null) {
                    return latestChannelVersion.longValue();
                }
                return 0L;
            }
        }
        return 0L;
    }

    private final Long getLatestChannelVersion(String rootDir, String accessKey, String channel) {
        if (TextUtils.isEmpty(accessKey) || TextUtils.isEmpty(channel)) {
            return null;
        }
        RLLogger.INSTANCE.m21d("GeckoXDepender getLatestChannelVersion:rootdir:" + rootDir + ",accessKey:" + accessKey + ",channel:" + channel);
        try {
            File file = new File(rootDir, accessKey);
            if (!file.exists()) {
                file.mkdirs();
            }
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            File file2 = new File(absolutePath, channel);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            Long latestChannelVersion = ResVersionUtils.getLatestChannelVersion(file2);
            RLLogger.INSTANCE.m21d("getLatestChannelVersion:" + latestChannelVersion);
            return latestChannelVersion;
        } catch (Throwable th) {
            RLLogger.INSTANCE.m23e("getLatestChannelVersion failed", th);
            return null;
        }
    }

    private final boolean isNeedServerMonitor(String ak) {
        if (this.service == null || !getService().resourceConfigIsInitialized()) {
            RLLogger.INSTANCE.m22e("RL实例未初始化，isNeedServerMonitor未执行");
            return true;
        }
        return getService().getConfig().getGeckoConfig(ak).getServerMonitor();
    }

    private final boolean useGeckoXV4(String ak) {
        if (this.service == null || !getService().resourceConfigIsInitialized()) {
            RLLogger.INSTANCE.m22e("RL实例未初始化，useGeckoXV4未执行");
            return true;
        }
        return getService().getConfig().getGeckoConfig(ak).getUseGeckoXV4();
    }

    private final boolean updateWhenInit(String ak) {
        if (this.service == null || !getService().resourceConfigIsInitialized()) {
            RLLogger.INSTANCE.m22e("RL实例未初始化，updateWhenInit未执行");
            return false;
        }
        return getService().getConfig().getGeckoConfig(ak).getUpdateWhenInit();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final File getGeckoXOfflineRootDirFileWithoutAccessKey(String offlineRootDir, String accessKey, boolean isRelative) {
        String str = (String) GeckoGlobalManager.inst().getAccessKeyDirs().get(accessKey);
        if (str != null) {
            if (str.length() > 0) {
                isRelative = false;
                if (isRelative) {
                    return new File(str);
                }
                if (this.appFileDir == null) {
                    Application application = ResourceLoader.INSTANCE.getApplication();
                    Intrinsics.checkNotNull(application);
                    this.appFileDir = application.getFilesDir();
                }
                try {
                    File file = new File(this.appFileDir, str);
                    if (file.exists()) {
                        return file;
                    }
                    file.mkdirs();
                    return file;
                } catch (Exception unused) {
                    return new File(offlineRootDir);
                }
            }
        }
        str = offlineRootDir;
        if (isRelative) {
        }
    }

    public final void geckoUpdateHighPriority(TaskConfig config, List<String> channelList) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(channelList, "channelList");
        GeckoUpdateListener geckoUpdateListener = new GeckoUpdateListener() { // from class: com.bytedance.ies.bullet.kit.resourceloader.GeckoXDepender$geckoUpdateHighPriority$geckoUpdateListener$1
        };
        GeckoClient normalGeckoXClient = getNormalGeckoXClient(config);
        if (normalGeckoXClient == null || !updateWhenInit(config.getAccessKey())) {
            return;
        }
        GeckoUpdateListener geckoUpdateListener2 = geckoUpdateListener;
        checkUpdateTarget(normalGeckoXClient, config.getAccessKey(), channelList, config.getGroup(), geckoUpdateListener2);
        checkUpdateMultiV4(normalGeckoXClient, config.getAccessKey(), GECKO_HIGH_PRIORITY_GROUP, geckoUpdateListener2);
    }

    private final void checkUpdateTarget(GeckoClient geckoClient, String str, List<String> list, String str2, GeckoUpdateListener geckoUpdateListener) {
        if (this.service == null || !getService().resourceConfigIsInitialized()) {
            RLLogger.INSTANCE.m22e("RL实例未初始化，checkUpdateTarget未执行");
            return;
        }
        if (list.isEmpty()) {
            return;
        }
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new CheckRequestBodyModel.TargetChannel((String) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        OptionCheckUpdateParams listener = new OptionCheckUpdateParams().setListener(geckoUpdateListener);
        if (useGeckoXV4(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(str, new CheckRequestParamModel(str2, arrayList2));
            HashMap hashMap2 = new HashMap();
            hashMap2.put(str, getService().getConfig().getAppVersion());
            geckoClient.registerCheckUpdate(hashMap, listener, hashMap2);
            return;
        }
        geckoClient.checkUpdateMulti(str2, geckoUpdateListener, MapsKt.mapOf(TuplesKt.to(str, arrayList2)));
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.ILoaderDepender
    public TaskConfig mergeConfig(Uri uri, TaskConfig config) {
        String channel;
        String bundlePath;
        List<GlobalConfigSettings.PipelineStep> pipeline;
        GlobalConfigSettings.CDNFallBackConfig cdnFallback;
        Map channels;
        GlobalConfigSettings.ChannelMetaInfo channelMetaInfo;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(config, "config");
        if (this.service == null || !getService().resourceConfigIsInitialized()) {
            RLLogger.INSTANCE.m22e("RL实例未初始化，mergeConfig未执行");
            return new TaskConfig(null, 1, null);
        }
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
        HybridLogger.INSTANCE.m11i("XResourceLoader", "start mergeConfig", MapsKt.mapOf(new kotlin.Pair[]{TuplesKt.to("url", uri.toString()), TuplesKt.to("cdnUri", config.getCdnUrl()), TuplesKt.to("config", config.toString())}), loggerContext);
        TaskConfig from = new TaskConfig(config.getAccessKey()).from(config);
        GlobalConfigSettings globalSettings = GeckoGlobalManager.inst().getGlobalSettings();
        if (globalSettings == null) {
            return from;
        }
        String queryParameter = uri.getQueryParameter(SchemaConstants.QUERY_KEY_RES_URL);
        String str = "";
        if (queryParameter == null) {
            queryParameter = "";
        }
        String queryParameter2 = uri.getQueryParameter(SchemaConstants.QUERY_KEY_SURL);
        if (queryParameter2 == null) {
            queryParameter2 = "";
        }
        if (!(queryParameter.length() > 0)) {
            if (LoaderUtil.INSTANCE.isNotNullOrEmpty(config.getCdnUrl())) {
                queryParameter = config.getCdnUrl();
            } else if (queryParameter2.length() > 0) {
                queryParameter = queryParameter2;
            } else {
                queryParameter = uri.toString();
                Intrinsics.checkNotNullExpressionValue(queryParameter, "{\n                uri.toString()\n            }");
            }
        }
        if (queryParameter.length() == 0) {
            return from;
        }
        String path = Uri.parse(queryParameter).getPath();
        if (path == null) {
            path = "";
        }
        String extraPrefix = extraPrefix(path);
        GlobalConfigSettings.ResourceMeta resourceMeta = globalSettings.getResourceMeta();
        GlobalConfigSettings.CurrentLevelConfig config2 = resourceMeta != null ? resourceMeta.getConfig() : null;
        if (config2 == null) {
            return from;
        }
        Map<String, String> defaultPrefix2Ak = getService().getConfig().getDefaultPrefix2Ak();
        Map prefix2AccessKey = config2.getPrefix2AccessKey();
        String str2 = prefix2AccessKey != null ? (String) prefix2AccessKey.get(extraPrefix) : null;
        String str3 = str2;
        if (str3 == null || str3.length() == 0) {
            str2 = defaultPrefix2Ak.get(extraPrefix);
        }
        String str4 = str2;
        if (str4 == null || str4.length() == 0) {
            RLLogger.INSTANCE.m21d("GeckoXDepender mergeConfig:ak is Null or Empty,prefix = " + extraPrefix);
            return from;
        }
        GlobalConfigSettings.CurrentLevelConfig config3 = globalSettings.getResourceMeta().getConfig();
        GlobalConfigSettings.AccessKeyMetaInfo accessKeyMetaInfo = (GlobalConfigSettings.AccessKeyMetaInfo) globalSettings.getResourceMeta().getAccessKeys().get(str2);
        GlobalConfigSettings.CurrentLevelConfig config4 = accessKeyMetaInfo != null ? accessKeyMetaInfo.getConfig() : null;
        RLChannelBundleModel parseChannelBundle = parseChannelBundle(queryParameter, extraPrefix);
        GlobalConfigSettings.CurrentLevelConfig config5 = (accessKeyMetaInfo == null || (channels = accessKeyMetaInfo.getChannels()) == null || (channelMetaInfo = (GlobalConfigSettings.ChannelMetaInfo) channels.get(parseChannelBundle.getChannel())) == null) ? null : channelMetaInfo.getConfig();
        if (parseChannelBundle.getChannel().length() == 0) {
            channel = config.getChannel();
        } else {
            channel = parseChannelBundle.getChannel();
        }
        from.setChannel(channel);
        if (parseChannelBundle.getBundlePath().length() == 0) {
            bundlePath = config.getBundle();
        } else {
            bundlePath = parseChannelBundle.getBundlePath();
        }
        from.setBundle(bundlePath);
        from.setAccessKey(str2);
        if (config5 == null || (pipeline = config5.getPipeline()) == null) {
            pipeline = config4 != null ? config4.getPipeline() : null;
            if (pipeline == null) {
                pipeline = config3.getPipeline();
            }
        }
        if (pipeline != null && (!pipeline.isEmpty())) {
            CustomLoaderConfig customLoaderConfig = new CustomLoaderConfig(true);
            customLoaderConfig.setPriorityHigh(config.getLoaderConfig().getPriorityHigh());
            customLoaderConfig.setPriorityLow(config.getLoaderConfig().getPriorityLow());
            customLoaderConfig.setRemovedLoader(config.getLoaderConfig().getRemovedLoader());
            from.setLoaderConfig(customLoaderConfig);
            List<LoaderType> loaderSequence = from.getLoaderConfig().getLoaderSequence();
            loaderSequence.clear();
            for (GlobalConfigSettings.PipelineStep pipelineStep : pipeline) {
                if (pipelineStep != null) {
                    str = str + pipelineStep.getType() + StringListParam.SPLIT_DELIMITER;
                    int type = pipelineStep.getType();
                    if (type == 1) {
                        loaderSequence.add(LoaderType.GECKO);
                        from.setDynamic(Integer.valueOf(pipelineStep.getUpdate()));
                    } else if (type == 2) {
                        loaderSequence.add(LoaderType.CDN);
                        from.setCdnNoCache(pipelineStep.getNoCache() == 1);
                    } else if (type == 3) {
                        loaderSequence.add(LoaderType.BUILTIN);
                    }
                }
            }
            if (Intrinsics.areEqual(config.getResTag(), "sub_resource")) {
                loaderSequence.remove(LoaderType.CDN);
            }
        }
        if (config5 == null || (cdnFallback = config5.getCdnFallback()) == null) {
            GlobalConfigSettings.CDNFallBackConfig cdnFallback2 = config4 != null ? config4.getCdnFallback() : null;
            cdnFallback = cdnFallback2 == null ? config3.getCdnFallback() : cdnFallback2;
        }
        if (cdnFallback != null && cdnFallback.getDomains() != null) {
            List<String> domains = cdnFallback.getDomains();
            Intrinsics.checkNotNullExpressionValue(domains, "fallbackConfig.domains");
            from.setFallbackDomains(domains);
            from.setLoadRetryTimes(cdnFallback.getMaxAttempts());
            from.setShuffle(cdnFallback.getShuffle());
        }
        HybridLogger.INSTANCE.m11i("XResourceLoader", "show mergeConfig result", MapsKt.mapOf(new kotlin.Pair[]{TuplesKt.to("url", uri.toString()), TuplesKt.to("ppl", str), TuplesKt.to(CDNLoader.DIAGNOSE_SOURCE_URL, queryParameter), TuplesKt.to(SchemaConstants.QUERY_KEY_PREFIX, extraPrefix), TuplesKt.to("channel", from.getChannel()), TuplesKt.to(SchemaConstants.QUERY_KEY_BUNDLE, from.getBundle()), TuplesKt.to("result", from.toString())}), loggerContext);
        from.setFromRemoteConfig(true);
        return from;
    }

    private final RLChannelBundleModel parseChannelBundle(String path, String prefix) {
        String str = "";
        RLChannelBundleModel rLChannelBundleModel = new RLChannelBundleModel("", "", false);
        if (LoaderUtil.INSTANCE.isNotNullOrEmpty(path) && LoaderUtil.INSTANCE.isNotNullOrEmpty(prefix)) {
            try {
                Pattern compile = Pattern.compile(prefix + PREFIX_PATTERN);
                if (path == null) {
                    path = "";
                }
                Matcher matcher = compile.matcher(path);
                if (matcher.find() && matcher.groupCount() == 3) {
                    String group = matcher.group(2);
                    String group2 = matcher.group(3);
                    if (LoaderUtil.INSTANCE.isNotNullOrEmpty(group) && LoaderUtil.INSTANCE.isNotNullOrEmpty(group2)) {
                        if (group == null) {
                            group = "";
                        }
                        rLChannelBundleModel.setChannel(group);
                        if (group2 != null) {
                            str = group2;
                        }
                        rLChannelBundleModel.setBundlePath(str);
                        rLChannelBundleModel.setValid(true);
                    }
                }
            } catch (Exception e) {
                Log.w(TAG, "ChannelBundleModel parse error: " + e.getMessage());
            }
        }
        return rLChannelBundleModel;
    }

    private final String extraPrefix(String path) {
        List split$default = StringsKt.split$default(path, new String[]{"/"}, false, 0, 6, (Object) null);
        return (split$default.isEmpty() || split$default.size() < 6) ? "" : "/" + ((String) split$default.get(1)) + '/' + ((String) split$default.get(2)) + '/' + ((String) split$default.get(3)) + '/' + ((String) split$default.get(4)) + '/' + ((String) split$default.get(5));
    }

    private final void checkUpdateMultiV4(GeckoClient geckoClient, String str, String str2, GeckoUpdateListener geckoUpdateListener) {
        if (this.service == null || !getService().resourceConfigIsInitialized()) {
            RLLogger.INSTANCE.m22e("RL实例未初始化，checkUpdateMultiV4未执行");
            return;
        }
        OptionCheckUpdateParams listener = new OptionCheckUpdateParams().setListener(geckoUpdateListener);
        if (useGeckoXV4(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(str, new CheckRequestParamModel(str2));
            HashMap hashMap2 = new HashMap();
            hashMap2.put(str, getService().getConfig().getAppVersion());
            geckoClient.registerCheckUpdate(hashMap, listener, hashMap2);
            return;
        }
        geckoClient.checkUpdateMulti(str2, geckoUpdateListener);
    }
}
