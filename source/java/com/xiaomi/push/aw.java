package com.xiaomi.push;

import java.util.LinkedList;

/* loaded from: classes7.dex */
public class aw {
    private LinkedList<a> a = new LinkedList<>();

    /* loaded from: classes7.dex */
    public static class a {
        private static final aw a = new aw();

        /* renamed from: a, reason: collision with other field name */
        public int f190a;

        /* renamed from: a, reason: collision with other field name */
        public Object f191a;

        /* renamed from: a, reason: collision with other field name */
        public String f192a;

        a(int i, Object obj) {
            this.f190a = i;
            this.f191a = obj;
        }
    }

    public static aw a() {
        return a.a;
    }

    public synchronized void a(Object obj) {
        this.a.add(new a(0, obj));
        m9636a();
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m9636a() {
        if (this.a.size() > 100) {
            this.a.removeFirst();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized int m9637a() {
        return this.a.size();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized LinkedList<a> m9638a() {
        LinkedList<a> linkedList;
        linkedList = this.a;
        this.a = new LinkedList<>();
        return linkedList;
    }
}
