package ms.bd.c;

import com.ss.ttm.player.MediaPlayer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import okio.Utf8;
import org.bouncycastle.math.ec.Tnaf;

/* loaded from: classes8.dex */
public abstract class v {
    public static final String a = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "a7ce96", new byte[]{64, 39, 31, 18, 3, 50, 113, 25, 32});
    public static final String b = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "12cfb9", new byte[]{8, 49, 2, 22, 74, 47, 32, 22});
    public static final String c = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f0b44b", new byte[]{81, 55, Tnaf.POW_2_WIDTH, 84, 30, 103, 96, 2});
    public static final String d = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "9cad6a", new byte[]{56, 98});
    public static final String e = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "fe9478", new byte[]{Byte.MAX_VALUE, 112});
    public static final String f = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "7109ca", new byte[]{32, 39});
    public static final String g = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "e1092e", new byte[]{121, 50, 91});
    public static final String h = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "28da52", new byte[]{46, 51, 25});
    public static final String i = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "024b3c", new byte[]{34, Utf8.REPLACEMENT_BYTE, 85, 19});
    public static final u j = new u();

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0041, code lost:
    
        if (r10 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        File file;
        String str2 = null;
        try {
            file = new File(str);
        } catch (Throwable unused) {
            fileReader = null;
            bufferedReader = null;
        }
        if (!file.exists()) {
            return (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "0ad581", new byte[]{113});
        }
        fileReader = new FileReader(file);
        try {
            bufferedReader = new BufferedReader(fileReader);
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        try {
            str2 = bufferedReader.readLine();
            try {
                bufferedReader.close();
            } catch (Throwable unused3) {
            }
        } catch (Throwable unused4) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused5) {
                }
            }
        }
        try {
            fileReader.close();
        } catch (Throwable unused6) {
            return str2 == null ? (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "d34651", new byte[]{37}) : str2.trim();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b0, code lost:
    
        if (r2 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap a() {
        FileReader fileReader;
        HashMap hashMap = new HashMap();
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "0e4185", new byte[]{110, 119, 85, 74, 4, 109, 48, 84, 112, 104, 47, 97, 72}));
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            try {
                                break;
                            } catch (Throwable unused) {
                            }
                        } else {
                            String[] split = readLine.split((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "27c013", new byte[]{121}), 2);
                            if (split.length >= 2) {
                                String trim = split[0].trim();
                                String trim2 = split[1].trim();
                                if (hashMap.get(trim) == null) {
                                    hashMap.put(trim, trim2);
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused3) {
                            }
                        }
                    }
                }
                bufferedReader2.close();
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            fileReader = null;
        }
        try {
            fileReader.close();
        } catch (Throwable unused6) {
            return hashMap;
        }
    }

    public static String a(HashMap hashMap, String str) {
        String str2;
        try {
            str2 = (String) hashMap.get(str);
        } catch (Throwable unused) {
            str2 = null;
        }
        return str2 == null ? "" : str2.trim();
    }
}
