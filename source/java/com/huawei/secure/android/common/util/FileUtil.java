package com.huawei.secure.android.common.util;

import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.platform.godzilla.common.Constant;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import io.noties.markwon.image.CustomImageSizeResolverDef;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Locale;

/* loaded from: classes6.dex */
public class FileUtil {
    private static String a(String str) {
        int lastIndexOf;
        int i;
        return (str.isEmpty() || (lastIndexOf = str.lastIndexOf(LibrarianImpl.Constants.DOT)) == -1 || (i = lastIndexOf + 1) == str.length()) ? "" : str.substring(i).toLowerCase(Locale.ENGLISH);
    }

    public static boolean checkFileExtValid(String str, String[] strArr) {
        if (str != null && !str.isEmpty() && strArr != null) {
            String a = a(str);
            for (String str2 : strArr) {
                if (a.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean filePathIsValid(String str, String str2) throws IllegalArgumentException, IOException {
        if (str != null && !str.equals("") && str2 != null && !str2.equals("")) {
            try {
                String decode = URLDecoder.decode(str2, Constant.CHARSET_UTF_8);
                String decode2 = URLDecoder.decode(str, Constant.CHARSET_UTF_8);
                if (!decode2.contains(DownloadConstants.VULNERABILITY_PATH) && !decode2.contains("./") && !decode2.contains(".\\.\\") && !decode2.contains("%00") && !decode.contains(DownloadConstants.VULNERABILITY_PATH) && !decode.contains("./") && !decode.contains(".\\.\\") && !decode.contains("%00")) {
                    return new File(decode2, decode).getCanonicalPath().startsWith(new File(decode2).getCanonicalPath());
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return false;
    }

    public static boolean filePathIsValidNew(String str) throws IOException {
        if (str == null || str.equals("")) {
            return false;
        }
        String name = new File(str.trim()).getName();
        return filePathIsValid(str.substring(0, str.lastIndexOf(name)), name);
    }

    @Deprecated
    public static boolean filePathIsValid(String str) throws UnsupportedEncodingException {
        if (str == null || str.equals("")) {
            return true;
        }
        if (str.contains(CustomImageSizeResolverDef.UNIT_PERCENT)) {
            str = str.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
        }
        String decode = URLDecoder.decode(str, Constant.CHARSET_UTF_8);
        return (decode.contains(DownloadConstants.VULNERABILITY_PATH) || decode.contains("./") || decode.contains(".\\.\\") || decode.contains("%00")) ? false : true;
    }
}
