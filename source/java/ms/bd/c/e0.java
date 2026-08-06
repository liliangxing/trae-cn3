package ms.bd.c;

import android.hardware.display.DisplayManager;
import android.text.TextUtils;
import android.view.Display;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: classes8.dex */
public final class e0 implements DisplayManager.DisplayListener {
    public final DisplayManager a;

    public e0(DisplayManager displayManager) {
        this.a = displayManager;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
        try {
            Display[] displays = this.a.getDisplays();
            int length = displays.length;
            if (length > 0) {
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
                if (!TextUtils.isEmpty(b)) {
                    r3Var.g = b;
                }
                if (!TextUtils.isEmpty(a)) {
                    r3Var.h = a;
                }
                r3Var.a = System.currentTimeMillis() / 1000;
                r3Var.f = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "73890a", new byte[]{39, 53, 79});
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
        try {
            Display[] displays = this.a.getDisplays();
            int length = displays.length;
            if (length > 0) {
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
                if (!TextUtils.isEmpty(b)) {
                    r3Var.g = b;
                }
                if (!TextUtils.isEmpty(a)) {
                    r3Var.h = a;
                }
                r3Var.b = System.currentTimeMillis() / 1000;
                r3Var.f = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "c7f849", new byte[]{96, 48, 24, 67, 29, 43});
            }
        } catch (Exception unused) {
        }
    }
}
