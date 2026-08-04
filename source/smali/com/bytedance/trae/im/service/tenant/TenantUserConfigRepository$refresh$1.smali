# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;
.super Lkotlin/coroutines/jvm/internal/ContinuationImpl;
.source "TenantUserConfigRepository.kt"

.field  J$0:J
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  Z$0:Z
.field  label:I
.field synthetic result:Ljava/lang/Object;
.field final synthetic this$0:Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;


.method constructor <init>(com.bytedance.trae.im.service.tenant.TenantUserConfigRepository  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->this$0 Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    invoke-direct v0, v2, Lkotlin/coroutines/jvm/internal/ContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    iput-object v7, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->result Ljava/lang/Object;
    iget v7, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->label I
    const/high16 v0, -2147483648
    or-int/2addr v7, v0
    iput v7, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->label I
    iget-object v0, v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$refresh$1;->this$0 Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    const/4 v1, 0
    const/4 v2, 0
    const-wide/16 v3, 0
    move-object v5, v6
    check-cast v5, Lkotlin/coroutines/Continuation;
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->access$refresh(Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository; Z Ljava/lang/String; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    return-object v7
.end method
