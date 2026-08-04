# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;
.super Ljava/lang/Object;
.source "CustomNotificationBuilder.kt"

.implements Lcom/bytedance/push/interfaze/ICustomNotificationBuilder;

.field private static final BIG_PIC_PRIORITY:I
.field public static final Companion:Lcom/bytedance/trae/push/impl/CustomNotificationBuilder$Companion;
.field private static final SMALL_PIC_PRIORITY:I
.field private final CHANNEL_ID:Ljava/lang/String;
.field private final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->Companion Lcom/bytedance/trae/push/impl/CustomNotificationBuilder$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const-string v0, "CustomNotificationBuilder"
    iput-object v0, v1, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->TAG Ljava/lang/String;
    const-string/jumbo v0, push
    iput-object v0, v1, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->CHANNEL_ID Ljava/lang/String;
    return-void 
.end method

.method private final buildPushPendingIntent(com.bytedance.push.PushBody  int)android.app.PendingIntent
    .registers 8
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    invoke-virtual v0, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;
    move-result-object v0
    const/4 v1, 0
    if-eqz v6, +005h
    iget-object v2, v6, Lcom/bytedance/push/PushBody;->open_url Ljava/lang/String;
    goto +2h
    move-object v2, v1
    invoke-static v2, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v2
    invoke-virtual v2, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;
    move-result-object v2
    const-string v3, "is_from_push"
    const-string/jumbo v4, true
    invoke-virtual v2, v3, v4, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v2
    const-string v3, "is_from_custom_push"
    invoke-virtual v2, v3, v4, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v2
    invoke-virtual v2, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    invoke-virtual v3, Landroid/app/Application;->getPackageManager()Landroid/content/pm/PackageManager;
    move-result-object v3
    const-string v4, "getPackageManager(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v4
    invoke-virtual v4, Landroid/app/Application;->getPackageName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;
    move-result-object v3
    if-eqz v3, +009h
    const v4, 268468224
    invoke-virtual v3, v4, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;
    goto +2h
    move-object v3, v1
    if-eqz v3, +007h
    const-string v4, "android.intent.action.VIEW"
    invoke-virtual v3, v4, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;
    if-eqz v3, +00eh
    if-eqz v6, +006h
    invoke-virtual v6, Lcom/bytedance/push/PushBody;->getOriginData()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v4, push_body
    invoke-virtual v3, v4, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    if-eqz v3, +008h
    const-string/jumbo v1, push_message_from
    invoke-virtual v3, v1, v7, Landroid/content/Intent;->putExtra(Ljava/lang/String; I)Landroid/content/Intent;
    if-eqz v3, +00fh
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-virtual v1, Landroid/app/Application;->getPackageName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v1, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;
    if-eqz v3, +005h
    invoke-virtual v3, v2, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;
    if-eqz v6, +005h
    iget-wide v6, v6, Lcom/bytedance/push/PushBody;->id J
    long-to-int v7, v6
    const/high16 v6, 201326592
    invoke-static v0, v7, v3, v6, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context; I Landroid/content/Intent; I)Landroid/app/PendingIntent;
    move-result-object v6
    const-string v7, "getActivity(...)"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v6
.end method

.method private final getLauncherIconBitmap()android.graphics.Bitmap
    .registers 10
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    invoke-virtual v0, Landroid/app/Application;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-virtual v1, Landroid/app/Application;->getPackageManager()Landroid/content/pm/PackageManager;
    move-result-object v1
    invoke-virtual v1, v0, Landroid/content/pm/PackageManager;->getApplicationIcon(Landroid/content/pm/ApplicationInfo;)Landroid/graphics/drawable/Drawable;
    move-result-object v3
    const-string v0, "getApplicationIcon(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 7
    const/4 v8, 0
    move-object v2, v9
    invoke-static/range v2 ... v8, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->toBitmapOrNull$default(Lcom/bytedance/trae/push/impl/CustomNotificationBuilder; Landroid/graphics/drawable/Drawable; I I Landroid/graphics/Bitmap$Config; I Ljava/lang/Object;)Landroid/graphics/Bitmap;
    move-result-object v0
    return-object v0
    move-exception v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v2, v9, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->TAG Ljava/lang/String;
    invoke-virtual v0, Landroid/content/pm/PackageManager$NameNotFoundException;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v0, 0
    return-object v0
    :try_start_0x0
.end method

.method private final setNotificationIconStyle(androidx.core.app.NotificationCompat$Builder  android.graphics.Bitmap  com.bytedance.push.PushBody)void
    .registers 5
    # ins_size=4
    if-eqz v3, +01fh
    if-nez v4, +003h
    goto +1bh
    iget v4, v4, Lcom/bytedance/push/PushBody;->imageType I
    const/4 v0, 1
    if-eq v4, v0, +013h
    const/4 v0, 2
    if-eq v4, v0, +00ch
    const/4 v0, 3
    if-eq v4, v0, +00dh
    const/4 v0, 4
    if-eq v4, v0, +006h
    invoke-direct v1, v2, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->setNotificationNoneImage(Landroidx/core/app/NotificationCompat$Builder;)V
    goto +8h
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->setNotificationSmallImage(Landroidx/core/app/NotificationCompat$Builder; Landroid/graphics/Bitmap;)V
    goto +4h
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->setNotificationLargeImage(Landroidx/core/app/NotificationCompat$Builder; Landroid/graphics/Bitmap;)V
    return-void 
    invoke-direct v1, v2, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->setNotificationNoneImage(Landroidx/core/app/NotificationCompat$Builder;)V
    return-void 
.end method

.method private final setNotificationLargeImage(androidx.core.app.NotificationCompat$Builder  android.graphics.Bitmap)void
    .registers 5
    # ins_size=3
    invoke-direct v2, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->getLauncherIconBitmap()Landroid/graphics/Bitmap;
    move-result-object v0
    new-instance v1, Landroidx/core/app/NotificationCompat$BigPictureStyle;
    invoke-direct v1, Landroidx/core/app/NotificationCompat$BigPictureStyle;-><init>()V
    invoke-virtual v1, v4, Landroidx/core/app/NotificationCompat$BigPictureStyle;->bigPicture(Landroid/graphics/Bitmap;)Landroidx/core/app/NotificationCompat$BigPictureStyle;
    move-result-object v1
    invoke-virtual v1, v0, Landroidx/core/app/NotificationCompat$BigPictureStyle;->bigLargeIcon(Landroid/graphics/Bitmap;)Landroidx/core/app/NotificationCompat$BigPictureStyle;
    move-result-object v0
    const-string v1, "bigLargeIcon(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/core/app/NotificationCompat$Style;
    invoke-virtual v3, v0, Landroidx/core/app/NotificationCompat$Builder;->setStyle(Landroidx/core/app/NotificationCompat$Style;)Landroidx/core/app/NotificationCompat$Builder;
    move-result-object v3
    invoke-virtual v3, v4, Landroidx/core/app/NotificationCompat$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroidx/core/app/NotificationCompat$Builder;
    return-void 
.end method

.method private final setNotificationNoneImage(androidx.core.app.NotificationCompat$Builder)void
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->getLauncherIconBitmap()Landroid/graphics/Bitmap;
    move-result-object v0
    invoke-virtual v2, v0, Landroidx/core/app/NotificationCompat$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroidx/core/app/NotificationCompat$Builder;
    return-void 
.end method

.method private final setNotificationSmallImage(androidx.core.app.NotificationCompat$Builder  android.graphics.Bitmap)void
    .registers 3
    # ins_size=3
    invoke-virtual v1, v2, Landroidx/core/app/NotificationCompat$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroidx/core/app/NotificationCompat$Builder;
    return-void 
.end method

.method private final toBitmap(android.graphics.drawable.Drawable  int  int  android.graphics.Bitmap$Config)android.graphics.Bitmap
    .registers 10
    # ins_size=5
    instance-of v0, v6, Landroid/graphics/drawable/BitmapDrawable;
    if-eqz v0, +049h
    move-object v0, v6
    check-cast v0, Landroid/graphics/drawable/BitmapDrawable;
    invoke-virtual v0, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;
    move-result-object v1
    if-eqz v1, +038h
    if-eqz v9, +00ch
    invoke-virtual v0, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;
    move-result-object v1
    invoke-virtual v1, Landroid/graphics/Bitmap;->getConfig()Landroid/graphics/Bitmap$Config;
    move-result-object v1
    if-ne v1, v9, +034h
    invoke-virtual v0, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;
    move-result-object v6
    invoke-virtual v6, Landroid/graphics/Bitmap;->getWidth()I
    move-result v6
    if-ne v7, v6, +016h
    invoke-virtual v0, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;
    move-result-object v6
    invoke-virtual v6, Landroid/graphics/Bitmap;->getHeight()I
    move-result v6
    if-ne v8, v6, +00ch
    invoke-virtual v0, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;
    move-result-object v6
    const-string v7, "getBitmap(...)"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v6
    invoke-virtual v0, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;
    move-result-object v6
    const/4 v9, 1
    invoke-static v6, v7, v8, v9, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap; I I Z)Landroid/graphics/Bitmap;
    move-result-object v6
    const-string v7, "createScaledBitmap(...)"
    goto -fh
    new-instance v6, Ljava/lang/IllegalArgumentException;
    const-string v7, "bitmap is null"
    invoke-direct v6, v7, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-virtual v6, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v0
    iget v0, v0, Landroid/graphics/Rect;->left I
    invoke-virtual v6, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v1
    iget v1, v1, Landroid/graphics/Rect;->top I
    invoke-virtual v6, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v2
    iget v2, v2, Landroid/graphics/Rect;->right I
    invoke-virtual v6, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;
    move-result-object v3
    iget v3, v3, Landroid/graphics/Rect;->bottom I
    if-nez v9, +004h
    sget-object v9, Landroid/graphics/Bitmap$Config;->ARGB_8888 Landroid/graphics/Bitmap$Config;
    invoke-static v7, v8, v9, Landroid/graphics/Bitmap;->createBitmap(I I Landroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    move-result-object v9
    const-string v4, "createBitmap(...)"
    invoke-static v9, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    invoke-virtual v6, v4, v4, v7, v8, Landroid/graphics/drawable/Drawable;->setBounds(I I I I)V
    new-instance v7, Landroid/graphics/Canvas;
    invoke-direct v7, v9, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V
    invoke-virtual v6, v7, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V
    invoke-virtual v6, v0, v1, v2, v3, Landroid/graphics/drawable/Drawable;->setBounds(I I I I)V
    return-object v9
.end method

.method static synthetic toBitmap$default(com.bytedance.trae.push.impl.CustomNotificationBuilder  android.graphics.drawable.Drawable  int  int  android.graphics.Bitmap$Config  int  java.lang.Object)android.graphics.Bitmap
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +006h
    invoke-virtual v1, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I
    move-result v2
    and-int/lit8 v6, v5, 2
    if-eqz v6, +006h
    invoke-virtual v1, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I
    move-result v3
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->toBitmap(Landroid/graphics/drawable/Drawable; I I Landroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    move-result-object v0
    return-object v0
.end method

.method private final toBitmapOrNull(android.graphics.drawable.Drawable  int  int  android.graphics.Bitmap$Config)android.graphics.Bitmap
    .registers 6
    # ins_size=5
    instance-of v0, v2, Landroid/graphics/drawable/BitmapDrawable;
    if-eqz v0, +00dh
    move-object v0, v2
    check-cast v0, Landroid/graphics/drawable/BitmapDrawable;
    invoke-virtual v0, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;
    move-result-object v0
    if-nez v0, +004h
    const/4 v2, 0
    return-object v2
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->toBitmap(Landroid/graphics/drawable/Drawable; I I Landroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    move-result-object v2
    return-object v2
.end method

.method static synthetic toBitmapOrNull$default(com.bytedance.trae.push.impl.CustomNotificationBuilder  android.graphics.drawable.Drawable  int  int  android.graphics.Bitmap$Config  int  java.lang.Object)android.graphics.Bitmap
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +006h
    invoke-virtual v1, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I
    move-result v2
    and-int/lit8 v6, v5, 2
    if-eqz v6, +006h
    invoke-virtual v1, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I
    move-result v3
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->toBitmapOrNull(Landroid/graphics/drawable/Drawable; I I Landroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    move-result-object v0
    return-object v0
.end method

.method public buildNotification(android.content.Context  int  com.bytedance.push.PushBody  android.graphics.Bitmap)android.app.Notification
    .registers 11
    # ins_size=5
    const/4 v7, 0
    if-eqz v9, +012h
    iget-object v0, v9, Lcom/bytedance/push/PushBody;->text Ljava/lang/String;
    if-eqz v0, +00eh
    const-string v1, "\n"
    const-string v2, "
"
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v7
    new-instance v1, Landroidx/core/app/NotificationCompat$Builder;
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v2
    check-cast v2, Landroid/content/Context;
    iget-object v3, v6, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->CHANNEL_ID Ljava/lang/String;
    invoke-direct v1, v2, v3, Landroidx/core/app/NotificationCompat$Builder;-><init>(Landroid/content/Context; Ljava/lang/String;)V
    invoke-direct v6, v9, v8, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->buildPushPendingIntent(Lcom/bytedance/push/PushBody; I)Landroid/app/PendingIntent;
    move-result-object v8
    invoke-virtual v1, v8, Landroidx/core/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroidx/core/app/NotificationCompat$Builder;
    move-result-object v8
    if-eqz v9, +005h
    iget-object v1, v9, Lcom/bytedance/push/PushBody;->groupId Ljava/lang/String;
    goto +2h
    move-object v1, v7
    invoke-virtual v8, v1, Landroidx/core/app/NotificationCompat$Builder;->setGroup(Ljava/lang/String;)Landroidx/core/app/NotificationCompat$Builder;
    move-result-object v8
    const/4 v1, 1
    invoke-virtual v8, v1, Landroidx/core/app/NotificationCompat$Builder;->setAutoCancel(Z)Landroidx/core/app/NotificationCompat$Builder;
    move-result-object v8
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppIconId()I
    move-result v2
    invoke-virtual v8, v2, Landroidx/core/app/NotificationCompat$Builder;->setSmallIcon(I)Landroidx/core/app/NotificationCompat$Builder;
    move-result-object v8
    if-eqz v9, +004h
    iget-object v7, v9, Lcom/bytedance/push/PushBody;->title Ljava/lang/String;
    check-cast v7, Ljava/lang/CharSequence;
    invoke-virtual v8, v7, Landroidx/core/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroidx/core/app/NotificationCompat$Builder;
    move-result-object v7
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v7, v0, Landroidx/core/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroidx/core/app/NotificationCompat$Builder;
    move-result-object v7
    const/4 v8, 0
    if-eqz v9, +007h
    iget-boolean v0, v9, Lcom/bytedance/push/PushBody;->showWhen Z
    if-ne v0, v1, +003h
    goto +2h
    move v1, v8
    invoke-virtual v7, v1, Landroidx/core/app/NotificationCompat$Builder;->setShowWhen(Z)Landroidx/core/app/NotificationCompat$Builder;
    move-result-object v7
    const-string/jumbo v8, setShowWhen(...)
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v6, v7, v10, v9, Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;->setNotificationIconStyle(Landroidx/core/app/NotificationCompat$Builder; Landroid/graphics/Bitmap; Lcom/bytedance/push/PushBody;)V
    invoke-virtual v7, Landroidx/core/app/NotificationCompat$Builder;->build()Landroid/app/Notification;
    move-result-object v7
    const-string v8, "build(...)"
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v7
.end method
