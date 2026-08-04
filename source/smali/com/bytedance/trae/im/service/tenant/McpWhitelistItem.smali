# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;
.super Ljava/lang/Object;
.source "TenantUserConfigModels.kt"

.field private final argsHash:Ljava/lang/String;
.field private final command:Ljava/lang/String;
.field private final configJson:Ljava/lang/String;
.field private final enable:Z
.field private final mtime:J
.field private final name:Ljava/lang/String;
.field private final rawArg:Lcom/google/gson/JsonElement;
.field private final source:I
.field private final status:I
.field private final type:Ljava/lang/String;
.field private final url:Ljava/lang/String;


.method public constructor <init>()void
    .registers 16
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const-wide/16 v8, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 2047
    const/4 v14, 0
    move-object v0, v15
    invoke-direct/range v0 ... v14, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonElement; Ljava/lang/String; Ljava/lang/String; Z I J I Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  com.google.gson.JsonElement  java.lang.String  java.lang.String  boolean  int  long  int  java.lang.String  java.lang.String)void
    .registers 13
    # ins_size=13
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->name Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->command Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->rawArg Lcom/google/gson/JsonElement;
    iput-object v4, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->argsHash Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->configJson Ljava/lang/String;
    iput-boolean v6, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->enable Z
    iput v7, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->source I
    iput-wide v8, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->mtime J
    iput v10, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->status I
    iput-object v11, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->type Ljava/lang/String;
    iput-object v12, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->url Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  com.google.gson.JsonElement  java.lang.String  java.lang.String  boolean  int  long  int  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 28
    # ins_size=15
    move/from16 v0, v26
    and-int/lit8 v1, v0, 1
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v1, v2
    goto +2h
    move-object v1, v14
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    move-object v3, v2
    goto +2h
    move-object v3, v15
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    move-object v4, v2
    goto +3h
    move-object/from16 v4, v16
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move-object v5, v2
    goto +3h
    move-object/from16 v5, v17
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v18
    and-int/lit8 v7, v0, 32
    const/4 v8, 0
    if-eqz v7, +004h
    move v7, v8
    goto +3h
    move/from16 v7, v19
    and-int/lit8 v9, v0, 64
    if-eqz v9, +004h
    move v9, v8
    goto +3h
    move/from16 v9, v20
    and-int/lit16 v10, v0, 128
    if-eqz v10, +005h
    const-wide/16 v10, 0
    goto +3h
    move-wide/from16 v10, v21
    and-int/lit16 v12, v0, 256
    if-eqz v12, +003h
    goto +3h
    move/from16 v8, v23
    and-int/lit16 v12, v0, 512
    if-eqz v12, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v24
    and-int/lit16 v0, v0, 1024
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v25
    move-object v14, v13
    move-object v15, v1
    move-object/from16 v16, v3
    move-object/from16 v17, v4
    move-object/from16 v18, v5
    move-object/from16 v19, v6
    move/from16 v20, v7
    move/from16 v21, v9
    move-wide/from16 v22, v10
    move/from16 v24, v8
    move-object/from16 v25, v12
    move-object/from16 v26, v2
    invoke-direct/range v14 ... v26, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonElement; Ljava/lang/String; Ljava/lang/String; Z I J I Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final component3()com.google.gson.JsonElement
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->rawArg Lcom/google/gson/JsonElement;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.tenant.McpWhitelistItem  java.lang.String  java.lang.String  com.google.gson.JsonElement  java.lang.String  java.lang.String  boolean  int  long  int  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.im.service.tenant.McpWhitelistItem
    .registers 28
    # ins_size=15
    move-object v0, v13
    move/from16 v1, v26
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->name Ljava/lang/String;
    goto +2h
    move-object v2, v14
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->command Ljava/lang/String;
    goto +2h
    move-object v3, v15
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->rawArg Lcom/google/gson/JsonElement;
    goto +3h
    move-object/from16 v4, v16
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->argsHash Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v17
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->configJson Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v18
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-boolean v7, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->enable Z
    goto +3h
    move/from16 v7, v19
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget v8, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->source I
    goto +3h
    move/from16 v8, v20
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-wide v9, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->mtime J
    goto +3h
    move-wide/from16 v9, v21
    and-int/lit16 v11, v1, 256
    if-eqz v11, +005h
    iget v11, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->status I
    goto +3h
    move/from16 v11, v23
    and-int/lit16 v12, v1, 512
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->type Ljava/lang/String;
    goto +3h
    move-object/from16 v12, v24
    and-int/lit16 v1, v1, 1024
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->url Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v25
    move-object v14, v2
    move-object v15, v3
    move-object/from16 v16, v4
    move-object/from16 v17, v5
    move-object/from16 v18, v6
    move/from16 v19, v7
    move/from16 v20, v8
    move-wide/from16 v21, v9
    move/from16 v23, v11
    move-object/from16 v24, v12
    move-object/from16 v25, v1
    invoke-virtual/range v13 ... v25, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->copy(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonElement; Ljava/lang/String; Ljava/lang/String; Z I J I Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->name Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->type Ljava/lang/String;
    return-object v0
.end method

.method public final component11()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->url Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->command Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->argsHash Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->configJson Ljava/lang/String;
    return-object v0
.end method

.method public final component6()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->enable Z
    return v0
.end method

.method public final component7()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->source I
    return v0
.end method

.method public final component8()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->mtime J
    return-wide v0
.end method

.method public final component9()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->status I
    return v0
.end method

.method public final copy(java.lang.String  java.lang.String  com.google.gson.JsonElement  java.lang.String  java.lang.String  boolean  int  long  int  java.lang.String  java.lang.String)com.bytedance.trae.im.service.tenant.McpWhitelistItem
    .registers 27
    # ins_size=13
    new-instance v13, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;
    move-object v0, v13
    move-object v1, v15
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v4, v18
    move-object/from16 v5, v19
    move/from16 v6, v20
    move/from16 v7, v21
    move-wide/from16 v8, v22
    move/from16 v10, v24
    move-object/from16 v11, v25
    move-object/from16 v12, v26
    invoke-direct/range v0 ... v12, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonElement; Ljava/lang/String; Ljava/lang/String; Z I J I Ljava/lang/String; Ljava/lang/String;)V
    return-object v13
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;
    iget-object v1, v7, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->name Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->name Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->command Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->command Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->rawArg Lcom/google/gson/JsonElement;
    iget-object v3, v8, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->rawArg Lcom/google/gson/JsonElement;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->argsHash Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->argsHash Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->configJson Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->configJson Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->enable Z
    iget-boolean v3, v8, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->enable Z
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->source I
    iget v3, v8, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->source I
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->mtime J
    iget-wide v5, v8, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->mtime J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->status I
    iget v3, v8, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->status I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->type Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->type Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->url Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->url Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getArg()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->rawArg Lcom/google/gson/JsonElement;
    invoke-static v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigModelsKt;->access$stringListFromArrayOrJsonString(Lcom/google/gson/JsonElement;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public final getArgsHash()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->argsHash Ljava/lang/String;
    return-object v0
.end method

.method public final getCommand()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->command Ljava/lang/String;
    return-object v0
.end method

.method public final getConfigJson()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->configJson Ljava/lang/String;
    return-object v0
.end method

.method public final getEnable()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->enable Z
    return v0
.end method

.method public final getMtime()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->mtime J
    return-wide v0
.end method

.method public final getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->name Ljava/lang/String;
    return-object v0
.end method

.method public final getSource()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->source I
    return v0
.end method

.method public final getStatus()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->status I
    return v0
.end method

.method public final getType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->type Ljava/lang/String;
    return-object v0
.end method

.method public final getUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->url Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->name Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->command Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->rawArg Lcom/google/gson/JsonElement;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->argsHash Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->configJson Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-boolean v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->enable Z
    invoke-static v2, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->source I
    invoke-static v2, Ljava/lang/Integer;->hashCode(I)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-wide v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->mtime J
    invoke-static v2, v3, Ljava/lang/Long;->hashCode(J)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->status I
    invoke-static v2, Ljava/lang/Integer;->hashCode(I)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->type Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->url Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 5
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "McpWhitelistItem(name="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->name Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", command="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->command Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", rawArg="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->rawArg Lcom/google/gson/JsonElement;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", argsHash="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->argsHash Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", configJson="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->configJson Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", enable="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->enable Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", source="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->source I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", mtime="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->mtime J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", status="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->status I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", type="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->type Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", url="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;->url Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
