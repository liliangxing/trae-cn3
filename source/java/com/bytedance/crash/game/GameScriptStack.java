package com.bytedance.crash.game;

import android.text.TextUtils;
import com.bytedance.crash.IScriptCallback;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class GameScriptStack {
    private static final String FILE_NAME = "game_script_stack.txt";
    private static IScriptCallback sCallback;

    public static void setCallback(IScriptCallback iScriptCallback) {
        sCallback = iScriptCallback;
    }

    public static void dump(File file) {
        IScriptCallback iScriptCallback = sCallback;
        if (iScriptCallback != null) {
            try {
                String scriptStackWhenCrash = iScriptCallback.getScriptStackWhenCrash();
                if (scriptStackWhenCrash != null) {
                    FileSystemUtils.writeFile(new File(file, FILE_NAME), scriptStackWhenCrash);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void putTo(JSONObject jSONObject, File file) {
        File file2 = new File(file, FILE_NAME);
        if (file2.exists()) {
            String readUtf8File = FileSystemUtils.readUtf8File(file2);
            if (TextUtils.isEmpty(readUtf8File)) {
                return;
            }
            JSONUtils.put(jSONObject, "game_script_stack", readUtf8File);
        }
    }
}
