package com.github.alexzhirkevich.customqrgenerator.dsl;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.alexzhirkevich.customqrgenerator.style.QrCanvasShape;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DslExtensions.kt */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.github.alexzhirkevich.customqrgenerator.dsl.DslExtensionsKt$sam$com_github_alexzhirkevich_customqrgenerator_style_QrCanvasShape$0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class C0395xcaafd69f implements QrCanvasShape, FunctionAdapter {
    private final /* synthetic */ Function3 function;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0395xcaafd69f(Function3 function3) {
        this.function = function3;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.QrCanvasShape
    public final /* synthetic */ void draw(Canvas canvas, Paint paint, Paint paint2) {
        this.function.invoke(canvas, paint, paint2);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof QrCanvasShape) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }
}
