# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;
.super Ljava/lang/Object;
.source "QueuingBannerView.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final shouldShowFastRequestAction(java.lang.Integer  boolean)boolean
    .registers 3
    # ins_size=3
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;->shouldUseFastRequestPresentation(Z)Z
    move-result v2
    if-eqz v2, +013h
    sget-object v2, Lcom/bytedance/trae/im/service/FastRequestEventType;->HasQuotaCanUse Lcom/bytedance/trae/im/service/FastRequestEventType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/FastRequestEventType;->getValue()I
    move-result v2
    if-nez v1, +003h
    goto +9h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    if-ne v1, v2, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    return v1
.end method

.method public final shouldUseFastRequestPresentation(boolean)boolean
    .registers 2
    # ins_size=2
    xor-int/lit8 v1, v1, 1
    return v1
.end method
