package com.bytedance.ies.bullet.kit.resourceloader;

import android.app.Application;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLoggerConstant;
import com.bytedance.ies.bullet.kit.resourceloader.model.ResourceLoaderEnvData;
import com.bytedance.ies.bullet.kit.resourceloader.model.ResourceLoaderType;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.secure.HybridSecureUtil;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ICdnDownloadDepender;
import com.bytedance.ies.bullet.service.base.resourceloader.config.RLDownLoadInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.RLDownloaderListener;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: DownloaderDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016JR\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J$\u0010\u001f\u001a\u0004\u0018\u00010\f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH\u0002J\b\u0010$\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/DownloaderDepend;", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ICdnDownloadDepender;", "()V", "cacheMaxTime", "", "checkExpired", "", "info", "Lcom/ss/android/socialbase/downloader/model/DownloadInfo;", CDNLoader.STEP_NAME_DOWNLOAD_RESOURCE_FILE, "", CDNLoader.DIAGNOSE_SOURCE_URL, "", "syncCall", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "listener", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/RLDownloaderListener;", "downloadWithDownloader", "application", "Landroid/app/Application;", "savePath", "name", "onlyLocal", "destination", "Ljava/io/File;", "index", "", "getExtraHeaders", "", "Lcom/ss/android/socialbase/downloader/model/HttpHeader;", "getMutableCdnURL", PrefetchRequestConfig.PARAM_TYPE_ENV, "Lcom/bytedance/ies/bullet/kit/resourceloader/model/ResourceLoaderEnvData;", "url", "rlSessionId", "isMainThread", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DownloaderDepend implements ICdnDownloadDepender {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEFAULT_MAX_CACHE_TIME = 14;
    public static final String DIR_NAME = "rl_resource_offline";
    public static final String DOWNLOAD_SCENE = "XResourceLoader";
    public static final String TAG = "res-DownloaderDepend";
    private static final Method methodSetCacheLifeMaxTime;
    private final long cacheMaxTime;

    /* compiled from: DownloaderDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/DownloaderDepend$Companion;", "", "()V", "DEFAULT_MAX_CACHE_TIME", "", "DIR_NAME", "", "DOWNLOAD_SCENE", "TAG", "methodSetCacheLifeMaxTime", "Ljava/lang/reflect/Method;", "getMethodSetCacheLifeMaxTime", "()Ljava/lang/reflect/Method;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Method getMethodSetCacheLifeMaxTime() {
            return DownloaderDepend.methodSetCacheLifeMaxTime;
        }
    }

    public DownloaderDepend() {
        int i;
        BulletSettings provideBulletSettings;
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService != null && (provideBulletSettings = iSettingService.provideBulletSettings()) != null) {
            Integer valueOf = Integer.valueOf(provideBulletSettings.getCdnCacheMaxAge());
            valueOf = valueOf.intValue() > 0 ? valueOf : null;
            if (valueOf != null) {
                i = valueOf.intValue();
                this.cacheMaxTime = i * 24 * 60 * 60;
            }
        }
        i = 14;
        this.cacheMaxTime = i * 24 * 60 * 60;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        DefaultConstructorMarker defaultConstructorMarker;
        try {
            Result.Companion companion = Result.Companion;
            defaultConstructorMarker = Result.constructor-impl(DownloadTask.class.getDeclaredMethod("setCacheLifeTimeMax", Long.TYPE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            defaultConstructorMarker = Result.constructor-impl(ResultKt.createFailure(th));
        }
        methodSetCacheLifeMaxTime = (Method) (Result.isFailure-impl(defaultConstructorMarker) ? null : defaultConstructorMarker);
    }

    private final boolean isMainThread() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    private final boolean checkExpired(DownloadInfo info) {
        if (info == null || info.getCacheExpiredTime() <= 0) {
            return true;
        }
        if (System.currentTimeMillis() > info.getCacheExpiredTime()) {
            RLLogger.INSTANCE.m24w("DownloaderDepend checkExpired was expired url == " + info.getUrl());
        }
        return System.currentTimeMillis() > info.getCacheExpiredTime();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0094, code lost:
    
        if (r13 != null) goto L38;
     */
    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.ICdnDownloadDepender
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void downloadResourceFile(String sourceUrl, boolean syncCall, TaskConfig config, RLDownloaderListener listener) {
        String str;
        boolean areEqual;
        String encodedPath;
        String extension;
        Intrinsics.checkNotNullParameter(sourceUrl, CDNLoader.DIAGNOSE_SOURCE_URL);
        Intrinsics.checkNotNullParameter(config, "config");
        Application application = ResourceLoader.INSTANCE.getApplication();
        if (application == null) {
            if (listener != null) {
                listener.onFailed("cdn application null");
                return;
            }
            return;
        }
        if (sourceUrl.length() == 0) {
            if (listener != null) {
                listener.onFailed("cdn Surl Empty");
                return;
            }
            return;
        }
        File file = new File(application.getCacheDir(), DIR_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }
        Uri parse = Uri.parse(sourceUrl);
        if (!parse.isHierarchical()) {
            if (listener != null) {
                listener.onFailed("cdn Url is not Hierarchical");
                return;
            }
            return;
        }
        String md5Hex = ResourceLoaderUtils.INSTANCE.md5Hex(sourceUrl);
        Uri uri = parse.isHierarchical() ? parse : null;
        if (uri != null && (encodedPath = uri.getEncodedPath()) != null && (extension = FilesKt.getExtension(new File(encodedPath))) != null) {
            str = TextUtils.isEmpty(extension) ^ true ? extension : null;
        }
        str = "jsbundle";
        File file2 = new File(file, md5Hex + '.' + str);
        String queryParameter = parse.getQueryParameter("__dev");
        String str2 = queryParameter;
        if (str2 == null || str2.length() == 0) {
            areEqual = !ResourceLoader.INSTANCE.isDebug();
        } else {
            areEqual = Intrinsics.areEqual(queryParameter, ViewVisibleBridge.INVISIBLE);
        }
        boolean z = areEqual && !config.getCdnNoCache();
        RLLogger.INSTANCE.m24w("CDNLoader start to get download info, uri=" + sourceUrl + ", syncCall=" + syncCall);
        DownloadInfo downloadInfo = Downloader.getInstance(application).getDownloadInfo(sourceUrl, file.getPath());
        RLLogger.INSTANCE.m24w("CDNLoader finish to get download info, uri=" + sourceUrl + ", syncCall=" + syncCall);
        if ((!z || downloadInfo == null) && file2.exists()) {
            file2.delete();
        }
        boolean z2 = config.getOnlyLocal() || Intrinsics.areEqual(parse.getQueryParameter("onlyLocal"), "1") || (isMainThread() && syncCall);
        RLLogger.INSTANCE.m24w("DownloaderDepend start download url=" + sourceUrl + ",targetPath=" + file2 + ",useCache=" + z + ",onlyLocal=" + z2);
        if (z2) {
            if (z && file2.exists() && !checkExpired(downloadInfo)) {
                if (listener != null) {
                    String absolutePath = file2.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "destination.absolutePath");
                    listener.onSuccess(new RLDownLoadInfo(absolutePath, true));
                }
            } else if (listener != null) {
                listener.onFailed("cdn: only local");
            }
        } else if (z && file2.exists() && !checkExpired(downloadInfo) && !Intrinsics.areEqual(parse.getQueryParameter("cdn_negotiate"), "1")) {
            RLLogger.INSTANCE.m24w("DownloaderDepend success by cache url=" + sourceUrl);
            if (listener != null) {
                String absolutePath2 = file2.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath2, "destination.absolutePath");
                listener.onSuccess(new RLDownLoadInfo(absolutePath2, true));
                return;
            }
            return;
        }
        try {
            LoaderUtil loaderUtil = LoaderUtil.INSTANCE;
            String path = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "parent.path");
            if (!loaderUtil.checkFileExists(path)) {
                LoaderUtil.INSTANCE.createFile(file.getPath(), false);
            }
            String path2 = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "parent.path");
            downloadWithDownloader(application, sourceUrl, config, path2, md5Hex + '.' + str, z2, file2, 0, listener);
        } catch (IOException e) {
            if (listener != null) {
                String message = e.getMessage();
                if (message == null) {
                    message = "";
                }
                listener.onFailed(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(17:1|(5:3|(1:5)(1:54)|6|(1:8)|9)(1:55)|10|(1:12)(1:53)|13|(6:15|(1:17)(1:51)|18|(1:20)(1:50)|21|(3:23|(1:25)(1:48)|(10:28|29|(1:47)(1:33)|34|35|36|(1:38)(1:44)|39|40|41)))(1:52)|49|29|(1:31)|47|34|35|36|(0)(0)|39|40|41) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x020d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x020e, code lost:
    
        r2 = kotlin.Result.Companion;
        kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01f8 A[Catch: all -> 0x020d, TryCatch #0 {all -> 0x020d, blocks: (B:36:0x01f2, B:38:0x01f8, B:39:0x0209), top: B:35:0x01f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0208  */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void downloadWithDownloader(final Application application, final String sourceUrl, final TaskConfig config, final String savePath, final String name, final boolean onlyLocal, final File destination, final int index, final RLDownloaderListener listener) {
        String str;
        boolean enableNegotiation;
        String str2;
        boolean z;
        String str3;
        int i;
        Method method;
        Object obj;
        String str4;
        String str5;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        if (config.getShuffle() == 1) {
            Uri parse = Uri.parse(sourceUrl);
            if (StringsKt.contains$default(sourceUrl, config.getFallbackDomains().get(index), false, 2, (Object) null)) {
                str5 = sourceUrl;
            } else {
                str5 = new Uri.Builder().scheme(parse.getScheme()).authority(config.getFallbackDomains().get(index)).query(parse.getQuery()).path(parse.getPath()).toString();
                Intrinsics.checkNotNullExpressionValue(str5, "targetUri.toString()");
            }
            if (index + 1 < config.getFallbackDomains().size()) {
                String builder = new Uri.Builder().scheme(parse.getScheme()).authority(config.getFallbackDomains().get(index)).query(parse.getQuery()).path(parse.getPath()).toString();
                Intrinsics.checkNotNullExpressionValue(builder, "Builder().scheme(sourceU…ourceUri.path).toString()");
                objectRef.element = builder;
            }
            str = str5;
        } else {
            str = sourceUrl;
        }
        String str6 = str;
        IDownloadListener iDownloadListener = new AbsDownloadListener(application, onlyLocal, destination, sourceUrl, objectRef, this, config, savePath, name, index) { // from class: com.bytedance.ies.bullet.kit.resourceloader.DownloaderDepend$downloadWithDownloader$downloadListener$1
            final /* synthetic */ Application $application;
            final /* synthetic */ TaskConfig $config;
            final /* synthetic */ File $destination;
            final /* synthetic */ int $index;
            final /* synthetic */ String $name;
            final /* synthetic */ Ref.ObjectRef<String> $nextUrl;
            final /* synthetic */ boolean $onlyLocal;
            final /* synthetic */ String $savePath;
            final /* synthetic */ String $sourceUrl;
            private final WeakReference<RLDownloaderListener> rejectRef;
            private final WeakReference<RLDownloaderListener> resolveRef;
            final /* synthetic */ DownloaderDepend this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$application = application;
                this.$onlyLocal = onlyLocal;
                this.$destination = destination;
                this.$sourceUrl = sourceUrl;
                this.$nextUrl = objectRef;
                this.this$0 = this;
                this.$config = config;
                this.$savePath = savePath;
                this.$name = name;
                this.$index = index;
                this.resolveRef = new WeakReference<>(RLDownloaderListener.this);
                this.rejectRef = new WeakReference<>(RLDownloaderListener.this);
            }

            public final WeakReference<RLDownloaderListener> getResolveRef() {
                return this.resolveRef;
            }

            public final WeakReference<RLDownloaderListener> getRejectRef() {
                return this.rejectRef;
            }

            public void onSuccessed(DownloadInfo entity) {
                Intrinsics.checkNotNullParameter(entity, "entity");
                RLLogger.INSTANCE.m24w("DownloaderDepend download success，" + entity.getUrl());
                Downloader.getInstance(this.$application).removeMainThreadListener(entity.getId(), (IDownloadListener) this);
                if (this.$onlyLocal) {
                    return;
                }
                if (this.$destination.exists()) {
                    RLDownloaderListener rLDownloaderListener = this.resolveRef.get();
                    if (rLDownloaderListener != null) {
                        String absolutePath = this.$destination.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "destination.absolutePath");
                        rLDownloaderListener.onSuccess(new RLDownLoadInfo(absolutePath, entity.isSuccessByCache()));
                        return;
                    }
                    return;
                }
                RLDownloaderListener rLDownloaderListener2 = this.rejectRef.get();
                if (rLDownloaderListener2 != null) {
                    rLDownloaderListener2.onFailed("DownloaderDepend Download Failed: download success but file not found");
                }
            }

            public void onFailed(DownloadInfo entity, BaseException e) {
                RLDownloaderListener rLDownloaderListener;
                Intrinsics.checkNotNullParameter(entity, "entity");
                Intrinsics.checkNotNullParameter(e, "e");
                RLLogger.INSTANCE.m24w("DownloaderDepend download failed,url=" + this.$sourceUrl + ",errorCode:" + e.getErrorCode() + ";errorMsg:" + e.getErrorMessage());
                Downloader.getInstance(this.$application).removeMainThreadListener(entity.getId(), (IDownloadListener) this);
                if (((CharSequence) this.$nextUrl.element).length() > 0) {
                    this.this$0.downloadWithDownloader(this.$application, this.$sourceUrl, this.$config, this.$savePath, this.$name, this.$onlyLocal, this.$destination, this.$index + 1, RLDownloaderListener.this);
                } else {
                    if (this.$onlyLocal || (rLDownloaderListener = this.rejectRef.get()) == null) {
                        return;
                    }
                    rLDownloaderListener.onFailed("DownloaderDepend Download Failed:errorCode=" + e.getErrorCode() + " message=" + e.getErrorMessage());
                }
            }
        };
        String queryParameter = Uri.parse(str6).getQueryParameter("cdn_negotiate");
        if (LoaderUtil.INSTANCE.isNotNullOrEmpty(queryParameter)) {
            enableNegotiation = Intrinsics.areEqual(queryParameter, "1");
        } else {
            enableNegotiation = config.getEnableNegotiation();
        }
        if (ResourceLoader.with$default(ResourceLoader.INSTANCE, config.getBid(), null, 2, null).resourceConfigIsInitialized()) {
            ResourceLoaderEnvData resourceLoaderEnvData = ResourceLoader.INSTANCE.getResourceLoaderEnvData();
            boolean isDebug = ResourceLoader.INSTANCE.isDebug();
            if (isDebug) {
                str2 = str6;
                str4 = getMutableCdnURL(resourceLoaderEnvData, str2, config.getResourceLoaderSession());
            } else {
                str2 = str6;
                str4 = null;
            }
            HybridLogger hybridLogger = HybridLogger.INSTANCE;
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to("mutableCdnUrl", str4);
            z = true;
            i = 1;
            z = true;
            z = true;
            pairArr[1] = TuplesKt.to("originUrl", str2);
            pairArr[2] = TuplesKt.to(PrefetchRequestConfig.PARAM_TYPE_ENV, resourceLoaderEnvData != null ? resourceLoaderEnvData.toString() : null);
            pairArr[3] = TuplesKt.to("isDebug", Boolean.valueOf(isDebug));
            Map<String, ? extends Object> mapOf = MapsKt.mapOf(pairArr);
            LoggerContext loggerContext = new LoggerContext();
            loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, config.getResourceLoaderSession());
            Unit unit = Unit.INSTANCE;
            hybridLogger.m11i("XResourceLoader", "getMutableCdnURL result", mapOf, loggerContext);
            if (str4 != null) {
                if ((str4.length() > 0) && isDebug) {
                    str3 = str4;
                    Uri parse2 = Uri.parse(str3);
                    Intrinsics.checkExpressionValueIsNotNull(parse2, "Uri.parse(this)");
                    DownloadTask extraHeaders = Downloader.with(application).url(str3).name(name).savePath(savePath).addListenerToSameTask(i).addTTNetCommonParam((Intrinsics.areEqual(parse2.getQueryParameter("need_common_params"), "1") || !HybridSecureUtil.INSTANCE.inCommonParamsAllowList(parse2)) ? false : i).deleteCacheIfCheckFailed(i).retryCount(config.getLoadRetryTimes()).autoSetHashCodeForSameTask(i).ttnetProtectTimeout(20000).expiredRedownload(i).expiredHttpCheck(enableNegotiation).mainThreadListener(iDownloadListener).monitorScene("XResourceLoader").extraHeaders(getExtraHeaders(config));
                    Result.Companion companion = Result.Companion;
                    method = methodSetCacheLifeMaxTime;
                    if (method == null) {
                        Object[] objArr = new Object[i];
                        objArr[0] = Long.valueOf(this.cacheMaxTime);
                        obj = method.invoke(extraHeaders, objArr);
                    } else {
                        obj = null;
                    }
                    Result.constructor-impl(obj);
                    extraHeaders.asyncDownload((IDownloadStartCallback) null);
                }
            }
        } else {
            str2 = str6;
            z = true;
        }
        str3 = str2;
        i = z;
        Uri parse22 = Uri.parse(str3);
        Intrinsics.checkExpressionValueIsNotNull(parse22, "Uri.parse(this)");
        DownloadTask extraHeaders2 = Downloader.with(application).url(str3).name(name).savePath(savePath).addListenerToSameTask(i).addTTNetCommonParam((Intrinsics.areEqual(parse22.getQueryParameter("need_common_params"), "1") || !HybridSecureUtil.INSTANCE.inCommonParamsAllowList(parse22)) ? false : i).deleteCacheIfCheckFailed(i).retryCount(config.getLoadRetryTimes()).autoSetHashCodeForSameTask(i).ttnetProtectTimeout(20000).expiredRedownload(i).expiredHttpCheck(enableNegotiation).mainThreadListener(iDownloadListener).monitorScene("XResourceLoader").extraHeaders(getExtraHeaders(config));
        Result.Companion companion2 = Result.Companion;
        method = methodSetCacheLifeMaxTime;
        if (method == null) {
        }
        Result.constructor-impl(obj);
        extraHeaders2.asyncDownload((IDownloadStartCallback) null);
    }

    private final List<HttpHeader> getExtraHeaders(TaskConfig config) {
        Map<String, String> injectedHttpHeaders = config.getInjectedHttpHeaders();
        if (injectedHttpHeaders == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(injectedHttpHeaders.size());
        for (Map.Entry<String, String> entry : injectedHttpHeaders.entrySet()) {
            arrayList.add(new HttpHeader(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private final String getMutableCdnURL(ResourceLoaderEnvData env, String url, String rlSessionId) {
        Object obj;
        if (env == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("com.bytedance.forest.model.ForestEnvType");
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
            if (env.getType() == ResourceLoaderType.PPE) {
                Method method = cls.getMethod("valueOf", String.class);
                method.setAccessible(true);
                obj = method.invoke(null, "PPE");
            } else if (env.getType() == ResourceLoaderType.BOE) {
                Method method2 = cls.getMethod("valueOf", String.class);
                method2.setAccessible(true);
                obj = method2.invoke(null, "BOE");
            } else {
                obj = null;
            }
            Class<?> cls2 = Class.forName("com.bytedance.forest.model.ForestEnvData");
            Intrinsics.checkNotNull(obj);
            Object newInstance = cls2.getConstructor(obj.getClass(), String.class).newInstance(obj, env.getName());
            Class<?> cls3 = Class.forName("com.bytedance.forest.Forest$Companion");
            cls3.getDeclaredMethod("injectEnv", newInstance.getClass()).invoke(Class.forName("com.bytedance.forest.Forest").getField("Companion").get(cls3.getClass()), newInstance);
            Class<?> cls4 = Class.forName("com.bytedance.forest.chain.fetchers.GeckoXAdapter");
            Class<?> cls5 = Class.forName("com.bytedance.forest.chain.fetchers.GeckoXAdapter$Companion");
            Object invoke = cls5.getDeclaredMethod("addCommonParamsForCDNMultiVersionURL", String.class).invoke(cls4.getField("Companion").get(cls5.getClass()), url);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e) {
            HybridLogger hybridLogger = HybridLogger.INSTANCE;
            Map<String, ? extends Object> mapOf = MapsKt.mapOf(TuplesKt.to("error", e.getMessage()));
            LoggerContext loggerContext = new LoggerContext();
            loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, rlSessionId);
            Unit unit = Unit.INSTANCE;
            hybridLogger.m13w("XResourceLoader", "getMutableCdnURL error", mapOf, loggerContext);
            return null;
        }
    }
}
