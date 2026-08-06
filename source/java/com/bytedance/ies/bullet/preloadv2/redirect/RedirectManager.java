package com.bytedance.ies.bullet.preloadv2.redirect;

import android.net.Uri;
import android.util.LruCache;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.utils.LoaderUtils;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadLogger;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.ResourceLoaderSettingsConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: RedirectManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0018\u001a\u00020\u0010J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010J0\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010H\u0002J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010H\u0002J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010'J\u001a\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010(\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010*R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006+"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/redirect/RedirectManager;", "", "()V", "DEFAULT_CACHE_SIZE", "", "defaultCache", "", "getDefaultCache", "()Z", "setDefaultCache", "(Z)V", "enable", "getEnable", "setEnable", "mMap", "Landroid/util/LruCache;", "", "getMMap", "()Landroid/util/LruCache;", "mMap$delegate", "Lkotlin/Lazy;", "checkFileExist", "redirectUrl", "getRedirectPath", "url", "putRedirectPath", "", "reportRedirect", "bid", "resUrl", "status", LynxTimingPerformanceReportProcessor.KEY_DURATION, "", "wrapAsset", "path", "wrapFile", "wrapRedirectPath", "filePath", "resourceFrom", "Lcom/bytedance/forest/model/ResourceFrom;", "rawFilePath", "resourceType", "Lcom/bytedance/ies/bullet/service/base/ResourceType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RedirectManager {
    private static final int DEFAULT_CACHE_SIZE = 100;
    private static volatile boolean defaultCache;
    public static final RedirectManager INSTANCE = new RedirectManager();
    private static volatile boolean enable = true;

    /* renamed from: mMap$delegate, reason: from kotlin metadata */
    private static final Lazy mMap = LazyKt.lazy(new Function0<LruCache<String, String>>() { // from class: com.bytedance.ies.bullet.preloadv2.redirect.RedirectManager$mMap$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LruCache<String, String> m544invoke() {
            ResourceLoaderSettingsConfig resourceLoaderSettingsConfig;
            IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
            int globalRedirectCacheSize = (iBulletSettingsService == null || (resourceLoaderSettingsConfig = (ResourceLoaderSettingsConfig) iBulletSettingsService.obtainSettings(ResourceLoaderSettingsConfig.class)) == null) ? 100 : resourceLoaderSettingsConfig.getGlobalRedirectCacheSize();
            PreloadLogger.INSTANCE.m43i("RedirectManager generate cache size " + globalRedirectCacheSize);
            return new LruCache<>(globalRedirectCacheSize);
        }
    });

    private RedirectManager() {
    }

    public final boolean getEnable() {
        return enable;
    }

    public final void setEnable(boolean z) {
        enable = z;
    }

    public final boolean getDefaultCache() {
        return defaultCache;
    }

    public final void setDefaultCache(boolean z) {
        defaultCache = z;
    }

    private final LruCache<String, String> getMMap() {
        return (LruCache) mMap.getValue();
    }

    public final void putRedirectPath(String url, String redirectUrl) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!enable) {
            PreloadLogger.INSTANCE.m43i("RedirectManager disable");
        } else if (redirectUrl != null) {
            PreloadLogger.INSTANCE.m43i("RedirectManager putRedirectPath URL:" + url + ",redirectUrl:" + redirectUrl);
            INSTANCE.getMMap().put(url, redirectUrl);
        }
    }

    public final String getRedirectPath(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!enable) {
            PreloadLogger.INSTANCE.m43i("RedirectManager disable");
            return null;
        }
        String str = getMMap().get(url);
        PreloadLogger.INSTANCE.m43i("RedirectManager getRedirectPath URL:" + url + ",redirectUrl:" + str);
        if (checkFileExist(str)) {
            PreloadLogger.INSTANCE.m43i("RedirectManager file exit,url:" + url);
            return str;
        }
        PreloadLogger.INSTANCE.m43i("RedirectManager file not exit,url:" + url);
        getMMap().remove(url);
        return null;
    }

    public final boolean checkFileExist(String redirectUrl) {
        if (redirectUrl == null) {
            return false;
        }
        if (StringsKt.startsWith$default(redirectUrl, "http", false, 2, (Object) null)) {
            return true;
        }
        if (StringsKt.startsWith$default(redirectUrl, "file", false, 2, (Object) null) && new File(Uri.parse(redirectUrl).getPath()).exists()) {
            return true;
        }
        StringsKt.startsWith$default(redirectUrl, "asset", false, 2, (Object) null);
        return false;
    }

    public final String wrapRedirectPath(String rawFilePath, ResourceType resourceType) {
        Intrinsics.checkNotNullParameter(rawFilePath, "rawFilePath");
        if (resourceType == ResourceType.ASSET) {
            return wrapAsset(rawFilePath);
        }
        if (resourceType == ResourceType.DISK) {
            return wrapFile(rawFilePath);
        }
        return null;
    }

    public final String wrapRedirectPath(String filePath, ResourceFrom resourceFrom) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        try {
            Result.Companion companion = Result.Companion;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (LoaderUtils.INSTANCE.isNotNullOrEmpty(Uri.parse(filePath).getScheme())) {
            return filePath;
        }
        Result.constructor-impl(Unit.INSTANCE);
        if (resourceFrom == ResourceFrom.BUILTIN) {
            return wrapAsset(filePath);
        }
        return wrapFile(filePath);
    }

    private final String wrapAsset(String path) {
        String uri = new Uri.Builder().scheme("asset").authority("").path(path).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "Builder()\n            .s…      .build().toString()");
        return uri;
    }

    private final String wrapFile(String path) {
        if (!StringsKt.contains$default(path, "@", false, 2, (Object) null)) {
            String uri = Uri.fromFile(new File(path)).toString();
            Intrinsics.checkNotNullExpressionValue(uri, "fromFile(File(path)).toString()");
            return uri;
        }
        return "file:///" + path;
    }

    public final void reportRedirect(String bid, String resUrl, String redirectUrl, boolean status, long duration) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(resUrl, "resUrl");
        PreloadLogger.INSTANCE.m43i((status ? "命中" : "错过") + "命中重定向缓存 " + resUrl + ", " + redirectUrl);
        IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo("bdx_redirect_fetch", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
            reportInfo.setUrl(resUrl);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SchemaConstants.QUERY_KEY_RES_URL, resUrl);
            jSONObject.put("redirect_url", redirectUrl == null ? "null" : redirectUrl);
            jSONObject.put("hit", status ? 1 : 0);
            reportInfo.setCategory(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(LynxTimingPerformanceReportProcessor.KEY_DURATION, duration);
            reportInfo.setMetrics(jSONObject2);
            iMonitorReportService.report(reportInfo);
        }
    }
}
