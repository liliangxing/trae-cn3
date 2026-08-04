# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
.super Landroidx/lifecycle/AndroidViewModel;
.source "InputAttachmentListModel.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$Companion;
.field private static final FAKE_PROGRESS_INCREMENT:I
.field private static final FAKE_PROGRESS_INTERVAL_MS:J
.field private static final FAKE_PROGRESS_MAX:I
.field private final TAG:Ljava/lang/String;
.field private final _attachmentList:Ljava/util/List;
.field private final _attachments:Landroidx/lifecycle/MutableLiveData;
.field private final _fileTooLarge:Landroidx/lifecycle/MutableLiveData;
.field private final _totalSizeTooLarge:Landroidx/lifecycle/MutableLiveData;
.field private final _uploadError:Landroidx/lifecycle/MutableLiveData;
.field private final attachmentLock:Ljava/lang/Object;
.field private final attachments:Landroidx/lifecycle/LiveData;
.field private final fakeProgressJobs:Ljava/util/concurrent/ConcurrentHashMap;
.field private final fileTooLarge:Landroidx/lifecycle/LiveData;
.field private final fileUploadService$delegate:Lkotlin/Lazy;
.field private final imageUploadServiceDelegate:Lkotlin/Lazy;
.field private final totalSizeTooLarge:Landroidx/lifecycle/LiveData;
.field private final uploadError:Landroidx/lifecycle/LiveData;
.field private final workAttachmentSettings$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$127Y-4ot9ewqmg66tezDGAkj6NY(com.bytedance.trae.conversation.widget.AttachmentItem  com.bytedance.trae.conversation.widget.AttachmentItem)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->removeAttachment$lambda$33$lambda$32(Lcom/bytedance/trae/conversation/widget/AttachmentItem; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$64K7k8Pld0-YB2BhRfZCYONgNE0(com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->retryUpload$lambda$31(Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$CkwQsIDjIn37AD7y2j8TfUyO24Y()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->imageUploadServiceDelegate$lambda$8$lambda$7()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$FCc1zYB8iH1TCMOsTWBtxqDMIxc()com.bytedance.trae.conversation.imageupload.ImageUploadService
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->imageUploadServiceDelegate$lambda$8()Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$XikVnhXLfAzElJ62oeHj7sA-6Rs()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->fileUploadService_delegate$lambda$10$lambda$9()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Xy3DY5QUfNU6lOfFo-S1jX-x8-8()com.bytedance.trae.conversation.fileupload.FileUploadService
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->fileUploadService_delegate$lambda$10()Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$eaJWt-38Vs_AZBf98oxxfyRBfZ4()com.bytedance.trae.conversation.settings.WorkAttachmentSettings
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->workAttachmentSettings_delegate$lambda$11()Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$kpIiTbOmDIQmfcvne_248bd6vVc(kotlin.jvm.functions.Function1  int  long  long)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->uploadImageFile$lambda$38(Lkotlin/jvm/functions/Function1; I J J)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->Companion Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$Companion;
    return-void 
.end method

.method public constructor <init>(android.app.Application)void
    .registers 3
    # ins_size=2
    const-string v0, "application"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Landroidx/lifecycle/AndroidViewModel;-><init>(Landroid/app/Application;)V
    const-string v2, "InputAttachmentListModel"
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    new-instance v2, Ljava/lang/Object;
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachmentLock Ljava/lang/Object;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/List;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    new-instance v2, Landroidx/lifecycle/MutableLiveData;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-direct v2, v0, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachments Landroidx/lifecycle/MutableLiveData;
    check-cast v2, Landroidx/lifecycle/LiveData;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachments Landroidx/lifecycle/LiveData;
    new-instance v2, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v2, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_fileTooLarge Landroidx/lifecycle/MutableLiveData;
    check-cast v2, Landroidx/lifecycle/LiveData;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->fileTooLarge Landroidx/lifecycle/LiveData;
    new-instance v2, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v2, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_totalSizeTooLarge Landroidx/lifecycle/MutableLiveData;
    check-cast v2, Landroidx/lifecycle/LiveData;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->totalSizeTooLarge Landroidx/lifecycle/LiveData;
    new-instance v2, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v2, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_uploadError Landroidx/lifecycle/MutableLiveData;
    check-cast v2, Landroidx/lifecycle/LiveData;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->uploadError Landroidx/lifecycle/LiveData;
    new-instance v2, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v2, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->fakeProgressJobs Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$$ExternalSyntheticLambda4;
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$$ExternalSyntheticLambda4;-><init>()V
    invoke-static v2, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->imageUploadServiceDelegate Lkotlin/Lazy;
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$$ExternalSyntheticLambda5;
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$$ExternalSyntheticLambda5;-><init>()V
    invoke-static v2, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->fileUploadService$delegate Lkotlin/Lazy;
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$$ExternalSyntheticLambda6;
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$$ExternalSyntheticLambda6;-><init>()V
    invoke-static v2, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->workAttachmentSettings$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public static final synthetic access$getFakeProgressJobs$p(com.bytedance.trae.conversation.widget.InputAttachmentListModel)java.util.concurrent.ConcurrentHashMap
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->fakeProgressJobs Ljava/util/concurrent/ConcurrentHashMap;
    return-object v0
.end method

.method public static final synthetic access$getFileUploadService(com.bytedance.trae.conversation.widget.InputAttachmentListModel)com.bytedance.trae.conversation.fileupload.FileUploadService
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getFileUploadService()Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$get_uploadError$p(com.bytedance.trae.conversation.widget.InputAttachmentListModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_uploadError Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$updateItem(com.bytedance.trae.conversation.widget.InputAttachmentListModel  android.net.Uri  kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->updateItem(Landroid/net/Uri; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public static final synthetic access$uploadImageFile(com.bytedance.trae.conversation.widget.InputAttachmentListModel  java.io.File  java.lang.String  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->uploadImageFile(Ljava/io/File; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$uploadWithFakeProgress(com.bytedance.trae.conversation.widget.InputAttachmentListModel  android.net.Uri  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->uploadWithFakeProgress(Landroid/net/Uri; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$uriToFile(com.bytedance.trae.conversation.widget.InputAttachmentListModel  android.net.Uri  java.lang.String)java.io.File
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->uriToFile(Landroid/net/Uri; Ljava/lang/String;)Ljava/io/File;
    move-result-object v0
    return-object v0
.end method

.method private static final fileUploadService_delegate$lambda$10()com.bytedance.trae.conversation.fileupload.FileUploadService
    .registers 8
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    new-instance v7, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$$ExternalSyntheticLambda2;
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$$ExternalSyntheticLambda2;-><init>()V
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

.method private static final fileUploadService_delegate$lambda$10$lambda$9()java.lang.String
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
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->fileUploadService$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    return-object v0
.end method

.method private final getImageUploadService()com.bytedance.trae.conversation.imageupload.ImageUploadService
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->imageUploadServiceDelegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    return-object v0
.end method

.method private static getImageUploadService$delegate(com.bytedance.trae.conversation.widget.InputAttachmentListModel)java.lang.Object
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->imageUploadServiceDelegate Lkotlin/Lazy;
    return-object v0
.end method

.method private final getWorkAttachmentSettings()com.bytedance.trae.conversation.settings.WorkAttachmentSettings
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->workAttachmentSettings$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;
    return-object v0
.end method

.method private static final imageUploadServiceDelegate$lambda$8()com.bytedance.trae.conversation.imageupload.ImageUploadService
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
    new-instance v16, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$$ExternalSyntheticLambda7;
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$$ExternalSyntheticLambda7;-><init>()V
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 6
    const/16 v20, 0
    move-object v15, v2
    invoke-direct/range v15 ... v20, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v10, v2
    check-cast v10, Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$imageUploadServiceDelegate$1$2;
    const/4 v3, 0
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$imageUploadServiceDelegate$1$2;-><init>(Lkotlin/coroutines/Continuation;)V
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

.method private static final imageUploadServiceDelegate$lambda$8$lambda$7()java.lang.String
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

.method private static final removeAttachment$lambda$33$lambda$32(com.bytedance.trae.conversation.widget.AttachmentItem  com.bytedance.trae.conversation.widget.AttachmentItem)boolean
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v1
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    return v1
.end method

.method private static final retryUpload$lambda$31(com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 18
    # ins_size=1
    move-object/from16 v0, v17
    const-string v1, "it"
    move-object/from16 v2, v17
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-wide/16 v1, 0
    const-wide/16 v3, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const-wide/16 v8, 0
    const/4 v10, 0
    sget-object v11, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Uploading Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 639
    const/16 v16, 0
    invoke-static/range v0 ... v16, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->copy$default(Lcom/bytedance/trae/conversation/widget/AttachmentItem; J J Ljava/lang/String; Landroid/net/Uri; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus; I Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method private final updateItem(android.net.Uri  kotlin.jvm.functions.Function1)void
    .registers 7
    # ins_size=3
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachmentLock Ljava/lang/Object;
    monitor-enter v0
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v2, 0
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +016h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v3
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto +5h
    add-int/lit8 v2, v2, 1
    goto -19h
    const/4 v2, -1
    if-ltz v2, +00fh
    iget-object v5, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    invoke-interface v5, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v1
    invoke-interface v6, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    invoke-interface v5, v2, v6, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v5, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachments Landroidx/lifecycle/MutableLiveData;
    iget-object v6, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    check-cast v6, Ljava/lang/Iterable;
    invoke-static v6, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v6
    invoke-virtual v5, v6, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    return-void 
    move-exception v5
    monitor-exit v0
    throw v5
    :try_start_0x3
.end method

.method private final uploadImageFile(java.io.File  java.lang.String  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 24
    # ins_size=5
    move-object/from16 v0, v19
    move-object/from16 v5, v21
    move-object/from16 v1, v23
    instance-of v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadImageFile$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadImageFile$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadImageFile$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadImageFile$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadImageFile$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadImageFile$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadImageFile$1;-><init>(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Lkotlin/coroutines/Continuation;)V
    move-object v8, v2
    iget-object v1, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadImageFile$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v11
    iget v2, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadImageFile$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +018h
    if-eq v2, v4, +011h
    if-ne v2, v3, +007h
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +15fh
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +09eh
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->isEnterpriseLogin()Z
    move-result v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string/jumbo v9, uploadImageFile: isEnterpriseLogin=
    invoke-direct v7, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v10, ", mimeType="
    invoke-virtual v7, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v12, ", fileName="
    invoke-virtual v7, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual/range v20, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v7, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v13, ", fileSize="
    invoke-virtual v7, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual/range v20, Ljava/io/File;->length()J
    move-result-wide v14
    invoke-virtual v7, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v6, v7, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual/range v20, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual/range v20, Ljava/io/File;->length()J
    move-result-wide v9
    invoke-virtual v6, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-static v2, v6, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    if-nez v1, +03ah
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    const-string/jumbo v3, uploadImageFile branch=ImageX
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    invoke-static v1, v3, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getImageUploadService()Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    move-result-object v3
    const-wide/16 v6, 0
    const/4 v9, 4
    const/4 v10, 0
    iput v4, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadImageFile$1;->label I
    move-object/from16 v4, v20
    move-object/from16 v5, v22
    invoke-static/range v3 ... v10, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->uploadImage$default(Lcom/bytedance/trae/conversation/imageupload/ImageUploadService; Ljava/io/File; Lkotlin/jvm/functions/Function1; J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v11, +003h
    return-object v11
    check-cast v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadResult;
    new-instance v10, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadResult;->getTosUri()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 1
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 28
    const/4 v9, 0
    move-object v2, v10
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/conversation/fileupload/UploadResult;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v10
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    const-string/jumbo v4, uploadImageFile branch=ToBImagePresigned
    invoke-virtual v1, v2, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    invoke-static v1, v4, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ImageValidation;
    move-object/from16 v2, v20
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;->validateFile(Ljava/io/File;)Lkotlin/Pair;
    move-result-object v1
    invoke-virtual v1, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->getValid()Z
    move-result v4
    if-nez v4, +020h
    new-instance v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->getErrorCode()Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    move-result-object v3
    if-nez v3, +004h
    sget-object v3, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->UNKNOWN Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    move-object v13, v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->getErrorMessage()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, "Invalid file"
    move-object v14, v1
    const/4 v15, 0
    const/16 v16, 4
    const/16 v17, 0
    move-object v12, v2
    invoke-direct/range v12 ... v17, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
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
    move-object v6, v1
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
    move-result-object v4
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getFileUploadService()Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    move-result-object v1
    sget-object v7, Lcom/bytedance/trae/conversation/fileupload/BizType;->Image Lcom/bytedance/trae/conversation/fileupload/BizType;
    new-instance v9, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
    const/4 v13, 0
    const/4 v14, 0
    new-instance v15, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$$ExternalSyntheticLambda3;
    move-object/from16 v10, v22
    invoke-direct v15, v10, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$$ExternalSyntheticLambda3;-><init>(Lkotlin/jvm/functions/Function1;)V
    const/16 v16, 0
    const/16 v17, 11
    const/16 v18, 0
    move-object v12, v9
    invoke-direct/range v12 ... v18, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;-><init>(Z Z Lkotlin/jvm/functions/Function3; Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput v3, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadImageFile$1;->label I
    move-object/from16 v2, v20
    move-object v3, v4
    move-object v4, v7
    move-object/from16 v5, v21
    move-object v7, v9
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->uploadSingleFile(Ljava/io/File; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/BizType; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v11, +003h
    return-object v11
    check-cast v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getSuccess()Z
    move-result v2
    if-eqz v2, +010h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getOid()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    return-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    sget-object v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->UPLOAD_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getError()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, "Upload failed"
    move-object v5, v1
    const/4 v6, 0
    const/4 v7, 4
    const/4 v8, 0
    move-object v3, v2
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
.end method

.method private static final uploadImageFile$lambda$38(kotlin.jvm.functions.Function1  int  long  long)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final uploadWithFakeProgress(android.net.Uri  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;
    const/4 v1, 0
    invoke-direct v0, v2, v3, v4, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;-><init>(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)V
    check-cast v0, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v5, Lkotlinx/coroutines/CoroutineScopeKt;->coroutineScope(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    if-ne v3, v4, +003h
    return-object v3
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private final uriToFile(android.net.Uri  java.lang.String)java.io.File
    .registers 9
    # ins_size=3
    const/4 v0, 0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-virtual v1, Landroid/app/Application;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v1
    const-string v2, "getContentResolver(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v8, +00bh
    invoke-static Landroid/webkit/MimeTypeMap;->getSingleton()Landroid/webkit/MimeTypeMap;
    move-result-object v2
    invoke-virtual v2, v8, Landroid/webkit/MimeTypeMap;->getExtensionFromMimeType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getApplication()Landroid/app/Application;
    move-result-object v2
    invoke-virtual v2, Landroid/app/Application;->getCacheDir()Ljava/io/File;
    move-result-object v2
    const-string v3, "getCacheDir(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v8, Lcom/bytedance/trae/conversation/widget/UploadTempFileFactoryKt;->createUploadTempFile(Ljava/io/File; Ljava/lang/String;)Ljava/io/File;
    move-result-object v8
    invoke-virtual v1, v7, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;
    move-result-object v7
    if-eqz v7, +031h
    check-cast v7, Ljava/io/Closeable;
    move-object v1, v7
    check-cast v1, Ljava/io/InputStream;
    new-instance v2, Ljava/io/FileOutputStream;
    invoke-direct v2, v8, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    check-cast v2, Ljava/io/Closeable;
    move-object v3, v2
    check-cast v3, Ljava/io/FileOutputStream;
    check-cast v3, Ljava/io/OutputStream;
    const/4 v4, 0
    const/4 v5, 2
    invoke-static v1, v3, v4, v5, v0, Lkotlin/io/ByteStreamsKt;->copyTo$default(Ljava/io/InputStream; Ljava/io/OutputStream; I I Ljava/lang/Object;)J
    move-result-wide v3
    invoke-static v2, v0, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    invoke-static v3, v4, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    invoke-static v7, v0, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +fh
    move-exception v8
    throw v8
    move-exception v1
    invoke-static v2, v8, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v1
    move-exception v8
    throw v8
    move-exception v1
    invoke-static v7, v8, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v1
    move-object v0, v8
    return-object v0
    :try_start_0x1
    :try_start_0x33
    :try_start_0x3d
    :try_start_0x48
    :try_start_0x4e
    :try_start_0x53
    :try_start_0x55
    :try_start_0x5a
    :try_start_0x5c
.end method

.method static synthetic uriToFile$default(com.bytedance.trae.conversation.widget.InputAttachmentListModel  android.net.Uri  java.lang.String  int  java.lang.Object)java.io.File
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->uriToFile(Landroid/net/Uri; Ljava/lang/String;)Ljava/io/File;
    move-result-object v0
    return-object v0
.end method

.method private static final workAttachmentSettings_delegate$lambda$11()com.bytedance.trae.conversation.settings.WorkAttachmentSettings
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettingsService;->INSTANCE Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettingsService;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettingsService;->getWorkAttachmentSettings()Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;
    move-result-object v0
    return-object v0
.end method

.method public final addAttachment(android.net.Uri  android.content.Context)void
    .registers 26
    # ins_size=3
    move-object/from16 v1, v23
    move-object/from16 v0, v24
    const-string/jumbo v2, uri
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "context"
    move-object/from16 v3, v25
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "addAttachment: uri="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", isEnterpriseLogin="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-direct/range v23, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->isEnterpriseLogin()Z
    move-result v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", uploadPath=RemoteResource"
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v4, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "addAttachment: uri="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", isEnterpriseLogin="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-direct/range v23, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->isEnterpriseLogin()Z
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", uploadPath=RemoteResource"
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v4, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachmentLock Ljava/lang/Object;
    monitor-enter v2
    iget-object v4, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    check-cast v4, Ljava/lang/Iterable;
    instance-of v5, v4, Ljava/util/Collection;
    const/4 v8, 1
    const/4 v9, 0
    if-eqz v5, +00dh
    move-object v5, v4
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    if-eqz v5, +004h
    move v4, v9
    goto +1ch
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, -00ah
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, -014h
    move v4, v8
    if-eqz v4, +004h
    monitor-exit v2
    return-void 
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v2
    const/4 v13, 0
    invoke-virtual/range v25, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v2
    const-string v3, "mime_type"
    const-string v4, "_size"
    const-string v5, "_display_name"
    filled-new-array v3, v4, v5, [Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    move-object/from16 v3, v24
    invoke-virtual/range v2 ... v7, Landroid/content/ContentResolver;->query(Landroid/net/Uri; [Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String; Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v2
    move-object v12, v2
    goto +2h
    move-object v12, v13
    if-nez v12, +012h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_uploadError Landroidx/lifecycle/MutableLiveData;
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getApplication()Landroid/app/Application;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_file_invalid_format I
    invoke-virtual v2, v3, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    return-void 
    invoke-interface v12, Landroid/database/Cursor;->moveToFirst()Z
    move-result v2
    if-nez v2, +015h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_uploadError Landroidx/lifecycle/MutableLiveData;
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getApplication()Landroid/app/Application;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_file_invalid_format I
    invoke-virtual v2, v3, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    invoke-interface v12, Landroid/database/Cursor;->close()V
    return-void 
    const-string v2, "_size"
    invoke-interface v12, v2, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I
    move-result v2
    const-wide/16 v3, 0
    const/4 v5, -1
    if-eq v2, v5, +008h
    invoke-interface v12, v2, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v6
    move-wide v10, v6
    goto +2h
    move-wide v10, v3
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, Ljava/lang/StringBuilder;-><init>()V
    const-string v14, "addAttachment:sizeBytes:"
    invoke-virtual v7, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v10, v11, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v6, v7, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getSingleSize()J
    move-result-wide v6
    cmp-long v2, v10, v6
    if-lez v2, +00dh
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_fileTooLarge Landroidx/lifecycle/MutableLiveData;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    invoke-interface v12, Landroid/database/Cursor;->close()V
    return-void 
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachmentLock Ljava/lang/Object;
    monitor-enter v2
    iget-object v6, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +00eh
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getSizeBytes()J
    move-result-wide v14
    add-long/2addr v3, v14
    goto -11h
    monitor-exit v2
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, Ljava/lang/StringBuilder;-><init>()V
    const-string v14, "addAttachment:currentTotalSize:"
    invoke-virtual v7, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v6, v7, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    add-long/2addr v3, v10
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentTotalSize()J
    move-result-wide v6
    cmp-long v2, v3, v6
    if-lez v2, +00dh
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_totalSizeTooLarge Landroidx/lifecycle/MutableLiveData;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    invoke-interface v12, Landroid/database/Cursor;->close()V
    return-void 
    const-string v2, "mime_type"
    invoke-interface v12, v2, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I
    move-result v2
    if-eq v2, v5, +008h
    invoke-interface v12, v2, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v2
    move-object v7, v2
    goto +2h
    move-object v7, v13
    const-string v2, "_display_name"
    invoke-interface v12, v2, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I
    move-result v2
    if-eq v2, v5, +009h
    invoke-interface v12, v2, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v2
    move-object/from16 v19, v2
    goto +3h
    move-object/from16 v19, v13
    new-instance v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    const-wide/16 v3, 0
    invoke-virtual/range v24, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    int-to-long v14, v2
    if-eqz v7, +00eh
    const-string v2, "image/"
    const/4 v6, 2
    invoke-static v7, v2, v9, v6, v13, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-ne v2, v8, +005h
    move/from16 v20, v8
    goto +3h
    move/from16 v20, v9
    sget-object v21, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Pending Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    const/4 v2, 0
    move-wide v8, v14
    move v14, v2
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 1536
    const/16 v18, 0
    move-object v2, v5
    move-object/from16 v22, v5
    move-wide v5, v8
    move-object v9, v7
    move-object/from16 v7, v19
    move-object/from16 v8, v24
    move-object/from16 v19, v12
    move/from16 v12, v20
    move-object/from16 v13, v21
    invoke-direct/range v2 ... v18, Lcom/bytedance/trae/conversation/widget/AttachmentItem;-><init>(J J Ljava/lang/String; Landroid/net/Uri; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus; I Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface/range v19, Landroid/database/Cursor;->close()V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachmentLock Ljava/lang/Object;
    monitor-enter v2
    iget-object v3, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    move-object/from16 v4, v22
    invoke-interface v3, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachments Landroidx/lifecycle/MutableLiveData;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    check-cast v5, Ljava/lang/Iterable;
    invoke-static v5, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v5
    invoke-virtual v3, v5, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v2
    move-object v2, v1
    check-cast v2, Landroidx/lifecycle/ViewModel;
    invoke-static v2, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v5
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Lkotlin/coroutines/CoroutineContext;
    const/4 v7, 0
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;
    const/4 v3, 0
    invoke-direct v2, v4, v1, v0, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;-><init>(Lcom/bytedance/trae/conversation/widget/AttachmentItem; Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    move-object v8, v2
    check-cast v8, Lkotlin/jvm/functions/Function2;
    const/4 v9, 2
    const/4 v10, 0
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    move-exception v0
    monitor-exit v2
    throw v0
    move-exception v0
    move-object/from16 v19, v12
    monitor-exit v2
    throw v0
    move-exception v0
    goto +4h
    move-exception v0
    move-object/from16 v19, v12
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    const-string v4, "addAttachment"
    invoke-virtual v2, v3, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_uploadError Landroidx/lifecycle/MutableLiveData;
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getApplication()Landroid/app/Application;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_file_invalid_format I
    invoke-virtual v2, v3, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    invoke-interface/range v19, Landroid/database/Cursor;->close()V
    return-void 
    move-exception v0
    invoke-interface/range v19, Landroid/database/Cursor;->close()V
    throw v0
    move-exception v0
    monitor-exit v2
    throw v0
    :try_start_0x66
    :try_start_0x9a
    :try_start_0x9e
    :try_start_0xca
    :try_start_0xe3
    :try_start_0x122
    :try_start_0x125
    :try_start_0x13f
    :try_start_0x16e
    :try_start_0x1c6
    :try_start_0x1cf
    :try_start_0x20a
    :try_start_0x211
.end method

.method public final addImageAttachments(java.util.List)void
    .registers 28
    # ins_size=2
    move-object/from16 v1, v26
    move-object/from16 v0, v27
    const-string v2, "list"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "addImageAttachments: count="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface/range v27, Ljava/util/List;->size()I
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", isEnterpriseLogin="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-direct/range v26, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->isEnterpriseLogin()Z
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", uploadPath=RemoteResource"
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v3, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "addImageAttachments: count="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface/range v27, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", isEnterpriseLogin="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-direct/range v26, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->isEnterpriseLogin()Z
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", uploadPath=RemoteResource"
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-static v2, v3, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    new-instance v2, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v2, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachmentLock Ljava/lang/Object;
    monitor-enter v3
    check-cast v0, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    const/4 v6, 0
    if-eqz v5, +040h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v8, v5
    check-cast v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    check-cast v9, Ljava/lang/Iterable;
    instance-of v10, v9, Ljava/util/Collection;
    if-eqz v10, +00dh
    move-object v10, v9
    check-cast v10, Ljava/util/Collection;
    invoke-interface v10, Ljava/util/Collection;->isEmpty()Z
    move-result v10
    if-eqz v10, +004h
    const/4 v6, 1
    goto +1fh
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-eqz v10, -00ah
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v10
    invoke-virtual v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getUri()Landroid/net/Uri;
    move-result-object v11
    invoke-static v10, v11, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v10
    if-eqz v10, -018h
    if-eqz v6, -03fh
    invoke-interface v4, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -44h
    check-cast v4, Ljava/util/List;
    check-cast v4, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v5, 10
    invoke-static v4, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v0, v5, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    const/4 v8, 0
    if-eqz v5, +05ch
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    new-instance v15, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v10
    invoke-virtual v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getUri()Landroid/net/Uri;
    move-result-object v9
    invoke-virtual v9, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/String;->hashCode()I
    move-result v9
    int-to-long v12, v9
    invoke-virtual v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getFileName()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getUri()Landroid/net/Uri;
    move-result-object v16
    invoke-virtual v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getMimeType()Ljava/lang/String;
    move-result-object v17
    invoke-virtual v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getSizeBytes()J
    move-result-wide v18
    invoke-virtual v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getMimeType()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +00eh
    const-string v9, "image/"
    const/4 v7, 2
    invoke-static v5, v9, v6, v7, v8, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v5
    const/4 v7, 1
    if-ne v5, v7, +005h
    move v5, v7
    goto +3h
    const/4 v7, 1
    move v5, v6
    sget-object v20, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Pending Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 1536
    const/16 v25, 0
    move-object v9, v15
    move-object v8, v15
    move-object/from16 v15, v16
    move-object/from16 v16, v17
    move-wide/from16 v17, v18
    move/from16 v19, v5
    invoke-direct/range v9 ... v25, Lcom/bytedance/trae/conversation/widget/AttachmentItem;-><init>(J J Ljava/lang/String; Landroid/net/Uri; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus; I Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -60h
    check-cast v0, Ljava/util/List;
    iput-object v0, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    iget-object v0, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v0, Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +004h
    monitor-exit v3
    return-void 
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    iget-object v4, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v4, Ljava/util/Collection;
    invoke-interface v0, v4, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachments Landroidx/lifecycle/MutableLiveData;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    check-cast v4, Ljava/lang/Iterable;
    invoke-static v4, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v4
    invoke-virtual v0, v4, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v3
    iget-object v0, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +025h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-object v3, v1
    check-cast v3, Landroidx/lifecycle/ViewModel;
    invoke-static v3, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v9
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v3
    move-object v10, v3
    check-cast v10, Lkotlin/coroutines/CoroutineContext;
    const/4 v11, 0
    new-instance v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;
    invoke-direct v3, v1, v2, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;-><init>(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Lcom/bytedance/trae/conversation/widget/AttachmentItem; Lkotlin/coroutines/Continuation;)V
    move-object v12, v3
    check-cast v12, Lkotlin/jvm/functions/Function2;
    const/4 v13, 2
    const/4 v14, 0
    invoke-static/range v9 ... v14, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto -28h
    return-void 
    move-exception v0
    monitor-exit v3
    throw v0
    :try_start_0x6b
    :try_start_0x143
.end method

.method public final addImages(java.util.List)void
    .registers 10
    # ins_size=2
    const-string v0, "items"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "addImages: count="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v9, Ljava/util/List;->size()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", isEnterpriseLogin="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->isEnterpriseLogin()Z
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", uploadPath=Image"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "addImages: count="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v9, Ljava/util/List;->size()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isEnterpriseLogin="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->isEnterpriseLogin()Z
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", uploadPath=Image"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    new-instance v0, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v0, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    iget-object v1, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachmentLock Ljava/lang/Object;
    monitor-enter v1
    iget-object v2, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    const/16 v4, 10
    invoke-static v2, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v3, v5, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +010h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v5
    invoke-interface v3, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v3, Ljava/util/List;
    check-cast v3, Ljava/lang/Iterable;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v2
    check-cast v9, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +019h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getUri()Landroid/net/Uri;
    move-result-object v6
    invoke-interface v2, v6, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v6
    xor-int/lit8 v6, v6, 1
    if-eqz v6, -017h
    invoke-interface v3, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ch
    check-cast v3, Ljava/util/List;
    check-cast v3, Ljava/lang/Iterable;
    new-instance v9, Ljava/util/ArrayList;
    invoke-static v3, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v9, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v9, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-static v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModelKt;->access$toAttachmentItem(Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v3
    invoke-interface v9, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v9, Ljava/util/List;
    iput-object v9, v0, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    iget-object v9, v0, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v9, Ljava/util/List;
    invoke-interface v9, Ljava/util/List;->isEmpty()Z
    move-result v9
    if-eqz v9, +004h
    monitor-exit v1
    return-void 
    iget-object v9, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    iget-object v2, v0, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v2, Ljava/util/Collection;
    invoke-interface v9, v2, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    iget-object v9, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachments Landroidx/lifecycle/MutableLiveData;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v2
    invoke-virtual v9, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v1
    iget-object v9, v0, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v9, Ljava/lang/Iterable;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +026h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/ViewModel;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Lkotlin/coroutines/CoroutineContext;
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1;
    const/4 v5, 0
    invoke-direct v1, v0, v8, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1;-><init>(Lcom/bytedance/trae/conversation/widget/AttachmentItem; Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 2
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto -29h
    return-void 
    move-exception v9
    monitor-exit v1
    throw v9
    :try_start_0x67
    :try_start_0xf9
.end method

.method public final clearAttachments()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->fakeProgressJobs Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentHashMap;->values()Ljava/util/Collection;
    move-result-object v0
    const-string v1, "<get-values>(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00eh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlinx/coroutines/Job;
    const/4 v2, 1
    const/4 v3, 0
    invoke-static v1, v3, v2, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    goto -11h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->fakeProgressJobs Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentHashMap;->clear()V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachmentLock Ljava/lang/Object;
    monitor-enter v0
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->clear()V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachments Landroidx/lifecycle/MutableLiveData;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    return-void 
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x2b
.end method

.method public final getAttachments()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachments Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getCodeImageMaxCount()long
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentSettings()Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->getCodeTotalImageCount()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v2, v0, v2
    if-lez v2, +003h
    goto +3h
    const-wide/16 v0, 5
    return-wide v0
.end method

.method public final getCodeImageSize()long
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentSettings()Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->getCodeSingleImageSize()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v2, v0, v2
    if-lez v2, +003h
    goto +4h
    const-wide/32 v0, 104857600
    return-wide v0
.end method

.method public final getFileTooLarge()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->fileTooLarge Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getRemainCount()long
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachmentLock Ljava/lang/Object;
    monitor-enter v0
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    monitor-exit v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentTotalCount()J
    move-result-wide v2
    int-to-long v0, v1
    sub-long/2addr v2, v0
    return-wide v2
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x3
.end method

.method public final getSelectedMediaItems()java.util.List
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachmentLock Ljava/lang/Object;
    monitor-enter v0
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +013h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->isImage()Z
    move-result v4
    if-eqz v4, -011h
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v2, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v1, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-static v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModelKt;->access$toMediaItem(Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    move-result-object v3
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v1, Ljava/util/List;
    monitor-exit v0
    return-object v1
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x3
.end method

.method public final getSingleSize()long
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentSettings()Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->getWorkSingleAttachmentSize()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v2, v0, v2
    if-lez v2, +003h
    goto +4h
    const-wide/32 v0, 209715200
    return-wide v0
.end method

.method public final getTAG()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    return-object v0
.end method

.method public final getTotalSizeTooLarge()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->totalSizeTooLarge Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getUploadError()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->uploadError Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getUploadedFiles()java.util.List
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachmentLock Ljava/lang/Object;
    monitor-enter v0
    iget-object v1, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +01ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadStatus()Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Success Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    if-ne v4, v5, +004h
    const/4 v4, 1
    goto +2h
    const/4 v4, 0
    if-eqz v4, -018h
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v2, Ljava/util/List;
    monitor-exit v0
    return-object v2
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x3
.end method

.method public final getUploadedImages()java.util.List
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachmentLock Ljava/lang/Object;
    monitor-enter v0
    iget-object v1, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +020h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->isImage()Z
    move-result v5
    if-eqz v5, +00ch
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadStatus()Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Success Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    if-ne v4, v5, +004h
    const/4 v4, 1
    goto +2h
    const/4 v4, 0
    if-eqz v4, -01eh
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -23h
    check-cast v2, Ljava/util/List;
    monitor-exit v0
    return-object v2
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x3
.end method

.method public final getWorkAttachmentRemainTotalSize()long
    .registers 9
    # ins_size=1
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentSettings()Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->getTotalSize()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v4, v0, v2
    if-gtz v4, +005h
    const-wide/32 v0, 1073741824
    iget-object v4, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachmentLock Ljava/lang/Object;
    monitor-enter v4
    iget-object v5, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +00eh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getSizeBytes()J
    move-result-wide v6
    add-long/2addr v2, v6
    goto -11h
    monitor-exit v4
    sub-long/2addr v0, v2
    return-wide v0
    move-exception v0
    monitor-exit v4
    throw v0
    :try_start_0x14
.end method

.method public final getWorkAttachmentTotalCount()long
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentSettings()Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->getTotalCount()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v2, v0, v2
    if-lez v2, +003h
    goto +3h
    const-wide/16 v0, 20
    return-wide v0
.end method

.method public final getWorkAttachmentTotalSize()long
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentSettings()Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->getTotalSize()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v2, v0, v2
    if-lez v2, +003h
    goto +4h
    const-wide/32 v0, 1073741824
    return-wide v0
.end method

.method public final getWorkSingleImageSize()long
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentSettings()Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->getWorkSingleImageSize()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v2, v0, v2
    if-lez v2, +003h
    goto +4h
    const-wide/32 v0, 104857600
    return-wide v0
.end method

.method public final isCanAddAttachment()boolean
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachmentLock Ljava/lang/Object;
    monitor-enter v0
    iget-object v1, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    monitor-exit v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "isCanAddAttachment:"
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v4, 32
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentTotalCount()J
    move-result-wide v4
    invoke-virtual v3, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    int-to-long v0, v1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentTotalCount()J
    move-result-wide v2
    cmp-long v0, v0, v2
    if-gez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x3
.end method

.method protected onCleared()void
    .registers 5
    # ins_size=1
    invoke-super v4, Landroidx/lifecycle/AndroidViewModel;->onCleared()V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->fakeProgressJobs Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentHashMap;->values()Ljava/util/Collection;
    move-result-object v0
    const-string v1, "<get-values>(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00eh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlinx/coroutines/Job;
    const/4 v2, 1
    const/4 v3, 0
    invoke-static v1, v3, v2, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    goto -11h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->fakeProgressJobs Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentHashMap;->clear()V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->imageUploadServiceDelegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->isInitialized()Z
    move-result v0
    if-eqz v0, +009h
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getImageUploadService()Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->close()V
    return-void 
.end method

.method public final removeAttachment(com.bytedance.trae.conversation.widget.AttachmentItem)void
    .registers 5
    # ins_size=2
    const-string v0, "item"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachmentLock Ljava/lang/Object;
    monitor-enter v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$$ExternalSyntheticLambda0;
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/widget/AttachmentItem;)V
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->removeAll(Ljava/util/List; Lkotlin/jvm/functions/Function1;)Z
    iget-object v4, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachments Landroidx/lifecycle/MutableLiveData;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v1
    invoke-virtual v4, v1, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    return-void 
    move-exception v4
    monitor-exit v0
    throw v4
    :try_start_0x8
.end method

.method public final retryUpload(com.bytedance.trae.conversation.widget.AttachmentItem  com.bytedance.trae.conversation.widget.ChatMode)void
    .registers 16
    # ins_size=3
    const-string v0, "item"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadStatus()Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Error Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    if-eq v0, v1, +003h
    return-void 
    invoke-virtual v14, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v5
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$$ExternalSyntheticLambda1;-><init>()V
    invoke-direct v13, v5, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->updateItem(Landroid/net/Uri; Lkotlin/jvm/functions/Function1;)V
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v15, v0, +00ah
    invoke-virtual v14, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->isImage()Z
    move-result v0
    if-eqz v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    move v6, v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v13, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, retryUpload: mode=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", isImage="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v14, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->isImage()Z
    move-result v7
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v7, ", useImageUpload="
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v8, ", isEnterpriseLogin="
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-direct v13, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->isEnterpriseLogin()Z
    move-result v9
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v13, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->TAG Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v15
    invoke-virtual v15, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v15
    invoke-virtual v14, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->isImage()Z
    move-result v1
    invoke-virtual v15, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v15
    invoke-virtual v15, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v15
    invoke-virtual v15, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v15
    invoke-virtual v15, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v15
    invoke-direct v13, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->isEnterpriseLogin()Z
    move-result v1
    invoke-virtual v15, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v15
    invoke-virtual v15, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v15
    invoke-static v0, v15, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    move-object v15, v13
    check-cast v15, Landroidx/lifecycle/ViewModel;
    invoke-static v15, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v15
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    move-object v8, v0
    check-cast v8, Lkotlin/coroutines/CoroutineContext;
    const/4 v9, 0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2;
    const/4 v7, 0
    move-object v2, v0
    move-object v3, v13
    move-object v4, v14
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2;-><init>(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Lcom/bytedance/trae/conversation/widget/AttachmentItem; Landroid/net/Uri; Z Lkotlin/coroutines/Continuation;)V
    move-object v10, v0
    check-cast v10, Lkotlin/jvm/functions/Function2;
    const/4 v11, 2
    const/4 v12, 0
    move-object v7, v15
    invoke-static/range v7 ... v12, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final setAttachments(java.util.List)void
    .registers 4
    # ins_size=2
    const-string v0, "items"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->attachmentLock Ljava/lang/Object;
    monitor-enter v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->clear()V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    check-cast v3, Ljava/util/Collection;
    invoke-interface v1, v3, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    iget-object v3, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachments Landroidx/lifecycle/MutableLiveData;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->_attachmentList Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v1
    invoke-virtual v3, v1, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    return-void 
    move-exception v3
    monitor-exit v0
    throw v3
    :try_start_0x8
.end method
