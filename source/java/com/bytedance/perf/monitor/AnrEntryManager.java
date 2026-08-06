package com.bytedance.perf.monitor;

import com.ss.android.update.UpdateDialogNewBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes4.dex */
public class AnrEntryManager {
    public static long FOUND_DURATION = 600000;
    public static int MAX_ANR_SIZE = 3;
    public static int MAX_QUEUE_SIZE = 10;
    public static LinkedBlockingQueue<AnrEntry> mAnrEntries = new LinkedBlockingQueue<>(MAX_QUEUE_SIZE);

    public static void putAnr(AnrEntry anrEntry) {
        if (mAnrEntries == null) {
            mAnrEntries = new LinkedBlockingQueue<>(MAX_QUEUE_SIZE);
        }
        try {
            if (mAnrEntries.size() == MAX_QUEUE_SIZE) {
                mAnrEntries.take();
            }
            mAnrEntries.put(anrEntry);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getCostTop2Stack(AnrEntry anrEntry) {
        if (checkIsSafe(anrEntry)) {
            return anrEntry.stack;
        }
        StringBuilder sb = new StringBuilder(anrEntry == null ? "" : anrEntry.stack);
        ArrayList arrayList = new ArrayList();
        Iterator<AnrEntry> it = mAnrEntries.iterator();
        while (it.hasNext()) {
            AnrEntry next = it.next();
            if (next != null) {
                arrayList.add(next);
            }
        }
        Collections.sort(arrayList);
        int min = Math.min(MAX_ANR_SIZE, arrayList.size());
        for (int i = 0; i < min - 1; i++) {
            if (arrayList.get(i) != null) {
                sb.append(UpdateDialogNewBase.TYPE).append(((AnrEntry) arrayList.get(i)).stack);
            }
        }
        return sb.toString();
    }

    private static boolean checkIsSafe(AnrEntry anrEntry) {
        LinkedBlockingQueue<AnrEntry> linkedBlockingQueue = mAnrEntries;
        return (linkedBlockingQueue == null || linkedBlockingQueue.isEmpty()) && anrEntry != null;
    }

    public static void clear() {
        mAnrEntries.clear();
    }
}
