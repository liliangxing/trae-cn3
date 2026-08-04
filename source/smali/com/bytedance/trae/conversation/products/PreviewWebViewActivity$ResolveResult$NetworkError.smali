# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$NetworkError;
.super Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult;
.source "PreviewWebViewActivity.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$NetworkError;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$NetworkError;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$NetworkError;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$NetworkError;->INSTANCE Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$NetworkError;
    return-void 
.end method

.method private constructor <init>()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public equals(java.lang.Object)boolean
    .registers 4
    # ins_size=2
    const/4 v0, 1
    if-ne v2, v3, +003h
    return v0
    instance-of v1, v3, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$NetworkError;
    if-nez v1, +004h
    const/4 v3, 0
    return v3
    check-cast v3, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$NetworkError;
    return v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    const v0, 733264498
    return v0
.end method

.method public toString()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "NetworkError"
    return-object v0
.end method
