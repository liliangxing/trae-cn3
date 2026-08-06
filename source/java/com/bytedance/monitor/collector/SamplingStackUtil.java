package com.bytedance.monitor.collector;

import androidx.core.app.NotificationCompat;
import com.ss.android.update.UpdateDialogNewBase;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public class SamplingStackUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class MethodItem implements Comparable<MethodItem> {
        long begin;
        long cpuCost;
        int depth;
        long duration;
        long end;
        boolean isSystemMethod;
        long methodId;

        public MethodItem(boolean z, int i, long j, long j2, long j3, long j4) {
            this.isSystemMethod = z;
            this.depth = i;
            this.methodId = j;
            this.begin = j2;
            this.end = j3;
            this.cpuCost = j4;
            this.duration = (j3 - j2) / 1000000;
        }

        @Override // java.lang.Comparable
        public int compareTo(MethodItem methodItem) {
            long j = this.begin;
            long j2 = methodItem.begin;
            if (j > j2) {
                return 1;
            }
            return j == j2 ? 0 : -1;
        }

        public String toString() {
            return this.depth + "," + (this.isSystemMethod ? NotificationCompat.CATEGORY_SYSTEM : "app") + "," + this.methodId + "," + this.begin + "," + this.end + "," + this.cpuCost;
        }
    }

    public static String trimStack(String str, StringBuilder sb, int i, long j) {
        LinkedList<MethodItem> sortStack = sortStack(str);
        while (sortStack.size() > i) {
            long j2 = 21;
            Iterator<MethodItem> it = sortStack.iterator();
            while (it.hasNext()) {
                if (it.next().duration < j2) {
                    it.remove();
                }
            }
        }
        Iterator<MethodItem> it2 = sortStack.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next().toString()).append('\n');
        }
        if (sortStack.size() == 0) {
            return null;
        }
        return getStackKey(sortStack, j);
    }

    private static LinkedList<MethodItem> sortStack(String str) {
        LinkedList<MethodItem> linkedList = new LinkedList<>();
        for (String str2 : str.split(UpdateDialogNewBase.TYPE)) {
            String[] split = str2.split(",");
            if (split != null && split.length >= 6) {
                linkedList.add(new MethodItem(split[1].startsWith(NotificationCompat.CATEGORY_SYSTEM), Integer.parseInt(split[0]), Long.parseLong(split[2]), Long.parseLong(split[3]), Long.parseLong(split[4]), Long.parseLong(split[5])));
            }
        }
        Collections.sort(linkedList);
        return linkedList;
    }

    public static String getStackString(String str) {
        if (str == null) {
            return null;
        }
        Iterator<MethodItem> it = sortStack(str).iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next().toString()).append('\n');
        }
        return sb.toString();
    }

    public static String getStackKey(List<MethodItem> list, long j) {
        StringBuilder sb = new StringBuilder();
        long j2 = ((float) j) * 0.3f;
        LinkedList linkedList = new LinkedList();
        for (MethodItem methodItem : list) {
            if (methodItem.end - methodItem.begin >= j2) {
                linkedList.add(methodItem);
            }
        }
        Collections.sort(linkedList, new Comparator<MethodItem>() { // from class: com.bytedance.monitor.collector.SamplingStackUtil.1
            @Override // java.util.Comparator
            public int compare(MethodItem methodItem2, MethodItem methodItem3) {
                return Long.compare((methodItem3.depth + 1) * (methodItem3.end - methodItem3.begin), (methodItem2.depth + 1) * (methodItem2.end - methodItem2.begin));
            }
        });
        if (linkedList.isEmpty() && !list.isEmpty()) {
            linkedList.add(list.get(0));
        }
        Iterator it = linkedList.iterator();
        if (it.hasNext()) {
            sb.append(((MethodItem) it.next()).methodId + UpdateDialogNewBase.TYPE);
        }
        return sb.toString();
    }
}
