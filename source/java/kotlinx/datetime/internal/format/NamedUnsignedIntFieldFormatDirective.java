package kotlinx.datetime.internal.format;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.formatter.StringFormatterStructure;
import kotlinx.datetime.internal.format.parser.AssignableField;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import kotlinx.datetime.internal.format.parser.StringSetParserOperation;
import net.openid.appauth.BuildConfig;

/* compiled from: FieldFormatDirective.kt */
@Metadata(m4d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0014B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m5d2 = {"Lkotlinx/datetime/internal/format/NamedUnsignedIntFieldFormatDirective;", "Target", "Lkotlinx/datetime/internal/format/FieldFormatDirective;", "field", "Lkotlinx/datetime/internal/format/UnsignedFieldSpec;", "values", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "name", "<init>", "(Lkotlinx/datetime/internal/format/UnsignedFieldSpec;Ljava/util/List;Ljava/lang/String;)V", "getField", "()Lkotlinx/datetime/internal/format/UnsignedFieldSpec;", "getStringValue", "target", "(Ljava/lang/Object;)Ljava/lang/String;", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "AssignableString", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class NamedUnsignedIntFieldFormatDirective<Target> implements FieldFormatDirective<Target> {
    private final UnsignedFieldSpec<Target> field;
    private final String name;
    private final List<String> values;

    /* JADX WARN: Multi-variable type inference failed */
    public NamedUnsignedIntFieldFormatDirective(UnsignedFieldSpec<? super Target> field, List<String> values, String name) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(name, "name");
        this.field = field;
        this.values = values;
        this.name = name;
        if (!(values.size() == (field.getMaxValue() - field.getMinValue()) + 1)) {
            throw new IllegalArgumentException(("The number of values (" + values.size() + ") in " + values + " does not match the range of the field (" + ((field.getMaxValue() - field.getMinValue()) + 1) + ')').toString());
        }
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public /* bridge */ /* synthetic */ FieldSpec getField() {
        return this.field;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final UnsignedFieldSpec<Target> getField() {
        return this.field;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getStringValue(Target target) {
        int intValue = this.field.getAccessor().getterNotNull(target).intValue();
        String str = (String) CollectionsKt.getOrNull(this.values, intValue - this.field.getMinValue());
        return str == null ? "The value " + intValue + " of " + this.field.getName() + " does not have a corresponding string representation" : str;
    }

    /* compiled from: FieldFormatDirective.kt */
    @Metadata(m4d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\bR\u0014\u0010\t\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m5d2 = {"Lkotlinx/datetime/internal/format/NamedUnsignedIntFieldFormatDirective$AssignableString;", "Lkotlinx/datetime/internal/format/parser/AssignableField;", BuildConfig.FLAVOR, "<init>", "(Lkotlinx/datetime/internal/format/NamedUnsignedIntFieldFormatDirective;)V", "trySetWithoutReassigning", "container", "newValue", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;", "name", "getName", "()Ljava/lang/String;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
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
            Integer trySetWithoutReassigning = NamedUnsignedIntFieldFormatDirective.this.getField().getAccessor().trySetWithoutReassigning(container, Integer.valueOf(((NamedUnsignedIntFieldFormatDirective) NamedUnsignedIntFieldFormatDirective.this).values.indexOf(newValue) + NamedUnsignedIntFieldFormatDirective.this.getField().getMinValue()));
            if (trySetWithoutReassigning == null) {
                return null;
            }
            NamedUnsignedIntFieldFormatDirective<Target> namedUnsignedIntFieldFormatDirective = NamedUnsignedIntFieldFormatDirective.this;
            return (String) ((NamedUnsignedIntFieldFormatDirective) namedUnsignedIntFieldFormatDirective).values.get(trySetWithoutReassigning.intValue() - namedUnsignedIntFieldFormatDirective.getField().getMinValue());
        }

        @Override // kotlinx.datetime.internal.format.parser.AssignableField
        public String getName() {
            return ((NamedUnsignedIntFieldFormatDirective) NamedUnsignedIntFieldFormatDirective.this).name;
        }
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public FormatterStructure<Target> formatter() {
        return new StringFormatterStructure(new NamedUnsignedIntFieldFormatDirective$formatter$1(this));
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public ParserStructure<Target> parser() {
        return new ParserStructure<>(CollectionsKt.listOf(new StringSetParserOperation(this.values, new AssignableString(), "one of " + this.values + " for " + this.name)), CollectionsKt.emptyList());
    }
}
