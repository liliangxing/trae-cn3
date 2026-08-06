package com.bytedance.salamander.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FoundationThread.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0001X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/salamander/adapter/Queue;", "", "name", "", "serial", "", "(Ljava/lang/String;Z)V", "isSerial", "()Z", "setSerial", "(Z)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "ref", "getRef", "()Ljava/lang/Object;", "setRef", "(Ljava/lang/Object;)V", "Companion", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class Queue {
    private boolean isSerial;
    private String name;
    private Object ref;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Queue main = new Queue("main", true);
    private static Queue background = new Queue("background", false);
    private static Queue utility = new Queue("utility", false);
    private static Queue userInteractive = new Queue("userInteractive", false);
    private static Queue userInitiated = new Queue("userInitiated", false);

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    /* renamed from: isSerial, reason: from getter */
    public boolean getIsSerial() {
        return this.isSerial;
    }

    public void setSerial(boolean z) {
        this.isSerial = z;
    }

    public Object getRef() {
        return this.ref;
    }

    public void setRef(Object obj) {
        this.ref = obj;
    }

    public Queue(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = "";
        this.isSerial = true;
        setName(str);
        setSerial(z);
        setRef(ThreadKt.queue(str, z));
    }

    public /* synthetic */ Queue(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? true : z);
    }

    /* compiled from: FoundationThread.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/salamander/adapter/Queue$Companion;", "", "()V", "background", "Lcom/bytedance/salamander/adapter/Queue;", "getBackground", "()Lcom/bytedance/salamander/adapter/Queue;", "setBackground", "(Lcom/bytedance/salamander/adapter/Queue;)V", "main", "getMain", "setMain", "userInitiated", "getUserInitiated", "setUserInitiated", "userInteractive", "getUserInteractive", "setUserInteractive", "utility", "getUtility", "setUtility", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public Queue getMain() {
            return Queue.main;
        }

        public void setMain(Queue queue) {
            Intrinsics.checkNotNullParameter(queue, "<set-?>");
            Queue.main = queue;
        }

        public Queue getBackground() {
            return Queue.background;
        }

        public void setBackground(Queue queue) {
            Queue.background = queue;
        }

        public Queue getUtility() {
            return Queue.utility;
        }

        public void setUtility(Queue queue) {
            Queue.utility = queue;
        }

        public Queue getUserInteractive() {
            return Queue.userInteractive;
        }

        public void setUserInteractive(Queue queue) {
            Queue.userInteractive = queue;
        }

        public Queue getUserInitiated() {
            return Queue.userInitiated;
        }

        public void setUserInitiated(Queue queue) {
            Queue.userInitiated = queue;
        }
    }
}
