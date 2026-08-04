# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/response/BizResponse$Companion;
.super Ljava/lang/Object;
.source "BizResponse.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/network/response/BizResponse$Companion;-><init>()V
    return-void 
.end method

.method public final getCODE_RISK_CONTROL()long[]
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/trae/network/response/BizResponse;->access$getCODE_RISK_CONTROL$cp()[J
    move-result-object v0
    return-object v0
.end method

.method public final getDEFAULT_SUCCESS_CODES()java.util.Set
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/trae/network/response/BizResponse;->access$getDEFAULT_SUCCESS_CODES$cp()Ljava/util/Set;
    move-result-object v0
    return-object v0
.end method
