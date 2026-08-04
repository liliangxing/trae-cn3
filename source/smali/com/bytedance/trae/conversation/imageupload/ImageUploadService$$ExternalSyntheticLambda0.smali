# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.imageupload.ImageUploadSdkConfig)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    invoke-static v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->$r8$lambda$LepMg7EEpEm5at9Bpg7m6NEgS7Y(Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
