package com.bytedance.pitaya.api;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* compiled from: PTYSocketStateCallback.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \u00072\u00020\u0001:\u0002\u0007\bJ\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\t"}, d2 = {"Lcom/bytedance/pitaya/api/PTYSocketStateCallback;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "onSocketStateChange", "", "state", "", "info", "Companion", "SocketState", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public interface PTYSocketStateCallback extends ReflectionCall {
    public static final String CLOSED = "closed";
    public static final String CONNECTED = "connected";
    public static final String CONNECTING = "connecting";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String ERROR = "error";
    public static final String NONE = "none";
    public static final String UNKNOWN = "unknown";

    /* compiled from: PTYSocketStateCallback.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pitaya/api/PTYSocketStateCallback$SocketState;", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes4.dex */
    public @interface SocketState {
    }

    void onSocketStateChange(String state, String info);

    /* compiled from: PTYSocketStateCallback.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/pitaya/api/PTYSocketStateCallback$Companion;", "", "()V", "CLOSED", "", "CONNECTED", "CONNECTING", "ERROR", "NONE", "UNKNOWN", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CLOSED = "closed";
        public static final String CONNECTED = "connected";
        public static final String CONNECTING = "connecting";
        public static final String ERROR = "error";
        public static final String NONE = "none";
        public static final String UNKNOWN = "unknown";

        private Companion() {
        }
    }
}
