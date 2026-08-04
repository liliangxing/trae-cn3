# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$didListener$1;
.super Ljava/lang/Object;
.source "SecurityServiceImpl.kt"

.implements Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;

.field final synthetic this$0:Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;


.method constructor <init>(com.bytedance.trae.common.security.impl.SecurityServiceImpl)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$didListener$1;->this$0 Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;
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
    const-string/jumbo v0, ssid
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v4, v2
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +004h
    const/4 v4, 1
    goto +2h
    const/4 v4, 0
    if-eqz v4, +007h
    iget-object v4, v1, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$didListener$1;->this$0 Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;
    invoke-static v4, v2, v3, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;->access$reportReceiveDid(Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
