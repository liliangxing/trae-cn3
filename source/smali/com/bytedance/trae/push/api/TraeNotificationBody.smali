# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/push/api/TraeNotificationBody;
.super Ljava/lang/Object;
.source "TraeNotificationBody.kt"

.field private androidGroup:Ljava/lang/String;
.field private appName:Ljava/lang/String;
.field private avatarDisplayMode:I
.field private bdPushStr:Ljava/lang/String;
.field private channelId:Ljava/lang/String;
.field private channelImportance:I
.field private content:Ljava/lang/String;
.field private eventExtra:Lorg/json/JSONObject;
.field private forceSameWithIos:Z
.field private groupFoldNum:I
.field private groupId:Ljava/lang/String;
.field private iconBitmap:Landroid/graphics/Bitmap;
.field private id:J
.field private imageBitmap:Landroid/graphics/Bitmap;
.field private imageType:I
.field private imageUrl:Ljava/lang/String;
.field private notificationCategory:Ljava/lang/String;
.field private openUrl:Ljava/lang/String;
.field private redBadgeNum:I
.field private showWhen:Z
.field private sound:Landroid/net/Uri;
.field private title:Ljava/lang/String;
.field private useLED:Z
.field private useSound:Z
.field private useVibrator:Z


.method public constructor <init>()void
    .registers 30
    # ins_size=1
    move-object/from16 v0, v29
    const-wide/16 v1, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const v27, 33554431
    const/16 v28, 0
    invoke-direct/range v0 ... v28, Lcom/bytedance/trae/push/api/TraeNotificationBody;-><init>(J Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Landroid/graphics/Bitmap; Landroid/graphics/Bitmap; I Z Z Z Ljava/lang/String; I Landroid/net/Uri; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject; I Ljava/lang/String; I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(long  boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  android.graphics.Bitmap  android.graphics.Bitmap  int  boolean  boolean  boolean  java.lang.String  int  android.net.Uri  java.lang.String  java.lang.String  java.lang.String  org.json.JSONObject  int  java.lang.String  int  boolean)void
    .registers 30
    # ins_size=27
    move-object v0, v3
    invoke-direct v3, Ljava/lang/Object;-><init>()V
    move-wide v1, v4
    iput-wide v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->id J
    move v1, v6
    iput-boolean v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->showWhen Z
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->title Ljava/lang/String;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->content Ljava/lang/String;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupId Ljava/lang/String;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelId Ljava/lang/String;
    move v1, v11
    iput v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->redBadgeNum I
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageUrl Ljava/lang/String;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageBitmap Landroid/graphics/Bitmap;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->iconBitmap Landroid/graphics/Bitmap;
    move v1, v15
    iput v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageType I
    move/from16 v1, v16
    iput-boolean v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useLED Z
    move/from16 v1, v17
    iput-boolean v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useSound Z
    move/from16 v1, v18
    iput-boolean v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useVibrator Z
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->androidGroup Ljava/lang/String;
    move/from16 v1, v20
    iput v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupFoldNum I
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->sound Landroid/net/Uri;
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->bdPushStr Ljava/lang/String;
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->appName Ljava/lang/String;
    move-object/from16 v1, v24
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->openUrl Ljava/lang/String;
    move-object/from16 v1, v25
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->eventExtra Lorg/json/JSONObject;
    move/from16 v1, v26
    iput v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelImportance I
    move-object/from16 v1, v27
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->notificationCategory Ljava/lang/String;
    move/from16 v1, v28
    iput v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->avatarDisplayMode I
    move/from16 v1, v29
    iput-boolean v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->forceSameWithIos Z
    return-void 
.end method

.method public synthetic constructor <init>(long  boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  android.graphics.Bitmap  android.graphics.Bitmap  int  boolean  boolean  boolean  java.lang.String  int  android.net.Uri  java.lang.String  java.lang.String  java.lang.String  org.json.JSONObject  int  java.lang.String  int  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 55
    # ins_size=29
    move/from16 v0, v53
    and-int/lit8 v1, v0, 1
    if-eqz v1, +005h
    const-wide/16 v1, 0
    goto +3h
    move-wide/from16 v1, v27
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    const/4 v3, 0
    goto +3h
    move/from16 v3, v29
    and-int/lit8 v5, v0, 4
    if-eqz v5, +004h
    const/4 v5, 0
    goto +3h
    move-object/from16 v5, v30
    and-int/lit8 v7, v0, 8
    if-eqz v7, +004h
    const/4 v7, 0
    goto +3h
    move-object/from16 v7, v31
    and-int/lit8 v8, v0, 16
    if-eqz v8, +004h
    const/4 v8, 0
    goto +3h
    move-object/from16 v8, v32
    and-int/lit8 v9, v0, 32
    if-eqz v9, +004h
    const/4 v9, 0
    goto +3h
    move-object/from16 v9, v33
    and-int/lit8 v10, v0, 64
    if-eqz v10, +004h
    const/4 v10, 0
    goto +3h
    move/from16 v10, v34
    and-int/lit16 v11, v0, 128
    if-eqz v11, +004h
    const/4 v11, 0
    goto +3h
    move-object/from16 v11, v35
    and-int/lit16 v12, v0, 256
    if-eqz v12, +004h
    const/4 v12, 0
    goto +3h
    move-object/from16 v12, v36
    and-int/lit16 v13, v0, 512
    if-eqz v13, +004h
    const/4 v13, 0
    goto +3h
    move-object/from16 v13, v37
    and-int/lit16 v14, v0, 1024
    if-eqz v14, +004h
    const/4 v14, 0
    goto +3h
    move/from16 v14, v38
    and-int/lit16 v15, v0, 2048
    if-eqz v15, +004h
    const/4 v15, 0
    goto +3h
    move/from16 v15, v39
    and-int/lit16 v4, v0, 4096
    if-eqz v4, +004h
    const/4 v4, 0
    goto +3h
    move/from16 v4, v40
    and-int/lit16 v6, v0, 8192
    if-eqz v6, +004h
    const/4 v6, 0
    goto +3h
    move/from16 v6, v41
    move/from16 v54, v6
    and-int/lit16 v6, v0, 16384
    if-eqz v6, +004h
    const/4 v6, 0
    goto +3h
    move-object/from16 v6, v42
    const v16, 32768
    and-int v16, v0, v16
    if-eqz v16, +005h
    const/16 v16, 0
    goto +3h
    move/from16 v16, v43
    const/high16 v17, 65536
    and-int v17, v0, v17
    if-eqz v17, +005h
    const/16 v17, 0
    goto +3h
    move-object/from16 v17, v44
    const/high16 v18, 131072
    and-int v18, v0, v18
    if-eqz v18, +005h
    const/16 v18, 0
    goto +3h
    move-object/from16 v18, v45
    const/high16 v19, 262144
    and-int v19, v0, v19
    if-eqz v19, +005h
    const/16 v19, 0
    goto +3h
    move-object/from16 v19, v46
    const/high16 v20, 524288
    and-int v20, v0, v20
    if-eqz v20, +005h
    const/16 v20, 0
    goto +3h
    move-object/from16 v20, v47
    const/high16 v21, 1048576
    and-int v21, v0, v21
    if-eqz v21, +005h
    const/16 v21, 0
    goto +3h
    move-object/from16 v21, v48
    const/high16 v22, 2097152
    and-int v22, v0, v22
    if-eqz v22, +005h
    const/16 v22, 0
    goto +3h
    move/from16 v22, v49
    const/high16 v23, 4194304
    and-int v23, v0, v23
    if-eqz v23, +005h
    const/16 v23, 0
    goto +3h
    move-object/from16 v23, v50
    const/high16 v24, 8388608
    and-int v24, v0, v24
    if-eqz v24, +005h
    const/16 v24, 0
    goto +3h
    move/from16 v24, v51
    const/high16 v25, 16777216
    and-int v0, v0, v25
    if-eqz v0, +004h
    const/4 v0, 0
    goto +3h
    move/from16 v0, v52
    move-object/from16 v27, v26
    move-wide/from16 v28, v1
    move/from16 v30, v3
    move-object/from16 v31, v5
    move-object/from16 v32, v7
    move-object/from16 v33, v8
    move-object/from16 v34, v9
    move/from16 v35, v10
    move-object/from16 v36, v11
    move-object/from16 v37, v12
    move-object/from16 v38, v13
    move/from16 v39, v14
    move/from16 v40, v15
    move/from16 v41, v4
    move/from16 v42, v54
    move-object/from16 v43, v6
    move/from16 v44, v16
    move-object/from16 v45, v17
    move-object/from16 v46, v18
    move-object/from16 v47, v19
    move-object/from16 v48, v20
    move-object/from16 v49, v21
    move/from16 v50, v22
    move-object/from16 v51, v23
    move/from16 v52, v24
    move/from16 v53, v0
    invoke-direct/range v27 ... v53, Lcom/bytedance/trae/push/api/TraeNotificationBody;-><init>(J Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Landroid/graphics/Bitmap; Landroid/graphics/Bitmap; I Z Z Z Ljava/lang/String; I Landroid/net/Uri; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject; I Ljava/lang/String; I Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.push.api.TraeNotificationBody  long  boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  android.graphics.Bitmap  android.graphics.Bitmap  int  boolean  boolean  boolean  java.lang.String  int  android.net.Uri  java.lang.String  java.lang.String  java.lang.String  org.json.JSONObject  int  java.lang.String  int  boolean  int  java.lang.Object)com.bytedance.trae.push.api.TraeNotificationBody
    .registers 46
    # ins_size=29
    move-object/from16 v0, v17
    move/from16 v1, v44
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-wide v2, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->id J
    goto +3h
    move-wide/from16 v2, v18
    and-int/lit8 v4, v1, 2
    if-eqz v4, +005h
    iget-boolean v4, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->showWhen Z
    goto +3h
    move/from16 v4, v20
    and-int/lit8 v5, v1, 4
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->title Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v21
    and-int/lit8 v6, v1, 8
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->content Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v22
    and-int/lit8 v7, v1, 16
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupId Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v8, v1, 32
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelId Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v24
    and-int/lit8 v9, v1, 64
    if-eqz v9, +005h
    iget v9, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->redBadgeNum I
    goto +3h
    move/from16 v9, v25
    and-int/lit16 v10, v1, 128
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageUrl Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v26
    and-int/lit16 v11, v1, 256
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageBitmap Landroid/graphics/Bitmap;
    goto +3h
    move-object/from16 v11, v27
    and-int/lit16 v12, v1, 512
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->iconBitmap Landroid/graphics/Bitmap;
    goto +3h
    move-object/from16 v12, v28
    and-int/lit16 v13, v1, 1024
    if-eqz v13, +005h
    iget v13, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageType I
    goto +3h
    move/from16 v13, v29
    and-int/lit16 v14, v1, 2048
    if-eqz v14, +005h
    iget-boolean v14, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useLED Z
    goto +3h
    move/from16 v14, v30
    and-int/lit16 v15, v1, 4096
    if-eqz v15, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useSound Z
    goto +3h
    move/from16 v15, v31
    move/from16 v31, v15
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useVibrator Z
    goto +3h
    move/from16 v15, v32
    move/from16 v32, v15
    and-int/lit16 v15, v1, 16384
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->androidGroup Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v33
    const v16, 32768
    and-int v16, v1, v16
    move-object/from16 v33, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupFoldNum I
    goto +3h
    move/from16 v15, v34
    const/high16 v16, 65536
    and-int v16, v1, v16
    move/from16 v34, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->sound Landroid/net/Uri;
    goto +3h
    move-object/from16 v15, v35
    const/high16 v16, 131072
    and-int v16, v1, v16
    move-object/from16 v35, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->bdPushStr Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v36
    const/high16 v16, 262144
    and-int v16, v1, v16
    move-object/from16 v36, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->appName Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v37
    const/high16 v16, 524288
    and-int v16, v1, v16
    move-object/from16 v37, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->openUrl Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v38
    const/high16 v16, 1048576
    and-int v16, v1, v16
    move-object/from16 v38, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->eventExtra Lorg/json/JSONObject;
    goto +3h
    move-object/from16 v15, v39
    const/high16 v16, 2097152
    and-int v16, v1, v16
    move-object/from16 v39, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelImportance I
    goto +3h
    move/from16 v15, v40
    const/high16 v16, 4194304
    and-int v16, v1, v16
    move/from16 v40, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->notificationCategory Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v41
    const/high16 v16, 8388608
    and-int v16, v1, v16
    move-object/from16 v41, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->avatarDisplayMode I
    goto +3h
    move/from16 v15, v42
    const/high16 v16, 16777216
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget-boolean v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->forceSameWithIos Z
    goto +3h
    move/from16 v1, v43
    move-wide/from16 v18, v2
    move/from16 v20, v4
    move-object/from16 v21, v5
    move-object/from16 v22, v6
    move-object/from16 v23, v7
    move-object/from16 v24, v8
    move/from16 v25, v9
    move-object/from16 v26, v10
    move-object/from16 v27, v11
    move-object/from16 v28, v12
    move/from16 v29, v13
    move/from16 v30, v14
    move/from16 v42, v15
    move/from16 v43, v1
    invoke-virtual/range v17 ... v43, Lcom/bytedance/trae/push/api/TraeNotificationBody;->copy(J Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Landroid/graphics/Bitmap; Landroid/graphics/Bitmap; I Z Z Z Ljava/lang/String; I Landroid/net/Uri; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject; I Ljava/lang/String; I Z)Lcom/bytedance/trae/push/api/TraeNotificationBody;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/push/api/TraeNotificationBody;->id J
    return-wide v0
.end method

.method public final component10()android.graphics.Bitmap
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->iconBitmap Landroid/graphics/Bitmap;
    return-object v0
.end method

.method public final component11()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageType I
    return v0
.end method

.method public final component12()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useLED Z
    return v0
.end method

.method public final component13()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useSound Z
    return v0
.end method

.method public final component14()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useVibrator Z
    return v0
.end method

.method public final component15()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->androidGroup Ljava/lang/String;
    return-object v0
.end method

.method public final component16()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupFoldNum I
    return v0
.end method

.method public final component17()android.net.Uri
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->sound Landroid/net/Uri;
    return-object v0
.end method

.method public final component18()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->bdPushStr Ljava/lang/String;
    return-object v0
.end method

.method public final component19()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->appName Ljava/lang/String;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->showWhen Z
    return v0
.end method

.method public final component20()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->openUrl Ljava/lang/String;
    return-object v0
.end method

.method public final component21()org.json.JSONObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->eventExtra Lorg/json/JSONObject;
    return-object v0
.end method

.method public final component22()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelImportance I
    return v0
.end method

.method public final component23()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->notificationCategory Ljava/lang/String;
    return-object v0
.end method

.method public final component24()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->avatarDisplayMode I
    return v0
.end method

.method public final component25()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->forceSameWithIos Z
    return v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->title Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->content Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupId Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelId Ljava/lang/String;
    return-object v0
.end method

.method public final component7()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->redBadgeNum I
    return v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageUrl Ljava/lang/String;
    return-object v0
.end method

.method public final component9()android.graphics.Bitmap
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageBitmap Landroid/graphics/Bitmap;
    return-object v0
.end method

.method public final copy(long  boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  android.graphics.Bitmap  android.graphics.Bitmap  int  boolean  boolean  boolean  java.lang.String  int  android.net.Uri  java.lang.String  java.lang.String  java.lang.String  org.json.JSONObject  int  java.lang.String  int  boolean)com.bytedance.trae.push.api.TraeNotificationBody
    .registers 55
    # ins_size=27
    move-wide/from16 v1, v29
    move/from16 v3, v31
    move-object/from16 v4, v32
    move-object/from16 v5, v33
    move-object/from16 v6, v34
    move-object/from16 v7, v35
    move/from16 v8, v36
    move-object/from16 v9, v37
    move-object/from16 v10, v38
    move-object/from16 v11, v39
    move/from16 v12, v40
    move/from16 v13, v41
    move/from16 v14, v42
    move/from16 v15, v43
    move-object/from16 v16, v44
    move/from16 v17, v45
    move-object/from16 v18, v46
    move-object/from16 v19, v47
    move-object/from16 v20, v48
    move-object/from16 v21, v49
    move-object/from16 v22, v50
    move/from16 v23, v51
    move-object/from16 v24, v52
    move/from16 v25, v53
    move/from16 v26, v54
    new-instance v27, Lcom/bytedance/trae/push/api/TraeNotificationBody;
    move-object/from16 v0, v27
    invoke-direct/range v0 ... v26, Lcom/bytedance/trae/push/api/TraeNotificationBody;-><init>(J Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Landroid/graphics/Bitmap; Landroid/graphics/Bitmap; I Z Z Z Ljava/lang/String; I Landroid/net/Uri; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject; I Ljava/lang/String; I Z)V
    return-object v27
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;
    iget-wide v3, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->id J
    iget-wide v5, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->id J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->showWhen Z
    iget-boolean v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->showWhen Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->title Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->title Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->content Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->content Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->redBadgeNum I
    iget v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->redBadgeNum I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageUrl Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageUrl Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageBitmap Landroid/graphics/Bitmap;
    iget-object v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageBitmap Landroid/graphics/Bitmap;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->iconBitmap Landroid/graphics/Bitmap;
    iget-object v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->iconBitmap Landroid/graphics/Bitmap;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageType I
    iget v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageType I
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useLED Z
    iget-boolean v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useLED Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useSound Z
    iget-boolean v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useSound Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useVibrator Z
    iget-boolean v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useVibrator Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->androidGroup Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->androidGroup Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupFoldNum I
    iget v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupFoldNum I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->sound Landroid/net/Uri;
    iget-object v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->sound Landroid/net/Uri;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->bdPushStr Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->bdPushStr Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->appName Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->appName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->openUrl Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->openUrl Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->eventExtra Lorg/json/JSONObject;
    iget-object v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->eventExtra Lorg/json/JSONObject;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelImportance I
    iget v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelImportance I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->notificationCategory Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->notificationCategory Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->avatarDisplayMode I
    iget v3, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->avatarDisplayMode I
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/push/api/TraeNotificationBody;->forceSameWithIos Z
    iget-boolean v8, v8, Lcom/bytedance/trae/push/api/TraeNotificationBody;->forceSameWithIos Z
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getAndroidGroup()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->androidGroup Ljava/lang/String;
    return-object v0
.end method

.method public final getAppName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->appName Ljava/lang/String;
    return-object v0
.end method

.method public final getAvatarDisplayMode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->avatarDisplayMode I
    return v0
.end method

.method public final getBdPushStr()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->bdPushStr Ljava/lang/String;
    return-object v0
.end method

.method public final getChannelId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelId Ljava/lang/String;
    return-object v0
.end method

.method public final getChannelImportance()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelImportance I
    return v0
.end method

.method public final getContent()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->content Ljava/lang/String;
    return-object v0
.end method

.method public final getEventExtra()org.json.JSONObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->eventExtra Lorg/json/JSONObject;
    return-object v0
.end method

.method public final getForceSameWithIos()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->forceSameWithIos Z
    return v0
.end method

.method public final getGroupFoldNum()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupFoldNum I
    return v0
.end method

.method public final getGroupId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupId Ljava/lang/String;
    return-object v0
.end method

.method public final getIconBitmap()android.graphics.Bitmap
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->iconBitmap Landroid/graphics/Bitmap;
    return-object v0
.end method

.method public final getId()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/push/api/TraeNotificationBody;->id J
    return-wide v0
.end method

.method public final getImageBitmap()android.graphics.Bitmap
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageBitmap Landroid/graphics/Bitmap;
    return-object v0
.end method

.method public final getImageType()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageType I
    return v0
.end method

.method public final getImageUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageUrl Ljava/lang/String;
    return-object v0
.end method

.method public final getNotificationCategory()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->notificationCategory Ljava/lang/String;
    return-object v0
.end method

.method public final getOpenUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->openUrl Ljava/lang/String;
    return-object v0
.end method

.method public final getRedBadgeNum()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->redBadgeNum I
    return v0
.end method

.method public final getShowWhen()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->showWhen Z
    return v0
.end method

.method public final getSound()android.net.Uri
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->sound Landroid/net/Uri;
    return-object v0
.end method

.method public final getTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->title Ljava/lang/String;
    return-object v0
.end method

.method public final getUseLED()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useLED Z
    return v0
.end method

.method public final getUseSound()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useSound Z
    return v0
.end method

.method public final getUseVibrator()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useVibrator Z
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-wide v0, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->id J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->showWhen Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->title Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->content Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->redBadgeNum I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageUrl Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageBitmap Landroid/graphics/Bitmap;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Landroid/graphics/Bitmap;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->iconBitmap Landroid/graphics/Bitmap;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Landroid/graphics/Bitmap;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageType I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useLED Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useSound Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useVibrator Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->androidGroup Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupFoldNum I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->sound Landroid/net/Uri;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Landroid/net/Uri;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->bdPushStr Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->appName Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->openUrl Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->eventExtra Lorg/json/JSONObject;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lorg/json/JSONObject;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelImportance I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->notificationCategory Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->avatarDisplayMode I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->forceSameWithIos Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final setAndroidGroup(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->androidGroup Ljava/lang/String;
    return-void 
.end method

.method public final setAppName(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->appName Ljava/lang/String;
    return-void 
.end method

.method public final setAvatarDisplayMode(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->avatarDisplayMode I
    return-void 
.end method

.method public final setBdPushStr(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->bdPushStr Ljava/lang/String;
    return-void 
.end method

.method public final setChannelId(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelId Ljava/lang/String;
    return-void 
.end method

.method public final setChannelImportance(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelImportance I
    return-void 
.end method

.method public final setContent(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->content Ljava/lang/String;
    return-void 
.end method

.method public final setEventExtra(org.json.JSONObject)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->eventExtra Lorg/json/JSONObject;
    return-void 
.end method

.method public final setForceSameWithIos(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->forceSameWithIos Z
    return-void 
.end method

.method public final setGroupFoldNum(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupFoldNum I
    return-void 
.end method

.method public final setGroupId(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupId Ljava/lang/String;
    return-void 
.end method

.method public final setIconBitmap(android.graphics.Bitmap)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->iconBitmap Landroid/graphics/Bitmap;
    return-void 
.end method

.method public final setId(long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->id J
    return-void 
.end method

.method public final setImageBitmap(android.graphics.Bitmap)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageBitmap Landroid/graphics/Bitmap;
    return-void 
.end method

.method public final setImageType(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageType I
    return-void 
.end method

.method public final setImageUrl(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageUrl Ljava/lang/String;
    return-void 
.end method

.method public final setNotificationCategory(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->notificationCategory Ljava/lang/String;
    return-void 
.end method

.method public final setOpenUrl(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->openUrl Ljava/lang/String;
    return-void 
.end method

.method public final setRedBadgeNum(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->redBadgeNum I
    return-void 
.end method

.method public final setShowWhen(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->showWhen Z
    return-void 
.end method

.method public final setSound(android.net.Uri)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->sound Landroid/net/Uri;
    return-void 
.end method

.method public final setTitle(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->title Ljava/lang/String;
    return-void 
.end method

.method public final setUseLED(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useLED Z
    return-void 
.end method

.method public final setUseSound(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useSound Z
    return-void 
.end method

.method public final setUseVibrator(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useVibrator Z
    return-void 
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TraeNotificationBody(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->id J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", showWhen="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->showWhen Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", title="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->title Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", content="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->content Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", groupId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", channelId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", redBadgeNum="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->redBadgeNum I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", imageUrl="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageUrl Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", imageBitmap="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageBitmap Landroid/graphics/Bitmap;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", iconBitmap="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->iconBitmap Landroid/graphics/Bitmap;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", imageType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->imageType I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", useLED="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-boolean v1, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useLED Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", useSound="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useSound Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", useVibrator="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->useVibrator Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", androidGroup="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->androidGroup Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", groupFoldNum="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->groupFoldNum I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sound="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->sound Landroid/net/Uri;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bdPushStr="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->bdPushStr Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", appName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->appName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", openUrl="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->openUrl Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", eventExtra="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->eventExtra Lorg/json/JSONObject;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", channelImportance="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->channelImportance I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", notificationCategory="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->notificationCategory Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v1, ", avatarDisplayMode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->avatarDisplayMode I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", forceSameWithIos="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->forceSameWithIos Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
