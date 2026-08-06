package com.bytedance.trae.conversation.products;

import android.widget.ProgressBar;
import android.widget.ScrollView;
import com.bytedance.trae.conversation.chat.block.renderer.ArtifactTrack;
import com.bytedance.trae.conversation.chat.block.renderer.MarkdownHelper;
import com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
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
/* compiled from: ArtifactPreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.ArtifactPreviewActivity$loadMarkdownPreview$1", f = "ArtifactPreviewActivity.kt", i = {}, l = {692}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactPreviewActivity$loadMarkdownPreview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatSessionId;
    final /* synthetic */ String $fileUrl;
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ ArtifactPreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactPreviewActivity$loadMarkdownPreview$1(String str, ArtifactPreviewActivity artifactPreviewActivity, String str2, String str3, Continuation<? super ArtifactPreviewActivity$loadMarkdownPreview$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.this$0 = artifactPreviewActivity;
        this.$fileUrl = str2;
        this.$chatSessionId = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArtifactPreviewActivity$loadMarkdownPreview$1(this.$path, this.this$0, this.$fileUrl, this.$chatSessionId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        ProgressBar progressBar;
        ScrollView scrollView;
        SimpleMarkdownTextView simpleMarkdownTextView;
        SimpleMarkdownTextView simpleMarkdownTextView2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new ArtifactPreviewActivity$loadMarkdownPreview$1$content$1(this.this$0, this.$fileUrl, null), (Continuation) this);
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
        ArtifactTrack artifactTrack = ArtifactTrack.INSTANCE;
        String str3 = this.$path;
        str = this.this$0.messageId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageId");
            str = null;
        }
        artifactTrack.trackArtifactOpen(str3, str);
        progressBar = this.this$0.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        if (str2 != null) {
            scrollView = this.this$0.scrollMarkdown;
            if (scrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollMarkdown");
                scrollView = null;
            }
            scrollView.setVisibility(0);
            MarkdownHelper markdownHelper = MarkdownHelper.INSTANCE;
            simpleMarkdownTextView = this.this$0.tvMarkdown;
            if (simpleMarkdownTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvMarkdown");
                simpleMarkdownTextView2 = null;
            } else {
                simpleMarkdownTextView2 = simpleMarkdownTextView;
            }
            MarkdownHelper.setMarkdownContent$default(markdownHelper, simpleMarkdownTextView2, str2, true, null, 8, null);
        } else {
            this.this$0.showError();
        }
        this.this$0.setupDownloadButtons(this.$fileUrl, this.$chatSessionId, this.$path);
        return Unit.INSTANCE;
    }
}
