# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;


.method public synthetic constructor <init>(com.bytedance.trae.im.service.GetDownloadUrlRequest)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;
    check-cast v2, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;
    check-cast v3, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->$r8$lambda$WdBi8RCfWvt1ZKAeIVFptdScx5A(Lcom/bytedance/trae/im/service/GetDownloadUrlRequest; Lcom/bytedance/trae/im/service/IGetDownloadUrlApi; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v2
    return-object v2
.end method
