package com.bytedance.trae.conversation.chat.block.renderer.settings;

import kotlin.Metadata;

/* compiled from: IArtifactsRendererSettings.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;", "", "imagePreview", "", "htmlPreview", "filePreview", "<init>", "(ZZZ)V", "getImagePreview", "()Z", "getHtmlPreview", "setHtmlPreview", "(Z)V", "getFilePreview", "setFilePreview", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ArtifactsRendererSettings {
    private boolean filePreview;
    private boolean htmlPreview;
    private final boolean imagePreview;

    public ArtifactsRendererSettings(boolean z, boolean z2, boolean z3) {
        this.imagePreview = z;
        this.htmlPreview = z2;
        this.filePreview = z3;
    }

    public final boolean getImagePreview() {
        return this.imagePreview;
    }

    public final boolean getHtmlPreview() {
        return this.htmlPreview;
    }

    public final void setHtmlPreview(boolean z) {
        this.htmlPreview = z;
    }

    public final boolean getFilePreview() {
        return this.filePreview;
    }

    public final void setFilePreview(boolean z) {
        this.filePreview = z;
    }
}
