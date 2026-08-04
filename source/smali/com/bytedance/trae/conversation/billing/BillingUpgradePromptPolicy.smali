# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;
.super Ljava/lang/Object;
.source "BillingUpgradePromptPolicy.kt"

.field public static final BILLING_VERSION_2:I
.field private static final CAMPAIGN_ID:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;
.field private static final SHOWN_KEY_PREFIX:Ljava/lang/String;
.field private static final managedCandidate:Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;
    new-instance v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    sget-object v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;->BillingUpgrade Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;
    const-string v2, "billing_upgrade"
    const/4 v3, 2
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptType; Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->managedCandidate Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final classifyUserState(boolean  long)com.bytedance.trae.conversation.billing.BillingUpgradeUserState
    .registers 6
    # ins_size=4
    if-eqz v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;->Express Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    goto +ch
    const-wide/16 v0, 0
    cmp-long v3, v4, v0
    if-lez v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;->HasFastRequests Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;->NoFastRequests Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    return-object v3
.end method

.method public final getManagedCandidate$conversation_mainlandRelease()com.bytedance.trae.conversation.prompt.ManagedPromptCandidate
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;->managedCandidate Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    return-object v0
.end method

.method public final shouldShow(boolean)boolean
    .registers 2
    # ins_size=2
    xor-int/lit8 v1, v1, 1
    return v1
.end method

.method public final shownKey(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    const-string/jumbo v0, userId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "billing_upgrade_prompt_shown_"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v0, "_2"
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method
