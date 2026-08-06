package com.bytedance.trae.conversation.products;

import android.webkit.WebView;
import android.widget.ProgressBar;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.products.PreviewWebViewActivity;
import com.bytedance.trae.multilanguage.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreviewWebViewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.PreviewWebViewActivity$onCreate$2$1", f = "PreviewWebViewActivity.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PreviewWebViewActivity$onCreate$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatSessionId;
    final /* synthetic */ String $cliType;
    final /* synthetic */ String $rawUrl;
    int label;
    final /* synthetic */ PreviewWebViewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewWebViewActivity$onCreate$2$1(PreviewWebViewActivity previewWebViewActivity, String str, String str2, String str3, Continuation<? super PreviewWebViewActivity$onCreate$2$1> continuation) {
        super(2, continuation);
        this.this$0 = previewWebViewActivity;
        this.$rawUrl = str;
        this.$chatSessionId = str2;
        this.$cliType = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreviewWebViewActivity$onCreate$2$1(this.this$0, this.$rawUrl, this.$chatSessionId, this.$cliType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ProgressBar progressBar;
        WebView webView;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new PreviewWebViewActivity$onCreate$2$1$result$1(this.this$0, this.$rawUrl, this.$chatSessionId, this.$cliType, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PreviewWebViewActivity.ResolveResult resolveResult = (PreviewWebViewActivity.ResolveResult) obj;
        progressBar = this.this$0.progressBar;
        WebView webView2 = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setIndeterminate(false);
        if (resolveResult instanceof PreviewWebViewActivity.ResolveResult.Success) {
            webView = this.this$0.webView;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            } else {
                webView2 = webView;
            }
            webView2.loadUrl(((PreviewWebViewActivity.ResolveResult.Success) resolveResult).getUrl());
        } else if (resolveResult instanceof PreviewWebViewActivity.ResolveResult.ServiceNotRunning) {
            PreviewWebViewActivity.showError$default(this.this$0, R.string.trae_doc_preview_service_not_running, R.string.trae_doc_preview_service_stopped, false, true, 4, null);
        } else {
            if (!(resolveResult instanceof PreviewWebViewActivity.ResolveResult.NetworkError)) {
                throw new NoWhenBranchMatchedException();
            }
            PreviewWebViewActivity.showError$default(this.this$0, R.string.trae_conversation_network_disconnected, R.string.trae_network_error_check_connection, true, false, 8, null);
        }
        return Unit.INSTANCE;
    }
}
