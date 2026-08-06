package kotlinx.datetime.internal.format.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.BuildConfig;

/* compiled from: Parser.kt */
@Metadata(m4d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0003H\u0000\u001a\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0002¨\u0006\b"}, m5d2 = {"concat", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "T", BuildConfig.FLAVOR, "formatError", BuildConfig.FLAVOR, "errors", "Lkotlinx/datetime/internal/format/parser/ParseError;", "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ParserKt {
    private static final <T> ParserStructure<T> concat$append(ParserStructure<? super T> parserStructure, ParserStructure<? super T> parserStructure2) {
        if (parserStructure.getFollowedBy().isEmpty()) {
            return new ParserStructure<>(CollectionsKt.plus((Collection) parserStructure.getOperations(), (Iterable) parserStructure2.getOperations()), parserStructure2.getFollowedBy());
        }
        List<ParserOperation<? super T>> operations = parserStructure.getOperations();
        List<ParserStructure<? super T>> followedBy = parserStructure.getFollowedBy();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(followedBy, 10));
        Iterator<T> it = followedBy.iterator();
        while (it.hasNext()) {
            arrayList.add(concat$append((ParserStructure) it.next(), parserStructure2));
        }
        return new ParserStructure<>(operations, arrayList);
    }

    private static final <T> ParserStructure<T> concat$simplify(ParserStructure<? super T> parserStructure, List<UnconditionalModification<T>> list) {
        boolean z;
        ParserStructure parserStructure2;
        List listOf;
        ArrayList arrayList = new ArrayList();
        List mutableList = CollectionsKt.toMutableList((Collection) list);
        List list2 = null;
        for (ParserOperation<? super T> parserOperation : parserStructure.getOperations()) {
            if (parserOperation instanceof NumberSpanParserOperation) {
                if (list2 != null) {
                    list2.addAll(((NumberSpanParserOperation) parserOperation).getConsumers());
                } else {
                    list2 = CollectionsKt.toMutableList((Collection) ((NumberSpanParserOperation) parserOperation).getConsumers());
                }
            } else if (parserOperation instanceof UnconditionalModification) {
                mutableList.add(parserOperation);
            } else {
                if (list2 != null) {
                    arrayList.add(new NumberSpanParserOperation(list2));
                    list2 = null;
                }
                arrayList.add(parserOperation);
            }
        }
        List<ParserStructure<? super T>> followedBy = parserStructure.getFollowedBy();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = followedBy.iterator();
        while (it.hasNext()) {
            ParserStructure concat$simplify = concat$simplify((ParserStructure) it.next(), mutableList);
            if (concat$simplify.getOperations().isEmpty()) {
                List followedBy2 = concat$simplify.getFollowedBy();
                if (followedBy2.isEmpty()) {
                    followedBy2 = CollectionsKt.listOf(concat$simplify);
                }
                listOf = followedBy2;
            } else {
                listOf = CollectionsKt.listOf(concat$simplify);
            }
            CollectionsKt.addAll(arrayList2, listOf);
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            arrayList3 = CollectionsKt.listOf(new ParserStructure(mutableList, CollectionsKt.emptyList()));
        }
        List list3 = arrayList3;
        if (list2 == null) {
            return new ParserStructure<>(arrayList, list3);
        }
        List<ParserStructure> list4 = list3;
        if (!(list4 instanceof Collection) || !list4.isEmpty()) {
            Iterator<T> it2 = list4.iterator();
            while (it2.hasNext()) {
                ParserOperation parserOperation2 = (ParserOperation) CollectionsKt.firstOrNull(((ParserStructure) it2.next()).getOperations());
                z = false;
                if (parserOperation2 != null && (parserOperation2 instanceof NumberSpanParserOperation)) {
                    break;
                }
            }
        }
        z = true;
        if (z) {
            arrayList.add(new NumberSpanParserOperation(list2));
            return new ParserStructure<>(arrayList, list3);
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        for (ParserStructure parserStructure3 : list4) {
            ParserOperation parserOperation3 = (ParserOperation) CollectionsKt.firstOrNull(parserStructure3.getOperations());
            if (parserOperation3 instanceof NumberSpanParserOperation) {
                parserStructure2 = new ParserStructure(CollectionsKt.plus((Collection) CollectionsKt.listOf(new NumberSpanParserOperation(CollectionsKt.plus((Collection) list2, (Iterable) ((NumberSpanParserOperation) parserOperation3).getConsumers()))), (Iterable) CollectionsKt.drop(parserStructure3.getOperations(), 1)), parserStructure3.getFollowedBy());
            } else if (parserOperation3 == null) {
                parserStructure2 = new ParserStructure(CollectionsKt.listOf(new NumberSpanParserOperation(list2)), parserStructure3.getFollowedBy());
            } else {
                parserStructure2 = new ParserStructure(CollectionsKt.plus((Collection) CollectionsKt.listOf(new NumberSpanParserOperation(list2)), (Iterable) parserStructure3.getOperations()), parserStructure3.getFollowedBy());
            }
            arrayList4.add(parserStructure2);
        }
        return new ParserStructure<>(arrayList, arrayList4);
    }

    public static final <T> ParserStructure<T> concat(List<? extends ParserStructure<? super T>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ParserStructure parserStructure = new ParserStructure(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        if (!list.isEmpty()) {
            ListIterator<? extends ParserStructure<? super T>> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                parserStructure = concat$append(listIterator.previous(), parserStructure);
            }
        }
        return concat$simplify(parserStructure, CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatError(List<ParseError> list) {
        Appendable joinTo;
        if (list.size() == 1) {
            return "Position " + list.get(0).getPosition() + ": " + list.get(0).getMessage().invoke();
        }
        joinTo = CollectionsKt.joinTo(list, new StringBuilder(list.size() * 33), (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? BuildConfig.FLAVOR : "Errors: ", (r14 & 8) != 0 ? BuildConfig.FLAVOR : null, (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : new Function1() { // from class: kotlinx.datetime.internal.format.parser.ParserKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence formatError$lambda$8;
                formatError$lambda$8 = ParserKt.formatError$lambda$8((ParseError) obj);
                return formatError$lambda$8;
            }
        });
        String sb = ((StringBuilder) joinTo).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence formatError$lambda$8(ParseError it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "position " + it.getPosition() + ": '" + it.getMessage().invoke() + '\'';
    }
}
