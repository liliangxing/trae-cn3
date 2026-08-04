# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem$Creator;
.super Ljava/lang/Object;
.source "MediaItem.kt"

.implements Landroid/os/Parcelable$Creator;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final createFromParcel(android.os.Parcel)com.bytedance.trae.conversation.mediachoose.model.MediaItem
    .registers 20
    # ins_size=2
    move-object/from16 v0, v19
    const-string v1, "parcel"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual/range v19, Landroid/os/Parcel;->readLong()J
    move-result-wide v3
    const-class v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v2, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;
    move-result-object v2
    invoke-virtual v0, v2, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/net/Uri;
    invoke-virtual/range v19, Landroid/os/Parcel;->readString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual/range v19, Landroid/os/Parcel;->readLong()J
    move-result-wide v7
    invoke-virtual/range v19, Landroid/os/Parcel;->readLong()J
    move-result-wide v9
    invoke-virtual/range v19, Landroid/os/Parcel;->readString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual/range v19, Landroid/os/Parcel;->readInt()I
    move-result v12
    invoke-virtual/range v19, Landroid/os/Parcel;->readInt()I
    move-result v13
    invoke-virtual/range v19, Landroid/os/Parcel;->readLong()J
    move-result-wide v14
    invoke-virtual/range v19, Landroid/os/Parcel;->readInt()I
    move-result v2
    if-eqz v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    move/from16 v16, v2
    invoke-virtual/range v19, Landroid/os/Parcel;->readString()Ljava/lang/String;
    move-result-object v17
    move-object v2, v1
    invoke-direct/range v2 ... v17, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;-><init>(J Landroid/net/Uri; Ljava/lang/String; J J Ljava/lang/String; I I J Z Ljava/lang/String;)V
    return-object v1
.end method

.method public bridge synthetic createFromParcel(android.os.Parcel)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem$Creator;->createFromParcel(Landroid/os/Parcel;)Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    move-result-object v1
    return-object v1
.end method

.method public final newArray(int)com.bytedance.trae.conversation.mediachoose.model.MediaItem[]
    .registers 2
    # ins_size=2
    new-array v1, v1, [Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    return-object v1
.end method

.method public bridge synthetic newArray(int)java.lang.Object[]
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem$Creator;->newArray(I)[Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    move-result-object v1
    return-object v1
.end method
