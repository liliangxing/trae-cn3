package com.bytedance.iesgurd.update;

import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.GeckoUpdateParams;
import com.bytedance.geckox.buffer.Buffer;
import com.bytedance.geckox.buffer.impl.BufferPolicy;
import com.bytedance.geckox.buffer.stream.BufferInputStream;
import com.bytedance.geckox.buffer.stream.BufferOutputStream;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.listener.ListenerManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.net.GeckoNetWorkRequest;
import com.bytedance.geckox.net.HttpRequestInfo;
import com.bytedance.geckox.net.INetWork;
import com.bytedance.geckox.pcdn.GeckoXOdlDownloader;
import com.bytedance.geckox.utils.GeckoExecutors;
import com.bytedance.geckox.utils.MD5Utils;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaPackage;
import com.bytedance.iesgurd.meta.UpdateStatisticModel;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Downloader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\u0006\u0010\u001d\u001a\u00020\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/iesgurd/update/Downloader;", "", IPiaCacheProvider.CacheConfig.FIELD_META, "Lcom/bytedance/iesgurd/meta/PrepareMeta;", "params", "Lcom/bytedance/geckox/GeckoUpdateParams;", "(Lcom/bytedance/iesgurd/meta/PrepareMeta;Lcom/bytedance/geckox/GeckoUpdateParams;)V", "downloadFile", "", "downloadIndex", "", "listener", "Lcom/bytedance/geckox/listener/GeckoUpdateListener;", "model", "Lcom/bytedance/iesgurd/meta/UpdateStatisticModel;", "startTime", "", "downloadViaNormalCDN", "", "url", "stream", "Lcom/bytedance/geckox/buffer/stream/BufferOutputStream;", "downloadViaOdl", "downloadWithIndex", "downloadWithUrl", "onFailed", "e", "Lcom/bytedance/iesgurd/update/UpdateException;", "onSuccess", TraeAuthManager.STAGE_START, "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Downloader {
    private final String downloadFile;
    private int downloadIndex;
    private GeckoUpdateListener listener;
    private final PrepareMeta meta;
    private UpdateStatisticModel model;
    private final GeckoUpdateParams params;
    private long startTime;

    public Downloader(PrepareMeta prepareMeta, GeckoUpdateParams geckoUpdateParams) {
        Intrinsics.checkParameterIsNotNull(prepareMeta, IPiaCacheProvider.CacheConfig.FIELD_META);
        Intrinsics.checkParameterIsNotNull(geckoUpdateParams, "params");
        this.meta = prepareMeta;
        this.params = geckoUpdateParams;
        this.downloadFile = prepareMeta.getUpdateWithPatch() ? "DOWNLOAD_PATCH" : "DOWNLOAD_FULL";
    }

    public final void start() {
        GeckoLogger.d("[" + this.meta + "]start download");
        this.startTime = System.currentTimeMillis();
        UpdateStatisticModel statisticModel = this.meta.getStatisticModel();
        if (statisticModel == null) {
            Intrinsics.throwNpe();
        }
        this.model = statisticModel;
        this.listener = this.params.getListener$geckox_noasanRelease();
        this.meta.setDownloadFile(new File(this.meta.getUpdatingDir(), this.downloadFile));
        downloadWithIndex();
    }

    private final void downloadWithIndex() {
        long currentTimeMillis = System.currentTimeMillis();
        List<String> urlList = this.meta.getPackage().getUrlList();
        String str = urlList.get(this.downloadIndex);
        UpdateStatisticModel updateStatisticModel = this.model;
        if (updateStatisticModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        UpdateStatisticModel.StageData stageData = updateStatisticModel.getStageData(this.meta.getUpdateWithPatch());
        stageData.setUrl(str);
        try {
            downloadWithUrl(str);
            UpdateStatisticModel updateStatisticModel2 = this.model;
            if (updateStatisticModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
            }
            updateStatisticModel2.setDurationDownloadLastTime(System.currentTimeMillis() - currentTimeMillis);
            UpdateStatisticModel updateStatisticModel3 = this.model;
            if (updateStatisticModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
            }
            updateStatisticModel3.setDurationDownload(System.currentTimeMillis() - this.startTime);
            onSuccess();
            new Activator(this.meta).start();
        } catch (Throwable th) {
            if ((this.params.getEnableDownloadRetry() || this.meta.getUsePcdn()) && this.downloadIndex < urlList.size() - 1) {
                this.downloadIndex++;
                stageData.setFailedTimes(stageData.getFailedTimes() + 1);
                downloadWithIndex();
            } else {
                int code = th instanceof UpdateException ? th.getCode() : ErrorCode.DOWNLOAD_OTHER.getCode();
                String message = th.getMessage();
                if (message == null) {
                    message = "";
                }
                UpdateException updateException = new UpdateException(code, message);
                onFailed(updateException);
                throw updateException;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006d A[Catch: all -> 0x00f4, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00f4, blocks: (B:18:0x006d, B:40:0x008a), top: B:16:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008a A[Catch: all -> 0x00f4, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00f4, blocks: (B:18:0x006d, B:40:0x008a), top: B:16:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void downloadWithUrl(String url) {
        boolean z;
        boolean z2;
        BufferOutputStream bufferOutputStream;
        HttpRequestInfo httpRequestInfo;
        Buffer create;
        HttpRequestInfo httpRequestInfo2;
        GeckoLogger.d("[" + this.meta + "]download url: " + url);
        PrepareMetaPackage prepareMetaPackage = this.meta.getPackage();
        long length = prepareMetaPackage.getLength();
        Buffer buffer = null;
        boolean z3 = true;
        try {
            try {
                try {
                    try {
                        if (this.meta.getUsePcdn()) {
                            if (this.meta.odlUseUrl.length() == 0) {
                                z = true;
                                if (z) {
                                    String initIfNeed = GeckoXOdlDownloader.Companion.initIfNeed();
                                    String str = initIfNeed;
                                    if (str != null && str.length() != 0) {
                                        z3 = false;
                                    }
                                    if (!z3) {
                                        this.meta.odlFallbackReason = initIfNeed;
                                        z2 = false;
                                        if (!z2) {
                                            create = BufferPolicy.INSTANCE.create(this.meta.getDownloadFile(), length);
                                            bufferOutputStream = new BufferOutputStream(create, this.params, this.meta, length);
                                            downloadViaNormalCDN(url, this.meta, bufferOutputStream);
                                        } else {
                                            create = BufferPolicy.INSTANCE.create(this.meta.getDownloadFile(), length);
                                            bufferOutputStream = new BufferOutputStream(create, this.params, this.meta, length);
                                            downloadViaOdl(url, this.meta, bufferOutputStream);
                                        }
                                        httpRequestInfo2 = bufferOutputStream.getHttpRequestInfo();
                                        if (httpRequestInfo2 != null) {
                                            httpRequestInfo2.upload();
                                        }
                                        if (create == null) {
                                            Intrinsics.throwNpe();
                                        }
                                        create.finish();
                                        create.position(0L);
                                        MD5Utils.INSTANCE.check$geckox_noasanRelease(new BufferInputStream(create), prepareMetaPackage.getMd5());
                                        this.meta.setUpdateBuffer(create);
                                        return;
                                    }
                                }
                                z2 = z;
                                if (!z2) {
                                }
                                httpRequestInfo2 = bufferOutputStream.getHttpRequestInfo();
                                if (httpRequestInfo2 != null) {
                                }
                                if (create == null) {
                                }
                                create.finish();
                                create.position(0L);
                                MD5Utils.INSTANCE.check$geckox_noasanRelease(new BufferInputStream(create), prepareMetaPackage.getMd5());
                                this.meta.setUpdateBuffer(create);
                                return;
                            }
                        }
                        create.position(0L);
                        MD5Utils.INSTANCE.check$geckox_noasanRelease(new BufferInputStream(create), prepareMetaPackage.getMd5());
                        this.meta.setUpdateBuffer(create);
                        return;
                    } catch (Throwable th) {
                        create.releaseAndDeleteSwap();
                        if (z2) {
                            this.meta.odlFallbackReason = th.getMessage();
                        }
                        throw new UpdateException(ErrorCode.DOWNLOAD_CHECK, th.getMessage());
                    }
                    if (!z2) {
                    }
                    httpRequestInfo2 = bufferOutputStream.getHttpRequestInfo();
                    if (httpRequestInfo2 != null) {
                    }
                    if (create == null) {
                    }
                    create.finish();
                } catch (Throwable th2) {
                    th = th2;
                    bufferOutputStream = null;
                    buffer = create;
                    if (buffer != null) {
                        try {
                            buffer.releaseAndDeleteSwap();
                        } catch (Throwable th3) {
                            if (bufferOutputStream != null && (httpRequestInfo = bufferOutputStream.getHttpRequestInfo()) != null) {
                                httpRequestInfo.upload();
                            }
                            throw th3;
                        }
                    }
                    throw new UpdateException(ErrorCode.DOWNLOAD, th.getMessage());
                }
            } catch (Throwable th4) {
                th = th4;
                bufferOutputStream = null;
                if (buffer != null) {
                }
                throw new UpdateException(ErrorCode.DOWNLOAD, th.getMessage());
            }
        } catch (Throwable th5) {
            th = th5;
            buffer = create;
            if (buffer != null) {
            }
            throw new UpdateException(ErrorCode.DOWNLOAD, th.getMessage());
        }
        z = false;
        if (z) {
        }
        z2 = z;
    }

    private final void downloadViaOdl(String url, PrepareMeta meta, BufferOutputStream stream) {
        meta.odlUseUrl = url;
        try {
            new GeckoXOdlDownloader(url, this.downloadFile, meta, stream).download();
        } catch (Throwable th) {
            meta.odlFallbackReason = th.toString();
            throw th;
        }
    }

    private final void downloadViaNormalCDN(String url, PrepareMeta meta, BufferOutputStream stream) {
        try {
            GeckoGlobalManager inst = GeckoGlobalManager.inst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
            GeckoGlobalConfig globalConfig = inst.getGlobalConfig();
            GeckoNetWorkRequest geckoNetWorkRequest = GeckoNetWorkRequest.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(globalConfig, "config");
            INetWork netWork = globalConfig.getNetWork();
            Intrinsics.checkExpressionValueIsNotNull(netWork, "config.netWork");
            geckoNetWorkRequest.requestWithDownloadFile(netWork, url, stream, meta, MapsKt.emptyMap());
        } finally {
            HttpRequestInfo httpRequestInfo = stream.getHttpRequestInfo();
            if (httpRequestInfo != null) {
                meta.originCDNDuration = httpRequestInfo.getDownloadDuration();
                meta.originCDNReceivedBytes = httpRequestInfo.getDownloadByteCount();
            }
        }
    }

    private final void onFailed(final UpdateException e) {
        GeckoExecutors.INSTANCE.getCallbackExecutor().execute(new Runnable() { // from class: com.bytedance.iesgurd.update.Downloader$onFailed$1
            @Override // java.lang.Runnable
            public final void run() {
                GeckoUpdateListener geckoUpdateListener;
                PrepareMeta prepareMeta;
                PrepareMeta prepareMeta2;
                try {
                    geckoUpdateListener = Downloader.this.listener;
                    if (geckoUpdateListener != null) {
                        prepareMeta2 = Downloader.this.meta;
                        geckoUpdateListener.onDownloadFail(prepareMeta2.getPack(), e);
                    }
                    for (GeckoUpdateListener geckoUpdateListener2 : ListenerManager.INSTANCE.getListeners()) {
                        prepareMeta = Downloader.this.meta;
                        geckoUpdateListener2.onDownloadFail(prepareMeta.getPack(), e);
                    }
                } catch (Throwable th) {
                    GeckoLogger.w("download onFailed exception: " + th.getMessage());
                }
            }
        });
    }

    private final void onSuccess() {
        GeckoExecutors.INSTANCE.getCallbackExecutor().execute(new Runnable() { // from class: com.bytedance.iesgurd.update.Downloader$onSuccess$1
            @Override // java.lang.Runnable
            public final void run() {
                GeckoUpdateListener geckoUpdateListener;
                PrepareMeta prepareMeta;
                PrepareMeta prepareMeta2;
                try {
                    geckoUpdateListener = Downloader.this.listener;
                    if (geckoUpdateListener != null) {
                        prepareMeta2 = Downloader.this.meta;
                        geckoUpdateListener.onDownloadSuccess(prepareMeta2.getPack());
                    }
                    for (GeckoUpdateListener geckoUpdateListener2 : ListenerManager.INSTANCE.getListeners()) {
                        prepareMeta = Downloader.this.meta;
                        geckoUpdateListener2.onDownloadSuccess(prepareMeta.getPack());
                    }
                } catch (Throwable th) {
                    GeckoLogger.w("download onSuccess exception: " + th.getMessage());
                }
            }
        });
    }
}
