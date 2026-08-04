# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy$DefaultImpls;
.super Ljava/lang/Object;
.source "UserPayIdentityService.kt"


.method public static fetchKnownUserPayIdentity(com.bytedance.trae.conversation.chat.UserPayIdentityService$IUserPayIdentityProxy  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-interface v0, v1, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;->fetchUserPayIdentity(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static getKnownUserPayIdentity(com.bytedance.trae.conversation.chat.UserPayIdentityService$IUserPayIdentityProxy)java.lang.Integer
    .registers 1
    # ins_size=1
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;->getUserPayIdentity()I
    move-result v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    return-object v0
.end method
