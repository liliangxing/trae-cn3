# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/TraeApplication$Companion;
.super Ljava/lang/Object;
.source "TraeApplication.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/TraeApplication$Companion;-><init>()V
    return-void 
.end method

.method public final getInst()com.bytedance.trae.TraeApplication
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/trae/TraeApplication;->access$getInst$cp()Lcom/bytedance/trae/TraeApplication;
    move-result-object v0
    if-eqz v0, +003h
    return-object v0
    const-string v0, "inst"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    return-object v0
.end method
