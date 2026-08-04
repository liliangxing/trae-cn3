# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/privacy/PrivacyManager;
.super Ljava/lang/Object;
.source "PrivacyManager.kt"

.field public static final $stable:I
.field private static final FLAG_FILE_NAME:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/home/privacy/PrivacyManager;
.field private static final KEVA_MARK:Ljava/lang/String;
.field private static final KEVA_REPO_NAME:Ljava/lang/String;
.field public static final TAG:Ljava/lang/String;
.field private static currentProcessName:Ljava/lang/String;
.field private static flagFile:Ljava/io/File;
.field private static keva:Lcom/bytedance/keva/Keva;
.field private static mainProcessName:Ljava/lang/String;
.field private static privacyProcessName:Ljava/lang/String;


.method public static synthetic $r8$lambda$K9gIovtgl09CSCxFKTflgUlsT_8(android.content.Context  java.lang.Thread  java.lang.Throwable)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/privacy/PrivacyManager;->init$lambda$0(Landroid/content/Context; Ljava/lang/Thread; Ljava/lang/Throwable;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-direct v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final init$lambda$0(android.content.Context  java.lang.Thread  java.lang.Throwable)void
    .registers 4
    # ins_size=3
    sget-object v2, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v2, v1, Lcom/bytedance/trae/home/privacy/PrivacyManager;->sendKillMySelfBroadcast(Landroid/content/Context;)V
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v0, "Uncaught exception e: "
    invoke-direct v1, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v1, Lcom/bytedance/trae/home/privacy/PrivacyManager;->exitProcess(Ljava/lang/String;)V
    return-void 
.end method

.method private final markAgreed()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->flagFile Ljava/io/File;
    const/4 v1, 0
    const-string v2, "flagFile"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Ljava/io/File;->exists()Z
    move-result v0
    if-nez v0, +00eh
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->flagFile Ljava/io/File;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Ljava/io/File;->createNewFile()Z
    return-void 
.end method

.method public final checkAgreed()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getSupportCloudTest()Z
    move-result v0
    if-eqz v0, +004h
    const/4 v0, 1
    goto +fh
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->flagFile Ljava/io/File;
    if-nez v0, +008h
    const-string v0, "flagFile"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Ljava/io/File;->exists()Z
    move-result v0
    return v0
.end method

.method public final exitProcess(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string v0, "reason"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    sget-object v1, Lcom/bytedance/trae/home/privacy/PrivacyManager;->currentProcessName Ljava/lang/String;
    if-nez v1, +008h
    const-string v1, "currentProcessName"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, " exitProcess reason["
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v0, 93
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "PrivacyManager"
    invoke-static v0, v3, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    invoke-static Landroid/os/Process;->myPid()I
    move-result v3
    invoke-static v3, Landroid/os/Process;->killProcess(I)V
    return-void 
.end method

.method public final init(android.content.Context)void
    .registers 7
    # ins_size=2
    const-string v0, "base"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/utils/AppUtils;->getCurrentProcessName()Ljava/lang/String;
    move-result-object v0
    const-string v1, "getCurrentProcessName(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->currentProcessName Ljava/lang/String;
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    sget-object v1, Lcom/bytedance/trae/home/privacy/PrivacyManager;->currentProcessName Ljava/lang/String;
    const-string v2, "currentProcessName"
    const/4 v3, 0
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, " init"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "PrivacyManager"
    invoke-static v1, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    invoke-virtual v6, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v0
    const-string v1, "getPackageName(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->mainProcessName Ljava/lang/String;
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v6, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ":privacy"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->privacyProcessName Ljava/lang/String;
    new-instance v0, Ljava/io/File;
    invoke-virtual v6, Landroid/content/Context;->getFilesDir()Ljava/io/File;
    move-result-object v1
    const-string v4, "privacy_agreed"
    invoke-direct v0, v1, v4, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->flagFile Ljava/io/File;
    const-string/jumbo v0, trae_privacy
    invoke-static v0, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String;)Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "getRepo(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->keva Lcom/bytedance/keva/Keva;
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->currentProcessName Ljava/lang/String;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    sget-object v1, Lcom/bytedance/trae/home/privacy/PrivacyManager;->privacyProcessName Ljava/lang/String;
    if-nez v1, +008h
    const-string v1, "privacyProcessName"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v1
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00ah
    new-instance v0, Lcom/bytedance/trae/home/privacy/PrivacyManager$$ExternalSyntheticLambda0;
    invoke-direct v0, v6, Lcom/bytedance/trae/home/privacy/PrivacyManager$$ExternalSyntheticLambda0;-><init>(Landroid/content/Context;)V
    invoke-static v0, Ljava/lang/Thread;->setDefaultUncaughtExceptionHandler(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    return-void 
.end method

.method public final isFirstInstallStarting()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->keva Lcom/bytedance/keva/Keva;
    if-nez v0, +008h
    const-string v0, "keva"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    const-string v1, "first_start"
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    return v0
.end method

.method public final isPrivacyProcess()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->currentProcessName Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "currentProcessName"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    sget-object v2, Lcom/bytedance/trae/home/privacy/PrivacyManager;->privacyProcessName Ljava/lang/String;
    if-nez v2, +008h
    const-string v2, "privacyProcessName"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v2
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    return v0
.end method

.method public final notifyAgree(boolean)void
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "click and Notify notifyAgreeResult = ["
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 93
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "PrivacyManager"
    invoke-static v1, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    if-eqz v3, +005h
    invoke-direct v2, Lcom/bytedance/trae/home/privacy/PrivacyManager;->markAgreed()V
    return-void 
.end method

.method public final notifyStartEventDelay()boolean
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/privacy/PrivacyManager;->checkAgreed()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    return v0
.end method

.method public final registerReceiver(android.content.Context)void
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver;->Companion Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;->registerReceiver(Landroid/content/Context;)V
    return-void 
.end method

.method public final sendKillMySelfBroadcast(android.content.Context)void
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver;->Companion Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;->sendBroadcast(Landroid/content/Context;)V
    return-void 
.end method

.method public final updateIsFirstStartMark(boolean)void
    .registers 4
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/home/privacy/PrivacyManager;->checkAgreed()Z
    move-result v0
    if-eqz v0, +011h
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->keva Lcom/bytedance/keva/Keva;
    if-nez v0, +008h
    const-string v0, "keva"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    const-string v1, "first_start"
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    return-void 
.end method
