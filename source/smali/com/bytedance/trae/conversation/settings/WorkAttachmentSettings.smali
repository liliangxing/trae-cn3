# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;
.super Ljava/lang/Object;
.source "IQuerySettings.kt"

.field private codeSingleImageSize:J
.field private codeTotalImageCount:J
.field private final totalCount:J
.field private totalSize:J
.field private workSingleAttachmentSize:J
.field private workSingleImageSize:J


.method public constructor <init>(long  long  long  long  long  long)void
    .registers 13
    # ins_size=13
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->totalCount J
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->totalSize J
    iput-wide v5, v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->workSingleImageSize J
    iput-wide v7, v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->workSingleAttachmentSize J
    iput-wide v9, v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->codeSingleImageSize J
    iput-wide v11, v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->codeTotalImageCount J
    return-void 
.end method

.method public final getCodeSingleImageSize()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->codeSingleImageSize J
    return-wide v0
.end method

.method public final getCodeTotalImageCount()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->codeTotalImageCount J
    return-wide v0
.end method

.method public final getTotalCount()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->totalCount J
    return-wide v0
.end method

.method public final getTotalSize()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->totalSize J
    return-wide v0
.end method

.method public final getWorkSingleAttachmentSize()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->workSingleAttachmentSize J
    return-wide v0
.end method

.method public final getWorkSingleImageSize()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->workSingleImageSize J
    return-wide v0
.end method

.method public final setCodeSingleImageSize(long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->codeSingleImageSize J
    return-void 
.end method

.method public final setCodeTotalImageCount(long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->codeTotalImageCount J
    return-void 
.end method

.method public final setTotalSize(long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->totalSize J
    return-void 
.end method

.method public final setWorkSingleAttachmentSize(long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->workSingleAttachmentSize J
    return-void 
.end method

.method public final setWorkSingleImageSize(long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;->workSingleImageSize J
    return-void 
.end method
