# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:I
.field public final synthetic f$2:I
.field public final synthetic f$3:J
.field public final synthetic f$4:J


.method public synthetic constructor <init>(java.lang.String  int  int  long  long)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda1;->f$0 Ljava/lang/String;
    iput v2, v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda1;->f$1 I
    iput v3, v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda1;->f$2 I
    iput-wide v4, v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda1;->f$3 J
    iput-wide v6, v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda1;->f$4 J
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=3
    iget-object v0, v9, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda1;->f$0 Ljava/lang/String;
    iget v1, v9, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda1;->f$1 I
    iget v2, v9, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda1;->f$2 I
    iget-wide v3, v9, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda1;->f$3 J
    iget-wide v5, v9, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda1;->f$4 J
    move-object v7, v10
    check-cast v7, Lcom/bytedance/trae/im/service/IListConversationsService;
    move-object v8, v11
    check-cast v8, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->$r8$lambda$gtYzrPBCyZs59AaqQTpec5nFJVU(Ljava/lang/String; I I J J Lcom/bytedance/trae/im/service/IListConversationsService; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v10
    return-object v10
.end method
