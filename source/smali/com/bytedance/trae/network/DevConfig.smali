# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/DevConfig;
.super Ljava/lang/Object;
.source "DevConfig.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/network/DevConfig;
.field private static final flagFile:Ljava/io/File;
.field private static final opaqueDataEnable:Z


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/DevConfig;
    invoke-direct v0, Lcom/bytedance/trae/network/DevConfig;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/DevConfig;->INSTANCE Lcom/bytedance/trae/network/DevConfig;
    new-instance v0, Ljava/io/File;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v2
    invoke-virtual v2, Landroid/app/Application;->getFilesDir()Ljava/io/File;
    move-result-object v2
    invoke-virtual v2, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "/enable_opaque_data.flag"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Ljava/io/File;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/network/DevConfig;->flagFile Ljava/io/File;
    invoke-virtual v0, Ljava/io/File;->exists()Z
    move-result v0
    sput-boolean v0, Lcom/bytedance/trae/network/DevConfig;->opaqueDataEnable Z
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getOpaqueDataEnable()boolean
    .registers 2
    # ins_size=1
    sget-boolean v0, Lcom/bytedance/trae/network/DevConfig;->opaqueDataEnable Z
    return v0
.end method

.method public final initHttpEnv()com.bytedance.trae.platform.model.HttpEnvConfig
    .registers 16
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v0, Lcom/bytedance/trae/network/DebugSettings;->getPpeEnv()Ljava/lang/String;
    move-result-object v5
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +00eh
    new-instance v0, Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 1
    const/4 v6, 3
    const/4 v7, 0
    move-object v1, v0
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/platform/model/HttpEnvConfig;-><init>(Z Ljava/lang/String; Z Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    new-instance v0, Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 15
    const/4 v14, 0
    move-object v8, v0
    invoke-direct/range v8 ... v14, Lcom/bytedance/trae/platform/model/HttpEnvConfig;-><init>(Z Ljava/lang/String; Z Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method

.method public final updateHttpEnv(boolean  java.lang.String  boolean  java.lang.String)void
    .registers 5
    # ins_size=5
    const-string v1, "boeEnv"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, ppeEnv
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public final updateOpaqueDataEnable(boolean)void
    .registers 4
    # ins_size=2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/network/DevConfig;
    sget-object v0, Lcom/bytedance/trae/network/DevConfig;->flagFile Ljava/io/File;
    if-eqz v3, +011h
    invoke-virtual v0, Ljava/io/File;->exists()Z
    move-result v1
    if-nez v1, +00bh
    invoke-virtual v0, Ljava/io/File;->createNewFile()Z
    move-result v3
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    goto +14h
    if-nez v3, +011h
    invoke-virtual v0, Ljava/io/File;->exists()Z
    move-result v3
    if-eqz v3, +00bh
    invoke-virtual v0, Ljava/io/File;->delete()Z
    move-result v3
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    goto +3h
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x0
.end method
