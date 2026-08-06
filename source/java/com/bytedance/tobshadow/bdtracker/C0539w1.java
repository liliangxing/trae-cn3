package com.bytedance.tobshadow.bdtracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.bytedance.tobshadow.bdtracker.w1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0539w1 {

    /* renamed from: a */
    public final LinkedList<AbstractC0479n4> f1181a = new LinkedList<>();

    /* renamed from: b */
    public final LinkedList<String> f1182b = new LinkedList<>();

    /* renamed from: a */
    public int m721a(ArrayList<AbstractC0479n4> arrayList, C0467m c0467m, C0510s0 c0510s0) {
        int size;
        synchronized (this.f1181a) {
            size = this.f1181a.size();
            Iterator<AbstractC0479n4> it = this.f1181a.iterator();
            while (it.hasNext()) {
                AbstractC0479n4 next = it.next();
                c0510s0.m651a(c0467m, next, arrayList);
                arrayList.add(next);
            }
            this.f1181a.clear();
        }
        return size;
    }

    /* renamed from: a */
    public void m722a(AbstractC0479n4 abstractC0479n4) {
        synchronized (this.f1181a) {
            if (this.f1181a.size() > 300) {
                this.f1181a.poll();
            }
            this.f1181a.add(abstractC0479n4);
        }
    }

    /* renamed from: a */
    public void m723a(String[] strArr) {
        synchronized (this.f1182b) {
            if (this.f1182b.size() > 300) {
                this.f1182b.poll();
            }
            this.f1182b.addAll(Arrays.asList(strArr));
        }
    }
}
