# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
.super Ljava/lang/Object;
.source "KmpHttpClient.kt"

.field public static final $stable:I
.field private final addCommonHeaders:Z
.field private final addPpeHeaders:Z
.field private final auth:Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
.field private final hostType:Lcom/bytedance/trae/kmp/network/KmpHostType;
.field private final tag:Ljava/lang/String;
.field private final trackRequestEvent:Z


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 10
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 63
    const/4 v8, 0
    move-object v0, v9
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;-><init>(Ljava/lang/String; Z Z Z Lcom/bytedance/trae/kmp/network/KmpRequestAuth; Lcom/bytedance/trae/kmp/network/KmpHostType; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  boolean  boolean  boolean  com.bytedance.trae.kmp.network.KmpRequestAuth  com.bytedance.trae.kmp.network.KmpHostType)void
    .registers 8
    # ins_size=7
    const-string v0, "auth"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->tag Ljava/lang/String;
    iput-boolean v3, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->addPpeHeaders Z
    iput-boolean v4, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->addCommonHeaders Z
    iput-boolean v5, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->trackRequestEvent Z
    iput-object v6, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->auth Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    iput-object v7, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->hostType Lcom/bytedance/trae/kmp/network/KmpHostType;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  boolean  boolean  boolean  com.bytedance.trae.kmp.network.KmpRequestAuth  com.bytedance.trae.kmp.network.KmpHostType  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 14
    # ins_size=9
    and-int/lit8 v13, v12, 1
    const/4 v0, 0
    if-eqz v13, +004h
    move-object v13, v0
    goto +2h
    move-object v13, v6
    and-int/lit8 v6, v12, 2
    if-eqz v6, +003h
    const/4 v7, 0
    move v1, v7
    and-int/lit8 v6, v12, 4
    const/4 v7, 1
    if-eqz v6, +004h
    move v2, v7
    goto +2h
    move v2, v8
    and-int/lit8 v6, v12, 8
    if-eqz v6, +004h
    move v3, v7
    goto +2h
    move v3, v9
    and-int/lit8 v6, v12, 16
    if-eqz v6, +004h
    sget-object v10, Lcom/bytedance/trae/kmp/network/KmpRequestAuth;->None Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    move-object v4, v10
    and-int/lit8 v6, v12, 32
    if-eqz v6, +004h
    move-object v12, v0
    goto +2h
    move-object v12, v11
    move-object v6, v5
    move-object v7, v13
    move v8, v1
    move v9, v2
    move v10, v3
    move-object v11, v4
    invoke-direct/range v6 ... v12, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;-><init>(Ljava/lang/String; Z Z Z Lcom/bytedance/trae/kmp/network/KmpRequestAuth; Lcom/bytedance/trae/kmp/network/KmpHostType;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.network.KmpHttpRequestOptions  java.lang.String  boolean  boolean  boolean  com.bytedance.trae.kmp.network.KmpRequestAuth  com.bytedance.trae.kmp.network.KmpHostType  int  java.lang.Object)com.bytedance.trae.kmp.network.KmpHttpRequestOptions
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget-object v5, v4, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->tag Ljava/lang/String;
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-boolean v6, v4, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->addPpeHeaders Z
    move v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget-boolean v7, v4, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->addCommonHeaders Z
    move v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-boolean v8, v4, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->trackRequestEvent Z
    move v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-object v9, v4, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->auth Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    move-object v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    iget-object v10, v4, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->hostType Lcom/bytedance/trae/kmp/network/KmpHostType;
    move-object v3, v10
    move-object v6, v4
    move-object v7, v5
    move v8, v12
    move v9, v0
    move v10, v1
    move-object v11, v2
    move-object v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->copy(Ljava/lang/String; Z Z Z Lcom/bytedance/trae/kmp/network/KmpRequestAuth; Lcom/bytedance/trae/kmp/network/KmpHostType;)Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    move-result-object v4
    return-object v4
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->tag Ljava/lang/String;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->addPpeHeaders Z
    return v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->addCommonHeaders Z
    return v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->trackRequestEvent Z
    return v0
.end method

.method public final component5()com.bytedance.trae.kmp.network.KmpRequestAuth
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->auth Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    return-object v0
.end method

.method public final component6()com.bytedance.trae.kmp.network.KmpHostType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->hostType Lcom/bytedance/trae/kmp/network/KmpHostType;
    return-object v0
.end method

.method public final copy(java.lang.String  boolean  boolean  boolean  com.bytedance.trae.kmp.network.KmpRequestAuth  com.bytedance.trae.kmp.network.KmpHostType)com.bytedance.trae.kmp.network.KmpHttpRequestOptions
    .registers 15
    # ins_size=7
    const-string v0, "auth"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    move-object v1, v0
    move-object v2, v9
    move v3, v10
    move v4, v11
    move v5, v12
    move-object v6, v13
    move-object v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;-><init>(Ljava/lang/String; Z Z Z Lcom/bytedance/trae/kmp/network/KmpRequestAuth; Lcom/bytedance/trae/kmp/network/KmpHostType;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->tag Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->tag Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->addPpeHeaders Z
    iget-boolean v3, v5, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->addPpeHeaders Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->addCommonHeaders Z
    iget-boolean v3, v5, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->addCommonHeaders Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->trackRequestEvent Z
    iget-boolean v3, v5, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->trackRequestEvent Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->auth Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->auth Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->hostType Lcom/bytedance/trae/kmp/network/KmpHostType;
    iget-object v5, v5, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->hostType Lcom/bytedance/trae/kmp/network/KmpHostType;
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getAddCommonHeaders()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->addCommonHeaders Z
    return v0
.end method

.method public final getAddPpeHeaders()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->addPpeHeaders Z
    return v0
.end method

.method public final getAuth()com.bytedance.trae.kmp.network.KmpRequestAuth
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->auth Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    return-object v0
.end method

.method public final getHostType()com.bytedance.trae.kmp.network.KmpHostType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->hostType Lcom/bytedance/trae/kmp/network/KmpHostType;
    return-object v0
.end method

.method public final getTag()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->tag Ljava/lang/String;
    return-object v0
.end method

.method public final getTrackRequestEvent()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->trackRequestEvent Z
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->tag Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v2, v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->addPpeHeaders Z
    invoke-static v2, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-boolean v2, v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->addCommonHeaders Z
    invoke-static v2, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-boolean v2, v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->trackRequestEvent Z
    invoke-static v2, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->auth Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    invoke-virtual v2, Lcom/bytedance/trae/kmp/network/KmpRequestAuth;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->hostType Lcom/bytedance/trae/kmp/network/KmpHostType;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "KmpHttpRequestOptions(tag="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->tag Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", addPpeHeaders="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->addPpeHeaders Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", addCommonHeaders="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->addCommonHeaders Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", trackRequestEvent="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->trackRequestEvent Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", auth="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->auth Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hostType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->hostType Lcom/bytedance/trae/kmp/network/KmpHostType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
