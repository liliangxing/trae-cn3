package kotlinx.datetime.internal.format.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.datetime.internal.UtilKt;
import net.openid.appauth.BuildConfig;

/* compiled from: ParserOperation.kt */
@Metadata(m4d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u000fH\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, m5d2 = {"Lkotlinx/datetime/internal/format/parser/NumberSpanParserOperation;", "Output", "Lkotlinx/datetime/internal/format/parser/ParserOperation;", "consumers", BuildConfig.FLAVOR, "Lkotlinx/datetime/internal/format/parser/NumberConsumer;", "<init>", "(Ljava/util/List;)V", "getConsumers", "()Ljava/util/List;", "minLength", BuildConfig.FLAVOR, "isFlexible", BuildConfig.FLAVOR, "whatThisExpects", BuildConfig.FLAVOR, "getWhatThisExpects", "()Ljava/lang/String;", "consume", "Lkotlinx/datetime/internal/format/parser/ParseResult;", "storage", "input", BuildConfig.FLAVOR, "startIndex", "consume-FANa98k", "(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;", "toString", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class NumberSpanParserOperation<Output> implements ParserOperation<Output> {
    private final List<NumberConsumer<Output>> consumers;
    private final boolean isFlexible;
    private final int minLength;

    /* JADX WARN: Multi-variable type inference failed */
    public NumberSpanParserOperation(List<? extends NumberConsumer<? super Output>> consumers) {
        boolean z;
        boolean z2;
        int i;
        Intrinsics.checkNotNullParameter(consumers, "consumers");
        this.consumers = consumers;
        Iterator it = consumers.iterator();
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (!it.hasNext()) {
                break;
            }
            Integer length = ((NumberConsumer) it.next()).getLength();
            if (length != null) {
                i3 = length.intValue();
            }
            i2 += i3;
        }
        this.minLength = i2;
        List<NumberConsumer<Output>> list = this.consumers;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (((NumberConsumer) it2.next()).getLength() == null) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        this.isFlexible = z;
        List<NumberConsumer<Output>> list2 = this.consumers;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it3 = list2.iterator();
            while (it3.hasNext()) {
                Integer length2 = ((NumberConsumer) it3.next()).getLength();
                if (!((length2 != null ? length2.intValue() : Integer.MAX_VALUE) > 0)) {
                    z2 = false;
                    break;
                }
            }
        }
        z2 = true;
        if (!z2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        List<NumberConsumer<Output>> list3 = this.consumers;
        if ((list3 instanceof Collection) && list3.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it4 = list3.iterator();
            i = 0;
            while (it4.hasNext()) {
                if ((((NumberConsumer) it4.next()).getLength() == null) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (i <= 1) {
            return;
        }
        List<NumberConsumer<Output>> list4 = this.consumers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list4) {
            if (((NumberConsumer) obj).getLength() == null) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            arrayList3.add(((NumberConsumer) it5.next()).getWhatThisExpects());
        }
        throw new IllegalArgumentException(("At most one variable-length numeric field in a row is allowed, but got several: " + arrayList3 + ". Parsing is undefined: for example, with variable-length month number and variable-length day of month, '111' can be parsed as Jan 11th or Nov 1st.").toString());
    }

    public final List<NumberConsumer<Output>> getConsumers() {
        return this.consumers;
    }

    private final String getWhatThisExpects() {
        List<NumberConsumer<Output>> list = this.consumers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            NumberConsumer numberConsumer = (NumberConsumer) it.next();
            StringBuilder sb = new StringBuilder();
            Integer length = numberConsumer.getLength();
            arrayList.add(sb.append(length == null ? "at least one digit" : length + " digits").append(" for ").append(numberConsumer.getWhatThisExpects()).toString());
        }
        ArrayList arrayList2 = arrayList;
        if (this.isFlexible) {
            return "a number with at least " + this.minLength + " digits: " + arrayList2;
        }
        return "a number with exactly " + this.minLength + " digits: " + arrayList2;
    }

    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    /* renamed from: consume-FANa98k, reason: not valid java name */
    public Object mo1988consumeFANa98k(Output storage, CharSequence input, int startIndex) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (this.minLength + startIndex > input.length()) {
            return ParseResult.INSTANCE.m1998ErrorRg3Co2E(startIndex, new Function0() { // from class: kotlinx.datetime.internal.format.parser.NumberSpanParserOperation$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String consume_FANa98k$lambda$8;
                    consume_FANa98k$lambda$8 = NumberSpanParserOperation.consume_FANa98k$lambda$8(NumberSpanParserOperation.this);
                    return consume_FANa98k$lambda$8;
                }
            });
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        while (intRef.element + startIndex < input.length() && UtilKt.isAsciiDigit(input.charAt(intRef.element + startIndex))) {
            intRef.element++;
            int i = intRef.element;
        }
        if (intRef.element < this.minLength) {
            return ParseResult.INSTANCE.m1998ErrorRg3Co2E(startIndex, new Function0() { // from class: kotlinx.datetime.internal.format.parser.NumberSpanParserOperation$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String consume_FANa98k$lambda$9;
                    consume_FANa98k$lambda$9 = NumberSpanParserOperation.consume_FANa98k$lambda$9(Ref.IntRef.this, this);
                    return consume_FANa98k$lambda$9;
                }
            });
        }
        int size = this.consumers.size();
        final int i2 = 0;
        while (i2 < size) {
            Integer length = this.consumers.get(i2).getLength();
            int intValue = (length != null ? length.intValue() : (intRef.element - this.minLength) + 1) + startIndex;
            final NumberConsumptionError consume = this.consumers.get(i2).consume(storage, input, startIndex, intValue);
            if (consume != null) {
                final String obj = input.subSequence(startIndex, intValue).toString();
                return ParseResult.INSTANCE.m1998ErrorRg3Co2E(startIndex, new Function0() { // from class: kotlinx.datetime.internal.format.parser.NumberSpanParserOperation$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        String consume_FANa98k$lambda$10;
                        consume_FANa98k$lambda$10 = NumberSpanParserOperation.consume_FANa98k$lambda$10(obj, this, i2, consume);
                        return consume_FANa98k$lambda$10;
                    }
                });
            }
            i2++;
            startIndex = intValue;
        }
        return ParseResult.INSTANCE.m1999OkQi1bsqg(startIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String consume_FANa98k$lambda$8(NumberSpanParserOperation this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return "Unexpected end of input: yet to parse " + this$0.getWhatThisExpects();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String consume_FANa98k$lambda$9(Ref.IntRef digitsInRow, NumberSpanParserOperation this$0) {
        Intrinsics.checkNotNullParameter(digitsInRow, "$digitsInRow");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return "Only found " + digitsInRow.element + " digits in a row, but need to parse " + this$0.getWhatThisExpects();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String consume_FANa98k$lambda$10(String numberString, NumberSpanParserOperation this$0, int i, NumberConsumptionError numberConsumptionError) {
        Intrinsics.checkNotNullParameter(numberString, "$numberString");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return "Can not interpret the string '" + numberString + "' as " + this$0.consumers.get(i).getWhatThisExpects() + ": " + numberConsumptionError.errorMessage();
    }

    public String toString() {
        return getWhatThisExpects();
    }
}
