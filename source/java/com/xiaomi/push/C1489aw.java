package com.xiaomi.push;

import java.util.LinkedList;

/* renamed from: com.xiaomi.push.aw */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1489aw {

    /* renamed from: a */
    private LinkedList<a> f1024a = new LinkedList<>();

    /* renamed from: com.xiaomi.push.aw$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        private static final C1489aw f1025a = new C1489aw();

        /* renamed from: a */
        public int f1026a;

        /* renamed from: a */
        public Object f1027a;

        /* renamed from: a */
        public String f1028a;

        a(int i, Object obj) {
            this.f1026a = i;
            this.f1027a = obj;
        }
    }

    /* renamed from: a */
    public static C1489aw m1579a() {
        return a.f1025a;
    }

    /* renamed from: a */
    public synchronized void m1583a(Object obj) {
        this.f1024a.add(new a(0, obj));
        m1580a();
    }

    /* renamed from: a */
    private void m1580a() {
        if (this.f1024a.size() > 100) {
            this.f1024a.removeFirst();
        }
    }

    /* renamed from: a */
    public synchronized int m1581a() {
        return this.f1024a.size();
    }

    /* renamed from: a */
    public synchronized LinkedList<a> m1582a() {
        LinkedList<a> linkedList;
        linkedList = this.f1024a;
        this.f1024a = new LinkedList<>();
        return linkedList;
    }
}
