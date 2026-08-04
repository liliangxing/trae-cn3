# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public abstract Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;
.super Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;
.source "TraeCmpContentFragment.kt"

.field public static final $stable:I
.field private final titleBarMode:Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;-><init>()V
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->SHEET Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    iput-object v0, v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;->titleBarMode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    return-void 
.end method

.method protected final getTitleBarMode()com.bytedance.trae.common.widget.TraeTitleBar$Mode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;->titleBarMode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    return-object v0
.end method
