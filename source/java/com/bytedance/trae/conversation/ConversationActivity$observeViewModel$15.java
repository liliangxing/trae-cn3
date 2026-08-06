package com.bytedance.trae.conversation;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.chat.ConversationDetailFragment;
import com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog;
import com.bytedance.trae.conversation.databinding.TraeActivityConversationBinding;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.tracker.AIEventContext;
import com.bytedance.trae.conversation.tracker.AISendMessageContext;
import com.bytedance.trae.conversation.tracker.SoloChatMode;
import com.bytedance.trae.conversation.tracker.TraeAITracker;
import com.bytedance.trae.conversation.widget.InputFragment;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.service.CancelNotifyRequest;
import com.bytedance.trae.im.service.CancelNotifyResponse;
import com.bytedance.trae.im.service.ICancelNotifyApi;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.praise.PraiseDialogHelper;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeViewModel$15", f = "ConversationActivity.kt", i = {}, l = {995}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationActivity$observeViewModel$15 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationActivity$observeViewModel$15(ConversationActivity conversationActivity, Continuation<? super ConversationActivity$observeViewModel$15> continuation) {
        super(2, continuation);
        this.this$0 = conversationActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> conversationActivity$observeViewModel$15 = new ConversationActivity$observeViewModel$15(this.this$0, continuation);
        conversationActivity$observeViewModel$15.L$0 = obj;
        return conversationActivity$observeViewModel$15;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConversationActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeViewModel$15$1", f = "ConversationActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.ConversationActivity$observeViewModel$15$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06061 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$launch;
        int label;
        final /* synthetic */ ConversationActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06061(ConversationActivity conversationActivity, CoroutineScope coroutineScope, Continuation<? super C06061> continuation) {
            super(2, continuation);
            this.this$0 = conversationActivity;
            this.$$this$launch = coroutineScope;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06061(this.this$0, this.$$this$launch, continuation);
        }

        public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
            return create(unit, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0108, code lost:
        
            if (r2.equals("cancelled") == false) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0119, code lost:
        
            r8 = com.bytedance.trae.im.model.ConfirmInfo.STATUS_CANCELED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x010f, code lost:
        
            if (r2.equals("error") == false) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0116, code lost:
        
            if (r2.equals(com.bytedance.trae.im.model.ConfirmInfo.STATUS_CANCELED) == false) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0121, code lost:
        
            if (r2.equals("failed") == false) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x012a, code lost:
        
            if (r2.equals("completed") == false) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0132, code lost:
        
            if (r8 != null) goto L59;
         */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0137  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x013f  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x017b  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x018e  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x019b  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x01a8  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x01c0  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x021c  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01ab  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x019e  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0191  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x017f  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x013c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            InputFragment inputFragment;
            TraeActivityConversationBinding traeActivityConversationBinding;
            TraeActivityConversationBinding traeActivityConversationBinding2;
            TraeActivityConversationBinding traeActivityConversationBinding3;
            ConversationDetailFragment detailFragment;
            ConversationViewModel conversationViewModel;
            ConversationViewModel conversationViewModel2;
            String status;
            ConversationViewModel conversationViewModel3;
            String str;
            String str2;
            AISendMessageContext aISendMessageContext;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                inputFragment = this.this$0.getInputFragment();
                inputFragment.switchInputState(InputFragment.InputState.Input);
                FLogger.INSTANCE.i("CheckPointDialog", "taskDone: CheckpointDialog dismissIfShowing");
                CheckpointDialog.Companion companion = CheckpointDialog.INSTANCE;
                FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                companion.dismissIfShowing(supportFragmentManager);
                this.this$0.dismissPluginAuthBottomSheetIfShowing();
                this.this$0.isCheckpointDialogVisible = false;
                ConversationViewModel conversationViewModel4 = null;
                this.this$0.showingCheckpointToolCallId = null;
                traeActivityConversationBinding = this.this$0.binding;
                if (traeActivityConversationBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    traeActivityConversationBinding = null;
                }
                traeActivityConversationBinding.checkpointOverlayContainer.setTranslationY(0.0f);
                traeActivityConversationBinding2 = this.this$0.binding;
                if (traeActivityConversationBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    traeActivityConversationBinding2 = null;
                }
                traeActivityConversationBinding2.checkpointOverlayContainer.setVisibility(8);
                traeActivityConversationBinding3 = this.this$0.binding;
                if (traeActivityConversationBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    traeActivityConversationBinding3 = null;
                }
                traeActivityConversationBinding3.inputFragmentContainer.setVisibility(0);
                detailFragment = this.this$0.getDetailFragment();
                if (detailFragment != null) {
                    detailFragment.scrollToBottom();
                }
                conversationViewModel = this.this$0.viewModel;
                if (conversationViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    conversationViewModel = null;
                }
                String str3 = (String) conversationViewModel.getConversationId().getValue();
                String str4 = str3;
                if (!(str4 == null || str4.length() == 0) && this.this$0.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                    BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(str3, null), 3, (Object) null);
                }
                conversationViewModel2 = this.this$0.viewModel;
                if (conversationViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    conversationViewModel2 = null;
                }
                ParsedChatMessage lastDoneMessage = conversationViewModel2.getLastDoneMessage();
                String status2 = lastDoneMessage != null ? lastDoneMessage.getStatus() : null;
                if (status2 != null) {
                    status = "error";
                    switch (status2.hashCode()) {
                        case -1402931637:
                            break;
                        case -1281977283:
                            break;
                        case -123173735:
                            break;
                        case 96784904:
                            break;
                        case 476588369:
                            break;
                    }
                    Long chatStartTime = lastDoneMessage == null ? lastDoneMessage.getChatStartTime() : null;
                    Long chatEndTime = lastDoneMessage == null ? lastDoneMessage.getChatEndTime() : null;
                    double longValue = (chatStartTime != null || chatEndTime == null || chatEndTime.longValue() <= chatStartTime.longValue()) ? 0.0d : (chatEndTime.longValue() - chatStartTime.longValue()) / 1000.0d;
                    SoloChatMode resolveCurrentChatMode$default = ConversationActivity.resolveCurrentChatMode$default(this.this$0, null, 1, null);
                    conversationViewModel3 = this.this$0.viewModel;
                    if (conversationViewModel3 != null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        conversationViewModel4 = conversationViewModel3;
                    }
                    String str5 = (String) conversationViewModel4.getConversationId().getValue();
                    String str6 = str5 != null ? "" : str5;
                    str = this.this$0.streamingMessageId;
                    String str7 = str != null ? "" : str;
                    str2 = this.this$0.streamingChatModel;
                    AIEventContext aIEventContext = new AIEventContext(null, str6, str7, str2 != null ? "" : str2, 1, null);
                    TraeAITracker traeAITracker = TraeAITracker.INSTANCE;
                    aISendMessageContext = this.this$0.lastSendContext;
                    if (aISendMessageContext == null) {
                        aISendMessageContext = new AISendMessageContext(null, false, null, null, false, false, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 134217727, null);
                    }
                    traeAITracker.trackCompleteShow(aIEventContext, (r28 & 2) != 0 ? null : aISendMessageContext, status, (r28 & 8) != 0 ? 0.0d : longValue, (r28 & 16) != 0 ? 0 : 0, (r28 & 32) != 0 ? 0 : 0, (r28 & 64) != 0 ? 0 : 0, (r28 & 128) != 0 ? "" : null, (r28 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? 0 : 0, (r28 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? SoloChatMode.DEFAULT : resolveCurrentChatMode$default, (r28 & 1024) != 0 ? MapsKt.emptyMap() : null);
                    if (Intrinsics.areEqual(status, "success")) {
                        PraiseDialogHelper.INSTANCE.onTaskDoneAndTryShow((Context) this.this$0, "conversation");
                    }
                    return Unit.INSTANCE;
                }
                if (lastDoneMessage != null) {
                    status = lastDoneMessage.getStatus();
                }
                status = "success";
                if (lastDoneMessage == null) {
                }
                if (lastDoneMessage == null) {
                }
                double longValue2 = (chatStartTime != null || chatEndTime == null || chatEndTime.longValue() <= chatStartTime.longValue()) ? 0.0d : (chatEndTime.longValue() - chatStartTime.longValue()) / 1000.0d;
                SoloChatMode resolveCurrentChatMode$default2 = ConversationActivity.resolveCurrentChatMode$default(this.this$0, null, 1, null);
                conversationViewModel3 = this.this$0.viewModel;
                if (conversationViewModel3 != null) {
                }
                String str52 = (String) conversationViewModel4.getConversationId().getValue();
                if (str52 != null) {
                }
                str = this.this$0.streamingMessageId;
                if (str != null) {
                }
                str2 = this.this$0.streamingChatModel;
                AIEventContext aIEventContext2 = new AIEventContext(null, str6, str7, str2 != null ? "" : str2, 1, null);
                TraeAITracker traeAITracker2 = TraeAITracker.INSTANCE;
                aISendMessageContext = this.this$0.lastSendContext;
                if (aISendMessageContext == null) {
                }
                traeAITracker2.trackCompleteShow(aIEventContext2, (r28 & 2) != 0 ? null : aISendMessageContext, status, (r28 & 8) != 0 ? 0.0d : longValue2, (r28 & 16) != 0 ? 0 : 0, (r28 & 32) != 0 ? 0 : 0, (r28 & 64) != 0 ? 0 : 0, (r28 & 128) != 0 ? "" : null, (r28 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? 0 : 0, (r28 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? SoloChatMode.DEFAULT : resolveCurrentChatMode$default2, (r28 & 1024) != 0 ? MapsKt.emptyMap() : null);
                if (Intrinsics.areEqual(status, "success")) {
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ConversationActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeViewModel$15$1$1", f = "ConversationActivity.kt", i = {}, l = {1011}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.bytedance.trae.conversation.ConversationActivity$observeViewModel$15$1$1, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $convId;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$convId = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$convId, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: ConversationActivity.kt */
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/CancelNotifyResponse;", "Lcom/bytedance/trae/im/service/ICancelNotifyApi;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeViewModel$15$1$1$1", f = "ConversationActivity.kt", i = {}, l = {1012}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.bytedance.trae.conversation.ConversationActivity$observeViewModel$15$1$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
            public static final class C08731 extends SuspendLambda implements Function2<ICancelNotifyApi, Continuation<? super BizResponse<CancelNotifyResponse>>, Object> {
                final /* synthetic */ String $convId;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C08731(String str, Continuation<? super C08731> continuation) {
                    super(2, continuation);
                    this.$convId = str;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> c08731 = new C08731(this.$convId, continuation);
                    c08731.L$0 = obj;
                    return c08731;
                }

                public final Object invoke(ICancelNotifyApi iCancelNotifyApi, Continuation<? super BizResponse<CancelNotifyResponse>> continuation) {
                    return create(iCancelNotifyApi, continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        obj = ((ICancelNotifyApi) this.L$0).cancelNotify(new CancelNotifyRequest(this.$convId), (Continuation) this);
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

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (ICancelNotifyApi.INSTANCE.safeCall(new C08731(this.$convId, null), (Continuation) this) == coroutine_suspended) {
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
            if (FlowKt.collectLatest(conversationViewModel.getTaskDone(), new C06061(this.this$0, coroutineScope, null), (Continuation) this) == coroutine_suspended) {
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
