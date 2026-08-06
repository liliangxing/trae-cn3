package com.bytedance.trae.conversation.imageupload;

import com.bytedance.retrofit2.Converter;
import com.bytedance.trae.conversation.LoginUtils;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.network.TraeHttpConnection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUploadApi.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001BK\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012*\b\u0002\u0010\u0005\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0096@¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0096@¢\u0006\u0002\u0010\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0005\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;", "Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;", "baseUrlProvider", "Lkotlin/Function0;", "", "headersProvider", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "tag", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "Lkotlin/jvm/functions/Function1;", "createService", "Lcom/bytedance/trae/conversation/imageupload/ICopilotImageUploadRetrofitApi;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStsToken", "Lcom/bytedance/trae/conversation/imageupload/StsTokenResponse;", "userId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageUrls", "tosUris", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkImageContent", "Lcom/bytedance/trae/conversation/imageupload/ContentCheckResult;", "uri", "isEnterpriseLogin", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationCopilotImageUploadApi implements ImageUploadApi {
    private final Function0<String> baseUrlProvider;
    private final Function1<Continuation<? super Map<String, String>>, Object> headersProvider;
    private final String tag;

    public ConversationCopilotImageUploadApi(Function0<String> function0, Function1<? super Continuation<? super Map<String, String>>, ? extends Object> function1, String str) {
        Intrinsics.checkNotNullParameter(function0, "baseUrlProvider");
        Intrinsics.checkNotNullParameter(function1, "headersProvider");
        Intrinsics.checkNotNullParameter(str, "tag");
        this.baseUrlProvider = function0;
        this.headersProvider = function1;
        this.tag = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImageUploadApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi$1", f = "ImageUploadApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07291 extends SuspendLambda implements Function1<Continuation<? super Map<String, ? extends String>>, Object> {
        int label;

        C07291(Continuation<? super C07291> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C07291(continuation);
        }

        public final Object invoke(Continuation<? super Map<String, String>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return MapsKt.emptyMap();
        }
    }

    public /* synthetic */ ConversationCopilotImageUploadApi(Function0 function0, C07291 c07291, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? new C07291(null) : c07291, (i & 4) != 0 ? "conversation_image_upload" : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object createService(Continuation<? super ICopilotImageUploadRetrofitApi> continuation) {
        ConversationCopilotImageUploadApi$createService$1 conversationCopilotImageUploadApi$createService$1;
        int i;
        ConversationCopilotImageUploadApi conversationCopilotImageUploadApi;
        if (continuation instanceof ConversationCopilotImageUploadApi$createService$1) {
            conversationCopilotImageUploadApi$createService$1 = (ConversationCopilotImageUploadApi$createService$1) continuation;
            if ((conversationCopilotImageUploadApi$createService$1.label & Integer.MIN_VALUE) != 0) {
                conversationCopilotImageUploadApi$createService$1.label -= Integer.MIN_VALUE;
                Object obj = conversationCopilotImageUploadApi$createService$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = conversationCopilotImageUploadApi$createService$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Function1<Continuation<? super Map<String, String>>, Object> function1 = this.headersProvider;
                    conversationCopilotImageUploadApi$createService$1.L$0 = this;
                    conversationCopilotImageUploadApi$createService$1.label = 1;
                    obj = function1.invoke(conversationCopilotImageUploadApi$createService$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    conversationCopilotImageUploadApi = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    conversationCopilotImageUploadApi = (ConversationCopilotImageUploadApi) conversationCopilotImageUploadApi$createService$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, conversationCopilotImageUploadApi.tag, ICopilotImageUploadRetrofitApi.class, (Converter.Factory) null, (String) conversationCopilotImageUploadApi.baseUrlProvider.invoke(), (Map) obj, false, 36, (Object) null);
            }
        }
        conversationCopilotImageUploadApi$createService$1 = new ConversationCopilotImageUploadApi$createService$1(this, continuation);
        Object obj2 = conversationCopilotImageUploadApi$createService$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = conversationCopilotImageUploadApi$createService$1.label;
        if (i != 0) {
        }
        return TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, conversationCopilotImageUploadApi.tag, ICopilotImageUploadRetrofitApi.class, (Converter.Factory) null, (String) conversationCopilotImageUploadApi.baseUrlProvider.invoke(), (Map) obj2, false, 36, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0056 A[PHI: r6
      0x0056: PHI (r6v7 java.lang.Object) = (r6v6 java.lang.Object), (r6v1 java.lang.Object) binds: [B:18:0x0053, B:11:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Override // com.bytedance.trae.conversation.imageupload.ImageUploadApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getStsToken(String str, Continuation<? super StsTokenResponse> continuation) {
        ConversationCopilotImageUploadApi$getStsToken$1 conversationCopilotImageUploadApi$getStsToken$1;
        int i;
        try {
            if (continuation instanceof ConversationCopilotImageUploadApi$getStsToken$1) {
                conversationCopilotImageUploadApi$getStsToken$1 = (ConversationCopilotImageUploadApi$getStsToken$1) continuation;
                if ((conversationCopilotImageUploadApi$getStsToken$1.label & Integer.MIN_VALUE) != 0) {
                    conversationCopilotImageUploadApi$getStsToken$1.label -= Integer.MIN_VALUE;
                    Object obj = conversationCopilotImageUploadApi$getStsToken$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = conversationCopilotImageUploadApi$getStsToken$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        conversationCopilotImageUploadApi$getStsToken$1.label = 1;
                        obj = createService(conversationCopilotImageUploadApi$getStsToken$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            if (i == 2) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Map<String, String> emptyMap = MapsKt.emptyMap();
                    conversationCopilotImageUploadApi$getStsToken$1.label = 2;
                    obj = ((ICopilotImageUploadRetrofitApi) obj).getResourceUploadToken(emptyMap, conversationCopilotImageUploadApi$getStsToken$1);
                    return obj != coroutine_suspended ? coroutine_suspended : obj;
                }
            }
            if (i != 0) {
            }
            Map<String, String> emptyMap2 = MapsKt.emptyMap();
            conversationCopilotImageUploadApi$getStsToken$1.label = 2;
            obj = ((ICopilotImageUploadRetrofitApi) obj).getResourceUploadToken(emptyMap2, conversationCopilotImageUploadApi$getStsToken$1);
            if (obj != coroutine_suspended) {
            }
        } catch (Throwable th) {
            throw new ImageUploadException(ImageUploadErrorCode.TOKEN_FETCH_FAILED, "getStsToken failed: " + th.getMessage(), th);
        }
        conversationCopilotImageUploadApi$getStsToken$1 = new ConversationCopilotImageUploadApi$getStsToken$1(this, continuation);
        Object obj2 = conversationCopilotImageUploadApi$getStsToken$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = conversationCopilotImageUploadApi$getStsToken$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Override // com.bytedance.trae.conversation.imageupload.ImageUploadApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getImageUrls(List<String> list, Continuation<? super Map<String, String>> continuation) {
        ConversationCopilotImageUploadApi$getImageUrls$1 conversationCopilotImageUploadApi$getImageUrls$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        ConversationCopilotImageUploadApi conversationCopilotImageUploadApi;
        try {
            if (continuation instanceof ConversationCopilotImageUploadApi$getImageUrls$1) {
                conversationCopilotImageUploadApi$getImageUrls$1 = (ConversationCopilotImageUploadApi$getImageUrls$1) continuation;
                if ((conversationCopilotImageUploadApi$getImageUrls$1.label & Integer.MIN_VALUE) != 0) {
                    conversationCopilotImageUploadApi$getImageUrls$1.label -= Integer.MIN_VALUE;
                    obj = conversationCopilotImageUploadApi$getImageUrls$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = conversationCopilotImageUploadApi$getImageUrls$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (list.isEmpty()) {
                            return MapsKt.emptyMap();
                        }
                        conversationCopilotImageUploadApi$getImageUrls$1.L$0 = this;
                        conversationCopilotImageUploadApi$getImageUrls$1.L$1 = list;
                        conversationCopilotImageUploadApi$getImageUrls$1.label = 1;
                        obj = createService(conversationCopilotImageUploadApi$getImageUrls$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        conversationCopilotImageUploadApi = this;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return ((GetResourceUrlResponse) obj).getUrlMap();
                        }
                        list = (List) conversationCopilotImageUploadApi$getImageUrls$1.L$1;
                        conversationCopilotImageUploadApi = (ConversationCopilotImageUploadApi) conversationCopilotImageUploadApi$getImageUrls$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    ICopilotImageUploadRetrofitApi iCopilotImageUploadRetrofitApi = (ICopilotImageUploadRetrofitApi) obj;
                    GetResourceUrlRequest getResourceUrlRequest = new GetResourceUrlRequest(list, !conversationCopilotImageUploadApi.isEnterpriseLogin() ? "image" : null);
                    conversationCopilotImageUploadApi$getImageUrls$1.L$0 = null;
                    conversationCopilotImageUploadApi$getImageUrls$1.L$1 = null;
                    conversationCopilotImageUploadApi$getImageUrls$1.label = 2;
                    obj = iCopilotImageUploadRetrofitApi.getResourceUrl(getResourceUrlRequest, conversationCopilotImageUploadApi$getImageUrls$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return ((GetResourceUrlResponse) obj).getUrlMap();
                }
            }
            if (i != 0) {
            }
            ICopilotImageUploadRetrofitApi iCopilotImageUploadRetrofitApi2 = (ICopilotImageUploadRetrofitApi) obj;
            GetResourceUrlRequest getResourceUrlRequest2 = new GetResourceUrlRequest(list, !conversationCopilotImageUploadApi.isEnterpriseLogin() ? "image" : null);
            conversationCopilotImageUploadApi$getImageUrls$1.L$0 = null;
            conversationCopilotImageUploadApi$getImageUrls$1.L$1 = null;
            conversationCopilotImageUploadApi$getImageUrls$1.label = 2;
            obj = iCopilotImageUploadRetrofitApi2.getResourceUrl(getResourceUrlRequest2, conversationCopilotImageUploadApi$getImageUrls$1);
            if (obj == coroutine_suspended) {
            }
            return ((GetResourceUrlResponse) obj).getUrlMap();
        } catch (Throwable th) {
            throw new ImageUploadException(ImageUploadErrorCode.NETWORK_ERROR, "getImageUrls failed: " + th.getMessage(), th);
        }
        conversationCopilotImageUploadApi$getImageUrls$1 = new ConversationCopilotImageUploadApi$getImageUrls$1(this, continuation);
        obj = conversationCopilotImageUploadApi$getImageUrls$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = conversationCopilotImageUploadApi$getImageUrls$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    @Override // com.bytedance.trae.conversation.imageupload.ImageUploadApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object checkImageContent(String str, Continuation<? super ContentCheckResult> continuation) {
        ConversationCopilotImageUploadApi$checkImageContent$1 conversationCopilotImageUploadApi$checkImageContent$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        try {
            if (continuation instanceof ConversationCopilotImageUploadApi$checkImageContent$1) {
                conversationCopilotImageUploadApi$checkImageContent$1 = (ConversationCopilotImageUploadApi$checkImageContent$1) continuation;
                if ((conversationCopilotImageUploadApi$checkImageContent$1.label & Integer.MIN_VALUE) != 0) {
                    conversationCopilotImageUploadApi$checkImageContent$1.label -= Integer.MIN_VALUE;
                    obj = conversationCopilotImageUploadApi$checkImageContent$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = conversationCopilotImageUploadApi$checkImageContent$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        conversationCopilotImageUploadApi$checkImageContent$1.L$0 = str;
                        conversationCopilotImageUploadApi$checkImageContent$1.label = 1;
                        obj = createService(conversationCopilotImageUploadApi$checkImageContent$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return new ContentCheckResult(0, Boxing.boxBoolean(((CheckContentResponse) obj).getPass()));
                        }
                        str = (String) conversationCopilotImageUploadApi$checkImageContent$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    CheckContentRequest checkContentRequest = new CheckContentRequest(str);
                    conversationCopilotImageUploadApi$checkImageContent$1.L$0 = null;
                    conversationCopilotImageUploadApi$checkImageContent$1.label = 2;
                    obj = ((ICopilotImageUploadRetrofitApi) obj).checkContent(checkContentRequest, conversationCopilotImageUploadApi$checkImageContent$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return new ContentCheckResult(0, Boxing.boxBoolean(((CheckContentResponse) obj).getPass()));
                }
            }
            if (i != 0) {
            }
            CheckContentRequest checkContentRequest2 = new CheckContentRequest(str);
            conversationCopilotImageUploadApi$checkImageContent$1.L$0 = null;
            conversationCopilotImageUploadApi$checkImageContent$1.label = 2;
            obj = ((ICopilotImageUploadRetrofitApi) obj).checkContent(checkContentRequest2, conversationCopilotImageUploadApi$checkImageContent$1);
            if (obj == coroutine_suspended) {
            }
            return new ContentCheckResult(0, Boxing.boxBoolean(((CheckContentResponse) obj).getPass()));
        } catch (Throwable unused) {
            return null;
        }
        conversationCopilotImageUploadApi$checkImageContent$1 = new ConversationCopilotImageUploadApi$checkImageContent$1(this, continuation);
        obj = conversationCopilotImageUploadApi$checkImageContent$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = conversationCopilotImageUploadApi$checkImageContent$1.label;
    }

    private final boolean isEnterpriseLogin() {
        return LoginUtils.INSTANCE.isEnterpriseLogin();
    }
}
