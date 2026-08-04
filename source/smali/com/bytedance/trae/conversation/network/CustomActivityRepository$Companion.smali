# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/CustomActivityRepository$Companion;
.super Ljava/lang/Object;
.source "CustomActivityRepository.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$Companion;-><init>()V
    return-void 
.end method

.method public final getInstance()com.bytedance.trae.conversation.network.CustomActivityRepository
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->access$getInstance$delegate$cp()Lkotlin/Lazy;
    move-result-object v0
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;
    return-object v0
.end method
