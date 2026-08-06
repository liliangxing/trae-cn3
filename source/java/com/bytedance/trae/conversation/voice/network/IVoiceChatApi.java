package com.bytedance.trae.conversation.voice.network;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.conversation.voice.VoiceChatApiPaths;
import com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: IVoiceChatApi.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;", "", "startVoiceChat", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;", "(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopVoiceChat", "Lcom/bytedance/trae/conversation/voice/network/StopVoiceChatData;", "Lcom/bytedance/trae/conversation/voice/network/StopVoiceChatRequest;", "(Lcom/bytedance/trae/conversation/voice/network/StopVoiceChatRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVoiceChatHistory", "Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;", "sessionId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IVoiceChatApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET(VoiceChatApiPaths.GET_VOICE_CHAT_HISTORY)
    Object getVoiceChatHistory(@Query("session_id") String str, Continuation<? super GetVoiceChatHistoryData> continuation);

    @POST(VoiceChatApiPaths.START_VOICE_CHAT)
    Object startVoiceChat(@Body StartVoiceChatRequest startVoiceChatRequest, Continuation<? super BizResponse<StartVoiceChatData>> continuation);

    @POST(VoiceChatApiPaths.STOP_VOICE_CHAT)
    Object stopVoiceChat(@Body StopVoiceChatRequest stopVoiceChatRequest, Continuation<? super BizResponse<StopVoiceChatData>> continuation);

    /* compiled from: IVoiceChatApi.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jr\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0002\u0010\u0012JN\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u0017J@\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00052\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;", "", "<init>", "()V", "startVoiceChat", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;", "conversationId", "", "xAppId", "sceneId", "configOnly", "", "roomId", "userId", "taskId", "token", "botUserId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopVoiceChat", "Lcom/bytedance/trae/conversation/voice/network/StopVoiceChatData;", "appId", "ppeEnv", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVoiceChatHistory", "Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;", "sessionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object startVoiceChat(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, Continuation<? super HttpDataResult<StartVoiceChatData>> continuation) {
            IVoiceChatApi$Companion$startVoiceChat$1 iVoiceChatApi$Companion$startVoiceChat$1;
            int i;
            try {
                if (continuation instanceof IVoiceChatApi$Companion$startVoiceChat$1) {
                    iVoiceChatApi$Companion$startVoiceChat$1 = (IVoiceChatApi$Companion$startVoiceChat$1) continuation;
                    if ((iVoiceChatApi$Companion$startVoiceChat$1.label & Integer.MIN_VALUE) != 0) {
                        iVoiceChatApi$Companion$startVoiceChat$1.label -= Integer.MIN_VALUE;
                        Object obj = iVoiceChatApi$Companion$startVoiceChat$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iVoiceChatApi$Companion$startVoiceChat$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            IVoiceChatApi iVoiceChatApi = (IVoiceChatApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, VoiceSubTaskCoordinator.SUB_TASK_AGENT_TYPE, IVoiceChatApi.class, (Converter.Factory) null, VoiceChatApiPaths.INSTANCE.getHOST(), VoiceChatApiPaths.buildHeaders$default(VoiceChatApiPaths.INSTANCE, str, str3, null, null, 12, null), false, 36, (Object) null);
                            StartVoiceChatRequest startVoiceChatRequest = new StartVoiceChatRequest(str3, z, null, str4, str5, str6, str7, str8, 4, null);
                            iVoiceChatApi$Companion$startVoiceChat$1.label = 1;
                            obj = iVoiceChatApi.startVoiceChat(startVoiceChatRequest, iVoiceChatApi$Companion$startVoiceChat$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return new HttpDataResult.Success((BizResponse) obj, (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                return new HttpDataResult.Success((BizResponse) obj, (Throwable) null);
            } catch (CancellationException e) {
                return new HttpDataResult.Error(-1001, "", e, (String) null, 8, (DefaultConstructorMarker) null);
            } catch (Throwable th) {
                return new HttpDataResult.Error(-1000, "", th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iVoiceChatApi$Companion$startVoiceChat$1 = new IVoiceChatApi$Companion$startVoiceChat$1(this, continuation);
            Object obj2 = iVoiceChatApi$Companion$startVoiceChat$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iVoiceChatApi$Companion$startVoiceChat$1.label;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object stopVoiceChat(String str, String str2, String str3, String str4, String str5, String str6, String str7, Continuation<? super HttpDataResult<StopVoiceChatData>> continuation) {
            IVoiceChatApi$Companion$stopVoiceChat$1 iVoiceChatApi$Companion$stopVoiceChat$1;
            int i;
            try {
                if (continuation instanceof IVoiceChatApi$Companion$stopVoiceChat$1) {
                    iVoiceChatApi$Companion$stopVoiceChat$1 = (IVoiceChatApi$Companion$stopVoiceChat$1) continuation;
                    if ((iVoiceChatApi$Companion$stopVoiceChat$1.label & Integer.MIN_VALUE) != 0) {
                        iVoiceChatApi$Companion$stopVoiceChat$1.label -= Integer.MIN_VALUE;
                        Object obj = iVoiceChatApi$Companion$stopVoiceChat$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iVoiceChatApi$Companion$stopVoiceChat$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            IVoiceChatApi iVoiceChatApi = (IVoiceChatApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, VoiceSubTaskCoordinator.SUB_TASK_AGENT_TYPE, IVoiceChatApi.class, (Converter.Factory) null, VoiceChatApiPaths.INSTANCE.getHOST(), VoiceChatApiPaths.INSTANCE.buildHeaders(str, str3, str2, str7), !(str7.length() == 0), 4, (Object) null);
                            StopVoiceChatRequest stopVoiceChatRequest = new StopVoiceChatRequest(str4, str5, str6);
                            iVoiceChatApi$Companion$stopVoiceChat$1.label = 1;
                            obj = iVoiceChatApi.stopVoiceChat(stopVoiceChatRequest, iVoiceChatApi$Companion$stopVoiceChat$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return new HttpDataResult.Success((BizResponse) obj, (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                return new HttpDataResult.Success((BizResponse) obj, (Throwable) null);
            } catch (CancellationException e) {
                return new HttpDataResult.Error(-1001, "", e, (String) null, 8, (DefaultConstructorMarker) null);
            } catch (Throwable th) {
                return new HttpDataResult.Error(-1000, "", th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iVoiceChatApi$Companion$stopVoiceChat$1 = new IVoiceChatApi$Companion$stopVoiceChat$1(this, continuation);
            Object obj2 = iVoiceChatApi$Companion$stopVoiceChat$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iVoiceChatApi$Companion$stopVoiceChat$1.label;
        }

        public static /* synthetic */ Object getVoiceChatHistory$default(Companion companion, String str, String str2, String str3, String str4, String str5, Continuation continuation, int i, Object obj) {
            if ((i & 8) != 0) {
                str4 = VoiceChatApiPaths.HeaderValue.DEFAULT_X_APP_ID;
            }
            String str6 = str4;
            if ((i & 16) != 0) {
                str5 = "";
            }
            return companion.getVoiceChatHistory(str, str2, str3, str6, str5, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object getVoiceChatHistory(String str, String str2, String str3, String str4, String str5, Continuation<? super HttpDataResult<GetVoiceChatHistoryData>> continuation) {
            IVoiceChatApi$Companion$getVoiceChatHistory$1 iVoiceChatApi$Companion$getVoiceChatHistory$1;
            int i;
            try {
                if (continuation instanceof IVoiceChatApi$Companion$getVoiceChatHistory$1) {
                    iVoiceChatApi$Companion$getVoiceChatHistory$1 = (IVoiceChatApi$Companion$getVoiceChatHistory$1) continuation;
                    if ((iVoiceChatApi$Companion$getVoiceChatHistory$1.label & Integer.MIN_VALUE) != 0) {
                        iVoiceChatApi$Companion$getVoiceChatHistory$1.label -= Integer.MIN_VALUE;
                        Object obj = iVoiceChatApi$Companion$getVoiceChatHistory$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iVoiceChatApi$Companion$getVoiceChatHistory$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            IVoiceChatApi iVoiceChatApi = (IVoiceChatApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, VoiceSubTaskCoordinator.SUB_TASK_AGENT_TYPE, IVoiceChatApi.class, (Converter.Factory) null, VoiceChatApiPaths.INSTANCE.getHOST(), VoiceChatApiPaths.INSTANCE.buildHeaders(str2, str3, str4, str5), !(str5.length() == 0), 4, (Object) null);
                            iVoiceChatApi$Companion$getVoiceChatHistory$1.label = 1;
                            obj = iVoiceChatApi.getVoiceChatHistory(str, iVoiceChatApi$Companion$getVoiceChatHistory$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return new HttpDataResult.Success(new BizResponse(0L, (String) null, (String) null, (String) null, (GetVoiceChatHistoryData) obj, (String) null, 46, (DefaultConstructorMarker) null), (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                return new HttpDataResult.Success(new BizResponse(0L, (String) null, (String) null, (String) null, (GetVoiceChatHistoryData) obj, (String) null, 46, (DefaultConstructorMarker) null), (Throwable) null);
            } catch (CancellationException e) {
                return new HttpDataResult.Error(-1001, "", e, (String) null, 8, (DefaultConstructorMarker) null);
            } catch (Throwable th) {
                return new HttpDataResult.Error(-1000, "", th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iVoiceChatApi$Companion$getVoiceChatHistory$1 = new IVoiceChatApi$Companion$getVoiceChatHistory$1(this, continuation);
            Object obj2 = iVoiceChatApi$Companion$getVoiceChatHistory$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iVoiceChatApi$Companion$getVoiceChatHistory$1.label;
        }
    }
}
