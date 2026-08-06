package com.larus.business.markdown.api.model;

import com.bytedance.forest.model.PreloadConfig;
import com.ss.ttm.utils.AVLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeBlockConfig.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bV\b\u0087\b\u0018\u00002\u00020\u0001B\u00ad\u0002\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0006¢\u0006\u0002\u0010!J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010F\u001a\u00020\u0006HÆ\u0003J\t\u0010G\u001a\u00020\u0010HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010M\u001a\u00020\u0006HÆ\u0003J\t\u0010N\u001a\u00020\u0006HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010Q\u001a\u00020\u0006HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010U\u001a\u00020\u0006HÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00102J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\t\u0010X\u001a\u00020\u0006HÆ\u0003J\t\u0010Y\u001a\u00020\u0006HÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010]\u001a\u00020\u0006HÆ\u0003J\t\u0010^\u001a\u00020\fHÆ\u0003J\t\u0010_\u001a\u00020\u0006HÆ\u0003J¶\u0002\u0010`\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00062\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010aJ\u0013\u0010b\u001a\u00020\u00062\b\u0010c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010d\u001a\u00020\u0003HÖ\u0001J\t\u0010e\u001a\u00020\fHÖ\u0001R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b&\u0010#R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b'\u0010#R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b(\u0010#R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b)\u0010#R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b*\u0010#R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b-\u0010#R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b0\u0010#R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010 \u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u00105R\u0011\u0010\u001f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b8\u00105R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b9\u00105R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b:\u00105R\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b;\u00105R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b<\u00105R\u0011\u0010\u0016\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b=\u00105R\u0011\u0010\u001d\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b>\u00105R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b?\u00105R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b@\u0010#R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\bA\u0010#R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\bB\u0010#R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bC\u0010D¨\u0006f"}, d2 = {"Lcom/larus/business/markdown/api/model/CodeBlockConfig;", "", "cornerRadius", "", "titleBgColor", "enableTitleBottomLine", "", "titleBottomLineColor", "codeTitleSize", "codeContentSize", "enableCodeFullScreenButton", "codeCopyTitle", "", "enablePreviewButton", "enableCodeCopyButton", "titleStyle", "Lcom/larus/business/markdown/api/model/TitleStyle;", "enableCodeHeader", "backgroundColor", "blockBackgroundColor", "codeTextColor", "blockMargin", "enableScroll", "enableLineNumber", "lineNumberColor", "enableBlockBackground", "codeBlockTextColor", "blockBorderColor", "blockBorderWidth", "enableSyntaxHighlight", "disableReplacementSpan", "enableCodeBlockStroke", "enableCodeBlockHeaderBackground", "(Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILjava/lang/Integer;ZLjava/lang/String;ZZLcom/larus/business/markdown/api/model/TitleStyle;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZZLjava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Boolean;ZZ)V", "getBackgroundColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBlockBackgroundColor", "getBlockBorderColor", "getBlockBorderWidth", "getBlockMargin", "getCodeBlockTextColor", "getCodeContentSize", "getCodeCopyTitle", "()Ljava/lang/String;", "getCodeTextColor", "getCodeTitleSize", "()I", "getCornerRadius", "getDisableReplacementSpan", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableBlockBackground", "()Z", "getEnableCodeBlockHeaderBackground", "getEnableCodeBlockStroke", "getEnableCodeCopyButton", "getEnableCodeFullScreenButton", "getEnableCodeHeader", "getEnableLineNumber", "getEnablePreviewButton", "getEnableScroll", "getEnableSyntaxHighlight", "getEnableTitleBottomLine", "getLineNumberColor", "getTitleBgColor", "getTitleBottomLineColor", "getTitleStyle", "()Lcom/larus/business/markdown/api/model/TitleStyle;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILjava/lang/Integer;ZLjava/lang/String;ZZLcom/larus/business/markdown/api/model/TitleStyle;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZZLjava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Boolean;ZZ)Lcom/larus/business/markdown/api/model/CodeBlockConfig;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class CodeBlockConfig {
    private final Integer backgroundColor;
    private final Integer blockBackgroundColor;
    private final Integer blockBorderColor;
    private final Integer blockBorderWidth;
    private final Integer blockMargin;
    private final Integer codeBlockTextColor;
    private final Integer codeContentSize;
    private final String codeCopyTitle;
    private final Integer codeTextColor;
    private final int codeTitleSize;
    private final Integer cornerRadius;
    private final Boolean disableReplacementSpan;
    private final boolean enableBlockBackground;
    private final boolean enableCodeBlockHeaderBackground;
    private final boolean enableCodeBlockStroke;
    private final boolean enableCodeCopyButton;
    private final boolean enableCodeFullScreenButton;
    private final boolean enableCodeHeader;
    private final boolean enableLineNumber;
    private final boolean enablePreviewButton;
    private final boolean enableScroll;
    private final boolean enableSyntaxHighlight;
    private final boolean enableTitleBottomLine;
    private final Integer lineNumberColor;
    private final Integer titleBgColor;
    private final Integer titleBottomLineColor;
    private final TitleStyle titleStyle;

    public CodeBlockConfig() {
        this(null, null, false, null, 0, null, false, null, false, false, null, false, null, null, null, null, false, false, null, false, null, null, null, false, null, false, false, 134217727, null);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getCornerRadius() {
        return this.cornerRadius;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getEnableCodeCopyButton() {
        return this.enableCodeCopyButton;
    }

    /* renamed from: component11, reason: from getter */
    public final TitleStyle getTitleStyle() {
        return this.titleStyle;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getEnableCodeHeader() {
        return this.enableCodeHeader;
    }

    /* renamed from: component13, reason: from getter */
    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: component14, reason: from getter */
    public final Integer getBlockBackgroundColor() {
        return this.blockBackgroundColor;
    }

    /* renamed from: component15, reason: from getter */
    public final Integer getCodeTextColor() {
        return this.codeTextColor;
    }

    /* renamed from: component16, reason: from getter */
    public final Integer getBlockMargin() {
        return this.blockMargin;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getEnableScroll() {
        return this.enableScroll;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getEnableLineNumber() {
        return this.enableLineNumber;
    }

    /* renamed from: component19, reason: from getter */
    public final Integer getLineNumberColor() {
        return this.lineNumberColor;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getTitleBgColor() {
        return this.titleBgColor;
    }

    /* renamed from: component20, reason: from getter */
    public final boolean getEnableBlockBackground() {
        return this.enableBlockBackground;
    }

    /* renamed from: component21, reason: from getter */
    public final Integer getCodeBlockTextColor() {
        return this.codeBlockTextColor;
    }

    /* renamed from: component22, reason: from getter */
    public final Integer getBlockBorderColor() {
        return this.blockBorderColor;
    }

    /* renamed from: component23, reason: from getter */
    public final Integer getBlockBorderWidth() {
        return this.blockBorderWidth;
    }

    /* renamed from: component24, reason: from getter */
    public final boolean getEnableSyntaxHighlight() {
        return this.enableSyntaxHighlight;
    }

    /* renamed from: component25, reason: from getter */
    public final Boolean getDisableReplacementSpan() {
        return this.disableReplacementSpan;
    }

    /* renamed from: component26, reason: from getter */
    public final boolean getEnableCodeBlockStroke() {
        return this.enableCodeBlockStroke;
    }

    /* renamed from: component27, reason: from getter */
    public final boolean getEnableCodeBlockHeaderBackground() {
        return this.enableCodeBlockHeaderBackground;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getEnableTitleBottomLine() {
        return this.enableTitleBottomLine;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getTitleBottomLineColor() {
        return this.titleBottomLineColor;
    }

    /* renamed from: component5, reason: from getter */
    public final int getCodeTitleSize() {
        return this.codeTitleSize;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getCodeContentSize() {
        return this.codeContentSize;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getEnableCodeFullScreenButton() {
        return this.enableCodeFullScreenButton;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCodeCopyTitle() {
        return this.codeCopyTitle;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getEnablePreviewButton() {
        return this.enablePreviewButton;
    }

    public final CodeBlockConfig copy(Integer cornerRadius, Integer titleBgColor, boolean enableTitleBottomLine, Integer titleBottomLineColor, int codeTitleSize, Integer codeContentSize, boolean enableCodeFullScreenButton, String codeCopyTitle, boolean enablePreviewButton, boolean enableCodeCopyButton, TitleStyle titleStyle, boolean enableCodeHeader, Integer backgroundColor, Integer blockBackgroundColor, Integer codeTextColor, Integer blockMargin, boolean enableScroll, boolean enableLineNumber, Integer lineNumberColor, boolean enableBlockBackground, Integer codeBlockTextColor, Integer blockBorderColor, Integer blockBorderWidth, boolean enableSyntaxHighlight, Boolean disableReplacementSpan, boolean enableCodeBlockStroke, boolean enableCodeBlockHeaderBackground) {
        Intrinsics.checkNotNullParameter(codeCopyTitle, "codeCopyTitle");
        Intrinsics.checkNotNullParameter(titleStyle, "titleStyle");
        return new CodeBlockConfig(cornerRadius, titleBgColor, enableTitleBottomLine, titleBottomLineColor, codeTitleSize, codeContentSize, enableCodeFullScreenButton, codeCopyTitle, enablePreviewButton, enableCodeCopyButton, titleStyle, enableCodeHeader, backgroundColor, blockBackgroundColor, codeTextColor, blockMargin, enableScroll, enableLineNumber, lineNumberColor, enableBlockBackground, codeBlockTextColor, blockBorderColor, blockBorderWidth, enableSyntaxHighlight, disableReplacementSpan, enableCodeBlockStroke, enableCodeBlockHeaderBackground);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CodeBlockConfig)) {
            return false;
        }
        CodeBlockConfig codeBlockConfig = (CodeBlockConfig) other;
        return Intrinsics.areEqual(this.cornerRadius, codeBlockConfig.cornerRadius) && Intrinsics.areEqual(this.titleBgColor, codeBlockConfig.titleBgColor) && this.enableTitleBottomLine == codeBlockConfig.enableTitleBottomLine && Intrinsics.areEqual(this.titleBottomLineColor, codeBlockConfig.titleBottomLineColor) && this.codeTitleSize == codeBlockConfig.codeTitleSize && Intrinsics.areEqual(this.codeContentSize, codeBlockConfig.codeContentSize) && this.enableCodeFullScreenButton == codeBlockConfig.enableCodeFullScreenButton && Intrinsics.areEqual(this.codeCopyTitle, codeBlockConfig.codeCopyTitle) && this.enablePreviewButton == codeBlockConfig.enablePreviewButton && this.enableCodeCopyButton == codeBlockConfig.enableCodeCopyButton && this.titleStyle == codeBlockConfig.titleStyle && this.enableCodeHeader == codeBlockConfig.enableCodeHeader && Intrinsics.areEqual(this.backgroundColor, codeBlockConfig.backgroundColor) && Intrinsics.areEqual(this.blockBackgroundColor, codeBlockConfig.blockBackgroundColor) && Intrinsics.areEqual(this.codeTextColor, codeBlockConfig.codeTextColor) && Intrinsics.areEqual(this.blockMargin, codeBlockConfig.blockMargin) && this.enableScroll == codeBlockConfig.enableScroll && this.enableLineNumber == codeBlockConfig.enableLineNumber && Intrinsics.areEqual(this.lineNumberColor, codeBlockConfig.lineNumberColor) && this.enableBlockBackground == codeBlockConfig.enableBlockBackground && Intrinsics.areEqual(this.codeBlockTextColor, codeBlockConfig.codeBlockTextColor) && Intrinsics.areEqual(this.blockBorderColor, codeBlockConfig.blockBorderColor) && Intrinsics.areEqual(this.blockBorderWidth, codeBlockConfig.blockBorderWidth) && this.enableSyntaxHighlight == codeBlockConfig.enableSyntaxHighlight && Intrinsics.areEqual(this.disableReplacementSpan, codeBlockConfig.disableReplacementSpan) && this.enableCodeBlockStroke == codeBlockConfig.enableCodeBlockStroke && this.enableCodeBlockHeaderBackground == codeBlockConfig.enableCodeBlockHeaderBackground;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Integer num = this.cornerRadius;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.titleBgColor;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        boolean z = this.enableTitleBottomLine;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode2 + i) * 31;
        Integer num3 = this.titleBottomLineColor;
        int hashCode3 = (((i2 + (num3 == null ? 0 : num3.hashCode())) * 31) + Integer.hashCode(this.codeTitleSize)) * 31;
        Integer num4 = this.codeContentSize;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        boolean z2 = this.enableCodeFullScreenButton;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int hashCode5 = (((hashCode4 + i3) * 31) + this.codeCopyTitle.hashCode()) * 31;
        boolean z3 = this.enablePreviewButton;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (hashCode5 + i4) * 31;
        boolean z4 = this.enableCodeCopyButton;
        int i6 = z4;
        if (z4 != 0) {
            i6 = 1;
        }
        int hashCode6 = (((i5 + i6) * 31) + this.titleStyle.hashCode()) * 31;
        boolean z5 = this.enableCodeHeader;
        int i7 = z5;
        if (z5 != 0) {
            i7 = 1;
        }
        int i8 = (hashCode6 + i7) * 31;
        Integer num5 = this.backgroundColor;
        int hashCode7 = (i8 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.blockBackgroundColor;
        int hashCode8 = (hashCode7 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.codeTextColor;
        int hashCode9 = (hashCode8 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.blockMargin;
        int hashCode10 = (hashCode9 + (num8 == null ? 0 : num8.hashCode())) * 31;
        boolean z6 = this.enableScroll;
        int i9 = z6;
        if (z6 != 0) {
            i9 = 1;
        }
        int i10 = (hashCode10 + i9) * 31;
        boolean z7 = this.enableLineNumber;
        int i11 = z7;
        if (z7 != 0) {
            i11 = 1;
        }
        int i12 = (i10 + i11) * 31;
        Integer num9 = this.lineNumberColor;
        int hashCode11 = (i12 + (num9 == null ? 0 : num9.hashCode())) * 31;
        boolean z8 = this.enableBlockBackground;
        int i13 = z8;
        if (z8 != 0) {
            i13 = 1;
        }
        int i14 = (hashCode11 + i13) * 31;
        Integer num10 = this.codeBlockTextColor;
        int hashCode12 = (i14 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.blockBorderColor;
        int hashCode13 = (hashCode12 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.blockBorderWidth;
        int hashCode14 = (hashCode13 + (num12 == null ? 0 : num12.hashCode())) * 31;
        boolean z9 = this.enableSyntaxHighlight;
        int i15 = z9;
        if (z9 != 0) {
            i15 = 1;
        }
        int i16 = (hashCode14 + i15) * 31;
        Boolean bool = this.disableReplacementSpan;
        int hashCode15 = (i16 + (bool != null ? bool.hashCode() : 0)) * 31;
        boolean z10 = this.enableCodeBlockStroke;
        int i17 = z10;
        if (z10 != 0) {
            i17 = 1;
        }
        int i18 = (hashCode15 + i17) * 31;
        boolean z11 = this.enableCodeBlockHeaderBackground;
        return i18 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CodeBlockConfig(cornerRadius=");
        sb.append(this.cornerRadius).append(", titleBgColor=").append(this.titleBgColor).append(", enableTitleBottomLine=").append(this.enableTitleBottomLine).append(", titleBottomLineColor=").append(this.titleBottomLineColor).append(", codeTitleSize=").append(this.codeTitleSize).append(", codeContentSize=").append(this.codeContentSize).append(", enableCodeFullScreenButton=").append(this.enableCodeFullScreenButton).append(", codeCopyTitle=").append(this.codeCopyTitle).append(", enablePreviewButton=").append(this.enablePreviewButton).append(", enableCodeCopyButton=").append(this.enableCodeCopyButton).append(", titleStyle=").append(this.titleStyle).append(", enableCodeHeader=");
        sb.append(this.enableCodeHeader).append(", backgroundColor=").append(this.backgroundColor).append(", blockBackgroundColor=").append(this.blockBackgroundColor).append(", codeTextColor=").append(this.codeTextColor).append(", blockMargin=").append(this.blockMargin).append(", enableScroll=").append(this.enableScroll).append(", enableLineNumber=").append(this.enableLineNumber).append(", lineNumberColor=").append(this.lineNumberColor).append(", enableBlockBackground=").append(this.enableBlockBackground).append(", codeBlockTextColor=").append(this.codeBlockTextColor).append(", blockBorderColor=").append(this.blockBorderColor).append(", blockBorderWidth=").append(this.blockBorderWidth);
        sb.append(", enableSyntaxHighlight=").append(this.enableSyntaxHighlight).append(", disableReplacementSpan=").append(this.disableReplacementSpan).append(", enableCodeBlockStroke=").append(this.enableCodeBlockStroke).append(", enableCodeBlockHeaderBackground=").append(this.enableCodeBlockHeaderBackground).append(')');
        return sb.toString();
    }

    public CodeBlockConfig(Integer num, Integer num2, boolean z, Integer num3, int i, Integer num4, boolean z2, String codeCopyTitle, boolean z3, boolean z4, TitleStyle titleStyle, boolean z5, Integer num5, Integer num6, Integer num7, Integer num8, boolean z6, boolean z7, Integer num9, boolean z8, Integer num10, Integer num11, Integer num12, boolean z9, Boolean bool, boolean z10, boolean z11) {
        Intrinsics.checkNotNullParameter(codeCopyTitle, "codeCopyTitle");
        Intrinsics.checkNotNullParameter(titleStyle, "titleStyle");
        this.cornerRadius = num;
        this.titleBgColor = num2;
        this.enableTitleBottomLine = z;
        this.titleBottomLineColor = num3;
        this.codeTitleSize = i;
        this.codeContentSize = num4;
        this.enableCodeFullScreenButton = z2;
        this.codeCopyTitle = codeCopyTitle;
        this.enablePreviewButton = z3;
        this.enableCodeCopyButton = z4;
        this.titleStyle = titleStyle;
        this.enableCodeHeader = z5;
        this.backgroundColor = num5;
        this.blockBackgroundColor = num6;
        this.codeTextColor = num7;
        this.blockMargin = num8;
        this.enableScroll = z6;
        this.enableLineNumber = z7;
        this.lineNumberColor = num9;
        this.enableBlockBackground = z8;
        this.codeBlockTextColor = num10;
        this.blockBorderColor = num11;
        this.blockBorderWidth = num12;
        this.enableSyntaxHighlight = z9;
        this.disableReplacementSpan = bool;
        this.enableCodeBlockStroke = z10;
        this.enableCodeBlockHeaderBackground = z11;
    }

    public final Integer getCornerRadius() {
        return this.cornerRadius;
    }

    public final Integer getTitleBgColor() {
        return this.titleBgColor;
    }

    public final boolean getEnableTitleBottomLine() {
        return this.enableTitleBottomLine;
    }

    public final Integer getTitleBottomLineColor() {
        return this.titleBottomLineColor;
    }

    public final int getCodeTitleSize() {
        return this.codeTitleSize;
    }

    public final Integer getCodeContentSize() {
        return this.codeContentSize;
    }

    public final boolean getEnableCodeFullScreenButton() {
        return this.enableCodeFullScreenButton;
    }

    public final String getCodeCopyTitle() {
        return this.codeCopyTitle;
    }

    public final boolean getEnablePreviewButton() {
        return this.enablePreviewButton;
    }

    public final boolean getEnableCodeCopyButton() {
        return this.enableCodeCopyButton;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ CodeBlockConfig(Integer num, Integer num2, boolean z, Integer num3, int i, Integer num4, boolean z2, String str, boolean z3, boolean z4, TitleStyle titleStyle, boolean z5, Integer num5, Integer num6, Integer num7, Integer num8, boolean z6, boolean z7, Integer num9, boolean z8, Integer num10, Integer num11, Integer num12, boolean z9, Boolean bool, boolean z10, boolean z11, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r6, r7, r8, r9, r11, r12, r13, r14, r15, r2, r10, r5, r16, r17, r18, r19, r20, r21, r22, r23, r24, r26, (i2 & AVLogger.LEVEL_LOG_INFO) != 0 ? r25 : z10, (i2 & 67108864) == 0 ? z11 : r25);
        boolean z12;
        Boolean bool2;
        Integer num13 = (i2 & 1) != 0 ? null : num;
        Integer num14 = (i2 & 2) != 0 ? null : num2;
        boolean z13 = (i2 & 4) != 0 ? false : z;
        Integer num15 = (i2 & 8) != 0 ? null : num3;
        int i3 = (i2 & 16) != 0 ? 0 : i;
        Integer num16 = (i2 & 32) != 0 ? null : num4;
        boolean z14 = (i2 & 64) != 0 ? true : z2;
        String str2 = (i2 & 128) != 0 ? "" : str;
        boolean z15 = (i2 & 256) != 0 ? false : z3;
        boolean z16 = (i2 & 512) != 0 ? true : z4;
        TitleStyle titleStyle2 = (i2 & 1024) != 0 ? TitleStyle.NORMAL : titleStyle;
        boolean z17 = (i2 & 2048) != 0 ? true : z5;
        Integer num17 = (i2 & 4096) != 0 ? null : num5;
        Integer num18 = (i2 & 8192) != 0 ? null : num6;
        Integer num19 = (i2 & 16384) != 0 ? null : num7;
        Integer num20 = (i2 & 32768) != 0 ? null : num8;
        boolean z18 = (i2 & 65536) != 0 ? false : z6;
        boolean z19 = (i2 & 131072) != 0 ? false : z7;
        Integer num21 = (i2 & 262144) != 0 ? null : num9;
        boolean z20 = (i2 & 524288) != 0 ? true : z8;
        Integer num22 = (i2 & 1048576) != 0 ? null : num10;
        Integer num23 = (i2 & 2097152) != 0 ? null : num11;
        Integer num24 = (i2 & 4194304) != 0 ? null : num12;
        boolean z21 = (i2 & 8388608) != 0 ? true : z9;
        if ((i2 & 16777216) != 0) {
            z12 = false;
            bool2 = false;
        } else {
            z12 = false;
            bool2 = bool;
        }
    }

    public final TitleStyle getTitleStyle() {
        return this.titleStyle;
    }

    public final boolean getEnableCodeHeader() {
        return this.enableCodeHeader;
    }

    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public final Integer getBlockBackgroundColor() {
        return this.blockBackgroundColor;
    }

    public final Integer getCodeTextColor() {
        return this.codeTextColor;
    }

    public final Integer getBlockMargin() {
        return this.blockMargin;
    }

    public final boolean getEnableScroll() {
        return this.enableScroll;
    }

    public final boolean getEnableLineNumber() {
        return this.enableLineNumber;
    }

    public final Integer getLineNumberColor() {
        return this.lineNumberColor;
    }

    public final boolean getEnableBlockBackground() {
        return this.enableBlockBackground;
    }

    public final Integer getCodeBlockTextColor() {
        return this.codeBlockTextColor;
    }

    public final Integer getBlockBorderColor() {
        return this.blockBorderColor;
    }

    public final Integer getBlockBorderWidth() {
        return this.blockBorderWidth;
    }

    public final boolean getEnableSyntaxHighlight() {
        return this.enableSyntaxHighlight;
    }

    public final Boolean getDisableReplacementSpan() {
        return this.disableReplacementSpan;
    }

    public final boolean getEnableCodeBlockStroke() {
        return this.enableCodeBlockStroke;
    }

    public final boolean getEnableCodeBlockHeaderBackground() {
        return this.enableCodeBlockHeaderBackground;
    }
}
