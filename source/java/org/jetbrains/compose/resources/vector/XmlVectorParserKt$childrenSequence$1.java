package org.jetbrains.compose.resources.vector;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import org.jetbrains.compose.resources.vector.xmldom.Element;
import org.jetbrains.compose.resources.vector.xmldom.Node;

/* compiled from: XmlVectorParser.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lorg/jetbrains/compose/resources/vector/xmldom/Node;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "org.jetbrains.compose.resources.vector.XmlVectorParserKt$childrenSequence$1", f = "XmlVectorParser.kt", i = {0, 0}, l = {272}, m = "invokeSuspend", n = {"$this$sequence", "i"}, s = {"L$0", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes9.dex */
final class XmlVectorParserKt$childrenSequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Node>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Element $this_childrenSequence;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XmlVectorParserKt$childrenSequence$1(Element element, Continuation<? super XmlVectorParserKt$childrenSequence$1> continuation) {
        super(2, continuation);
        this.$this_childrenSequence = element;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> xmlVectorParserKt$childrenSequence$1 = new XmlVectorParserKt$childrenSequence$1(this.$this_childrenSequence, continuation);
        xmlVectorParserKt$childrenSequence$1.L$0 = obj;
        return xmlVectorParserKt$childrenSequence$1;
    }

    public final Object invoke(SequenceScope<? super Node> sequenceScope, Continuation<? super Unit> continuation) {
        return create(sequenceScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0036  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x004f -> B:5:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int length;
        int i;
        SequenceScope sequenceScope;
        XmlVectorParserKt$childrenSequence$1 xmlVectorParserKt$childrenSequence$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
            length = this.$this_childrenSequence.getChildNodes().getLength();
            i = 0;
            sequenceScope = sequenceScope2;
            xmlVectorParserKt$childrenSequence$1 = this;
            if (i < length) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            length = this.I$1;
            i = this.I$0;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            xmlVectorParserKt$childrenSequence$1 = this;
            i++;
            if (i < length) {
                xmlVectorParserKt$childrenSequence$1.L$0 = sequenceScope;
                xmlVectorParserKt$childrenSequence$1.I$0 = i;
                xmlVectorParserKt$childrenSequence$1.I$1 = length;
                xmlVectorParserKt$childrenSequence$1.label = 1;
                if (sequenceScope.yield(xmlVectorParserKt$childrenSequence$1.$this_childrenSequence.getChildNodes().item(i), (Continuation) xmlVectorParserKt$childrenSequence$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i++;
                if (i < length) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
