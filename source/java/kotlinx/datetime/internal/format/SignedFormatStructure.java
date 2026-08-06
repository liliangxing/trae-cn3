package kotlinx.datetime.internal.format;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.formatter.SignedFormatter;
import kotlinx.datetime.internal.format.parser.ParserKt;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import kotlinx.datetime.internal.format.parser.SignParser;
import net.openid.appauth.BuildConfig;

/* compiled from: FormatStructure.kt */
@Metadata(m4d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m5d2 = {"Lkotlinx/datetime/internal/format/SignedFormatStructure;", "T", "Lkotlinx/datetime/internal/format/NonConcatenatedFormatStructure;", "format", "Lkotlinx/datetime/internal/format/FormatStructure;", "withPlusSign", BuildConfig.FLAVOR, "<init>", "(Lkotlinx/datetime/internal/format/FormatStructure;Z)V", "getFormat", "()Lkotlinx/datetime/internal/format/FormatStructure;", "getWithPlusSign", "()Z", "fieldSigns", BuildConfig.FLAVOR, "Lkotlinx/datetime/internal/format/FieldSign;", "toString", BuildConfig.FLAVOR, "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class SignedFormatStructure<T> implements NonConcatenatedFormatStructure<T> {
    private final Set<FieldSign<T>> fieldSigns;
    private final FormatStructure<T> format;
    private final boolean withPlusSign;

    /* JADX WARN: Multi-variable type inference failed */
    public SignedFormatStructure(FormatStructure<? super T> format, boolean z) {
        List basicFormats;
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
        this.withPlusSign = z;
        basicFormats = FormatStructureKt.basicFormats(format);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = basicFormats.iterator();
        while (it.hasNext()) {
            FieldSign sign = ((FieldFormatDirective) it.next()).getField().getSign();
            if (sign != null) {
                arrayList.add(sign);
            }
        }
        this.fieldSigns = CollectionsKt.toSet(arrayList);
        if (!(!r2.isEmpty())) {
            throw new IllegalArgumentException("Signed format must contain at least one field with a sign".toString());
        }
    }

    public final FormatStructure<T> getFormat() {
        return this.format;
    }

    public final boolean getWithPlusSign() {
        return this.withPlusSign;
    }

    public String toString() {
        return "SignedFormatStructure(" + this.format + ')';
    }

    public boolean equals(Object other) {
        if (other instanceof SignedFormatStructure) {
            SignedFormatStructure signedFormatStructure = (SignedFormatStructure) other;
            if (Intrinsics.areEqual(this.format, signedFormatStructure.format) && this.withPlusSign == signedFormatStructure.withPlusSign) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.format.hashCode() * 31) + Boolean.hashCode(this.withPlusSign);
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public ParserStructure<T> parser() {
        return ParserKt.concat(CollectionsKt.listOf((Object[]) new ParserStructure[]{new ParserStructure(CollectionsKt.listOf(new SignParser(new Function2() { // from class: kotlinx.datetime.internal.format.SignedFormatStructure$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit parser$lambda$2;
                parser$lambda$2 = SignedFormatStructure.parser$lambda$2(SignedFormatStructure.this, obj, ((Boolean) obj2).booleanValue());
                return parser$lambda$2;
            }
        }, this.withPlusSign, "sign for " + this.fieldSigns)), CollectionsKt.emptyList()), this.format.parser()}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit parser$lambda$2(SignedFormatStructure this$0, Object obj, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        for (FieldSign<T> fieldSign : this$0.fieldSigns) {
            boolean z2 = true;
            boolean areEqual = Intrinsics.areEqual((Object) fieldSign.isNegative().getter(obj), (Object) true);
            Accessor<T, Boolean> isNegative = fieldSign.isNegative();
            if (z == areEqual) {
                z2 = false;
            }
            isNegative.trySetWithoutReassigning(obj, Boolean.valueOf(z2));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public FormatterStructure<T> formatter() {
        return new SignedFormatter(this.format.formatter(), new SignedFormatStructure$formatter$1(this), this.withPlusSign);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean formatter$checkIfAllNegative(SignedFormatStructure<? super T> signedFormatStructure, T t) {
        boolean z = false;
        for (FieldSign<? super T> fieldSign : ((SignedFormatStructure) signedFormatStructure).fieldSigns) {
            if (Intrinsics.areEqual((Object) fieldSign.isNegative().getter(t), (Object) true)) {
                z = true;
            } else if (!fieldSign.isZero(t)) {
                return false;
            }
        }
        return z;
    }
}
