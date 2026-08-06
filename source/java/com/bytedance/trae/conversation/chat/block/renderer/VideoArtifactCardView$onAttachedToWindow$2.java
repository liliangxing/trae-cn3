package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.trae.conversation.imageupload.ResourceRepoManager;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: VideoArtifactCardView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.VideoArtifactCardView$onAttachedToWindow$2", f = "VideoArtifactCardView.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class VideoArtifactCardView$onAttachedToWindow$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $lastFrameUri;
    int label;
    final /* synthetic */ VideoArtifactCardView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoArtifactCardView$onAttachedToWindow$2(String str, VideoArtifactCardView videoArtifactCardView, Continuation<? super VideoArtifactCardView$onAttachedToWindow$2> continuation) {
        super(2, continuation);
        this.$lastFrameUri = str;
        this.this$0 = videoArtifactCardView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoArtifactCardView$onAttachedToWindow$2(this.$lastFrameUri, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1(this.this$0, this.$lastFrameUri, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        String str = (String) obj;
        if (str != null) {
            String str2 = StringsKt.isBlank(str) ^ true ? str : null;
            if (str2 != null) {
                ResourceRepoManager.INSTANCE.put(this.$lastFrameUri, str2);
                this.this$0.loadLastFrame(str2);
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }
}
