package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.ISubTaskResultApi;
import com.bytedance.trae.im.service.SubTaskResultRequest;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoiceSubTaskCoordinator.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1", f = "VoiceSubTaskCoordinator.kt", i = {}, l = {2684}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $durationMs;
    final /* synthetic */ String $errorCode;
    final /* synthetic */ String $reportTaskId;
    final /* synthetic */ String $result;
    final /* synthetic */ String $safeError;
    final /* synthetic */ String $scene;
    final /* synthetic */ String $status;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1(String str, String str2, String str3, String str4, long j, String str5, String str6, Continuation<? super VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1> continuation) {
        super(2, continuation);
        this.$reportTaskId = str;
        this.$result = str2;
        this.$status = str3;
        this.$errorCode = str4;
        this.$durationMs = j;
        this.$safeError = str5;
        this.$scene = str6;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1(this.$reportTaskId, this.$result, this.$status, this.$errorCode, this.$durationMs, this.$safeError, this.$scene, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SubTaskResultRequest subTaskResultRequest = new SubTaskResultRequest(this.$reportTaskId, this.$result, this.$status, this.$errorCode, this.$durationMs, this.$safeError);
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder append = new StringBuilder("postSubTaskResult[").append(this.$scene).append("]: posting taskId=").append(this.$reportTaskId).append(" status=").append(this.$status).append(" durationMs=").append(this.$durationMs).append(" errorCode=").append(this.$errorCode).append(" resultLen=").append(this.$result.length()).append(" errorLen=");
            String str = this.$safeError;
            fLogger.d("VoiceSubTaskCoord", append.append(str != null ? str.length() : 0).toString());
            this.label = 1;
            obj = ISubTaskResultApi.INSTANCE.safeCall(new C0786x2c0ab789(subTaskResultRequest, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        HttpDataResult.Success success = (HttpDataResult) obj;
        if (success instanceof HttpDataResult.Success) {
            FLogger.INSTANCE.d("VoiceSubTaskCoord", "postSubTaskResult[" + this.$scene + "]: ok taskId=" + this.$reportTaskId + " bizCode=" + success.getBizResp().getCode());
        } else {
            if (!(success instanceof HttpDataResult.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            VoiceSubTaskCoordinator.INSTANCE.clearSubTaskResultReportStarted(this.$reportTaskId);
            HttpDataResult.Error error = (HttpDataResult.Error) success;
            FLogger.INSTANCE.w("VoiceSubTaskCoord", "postSubTaskResult[" + this.$scene + "]: failed taskId=" + this.$reportTaskId + " code=" + error.getCode() + " msg=" + error.getMsg());
        }
        return Unit.INSTANCE;
    }
}
