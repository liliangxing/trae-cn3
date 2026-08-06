package com.edu.onetex.latex.icon;

import android.view.View;
import androidx.core.graphics.Insets;
import com.edu.onetex.latex.LaTeXParam;
import com.edu.onetex.latex.graphic.Graphics2D;
import com.edu.onetex.latex.view.ILaTeXView;
import com.edu.onetex.utils.LaTeXLogger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LaTeXIcon.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013J\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0015J\u001e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015J\u0014\u0010\"\u001a\u00020\u000f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u0013J\u000e\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0015J\u0014\u0010&\u001a\u00020\u000f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013J\u000e\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00000\u0013R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/edu/onetex/latex/icon/LaTeXIcon;", "", "nativePtr", "", "latexParam", "Lcom/edu/onetex/latex/LaTeXParam;", "(JLcom/edu/onetex/latex/LaTeXParam;)V", "customViewList", "Ljava/util/LinkedList;", "Landroid/view/View;", "iTexViewList", "Lcom/edu/onetex/latex/view/ILaTeXView;", "getLatexParam", "()Lcom/edu/onetex/latex/LaTeXParam;", "finalize", "", "getBaseLine", "", "getCustomViewList", "", "getHeight", "", "getITeXViewList", "getIconDepth", "getRawContent", "", "getSpeechText", "getTexContent", "getWidth", "paintIcon", "g2", "Lcom/edu/onetex/latex/graphic/Graphics2D;", "x", "y", "setCustomViewList", "list", "setForeground", "color", "setITeXViewList", "setInsets", "insets", "Landroidx/core/graphics/Insets;", "split", "Companion", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class LaTeXIcon {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final LinkedList<View> customViewList;
    private final LinkedList<ILaTeXView> iTexViewList;
    private final LaTeXParam latexParam;
    private volatile long nativePtr;

    public LaTeXIcon(long j, LaTeXParam latexParam) {
        Intrinsics.checkNotNullParameter(latexParam, "latexParam");
        this.nativePtr = j;
        this.latexParam = latexParam;
        this.customViewList = new LinkedList<>();
        this.iTexViewList = new LinkedList<>();
        LaTeXLogger.INSTANCE.d("TeXIcon", "TeXIcon build called!");
    }

    public final LaTeXParam getLatexParam() {
        return this.latexParam;
    }

    public final void setCustomViewList(List<? extends View> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.customViewList.clear();
        this.customViewList.addAll(list);
    }

    public final List<View> getCustomViewList() {
        return this.customViewList;
    }

    public final void setITeXViewList(List<? extends ILaTeXView> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.iTexViewList.clear();
        this.iTexViewList.addAll(list);
    }

    public final List<ILaTeXView> getITeXViewList() {
        return this.iTexViewList;
    }

    public final int getWidth() {
        if (this.nativePtr == 0) {
            return 0;
        }
        return INSTANCE.nGetWidth(this.nativePtr);
    }

    public final int getHeight() {
        if (this.nativePtr == 0) {
            return 0;
        }
        return INSTANCE.nGetHeight(this.nativePtr);
    }

    public final int getIconDepth() {
        if (this.nativePtr == 0) {
            return 0;
        }
        return INSTANCE.nGetIconDepth(this.nativePtr);
    }

    public final double getBaseLine() {
        if (this.nativePtr == 0) {
            return 0.0d;
        }
        return INSTANCE.nGetBaseLine(this.nativePtr);
    }

    public final void setForeground(int color) {
        if (this.nativePtr == 0) {
            return;
        }
        INSTANCE.nSetForeground(this.nativePtr, color);
    }

    public final void paintIcon(Graphics2D g2, int x, int y) {
        Intrinsics.checkNotNullParameter(g2, "g2");
        if (this.nativePtr == 0) {
            return;
        }
        INSTANCE.nPaintIcon(this.nativePtr, g2, x, y);
    }

    public final List<LaTeXIcon> split() {
        if (this.nativePtr == 0) {
            return CollectionsKt.emptyList();
        }
        long[] nSplit = INSTANCE.nSplit(this.nativePtr);
        if (nSplit == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(nSplit.length);
        for (long j : nSplit) {
            arrayList.add(new LaTeXIcon(j, this.latexParam));
        }
        return arrayList;
    }

    public final String getSpeechText() {
        String nGetSpeechText;
        return (this.nativePtr == 0 || (nGetSpeechText = INSTANCE.nGetSpeechText(this.nativePtr)) == null) ? "" : nGetSpeechText;
    }

    public final String getTexContent() {
        String nGetTexContent;
        return (this.nativePtr == 0 || (nGetTexContent = INSTANCE.nGetTexContent(this.nativePtr)) == null) ? "" : nGetTexContent;
    }

    public final String getRawContent() {
        String nGetRawContent;
        return (this.nativePtr == 0 || (nGetRawContent = INSTANCE.nGetRawContent(this.nativePtr)) == null) ? "" : nGetRawContent;
    }

    public final void setInsets(Insets insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (this.nativePtr == 0) {
            return;
        }
        INSTANCE.nSetInsets(this.nativePtr, insets.left, insets.top, insets.right, insets.bottom);
    }

    public final void finalize() {
        LaTeXLogger.INSTANCE.d("TeXIcon", "TeXIcon finalize called!");
        if (this.nativePtr != 0) {
            INSTANCE.nFinalize(this.nativePtr);
            this.nativePtr = 0L;
        }
    }

    /* compiled from: LaTeXIcon.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0016\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0013\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0013\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J)\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0082 J\u0019\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\nH\u0082 J1\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0082 J\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 ¨\u0006\u001f"}, d2 = {"Lcom/edu/onetex/latex/icon/LaTeXIcon$Companion;", "", "()V", "nFinalize", "", "ptr", "", "nGetBaseLine", "", "nGetHeight", "", "nGetIconDepth", "nGetRawContent", "", "nGetSpeechText", "nGetTexContent", "nGetWidth", "nPaintIcon", "g2", "Lcom/edu/onetex/latex/graphic/Graphics2D;", "x", "y", "nSetForeground", "color", "nSetInsets", "left", "top", "right", "bottom", "nSplit", "", "onetex_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class Companion {
        /* JADX INFO: Access modifiers changed from: private */
        public final native void nFinalize(long ptr);

        /* JADX INFO: Access modifiers changed from: private */
        public final native double nGetBaseLine(long ptr);

        /* JADX INFO: Access modifiers changed from: private */
        public final native int nGetHeight(long ptr);

        /* JADX INFO: Access modifiers changed from: private */
        public final native int nGetIconDepth(long ptr);

        /* JADX INFO: Access modifiers changed from: private */
        public final native String nGetRawContent(long ptr);

        /* JADX INFO: Access modifiers changed from: private */
        public final native String nGetSpeechText(long ptr);

        /* JADX INFO: Access modifiers changed from: private */
        public final native String nGetTexContent(long ptr);

        /* JADX INFO: Access modifiers changed from: private */
        public final native int nGetWidth(long ptr);

        /* JADX INFO: Access modifiers changed from: private */
        public final native void nPaintIcon(long ptr, Graphics2D g2, int x, int y);

        /* JADX INFO: Access modifiers changed from: private */
        public final native void nSetForeground(long ptr, int color);

        /* JADX INFO: Access modifiers changed from: private */
        public final native void nSetInsets(long ptr, int left, int top, int right, int bottom);

        /* JADX INFO: Access modifiers changed from: private */
        public final native long[] nSplit(long ptr);

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
