package com.bytedance.trae.home;

import android.content.Context;
import android.content.Intent;
import com.bytedance.trae.conversation.ConversationActivity;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.im.service.ConversationFullDetailResponse;
import com.bytedance.trae.im.service.IGetConversationFullDetailService;
import com.bytedance.trae.network.response.HttpDataResult;
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

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.MainActivity$navigateToConversationById$1", f = "MainActivity.kt", i = {}, l = {475}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class MainActivity$navigateToConversationById$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$navigateToConversationById$1(String str, MainActivity mainActivity, Continuation<? super MainActivity$navigateToConversationById$1> continuation) {
        super(2, continuation);
        this.$conversationId = str;
        this.this$0 = mainActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$navigateToConversationById$1(this.$conversationId, this.this$0, continuation);
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
            obj = IGetConversationFullDetailService.INSTANCE.getConversationFullDetailRawCall(this.$conversationId, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        HttpDataResult.Success success = (HttpDataResult) obj;
        if (success instanceof HttpDataResult.Success) {
            HttpDataResult.Success success2 = success;
            if (success2.getBizResp().isSuccess()) {
                Intent intent = new Intent((Context) this.this$0, (Class<?>) ConversationActivity.class);
                ConversationFullDetailResponse conversationFullDetailResponse = (ConversationFullDetailResponse) success2.getBizResp().getData();
                Conversation conversation = conversationFullDetailResponse != null ? conversationFullDetailResponse.getConversation() : null;
                if (conversation != null) {
                    ConversationFullDetailResponse conversationFullDetailResponse2 = (ConversationFullDetailResponse) success2.getBizResp().getData();
                    if (Intrinsics.areEqual(conversationFullDetailResponse2 != null ? conversationFullDetailResponse2.getCliProductType() : null, "remote")) {
                        conversation.setEnvironment("remote");
                    } else {
                        ConversationFullDetailResponse conversationFullDetailResponse3 = (ConversationFullDetailResponse) success2.getBizResp().getData();
                        if (Intrinsics.areEqual(conversationFullDetailResponse3 != null ? conversationFullDetailResponse3.getCliProductType() : null, "trae_work")) {
                            conversation.setEnvironment(CliType.LOCAL.getValue());
                        } else {
                            ConversationFullDetailResponse conversationFullDetailResponse4 = (ConversationFullDetailResponse) success2.getBizResp().getData();
                            if (Intrinsics.areEqual(conversationFullDetailResponse4 != null ? conversationFullDetailResponse4.getCliProductType() : null, "trae_ide")) {
                                conversation.setEnvironment(CliType.IDE.getValue());
                            }
                        }
                    }
                    intent.putExtra(ConversationActivity.EXTRA_CONVERSATION, conversation);
                    this.this$0.startActivity(intent);
                    this.this$0.overridePendingTransition(0, 0);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
