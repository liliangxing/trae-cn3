package kotlinx.datetime.internal.format.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.format.parser.StringSetParserOperation;
import net.openid.appauth.BuildConfig;

/* compiled from: ParserOperation.kt */
@Metadata(m4d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0016B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m5d2 = {"Lkotlinx/datetime/internal/format/parser/StringSetParserOperation;", "Output", "Lkotlinx/datetime/internal/format/parser/ParserOperation;", "strings", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "setter", "Lkotlinx/datetime/internal/format/parser/AssignableField;", "whatThisExpects", "<init>", "(Ljava/util/Collection;Lkotlinx/datetime/internal/format/parser/AssignableField;Ljava/lang/String;)V", "trie", "Lkotlinx/datetime/internal/format/parser/StringSetParserOperation$TrieNode;", "consume", "Lkotlinx/datetime/internal/format/parser/ParseResult;", "storage", "input", BuildConfig.FLAVOR, "startIndex", BuildConfig.FLAVOR, "consume-FANa98k", "(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;", "TrieNode", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class StringSetParserOperation<Output> implements ParserOperation<Output> {
    private final AssignableField<Output, String> setter;
    private final TrieNode trie;
    private final String whatThisExpects;

    /* JADX WARN: Multi-variable type inference failed */
    public StringSetParserOperation(Collection<String> strings, AssignableField<? super Output, String> setter, String whatThisExpects) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(whatThisExpects, "whatThisExpects");
        this.setter = setter;
        this.whatThisExpects = whatThisExpects;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        boolean z = false;
        int i = 3;
        this.trie = new TrieNode(null, z, i, 0 == true ? 1 : 0);
        for (String str : strings) {
            if ((str.length() > 0) == false) {
                throw new IllegalArgumentException(("Found an empty string in " + this.whatThisExpects).toString());
            }
            TrieNode trieNode = this.trie;
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                List<Pair<String, TrieNode>> children = trieNode.getChildren();
                final String valueOf = String.valueOf(charAt);
                int binarySearch = CollectionsKt.binarySearch(children, 0, children.size(), new Function1<Pair<? extends String, ? extends TrieNode>, Integer>() { // from class: kotlinx.datetime.internal.format.parser.StringSetParserOperation$special$$inlined$binarySearchBy$default$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Integer invoke(Pair<? extends String, ? extends StringSetParserOperation.TrieNode> pair) {
                        return Integer.valueOf(ComparisonsKt.compareValues(pair.getFirst(), valueOf));
                    }
                });
                if (binarySearch < 0) {
                    TrieNode trieNode2 = new TrieNode(objArr2 == true ? 1 : 0, z, i, objArr == true ? 1 : 0);
                    trieNode.getChildren().add((-binarySearch) - 1, TuplesKt.m12to(String.valueOf(charAt), trieNode2));
                    trieNode = trieNode2;
                } else {
                    trieNode = trieNode.getChildren().get(binarySearch).getSecond();
                }
            }
            if (!(!trieNode.getIsTerminal())) {
                throw new IllegalArgumentException(("The string '" + str + "' was passed several times").toString());
            }
            trieNode.setTerminal(true);
        }
        _init_$reduceTrie(this.trie);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ParserOperation.kt */
    @Metadata(m4d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00000\u00040\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00000\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m5d2 = {"Lkotlinx/datetime/internal/format/parser/StringSetParserOperation$TrieNode;", BuildConfig.FLAVOR, "children", BuildConfig.FLAVOR, "Lkotlin/Pair;", BuildConfig.FLAVOR, "isTerminal", BuildConfig.FLAVOR, "<init>", "(Ljava/util/List;Z)V", "getChildren", "()Ljava/util/List;", "()Z", "setTerminal", "(Z)V", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class TrieNode {
        private final List<Pair<String, TrieNode>> children;
        private boolean isTerminal;

        /* JADX WARN: Multi-variable type inference failed */
        public TrieNode() {
            this(null, false, 3, 0 == true ? 1 : 0);
        }

        public TrieNode(List<Pair<String, TrieNode>> children, boolean z) {
            Intrinsics.checkNotNullParameter(children, "children");
            this.children = children;
            this.isTerminal = z;
        }

        public /* synthetic */ TrieNode(ArrayList arrayList, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? false : z);
        }

        public final List<Pair<String, TrieNode>> getChildren() {
            return this.children;
        }

        /* renamed from: isTerminal, reason: from getter */
        public final boolean getIsTerminal() {
            return this.isTerminal;
        }

        public final void setTerminal(boolean z) {
            this.isTerminal = z;
        }
    }

    private static final void _init_$reduceTrie(TrieNode trieNode) {
        Iterator<Pair<String, TrieNode>> it = trieNode.getChildren().iterator();
        while (it.hasNext()) {
            _init_$reduceTrie(it.next().component2());
        }
        ArrayList arrayList = new ArrayList();
        for (Pair<String, TrieNode> pair : trieNode.getChildren()) {
            String component1 = pair.component1();
            TrieNode component2 = pair.component2();
            if (!component2.getIsTerminal() && component2.getChildren().size() == 1) {
                Pair pair2 = (Pair) CollectionsKt.single((List) component2.getChildren());
                arrayList.add(TuplesKt.m12to(component1 + ((String) pair2.component1()), (TrieNode) pair2.component2()));
            } else {
                arrayList.add(TuplesKt.m12to(component1, component2));
            }
        }
        trieNode.getChildren().clear();
        trieNode.getChildren().addAll(CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: kotlinx.datetime.internal.format.parser.StringSetParserOperation$_init_$reduceTrie$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((String) ((Pair) t).getFirst(), (String) ((Pair) t2).getFirst());
            }
        }));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0052, code lost:
    
        r1.element += r4.length();
        r0 = r3;
     */
    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    /* renamed from: consume-FANa98k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1988consumeFANa98k(Output storage, final CharSequence input, final int startIndex) {
        Intrinsics.checkNotNullParameter(input, "input");
        TrieNode trieNode = this.trie;
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = startIndex;
        Integer num = null;
        loop0: while (intRef.element <= input.length()) {
            if (trieNode.getIsTerminal()) {
                num = Integer.valueOf(intRef.element);
            }
            for (Pair<String, TrieNode> pair : trieNode.getChildren()) {
                String component1 = pair.component1();
                TrieNode component2 = pair.component2();
                if (StringsKt.startsWith$default(input, (CharSequence) component1, intRef.element, false, 4, (Object) null)) {
                    break;
                }
            }
        }
        if (num != null) {
            return ParserOperationKt.access$setWithoutReassigning(this.setter, storage, input.subSequence(startIndex, num.intValue()).toString(), startIndex, num.intValue());
        }
        return ParseResult.INSTANCE.m1998ErrorRg3Co2E(startIndex, new Function0() { // from class: kotlinx.datetime.internal.format.parser.StringSetParserOperation$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String consume_FANa98k$lambda$5;
                consume_FANa98k$lambda$5 = StringSetParserOperation.consume_FANa98k$lambda$5(StringSetParserOperation.this, input, startIndex, intRef);
                return consume_FANa98k$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String consume_FANa98k$lambda$5(StringSetParserOperation this$0, CharSequence input, int i, Ref.IntRef index) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(input, "$input");
        Intrinsics.checkNotNullParameter(index, "$index");
        return "Expected " + this$0.whatThisExpects + " but got " + input.subSequence(i, index.element).toString();
    }
}
