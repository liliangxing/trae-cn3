package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.fileupload.BizType;
import com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi;
import com.bytedance.trae.conversation.fileupload.GetResourceUrlRequest;
import com.bytedance.trae.conversation.fileupload.GetResourceUrlResponse;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputPreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.InputPreviewActivity$fetchRemoteResourceUrl$2", f = "InputPreviewActivity.kt", i = {}, l = {332}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputPreviewActivity$fetchRemoteResourceUrl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $resourceUri;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ InputPreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputPreviewActivity$fetchRemoteResourceUrl$2(InputPreviewActivity inputPreviewActivity, String str, Continuation<? super InputPreviewActivity$fetchRemoteResourceUrl$2> continuation) {
        super(2, continuation);
        this.this$0 = inputPreviewActivity;
        this.$resourceUri = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> inputPreviewActivity$fetchRemoteResourceUrl$2 = new InputPreviewActivity$fetchRemoteResourceUrl$2(this.this$0, this.$resourceUri, continuation);
        inputPreviewActivity$fetchRemoteResourceUrl$2.L$0 = obj;
        return inputPreviewActivity$fetchRemoteResourceUrl$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008f, code lost:
    
        r14 = com.bytedance.trae.utils.logger.FLogger.INSTANCE;
        r0 = new java.lang.StringBuilder("fetchRemoteResourceUrl missing url, resourceUri=").append(r1).append(", oidId=");
        r1 = r2.oidId;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a4, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a6, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("oidId");
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00aa, code lost:
    
        r0 = r0.append(r1).append(", fileName=");
        r1 = r2.fileName;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b6, code lost:
    
        if (r1 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b8, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("fileName");
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bc, code lost:
    
        r14.w("InputPreviewActivity", r0.append(r1).toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String str;
        String str2;
        InputPreviewActivity inputPreviewActivity;
        ConversationCopilotResourceUploadApi resourceUploadApi;
        String str3;
        String str4;
        String str5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                inputPreviewActivity = this.this$0;
                String str6 = this.$resourceUri;
                Result.Companion companion = Result.Companion;
                resourceUploadApi = inputPreviewActivity.getResourceUploadApi();
                GetResourceUrlRequest getResourceUrlRequest = new GetResourceUrlRequest(CollectionsKt.listOf(str6), BizType.RemoteResource);
                this.L$0 = inputPreviewActivity;
                this.L$1 = str6;
                this.label = 1;
                Object resourceUrl = resourceUploadApi.getResourceUrl(getResourceUrlRequest, this);
                if (resourceUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str3 = str6;
                obj = resourceUrl;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str3 = (String) this.L$1;
                inputPreviewActivity = (InputPreviewActivity) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Map<String, String> urlMap = ((GetResourceUrlResponse) obj).getUrlMap();
            String str7 = urlMap.get(str3);
            if (str7 == null) {
                str4 = inputPreviewActivity.oidId;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("oidId");
                    str4 = null;
                }
                str7 = urlMap.get(str4);
                if (str7 == null) {
                    str5 = inputPreviewActivity.extraOidId;
                    str7 = urlMap.get(str5);
                }
            }
            String str8 = str7;
            if (str8 != null && !StringsKt.isBlank(str8)) {
                z = false;
            }
            obj2 = Result.constructor-impl(str7);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        InputPreviewActivity inputPreviewActivity2 = this.this$0;
        Throwable th2 = Result.exceptionOrNull-impl(obj2);
        if (th2 != null) {
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("fetchRemoteResourceUrl failed, oidId=");
            str = inputPreviewActivity2.oidId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("oidId");
                str = null;
            }
            StringBuilder append = sb.append(str).append(", fileName=");
            str2 = inputPreviewActivity2.fileName;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileName");
                str2 = null;
            }
            fLogger.w("InputPreviewActivity", append.append(str2).append(", error=").append(th2.getMessage()).toString());
        }
        if (Result.isFailure-impl(obj2)) {
            return null;
        }
        return obj2;
    }
}
