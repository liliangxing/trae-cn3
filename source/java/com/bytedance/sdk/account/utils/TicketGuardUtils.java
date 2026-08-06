package com.bytedance.sdk.account.utils;

import com.ss.android.TTHeader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class TicketGuardUtils {
    public static List<TTHeader> convertToTokenHeader(List<com.bytedance.android.sdk.bdticketguard.TTHeader> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.android.sdk.bdticketguard.TTHeader tTHeader : list) {
            arrayList.add(new TTHeader(tTHeader.getName(), tTHeader.getValue()));
        }
        return arrayList;
    }

    public static List<com.bytedance.android.sdk.bdticketguard.TTHeader> convertToTicketGuardHeader(List<TTHeader> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TTHeader tTHeader : list) {
            arrayList.add(new com.bytedance.android.sdk.bdticketguard.TTHeader(tTHeader.getName(), tTHeader.getValue()));
        }
        return arrayList;
    }
}
