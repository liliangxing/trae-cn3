package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ArtifactsRenderer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$resolveImageUri$cacheFile$1", f = "ArtifactsRenderer.kt", i = {}, l = {2190}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class ArtifactsRenderer$resolveImageUri$cacheFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ FileDownloadHelper $fileDownloadHelper;
    final /* synthetic */ String $target;
    final /* synthetic */ Ref.ObjectRef<String> $url;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactsRenderer$resolveImageUri$cacheFile$1(FileDownloadHelper fileDownloadHelper, Context context, Ref.ObjectRef<String> objectRef, String str, String str2, Continuation<? super ArtifactsRenderer$resolveImageUri$cacheFile$1> continuation) {
        super(2, continuation);
        this.$fileDownloadHelper = fileDownloadHelper;
        this.$context = context;
        this.$url = objectRef;
        this.$conversationId = str;
        this.$target = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArtifactsRenderer$resolveImageUri$cacheFile$1(this.$fileDownloadHelper, this.$context, this.$url, this.$conversationId, this.$target, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FileDownloadHelper fileDownloadHelper = this.$fileDownloadHelper;
            Context applicationContext = this.$context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            this.label = 1;
            obj = fileDownloadHelper.downloadToCache(applicationContext, (String) this.$url.element, this.$conversationId, this.$target, (r19 & 16) != 0 ? false : true, (r19 & 32) != 0 ? 0L : 0L, (Continuation) this);
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
