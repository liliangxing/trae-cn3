# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;
.super Ljava/lang/Object;
.source "TenantUserConfigModels.kt"

.field private final rawRuleDetailId:Lcom/google/gson/JsonElement;
.field private final regexPattern:Ljava/lang/String;
.field private final replacement:Ljava/lang/String;
.field private final ruleDetailName:Ljava/lang/String;
.field private final sequence:I


.method public constructor <init>()void
    .registers 9
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 31
    const/4 v7, 0
    move-object v0, v8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;-><init>(Lcom/google/gson/JsonElement; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.google.gson.JsonElement  java.lang.String  java.lang.String  java.lang.String  int)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->rawRuleDetailId Lcom/google/gson/JsonElement;
    iput-object v2, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->ruleDetailName Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->regexPattern Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->replacement Ljava/lang/String;
    iput v5, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->sequence I
    return-void 
.end method

.method public synthetic constructor <init>(com.google.gson.JsonElement  java.lang.String  java.lang.String  java.lang.String  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    const/4 v0, 0
    if-eqz v10, +004h
    move-object v10, v0
    goto +2h
    move-object v10, v4
    and-int/lit8 v4, v9, 2
    if-eqz v4, +004h
    move-object v1, v0
    goto +2h
    move-object v1, v5
    and-int/lit8 v4, v9, 4
    if-eqz v4, +004h
    move-object v2, v0
    goto +2h
    move-object v2, v6
    and-int/lit8 v4, v9, 8
    if-eqz v4, +003h
    goto +2h
    move-object v0, v7
    and-int/lit8 v4, v9, 16
    if-eqz v4, +003h
    const/4 v8, 0
    move v9, v8
    move-object v4, v3
    move-object v5, v10
    move-object v6, v1
    move-object v7, v2
    move-object v8, v0
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;-><init>(Lcom/google/gson/JsonElement; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method private final component1()com.google.gson.JsonElement
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->rawRuleDetailId Lcom/google/gson/JsonElement;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.tenant.ContentSecurityRuleDetail  com.google.gson.JsonElement  java.lang.String  java.lang.String  java.lang.String  int  int  java.lang.Object)com.bytedance.trae.im.service.tenant.ContentSecurityRuleDetail
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->rawRuleDetailId Lcom/google/gson/JsonElement;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->ruleDetailName Ljava/lang/String;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->regexPattern Ljava/lang/String;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-object v7, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->replacement Ljava/lang/String;
    move-object v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget v8, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->sequence I
    move v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move-object v8, v0
    move-object v9, v1
    move v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->copy(Lcom/google/gson/JsonElement; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I)Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;
    move-result-object v3
    return-object v3
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->ruleDetailName Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->regexPattern Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->replacement Ljava/lang/String;
    return-object v0
.end method

.method public final component5()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->sequence I
    return v0
.end method

.method public final copy(com.google.gson.JsonElement  java.lang.String  java.lang.String  java.lang.String  int)com.bytedance.trae.im.service.tenant.ContentSecurityRuleDetail
    .registers 13
    # ins_size=6
    new-instance v6, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;
    move-object v0, v6
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move v5, v12
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;-><init>(Lcom/google/gson/JsonElement; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I)V
    return-object v6
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->rawRuleDetailId Lcom/google/gson/JsonElement;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->rawRuleDetailId Lcom/google/gson/JsonElement;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->ruleDetailName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->ruleDetailName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->regexPattern Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->regexPattern Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->replacement Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->replacement Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->sequence I
    iget v5, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->sequence I
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getRegexPattern()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->regexPattern Ljava/lang/String;
    return-object v0
.end method

.method public final getReplacement()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->replacement Ljava/lang/String;
    return-object v0
.end method

.method public final getRuleDetailId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->rawRuleDetailId Lcom/google/gson/JsonElement;
    invoke-static v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigModelsKt;->access$stringOrNumber(Lcom/google/gson/JsonElement;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final getRuleDetailName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->ruleDetailName Ljava/lang/String;
    return-object v0
.end method

.method public final getSequence()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->sequence I
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->rawRuleDetailId Lcom/google/gson/JsonElement;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->ruleDetailName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->regexPattern Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->replacement Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->sequence I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ContentSecurityRuleDetail(rawRuleDetailId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->rawRuleDetailId Lcom/google/gson/JsonElement;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", ruleDetailName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->ruleDetailName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", regexPattern="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->regexPattern Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", replacement="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->replacement Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sequence="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->sequence I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
