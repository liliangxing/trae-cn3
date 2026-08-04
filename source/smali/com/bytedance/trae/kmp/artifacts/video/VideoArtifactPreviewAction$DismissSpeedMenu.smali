# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DismissSpeedMenu;
.super Ljava/lang/Object;
.source "VideoArtifactPreviewViewModel.kt"

.implements Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction;

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DismissSpeedMenu;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DismissSpeedMenu;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DismissSpeedMenu;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DismissSpeedMenu;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DismissSpeedMenu;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public equals(java.lang.Object)boolean
    .registers 4
    # ins_size=2
    const/4 v0, 1
    if-ne v2, v3, +003h
    return v0
    instance-of v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DismissSpeedMenu;
    if-nez v1, +004h
    const/4 v3, 0
    return v3
    check-cast v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DismissSpeedMenu;
    return v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    const v0, -16056387
    return v0
.end method

.method public toString()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "DismissSpeedMenu"
    return-object v0
.end method
