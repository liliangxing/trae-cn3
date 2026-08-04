# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;
.super Ljava/lang/Object;
.source "ResourceUploadUtil.kt"

.field private final payloadOffset:I


.method public constructor <init>(int)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;->payloadOffset I
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.fileupload.V2MagicMatch  int  int  java.lang.Object)com.bytedance.trae.conversation.fileupload.V2MagicMatch
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget v1, v0, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;->payloadOffset I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;->copy(I)Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;->payloadOffset I
    return v0
.end method

.method public final copy(int)com.bytedance.trae.conversation.fileupload.V2MagicMatch
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;-><init>(I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;
    iget v1, v3, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;->payloadOffset I
    iget v4, v4, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;->payloadOffset I
    if-eq v1, v4, +003h
    return v2
    return v0
.end method

.method public final getPayloadOffset()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;->payloadOffset I
    return v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;->payloadOffset I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "V2MagicMatch(payloadOffset="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;->payloadOffset I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
