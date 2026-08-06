package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.BuildConfig;

/* compiled from: ParserOperation.kt */
@Metadata(m4d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m5d2 = {"Lkotlinx/datetime/internal/format/parser/UnconditionalModification;", "Output", "Lkotlinx/datetime/internal/format/parser/ParserOperation;", "operation", "Lkotlin/Function1;", BuildConfig.FLAVOR, "<init>", "(Lkotlin/jvm/functions/Function1;)V", "consume", "Lkotlinx/datetime/internal/format/parser/ParseResult;", "storage", "input", BuildConfig.FLAVOR, "startIndex", BuildConfig.FLAVOR, "consume-FANa98k", "(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class UnconditionalModification<Output> implements ParserOperation<Output> {
    private final Function1<Output, Unit> operation;

    /* JADX WARN: Multi-variable type inference failed */
    public UnconditionalModification(Function1<? super Output, Unit> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        this.operation = operation;
    }

    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    /* renamed from: consume-FANa98k */
    public Object mo1988consumeFANa98k(Output storage, CharSequence input, int startIndex) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.operation.invoke(storage);
        return ParseResult.INSTANCE.m1999OkQi1bsqg(startIndex);
    }
}
