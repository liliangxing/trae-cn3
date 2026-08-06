package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlinx.datetime.internal.UtilKt;
import kotlinx.datetime.internal.format.parser.NumberConsumptionError;

/* compiled from: NumberConsumer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0005\u001a;\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0003H\u0002¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002\u001a#\u0010\r\u001a\u0004\u0018\u00010\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"setWithoutReassigning", "Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "Object", "Type", "Lkotlinx/datetime/internal/format/parser/AssignableField;", "receiver", "value", "(Lkotlinx/datetime/internal/format/parser/AssignableField;Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "parseAsciiInt", "", "", "start", "end", "parseAsciiIntOrNull", "(Ljava/lang/CharSequence;II)Ljava/lang/Integer;", "kotlinx-datetime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class NumberConsumerKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <Object, Type> NumberConsumptionError setWithoutReassigning(AssignableField<? super Object, Type> assignableField, Object object, Type type) {
        Type trySetWithoutReassigning = assignableField.trySetWithoutReassigning(object, type);
        if (trySetWithoutReassigning == null) {
            return null;
        }
        return new NumberConsumptionError.Conflicting(trySetWithoutReassigning);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int parseAsciiInt(CharSequence charSequence, int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            i3 = (i3 * 10) + UtilKt.asciiDigitToInt(charSequence.charAt(i));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer parseAsciiIntOrNull(CharSequence charSequence, int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            i3 = (i3 * 10) + UtilKt.asciiDigitToInt(charSequence.charAt(i));
            if (i3 < 0) {
                return null;
            }
            i++;
        }
        return Integer.valueOf(i3);
    }
}
