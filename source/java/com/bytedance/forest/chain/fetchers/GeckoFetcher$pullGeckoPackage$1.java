package com.bytedance.forest.chain.fetchers;

import com.bytedance.forest.model.ErrorInfo;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Timing;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeckoFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J)\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"com/bytedance/forest/chain/fetchers/GeckoFetcher$pullGeckoPackage$1", "Lcom/bytedance/forest/chain/fetchers/OnUpdateListener;", "called", "", "getCalled", "()Z", "setCalled", "(Z)V", "onUpdateFailed", "", "channel", "", "throwable", "", "onUpdateSuccess", "path", "version", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoFetcher$pullGeckoPackage$1 implements OnUpdateListener {
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ GeckoConfig $loaderConfig;
    final /* synthetic */ boolean $onlyLocal;
    final /* synthetic */ Request $request;
    final /* synthetic */ Response $response;
    private boolean called;
    final /* synthetic */ GeckoFetcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeckoFetcher$pullGeckoPackage$1(GeckoFetcher geckoFetcher, Request request, boolean z, Response response, GeckoConfig geckoConfig, Function1 function1) {
        this.this$0 = geckoFetcher;
        this.$request = request;
        this.$onlyLocal = z;
        this.$response = response;
        this.$loaderConfig = geckoConfig;
        this.$callback = function1;
    }

    public final boolean getCalled() {
        return this.called;
    }

    public final void setCalled(boolean z) {
        this.called = z;
    }

    @Override // com.bytedance.forest.chain.fetchers.OnUpdateListener
    public void onUpdateSuccess(String channel, String path, Long version) {
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        if (this.called) {
            return;
        }
        this.called = true;
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.this$0.getContext$forest_release(), new String[]{Timing.GECKO_UPDATE_FINISH}, null, 2, null);
        ForestLogger.print$default(this.this$0.getContext$forest_release().getLogger(), 3, GeckoFetcher.TAG, "download success with waitGeckoUpdate=" + this.$request.getWaitGeckoUpdate() + " , channel=" + channel + ",bundle=" + this.$request.getGeckoModel().getBundle(), true, null, Timing.GECKO_UPDATE_FINISH, 16, null);
        if (!this.$onlyLocal) {
            this.this$0.loadGeckoFile(this.$request, this.$response, false, version, this.$loaderConfig, new Function0<Unit>() { // from class: com.bytedance.forest.chain.fetchers.GeckoFetcher$pullGeckoPackage$1$onUpdateSuccess$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m479invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m479invoke() {
                    GeckoFetcher$pullGeckoPackage$1.this.$callback.invoke(GeckoFetcher$pullGeckoPackage$1.this.$response);
                }
            });
        } else {
            ForestLogger.print$default(this.this$0.getContext$forest_release().getLogger(), 3, GeckoFetcher.TAG, "success, skip callbacks when onlyLocal is true", false, null, null, 56, null);
        }
    }

    @Override // com.bytedance.forest.chain.fetchers.OnUpdateListener
    public void onUpdateFailed(String channel, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        if (this.called) {
            return;
        }
        this.called = true;
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.this$0.getContext$forest_release(), new String[]{Timing.GECKO_UPDATE_FINISH}, null, 2, null);
        ForestLogger.print$default(this.this$0.getContext$forest_release().getLogger(), 6, GeckoFetcher.TAG, "download failed with waitGeckoUpdate=" + this.$request.getWaitGeckoUpdate() + " ,channel = " + channel + ",bundle = " + this.$request.getGeckoModel().getBundle() + ',' + (throwable != null ? throwable.getMessage() : null), true, null, Timing.GECKO_UPDATE_FINISH, 16, null);
        this.$response.getErrorInfo().setError(ErrorInfo.Type.Gecko, 5, "CheckUpdate Failed:" + (throwable != null ? throwable.getMessage() : null));
        if (!this.$onlyLocal) {
            this.this$0.loadGeckoFile(this.$request, this.$response, false, null, this.$loaderConfig, new Function0<Unit>() { // from class: com.bytedance.forest.chain.fetchers.GeckoFetcher$pullGeckoPackage$1$onUpdateFailed$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m478invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m478invoke() {
                    GeckoFetcher$pullGeckoPackage$1.this.$callback.invoke(GeckoFetcher$pullGeckoPackage$1.this.$response);
                }
            });
        } else {
            ForestLogger.print$default(this.this$0.getContext$forest_release().getLogger(), 3, GeckoFetcher.TAG, "failed, skip callbacks when onlyLocal is true", false, null, null, 56, null);
        }
    }
}
