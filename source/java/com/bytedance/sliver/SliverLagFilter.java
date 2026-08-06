package com.bytedance.sliver;

import com.bytedance.librarian.LibrarianImpl;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/* loaded from: classes5.dex */
class SliverLagFilter {
    SliverLagFilter() {
    }

    public static StackTraceElement[] filter(SliverLagStack sliverLagStack, long j) {
        LinkedList linkedList = new LinkedList();
        fillInStackTrace(sliverLagStack, linkedList, j);
        return (StackTraceElement[]) linkedList.toArray(new StackTraceElement[0]);
    }

    private static void fillInStackTrace(SliverLagStack sliverLagStack, LinkedList<StackTraceElement> linkedList, long j) {
        if (sliverLagStack.getChildStack().isEmpty()) {
            return;
        }
        Collections.sort(sliverLagStack.getChildStack(), new Comparator<SliverLagStack>() { // from class: com.bytedance.sliver.SliverLagFilter.1
            @Override // java.util.Comparator
            public int compare(SliverLagStack sliverLagStack2, SliverLagStack sliverLagStack3) {
                long cost = sliverLagStack3.getCost();
                long cost2 = sliverLagStack2.getCost();
                if (cost < cost2) {
                    return -1;
                }
                return cost == cost2 ? 0 : 1;
            }
        });
        SliverLagStack sliverLagStack2 = sliverLagStack.getChildStack().get(0);
        if (sliverLagStack2.getCost() > j) {
            linkedList.addFirst(toStackTraceElement(sliverLagStack2, sliverLagStack2.getLine()));
            fillInStackTrace(sliverLagStack2, linkedList, j);
        }
    }

    private static StackTraceElement toStackTraceElement(SliverLagStack sliverLagStack, String str) {
        String str2;
        String str3;
        int cost = (int) (sliverLagStack.getCost() / 1000000);
        String str4 = str.split(Constants.COLON_SEPARATOR)[1];
        if (str4.contains("(")) {
            String str5 = str4.split("\\(")[0].split(" ")[1];
            str2 = str5.substring(str5.lastIndexOf(LibrarianImpl.Constants.DOT) + 1);
            str3 = str5.substring(0, str5.lastIndexOf(LibrarianImpl.Constants.DOT));
        } else {
            str2 = str4;
            str3 = "java.lang.SliverThreadState";
        }
        return new StackTraceElement(str3, str2, "CostMs", cost);
    }
}
