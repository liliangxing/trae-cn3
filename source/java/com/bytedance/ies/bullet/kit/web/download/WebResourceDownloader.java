package com.bytedance.ies.bullet.kit.web.download;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderUtils;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.pia.core.misc.UrlMatcher;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebResourceDownloader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000eJ$\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/download/WebResourceDownloader;", "", "()V", "_application", "Landroid/app/Application;", "_parentDir", "Ljava/io/File;", "checkExpired", "", "downloadInfo", "Lcom/ss/android/socialbase/downloader/model/DownloadInfo;", "deleteResource", "", "url", "", "downloadResource", "getCacheResource", "Landroid/webkit/WebResourceResponse;", "getFileName", "loadLocalResponse", "mimeType", "encode", "input", "Ljava/io/InputStream;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class WebResourceDownloader {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DIR_NAME = "bullet_web_resource_offline";
    public static final String DOWNLOAD_SCENE = "XWeb";
    public static final long MAX_CACHE_TIME = 1209600;
    public static final String TAG = "WebResourceDownloader";
    private static final Lazy<WebResourceDownloader> instance$delegate;
    private static final Method methodSetCacheLifeMaxTime;
    private final Application _application;
    private final File _parentDir;

    /* compiled from: WebResourceDownloader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/download/WebResourceDownloader$Companion;", "", "()V", "DIR_NAME", "", "DOWNLOAD_SCENE", "MAX_CACHE_TIME", "", "TAG", "instance", "Lcom/bytedance/ies/bullet/kit/web/download/WebResourceDownloader;", "getInstance", "()Lcom/bytedance/ies/bullet/kit/web/download/WebResourceDownloader;", "instance$delegate", "Lkotlin/Lazy;", "methodSetCacheLifeMaxTime", "Ljava/lang/reflect/Method;", "getMethodSetCacheLifeMaxTime", "()Ljava/lang/reflect/Method;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Method getMethodSetCacheLifeMaxTime() {
            return WebResourceDownloader.methodSetCacheLifeMaxTime;
        }

        public final WebResourceDownloader getInstance() {
            return (WebResourceDownloader) WebResourceDownloader.instance$delegate.getValue();
        }
    }

    public WebResourceDownloader() {
        File file;
        Application application = ResourceLoader.INSTANCE.getApplication();
        this._application = application;
        if (application != null) {
            file = new File(application.getCacheDir(), DIR_NAME);
            file.mkdirs();
        } else {
            file = null;
        }
        this._parentDir = file;
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
        instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<WebResourceDownloader>() { // from class: com.bytedance.ies.bullet.kit.web.download.WebResourceDownloader$Companion$instance$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final WebResourceDownloader m508invoke() {
                return new WebResourceDownloader();
            }
        });
    }

    private final boolean checkExpired(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getCacheExpiredTime() > 0 && System.currentTimeMillis() > downloadInfo.getCacheExpiredTime();
    }

    public final String getFileName(String url) {
        String encodedPath;
        String extension;
        Intrinsics.checkNotNullParameter(url, "url");
        Uri parse = Uri.parse(url);
        if (!parse.isHierarchical()) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "WebResourceDownloader: url=" + url + " isn't hierarchical", null, "XPreload", 2, null);
            return null;
        }
        String md5Hex = ResourceLoaderUtils.INSTANCE.md5Hex(url);
        if (!parse.isHierarchical()) {
            parse = null;
        }
        if (parse == null || (encodedPath = parse.getEncodedPath()) == null || (extension = FilesKt.getExtension(new File(encodedPath))) == null) {
            return null;
        }
        if (!(!TextUtils.isEmpty(extension))) {
            extension = null;
        }
        if (extension != null) {
            return md5Hex + '.' + extension;
        }
        return null;
    }

    private final WebResourceResponse loadLocalResponse(String mimeType, String encode, InputStream input) {
        if (input == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Access-Control-Allow-Origin", UrlMatcher.WILDCARD);
            if (Intrinsics.areEqual("font/ttf", mimeType)) {
                return new WebResourceResponse(mimeType, encode, 200, "OK", hashMap, input);
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(mimeType, encode, input);
            webResourceResponse.setResponseHeaders(hashMap);
            return webResourceResponse;
        } catch (Exception unused) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "WebResourceDownloader: translate input to response failed", null, "XPreload", 2, null);
            return null;
        }
    }

    public final WebResourceResponse getCacheResource(String url) {
        String fileName;
        String mimeType;
        Intrinsics.checkNotNullParameter(url, "url");
        File file = this._parentDir;
        if (file == null || (fileName = getFileName(url)) == null) {
            return null;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(this._application).getDownloadInfo(url, file.getPath());
        File file2 = new File(file, fileName);
        if (!file2.exists() || file2.isDirectory() || checkExpired(downloadInfo)) {
            return null;
        }
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "WebResourceDownloader: get cache of url=" + url + " from destination=" + file2, null, "XPreload", 2, null);
        ResourceLoaderUtils resourceLoaderUtils = ResourceLoaderUtils.INSTANCE;
        String path = file2.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "destination.path");
        String mimeType2 = resourceLoaderUtils.getMimeType(path);
        if (TextUtils.isEmpty(mimeType2) && downloadInfo != null && (mimeType = downloadInfo.getMimeType()) != null) {
            Intrinsics.checkNotNullExpressionValue(mimeType, "mimeType");
            mimeType2 = mimeType;
        }
        return loadLocalResponse(mimeType2, "", new FileInputStream(file2));
    }

    public final void deleteResource(String url) {
        String fileName;
        Intrinsics.checkNotNullParameter(url, "url");
        File file = this._parentDir;
        if (file == null || (fileName = getFileName(url)) == null) {
            return;
        }
        File file2 = new File(file, fileName);
        if (file2.exists()) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "WebResourceDownloader: delete cache of url=" + url + " from destination=" + file2, null, "XPreload", 2, null);
            file2.delete();
        }
    }

    public final void downloadResource(final String url) {
        String fileName;
        Intrinsics.checkNotNullParameter(url, "url");
        File file = this._parentDir;
        if (file == null || (fileName = getFileName(url)) == null) {
            return;
        }
        File file2 = new File(file, fileName);
        if (file2.exists()) {
            file2.delete();
        }
        DownloadTask monitorScene = Downloader.with(this._application).url(url).name(fileName).savePath(file.getPath()).addListenerToSameTask(true).addTTNetCommonParam(Intrinsics.areEqual(Uri.parse(url).getQueryParameter("need_common_params"), "1")).deleteCacheIfCheckFailed(true).retryCount(0).autoSetHashCodeForSameTask(true).ttnetProtectTimeout(20000).expiredRedownload(true).expiredHttpCheck(Intrinsics.areEqual(Uri.parse(url).getQueryParameter("cdn_negotiate"), "1")).mainThreadListener(new AbsDownloadListener() { // from class: com.bytedance.ies.bullet.kit.web.download.WebResourceDownloader$downloadResource$1$1$downloadListener$1
            public void onSuccessed(DownloadInfo entity) {
                Application application;
                Intrinsics.checkNotNullParameter(entity, "entity");
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "WebResourceDownloader: download success " + entity.getUrl(), null, "XPreload", 2, null);
                application = WebResourceDownloader.this._application;
                Downloader.getInstance(application).removeMainThreadListener(entity.getId(), (IDownloadListener) this);
            }

            public void onFailed(DownloadInfo entity, BaseException e) {
                Application application;
                Intrinsics.checkNotNullParameter(entity, "entity");
                Intrinsics.checkNotNullParameter(e, "e");
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "WebResourceDownloader: download failed url=" + url + ",errorCode=" + e.getErrorCode() + ",errorMsg=" + e.getErrorMessage(), null, "XPreload", 2, null);
                application = WebResourceDownloader.this._application;
                Downloader.getInstance(application).removeMainThreadListener(entity.getId(), (IDownloadListener) this);
            }
        }).monitorScene(DOWNLOAD_SCENE);
        try {
            Result.Companion companion = Result.Companion;
            Method method = methodSetCacheLifeMaxTime;
            Result.constructor-impl(method != null ? method.invoke(monitorScene, Long.valueOf(MAX_CACHE_TIME)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        monitorScene.asyncDownload((IDownloadStartCallback) null);
    }
}
