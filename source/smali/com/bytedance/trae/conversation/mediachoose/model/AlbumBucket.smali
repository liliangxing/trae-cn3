# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;
.super Ljava/lang/Object;
.source "AlbumBucket.kt"

.field private final count:I
.field private final coverUri:Landroid/net/Uri;
.field private final id:J
.field private final name:Ljava/lang/String;


.method public constructor <init>(long  java.lang.String  int  android.net.Uri)void
    .registers 7
    # ins_size=6
    const-string v0, "name"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-wide v2, v1, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->id J
    iput-object v4, v1, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->name Ljava/lang/String;
    iput v5, v1, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->count I
    iput-object v6, v1, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->coverUri Landroid/net/Uri;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.mediachoose.model.AlbumBucket  long  java.lang.String  int  android.net.Uri  int  java.lang.Object)com.bytedance.trae.conversation.mediachoose.model.AlbumBucket
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 1
    if-eqz v13, +004h
    iget-wide v7, v6, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->id J
    move-wide v1, v7
    and-int/lit8 v7, v12, 2
    if-eqz v7, +004h
    iget-object v9, v6, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->name Ljava/lang/String;
    move-object v3, v9
    and-int/lit8 v7, v12, 4
    if-eqz v7, +004h
    iget v10, v6, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->count I
    move v4, v10
    and-int/lit8 v7, v12, 8
    if-eqz v7, +004h
    iget-object v11, v6, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->coverUri Landroid/net/Uri;
    move-object v5, v11
    move-object v0, v6
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->copy(J Ljava/lang/String; I Landroid/net/Uri;)Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;
    move-result-object v6
    return-object v6
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->id J
    return-wide v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->name Ljava/lang/String;
    return-object v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->count I
    return v0
.end method

.method public final component4()android.net.Uri
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->coverUri Landroid/net/Uri;
    return-object v0
.end method

.method public final copy(long  java.lang.String  int  android.net.Uri)com.bytedance.trae.conversation.mediachoose.model.AlbumBucket
    .registers 13
    # ins_size=6
    const-string v0, "name"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;
    move-object v1, v0
    move-wide v2, v8
    move-object v4, v10
    move v5, v11
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;-><init>(J Ljava/lang/String; I Landroid/net/Uri;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->id J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->id J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->name Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->name Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->count I
    iget v3, v8, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->count I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->coverUri Landroid/net/Uri;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->coverUri Landroid/net/Uri;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->count I
    return v0
.end method

.method public final getCoverUri()android.net.Uri
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->coverUri Landroid/net/Uri;
    return-object v0
.end method

.method public final getId()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->id J
    return-wide v0
.end method

.method public final getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->name Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->id J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->name Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->count I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->coverUri Landroid/net/Uri;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Landroid/net/Uri;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "AlbumBucket(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->id J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", name="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->name Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", count="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->count I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", coverUri="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->coverUri Landroid/net/Uri;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
