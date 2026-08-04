# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
.super Ljava/lang/Object;
.source "FileDownloadHelper.kt"

.field private final MIN_TRIGGER_LOADING_DURATION:J
.field private final RESULT_CODE_FAILED_CRASH:I
.field private final RESULT_CODE_FAILED_DOWNLOAD:I
.field private final RESULT_CODE_FAILED_NO_WRITE_EXTERNAL_PERMISSION:I
.field private final RESULT_CODE_SUCCESS:I
.field private final TAG:Ljava/lang/String;
.field private final downloadContinuationMap:Ljava/util/concurrent/ConcurrentHashMap;
.field private final downloadFinishBlk:Lkotlin/jvm/functions/Function1;
.field private final downloadingDatas:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final uploadLoadingJobMap:Ljava/util/concurrent/ConcurrentHashMap;


.method public static synthetic $r8$lambda$-FebZVsQd7tbvVfpbqFjd8pltsI(com.bytedance.trae.conversation.products.FileDownloadHelper  java.io.File  java.lang.String  java.lang.String  kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function3  long  boolean)kotlin.Unit
    .registers 9
    # ins_size=9
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->copyCachedFileAndLoading$lambda$9$lambda$8(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; J Z)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$3UsG7s2EdR7bYAaJm-HMDhD0pGs(com.bytedance.trae.conversation.products.FileDownloadHelper  java.lang.String  java.lang.String  java.lang.String  kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function3  boolean  long  boolean)kotlin.Unit
    .registers 10
    # ins_size=10
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFileAndLoading$lambda$5$lambda$4(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J Z)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$3h2X-84eNr-nB3yHXEAa2Yqpxo0(com.bytedance.trae.conversation.products.FileDownloadHelper  java.lang.String  java.lang.Throwable)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->copyCachedFileAndLoading$lambda$6(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/lang/String; Ljava/lang/Throwable;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$4gwD2ZLqO6kXIXiiQObmk1YvJz0(androidx.fragment.app.FragmentActivity  com.bytedance.trae.conversation.products.FileDownloadHelper  java.lang.String  java.lang.String  java.lang.String  kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function3  boolean  long)kotlin.Unit
    .registers 10
    # ins_size=10
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFileAndLoading$lambda$5(Landroidx/fragment/app/FragmentActivity; Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$O1e2DBO_Zm4zi9zoGG2JsRNvzGw(com.bytedance.trae.conversation.products.FileDownloadHelper  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadFinishBlk$lambda$0(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$QojJJ7HXUddQCexiBi18ORfPHVk(com.bytedance.trae.conversation.products.FileDownloadHelper  java.lang.String  java.lang.Throwable)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFileAndLoading$lambda$2(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/lang/String; Ljava/lang/Throwable;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$fCgh9mNv1B4jV9iMroFXQUycL6E(androidx.fragment.app.FragmentActivity  com.bytedance.trae.conversation.products.FileDownloadHelper  java.io.File  java.lang.String  java.lang.String  kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function3  long)kotlin.Unit
    .registers 9
    # ins_size=9
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->copyCachedFileAndLoading$lambda$9(Landroidx/fragment/app/FragmentActivity; Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; J)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$pdutHqqPdXJTNnwGoE3J5pphVOs(byte)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getCacheFilePath$lambda$18(B)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    const-string v0, "FileDownloadHelper"
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadContinuationMap Ljava/util/concurrent/ConcurrentHashMap;
    const/4 v0, -1
    iput v0, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_FAILED_CRASH I
    const/16 v0, 601
    iput v0, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_FAILED_NO_WRITE_EXTERNAL_PERMISSION I
    const/4 v0, -2
    iput v0, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_FAILED_DOWNLOAD I
    const-wide/16 v0, 200
    iput-wide v0, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->MIN_TRIGGER_LOADING_DURATION J
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadingDatas Lkotlinx/coroutines/flow/MutableStateFlow;
    new-instance v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadFinishBlk Lkotlin/jvm/functions/Function1;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->uploadLoadingJobMap Ljava/util/concurrent/ConcurrentHashMap;
    return-void 
.end method

.method public static final synthetic access$copyCachedFile(com.bytedance.trae.conversation.products.FileDownloadHelper  android.content.Context  java.io.File  java.lang.String  java.lang.String  long)kotlin.Pair
    .registers 7
    # ins_size=7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->copyCachedFile(Landroid/content/Context; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; J)Lkotlin/Pair;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$downloadFile(com.bytedance.trae.conversation.products.FileDownloadHelper  android.content.Context  java.lang.String  java.lang.String  java.lang.String  boolean  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=9
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadFile(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getDownloadContinuationMap$p(com.bytedance.trae.conversation.products.FileDownloadHelper)java.util.concurrent.ConcurrentHashMap
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadContinuationMap Ljava/util/concurrent/ConcurrentHashMap;
    return-object v0
.end method

.method public static final synthetic access$getDownloadFinishBlk$p(com.bytedance.trae.conversation.products.FileDownloadHelper)kotlin.jvm.functions.Function1
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadFinishBlk Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public static final synthetic access$getDownloadingDatas$p(com.bytedance.trae.conversation.products.FileDownloadHelper)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadingDatas Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$getMIN_TRIGGER_LOADING_DURATION$p(com.bytedance.trae.conversation.products.FileDownloadHelper)long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->MIN_TRIGGER_LOADING_DURATION J
    return-wide v0
.end method

.method public static final synthetic access$getRESULT_CODE_FAILED_CRASH$p(com.bytedance.trae.conversation.products.FileDownloadHelper)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_FAILED_CRASH I
    return v0
.end method

.method public static final synthetic access$getTAG$p(com.bytedance.trae.conversation.products.FileDownloadHelper)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$resumeDownloadContinuation(com.bytedance.trae.conversation.products.FileDownloadHelper  int  com.bytedance.trae.conversation.products.SaveFileResult)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->resumeDownloadContinuation(I Lcom/bytedance/trae/conversation/products/SaveFileResult;)V
    return-void 
.end method

.method public static final synthetic access$saveFile(com.bytedance.trae.conversation.products.FileDownloadHelper  android.content.Context  java.lang.String  java.io.File  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFile(Landroid/content/Context; Ljava/lang/String; Ljava/io/File; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final buildDisplayPath(java.lang.String  java.lang.String)java.lang.String
    .registers 5
    # ins_size=3
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-static Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;
    move-result-object v1
    invoke-virtual v1, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    sget-object v1, Ljava/io/File;->separator Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    sget-object v0, Ljava/io/File;->separator Ljava/lang/String;
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final cancelUpdateLoadingJob(java.lang.String)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->uploadLoadingJobMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v3, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lkotlinx/coroutines/Job;
    if-eqz v3, +007h
    const/4 v0, 1
    const/4 v1, 0
    invoke-static v3, v1, v0, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    return-void 
.end method

.method private final copyCachedFile(android.content.Context  java.io.File  java.lang.String  java.lang.String  long)kotlin.Pair
    .registers 13
    # ins_size=7
    invoke-virtual v8, Ljava/io/File;->exists()Z
    move-result v0
    const-string v1, ""
    if-eqz v0, +0b1h
    invoke-virtual v8, Ljava/io/File;->length()J
    move-result-wide v2
    const-wide/16 v4, 0
    cmp-long v0, v2, v4
    if-nez v0, +004h
    goto/16 +0a5h
    invoke-direct v6, v7, v10, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getExternalFilePath(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +02bh
    cmp-long v11, v11, v4
    if-gtz v11, +024h
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v8, v6, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v9, Ljava/lang/StringBuilder;
    const-string v10, "copyCachedFile: no createTime, existing file found="
    invoke-direct v9, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v7, v8, v9, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v7, Lkotlin/Pair;
    iget v8, v6, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_SUCCESS I
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-direct v7, v8, v0, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v7
    invoke-direct v6, v7, v10, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->removeExternalFile(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v6, v7, v8, v10, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->copyToExternalDownload(Landroid/content/Context; Ljava/io/File; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    sget-object v9, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v11, v6, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v12, Ljava/lang/StringBuilder;
    const-string v0, "copyCachedFile: copyToExternalDownload result="
    invoke-direct v12, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    const-string v0, ", cacheFile="
    invoke-virtual v12, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v8, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v12, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    const-string v0, ", cacheExists="
    invoke-virtual v12, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v8, Ljava/io/File;->exists()Z
    move-result v0
    invoke-virtual v12, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v12
    const-string v0, ", cacheSize="
    invoke-virtual v12, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v8, Ljava/io/File;->length()J
    move-result-wide v2
    invoke-virtual v12, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v9, v11, v8, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v7, +00eh
    new-instance v8, Lkotlin/Pair;
    iget v9, v6, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_SUCCESS I
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-direct v8, v9, v7, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    goto +22h
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v8, v6, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v9, Ljava/lang/StringBuilder;
    const-string v11, "copyCachedFile: copyToExternalDownload failed for path="
    invoke-direct v9, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v7, v8, v9, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v8, Lkotlin/Pair;
    iget v7, v6, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_FAILED_DOWNLOAD I
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-direct v8, v7, v1, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v8
    new-instance v7, Lkotlin/Pair;
    iget v8, v6, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_FAILED_DOWNLOAD I
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-direct v7, v8, v1, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v7
.end method

.method public static synthetic copyCachedFileAndLoading$default(com.bytedance.trae.conversation.products.FileDownloadHelper  android.content.Context  java.io.File  java.lang.String  java.lang.String  kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function3  long  int  java.lang.Object)void
    .registers 22
    # ins_size=11
    and-int/lit8 v0, v20, 64
    if-eqz v0, +006h
    const-wide/16 v0, 0
    move-wide v9, v0
    goto +3h
    move-wide/from16 v9, v18
    move-object v2, v11
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object v6, v15
    move-object/from16 v7, v16
    move-object/from16 v8, v17
    invoke-virtual/range v2 ... v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->copyCachedFileAndLoading(Landroid/content/Context; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; J)V
    return-void 
.end method

.method private static final copyCachedFileAndLoading$lambda$6(com.bytedance.trae.conversation.products.FileDownloadHelper  java.lang.String  java.lang.Throwable)kotlin.Unit
    .registers 7
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "invokeOnCompletion: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v2, " with path "
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v1, v6, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v4, v4, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->uploadLoadingJobMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v4, v5, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private static final copyCachedFileAndLoading$lambda$9(androidx.fragment.app.FragmentActivity  com.bytedance.trae.conversation.products.FileDownloadHelper  java.io.File  java.lang.String  java.lang.String  kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function3  long)kotlin.Unit
    .registers 21
    # ins_size=9
    const-string v0, "android.permission.READ_EXTERNAL_STORAGE"
    const-string v1, "android.permission.WRITE_EXTERNAL_STORAGE"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/products/PermissionService;->INSTANCE Lcom/bytedance/trae/conversation/products/PermissionService;
    new-instance v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;
    move-object v2, v11
    move-object v3, v13
    move-object v4, v14
    move-object v5, v15
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    move-object/from16 v8, v18
    move-wide/from16 v9, v19
    invoke-direct/range v2 ... v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; J)V
    move-object v2, v12
    invoke-virtual v1, v12, v0, v11, Lcom/bytedance/trae/conversation/products/PermissionService;->permission(Landroidx/fragment/app/FragmentActivity; Ljava/util/List; Lkotlin/jvm/functions/Function1;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final copyCachedFileAndLoading$lambda$9$lambda$8(com.bytedance.trae.conversation.products.FileDownloadHelper  java.io.File  java.lang.String  java.lang.String  kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function3  long  boolean)kotlin.Unit
    .registers 18
    # ins_size=9
    move-object v0, v9
    move-object v6, v14
    if-eqz v17, +01ch
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-virtual v1, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;
    move-result-object v1
    const-string v2, "getApplicationContext(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v9
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move-object v6, v14
    move-wide v7, v15
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->copyCachedFileAndLoadingInternal(Landroid/content/Context; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; J)V
    goto +23h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "Music Edit Error"
    const-string v3, "no permission"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v6, +013h
    iget v1, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_FAILED_NO_WRITE_EXTERNAL_PERMISSION I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-wide/16 v2, 0
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    const-string v3, ""
    invoke-interface v14, v1, v3, v2, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadFinishBlk Lkotlin/jvm/functions/Function1;
    move-object v1, v12
    invoke-interface v0, v12, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final copyCachedFileAndLoadingInternal(android.content.Context  java.io.File  java.lang.String  java.lang.String  kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function3  long)void
    .registers 23
    # ins_size=9
    sget-object v0, Lkotlinx/coroutines/CoroutineExceptionHandler;->Key Lkotlinx/coroutines/CoroutineExceptionHandler$Key;
    new-instance v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$$inlined$CoroutineExceptionHandler$1;
    move-object v12, v14
    move-object/from16 v7, v18
    move-object/from16 v10, v20
    invoke-direct v1, v0, v10, v14, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$$inlined$CoroutineExceptionHandler$1;-><init>(Lkotlinx/coroutines/CoroutineExceptionHandler$Key; Lkotlin/jvm/functions/Function3; Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/lang/String;)V
    check-cast v1, Lkotlinx/coroutines/CoroutineExceptionHandler;
    move-object v0, v1
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    const/4 v1, 0
    new-instance v13, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;
    const/4 v11, 0
    move-object v2, v13
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v5, v16
    move-object/from16 v6, v17
    move-wide/from16 v8, v21
    invoke-direct/range v2 ... v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; J Lkotlin/jvm/functions/Function3; Lkotlin/coroutines/Continuation;)V
    move-object v2, v13
    check-cast v2, Lkotlin/jvm/functions/Function2;
    const/4 v3, 2
    const/4 v4, 0
    move-object/from16 v15, v19
    move-object/from16 v16, v0
    move-object/from16 v17, v1
    move-object/from16 v18, v2
    move/from16 v19, v3
    move-object/from16 v20, v4
    invoke-static/range v15 ... v20, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final copyToExternalDownload(android.content.Context  java.io.File  java.lang.String  java.lang.String)java.lang.String
    .registers 15
    # ins_size=5
    const/16 v0, 47
    const/4 v1, 0
    const/4 v2, 2
    invoke-static v13, v0, v1, v2, v1, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    move-object v3, v14
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v3
    if-nez v3, +019h
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v3, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    const/16 v3, 95
    invoke-virtual v14, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v6, v0
    const/16 v14, 46
    const-string v0, ""
    invoke-static v13, v14, v0, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    sget-object v14, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v13, v14, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v7
    const-string/jumbo v13, toLowerCase(...)
    invoke-static v7, v13, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v10, v6, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getMimeType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    const-string v13, "image/"
    const/4 v14, 0
    invoke-static v8, v13, v14, v2, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v9
    sget v13, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v14, 29
    if-lt v13, v14, +00ch
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    move-object v7, v8
    move v8, v9
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->copyToExternalViaMediaStore(Landroid/content/Context; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; Z)Ljava/lang/String;
    move-result-object v11
    goto +8h
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->copyToExternalViaFileApi(Landroid/content/Context; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z)Ljava/lang/String;
    move-result-object v11
    return-object v11
.end method

.method private final copyToExternalViaFileApi(android.content.Context  java.io.File  java.lang.String  java.lang.String  java.lang.String  boolean)java.lang.String
    .registers 25
    # ins_size=7
    move-object/from16 v1, v18
    move-object/from16 v0, v21
    move-object/from16 v2, v22
    move/from16 v3, v24
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getExternalTargetDir(Z)Ljava/io/File;
    move-result-object v4
    invoke-virtual v4, Ljava/io/File;->mkdirs()Z
    new-instance v5, Ljava/io/File;
    invoke-direct v5, v4, v0, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v5, Ljava/io/File;->exists()Z
    move-result v6
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 1
    if-eqz v6, +06eh
    move-object v6, v2
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-lez v5, +004h
    move v5, v9
    goto +2h
    move v5, v8
    if-eqz v5, +009h
    const/16 v5, 46
    const/4 v10, 2
    invoke-static v0, v5, v7, v10, v7, Lkotlin/text/StringsKt;->substringBeforeLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    move v5, v9
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v10
    if-lez v10, +004h
    move v10, v9
    goto +2h
    move v10, v8
    const/16 v11, 40
    if-eqz v10, +022h
    new-instance v10, Ljava/lang/StringBuilder;
    invoke-direct v10, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v10, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ")."
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    goto +1ch
    new-instance v10, Ljava/lang/StringBuilder;
    invoke-direct v10, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v10, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v10
    const/16 v11, 41
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    new-instance v11, Ljava/io/File;
    invoke-direct v11, v4, v10, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    add-int/lit8 v5, v5, 1
    invoke-virtual v11, Ljava/io/File;->exists()Z
    move-result v10
    if-nez v10, -053h
    move-object v5, v11
    const/4 v14, 1
    const/4 v15, 0
    const/16 v16, 4
    const/16 v17, 0
    move-object/from16 v12, v20
    move-object v13, v5
    invoke-static/range v12 ... v17, Lkotlin/io/FilesKt;->copyTo$default(Ljava/io/File; Ljava/io/File; Z I I Ljava/lang/Object;)Ljava/io/File;
    if-eqz v3, +013h
    new-array v0, v9, [Ljava/lang/String;
    invoke-virtual v5, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v2
    aput-object v2, v0, v8
    new-array v2, v9, [Ljava/lang/String;
    aput-object v23, v2, v8
    move-object/from16 v3, v19
    invoke-static v3, v0, v2, v7, Landroid/media/MediaScannerConnection;->scanFile(Landroid/content/Context; [Ljava/lang/String; [Ljava/lang/String; Landroid/media/MediaScannerConnection$OnScanCompletedListener;)V
    invoke-virtual v5, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v7
    goto +dh
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    const-string v4, "copyToExternalViaFileApi failed"
    check-cast v0, Ljava/lang/Throwable;
    invoke-virtual v2, v3, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-object v7
    :try_start_0x92
.end method

.method private final copyToExternalViaMediaStore(android.content.Context  java.io.File  java.lang.String  java.lang.String  boolean)java.lang.String
    .registers 22
    # ins_size=6
    move-object/from16 v1, v16
    move/from16 v0, v21
    const-string v2, "Failed to clear IS_PENDING for "
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getExternalRelativePath(Z)Ljava/lang/String;
    move-result-object v3
    if-eqz v0, +005h
    sget-object v0, Landroid/provider/MediaStore$Images$Media;->EXTERNAL_CONTENT_URI Landroid/net/Uri;
    goto +3h
    sget-object v0, Landroid/provider/MediaStore$Downloads;->EXTERNAL_CONTENT_URI Landroid/net/Uri;
    new-instance v4, Landroid/content/ContentValues;
    invoke-direct v4, Landroid/content/ContentValues;-><init>()V
    const-string v5, "_display_name"
    move-object/from16 v6, v19
    invoke-virtual v4, v5, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v7, "mime_type"
    move-object/from16 v8, v20
    invoke-virtual v4, v7, v8, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v7, "relative_path"
    invoke-virtual v4, v7, v3, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v7, 1
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    const-string v8, "is_pending"
    invoke-virtual v4, v8, v7, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/Integer;)V
    invoke-virtual/range v17, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v7
    invoke-virtual v7, v0, v4, Landroid/content/ContentResolver;->insert(Landroid/net/Uri; Landroid/content/ContentValues;)Landroid/net/Uri;
    move-result-object v4
    const/4 v15, 0
    if-nez v4, +003h
    return-object v15
    invoke-virtual v7, v4, Landroid/content/ContentResolver;->openOutputStream(Landroid/net/Uri;)Ljava/io/OutputStream;
    move-result-object v0
    const/4 v14, 0
    if-eqz v0, +037h
    move-object v9, v0
    check-cast v9, Ljava/io/Closeable;
    move-object v0, v9
    check-cast v0, Ljava/io/OutputStream;
    new-instance v10, Ljava/io/FileInputStream;
    move-object/from16 v11, v18
    invoke-direct v10, v11, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    check-cast v10, Ljava/io/Closeable;
    move-object v11, v10
    check-cast v11, Ljava/io/FileInputStream;
    check-cast v11, Ljava/io/InputStream;
    const/4 v12, 2
    invoke-static v11, v0, v14, v12, v15, Lkotlin/io/ByteStreamsKt;->copyTo$default(Ljava/io/InputStream; Ljava/io/OutputStream; I I Ljava/lang/Object;)J
    move-result-wide v11
    invoke-static v10, v15, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    invoke-static v11, v12, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    invoke-static v9, v15, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +13h
    move-exception v0
    move-object v2, v0
    throw v2
    move-exception v0
    move-object v3, v0
    invoke-static v10, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v3
    move-exception v0
    move-object v2, v0
    throw v2
    move-exception v0
    move-object v3, v0
    invoke-static v9, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v3
    new-instance v0, Landroid/content/ContentValues;
    invoke-direct v0, Landroid/content/ContentValues;-><init>()V
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-virtual v0, v8, v9, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/Integer;)V
    invoke-virtual v7, v4, v0, v15, v15, Landroid/content/ContentResolver;->update(Landroid/net/Uri; Landroid/content/ContentValues; Ljava/lang/String; [Ljava/lang/String;)I
    move-result v0
    if-nez v0, +020h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", deleting entry"
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v7, v4, v15, v15, Landroid/content/ContentResolver;->delete(Landroid/net/Uri; Ljava/lang/String; [Ljava/lang/String;)I
    return-object v15
    filled-new-array v5, [Ljava/lang/String;
    move-result-object v11
    const/4 v12, 0
    const/4 v13, 0
    const/4 v0, 0
    move-object v9, v7
    move-object v10, v4
    move v2, v14
    move-object v14, v0
    invoke-virtual/range v9 ... v14, Landroid/content/ContentResolver;->query(Landroid/net/Uri; [Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String; Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v0
    if-eqz v0, +023h
    move-object v5, v0
    check-cast v5, Ljava/io/Closeable;
    move-object v0, v5
    check-cast v0, Landroid/database/Cursor;
    invoke-interface v0, Landroid/database/Cursor;->moveToFirst()Z
    move-result v8
    if-eqz v8, +007h
    invoke-interface v0, v2, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v15
    invoke-static v5, v15, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    if-eqz v0, +00ch
    goto +bh
    move-exception v0
    move-object v2, v0
    throw v2
    move-exception v0
    move-object v3, v0
    invoke-static v5, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v3
    move-object v0, v6
    invoke-direct v1, v3, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->buildDisplayPath(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v15
    goto +1eh
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    const-string v5, "copyToExternalViaMediaStore failed"
    check-cast v0, Ljava/lang/Throwable;
    invoke-virtual v2, v3, v5, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-virtual v7, v4, v15, v15, Landroid/content/ContentResolver;->delete(Landroid/net/Uri; Ljava/lang/String; [Ljava/lang/String;)I
    goto +eh
    move-exception v0
    move-object v2, v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    const-string v4, "Failed to clean up MediaStore entry"
    check-cast v2, Ljava/lang/Throwable;
    invoke-virtual v0, v3, v4, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-object v15
    :try_start_0x3f
    :try_start_0x49
    :try_start_0x55
    :try_start_0x5f
    :try_start_0x65
    :try_start_0x6b
    :try_start_0x6e
    :try_start_0x74
    :try_start_0x77
    :try_start_0xbf
    :try_start_0xce
    :try_start_0xd6
    :try_start_0xd9
    :try_start_0xef
.end method

.method private final downloadFile(android.content.Context  java.lang.String  java.lang.String  java.lang.String  boolean  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 30
    # ins_size=9
    move-object/from16 v1, v21
    move-object/from16 v0, v22
    move-object/from16 v2, v24
    move-object/from16 v3, v25
    move-wide/from16 v4, v27
    move-object/from16 v6, v29
    instance-of v7, v6, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;
    if-eqz v7, +012h
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;
    iget v8, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->label I
    const/high16 v9, -2147483648
    and-int/2addr v8, v9
    if-eqz v8, +008h
    iget v6, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->label I
    sub-int/2addr v6, v9
    iput v6, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->label I
    goto +6h
    new-instance v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;
    invoke-direct v7, v1, v6, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Lkotlin/coroutines/Continuation;)V
    iget-object v6, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v8
    iget v9, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->label I
    const/4 v10, 1
    const-string v11, ""
    const-wide/16 v13, 0
    if-eqz v9, +033h
    if-ne v9, v10, +029h
    iget-wide v2, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->J$0 J
    iget-boolean v0, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->Z$0 Z
    iget-object v4, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->L$6 Ljava/lang/Object;
    check-cast v4, Ljava/io/File;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->L$5 Ljava/lang/Object;
    check-cast v5, Ljava/io/File;
    iget-object v8, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->L$4 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v9, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->L$3 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v10, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->L$2 Ljava/lang/Object;
    check-cast v10, Ljava/lang/String;
    iget-object v15, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->L$1 Ljava/lang/Object;
    check-cast v15, Landroid/content/Context;
    iget-object v7, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v19, v11
    goto/16 +16eh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-direct v1, v0, v3, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getExternalFilePath(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +028h
    cmp-long v9, v4, v13
    if-gtz v9, +024h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "downloadFile: no createTime, existing file found="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lkotlin/Pair;
    iget v2, v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_SUCCESS I
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-direct v0, v2, v6, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v0
    invoke-direct v1, v0, v2, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getCacheFilePath(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Ljava/io/File;
    move-result-object v9
    sget-object v15, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v14, Ljava/lang/StringBuilder;
    const-string v10, "downloadFile: cacheFile="
    invoke-direct v14, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v12, " exists="
    invoke-virtual v14, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v9, Ljava/io/File;->exists()Z
    move-result v14
    invoke-virtual v12, v14, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v12
    const-string v14, " length="
    invoke-virtual v12, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v9, Ljava/io/File;->length()J
    move-result-wide v2
    invoke-virtual v12, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 32
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v15, v13, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v9, Lkotlin/io/FilesKt;->getNameWithoutExtension(Ljava/io/File;)Ljava/lang/String;
    move-result-object v2
    new-instance v12, Ljava/lang/StringBuilder;
    invoke-direct v12, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v12, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v12, "_time.txt"
    invoke-virtual v2, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    new-instance v12, Ljava/io/File;
    invoke-virtual v9, Ljava/io/File;->getParent()Ljava/lang/String;
    move-result-object v13
    invoke-direct v12, v13, v2, Ljava/io/File;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v12, Ljava/io/File;->exists()Z
    move-result v2
    if-eqz v2, +019h
    invoke-virtual v12, Ljava/io/File;->isFile()Z
    move-result v2
    if-eqz v2, +013h
    const/4 v2, 1
    const/4 v13, 0
    invoke-static v12, v13, v2, v13, Lkotlin/io/FilesKt;->readText$default(Ljava/io/File; Ljava/nio/charset/Charset; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v14
    check-cast v14, Ljava/lang/CharSequence;
    invoke-static v14, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v11
    invoke-static v2, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v2
    if-eqz v2, +008h
    invoke-virtual v2, Ljava/lang/Long;->longValue()J
    move-result-wide v13
    goto +4h
    const/4 v12, 0
    const-wide/16 v13, 0
    invoke-virtual v9, Ljava/io/File;->getParentFile()Ljava/io/File;
    move-result-object v2
    if-eqz v2, +009h
    invoke-virtual v2, Ljava/io/File;->mkdirs()Z
    move-result v2
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    invoke-virtual v9, Ljava/io/File;->exists()Z
    move-result v2
    if-eqz v2, +00bh
    invoke-virtual v9, Ljava/io/File;->isFile()Z
    move-result v2
    if-nez v2, +005h
    invoke-static v9, Lkotlin/io/FilesKt;->deleteRecursively(Ljava/io/File;)Z
    invoke-virtual v9, Ljava/io/File;->exists()Z
    move-result v2
    if-eqz v2, +017h
    invoke-virtual v9, Ljava/io/File;->length()J
    move-result-wide v18
    const-wide/16 v15, 0
    cmp-long v2, v18, v15
    if-eqz v2, +00dh
    cmp-long v2, v4, v15
    if-lez v2, +007h
    cmp-long v2, v4, v13
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    sget-object v15, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    move-object/from16 v19, v11
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-direct v11, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v10
    const/16 v11, 32
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v13, v14, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v15, v3, v10, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v2, +0b8h
    invoke-virtual v9, Ljava/io/File;->exists()Z
    move-result v2
    if-eqz v2, +005h
    invoke-virtual v9, Ljava/io/File;->delete()Z
    invoke-virtual v9, Ljava/io/File;->getParentFile()Ljava/io/File;
    move-result-object v2
    if-eqz v2, +009h
    invoke-virtual v2, Ljava/io/File;->mkdirs()Z
    move-result v2
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    iput-object v1, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->L$0 Ljava/lang/Object;
    iput-object v0, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->L$1 Ljava/lang/Object;
    move-object/from16 v2, v24
    iput-object v2, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->L$2 Ljava/lang/Object;
    move-object/from16 v3, v25
    iput-object v3, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->L$3 Ljava/lang/Object;
    iput-object v6, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->L$4 Ljava/lang/Object;
    iput-object v9, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->L$5 Ljava/lang/Object;
    iput-object v12, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->L$6 Ljava/lang/Object;
    move/from16 v10, v26
    iput-boolean v10, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->Z$0 Z
    iput-wide v4, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->J$0 J
    const/4 v11, 1
    iput v11, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadFile$1;->label I
    move-object/from16 v11, v23
    invoke-direct v1, v0, v11, v9, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFile(Landroid/content/Context; Ljava/lang/String; Ljava/io/File; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v8, +003h
    return-object v8
    move-object v15, v0
    move-object v8, v6
    move-object v6, v7
    move v0, v10
    move-object v7, v1
    move-object v10, v2
    move-object/from16 v20, v9
    move-object v9, v3
    move-wide v2, v4
    move-object/from16 v5, v20
    move-object v4, v12
    check-cast v6, Lcom/bytedance/trae/conversation/products/SaveFileResult;
    instance-of v6, v6, Lcom/bytedance/trae/conversation/products/SaveFileResult$Failure;
    if-eqz v6, +010h
    new-instance v0, Lkotlin/Pair;
    iget v2, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_FAILED_DOWNLOAD I
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v2
    move-object/from16 v11, v19
    invoke-direct v0, v2, v11, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v0
    move-object/from16 v11, v19
    invoke-virtual v5, Ljava/io/File;->exists()Z
    move-result v6
    if-eqz v6, +01eh
    invoke-virtual v5, Ljava/io/File;->length()J
    move-result-wide v12
    const-wide/16 v16, 0
    cmp-long v6, v12, v16
    if-nez v6, +003h
    goto +12h
    cmp-long v6, v2, v16
    if-lez v6, +00dh
    if-eqz v4, +00bh
    invoke-static v2, v3, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v2
    const/4 v3, 2
    const/4 v6, 0
    invoke-static v4, v2, v6, v3, v6, Lkotlin/io/FilesKt;->writeText$default(Ljava/io/File; Ljava/lang/String; Ljava/nio/charset/Charset; I Ljava/lang/Object;)V
    move-object v6, v8
    goto +46h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "downloadFile: file still invalid after download, exists="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Ljava/io/File;->exists()Z
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", length="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v5, Ljava/io/File;->length()J
    move-result-wide v8
    invoke-virtual v3, v8, v9, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v5, Ljava/io/File;->delete()Z
    new-instance v0, Lkotlin/Pair;
    iget v2, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_FAILED_DOWNLOAD I
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-direct v0, v2, v11, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v0
    move-object/from16 v2, v24
    move-object/from16 v3, v25
    move/from16 v10, v26
    move-object/from16 v11, v19
    move-object v15, v0
    move-object v7, v1
    move-object v5, v9
    move v0, v10
    move-object v10, v2
    move-object v9, v3
    if-eqz v0, +024h
    invoke-static v5, Lkotlin/io/FilesKt;->readBytes(Ljava/io/File;)[B
    move-result-object v0
    invoke-static v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->decodeContent([B)[B
    move-result-object v0
    invoke-static v5, v0, Lkotlin/io/FilesKt;->writeBytes(Ljava/io/File; [B)V
    goto +17h
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    const-string v4, "decode failed"
    invoke-virtual v2, v3, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    new-instance v0, Lkotlin/Pair;
    iget v2, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_FAILED_DOWNLOAD I
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-direct v0, v2, v11, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v0
    if-eqz v6, +005h
    invoke-direct v7, v15, v9, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->removeExternalFile(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v7, v15, v5, v9, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->copyToExternalDownload(Landroid/content/Context; Ljava/io/File; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v6, "downloadFile: copyToExternalDownload result="
    invoke-direct v4, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", cacheFile="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v5, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", cacheExists="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v5, Ljava/io/File;->exists()Z
    move-result v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", cacheSize="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v5, Ljava/io/File;->length()J
    move-result-wide v5
    invoke-virtual v4, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v3, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v0, +00eh
    new-instance v2, Lkotlin/Pair;
    iget v3, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_SUCCESS I
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-direct v2, v3, v0, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    goto +22h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "downloadFile: copyToExternalDownload failed for path="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v2, Lkotlin/Pair;
    iget v0, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_FAILED_DOWNLOAD I
    invoke-static v0, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-direct v2, v0, v11, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v2
    :try_start_0xdc
    :try_start_0xfc
    :try_start_0x1f6
    :try_start_0x248
.end method

.method private static final downloadFinishBlk$lambda$0(com.bytedance.trae.conversation.products.FileDownloadHelper  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string v0, "data"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadingDatas Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, v3, Ljava/util/List;->remove(Ljava/lang/Object;)Z
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadingDatas Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->cancelUpdateLoadingJob(Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method public static synthetic downloadToCache$default(com.bytedance.trae.conversation.products.FileDownloadHelper  android.content.Context  java.lang.String  java.lang.String  java.lang.String  boolean  long  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 21
    # ins_size=11
    and-int/lit8 v0, v19, 16
    if-eqz v0, +005h
    const/4 v0, 0
    move v6, v0
    goto +2h
    move v6, v15
    and-int/lit8 v0, v19, 32
    if-eqz v0, +006h
    const-wide/16 v0, 0
    move-wide v7, v0
    goto +3h
    move-wide/from16 v7, v16
    move-object v1, v10
    move-object v2, v11
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object/from16 v9, v18
    invoke-virtual/range v1 ... v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadToCache(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic downloadToCacheWithResult$conversation_mainlandRelease$default(com.bytedance.trae.conversation.products.FileDownloadHelper  android.content.Context  java.lang.String  java.lang.String  java.lang.String  boolean  long  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 21
    # ins_size=11
    and-int/lit8 v0, v19, 16
    if-eqz v0, +005h
    const/4 v0, 0
    move v6, v0
    goto +2h
    move v6, v15
    and-int/lit8 v0, v19, 32
    if-eqz v0, +006h
    const-wide/16 v0, 0
    move-wide v7, v0
    goto +3h
    move-wide/from16 v7, v16
    move-object v1, v10
    move-object v2, v11
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object/from16 v9, v18
    invoke-virtual/range v1 ... v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadToCacheWithResult$conversation_mainlandRelease(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final getCacheFilePath(android.content.Context  java.lang.String  java.lang.String)java.io.File
    .registers 16
    # ins_size=4
    const-string v0, "MD5"
    invoke-static v0, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;
    move-result-object v0
    sget-object v1, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-virtual v15, v1, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B
    move-result-object v1
    const-string v2, "getBytes(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Ljava/security/MessageDigest;->digest([B)[B
    move-result-object v3
    const-string v0, "digest(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, ""
    move-object v4, v0
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda1;
    invoke-direct v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda1;-><init>()V
    const/16 v10, 30
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lkotlin/collections/ArraysKt;->joinToString$default([B Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    const/16 v2, 46
    invoke-static v15, v2, v0, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v15
    move-object v0, v15
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +017h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v15
    invoke-virtual v15, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    new-instance v15, Ljava/io/File;
    new-instance v0, Ljava/io/File;
    invoke-virtual v13, Landroid/content/Context;->getCacheDir()Ljava/io/File;
    move-result-object v13
    invoke-direct v0, v13, v14, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-direct v15, v0, v1, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v15, Ljava/io/File;->getParentFile()Ljava/io/File;
    move-result-object v13
    if-eqz v13, +005h
    invoke-virtual v13, Ljava/io/File;->mkdirs()Z
    return-object v15
.end method

.method private static final getCacheFilePath$lambda$18(byte)java.lang.CharSequence
    .registers 4
    # ins_size=1
    const/4 v0, 1
    new-array v1, v0, [Ljava/lang/Object;
    const/4 v2, 0
    invoke-static v3, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;
    move-result-object v3
    aput-object v3, v1, v2
    invoke-static v1, v0, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v3
    const-string v0, "%02x"
    invoke-static v0, v3, Ljava/lang/String;->format(Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    const-string v0, "format(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    return-object v3
.end method

.method private final getExternalFilePath(android.content.Context  java.lang.String  java.lang.String)java.lang.String
    .registers 22
    # ins_size=4
    move-object/from16 v1, v18
    move-object/from16 v0, v21
    const/16 v2, 47
    const/4 v3, 0
    const/4 v4, 2
    move-object/from16 v5, v20
    invoke-static v5, v2, v3, v4, v3, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    move-object v6, v0
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v6
    if-nez v6, +019h
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v6, 95
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getMimeType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    const-string v6, "image/"
    const/4 v7, 0
    invoke-static v0, v6, v7, v4, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getExternalRelativePath(Z)Ljava/lang/String;
    move-result-object v6
    sget v8, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v9, 29
    const-wide/16 v10, 0
    if-lt v8, v9, +077h
    if-eqz v0, +005h
    sget-object v0, Landroid/provider/MediaStore$Images$Media;->EXTERNAL_CONTENT_URI Landroid/net/Uri;
    goto +3h
    sget-object v0, Landroid/provider/MediaStore$Downloads;->EXTERNAL_CONTENT_URI Landroid/net/Uri;
    move-object v13, v0
    const-string v0, "_id"
    const-string v8, "_display_name"
    const-string v9, "_size"
    filled-new-array v0, v8, v9, [Ljava/lang/String;
    move-result-object v14
    const-string v15, "_display_name = ? AND relative_path = ?"
    new-array v0, v4, [Ljava/lang/String;
    aput-object v5, v0, v7
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const/4 v4, 1
    aput-object v2, v0, v4
    invoke-virtual/range v19, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v12
    const/16 v17, 0
    move-object/from16 v16, v0
    invoke-virtual/range v12 ... v17, Landroid/content/ContentResolver;->query(Landroid/net/Uri; [Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String; Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v0
    if-eqz v0, +03ch
    move-object v2, v0
    check-cast v2, Ljava/io/Closeable;
    move-object v0, v2
    check-cast v0, Landroid/database/Cursor;
    invoke-interface v0, Landroid/database/Cursor;->moveToFirst()Z
    move-result v4
    if-eqz v4, +021h
    invoke-interface v0, v9, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v4
    invoke-interface v0, v4, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v4
    invoke-interface v0, v8, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v7
    invoke-interface v0, v7, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v0
    cmp-long v4, v4, v10
    if-lez v4, +00dh
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v1, v6, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->buildDisplayPath(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-static v2, v3, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v2, v3, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +ah
    move-exception v0
    move-object v3, v0
    throw v3
    move-exception v0
    move-object v4, v0
    invoke-static v2, v3, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v4
    return-object v3
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getExternalTargetDir(Z)Ljava/io/File;
    move-result-object v0
    new-instance v2, Ljava/io/File;
    invoke-direct v2, v0, v5, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v2, Ljava/io/File;->exists()Z
    move-result v0
    if-eqz v0, +014h
    invoke-virtual v2, Ljava/io/File;->isFile()Z
    move-result v0
    if-eqz v0, +00eh
    invoke-virtual v2, Ljava/io/File;->length()J
    move-result-wide v4
    cmp-long v0, v4, v10
    if-lez v0, +006h
    invoke-virtual v2, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v3
    return-object v3
    :try_start_0x82
    :try_start_0xaa
    :try_start_0xb2
.end method

.method static synthetic getExternalFilePath$default(com.bytedance.trae.conversation.products.FileDownloadHelper  android.content.Context  java.lang.String  java.lang.String  int  java.lang.Object)java.lang.String
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    const-string v3, ""
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getExternalFilePath(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final getExternalRelativePath(boolean)java.lang.String
    .registers 4
    # ins_size=2
    const-string/jumbo v0, trae
    if-eqz v3, +01ch
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    sget-object v1, Landroid/os/Environment;->DIRECTORY_PICTURES Ljava/lang/String;
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    sget-object v1, Ljava/io/File;->separator Ljava/lang/String;
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    goto +26h
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    sget-object v1, Landroid/os/Environment;->DIRECTORY_DOWNLOADS Ljava/lang/String;
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    sget-object v1, Ljava/io/File;->separator Ljava/lang/String;
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v1, "Android"
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    sget-object v1, Ljava/io/File;->separator Ljava/lang/String;
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final getExternalTargetDir(boolean)java.io.File
    .registers 6
    # ins_size=2
    const-string/jumbo v0, trae
    if-eqz v5, +00eh
    new-instance v5, Ljava/io/File;
    sget-object v1, Landroid/os/Environment;->DIRECTORY_PICTURES Ljava/lang/String;
    invoke-static v1, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;
    move-result-object v1
    invoke-direct v5, v1, v0, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    goto +21h
    new-instance v5, Ljava/io/File;
    sget-object v1, Landroid/os/Environment;->DIRECTORY_DOWNLOADS Ljava/lang/String;
    invoke-static v1, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;
    move-result-object v1
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "Android"
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-object v3, Ljava/io/File;->separator Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v5, v1, v0, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    return-object v5
.end method

.method private final getMimeType(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    const/16 v0, 46
    const-string v1, ""
    invoke-static v3, v0, v1, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v3, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Landroid/webkit/MimeTypeMap;->getSingleton()Landroid/webkit/MimeTypeMap;
    move-result-object v0
    invoke-virtual v0, v3, Landroid/webkit/MimeTypeMap;->getMimeTypeFromExtension(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-nez v1, +003h
    return-object v0
    invoke-virtual v3, Ljava/lang/String;->hashCode()I
    move-result v0
    sparse-switch v0, +000004eh
    goto +48h
    const-string v0, "heif"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +041h
    goto +ah
    const-string v0, "heic"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +36h
    const-string v3, "image/heic"
    goto +35h
    const-string v0, "flac"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +2ah
    const-string v3, "audio/flac"
    goto +29h
    const-string v0, "mkv"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +1eh
    const-string/jumbo v3, video/x-matroska
    goto +1ch
    const-string v0, "md"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +11h
    const-string/jumbo v3, text/markdown
    goto +fh
    const-string v0, "7z"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +4h
    const-string v3, "application/x-7z-compressed"
    goto +3h
    const-string v3, "application/octet-stream"
    return-object v3
    sparse-switch-payload 723 d97 1a698 2fff68 30ced7 30ceda
.end method

.method private final removeExternalFile(android.content.Context  java.lang.String  java.lang.String)void
    .registers 12
    # ins_size=4
    const-string/jumbo v0, removeExternalFile: MediaStore deleted 
    const-string/jumbo v1, removeExternalFile: File.delete=
    const/16 v2, 47
    const/4 v3, 0
    const/4 v4, 2
    invoke-static v10, v2, v3, v4, v3, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    move-object v5, v11
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v5
    if-nez v5, +019h
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v5, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const/16 v5, 95
    invoke-virtual v11, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-direct v8, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getMimeType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    const-string v5, "image/"
    const/4 v6, 0
    invoke-static v11, v5, v6, v4, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v11
    invoke-direct v8, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getExternalRelativePath(Z)Ljava/lang/String;
    move-result-object v3
    sget v5, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v7, 29
    if-lt v5, v7, +04ah
    if-eqz v11, +005h
    sget-object v11, Landroid/provider/MediaStore$Images$Media;->EXTERNAL_CONTENT_URI Landroid/net/Uri;
    goto +3h
    sget-object v11, Landroid/provider/MediaStore$Downloads;->EXTERNAL_CONTENT_URI Landroid/net/Uri;
    const-string v1, "_display_name = ? AND relative_path = ?"
    new-array v4, v4, [Ljava/lang/String;
    aput-object v10, v4, v6
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 1
    aput-object v2, v4, v3
    invoke-virtual v9, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v9
    invoke-virtual v9, v11, v1, v4, Landroid/content/ContentResolver;->delete(Landroid/net/Uri; Ljava/lang/String; [Ljava/lang/String;)I
    move-result v9
    sget-object v11, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v0, " rows for "
    invoke-virtual v9, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v11, v1, v9, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +51h
    invoke-direct v8, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getExternalTargetDir(Z)Ljava/io/File;
    move-result-object v9
    new-instance v11, Ljava/io/File;
    invoke-direct v11, v9, v10, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v11, Ljava/io/File;->exists()Z
    move-result v9
    if-eqz v9, +043h
    invoke-virtual v11, Ljava/io/File;->delete()Z
    move-result v9
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v1, " for "
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v11, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v0, v2, v9, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +1bh
    move-exception v9
    sget-object v11, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v0, v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, removeExternalFile failed for 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    check-cast v9, Ljava/lang/Throwable;
    invoke-virtual v11, v0, v10, v9, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x3d
.end method

.method static synthetic removeExternalFile$default(com.bytedance.trae.conversation.products.FileDownloadHelper  android.content.Context  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    const-string v3, ""
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->removeExternalFile(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final resumeDownloadContinuation(int  com.bytedance.trae.conversation.products.SaveFileResult)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadContinuationMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lkotlinx/coroutines/CancellableContinuation;
    if-nez v2, +003h
    return-void 
    invoke-interface v2, Lkotlinx/coroutines/CancellableContinuation;->isActive()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    check-cast v2, Lkotlin/coroutines/Continuation;
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-interface v2, v3, Lkotlin/coroutines/Continuation;->resumeWith(Ljava/lang/Object;)V
    return-void 
.end method

.method private final saveFile(android.content.Context  java.lang.String  java.io.File  kotlin.coroutines.Continuation)java.lang.Object
    .registers 13
    # ins_size=5
    new-instance v0, Lkotlinx/coroutines/CancellableContinuationImpl;
    invoke-static v12, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->intercepted(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lkotlinx/coroutines/CancellableContinuationImpl;-><init>(Lkotlin/coroutines/Continuation; I)V
    invoke-virtual v0, Lkotlinx/coroutines/CancellableContinuationImpl;->initCancellability()V
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CancellableContinuation;
    new-instance v3, Lkotlin/jvm/internal/Ref$IntRef;
    invoke-direct v3, Lkotlin/jvm/internal/Ref$IntRef;-><init>()V
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-static v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getTAG$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)Ljava/lang/String;
    move-result-object v5
    new-instance v6, Ljava/lang/StringBuilder;
    const-string/jumbo v7, saveFile: url=
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-object v7, Lcom/bytedance/trae/conversation/products/DownloadUrlLogSanitizer;->INSTANCE Lcom/bytedance/trae/conversation/products/DownloadUrlLogSanitizer;
    invoke-virtual v7, v10, Lcom/bytedance/trae/conversation/products/DownloadUrlLogSanitizer;->redactSensitiveQueryParams(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", dir="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v11, Ljava/io/File;->getParent()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", name="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v11, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v5, v6, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v4, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;
    invoke-direct v4, v8, v3, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Lkotlin/jvm/internal/Ref$IntRef; Ljava/io/File;)V
    invoke-static v9, Lcom/ss/android/socialbase/downloader/downloader/Downloader;->with(Landroid/content/Context;)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v5
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v6
    invoke-virtual v6, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->taskKey(Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v5
    const/4 v6, 3
    invoke-virtual v5, v6, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->retryCount(I)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v5
    invoke-virtual v5, v2, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->autoSetHashCodeForSameTask(Z)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v2
    invoke-virtual v2, v10, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->url(Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v10
    invoke-virtual v11, Ljava/io/File;->getParent()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +00ah
    invoke-virtual v9, Landroid/content/Context;->getCacheDir()Ljava/io/File;
    move-result-object v2
    invoke-virtual v2, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v10, v2, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->savePath(Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v10
    invoke-virtual v11, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v10, v2, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->name(Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v10
    check-cast v4, Lcom/ss/android/socialbase/downloader/depend/IDownloadListener;
    invoke-virtual v10, v4, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->subThreadListener(Lcom/ss/android/socialbase/downloader/depend/IDownloadListener;)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v10
    invoke-virtual v10, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->getDownloadId()I
    move-result v2
    iput v2, v3, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-static v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getDownloadContinuationMap$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v2
    check-cast v2, Ljava/util/Map;
    iget v4, v3, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-static v4, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v2, v4, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$1;
    invoke-direct v2, v8, v3, v11, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$1;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Lkotlin/jvm/internal/Ref$IntRef; Ljava/io/File; Landroid/content/Context;)V
    check-cast v2, Lkotlin/jvm/functions/Function1;
    invoke-interface v1, v2, Lkotlinx/coroutines/CancellableContinuation;->invokeOnCancellation(Lkotlin/jvm/functions/Function1;)V
    const/4 v9, 0
    invoke-virtual v10, v9, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->asyncDownload(Lcom/ss/android/socialbase/downloader/downloader/IDownloadStartCallback;)V
    invoke-virtual v0, Lkotlinx/coroutines/CancellableContinuationImpl;->getResult()Ljava/lang/Object;
    move-result-object v9
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v10
    if-ne v9, v10, +005h
    invoke-static v12, Lkotlin/coroutines/jvm/internal/DebugProbesKt;->probeCoroutineSuspended(Lkotlin/coroutines/Continuation;)V
    return-object v9
.end method

.method public static synthetic saveFileAndLoading$default(com.bytedance.trae.conversation.products.FileDownloadHelper  android.content.Context  java.lang.String  java.lang.String  java.lang.String  kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function3  boolean  long  int  java.lang.Object)void
    .registers 24
    # ins_size=12
    move/from16 v0, v22
    and-int/lit8 v1, v0, 64
    if-eqz v1, +005h
    const/4 v1, 0
    move v9, v1
    goto +3h
    move/from16 v9, v19
    and-int/lit16 v0, v0, 128
    if-eqz v0, +006h
    const-wide/16 v0, 0
    move-wide v10, v0
    goto +3h
    move-wide/from16 v10, v20
    move-object v2, v12
    move-object v3, v13
    move-object v4, v14
    move-object v5, v15
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    move-object/from16 v8, v18
    invoke-virtual/range v2 ... v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFileAndLoading(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J)V
    return-void 
.end method

.method private static final saveFileAndLoading$lambda$2(com.bytedance.trae.conversation.products.FileDownloadHelper  java.lang.String  java.lang.Throwable)kotlin.Unit
    .registers 7
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "invokeOnCompletion: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v2, " with path "
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v1, v6, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v4, v4, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->uploadLoadingJobMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v4, v5, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private static final saveFileAndLoading$lambda$5(androidx.fragment.app.FragmentActivity  com.bytedance.trae.conversation.products.FileDownloadHelper  java.lang.String  java.lang.String  java.lang.String  kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function3  boolean  long)kotlin.Unit
    .registers 23
    # ins_size=10
    const-string v0, "android.permission.READ_EXTERNAL_STORAGE"
    const-string v1, "android.permission.WRITE_EXTERNAL_STORAGE"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/products/PermissionService;->INSTANCE Lcom/bytedance/trae/conversation/products/PermissionService;
    new-instance v12, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;
    move-object v2, v12
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v5, v16
    move-object/from16 v6, v17
    move-object/from16 v7, v18
    move-object/from16 v8, v19
    move/from16 v9, v20
    move-wide/from16 v10, v21
    invoke-direct/range v2 ... v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J)V
    move-object v2, v13
    invoke-virtual v1, v13, v0, v12, Lcom/bytedance/trae/conversation/products/PermissionService;->permission(Landroidx/fragment/app/FragmentActivity; Ljava/util/List; Lkotlin/jvm/functions/Function1;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final saveFileAndLoading$lambda$5$lambda$4(com.bytedance.trae.conversation.products.FileDownloadHelper  java.lang.String  java.lang.String  java.lang.String  kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function3  boolean  long  boolean)kotlin.Unit
    .registers 20
    # ins_size=10
    move-object v0, v10
    move-object v6, v15
    if-eqz v19, +01fh
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-virtual v1, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;
    move-result-object v1
    const-string v2, "getApplicationContext(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v10
    move-object v2, v11
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object v6, v15
    move/from16 v7, v16
    move-wide/from16 v8, v17
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFileAndLoadingInternal(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J)V
    goto +23h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "Music Edit Error"
    const-string v3, "no permission"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v6, +013h
    iget v1, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_FAILED_NO_WRITE_EXTERNAL_PERMISSION I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-wide/16 v2, 0
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    const-string v3, ""
    invoke-interface v15, v1, v3, v2, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadFinishBlk Lkotlin/jvm/functions/Function1;
    move-object v1, v13
    invoke-interface v0, v13, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final saveFileAndLoadingInternal(android.content.Context  java.lang.String  java.lang.String  java.lang.String  kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function3  boolean  long)void
    .registers 25
    # ins_size=10
    sget-object v0, Lkotlinx/coroutines/CoroutineExceptionHandler;->Key Lkotlinx/coroutines/CoroutineExceptionHandler$Key;
    new-instance v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$$inlined$CoroutineExceptionHandler$1;
    move-object v13, v15
    move-object/from16 v7, v19
    move-object/from16 v11, v21
    invoke-direct v1, v0, v11, v15, v7, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$$inlined$CoroutineExceptionHandler$1;-><init>(Lkotlinx/coroutines/CoroutineExceptionHandler$Key; Lkotlin/jvm/functions/Function3; Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/lang/String;)V
    check-cast v1, Lkotlinx/coroutines/CoroutineExceptionHandler;
    move-object v0, v1
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    const/4 v1, 0
    new-instance v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;
    const/4 v12, 0
    move-object v2, v14
    move-object v3, v15
    move-object/from16 v4, v16
    move-object/from16 v5, v17
    move-object/from16 v6, v18
    move/from16 v8, v22
    move-wide/from16 v9, v23
    invoke-direct/range v2 ... v12, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Lkotlin/jvm/functions/Function3; Lkotlin/coroutines/Continuation;)V
    move-object v2, v14
    check-cast v2, Lkotlin/jvm/functions/Function2;
    const/4 v3, 2
    const/4 v4, 0
    move-object/from16 v16, v20
    move-object/from16 v17, v0
    move-object/from16 v18, v1
    move-object/from16 v19, v2
    move/from16 v20, v3
    move-object/from16 v21, v4
    invoke-static/range v16 ... v21, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final copyCachedFileAndLoading(android.content.Context  java.io.File  java.lang.String  java.lang.String  kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function3  long)void
    .registers 31
    # ins_size=9
    move-object/from16 v10, v22
    move-object/from16 v0, v23
    move-object/from16 v5, v26
    move-object/from16 v7, v28
    const-string v1, "context"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, sessionId
    move-object/from16 v4, v25
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, scope
    move-object/from16 v6, v27
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v5, +003h
    return-void 
    const-string v1, ""
    const-wide/16 v2, 0
    if-eqz v24, +0bah
    invoke-virtual/range v24, Ljava/io/File;->exists()Z
    move-result v8
    if-eqz v8, +0b4h
    invoke-virtual/range v24, Ljava/io/File;->length()J
    move-result-wide v8
    cmp-long v8, v8, v2
    if-nez v8, +004h
    goto/16 +0aah
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v8
    move-object v12, v8
    check-cast v12, Lkotlin/coroutines/CoroutineContext;
    const/4 v13, 0
    new-instance v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoading$updateLoadingJob$1;
    const/4 v9, 0
    invoke-direct v8, v10, v5, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoading$updateLoadingJob$1;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v14, v8
    check-cast v14, Lkotlin/jvm/functions/Function2;
    const/4 v15, 2
    const/16 v16, 0
    move-object/from16 v11, v27
    invoke-static/range v11 ... v16, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v8
    new-instance v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda2;
    invoke-direct v11, v10, v5, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/lang/String;)V
    invoke-interface v8, v11, Lkotlinx/coroutines/Job;->invokeOnCompletion(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->uploadLoadingJobMap Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v11, Ljava/util/Map;
    invoke-interface v11, v5, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget v8, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v11, 28
    if-gt v8, v11, +05ah
    const-string v8, "android.permission.WRITE_EXTERNAL_STORAGE"
    invoke-static v0, v8, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context; Ljava/lang/String;)I
    move-result v8
    if-eqz v8, +052h
    instance-of v8, v0, Landroidx/fragment/app/FragmentActivity;
    if-eqz v8, +005h
    check-cast v0, Landroidx/fragment/app/FragmentActivity;
    move-object v9, v0
    if-nez v9, +01ah
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadFinishBlk Lkotlin/jvm/functions/Function1;
    invoke-interface v0, v5, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v7, +00fh
    iget v0, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_FAILED_CRASH I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    invoke-interface v7, v0, v1, v2, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    sget-object v11, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->Companion Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;
    move-object v12, v9
    check-cast v12, Landroid/content/Context;
    sget v13, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_permission_file I
    sget v14, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_storage_title I
    sget v15, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_storage_message I
    sget v16, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_allow I
    sget v17, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_deny I
    new-instance v18, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda3;
    move-object/from16 v0, v18
    move-object v1, v9
    move-object/from16 v2, v22
    move-object/from16 v3, v24
    move-object/from16 v4, v25
    move-object/from16 v5, v26
    move-object/from16 v6, v27
    move-object/from16 v7, v28
    move-wide/from16 v8, v29
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda3;-><init>(Landroidx/fragment/app/FragmentActivity; Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; J)V
    const/16 v19, 0
    const/16 v20, 128
    const/16 v21, 0
    invoke-static/range v11 ... v21, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showForPermission$default(Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion; Landroid/content/Context; I I I I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
    goto +21h
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    invoke-virtual v0, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;
    move-result-object v1
    const-string v0, "getApplicationContext(...)"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v0, v22
    move-object/from16 v2, v24
    move-object/from16 v3, v25
    move-object/from16 v4, v26
    move-object/from16 v5, v27
    move-object/from16 v6, v28
    move-wide/from16 v7, v29
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->copyCachedFileAndLoadingInternal(Landroid/content/Context; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; J)V
    return-void 
    if-eqz v7, +00fh
    iget v0, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_FAILED_DOWNLOAD I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    invoke-interface v7, v0, v1, v2, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final downloadToCache(android.content.Context  java.lang.String  java.lang.String  java.lang.String  boolean  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 21
    # ins_size=9
    move-object/from16 v0, v20
    instance-of v1, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCache$1;
    if-eqz v1, +013h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCache$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCache$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +009h
    iget v0, v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCache$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCache$1;->label I
    move-object v11, v12
    goto +7h
    new-instance v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCache$1;
    move-object v11, v12
    invoke-direct v1, v12, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCache$1;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Lkotlin/coroutines/Continuation;)V
    move-object v10, v1
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCache$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCache$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1fh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput v3, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCache$1;->label I
    move-object v2, v12
    move-object v3, v13
    move-object v4, v14
    move-object v5, v15
    move-object/from16 v6, v16
    move/from16 v7, v17
    move-wide/from16 v8, v18
    invoke-virtual/range v2 ... v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadToCacheWithResult$conversation_mainlandRelease(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    check-cast v0, Lcom/bytedance/trae/conversation/products/DownloadCacheResult;
    instance-of v1, v0, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Success;
    if-eqz v1, +009h
    check-cast v0, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Success;->getFile()Ljava/io/File;
    move-result-object v0
    goto +6h
    instance-of v0, v0, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;
    if-eqz v0, +004h
    const/4 v0, 0
    return-object v0
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
.end method

.method public final downloadToCacheWithResult$conversation_mainlandRelease(android.content.Context  java.lang.String  java.lang.String  java.lang.String  boolean  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 25
    # ins_size=9
    move-object/from16 v1, v16
    move-object/from16 v0, v17
    move-object/from16 v2, v24
    instance-of v3, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCacheWithResult$1;
    if-eqz v3, +012h
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCacheWithResult$1;
    iget v4, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCacheWithResult$1;->label I
    const/high16 v5, -2147483648
    and-int/2addr v4, v5
    if-eqz v4, +008h
    iget v2, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCacheWithResult$1;->label I
    sub-int/2addr v2, v5
    iput v2, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCacheWithResult$1;->label I
    goto +6h
    new-instance v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCacheWithResult$1;
    invoke-direct v3, v1, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCacheWithResult$1;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Lkotlin/coroutines/Continuation;)V
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCacheWithResult$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCacheWithResult$1;->label I
    const/4 v6, 2
    const/4 v7, 1
    const-wide/16 v8, 0
    const/4 v10, 0
    if-eqz v5, +01bh
    if-ne v5, v7, +011h
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCacheWithResult$1;->Z$0 Z
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCacheWithResult$1;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/io/File;
    iget-object v3, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCacheWithResult$1;->L$0 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0f5h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v19
    move-object/from16 v5, v20
    invoke-direct v1, v0, v2, v5, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getCacheFilePath(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Ljava/io/File;
    move-result-object v2
    invoke-static v2, Lkotlin/io/FilesKt;->getNameWithoutExtension(Ljava/io/File;)Ljava/lang/String;
    move-result-object v5
    sget-object v11, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v13, Ljava/lang/StringBuilder;
    const-string v14, "downloadToCache: cacheFile="
    invoke-direct v13, v14, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v13
    const-string v14, " exists="
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v2, Ljava/io/File;->exists()Z
    move-result v14
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v13
    const-string v14, " length="
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v2, Ljava/io/File;->length()J
    move-result-wide v14
    invoke-virtual v13, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v11, v12, v13, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v2, Ljava/io/File;->getParentFile()Ljava/io/File;
    move-result-object v11
    if-eqz v11, +009h
    invoke-virtual v11, Ljava/io/File;->mkdirs()Z
    move-result v11
    invoke-static v11, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-direct v11, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v11, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v11, "_time.txt"
    invoke-virtual v5, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    new-instance v11, Ljava/io/File;
    invoke-virtual v2, Ljava/io/File;->getParent()Ljava/lang/String;
    move-result-object v12
    invoke-direct v11, v12, v5, Ljava/io/File;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v11, Ljava/io/File;->exists()Z
    move-result v5
    if-eqz v5, +017h
    invoke-virtual v11, Ljava/io/File;->isFile()Z
    move-result v5
    if-eqz v5, +011h
    invoke-static v11, v10, v7, v10, Lkotlin/io/FilesKt;->readText$default(Ljava/io/File; Ljava/nio/charset/Charset; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v5
    goto +3h
    const-string v5, ""
    invoke-static v5, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v5
    if-eqz v5, +007h
    invoke-virtual v5, Ljava/lang/Long;->longValue()J
    move-result-wide v11
    goto +2h
    move-wide v11, v8
    invoke-virtual v2, Ljava/io/File;->exists()Z
    move-result v5
    if-eqz v5, +00bh
    invoke-virtual v2, Ljava/io/File;->isFile()Z
    move-result v5
    if-nez v5, +005h
    invoke-static v2, Lkotlin/io/FilesKt;->deleteRecursively(Ljava/io/File;)Z
    invoke-virtual v2, Ljava/io/File;->exists()Z
    move-result v5
    if-eqz v5, +015h
    invoke-virtual v2, Ljava/io/File;->length()J
    move-result-wide v13
    cmp-long v5, v13, v8
    if-eqz v5, +00dh
    cmp-long v5, v22, v8
    if-lez v5, +007h
    cmp-long v5, v11, v22
    if-eqz v5, +003h
    goto +3h
    const/4 v5, 0
    goto +2h
    move v5, v7
    if-eqz v5, +084h
    invoke-virtual v2, Ljava/io/File;->exists()Z
    move-result v5
    if-eqz v5, +005h
    invoke-virtual v2, Ljava/io/File;->delete()Z
    invoke-virtual v2, Ljava/io/File;->getParentFile()Ljava/io/File;
    move-result-object v5
    if-eqz v5, +009h
    invoke-virtual v5, Ljava/io/File;->mkdirs()Z
    move-result v5
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    iput-object v1, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCacheWithResult$1;->L$0 Ljava/lang/Object;
    iput-object v2, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCacheWithResult$1;->L$1 Ljava/lang/Object;
    move/from16 v5, v21
    iput-boolean v5, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCacheWithResult$1;->Z$0 Z
    iput v7, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$downloadToCacheWithResult$1;->label I
    move-object/from16 v7, v18
    invoke-direct v1, v0, v7, v2, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFile(Landroid/content/Context; Ljava/lang/String; Ljava/io/File; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v4, +003h
    return-object v4
    move-object v3, v1
    move-object v4, v2
    move-object v2, v0
    move v0, v5
    check-cast v2, Lcom/bytedance/trae/conversation/products/SaveFileResult;
    instance-of v5, v2, Lcom/bytedance/trae/conversation/products/SaveFileResult$Failure;
    if-eqz v5, +02ch
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "downloadToCache: download failed, error="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/trae/conversation/products/SaveFileResult$Failure;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/SaveFileResult$Failure;->getMessage()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/SaveFileResult$Failure;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/SaveFileResult$Failure;->getHttpStatusCode()Ljava/lang/Integer;
    move-result-object v2
    invoke-direct v0, v3, v2, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;-><init>(Ljava/lang/String; Ljava/lang/Integer;)V
    return-object v0
    invoke-virtual v4, Ljava/io/File;->exists()Z
    move-result v2
    if-eqz v2, +00dh
    invoke-virtual v4, Ljava/io/File;->length()J
    move-result-wide v11
    cmp-long v2, v11, v8
    if-nez v2, +003h
    goto +3h
    move-object v2, v4
    goto +19h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    const-string v3, "downloadToCache: file invalid after download"
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, Ljava/io/File;->delete()Z
    new-instance v0, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;
    const-string v2, "Downloaded file is invalid"
    invoke-direct v0, v2, v10, v6, v10, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;-><init>(Ljava/lang/String; Ljava/lang/Integer; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    move/from16 v5, v21
    move-object v3, v1
    move v0, v5
    if-eqz v0, +022h
    invoke-static v2, Lkotlin/io/FilesKt;->readBytes(Ljava/io/File;)[B
    move-result-object v0
    invoke-static v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->decodeContent([B)[B
    move-result-object v0
    invoke-static v2, v0, Lkotlin/io/FilesKt;->writeBytes(Ljava/io/File; [B)V
    goto +15h
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->TAG Ljava/lang/String;
    const-string v4, "decode failed"
    invoke-virtual v2, v3, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    new-instance v2, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-direct v2, v0, v10, v6, v10, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;-><init>(Ljava/lang/String; Ljava/lang/Integer; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v2
    new-instance v0, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Success;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Success;-><init>(Ljava/io/File;)V
    return-object v0
    :try_start_0x95
    :try_start_0x18d
.end method

.method public final getCachedFile(android.content.Context  java.lang.String  java.lang.String)java.io.File
    .registers 6
    # ins_size=4
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sessionId
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "path"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, v4, v5, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getCacheFilePath(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Ljava/io/File;
    move-result-object v3
    invoke-virtual v3, Ljava/io/File;->exists()Z
    move-result v4
    if-eqz v4, +014h
    invoke-virtual v3, Ljava/io/File;->isFile()Z
    move-result v4
    if-eqz v4, +00eh
    invoke-virtual v3, Ljava/io/File;->length()J
    move-result-wide v4
    const-wide/16 v0, 0
    cmp-long v4, v4, v0
    if-lez v4, +004h
    const/4 v4, 1
    goto +2h
    const/4 v4, 0
    if-eqz v4, +003h
    goto +2h
    const/4 v3, 0
    return-object v3
.end method

.method public final getExistingFilePath(android.content.Context  java.lang.String)java.lang.String
    .registers 10
    # ins_size=3
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "path"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getExternalFilePath$default(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v8
    return-object v8
.end method

.method public final saveFileAndLoading(android.content.Context  java.lang.String  java.lang.String  java.lang.String  kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function3  boolean  long)void
    .registers 33
    # ins_size=10
    move-object/from16 v11, v23
    move-object/from16 v0, v24
    move-object/from16 v5, v27
    move-object/from16 v7, v29
    const-string v1, "context"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, url
    move-object/from16 v3, v25
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, sessionId
    move-object/from16 v4, v26
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, scope
    move-object/from16 v6, v28
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v5, +003h
    return-void 
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    move-object v13, v1
    check-cast v13, Lkotlin/coroutines/CoroutineContext;
    const/4 v14, 0
    new-instance v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoading$updateLoadingJob$1;
    const/4 v2, 0
    invoke-direct v1, v11, v5, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoading$updateLoadingJob$1;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v15, v1
    check-cast v15, Lkotlin/jvm/functions/Function2;
    const/16 v16, 2
    const/16 v17, 0
    move-object/from16 v12, v28
    invoke-static/range v12 ... v17, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v1
    new-instance v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda6;
    invoke-direct v8, v11, v5, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/lang/String;)V
    invoke-interface v1, v8, Lkotlinx/coroutines/Job;->invokeOnCompletion(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;
    iget-object v8, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->uploadLoadingJobMap Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v8, Ljava/util/Map;
    invoke-interface v8, v5, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget v1, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v8, 28
    if-gt v1, v8, +061h
    const-string v1, "android.permission.WRITE_EXTERNAL_STORAGE"
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context; Ljava/lang/String;)I
    move-result v1
    if-eqz v1, +059h
    instance-of v1, v0, Landroidx/fragment/app/FragmentActivity;
    if-eqz v1, +006h
    check-cast v0, Landroidx/fragment/app/FragmentActivity;
    move-object v1, v0
    goto +2h
    move-object v1, v2
    if-nez v1, +01eh
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadFinishBlk Lkotlin/jvm/functions/Function1;
    invoke-interface v0, v5, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v7, +013h
    iget v0, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->RESULT_CODE_FAILED_CRASH I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-wide/16 v1, 0
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    const-string v2, ""
    invoke-interface v7, v0, v2, v1, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    sget-object v12, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->Companion Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;
    move-object v13, v1
    check-cast v13, Landroid/content/Context;
    sget v14, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_permission_file I
    sget v15, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_storage_title I
    sget v16, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_storage_message I
    sget v17, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_allow I
    sget v18, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_deny I
    new-instance v19, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda7;
    move-object/from16 v0, v19
    move-object/from16 v2, v23
    move-object/from16 v3, v25
    move-object/from16 v4, v26
    move-object/from16 v5, v27
    move-object/from16 v6, v28
    move-object/from16 v7, v29
    move/from16 v8, v30
    move-wide/from16 v9, v31
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda7;-><init>(Landroidx/fragment/app/FragmentActivity; Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J)V
    const/16 v20, 0
    const/16 v21, 128
    const/16 v22, 0
    invoke-static/range v12 ... v22, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showForPermission$default(Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion; Landroid/content/Context; I I I I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
    goto +23h
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    invoke-virtual v0, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;
    move-result-object v1
    const-string v0, "getApplicationContext(...)"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v0, v23
    move-object/from16 v2, v25
    move-object/from16 v3, v26
    move-object/from16 v4, v27
    move-object/from16 v5, v28
    move-object/from16 v6, v29
    move/from16 v7, v30
    move-wide/from16 v8, v31
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFileAndLoadingInternal(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J)V
    return-void 
.end method
