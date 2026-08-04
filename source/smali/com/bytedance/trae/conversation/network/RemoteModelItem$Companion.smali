# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
.super Ljava/lang/Object;
.source "Models.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;-><init>()V
    return-void 
.end method

.method public final auto()com.bytedance.trae.conversation.network.RemoteModelItem
    .registers 20
    # ins_size=1
    new-instance v18, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-object/from16 v0, v18
    const-string v1, "auto"
    const-string v2, "TRAE Auto Model"
    const-string v3, "TRAE Auto Model"
    const/4 v4, 1
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 32752
    const/16 v17, 0
    invoke-direct/range v0 ... v17, Lcom/bytedance/trae/conversation/network/RemoteModelItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Lcom/google/gson/JsonObject; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v18
.end method
