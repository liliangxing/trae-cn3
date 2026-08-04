# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/NpthImpl$trySaveDeviceIdToKeva$1$1;
.super Ljava/lang/Object;
.source "NpthImpl.kt"

.implements Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;

.field final synthetic this$0:Lcom/bytedance/trae/apm/impl/NpthImpl;


.method constructor <init>(com.bytedance.trae.apm.impl.NpthImpl)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/apm/impl/NpthImpl$trySaveDeviceIdToKeva$1$1;->this$0 Lcom/bytedance/trae/apm/impl/NpthImpl;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onGetId(java.lang.String  java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=4
    const-string v0, "did"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "iid"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, ssid
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/apm/impl/NpthImpl$trySaveDeviceIdToKeva$1$1;->this$0 Lcom/bytedance/trae/apm/impl/NpthImpl;
    invoke-static v2, Lcom/bytedance/trae/apm/impl/NpthImpl;->access$trySaveDeviceIdToKeva(Lcom/bytedance/trae/apm/impl/NpthImpl;)V
    return-void 
.end method
