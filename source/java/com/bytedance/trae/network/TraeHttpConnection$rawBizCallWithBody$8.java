package com.bytedance.trae.network;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.network.response.HttpErrorCode;
import com.bytedance.ttnet.http.RequestContext;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: TraeHttpConnection.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.TraeHttpConnection$rawBizCallWithBody$8", f = "TraeHttpConnection.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeHttpConnection$rawBizCallWithBody$8<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TraeHttpConnection.RawBizCallResult<T>>, Object> {
    final /* synthetic */ boolean $allowEmptyBody;
    final /* synthetic */ Function1<RequestContext, SsResponse<String>> $execute;
    final /* synthetic */ String $interceptorPath;
    final /* synthetic */ Function2<String, SsResponse<String>, BizResponse<T>> $parseBody;
    final /* synthetic */ boolean $requireHttpSuccess;
    final /* synthetic */ Set<Long> $successCodes;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TraeHttpConnection$rawBizCallWithBody$8(Function1<? super RequestContext, SsResponse<String>> function1, boolean z, boolean z2, Function2<? super String, ? super SsResponse<String>, BizResponse<T>> function2, Set<Long> set, String str, Continuation<? super TraeHttpConnection$rawBizCallWithBody$8> continuation) {
        super(2, continuation);
        this.$execute = function1;
        this.$allowEmptyBody = z;
        this.$requireHttpSuccess = z2;
        this.$parseBody = function2;
        this.$successCodes = set;
        this.$interceptorPath = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TraeHttpConnection$rawBizCallWithBody$8<>(this.$execute, this.$allowEmptyBody, this.$requireHttpSuccess, this.$parseBody, this.$successCodes, this.$interceptorPath, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super TraeHttpConnection.RawBizCallResult<T>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        long elapsedRealtime;
        SsResponse<String> ssResponse;
        Throwable th;
        TraeHttpConnection.ErrorInfo extractErrorInfo;
        HttpDataResult.Error error;
        long elapsedRealtime2;
        String readRawBody;
        String takeIfPresentBody;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            elapsedRealtime = TraeHttpConnection.INSTANCE.elapsedRealtime();
            String str = null;
            try {
                RequestContext requestContext = new RequestContext();
                requestContext.force_handle_response = true;
                ssResponse = (SsResponse) this.$execute.invoke(requestContext);
            } catch (CancellationException e) {
                e = e;
                ssResponse = null;
            } catch (Throwable th2) {
                th = th2;
                ssResponse = null;
            }
            try {
                if (ssResponse == null) {
                    error = new HttpDataResult.Error(HttpErrorCode.NULL_POINTER, "ssResponse is null", new Exception("ssResponse is null"), null, 8, null);
                } else {
                    int code = ssResponse.code();
                    readRawBody = TraeHttpConnection.INSTANCE.readRawBody(ssResponse);
                    String normalizeJsonBody = readRawBody != null ? TraeHttpConnection.INSTANCE.normalizeJsonBody(readRawBody) : null;
                    if (normalizeJsonBody != null) {
                        try {
                            takeIfPresentBody = TraeHttpConnection.INSTANCE.takeIfPresentBody(normalizeJsonBody);
                        } catch (CancellationException e2) {
                            String str2 = normalizeJsonBody;
                            e = e2;
                            str = str2;
                            error = new HttpDataResult.Error(-1001, "", e, null, 8, null);
                            TraeHttpConnection traeHttpConnection = TraeHttpConnection.INSTANCE;
                            String str3 = this.$interceptorPath;
                            elapsedRealtime2 = TraeHttpConnection.INSTANCE.elapsedRealtime();
                            traeHttpConnection.trackRequestEventSafely(str3, elapsedRealtime2 - elapsedRealtime, error);
                            return new TraeHttpConnection.RawBizCallResult(error, str, ssResponse);
                        } catch (Throwable th3) {
                            th = th3;
                            str = normalizeJsonBody;
                            extractErrorInfo = TraeHttpConnection.INSTANCE.extractErrorInfo(th);
                            error = new HttpDataResult.Error(extractErrorInfo.getCode(), extractErrorInfo.getMessage(), th, null, 8, null);
                            TraeHttpConnection traeHttpConnection2 = TraeHttpConnection.INSTANCE;
                            String str32 = this.$interceptorPath;
                            elapsedRealtime2 = TraeHttpConnection.INSTANCE.elapsedRealtime();
                            traeHttpConnection2.trackRequestEventSafely(str32, elapsedRealtime2 - elapsedRealtime, error);
                            return new TraeHttpConnection.RawBizCallResult(error, str, ssResponse);
                        }
                    } else {
                        takeIfPresentBody = null;
                    }
                    String str4 = "";
                    if (takeIfPresentBody != null) {
                        str = takeIfPresentBody;
                    } else if (this.$allowEmptyBody) {
                        str = "";
                    }
                    if (this.$requireHttpSuccess && code != 200) {
                        String message = ssResponse.message();
                        if (message == null) {
                            message = "HTTP " + code;
                        }
                        StringBuilder append = new StringBuilder("HTTP ").append(code).append(": ");
                        if (takeIfPresentBody != null) {
                            str4 = takeIfPresentBody;
                        }
                        error = new HttpDataResult.Error(code, message, new Exception(append.append(str4).toString()), takeIfPresentBody);
                    } else if (str != null) {
                        BizResponse bizResponse = (BizResponse) this.$parseBody.invoke(str, ssResponse);
                        bizResponse.setupSSResponse(ssResponse);
                        bizResponse.setupSuccessCodes(this.$successCodes);
                        error = TraeHttpConnection.INSTANCE.successResult(this.$interceptorPath, bizResponse);
                    } else {
                        String message2 = ssResponse.message();
                        if (message2 == null) {
                            message2 = "Empty response body";
                        }
                        error = new HttpDataResult.Error(code, message2, new Exception("HTTP " + code + ": empty body"), null, 8, null);
                    }
                    str = normalizeJsonBody;
                }
            } catch (CancellationException e3) {
                e = e3;
            } catch (Throwable th4) {
                th = th4;
                th = th;
                extractErrorInfo = TraeHttpConnection.INSTANCE.extractErrorInfo(th);
                error = new HttpDataResult.Error(extractErrorInfo.getCode(), extractErrorInfo.getMessage(), th, null, 8, null);
                TraeHttpConnection traeHttpConnection22 = TraeHttpConnection.INSTANCE;
                String str322 = this.$interceptorPath;
                elapsedRealtime2 = TraeHttpConnection.INSTANCE.elapsedRealtime();
                traeHttpConnection22.trackRequestEventSafely(str322, elapsedRealtime2 - elapsedRealtime, error);
                return new TraeHttpConnection.RawBizCallResult(error, str, ssResponse);
            }
            TraeHttpConnection traeHttpConnection222 = TraeHttpConnection.INSTANCE;
            String str3222 = this.$interceptorPath;
            elapsedRealtime2 = TraeHttpConnection.INSTANCE.elapsedRealtime();
            traeHttpConnection222.trackRequestEventSafely(str3222, elapsedRealtime2 - elapsedRealtime, error);
            return new TraeHttpConnection.RawBizCallResult(error, str, ssResponse);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
