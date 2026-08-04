# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/ApmImpl$initApm$1;
.super Ljava/lang/Object;
.source "ApmImpl.kt"

.implements Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;

.field final synthetic this$0:Lcom/bytedance/trae/apm/impl/ApmImpl;


.method constructor <init>(com.bytedance.trae.apm.impl.ApmImpl)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/apm/impl/ApmImpl$initApm$1;->this$0 Lcom/bytedance/trae/apm/impl/ApmImpl;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onGetId(java.lang.String  java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=4
    const-string v0, "did"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "iid"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, ssid
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/apm/impl/ApmImpl$initApm$1;->this$0 Lcom/bytedance/trae/apm/impl/ApmImpl;
    invoke-static v3, v2, Lcom/bytedance/trae/apm/impl/ApmImpl;->access$startApm(Lcom/bytedance/trae/apm/impl/ApmImpl; Ljava/lang/String;)V
    return-void 
.end method
