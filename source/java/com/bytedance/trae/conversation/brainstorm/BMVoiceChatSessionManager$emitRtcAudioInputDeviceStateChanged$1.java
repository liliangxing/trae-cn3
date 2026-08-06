package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BMVoiceChatSessionManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1", f = "BMVoiceChatSessionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ int $error;

    /* renamed from: $l */
    final /* synthetic */ BMVoiceChatSessionManager.Listener f1288$l;
    final /* synthetic */ int $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1(BMVoiceChatSessionManager.Listener listener, String str, int i, int i2, Continuation<? super BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1> continuation) {
        super(2, continuation);
        this.f1288$l = listener;
        this.$deviceId = str;
        this.$state = i;
        this.$error = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1(this.f1288$l, this.$deviceId, this.$state, this.$error, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.f1288$l.onRtcAudioInputDeviceStateChanged(this.$deviceId, this.$state, this.$error);
        return Unit.INSTANCE;
    }
}
