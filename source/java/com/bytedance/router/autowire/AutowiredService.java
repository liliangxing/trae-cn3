package com.bytedance.router.autowire;

import android.util.LruCache;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class AutowiredService {
    private List<String> blackList;
    private LruCache<String, ISyringe> classCache;

    public static AutowiredService inst() {
        return Single.single;
    }

    /* loaded from: classes4.dex */
    private static final class Single {
        private static final AutowiredService single = new AutowiredService();

        private Single() {
        }
    }

    private AutowiredService() {
        this.classCache = new LruCache<>(66);
        this.blackList = new ArrayList();
    }

    public void autowire(Object obj) {
        String name = obj.getClass().getName();
        try {
            if (this.blackList.contains(name)) {
                return;
            }
            ISyringe iSyringe = this.classCache.get(name);
            if (iSyringe == null) {
                iSyringe = (ISyringe) Class.forName(obj.getClass().getName() + "$$SmartRouter$$Autowired").getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            iSyringe.inject(obj);
            this.classCache.put(name, iSyringe);
        } catch (Exception unused) {
            this.blackList.add(name);
        }
    }
}
