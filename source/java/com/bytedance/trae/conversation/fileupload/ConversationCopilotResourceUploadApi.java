package com.bytedance.trae.conversation.fileupload;

import com.bytedance.retrofit2.Converter;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.network.TraeHttpConnection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceUploadApi.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BK\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012*\b\u0002\u0010\u0005\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0005\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "Lcom/bytedance/trae/conversation/fileupload/ResourceUploadApi;", "baseUrlProvider", "Lkotlin/Function0;", "", "headersProvider", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "tag", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "Lkotlin/jvm/functions/Function1;", "createService", "Lcom/bytedance/trae/conversation/fileupload/ICopilotResourceUploadRetrofitApi;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResourceUploadUrl", "Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;", "req", "Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlRequest;", "(Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commitResourceUploadResult", "", "Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;", "(Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResourceUrl", "Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlResponse;", "Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;", "(Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationCopilotResourceUploadApi implements ResourceUploadApi {
    private final Function0<String> baseUrlProvider;
    private final Function1<Continuation<? super Map<String, String>>, Object> headersProvider;
    private final String tag;

    public ConversationCopilotResourceUploadApi(Function0<String> function0, Function1<? super Continuation<? super Map<String, String>>, ? extends Object> function1, String str) {
        Intrinsics.checkNotNullParameter(function0, "baseUrlProvider");
        Intrinsics.checkNotNullParameter(function1, "headersProvider");
        Intrinsics.checkNotNullParameter(str, "tag");
        this.baseUrlProvider = function0;
        this.headersProvider = function1;
        this.tag = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResourceUploadApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi$1", f = "ResourceUploadApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07271 extends SuspendLambda implements Function1<Continuation<? super Map<String, ? extends String>>, Object> {
        int label;

        C07271(Continuation<? super C07271> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C07271(continuation);
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

    public /* synthetic */ ConversationCopilotResourceUploadApi(Function0 function0, C07271 c07271, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? new C07271(null) : c07271, (i & 4) != 0 ? "conversation_file_upload" : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object createService(Continuation<? super ICopilotResourceUploadRetrofitApi> continuation) {
        ConversationCopilotResourceUploadApi$createService$1 conversationCopilotResourceUploadApi$createService$1;
        int i;
        String str;
        Class cls;
        String str2;
        TraeHttpConnection traeHttpConnection;
        if (continuation instanceof ConversationCopilotResourceUploadApi$createService$1) {
            conversationCopilotResourceUploadApi$createService$1 = (ConversationCopilotResourceUploadApi$createService$1) continuation;
            if ((conversationCopilotResourceUploadApi$createService$1.label & Integer.MIN_VALUE) != 0) {
                conversationCopilotResourceUploadApi$createService$1.label -= Integer.MIN_VALUE;
                Object obj = conversationCopilotResourceUploadApi$createService$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = conversationCopilotResourceUploadApi$createService$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    TraeHttpConnection traeHttpConnection2 = TraeHttpConnection.INSTANCE;
                    String str3 = this.tag;
                    String str4 = (String) this.baseUrlProvider.invoke();
                    Function1<Continuation<? super Map<String, String>>, Object> function1 = this.headersProvider;
                    conversationCopilotResourceUploadApi$createService$1.L$0 = traeHttpConnection2;
                    conversationCopilotResourceUploadApi$createService$1.L$1 = str3;
                    conversationCopilotResourceUploadApi$createService$1.L$2 = ICopilotResourceUploadRetrofitApi.class;
                    conversationCopilotResourceUploadApi$createService$1.L$3 = str4;
                    conversationCopilotResourceUploadApi$createService$1.label = 1;
                    Object invoke = function1.invoke(conversationCopilotResourceUploadApi$createService$1);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str = str3;
                    cls = ICopilotResourceUploadRetrofitApi.class;
                    str2 = str4;
                    traeHttpConnection = traeHttpConnection2;
                    obj = invoke;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    String str5 = (String) conversationCopilotResourceUploadApi$createService$1.L$3;
                    cls = (Class) conversationCopilotResourceUploadApi$createService$1.L$2;
                    String str6 = (String) conversationCopilotResourceUploadApi$createService$1.L$1;
                    traeHttpConnection = (TraeHttpConnection) conversationCopilotResourceUploadApi$createService$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str2 = str5;
                    str = str6;
                }
                return TraeHttpConnection.createService$default(traeHttpConnection, str, cls, (Converter.Factory) null, str2, (Map) obj, false, 36, (Object) null);
            }
        }
        conversationCopilotResourceUploadApi$createService$1 = new ConversationCopilotResourceUploadApi$createService$1(this, continuation);
        Object obj2 = conversationCopilotResourceUploadApi$createService$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = conversationCopilotResourceUploadApi$createService$1.label;
        if (i != 0) {
        }
        return TraeHttpConnection.createService$default(traeHttpConnection, str, cls, (Converter.Factory) null, str2, (Map) obj2, false, 36, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0059 A[PHI: r7
      0x0059: PHI (r7v6 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x0056, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.bytedance.trae.conversation.fileupload.ResourceUploadApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getResourceUploadUrl(GetResourceUploadUrlRequest getResourceUploadUrlRequest, Continuation<? super GetResourceUploadUrlResponse> continuation) {
        ConversationCopilotResourceUploadApi$getResourceUploadUrl$1 conversationCopilotResourceUploadApi$getResourceUploadUrl$1;
        int i;
        if (continuation instanceof ConversationCopilotResourceUploadApi$getResourceUploadUrl$1) {
            conversationCopilotResourceUploadApi$getResourceUploadUrl$1 = (ConversationCopilotResourceUploadApi$getResourceUploadUrl$1) continuation;
            if ((conversationCopilotResourceUploadApi$getResourceUploadUrl$1.label & Integer.MIN_VALUE) != 0) {
                conversationCopilotResourceUploadApi$getResourceUploadUrl$1.label -= Integer.MIN_VALUE;
                Object obj = conversationCopilotResourceUploadApi$getResourceUploadUrl$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = conversationCopilotResourceUploadApi$getResourceUploadUrl$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    conversationCopilotResourceUploadApi$getResourceUploadUrl$1.L$0 = getResourceUploadUrlRequest;
                    conversationCopilotResourceUploadApi$getResourceUploadUrl$1.label = 1;
                    obj = createService(conversationCopilotResourceUploadApi$getResourceUploadUrl$1);
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
                    getResourceUploadUrlRequest = (GetResourceUploadUrlRequest) conversationCopilotResourceUploadApi$getResourceUploadUrl$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                conversationCopilotResourceUploadApi$getResourceUploadUrl$1.L$0 = null;
                conversationCopilotResourceUploadApi$getResourceUploadUrl$1.label = 2;
                obj = ((ICopilotResourceUploadRetrofitApi) obj).getResourceUploadUrl(getResourceUploadUrlRequest, conversationCopilotResourceUploadApi$getResourceUploadUrl$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        conversationCopilotResourceUploadApi$getResourceUploadUrl$1 = new ConversationCopilotResourceUploadApi$getResourceUploadUrl$1(this, continuation);
        Object obj2 = conversationCopilotResourceUploadApi$getResourceUploadUrl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = conversationCopilotResourceUploadApi$getResourceUploadUrl$1.label;
        if (i != 0) {
        }
        conversationCopilotResourceUploadApi$getResourceUploadUrl$1.L$0 = null;
        conversationCopilotResourceUploadApi$getResourceUploadUrl$1.label = 2;
        obj2 = ((ICopilotResourceUploadRetrofitApi) obj2).getResourceUploadUrl(getResourceUploadUrlRequest, conversationCopilotResourceUploadApi$getResourceUploadUrl$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.bytedance.trae.conversation.fileupload.ResourceUploadApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object commitResourceUploadResult(CommitResourceUploadResultRequest commitResourceUploadResultRequest, Continuation<? super Unit> continuation) {
        C0728xed751a72 c0728xed751a72;
        Object obj;
        Object coroutine_suspended;
        int i;
        if (continuation instanceof C0728xed751a72) {
            c0728xed751a72 = (C0728xed751a72) continuation;
            if ((c0728xed751a72.label & Integer.MIN_VALUE) != 0) {
                c0728xed751a72.label -= Integer.MIN_VALUE;
                obj = c0728xed751a72.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0728xed751a72.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    c0728xed751a72.L$0 = commitResourceUploadResultRequest;
                    c0728xed751a72.label = 1;
                    obj = createService(c0728xed751a72);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    commitResourceUploadResultRequest = (CommitResourceUploadResultRequest) c0728xed751a72.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                c0728xed751a72.L$0 = null;
                c0728xed751a72.label = 2;
                if (((ICopilotResourceUploadRetrofitApi) obj).commitResourceUploadResult(commitResourceUploadResultRequest, c0728xed751a72) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        c0728xed751a72 = new C0728xed751a72(this, continuation);
        obj = c0728xed751a72.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c0728xed751a72.label;
        if (i != 0) {
        }
        c0728xed751a72.L$0 = null;
        c0728xed751a72.label = 2;
        if (((ICopilotResourceUploadRetrofitApi) obj).commitResourceUploadResult(commitResourceUploadResultRequest, c0728xed751a72) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0059 A[PHI: r7
      0x0059: PHI (r7v6 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x0056, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.bytedance.trae.conversation.fileupload.ResourceUploadApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getResourceUrl(GetResourceUrlRequest getResourceUrlRequest, Continuation<? super GetResourceUrlResponse> continuation) {
        ConversationCopilotResourceUploadApi$getResourceUrl$1 conversationCopilotResourceUploadApi$getResourceUrl$1;
        int i;
        if (continuation instanceof ConversationCopilotResourceUploadApi$getResourceUrl$1) {
            conversationCopilotResourceUploadApi$getResourceUrl$1 = (ConversationCopilotResourceUploadApi$getResourceUrl$1) continuation;
            if ((conversationCopilotResourceUploadApi$getResourceUrl$1.label & Integer.MIN_VALUE) != 0) {
                conversationCopilotResourceUploadApi$getResourceUrl$1.label -= Integer.MIN_VALUE;
                Object obj = conversationCopilotResourceUploadApi$getResourceUrl$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = conversationCopilotResourceUploadApi$getResourceUrl$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    conversationCopilotResourceUploadApi$getResourceUrl$1.L$0 = getResourceUrlRequest;
                    conversationCopilotResourceUploadApi$getResourceUrl$1.label = 1;
                    obj = createService(conversationCopilotResourceUploadApi$getResourceUrl$1);
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
                    getResourceUrlRequest = (GetResourceUrlRequest) conversationCopilotResourceUploadApi$getResourceUrl$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                conversationCopilotResourceUploadApi$getResourceUrl$1.L$0 = null;
                conversationCopilotResourceUploadApi$getResourceUrl$1.label = 2;
                obj = ((ICopilotResourceUploadRetrofitApi) obj).getResourceUrl(getResourceUrlRequest, conversationCopilotResourceUploadApi$getResourceUrl$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        conversationCopilotResourceUploadApi$getResourceUrl$1 = new ConversationCopilotResourceUploadApi$getResourceUrl$1(this, continuation);
        Object obj2 = conversationCopilotResourceUploadApi$getResourceUrl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = conversationCopilotResourceUploadApi$getResourceUrl$1.label;
        if (i != 0) {
        }
        conversationCopilotResourceUploadApi$getResourceUrl$1.L$0 = null;
        conversationCopilotResourceUploadApi$getResourceUrl$1.label = 2;
        obj2 = ((ICopilotResourceUploadRetrofitApi) obj2).getResourceUrl(getResourceUrlRequest, conversationCopilotResourceUploadApi$getResourceUrl$1);
        if (obj2 != coroutine_suspended2) {
        }
    }
}
