# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/common/widget/CustomToast;
.super Ljava/lang/Object;
.source "CustomToast.java"

.field private static final MAIN_HANDLER:Landroid/os/Handler;
.field private static bridge sLastShownMessageForTest:Ljava/lang/String;
.field private static sToast:Landroid/widget/Toast;


.method public static synthetic $r8$lambda$lQQJWPgQ-vsMouqOAuFwOQiKHlc()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/common/widget/CustomToast;->cancelInternalForTest()V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    sput-object v0, Lcom/bytedance/trae/common/widget/CustomToast;->MAIN_HANDLER Landroid/os/Handler;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static cancelInternalForTest()void
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/common/widget/CustomToast;->sToast Landroid/widget/Toast;
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-virtual v0, Landroid/widget/Toast;->cancel()V
    sput-object v1, Lcom/bytedance/trae/common/widget/CustomToast;->sToast Landroid/widget/Toast;
    sput-object v1, Lcom/bytedance/trae/common/widget/CustomToast;->sLastShownMessageForTest Ljava/lang/String;
    return-void 
.end method

.method public static cancelLastShownMessageForTest()void
    .registers 2
    # ins_size=0
    invoke-static Landroid/os/Looper;->myLooper()Landroid/os/Looper;
    move-result-object v0
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    if-ne v0, v1, +006h
    invoke-static Lcom/bytedance/trae/common/widget/CustomToast;->cancelInternalForTest()V
    goto +bh
    sget-object v0, Lcom/bytedance/trae/common/widget/CustomToast;->MAIN_HANDLER Landroid/os/Handler;
    new-instance v1, Lcom/bytedance/trae/common/widget/CustomToast$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/common/widget/CustomToast$$ExternalSyntheticLambda0;-><init>()V
    invoke-virtual v0, v1, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method public static clearLastShownMessageForTest()void
    .registers 1
    # ins_size=0
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/common/widget/CustomToast;->sLastShownMessageForTest Ljava/lang/String;
    return-void 
.end method

.method public static getLastShownMessageForTest()java.lang.String
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/common/widget/CustomToast;->sLastShownMessageForTest Ljava/lang/String;
    return-object v0
.end method

.method static synthetic lambda$show$0(android.content.Context  java.lang.String  int)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/common/widget/CustomToast;->showInternal(Landroid/content/Context; Ljava/lang/String; I)V
    return-void 
.end method

.method private static show(android.content.Context  java.lang.String  int)void
    .registers 5
    # ins_size=3
    invoke-static Landroid/os/Looper;->myLooper()Landroid/os/Looper;
    move-result-object v0
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    if-ne v0, v1, +00ah
    invoke-virtual v2, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v2
    invoke-static v2, v3, v4, Lcom/bytedance/trae/common/widget/CustomToast;->showInternal(Landroid/content/Context; Ljava/lang/String; I)V
    goto +fh
    invoke-virtual v2, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v2
    sget-object v0, Lcom/bytedance/trae/common/widget/CustomToast;->MAIN_HANDLER Landroid/os/Handler;
    new-instance v1, Lcom/bytedance/trae/common/widget/CustomToast$$ExternalSyntheticLambda1;
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/common/widget/CustomToast$$ExternalSyntheticLambda1;-><init>(Landroid/content/Context; Ljava/lang/String; I)V
    invoke-virtual v0, v1, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static showInternal(android.content.Context  java.lang.String  int)void
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/common/widget/CustomToast;->sToast Landroid/widget/Toast;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/widget/Toast;->cancel()V
    sput-object v2, Lcom/bytedance/trae/common/widget/CustomToast;->sLastShownMessageForTest Ljava/lang/String;
    invoke-static v1, v2, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/common/widget/CustomToast;->sToast Landroid/widget/Toast;
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method public static showLong(android.content.Context  int)void
    .registers 3
    # ins_size=2
    invoke-virtual v1, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    const/4 v0, 1
    invoke-static v1, v2, v0, Lcom/bytedance/trae/common/widget/CustomToast;->show(Landroid/content/Context; Ljava/lang/String; I)V
    return-void 
.end method

.method public static showLong(android.content.Context  java.lang.String)void
    .registers 3
    # ins_size=2
    const/4 v0, 1
    invoke-static v1, v2, v0, Lcom/bytedance/trae/common/widget/CustomToast;->show(Landroid/content/Context; Ljava/lang/String; I)V
    return-void 
.end method

.method public static showShort(android.content.Context  int)void
    .registers 3
    # ins_size=2
    invoke-virtual v1, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    const/4 v0, 0
    invoke-static v1, v2, v0, Lcom/bytedance/trae/common/widget/CustomToast;->show(Landroid/content/Context; Ljava/lang/String; I)V
    return-void 
.end method

.method public static showShort(android.content.Context  java.lang.String)void
    .registers 3
    # ins_size=2
    const/4 v0, 0
    invoke-static v1, v2, v0, Lcom/bytedance/trae/common/widget/CustomToast;->show(Landroid/content/Context; Ljava/lang/String; I)V
    return-void 
.end method
