package com.bytedance.trae.conversation.brainstorm.widget;

import android.net.Uri;
import com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import java.io.File;
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
/* compiled from: BrainstormVoiceHistorySheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$loadPreviewUrl$1", f = "BrainstormVoiceHistorySheet.kt", i = {}, l = {787}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$loadPreviewUrl$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0679x9b8e62fb extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $source;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ BrainstormVoiceHistorySheet.VoiceHistoryThumbnailLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0679x9b8e62fb(BrainstormVoiceHistorySheet.VoiceHistoryThumbnailLoader voiceHistoryThumbnailLoader, String str, String str2, Continuation<? super C0679x9b8e62fb> continuation) {
        super(2, continuation);
        this.this$0 = voiceHistoryThumbnailLoader;
        this.$source = str;
        this.$url = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0679x9b8e62fb(this.this$0, this.$source, this.$url, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        SimpleDraweeView simpleDraweeView;
        SimpleDraweeView simpleDraweeView2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new C0680xd8f70102(this.this$0, this.$url, this.$source, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        File file = (File) obj;
        str = this.this$0.boundImageSource;
        if (!Intrinsics.areEqual(str, this.$source)) {
            return Unit.INSTANCE;
        }
        if (file != null && file.exists() && file.length() > 0) {
            simpleDraweeView = this.this$0.previewView;
            PipelineDraweeControllerBuilder autoPlayAnimations = Fresco.newDraweeControllerBuilder().setUri(Uri.fromFile(file)).setAutoPlayAnimations(true);
            simpleDraweeView2 = this.this$0.previewView;
            simpleDraweeView.setController(autoPlayAnimations.setOldController(simpleDraweeView2.getController()).build());
        }
        return Unit.INSTANCE;
    }
}
