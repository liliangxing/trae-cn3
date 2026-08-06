package com.bytedance.trae.conversation.products;

import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.trae.conversation.chat.block.renderer.ArtifactTrack;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.products.ArtifactPreviewActivity$downloadAndShowTxt$1", f = "ArtifactPreviewActivity.kt", i = {}, l = {673}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactPreviewActivity$downloadAndShowTxt$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fileUrl;
    int label;
    final /* synthetic */ ArtifactPreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactPreviewActivity$downloadAndShowTxt$1(ArtifactPreviewActivity artifactPreviewActivity, String str, Continuation<? super ArtifactPreviewActivity$downloadAndShowTxt$1> continuation) {
        super(2, continuation);
        this.this$0 = artifactPreviewActivity;
        this.$fileUrl = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArtifactPreviewActivity$downloadAndShowTxt$1(this.this$0, this.$fileUrl, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ProgressBar progressBar;
        String str;
        String str2;
        ScrollView scrollView;
        TextView textView;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        TextView textView2 = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new ArtifactPreviewActivity$downloadAndShowTxt$1$content$1(this.this$0, this.$fileUrl, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        String str3 = (String) obj;
        progressBar = this.this$0.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        if (str3 == null) {
            this.this$0.showError();
        } else {
            ArtifactTrack artifactTrack = ArtifactTrack.INSTANCE;
            str = this.this$0.path;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("path");
                str = null;
            }
            str2 = this.this$0.messageId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageId");
                str2 = null;
            }
            artifactTrack.trackArtifactOpen(str, str2);
            scrollView = this.this$0.scrollTxt;
            if (scrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollTxt");
                scrollView = null;
            }
            scrollView.setVisibility(0);
            textView = this.this$0.tvTxt;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTxt");
            } else {
                textView2 = textView;
            }
            textView2.setText(str3);
        }
        return Unit.INSTANCE;
    }
}
