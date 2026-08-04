# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/ss/android/update/IAutoInstallApk;

.field public final synthetic f$0:Lcom/bytedance/trae/update/IBitsUpdateImpl;
.field public final synthetic f$1:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.update.IBitsUpdateImpl  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/update/IBitsUpdateImpl;
    iput-object v2, v0, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda3;->f$1 Ljava/lang/String;
    return-void 
.end method

.method public final installApk(android.content.Context  java.io.File)void
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/update/IBitsUpdateImpl;
    iget-object v1, v2, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda3;->f$1 Ljava/lang/String;
    invoke-static v0, v1, v3, v4, Lcom/bytedance/trae/update/IBitsUpdateImpl;->$r8$lambda$bVBVOWUw0FoUMjpuBQP3dVZTDN4(Lcom/bytedance/trae/update/IBitsUpdateImpl; Ljava/lang/String; Landroid/content/Context; Ljava/io/File;)V
    return-void 
.end method
