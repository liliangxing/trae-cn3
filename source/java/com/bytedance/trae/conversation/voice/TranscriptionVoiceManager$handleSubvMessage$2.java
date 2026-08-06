package com.bytedance.trae.conversation.voice;

import android.text.TextUtils;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.voice.subtitle.SubtitleBinaryProtocol;
import com.facebook.common.logging.FLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TranscriptionVoiceManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$handleSubvMessage$2", f = "TranscriptionVoiceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TranscriptionVoiceManager$handleSubvMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botName;
    final /* synthetic */ SubtitleBinaryProtocol.SubtitlePayload $payload;
    final /* synthetic */ String $uid;
    int label;
    final /* synthetic */ TranscriptionVoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TranscriptionVoiceManager$handleSubvMessage$2(SubtitleBinaryProtocol.SubtitlePayload subtitlePayload, String str, TranscriptionVoiceManager transcriptionVoiceManager, String str2, Continuation<? super TranscriptionVoiceManager$handleSubvMessage$2> continuation) {
        super(2, continuation);
        this.$payload = subtitlePayload;
        this.$botName = str;
        this.this$0 = transcriptionVoiceManager;
        this.$uid = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TranscriptionVoiceManager$handleSubvMessage$2(this.$payload, this.$botName, this.this$0, this.$uid, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0139 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x001c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        VoiceAttemptMetricsTracker voiceAttemptMetricsTracker;
        String str5;
        String str6;
        VoiceAttemptMetricsTracker voiceAttemptMetricsTracker2;
        String str7;
        String str8;
        String str9;
        String str10;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<SubtitleBinaryProtocol.SubtitleItem> data = this.$payload.getData();
        String str11 = this.$botName;
        TranscriptionVoiceManager transcriptionVoiceManager = this.this$0;
        String str12 = this.$uid;
        for (SubtitleBinaryProtocol.SubtitleItem subtitleItem : data) {
            boolean definite = subtitleItem.getDefinite();
            String text = subtitleItem.getText();
            boolean paragraph = subtitleItem.getParagraph();
            String userId = subtitleItem.getUserId();
            boolean z = (str11.length() > 0) && Intrinsics.areEqual(userId, str11);
            transcriptionVoiceManager.hasReceiveVoice = true;
            FLog.d("VoiceChatSession", "RTC subtitle: uid=" + str12 + ", userId=" + userId + " botName=" + str11 + " isBot=" + z + " paragraph=" + paragraph + " definite=" + definite);
            if (!z) {
                if (definite) {
                    if (text.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        str9 = transcriptionVoiceManager.definiteText;
                        transcriptionVoiceManager.definiteText = sb.append(str9).append(text).toString();
                        str10 = transcriptionVoiceManager.definiteText;
                        transcriptionVoiceManager.currentRecognizedText = str10;
                        i = transcriptionVoiceManager.asrCallbackCount;
                        transcriptionVoiceManager.asrCallbackCount = i + 1;
                        voiceAttemptMetricsTracker = transcriptionVoiceManager.attemptTracker;
                        str5 = transcriptionVoiceManager.currentRecognizedText;
                        voiceAttemptMetricsTracker.onRecognizedText(!StringsKt.isBlank(str5));
                        str6 = transcriptionVoiceManager.currentRecognizedText;
                        transcriptionVoiceManager.emitRecognizedText(str6);
                        if (!paragraph) {
                            voiceAttemptMetricsTracker2 = transcriptionVoiceManager.attemptTracker;
                            voiceAttemptMetricsTracker2.onParagraph();
                            StringBuilder sb2 = new StringBuilder();
                            str7 = transcriptionVoiceManager.botCompleteText;
                            StringBuilder append = sb2.append(str7);
                            str8 = transcriptionVoiceManager.currentRecognizedText;
                            transcriptionVoiceManager.botCompleteText = append.append(str8).toString();
                            transcriptionVoiceManager.definiteText = "";
                            transcriptionVoiceManager.currentRecognizedText = "";
                        }
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                str4 = transcriptionVoiceManager.definiteText;
                transcriptionVoiceManager.currentRecognizedText = sb3.append(str4).append(text).toString();
                i = transcriptionVoiceManager.asrCallbackCount;
                transcriptionVoiceManager.asrCallbackCount = i + 1;
                voiceAttemptMetricsTracker = transcriptionVoiceManager.attemptTracker;
                str5 = transcriptionVoiceManager.currentRecognizedText;
                voiceAttemptMetricsTracker.onRecognizedText(!StringsKt.isBlank(str5));
                str6 = transcriptionVoiceManager.currentRecognizedText;
                transcriptionVoiceManager.emitRecognizedText(str6);
                if (!paragraph) {
                }
            } else if (paragraph) {
                str = transcriptionVoiceManager.currentRecognizedText;
                if (!TextUtils.isEmpty(str)) {
                    StringBuilder sb4 = new StringBuilder();
                    str2 = transcriptionVoiceManager.botCompleteText;
                    StringBuilder append2 = sb4.append(str2);
                    str3 = transcriptionVoiceManager.currentRecognizedText;
                    transcriptionVoiceManager.botCompleteText = append2.append(str3).toString();
                    transcriptionVoiceManager.currentRecognizedText = "";
                    transcriptionVoiceManager.definiteText = "";
                }
            }
        }
        return Unit.INSTANCE;
    }
}
