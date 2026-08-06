package com.bytedance.forest.chain.fetchers;

import com.bytedance.forest.model.ErrorInfo;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.model.LogReportNode;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.utils.ForestLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GeckoFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoFetcher$fetchAsync$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $accessKey;
    final /* synthetic */ String $bundle;
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ String $channel;
    final /* synthetic */ GeckoConfig $loaderConfig;
    final /* synthetic */ Request $request;
    final /* synthetic */ Response $response;
    final /* synthetic */ GeckoFetcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeckoFetcher$fetchAsync$4(GeckoFetcher geckoFetcher, Response response, Function1 function1, Request request, String str, String str2, GeckoConfig geckoConfig, String str3) {
        super(0);
        this.this$0 = geckoFetcher;
        this.$response = response;
        this.$callback = function1;
        this.$request = request;
        this.$accessKey = str;
        this.$channel = str2;
        this.$loaderConfig = geckoConfig;
        this.$bundle = str3;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m475invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m475invoke() {
        if (this.$response.getIsSucceed()) {
            this.$callback.invoke(this.$response);
            if (this.$request.getDisableGeckoUpdate()) {
                return;
            }
            GeckoFetcher geckoFetcher = this.this$0;
            geckoFetcher.checkUpdate(geckoFetcher.getForest(), this.$accessKey, this.$channel, this.$request.getUseInteraction(), GeckoFetcher.GECKO_SDK_INVOKE_ASYNC_TAG, new C11011());
            return;
        }
        if (this.$request.getDisableGeckoUpdate()) {
            ForestLogger.print$default(this.this$0.getContext$forest_release().getLogger(), 6, GeckoFetcher.TAG, "disable gecko update and no file exists", true, null, LogReportNode.GECKO_FETCH_ERROR, 16, null);
            this.$response.getErrorInfo().setError(ErrorInfo.Type.Gecko, 6, "disable gecko update and no file exists");
            this.$callback.invoke(this.$response);
        } else if (this.$request.getWaitGeckoUpdate()) {
            this.this$0.pullGeckoPackage(this.$request, this.$response, this.$callback, this.$loaderConfig);
        } else {
            this.$callback.invoke(this.$response);
        }
    }

    /* compiled from: GeckoFetcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J)\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"com/bytedance/forest/chain/fetchers/GeckoFetcher$fetchAsync$4$1", "Lcom/bytedance/forest/chain/fetchers/OnUpdateListener;", "onUpdateFailed", "", "channel", "", "throwable", "", "onUpdateSuccess", "path", "version", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* renamed from: com.bytedance.forest.chain.fetchers.GeckoFetcher$fetchAsync$4$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class C11011 implements OnUpdateListener {
        C11011() {
        }

        @Override // com.bytedance.forest.chain.fetchers.OnUpdateListener
        public void onUpdateSuccess(final String channel, String path, Long version) {
            Intrinsics.checkParameterIsNotNull(channel, "channel");
            ForestLogger.printOptimize$default(GeckoFetcher$fetchAsync$4.this.this$0.getContext$forest_release().getLogger(), 3, GeckoFetcher.TAG, false, null, null, new Function0<String>() { // from class: com.bytedance.forest.chain.fetchers.GeckoFetcher$fetchAsync$4$1$onUpdateSuccess$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final String invoke() {
                    return "onUpdateSuccess with accessKey=" + GeckoFetcher$fetchAsync$4.this.$loaderConfig.getAccessKey() + ", channel=" + channel + ",bundle=" + GeckoFetcher$fetchAsync$4.this.$bundle;
                }
            }, 28, null);
        }

        @Override // com.bytedance.forest.chain.fetchers.OnUpdateListener
        public void onUpdateFailed(final String channel, Throwable throwable) {
            Intrinsics.checkParameterIsNotNull(channel, "channel");
            ForestLogger.printOptimize$default(GeckoFetcher$fetchAsync$4.this.this$0.getContext$forest_release().getLogger(), 6, GeckoFetcher.TAG, false, throwable, null, new Function0<String>() { // from class: com.bytedance.forest.chain.fetchers.GeckoFetcher$fetchAsync$4$1$onUpdateFailed$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final String invoke() {
                    return "download failed with accessKey=" + GeckoFetcher$fetchAsync$4.this.$loaderConfig.getAccessKey() + ",channel = " + channel + ",bundle = " + GeckoFetcher$fetchAsync$4.this.$bundle;
                }
            }, 20, null);
        }
    }
}
