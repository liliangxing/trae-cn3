# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig$Creator;
.super Ljava/lang/Object;
.source "MediaChooseConfig.kt"

.implements Landroid/os/Parcelable$Creator;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final createFromParcel(android.os.Parcel)com.bytedance.trae.conversation.mediachoose.model.MediaChooseConfig
    .registers 15
    # ins_size=2
    const-string v0, "parcel"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    invoke-virtual v14, Landroid/os/Parcel;->readInt()I
    move-result v2
    invoke-virtual v14, Landroid/os/Parcel;->readString()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    move-result-object v3
    invoke-virtual v14, Landroid/os/Parcel;->readInt()I
    move-result v1
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v1, +004h
    move v6, v4
    goto +2h
    move v6, v5
    invoke-virtual v14, Landroid/os/Parcel;->readInt()I
    move-result v1
    if-eqz v1, +004h
    move v7, v4
    goto +2h
    move v7, v5
    invoke-virtual v14, Landroid/os/Parcel;->readInt()I
    move-result v1
    if-eqz v1, +004h
    move v8, v4
    goto +2h
    move v8, v5
    invoke-virtual v14, Landroid/os/Parcel;->readInt()I
    move-result v1
    if-eqz v1, +004h
    move v9, v4
    goto +2h
    move v9, v5
    invoke-virtual v14, Landroid/os/Parcel;->readInt()I
    move-result v1
    if-eqz v1, +004h
    move v10, v4
    goto +2h
    move v10, v5
    invoke-virtual v14, Landroid/os/Parcel;->readString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v14, Landroid/os/Parcel;->readInt()I
    move-result v12
    invoke-virtual v14, Landroid/os/Parcel;->readInt()I
    move-result v14
    if-eqz v14, +004h
    move v14, v4
    goto +2h
    move v14, v5
    move-object v1, v0
    move v4, v6
    move v5, v7
    move v6, v8
    move v7, v9
    move v8, v10
    move-object v9, v11
    move v10, v12
    move v11, v14
    invoke-direct/range v1 ... v11, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;-><init>(I Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; Z Z Z Z Z Ljava/lang/String; I Z)V
    return-object v0
.end method

.method public bridge synthetic createFromParcel(android.os.Parcel)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig$Creator;->createFromParcel(Landroid/os/Parcel;)Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    move-result-object v1
    return-object v1
.end method

.method public final newArray(int)com.bytedance.trae.conversation.mediachoose.model.MediaChooseConfig[]
    .registers 2
    # ins_size=2
    new-array v1, v1, [Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    return-object v1
.end method

.method public bridge synthetic newArray(int)java.lang.Object[]
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig$Creator;->newArray(I)[Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    move-result-object v1
    return-object v1
.end method
