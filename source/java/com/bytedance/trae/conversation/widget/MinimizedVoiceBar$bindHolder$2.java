package com.bytedance.trae.conversation.widget;

import com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder;
import com.bytedance.trae.conversation.brainstorm.widget.VoiceStatusWaveIconView;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MinimizedVoiceBar.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.widget.MinimizedVoiceBar$bindHolder$2", f = "MinimizedVoiceBar.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MinimizedVoiceBar$bindHolder$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MinimizedVoiceBar this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MinimizedVoiceBar$bindHolder$2(MinimizedVoiceBar minimizedVoiceBar, Continuation<? super MinimizedVoiceBar$bindHolder$2> continuation) {
        super(2, continuation);
        this.this$0 = minimizedVoiceBar;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MinimizedVoiceBar$bindHolder$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MinimizedVoiceBar.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "volume", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.widget.MinimizedVoiceBar$bindHolder$2$1", f = "MinimizedVoiceBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.widget.MinimizedVoiceBar$bindHolder$2$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C08141 extends SuspendLambda implements Function2<Float, Continuation<? super Unit>, Object> {
        /* synthetic */ float F$0;
        int label;
        final /* synthetic */ MinimizedVoiceBar this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08141(MinimizedVoiceBar minimizedVoiceBar, Continuation<? super C08141> continuation) {
            super(2, continuation);
            this.this$0 = minimizedVoiceBar;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c08141 = new C08141(this.this$0, continuation);
            c08141.F$0 = ((Number) obj).floatValue();
            return c08141;
        }

        public final Object invoke(float f, Continuation<? super Unit> continuation) {
            return create(Float.valueOf(f), continuation).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).floatValue(), (Continuation<? super Unit>) obj2);
        }

        public final Object invokeSuspend(Object obj) {
            VoiceStatusWaveIconView voiceStatusWaveIconView;
            VoiceStatusWaveIconView voiceStatusWaveIconView2;
            VoiceStatusWaveIconView voiceStatusWaveIconView3;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            float f = this.F$0;
            if (BrainstormSessionHolder.INSTANCE.isMicMuted()) {
                voiceStatusWaveIconView3 = this.this$0.waveIcon;
                voiceStatusWaveIconView3.stopAnimating();
            } else {
                voiceStatusWaveIconView = this.this$0.waveIcon;
                voiceStatusWaveIconView.startAnimating();
                voiceStatusWaveIconView2 = this.this$0.waveIcon;
                voiceStatusWaveIconView2.updateVolume(f);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (FlowKt.collectLatest(BrainstormSessionHolder.INSTANCE.getLocalAudioVolume(), new C08141(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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
