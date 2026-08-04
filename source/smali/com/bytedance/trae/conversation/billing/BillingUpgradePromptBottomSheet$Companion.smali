# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet$Companion;
.super Ljava/lang/Object;
.source "BillingUpgradePromptBottomSheet.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet$Companion;-><init>()V
    return-void 
.end method

.method public final newInstance(java.lang.String  com.bytedance.trae.conversation.billing.BillingUpgradePromptData)com.bytedance.trae.conversation.billing.BillingUpgradePromptBottomSheet
    .registers 6
    # ins_size=3
    const-string v0, "ownerUserId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "promptData"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string v2, "arg_owner_user_id"
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;->getUserState()Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;->name()Ljava/lang/String;
    move-result-object v4
    const-string v5, "arg_user_state"
    invoke-virtual v1, v5, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
