# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IGetConversationFullDetailService$DefaultImpls;
.super Ljava/lang/Object;
.source "IGetConversationFullDetailService.kt"


.method public static synthetic getConversationFullDetailRaw$default(com.bytedance.trae.im.service.IGetConversationFullDetailService  java.lang.String  java.lang.Object  int  java.lang.Object)com.bytedance.retrofit2.Call
    .registers 5
    # ins_size=5
    if-nez v4, +00ch
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/im/service/IGetConversationFullDetailService;->getConversationFullDetailRaw(Ljava/lang/String; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: getConversationFullDetailRaw"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
