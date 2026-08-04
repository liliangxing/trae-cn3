# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;
.super Ljava/lang/Object;
.source "BrainstormAttachmentManager.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$Companion;
.field public static final TAG:Ljava/lang/String;
.field private final application:Landroid/app/Application;
.field private final fileUploadService$delegate:Lkotlin/Lazy;
.field private final imageUploadServiceDelegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$-qCheQnEuj7GT-BfytaVXB0fLgE()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->fileUploadService_delegate$lambda$3$lambda$2()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$GyT9i6U4vr4TXTyyicTmBSokEXI(kotlin.jvm.functions.Function1  int  long  long)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->uploadFile$lambda$9(Lkotlin/jvm/functions/Function1; I J J)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$IsWt9X9C-vphOwdHz_FbobBRnPA()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->imageUploadServiceDelegate$lambda$1$lambda$0()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$qbFaEFs4nBPXrMiL8CSe9fcdaqw()com.bytedance.trae.conversation.imageupload.ImageUploadService
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->imageUploadServiceDelegate$lambda$1()Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$rZT0K4xTt215w2AjQV8Tl2_99MA(kotlin.jvm.functions.Function1  int  long  long)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->uploadImage$lambda$8(Lkotlin/jvm/functions/Function1; I J J)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$zaEygWgKEZinKnqu1hxSuEwIaaQ()com.bytedance.trae.conversation.fileupload.FileUploadService
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->fileUploadService_delegate$lambda$3()Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$Companion;
    return-void 
.end method

.method public constructor <init>(android.app.Application)void
    .registers 3
    # ins_size=2
    const-string v0, "application"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->application Landroid/app/Application;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$$ExternalSyntheticLambda1;
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v2, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->imageUploadServiceDelegate Lkotlin/Lazy;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$$ExternalSyntheticLambda2;
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$$ExternalSyntheticLambda2;-><init>()V
    invoke-static v2, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->fileUploadService$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private static final fileUploadService_delegate$lambda$3()com.bytedance.trae.conversation.fileupload.FileUploadService
    .registers 8
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    new-instance v7, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$$ExternalSyntheticLambda4;
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$$ExternalSyntheticLambda4;-><init>()V
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v1, v7
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v7, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadApi;
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;-><init>(Lcom/bytedance/trae/conversation/fileupload/ResourceUploadApi;)V
    return-object v0
.end method

.method private static final fileUploadService_delegate$lambda$3$lambda$2()java.lang.String
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final getFileUploadService()com.bytedance.trae.conversation.fileupload.FileUploadService
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->fileUploadService$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    return-object v0
.end method

.method private final getImageUploadService()com.bytedance.trae.conversation.imageupload.ImageUploadService
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->imageUploadServiceDelegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    return-object v0
.end method

.method private static getImageUploadService$delegate(com.bytedance.trae.conversation.brainstorm.BrainstormAttachmentManager)java.lang.Object
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->imageUploadServiceDelegate Lkotlin/Lazy;
    return-object v0
.end method

.method private static final imageUploadServiceDelegate$lambda$1()com.bytedance.trae.conversation.imageupload.ImageUploadService
    .registers 21
    # ins_size=0
    new-instance v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    new-instance v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v9
    sget-object v2, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v3, Lcom/bytedance/trae/network/HostType;->IMAGEX Lcom/bytedance/trae/network/HostType;
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostResolver;->getHost(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v10
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 12
    const/4 v14, 0
    move-object v8, v0
    invoke-direct/range v8 ... v14, Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;-><init>(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    new-instance v2, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    new-instance v16, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$$ExternalSyntheticLambda0;
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$$ExternalSyntheticLambda0;-><init>()V
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 6
    const/16 v20, 0
    move-object v15, v2
    invoke-direct/range v15 ... v20, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v10, v2
    check-cast v10, Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$imageUploadServiceDelegate$1$2;
    const/4 v3, 0
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$imageUploadServiceDelegate$1$2;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v11, v2
    check-cast v11, Lkotlin/jvm/functions/Function1;
    const/4 v13, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 248
    move-object v8, v1
    move-object v9, v0
    invoke-direct/range v8 ... v18, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;-><init>(Lcom/bytedance/trae/conversation/imageupload/UploaderConfig; Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Z Lkotlin/jvm/functions/Function2; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v2, 0
    const/4 v4, 0
    const/16 v5, 14
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig; Lcom/bytedance/trae/conversation/imageupload/StsTokenManager; Lcom/bytedance/trae/conversation/imageupload/ImageXUploader; Lcom/bytedance/trae/conversation/imageupload/ImageCompressor; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v7
.end method

.method private static final imageUploadServiceDelegate$lambda$1$lambda$0()java.lang.String
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final isEnterpriseLogin()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/LoginUtils;->isEnterpriseLogin()Z
    move-result v0
    return v0
.end method

.method private static final uploadFile$lambda$9(kotlin.jvm.functions.Function1  int  long  long)kotlin.Unit
    .registers 6
    # ins_size=6
    const/4 v2, 0
    const/16 v3, 99
    invoke-static v1, v2, v3, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final uploadImage$lambda$8(kotlin.jvm.functions.Function1  int  long  long)kotlin.Unit
    .registers 6
    # ins_size=6
    const/4 v2, 0
    const/16 v3, 99
    invoke-static v1, v2, v3, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final release()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->imageUploadServiceDelegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->isInitialized()Z
    move-result v0
    if-eqz v0, +01eh
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->getImageUploadService()Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->close()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x8
.end method

.method public final uploadFile(java.io.File  android.net.Uri  java.lang.String  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 27
    # ins_size=6
    move-object/from16 v0, v26
    instance-of v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadFile$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadFile$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadFile$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadFile$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadFile$1;->label I
    move-object/from16 v2, v21
    goto +8h
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadFile$1;
    move-object/from16 v2, v21
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadFile$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager; Lkotlin/coroutines/Continuation;)V
    move-object v10, v1
    iget-object v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadFile$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v3, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadFile$1;->label I
    const/4 v13, 0
    const/4 v4, 1
    if-eqz v3, +017h
    if-ne v3, v4, +00dh
    iget-object v1, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadFile$1;->L$0 Ljava/lang/Object;
    check-cast v1, Landroid/net/Uri;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v3, v0
    move-object v0, v1
    goto/16 +06fh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, ".trae"
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-direct/range v21, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->getFileUploadService()Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    move-result-object v3
    const/4 v6, 0
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v7, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v7, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00eh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    move-object v8, v0
    goto +2h
    move-object v8, v13
    new-instance v9, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
    const/4 v15, 1
    const/16 v16, 1
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$$ExternalSyntheticLambda3;
    move-object/from16 v7, v25
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$$ExternalSyntheticLambda3;-><init>(Lkotlin/jvm/functions/Function1;)V
    const/16 v18, 0
    const/16 v19, 8
    const/16 v20, 0
    move-object v14, v9
    move-object/from16 v17, v0
    invoke-direct/range v14 ... v20, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;-><init>(Z Z Lkotlin/jvm/functions/Function3; Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v11, 4
    const/4 v12, 0
    move-object/from16 v0, v23
    iput-object v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadFile$1;->L$0 Ljava/lang/Object;
    iput v4, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadFile$1;->label I
    move-object/from16 v4, v22
    move-object/from16 v7, v24
    invoke-static/range v3 ... v12, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->uploadSingleFile$default(Lcom/bytedance/trae/conversation/fileupload/FileUploadService; Ljava/io/File; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/BizType; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v1, +003h
    return-object v1
    check-cast v3, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getSuccess()Z
    move-result v1
    if-eqz v1, +027h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getOid()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +19h
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getOid()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v5, toString(...)
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v4, v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->put(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getOid()Ljava/lang/String;
    move-result-object v0
    return-object v0
    return-object v13
.end method

.method public final uploadImage(java.io.File  android.net.Uri  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 25
    # ins_size=5
    move-object/from16 v0, v22
    move-object/from16 v1, v24
    instance-of v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadImage$1;
    if-eqz v2, +014h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadImage$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadImage$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +00ah
    iget v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadImage$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadImage$1;->label I
    move-object/from16 v3, v20
    goto +8h
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadImage$1;
    move-object/from16 v3, v20
    invoke-direct v2, v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadImage$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager; Lkotlin/coroutines/Continuation;)V
    move-object v11, v2
    iget-object v1, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadImage$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v4, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadImage$1;->label I
    const-string/jumbo v12, toString(...)
    const/4 v5, 2
    const/4 v6, 1
    if-eqz v4, +020h
    if-eq v4, v6, +015h
    if-ne v4, v5, +00bh
    iget-object v0, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadImage$1;->L$0 Ljava/lang/Object;
    check-cast v0, Landroid/net/Uri;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +16fh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v0, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadImage$1;->L$0 Ljava/lang/Object;
    check-cast v0, Landroid/net/Uri;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +09ch
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-direct/range v20, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->isEnterpriseLogin()Z
    move-result v1
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string/jumbo v8, uploadImage: isEnterpriseLogin=
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v9, ", sourceUri="
    invoke-virtual v7, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v10, ", fileName="
    invoke-virtual v7, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual/range v21, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v7, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v13, ", fileSize="
    invoke-virtual v7, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual/range v21, Ljava/io/File;->length()J
    move-result-wide v14
    invoke-virtual v7, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v14, "BrainstormAttachmentManager"
    invoke-virtual v4, v14, v7, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v21, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v21, Ljava/io/File;->length()J
    move-result-wide v7
    invoke-virtual v4, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v14, v4, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    if-nez v1, +03dh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v4, uploadImage branch=ImageX
    invoke-virtual v1, v14, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v14, v4, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    invoke-direct/range v20, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->getImageUploadService()Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    move-result-object v4
    const-wide/16 v7, 0
    const/4 v10, 4
    const/4 v1, 0
    iput-object v0, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadImage$1;->L$0 Ljava/lang/Object;
    iput v6, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadImage$1;->label I
    move-object/from16 v5, v21
    move-object/from16 v6, v23
    move-object v9, v11
    move-object v11, v1
    invoke-static/range v4 ... v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->uploadImage$default(Lcom/bytedance/trae/conversation/imageupload/ImageUploadService; Ljava/io/File; Lkotlin/jvm/functions/Function1; J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v2, +003h
    return-object v2
    check-cast v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadResult;
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadResult;->getTosUri()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v4, v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->put(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadResult;->getTosUri()Ljava/lang/String;
    move-result-object v0
    return-object v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v4, uploadImage branch=ToBImagePresigned
    invoke-virtual v1, v14, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v14, v4, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ImageValidation;
    move-object/from16 v6, v21
    invoke-virtual v1, v6, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;->validateFile(Ljava/io/File;)Lkotlin/Pair;
    move-result-object v1
    invoke-virtual v1, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->getValid()Z
    move-result v4
    if-nez v4, +021h
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->getErrorCode()Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    move-result-object v2
    if-nez v2, +004h
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->UNKNOWN Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    move-object v14, v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->getErrorMessage()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, "Invalid file"
    move-object v15, v1
    const/16 v16, 0
    const/16 v17, 4
    const/16 v18, 0
    move-object v13, v0
    invoke-direct/range v13 ... v18, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v4, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v1, v4, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v1, +00eh
    invoke-interface v1, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v1
    if-eqz v1, +008h
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, ""
    move-object v9, v1
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ".trae"
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct/range v20, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->getFileUploadService()Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    move-result-object v4
    sget-object v7, Lcom/bytedance/trae/conversation/fileupload/BizType;->Image Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-static Landroid/webkit/MimeTypeMap;->getSingleton()Landroid/webkit/MimeTypeMap;
    move-result-object v8
    invoke-static/range v21, Lkotlin/io/FilesKt;->getExtension(Ljava/io/File;)Ljava/lang/String;
    move-result-object v10
    invoke-virtual v8, v10, Landroid/webkit/MimeTypeMap;->getMimeTypeFromExtension(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    new-instance v10, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
    const/4 v14, 0
    const/4 v15, 0
    new-instance v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$$ExternalSyntheticLambda5;
    move-object/from16 v5, v23
    invoke-direct v13, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$$ExternalSyntheticLambda5;-><init>(Lkotlin/jvm/functions/Function1;)V
    const/16 v17, 0
    const/16 v18, 11
    const/16 v19, 0
    move-object v5, v13
    move-object v13, v10
    move-object/from16 v16, v5
    invoke-direct/range v13 ... v19, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;-><init>(Z Z Lkotlin/jvm/functions/Function3; Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v0, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadImage$1;->L$0 Ljava/lang/Object;
    const/4 v5, 2
    iput v5, v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$uploadImage$1;->label I
    move-object/from16 v5, v21
    move-object v6, v1
    invoke-virtual/range v4 ... v11, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->uploadSingleFile(Ljava/io/File; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/BizType; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v2, +003h
    return-object v2
    check-cast v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getSuccess()Z
    move-result v2
    if-eqz v2, +024h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getOid()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +16h
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getOid()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v4, v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->put(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getOid()Ljava/lang/String;
    move-result-object v0
    return-object v0
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    sget-object v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->UPLOAD_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getError()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, "Upload failed"
    move-object v6, v1
    const/4 v7, 0
    const/4 v8, 4
    const/4 v9, 0
    move-object v4, v0
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
.end method

.method public final uriToFile(android.net.Uri  java.lang.String)java.io.File
    .registers 9
    # ins_size=3
    const-string v0, "brainstorm_attach_"
    const-string/jumbo v1, uri
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 0
    iget-object v2, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->application Landroid/app/Application;
    invoke-virtual v2, Landroid/app/Application;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v2
    const-string v3, "getContentResolver(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v8, +00bh
    invoke-static Landroid/webkit/MimeTypeMap;->getSingleton()Landroid/webkit/MimeTypeMap;
    move-result-object v3
    invoke-virtual v3, v8, Landroid/webkit/MimeTypeMap;->getExtensionFromMimeType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v1
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    invoke-virtual v3, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v3, 46
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    if-nez v8, +004h
    const-string v8, "bin"
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    new-instance v0, Ljava/io/File;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->application Landroid/app/Application;
    invoke-virtual v3, Landroid/app/Application;->getCacheDir()Ljava/io/File;
    move-result-object v3
    invoke-direct v0, v3, v8, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v2, v7, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;
    move-result-object v7
    if-nez v7, +009h
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;
    invoke-virtual v0, Ljava/io/File;->delete()Z
    return-object v1
    check-cast v7, Ljava/io/Closeable;
    move-object v8, v7
    check-cast v8, Ljava/io/InputStream;
    new-instance v2, Ljava/io/FileOutputStream;
    invoke-direct v2, v0, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    check-cast v2, Ljava/io/Closeable;
    move-object v3, v2
    check-cast v3, Ljava/io/FileOutputStream;
    check-cast v3, Ljava/io/OutputStream;
    const/4 v4, 0
    const/4 v5, 2
    invoke-static v8, v3, v4, v5, v1, Lkotlin/io/ByteStreamsKt;->copyTo$default(Ljava/io/InputStream; Ljava/io/OutputStream; I I Ljava/lang/Object;)J
    invoke-static v2, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    invoke-static v7, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    move-object v1, v0
    goto +18h
    move-exception v8
    throw v8
    move-exception v3
    invoke-static v2, v8, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v3
    move-exception v8
    throw v8
    move-exception v2
    invoke-static v7, v8, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v2
    move-object v0, v1
    move-object v7, v0
    check-cast v7, Ljava/io/File;
    if-eqz v0, +005h
    invoke-virtual v0, Ljava/io/File;->delete()Z
    return-object v1
    :try_start_0x9
    :try_start_0x4a
    :try_start_0x59
    :try_start_0x63
    :try_start_0x6d
    :try_start_0x70
    :try_start_0x76
    :try_start_0x78
    :try_start_0x7d
    :try_start_0x7f
.end method
