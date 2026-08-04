# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;
.super Ljava/lang/Object;
.source "TenantUserConfigModels.kt"

.field public static final ACTION_TYPE_BLOCK:I
.field public static final ACTION_TYPE_DESENSITIZE:I
.field public static final Companion:Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule$Companion;
.field public static final EXECUTION_POINT_PRE:I
.field public static final SCENE_TYPE_CHAT:I
.field private final actionType:Ljava/lang/Integer;
.field private final isEnabled:Z
.field private final rawExecutionPoints:Ljava/util/List;
.field private final rawRuleDetails:Ljava/util/List;
.field private final rawRuleId:Lcom/google/gson/JsonElement;
.field private final ruleName:Ljava/lang/String;
.field private final ruleType:Ljava/lang/Integer;
.field private final sceneType:Ljava/lang/Integer;
.field private final tenantId:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->Companion Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 13
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 511
    const/4 v11, 0
    move-object v0, v12
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;-><init>(Lcom/google/gson/JsonElement; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/util/List; Ljava/lang/Integer; Z Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.google.gson.JsonElement  java.lang.String  java.lang.String  java.lang.Integer  java.lang.Integer  java.util.List  java.lang.Integer  boolean  java.util.List)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawRuleId Lcom/google/gson/JsonElement;
    iput-object v2, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->tenantId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->ruleName Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->ruleType Ljava/lang/Integer;
    iput-object v5, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->sceneType Ljava/lang/Integer;
    iput-object v6, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawExecutionPoints Ljava/util/List;
    iput-object v7, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->actionType Ljava/lang/Integer;
    iput-boolean v8, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->isEnabled Z
    iput-object v9, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawRuleDetails Ljava/util/List;
    return-void 
.end method

.method public synthetic constructor <init>(com.google.gson.JsonElement  java.lang.String  java.lang.String  java.lang.Integer  java.lang.Integer  java.util.List  java.lang.Integer  boolean  java.util.List  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 22
    # ins_size=12
    move/from16 v0, v20
    and-int/lit8 v1, v0, 1
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v1, v2
    goto +2h
    move-object v1, v11
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    move-object v3, v2
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    move-object v4, v2
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move-object v5, v2
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    move-object v6, v2
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v17
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    const/4 v9, 0
    goto +3h
    move/from16 v9, v18
    and-int/lit16 v0, v0, 256
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v19
    move-object v11, v10
    move-object v12, v1
    move-object v13, v3
    move-object v14, v4
    move-object v15, v5
    move-object/from16 v16, v6
    move-object/from16 v17, v7
    move-object/from16 v18, v8
    move/from16 v19, v9
    move-object/from16 v20, v2
    invoke-direct/range v11 ... v20, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;-><init>(Lcom/google/gson/JsonElement; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/util/List; Ljava/lang/Integer; Z Ljava/util/List;)V
    return-void 
.end method

.method private final component1()com.google.gson.JsonElement
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawRuleId Lcom/google/gson/JsonElement;
    return-object v0
.end method

.method private final component6()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawExecutionPoints Ljava/util/List;
    return-object v0
.end method

.method private final component9()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawRuleDetails Ljava/util/List;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.tenant.ContentSecurityRule  com.google.gson.JsonElement  java.lang.String  java.lang.String  java.lang.Integer  java.lang.Integer  java.util.List  java.lang.Integer  boolean  java.util.List  int  java.lang.Object)com.bytedance.trae.im.service.tenant.ContentSecurityRule
    .registers 22
    # ins_size=12
    move-object v0, v10
    move/from16 v1, v20
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawRuleId Lcom/google/gson/JsonElement;
    goto +2h
    move-object v2, v11
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->tenantId Ljava/lang/String;
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->ruleName Ljava/lang/String;
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->ruleType Ljava/lang/Integer;
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->sceneType Ljava/lang/Integer;
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawExecutionPoints Ljava/util/List;
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->actionType Ljava/lang/Integer;
    goto +3h
    move-object/from16 v8, v17
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-boolean v9, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->isEnabled Z
    goto +3h
    move/from16 v9, v18
    and-int/lit16 v1, v1, 256
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawRuleDetails Ljava/util/List;
    goto +3h
    move-object/from16 v1, v19
    move-object v11, v2
    move-object v12, v3
    move-object v13, v4
    move-object v14, v5
    move-object v15, v6
    move-object/from16 v16, v7
    move-object/from16 v17, v8
    move/from16 v18, v9
    move-object/from16 v19, v1
    invoke-virtual/range v10 ... v19, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->copy(Lcom/google/gson/JsonElement; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/util/List; Ljava/lang/Integer; Z Ljava/util/List;)Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;
    move-result-object v0
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->tenantId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->ruleName Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->ruleType Ljava/lang/Integer;
    return-object v0
.end method

.method public final component5()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->sceneType Ljava/lang/Integer;
    return-object v0
.end method

.method public final component7()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->actionType Ljava/lang/Integer;
    return-object v0
.end method

.method public final component8()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->isEnabled Z
    return v0
.end method

.method public final copy(com.google.gson.JsonElement  java.lang.String  java.lang.String  java.lang.Integer  java.lang.Integer  java.util.List  java.lang.Integer  boolean  java.util.List)com.bytedance.trae.im.service.tenant.ContentSecurityRule
    .registers 21
    # ins_size=10
    new-instance v10, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;
    move-object v0, v10
    move-object v1, v12
    move-object v2, v13
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v5, v16
    move-object/from16 v6, v17
    move-object/from16 v7, v18
    move/from16 v8, v19
    move-object/from16 v9, v20
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;-><init>(Lcom/google/gson/JsonElement; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/util/List; Ljava/lang/Integer; Z Ljava/util/List;)V
    return-object v10
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawRuleId Lcom/google/gson/JsonElement;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawRuleId Lcom/google/gson/JsonElement;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->tenantId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->tenantId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->ruleName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->ruleName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->ruleType Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->ruleType Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->sceneType Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->sceneType Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawExecutionPoints Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawExecutionPoints Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->actionType Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->actionType Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->isEnabled Z
    iget-boolean v3, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->isEnabled Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawRuleDetails Ljava/util/List;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawRuleDetails Ljava/util/List;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getActionType()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->actionType Ljava/lang/Integer;
    return-object v0
.end method

.method public final getExecutionPoints()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawExecutionPoints Ljava/util/List;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public final getRuleDetails()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawRuleDetails Ljava/util/List;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public final getRuleId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawRuleId Lcom/google/gson/JsonElement;
    invoke-static v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigModelsKt;->access$stringOrNumber(Lcom/google/gson/JsonElement;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final getRuleName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->ruleName Ljava/lang/String;
    return-object v0
.end method

.method public final getRuleType()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->ruleType Ljava/lang/Integer;
    return-object v0
.end method

.method public final getSceneType()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->sceneType Ljava/lang/Integer;
    return-object v0
.end method

.method public final getTenantId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->tenantId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawRuleId Lcom/google/gson/JsonElement;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->tenantId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->ruleName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->ruleType Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->sceneType Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawExecutionPoints Ljava/util/List;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->actionType Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-boolean v2, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->isEnabled Z
    invoke-static v2, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawRuleDetails Ljava/util/List;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isEnabled()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->isEnabled Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ContentSecurityRule(rawRuleId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawRuleId Lcom/google/gson/JsonElement;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", tenantId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->tenantId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", ruleName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->ruleName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", ruleType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->ruleType Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sceneType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->sceneType Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", rawExecutionPoints="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawExecutionPoints Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", actionType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->actionType Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isEnabled="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->isEnabled Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", rawRuleDetails="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->rawRuleDetails Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
