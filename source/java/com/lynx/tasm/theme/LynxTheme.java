package com.lynx.tasm.theme;

import java.util.HashMap;
import java.util.Set;

@Deprecated
/* loaded from: classes7.dex */
public class LynxTheme {
    private HashMap<String, String> mMap = new HashMap<>();
    private int mChangeCount = 0;

    public boolean update(String str, String str2) {
        if (str == null || str.isEmpty() || str.startsWith("__")) {
            return false;
        }
        if (str2 == null) {
            this.mMap.remove(str);
        } else {
            this.mMap.put(str, str2);
        }
        this.mChangeCount++;
        return true;
    }

    public String get(String str) {
        if (str == null) {
            return null;
        }
        return this.mMap.get(str);
    }

    public Set<String> keySet() {
        return this.mMap.keySet();
    }

    public int changeCount() {
        return this.mChangeCount;
    }

    public boolean replaceWithTheme(LynxTheme lynxTheme) {
        if (lynxTheme == null) {
            return false;
        }
        this.mMap = lynxTheme.mMap;
        this.mChangeCount++;
        return true;
    }

    public void addToHashMap(HashMap hashMap, String str) {
        hashMap.put(str, this.mMap);
    }
}
