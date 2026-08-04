# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:I
.field public final synthetic f$1:I
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:Ljava/lang/String;
.field public final synthetic f$4:Z
.field public final synthetic f$5:Ljava/lang/Integer;
.field public final synthetic f$6:Ljava/lang/Integer;
.field public final synthetic f$7:Ljava/lang/String;
.field public final synthetic f$8:Ljava/util/List;


.method public synthetic constructor <init>(int  int  java.lang.String  java.lang.String  boolean  java.lang.Integer  java.lang.Integer  java.lang.String  java.util.List)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$0 I
    iput v2, v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$1 I
    iput-object v3, v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$3 Ljava/lang/String;
    iput-boolean v5, v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$4 Z
    iput-object v6, v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$5 Ljava/lang/Integer;
    iput-object v7, v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$6 Ljava/lang/Integer;
    iput-object v8, v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$7 Ljava/lang/String;
    iput-object v9, v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$8 Ljava/util/List;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=3
    iget v0, v11, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$0 I
    iget v1, v11, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$1 I
    iget-object v2, v11, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    iget-object v3, v11, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$3 Ljava/lang/String;
    iget-boolean v4, v11, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$4 Z
    iget-object v5, v11, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$5 Ljava/lang/Integer;
    iget-object v6, v11, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$6 Ljava/lang/Integer;
    iget-object v7, v11, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$7 Ljava/lang/String;
    iget-object v8, v11, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;->f$8 Ljava/util/List;
    move-object v9, v12
    check-cast v9, Lcom/bytedance/trae/im/service/IListConversationsService;
    move-object v10, v13
    check-cast v10, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-static/range v0 ... v10, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->$r8$lambda$pUibCL-cb6_-tKttlnDcoxewGJE(I I Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/im/service/IListConversationsService; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v12
    return-object v12
.end method
