package bytedance.jvm.time.temporal;

@FunctionalInterface
/* loaded from: classes2.dex */
public interface TemporalQuery<R> {
    R queryFrom(TemporalAccessor temporalAccessor);
}
