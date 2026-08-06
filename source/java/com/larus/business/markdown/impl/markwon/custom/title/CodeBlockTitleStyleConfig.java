package com.larus.business.markdown.impl.markwon.custom.title;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkwonCustomTitleManager.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0088\u0001\u0010+\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\u00032\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0003\u0010\u000e\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011¨\u00063"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/custom/title/CodeBlockTitleStyleConfig;", "", "titleVerticalPadding", "", "copyButton", "fullScreenButton", "previewButtonPaddingEnd", "previewButtonPaddingStart", "copyButtonPaddingEnd", "copyButtonPaddingStart", "fullScreenButtonPaddingEnd", "fullScreenButtonPaddingStart", "downloadButtonPaddingEnd", "downloadButtonPaddingStart", "titlePaddingEnd", "(IILjava/lang/Integer;IIIIIIIII)V", "getCopyButton", "()I", "getCopyButtonPaddingEnd", "getCopyButtonPaddingStart", "getDownloadButtonPaddingEnd", "getDownloadButtonPaddingStart", "getFullScreenButton", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFullScreenButtonPaddingEnd", "getFullScreenButtonPaddingStart", "getPreviewButtonPaddingEnd", "getPreviewButtonPaddingStart", "getTitlePaddingEnd", "getTitleVerticalPadding", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IILjava/lang/Integer;IIIIIIIII)Lcom/larus/business/markdown/impl/markwon/custom/title/CodeBlockTitleStyleConfig;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class CodeBlockTitleStyleConfig {
    private final int copyButton;
    private final int copyButtonPaddingEnd;
    private final int copyButtonPaddingStart;
    private final int downloadButtonPaddingEnd;
    private final int downloadButtonPaddingStart;
    private final Integer fullScreenButton;
    private final int fullScreenButtonPaddingEnd;
    private final int fullScreenButtonPaddingStart;
    private final int previewButtonPaddingEnd;
    private final int previewButtonPaddingStart;
    private final int titlePaddingEnd;
    private final int titleVerticalPadding;

    /* renamed from: component1, reason: from getter */
    public final int getTitleVerticalPadding() {
        return this.titleVerticalPadding;
    }

    /* renamed from: component10, reason: from getter */
    public final int getDownloadButtonPaddingEnd() {
        return this.downloadButtonPaddingEnd;
    }

    /* renamed from: component11, reason: from getter */
    public final int getDownloadButtonPaddingStart() {
        return this.downloadButtonPaddingStart;
    }

    /* renamed from: component12, reason: from getter */
    public final int getTitlePaddingEnd() {
        return this.titlePaddingEnd;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCopyButton() {
        return this.copyButton;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getFullScreenButton() {
        return this.fullScreenButton;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPreviewButtonPaddingEnd() {
        return this.previewButtonPaddingEnd;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPreviewButtonPaddingStart() {
        return this.previewButtonPaddingStart;
    }

    /* renamed from: component6, reason: from getter */
    public final int getCopyButtonPaddingEnd() {
        return this.copyButtonPaddingEnd;
    }

    /* renamed from: component7, reason: from getter */
    public final int getCopyButtonPaddingStart() {
        return this.copyButtonPaddingStart;
    }

    /* renamed from: component8, reason: from getter */
    public final int getFullScreenButtonPaddingEnd() {
        return this.fullScreenButtonPaddingEnd;
    }

    /* renamed from: component9, reason: from getter */
    public final int getFullScreenButtonPaddingStart() {
        return this.fullScreenButtonPaddingStart;
    }

    public final CodeBlockTitleStyleConfig copy(int titleVerticalPadding, int copyButton, Integer fullScreenButton, int previewButtonPaddingEnd, int previewButtonPaddingStart, int copyButtonPaddingEnd, int copyButtonPaddingStart, int fullScreenButtonPaddingEnd, int fullScreenButtonPaddingStart, int downloadButtonPaddingEnd, int downloadButtonPaddingStart, int titlePaddingEnd) {
        return new CodeBlockTitleStyleConfig(titleVerticalPadding, copyButton, fullScreenButton, previewButtonPaddingEnd, previewButtonPaddingStart, copyButtonPaddingEnd, copyButtonPaddingStart, fullScreenButtonPaddingEnd, fullScreenButtonPaddingStart, downloadButtonPaddingEnd, downloadButtonPaddingStart, titlePaddingEnd);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CodeBlockTitleStyleConfig)) {
            return false;
        }
        CodeBlockTitleStyleConfig codeBlockTitleStyleConfig = (CodeBlockTitleStyleConfig) other;
        return this.titleVerticalPadding == codeBlockTitleStyleConfig.titleVerticalPadding && this.copyButton == codeBlockTitleStyleConfig.copyButton && Intrinsics.areEqual(this.fullScreenButton, codeBlockTitleStyleConfig.fullScreenButton) && this.previewButtonPaddingEnd == codeBlockTitleStyleConfig.previewButtonPaddingEnd && this.previewButtonPaddingStart == codeBlockTitleStyleConfig.previewButtonPaddingStart && this.copyButtonPaddingEnd == codeBlockTitleStyleConfig.copyButtonPaddingEnd && this.copyButtonPaddingStart == codeBlockTitleStyleConfig.copyButtonPaddingStart && this.fullScreenButtonPaddingEnd == codeBlockTitleStyleConfig.fullScreenButtonPaddingEnd && this.fullScreenButtonPaddingStart == codeBlockTitleStyleConfig.fullScreenButtonPaddingStart && this.downloadButtonPaddingEnd == codeBlockTitleStyleConfig.downloadButtonPaddingEnd && this.downloadButtonPaddingStart == codeBlockTitleStyleConfig.downloadButtonPaddingStart && this.titlePaddingEnd == codeBlockTitleStyleConfig.titlePaddingEnd;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.titleVerticalPadding) * 31) + Integer.hashCode(this.copyButton)) * 31;
        Integer num = this.fullScreenButton;
        return ((((((((((((((((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.previewButtonPaddingEnd)) * 31) + Integer.hashCode(this.previewButtonPaddingStart)) * 31) + Integer.hashCode(this.copyButtonPaddingEnd)) * 31) + Integer.hashCode(this.copyButtonPaddingStart)) * 31) + Integer.hashCode(this.fullScreenButtonPaddingEnd)) * 31) + Integer.hashCode(this.fullScreenButtonPaddingStart)) * 31) + Integer.hashCode(this.downloadButtonPaddingEnd)) * 31) + Integer.hashCode(this.downloadButtonPaddingStart)) * 31) + Integer.hashCode(this.titlePaddingEnd);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CodeBlockTitleStyleConfig(titleVerticalPadding=");
        sb.append(this.titleVerticalPadding).append(", copyButton=").append(this.copyButton).append(", fullScreenButton=").append(this.fullScreenButton).append(", previewButtonPaddingEnd=").append(this.previewButtonPaddingEnd).append(", previewButtonPaddingStart=").append(this.previewButtonPaddingStart).append(", copyButtonPaddingEnd=").append(this.copyButtonPaddingEnd).append(", copyButtonPaddingStart=").append(this.copyButtonPaddingStart).append(", fullScreenButtonPaddingEnd=").append(this.fullScreenButtonPaddingEnd).append(", fullScreenButtonPaddingStart=").append(this.fullScreenButtonPaddingStart).append(", downloadButtonPaddingEnd=").append(this.downloadButtonPaddingEnd).append(", downloadButtonPaddingStart=").append(this.downloadButtonPaddingStart).append(", titlePaddingEnd=");
        sb.append(this.titlePaddingEnd).append(')');
        return sb.toString();
    }

    public CodeBlockTitleStyleConfig(int i, int i2, Integer num, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.titleVerticalPadding = i;
        this.copyButton = i2;
        this.fullScreenButton = num;
        this.previewButtonPaddingEnd = i3;
        this.previewButtonPaddingStart = i4;
        this.copyButtonPaddingEnd = i5;
        this.copyButtonPaddingStart = i6;
        this.fullScreenButtonPaddingEnd = i7;
        this.fullScreenButtonPaddingStart = i8;
        this.downloadButtonPaddingEnd = i9;
        this.downloadButtonPaddingStart = i10;
        this.titlePaddingEnd = i11;
    }

    public final int getTitleVerticalPadding() {
        return this.titleVerticalPadding;
    }

    public final int getCopyButton() {
        return this.copyButton;
    }

    public final Integer getFullScreenButton() {
        return this.fullScreenButton;
    }

    public final int getPreviewButtonPaddingEnd() {
        return this.previewButtonPaddingEnd;
    }

    public final int getPreviewButtonPaddingStart() {
        return this.previewButtonPaddingStart;
    }

    public final int getCopyButtonPaddingEnd() {
        return this.copyButtonPaddingEnd;
    }

    public final int getCopyButtonPaddingStart() {
        return this.copyButtonPaddingStart;
    }

    public final int getFullScreenButtonPaddingEnd() {
        return this.fullScreenButtonPaddingEnd;
    }

    public final int getFullScreenButtonPaddingStart() {
        return this.fullScreenButtonPaddingStart;
    }

    public final int getDownloadButtonPaddingEnd() {
        return this.downloadButtonPaddingEnd;
    }

    public final int getDownloadButtonPaddingStart() {
        return this.downloadButtonPaddingStart;
    }

    public final int getTitlePaddingEnd() {
        return this.titlePaddingEnd;
    }
}
