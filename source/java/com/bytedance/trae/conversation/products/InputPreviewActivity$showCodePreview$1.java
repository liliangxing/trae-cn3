package com.bytedance.trae.conversation.products;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetHtml;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputPreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.InputPreviewActivity$showCodePreview$1", f = "InputPreviewActivity.kt", i = {}, l = {438}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputPreviewActivity$showCodePreview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fileUrl;
    int label;
    final /* synthetic */ InputPreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputPreviewActivity$showCodePreview$1(InputPreviewActivity inputPreviewActivity, String str, Continuation<? super InputPreviewActivity$showCodePreview$1> continuation) {
        super(2, continuation);
        this.this$0 = inputPreviewActivity;
        this.$fileUrl = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputPreviewActivity$showCodePreview$1(this.this$0, this.$fileUrl, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ProgressBar progressBar;
        String str;
        String buildCodeHighlightHtml;
        WebView webView;
        WebView webView2;
        WebView webView3;
        WebView webView4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new InputPreviewActivity$showCodePreview$1$content$1(this.this$0, this.$fileUrl, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        String str2 = (String) obj;
        progressBar = this.this$0.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        if (str2 != null) {
            str = this.this$0.fileName;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileName");
                str = null;
            }
            String lowerCase = StringsKt.substringAfterLast(str, '.', "").toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            buildCodeHighlightHtml = this.this$0.buildCodeHighlightHtml(str2, lowerCase);
            webView = this.this$0.webView;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView = null;
            }
            webView.setVisibility(0);
            webView2 = this.this$0.webView;
            if (webView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView2 = null;
            }
            WebSettings settings = webView2.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setDefaultTextEncodingName("UTF-8");
            webView3 = this.this$0.webView;
            if (webView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView4 = null;
            } else {
                webView4 = webView3;
            }
            webView4.loadDataWithBaseURL("https://localhost", buildCodeHighlightHtml, PureShowWidgetHtml.MIME_TYPE, "UTF-8", null);
        } else {
            this.this$0.showError();
        }
        return Unit.INSTANCE;
    }
}
