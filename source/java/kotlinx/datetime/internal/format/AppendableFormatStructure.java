package kotlinx.datetime.internal.format;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.BuildConfig;

/* compiled from: Builder.kt */
@Metadata(m4d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tJ\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5d2 = {"Lkotlinx/datetime/internal/format/AppendableFormatStructure;", "T", BuildConfig.FLAVOR, "<init>", "()V", "list", BuildConfig.FLAVOR, "Lkotlinx/datetime/internal/format/NonConcatenatedFormatStructure;", "build", "Lkotlinx/datetime/internal/format/ConcatenatedFormatStructure;", "add", BuildConfig.FLAVOR, "format", "Lkotlinx/datetime/internal/format/FormatStructure;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class AppendableFormatStructure<T> {
    private final List<NonConcatenatedFormatStructure<T>> list = new ArrayList();

    public final ConcatenatedFormatStructure<T> build() {
        return new ConcatenatedFormatStructure<>(this.list);
    }

    public final void add(FormatStructure<? super T> format) {
        Intrinsics.checkNotNullParameter(format, "format");
        if (format instanceof NonConcatenatedFormatStructure) {
            this.list.add(format);
        } else {
            if (!(format instanceof ConcatenatedFormatStructure)) {
                throw new NoWhenBranchMatchedException();
            }
            Iterator<T> it = ((ConcatenatedFormatStructure) format).getFormats().iterator();
            while (it.hasNext()) {
                this.list.add((NonConcatenatedFormatStructure) it.next());
            }
        }
    }
}
