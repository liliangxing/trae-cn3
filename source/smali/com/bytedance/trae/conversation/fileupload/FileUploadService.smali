# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
.super Ljava/lang/Object;
.source "FileUploadService.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/fileupload/FileUploadService$Companion;
.field public static final LOG_CHUNK_SIZE:I
.field public static final TAG:Ljava/lang/String;
.field private final api:Lcom/bytedance/trae/conversation/fileupload/ResourceUploadApi;


.method public static synthetic $r8$lambda$6rg3R00012QdL5bZndm6Gwv_AnQ(com.bytedance.retrofit2.client.Header)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->formatRetrofitHeaders$lambda$4(Lcom/bytedance/retrofit2/client/Header;)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$aPgPL8SHAOYGpGAh4D5i-PQsOdg(com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->createObjectStoreApi$lambda$0(Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->Companion Lcom/bytedance/trae/conversation/fileupload/FileUploadService$Companion;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.fileupload.ResourceUploadApi)void
    .registers 3
    # ins_size=2
    const-string v0, "api"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->api Lcom/bytedance/trae/conversation/fileupload/ResourceUploadApi;
    return-void 
.end method

.method public static final synthetic access$buildUploadUrl(com.bytedance.trae.conversation.fileupload.FileUploadService  java.lang.String  java.lang.String)java.lang.String
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->buildUploadUrl(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$createObjectStoreApi(com.bytedance.trae.conversation.fileupload.FileUploadService)com.bytedance.trae.conversation.fileupload.FileUploadService$IObjectStoreApi
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->createObjectStoreApi()Lcom/bytedance/trae/conversation/fileupload/FileUploadService$IObjectStoreApi;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$formatRetrofitHeaders(com.bytedance.trae.conversation.fileupload.FileUploadService  java.util.List)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->formatRetrofitHeaders(Ljava/util/List;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getApi$p(com.bytedance.trae.conversation.fileupload.FileUploadService)com.bytedance.trae.conversation.fileupload.ResourceUploadApi
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->api Lcom/bytedance/trae/conversation/fileupload/ResourceUploadApi;
    return-object v0
.end method

.method public static final synthetic access$logPutFailureResponse(com.bytedance.trae.conversation.fileupload.FileUploadService  com.bytedance.trae.conversation.fileupload.BizType  com.bytedance.trae.conversation.fileupload.FileUploadService$ObjectStorePutResult)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->logPutFailureResponse(Lcom/bytedance/trae/conversation/fileupload/BizType; Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;)V
    return-void 
.end method

.method public static final synthetic access$readAllBytes(com.bytedance.trae.conversation.fileupload.FileUploadService  java.io.InputStream)byte[]
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->readAllBytes(Ljava/io/InputStream;)[B
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$shouldUseTobObjectStorePutCompat(com.bytedance.trae.conversation.fileupload.FileUploadService)boolean
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->shouldUseTobObjectStorePutCompat()Z
    move-result v0
    return v0
.end method

.method private final buildUploadUrl(java.lang.String  java.lang.String)java.lang.String
    .registers 8
    # ins_size=3
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v6
    const/4 v0, 1
    new-array v1, v0, [C
    const/4 v2, 0
    const/16 v3, 47
    aput-char v3, v1, v2
    invoke-static v6, v1, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v6
    new-array v0, v0, [C
    aput-char v3, v0, v2
    invoke-static v7, v0, Lkotlin/text/StringsKt;->trimStart(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v7
    const-string v0, "http://"
    const/4 v1, 2
    const/4 v4, 0
    invoke-static v6, v0, v2, v1, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +021h
    const-string v0, "https://"
    invoke-static v6, v0, v2, v1, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +17h
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    goto +16h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    return-object v6
.end method

.method private final createObjectStoreApi()com.bytedance.trae.conversation.fileupload.FileUploadService$IObjectStoreApi
    .registers 4
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    const/4 v1, 0
    const-string v2, "https://placeholder.trae/"
    invoke-static v2, v0, v1, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsRetrofit(Ljava/lang/String; Ljava/util/List; Lcom/bytedance/retrofit2/Converter$Factory;)Lcom/bytedance/retrofit2/Retrofit;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$IObjectStoreApi;
    invoke-virtual v0, v1, Lcom/bytedance/retrofit2/Retrofit;->create(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    const-string v1, "create(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$IObjectStoreApi;
    return-object v0
.end method

.method private static final createObjectStoreApi$lambda$0(com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 6
    # ins_size=1
    invoke-interface v5, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->request()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->getHeaders()Ljava/util/List;
    move-result-object v1
    const-string v2, "getHeaders(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Ljava/util/Collection;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v1
    new-instance v2, Lcom/bytedance/retrofit2/client/Header;
    const-string/jumbo v3, x-ttnet-req-biz-id
    const-string v4, "conversation_file_upload_object_store"
    invoke-direct v2, v3, v4, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->newBuilder()Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v0
    invoke-virtual v0, v1, Lcom/bytedance/retrofit2/client/Request$Builder;->headers(Ljava/util/List;)Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v0
    const-string v1, "headers(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request$Builder;->build()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    invoke-interface v5, v0, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->proceed(Lcom/bytedance/retrofit2/client/Request;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v5
    return-object v5
.end method

.method public static synthetic downloadSingleFile$default(com.bytedance.trae.conversation.fileupload.FileUploadService  java.lang.String  com.bytedance.trae.conversation.fileupload.BizType  boolean  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    sget-object v2, Lcom/bytedance/trae/conversation/fileupload/BizType;->RemoteResource Lcom/bytedance/trae/conversation/fileupload/BizType;
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->downloadSingleFile(Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/BizType; Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final formatRetrofitHeaders(java.util.List)java.lang.String
    .registers 11
    # ins_size=2
    invoke-interface v10, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +005h
    const-string v10, ""
    return-object v10
    move-object v0, v10
    check-cast v0, Ljava/lang/Iterable;
    const-string v10, "
"
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    new-instance v6, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$$ExternalSyntheticLambda1;
    invoke-direct v6, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$$ExternalSyntheticLambda1;-><init>()V
    const/16 v7, 30
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    return-object v10
.end method

.method private static final formatRetrofitHeaders$lambda$4(com.bytedance.retrofit2.client.Header)java.lang.CharSequence
    .registers 3
    # ins_size=1
    const-string v0, "header"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, Lcom/bytedance/retrofit2/client/Header;->getName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ": "
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v2, Lcom/bytedance/retrofit2/client/Header;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    return-object v2
.end method

.method private final logLongWarn(java.lang.String)void
    .registers 10
    # ins_size=2
    invoke-virtual v9, Ljava/lang/String;->length()I
    move-result v0
    const-string v1, "FileUploadService"
    const/16 v2, 3000
    if-gt v0, v2, +00bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-virtual v0, v1, v9, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v1, v9, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
    invoke-virtual v9, Ljava/lang/String;->length()I
    move-result v0
    add-int/2addr v0, v2
    const/4 v3, 1
    sub-int/2addr v0, v3
    div-int/2addr v0, v2
    const/4 v2, 0
    move v4, v3
    invoke-virtual v9, Ljava/lang/String;->length()I
    move-result v5
    if-ge v2, v5, +044h
    add-int/lit16 v5, v2, 3000
    invoke-virtual v9, Ljava/lang/String;->length()I
    move-result v6
    invoke-static v5, v6, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v5
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "["
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    const/16 v7, 47
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, "] "
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v9, v2, v5, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v7, substring(...)
    invoke-static v2, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-virtual v6, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v1, v2, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String;)I
    add-int/2addr v4, v3
    move v2, v5
    goto -47h
    return-void 
.end method

.method private final logPutFailureResponse(com.bytedance.trae.conversation.fileupload.BizType  com.bytedance.trae.conversation.fileupload.FileUploadService$ObjectStorePutResult)void
    .registers 6
    # ins_size=3
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, uploadSingleFile put failed response: bizType=
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    const-string v4, ", code="
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->getCode()I
    move-result v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    const-string v4, ", message="
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->getMessage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v4, "
headers:
"
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->getHeadersText()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    const-string v2, "<empty>"
    if-eqz v1, +003h
    move-object v4, v2
    check-cast v4, Ljava/lang/String;
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v4, "
body:
"
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->getErrorText()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v2, v4
    check-cast v2, Ljava/lang/String;
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->logLongWarn(Ljava/lang/String;)V
    return-void 
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

.method private final shouldUseTobObjectStorePutCompat()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/LoginUtils;->isEnterpriseLogin()Z
    move-result v0
    return v0
.end method

.method public static synthetic uploadSingleFile$default(com.bytedance.trae.conversation.fileupload.FileUploadService  java.io.File  java.lang.String  com.bytedance.trae.conversation.fileupload.BizType  java.lang.String  java.lang.String  com.bytedance.trae.conversation.fileupload.FileUploadService$UploadOptions  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 24
    # ins_size=10
    and-int/lit8 v0, v22, 4
    if-eqz v0, +006h
    sget-object v0, Lcom/bytedance/trae/conversation/fileupload/BizType;->RemoteResource Lcom/bytedance/trae/conversation/fileupload/BizType;
    move-object v4, v0
    goto +3h
    move-object/from16 v4, v17
    and-int/lit8 v0, v22, 8
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v5, v1
    goto +3h
    move-object/from16 v5, v18
    and-int/lit8 v0, v22, 16
    if-eqz v0, +004h
    move-object v6, v1
    goto +3h
    move-object/from16 v6, v19
    and-int/lit8 v0, v22, 32
    if-eqz v0, +010h
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 15
    const/4 v13, 0
    move-object v7, v0
    invoke-direct/range v7 ... v13, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;-><init>(Z Z Lkotlin/jvm/functions/Function3; Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +3h
    move-object/from16 v7, v20
    move-object v1, v14
    move-object v2, v15
    move-object/from16 v3, v16
    move-object/from16 v8, v21
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->uploadSingleFile(Ljava/io/File; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/BizType; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final downloadSingleFile(java.lang.String  com.bytedance.trae.conversation.fileupload.BizType  boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 13
    # ins_size=5
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v7, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    move v5, v11
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;-><init>(Lcom/bytedance/trae/conversation/fileupload/FileUploadService; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/BizType; Z Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v7, v12, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    return-object v9
.end method

.method public final uploadSingleFile(java.io.File  java.lang.String  com.bytedance.trae.conversation.fileupload.BizType  java.lang.String  java.lang.String  com.bytedance.trae.conversation.fileupload.FileUploadService$UploadOptions  kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=8
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v10, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;
    const/4 v9, 0
    move-object v1, v10
    move-object/from16 v2, v17
    move-object v3, v15
    move-object v4, v14
    move-object v5, v13
    move-object/from16 v6, v16
    move-object v7, v11
    move-object v8, v12
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;-><init>(Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/BizType; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/FileUploadService; Ljava/io/File; Lkotlin/coroutines/Continuation;)V
    check-cast v10, Lkotlin/jvm/functions/Function2;
    move-object/from16 v1, v18
    invoke-static v0, v10, v1, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method
