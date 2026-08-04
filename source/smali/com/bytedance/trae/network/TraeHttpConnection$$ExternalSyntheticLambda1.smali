# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/retrofit2/intercept/Interceptor;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Ljava/util/Map;
.field public final synthetic f$2:Z


.method public synthetic constructor <init>(java.lang.String  java.util.Map  boolean)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda1;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda1;->f$1 Ljava/util/Map;
    iput-boolean v3, v0, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda1;->f$2 Z
    return-void 
.end method

.method public final intercept(com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda1;->f$0 Ljava/lang/String;
    iget-object v1, v3, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda1;->f$1 Ljava/util/Map;
    iget-boolean v2, v3, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda1;->f$2 Z
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/network/TraeHttpConnection;->$r8$lambda$VnPw36bnXLgmKxRkwGnEu7LPtyY(Ljava/lang/String; Ljava/util/Map; Z Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v4
    return-object v4
.end method
