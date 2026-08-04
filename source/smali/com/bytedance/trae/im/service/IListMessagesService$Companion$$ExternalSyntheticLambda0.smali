# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/im/service/IListMessagesService$Companion$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:I
.field public final synthetic f$3:I
.field public final synthetic f$4:Z


.method public synthetic constructor <init>(java.lang.String  java.lang.String  int  int  boolean)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/IListMessagesService$Companion$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/im/service/IListMessagesService$Companion$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    iput v3, v0, Lcom/bytedance/trae/im/service/IListMessagesService$Companion$$ExternalSyntheticLambda0;->f$2 I
    iput v4, v0, Lcom/bytedance/trae/im/service/IListMessagesService$Companion$$ExternalSyntheticLambda0;->f$3 I
    iput-boolean v5, v0, Lcom/bytedance/trae/im/service/IListMessagesService$Companion$$ExternalSyntheticLambda0;->f$4 Z
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=3
    iget-object v0, v7, Lcom/bytedance/trae/im/service/IListMessagesService$Companion$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    iget-object v1, v7, Lcom/bytedance/trae/im/service/IListMessagesService$Companion$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    iget v2, v7, Lcom/bytedance/trae/im/service/IListMessagesService$Companion$$ExternalSyntheticLambda0;->f$2 I
    iget v3, v7, Lcom/bytedance/trae/im/service/IListMessagesService$Companion$$ExternalSyntheticLambda0;->f$3 I
    iget-boolean v4, v7, Lcom/bytedance/trae/im/service/IListMessagesService$Companion$$ExternalSyntheticLambda0;->f$4 Z
    move-object v5, v8
    check-cast v5, Lcom/bytedance/trae/im/service/IListMessagesService;
    move-object v6, v9
    check-cast v6, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/im/service/IListMessagesService$Companion;->$r8$lambda$-RjA4HzYHAuqVbUqtyVJ9DU-Oho(Ljava/lang/String; Ljava/lang/String; I I Z Lcom/bytedance/trae/im/service/IListMessagesService; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v8
    return-object v8
.end method
