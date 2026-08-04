# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;
.super Ljava/lang/Object;
.source "BytecloudNetworkCacheReset.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;
.field private static resetAction:Lkotlin/jvm/functions/Function0;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;
    invoke-direct v0, Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;->INSTANCE Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final onNetworkChanged()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;->resetAction Lkotlin/jvm/functions/Function0;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public final setResetAction(kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=2
    const-string v0, "action"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v2, Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;->resetAction Lkotlin/jvm/functions/Function0;
    return-void 
.end method
