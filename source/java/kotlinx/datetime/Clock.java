package kotlinx.datetime;

import kotlin.Metadata;
import net.openid.appauth.BuildConfig;

/* compiled from: Clock.kt */
@Metadata(m4d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0006"}, m5d2 = {"Lkotlinx/datetime/Clock;", BuildConfig.FLAVOR, "now", "Lkotlinx/datetime/Instant;", "System", "Companion", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface Clock {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Instant now();

    /* compiled from: Clock.kt */
    @Metadata(m4d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m5d2 = {"Lkotlinx/datetime/Clock$System;", "Lkotlinx/datetime/Clock;", "<init>", "()V", "now", "Lkotlinx/datetime/Instant;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class System implements Clock {
        public static final System INSTANCE = new System();

        private System() {
        }

        @Override // kotlinx.datetime.Clock
        public Instant now() {
            return Instant.INSTANCE.now();
        }
    }

    /* compiled from: Clock.kt */
    @Metadata(m4d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5d2 = {"Lkotlinx/datetime/Clock$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
