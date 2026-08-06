package com.bytedance.trae.conversation.devices;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.bytedance.trae.conversation.devices.BindingGuideStableState;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.tracker.DevicePairingEventTracker;
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
/* compiled from: ConnectComputerGuideFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$observeBindingState$1", f = "ConnectComputerGuideFragment.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConnectComputerGuideFragment$observeBindingState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConnectComputerGuideFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectComputerGuideFragment$observeBindingState$1(ConnectComputerGuideFragment connectComputerGuideFragment, Continuation<? super ConnectComputerGuideFragment$observeBindingState$1> continuation) {
        super(2, continuation);
        this.this$0 = connectComputerGuideFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConnectComputerGuideFragment$observeBindingState$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConnectComputerGuideFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$observeBindingState$1$1", f = "ConnectComputerGuideFragment.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$observeBindingState$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ConnectComputerGuideFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07151(ConnectComputerGuideFragment connectComputerGuideFragment, Continuation<? super C07151> continuation) {
            super(2, continuation);
            this.this$0 = connectComputerGuideFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07151(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ConnectComputerGuideFragment.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "state", "Lcom/bytedance/trae/conversation/devices/BindingGuideState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$observeBindingState$1$1$1", f = "ConnectComputerGuideFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$observeBindingState$1$1$1, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<BindingGuideState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ConnectComputerGuideFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ConnectComputerGuideFragment connectComputerGuideFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = connectComputerGuideFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(BindingGuideState bindingGuideState, Continuation<? super Unit> continuation) {
                return create(bindingGuideState, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                DevicePairingEventTracker devicePairingEventTracker;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    BindingGuideState bindingGuideState = (BindingGuideState) this.L$0;
                    this.this$0.renderBindingState(bindingGuideState.getDisplayState());
                    if (bindingGuideState.getDisplayState() instanceof BindingGuideStableState.Succeeded) {
                        devicePairingEventTracker = this.this$0.pairingEventTracker;
                        if (devicePairingEventTracker != null) {
                            devicePairingEventTracker.onPairingSucceeded();
                        }
                        this.this$0.scheduleSuccessCompletion();
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invokeSuspend(Object obj) {
            ConnectComputerGuideViewModel connectComputerGuideViewModel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                connectComputerGuideViewModel = this.this$0.viewModel;
                if (connectComputerGuideViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    connectComputerGuideViewModel = null;
                }
                this.label = 1;
                if (FlowKt.collectLatest(connectComputerGuideViewModel.getState(), new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new C07151(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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
