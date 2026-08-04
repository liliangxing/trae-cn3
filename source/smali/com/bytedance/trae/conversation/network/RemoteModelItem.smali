# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/RemoteModelItem;
.super Ljava/lang/Object;
.source "Models.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
.field private final configSource:Ljava/lang/Integer;
.field private final customModelId:Ljava/lang/String;
.field private final displayName:Ljava/lang/String;
.field private final features:Ljava/lang/String;
.field private final iconDark:Ljava/lang/String;
.field private final iconLight:Ljava/lang/String;
.field private final id:Ljava/lang/String;
.field private final isBuiltin:Z
.field private final isDefault:Z
.field private final isInternalUsageLimit:Ljava/lang/Boolean;
.field private final isPreset:Ljava/lang/Boolean;
.field private final multimodal:Ljava/lang/Boolean;
.field private final name:Ljava/lang/String;
.field private final provider:Ljava/lang/String;
.field private final rawModel:Lcom/google/gson/JsonObject;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  com.google.gson.JsonObject  boolean)void
    .registers 21
    # ins_size=16
    move-object v0, v5
    move-object v1, v6
    move-object v2, v7
    move-object v3, v8
    const-string v4, "id"
    invoke-static v6, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "name"
    invoke-static v7, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "displayName"
    invoke-static v8, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->id Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->name Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->displayName Ljava/lang/String;
    move v1, v9
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isBuiltin Z
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->multimodal Ljava/lang/Boolean;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isPreset Ljava/lang/Boolean;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->configSource Ljava/lang/Integer;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->provider Ljava/lang/String;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->customModelId Ljava/lang/String;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->iconLight Ljava/lang/String;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->iconDark Ljava/lang/String;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isInternalUsageLimit Ljava/lang/Boolean;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->features Ljava/lang/String;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->rawModel Lcom/google/gson/JsonObject;
    move/from16 v1, v20
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isDefault Z
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  com.google.gson.JsonObject  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 36
    # ins_size=18
    move/from16 v0, v34
    and-int/lit8 v1, v0, 4
    if-eqz v1, +005h
    move-object/from16 v5, v20
    goto +3h
    move-object/from16 v5, v21
    and-int/lit8 v1, v0, 8
    if-eqz v1, +005h
    const/4 v1, 1
    move v6, v1
    goto +3h
    move/from16 v6, v22
    and-int/lit8 v1, v0, 16
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v1, v0, 32
    if-eqz v1, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v24
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v25
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v26
    and-int/lit16 v1, v0, 256
    if-eqz v1, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v27
    and-int/lit16 v1, v0, 512
    if-eqz v1, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v28
    and-int/lit16 v1, v0, 1024
    if-eqz v1, +004h
    move-object v13, v2
    goto +3h
    move-object/from16 v13, v29
    and-int/lit16 v1, v0, 2048
    if-eqz v1, +004h
    move-object v14, v2
    goto +3h
    move-object/from16 v14, v30
    and-int/lit16 v1, v0, 4096
    if-eqz v1, +004h
    move-object v15, v2
    goto +3h
    move-object/from16 v15, v31
    and-int/lit16 v1, v0, 8192
    if-eqz v1, +005h
    move-object/from16 v16, v2
    goto +3h
    move-object/from16 v16, v32
    and-int/lit16 v0, v0, 16384
    if-eqz v0, +006h
    const/4 v0, 0
    move/from16 v17, v0
    goto +3h
    move/from16 v17, v33
    move-object/from16 v2, v18
    move-object/from16 v3, v19
    move-object/from16 v4, v20
    invoke-direct/range v2 ... v17, Lcom/bytedance/trae/conversation/network/RemoteModelItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Lcom/google/gson/JsonObject; Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.RemoteModelItem  java.lang.String  java.lang.String  java.lang.String  boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  com.google.gson.JsonObject  boolean  int  java.lang.Object)com.bytedance.trae.conversation.network.RemoteModelItem
    .registers 34
    # ins_size=18
    move-object/from16 v0, v16
    move/from16 v1, v32
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->id Ljava/lang/String;
    goto +3h
    move-object/from16 v2, v17
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->name Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v18
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->displayName Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v19
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-boolean v5, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isBuiltin Z
    goto +3h
    move/from16 v5, v20
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->multimodal Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v6, v21
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isPreset Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v7, v22
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->configSource Ljava/lang/Integer;
    goto +3h
    move-object/from16 v8, v23
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->provider Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v24
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->customModelId Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v25
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->iconLight Ljava/lang/String;
    goto +3h
    move-object/from16 v11, v26
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->iconDark Ljava/lang/String;
    goto +3h
    move-object/from16 v12, v27
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isInternalUsageLimit Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v13, v28
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->features Ljava/lang/String;
    goto +3h
    move-object/from16 v14, v29
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->rawModel Lcom/google/gson/JsonObject;
    goto +3h
    move-object/from16 v15, v30
    and-int/lit16 v1, v1, 16384
    if-eqz v1, +005h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isDefault Z
    goto +3h
    move/from16 v1, v31
    move-object/from16 v17, v2
    move-object/from16 v18, v3
    move-object/from16 v19, v4
    move/from16 v20, v5
    move-object/from16 v21, v6
    move-object/from16 v22, v7
    move-object/from16 v23, v8
    move-object/from16 v24, v9
    move-object/from16 v25, v10
    move-object/from16 v26, v11
    move-object/from16 v27, v12
    move-object/from16 v28, v13
    move-object/from16 v29, v14
    move-object/from16 v30, v15
    move/from16 v31, v1
    invoke-virtual/range v16 ... v31, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Lcom/google/gson/JsonObject; Z)Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->id Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->iconLight Ljava/lang/String;
    return-object v0
.end method

.method public final component11()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->iconDark Ljava/lang/String;
    return-object v0
.end method

.method public final component12()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isInternalUsageLimit Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component13()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->features Ljava/lang/String;
    return-object v0
.end method

.method public final component14()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->rawModel Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final component15()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isDefault Z
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->name Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->displayName Ljava/lang/String;
    return-object v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isBuiltin Z
    return v0
.end method

.method public final component5()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->multimodal Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component6()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isPreset Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component7()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->configSource Ljava/lang/Integer;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->provider Ljava/lang/String;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->customModelId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  com.google.gson.JsonObject  boolean)com.bytedance.trae.conversation.network.RemoteModelItem
    .registers 33
    # ins_size=16
    const-string v0, "id"
    move-object/from16 v2, v18
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    move-object/from16 v3, v19
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "displayName"
    move-object/from16 v4, v20
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-object v1, v0
    move/from16 v5, v21
    move-object/from16 v6, v22
    move-object/from16 v7, v23
    move-object/from16 v8, v24
    move-object/from16 v9, v25
    move-object/from16 v10, v26
    move-object/from16 v11, v27
    move-object/from16 v12, v28
    move-object/from16 v13, v29
    move-object/from16 v14, v30
    move-object/from16 v15, v31
    move/from16 v16, v32
    invoke-direct/range v1 ... v16, Lcom/bytedance/trae/conversation/network/RemoteModelItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Lcom/google/gson/JsonObject; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->id Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->id Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->name Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->name Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->displayName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->displayName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isBuiltin Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isBuiltin Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->multimodal Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->multimodal Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isPreset Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isPreset Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->configSource Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->configSource Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->provider Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->provider Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->customModelId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->customModelId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->iconLight Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->iconLight Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->iconDark Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->iconDark Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isInternalUsageLimit Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isInternalUsageLimit Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->features Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->features Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->rawModel Lcom/google/gson/JsonObject;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->rawModel Lcom/google/gson/JsonObject;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isDefault Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isDefault Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getConfigSource()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->configSource Ljava/lang/Integer;
    return-object v0
.end method

.method public final getCustomModelId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->customModelId Ljava/lang/String;
    return-object v0
.end method

.method public final getDisplayName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->displayName Ljava/lang/String;
    return-object v0
.end method

.method public final getFeatures()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->features Ljava/lang/String;
    return-object v0
.end method

.method public final getIconDark()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->iconDark Ljava/lang/String;
    return-object v0
.end method

.method public final getIconLight()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->iconLight Ljava/lang/String;
    return-object v0
.end method

.method public final getId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->id Ljava/lang/String;
    return-object v0
.end method

.method public final getMultimodal()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->multimodal Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->name Ljava/lang/String;
    return-object v0
.end method

.method public final getProvider()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->provider Ljava/lang/String;
    return-object v0
.end method

.method public final getRawModel()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->rawModel Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->id Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->name Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->displayName Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isBuiltin Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->multimodal Ljava/lang/Boolean;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isPreset Ljava/lang/Boolean;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->configSource Ljava/lang/Integer;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->provider Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->customModelId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->iconLight Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->iconDark Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isInternalUsageLimit Ljava/lang/Boolean;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->features Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->rawModel Lcom/google/gson/JsonObject;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/google/gson/JsonObject;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isDefault Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isBuiltin()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isBuiltin Z
    return v0
.end method

.method public final isDefault()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isDefault Z
    return v0
.end method

.method public final isInternalUsageLimit()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isInternalUsageLimit Ljava/lang/Boolean;
    return-object v0
.end method

.method public final isPreset()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isPreset Ljava/lang/Boolean;
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "RemoteModelItem(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->id Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", name="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->name Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", displayName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->displayName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isBuiltin="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isBuiltin Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", multimodal="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->multimodal Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isPreset="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isPreset Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", configSource="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->configSource Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", provider="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->provider Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", customModelId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->customModelId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", iconLight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->iconLight Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", iconDark="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->iconDark Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isInternalUsageLimit="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isInternalUsageLimit Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", features="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->features Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", rawModel="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->rawModel Lcom/google/gson/JsonObject;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isDefault="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isDefault Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
