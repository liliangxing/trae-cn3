package com.larus.business.markdown.api.model;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TableConfig.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b<\b\u0087\b\u0018\u00002\u00020\u0001Bñ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001cJ\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010>\u001a\u00020\u0012HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0019HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010H\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJú\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010PJ\u0013\u0010Q\u001a\u00020\u00032\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020\u0005HÖ\u0001J\t\u0010T\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001eR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b)\u0010\u001eR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b*\u0010\u001eR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b+\u0010\u001eR\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b,\u0010\u001eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b-\u0010\u001eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b5\u0010\u001eR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b6\u0010\u001eR\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b9\u0010\u001e¨\u0006U"}, d2 = {"Lcom/larus/business/markdown/api/model/TableConfig;", "", "enableTableHeader", "", "tableTitleBgColor", "", "tableTextSize", "", "tableBorderWidth", "tableBorderColor", "tableTextColor", "bottomRoundCornerRadius", "topRoundCornerRadius", "tableWidth", "cellMaxWidth", "cellVerticalPadding", "cellHorizontalPadding", "tableTitle", "", "tableTitleSize", "enableCopyButton", "copyExcelStyle", "enableFullScreenButton", "enableTableWidthMatchParent", "titleStyle", "Lcom/larus/business/markdown/api/model/TitleStyle;", "tableOddRowBackgroundColor", "tableHeaderRowBackgroundColor", "(ZILjava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;ZZZZLcom/larus/business/markdown/api/model/TitleStyle;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBottomRoundCornerRadius", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCellHorizontalPadding", "getCellMaxWidth", "getCellVerticalPadding", "getCopyExcelStyle", "()Z", "getEnableCopyButton", "getEnableFullScreenButton", "getEnableTableHeader", "getEnableTableWidthMatchParent", "getTableBorderColor", "getTableBorderWidth", "getTableHeaderRowBackgroundColor", "getTableOddRowBackgroundColor", "getTableTextColor", "getTableTextSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTableTitle", "()Ljava/lang/String;", "getTableTitleBgColor", "()I", "getTableTitleSize", "getTableWidth", "getTitleStyle", "()Lcom/larus/business/markdown/api/model/TitleStyle;", "getTopRoundCornerRadius", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZILjava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;ZZZZLcom/larus/business/markdown/api/model/TitleStyle;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/business/markdown/api/model/TableConfig;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class TableConfig {
    private final Integer bottomRoundCornerRadius;
    private final Integer cellHorizontalPadding;
    private final Integer cellMaxWidth;
    private final Integer cellVerticalPadding;
    private final boolean copyExcelStyle;
    private final boolean enableCopyButton;
    private final boolean enableFullScreenButton;
    private final boolean enableTableHeader;
    private final boolean enableTableWidthMatchParent;
    private final Integer tableBorderColor;
    private final Integer tableBorderWidth;
    private final Integer tableHeaderRowBackgroundColor;
    private final Integer tableOddRowBackgroundColor;
    private final Integer tableTextColor;
    private final Float tableTextSize;
    private final String tableTitle;
    private final int tableTitleBgColor;
    private final Integer tableTitleSize;
    private final Integer tableWidth;
    private final TitleStyle titleStyle;
    private final Integer topRoundCornerRadius;

    public TableConfig() {
        this(false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, null, null, null, 2097151, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnableTableHeader() {
        return this.enableTableHeader;
    }

    /* renamed from: component10, reason: from getter */
    public final Integer getCellMaxWidth() {
        return this.cellMaxWidth;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getCellVerticalPadding() {
        return this.cellVerticalPadding;
    }

    /* renamed from: component12, reason: from getter */
    public final Integer getCellHorizontalPadding() {
        return this.cellHorizontalPadding;
    }

    /* renamed from: component13, reason: from getter */
    public final String getTableTitle() {
        return this.tableTitle;
    }

    /* renamed from: component14, reason: from getter */
    public final Integer getTableTitleSize() {
        return this.tableTitleSize;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getEnableCopyButton() {
        return this.enableCopyButton;
    }

    /* renamed from: component16, reason: from getter */
    public final boolean getCopyExcelStyle() {
        return this.copyExcelStyle;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getEnableFullScreenButton() {
        return this.enableFullScreenButton;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getEnableTableWidthMatchParent() {
        return this.enableTableWidthMatchParent;
    }

    /* renamed from: component19, reason: from getter */
    public final TitleStyle getTitleStyle() {
        return this.titleStyle;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTableTitleBgColor() {
        return this.tableTitleBgColor;
    }

    /* renamed from: component20, reason: from getter */
    public final Integer getTableOddRowBackgroundColor() {
        return this.tableOddRowBackgroundColor;
    }

    /* renamed from: component21, reason: from getter */
    public final Integer getTableHeaderRowBackgroundColor() {
        return this.tableHeaderRowBackgroundColor;
    }

    /* renamed from: component3, reason: from getter */
    public final Float getTableTextSize() {
        return this.tableTextSize;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getTableBorderWidth() {
        return this.tableBorderWidth;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getTableBorderColor() {
        return this.tableBorderColor;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getTableTextColor() {
        return this.tableTextColor;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getBottomRoundCornerRadius() {
        return this.bottomRoundCornerRadius;
    }

    /* renamed from: component8, reason: from getter */
    public final Integer getTopRoundCornerRadius() {
        return this.topRoundCornerRadius;
    }

    /* renamed from: component9, reason: from getter */
    public final Integer getTableWidth() {
        return this.tableWidth;
    }

    public final TableConfig copy(boolean enableTableHeader, int tableTitleBgColor, Float tableTextSize, Integer tableBorderWidth, Integer tableBorderColor, Integer tableTextColor, Integer bottomRoundCornerRadius, Integer topRoundCornerRadius, Integer tableWidth, Integer cellMaxWidth, Integer cellVerticalPadding, Integer cellHorizontalPadding, String tableTitle, Integer tableTitleSize, boolean enableCopyButton, boolean copyExcelStyle, boolean enableFullScreenButton, boolean enableTableWidthMatchParent, TitleStyle titleStyle, Integer tableOddRowBackgroundColor, Integer tableHeaderRowBackgroundColor) {
        Intrinsics.checkNotNullParameter(tableTitle, "tableTitle");
        Intrinsics.checkNotNullParameter(titleStyle, "titleStyle");
        return new TableConfig(enableTableHeader, tableTitleBgColor, tableTextSize, tableBorderWidth, tableBorderColor, tableTextColor, bottomRoundCornerRadius, topRoundCornerRadius, tableWidth, cellMaxWidth, cellVerticalPadding, cellHorizontalPadding, tableTitle, tableTitleSize, enableCopyButton, copyExcelStyle, enableFullScreenButton, enableTableWidthMatchParent, titleStyle, tableOddRowBackgroundColor, tableHeaderRowBackgroundColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TableConfig)) {
            return false;
        }
        TableConfig tableConfig = (TableConfig) other;
        return this.enableTableHeader == tableConfig.enableTableHeader && this.tableTitleBgColor == tableConfig.tableTitleBgColor && Intrinsics.areEqual((Object) this.tableTextSize, (Object) tableConfig.tableTextSize) && Intrinsics.areEqual(this.tableBorderWidth, tableConfig.tableBorderWidth) && Intrinsics.areEqual(this.tableBorderColor, tableConfig.tableBorderColor) && Intrinsics.areEqual(this.tableTextColor, tableConfig.tableTextColor) && Intrinsics.areEqual(this.bottomRoundCornerRadius, tableConfig.bottomRoundCornerRadius) && Intrinsics.areEqual(this.topRoundCornerRadius, tableConfig.topRoundCornerRadius) && Intrinsics.areEqual(this.tableWidth, tableConfig.tableWidth) && Intrinsics.areEqual(this.cellMaxWidth, tableConfig.cellMaxWidth) && Intrinsics.areEqual(this.cellVerticalPadding, tableConfig.cellVerticalPadding) && Intrinsics.areEqual(this.cellHorizontalPadding, tableConfig.cellHorizontalPadding) && Intrinsics.areEqual(this.tableTitle, tableConfig.tableTitle) && Intrinsics.areEqual(this.tableTitleSize, tableConfig.tableTitleSize) && this.enableCopyButton == tableConfig.enableCopyButton && this.copyExcelStyle == tableConfig.copyExcelStyle && this.enableFullScreenButton == tableConfig.enableFullScreenButton && this.enableTableWidthMatchParent == tableConfig.enableTableWidthMatchParent && this.titleStyle == tableConfig.titleStyle && Intrinsics.areEqual(this.tableOddRowBackgroundColor, tableConfig.tableOddRowBackgroundColor) && Intrinsics.areEqual(this.tableHeaderRowBackgroundColor, tableConfig.tableHeaderRowBackgroundColor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r2v37, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v39, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v41, types: [boolean] */
    public int hashCode() {
        boolean z = this.enableTableHeader;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = ((r0 * 31) + Integer.hashCode(this.tableTitleBgColor)) * 31;
        Float f = this.tableTextSize;
        int hashCode2 = (hashCode + (f == null ? 0 : f.hashCode())) * 31;
        Integer num = this.tableBorderWidth;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.tableBorderColor;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.tableTextColor;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.bottomRoundCornerRadius;
        int hashCode6 = (hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.topRoundCornerRadius;
        int hashCode7 = (hashCode6 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.tableWidth;
        int hashCode8 = (hashCode7 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.cellMaxWidth;
        int hashCode9 = (hashCode8 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.cellVerticalPadding;
        int hashCode10 = (hashCode9 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.cellHorizontalPadding;
        int hashCode11 = (((hashCode10 + (num9 == null ? 0 : num9.hashCode())) * 31) + this.tableTitle.hashCode()) * 31;
        Integer num10 = this.tableTitleSize;
        int hashCode12 = (hashCode11 + (num10 == null ? 0 : num10.hashCode())) * 31;
        ?? r2 = this.enableCopyButton;
        int i = r2;
        if (r2 != 0) {
            i = 1;
        }
        int i2 = (hashCode12 + i) * 31;
        ?? r22 = this.copyExcelStyle;
        int i3 = r22;
        if (r22 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        ?? r23 = this.enableFullScreenButton;
        int i5 = r23;
        if (r23 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z2 = this.enableTableWidthMatchParent;
        int hashCode13 = (((i6 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.titleStyle.hashCode()) * 31;
        Integer num11 = this.tableOddRowBackgroundColor;
        int hashCode14 = (hashCode13 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.tableHeaderRowBackgroundColor;
        return hashCode14 + (num12 != null ? num12.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TableConfig(enableTableHeader=");
        sb.append(this.enableTableHeader).append(", tableTitleBgColor=").append(this.tableTitleBgColor).append(", tableTextSize=").append(this.tableTextSize).append(", tableBorderWidth=").append(this.tableBorderWidth).append(", tableBorderColor=").append(this.tableBorderColor).append(", tableTextColor=").append(this.tableTextColor).append(", bottomRoundCornerRadius=").append(this.bottomRoundCornerRadius).append(", topRoundCornerRadius=").append(this.topRoundCornerRadius).append(", tableWidth=").append(this.tableWidth).append(", cellMaxWidth=").append(this.cellMaxWidth).append(", cellVerticalPadding=").append(this.cellVerticalPadding).append(", cellHorizontalPadding=");
        sb.append(this.cellHorizontalPadding).append(", tableTitle=").append(this.tableTitle).append(", tableTitleSize=").append(this.tableTitleSize).append(", enableCopyButton=").append(this.enableCopyButton).append(", copyExcelStyle=").append(this.copyExcelStyle).append(", enableFullScreenButton=").append(this.enableFullScreenButton).append(", enableTableWidthMatchParent=").append(this.enableTableWidthMatchParent).append(", titleStyle=").append(this.titleStyle).append(", tableOddRowBackgroundColor=").append(this.tableOddRowBackgroundColor).append(", tableHeaderRowBackgroundColor=").append(this.tableHeaderRowBackgroundColor).append(')');
        return sb.toString();
    }

    public TableConfig(boolean z, int i, Float f, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, String tableTitle, Integer num10, boolean z2, boolean z3, boolean z4, boolean z5, TitleStyle titleStyle, Integer num11, Integer num12) {
        Intrinsics.checkNotNullParameter(tableTitle, "tableTitle");
        Intrinsics.checkNotNullParameter(titleStyle, "titleStyle");
        this.enableTableHeader = z;
        this.tableTitleBgColor = i;
        this.tableTextSize = f;
        this.tableBorderWidth = num;
        this.tableBorderColor = num2;
        this.tableTextColor = num3;
        this.bottomRoundCornerRadius = num4;
        this.topRoundCornerRadius = num5;
        this.tableWidth = num6;
        this.cellMaxWidth = num7;
        this.cellVerticalPadding = num8;
        this.cellHorizontalPadding = num9;
        this.tableTitle = tableTitle;
        this.tableTitleSize = num10;
        this.enableCopyButton = z2;
        this.copyExcelStyle = z3;
        this.enableFullScreenButton = z4;
        this.enableTableWidthMatchParent = z5;
        this.titleStyle = titleStyle;
        this.tableOddRowBackgroundColor = num11;
        this.tableHeaderRowBackgroundColor = num12;
    }

    public final boolean getEnableTableHeader() {
        return this.enableTableHeader;
    }

    public final int getTableTitleBgColor() {
        return this.tableTitleBgColor;
    }

    public final Float getTableTextSize() {
        return this.tableTextSize;
    }

    public final Integer getTableBorderWidth() {
        return this.tableBorderWidth;
    }

    public final Integer getTableBorderColor() {
        return this.tableBorderColor;
    }

    public final Integer getTableTextColor() {
        return this.tableTextColor;
    }

    public final Integer getBottomRoundCornerRadius() {
        return this.bottomRoundCornerRadius;
    }

    public final Integer getTopRoundCornerRadius() {
        return this.topRoundCornerRadius;
    }

    public final Integer getTableWidth() {
        return this.tableWidth;
    }

    public final Integer getCellMaxWidth() {
        return this.cellMaxWidth;
    }

    public final Integer getCellVerticalPadding() {
        return this.cellVerticalPadding;
    }

    public final Integer getCellHorizontalPadding() {
        return this.cellHorizontalPadding;
    }

    public final String getTableTitle() {
        return this.tableTitle;
    }

    public final Integer getTableTitleSize() {
        return this.tableTitleSize;
    }

    public final boolean getEnableCopyButton() {
        return this.enableCopyButton;
    }

    public final boolean getCopyExcelStyle() {
        return this.copyExcelStyle;
    }

    public final boolean getEnableFullScreenButton() {
        return this.enableFullScreenButton;
    }

    public final boolean getEnableTableWidthMatchParent() {
        return this.enableTableWidthMatchParent;
    }

    public /* synthetic */ TableConfig(boolean z, int i, Float f, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, String str, Integer num10, boolean z2, boolean z3, boolean z4, boolean z5, TitleStyle titleStyle, Integer num11, Integer num12, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? -7829368 : i, (i2 & 4) != 0 ? null : f, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? null : num2, (i2 & 32) != 0 ? null : num3, (i2 & 64) != 0 ? null : num4, (i2 & 128) != 0 ? null : num5, (i2 & 256) != 0 ? null : num6, (i2 & 512) != 0 ? null : num7, (i2 & 1024) != 0 ? null : num8, (i2 & 2048) != 0 ? null : num9, (i2 & 4096) != 0 ? "" : str, (i2 & 8192) != 0 ? null : num10, (i2 & 16384) != 0 ? false : z2, (i2 & 32768) != 0 ? false : z3, (i2 & 65536) != 0 ? false : z4, (i2 & 131072) != 0 ? true : z5, (i2 & 262144) != 0 ? TitleStyle.LARGE : titleStyle, (i2 & 524288) != 0 ? null : num11, (i2 & 1048576) != 0 ? null : num12);
    }

    public final TitleStyle getTitleStyle() {
        return this.titleStyle;
    }

    public final Integer getTableOddRowBackgroundColor() {
        return this.tableOddRowBackgroundColor;
    }

    public final Integer getTableHeaderRowBackgroundColor() {
        return this.tableHeaderRowBackgroundColor;
    }
}
