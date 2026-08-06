package kotlinx.datetime.internal.format.formatter;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* compiled from: Formatter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00002\n\u0010\u0006\u001a\u00060\bj\u0002`\u00072\b\b\u0002\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", ExifInterface.GPS_DIRECTION_TRUE, "", "format", "", "obj", "builder", "Lkotlin/text/Appendable;", "Ljava/lang/Appendable;", "minusNotRequired", "", "(Ljava/lang/Object;Ljava/lang/Appendable;Z)V", "kotlinx-datetime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface FormatterStructure<T> {
    void format(T obj, Appendable builder, boolean minusNotRequired);

    /* compiled from: Formatter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void format$default(FormatterStructure formatterStructure, Object obj, Appendable appendable, boolean z, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: format");
            }
            if ((i & 4) != 0) {
                z = false;
            }
            formatterStructure.format(obj, appendable, z);
        }
    }
}
