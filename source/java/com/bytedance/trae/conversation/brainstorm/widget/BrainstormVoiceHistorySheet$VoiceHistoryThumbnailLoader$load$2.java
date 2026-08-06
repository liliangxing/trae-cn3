package com.bytedance.trae.conversation.brainstorm.widget;

import com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrainstormVoiceHistorySheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2", f = "BrainstormVoiceHistorySheet.kt", i = {}, l = {754}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $imageId;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ BrainstormVoiceHistorySheet.HistoryRow.UserAttachment $row;
    final /* synthetic */ String $source;
    int label;
    final /* synthetic */ BrainstormVoiceHistorySheet.VoiceHistoryThumbnailLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2(BrainstormVoiceHistorySheet.VoiceHistoryThumbnailLoader voiceHistoryThumbnailLoader, String str, String str2, String str3, BrainstormVoiceHistorySheet.HistoryRow.UserAttachment userAttachment, Continuation<? super BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2> continuation) {
        super(2, continuation);
        this.this$0 = voiceHistoryThumbnailLoader;
        this.$source = str;
        this.$resourceId = str2;
        this.$imageId = str3;
        this.$row = userAttachment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2(this.this$0, this.$source, this.$resourceId, this.$imageId, this.$row, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new C0678xb7f0f9ad(this.$imageId, this.$resourceId, this.this$0, this.$row, null), (Continuation) this);
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
        str = this.this$0.boundImageSource;
        if (Intrinsics.areEqual(str, this.$source)) {
            String str3 = str2;
            if (!(str3 == null || StringsKt.isBlank(str3))) {
                ResourceRepoManager.INSTANCE.put(this.$source, str2);
                this.this$0.loadPreviewUrl(this.$source, str2, this.$resourceId != null);
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }
}
