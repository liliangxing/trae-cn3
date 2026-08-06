package com.bytedance.trae.conversation.brainstorm.widget;

import android.content.Context;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.products.FileDownloadHelper;
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
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BrainstormVoiceHistorySheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$loadPreviewUrl$1$cacheFile$1", f = "BrainstormVoiceHistorySheet.kt", i = {}, l = {788}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$loadPreviewUrl$1$cacheFile$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class C0680xd8f70102 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ String $source;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ BrainstormVoiceHistorySheet.VoiceHistoryThumbnailLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0680xd8f70102(BrainstormVoiceHistorySheet.VoiceHistoryThumbnailLoader voiceHistoryThumbnailLoader, String str, String str2, Continuation<? super C0680xd8f70102> continuation) {
        super(2, continuation);
        this.this$0 = voiceHistoryThumbnailLoader;
        this.$url = str;
        this.$source = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0680xd8f70102(this.this$0, this.$url, this.$source, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        FileDownloadHelper fileDownloadHelper;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            fileDownloadHelper = this.this$0.fileDownloadHelper;
            Context applicationContext = AppHost.INSTANCE.getApplication().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            this.label = 1;
            obj = fileDownloadHelper.downloadToCache(applicationContext, this.$url, "voice_history_remote_resource", this.$source, (r19 & 16) != 0 ? false : true, (r19 & 32) != 0 ? 0L : 0L, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
