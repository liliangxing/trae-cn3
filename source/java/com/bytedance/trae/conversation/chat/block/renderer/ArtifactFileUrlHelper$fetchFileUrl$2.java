package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.CliType;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactFileUrlHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper$fetchFileUrl$2", f = "ArtifactFileUrlHelper.kt", i = {}, l = {52, 54}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactFileUrlHelper$fetchFileUrl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArtifactFileUrlHelper.FileUrlResult>, Object> {
    final /* synthetic */ String $chatSessionId;
    final /* synthetic */ String $cliType;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $path;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactFileUrlHelper$fetchFileUrl$2(String str, String str2, String str3, String str4, String str5, Continuation<? super ArtifactFileUrlHelper$fetchFileUrl$2> continuation) {
        super(2, continuation);
        this.$cliType = str;
        this.$chatSessionId = str2;
        this.$path = str3;
        this.$conversationId = str4;
        this.$messageId = str5;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArtifactFileUrlHelper$fetchFileUrl$2(this.$cliType, this.$chatSessionId, this.$path, this.$conversationId, this.$messageId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArtifactFileUrlHelper.FileUrlResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return (ArtifactFileUrlHelper.FileUrlResult) obj;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return (ArtifactFileUrlHelper.FileUrlResult) obj;
        }
        ResultKt.throwOnFailure(obj);
        if (Intrinsics.areEqual(this.$cliType, CliType.REMOTE.getValue())) {
            this.label = 1;
            obj = ArtifactFileUrlHelper.INSTANCE.fetchRemoteFileUrl(this.$chatSessionId, this.$path, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            return (ArtifactFileUrlHelper.FileUrlResult) obj;
        }
        this.label = 2;
        obj = ArtifactFileUrlHelper.INSTANCE.fetchLocalFileUrl(this.$path, this.$conversationId, this.$messageId, (Continuation) this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        return (ArtifactFileUrlHelper.FileUrlResult) obj;
    }
}
