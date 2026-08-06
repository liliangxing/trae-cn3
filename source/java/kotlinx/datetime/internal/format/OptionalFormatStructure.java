package kotlinx.datetime.internal.format;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.ConditionalFormatter;
import kotlinx.datetime.internal.format.formatter.ConstantStringFormatterStructure;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserKt;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import kotlinx.datetime.internal.format.parser.UnconditionalModification;
import net.openid.appauth.BuildConfig;

/* compiled from: FormatStructure.kt */
@Metadata(m4d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u001bB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u0004H\u0016J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u0000\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00110\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m5d2 = {"Lkotlinx/datetime/internal/format/OptionalFormatStructure;", "T", "Lkotlinx/datetime/internal/format/NonConcatenatedFormatStructure;", "onZero", BuildConfig.FLAVOR, "format", "Lkotlinx/datetime/internal/format/FormatStructure;", "<init>", "(Ljava/lang/String;Lkotlinx/datetime/internal/format/FormatStructure;)V", "getOnZero", "()Ljava/lang/String;", "getFormat", "()Lkotlinx/datetime/internal/format/FormatStructure;", "toString", "fields", BuildConfig.FLAVOR, "Lkotlinx/datetime/internal/format/OptionalFormatStructure$PropertyWithDefault;", BuildConfig.FLAVOR, "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "PropertyWithDefault", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class OptionalFormatStructure<T> implements NonConcatenatedFormatStructure<T> {
    private final List<PropertyWithDefault<T, ? extends Object>> fields;
    private final FormatStructure<T> format;
    private final String onZero;

    /* JADX WARN: Multi-variable type inference failed */
    public OptionalFormatStructure(String onZero, FormatStructure<? super T> format) {
        List basicFormats;
        Intrinsics.checkNotNullParameter(onZero, "onZero");
        Intrinsics.checkNotNullParameter(format, "format");
        this.onZero = onZero;
        this.format = format;
        basicFormats = FormatStructureKt.basicFormats(format);
        List list = basicFormats;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((FieldFormatDirective) it.next()).getField());
        }
        List distinct = CollectionsKt.distinct(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(distinct, 10));
        Iterator<T> it2 = distinct.iterator();
        while (it2.hasNext()) {
            arrayList2.add(PropertyWithDefault.INSTANCE.fromField((FieldSpec) it2.next()));
        }
        this.fields = arrayList2;
    }

    public final String getOnZero() {
        return this.onZero;
    }

    public final FormatStructure<T> getFormat() {
        return this.format;
    }

    public String toString() {
        return "Optional(" + this.onZero + ", " + this.format + ')';
    }

    public boolean equals(Object other) {
        if (other instanceof OptionalFormatStructure) {
            OptionalFormatStructure optionalFormatStructure = (OptionalFormatStructure) other;
            if (Intrinsics.areEqual(this.onZero, optionalFormatStructure.onZero) && Intrinsics.areEqual(this.format, optionalFormatStructure.format)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.onZero.hashCode() * 31) + this.format.hashCode();
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public ParserStructure<T> parser() {
        List listOf;
        List emptyList = CollectionsKt.emptyList();
        ParserStructure[] parserStructureArr = new ParserStructure[2];
        parserStructureArr[0] = this.format.parser();
        ParserStructure[] parserStructureArr2 = new ParserStructure[2];
        parserStructureArr2[0] = new ConstantFormatStructure(this.onZero).parser();
        if (this.fields.isEmpty()) {
            listOf = CollectionsKt.emptyList();
        } else {
            listOf = CollectionsKt.listOf(new UnconditionalModification(new Function1() { // from class: kotlinx.datetime.internal.format.OptionalFormatStructure$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit parser$lambda$2;
                    parser$lambda$2 = OptionalFormatStructure.parser$lambda$2(OptionalFormatStructure.this, obj);
                    return parser$lambda$2;
                }
            }));
        }
        parserStructureArr2[1] = new ParserStructure(listOf, CollectionsKt.emptyList());
        parserStructureArr[1] = ParserKt.concat(CollectionsKt.listOf((Object[]) parserStructureArr2));
        return new ParserStructure<>(emptyList, CollectionsKt.listOf((Object[]) parserStructureArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit parser$lambda$2(OptionalFormatStructure this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        for (PropertyWithDefault<T, ? extends Object> propertyWithDefault : this$0.fields) {
            ((PropertyWithDefault) propertyWithDefault).accessor.trySetWithoutReassigning(obj, ((PropertyWithDefault) propertyWithDefault).defaultValue);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public FormatterStructure<T> formatter() {
        FormatterStructure<T> formatter = this.format.formatter();
        List<PropertyWithDefault<T, ? extends Object>> list = this.fields;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            PropertyWithDefault propertyWithDefault = (PropertyWithDefault) it.next();
            arrayList.add(new ComparisonPredicate(propertyWithDefault.defaultValue, new C0098x66a7504a(propertyWithDefault.accessor)));
        }
        Predicate conjunctionPredicate = PredicateKt.conjunctionPredicate(arrayList);
        if (conjunctionPredicate instanceof Truth) {
            return new ConstantStringFormatterStructure(this.onZero);
        }
        return new ConditionalFormatter(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.m12to(new OptionalFormatStructure$formatter$1(conjunctionPredicate), new ConstantStringFormatterStructure(this.onZero)), TuplesKt.m12to(new OptionalFormatStructure$formatter$2(Truth.INSTANCE), formatter)}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FormatStructure.kt */
    @Metadata(m4d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u0010*\u0006\b\u0001\u0010\u0001 \u0000*\u0004\b\u0002\u0010\u00022\u00020\u0003:\u0001\u0010B%\b\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0086\b¢\u0006\u0002\u0010\rJ\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000fH\u0086\bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00028\u0002X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0011"}, m5d2 = {"Lkotlinx/datetime/internal/format/OptionalFormatStructure$PropertyWithDefault;", "T", "E", BuildConfig.FLAVOR, "accessor", "Lkotlinx/datetime/internal/format/Accessor;", "defaultValue", "<init>", "(Lkotlinx/datetime/internal/format/Accessor;Ljava/lang/Object;)V", "Ljava/lang/Object;", "assignDefault", BuildConfig.FLAVOR, "target", "(Ljava/lang/Object;)V", "isDefaultComparisonPredicate", "Lkotlinx/datetime/internal/format/ComparisonPredicate;", "Companion", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class PropertyWithDefault<T, E> {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Accessor<T, E> accessor;
        private final E defaultValue;

        public /* synthetic */ PropertyWithDefault(Accessor accessor, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
            this(accessor, obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private PropertyWithDefault(Accessor<? super T, E> accessor, E e) {
            this.accessor = accessor;
            this.defaultValue = e;
        }

        /* compiled from: FormatStructure.kt */
        @Metadata(m4d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0003\u0010\u0006\"\u0004\b\u0004\u0010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\t¨\u0006\n"}, m5d2 = {"Lkotlinx/datetime/internal/format/OptionalFormatStructure$PropertyWithDefault$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "fromField", "Lkotlinx/datetime/internal/format/OptionalFormatStructure$PropertyWithDefault;", "T", "E", "field", "Lkotlinx/datetime/internal/format/FieldSpec;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final <T, E> PropertyWithDefault<T, E> fromField(FieldSpec<? super T, E> field) {
                Intrinsics.checkNotNullParameter(field, "field");
                E defaultValue = field.getDefaultValue();
                if (!(defaultValue != null)) {
                    throw new IllegalArgumentException(("The field '" + field.getName() + "' does not define a default value").toString());
                }
                return new PropertyWithDefault<>(field.getAccessor(), defaultValue, null);
            }
        }

        public final void assignDefault(T target) {
            this.accessor.trySetWithoutReassigning(target, this.defaultValue);
        }

        public final ComparisonPredicate<T, E> isDefaultComparisonPredicate() {
            return new ComparisonPredicate<>(this.defaultValue, new C0098x66a7504a(this.accessor));
        }
    }
}
