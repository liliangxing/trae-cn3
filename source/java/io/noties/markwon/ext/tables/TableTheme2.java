package io.noties.markwon.ext.tables;

import io.noties.markwon.ext.tables.TableTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TableTheme2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0016\u0018\u0000 -2\u00020\u0001:\u0001-B\u009b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0003\u0010\b\u001a\u00020\u0005\u0012\b\b\u0003\u0010\t\u001a\u00020\u0005\u0012\b\b\u0003\u0010\n\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u000b\u001a\u00020\f\u0012\b\b\u0003\u0010\r\u001a\u00020\f\u0012\b\b\u0003\u0010\u000e\u001a\u00020\f\u0012\b\b\u0003\u0010\u000f\u001a\u00020\f\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005¢\u0006\u0002\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u001a\u0010#\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0018¨\u0006."}, d2 = {"Lio/noties/markwon/ext/tables/TableTheme2;", "Lio/noties/markwon/ext/tables/TableTheme;", "builder", "Lio/noties/markwon/ext/tables/TableTheme$Builder;", "tableWidth", "", "cellMinWidth", "cellMaxWidth", "cellVerticalPadding", "cellHorizontalPadding", "shaderColor", "tableTextSize", "", "roundCornerRadius", "bottomRoundCornerRadius", "topRoundCornerRadius", "tableTextColor", "enableTableWidthMatchParent", "", "foregroundProvider", "Lio/noties/markwon/ext/tables/ForegroundProvider;", "placeholderStyle", "(Lio/noties/markwon/ext/tables/TableTheme$Builder;IIIIIIFFFFIZLio/noties/markwon/ext/tables/ForegroundProvider;I)V", "getBottomRoundCornerRadius", "()F", "getCellMaxWidth", "()I", "getCellMinWidth", "getEnableTableWidthMatchParent", "()Z", "getForegroundProvider", "()Lio/noties/markwon/ext/tables/ForegroundProvider;", "getPlaceholderStyle", "getRoundCornerRadius", "getShaderColor", "tableCellHorizontalPadding", "getTableCellHorizontalPadding", "setTableCellHorizontalPadding", "(I)V", "tableCellVerticalPadding", "getTableCellVerticalPadding", "getTableTextColor", "getTableTextSize", "getTableWidth", "getTopRoundCornerRadius", "Companion", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public class TableTheme2 extends TableTheme {
    public static final int PLACEHOLDER_STYLE_DEFAULT = 0;
    public static final int PLACEHOLDER_STYLE_WHITE_SPACE = 1;
    private final float bottomRoundCornerRadius;
    private final int cellMaxWidth;
    private final int cellMinWidth;
    private final boolean enableTableWidthMatchParent;
    private final ForegroundProvider foregroundProvider;
    private final int placeholderStyle;
    private final float roundCornerRadius;
    private final int shaderColor;
    private int tableCellHorizontalPadding;
    private final int tableCellVerticalPadding;
    private final int tableTextColor;
    private final float tableTextSize;
    private final int tableWidth;
    private final float topRoundCornerRadius;

    public final int getTableWidth() {
        return this.tableWidth;
    }

    public final int getCellMinWidth() {
        return this.cellMinWidth;
    }

    public final int getCellMaxWidth() {
        return this.cellMaxWidth;
    }

    public final int getShaderColor() {
        return this.shaderColor;
    }

    public final float getTableTextSize() {
        return this.tableTextSize;
    }

    public final float getRoundCornerRadius() {
        return this.roundCornerRadius;
    }

    public final float getBottomRoundCornerRadius() {
        return this.bottomRoundCornerRadius;
    }

    public final float getTopRoundCornerRadius() {
        return this.topRoundCornerRadius;
    }

    public final int getTableTextColor() {
        return this.tableTextColor;
    }

    public final boolean getEnableTableWidthMatchParent() {
        return this.enableTableWidthMatchParent;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TableTheme2(TableTheme.Builder builder, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3, float f4, int i7, boolean z, ForegroundProvider foregroundProvider, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder, i, i2, i3, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, (i9 & 16384) != 0 ? 0 : i8);
        ForegroundProvider foregroundProvider2;
        int i10 = (i9 & 16) != 0 ? -1 : i4;
        int i11 = (i9 & 32) != 0 ? -1 : i5;
        int i12 = (i9 & 64) != 0 ? 0 : i6;
        float f5 = (i9 & 128) != 0 ? -1.0f : f;
        float f6 = (i9 & 256) != 0 ? 0.0f : f2;
        float f7 = (i9 & 512) != 0 ? 0.0f : f3;
        float f8 = (i9 & 1024) != 0 ? 0.0f : f4;
        int i13 = (i9 & 2048) != 0 ? -16777216 : i7;
        boolean z2 = (i9 & 4096) != 0 ? false : z;
        if ((i9 & 8192) != 0) {
            foregroundProvider2 = null;
        } else {
            foregroundProvider2 = foregroundProvider;
        }
    }

    public final ForegroundProvider getForegroundProvider() {
        return this.foregroundProvider;
    }

    public final int getPlaceholderStyle() {
        return this.placeholderStyle;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TableTheme2(TableTheme.Builder builder, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3, float f4, int i7, boolean z, ForegroundProvider foregroundProvider, int i8) {
        super(builder);
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        this.tableWidth = i;
        this.cellMinWidth = i2;
        this.cellMaxWidth = i3;
        this.shaderColor = i6;
        this.tableTextSize = f;
        this.roundCornerRadius = f2;
        this.bottomRoundCornerRadius = f3;
        this.topRoundCornerRadius = f4;
        this.tableTextColor = i7;
        this.enableTableWidthMatchParent = z;
        this.foregroundProvider = foregroundProvider;
        this.placeholderStyle = i8;
        this.tableCellVerticalPadding = i4 < 0 ? this.tableCellPadding : i4;
        int i9 = i5 < 0 ? this.tableCellPadding : i5;
        this.tableCellHorizontalPadding = i9;
        if (i9 * 2 > i3) {
            throw new IllegalArgumentException("Padding(" + (this.tableCellPadding * 2) + ") can't larger than width(" + i3 + ')');
        }
    }

    public final int getTableCellVerticalPadding() {
        return this.tableCellVerticalPadding;
    }

    public final int getTableCellHorizontalPadding() {
        return this.tableCellHorizontalPadding;
    }

    public final void setTableCellHorizontalPadding(int i) {
        this.tableCellHorizontalPadding = i;
    }
}
