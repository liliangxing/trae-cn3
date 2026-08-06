package com.bytedance.rts.foundation;

import com.bytedance.push.frontier.interfaze.IFrontierMonitor;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: console.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/rts/foundation/console;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class console {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: console.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ#\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\fJ#\u0010\u000e\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\fJ#\u0010\u000f\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/rts/foundation/console$Companion;", "", "()V", "assert", "", "value", "", "message", "", "error", "messages", "", "([Ljava/lang/Object;)V", "info", IFrontierMonitor.KEY_LOG, "warn", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void log(Object... messages) {
            Intrinsics.checkNotNullParameter(messages, "messages");
            System.out.println((Object) ArraysKt.joinToString$default(messages, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }

        public final void error(Object... messages) {
            Intrinsics.checkNotNullParameter(messages, "messages");
            System.err.println("RTSError:" + ArraysKt.joinToString$default(messages, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }

        public final void info(Object... messages) {
            Intrinsics.checkNotNullParameter(messages, "messages");
            System.out.println((Object) ("RTSInfo:" + ArraysKt.joinToString$default(messages, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)));
        }

        public final void warn(Object... messages) {
            Intrinsics.checkNotNullParameter(messages, "messages");
            System.err.println("RTSWarning:" + ArraysKt.joinToString$default(messages, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }

        public static /* synthetic */ void assert$default(Companion companion, boolean z, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            companion.m834assert(z, str);
        }

        /* renamed from: assert, reason: not valid java name */
        public final void m834assert(boolean value, String message) {
            if (value) {
                return;
            }
            if (message == null) {
                message = "Assertion failed";
            }
            System.out.println((Object) ("RTSAssertion: " + message));
            System.exit(1);
        }
    }
}
