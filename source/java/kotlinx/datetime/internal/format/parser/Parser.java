package kotlinx.datetime.internal.format.parser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.Copyable;
import net.openid.appauth.BuildConfig;

/* compiled from: Parser.kt */
@Metadata(m4d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081@\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\"B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J^\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00122\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u0015H\u0082\b¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00028\u00002\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00028\u00002\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u001aJ\u0013\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u001f\u001a\u00020\rHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0004\u0092\u0001\b\u0012\u0004\u0012\u0002H\u00010\u0005¨\u0006#"}, m5d2 = {"Lkotlinx/datetime/internal/format/parser/Parser;", "Output", "Lkotlinx/datetime/internal/format/parser/Copyable;", BuildConfig.FLAVOR, "commands", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "constructor-impl", "(Lkotlinx/datetime/internal/format/parser/ParserStructure;)Lkotlinx/datetime/internal/format/parser/ParserStructure;", "parse", BuildConfig.FLAVOR, "input", BuildConfig.FLAVOR, "startIndex", BuildConfig.FLAVOR, "initialContainer", "allowDanglingInput", BuildConfig.FLAVOR, "onError", "Lkotlin/Function1;", "Lkotlinx/datetime/internal/format/parser/ParseError;", "onSuccess", "Lkotlin/Function2;", "parse-impl", "(Lkotlinx/datetime/internal/format/parser/ParserStructure;Ljava/lang/CharSequence;ILkotlinx/datetime/internal/format/parser/Copyable;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "match", "match-impl", "(Lkotlinx/datetime/internal/format/parser/ParserStructure;Ljava/lang/CharSequence;Lkotlinx/datetime/internal/format/parser/Copyable;I)Lkotlinx/datetime/internal/format/parser/Copyable;", "matchOrNull", "matchOrNull-impl", "equals", "other", "hashCode", "toString", BuildConfig.FLAVOR, "ParserState", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
@JvmInline
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class Parser<Output extends Copyable<Output>> {
    private final ParserStructure<Output> commands;

    /* renamed from: box-impl */
    public static final /* synthetic */ Parser m2000boximpl(ParserStructure parserStructure) {
        return new Parser(parserStructure);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: constructor-impl */
    public static <Output extends Copyable<Output>> ParserStructure<Output> m2001constructorimpl(ParserStructure<? super Output> commands) {
        Intrinsics.checkNotNullParameter(commands, "commands");
        return commands;
    }

    /* renamed from: equals-impl */
    public static boolean m2002equalsimpl(ParserStructure<? super Output> parserStructure, Object obj) {
        return (obj instanceof Parser) && Intrinsics.areEqual(parserStructure, ((Parser) obj).getCommands());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m2003equalsimpl0(ParserStructure<? super Output> parserStructure, ParserStructure<? super Output> parserStructure2) {
        return Intrinsics.areEqual(parserStructure, parserStructure2);
    }

    /* renamed from: hashCode-impl */
    public static int m2004hashCodeimpl(ParserStructure<? super Output> parserStructure) {
        return parserStructure.hashCode();
    }

    /* renamed from: toString-impl */
    public static String m2010toStringimpl(ParserStructure<? super Output> parserStructure) {
        return "Parser(commands=" + parserStructure + ')';
    }

    public boolean equals(Object other) {
        return m2002equalsimpl(this.commands, other);
    }

    public int hashCode() {
        return m2004hashCodeimpl(this.commands);
    }

    public String toString() {
        return m2010toStringimpl(this.commands);
    }

    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ ParserStructure getCommands() {
        return this.commands;
    }

    private /* synthetic */ Parser(ParserStructure parserStructure) {
        this.commands = parserStructure;
    }

    /* renamed from: parse-impl */
    private static final void m2009parseimpl(ParserStructure<? super Output> parserStructure, CharSequence charSequence, int i, Output output, boolean z, Function1<? super ParseError, Unit> function1, Function2<? super Integer, ? super Output, Unit> function2) {
        List mutableListOf = CollectionsKt.mutableListOf(new ParserState(output, parserStructure, i));
        while (true) {
            ParserState parserState = (ParserState) CollectionsKt.removeLastOrNull(mutableListOf);
            if (parserState == null) {
                return;
            }
            Copyable copyable = (Copyable) ((Copyable) parserState.getOutput()).copy();
            int inputPosition = parserState.getInputPosition();
            ParserStructure parserStructure2 = parserState.getParserStructure();
            int size = parserStructure2.getOperations().size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    Object mo1988consumeFANa98k = ((ParserOperation) parserStructure2.getOperations().get(i2)).mo1988consumeFANa98k(copyable, charSequence, inputPosition);
                    if (mo1988consumeFANa98k instanceof Integer) {
                        inputPosition = ((Number) mo1988consumeFANa98k).intValue();
                        i2++;
                    } else if (mo1988consumeFANa98k instanceof ParseError) {
                        function1.invoke((ParseError) mo1988consumeFANa98k);
                    } else {
                        throw new IllegalStateException(("Unexpected parse result: " + mo1988consumeFANa98k).toString());
                    }
                } else if (parserStructure2.getFollowedBy().isEmpty()) {
                    if (z || inputPosition == charSequence.length()) {
                        function2.invoke(Integer.valueOf(inputPosition), copyable);
                    } else {
                        function1.invoke(new ParseError(inputPosition, Parser$parse$1$3.INSTANCE));
                    }
                } else {
                    int size2 = parserStructure2.getFollowedBy().size() - 1;
                    if (size2 >= 0) {
                        while (true) {
                            int i3 = size2 - 1;
                            mutableListOf.add(new ParserState(copyable, (ParserStructure) parserStructure2.getFollowedBy().get(size2), inputPosition));
                            if (i3 < 0) {
                                break;
                            } else {
                                size2 = i3;
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: match-impl$default */
    public static /* synthetic */ Copyable m2006matchimpl$default(ParserStructure parserStructure, CharSequence charSequence, Copyable copyable, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m2005matchimpl(parserStructure, charSequence, copyable, i);
    }

    /* renamed from: match-impl */
    public static final Output m2005matchimpl(ParserStructure<? super Output> parserStructure, CharSequence input, Output initialContainer, int i) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(initialContainer, "initialContainer");
        ArrayList arrayList = new ArrayList();
        List mutableListOf = CollectionsKt.mutableListOf(new ParserState(initialContainer, parserStructure, i));
        while (true) {
            ParserState parserState = (ParserState) CollectionsKt.removeLastOrNull(mutableListOf);
            if (parserState != null) {
                Output output = (Output) ((Copyable) parserState.getOutput()).copy();
                int inputPosition = parserState.getInputPosition();
                ParserStructure parserStructure2 = parserState.getParserStructure();
                int size = parserStructure2.getOperations().size();
                int i2 = 0;
                while (true) {
                    if (i2 < size) {
                        Object mo1988consumeFANa98k = ((ParserOperation) parserStructure2.getOperations().get(i2)).mo1988consumeFANa98k(output, input, inputPosition);
                        if (mo1988consumeFANa98k instanceof Integer) {
                            inputPosition = ((Number) mo1988consumeFANa98k).intValue();
                            i2++;
                        } else if (mo1988consumeFANa98k instanceof ParseError) {
                            arrayList.add((ParseError) mo1988consumeFANa98k);
                        } else {
                            throw new IllegalStateException(("Unexpected parse result: " + mo1988consumeFANa98k).toString());
                        }
                    } else if (parserStructure2.getFollowedBy().isEmpty()) {
                        if (inputPosition == input.length()) {
                            return output;
                        }
                        arrayList.add(new ParseError(inputPosition, Parser$parse$1$3.INSTANCE));
                    } else {
                        int size2 = parserStructure2.getFollowedBy().size() - 1;
                        if (size2 >= 0) {
                            while (true) {
                                int i3 = size2 - 1;
                                mutableListOf.add(new ParserState(output, (ParserStructure) parserStructure2.getFollowedBy().get(size2), inputPosition));
                                if (i3 < 0) {
                                    break;
                                }
                                size2 = i3;
                            }
                        }
                    }
                }
            } else {
                if (arrayList.size() > 1) {
                    CollectionsKt.sortWith(arrayList, new Comparator() { // from class: kotlinx.datetime.internal.format.parser.Parser$match-impl$$inlined$sortByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Integer.valueOf(((ParseError) t2).getPosition()), Integer.valueOf(((ParseError) t).getPosition()));
                        }
                    });
                }
                throw new ParseException(arrayList);
            }
        }
    }

    /* renamed from: matchOrNull-impl$default */
    public static /* synthetic */ Copyable m2008matchOrNullimpl$default(ParserStructure parserStructure, CharSequence charSequence, Copyable copyable, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m2007matchOrNullimpl(parserStructure, charSequence, copyable, i);
    }

    /* compiled from: Parser.kt */
    @Metadata(m4d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m5d2 = {"Lkotlinx/datetime/internal/format/parser/Parser$ParserState;", "Output", BuildConfig.FLAVOR, "output", "parserStructure", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "inputPosition", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/Object;Lkotlinx/datetime/internal/format/parser/ParserStructure;I)V", "getOutput", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getParserStructure", "()Lkotlinx/datetime/internal/format/parser/ParserStructure;", "getInputPosition", "()I", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class ParserState<Output> {
        private final int inputPosition;
        private final Output output;
        private final ParserStructure<Output> parserStructure;

        /* JADX WARN: Multi-variable type inference failed */
        public ParserState(Output output, ParserStructure<? super Output> parserStructure, int i) {
            Intrinsics.checkNotNullParameter(parserStructure, "parserStructure");
            this.output = output;
            this.parserStructure = parserStructure;
            this.inputPosition = i;
        }

        public final Output getOutput() {
            return this.output;
        }

        public final ParserStructure<Output> getParserStructure() {
            return this.parserStructure;
        }

        public final int getInputPosition() {
            return this.inputPosition;
        }
    }

    /* renamed from: matchOrNull-impl */
    public static final Output m2007matchOrNullimpl(ParserStructure<? super Output> parserStructure, CharSequence input, Output initialContainer, int i) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(initialContainer, "initialContainer");
        List mutableListOf = CollectionsKt.mutableListOf(new ParserState(initialContainer, parserStructure, i));
        while (true) {
            ParserState parserState = (ParserState) CollectionsKt.removeLastOrNull(mutableListOf);
            if (parserState == null) {
                return null;
            }
            Output output = (Output) ((Copyable) parserState.getOutput()).copy();
            int inputPosition = parserState.getInputPosition();
            ParserStructure parserStructure2 = parserState.getParserStructure();
            int size = parserStructure2.getOperations().size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    Object mo1988consumeFANa98k = ((ParserOperation) parserStructure2.getOperations().get(i2)).mo1988consumeFANa98k(output, input, inputPosition);
                    if (mo1988consumeFANa98k instanceof Integer) {
                        inputPosition = ((Number) mo1988consumeFANa98k).intValue();
                        i2++;
                    } else {
                        if (!(mo1988consumeFANa98k instanceof ParseError)) {
                            throw new IllegalStateException(("Unexpected parse result: " + mo1988consumeFANa98k).toString());
                        }
                    }
                } else if (parserStructure2.getFollowedBy().isEmpty()) {
                    if (inputPosition == input.length()) {
                        return output;
                    }
                    new ParseError(inputPosition, Parser$parse$1$3.INSTANCE);
                } else {
                    int size2 = parserStructure2.getFollowedBy().size() - 1;
                    if (size2 >= 0) {
                        while (true) {
                            int i3 = size2 - 1;
                            mutableListOf.add(new ParserState(output, (ParserStructure) parserStructure2.getFollowedBy().get(size2), inputPosition));
                            if (i3 < 0) {
                                break;
                            }
                            size2 = i3;
                        }
                    }
                }
            }
        }
    }
}
