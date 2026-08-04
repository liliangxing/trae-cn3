# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
.super Ljava/lang/Object;
.source "ArtifactFileUrlHelper.kt"

.field private static final DOWNLOAD_URL_MAX_RETRIES:I
.field private static final DOWNLOAD_URL_RETRY_DELAY_MS:J
.field private static final IM_ARTIFACT_PREVIEW:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$fetchLocalFileUrl(com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->fetchLocalFileUrl(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchRemoteFileUrl(com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->fetchRemoteFileUrl(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$readAllBytes(com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper  java.io.InputStream)byte[]
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->readAllBytes(Ljava/io/InputStream;)[B
    move-result-object v0
    return-object v0
.end method

.method private final buildFileUrl(java.lang.String  java.lang.String)java.lang.String
    .registers 9
    # ins_size=3
    const-string v0, "UTF-8"
    invoke-static v8, v0, Ljava/net/URLEncoder;->encode(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    if-nez v1, +004h
    const-string v1, ""
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    const/4 v3, 1
    new-array v3, v3, [C
    const/4 v4, 0
    const/16 v5, 47
    aput-char v5, v3, v4
    invoke-static v7, v3, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v2, "/file/"
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, "?download=true&authorization="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v2, "Cloud-IDE-JWT "
    invoke-direct v8, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v0, Ljava/net/URLEncoder;->encode(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    return-object v7
.end method

.method private final fetchLocalFileUrl(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 24
    # ins_size=5
    move-object/from16 v0, v23
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->label I
    move-object/from16 v2, v19
    goto +8h
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;
    move-object/from16 v2, v19
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->label I
    const/4 v6, 2
    const/4 v7, 1
    const/4 v8, 0
    if-eqz v4, +047h
    if-eq v4, v7, +027h
    if-ne v4, v6, +01dh
    iget v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->I$0 I
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$4 Ljava/lang/Object;
    check-cast v9, Lorg/json/JSONObject;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$3 Ljava/lang/Object;
    check-cast v10, Ljava/lang/String;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$2 Ljava/lang/Object;
    check-cast v11, Ljava/lang/String;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$1 Ljava/lang/Object;
    check-cast v12, Ljava/lang/String;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$0 Ljava/lang/Object;
    check-cast v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +124h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->I$0 I
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$4 Ljava/lang/Object;
    check-cast v9, Lorg/json/JSONObject;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$3 Ljava/lang/Object;
    check-cast v10, Ljava/lang/String;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$2 Ljava/lang/Object;
    check-cast v11, Ljava/lang/String;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$1 Ljava/lang/Object;
    check-cast v12, Ljava/lang/String;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$0 Ljava/lang/Object;
    check-cast v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v5, v9
    move-object v14, v10
    move-object v15, v13
    move-object v13, v11
    goto +5eh
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v4, "conversationId"
    move-object/from16 v9, v21
    invoke-virtual v0, v4, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "messageId"
    move-object/from16 v10, v22
    invoke-virtual v0, v4, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "path"
    move-object/from16 v11, v20
    invoke-virtual v0, v4, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto +dh
    move-object/from16 v11, v20
    goto +ah
    move-object/from16 v11, v20
    goto +5h
    move-object/from16 v11, v20
    move-object/from16 v9, v21
    move-object/from16 v10, v22
    move-object v12, v2
    const/4 v4, 0
    const/16 v13, 21
    if-ge v4, v13, +144h
    sget-object v13, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;->Companion Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;
    new-instance v14, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;
    invoke-static v11, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v15
    invoke-static v7, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v5
    invoke-direct v14, v15, v9, v10, v5, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean;)V
    iput-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$0 Ljava/lang/Object;
    iput-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$1 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$2 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$3 Ljava/lang/Object;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$4 Ljava/lang/Object;
    iput v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->I$0 I
    iput v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->label I
    invoke-virtual v13, v14, v1, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->getDownloadUrlRawCall(Lcom/bytedance/trae/im/service/GetDownloadUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v3, +003h
    return-object v3
    move-object v13, v9
    move-object v14, v10
    move-object v15, v12
    move-object v12, v11
    move-object/from16 v18, v5
    move-object v5, v0
    move-object/from16 v0, v18
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v9, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v9, +0d3h
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/im/service/GetDownloadUrlData;
    if-eqz v9, +010h
    invoke-virtual v9, Lcom/bytedance/trae/im/service/GetDownloadUrlData;->getUrlMap()Ljava/util/Map;
    move-result-object v9
    if-eqz v9, +00ah
    invoke-interface v9, v12, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/String;
    move-object v11, v9
    goto +2h
    move-object v11, v8
    if-eqz v11, +03bh
    move-object v0, v11
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    move v0, v7
    goto +2h
    const/4 v0, 0
    if-eqz v0, +016h
    const-string v10, "fetch_file_url"
    const-string v11, "local"
    const-string v12, "failed"
    const-string/jumbo v13, url_is_null
    move-object v9, v15
    move-object v14, v5
    invoke-virtual/range v9 ... v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    invoke-direct v0, v8, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;-><init>(Ljava/lang/String; Z)V
    return-object v0
    const-string v10, "fetch_file_url"
    const-string v0, "local"
    const-string/jumbo v12, success
    const-string v13, ""
    move-object v9, v15
    move-object v1, v11
    move-object v11, v0
    move-object v14, v5
    invoke-virtual/range v9 ... v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    const/4 v3, 0
    invoke-direct v0, v1, v3, v6, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;-><init>(Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    const-wide/16 v16, 202
    cmp-long v0, v9, v16
    if-nez v0, +046h
    const-string v10, "fetch_file_url"
    const-string v11, "local"
    const-string v0, "failed"
    const-string v16, "202"
    move-object v9, v15
    move-object v8, v12
    move-object v12, v0
    move-object v0, v13
    move-object/from16 v13, v16
    move-object v7, v14
    move-object v14, v5
    invoke-virtual/range v9 ... v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    const/16 v9, 20
    if-ge v4, v9, +024h
    iput-object v15, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$0 Ljava/lang/Object;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$1 Ljava/lang/Object;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$2 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$3 Ljava/lang/Object;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->L$4 Ljava/lang/Object;
    iput v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->I$0 I
    iput v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchLocalFileUrl$1;->label I
    const-wide/16 v9, 2000
    invoke-static v9, v10, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v3, +003h
    return-object v3
    move-object v11, v0
    move-object v9, v5
    move-object v10, v7
    move-object v12, v8
    move-object v13, v15
    move-object v0, v9
    move-object v9, v11
    move-object v11, v12
    move-object v12, v13
    const/4 v5, 1
    goto +7h
    move-object v9, v0
    move-object v0, v5
    move-object v10, v7
    move-object v11, v8
    move-object v12, v15
    goto -7h
    add-int/2addr v4, v5
    move v7, v5
    const/4 v8, 0
    goto/16 -0dfh
    const-string v0, "fetch_file_url"
    const-string v11, "local"
    const-string v12, "failed"
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ""
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    move-object v9, v15
    move-object v10, v0
    move-object v14, v5
    invoke-virtual/range v9 ... v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    const/4 v1, 1
    const/4 v3, 0
    invoke-direct v0, v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;-><init>(Ljava/lang/String; Z)V
    return-object v0
    instance-of v1, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v1, +036h
    const-string v10, "fetch_file_url"
    const-string v11, "local"
    const-string v12, "failed"
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v3, 95
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    move-object v9, v15
    move-object v14, v5
    invoke-virtual/range v9 ... v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    const/4 v1, 0
    const/4 v3, 0
    invoke-direct v0, v3, v1, v6, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;-><init>(Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    const-string v13, "fetch_file_url"
    const-string v14, "local"
    const-string v15, "failed"
    const-string/jumbo v16, uploading
    move-object/from16 v17, v0
    invoke-virtual/range v12 ... v17, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    const/4 v1, 0
    const/4 v3, 0
    invoke-direct v0, v3, v1, v6, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;-><init>(Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    :try_start_0x79
    :try_start_0x7d
    :try_start_0x84
    :try_start_0x8b
.end method

.method private final fetchRemoteFileUrl(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 15
    # ins_size=4
    instance-of v0, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchRemoteFileUrl$1;
    if-eqz v0, +012h
    move-object v0, v14
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchRemoteFileUrl$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchRemoteFileUrl$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v14, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchRemoteFileUrl$1;->label I
    sub-int/2addr v14, v2
    iput v14, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchRemoteFileUrl$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchRemoteFileUrl$1;
    invoke-direct v0, v11, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchRemoteFileUrl$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper; Lkotlin/coroutines/Continuation;)V
    iget-object v14, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchRemoteFileUrl$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchRemoteFileUrl$1;->label I
    const/4 v3, 1
    if-eqz v2, +01dh
    if-ne v2, v3, +013h
    iget-object v12, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchRemoteFileUrl$1;->L$2 Ljava/lang/Object;
    move-object v13, v12
    check-cast v13, Ljava/lang/String;
    iget-object v12, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchRemoteFileUrl$1;->L$1 Ljava/lang/Object;
    check-cast v12, Ljava/lang/String;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchRemoteFileUrl$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1eh
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v13, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v13, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v14, Lcom/bytedance/trae/im/service/IChatSessionApi;->Companion Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchRemoteFileUrl$1;->L$0 Ljava/lang/Object;
    iput-object v12, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchRemoteFileUrl$1;->L$1 Ljava/lang/Object;
    iput-object v13, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchRemoteFileUrl$1;->L$2 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchRemoteFileUrl$1;->label I
    invoke-virtual v14, v12, v0, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->getChatSessionRawCall(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v1, +003h
    return-object v1
    move-object v0, v11
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    new-instance v9, Lorg/json/JSONObject;
    invoke-direct v9, Lorg/json/JSONObject;-><init>()V
    const-string v1, "chatSessionId"
    invoke-virtual v9, v1, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v12, "path"
    invoke-virtual v9, v12, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    instance-of v12, v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v1, 2
    const/4 v2, 0
    const/4 v10, 0
    if-eqz v12, +065h
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    if-eqz v12, +007h
    invoke-virtual v12, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getExplorerUrl()Ljava/lang/String;
    move-result-object v12
    goto +2h
    move-object v12, v10
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v14
    invoke-virtual v14, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v14
    check-cast v14, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    if-eqz v14, +007h
    invoke-virtual v14, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getWorkspacePath()Ljava/lang/String;
    move-result-object v14
    goto +2h
    move-object v14, v10
    move-object v4, v12
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00ah
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +2h
    move v3, v2
    if-eqz v3, +015h
    const-string v5, "fetch_file_url"
    const-string v6, "remote"
    const-string v7, "failed"
    const-string/jumbo v8, url_null
    move-object v4, v0
    invoke-virtual/range v4 ... v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    new-instance v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    invoke-direct v12, v10, v2, v1, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;-><init>(Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +50h
    const-string v5, "fetch_file_url"
    const-string v6, "remote"
    const-string/jumbo v7, success
    const/4 v8, 0
    move-object v4, v0
    invoke-virtual/range v4 ... v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-direct v0, v13, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->normalizeFilePath(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    invoke-direct v0, v12, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->buildFileUrl(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    new-instance v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    invoke-direct v13, v12, v2, v1, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;-><init>(Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v12, v13
    goto +35h
    instance-of v12, v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v12, +033h
    const-string v5, "fetch_file_url"
    const-string v6, "remote"
    const-string v7, "failed"
    new-instance v12, Ljava/lang/StringBuilder;
    invoke-direct v12, Ljava/lang/StringBuilder;-><init>()V
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v13
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v12
    const/16 v13, 95
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    move-object v4, v0
    invoke-virtual/range v4 ... v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    new-instance v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    invoke-direct v12, v10, v2, v1, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;-><init>(Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v12
    new-instance v12, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v12, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v12
    :try_start_0x5b
.end method

.method private final normalizeFilePath(java.lang.String  java.lang.String)java.lang.String
    .registers 11
    # ins_size=3
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v2
    goto +2h
    move v0, v1
    const-string/jumbo v3, substring(...)
    const/4 v4, 0
    const-string v5, "/"
    const/4 v6, 2
    if-nez v0, +059h
    invoke-static v10, v5, v2, v6, v4, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +004h
    move-object v0, v10
    goto +14h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v7, 47
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v10, v5, v2, v6, v4, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +006h
    invoke-static v10, v1, Lkotlin/text/StringsKt;->dropLast(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v10
    new-array v7, v6, [Ljava/lang/String;
    aput-object v0, v7, v2
    aput-object v10, v7, v1
    invoke-static v7, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v10
    invoke-interface v10, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +020h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    invoke-static v9, v0, v2, v6, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, -010h
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v10
    invoke-virtual v9, v10, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v9, v5, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v9
    return-object v9
    invoke-static v9, v5, v2, v6, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v10
    if-eqz v10, +009h
    invoke-virtual v9, v1, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v9
.end method

.method static synthetic normalizeFilePath$default(com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper  java.lang.String  java.lang.String  int  java.lang.Object)java.lang.String
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->normalizeFilePath(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final readAllBytes(java.io.InputStream)byte[]
    .registers 7
    # ins_size=2
    check-cast v6, Ljava/io/Closeable;
    move-object v0, v6
    check-cast v0, Ljava/io/InputStream;
    new-instance v1, Ljava/io/ByteArrayOutputStream;
    invoke-direct v1, Ljava/io/ByteArrayOutputStream;-><init>()V
    const/16 v2, 8192
    new-array v2, v2, [B
    invoke-virtual v0, v2, Ljava/io/InputStream;->read([B)I
    move-result v3
    if-lez v3, +007h
    const/4 v4, 0
    invoke-virtual v1, v2, v4, v3, Ljava/io/ByteArrayOutputStream;->write([B I I)V
    goto -ah
    invoke-virtual v1, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    move-result-object v0
    const-string/jumbo v1, toByteArray(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 0
    invoke-static v6, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v0
    move-exception v0
    throw v0
    move-exception v1
    invoke-static v6, v0, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v1
    :try_start_0x2
    :try_start_0x29
.end method

.method public static synthetic reportApm$default(com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper  java.lang.String  java.lang.String  java.lang.String  java.lang.String  org.json.JSONObject  int  java.lang.Object)void
    .registers 15
    # ins_size=8
    and-int/lit8 v14, v13, 8
    const/4 v0, 0
    if-eqz v14, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v11
    and-int/lit8 v11, v13, 16
    if-eqz v11, +004h
    move-object v6, v0
    goto +2h
    move-object v6, v12
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final fetchFileUrl(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 16
    # ins_size=7
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;
    const/4 v7, 0
    move-object v1, v8
    move-object v2, v11
    move-object v3, v10
    move-object v4, v12
    move-object v5, v14
    move-object v6, v13
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v8, v15, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    return-object v10
.end method

.method public final fetchTextContent(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=4
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;
    const/4 v2, 0
    invoke-direct v1, v5, v4, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v6, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    return-object v4
.end method

.method public final reportApm(java.lang.String  java.lang.String  java.lang.String  java.lang.String  org.json.JSONObject)void
    .registers 12
    # ins_size=6
    const-string/jumbo v0, step
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, type
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, status
    invoke-static v9, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v3, v6
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    sget-object v3, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string v4, "im_artifact_preview"
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v5, v0, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v5, v1, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v5, v2, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v10, +007h
    const-string v7, "reason"
    invoke-virtual v5, v7, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v7, 0
    invoke-virtual v3, v4, v5, v7, v11, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v7
    sget-object v8, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v7, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x12
.end method
