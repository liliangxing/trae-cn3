# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/push/impl/PushHelper;
.super Ljava/lang/Object;
.source "PushHelper.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/push/impl/PushHelper;
.field private static final KEY_HAS_REQUEST_NOTIFICATION_PERMISSION:Ljava/lang/String;
.field private static final KEY_NOTIFICATION_PERMISSION_PERMANENTLY_DENIED:Ljava/lang/String;
.field private static final KEY_PUSH_PERMISSION_REQUEST_ST:Ljava/lang/String;
.field private static final keva:Lcom/bytedance/keva/Keva;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/push/impl/PushHelper;
    invoke-direct v0, Lcom/bytedance/trae/push/impl/PushHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->INSTANCE Lcom/bytedance/trae/push/impl/PushHelper;
    sget-object v0, Lcom/bytedance/trae/keva/KevaRepos;->INSTANCE Lcom/bytedance/trae/keva/KevaRepos;
    invoke-virtual v0, Lcom/bytedance/trae/keva/KevaRepos;->getDefaultRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->keva Lcom/bytedance/keva/Keva;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getLastRequestNotificationPermissionTimestamp()long
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->keva Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, push_permission_request_st
    const-wide/16 v2, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/keva/Keva;->getLong(Ljava/lang/String; J)J
    move-result-wide v0
    return-wide v0
.end method

.method public final hasRequestNotificationPermission()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->keva Lcom/bytedance/keva/Keva;
    const-string v1, "has_request_push_permission"
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    return v0
.end method

.method public final isNotificationEnabled(android.content.Context)boolean
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, Landroidx/core/app/NotificationManagerCompat;->from(Landroid/content/Context;)Landroidx/core/app/NotificationManagerCompat;
    move-result-object v2
    invoke-virtual v2, Landroidx/core/app/NotificationManagerCompat;->areNotificationsEnabled()Z
    move-result v2
    goto +2h
    const/4 v2, 0
    return v2
    :try_start_0x5
.end method

.method public final isNotificationPermissionPermanentlyDenied()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->keva Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, notification_permission_permanently_denied
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    return v0
.end method

.method public final openSysPushSettingPage(android.content.Context)void
    .registers 7
    # ins_size=2
    const-string v0, "context"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    invoke-direct v0, Landroid/content/Intent;-><init>()V
    sget v1, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v2, 26
    const/high16 v3, 268435456
    const-string v4, "android.settings.APP_NOTIFICATION_SETTINGS"
    if-lt v1, v2, +012h
    invoke-virtual v0, v4, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;
    const-string v1, "android.provider.extra.APP_PACKAGE"
    invoke-virtual v6, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v0, v3, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    goto +1bh
    invoke-virtual v0, v4, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;
    const-string v1, "app_package"
    invoke-virtual v6, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v6, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;
    move-result-object v1
    iget v1, v1, Landroid/content/pm/ApplicationInfo;->uid I
    const-string v2, "app_uid"
    invoke-virtual v0, v2, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; I)Landroid/content/Intent;
    invoke-virtual v0, v3, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    invoke-virtual v6, v0, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    goto +25h
    const-string v1, "android.settings.APPLICATION_DETAILS_SETTINGS"
    invoke-virtual v0, v1, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;
    const-string/jumbo v1, package
    invoke-virtual v6, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    invoke-static v1, v2, v3, Landroid/net/Uri;->fromParts(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;
    invoke-virtual v6, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;
    move-result-object v1
    if-eqz v1, +007h
    const/4 v2, 0
    invoke-virtual v1, v0, v2, Landroid/content/pm/PackageManager;->resolveActivity(Landroid/content/Intent; I)Landroid/content/pm/ResolveInfo;
    move-result-object v3
    if-eqz v3, +005h
    invoke-virtual v6, v0, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
    :try_start_0x3e
    :try_start_0x56
.end method

.method public final saveRequestNotificationPermission(boolean)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->keva Lcom/bytedance/keva/Keva;
    const-string v1, "has_request_push_permission"
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    return-void 
.end method

.method public final setLastRequestNotificationPermissionTimestamp(long)void
    .registers 5
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->keva Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, push_permission_request_st
    invoke-virtual v0, v1, v3, v4, Lcom/bytedance/keva/Keva;->storeLong(Ljava/lang/String; J)V
    return-void 
.end method

.method public final setNotificationPermissionPermanentlyDenied(boolean)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/push/impl/PushHelper;->keva Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, notification_permission_permanently_denied
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    return-void 
.end method
