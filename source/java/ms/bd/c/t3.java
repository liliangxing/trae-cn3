package ms.bd.c;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: classes8.dex */
public final class t3 implements Runnable {
    public final /* synthetic */ u3 a;

    public t3(u3 u3Var) {
        this.a = u3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            u3 u3Var = this.a;
            if (u3Var.b != null) {
                u3Var.a.start();
                Handler handler = new Handler(this.a.a.getLooper());
                u3 u3Var2 = this.a;
                u3Var2.d = (DisplayManager) u3Var2.b.getApplicationContext().getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "8ce276", new byte[]{45, 104, 5, 86, 4, 32, 34}));
                DisplayManager displayManager = this.a.d;
                if (displayManager != null) {
                    Display[] displays = displayManager.getDisplays();
                    int length = displays.length;
                    if (length > 1) {
                        if (r3.j == null) {
                            r3.j = new r3();
                        }
                        r3 r3Var = r3.j;
                        r3Var.getClass();
                        String b = r3.b(displays);
                        String a = r3.a(displays);
                        if (r3Var.d != length) {
                            r3Var.e = System.currentTimeMillis() / 1000;
                        }
                        r3Var.d = length;
                        r3Var.i = true;
                        if (!TextUtils.isEmpty(b)) {
                            r3Var.g = b;
                        }
                        if (!TextUtils.isEmpty(a)) {
                            r3Var.h = a;
                        }
                    }
                    u3 u3Var3 = this.a;
                    DisplayManager displayManager2 = u3Var3.d;
                    e0 e0Var = new e0(displayManager2);
                    u3Var3.e = e0Var;
                    displayManager2.registerDisplayListener(e0Var, handler);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
