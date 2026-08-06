package org.jetbrains.compose.resources;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Trace;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageResources.android.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\n\u001a\f\u0010\u000b\u001a\u00020\u0006*\u00020\fH\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\fH\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u0015\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0013"}, d2 = {"painterResource", "Landroidx/compose/ui/graphics/painter/Painter;", "resource", "Lorg/jetbrains/compose/resources/DrawableResource;", "(Lorg/jetbrains/compose/resources/DrawableResource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "imageResource", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Lorg/jetbrains/compose/resources/DrawableResource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/ImageBitmap;", "vectorResource", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Lorg/jetbrains/compose/resources/DrawableResource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/ImageVector;", "toImageBitmap", "", "toSvgElement", "Lorg/jetbrains/compose/resources/SvgElement;", "toSvgPainter", "density", "Landroidx/compose/ui/unit/Density;", "svgPainter", "library_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes9.dex */
public final class ImageResources_androidKt {
    public static final Painter painterResource(DrawableResource drawableResource, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(drawableResource, "resource");
        composer.startReplaceableGroup(357952552);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(357952552, i, -1, "org.jetbrains.compose.resources.painterResource (ImageResources.android.kt:22)");
        }
        Trace.beginSection("composeResource.painterResource");
        try {
            Painter painterResource = PainterResources_androidKt.painterResource(drawableResource.getId(), composer, 0);
            Trace.endSection();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return painterResource;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public static final ImageBitmap imageResource(DrawableResource drawableResource, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(drawableResource, "resource");
        composer.startReplaceableGroup(2132450105);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2132450105, i, -1, "org.jetbrains.compose.resources.imageResource (ImageResources.android.kt:29)");
        }
        Trace.beginSection("composeResource.imageResource");
        try {
            ImageBitmap imageResource = androidx.compose.ui.res.ImageResources_androidKt.imageResource(ImageBitmap.Companion, drawableResource.getId(), composer, 6);
            Trace.endSection();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return imageResource;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public static final ImageVector vectorResource(DrawableResource drawableResource, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(drawableResource, "resource");
        composer.startReplaceableGroup(-868966295);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-868966295, i, -1, "org.jetbrains.compose.resources.vectorResource (ImageResources.android.kt:36)");
        }
        Trace.beginSection("composeResource.vectorResource");
        try {
            ImageVector vectorResource = VectorResources_androidKt.vectorResource(ImageVector.Companion, drawableResource.getId(), composer, 6);
            Trace.endSection();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return vectorResource;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public static final ImageBitmap toImageBitmap(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        Intrinsics.checkNotNullExpressionValue(decodeByteArray, "decodeByteArray(...)");
        return AndroidImageBitmap_androidKt.asImageBitmap(decodeByteArray);
    }

    public static final SvgElement toSvgElement(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        throw new IllegalStateException("Android platform doesn't support SVG format.".toString());
    }

    public static final Painter toSvgPainter(SvgElement svgElement, Density density) {
        Intrinsics.checkNotNullParameter(svgElement, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        throw new IllegalStateException("Android platform doesn't support SVG format.".toString());
    }

    public static final Painter svgPainter(DrawableResource drawableResource, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(drawableResource, "resource");
        composer.startReplaceableGroup(-1489050030);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1489050030, i, -1, "org.jetbrains.compose.resources.svgPainter (ImageResources.android.kt:56)");
        }
        throw new IllegalStateException("Android platform doesn't support SVG format.".toString());
    }
}
