# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;
.super Ljava/lang/Object;
.source "AndroidKmpMediaLibraryHandler.kt"

.implements Lcom/bytedance/trae/kmp/host/KmpMediaLibraryHandler;

.field public static final $stable:I
.field private final activityProvider:Lkotlin/jvm/functions/Function0;
.field private final context:Landroid/content/Context;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(android.content.Context  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=3
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "activityProvider"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->context Landroid/content/Context;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->activityProvider Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public static final synthetic access$ensureLegacyStoragePermission(com.bytedance.trae.kmp.host.AndroidKmpMediaLibraryHandler  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->ensureLegacyStoragePermission(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getContext$p(com.bytedance.trae.kmp.host.AndroidKmpMediaLibraryHandler)android.content.Context
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->context Landroid/content/Context;
    return-object v0
.end method

.method public static final synthetic access$resolveLocalFile(com.bytedance.trae.kmp.host.AndroidKmpMediaLibraryHandler  java.lang.String)java.io.File
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->resolveLocalFile(Ljava/lang/String;)Ljava/io/File;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$saveWithFileApi(com.bytedance.trae.kmp.host.AndroidKmpMediaLibraryHandler  java.io.File  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->saveWithFileApi(Ljava/io/File; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$saveWithMediaStore(com.bytedance.trae.kmp.host.AndroidKmpMediaLibraryHandler  java.io.File  java.lang.String  java.lang.String)com.bytedance.trae.kmp.host.KmpMediaLibrarySaveResult
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->saveWithMediaStore(Ljava/io/File; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$scan(com.bytedance.trae.kmp.host.AndroidKmpMediaLibraryHandler  java.io.File  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->scan(Ljava/io/File; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final ensureLegacyStoragePermission(kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=2
    instance-of v0, v5, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1;
    if-eqz v0, +012h
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v5, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1;->label I
    sub-int/2addr v5, v2
    iput v5, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1;
    invoke-direct v0, v4, v5, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1;-><init>(Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler; Lkotlin/coroutines/Continuation;)V
    iget-object v5, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2eh
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->context Landroid/content/Context;
    const-string v2, "android.permission.WRITE_EXTERNAL_STORAGE"
    invoke-static v5, v2, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context; Ljava/lang/String;)I
    move-result v5
    if-nez v5, +005h
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    iget-object v5, v4, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->activityProvider Lkotlin/jvm/functions/Function0;
    invoke-interface v5, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v5
    if-eqz v5, +026h
    check-cast v5, Landroidx/fragment/app/FragmentActivity;
    sget-object v2, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;->Companion Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion;
    iput v3, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$ensureLegacyStoragePermission$1;->label I
    invoke-virtual v2, v5, v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion;->request(Landroidx/fragment/app/FragmentActivity; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v1, +003h
    return-object v1
    check-cast v5, Ljava/lang/Boolean;
    invoke-virtual v5, Ljava/lang/Boolean;->booleanValue()Z
    move-result v5
    if-eqz v5, +005h
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "Storage permission is required"
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "Storage permission cannot be requested without an active activity"
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
.end method

.method private final resolveLocalFile(java.lang.String)java.io.File
    .registers 6
    # ins_size=2
    const/4 v0, 2
    const/4 v1, 0
    const-string v2, "file:"
    const/4 v3, 0
    invoke-static v5, v2, v3, v0, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00dh
    new-instance v0, Ljava/io/File;
    new-instance v1, Ljava/net/URI;
    invoke-direct v1, v5, Ljava/net/URI;-><init>(Ljava/lang/String;)V
    invoke-direct v0, v1, Ljava/io/File;-><init>(Ljava/net/URI;)V
    goto +ah
    new-instance v0, Ljava/io/File;
    invoke-static v5, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    invoke-direct v0, v5, Ljava/io/File;-><init>(Ljava/lang/String;)V
    return-object v0
.end method

.method private final saveWithFileApi(java.io.File  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 22
    # ins_size=5
    move-object/from16 v0, v17
    move-object/from16 v1, v21
    instance-of v2, v1, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;
    iget v3, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;-><init>(Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->label I
    const/4 v5, 1
    const/4 v6, 2
    if-eqz v4, +02eh
    if-eq v4, v5, +011h
    if-ne v4, v6, +007h
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +095h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-object v4, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->L$3 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v7, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->L$2 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    iget-object v8, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->L$1 Ljava/lang/Object;
    check-cast v8, Ljava/io/File;
    iget-object v9, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v1, v9
    move-object v9, v8
    move-object/from16 v16, v7
    move-object v7, v4
    move-object/from16 v4, v16
    goto +1dh
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput-object v0, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->L$0 Ljava/lang/Object;
    move-object/from16 v1, v18
    iput-object v1, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->L$1 Ljava/lang/Object;
    move-object/from16 v4, v19
    iput-object v4, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->L$2 Ljava/lang/Object;
    move-object/from16 v7, v20
    iput-object v7, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->L$3 Ljava/lang/Object;
    iput v5, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->label I
    invoke-direct v0, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->ensureLegacyStoragePermission(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v3, +003h
    return-object v3
    move-object v9, v1
    move-object v1, v0
    const-string/jumbo v8, video/
    const/4 v10, 0
    const/4 v15, 0
    invoke-static v7, v8, v10, v6, v15, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +009h
    sget-object v8, Landroid/os/Environment;->DIRECTORY_MOVIES Ljava/lang/String;
    invoke-static v8, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;
    move-result-object v8
    goto +fh
    const-string v8, "image/"
    invoke-static v7, v8, v10, v6, v15, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +049h
    sget-object v8, Landroid/os/Environment;->DIRECTORY_PICTURES Ljava/lang/String;
    invoke-static v8, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;
    move-result-object v8
    new-instance v11, Ljava/io/File;
    const-string v12, "TRAE"
    invoke-direct v11, v8, v12, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v11, Ljava/io/File;->isDirectory()Z
    move-result v8
    if-nez v8, +00ah
    invoke-virtual v11, Ljava/io/File;->mkdirs()Z
    move-result v8
    if-eqz v8, +003h
    goto +2h
    move v5, v10
    if-eqz v5, +020h
    invoke-direct v1, v11, v4, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->uniqueFile(Ljava/io/File; Ljava/lang/String;)Ljava/io/File;
    move-result-object v4
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 6
    const/4 v14, 0
    move-object v10, v4
    invoke-static/range v9 ... v14, Lkotlin/io/FilesKt;->copyTo$default(Ljava/io/File; Ljava/io/File; Z I I Ljava/lang/Object;)Ljava/io/File;
    iput-object v15, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->L$0 Ljava/lang/Object;
    iput-object v15, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->L$1 Ljava/lang/Object;
    iput-object v15, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->L$2 Ljava/lang/Object;
    iput-object v15, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->L$3 Ljava/lang/Object;
    iput v6, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveWithFileApi$1;->label I
    invoke-direct v1, v4, v7, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->scan(Ljava/io/File; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    return-object v1
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "Failed to create media library directory"
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    new-instance v1, Ljava/lang/IllegalStateException;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "Unsupported media type: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
.end method

.method private final saveWithMediaStore(java.io.File  java.lang.String  java.lang.String)com.bytedance.trae.kmp.host.KmpMediaLibrarySaveResult
    .registers 13
    # ins_size=4
    const-string/jumbo v0, video/
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v12, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +005h
    sget-object v4, Landroid/provider/MediaStore$Video$Media;->EXTERNAL_CONTENT_URI Landroid/net/Uri;
    goto +bh
    const-string v4, "image/"
    invoke-static v12, v4, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +0e3h
    sget-object v4, Landroid/provider/MediaStore$Images$Media;->EXTERNAL_CONTENT_URI Landroid/net/Uri;
    invoke-static v12, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    const-string v5, "/TRAE"
    if-eqz v0, +016h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    sget-object v6, Landroid/os/Environment;->DIRECTORY_MOVIES Ljava/lang/String;
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    goto +14h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    sget-object v6, Landroid/os/Environment;->DIRECTORY_PICTURES Ljava/lang/String;
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    iget-object v5, v9, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->context Landroid/content/Context;
    invoke-virtual v5, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v5
    new-instance v6, Landroid/content/ContentValues;
    invoke-direct v6, Landroid/content/ContentValues;-><init>()V
    const-string v7, "_display_name"
    invoke-virtual v6, v7, v11, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v11, "mime_type"
    invoke-virtual v6, v11, v12, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v11, relative_path
    invoke-virtual v6, v11, v0, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v11, 1
    invoke-static v11, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    const-string v0, "is_pending"
    invoke-virtual v6, v0, v12, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/Integer;)V
    invoke-virtual v5, v4, v6, Landroid/content/ContentResolver;->insert(Landroid/net/Uri; Landroid/content/ContentValues;)Landroid/net/Uri;
    move-result-object v12
    if-eqz v12, +07bh
    invoke-virtual v5, v12, Landroid/content/ContentResolver;->openOutputStream(Landroid/net/Uri;)Ljava/io/OutputStream;
    move-result-object v4
    if-eqz v4, +064h
    check-cast v4, Ljava/io/Closeable;
    move-object v6, v4
    check-cast v6, Ljava/io/OutputStream;
    new-instance v7, Ljava/io/FileInputStream;
    invoke-direct v7, v10, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    check-cast v7, Ljava/io/InputStream;
    instance-of v10, v7, Ljava/io/BufferedInputStream;
    if-eqz v10, +005h
    check-cast v7, Ljava/io/BufferedInputStream;
    goto +9h
    new-instance v10, Ljava/io/BufferedInputStream;
    const/16 v8, 8192
    invoke-direct v10, v7, v8, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream; I)V
    move-object v7, v10
    check-cast v7, Ljava/io/Closeable;
    move-object v10, v7
    check-cast v10, Ljava/io/BufferedInputStream;
    check-cast v10, Ljava/io/InputStream;
    invoke-static v10, v6, v1, v2, v3, Lkotlin/io/ByteStreamsKt;->copyTo$default(Ljava/io/InputStream; Ljava/io/OutputStream; I I Ljava/lang/Object;)J
    invoke-static v7, v3, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    invoke-static v4, v3, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    new-instance v10, Landroid/content/ContentValues;
    invoke-direct v10, Landroid/content/ContentValues;-><init>()V
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-virtual v10, v0, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/Integer;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v5, v12, v10, v3, v3, Landroid/content/ContentResolver;->update(Landroid/net/Uri; Landroid/content/ContentValues; Ljava/lang/String; [Ljava/lang/String;)I
    move-result v10
    if-lez v10, +003h
    move v1, v11
    if-eqz v1, +008h
    new-instance v10, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;
    invoke-direct v10, v11, v3, v2, v3, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;-><init>(Z Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v10
    const-string v10, "Failed to publish media library entry"
    new-instance v11, Ljava/lang/IllegalStateException;
    invoke-virtual v10, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-direct v11, v10, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    move-exception v10
    throw v10
    move-exception v11
    invoke-static v7, v10, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v11
    move-exception v10
    throw v10
    move-exception v11
    invoke-static v4, v10, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v11
    const-string v10, "Failed to open media library entry"
    new-instance v11, Ljava/lang/IllegalStateException;
    invoke-virtual v10, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-direct v11, v10, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    move-exception v10
    invoke-virtual v5, v12, v3, v3, Landroid/content/ContentResolver;->delete(Landroid/net/Uri; Ljava/lang/String; [Ljava/lang/String;)I
    throw v10
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v11, "Failed to create media library entry"
    invoke-virtual v11, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-direct v10, v11, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    new-instance v10, Ljava/lang/IllegalStateException;
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v0, "Unsupported media type: "
    invoke-direct v11, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-direct v10, v11, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    :try_start_0x73
    :try_start_0x7b
    :try_start_0x96
    :try_start_0x9e
    :try_start_0xa1
    :try_start_0xce
    :try_start_0xd0
    :try_start_0xd5
    :try_start_0xd7
.end method

.method private final scan(java.io.File  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 11
    # ins_size=4
    new-instance v0, Lkotlinx/coroutines/CancellableContinuationImpl;
    invoke-static v10, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->intercepted(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lkotlinx/coroutines/CancellableContinuationImpl;-><init>(Lkotlin/coroutines/Continuation; I)V
    invoke-virtual v0, Lkotlinx/coroutines/CancellableContinuationImpl;->initCancellability()V
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CancellableContinuation;
    invoke-static v7, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->access$getContext$p(Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;)Landroid/content/Context;
    move-result-object v3
    new-array v4, v2, [Ljava/lang/String;
    invoke-virtual v8, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    aput-object v5, v4, v6
    new-array v2, v2, [Ljava/lang/String;
    aput-object v9, v2, v6
    new-instance v9, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$scan$2$1;
    invoke-direct v9, v1, v8, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$scan$2$1;-><init>(Lkotlinx/coroutines/CancellableContinuation; Ljava/io/File;)V
    check-cast v9, Landroid/media/MediaScannerConnection$OnScanCompletedListener;
    invoke-static v3, v4, v2, v9, Landroid/media/MediaScannerConnection;->scanFile(Landroid/content/Context; [Ljava/lang/String; [Ljava/lang/String; Landroid/media/MediaScannerConnection$OnScanCompletedListener;)V
    invoke-virtual v0, Lkotlinx/coroutines/CancellableContinuationImpl;->getResult()Ljava/lang/Object;
    move-result-object v8
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v9
    if-ne v8, v9, +005h
    invoke-static v10, Lkotlin/coroutines/jvm/internal/DebugProbesKt;->probeCoroutineSuspended(Lkotlin/coroutines/Continuation;)V
    return-object v8
.end method

.method private final uniqueFile(java.io.File  java.lang.String)java.io.File
    .registers 8
    # ins_size=3
    new-instance v0, Ljava/io/File;
    invoke-direct v0, v6, v7, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v0, Ljava/io/File;->exists()Z
    move-result v7
    if-nez v7, +003h
    return-object v0
    invoke-static v0, Lkotlin/io/FilesKt;->getExtension(Ljava/io/File;)Ljava/lang/String;
    move-result-object v7
    move-object v1, v7
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    const/4 v2, 1
    xor-int/2addr v1, v2
    const/4 v3, 0
    if-eqz v1, +003h
    goto +2h
    move-object v7, v3
    if-eqz v7, +011h
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "."
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +004h
    const-string v3, ""
    invoke-virtual v0, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v7
    const-string v0, "getName(...)"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v7, v0, Lkotlin/text/StringsKt;->removeSuffix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v7
    new-instance v0, Ljava/io/File;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, " ("
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v4, 41
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v6, v1, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v0, Ljava/io/File;->exists()Z
    move-result v1
    if-nez v1, +003h
    return-object v0
    add-int/lit8 v2, v2, 1
    goto -2fh
.end method

.method public saveLocalFile(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 13
    # ins_size=5
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v7, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    move-object v5, v11
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;-><init>(Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v7, v12, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    return-object v9
.end method
