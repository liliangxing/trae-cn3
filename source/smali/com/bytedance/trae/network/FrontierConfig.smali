# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/FrontierConfig;
.super Ljava/lang/Object;
.source "FrontierConfig.kt"

.field private final appId:I
.field private final appKey:Ljava/lang/String;
.field private final productId:I
.field private final url:Ljava/lang/String;


.method public constructor <init>(int  int  java.lang.String  java.lang.String)void
    .registers 6
    # ins_size=5
    const-string v0, "appKey"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, url
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput v2, v1, Lcom/bytedance/trae/network/FrontierConfig;->productId I
    iput v3, v1, Lcom/bytedance/trae/network/FrontierConfig;->appId I
    iput-object v4, v1, Lcom/bytedance/trae/network/FrontierConfig;->appKey Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/network/FrontierConfig;->url Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.network.FrontierConfig  int  int  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.network.FrontierConfig
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget v1, v0, Lcom/bytedance/trae/network/FrontierConfig;->productId I
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget v2, v0, Lcom/bytedance/trae/network/FrontierConfig;->appId I
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/network/FrontierConfig;->appKey Ljava/lang/String;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/network/FrontierConfig;->url Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/network/FrontierConfig;->copy(I I Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/network/FrontierConfig;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/FrontierConfig;->productId I
    return v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/FrontierConfig;->appId I
    return v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/FrontierConfig;->appKey Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/FrontierConfig;->url Ljava/lang/String;
    return-object v0
.end method

.method public final copy(int  int  java.lang.String  java.lang.String)com.bytedance.trae.network.FrontierConfig
    .registers 6
    # ins_size=5
    const-string v0, "appKey"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, url
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/network/FrontierConfig;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/network/FrontierConfig;-><init>(I I Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/network/FrontierConfig;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/network/FrontierConfig;
    iget v1, v4, Lcom/bytedance/trae/network/FrontierConfig;->productId I
    iget v3, v5, Lcom/bytedance/trae/network/FrontierConfig;->productId I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/network/FrontierConfig;->appId I
    iget v3, v5, Lcom/bytedance/trae/network/FrontierConfig;->appId I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/network/FrontierConfig;->appKey Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/network/FrontierConfig;->appKey Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/network/FrontierConfig;->url Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/network/FrontierConfig;->url Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAppId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/FrontierConfig;->appId I
    return v0
.end method

.method public final getAppKey()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/FrontierConfig;->appKey Ljava/lang/String;
    return-object v0
.end method

.method public final getProductId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/FrontierConfig;->productId I
    return v0
.end method

.method public final getUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/FrontierConfig;->url Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/network/FrontierConfig;->productId I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/network/FrontierConfig;->appId I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/network/FrontierConfig;->appKey Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/network/FrontierConfig;->url Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isConnectable()boolean
    .registers 4
    # ins_size=1
    iget v0, v3, Lcom/bytedance/trae/network/FrontierConfig;->productId I
    const/4 v1, 0
    if-lez v0, +022h
    iget-object v0, v3, Lcom/bytedance/trae/network/FrontierConfig;->appKey Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v2, 1
    if-lez v0, +004h
    move v0, v2
    goto +2h
    move v0, v1
    if-eqz v0, +012h
    iget-object v0, v3, Lcom/bytedance/trae/network/FrontierConfig;->url Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    move v0, v2
    goto +2h
    move v0, v1
    if-eqz v0, +003h
    move v1, v2
    return v1
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "FrontierConfig(productId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/network/FrontierConfig;->productId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", appId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/network/FrontierConfig;->appId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", appKey="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/network/FrontierConfig;->appKey Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", url="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/network/FrontierConfig;->url Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
