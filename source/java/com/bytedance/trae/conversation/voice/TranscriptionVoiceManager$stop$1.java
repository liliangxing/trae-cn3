package com.bytedance.trae.conversation.voice;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.voice.TranscriptionVoiceManager;
import com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker;
import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
import com.facebook.common.logging.FLog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TranscriptionVoiceManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$stop$1", f = "TranscriptionVoiceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TranscriptionVoiceManager$stop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $ignoreFinalText;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TranscriptionVoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TranscriptionVoiceManager$stop$1(TranscriptionVoiceManager transcriptionVoiceManager, boolean z, Continuation<? super TranscriptionVoiceManager$stop$1> continuation) {
        super(2, continuation);
        this.this$0 = transcriptionVoiceManager;
        this.$ignoreFinalText = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> transcriptionVoiceManager$stop$1 = new TranscriptionVoiceManager$stop$1(this.this$0, this.$ignoreFinalText, continuation);
        transcriptionVoiceManager$stop$1.L$0 = obj;
        return transcriptionVoiceManager$stop$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Job job;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            this.this$0.isWaitingBotResponse = true;
            this.this$0.emitStatus(TranscriptionVoiceManager.Status.WaitingBotResponse);
            job = this.this$0.waitBotJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.this$0.waitBotJob = BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C07811(this.$ignoreFinalText, this.this$0, null), 3, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TranscriptionVoiceManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$stop$1$1", f = "TranscriptionVoiceManager.kt", i = {}, l = {349, 351}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$stop$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $ignoreFinalText;
        int label;
        final /* synthetic */ TranscriptionVoiceManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07811(boolean z, TranscriptionVoiceManager transcriptionVoiceManager, Continuation<? super C07811> continuation) {
            super(2, continuation);
            this.$ignoreFinalText = z;
            this.this$0 = transcriptionVoiceManager;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07811(this.$ignoreFinalText, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            boolean z;
            VoiceAttemptMetricsTracker voiceAttemptMetricsTracker;
            VoiceAttemptMetricsTracker.SessionSnapshot buildSessionSnapshot;
            Unit unit;
            TranscriptionVoiceManager$rtcListener$1 transcriptionVoiceManager$rtcListener$1;
            String str;
            String str2;
            VoiceAttemptMetricsTracker voiceAttemptMetricsTracker2;
            String str3;
            VoiceAttemptMetricsTracker voiceAttemptMetricsTracker3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.$ignoreFinalText) {
                        voiceAttemptMetricsTracker = this.this$0.attemptTracker;
                        buildSessionSnapshot = this.this$0.buildSessionSnapshot();
                        voiceAttemptMetricsTracker.report("cancel", "", "unknown", buildSessionSnapshot);
                        this.this$0.stopInternal();
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                    z = this.this$0.hasReceiveVoice;
                    if (z) {
                        this.label = 1;
                        if (DelayKt.delay(2000L, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        this.label = 2;
                        if (DelayKt.delay(1000L, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 1 && i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                VolcRtcClient volcRtcClient = VolcRtcClient.INSTANCE;
                transcriptionVoiceManager$rtcListener$1 = this.this$0.rtcListener;
                volcRtcClient.removeListener(transcriptionVoiceManager$rtcListener$1);
                str = this.this$0.botCompleteText;
            } catch (Throwable th) {
                try {
                    FLog.w("VoiceChatSession", "wait bot response failed", th);
                } finally {
                    this.this$0.stopInternal();
                }
            }
            if (!StringsKt.isBlank(str)) {
                str3 = this.this$0.botCompleteText;
                voiceAttemptMetricsTracker3 = this.this$0.attemptTracker;
                voiceAttemptMetricsTracker3.markFinalText(str3, VoiceAttemptMetricsTracker.FINAL_SOURCE_PARAGRAPH);
                this.this$0.botCompleteText = "";
                this.this$0.currentRecognizedText = "";
                this.this$0.definiteText = "";
                this.this$0.reportVoiceStartPerf(0);
                this.this$0.reportVoiceSessionPerf(str3);
                this.this$0.emitFinalText(str3);
                this.this$0.stopInternal();
                unit = Unit.INSTANCE;
                return unit;
            }
            str2 = this.this$0.botCompleteText;
            String str4 = str2;
            TranscriptionVoiceManager transcriptionVoiceManager = this.this$0;
            if (StringsKt.isBlank(str4)) {
                str4 = transcriptionVoiceManager.currentRecognizedText;
            }
            String str5 = str4;
            voiceAttemptMetricsTracker2 = this.this$0.attemptTracker;
            voiceAttemptMetricsTracker2.markFinalText(str5, StringsKt.isBlank(str5) ? VoiceAttemptMetricsTracker.FINAL_SOURCE_EMPTY : VoiceAttemptMetricsTracker.FINAL_SOURCE_CURRENT_TEXT_FALLBACK);
            this.this$0.reportVoiceStartPerf(0);
            this.this$0.reportVoiceSessionPerf(str5);
            this.this$0.emitFinalText(str5);
            this.this$0.botCompleteText = "";
            this.this$0.currentRecognizedText = "";
            this.this$0.definiteText = "";
            this.this$0.stopInternal();
            return Unit.INSTANCE;
        }
    }
}
