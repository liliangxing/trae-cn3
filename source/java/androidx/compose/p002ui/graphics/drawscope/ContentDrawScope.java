package androidx.compose.p002ui.graphics.drawscope;

import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.graphics.ColorFilter;
import androidx.compose.p002ui.graphics.ImageBitmap;
import androidx.compose.p002ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ContentDrawScope.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawContent", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public interface ContentDrawScope extends DrawScope {
    void drawContent();

    /* compiled from: ContentDrawScope.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m5363drawImageAZ2fEMs(ContentDrawScope contentDrawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
            ContentDrawScope.super.mo5319drawImageAZ2fEMs(imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, i2);
        }

        @Deprecated
        /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m5364getCenterF1C5BW0(ContentDrawScope contentDrawScope) {
            return ContentDrawScope.super.m5416getCenterF1C5BW0();
        }

        @Deprecated
        /* renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m5365getSizeNHjbRc(ContentDrawScope contentDrawScope) {
            return ContentDrawScope.super.m5417getSizeNHjbRc();
        }

        @Deprecated
        /* renamed from: record-JVtK1S4, reason: not valid java name */
        public static void m5366recordJVtK1S4(ContentDrawScope contentDrawScope, GraphicsLayer graphicsLayer, long j, Function1<? super DrawScope, Unit> function1) {
            ContentDrawScope.super.m5418recordJVtK1S4(graphicsLayer, j, function1);
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m5367roundToPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.roundToPx--R2X_6o(j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m5368roundToPx0680j_4(ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.roundToPx-0680j_4(f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m5369toDpGaN1DYA(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.toDp-GaN1DYA(j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5370toDpu2uoSUM(ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.toDp-u2uoSUM(f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5371toDpu2uoSUM(ContentDrawScope contentDrawScope, int i) {
            return ContentDrawScope.super.toDp-u2uoSUM(i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m5372toDpSizekrfVVM(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.toDpSize-k-rfVVM(j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m5373toPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.toPx--R2X_6o(j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m5374toPx0680j_4(ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.toPx-0680j_4(f);
        }

        @Deprecated
        public static Rect toRect(ContentDrawScope contentDrawScope, DpRect dpRect) {
            return ContentDrawScope.super.toRect(dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m5375toSizeXkaWNTQ(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.toSize-XkaWNTQ(j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m5376toSp0xMU5do(ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.toSp-0xMU5do(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5377toSpkPz2Gy4(ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.toSp-kPz2Gy4(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5378toSpkPz2Gy4(ContentDrawScope contentDrawScope, int i) {
            return ContentDrawScope.super.toSp-kPz2Gy4(i);
        }
    }
}
