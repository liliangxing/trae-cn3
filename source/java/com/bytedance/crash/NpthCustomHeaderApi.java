package com.bytedance.crash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class NpthCustomHeaderApi {
    private static CopyOnWriteArrayList<ICustomHeaderService> sList = new CopyOnWriteArrayList<>();

    /* loaded from: classes3.dex */
    public interface ICustomHeaderService {
        Map<String, String> getCustomHeader();
    }

    public static void addCustomHeaderService(ICustomHeaderService iCustomHeaderService) {
        if (iCustomHeaderService == null) {
            return;
        }
        sList.add(iCustomHeaderService);
    }

    public static void removeCustomHeaderService(ICustomHeaderService iCustomHeaderService) {
        if (iCustomHeaderService == null) {
            return;
        }
        sList.remove(iCustomHeaderService);
    }

    public static Map<String, String> getCustomHeaders() {
        if (sList.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(sList);
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            hashMap.putAll(((ICustomHeaderService) it.next()).getCustomHeader());
        }
        return hashMap;
    }
}
