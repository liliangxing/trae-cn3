package com.larus.business.markdown.api.model.latex;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.forest.model.PreloadConfig;
import com.larus.business.markdown.api.depend.OnLatexUrlCallBack;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LatexGlobalConfig.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001BÃ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f\u0012:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fHÆ\u0003J;\u00107\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000eHÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003JÇ\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0003HÆ\u0001J\u0013\u0010:\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0003HÖ\u0001J\t\u0010=\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u001eR\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&RC\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006>"}, d2 = {"Lcom/larus/business/markdown/api/model/latex/LatexGlobalConfig;", "", "markdownLatexPatternStrategy", "", "enableMarkdownLatexOpt", "", "customizedSingleDollarLatexPattern", "", "disableLatexSplit", "enableLatexSplitOptimize", "enableLatexFallback", "unSupportLatexCommandList", "", "latexFallbackAbility", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "latex", "Lcom/larus/business/markdown/api/depend/OnLatexUrlCallBack;", JsCallParser.VALUE_CALLBACK, "", "enableBlockLatex", "isDisableLatex", "enableLatexNewCommand", "enableUseLatexBitmapCache", "latexBitmapCacheSize", "(IZLjava/lang/String;ZZZLjava/util/List;Lkotlin/jvm/functions/Function2;ZZZZI)V", "getCustomizedSingleDollarLatexPattern", "()Ljava/lang/String;", "getDisableLatexSplit", "()Z", "getEnableBlockLatex", "getEnableLatexFallback", "getEnableLatexNewCommand", "getEnableLatexSplitOptimize", "getEnableMarkdownLatexOpt", "getEnableUseLatexBitmapCache", "getLatexBitmapCacheSize", "()I", "getLatexFallbackAbility", "()Lkotlin/jvm/functions/Function2;", "getMarkdownLatexPatternStrategy", "getUnSupportLatexCommandList", "()Ljava/util/List;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class LatexGlobalConfig {
    private final String customizedSingleDollarLatexPattern;
    private final boolean disableLatexSplit;
    private final boolean enableBlockLatex;
    private final boolean enableLatexFallback;
    private final boolean enableLatexNewCommand;
    private final boolean enableLatexSplitOptimize;
    private final boolean enableMarkdownLatexOpt;
    private final boolean enableUseLatexBitmapCache;
    private final boolean isDisableLatex;
    private final int latexBitmapCacheSize;
    private final Function2<String, OnLatexUrlCallBack, Unit> latexFallbackAbility;
    private final int markdownLatexPatternStrategy;
    private final List<String> unSupportLatexCommandList;

    public LatexGlobalConfig() {
        this(0, false, null, false, false, false, null, null, false, false, false, false, 0, 8191, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMarkdownLatexPatternStrategy() {
        return this.markdownLatexPatternStrategy;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsDisableLatex() {
        return this.isDisableLatex;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getEnableLatexNewCommand() {
        return this.enableLatexNewCommand;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getEnableUseLatexBitmapCache() {
        return this.enableUseLatexBitmapCache;
    }

    /* renamed from: component13, reason: from getter */
    public final int getLatexBitmapCacheSize() {
        return this.latexBitmapCacheSize;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getEnableMarkdownLatexOpt() {
        return this.enableMarkdownLatexOpt;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCustomizedSingleDollarLatexPattern() {
        return this.customizedSingleDollarLatexPattern;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getDisableLatexSplit() {
        return this.disableLatexSplit;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getEnableLatexSplitOptimize() {
        return this.enableLatexSplitOptimize;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getEnableLatexFallback() {
        return this.enableLatexFallback;
    }

    public final List<String> component7() {
        return this.unSupportLatexCommandList;
    }

    public final Function2<String, OnLatexUrlCallBack, Unit> component8() {
        return this.latexFallbackAbility;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getEnableBlockLatex() {
        return this.enableBlockLatex;
    }

    public final LatexGlobalConfig copy(int markdownLatexPatternStrategy, boolean enableMarkdownLatexOpt, String customizedSingleDollarLatexPattern, boolean disableLatexSplit, boolean enableLatexSplitOptimize, boolean enableLatexFallback, List<String> unSupportLatexCommandList, Function2<? super String, ? super OnLatexUrlCallBack, Unit> latexFallbackAbility, boolean enableBlockLatex, boolean isDisableLatex, boolean enableLatexNewCommand, boolean enableUseLatexBitmapCache, int latexBitmapCacheSize) {
        return new LatexGlobalConfig(markdownLatexPatternStrategy, enableMarkdownLatexOpt, customizedSingleDollarLatexPattern, disableLatexSplit, enableLatexSplitOptimize, enableLatexFallback, unSupportLatexCommandList, latexFallbackAbility, enableBlockLatex, isDisableLatex, enableLatexNewCommand, enableUseLatexBitmapCache, latexBitmapCacheSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LatexGlobalConfig)) {
            return false;
        }
        LatexGlobalConfig latexGlobalConfig = (LatexGlobalConfig) other;
        return this.markdownLatexPatternStrategy == latexGlobalConfig.markdownLatexPatternStrategy && this.enableMarkdownLatexOpt == latexGlobalConfig.enableMarkdownLatexOpt && Intrinsics.areEqual(this.customizedSingleDollarLatexPattern, latexGlobalConfig.customizedSingleDollarLatexPattern) && this.disableLatexSplit == latexGlobalConfig.disableLatexSplit && this.enableLatexSplitOptimize == latexGlobalConfig.enableLatexSplitOptimize && this.enableLatexFallback == latexGlobalConfig.enableLatexFallback && Intrinsics.areEqual(this.unSupportLatexCommandList, latexGlobalConfig.unSupportLatexCommandList) && Intrinsics.areEqual(this.latexFallbackAbility, latexGlobalConfig.latexFallbackAbility) && this.enableBlockLatex == latexGlobalConfig.enableBlockLatex && this.isDisableLatex == latexGlobalConfig.isDisableLatex && this.enableLatexNewCommand == latexGlobalConfig.enableLatexNewCommand && this.enableUseLatexBitmapCache == latexGlobalConfig.enableUseLatexBitmapCache && this.latexBitmapCacheSize == latexGlobalConfig.latexBitmapCacheSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = Integer.hashCode(this.markdownLatexPatternStrategy) * 31;
        boolean z = this.enableMarkdownLatexOpt;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        String str = this.customizedSingleDollarLatexPattern;
        int hashCode2 = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z2 = this.disableLatexSplit;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (hashCode2 + i3) * 31;
        boolean z3 = this.enableLatexSplitOptimize;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z4 = this.enableLatexFallback;
        int i7 = z4;
        if (z4 != 0) {
            i7 = 1;
        }
        int i8 = (i6 + i7) * 31;
        List<String> list = this.unSupportLatexCommandList;
        int hashCode3 = (i8 + (list == null ? 0 : list.hashCode())) * 31;
        Function2<String, OnLatexUrlCallBack, Unit> function2 = this.latexFallbackAbility;
        int hashCode4 = (hashCode3 + (function2 != null ? function2.hashCode() : 0)) * 31;
        boolean z5 = this.enableBlockLatex;
        int i9 = z5;
        if (z5 != 0) {
            i9 = 1;
        }
        int i10 = (hashCode4 + i9) * 31;
        boolean z6 = this.isDisableLatex;
        int i11 = z6;
        if (z6 != 0) {
            i11 = 1;
        }
        int i12 = (i10 + i11) * 31;
        boolean z7 = this.enableLatexNewCommand;
        int i13 = z7;
        if (z7 != 0) {
            i13 = 1;
        }
        int i14 = (i12 + i13) * 31;
        boolean z8 = this.enableUseLatexBitmapCache;
        return ((i14 + (z8 ? 1 : z8 ? 1 : 0)) * 31) + Integer.hashCode(this.latexBitmapCacheSize);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LatexGlobalConfig(markdownLatexPatternStrategy=");
        sb.append(this.markdownLatexPatternStrategy).append(", enableMarkdownLatexOpt=").append(this.enableMarkdownLatexOpt).append(", customizedSingleDollarLatexPattern=").append(this.customizedSingleDollarLatexPattern).append(", disableLatexSplit=").append(this.disableLatexSplit).append(", enableLatexSplitOptimize=").append(this.enableLatexSplitOptimize).append(", enableLatexFallback=").append(this.enableLatexFallback).append(", unSupportLatexCommandList=").append(this.unSupportLatexCommandList).append(", latexFallbackAbility=").append(this.latexFallbackAbility).append(", enableBlockLatex=").append(this.enableBlockLatex).append(", isDisableLatex=").append(this.isDisableLatex).append(", enableLatexNewCommand=").append(this.enableLatexNewCommand).append(", enableUseLatexBitmapCache=");
        sb.append(this.enableUseLatexBitmapCache).append(", latexBitmapCacheSize=").append(this.latexBitmapCacheSize).append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LatexGlobalConfig(int i, boolean z, String str, boolean z2, boolean z3, boolean z4, List<String> list, Function2<? super String, ? super OnLatexUrlCallBack, Unit> function2, boolean z5, boolean z6, boolean z7, boolean z8, int i2) {
        this.markdownLatexPatternStrategy = i;
        this.enableMarkdownLatexOpt = z;
        this.customizedSingleDollarLatexPattern = str;
        this.disableLatexSplit = z2;
        this.enableLatexSplitOptimize = z3;
        this.enableLatexFallback = z4;
        this.unSupportLatexCommandList = list;
        this.latexFallbackAbility = function2;
        this.enableBlockLatex = z5;
        this.isDisableLatex = z6;
        this.enableLatexNewCommand = z7;
        this.enableUseLatexBitmapCache = z8;
        this.latexBitmapCacheSize = i2;
    }

    public /* synthetic */ LatexGlobalConfig(int i, boolean z, String str, boolean z2, boolean z3, boolean z4, List list, Function2 function2, boolean z5, boolean z6, boolean z7, boolean z8, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? false : z3, (i3 & 32) != 0 ? false : z4, (i3 & 64) != 0 ? null : list, (i3 & 128) == 0 ? function2 : null, (i3 & 256) != 0 ? true : z5, (i3 & 512) != 0 ? false : z6, (i3 & 1024) != 0 ? false : z7, (i3 & 2048) != 0 ? false : z8, (i3 & 4096) == 0 ? i2 : 0);
    }

    public final int getMarkdownLatexPatternStrategy() {
        return this.markdownLatexPatternStrategy;
    }

    public final boolean getEnableMarkdownLatexOpt() {
        return this.enableMarkdownLatexOpt;
    }

    public final String getCustomizedSingleDollarLatexPattern() {
        return this.customizedSingleDollarLatexPattern;
    }

    public final boolean getDisableLatexSplit() {
        return this.disableLatexSplit;
    }

    public final boolean getEnableLatexSplitOptimize() {
        return this.enableLatexSplitOptimize;
    }

    public final boolean getEnableLatexFallback() {
        return this.enableLatexFallback;
    }

    public final List<String> getUnSupportLatexCommandList() {
        return this.unSupportLatexCommandList;
    }

    public final Function2<String, OnLatexUrlCallBack, Unit> getLatexFallbackAbility() {
        return this.latexFallbackAbility;
    }

    public final boolean getEnableBlockLatex() {
        return this.enableBlockLatex;
    }

    public final boolean isDisableLatex() {
        return this.isDisableLatex;
    }

    public final boolean getEnableLatexNewCommand() {
        return this.enableLatexNewCommand;
    }

    public final boolean getEnableUseLatexBitmapCache() {
        return this.enableUseLatexBitmapCache;
    }

    public final int getLatexBitmapCacheSize() {
        return this.latexBitmapCacheSize;
    }
}
