# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;
.super Ljava/lang/Object;
.source "IArtifactsRendererSettings.kt"

.field private filePreview:Z
.field private htmlPreview:Z
.field private final imagePreview:Z


.method public constructor <init>(boolean  boolean  boolean)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;->imagePreview Z
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;->htmlPreview Z
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;->filePreview Z
    return-void 
.end method

.method public final getFilePreview()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;->filePreview Z
    return v0
.end method

.method public final getHtmlPreview()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;->htmlPreview Z
    return v0
.end method

.method public final getImagePreview()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;->imagePreview Z
    return v0
.end method

.method public final setFilePreview(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;->filePreview Z
    return-void 
.end method

.method public final setHtmlPreview(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;->htmlPreview Z
    return-void 
.end method
