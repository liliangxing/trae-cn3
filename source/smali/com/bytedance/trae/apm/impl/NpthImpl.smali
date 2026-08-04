# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/NpthImpl;
.super Ljava/lang/Object;
.source "NpthImpl.kt"

.implements Lcom/bytedance/trae/apm/api/INpth;

.field public static final Companion:Lcom/bytedance/trae/apm/impl/NpthImpl$Companion;
.field private static final TAG:Ljava/lang/String;
.field private final deviceIdKV:Lcom/bytedance/keva/Keva;


.method public static synthetic $r8$lambda$BzeyHdXaUTxt5P0YlkBUMD7L4nQ(com.bytedance.trae.apm.impl.NpthImpl  com.bytedance.crash.CrashType  java.lang.String  java.lang.Thread)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/apm/impl/NpthImpl;->registerCrashCallback$lambda$2(Lcom/bytedance/trae/apm/impl/NpthImpl; Lcom/bytedance/crash/CrashType; Ljava/lang/String; Ljava/lang/Thread;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$EttcgRztxGXxQUBCNMPveiJOulE(com.bytedance.trae.apm.api.ICrashCallback  com.bytedance.crash.CrashType  java.lang.String  java.lang.Thread)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/apm/impl/NpthImpl;->registerCrashCallback$lambda$3(Lcom/bytedance/trae/apm/api/ICrashCallback; Lcom/bytedance/crash/CrashType; Ljava/lang/String; Ljava/lang/Thread;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$_BVngLeX0jerZuhFkj7PU0MBLvg(com.bytedance.trae.apm.impl.NpthImpl)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/apm/impl/NpthImpl;->trySaveDeviceIdToKeva$lambda$0(Lcom/bytedance/trae/apm/impl/NpthImpl;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$_duFU9Ns9YuGqTZYTgBAr61ltN4(android.app.ApplicationExitInfo)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/apm/impl/NpthImpl;->registerExitReasonCallback$lambda$1(Landroid/app/ApplicationExitInfo;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/apm/impl/NpthImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/apm/impl/NpthImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/apm/impl/NpthImpl;->Companion Lcom/bytedance/trae/apm/impl/NpthImpl$Companion;
    const-string v0, "NpthImpl"
    sput-object v0, Lcom/bytedance/trae/apm/impl/NpthImpl;->TAG Ljava/lang/String;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    const-string v0, "device_id_repo"
    const/4 v1, 1
    invoke-static v0, v1, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String; I)Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "getRepo(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/apm/impl/NpthImpl;->deviceIdKV Lcom/bytedance/keva/Keva;
    return-void 
.end method

.method public static final synthetic access$getDeviceIdForNpth(com.bytedance.trae.apm.impl.NpthImpl)java.lang.String
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/NpthImpl;->getDeviceIdForNpth()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getTAG$cp()java.lang.String
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/apm/impl/NpthImpl;->TAG Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$trySaveDeviceIdToKeva(com.bytedance.trae.apm.impl.NpthImpl)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/NpthImpl;->trySaveDeviceIdToKeva()V
    return-void 
.end method

.method private final addAttachUserData()void
    .registers 3
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;-><init>()V
    check-cast v0, Lcom/bytedance/crash/AttachUserData;
    sget-object v1, Lcom/bytedance/crash/CrashType;->ALL Lcom/bytedance/crash/CrashType;
    invoke-static v0, v1, Lcom/bytedance/crash/Npth;->addAttachUserData(Lcom/bytedance/crash/AttachUserData; Lcom/bytedance/crash/CrashType;)V
    return-void 
.end method

.method private final getCurrentDateString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/text/SimpleDateFormat;
    const-string/jumbo v1, yyyy-MM-dd HH:mm:ss
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v2
    invoke-direct v0, v1, v2, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    new-instance v1, Ljava/util/Date;
    invoke-direct v1, Ljava/util/Date;-><init>()V
    invoke-virtual v0, v1, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v0
    const-string v1, "format(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +3h
    const-string v0, ""
    return-object v0
    :try_start_0xc
.end method

.method private final getDeviceIdForNpth()java.lang.String
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v1
    if-nez v1, +014h
    const-string v1, "0"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +00ch
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    sget-object v2, Lcom/bytedance/trae/apm/impl/NpthImpl;->TAG Ljava/lang/String;
    const-string v3, "getDeviceIdForNpth: GetDeviceId from AppLog success"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    invoke-direct v4, Lcom/bytedance/trae/apm/impl/NpthImpl;->getDeviceIdFromKeva()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final getDeviceIdFromKeva()java.lang.String
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/apm/impl/NpthImpl;->deviceIdKV Lcom/bytedance/keva/Keva;
    const-string v1, "latest_did"
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v1
    if-nez v1, +014h
    const-string v1, "0"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +00ch
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    sget-object v2, Lcom/bytedance/trae/apm/impl/NpthImpl;->TAG Ljava/lang/String;
    const-string v3, "getDeviceIdFromKeva latest_did success"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +ah
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    sget-object v2, Lcom/bytedance/trae/apm/impl/NpthImpl;->TAG Ljava/lang/String;
    const-string v3, "getDeviceIdFromKeva latest_did empty"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v0
.end method

.method private final getProcessNameFromCmd()java.lang.String
    .registers 11
    # ins_size=1
    const-string v0, "/proc/"
    const/4 v1, 0
    new-instance v2, Ljava/io/BufferedReader;
    new-instance v3, Ljava/io/FileReader;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Landroid/os/Process;->myPid()I
    move-result v0
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v4, "/cmdline"
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v3, v0, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V
    check-cast v3, Ljava/io/Reader;
    invoke-direct v2, v3, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    invoke-virtual v2, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v3
    if-nez v3, +03eh
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v3
    const/4 v4, 1
    sub-int/2addr v3, v4
    const/4 v5, 0
    move v6, v5
    move v7, v6
    if-gt v6, v3, +025h
    if-nez v7, +004h
    move v8, v6
    goto +2h
    move v8, v3
    invoke-interface v0, v8, Ljava/lang/CharSequence;->charAt(I)C
    move-result v8
    const/16 v9, 32
    invoke-static v8, v9, Lkotlin/jvm/internal/Intrinsics;->compare(I I)I
    move-result v8
    if-gtz v8, +004h
    move v8, v4
    goto +2h
    move v8, v5
    if-nez v7, +009h
    if-nez v8, +004h
    move v7, v4
    goto -1bh
    add-int/lit8 v6, v6, 1
    goto -1eh
    if-nez v8, +003h
    goto +4h
    add-int/lit8 v3, v3, -1
    goto -24h
    add-int/2addr v3, v4
    invoke-interface v0, v6, v3, Ljava/lang/CharSequence;->subSequence(I I)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, Ljava/io/BufferedReader;->close()V
    return-object v0
    move-object v2, v1
    if-eqz v2, +005h
    invoke-virtual v2, Ljava/io/BufferedReader;->close()V
    return-object v1
    :try_start_0x3
    :try_start_0x26
    :try_start_0x6f
    :try_start_0x76
.end method

.method private final registerCrashCallback()void
    .registers 3
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/apm/impl/NpthImpl$$ExternalSyntheticLambda1;
    invoke-direct v0, v2, Lcom/bytedance/trae/apm/impl/NpthImpl$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/apm/impl/NpthImpl;)V
    sget-object v1, Lcom/bytedance/crash/CrashType;->ALL Lcom/bytedance/crash/CrashType;
    invoke-static v0, v1, Lcom/bytedance/crash/Npth;->registerCrashCallback(Lcom/bytedance/crash/ICrashCallback; Lcom/bytedance/crash/CrashType;)V
    return-void 
.end method

.method private static final registerCrashCallback$lambda$2(com.bytedance.trae.apm.impl.NpthImpl  com.bytedance.crash.CrashType  java.lang.String  java.lang.Thread)void
    .registers 10
    # ins_size=4
    const-string v0, "CrashMonitor"
    const-string v1, "
"
    const-string/jumbo v2, type
    invoke-static v7, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "crash occurs!
"
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-string v3, "crash-time:"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-direct v6, Lcom/bytedance/trae/apm/impl/NpthImpl;->getCurrentDateString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, "append(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v9, +039h
    const-string/jumbo v3, thread-name:
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v9, Ljava/lang/Thread;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string/jumbo v4, thread-id:
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v9, Ljava/lang/Thread;->getId()J
    move-result-wide v4
    invoke-virtual v3, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v3, "process-name:"
    invoke-virtual v9, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-direct v6, Lcom/bytedance/trae/apm/impl/NpthImpl;->getProcessNameFromCmd()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v9, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v6, "crash-type:"
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    if-eqz v8, +009h
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v0, v7, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    goto +9h
    move-exception v6
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v8, "registerCrashCallback error"
    invoke-virtual v7, v0, v8, v6, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0xa
.end method

.method private static final registerCrashCallback$lambda$3(com.bytedance.trae.apm.api.ICrashCallback  com.bytedance.crash.CrashType  java.lang.String  java.lang.Thread)void
    .registers 4
    # ins_size=4
    const-string/jumbo v3, type
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, v2, Lcom/bytedance/trae/apm/api/ICrashCallback;->onCrash(Ljava/lang/String;)V
    return-void 
.end method

.method private final registerExitReasonCallback()void
    .registers 3
    # ins_size=1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 30
    if-ge v0, v1, +003h
    return-void 
    new-instance v0, Lcom/bytedance/trae/apm/impl/NpthImpl$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/NpthImpl$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lcom/bytedance/crash/terminate/TerminateMonitor;->registerExitReasonCallback(Lcom/bytedance/crash/IExitReasonCallback;)V
    return-void 
.end method

.method private static final registerExitReasonCallback$lambda$1(android.app.ApplicationExitInfo)void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    sget-object v1, Lcom/bytedance/trae/apm/impl/NpthImpl;->TAG Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "App exit reason: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final trySaveDeviceIdToKeva()void
    .registers 4
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/apm/impl/NpthImpl$$ExternalSyntheticLambda2;
    invoke-direct v0, v3, Lcom/bytedance/trae/apm/impl/NpthImpl$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/apm/impl/NpthImpl;)V
    const-wide/16 v1, 2000
    invoke-static v0, v1, v2, Lcom/bytedance/trae/utils/ThreadUtils;->postInBackground(Ljava/lang/Runnable; J)V
    return-void 
.end method

.method private static final trySaveDeviceIdToKeva$lambda$0(com.bytedance.trae.apm.impl.NpthImpl)void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v1
    if-nez v1, +01ch
    const-string v1, "0"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +014h
    invoke-direct v2, Lcom/bytedance/trae/apm/impl/NpthImpl;->getDeviceIdFromKeva()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +016h
    iget-object v2, v2, Lcom/bytedance/trae/apm/impl/NpthImpl;->deviceIdKV Lcom/bytedance/keva/Keva;
    const-string v1, "latest_did"
    invoke-virtual v2, v1, v0, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    goto +dh
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lcom/bytedance/trae/apm/impl/NpthImpl$trySaveDeviceIdToKeva$1$1;
    invoke-direct v1, v2, Lcom/bytedance/trae/apm/impl/NpthImpl$trySaveDeviceIdToKeva$1$1;-><init>(Lcom/bytedance/trae/apm/impl/NpthImpl;)V
    check-cast v1, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->addGetAppLogIdListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    return-void 
.end method

.method public enableGwpAsan()void
    .registers 2
    # ins_size=1
    const/4 v0, 1
    invoke-static v0, Lcom/bytedance/crash/Npth;->enableGwpAsan(Z)V
    return-void 
.end method

.method public goUpload()void
    .registers 4
    # ins_size=1
    const-string v0, "com.bytedance.crash.NpthCore"
    invoke-static v0, Lcom/bytedance/common/utility/reflect/Reflect;->on(Ljava/lang/String;)Lcom/bytedance/common/utility/reflect/Reflect;
    move-result-object v0
    const-string/jumbo v1, sStopUpload
    const/4 v2, 0
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/common/utility/reflect/Reflect;->set(Ljava/lang/String; Ljava/lang/Object;)Lcom/bytedance/common/utility/reflect/Reflect;
    return-void 
    :try_start_0x0
.end method

.method public init(android.content.Context)void
    .registers 4
    # ins_size=2
    const-string v0, "baseCtx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/crash/Npth;->setApplication(Landroid/app/Application;)V
    invoke-direct v2, Lcom/bytedance/trae/apm/impl/NpthImpl;->getProcessNameFromCmd()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/crash/util/App;->setCurProcessName(Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/apm/impl/NpthImpl$init$1;
    invoke-direct v0, v2, Lcom/bytedance/trae/apm/impl/NpthImpl$init$1;-><init>(Lcom/bytedance/trae/apm/impl/NpthImpl;)V
    check-cast v0, Lcom/bytedance/crash/ICommonParams;
    const/4 v1, 1
    invoke-static v3, v0, v1, v1, v1, Lcom/bytedance/crash/Npth;->init(Landroid/content/Context; Lcom/bytedance/crash/ICommonParams; Z Z Z)V
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v0, Lcom/bytedance/trae/apm/impl/NpthImpl$init$2;
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/NpthImpl$init$2;-><init>()V
    check-cast v0, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;
    invoke-virtual v3, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->addGetAppLogIdListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    invoke-direct v2, Lcom/bytedance/trae/apm/impl/NpthImpl;->registerCrashCallback()V
    invoke-direct v2, Lcom/bytedance/trae/apm/impl/NpthImpl;->registerExitReasonCallback()V
    invoke-direct v2, Lcom/bytedance/trae/apm/impl/NpthImpl;->addAttachUserData()V
    invoke-direct v2, Lcom/bytedance/trae/apm/impl/NpthImpl;->trySaveDeviceIdToKeva()V
    return-void 
.end method

.method public registerCrashCallback(com.bytedance.trae.apm.api.ICrashCallback)void
    .registers 3
    # ins_size=2
    const-string v0, "crashCallback"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/apm/impl/NpthImpl$$ExternalSyntheticLambda3;
    invoke-direct v0, v2, Lcom/bytedance/trae/apm/impl/NpthImpl$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/apm/api/ICrashCallback;)V
    sget-object v2, Lcom/bytedance/crash/CrashType;->ALL Lcom/bytedance/crash/CrashType;
    invoke-static v0, v2, Lcom/bytedance/crash/Npth;->registerCrashCallback(Lcom/bytedance/crash/ICrashCallback; Lcom/bytedance/crash/CrashType;)V
    return-void 
.end method

.method public startNpthLifecycleRecorder(android.app.Application  int)void
    .registers 4
    # ins_size=3
    const-string v0, "app"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->INSTANCE Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    invoke-virtual v2, v0, v3, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->onAppCreate(Landroid/app/Application; I)V
    return-void 
.end method

.method public stopUpload(boolean)void
    .registers 2
    # ins_size=2
    if-eqz v1, +005h
    invoke-static Lcom/bytedance/crash/Npth;->stopUpload()V
    return-void 
.end method
