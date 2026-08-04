# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;
.super Ljava/lang/Object;
.source "ResourceUploadModels.kt"

.field private final bizType:Lcom/bytedance/trae/conversation/fileupload/BizType;
.field private final uriList:Ljava/util/List;


.method public constructor <init>(java.util.List  com.bytedance.trae.conversation.fileupload.BizType)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, uriList
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->uriList Ljava/util/List;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  com.bytedance.trae.conversation.fileupload.BizType  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;-><init>(Ljava/util/List; Lcom/bytedance/trae/conversation/fileupload/BizType;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.fileupload.GetResourceUrlRequest  java.util.List  com.bytedance.trae.conversation.fileupload.BizType  int  java.lang.Object)com.bytedance.trae.conversation.fileupload.GetResourceUrlRequest
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->uriList Ljava/util/List;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->copy(Ljava/util/List; Lcom/bytedance/trae/conversation/fileupload/BizType;)Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->uriList Ljava/util/List;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.fileupload.BizType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    return-object v0
.end method

.method public final copy(java.util.List  com.bytedance.trae.conversation.fileupload.BizType)com.bytedance.trae.conversation.fileupload.GetResourceUrlRequest
    .registers 4
    # ins_size=3
    const-string/jumbo v0, uriList
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;-><init>(Ljava/util/List; Lcom/bytedance/trae/conversation/fileupload/BizType;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->uriList Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->uriList Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getBizType()com.bytedance.trae.conversation.fileupload.BizType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    return-object v0
.end method

.method public final getUriList()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->uriList Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->uriList Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/fileupload/BizType;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "GetResourceUrlRequest(uriList="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->uriList Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", bizType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;->bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
