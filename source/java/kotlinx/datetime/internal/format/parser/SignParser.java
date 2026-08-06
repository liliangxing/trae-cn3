package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.BuildConfig;

/* compiled from: ParserOperation.kt */
@Metadata(m4d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\tH\u0016R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m5d2 = {"Lkotlinx/datetime/internal/format/parser/SignParser;", "Output", "Lkotlinx/datetime/internal/format/parser/ParserOperation;", "isNegativeSetter", "Lkotlin/Function2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "withPlusSign", "whatThisExpects", BuildConfig.FLAVOR, "<init>", "(Lkotlin/jvm/functions/Function2;ZLjava/lang/String;)V", "consume", "Lkotlinx/datetime/internal/format/parser/ParseResult;", "storage", "input", BuildConfig.FLAVOR, "startIndex", BuildConfig.FLAVOR, "consume-FANa98k", "(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;", "toString", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class SignParser<Output> implements ParserOperation<Output> {
    private final Function2<Output, Boolean, Unit> isNegativeSetter;
    private final String whatThisExpects;
    private final boolean withPlusSign;

    /* JADX WARN: Multi-variable type inference failed */
    public SignParser(Function2<? super Output, ? super Boolean, Unit> isNegativeSetter, boolean z, String whatThisExpects) {
        Intrinsics.checkNotNullParameter(isNegativeSetter, "isNegativeSetter");
        Intrinsics.checkNotNullParameter(whatThisExpects, "whatThisExpects");
        this.isNegativeSetter = isNegativeSetter;
        this.withPlusSign = z;
        this.whatThisExpects = whatThisExpects;
    }

    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    /* renamed from: consume-FANa98k */
    public Object mo1988consumeFANa98k(Output storage, CharSequence input, int startIndex) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (startIndex >= input.length()) {
            return ParseResult.INSTANCE.m1999OkQi1bsqg(startIndex);
        }
        final char charAt = input.charAt(startIndex);
        if (charAt == '-') {
            this.isNegativeSetter.invoke(storage, true);
            return ParseResult.INSTANCE.m1999OkQi1bsqg(startIndex + 1);
        }
        if (charAt == '+' && this.withPlusSign) {
            this.isNegativeSetter.invoke(storage, false);
            return ParseResult.INSTANCE.m1999OkQi1bsqg(startIndex + 1);
        }
        return ParseResult.INSTANCE.m1998ErrorRg3Co2E(startIndex, new Function0() { // from class: kotlinx.datetime.internal.format.parser.SignParser$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String consume_FANa98k$lambda$0;
                consume_FANa98k$lambda$0 = SignParser.consume_FANa98k$lambda$0(SignParser.this, charAt);
                return consume_FANa98k$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String consume_FANa98k$lambda$0(SignParser this$0, char c) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return "Expected " + this$0.whatThisExpects + " but got " + c;
    }

    /* renamed from: toString, reason: from getter */
    public String getWhatThisExpects() {
        return this.whatThisExpects;
    }
}
