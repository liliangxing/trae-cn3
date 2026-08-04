# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/zlink/ZlinkInitializer;
.super Ljava/lang/Object;
.source "ZlinkInitializer.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/zlink/ZlinkInitializer;
.field private static final TAG:Ljava/lang/String;
.field private static bridge initialized:Z


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/zlink/ZlinkInitializer;
    invoke-direct v0, Lcom/bytedance/trae/home/zlink/ZlinkInitializer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/zlink/ZlinkInitializer;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkInitializer;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/zlink/ZlinkInitializer;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final initAfterPrivacyAgreed(android.app.Application)void
    .registers 4
    # ins_size=2
    const-string v0, "application"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/home/zlink/ZlinkInitializer;->initialized Z
    const-string v1, "ZlinkInitializer"
    if-eqz v0, +008h
    const-string v3, "Already initialized, skip"
    invoke-static v1, v3, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
    const-string v0, "initAfterPrivacyAgreed"
    invoke-static v1, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v0, Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;->INSTANCE Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;
    invoke-virtual v0, Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;->getInit()Z
    move-result v0
    if-nez v0, +007h
    sget-object v0, Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;->INSTANCE Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;
    invoke-virtual v0, v3, Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;->init(Landroid/app/Application;)V
    sget-object v0, Lcom/bytedance/trae/home/zlink/ZlinkSetup;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkSetup;
    invoke-virtual v0, v3, Lcom/bytedance/trae/home/zlink/ZlinkSetup;->buildDependAbility(Landroid/app/Application;)Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility;
    move-result-object v3
    sget-object v0, Lcom/bytedance/ug/sdk/deeplink/ZlinkApi;->INSTANCE Lcom/bytedance/ug/sdk/deeplink/ZlinkApi;
    invoke-virtual v0, v3, Lcom/bytedance/ug/sdk/deeplink/ZlinkApi;->init(Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility;)V
    const/4 v3, 1
    sput-boolean v3, Lcom/bytedance/trae/home/zlink/ZlinkInitializer;->initialized Z
    return-void 
.end method

.method public final registerLifeCycle(android.app.Application)void
    .registers 4
    # ins_size=2
    const-string v0, "application"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "ZlinkInitializer"
    const-string v1, "registerLifeCycle"
    invoke-static v0, v1, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v0, Lcom/bytedance/ug/sdk/deeplink/ZlinkApi;->INSTANCE Lcom/bytedance/ug/sdk/deeplink/ZlinkApi;
    invoke-virtual v0, v3, Lcom/bytedance/ug/sdk/deeplink/ZlinkApi;->registerLifeCycle(Landroid/app/Application;)V
    return-void 
.end method
