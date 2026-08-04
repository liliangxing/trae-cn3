# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$1;
.super Ljava/lang/Object;
.source "BillingUpgradePromptEngine.kt"

.implements Lkotlin/jvm/functions/Function1;

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$1;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$1;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$1;
    return-void 
.end method

.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public bridge synthetic invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Ljava/lang/String;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$1;->invoke(Ljava/lang/String;)Ljava/lang/Void;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(java.lang.String)java.lang.Void
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    return-object v2
.end method
