# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
.super Ljava/lang/Object;
.source "FileUploadService.kt"

.field private final enableMagic:Z
.field private final onFinish:Lkotlin/jvm/functions/Function1;
.field private final onProgress:Lkotlin/jvm/functions/Function3;
.field private final useV2:Z


.method public constructor <init>()void
    .registers 8
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 15
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;-><init>(Z Z Lkotlin/jvm/functions/Function3; Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(boolean  boolean  kotlin.jvm.functions.Function3  kotlin.jvm.functions.Function1)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->enableMagic Z
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->useV2 Z
    iput-object v3, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->onProgress Lkotlin/jvm/functions/Function3;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->onFinish Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public synthetic constructor <init>(boolean  boolean  kotlin.jvm.functions.Function3  kotlin.jvm.functions.Function1  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 1
    const/4 v0, 0
    if-eqz v7, +003h
    move v2, v0
    and-int/lit8 v7, v6, 2
    if-eqz v7, +003h
    move v3, v0
    and-int/lit8 v7, v6, 4
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;-><init>(Z Z Lkotlin/jvm/functions/Function3; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.fileupload.FileUploadService$UploadOptions  boolean  boolean  kotlin.jvm.functions.Function3  kotlin.jvm.functions.Function1  int  java.lang.Object)com.bytedance.trae.conversation.fileupload.FileUploadService$UploadOptions
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->enableMagic Z
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->useV2 Z
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->onProgress Lkotlin/jvm/functions/Function3;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->onFinish Lkotlin/jvm/functions/Function1;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->copy(Z Z Lkotlin/jvm/functions/Function3; Lkotlin/jvm/functions/Function1;)Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
    move-result-object v0
    return-object v0
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->enableMagic Z
    return v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->useV2 Z
    return v0
.end method

.method public final component3()kotlin.jvm.functions.Function3
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->onProgress Lkotlin/jvm/functions/Function3;
    return-object v0
.end method

.method public final component4()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->onFinish Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final copy(boolean  boolean  kotlin.jvm.functions.Function3  kotlin.jvm.functions.Function1)com.bytedance.trae.conversation.fileupload.FileUploadService$UploadOptions
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;-><init>(Z Z Lkotlin/jvm/functions/Function3; Lkotlin/jvm/functions/Function1;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->enableMagic Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->enableMagic Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->useV2 Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->useV2 Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->onProgress Lkotlin/jvm/functions/Function3;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->onProgress Lkotlin/jvm/functions/Function3;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->onFinish Lkotlin/jvm/functions/Function1;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->onFinish Lkotlin/jvm/functions/Function1;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getEnableMagic()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->enableMagic Z
    return v0
.end method

.method public final getOnFinish()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->onFinish Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnProgress()kotlin.jvm.functions.Function3
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->onProgress Lkotlin/jvm/functions/Function3;
    return-object v0
.end method

.method public final getUseV2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->useV2 Z
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->enableMagic Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->useV2 Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->onProgress Lkotlin/jvm/functions/Function3;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->onFinish Lkotlin/jvm/functions/Function1;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "UploadOptions(enableMagic="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->enableMagic Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", useV2="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->useV2 Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", onProgress="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->onProgress Lkotlin/jvm/functions/Function3;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", onFinish="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->onFinish Lkotlin/jvm/functions/Function1;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
