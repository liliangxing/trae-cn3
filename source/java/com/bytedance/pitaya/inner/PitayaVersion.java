package com.bytedance.pitaya.inner;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;

/* compiled from: PitayaVersion.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/pitaya/inner/PitayaVersion;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "()V", "PTY_MIN_PY_VERSION", "", "PTY_PY_BRIDGE_VERSION", "PTY_PY_CV2_BINDER_VERSION", "PTY_PY_NUMPY_VERSION", "PTY_RESOURCE_VERSION", "PTY_VERSION", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class PitayaVersion implements ReflectionCall {
    public static final PitayaVersion INSTANCE = new PitayaVersion();
    public static final String PTY_MIN_PY_VERSION = "2.13.0";
    public static final String PTY_PY_BRIDGE_VERSION = "3.13.0";
    public static final String PTY_PY_CV2_BINDER_VERSION = "2.0.0";
    public static final String PTY_PY_NUMPY_VERSION = "2.0.0";
    public static final String PTY_RESOURCE_VERSION = "1.0.0";
    public static final String PTY_VERSION = "2.13.0";

    private PitayaVersion() {
    }
}
