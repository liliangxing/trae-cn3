# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator$DefaultImpls;
.super Ljava/lang/Object;
.source "IToolDetailCardCreator.kt"


.method public static synthetic createDetail$default(com.bytedance.trae.conversation.chat.toolcall.IToolDetailCardCreator  android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext  int  java.lang.Object)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 6
    # ins_size=6
    if-nez v5, +00ch
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-interface v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;->createDetail(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: createDetail"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
