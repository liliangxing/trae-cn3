# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;
.super Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException;
.source "ThirdPartyTokenRepository.kt"

.field private final body:Ljava/lang/String;
.field private final code:Ljava/lang/String;
.field private final serverMessage:Ljava/lang/String;
.field private final statusCode:I


.method public constructor <init>(java.lang.String  java.lang.String  int  java.lang.String)void
    .registers 15
    # ins_size=5
    const-string v0, "code"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, serverMessage
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 2
    new-array v0, v0, [Ljava/lang/String;
    const/4 v1, 0
    aput-object v11, v0, v1
    const/4 v1, 1
    aput-object v12, v0, v1
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/Iterable;
    const-string v0, " "
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 62
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    invoke-direct v10, v0, v1, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException;-><init>(Ljava/lang/String; Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v11, v10, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;->code Ljava/lang/String;
    iput-object v12, v10, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;->serverMessage Ljava/lang/String;
    iput v13, v10, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;->statusCode I
    iput-object v14, v10, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;->body Ljava/lang/String;
    return-void 
.end method

.method public final getBody()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;->body Ljava/lang/String;
    return-object v0
.end method

.method public final getCode()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;->code Ljava/lang/String;
    return-object v0
.end method

.method public final getServerMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;->serverMessage Ljava/lang/String;
    return-object v0
.end method

.method public final getStatusCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;->statusCode I
    return v0
.end method
