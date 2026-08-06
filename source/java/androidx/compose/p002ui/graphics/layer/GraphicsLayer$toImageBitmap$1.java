package androidx.compose.p002ui.graphics.layer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidGraphicsLayer.android.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.graphics.layer.GraphicsLayer", f = "AndroidGraphicsLayer.android.kt", i = {}, l = {869}, m = "toImageBitmap", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class GraphicsLayer$toImageBitmap$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GraphicsLayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GraphicsLayer$toImageBitmap$1(GraphicsLayer graphicsLayer, Continuation<? super GraphicsLayer$toImageBitmap$1> continuation) {
        super(continuation);
        this.this$0 = graphicsLayer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.toImageBitmap((Continuation) this);
    }
}
