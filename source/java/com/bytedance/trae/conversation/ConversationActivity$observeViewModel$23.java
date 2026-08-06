package com.bytedance.trae.conversation;

import android.os.SystemClock;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.tracker.AIEventContext;
import com.bytedance.trae.conversation.tracker.SoloChatMode;
import com.bytedance.trae.conversation.tracker.TraeAITracker;
import com.bytedance.trae.conversation.widget.InputFragment;
import com.bytedance.trae.im.model.ParsedChatMessage;
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
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeViewModel$23", f = "ConversationActivity.kt", i = {}, l = {1120}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationActivity$observeViewModel$23 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationActivity$observeViewModel$23(ConversationActivity conversationActivity, Continuation<? super ConversationActivity$observeViewModel$23> continuation) {
        super(2, continuation);
        this.this$0 = conversationActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> conversationActivity$observeViewModel$23 = new ConversationActivity$observeViewModel$23(this.this$0, continuation);
        conversationActivity$observeViewModel$23.L$0 = obj;
        return conversationActivity$observeViewModel$23;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConversationActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "success", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeViewModel$23$1", f = "ConversationActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.ConversationActivity$observeViewModel$23$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06141 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$launch;
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ ConversationActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06141(ConversationActivity conversationActivity, CoroutineScope coroutineScope, Continuation<? super C06141> continuation) {
            super(2, continuation);
            this.this$0 = conversationActivity;
            this.$$this$launch = coroutineScope;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c06141 = new C06141(this.this$0, this.$$this$launch, continuation);
            c06141.Z$0 = ((Boolean) obj).booleanValue();
            return c06141;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) obj2);
        }

        public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
            return create(Boolean.valueOf(z), continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00bf  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0096  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            InputFragment inputFragment;
            InputFragment inputFragment2;
            boolean z;
            ConversationViewModel conversationViewModel;
            long j;
            double d;
            long elapsedRealtime;
            long j2;
            ConversationViewModel conversationViewModel2;
            String str;
            String str2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.Z$0) {
                inputFragment2 = this.this$0.getInputFragment();
                inputFragment2.switchInputState(InputFragment.InputState.Input);
                z = this.this$0.wasUserInitiatedCancel;
                if (z) {
                    conversationViewModel = this.this$0.viewModel;
                    ConversationViewModel conversationViewModel3 = null;
                    if (conversationViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        conversationViewModel = null;
                    }
                    ParsedChatMessage lastDoneMessage = conversationViewModel.getLastDoneMessage();
                    ConversationActivity conversationActivity = this.this$0;
                    Long chatStartTime = lastDoneMessage != null ? lastDoneMessage.getChatStartTime() : null;
                    Long chatEndTime = lastDoneMessage != null ? lastDoneMessage.getChatEndTime() : null;
                    if (chatStartTime == null || chatEndTime == null || chatEndTime.longValue() <= chatStartTime.longValue()) {
                        j = conversationActivity.streamingStartTimeMs;
                        if (j > 0) {
                            elapsedRealtime = SystemClock.elapsedRealtime();
                            j2 = conversationActivity.streamingStartTimeMs;
                        } else {
                            d = 0.0d;
                            double d2 = d;
                            SoloChatMode resolveCurrentChatMode$default = ConversationActivity.resolveCurrentChatMode$default(this.this$0, null, 1, null);
                            conversationViewModel2 = this.this$0.viewModel;
                            if (conversationViewModel2 != null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            } else {
                                conversationViewModel3 = conversationViewModel2;
                            }
                            String str3 = (String) conversationViewModel3.getConversationId().getValue();
                            String str4 = str3 != null ? "" : str3;
                            str = this.this$0.streamingMessageId;
                            String str5 = str != null ? "" : str;
                            str2 = this.this$0.streamingChatModel;
                            TraeAITracker.INSTANCE.trackCanceled(new AIEventContext(null, str4, str5, str2 != null ? "" : str2, 1, null), "user_click", "streaming", (r18 & 8) != 0 ? 0.0d : d2, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? SoloChatMode.DEFAULT : resolveCurrentChatMode$default);
                        }
                    } else {
                        elapsedRealtime = chatEndTime.longValue();
                        j2 = chatStartTime.longValue();
                    }
                    d = (elapsedRealtime - j2) / 1000.0d;
                    double d22 = d;
                    SoloChatMode resolveCurrentChatMode$default2 = ConversationActivity.resolveCurrentChatMode$default(this.this$0, null, 1, null);
                    conversationViewModel2 = this.this$0.viewModel;
                    if (conversationViewModel2 != null) {
                    }
                    String str32 = (String) conversationViewModel3.getConversationId().getValue();
                    if (str32 != null) {
                    }
                    str = this.this$0.streamingMessageId;
                    if (str != null) {
                    }
                    str2 = this.this$0.streamingChatModel;
                    TraeAITracker.INSTANCE.trackCanceled(new AIEventContext(null, str4, str5, str2 != null ? "" : str2, 1, null), "user_click", "streaming", (r18 & 8) != 0 ? 0.0d : d22, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? SoloChatMode.DEFAULT : resolveCurrentChatMode$default2);
                }
            } else {
                inputFragment = this.this$0.getInputFragment();
                inputFragment.switchInputSended();
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        ConversationViewModel conversationViewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            conversationViewModel = this.this$0.viewModel;
            if (conversationViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel = null;
            }
            this.label = 1;
            if (FlowKt.collectLatest(conversationViewModel.getCancelTaskResult(), new C06141(this.this$0, coroutineScope, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
