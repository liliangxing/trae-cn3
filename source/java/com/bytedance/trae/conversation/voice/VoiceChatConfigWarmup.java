package com.bytedance.trae.conversation.voice;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.conversation.voice.VoiceChatApiPaths;
import com.bytedance.trae.conversation.voice.network.IVoiceChatApi;
import com.bytedance.trae.conversation.voice.network.StartVoiceChatData;
import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.platform.service.ApmService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* compiled from: VoiceChatConfigWarmup.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0011H\u0086@¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;", "", "<init>", "()V", "TAG", "", "EVENT_NAME", "SCENE_ID_CUSTOM", "MIN_FETCH_INTERVAL_MS", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "value", "appId", "getAppId", "()Ljava/lang/String;", "cachedData", "Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;", "getCachedData", "()Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;", "setCachedData", "(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V", "pollingJob", "Lkotlinx/coroutines/Job;", "lastFetchTimeMs", "warmup", "", "startPolling", "stopPolling", "getOrFetchCachedData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAndCache", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceChatConfigWarmup {
    private static final String EVENT_NAME = "rtc_voice_pre_create_engine";
    private static final long MIN_FETCH_INTERVAL_MS = 3600000;
    private static final String SCENE_ID_CUSTOM = "transcription";
    private static final String TAG = "VoiceChatConfigWarmup";
    private static String appId;
    private static volatile StartVoiceChatData cachedData;
    private static volatile long lastFetchTimeMs;
    private static Job pollingJob;
    public static final VoiceChatConfigWarmup INSTANCE = new VoiceChatConfigWarmup();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));

    private VoiceChatConfigWarmup() {
    }

    public final String getAppId() {
        return appId;
    }

    public final StartVoiceChatData getCachedData() {
        return cachedData;
    }

    public final void setCachedData(StartVoiceChatData startVoiceChatData) {
        cachedData = startVoiceChatData;
    }

    public final void warmup() {
        Job job = pollingJob;
        boolean z = false;
        if (job != null && job.isActive()) {
            z = true;
        }
        if (z) {
            return;
        }
        if (System.currentTimeMillis() - lastFetchTimeMs >= MIN_FETCH_INTERVAL_MS || cachedData == null) {
            startPolling();
        }
    }

    private final void startPolling() {
        stopPolling();
        pollingJob = BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new VoiceChatConfigWarmup$startPolling$1(null), 3, (Object) null);
    }

    private final void stopPolling() {
        Job job = pollingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        pollingJob = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getOrFetchCachedData(Continuation<? super StartVoiceChatData> continuation) {
        VoiceChatConfigWarmup$getOrFetchCachedData$1 voiceChatConfigWarmup$getOrFetchCachedData$1;
        int i;
        if (continuation instanceof VoiceChatConfigWarmup$getOrFetchCachedData$1) {
            voiceChatConfigWarmup$getOrFetchCachedData$1 = (VoiceChatConfigWarmup$getOrFetchCachedData$1) continuation;
            if ((voiceChatConfigWarmup$getOrFetchCachedData$1.label & Integer.MIN_VALUE) != 0) {
                voiceChatConfigWarmup$getOrFetchCachedData$1.label -= Integer.MIN_VALUE;
                Object obj = voiceChatConfigWarmup$getOrFetchCachedData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = voiceChatConfigWarmup$getOrFetchCachedData$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    StartVoiceChatData startVoiceChatData = cachedData;
                    if (startVoiceChatData != null) {
                        return startVoiceChatData;
                    }
                    voiceChatConfigWarmup$getOrFetchCachedData$1.label = 1;
                    if (fetchAndCache(voiceChatConfigWarmup$getOrFetchCachedData$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return cachedData;
            }
        }
        voiceChatConfigWarmup$getOrFetchCachedData$1 = new VoiceChatConfigWarmup$getOrFetchCachedData$1(this, continuation);
        Object obj2 = voiceChatConfigWarmup$getOrFetchCachedData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = voiceChatConfigWarmup$getOrFetchCachedData$1.label;
        if (i != 0) {
        }
        return cachedData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|7|(1:(3:10|11|12)(2:72|73))(5:74|75|(3:77|(1:87)(1:81)|(1:83)(2:84|(1:86)))|88|89)|13|14|(4:16|(1:18)(1:70)|19|(2:21|22)(7:24|25|26|27|28|29|(4:31|(2:36|(4:38|(2:43|(4:45|(2:50|(4:52|(2:57|(1:59))|60|(0)))|61|(0)))|62|(0)))|63|(0))))(1:71)|64|65))|91|6|7|(0)(0)|13|14|(0)(0)|64|65) */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a3 A[Catch: all -> 0x015e, TRY_ENTER, TryCatch #1 {all -> 0x015e, blocks: (B:11:0x0030, B:13:0x0094, B:16:0x00a3, B:18:0x00b7, B:19:0x00bd, B:21:0x00c1, B:24:0x00c4, B:27:0x00cf, B:31:0x00ec, B:33:0x00f4, B:38:0x0101, B:40:0x0109, B:45:0x0116, B:47:0x011e, B:52:0x012b, B:54:0x0133, B:59:0x0140, B:71:0x0143, B:75:0x0043, B:77:0x0051, B:79:0x0057, B:84:0x0064, B:88:0x015b), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0101 A[Catch: all -> 0x015e, TryCatch #1 {all -> 0x015e, blocks: (B:11:0x0030, B:13:0x0094, B:16:0x00a3, B:18:0x00b7, B:19:0x00bd, B:21:0x00c1, B:24:0x00c4, B:27:0x00cf, B:31:0x00ec, B:33:0x00f4, B:38:0x0101, B:40:0x0109, B:45:0x0116, B:47:0x011e, B:52:0x012b, B:54:0x0133, B:59:0x0140, B:71:0x0143, B:75:0x0043, B:77:0x0051, B:79:0x0057, B:84:0x0064, B:88:0x015b), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0116 A[Catch: all -> 0x015e, TryCatch #1 {all -> 0x015e, blocks: (B:11:0x0030, B:13:0x0094, B:16:0x00a3, B:18:0x00b7, B:19:0x00bd, B:21:0x00c1, B:24:0x00c4, B:27:0x00cf, B:31:0x00ec, B:33:0x00f4, B:38:0x0101, B:40:0x0109, B:45:0x0116, B:47:0x011e, B:52:0x012b, B:54:0x0133, B:59:0x0140, B:71:0x0143, B:75:0x0043, B:77:0x0051, B:79:0x0057, B:84:0x0064, B:88:0x015b), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012b A[Catch: all -> 0x015e, TryCatch #1 {all -> 0x015e, blocks: (B:11:0x0030, B:13:0x0094, B:16:0x00a3, B:18:0x00b7, B:19:0x00bd, B:21:0x00c1, B:24:0x00c4, B:27:0x00cf, B:31:0x00ec, B:33:0x00f4, B:38:0x0101, B:40:0x0109, B:45:0x0116, B:47:0x011e, B:52:0x012b, B:54:0x0133, B:59:0x0140, B:71:0x0143, B:75:0x0043, B:77:0x0051, B:79:0x0057, B:84:0x0064, B:88:0x015b), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0140 A[Catch: all -> 0x015e, TryCatch #1 {all -> 0x015e, blocks: (B:11:0x0030, B:13:0x0094, B:16:0x00a3, B:18:0x00b7, B:19:0x00bd, B:21:0x00c1, B:24:0x00c4, B:27:0x00cf, B:31:0x00ec, B:33:0x00f4, B:38:0x0101, B:40:0x0109, B:45:0x0116, B:47:0x011e, B:52:0x012b, B:54:0x0133, B:59:0x0140, B:71:0x0143, B:75:0x0043, B:77:0x0051, B:79:0x0057, B:84:0x0064, B:88:0x015b), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0143 A[Catch: all -> 0x015e, TryCatch #1 {all -> 0x015e, blocks: (B:11:0x0030, B:13:0x0094, B:16:0x00a3, B:18:0x00b7, B:19:0x00bd, B:21:0x00c1, B:24:0x00c4, B:27:0x00cf, B:31:0x00ec, B:33:0x00f4, B:38:0x0101, B:40:0x0109, B:45:0x0116, B:47:0x011e, B:52:0x012b, B:54:0x0133, B:59:0x0140, B:71:0x0143, B:75:0x0043, B:77:0x0051, B:79:0x0057, B:84:0x0064, B:88:0x015b), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchAndCache(Continuation<? super Unit> continuation) {
        VoiceChatConfigWarmup$fetchAndCache$1 voiceChatConfigWarmup$fetchAndCache$1;
        int i;
        int i2;
        int i3;
        Object startVoiceChat;
        HttpDataResult.Success success;
        int i4;
        int i5;
        int i6;
        int i7;
        if (continuation instanceof VoiceChatConfigWarmup$fetchAndCache$1) {
            voiceChatConfigWarmup$fetchAndCache$1 = (VoiceChatConfigWarmup$fetchAndCache$1) continuation;
            if ((voiceChatConfigWarmup$fetchAndCache$1.label & Integer.MIN_VALUE) != 0) {
                voiceChatConfigWarmup$fetchAndCache$1.label -= Integer.MIN_VALUE;
                VoiceChatConfigWarmup$fetchAndCache$1 voiceChatConfigWarmup$fetchAndCache$12 = voiceChatConfigWarmup$fetchAndCache$1;
                Object obj = voiceChatConfigWarmup$fetchAndCache$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = voiceChatConfigWarmup$fetchAndCache$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                    if (iLoginService != null) {
                        AccountInfo accountInfo = iLoginService.getAccountInfo();
                        if (accountInfo != null && accountInfo.isLogin()) {
                            IVoiceChatApi.Companion companion = IVoiceChatApi.INSTANCE;
                            String uuid = UUID.randomUUID().toString();
                            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
                            voiceChatConfigWarmup$fetchAndCache$12.L$0 = this;
                            voiceChatConfigWarmup$fetchAndCache$12.label = 1;
                            i2 = 1;
                            i3 = 0;
                            startVoiceChat = companion.startVoiceChat(uuid, VoiceChatApiPaths.HeaderValue.DEFAULT_X_APP_ID, SCENE_ID_CUSTOM, (r24 & 8) != 0 ? false : true, (r24 & 16) != 0 ? null : null, (r24 & 32) != 0 ? null : null, (r24 & 64) != 0 ? null : null, (r24 & 128) != 0 ? null : null, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : null, voiceChatConfigWarmup$fetchAndCache$12);
                            if (startVoiceChat == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                startVoiceChat = obj;
                i2 = 1;
                i3 = 0;
                success = (HttpDataResult) startVoiceChat;
                if (!(success instanceof HttpDataResult.Success)) {
                    lastFetchTimeMs = System.currentTimeMillis();
                    StartVoiceChatData startVoiceChatData = (StartVoiceChatData) success.getBizResp().getData();
                    String appId2 = startVoiceChatData != null ? startVoiceChatData.getAppId() : null;
                    appId = appId2;
                    if (appId2 == null) {
                        return Unit.INSTANCE;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(PageDataManager.EXTRA_STATUS, "success");
                    } catch (Throwable unused) {
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    long currentTimeMillis = System.currentTimeMillis();
                    VolcRtcClient.INSTANCE.preloadEngine(appId2);
                    try {
                        jSONObject2.put("duration_ms", System.currentTimeMillis() - currentTimeMillis);
                        ApmService.INSTANCE.monitorEventForSlardar(EVENT_NAME, jSONObject, jSONObject2, (JSONObject) null);
                    } catch (Throwable unused2) {
                    }
                    if (startVoiceChatData != null) {
                        String appId3 = startVoiceChatData.getAppId();
                        if (appId3 != null && !StringsKt.isBlank(appId3)) {
                            i4 = i3;
                            if (i4 == 0) {
                                String roomId = startVoiceChatData.getRoomId();
                                if (roomId != null && !StringsKt.isBlank(roomId)) {
                                    i5 = i3;
                                    if (i5 == 0) {
                                        String userId = startVoiceChatData.getUserId();
                                        if (userId != null && !StringsKt.isBlank(userId)) {
                                            i6 = i3;
                                            if (i6 == 0) {
                                                String token = startVoiceChatData.getToken();
                                                if (token != null && !StringsKt.isBlank(token)) {
                                                    i7 = i3;
                                                    if (i7 == 0) {
                                                        cachedData = startVoiceChatData;
                                                    }
                                                }
                                                i7 = i2;
                                                if (i7 == 0) {
                                                }
                                            }
                                        }
                                        i6 = i2;
                                        if (i6 == 0) {
                                        }
                                    }
                                }
                                i5 = i2;
                                if (i5 == 0) {
                                }
                            }
                        }
                        i4 = i2;
                        if (i4 == 0) {
                        }
                    }
                } else {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(PageDataManager.EXTRA_STATUS, "failed");
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("duration_ms", i3);
                    ApmService.INSTANCE.monitorEventForSlardar(EVENT_NAME, jSONObject3, jSONObject4, (JSONObject) null);
                }
                return Unit.INSTANCE;
            }
        }
        voiceChatConfigWarmup$fetchAndCache$1 = new VoiceChatConfigWarmup$fetchAndCache$1(this, continuation);
        VoiceChatConfigWarmup$fetchAndCache$1 voiceChatConfigWarmup$fetchAndCache$122 = voiceChatConfigWarmup$fetchAndCache$1;
        Object obj2 = voiceChatConfigWarmup$fetchAndCache$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = voiceChatConfigWarmup$fetchAndCache$122.label;
        if (i != 0) {
        }
        success = (HttpDataResult) startVoiceChat;
        if (!(success instanceof HttpDataResult.Success)) {
        }
        return Unit.INSTANCE;
    }
}
