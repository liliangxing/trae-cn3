# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
.super Ljava/lang/Object;
.source "UserPayStatusApi.kt"

.field public static final $stable:I
.field private final userPayIdentity:Ljava/lang/Integer;
.field private final userPayIdentityStr:Ljava/lang/String;


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
    invoke-direct v2, v0, v0, v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;-><init>(Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.Integer  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentity Ljava/lang/Integer;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentityStr Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.Integer  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v4, 1
    const/4 v0, 0
    if-eqz v5, +003h
    move-object v2, v0
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    move-object v3, v0
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;-><init>(Ljava/lang/Integer; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.UserPayStatusData  java.lang.Integer  java.lang.String  int  java.lang.Object)com.bytedance.trae.home.solo.setting.UserPayStatusData
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentity Ljava/lang/Integer;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentityStr Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->copy(Ljava/lang/Integer; Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentity Ljava/lang/Integer;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentityStr Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.Integer  java.lang.String)com.bytedance.trae.home.solo.setting.UserPayStatusData
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;-><init>(Ljava/lang/Integer; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentity Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentity Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentityStr Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentityStr Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getIdentity()com.bytedance.trae.home.solo.setting.UserPayIdentity
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->Companion Lcom/bytedance/trae/home/solo/setting/UserPayIdentity$Companion;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentity Ljava/lang/Integer;
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    goto +2h
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity$Companion;->fromValue(I)Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    move-result-object v0
    return-object v0
.end method

.method public final getUserPayIdentity()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentity Ljava/lang/Integer;
    return-object v0
.end method

.method public final getUserPayIdentityStr()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentityStr Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentity Ljava/lang/Integer;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentityStr Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isPaidUser()boolean
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentity Ljava/lang/Integer;
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    goto +2h
    move v0, v1
    if-lez v0, +003h
    const/4 v1, 1
    return v1
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "UserPayStatusData(userPayIdentity="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentity Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", userPayIdentityStr="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;->userPayIdentityStr Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
