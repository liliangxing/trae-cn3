# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IChatSessionAuthApi$DefaultImpls;
.super Ljava/lang/Object;
.source "IChatSessionAuthApi.kt"


.method public static synthetic issueSessionToken$default(com.bytedance.trae.im.service.IChatSessionAuthApi  java.lang.String  com.bytedance.trae.im.service.IssueSessionTokenRequest  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=6
    if-nez v5, +011h
    const/4 v5, 2
    and-int/2addr v4, v5
    if-eqz v4, +008h
    new-instance v2, Lcom/bytedance/trae/im/service/IssueSessionTokenRequest;
    const/4 v4, 0
    invoke-direct v2, v1, v4, v5, v4, Lcom/bytedance/trae/im/service/IssueSessionTokenRequest;-><init>(Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, v3, Lcom/bytedance/trae/im/service/IChatSessionAuthApi;->issueSessionToken(Ljava/lang/String; Lcom/bytedance/trae/im/service/IssueSessionTokenRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: issueSessionToken"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
