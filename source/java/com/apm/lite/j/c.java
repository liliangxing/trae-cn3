package com.apm.lite.j;

import com.apm.lite.CrashType;
import com.bytedance.crash.entity.CrashBody;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class c {
    private static ConcurrentLinkedQueue<c> a = new ConcurrentLinkedQueue<>();

    /* renamed from: com.apm.lite.j.c$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CrashType.values().length];
            a = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private JSONObject a;
        private JSONObject b;
        private CrashType c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject, CrashType crashType) {
            this.c = crashType;
            if (crashType == CrashType.LAUNCH) {
                this.a = ((JSONArray) jSONObject.opt("data")).optJSONObject(0);
            } else {
                this.a = jSONObject;
            }
            this.b = jSONObject.optJSONObject("header");
        }

        public String a() {
            return this.a.optString(CrashBody.CRASH_THREAD_NAME, null);
        }

        public long b() {
            return this.a.optLong("app_start_time", -1L);
        }

        public String c() {
            int i = AnonymousClass1.a[this.c.ordinal()];
            if (i == 1) {
                return this.a.optString("data", null);
            }
            if (i == 2) {
                return this.a.optString("stack", null);
            }
            if (i != 3) {
                return null;
            }
            return this.a.optString("data", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CrashType crashType, JSONObject jSONObject) {
        ConcurrentLinkedQueue<c> concurrentLinkedQueue = a;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return;
        }
        a aVar = new a(jSONObject, crashType);
        while (!a.isEmpty()) {
            c poll = a.poll();
            if (poll != null) {
                poll.a(crashType, aVar);
            }
        }
        a = null;
    }

    public abstract void a(CrashType crashType, a aVar);
}
