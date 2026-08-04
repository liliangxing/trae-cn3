# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;
.super Ljava/lang/Object;
.source "PreviewWebViewActivity.kt"

.field private final isLocal:Z
.field private final isValid:Z
.field private final pathSearchHash:Ljava/lang/String;


.method public constructor <init>(java.lang.String  boolean  boolean)void
    .registers 5
    # ins_size=4
    const-string v0, "pathSearchHash"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->pathSearchHash Ljava/lang/String;
    iput-boolean v3, v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isLocal Z
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isValid Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.products.PreviewWebViewActivity$ParsedUrl  java.lang.String  boolean  boolean  int  java.lang.Object)com.bytedance.trae.conversation.products.PreviewWebViewActivity$ParsedUrl
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->pathSearchHash Ljava/lang/String;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isLocal Z
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isValid Z
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->copy(Ljava/lang/String; Z Z)Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->pathSearchHash Ljava/lang/String;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isLocal Z
    return v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isValid Z
    return v0
.end method

.method public final copy(java.lang.String  boolean  boolean)com.bytedance.trae.conversation.products.PreviewWebViewActivity$ParsedUrl
    .registers 5
    # ins_size=4
    const-string v0, "pathSearchHash"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;-><init>(Ljava/lang/String; Z Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->pathSearchHash Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->pathSearchHash Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isLocal Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isLocal Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isValid Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isValid Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getPathSearchHash()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->pathSearchHash Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->pathSearchHash Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isLocal Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isValid Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isLocal()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isLocal Z
    return v0
.end method

.method public final isValid()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isValid Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ParsedUrl(pathSearchHash="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->pathSearchHash Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isLocal="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isLocal Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isValid="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isValid Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
