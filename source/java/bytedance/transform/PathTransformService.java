package bytedance.transform;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import bytedance.io.exception.IllegalPathException;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
class PathTransformService {
    private static final String[] PARTITION_DIRECTORIES = {"/data", "/sdcard", "/storage", "/mnt"};
    private static final String[] STANDARD_DIRECTORIES = {Environment.DIRECTORY_MUSIC, Environment.DIRECTORY_PODCASTS, Environment.DIRECTORY_RINGTONES, Environment.DIRECTORY_ALARMS, Environment.DIRECTORY_NOTIFICATIONS, Environment.DIRECTORY_PICTURES, Environment.DIRECTORY_MOVIES, Environment.DIRECTORY_DOWNLOADS, Environment.DIRECTORY_DCIM};
    private static PathTransformService sInstance;
    private String externalAppDir;
    private String internalAppDir;
    private String internalCanonicalAppDir;
    private boolean initialized = false;
    private String redirectDir = "externalTemp";
    private String externalRootDir = Environment.getExternalStorageDirectory().getPath();
    private String aliasExternalRootDir = "/sdcard";

    PathTransformService() {
    }

    public static synchronized PathTransformService getInstance() {
        PathTransformService pathTransformService;
        synchronized (PathTransformService.class) {
            if (sInstance == null) {
                sInstance = new PathTransformService();
            }
            pathTransformService = sInstance;
        }
        return pathTransformService;
    }

    public String transform(String str, Context context) throws IllegalPathException {
        return Build.VERSION.SDK_INT <= 28 ? str : (Build.VERSION.SDK_INT == 29 && Environment.isExternalStorageLegacy()) ? str : reslovePath(str, context);
    }

    private void initPath(Context context) {
        if (this.initialized) {
            return;
        }
        if (TextUtils.isEmpty(this.internalAppDir)) {
            this.internalAppDir = context.getFilesDir().getParent();
        }
        if (TextUtils.isEmpty(this.internalCanonicalAppDir)) {
            try {
                this.internalCanonicalAppDir = context.getFilesDir().getParentFile().getCanonicalPath();
            } catch (IOException unused) {
                this.internalCanonicalAppDir = "/data/data/" + context.getPackageName();
            }
        }
        if (TextUtils.isEmpty(this.externalAppDir)) {
            this.externalAppDir = context.getExternalCacheDir().getParent();
        }
        if (TextUtils.isEmpty(this.externalRootDir)) {
            this.externalRootDir = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        this.initialized = true;
    }

    private String reslovePath(String str, Context context) throws IllegalPathException {
        String str2;
        initPath(context);
        String removeDupSlash = removeDupSlash(str);
        if (isPrivateDirectory(removeDupSlash) || !isExternalDirectory(removeDupSlash)) {
            return removeDupSlash;
        }
        String subDirectory = getSubDirectory(removeDupSlash);
        if (TextUtils.isEmpty(subDirectory) || "/".equals(subDirectory)) {
            str2 = subDirectory;
        } else {
            if (subDirectory.startsWith("/")) {
                subDirectory = subDirectory.replaceFirst("/", "");
            }
            str2 = subDirectory;
            subDirectory = subDirectory.split(File.separator)[0];
        }
        if (isStandardDirectory(subDirectory)) {
            throw new IllegalPathException(removeDupSlash, "Please Use MediaStore Api.");
        }
        return removeDupSlash(this.externalAppDir + File.separator + this.redirectDir + File.separator + str2);
    }

    private boolean isStandardDirectory(String str) {
        for (String str2 : STANDARD_DIRECTORIES) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPrivateDirectory(String str) {
        return str.startsWith(this.internalAppDir) || str.startsWith(this.internalCanonicalAppDir) || str.startsWith(this.externalAppDir);
    }

    private boolean isExternalDirectory(String str) {
        return str.startsWith(this.externalRootDir) || str.startsWith(this.aliasExternalRootDir);
    }

    private String getSubDirectory(String str) {
        if (str.startsWith(this.externalRootDir)) {
            return str.replaceFirst(this.externalRootDir, "");
        }
        return str.startsWith(this.aliasExternalRootDir) ? str.replaceFirst(this.aliasExternalRootDir, "") : "";
    }

    public String removeDupSlash(String str) {
        int length = str.length();
        char[] charArray = str.toCharArray();
        int i = 0;
        char c = 0;
        int i2 = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 != '/' || c != '/') {
                charArray[i2] = c2;
                i2++;
            }
            i++;
            c = c2;
        }
        if (c == '/' && length > 1) {
            i2--;
        }
        return i2 != length ? new String(charArray, 0, i2) : str;
    }
}
