# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/PluginItem;
.super Ljava/lang/Object;
.source "Models.kt"

.field private final connectorJson:Ljava/lang/String;
.field private final createdAt:Ljava/lang/Long;
.field private final description:Ljava/lang/String;
.field private final dirName:Ljava/lang/String;
.field private final disabledAbilities:Ljava/util/List;
.field private final displayName:Ljava/lang/String;
.field private final enabled:Z
.field private final iconUrl:Ljava/lang/String;
.field private final marketplacePluginId:Ljava/lang/String;
.field private final name:Ljava/lang/String;
.field private final originPluginName:Ljava/lang/String;
.field private final pluginId:Ljava/lang/String;
.field private final registry:Ljava/lang/String;
.field private final updatedAt:Ljava/lang/Long;
.field private final version:Ljava/lang/String;


.method public constructor <init>()void
    .registers 19
    # ins_size=1
    move-object/from16 v0, v18
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 32767
    const/16 v17, 0
    invoke-direct/range v0 ... v17, Lcom/bytedance/trae/conversation/network/PluginItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/util/List; Ljava/lang/Long; Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  boolean  java.lang.String  java.util.List  java.lang.Long  java.lang.Long)void
    .registers 21
    # ins_size=16
    move-object v0, v5
    move-object v1, v6
    move-object v2, v7
    move-object/from16 v3, v18
    const-string v4, "pluginId"
    invoke-static v6, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "name"
    invoke-static v7, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "disabledAbilities"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->pluginId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->name Ljava/lang/String;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->originPluginName Ljava/lang/String;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->dirName Ljava/lang/String;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->displayName Ljava/lang/String;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->description Ljava/lang/String;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->iconUrl Ljava/lang/String;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->version Ljava/lang/String;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->registry Ljava/lang/String;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->marketplacePluginId Ljava/lang/String;
    move/from16 v1, v16
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->enabled Z
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->connectorJson Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->disabledAbilities Ljava/util/List;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->createdAt Ljava/lang/Long;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->updatedAt Ljava/lang/Long;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  boolean  java.lang.String  java.util.List  java.lang.Long  java.lang.Long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 34
    # ins_size=18
    move/from16 v0, v32
    and-int/lit8 v1, v0, 1
    const-string v2, ""
    if-eqz v1, +004h
    move-object v1, v2
    goto +3h
    move-object/from16 v1, v17
    and-int/lit8 v3, v0, 2
    if-eqz v3, +003h
    goto +3h
    move-object/from16 v2, v18
    and-int/lit8 v3, v0, 4
    const/4 v4, 0
    if-eqz v3, +004h
    move-object v3, v4
    goto +3h
    move-object/from16 v3, v19
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move-object v5, v4
    goto +3h
    move-object/from16 v5, v20
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    move-object v6, v4
    goto +3h
    move-object/from16 v6, v21
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    move-object v7, v4
    goto +3h
    move-object/from16 v7, v22
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    move-object v8, v4
    goto +3h
    move-object/from16 v8, v23
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    move-object v9, v4
    goto +3h
    move-object/from16 v9, v24
    and-int/lit16 v10, v0, 256
    if-eqz v10, +004h
    move-object v10, v4
    goto +3h
    move-object/from16 v10, v25
    and-int/lit16 v11, v0, 512
    if-eqz v11, +004h
    move-object v11, v4
    goto +3h
    move-object/from16 v11, v26
    and-int/lit16 v12, v0, 1024
    if-eqz v12, +004h
    const/4 v12, 1
    goto +3h
    move/from16 v12, v27
    and-int/lit16 v13, v0, 2048
    if-eqz v13, +004h
    move-object v13, v4
    goto +3h
    move-object/from16 v13, v28
    and-int/lit16 v14, v0, 4096
    if-eqz v14, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v14
    goto +3h
    move-object/from16 v14, v29
    and-int/lit16 v15, v0, 8192
    if-eqz v15, +004h
    move-object v15, v4
    goto +3h
    move-object/from16 v15, v30
    and-int/lit16 v0, v0, 16384
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v4, v31
    move-object/from16 v17, v16
    move-object/from16 v18, v1
    move-object/from16 v19, v2
    move-object/from16 v20, v3
    move-object/from16 v21, v5
    move-object/from16 v22, v6
    move-object/from16 v23, v7
    move-object/from16 v24, v8
    move-object/from16 v25, v9
    move-object/from16 v26, v10
    move-object/from16 v27, v11
    move/from16 v28, v12
    move-object/from16 v29, v13
    move-object/from16 v30, v14
    move-object/from16 v31, v15
    move-object/from16 v32, v4
    invoke-direct/range v17 ... v32, Lcom/bytedance/trae/conversation/network/PluginItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/util/List; Ljava/lang/Long; Ljava/lang/Long;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.PluginItem  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  boolean  java.lang.String  java.util.List  java.lang.Long  java.lang.Long  int  java.lang.Object)com.bytedance.trae.conversation.network.PluginItem
    .registers 34
    # ins_size=18
    move-object/from16 v0, v16
    move/from16 v1, v32
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->pluginId Ljava/lang/String;
    goto +3h
    move-object/from16 v2, v17
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->name Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v18
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->originPluginName Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v19
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->dirName Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v20
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->displayName Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v21
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->description Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v22
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->iconUrl Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v23
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->version Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v24
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->registry Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v25
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->marketplacePluginId Ljava/lang/String;
    goto +3h
    move-object/from16 v11, v26
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-boolean v12, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->enabled Z
    goto +3h
    move/from16 v12, v27
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->connectorJson Ljava/lang/String;
    goto +3h
    move-object/from16 v13, v28
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->disabledAbilities Ljava/util/List;
    goto +3h
    move-object/from16 v14, v29
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->createdAt Ljava/lang/Long;
    goto +3h
    move-object/from16 v15, v30
    and-int/lit16 v1, v1, 16384
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/network/PluginItem;->updatedAt Ljava/lang/Long;
    goto +3h
    move-object/from16 v1, v31
    move-object/from16 v17, v2
    move-object/from16 v18, v3
    move-object/from16 v19, v4
    move-object/from16 v20, v5
    move-object/from16 v21, v6
    move-object/from16 v22, v7
    move-object/from16 v23, v8
    move-object/from16 v24, v9
    move-object/from16 v25, v10
    move-object/from16 v26, v11
    move/from16 v27, v12
    move-object/from16 v28, v13
    move-object/from16 v29, v14
    move-object/from16 v30, v15
    move-object/from16 v31, v1
    invoke-virtual/range v16 ... v31, Lcom/bytedance/trae/conversation/network/PluginItem;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/util/List; Ljava/lang/Long; Ljava/lang/Long;)Lcom/bytedance/trae/conversation/network/PluginItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->pluginId Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->marketplacePluginId Ljava/lang/String;
    return-object v0
.end method

.method public final component11()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->enabled Z
    return v0
.end method

.method public final component12()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->connectorJson Ljava/lang/String;
    return-object v0
.end method

.method public final component13()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->disabledAbilities Ljava/util/List;
    return-object v0
.end method

.method public final component14()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->createdAt Ljava/lang/Long;
    return-object v0
.end method

.method public final component15()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->updatedAt Ljava/lang/Long;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->name Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->originPluginName Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->dirName Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->displayName Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->description Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->iconUrl Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->version Ljava/lang/String;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->registry Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  boolean  java.lang.String  java.util.List  java.lang.Long  java.lang.Long)com.bytedance.trae.conversation.network.PluginItem
    .registers 33
    # ins_size=16
    const-string v0, "pluginId"
    move-object/from16 v2, v18
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    move-object/from16 v3, v19
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "disabledAbilities"
    move-object/from16 v14, v30
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/network/PluginItem;
    move-object v1, v0
    move-object/from16 v4, v20
    move-object/from16 v5, v21
    move-object/from16 v6, v22
    move-object/from16 v7, v23
    move-object/from16 v8, v24
    move-object/from16 v9, v25
    move-object/from16 v10, v26
    move-object/from16 v11, v27
    move/from16 v12, v28
    move-object/from16 v13, v29
    move-object/from16 v15, v31
    move-object/from16 v16, v32
    invoke-direct/range v1 ... v16, Lcom/bytedance/trae/conversation/network/PluginItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/util/List; Ljava/lang/Long; Ljava/lang/Long;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/network/PluginItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/network/PluginItem;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/PluginItem;->pluginId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/PluginItem;->pluginId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/PluginItem;->name Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/PluginItem;->name Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/PluginItem;->originPluginName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/PluginItem;->originPluginName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/PluginItem;->dirName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/PluginItem;->dirName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/PluginItem;->displayName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/PluginItem;->displayName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/PluginItem;->description Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/PluginItem;->description Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/PluginItem;->iconUrl Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/PluginItem;->iconUrl Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/PluginItem;->version Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/PluginItem;->version Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/PluginItem;->registry Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/PluginItem;->registry Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/PluginItem;->marketplacePluginId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/PluginItem;->marketplacePluginId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/network/PluginItem;->enabled Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/network/PluginItem;->enabled Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/PluginItem;->connectorJson Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/PluginItem;->connectorJson Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/PluginItem;->disabledAbilities Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/PluginItem;->disabledAbilities Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/PluginItem;->createdAt Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/PluginItem;->createdAt Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/PluginItem;->updatedAt Ljava/lang/Long;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/network/PluginItem;->updatedAt Ljava/lang/Long;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getConnectorJson()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->connectorJson Ljava/lang/String;
    return-object v0
.end method

.method public final getCreatedAt()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->createdAt Ljava/lang/Long;
    return-object v0
.end method

.method public final getDescription()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->description Ljava/lang/String;
    return-object v0
.end method

.method public final getDirName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->dirName Ljava/lang/String;
    return-object v0
.end method

.method public final getDisabledAbilities()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->disabledAbilities Ljava/util/List;
    return-object v0
.end method

.method public final getDisplayName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->displayName Ljava/lang/String;
    return-object v0
.end method

.method public final getEnabled()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->enabled Z
    return v0
.end method

.method public final getIconUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->iconUrl Ljava/lang/String;
    return-object v0
.end method

.method public final getMarketplacePluginId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->marketplacePluginId Ljava/lang/String;
    return-object v0
.end method

.method public final getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->name Ljava/lang/String;
    return-object v0
.end method

.method public final getOriginPluginName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->originPluginName Ljava/lang/String;
    return-object v0
.end method

.method public final getPluginId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->pluginId Ljava/lang/String;
    return-object v0
.end method

.method public final getRegistry()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->registry Ljava/lang/String;
    return-object v0
.end method

.method public final getUpdatedAt()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->updatedAt Ljava/lang/Long;
    return-object v0
.end method

.method public final getVersion()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/PluginItem;->version Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->pluginId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->name Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->originPluginName Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->dirName Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->displayName Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->description Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->iconUrl Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->version Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->registry Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->marketplacePluginId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->enabled Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->connectorJson Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->disabledAbilities Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->createdAt Ljava/lang/Long;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->updatedAt Ljava/lang/Long;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "PluginItem(pluginId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->pluginId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", name="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->name Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", originPluginName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->originPluginName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", dirName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->dirName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", displayName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->displayName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", description="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->description Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", iconUrl="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->iconUrl Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", version="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->version Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", registry="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->registry Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", marketplacePluginId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->marketplacePluginId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", enabled="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->enabled Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", connectorJson="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->connectorJson Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", disabledAbilities="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->disabledAbilities Ljava/util/List;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", createdAt="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->createdAt Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", updatedAt="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/PluginItem;->updatedAt Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
