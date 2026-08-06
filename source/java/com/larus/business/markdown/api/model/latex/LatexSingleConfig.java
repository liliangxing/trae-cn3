package com.larus.business.markdown.api.model.latex;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LatexSingleConfig.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/larus/business/markdown/api/model/latex/LatexSingleConfig;", "", "latexTextSize", "", "latexTextColor", "", "(FI)V", "getLatexTextColor", "()I", "getLatexTextSize", "()F", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class LatexSingleConfig {
    private final int latexTextColor;
    private final float latexTextSize;

    public LatexSingleConfig() {
        this(0.0f, 0, 3, null);
    }

    public static /* synthetic */ LatexSingleConfig copy$default(LatexSingleConfig latexSingleConfig, float f, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = latexSingleConfig.latexTextSize;
        }
        if ((i2 & 2) != 0) {
            i = latexSingleConfig.latexTextColor;
        }
        return latexSingleConfig.copy(f, i);
    }

    /* renamed from: component1, reason: from getter */
    public final float getLatexTextSize() {
        return this.latexTextSize;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLatexTextColor() {
        return this.latexTextColor;
    }

    public final LatexSingleConfig copy(float latexTextSize, int latexTextColor) {
        return new LatexSingleConfig(latexTextSize, latexTextColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LatexSingleConfig)) {
            return false;
        }
        LatexSingleConfig latexSingleConfig = (LatexSingleConfig) other;
        return Float.compare(this.latexTextSize, latexSingleConfig.latexTextSize) == 0 && this.latexTextColor == latexSingleConfig.latexTextColor;
    }

    public int hashCode() {
        return (Float.hashCode(this.latexTextSize) * 31) + Integer.hashCode(this.latexTextColor);
    }

    public String toString() {
        return "LatexSingleConfig(latexTextSize=" + this.latexTextSize + ", latexTextColor=" + this.latexTextColor + ')';
    }

    public LatexSingleConfig(float f, int i) {
        this.latexTextSize = f;
        this.latexTextColor = i;
    }

    public /* synthetic */ LatexSingleConfig(float f, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 48.0f : f, (i2 & 2) != 0 ? -16776961 : i);
    }

    public final float getLatexTextSize() {
        return this.latexTextSize;
    }

    public final int getLatexTextColor() {
        return this.latexTextColor;
    }
}
