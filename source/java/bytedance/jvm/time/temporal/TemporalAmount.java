package bytedance.jvm.time.temporal;

import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface TemporalAmount {
    Temporal addTo(Temporal temporal);

    long get(TemporalUnit temporalUnit);

    List<TemporalUnit> getUnits();

    Temporal subtractFrom(Temporal temporal);
}
