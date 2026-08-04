# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;
.field public final synthetic f$1:Landroid/net/Uri;
.field public final synthetic f$2:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity  android.net.Uri  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;
    iput-object v2, v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$$ExternalSyntheticLambda2;->f$1 Landroid/net/Uri;
    iput-object v3, v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$$ExternalSyntheticLambda2;->f$2 Ljava/lang/String;
    return-void 
.end method

.method public final run()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;
    iget-object v1, v3, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$$ExternalSyntheticLambda2;->f$1 Landroid/net/Uri;
    iget-object v2, v3, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$$ExternalSyntheticLambda2;->f$2 Ljava/lang/String;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->$r8$lambda$xg8diSKfSIKWRtpDm0pdZkppnPs(Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity; Landroid/net/Uri; Ljava/lang/String;)V
    return-void 
.end method
