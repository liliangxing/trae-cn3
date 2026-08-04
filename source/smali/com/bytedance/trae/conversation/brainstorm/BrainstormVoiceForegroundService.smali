# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;
.super Landroid/app/Service;
.source "BrainstormVoiceForegroundService.kt"

.field private static final ACTION_START:Ljava/lang/String;
.field private static final ACTION_STOP:Ljava/lang/String;
.field private static final ACTION_UPDATE:Ljava/lang/String;
.field private static final CHANNEL_ID:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
.field private static final EXTRA_MIC_MUTED:Ljava/lang/String;
.field private static final NOTIFICATION_ID:I
.field private static final REQUEST_RESTORE:I
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroid/app/Service;-><init>()V
    return-void 
.end method

.method private final buildContentIntent()android.app.PendingIntent
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->isMinimized()Z
    move-result v0
    if-eqz v0, +013h
    new-instance v0, Landroid/content/Intent;
    move-object v1, v4
    check-cast v1, Landroid/content/Context;
    const-class v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-direct v0, v1, v2, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v1, "extra_restore_from_holder"
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    goto +19h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->getPackageManager()Landroid/content/pm/PackageManager;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->getPackageName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;
    move-result-object v0
    if-nez v0, +00ch
    new-instance v0, Landroid/content/Intent;
    move-object v1, v4
    check-cast v1, Landroid/content/Context;
    const-class v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-direct v0, v1, v2, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const/high16 v1, 805437440
    invoke-virtual v0, v1, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    move-object v1, v4
    check-cast v1, Landroid/content/Context;
    const/16 v2, 28042
    const/high16 v3, 201326592
    invoke-static v1, v2, v0, v3, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context; I Landroid/content/Intent; I)Landroid/app/PendingIntent;
    move-result-object v0
    const-string v1, "getActivity(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method private final buildNotification(boolean)android.app.Notification
    .registers 5
    # ins_size=2
    if-eqz v4, +005h
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_voice_notification_muted I
    goto +3h
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_voice_notification_active I
    new-instance v0, Landroidx/core/app/NotificationCompat$Builder;
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    const-string v2, "brainstorm_voice_discussion"
    invoke-direct v0, v1, v2, Landroidx/core/app/NotificationCompat$Builder;-><init>(Landroid/content/Context; Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_brainstorm_mic I
    invoke-virtual v0, v1, Landroidx/core/app/NotificationCompat$Builder;->setSmallIcon(I)Landroidx/core/app/NotificationCompat$Builder;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_voice_discussing I
    invoke-virtual v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroidx/core/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroidx/core/app/NotificationCompat$Builder;
    move-result-object v0
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->getString(I)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v0, v4, Landroidx/core/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroidx/core/app/NotificationCompat$Builder;
    move-result-object v4
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->buildContentIntent()Landroid/app/PendingIntent;
    move-result-object v0
    invoke-virtual v4, v0, Landroidx/core/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroidx/core/app/NotificationCompat$Builder;
    move-result-object v4
    const/4 v0, 1
    invoke-virtual v4, v0, Landroidx/core/app/NotificationCompat$Builder;->setOngoing(Z)Landroidx/core/app/NotificationCompat$Builder;
    move-result-object v4
    invoke-virtual v4, v0, Landroidx/core/app/NotificationCompat$Builder;->setOnlyAlertOnce(Z)Landroidx/core/app/NotificationCompat$Builder;
    move-result-object v4
    const-string/jumbo v0, service
    invoke-virtual v4, v0, Landroidx/core/app/NotificationCompat$Builder;->setCategory(Ljava/lang/String;)Landroidx/core/app/NotificationCompat$Builder;
    move-result-object v4
    const/4 v0, -1
    invoke-virtual v4, v0, Landroidx/core/app/NotificationCompat$Builder;->setPriority(I)Landroidx/core/app/NotificationCompat$Builder;
    move-result-object v4
    invoke-virtual v4, Landroidx/core/app/NotificationCompat$Builder;->build()Landroid/app/Notification;
    move-result-object v4
    const-string v0, "build(...)"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v4
.end method

.method private final createNotificationChannel()void
    .registers 5
    # ins_size=1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 26
    if-ge v0, v1, +003h
    return-void 
    new-instance v0, Landroid/app/NotificationChannel;
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_voice_notification_channel I
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 2
    const-string v3, "brainstorm_voice_discussion"
    invoke-direct v0, v3, v1, v2, Landroid/app/NotificationChannel;-><init>(Ljava/lang/String; Ljava/lang/CharSequence; I)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/app/NotificationChannel;->setShowBadge(Z)V
    const-class v1, Landroid/app/NotificationManager;
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->getSystemService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Landroid/app/NotificationManager;
    if-eqz v1, +005h
    invoke-virtual v1, v0, Landroid/app/NotificationManager;->createNotificationChannel(Landroid/app/NotificationChannel;)V
    return-void 
.end method

.method private final foregroundServiceType(boolean)int
    .registers 4
    # ins_size=2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 29
    if-ge v0, v1, +004h
    const/4 v3, 0
    return v3
    if-nez v3, +005h
    const/16 v3, 130
    goto +2h
    const/4 v3, 2
    return v3
.end method

.method private final startForegroundSafely(boolean)void
    .registers 6
    # ins_size=2
    invoke-direct v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->createNotificationChannel()V
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->buildNotification(Z)Landroid/app/Notification;
    move-result-object v0
    sget v1, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v2, 29
    const/16 v3, 28041
    if-lt v1, v2, +00ah
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->foregroundServiceType(Z)I
    move-result v1
    invoke-virtual v4, v3, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->startForeground(I Landroid/app/Notification; I)V
    goto +20h
    invoke-virtual v4, v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->startForeground(I Landroid/app/Notification;)V
    goto +1ch
    move-exception v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, startForeground failed, micMuted=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v2, "BrainstormVoiceFGS"
    invoke-virtual v1, v2, v5, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->stopSelf()V
    return-void 
    :try_start_0x0
.end method

.method private final stopForegroundCompat()void
    .registers 2
    # ins_size=1
    const/4 v0, 1
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->stopForeground(I)V
    return-void 
.end method

.method public onBind(android.content.Intent)android.os.IBinder
    .registers 2
    # ins_size=2
    const/4 v1, 0
    return-object v1
.end method

.method public onDestroy()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->stopForegroundCompat()V
    invoke-super v0, Landroid/app/Service;->onDestroy()V
    return-void 
.end method

.method public onStartCommand(android.content.Intent  int  int)int
    .registers 5
    # ins_size=4
    if-eqz v2, +007h
    invoke-virtual v2, Landroid/content/Intent;->getAction()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    if-eqz v3, +038h
    invoke-virtual v3, Ljava/lang/String;->hashCode()I
    move-result v4
    const v0, -540669514
    if-eq v4, v0, +01fh
    const v0, 160864637
    if-eq v4, v0, +011h
    const v0, 419100942
    if-eq v4, v0, +003h
    goto +2fh
    const-string v4, "com.bytedance.trae.conversation.brainstorm.voice_fg.START"
    invoke-virtual v3, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +01ch
    goto +26h
    const-string v4, "com.bytedance.trae.conversation.brainstorm.voice_fg.UPDATE"
    invoke-virtual v3, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +013h
    goto +1dh
    const-string v2, "com.bytedance.trae.conversation.brainstorm.voice_fg.STOP"
    invoke-virtual v3, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +14h
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->stopForegroundCompat()V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->stopSelf()V
    goto +dh
    const/4 v3, 0
    if-eqz v2, +008h
    const-string v4, "extra_mic_muted"
    invoke-virtual v2, v4, v3, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String; Z)Z
    move-result v3
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->startForegroundSafely(Z)V
    const/4 v2, 2
    return v2
.end method
