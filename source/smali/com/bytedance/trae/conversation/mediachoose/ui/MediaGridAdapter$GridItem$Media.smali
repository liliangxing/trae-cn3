# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;
.super Ljava/lang/Object;
.source "MediaGridAdapter.kt"

.implements Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem;

.field private final item:Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;


.method public constructor <init>(com.bytedance.trae.conversation.mediachoose.model.MediaItem)void
    .registers 3
    # ins_size=2
    const-string v0, "item"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;->item Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.mediachoose.ui.MediaGridAdapter$GridItem$Media  com.bytedance.trae.conversation.mediachoose.model.MediaItem  int  java.lang.Object)com.bytedance.trae.conversation.mediachoose.ui.MediaGridAdapter$GridItem$Media
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;->item Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;->copy(Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;)Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.mediachoose.model.MediaItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;->item Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.mediachoose.model.MediaItem)com.bytedance.trae.conversation.mediachoose.ui.MediaGridAdapter$GridItem$Media
    .registers 3
    # ins_size=2
    const-string v0, "item"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;-><init>(Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;->item Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    iget-object v4, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;->item Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getItem()com.bytedance.trae.conversation.mediachoose.model.MediaItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;->item Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;->item Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->hashCode()I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Media(item="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;->item Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
