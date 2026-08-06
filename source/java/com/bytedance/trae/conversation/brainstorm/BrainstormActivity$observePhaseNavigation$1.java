package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.trae.conversation.AccountSettingsKeva;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormPhase;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrainstormActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormActivity$observePhaseNavigation$1", f = "BrainstormActivity.kt", i = {}, l = {378}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormActivity$observePhaseNavigation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BrainstormActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormActivity$observePhaseNavigation$1(BrainstormActivity brainstormActivity, Continuation<? super BrainstormActivity$observePhaseNavigation$1> continuation) {
        super(2, continuation);
        this.this$0 = brainstormActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrainstormActivity$observePhaseNavigation$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        BrainstormViewModel brainstormViewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            brainstormViewModel = this.this$0.viewModel;
            if (brainstormViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                brainstormViewModel = null;
            }
            final Flow uiState = brainstormViewModel.getUiState();
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<BrainstormPhase>() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1
                public Object collect(FlowCollector flowCollector, Continuation continuation) {
                    Object collect = uiState.collect(new AnonymousClass2(flowCollector), continuation);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }

                /* compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
                /* renamed from: com.bytedance.trae.conversation.brainstorm.BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2", f = "BrainstormActivity.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    /* renamed from: com.bytedance.trae.conversation.brainstorm.BrainstormActivity$observePhaseNavigation$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, (Continuation) this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        int i;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label -= Integer.MIN_VALUE;
                                Object obj2 = anonymousClass1.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                i = anonymousClass1.label;
                                if (i != 0) {
                                    ResultKt.throwOnFailure(obj2);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    BrainstormPhase phase = ((BrainstormUiState) obj).getPhase();
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(phase, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj2);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        anonymousClass1 = new AnonymousClass1(continuation);
                        Object obj22 = anonymousClass1.result;
                        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = anonymousClass1.label;
                        if (i != 0) {
                        }
                        return Unit.INSTANCE;
                    }
                }
            });
            final BrainstormActivity brainstormActivity = this.this$0;
            this.label = 1;
            if (distinctUntilChanged.collect(new FlowCollector() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormActivity$observePhaseNavigation$1.2

                /* compiled from: BrainstormActivity.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                /* renamed from: com.bytedance.trae.conversation.brainstorm.BrainstormActivity$observePhaseNavigation$1$2$WhenMappings */
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[BrainstormPhase.values().length];
                        try {
                            iArr[BrainstormPhase.Intro.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[BrainstormPhase.Discussing.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((BrainstormPhase) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(BrainstormPhase brainstormPhase, Continuation<? super Unit> continuation) {
                    int i2 = WhenMappings.$EnumSwitchMapping$0[brainstormPhase.ordinal()];
                    if (i2 == 1) {
                        return Unit.INSTANCE;
                    }
                    if (i2 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BrainstormActivity.this.getSupportFragmentManager().beginTransaction().setCustomAnimations(C0637R.anim.trae_fade_in, C0637R.anim.trae_fade_out).replace(C0637R.id.brainstorm_fragment_container, new DiscussingFragment()).commitNow();
                    AccountSettingsKeva.INSTANCE.getKeva().storeBoolean("brainstorm_has_seen_intro", true);
                    return Unit.INSTANCE;
                }
            }, (Continuation) this) == coroutine_suspended) {
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
