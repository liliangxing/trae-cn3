package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MultiImagePreviewActivity.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1", f = "MultiImagePreviewActivity.kt", i = {}, l = {373}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends String>>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MultiImagePreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1(MultiImagePreviewActivity multiImagePreviewActivity, Continuation<? super MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1> continuation) {
        super(2, continuation);
        this.this$0 = multiImagePreviewActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> multiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1 = new MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1(this.this$0, continuation);
        multiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1.L$0 = obj;
        return multiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, String>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        ConversationCopilotImageUploadApi imageUploadApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MultiImagePreviewActivity multiImagePreviewActivity = this.this$0;
                Result.Companion companion = Result.Companion;
                imageUploadApi = multiImagePreviewActivity.getImageUploadApi();
                List<String> list = multiImagePreviewActivity.paths;
                this.label = 1;
                obj = imageUploadApi.getImageUrls(list, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            obj2 = Result.constructor-impl((Map) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj2)) {
            obj2 = null;
        }
        Map map = (Map) obj2;
        return map == null ? MapsKt.emptyMap() : map;
    }
}
