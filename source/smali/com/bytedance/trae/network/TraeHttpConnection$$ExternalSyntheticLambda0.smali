# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Ljava/lang/reflect/Type;


.method public synthetic constructor <init>(java.lang.reflect.Type)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda0;->f$0 Ljava/lang/reflect/Type;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda0;->f$0 Ljava/lang/reflect/Type;
    check-cast v2, Ljava/lang/String;
    check-cast v3, Lcom/bytedance/retrofit2/SsResponse;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/network/TraeHttpConnection;->$r8$lambda$SYIHu2BUGDsRgQTU6f8F-YjgG0E(Ljava/lang/reflect/Type; Ljava/lang/String; Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    return-object v2
.end method
