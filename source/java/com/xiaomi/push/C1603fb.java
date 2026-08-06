package com.xiaomi.push;

import com.ss.ttm.player.MediaPlayer;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* renamed from: com.xiaomi.push.fb */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1603fb {
    /* renamed from: a */
    public static int m2541a(Throwable th) {
        boolean z = th instanceof C1609fh;
        if (z) {
            C1609fh c1609fh = (C1609fh) th;
            if (c1609fh.m2560a() != null) {
                th = c1609fh.m2560a();
            }
        }
        String message = th.getMessage();
        if (th.getCause() != null) {
            message = th.getCause().getMessage();
        }
        if (th instanceof SocketTimeoutException) {
            return 105;
        }
        if (th instanceof SocketException) {
            if (message.indexOf("Network is unreachable") != -1) {
                return 102;
            }
            if (message.indexOf("Connection refused") != -1) {
                return 103;
            }
            if (message.indexOf("Connection timed out") != -1) {
                return 105;
            }
            if (message.endsWith("EACCES (Permission denied)")) {
                return 101;
            }
            if (message.indexOf("Connection reset by peer") != -1) {
                return 109;
            }
            if (message.indexOf("Broken pipe") != -1) {
                return 110;
            }
            if (message.indexOf("No route to host") != -1) {
                return 104;
            }
            return message.endsWith("EINVAL (Invalid argument)") ? 106 : 199;
        }
        if (th instanceof UnknownHostException) {
            return 107;
        }
        if (z) {
            return MediaPlayer.MEDIA_PLAYER_OPTION_BYTEVC1_SW_FORBIDDEN;
        }
        return 0;
    }
}
