package com.bytedance.trae.conversation.devices;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: ConnectComputerGuideFragment.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class ConnectComputerGuideFragment$onViewCreated$2 extends FunctionReferenceImpl implements Function0<Long> {
    public static final ConnectComputerGuideFragment$onViewCreated$2 INSTANCE = new ConnectComputerGuideFragment$onViewCreated$2();

    ConnectComputerGuideFragment$onViewCreated$2() {
        super(0, SystemClock.class, "elapsedRealtime", "elapsedRealtime()J", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(SystemClock.elapsedRealtime());
    }
}
