package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.LongCompanionObject;
import net.openid.appauth.BuildConfig;

/* compiled from: TimeSources.kt */
@Metadata(m4d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m5d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "<init>", "()V", "reading", BuildConfig.FLAVOR, "read", "plusAssign", BuildConfig.FLAVOR, "duration", "Lkotlin/time/Duration;", "plusAssign-LRDsOJo", "(J)V", "overflow", "overflow-LRDsOJo", "kotlin-stdlib"}, m6k = 1, m7mv = {2, 1, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        markNow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.time.AbstractLongTimeSource
    /* renamed from: read, reason: from getter */
    public long getReading() {
        return this.reading;
    }

    /* renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m1836plusAssignLRDsOJo(long duration) {
        long m1764toLongimpl = Duration.m1764toLongimpl(duration, getUnit());
        if (!(((m1764toLongimpl - 1) | 1) == LongCompanionObject.MAX_VALUE)) {
            long j = this.reading;
            long j2 = j + m1764toLongimpl;
            if ((m1764toLongimpl ^ j) >= 0 && (j ^ j2) < 0) {
                m1835overflowLRDsOJo(duration);
            }
            this.reading = j2;
            return;
        }
        long m1728divUwyO8pc = Duration.m1728divUwyO8pc(duration, 2);
        if (!((1 | (Duration.m1764toLongimpl(m1728divUwyO8pc, getUnit()) - 1)) == LongCompanionObject.MAX_VALUE)) {
            long j3 = this.reading;
            try {
                m1836plusAssignLRDsOJo(m1728divUwyO8pc);
                m1836plusAssignLRDsOJo(Duration.m1753minusLRDsOJo(duration, m1728divUwyO8pc));
                return;
            } catch (IllegalStateException e) {
                this.reading = j3;
                throw e;
            }
        }
        m1835overflowLRDsOJo(duration);
    }

    /* renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m1835overflowLRDsOJo(long duration) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt.shortName(getUnit()) + " is advanced by " + ((Object) Duration.m1765toStringimpl(duration)) + '.');
    }
}
