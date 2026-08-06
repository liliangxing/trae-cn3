package com.bytedance.tobshadow.bdtracker;

import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes5.dex */
public class o1 extends n1 {
    public o1(HashSet<String> hashSet, HashMap<String, HashSet<String>> hashMap) {
        super(hashSet, hashMap);
    }

    @Override // com.bytedance.tobshadow.bdtracker.n1
    public boolean a(String str) {
        return !this.a.contains(str);
    }

    @Override // com.bytedance.tobshadow.bdtracker.n1
    public boolean a(HashSet<String> hashSet, String str) {
        return !hashSet.contains(str);
    }
}
