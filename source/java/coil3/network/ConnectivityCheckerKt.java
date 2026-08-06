package coil3.network;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.core.content.ContextCompat;
import coil3.network.internal.UtilsKt;
import kotlin.Metadata;

/* compiled from: ConnectivityChecker.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0004j\u0002`\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"ConnectivityChecker", "Lcoil3/network/ConnectivityChecker;", "context", "Lcoil3/PlatformContext;", "Landroid/content/Context;", "(Landroid/content/Context;)Lcoil3/network/ConnectivityChecker;", "coil-network-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ConnectivityCheckerKt {
    public static final ConnectivityChecker ConnectivityChecker(Context context) {
        Context applicationContext = context.getApplicationContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(applicationContext, ConnectivityManager.class);
        if (connectivityManager == null || !UtilsKt.isPermissionGranted(applicationContext, "android.permission.ACCESS_NETWORK_STATE")) {
            return ConnectivityChecker.ONLINE;
        }
        try {
            return new ConnectivityCheckerApi23(connectivityManager);
        } catch (Exception unused) {
            return ConnectivityChecker.ONLINE;
        }
    }
}
