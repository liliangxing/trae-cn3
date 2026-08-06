package androidx.compose.animation;

import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p002ui.graphics.GraphicsLayerScope;
import androidx.compose.p002ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SkipToLookaheadNode.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"DefaultEnabled", "Lkotlin/Function0;", "", "createContentScaleModifier", "Landroidx/compose/ui/Modifier;", "scaleToBounds", "Landroidx/compose/animation/ScaleToBoundsImpl;", "isEnabled", "animation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SkipToLookaheadNodeKt {
    private static final Function0<Boolean> DefaultEnabled = new Function0<Boolean>() { // from class: androidx.compose.animation.SkipToLookaheadNodeKt$DefaultEnabled$1
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m258invoke() {
            return true;
        }
    };

    public static final Modifier createContentScaleModifier(Modifier modifier, ScaleToBoundsImpl scaleToBoundsImpl, final Function0<Boolean> function0) {
        Modifier.Companion companion;
        if (Intrinsics.areEqual(scaleToBoundsImpl.getContentScale(), ContentScale.INSTANCE.getCrop())) {
            companion = GraphicsLayerModifierKt.graphicsLayer(Modifier.INSTANCE, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.SkipToLookaheadNodeKt$createContentScaleModifier$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((GraphicsLayerScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                    graphicsLayerScope.setClip(((Boolean) function0.invoke()).booleanValue());
                }
            });
        } else {
            companion = Modifier.INSTANCE;
        }
        return modifier.then(companion).then((Modifier) new SkipToLookaheadElement(scaleToBoundsImpl, function0));
    }
}
