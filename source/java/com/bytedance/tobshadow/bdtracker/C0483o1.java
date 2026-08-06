package com.bytedance.tobshadow.bdtracker;

import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.bytedance.tobshadow.bdtracker.o1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0483o1 extends AbstractC0476n1 {
    public C0483o1(HashSet<String> hashSet, HashMap<String, HashSet<String>> hashMap) {
        super(hashSet, hashMap);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0476n1
    /* renamed from: a */
    public boolean mo563a(String str) {
        return !this.f863a.contains(str);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0476n1
    /* renamed from: a */
    public boolean mo565a(HashSet<String> hashSet, String str) {
        return !hashSet.contains(str);
    }
}
