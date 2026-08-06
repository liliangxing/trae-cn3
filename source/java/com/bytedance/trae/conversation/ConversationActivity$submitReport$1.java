package com.bytedance.trae.conversation;

import android.content.Context;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.IReportMessageApi;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$submitReport$1", f = "ConversationActivity.kt", i = {}, l = {2532}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationActivity$submitReport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $messageId;
    int label;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationActivity$submitReport$1(ConversationActivity conversationActivity, String str, String str2, String str3, Continuation<? super ConversationActivity$submitReport$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationActivity;
        this.$conversationId = str;
        this.$messageId = str2;
        this.$content = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationActivity$submitReport$1(this.this$0, this.$conversationId, this.$messageId, this.$content, continuation);
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
            obj = IReportMessageApi.INSTANCE.safeCall(new ConversationActivity$submitReport$1$result$1(this.$conversationId, this.$messageId, this.$content, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        HttpDataResult httpDataResult = (HttpDataResult) obj;
        if (httpDataResult instanceof HttpDataResult.Success) {
            CustomToast.showLong((Context) this.this$0, C0637R.string.trae_report_submit_success);
        } else {
            if (!(httpDataResult instanceof HttpDataResult.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            CustomToast.showLong((Context) this.this$0, C0637R.string.trae_report_submit_failed);
        }
        return Unit.INSTANCE;
    }
}
