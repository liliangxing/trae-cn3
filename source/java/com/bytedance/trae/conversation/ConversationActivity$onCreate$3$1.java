package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: ConversationActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$onCreate$3$1", f = "ConversationActivity.kt", i = {1, 2}, l = {477, 480, 481, 491}, m = "invokeSuspend", n = {"retryCount", "retryCount"}, s = {"I$0", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class ConversationActivity$onCreate$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    int I$0;
    int label;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationActivity$onCreate$3$1(String str, ConversationActivity conversationActivity, Continuation<? super ConversationActivity$onCreate$3$1> continuation) {
        super(2, continuation);
        this.$id = str;
        this.this$0 = conversationActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationActivity$onCreate$3$1(this.$id, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007e A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x007c -> B:14:0x007f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.trae.conversation.ConversationActivity$onCreate$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConversationActivity.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.bytedance.trae.conversation.ConversationActivity$onCreate$3$1$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06242<T> implements FlowCollector {
        final /* synthetic */ String $id;
        final /* synthetic */ Ref.BooleanRef $pendingFetch;
        final /* synthetic */ ConversationActivity this$0;

        C06242(Ref.BooleanRef booleanRef, String str, ConversationActivity conversationActivity) {
            this.$pendingFetch = booleanRef;
            this.$id = str;
            this.this$0 = conversationActivity;
        }

        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(boolean z, Continuation<? super Unit> continuation) {
            ConversationActivity$onCreate$3$1$2$emit$1 conversationActivity$onCreate$3$1$2$emit$1;
            int i;
            C06242<T> c06242;
            HttpDataResult.Success success;
            ConversationViewModel conversationViewModel;
            if (continuation instanceof ConversationActivity$onCreate$3$1$2$emit$1) {
                conversationActivity$onCreate$3$1$2$emit$1 = (ConversationActivity$onCreate$3$1$2$emit$1) continuation;
                if ((conversationActivity$onCreate$3$1$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                    conversationActivity$onCreate$3$1$2$emit$1.label -= Integer.MIN_VALUE;
                    Object obj = conversationActivity$onCreate$3$1$2$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = conversationActivity$onCreate$3$1$2$emit$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (this.$pendingFetch.element) {
                            this.$pendingFetch.element = false;
                            IGetConversationFullDetailService.Companion companion = IGetConversationFullDetailService.INSTANCE;
                            String str = this.$id;
                            conversationActivity$onCreate$3$1$2$emit$1.L$0 = this;
                            conversationActivity$onCreate$3$1$2$emit$1.label = 1;
                            obj = companion.getConversationFullDetailRawCall(str, conversationActivity$onCreate$3$1$2$emit$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            c06242 = this;
                        }
                        return Unit.INSTANCE;
                    }
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    c06242 = (C06242) conversationActivity$onCreate$3$1$2$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    success = (HttpDataResult) obj;
                    if (success instanceof HttpDataResult.Success) {
                        HttpDataResult.Success success2 = success;
                        if (success2.getBizResp().isSuccess()) {
                            conversationViewModel = c06242.this$0.viewModel;
                            if (conversationViewModel == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                conversationViewModel = null;
                            }
                            conversationViewModel.onConversationFullDetailLoaded((ConversationFullDetailResponse) success2.getBizResp().getData());
                            return Unit.INSTANCE;
                        }
                    }
                    c06242.$pendingFetch.element = true;
                    return Unit.INSTANCE;
                }
            }
            conversationActivity$onCreate$3$1$2$emit$1 = new ConversationActivity$onCreate$3$1$2$emit$1(this, continuation);
            Object obj2 = conversationActivity$onCreate$3$1$2$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = conversationActivity$onCreate$3$1$2$emit$1.label;
            if (i != 0) {
            }
            success = (HttpDataResult) obj2;
            if (success instanceof HttpDataResult.Success) {
            }
            c06242.$pendingFetch.element = true;
            return Unit.INSTANCE;
        }
    }
}
