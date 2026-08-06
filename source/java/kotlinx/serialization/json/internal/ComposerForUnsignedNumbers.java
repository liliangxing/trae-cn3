package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.BuildConfig;

/* compiled from: Composers.kt */
@Metadata(m4d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\fH\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m5d2 = {"Lkotlinx/serialization/json/internal/ComposerForUnsignedNumbers;", "Lkotlinx/serialization/json/internal/Composer;", "writer", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "forceQuoting", BuildConfig.FLAVOR, "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Z)V", "print", BuildConfig.FLAVOR, "v", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "kotlinx-serialization-json"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ComposerForUnsignedNumbers extends Composer {
    private final boolean forceQuoting;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(InternalJsonWriter writer, boolean z) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.forceQuoting = z;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(int v) {
        String m26m;
        String m26m2;
        boolean z = this.forceQuoting;
        int m474constructorimpl = UInt.m474constructorimpl(v);
        if (z) {
            m26m2 = UByte$$ExternalSyntheticBackport0.m26m(m474constructorimpl, 10);
            printQuoted(m26m2);
        } else {
            m26m = UByte$$ExternalSyntheticBackport0.m26m(m474constructorimpl, 10);
            print(m26m);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(long v) {
        String m$2;
        String m$22;
        boolean z = this.forceQuoting;
        long m553constructorimpl = ULong.m553constructorimpl(v);
        if (z) {
            m$22 = UByte$$ExternalSyntheticBackport0.m$2(m553constructorimpl, 10);
            printQuoted(m$22);
        } else {
            m$2 = UByte$$ExternalSyntheticBackport0.m$2(m553constructorimpl, 10);
            print(m$2);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(byte v) {
        boolean z = this.forceQuoting;
        String m440toStringimpl = UByte.m440toStringimpl(UByte.m396constructorimpl(v));
        if (z) {
            printQuoted(m440toStringimpl);
        } else {
            print(m440toStringimpl);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(short v) {
        boolean z = this.forceQuoting;
        String m704toStringimpl = UShort.m704toStringimpl(UShort.m660constructorimpl(v));
        if (z) {
            printQuoted(m704toStringimpl);
        } else {
            print(m704toStringimpl);
        }
    }
}
