package com.bytedance.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.bytedance.lottie.C0225L;
import com.bytedance.lottie.LottieComposition;
import com.bytedance.lottie.LottieCompositionFactory;
import com.bytedance.lottie.LottieResult;
import com.bytedance.lottie.LottieTask;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipInputStream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NetworkFetcher {
    private final Context appContext;
    private final NetworkCache networkCache;
    private final String url;

    public static LottieTask<LottieComposition> fetch(Context context, String str) {
        return new NetworkFetcher(context, str).fetch();
    }

    public static LottieResult<LottieComposition> fetchSync(Context context, String str) {
        return new NetworkFetcher(context, str).fetchSync();
    }

    private NetworkFetcher(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.url = str;
        this.networkCache = new NetworkCache(applicationContext, str);
    }

    private LottieTask<LottieComposition> fetch() {
        return new LottieTask<>(new Callable<LottieResult<LottieComposition>>() { // from class: com.bytedance.lottie.network.NetworkFetcher.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() throws Exception {
                return NetworkFetcher.this.fetchSync();
            }
        });
    }

    public LottieResult<LottieComposition> fetchSync() {
        LottieComposition fetchFromCache = fetchFromCache();
        if (fetchFromCache != null) {
            return new LottieResult<>(fetchFromCache);
        }
        C0225L.debug("Animation for " + this.url + " not found in cache. Fetching from network.");
        return fetchFromNetwork();
    }

    private LottieComposition fetchFromCache() {
        LottieResult<LottieComposition> fromJsonInputStreamSync;
        Pair<FileExtension, InputStream> fetch = this.networkCache.fetch();
        if (fetch == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) fetch.first;
        InputStream inputStream = (InputStream) fetch.second;
        if (fileExtension == FileExtension.Zip) {
            fromJsonInputStreamSync = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), this.url);
        } else {
            fromJsonInputStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, this.url);
        }
        if (fromJsonInputStreamSync.getValue() != null) {
            return fromJsonInputStreamSync.getValue();
        }
        return null;
    }

    private LottieResult<LottieComposition> fetchFromNetwork() {
        try {
            return fetchFromNetworkInternal();
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    private LottieResult fetchFromNetworkInternal() throws IOException {
        LottieResult<LottieComposition> fromZipStreamSync;
        boolean z = true;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        C0225L.debug("Fetching " + this.url);
        FileExtension fileExtension = this.url.endsWith(".json") ? FileExtension.Json : FileExtension.Zip;
        String filenameForUrl = NetworkCache.filenameForUrl(this.url, fileExtension, true);
        Downloader.with(this.appContext).url(this.url).name(filenameForUrl).savePath(this.appContext.getCacheDir().getAbsolutePath()).mainThreadListener(new AbsDownloadListener() { // from class: com.bytedance.lottie.network.NetworkFetcher.2
            public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                countDownLatch.countDown();
            }

            public void onSuccessed(DownloadInfo downloadInfo) {
                countDownLatch.countDown();
            }
        }).monitorScene("legacy_lynx_lottie").download();
        try {
            countDownLatch.await(3L, TimeUnit.SECONDS);
            File file = new File(this.appContext.getCacheDir().getAbsolutePath(), filenameForUrl);
            if (C02793.$SwitchMap$com$bytedance$lottie$network$FileExtension[fileExtension.ordinal()] == 1) {
                fromZipStreamSync = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(file)), this.url);
            } else {
                fromZipStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(new File(file.getAbsolutePath())), this.url);
            }
            if (fromZipStreamSync.getValue() != null) {
                this.networkCache.renameTempFile(fileExtension);
            }
            StringBuilder sb = new StringBuilder("Completed fetch from network. Success: ");
            if (fromZipStreamSync.getValue() == null) {
                z = false;
            }
            C0225L.debug(sb.append(z).toString());
            return fromZipStreamSync;
        } catch (InterruptedException unused) {
            return new LottieResult((Throwable) new IllegalArgumentException("Unable to fetch " + this.url));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.lottie.network.NetworkFetcher$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static /* synthetic */ class C02793 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$lottie$network$FileExtension;

        static {
            int[] iArr = new int[FileExtension.values().length];
            $SwitchMap$com$bytedance$lottie$network$FileExtension = iArr;
            try {
                iArr[FileExtension.Zip.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$lottie$network$FileExtension[FileExtension.Json.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
