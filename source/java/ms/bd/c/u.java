package ms.bd.c;

import com.ss.ttm.player.MediaPlayer;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* loaded from: classes8.dex */
public final class u implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return Pattern.matches((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "ab1ba8", new byte[]{115, 112, 87, 45, 14, 98, 59, 126}), file.getName());
    }
}
