package com.lynx.tasm.utils;

import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.FontFace;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FontFaceParser {
    private static final String SRC_FORMAT_ERROR = "Src format error";
    private static final String TAG = "FontFaceParser";

    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        while (i < str.length() && (str.charAt(i) == ' ' || str.charAt(i) == '\"' || str.charAt(i) == '\'')) {
            i++;
        }
        if (i >= str.length()) {
            return null;
        }
        int length = str.length() - 1;
        while (length > i && (str.charAt(length) == ' ' || str.charAt(length) == '\"' || str.charAt(length) == '\'')) {
            length--;
        }
        return str.substring(i, length + 1);
    }

    public static FontFace parse(LynxContext lynxContext, String str) {
        boolean z;
        int i;
        String trim = trim(str);
        if (trim == null) {
            reportSrcFormatError(lynxContext, "Font-family is empty", "");
            return null;
        }
        Map fontFaces = lynxContext.getFontFaces(trim);
        if (fontFaces == null) {
            return null;
        }
        FontFace fontFace = new FontFace();
        fontFace.setFontFamily(trim);
        boolean z2 = false;
        for (Object obj : fontFaces.values()) {
            if (!(obj instanceof String)) {
                reportSrcFormatError(lynxContext, "Src is not string", obj.toString());
            } else {
                String str2 = (String) obj;
                int length = str2.length();
                int i2 = 0;
                while (true) {
                    z = true;
                    if (i2 >= length) {
                        break;
                    }
                    int indexOf = str2.indexOf("url(", i2);
                    int indexOf2 = str2.indexOf("local(", i2);
                    if (indexOf == -1 && indexOf2 == -1) {
                        break;
                    }
                    if (indexOf == -1 || indexOf2 == -1) {
                        if (indexOf != -1) {
                            int indexOf3 = str2.indexOf(")", indexOf);
                            if (indexOf3 == -1) {
                                break;
                            }
                            i = indexOf3 + 2;
                            String trimSrc = trimSrc(str2.substring(indexOf + 4, indexOf3));
                            if (trimSrc == null) {
                                break;
                            }
                            if (!checkIsWoffFormat(trimSrc)) {
                                fontFace.addUrl(trimSrc);
                                i2 = i;
                            }
                            z2 = true;
                            i2 = i;
                        } else {
                            int indexOf4 = str2.indexOf(")", indexOf2);
                            if (indexOf4 == -1) {
                                break;
                            }
                            i = indexOf4 + 2;
                            String trimSrc2 = trimSrc(str2.substring(indexOf2 + 6, indexOf4));
                            if (trimSrc2 == null) {
                                break;
                            }
                            if (!checkIsWoffFormat(trimSrc2)) {
                                fontFace.addLocal(trimSrc2);
                                i2 = i;
                            }
                            z2 = true;
                            i2 = i;
                        }
                    } else if (indexOf < indexOf2) {
                        int indexOf5 = str2.indexOf(")", indexOf);
                        if (indexOf5 == -1) {
                            break;
                        }
                        i = indexOf5 + 2;
                        String trimSrc3 = trimSrc(str2.substring(indexOf + 4, indexOf5));
                        if (trimSrc3 == null) {
                            break;
                        }
                        if (!checkIsWoffFormat(trimSrc3)) {
                            fontFace.addUrl(trimSrc3);
                            i2 = i;
                        }
                        z2 = true;
                        i2 = i;
                    } else {
                        int indexOf6 = str2.indexOf(")", indexOf2);
                        if (indexOf6 == -1) {
                            break;
                        }
                        i = indexOf6 + 2;
                        String trimSrc4 = trimSrc(str2.substring(indexOf2 + 6, indexOf6));
                        if (trimSrc4 == null) {
                            break;
                        }
                        if (!checkIsWoffFormat(trimSrc4)) {
                            fontFace.addLocal(trimSrc4);
                            i2 = i;
                        }
                        z2 = true;
                        i2 = i;
                    }
                }
                z = false;
                if (!z) {
                    reportSrcFormatError(lynxContext, SRC_FORMAT_ERROR, str2);
                }
                if (z2 && fontFace.getSrc().isEmpty()) {
                    reportFontFileFormatError(lynxContext, "The woff file format is not supported on Android", str2);
                }
            }
        }
        return fontFace;
    }

    private static boolean checkIsWoffFormat(String str) {
        return str.endsWith(".woff") || str.endsWith(".woff2");
    }

    private static String trimSrc(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        int i = (str.startsWith("'") || str.startsWith("\"")) ? 1 : 0;
        if (str.endsWith("'") || str.endsWith("\"")) {
            length--;
        }
        if (i > length) {
            return null;
        }
        return str.substring(i, length);
    }

    private static void reportSrcFormatError(LynxContext lynxContext, String str, String str2) {
        lynxContext.reportResourceError(str2, "font", new LynxError(30201, str));
        LLog.e(TAG, str + ",src:" + str2);
    }

    private static void reportFontFileFormatError(LynxContext lynxContext, String str, String str2) {
        lynxContext.reportResourceError(str2, "font", new LynxError(30204, str));
        LLog.e(TAG, str + ",src:" + str2);
    }
}
