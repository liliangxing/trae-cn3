package com.bytedance.memory.test;

import com.bytedance.memory.common.MemoryUtils;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class OOMMaker {
    private static ArrayList<byte[]> sArrayList = new ArrayList<>();

    public static void createOOM() {
        while (true) {
            encreaseMem(2097152);
        }
    }

    public static void encreaseMem() {
        encreaseMem(15728640);
    }

    private static void encreaseMem(int i) {
        sArrayList.add(new byte[i]);
    }

    public static void createReachTop(int i) {
        while (MemoryUtils.getMemoryRate() < i) {
            encreaseMem();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
