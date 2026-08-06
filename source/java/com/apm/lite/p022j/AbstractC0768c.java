package com.apm.lite.p022j;

import com.apm.lite.CrashType;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.apm.lite.j.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class AbstractC0768c {

    /* renamed from: a */
    private static ConcurrentLinkedQueue<AbstractC0768c> f526a = new ConcurrentLinkedQueue<>();

    /* renamed from: com.apm.lite.j.c$1, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f527a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f527a = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f527a[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f527a[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: com.apm.lite.j.c$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class a {

        /* renamed from: a */
        private JSONObject f528a;

        /* renamed from: b */
        private JSONObject f529b;

        /* renamed from: c */
        private CrashType f530c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject, CrashType crashType) {
            this.f530c = crashType;
            if (crashType == CrashType.LAUNCH) {
                this.f528a = ((JSONArray) jSONObject.opt(Constants.KEY_DATA)).optJSONObject(0);
            } else {
                this.f528a = jSONObject;
            }
            this.f529b = jSONObject.optJSONObject(Constants.KEY_HEADER);
        }

        /* renamed from: a */
        public String m682a() {
            return this.f528a.optString("crash_thread_name", null);
        }

        /* renamed from: b */
        public long m683b() {
            return this.f528a.optLong("app_start_time", -1L);
        }

        /* renamed from: c */
        public String m684c() {
            int i = AnonymousClass1.f527a[this.f530c.ordinal()];
            if (i == 1) {
                return this.f528a.optString(Constants.KEY_DATA, null);
            }
            if (i == 2) {
                return this.f528a.optString("stack", null);
            }
            if (i != 3) {
                return null;
            }
            return this.f528a.optString(Constants.KEY_DATA, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m680a(CrashType crashType, JSONObject jSONObject) {
        ConcurrentLinkedQueue<AbstractC0768c> concurrentLinkedQueue = f526a;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return;
        }
        a aVar = new a(jSONObject, crashType);
        while (!f526a.isEmpty()) {
            AbstractC0768c poll = f526a.poll();
            if (poll != null) {
                poll.m681a(crashType, aVar);
            }
        }
        f526a = null;
    }

    /* renamed from: a */
    public abstract void m681a(CrashType crashType, a aVar);
}
