package com.bytedance.trae.conversation.brainstorm;

import android.content.Context;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager;
import com.bytedance.trae.conversation.brainstorm.BrainstormVoiceForegroundService;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.voice.network.IVoiceChatApi;
import com.bytedance.trae.conversation.voice.network.StartVoiceChatData;
import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BMVoiceChatSessionManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$start$1", f = "BMVoiceChatSessionManager.kt", i = {}, l = {312}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BMVoiceChatSessionManager$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BMVoiceChatSessionManager.Listener $listener;
    final /* synthetic */ String $sceneId;
    int label;
    final /* synthetic */ BMVoiceChatSessionManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BMVoiceChatSessionManager$start$1(BMVoiceChatSessionManager bMVoiceChatSessionManager, String str, BMVoiceChatSessionManager.Listener listener, Continuation<? super BMVoiceChatSessionManager$start$1> continuation) {
        super(2, continuation);
        this.this$0 = bMVoiceChatSessionManager;
        this.$sceneId = str;
        this.$listener = listener;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BMVoiceChatSessionManager$start$1(this.this$0, this.$sceneId, this.$listener, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0102 A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:5:0x0021, B:7:0x0097, B:9:0x009e, B:11:0x00ce, B:12:0x00d2, B:13:0x00dd, B:15:0x00de, B:17:0x00ed, B:19:0x00f6, B:24:0x0102, B:26:0x010a, B:31:0x0116, B:33:0x011e, B:38:0x012a, B:40:0x0132, B:45:0x013e, B:48:0x01a0, B:52:0x01b3, B:55:0x01c9, B:57:0x01fa, B:60:0x0237, B:62:0x0270, B:64:0x0293, B:67:0x029b, B:68:0x02a3, B:75:0x02a4, B:76:0x02c0, B:80:0x0035), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0116 A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:5:0x0021, B:7:0x0097, B:9:0x009e, B:11:0x00ce, B:12:0x00d2, B:13:0x00dd, B:15:0x00de, B:17:0x00ed, B:19:0x00f6, B:24:0x0102, B:26:0x010a, B:31:0x0116, B:33:0x011e, B:38:0x012a, B:40:0x0132, B:45:0x013e, B:48:0x01a0, B:52:0x01b3, B:55:0x01c9, B:57:0x01fa, B:60:0x0237, B:62:0x0270, B:64:0x0293, B:67:0x029b, B:68:0x02a3, B:75:0x02a4, B:76:0x02c0, B:80:0x0035), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012a A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:5:0x0021, B:7:0x0097, B:9:0x009e, B:11:0x00ce, B:12:0x00d2, B:13:0x00dd, B:15:0x00de, B:17:0x00ed, B:19:0x00f6, B:24:0x0102, B:26:0x010a, B:31:0x0116, B:33:0x011e, B:38:0x012a, B:40:0x0132, B:45:0x013e, B:48:0x01a0, B:52:0x01b3, B:55:0x01c9, B:57:0x01fa, B:60:0x0237, B:62:0x0270, B:64:0x0293, B:67:0x029b, B:68:0x02a3, B:75:0x02a4, B:76:0x02c0, B:80:0x0035), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013e A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:5:0x0021, B:7:0x0097, B:9:0x009e, B:11:0x00ce, B:12:0x00d2, B:13:0x00dd, B:15:0x00de, B:17:0x00ed, B:19:0x00f6, B:24:0x0102, B:26:0x010a, B:31:0x0116, B:33:0x011e, B:38:0x012a, B:40:0x0132, B:45:0x013e, B:48:0x01a0, B:52:0x01b3, B:55:0x01c9, B:57:0x01fa, B:60:0x0237, B:62:0x0270, B:64:0x0293, B:67:0x029b, B:68:0x02a3, B:75:0x02a4, B:76:0x02c0, B:80:0x0035), top: B:2:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String rtcDiag;
        String str;
        String rtcDiag2;
        String str2;
        String str3;
        Object startVoiceChat;
        HttpDataResult.Error error;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String rtcDiag3;
        Context context;
        CoroutineScope coroutineScope;
        BMVoiceChatSessionManager$rtcListener$1 bMVoiceChatSessionManager$rtcListener$1;
        boolean z5;
        String rtcDiag4;
        String rtcDiag5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.emitPerfTimestamp(BMVoiceChatSessionManager.PerfEvent.API_REQUEST_START, System.currentTimeMillis());
                FLogger fLogger = FLogger.INSTANCE;
                BMVoiceChatSessionManager bMVoiceChatSessionManager = this.this$0;
                StringBuilder append = new StringBuilder("startVoiceChat request: scene=").append(this.$sceneId).append(", conversationId=");
                str = this.this$0.conversationId;
                rtcDiag2 = bMVoiceChatSessionManager.rtcDiag(append.append(str).toString());
                fLogger.d("BMVoiceChatSession", rtcDiag2);
                IVoiceChatApi.Companion companion = IVoiceChatApi.INSTANCE;
                str2 = this.this$0.conversationId;
                str3 = this.this$0.xAppId;
                this.label = 1;
                startVoiceChat = companion.startVoiceChat(str2, str3, this.$sceneId, (r24 & 8) != 0 ? false : false, (r24 & 16) != 0 ? null : null, (r24 & 32) != 0 ? null : null, (r24 & 64) != 0 ? null : null, (r24 & 128) != 0 ? null : null, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : null, (Continuation) this);
                if (startVoiceChat == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                startVoiceChat = obj;
            }
            error = (HttpDataResult) startVoiceChat;
        } catch (Throwable th) {
            this.this$0.emitError(th);
            FLogger fLogger2 = FLogger.INSTANCE;
            rtcDiag = this.this$0.rtcDiag("stopInternal caller: start() catch block, error=" + th);
            fLogger2.e("BMVoiceChatSession", rtcDiag, th);
            this.this$0.stopInternal(true);
        }
        if (!(error instanceof HttpDataResult.Success)) {
            Intrinsics.checkNotNull(error, "null cannot be cast to non-null type com.bytedance.trae.network.response.HttpDataResult.Error");
            HttpDataResult.Error error2 = error;
            StringBuilder append2 = new StringBuilder("startVoiceChat failed: code=").append(error2.getCode()).append(", msg=").append(error2.getMsg()).append(", cause=");
            Throwable throwable = error2.getThrowable();
            throw new RuntimeException(append2.append(throwable != null ? throwable.getMessage() : null).toString());
        }
        StartVoiceChatData startVoiceChatData = (StartVoiceChatData) ((HttpDataResult.Success) error).getBizResp().getData();
        if (startVoiceChatData != null) {
            String appId = startVoiceChatData.getAppId();
            if (appId != null && !StringsKt.isBlank(appId)) {
                z = false;
                if (!z) {
                    String roomId = startVoiceChatData.getRoomId();
                    if (roomId != null && !StringsKt.isBlank(roomId)) {
                        z2 = false;
                        if (!z2) {
                            String userId = startVoiceChatData.getUserId();
                            if (userId != null && !StringsKt.isBlank(userId)) {
                                z3 = false;
                                if (!z3) {
                                    String token = startVoiceChatData.getToken();
                                    if (token != null && !StringsKt.isBlank(token)) {
                                        z4 = false;
                                        if (!z4) {
                                            FLogger fLogger3 = FLogger.INSTANCE;
                                            BMVoiceChatSessionManager bMVoiceChatSessionManager2 = this.this$0;
                                            StringBuilder append3 = new StringBuilder("startVoiceChat success: appId=").append(startVoiceChatData.getAppId()).append(", roomId=").append(startVoiceChatData.getRoomId()).append(", userId=").append(startVoiceChatData.getUserId()).append(", taskId=").append(startVoiceChatData.getTaskId()).append(", botName=").append(startVoiceChatData.getBotName()).append(", botUserId=").append(startVoiceChatData.getBotUserId()).append(", hasSubTaskConfig=").append(startVoiceChatData.getSubTaskConfig() != null).append(", tokenLength=");
                                            String token2 = startVoiceChatData.getToken();
                                            String str4 = "";
                                            if (token2 == null) {
                                                token2 = "";
                                            }
                                            StringBuilder append4 = append3.append(token2.length()).append(", tokenHash=");
                                            String token3 = startVoiceChatData.getToken();
                                            if (token3 != null) {
                                                str4 = token3;
                                            }
                                            rtcDiag3 = bMVoiceChatSessionManager2.rtcDiag(append4.append(str4.hashCode()).toString());
                                            fLogger3.d("BMVoiceChatSession", rtcDiag3);
                                            this.this$0.emitPerfTimestamp(BMVoiceChatSessionManager.PerfEvent.API_REQUEST_END_JOIN_ROOM_START, System.currentTimeMillis());
                                            BrainstormVoiceForegroundService.Companion companion2 = BrainstormVoiceForegroundService.INSTANCE;
                                            context = this.this$0.appContext;
                                            Intrinsics.checkNotNullExpressionValue(context, "access$getAppContext$p(...)");
                                            if (!companion2.start(context, false)) {
                                                throw new RuntimeException("voice foreground service start failed");
                                            }
                                            this.this$0.voiceChat = startVoiceChatData;
                                            coroutineScope = this.this$0.uiScope;
                                            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C06411(this.$listener, startVoiceChatData, this.this$0, null), 3, (Object) null);
                                            VolcRtcClient volcRtcClient = VolcRtcClient.INSTANCE;
                                            bMVoiceChatSessionManager$rtcListener$1 = this.this$0.rtcListener;
                                            boolean join$conversation_mainlandRelease = volcRtcClient.join$conversation_mainlandRelease(startVoiceChatData, bMVoiceChatSessionManager$rtcListener$1, VolcRtcClient.CallerType.Brainstorm);
                                            FLogger fLogger4 = FLogger.INSTANCE;
                                            BMVoiceChatSessionManager bMVoiceChatSessionManager3 = this.this$0;
                                            StringBuilder append5 = new StringBuilder("VolcRtcClient.join returned: joined=").append(join$conversation_mainlandRelease).append(", roomId=").append(startVoiceChatData.getRoomId()).append(", taskId=").append(startVoiceChatData.getTaskId()).append(", micMutedRequested=");
                                            z5 = this.this$0.micMutedRequested;
                                            rtcDiag4 = bMVoiceChatSessionManager3.rtcDiag(append5.append(z5).toString());
                                            fLogger4.d("BMVoiceChatSession", rtcDiag4);
                                            if (join$conversation_mainlandRelease) {
                                                this.this$0.emitStatus(BMVoiceChatSessionManager.Status.JoiningRoom);
                                                return Unit.INSTANCE;
                                            }
                                            FLogger fLogger5 = FLogger.INSTANCE;
                                            rtcDiag5 = this.this$0.rtcDiag("VolcRtcClient busy, refuse to start brainstorm voice");
                                            fLogger5.w("BMVoiceChatSession", rtcDiag5);
                                            this.this$0.emitError(new IllegalStateException("Another voice session is active, cannot start brainstorm"));
                                            this.this$0.handleJoinRefused(startVoiceChatData);
                                            return Unit.INSTANCE;
                                        }
                                    }
                                    z4 = true;
                                    if (!z4) {
                                    }
                                }
                            }
                            z3 = true;
                            if (!z3) {
                            }
                        }
                    }
                    z2 = true;
                    if (!z2) {
                    }
                }
            }
            z = true;
            if (!z) {
            }
        }
        throw new RuntimeException("startVoiceChat returns invalid data: " + ((HttpDataResult.Success) error).getBizResp().getData());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BMVoiceChatSessionManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$start$1$1", f = "BMVoiceChatSessionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$start$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ StartVoiceChatData $data;
        final /* synthetic */ BMVoiceChatSessionManager.Listener $listener;
        int label;
        final /* synthetic */ BMVoiceChatSessionManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06411(BMVoiceChatSessionManager.Listener listener, StartVoiceChatData startVoiceChatData, BMVoiceChatSessionManager bMVoiceChatSessionManager, Continuation<? super C06411> continuation) {
            super(2, continuation);
            this.$listener = listener;
            this.$data = startVoiceChatData;
            this.this$0 = bMVoiceChatSessionManager;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06411(this.$listener, this.$data, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            String rtcDiag;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                BMVoiceChatSessionManager.Listener listener = this.$listener;
                if (listener != null) {
                    listener.onVoiceChatDataReady(this.$data);
                }
            } catch (Throwable th) {
                FLogger fLogger = FLogger.INSTANCE;
                rtcDiag = this.this$0.rtcDiag("onVoiceChatDataReady forward failed: roomId=" + this.$data.getRoomId() + ", taskId=" + this.$data.getTaskId());
                fLogger.w("BMVoiceChatSession", rtcDiag, th);
            }
            return Unit.INSTANCE;
        }
    }
}
