package com.bytedance.trae.conversation.brainstorm;

import android.content.Context;
import com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager;
import com.bytedance.trae.conversation.brainstorm.BrainstormVoiceForegroundService;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.voice.network.IVoiceChatApi;
import com.bytedance.trae.conversation.voice.network.StartVoiceChatData;
import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
import com.bytedance.trae.utils.logger.FLogger;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BMVoiceChatSessionManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$stopInternal$1", f = "BMVoiceChatSessionManager.kt", i = {}, l = {403}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BMVoiceChatSessionManager$stopInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StartVoiceChatData $current;
    final /* synthetic */ boolean $forceCleanup;
    final /* synthetic */ String $sceneId;
    int label;
    final /* synthetic */ BMVoiceChatSessionManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BMVoiceChatSessionManager$stopInternal$1(StartVoiceChatData startVoiceChatData, boolean z, String str, BMVoiceChatSessionManager bMVoiceChatSessionManager, Continuation<? super BMVoiceChatSessionManager$stopInternal$1> continuation) {
        super(2, continuation);
        this.$current = startVoiceChatData;
        this.$forceCleanup = z;
        this.$sceneId = str;
        this.this$0 = bMVoiceChatSessionManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BMVoiceChatSessionManager$stopInternal$1(this.$current, this.$forceCleanup, this.$sceneId, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0127, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0122, code lost:
    
        if (r3 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Context context;
        String str;
        String str2;
        String str3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StartVoiceChatData startVoiceChatData = this.$current;
                if ((startVoiceChatData != null ? startVoiceChatData.getAppId() : null) != null && this.$current.getRoomId() != null && this.$current.getTaskId() != null && !this.$forceCleanup) {
                    FLogger.INSTANCE.d("BMVoiceChatSession", "stopVoiceChat request: scene=" + this.$sceneId + ", room=" + this.$current.getRoomId() + ", task=" + this.$current.getTaskId());
                    IVoiceChatApi.Companion companion = IVoiceChatApi.INSTANCE;
                    str = this.this$0.conversationId;
                    str2 = this.this$0.xAppId;
                    String str4 = this.$sceneId;
                    String appId = this.$current.getAppId();
                    String roomId = this.$current.getRoomId();
                    String taskId = this.$current.getTaskId();
                    str3 = this.this$0.ppeEnv;
                    this.label = 1;
                    if (companion.stopVoiceChat(str, str2, str4, appId, roomId, taskId, str3, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            FLogger.INSTANCE.d("BMVoiceChatSession", "stopVoiceChat success: room=" + this.$current.getRoomId() + ", task=" + this.$current.getTaskId());
        } catch (Throwable th) {
            try {
                FLogger.INSTANCE.w("BMVoiceChatSession", "stopVoiceChat failed", th);
                FLogger fLogger = FLogger.INSTANCE;
                StringBuilder sb = new StringBuilder("leaveRoom after stopInternal: room=");
                StartVoiceChatData startVoiceChatData2 = this.$current;
            } finally {
                FLogger fLogger2 = FLogger.INSTANCE;
                StringBuilder sb2 = new StringBuilder("leaveRoom after stopInternal: room=");
                StartVoiceChatData startVoiceChatData3 = this.$current;
                fLogger2.d("BMVoiceChatSession", sb2.append(startVoiceChatData3 != null ? startVoiceChatData3.getRoomId() : null).toString());
                VolcRtcClient.INSTANCE.leaveRoom();
                BrainstormVoiceForegroundService.Companion companion2 = BrainstormVoiceForegroundService.INSTANCE;
                context = this.this$0.appContext;
                Intrinsics.checkNotNullExpressionValue(context, "access$getAppContext$p(...)");
                companion2.stop(context);
                this.this$0.emitStatus(BMVoiceChatSessionManager.Status.Stopped);
            }
        }
    }
}
