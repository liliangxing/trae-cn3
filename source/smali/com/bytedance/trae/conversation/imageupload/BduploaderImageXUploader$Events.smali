# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;
.super Ljava/lang/Object;
.source "BduploaderImageXUploader.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;
.field private static final MSG_ALL_COMPLETE:I
.field private static final MSG_SINGLE_COMPLETE:I
.field private static final MSG_SINGLE_FAIL:I
.field private static final MSG_UPDATE_PROGRESS:I


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;
    invoke-direct v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;
    const-string v1, "MsgIsSingleImageComplete"
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->getIntFieldOrMinusOne(Ljava/lang/String;)I
    move-result v1
    sput v1, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->MSG_SINGLE_COMPLETE I
    const-string v1, "MsgIsSingleImageFail"
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->getIntFieldOrMinusOne(Ljava/lang/String;)I
    move-result v1
    sput v1, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->MSG_SINGLE_FAIL I
    const-string v1, "MsgIsUpdateProgress"
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->getIntFieldOrMinusOne(Ljava/lang/String;)I
    move-result v1
    sput v1, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->MSG_UPDATE_PROGRESS I
    const-string v1, "MsgIsComplete"
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->getIntFieldOrMinusOne(Ljava/lang/String;)I
    move-result v0
    sput v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->MSG_ALL_COMPLETE I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getIntFieldOrMinusOne(java.lang.String)int
    .registers 4
    # ins_size=2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;
    const-class v0, Lcom/ss/bduploader/BDImageXUploader;
    invoke-virtual v0, v3, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;
    move-result-object v3
    const/4 v0, 0
    invoke-virtual v3, v0, Ljava/lang/reflect/Field;->getInt(Ljava/lang/Object;)I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    const/4 v0, -1
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v3, v0
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->intValue()I
    move-result v3
    return v3
    :try_start_0x0
.end method

.method public final getMSG_ALL_COMPLETE()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->MSG_ALL_COMPLETE I
    return v0
.end method

.method public final getMSG_SINGLE_COMPLETE()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->MSG_SINGLE_COMPLETE I
    return v0
.end method

.method public final getMSG_SINGLE_FAIL()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->MSG_SINGLE_FAIL I
    return v0
.end method

.method public final getMSG_UPDATE_PROGRESS()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->MSG_UPDATE_PROGRESS I
    return v0
.end method
