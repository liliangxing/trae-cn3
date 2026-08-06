package com.bytedance.trae.conversation.brainstorm.widget;

import com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet;
import com.bytedance.trae.conversation.fileupload.BizType;
import com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi;
import com.bytedance.trae.conversation.fileupload.GetResourceUrlRequest;
import com.bytedance.trae.conversation.fileupload.GetResourceUrlResponse;
import com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.List;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BrainstormVoiceHistorySheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2$url$1", f = "BrainstormVoiceHistorySheet.kt", i = {}, l = {756, 759}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2$url$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class C0678xb7f0f9ad extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $imageId;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ BrainstormVoiceHistorySheet.HistoryRow.UserAttachment $row;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BrainstormVoiceHistorySheet.VoiceHistoryThumbnailLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0678xb7f0f9ad(String str, String str2, BrainstormVoiceHistorySheet.VoiceHistoryThumbnailLoader voiceHistoryThumbnailLoader, BrainstormVoiceHistorySheet.HistoryRow.UserAttachment userAttachment, Continuation<? super C0678xb7f0f9ad> continuation) {
        super(2, continuation);
        this.$imageId = str;
        this.$resourceId = str2;
        this.this$0 = voiceHistoryThumbnailLoader;
        this.$row = userAttachment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0678xb7f0f9ad = new C0678xb7f0f9ad(this.$imageId, this.$resourceId, this.this$0, this.$row, continuation);
        c0678xb7f0f9ad.L$0 = obj;
        return c0678xb7f0f9ad;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00ca A[Catch: all -> 0x001c, TryCatch #0 {all -> 0x001c, blocks: (B:7:0x0017, B:8:0x00bc, B:10:0x00ca, B:11:0x00d5, B:48:0x009d), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object obj3;
        String str;
        ConversationCopilotResourceUploadApi conversationCopilotResourceUploadApi;
        BrainstormVoiceHistorySheet.HistoryRow.UserAttachment userAttachment;
        ConversationCopilotImageUploadApi conversationCopilotImageUploadApi;
        String str2;
        String str3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        try {
            try {
            } catch (Throwable th) {
                Result.Companion companion = Result.Companion;
                obj3 = Result.constructor-impl(ResultKt.createFailure(th));
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        if (i != 0) {
            if (i == 1) {
                str2 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = Result.constructor-impl((String) ((Map) obj).get(str2));
                return (String) (Result.isFailure-impl(obj2) ? null : obj2);
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            userAttachment = (BrainstormVoiceHistorySheet.HistoryRow.UserAttachment) this.L$1;
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            Map<String, String> urlMap = ((GetResourceUrlResponse) obj).getUrlMap();
            str3 = urlMap.get(str);
            if (str3 == null) {
                str3 = urlMap.get(userAttachment.getPreviewResourceUri());
            }
            obj3 = Result.constructor-impl(str3);
            return (String) (Result.isFailure-impl(obj3) ? null : obj3);
        }
        ResultKt.throwOnFailure(obj);
        String str4 = this.$imageId;
        if (!(str4 == null || StringsKt.isBlank(str4))) {
            BrainstormVoiceHistorySheet.VoiceHistoryThumbnailLoader voiceHistoryThumbnailLoader = this.this$0;
            String str5 = this.$imageId;
            Result.Companion companion3 = Result.Companion;
            conversationCopilotImageUploadApi = voiceHistoryThumbnailLoader.imageUploadApi;
            List<String> listOf = CollectionsKt.listOf(str5);
            this.L$0 = str5;
            this.label = 1;
            obj = conversationCopilotImageUploadApi.getImageUrls(listOf, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            str2 = str5;
            obj2 = Result.constructor-impl((String) ((Map) obj).get(str2));
            return (String) (Result.isFailure-impl(obj2) ? null : obj2);
        }
        String str6 = this.$resourceId;
        if (str6 != null && !StringsKt.isBlank(str6)) {
            z = false;
        }
        if (z) {
            return null;
        }
        BrainstormVoiceHistorySheet.VoiceHistoryThumbnailLoader voiceHistoryThumbnailLoader2 = this.this$0;
        str = this.$resourceId;
        BrainstormVoiceHistorySheet.HistoryRow.UserAttachment userAttachment2 = this.$row;
        Result.Companion companion4 = Result.Companion;
        conversationCopilotResourceUploadApi = voiceHistoryThumbnailLoader2.resourceUploadApi;
        GetResourceUrlRequest getResourceUrlRequest = new GetResourceUrlRequest(CollectionsKt.listOf(str), BizType.RemoteResource);
        this.L$0 = str;
        this.L$1 = userAttachment2;
        this.label = 2;
        obj = conversationCopilotResourceUploadApi.getResourceUrl(getResourceUrlRequest, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        userAttachment = userAttachment2;
        Map<String, String> urlMap2 = ((GetResourceUrlResponse) obj).getUrlMap();
        str3 = urlMap2.get(str);
        if (str3 == null) {
        }
        obj3 = Result.constructor-impl(str3);
        return (String) (Result.isFailure-impl(obj3) ? null : obj3);
    }
}
