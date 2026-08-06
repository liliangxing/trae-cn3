package kotlinx.datetime.internal.format;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.formatter.StringFormatterStructure;
import kotlinx.datetime.internal.format.parser.AssignableField;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import kotlinx.datetime.internal.format.parser.StringSetParserOperation;
import net.openid.appauth.BuildConfig;

/* compiled from: FieldFormatDirective.kt */
@Metadata(m4d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0016B7\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m5d2 = {"Lkotlinx/datetime/internal/format/NamedEnumIntFieldFormatDirective;", "Target", "Type", "Lkotlinx/datetime/internal/format/FieldFormatDirective;", "field", "Lkotlinx/datetime/internal/format/FieldSpec;", "mapping", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "name", "<init>", "(Lkotlinx/datetime/internal/format/FieldSpec;Ljava/util/Map;Ljava/lang/String;)V", "getField", "()Lkotlinx/datetime/internal/format/FieldSpec;", "reverseMapping", "getStringValue", "target", "(Ljava/lang/Object;)Ljava/lang/String;", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "AssignableString", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class NamedEnumIntFieldFormatDirective<Target, Type> implements FieldFormatDirective<Target> {
    private final FieldSpec<Target, Type> field;
    private final Map<Type, String> mapping;
    private final String name;
    private final Map<String, Type> reverseMapping;

    /* JADX WARN: Multi-variable type inference failed */
    public NamedEnumIntFieldFormatDirective(FieldSpec<? super Target, Type> field, Map<Type, String> mapping, String name) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        Intrinsics.checkNotNullParameter(name, "name");
        this.field = field;
        this.mapping = mapping;
        this.name = name;
        Set<Map.Entry<Type, String>> entrySet = mapping.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet, 10)), 16));
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Pair m12to = TuplesKt.m12to(entry.getValue(), entry.getKey());
            linkedHashMap.put(m12to.getFirst(), m12to.getSecond());
        }
        this.reverseMapping = linkedHashMap;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final FieldSpec<Target, Type> getField() {
        return this.field;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getStringValue(Target target) {
        Type type = this.field.getAccessor().getterNotNull(target);
        String str = this.mapping.get(this.field.getAccessor().getterNotNull(target));
        return str == null ? "The value " + type + " of " + this.field.getName() + " does not have a corresponding string representation" : str;
    }

    /* compiled from: FieldFormatDirective.kt */
    @Metadata(m4d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\bR\u0014\u0010\t\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m5d2 = {"Lkotlinx/datetime/internal/format/NamedEnumIntFieldFormatDirective$AssignableString;", "Lkotlinx/datetime/internal/format/parser/AssignableField;", BuildConfig.FLAVOR, "<init>", "(Lkotlinx/datetime/internal/format/NamedEnumIntFieldFormatDirective;)V", "trySetWithoutReassigning", "container", "newValue", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;", "name", "getName", "()Ljava/lang/String;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    private final class AssignableString implements AssignableField<Target, String> {
        public AssignableString() {
        }

        @Override // kotlinx.datetime.internal.format.parser.AssignableField
        public /* bridge */ /* synthetic */ String trySetWithoutReassigning(Object obj, String str) {
            return trySetWithoutReassigning2((AssignableString) obj, str);
        }

        /* renamed from: trySetWithoutReassigning, reason: avoid collision after fix types in other method */
        public String trySetWithoutReassigning2(Target container, String newValue) {
            Intrinsics.checkNotNullParameter(newValue, "newValue");
            Accessor<Target, Type> accessor = NamedEnumIntFieldFormatDirective.this.getField().getAccessor();
            Object obj = ((NamedEnumIntFieldFormatDirective) NamedEnumIntFieldFormatDirective.this).reverseMapping.get(newValue);
            Intrinsics.checkNotNull(obj);
            Type trySetWithoutReassigning = accessor.trySetWithoutReassigning(container, obj);
            if (trySetWithoutReassigning != null) {
                return (String) ((NamedEnumIntFieldFormatDirective) NamedEnumIntFieldFormatDirective.this).mapping.get(trySetWithoutReassigning);
            }
            return null;
        }

        @Override // kotlinx.datetime.internal.format.parser.AssignableField
        public String getName() {
            return ((NamedEnumIntFieldFormatDirective) NamedEnumIntFieldFormatDirective.this).name;
        }
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public FormatterStructure<Target> formatter() {
        return new StringFormatterStructure(new NamedEnumIntFieldFormatDirective$formatter$1(this));
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public ParserStructure<Target> parser() {
        return new ParserStructure<>(CollectionsKt.listOf(new StringSetParserOperation(this.mapping.values(), new AssignableString(), "one of " + this.mapping.values() + " for " + this.name)), CollectionsKt.emptyList());
    }
}
