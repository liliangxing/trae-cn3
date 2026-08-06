package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.voice.subtitle.SubtitleBinaryProtocol;
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
/* compiled from: BMVoiceChatSessionManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$handleSubvMessage$1", f = "BMVoiceChatSessionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BMVoiceChatSessionManager$handleSubvMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SubtitleBinaryProtocol.SubtitlePayload $payload;
    int label;
    final /* synthetic */ BMVoiceChatSessionManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BMVoiceChatSessionManager$handleSubvMessage$1(SubtitleBinaryProtocol.SubtitlePayload subtitlePayload, BMVoiceChatSessionManager bMVoiceChatSessionManager, Continuation<? super BMVoiceChatSessionManager$handleSubvMessage$1> continuation) {
        super(2, continuation);
        this.$payload = subtitlePayload;
        this.this$0 = bMVoiceChatSessionManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BMVoiceChatSessionManager$handleSubvMessage$1(this.$payload, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        BMVoiceChatSessionManager.MessageRole resolveRole;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<SubtitleBinaryProtocol.SubtitleItem> data = this.$payload.getData();
        BMVoiceChatSessionManager bMVoiceChatSessionManager = this.this$0;
        for (SubtitleBinaryProtocol.SubtitleItem subtitleItem : data) {
            boolean definite = subtitleItem.getDefinite();
            String text = subtitleItem.getText();
            boolean paragraph = subtitleItem.getParagraph();
            resolveRole = bMVoiceChatSessionManager.resolveRole(subtitleItem.getUserId());
            if (resolveRole == BMVoiceChatSessionManager.MessageRole.USER) {
                str = bMVoiceChatSessionManager.lastBotNonDefiniteText;
                if (StringsKt.startsWith$default(text, str, false, 2, (Object) null)) {
                    str8 = bMVoiceChatSessionManager.lastBotNonDefiniteText;
                    str2 = text.substring(str8.length());
                    Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
                } else {
                    str2 = text;
                }
                if (definite) {
                    StringBuilder sb = new StringBuilder();
                    str6 = bMVoiceChatSessionManager.userDefiniteText;
                    bMVoiceChatSessionManager.userDefiniteText = sb.append(str6).append(text).toString();
                    str7 = bMVoiceChatSessionManager.userDefiniteText;
                    bMVoiceChatSessionManager.currentUserRecognizedText = str7;
                    bMVoiceChatSessionManager.lastUserNonDefiniteText = "";
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    str3 = bMVoiceChatSessionManager.userDefiniteText;
                    bMVoiceChatSessionManager.currentUserRecognizedText = sb2.append(str3).append(text).toString();
                    bMVoiceChatSessionManager.lastUserNonDefiniteText = text;
                }
                bMVoiceChatSessionManager.emitSubtitleText(str2, BMVoiceChatSessionManager.MessageRole.USER);
                str4 = bMVoiceChatSessionManager.currentUserRecognizedText;
                bMVoiceChatSessionManager.emitRecognizedText(str4, BMVoiceChatSessionManager.MessageRole.USER);
                if (paragraph) {
                    str5 = bMVoiceChatSessionManager.currentUserRecognizedText;
                    bMVoiceChatSessionManager.emitFinalText(str5, BMVoiceChatSessionManager.MessageRole.USER);
                    bMVoiceChatSessionManager.userDefiniteText = "";
                    bMVoiceChatSessionManager.currentUserRecognizedText = "";
                    bMVoiceChatSessionManager.lastUserNonDefiniteText = "";
                }
            } else {
                str9 = bMVoiceChatSessionManager.lastBotNonDefiniteText;
                if (StringsKt.startsWith$default(text, str9, false, 2, (Object) null)) {
                    str16 = bMVoiceChatSessionManager.lastBotNonDefiniteText;
                    str10 = text.substring(str16.length());
                    Intrinsics.checkNotNullExpressionValue(str10, "substring(...)");
                } else {
                    str10 = text;
                }
                if (definite) {
                    StringBuilder sb3 = new StringBuilder();
                    str14 = bMVoiceChatSessionManager.botDefiniteText;
                    bMVoiceChatSessionManager.botDefiniteText = sb3.append(str14).append(text).toString();
                    str15 = bMVoiceChatSessionManager.botDefiniteText;
                    bMVoiceChatSessionManager.botRecognizedText = str15;
                    bMVoiceChatSessionManager.lastBotNonDefiniteText = "";
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    str11 = bMVoiceChatSessionManager.botDefiniteText;
                    bMVoiceChatSessionManager.botRecognizedText = sb4.append(str11).append(text).toString();
                    bMVoiceChatSessionManager.lastBotNonDefiniteText = text;
                }
                bMVoiceChatSessionManager.emitSubtitleText(str10, BMVoiceChatSessionManager.MessageRole.BOT);
                str12 = bMVoiceChatSessionManager.botRecognizedText;
                bMVoiceChatSessionManager.emitRecognizedText(str12, BMVoiceChatSessionManager.MessageRole.BOT);
                if (paragraph) {
                    str13 = bMVoiceChatSessionManager.botRecognizedText;
                    bMVoiceChatSessionManager.emitFinalText(str13, BMVoiceChatSessionManager.MessageRole.BOT);
                    bMVoiceChatSessionManager.botDefiniteText = "";
                    bMVoiceChatSessionManager.botRecognizedText = "";
                    bMVoiceChatSessionManager.lastBotNonDefiniteText = "";
                }
            }
        }
        return Unit.INSTANCE;
    }
}
