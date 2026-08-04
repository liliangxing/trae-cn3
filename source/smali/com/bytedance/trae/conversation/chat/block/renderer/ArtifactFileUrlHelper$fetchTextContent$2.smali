# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactFileUrlHelper.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cliType:Ljava/lang/String;
.field final synthetic $url:Ljava/lang/String;
.field  label:I


.method public static synthetic $r8$lambda$ndw_zjAPCZ-XINlKwccbQhIlqsg(java.lang.String  com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;->invokeSuspend$lambda$0(Ljava/lang/String; Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;->$cliType Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;->$url Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(java.lang.String  com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 3
    # ins_size=2
    if-eqz v2, +01ah
    invoke-interface v2, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->request()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    if-nez v0, +003h
    goto +12h
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->newBuilder()Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v0
    invoke-virtual v0, v1, Lcom/bytedance/retrofit2/client/Request$Builder;->url(Ljava/lang/String;)Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/retrofit2/client/Request$Builder;->build()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v1
    invoke-interface v2, v1, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->proceed(Lcom/bytedance/retrofit2/client/Request;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v1
    return-object v1
    const/4 v1, 0
    return-object v1
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;->$cliType Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;->$url Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;->label I
    if-nez v0, +08ch
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    const/4 v5, 0
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;->$cliType Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00ch
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;->$url Ljava/lang/String;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2$$ExternalSyntheticLambda0;
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String;)V
    invoke-interface v0, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    const-string v1, "https://placeholder.trae/"
    invoke-static v1, v0, v5, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsRetrofit(Ljava/lang/String; Ljava/util/List; Lcom/bytedance/retrofit2/Converter$Factory;)Lcom/bytedance/retrofit2/Retrofit;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$TxtFetchApi;
    invoke-virtual v0, v1, Lcom/bytedance/retrofit2/Retrofit;->create(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$TxtFetchApi;
    if-nez v0, +003h
    return-object v5
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;->$url Ljava/lang/String;
    const/high16 v2, 52428800
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$TxtFetchApi;->get(Ljava/lang/String; I)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/retrofit2/mime/TypedInput;
    if-nez v0, +005h
    const-string v5, ""
    return-object v5
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    invoke-interface v0, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v0
    const-string v2, "in(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->access$readAllBytes(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper; Ljava/io/InputStream;)[B
    move-result-object v0
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;->$cliType Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00eh
    new-instance v1, Ljava/lang/String;
    invoke-static v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->decodeContent([B)[B
    move-result-object v0
    sget-object v2, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v1, v0, v2, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    goto +8h
    new-instance v1, Ljava/lang/String;
    sget-object v2, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v1, v0, v2, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    move-object v5, v1
    goto +dh
    move-exception v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "fetchTextContent error"
    check-cast v0, Ljava/lang/Throwable;
    const-string v3, "ArtifactFileUrlHelper"
    invoke-virtual v1, v3, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-object v5
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    :try_start_0xb
.end method
