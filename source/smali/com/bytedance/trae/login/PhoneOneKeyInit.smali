# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/PhoneOneKeyInit;
.super Ljava/lang/Object;
.source "PhoneOneKeyInit.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/PhoneOneKeyInit;
.field private static final TAG:Ljava/lang/String;
.field private static bridge initialized:Z


.method public static synthetic $r8$lambda$erAkgtCZzYzGjjtea1l449VpDd4(java.lang.String  org.json.JSONObject)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/PhoneOneKeyInit;->init$lambda$1$lambda$0(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/PhoneOneKeyInit;
    invoke-direct v0, Lcom/bytedance/trae/login/PhoneOneKeyInit;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/PhoneOneKeyInit;->INSTANCE Lcom/bytedance/trae/login/PhoneOneKeyInit;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final init$lambda$1$lambda$0(java.lang.String  org.json.JSONObject)void
    .registers 3
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v0, 32
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "PhoneOneKeyInit"
    invoke-static v2, v1, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public final init()void
    .registers 8
    # ins_size=1
    const-string v0, "OneKey login SDK init failed: "
    sget-boolean v1, Lcom/bytedance/trae/login/PhoneOneKeyInit;->initialized Z
    if-eqz v1, +003h
    return-void 
    monitor-enter v7
    sget-boolean v1, Lcom/bytedance/trae/login/PhoneOneKeyInit;->initialized Z
    if-eqz v1, +004h
    monitor-exit v7
    return-void 
    new-instance v1, Lcom/bytedance/sdk/account/platform/onekey/OnekeyLoginConfig;
    new-instance v2, Lcom/bytedance/trae/login/PhoneOneKeyInit$$ExternalSyntheticLambda0;
    invoke-direct v2, Lcom/bytedance/trae/login/PhoneOneKeyInit$$ExternalSyntheticLambda0;-><init>()V
    invoke-direct v1, v2, Lcom/bytedance/sdk/account/platform/onekey/OnekeyLoginConfig;-><init>(Lcom/bytedance/sdk/account/platform/onekey/IOnekeyMonitor;)V
    const/4 v2, 0
    invoke-virtual v1, v2, Lcom/bytedance/sdk/account/platform/onekey/OnekeyLoginConfig;->getDefault(Z)Lcom/bytedance/sdk/account/platform/onekey/OnekeyLoginConfig;
    move-result-object v1
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    check-cast v3, Landroid/content/Context;
    const/4 v4, 1
    new-array v5, v4, [Lcom/bytedance/sdk/account/platform/onekey/OnekeyLoginServiceIniter;
    new-instance v6, Lcom/bytedance/sdk/account/platform/onekey/OnekeyLoginServiceIniter;
    invoke-direct v6, v1, Lcom/bytedance/sdk/account/platform/onekey/OnekeyLoginServiceIniter;-><init>(Lcom/bytedance/sdk/account/platform/onekey/OnekeyLoginConfig;)V
    aput-object v6, v5, v2
    check-cast v5, [Lcom/bytedance/sdk/account/platform/base/AuthorizeIniter;
    invoke-static v3, v5, Lcom/bytedance/sdk/account/platform/base/AuthorizeFramework;->init(Landroid/content/Context; [Lcom/bytedance/sdk/account/platform/base/AuthorizeIniter;)V
    sput-boolean v4, Lcom/bytedance/trae/login/PhoneOneKeyInit;->initialized Z
    const-string v1, "PhoneOneKeyInit"
    const-string v2, "OneKey login SDK initialized successfully"
    invoke-static v1, v2, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    goto +18h
    move-exception v1
    const-string v2, "PhoneOneKeyInit"
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v2, v0, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    monitor-exit v7
    return-void 
    move-exception v0
    monitor-exit v7
    throw v0
    :try_start_0x8
    :try_start_0xe
    :try_start_0x3f
.end method
