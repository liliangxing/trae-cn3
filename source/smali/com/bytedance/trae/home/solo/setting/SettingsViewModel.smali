# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
.super Landroidx/lifecycle/AndroidViewModel;
.source "SettingsViewModel.kt"

.field public static final $stable:I
.field private static final AVATAR_MAX_DIMENSION:I
.field private static final AVATAR_MAX_SIZE_BYTES:J
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$Companion;
.field private static final TAG:Ljava/lang/String;
.field private final _creditsBalanceSnapshot:Landroidx/lifecycle/MutableLiveData;
.field private final _isLoading:Landroidx/lifecycle/MutableLiveData;
.field private final _updateNameResult:Landroidx/lifecycle/MutableLiveData;
.field private final _uploadAvatarResult:Landroidx/lifecycle/MutableLiveData;
.field private final _userCNPayStatus:Landroidx/lifecycle/MutableLiveData;
.field private final _userPayStatus:Landroidx/lifecycle/MutableLiveData;
.field private final _userProfile:Landroidx/lifecycle/MutableLiveData;
.field private creditsBalanceFetchJob:Lkotlinx/coroutines/Job;
.field private final creditsBalanceSnapshot:Landroidx/lifecycle/LiveData;
.field private final isLoading:Landroidx/lifecycle/LiveData;
.field private final updateNameResult:Landroidx/lifecycle/LiveData;
.field private final uploadAvatarResult:Landroidx/lifecycle/LiveData;
.field private final userCNPayStatus:Landroidx/lifecycle/LiveData;
.field private final userPayStatus:Landroidx/lifecycle/LiveData;
.field private final userProfile:Landroidx/lifecycle/LiveData;


.method public static synthetic $r8$lambda$HPi-5HL200JnLNEiNAGgN0pIrjE(com.bytedance.trae.home.solo.setting.SettingsViewModel  int)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->updateNickname$lambda$13(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$PO5Rt1zPXJp_Pl8OW9tfLEdixVQ(com.bytedance.trae.home.solo.setting.SettingsViewModel  com.bytedance.trae.login.api.AccountInfo)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->doRefreshUserInfo$lambda$11(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Lcom/bytedance/trae/login/api/AccountInfo;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$YW9DmDo92EoPbdCiR7R7BzXA8Rk(com.bytedance.trae.home.solo.setting.SettingsViewModel  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->updateNickname$lambda$12(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->Companion Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->$stable I
    return-void 
.end method

.method public constructor <init>(android.app.Application)void
    .registers 3
    # ins_size=2
    const-string v0, "application"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Landroidx/lifecycle/AndroidViewModel;-><init>(Landroid/app/Application;)V
    new-instance v2, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v2, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userProfile Landroidx/lifecycle/MutableLiveData;
    check-cast v2, Landroidx/lifecycle/LiveData;
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->userProfile Landroidx/lifecycle/LiveData;
    new-instance v2, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v2, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_updateNameResult Landroidx/lifecycle/MutableLiveData;
    check-cast v2, Landroidx/lifecycle/LiveData;
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->updateNameResult Landroidx/lifecycle/LiveData;
    new-instance v2, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v2, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_uploadAvatarResult Landroidx/lifecycle/MutableLiveData;
    check-cast v2, Landroidx/lifecycle/LiveData;
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->uploadAvatarResult Landroidx/lifecycle/LiveData;
    new-instance v2, Landroidx/lifecycle/MutableLiveData;
    const/4 v0, 0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-direct v2, v0, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    check-cast v2, Landroidx/lifecycle/LiveData;
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->isLoading Landroidx/lifecycle/LiveData;
    new-instance v2, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v2, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userPayStatus Landroidx/lifecycle/MutableLiveData;
    check-cast v2, Landroidx/lifecycle/LiveData;
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->userPayStatus Landroidx/lifecycle/LiveData;
    new-instance v2, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v2, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userCNPayStatus Landroidx/lifecycle/MutableLiveData;
    check-cast v2, Landroidx/lifecycle/LiveData;
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->userCNPayStatus Landroidx/lifecycle/LiveData;
    new-instance v2, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v2, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_creditsBalanceSnapshot Landroidx/lifecycle/MutableLiveData;
    check-cast v2, Landroidx/lifecycle/LiveData;
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->creditsBalanceSnapshot Landroidx/lifecycle/LiveData;
    return-void 
.end method

.method public static final synthetic access$copyAndCompressAvatar(com.bytedance.trae.home.solo.setting.SettingsViewModel  android.app.Application  android.net.Uri)java.io.File
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->copyAndCompressAvatar(Landroid/app/Application; Landroid/net/Uri;)Ljava/io/File;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$get_creditsBalanceSnapshot$p(com.bytedance.trae.home.solo.setting.SettingsViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_creditsBalanceSnapshot Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_isLoading$p(com.bytedance.trae.home.solo.setting.SettingsViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_uploadAvatarResult$p(com.bytedance.trae.home.solo.setting.SettingsViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_uploadAvatarResult Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_userCNPayStatus$p(com.bytedance.trae.home.solo.setting.SettingsViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userCNPayStatus Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_userPayStatus$p(com.bytedance.trae.home.solo.setting.SettingsViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userPayStatus Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_userProfile$p(com.bytedance.trae.home.solo.setting.SettingsViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userProfile Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method private final copyAndCompressAvatar(android.app.Application  android.net.Uri)java.io.File
    .registers 15
    # ins_size=3
    const-string v0, "SettingsViewModel"
    const-string v1, "avatar_upload_"
    const/4 v2, 0
    invoke-virtual v13, Landroid/app/Application;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v3
    invoke-virtual v3, v14, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;
    move-result-object v14
    if-nez v14, +003h
    return-object v2
    new-instance v3, Ljava/io/File;
    invoke-virtual v13, Landroid/app/Application;->getCacheDir()Ljava/io/File;
    move-result-object v4
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    invoke-virtual v5, v6, v7, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v5, ".jpg"
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v3, v4, v1, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    new-instance v1, Ljava/io/FileOutputStream;
    invoke-direct v1, v3, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    check-cast v1, Ljava/io/Closeable;
    move-object v4, v1
    check-cast v4, Ljava/io/FileOutputStream;
    check-cast v4, Ljava/io/OutputStream;
    const/4 v5, 2
    const/4 v6, 0
    invoke-static v14, v4, v6, v5, v2, Lkotlin/io/ByteStreamsKt;->copyTo$default(Ljava/io/InputStream; Ljava/io/OutputStream; I I Ljava/lang/Object;)J
    invoke-static v1, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    invoke-virtual v14, Ljava/io/InputStream;->close()V
    invoke-direct v12, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->cropToSquare(Ljava/io/File;)Ljava/io/File;
    move-result-object v14
    if-nez v14, +003h
    goto +2h
    move-object v3, v14
    invoke-virtual v3, Ljava/io/File;->length()J
    move-result-wide v4
    const-wide/32 v7, 512000
    cmp-long v14, v4, v7
    const/4 v1, 1
    if-gtz v14, +023h
    move-object v14, v12
    check-cast v14, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    new-instance v14, Landroid/graphics/BitmapFactory$Options;
    invoke-direct v14, Landroid/graphics/BitmapFactory$Options;-><init>()V
    iput-boolean v1, v14, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds Z
    invoke-virtual v3, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v14, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String; Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    iget v4, v14, Landroid/graphics/BitmapFactory$Options;->outWidth I
    const/16 v5, 1024
    if-gt v4, v5, +009h
    iget v14, v14, Landroid/graphics/BitmapFactory$Options;->outHeight I
    if-le v14, v5, +003h
    goto +3h
    move v14, v6
    goto +2h
    move v14, v1
    if-eqz v14, +003h
    move v6, v1
    if-nez v6, +003h
    return-object v3
    new-instance v14, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;
    invoke-virtual v13, Landroid/app/Application;->getCacheDir()Ljava/io/File;
    move-result-object v13
    const-string v1, "getCacheDir(...)"
    invoke-static v13, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v14, v13, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;-><init>(Ljava/io/File;)V
    new-instance v13, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;
    const-wide/32 v5, 512000
    const/16 v7, 1024
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 12
    const/4 v11, 0
    move-object v4, v13
    invoke-direct/range v4 ... v11, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;-><init>(J I F Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v14, v3, v2, v13, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;->compressIfNeeded(Ljava/io/File; Lcom/bytedance/trae/conversation/imageupload/ImageDimension; Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;)Lcom/bytedance/trae/conversation/imageupload/CompressionResult;
    move-result-object v13
    invoke-virtual v13, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->getWasCompressed()Z
    move-result v14
    if-eqz v14, +00fh
    invoke-virtual v13, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->getFile()Ljava/io/File;
    move-result-object v14
    invoke-static v14, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-nez v14, +005h
    invoke-virtual v3, Ljava/io/File;->delete()Z
    invoke-virtual v13, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->getFile()Ljava/io/File;
    move-result-object v13
    return-object v13
    move-exception v13
    throw v13
    move-exception v14
    invoke-static v1, v13, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v14
    move-exception v13
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v3, uploadAvatar copy/compress exception: 
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v14, v0, v13, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-object v2
    move-exception v13
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v3, uploadAvatar OOM: 
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Ljava/lang/OutOfMemoryError;->getMessage()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v14, v0, v13, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-object v2
    :try_start_0x5
    :try_start_0x37
    :try_start_0x41
    :try_start_0xbb
    :try_start_0xbd
.end method

.method private final cropToSquare(java.io.File)java.io.File
    .registers 11
    # ins_size=2
    const-string v0, "SettingsViewModel"
    const-string v1, "avatar_cropped_"
    const/4 v2, 0
    new-instance v3, Landroid/graphics/BitmapFactory$Options;
    invoke-direct v3, Landroid/graphics/BitmapFactory$Options;-><init>()V
    const/4 v4, 1
    iput-boolean v4, v3, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds Z
    invoke-virtual v10, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String; Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    iget v5, v3, Landroid/graphics/BitmapFactory$Options;->outWidth I
    iget v3, v3, Landroid/graphics/BitmapFactory$Options;->outHeight I
    if-lez v5, +099h
    if-gtz v3, +004h
    goto/16 +095h
    if-ne v5, v3, +003h
    return-object v10
    invoke-static v5, v3, Ljava/lang/Math;->min(I I)I
    move-result v3
    const/16 v5, 1024
    invoke-static v3, v5, Ljava/lang/Math;->min(I I)I
    move-result v5
    div-int/2addr v3, v5
    new-instance v5, Landroid/graphics/BitmapFactory$Options;
    invoke-direct v5, Landroid/graphics/BitmapFactory$Options;-><init>()V
    const/4 v6, 2
    if-lt v3, v6, +006h
    invoke-static v3, Ljava/lang/Integer;->highestOneBit(I)I
    move-result v4
    iput v4, v5, Landroid/graphics/BitmapFactory$Options;->inSampleSize I
    invoke-virtual v10, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v5, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String; Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    move-result-object v3
    if-nez v3, +003h
    return-object v2
    invoke-virtual v3, Landroid/graphics/Bitmap;->getWidth()I
    move-result v4
    invoke-virtual v3, Landroid/graphics/Bitmap;->getHeight()I
    move-result v5
    invoke-static v4, v5, Ljava/lang/Math;->min(I I)I
    move-result v7
    sub-int/2addr v4, v7
    div-int/2addr v4, v6
    sub-int/2addr v5, v7
    div-int/2addr v5, v6
    invoke-static v3, v4, v5, v7, v7, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap; I I I I)Landroid/graphics/Bitmap;
    move-result-object v4
    const-string v5, "createBitmap(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +005h
    invoke-virtual v3, Landroid/graphics/Bitmap;->recycle()V
    new-instance v3, Ljava/io/File;
    invoke-virtual v10, Ljava/io/File;->getParent()Ljava/lang/String;
    move-result-object v5
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v7
    invoke-virtual v6, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v6, ".jpg"
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v3, v5, v1, Ljava/io/File;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Ljava/io/FileOutputStream;
    invoke-direct v1, v3, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    check-cast v1, Ljava/io/Closeable;
    move-object v5, v1
    check-cast v5, Ljava/io/FileOutputStream;
    sget-object v6, Landroid/graphics/Bitmap$CompressFormat;->JPEG Landroid/graphics/Bitmap$CompressFormat;
    check-cast v5, Ljava/io/OutputStream;
    const/16 v7, 90
    invoke-virtual v4, v6, v7, v5, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat; I Ljava/io/OutputStream;)Z
    invoke-static v1, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    invoke-virtual v4, Landroid/graphics/Bitmap;->recycle()V
    invoke-static v3, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +005h
    invoke-virtual v10, Ljava/io/File;->delete()Z
    return-object v3
    move-exception v10
    throw v10
    move-exception v3
    invoke-static v1, v10, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v3
    return-object v2
    move-exception v10
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "cropToSquare exception: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v1, v0, v10, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-object v2
    move-exception v10
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "cropToSquare OOM: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Ljava/lang/OutOfMemoryError;->getMessage()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v1, v0, v10, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-object v2
    :try_start_0x5
    :try_start_0x8e
    :try_start_0x9a
    :try_start_0xab
    :try_start_0xad
.end method

.method private final doRefreshUserInfo(com.bytedance.trae.login.api.ILoginService)void
    .registers 5
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$$ExternalSyntheticLambda0;
    invoke-direct v0, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)V
    const/4 v1, 0
    const/4 v2, 2
    invoke-static v4, v0, v1, v2, v1, Lcom/bytedance/trae/login/api/ILoginService$DefaultImpls;->refreshUserInfo$default(Lcom/bytedance/trae/login/api/ILoginService; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)V
    return-void 
.end method

.method private static final doRefreshUserInfo$lambda$11(com.bytedance.trae.home.solo.setting.SettingsViewModel  com.bytedance.trae.login.api.AccountInfo)kotlin.Unit
    .registers 12
    # ins_size=2
    const-string v0, "fresh"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v10, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userProfile Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    if-nez v1, +005h
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    iget-object v10, v10, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userProfile Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v11, Lcom/bytedance/trae/login/api/AccountInfo;->getEmail()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v2
    const/4 v3, 1
    const/4 v4, 0
    if-nez v2, +004h
    move v2, v3
    goto +2h
    move v2, v4
    if-eqz v2, +006h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getEmail()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    invoke-virtual v11, Lcom/bytedance/trae/login/api/AccountInfo;->getPhoneNumber()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +004h
    move v5, v3
    goto +2h
    move v5, v4
    if-eqz v5, +006h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getPhoneNumber()Ljava/lang/String;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Ljava/lang/String;
    invoke-virtual v11, Lcom/bytedance/trae/login/api/AccountInfo;->getScreenName()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +004h
    move v6, v3
    goto +2h
    move v6, v4
    if-eqz v6, +006h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getScreenName()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-virtual v11, Lcom/bytedance/trae/login/api/AccountInfo;->getAvatarUrl()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +004h
    move v7, v3
    goto +2h
    move v7, v4
    if-eqz v7, +006h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getAvatarUrl()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    invoke-virtual v11, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +004h
    move v8, v3
    goto +2h
    move v8, v4
    if-eqz v8, +006h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getUserId()Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    invoke-virtual v11, Lcom/bytedance/trae/login/api/AccountInfo;->getProductType()I
    move-result v8
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    move-object v9, v8
    check-cast v9, Ljava/lang/Number;
    invoke-virtual v9, Ljava/lang/Number;->intValue()I
    move-result v9
    if-eqz v9, +003h
    goto +2h
    move v3, v4
    if-eqz v3, +003h
    goto +2h
    const/4 v8, 0
    if-eqz v8, +007h
    invoke-virtual v8, Ljava/lang/Integer;->intValue()I
    move-result v3
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getProductType()I
    move-result v3
    move v8, v3
    invoke-virtual v11, Lcom/bytedance/trae/login/api/AccountInfo;->getSaasPrivacyMode()Ljava/lang/Boolean;
    move-result-object v11
    move-object v3, v6
    move-object v4, v0
    move-object v6, v7
    move v7, v8
    move-object v8, v11
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Boolean;)Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    move-result-object v11
    invoke-virtual v10, v11, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
.end method

.method private static final updateNickname$lambda$12(com.bytedance.trae.home.solo.setting.SettingsViewModel  java.lang.String)kotlin.Unit
    .registers 13
    # ins_size=2
    iget-object v0, v11, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    iget-object v0, v11, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userProfile Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    if-eqz v1, +015h
    iget-object v0, v11, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userProfile Landroidx/lifecycle/MutableLiveData;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 126
    const/4 v10, 0
    move-object v2, v12
    invoke-static/range v1 ... v10, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->copy$default(Lcom/bytedance/trae/home/solo/setting/UserProfileState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Boolean; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    move-result-object v12
    invoke-virtual v0, v12, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    iget-object v11, v11, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_updateNameResult Landroidx/lifecycle/MutableLiveData;
    new-instance v12, Lcom/bytedance/trae/home/solo/setting/Event;
    const/4 v0, 1
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-direct v12, v0, Lcom/bytedance/trae/home/solo/setting/Event;-><init>(Ljava/lang/Object;)V
    invoke-virtual v11, v12, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method

.method private static final updateNickname$lambda$13(com.bytedance.trae.home.solo.setting.SettingsViewModel  int)kotlin.Unit
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, updateNickname failed, errorCode=
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v1, "SettingsViewModel"
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    const/4 v0, 0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-virtual v4, v0, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    iget-object v3, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_updateNameResult Landroidx/lifecycle/MutableLiveData;
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/Event;
    invoke-direct v4, v0, Lcom/bytedance/trae/home/solo/setting/Event;-><init>(Ljava/lang/Object;)V
    invoke-virtual v3, v4, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method public final fetchCreditsBalance()void
    .registers 10
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-nez v0, +00fh
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->creditsBalanceFetchJob Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_creditsBalanceSnapshot Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_creditsBalanceSnapshot Landroidx/lifecycle/MutableLiveData;
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->getCreditsBalanceSnapshot()Lcom/bytedance/trae/home/solo/setting/CreditsBalanceSnapshot;
    move-result-object v3
    invoke-virtual v0, v3, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->creditsBalanceFetchJob Lkotlinx/coroutines/Job;
    const/4 v3, 0
    if-eqz v0, +009h
    invoke-interface v0, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v0
    if-ne v0, v1, +003h
    goto +2h
    move v1, v3
    if-eqz v1, +003h
    return-void 
    move-object v0, v9
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;
    invoke-direct v0, v9, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchCreditsBalance$1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v9, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->creditsBalanceFetchJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final fetchUserPayStatus()void
    .registers 9
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +008h
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userPayStatus Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    goto +6h
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userCNPayStatus Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    move-object v0, v8
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;
    invoke-direct v0, v8, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final getCreditsBalanceSnapshot()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->creditsBalanceSnapshot Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getUpdateNameResult()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->updateNameResult Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getUploadAvatarResult()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->uploadAvatarResult Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getUserCNPayStatus()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->userCNPayStatus Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getUserPayStatus()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->userPayStatus Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getUserProfile()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->userProfile Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final isLoading()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->isLoading Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final loadUserInfo()void
    .registers 15
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-nez v0, +003h
    return-void 
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v1
    iget-object v2, v14, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userProfile Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v2, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    if-eqz v3, +09eh
    iget-object v2, v14, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userProfile Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getEmail()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v5
    const/4 v6, 1
    const/4 v7, 0
    if-nez v5, +004h
    move v5, v6
    goto +2h
    move v5, v7
    if-eqz v5, +006h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getEmail()Ljava/lang/String;
    move-result-object v4
    move-object v8, v4
    check-cast v8, Ljava/lang/String;
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getPhoneNumber()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +004h
    move v5, v6
    goto +2h
    move v5, v7
    if-eqz v5, +006h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getPhoneNumber()Ljava/lang/String;
    move-result-object v4
    move-object v9, v4
    check-cast v9, Ljava/lang/String;
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getScreenName()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +004h
    move v5, v6
    goto +2h
    move v5, v7
    if-eqz v5, +006h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getScreenName()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getAvatarUrl()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v10
    if-nez v10, +004h
    move v10, v6
    goto +2h
    move v10, v7
    if-eqz v10, +006h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getAvatarUrl()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getProductType()I
    move-result v10
    invoke-static v10, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    move-object v11, v10
    check-cast v11, Ljava/lang/Number;
    invoke-virtual v11, Ljava/lang/Number;->intValue()I
    move-result v11
    if-eqz v11, +003h
    goto +2h
    move v6, v7
    if-eqz v6, +003h
    goto +2h
    const/4 v10, 0
    if-eqz v10, +007h
    invoke-virtual v10, Ljava/lang/Integer;->intValue()I
    move-result v6
    goto +5h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getProductType()I
    move-result v6
    move v10, v6
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getSaasPrivacyMode()Ljava/lang/Boolean;
    move-result-object v1
    const/4 v11, 0
    const/16 v12, 16
    const/4 v13, 0
    move-object v6, v8
    move-object v7, v9
    move-object v8, v11
    move v9, v10
    move-object v10, v1
    move v11, v12
    move-object v12, v13
    invoke-static/range v3 ... v12, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->copy$default(Lcom/bytedance/trae/home/solo/setting/UserProfileState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Boolean; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    move-result-object v1
    invoke-virtual v2, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    goto +28h
    iget-object v2, v14, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userProfile Landroidx/lifecycle/MutableLiveData;
    new-instance v11, Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getScreenName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getAvatarUrl()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getEmail()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getPhoneNumber()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getProductType()I
    move-result v9
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getSaasPrivacyMode()Ljava/lang/Boolean;
    move-result-object v10
    move-object v3, v11
    invoke-direct/range v3 ... v10, Lcom/bytedance/trae/home/solo/setting/UserProfileState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Boolean;)V
    invoke-virtual v2, v11, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    invoke-direct v14, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->doRefreshUserInfo(Lcom/bytedance/trae/login/api/ILoginService;)V
    return-void 
.end method

.method public final updateNickname(java.lang.String)void
    .registers 5
    # ins_size=2
    const-string v0, "newName"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-nez v0, +01bh
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    const/4 v0, 0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v4, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_updateNameResult Landroidx/lifecycle/MutableLiveData;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/Event;
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/setting/Event;-><init>(Ljava/lang/Object;)V
    invoke-virtual v4, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
    const-string v1, "name"
    invoke-static v1, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$$ExternalSyntheticLambda1;
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Ljava/lang/String;)V
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$$ExternalSyntheticLambda2;
    invoke-direct v4, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)V
    invoke-interface v0, v1, v2, v4, Lcom/bytedance/trae/login/api/ILoginService;->updateUserProfile(Ljava/util/Map; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public final updatePhoneNumber(java.lang.String)void
    .registers 12
    # ins_size=2
    const-string v0, "phone"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, Ljava/lang/String;->length()I
    move-result v0
    add-int/lit8 v0, v0, -2
    const-string v1, "*"
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v11, Ljava/lang/String;->length()I
    move-result v2
    add-int/lit8 v2, v2, -5
    invoke-static v1, v2, Lkotlin/text/StringsKt;->repeat(Ljava/lang/CharSequence; I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    check-cast v11, Ljava/lang/CharSequence;
    const/4 v2, 3
    invoke-static v11, v2, v0, v1, Lkotlin/text/StringsKt;->replaceRange(Ljava/lang/CharSequence; I I Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v4
    iget-object v11, v10, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userProfile Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v11, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v11
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    if-eqz v0, +014h
    iget-object v11, v10, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_userProfile Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 119
    const/4 v9, 0
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->copy$default(Lcom/bytedance/trae/home/solo/setting/UserProfileState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Boolean; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    move-result-object v0
    invoke-virtual v11, v0, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final uploadAvatar(android.net.Uri)void
    .registers 13
    # ins_size=2
    const-string/jumbo v0, uri
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v11, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v0, 0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    if-nez v3, +012h
    iget-object v12, v11, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v12, v0, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v12, v11, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_uploadAvatarResult Landroidx/lifecycle/MutableLiveData;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/Event;
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/setting/Event;-><init>(Ljava/lang/Object;)V
    invoke-virtual v12, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
    invoke-interface v3, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getAccountType()Lcom/bytedance/trae/login/api/AccountType;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/login/api/AccountType;->TOB Lcom/bytedance/trae/login/api/AccountType;
    if-ne v1, v2, +012h
    iget-object v12, v11, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v12, v0, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v12, v11, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->_uploadAvatarResult Landroidx/lifecycle/MutableLiveData;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/Event;
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/setting/Event;-><init>(Ljava/lang/Object;)V
    invoke-virtual v12, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->getApplication()Landroid/app/Application;
    move-result-object v4
    move-object v0, v11
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    const/4 v7, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;
    const/4 v6, 0
    move-object v1, v9
    move-object v2, v11
    move-object v5, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Lcom/bytedance/trae/login/api/ILoginService; Landroid/app/Application; Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    move-object v12, v9
    check-cast v12, Lkotlin/jvm/functions/Function2;
    const/4 v9, 3
    const/4 v10, 0
    move-object v5, v0
    move-object v6, v7
    move-object v7, v8
    move-object v8, v12
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method
