# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;
.super Ljava/lang/Object;
.source "SiteMessageApi.kt"

.field public static final $stable:I
.field private final data:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;
.field private final success:Ljava/lang/Boolean;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 3
    invoke-direct v2, v0, v0, v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.home.solo.sitemessage.SiteMessageListResponse$ListData  java.lang.Boolean)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->data Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->success Ljava/lang/Boolean;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.home.solo.sitemessage.SiteMessageListResponse$ListData  java.lang.Boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v4, 1
    const/4 v0, 0
    if-eqz v5, +003h
    move-object v2, v0
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    move-object v3, v0
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData; Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.sitemessage.SiteMessageListResponse  com.bytedance.trae.home.solo.sitemessage.SiteMessageListResponse$ListData  java.lang.Boolean  int  java.lang.Object)com.bytedance.trae.home.solo.sitemessage.SiteMessageListResponse
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->data Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->success Ljava/lang/Boolean;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->copy(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData; Ljava/lang/Boolean;)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.home.solo.sitemessage.SiteMessageListResponse$ListData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->data Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;
    return-object v0
.end method

.method public final component2()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->success Ljava/lang/Boolean;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.home.solo.sitemessage.SiteMessageListResponse$ListData  java.lang.Boolean)com.bytedance.trae.home.solo.sitemessage.SiteMessageListResponse
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData; Ljava/lang/Boolean;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->data Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->data Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->success Ljava/lang/Boolean;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->success Ljava/lang/Boolean;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getData()com.bytedance.trae.home.solo.sitemessage.SiteMessageListResponse$ListData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->data Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;
    return-object v0
.end method

.method public final getSuccess()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->success Ljava/lang/Boolean;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->data Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->success Ljava/lang/Boolean;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SiteMessageListResponse(data="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->data Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", success="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->success Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
