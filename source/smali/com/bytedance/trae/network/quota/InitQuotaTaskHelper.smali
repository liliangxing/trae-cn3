# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/quota/InitQuotaTaskHelper;
.super Ljava/lang/Object;
.source "InitQuotaTaskHelper.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/network/quota/InitQuotaTaskHelper;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/quota/InitQuotaTaskHelper;
    invoke-direct v0, Lcom/bytedance/trae/network/quota/InitQuotaTaskHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/quota/InitQuotaTaskHelper;->INSTANCE Lcom/bytedance/trae/network/quota/InitQuotaTaskHelper;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final getBDNetworkTagDependImpl(java.lang.String)com.ss.android.ugc.quota.IBDNetworkTagDepend
    .registers 2
    # ins_size=1
    const-string v0, "lazyType"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/network/quota/InitQuotaTaskHelper$getBDNetworkTagDependImpl$1;
    invoke-direct v1, Lcom/bytedance/trae/network/quota/InitQuotaTaskHelper$getBDNetworkTagDependImpl$1;-><init>()V
    check-cast v1, Lcom/ss/android/ugc/quota/IBDNetworkTagDepend;
    return-object v1
.end method
