package com.bytedance.forest.pollyfill;

import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.forest.model.ErrorInfo;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Timing;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.geckox.logger.GeckoLogger;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: DownloadDepender.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\r"}, d2 = {"com/bytedance/forest/pollyfill/DownloadDepender$fetchFile$absDownloadListener$1", "Lcom/ss/android/socialbase/downloader/depend/AbsDownloadListener;", "onCanceled", "", "entity", "Lcom/ss/android/socialbase/downloader/model/DownloadInfo;", "onFailed", "e", "Lcom/ss/android/socialbase/downloader/exception/BaseException;", "onIntercept", "onPause", AgentConstants.ON_START, "onSuccessed", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class DownloadDepender$fetchFile$absDownloadListener$1 extends AbsDownloadListener {
    final /* synthetic */ File $destination;
    final /* synthetic */ Ref.ObjectRef $downloaderListenerId;
    final /* synthetic */ FetchTask $fetchTask;
    final /* synthetic */ CountDownLatch $latch;
    final /* synthetic */ Response $response;
    final /* synthetic */ String $sourceUrl;
    final /* synthetic */ DownloadDepender this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DownloadDepender$fetchFile$absDownloadListener$1(DownloadDepender downloadDepender, Ref.ObjectRef objectRef, Response response, File file, FetchTask fetchTask, CountDownLatch countDownLatch, String str) {
        this.this$0 = downloadDepender;
        this.$downloaderListenerId = objectRef;
        this.$response = response;
        this.$destination = file;
        this.$fetchTask = fetchTask;
        this.$latch = countDownLatch;
        this.$sourceUrl = str;
    }

    public void onSuccessed(DownloadInfo entity) {
        boolean tryLoadFromCDN;
        ForestPipelineContext forestPipelineContext;
        super.onSuccessed(entity);
        this.$downloaderListenerId.element = entity != null ? Integer.valueOf(entity.getId()) : null;
        tryLoadFromCDN = this.this$0.tryLoadFromCDN(this.$response, this.$destination);
        if (tryLoadFromCDN) {
            forestPipelineContext = this.this$0.context;
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext, new String[]{Timing.CDN_DOWNLOAD_FINISH}, null, 2, null);
            this.this$0.callbackSucceed(this.$response, this.$fetchTask, entity);
        } else {
            this.$fetchTask.onFailure$forest_release(true, new IOException("fetch succeeded but file not exists"));
        }
        this.$latch.countDown();
    }

    public void onStart(DownloadInfo entity) {
        ForestPipelineContext forestPipelineContext;
        super.onStart(entity);
        this.$downloaderListenerId.element = entity != null ? Integer.valueOf(entity.getId()) : null;
        forestPipelineContext = this.this$0.context;
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext, new String[]{Timing.CDN_DOWNLOAD_INTERNAL_START}, null, 2, null);
    }

    public void onFailed(DownloadInfo entity, BaseException e) {
        super.onFailed(entity, e);
        this.$downloaderListenerId.element = entity != null ? Integer.valueOf(entity.getId()) : null;
        if (e != null) {
            this.$response.getErrorInfo().setNetLibraryErrorCode(e.getErrorCode());
            if (e instanceof DownloadHttpException) {
                this.$response.getErrorInfo().setHttpStatusCode(((DownloadHttpException) e).getHttpStatusCode());
            }
            ErrorInfo errorInfo = this.$response.getErrorInfo();
            String errorMessage = e.getErrorMessage();
            Intrinsics.checkExpressionValueIsNotNull(errorMessage, "errorMessage");
            errorInfo.setCdnError(errorMessage);
        }
        Exception exc = (Throwable) e;
        GeckoLogger.m298e(CDNFetchDepender.TAG, "download failed, httpHeaders:" + (entity != null ? entity.getHttpHeaders() : null), exc);
        FetchTask fetchTask = this.$fetchTask;
        if (e == null) {
            exc = new Exception();
        }
        fetchTask.onFailure$forest_release(true, exc);
        this.$latch.countDown();
    }

    public void onCanceled(DownloadInfo entity) {
        super.onCanceled(entity);
        this.$downloaderListenerId.element = entity != null ? Integer.valueOf(entity.getId()) : null;
        this.$fetchTask.onCanceled$forest_release();
        this.$latch.countDown();
    }

    public void onPause(DownloadInfo entity) {
        ForestPipelineContext forestPipelineContext;
        super.onPause(entity);
        this.$downloaderListenerId.element = entity != null ? Integer.valueOf(entity.getId()) : null;
        this.$fetchTask.onPaused();
        forestPipelineContext = this.this$0.context;
        ForestLogger.printOptimize$default(forestPipelineContext.getLogger(), 3, CDNFetchDepender.TAG, false, null, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.DownloadDepender$fetchFile$absDownloadListener$1$onPause$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                return "downloader paused, url: " + DownloadDepender$fetchFile$absDownloadListener$1.this.$sourceUrl;
            }
        }, 28, null);
    }

    public void onIntercept(DownloadInfo entity) {
        super.onIntercept(entity);
        this.$downloaderListenerId.element = entity != null ? Integer.valueOf(entity.getId()) : null;
        this.$fetchTask.onIntercept$forest_release();
        this.$latch.countDown();
    }
}
