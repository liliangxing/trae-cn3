package com.github.alexzhirkevich.customqrgenerator.style;

import android.graphics.Path;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrShapeModifierFromPath.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B$\u0012\u001d\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJ)\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0002R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\nX\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifierFromPath;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "path", "Lkotlin/Function2;", "Landroid/graphics/Path;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)V", "cache", "", "invoke", "", RXScreenCaptureService.KEY_INDEX, "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class QrShapeModifierFromPath implements QrShapeModifier {
    private final Map<Integer, Path> cache;
    private final Function2<Path, Integer, Unit> path;

    /* JADX WARN: Multi-variable type inference failed */
    public QrShapeModifierFromPath(Function2<? super Path, ? super Integer, Unit> path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.cache = new ConcurrentHashMap();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
    public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
        Intrinsics.checkNotNullParameter(neighbors, "neighbors");
        Path path = this.cache.get(Integer.valueOf(elementSize));
        if (path == null) {
            path = new Path();
            this.path.invoke(path, Integer.valueOf(elementSize));
            this.cache.put(Integer.valueOf(elementSize), path);
        }
        Path path2 = new Path();
        float f = i;
        float f2 = j;
        path2.addRect(f, f2, f + 0.49f, f2 + 0.49f, Path.Direction.CW);
        new Path().op(path, path2, Path.Op.INTERSECT);
        return !r7.isEmpty();
    }
}
