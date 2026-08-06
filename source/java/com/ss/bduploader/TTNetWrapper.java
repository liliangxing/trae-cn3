package com.ss.bduploader;

import com.bytedance.ttnet.TTNetInit;
import java.net.InetAddress;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TTNetWrapper {
    public static List<InetAddress> dnsLookup(String str) {
        try {
            return TTNetInit.dnsLookup(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
