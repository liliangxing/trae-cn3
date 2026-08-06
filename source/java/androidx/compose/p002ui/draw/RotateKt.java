package androidx.compose.p002ui.draw;

import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.GraphicsLayerModifierKt;
import kotlin.Metadata;

/* compiled from: Rotate.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"rotate", "Landroidx/compose/ui/Modifier;", "degrees", "", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class RotateKt {
    public static final Modifier rotate(Modifier modifier, float f) {
        return !((f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) == 0) ? GraphicsLayerModifierKt.m5006graphicsLayer_6ThJ44$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 0, null, 524031, null) : modifier;
    }
}
