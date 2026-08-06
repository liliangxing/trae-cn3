package com.bytedance.trae.conversation.brainstorm.fragment;

import com.bytedance.trae.conversation.brainstorm.BrainstormViewModel;
import com.bytedance.trae.conversation.brainstorm.widget.VoiceStatusWaveIconView;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiscussingFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$observeState$3", f = "DiscussingFragment.kt", i = {}, l = {998}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DiscussingFragment$observeState$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DiscussingFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscussingFragment$observeState$3(DiscussingFragment discussingFragment, Continuation<? super DiscussingFragment$observeState$3> continuation) {
        super(2, continuation);
        this.this$0 = discussingFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiscussingFragment$observeState$3(this.this$0, continuation);
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
            SharedFlow<Float> localAudioVolume = brainstormViewModel.getLocalAudioVolume();
            final DiscussingFragment discussingFragment = this.this$0;
            this.label = 1;
            if (localAudioVolume.collect(new FlowCollector() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$observeState$3.1
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Number) obj2).floatValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(float f, Continuation<? super Unit> continuation) {
                    boolean z;
                    VoiceStatusWaveIconView voiceStatusWaveIconView;
                    z = DiscussingFragment.this.curIsMicMuted;
                    if (!z) {
                        voiceStatusWaveIconView = DiscussingFragment.this.mainWaveform;
                        if (voiceStatusWaveIconView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mainWaveform");
                            voiceStatusWaveIconView = null;
                        }
                        voiceStatusWaveIconView.updateVolume(f);
                    }
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
        throw new KotlinNothingValueException();
    }
}
