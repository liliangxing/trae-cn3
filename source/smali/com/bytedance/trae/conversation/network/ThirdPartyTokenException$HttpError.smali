# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$HttpError;
.super Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException;
.source "ThirdPartyTokenRepository.kt"

.field private final body:Ljava/lang/String;
.field private final statusCode:I


.method public constructor <init>(int  java.lang.String)void
    .registers 5
    # ins_size=3
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "HTTP "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException;-><init>(Ljava/lang/String; Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput v3, v2, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$HttpError;->statusCode I
    iput-object v4, v2, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$HttpError;->body Ljava/lang/String;
    return-void 
.end method

.method public final getBody()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$HttpError;->body Ljava/lang/String;
    return-object v0
.end method

.method public final getStatusCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$HttpError;->statusCode I
    return v0
.end method
