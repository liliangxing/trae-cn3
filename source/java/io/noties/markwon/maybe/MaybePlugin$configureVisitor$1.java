package io.noties.markwon.maybe;

import io.noties.markwon.MarkwonVisitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: MaybePlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0019\u0010\u0007\u001a\u0015\u0012\u0002\b\u00030\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "p1", "Lio/noties/markwon/MarkwonVisitor;", "Lkotlin/ParameterName;", "name", "visitor", "p2", "Lio/noties/markwon/maybe/MaybeNode;", "node", "invoke"}, k = 3, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final /* synthetic */ class MaybePlugin$configureVisitor$1 extends FunctionReference implements Function2<MarkwonVisitor, MaybeNode<?>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MaybePlugin$configureVisitor$1(MaybePlugin maybePlugin) {
        super(2, maybePlugin);
    }

    public final String getName() {
        return "visitMaybe";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(MaybePlugin.class);
    }

    public final String getSignature() {
        return "visitMaybe(Lio/noties/markwon/MarkwonVisitor;Lio/noties/markwon/maybe/MaybeNode;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((MarkwonVisitor) obj, (MaybeNode<?>) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(MarkwonVisitor markwonVisitor, MaybeNode<?> maybeNode) {
        Intrinsics.checkParameterIsNotNull(markwonVisitor, "p1");
        Intrinsics.checkParameterIsNotNull(maybeNode, "p2");
        ((MaybePlugin) this.receiver).visitMaybe(markwonVisitor, maybeNode);
    }
}
