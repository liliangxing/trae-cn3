package com.bytedance.trae.kmp.artifact;

import android.content.Context;
import com.bytedance.trae.network.E2ENetworkOverrides;
import com.bytedance.trae.platform.api.ISdkCommonHttp;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* compiled from: AndroidKmpArtifactIo.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient;", "Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadClient;", "context", "Landroid/content/Context;", "fileSystem", "Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;", "<init>", "(Landroid/content/Context;Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;)V", "downloadToFile", "Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadTask;", "request", "Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadRequest;", "rewriteAbsoluteUrlForMock", "", "url", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidKmpBinaryDownloadClient implements KmpBinaryDownloadClient {
    public static final int $stable = 8;
    private final Context context;
    private final AndroidKmpArtifactFileSystem fileSystem;

    public AndroidKmpBinaryDownloadClient(Context context, AndroidKmpArtifactFileSystem androidKmpArtifactFileSystem) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(androidKmpArtifactFileSystem, "fileSystem");
        this.context = context;
        this.fileSystem = androidKmpArtifactFileSystem;
    }

    @Override // com.bytedance.trae.kmp.artifact.KmpBinaryDownloadClient
    public KmpBinaryDownloadTask downloadToFile(final KmpBinaryDownloadRequest request) {
        boolean z;
        Intrinsics.checkNotNullParameter(request, "request");
        final File resolveForDownload = AndroidKmpArtifactIoKt.resolveForDownload(this.fileSystem, request.getTarget());
        File parentFile = resolveForDownload.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        String rewriteAbsoluteUrlForMock = rewriteAbsoluteUrlForMock(request.getUrl());
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        IDownloadListener iDownloadListener = new AbsDownloadListener() { // from class: com.bytedance.trae.kmp.artifact.AndroidKmpBinaryDownloadClient$downloadToFile$listener$1
            public void onSuccessed(DownloadInfo entity) {
                int i;
                CompletableDeferred<KmpBinaryDownloadResult> completableDeferred = CompletableDeferred$default;
                KmpFileReference target = request.getTarget();
                if (entity != null) {
                    Integer valueOf = Integer.valueOf(entity.getHttpStatusCode());
                    if (!(valueOf.intValue() > 0)) {
                        valueOf = null;
                    }
                    if (valueOf != null) {
                        i = valueOf.intValue();
                        completableDeferred.complete(new KmpBinaryDownloadResult(target, i, null, null, 12, null));
                    }
                }
                i = 200;
                completableDeferred.complete(new KmpBinaryDownloadResult(target, i, null, null, 12, null));
            }

            public void onFailed(DownloadInfo entity, BaseException error) {
                String str;
                resolveForDownload.delete();
                CompletableDeferred<KmpBinaryDownloadResult> completableDeferred = CompletableDeferred$default;
                int httpStatusCode = entity != null ? entity.getHttpStatusCode() : -1;
                if (error == null || (str = error.getMessage()) == null) {
                    str = "download failed";
                }
                completableDeferred.complete(new KmpBinaryDownloadResult(null, httpStatusCode, null, str, 4, null));
            }

            public void onCanceled(DownloadInfo entity) {
                resolveForDownload.delete();
                CompletableDeferred$default.complete(new KmpBinaryDownloadResult(null, -1, null, "cancelled", 4, null));
            }
        };
        Map mutableMap = MapsKt.toMutableMap(request.getHeaders());
        if (request.getAuth() == KmpBinaryAuth.CloudIdeJwt) {
            Set keySet = mutableMap.keySet();
            if (!(keySet instanceof Collection) || !keySet.isEmpty()) {
                Iterator it = keySet.iterator();
                while (it.hasNext()) {
                    if (StringsKt.equals((String) it.next(), "Authorization", true)) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                String token = ISdkCommonHttp.INSTANCE.getToken();
                if (!(!StringsKt.isBlank(token))) {
                    token = null;
                }
                if (token != null) {
                    mutableMap.put("Authorization", "Cloud-IDE-JWT " + token);
                }
            }
        }
        DownloadTask url = Downloader.with(this.context).taskKey(UUID.randomUUID().toString()).retryCount(3).autoSetHashCodeForSameTask(true).url(rewriteAbsoluteUrlForMock);
        String parent = resolveForDownload.getParent();
        if (parent == null) {
            parent = this.context.getCacheDir().getAbsolutePath();
        }
        DownloadTask name = url.savePath(parent).name(resolveForDownload.getName());
        ArrayList arrayList = new ArrayList(mutableMap.size());
        for (Map.Entry entry : mutableMap.entrySet()) {
            arrayList.add(new HttpHeader((String) entry.getKey(), (String) entry.getValue()));
        }
        DownloadTask subThreadListener = name.extraHeaders(arrayList).subThreadListener(iDownloadListener);
        final int downloadId = subThreadListener.getDownloadId();
        subThreadListener.asyncDownload((IDownloadStartCallback) null);
        return new KmpBinaryDownloadTask() { // from class: com.bytedance.trae.kmp.artifact.AndroidKmpBinaryDownloadClient$downloadToFile$4
            @Override // com.bytedance.trae.kmp.artifact.KmpBinaryDownloadTask
            public Object await(Continuation<? super KmpBinaryDownloadResult> continuation) {
                return CompletableDeferred$default.await(continuation);
            }

            @Override // com.bytedance.trae.kmp.artifact.KmpBinaryDownloadTask
            public void cancel() {
                Context context;
                context = this.context;
                Downloader.getInstance(context).cancel(downloadId);
                resolveForDownload.delete();
            }
        };
    }

    private final String rewriteAbsoluteUrlForMock(String url) {
        String overrideBaseUrlOrNull = E2ENetworkOverrides.INSTANCE.overrideBaseUrlOrNull();
        if (overrideBaseUrlOrNull == null) {
            return url;
        }
        URI uri = new URI(url);
        URI uri2 = new URI(overrideBaseUrlOrNull);
        String uri3 = new URI(uri2.getScheme(), null, uri2.getHost(), uri2.getPort(), uri.getRawPath(), uri.getRawQuery(), uri.getRawFragment()).toString();
        Intrinsics.checkNotNullExpressionValue(uri3, "toString(...)");
        return uri3;
    }
}
