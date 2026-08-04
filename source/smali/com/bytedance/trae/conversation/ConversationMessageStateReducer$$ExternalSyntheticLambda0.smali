# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/ConversationMessageStateReducer$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;


.method public synthetic constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Ljava/lang/String;
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->$r8$lambda$LlgUkNbwYflQjHEr9ydzfUqns90(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Lkotlin/Unit;
    move-result-object v1
    return-object v1
.end method
