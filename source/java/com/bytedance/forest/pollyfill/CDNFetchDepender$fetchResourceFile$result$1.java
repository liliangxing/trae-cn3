package com.bytedance.forest.pollyfill;

import android.webkit.WebResourceRequest;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.ResourceFetchScheduler;
import com.bytedance.forest.model.ErrorInfo;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CDNFetchDepender.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\r\u0010\u0002\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\u0004J\u001d\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0010¢\u0006\u0002\b\nJ\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0015\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u000fJ\r\u0010\u0010\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\u0011¨\u0006\u0012"}, d2 = {"com/bytedance/forest/pollyfill/CDNFetchDepender$fetchResourceFile$result$1", "Lcom/bytedance/forest/pollyfill/FetchTask;", "onCanceled", "", "onCanceled$forest_release", "onFailure", "shouldRetry", "", "error", "", "onFailure$forest_release", "onPaused", "onRedirection", "url", "", "onRedirection$forest_release", "onSuccess", "onSuccess$forest_release", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class CDNFetchDepender$fetchResourceFile$result$1 extends FetchTask {
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ ForestPipelineContext $context;
    final /* synthetic */ Forest $forest;
    final /* synthetic */ INetDepender $netDepender;
    final /* synthetic */ boolean $onlyLocal;
    final /* synthetic */ Request $request;
    final /* synthetic */ Response $response;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CDNFetchDepender$fetchResourceFile$result$1(Function1 function1, Response response, Request request, INetDepender iNetDepender, boolean z, ForestPipelineContext forestPipelineContext, Forest forest, Forest forest2, Response response2, ForestPipelineContext forestPipelineContext2) {
        super(forest2, response2, forestPipelineContext2);
        this.$callback = function1;
        this.$response = response;
        this.$request = request;
        this.$netDepender = iNetDepender;
        this.$onlyLocal = z;
        this.$context = forestPipelineContext;
        this.$forest = forest;
    }

    @Override // com.bytedance.forest.pollyfill.FetchTask
    public void onSuccess$forest_release() {
        super.onSuccess$forest_release();
        this.$callback.invoke(true);
    }

    @Override // com.bytedance.forest.pollyfill.FetchTask
    public void onFailure$forest_release(boolean shouldRetry, Throwable error) {
        String shuffleUrl;
        Intrinsics.checkParameterIsNotNull(error, "error");
        super.onFailure$forest_release(shouldRetry, error);
        this.$response.getErrorInfo().setCdnError(String.valueOf(error.getMessage()));
        if (!this.$response.getIsCanceled() && shouldRetry) {
            shuffleUrl = CDNFetchDepender.INSTANCE.shuffleUrl(this.$request);
            if (shuffleUrl != null) {
                this.$netDepender.fetchFile(this.$response, this, this.$onlyLocal);
                return;
            }
        }
        if (!this.$response.getIsCanceled()) {
            ErrorInfo errorInfo = this.$response.getErrorInfo();
            ErrorInfo.Type type = ErrorInfo.Type.CDN;
            String message = error.getMessage();
            if (message == null) {
                message = "download failed";
            }
            errorInfo.setError(type, 3, message);
        }
        this.$callback.invoke(false);
    }

    @Override // com.bytedance.forest.pollyfill.FetchTask
    public void onRedirection$forest_release(final String url) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        super.onRedirection$forest_release(url);
        ForestLogger.printOptimize$default(this.$context.getLogger(), 4, "cdnfetcher", false, null, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.CDNFetchDepender$fetchResourceFile$result$1$onRedirection$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final String invoke() {
                return "redirected to " + url;
            }
        }, 28, null);
        Object webResourceRequest = this.$response.getRequest().getWebResourceRequest();
        if (!(webResourceRequest instanceof WebResourceRequest)) {
            webResourceRequest = null;
        }
        WebResourceRequest webResourceRequest2 = (WebResourceRequest) webResourceRequest;
        if (webResourceRequest2 != null && webResourceRequest2.isForMainFrame()) {
            onSuccess$forest_release();
            return;
        }
        this.$request.setUrl(url);
        this.$request.setSupportShuffle(false);
        this.$context.setPipelineTag$forest_release("redirection");
        ResourceFetchScheduler.INSTANCE.createFetcherChain$forest_release(this.$request, this.$response, null, this.$context).fetch$forest_release(new Function1<Response, Unit>() { // from class: com.bytedance.forest.pollyfill.CDNFetchDepender$fetchResourceFile$result$1$onRedirection$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Response) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Response response) {
                Intrinsics.checkParameterIsNotNull(response, "it");
                CDNFetchDepender$fetchResourceFile$result$1.this.$context.setPipelineTag$forest_release("");
                CDNFetchDepender$fetchResourceFile$result$1.this.$callback.invoke(Boolean.valueOf(CDNFetchDepender$fetchResourceFile$result$1.this.$response.getIsSucceed()));
            }
        });
    }

    @Override // com.bytedance.forest.pollyfill.FetchTask
    public void onCanceled$forest_release() {
        super.onCanceled$forest_release();
        this.$callback.invoke(false);
    }

    @Override // com.bytedance.forest.pollyfill.FetchTask
    public void onPaused() {
        super.onPaused();
        this.$response.setHasBeenPaused(true);
    }
}
