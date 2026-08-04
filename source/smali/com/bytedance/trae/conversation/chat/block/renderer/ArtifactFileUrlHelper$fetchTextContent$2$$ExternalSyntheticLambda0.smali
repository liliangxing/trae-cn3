# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/retrofit2/intercept/Interceptor;

.field public final synthetic f$0:Ljava/lang/String;


.method public synthetic constructor <init>(java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    return-void 
.end method

.method public final intercept(com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchTextContent$2;->$r8$lambda$ndw_zjAPCZ-XINlKwccbQhIlqsg(Ljava/lang/String; Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v2
    return-object v2
.end method
