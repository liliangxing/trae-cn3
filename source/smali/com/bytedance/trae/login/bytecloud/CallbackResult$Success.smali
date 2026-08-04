# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/bytecloud/CallbackResult$Success;
.super Lcom/bytedance/trae/login/bytecloud/CallbackResult;
.source "BytecloudAuthManager.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/bytecloud/CallbackResult$Success;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Success;
    invoke-direct v0, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Success;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Success;->INSTANCE Lcom/bytedance/trae/login/bytecloud/CallbackResult$Success;
    return-void 
.end method

.method private constructor <init>()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/login/bytecloud/CallbackResult;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public equals(java.lang.Object)boolean
    .registers 4
    # ins_size=2
    const/4 v0, 1
    if-ne v2, v3, +003h
    return v0
    instance-of v1, v3, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Success;
    if-nez v1, +004h
    const/4 v3, 0
    return v3
    check-cast v3, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Success;
    return v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    const v0, 593660793
    return v0
.end method

.method public toString()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "Success"
    return-object v0
.end method
