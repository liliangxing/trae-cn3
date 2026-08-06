package coil3;

import com.bytedance.framwork.core.sdklib.apm6.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okio.Path;

/* compiled from: Uri.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0016\u0010\t\u001a\u00020\u0003*\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0007\u001a \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u0002*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u001a\u0010\u0011\u001a\u00020\u0012*\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"pathSegments", "", "", "Lcoil3/Uri;", "getPathSegments", "(Lcoil3/Uri;)Ljava/util/List;", "filePath", "getFilePath", "(Lcoil3/Uri;)Ljava/lang/String;", "toUri", "separator", "parseUri", Constants.KEY_DATA, "original", "percentDecode", "bytes", "", "length", "", "getLength", "(Ljava/lang/String;)I", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class UriKt {
    public static final Uri toUri(String str) {
        return toUri$default(str, null, 1, null);
    }

    public static final List<String> getPathSegments(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int i = -1;
        while (i < path.length()) {
            int i2 = i + 1;
            int indexOf$default = StringsKt.indexOf$default(path, '/', i2, false, 4, (Object) null);
            if (indexOf$default == -1) {
                indexOf$default = path.length();
            }
            String substring = path.substring(i2, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            if (substring.length() > 0) {
                arrayList.add(substring);
            }
            i = indexOf$default;
        }
        return arrayList;
    }

    public static final String getFilePath(Uri uri) {
        List<String> pathSegments = getPathSegments(uri);
        if (pathSegments.isEmpty()) {
            return null;
        }
        String path = uri.getPath();
        Intrinsics.checkNotNull(path);
        return CollectionsKt.joinToString$default(pathSegments, uri.getSeparator(), StringsKt.startsWith$default(path, uri.getSeparator(), false, 2, (Object) null) ? uri.getSeparator() : "", (CharSequence) null, 0, (CharSequence) null, (Function1) null, 60, (Object) null);
    }

    public static /* synthetic */ Uri toUri$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = Path.DIRECTORY_SEPARATOR;
        }
        return toUri(str, str2);
    }

    public static final Uri toUri(String str, String str2) {
        return parseUri(!Intrinsics.areEqual(str2, "/") ? StringsKt.replace$default(str, str2, "/", false, 4, (Object) null) : str, str, str2);
    }

    private static final Uri parseUri(String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z = true;
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        while (i6 < str.length()) {
            char charAt = str.charAt(i6);
            if (charAt == ':') {
                if (z && i2 == -1 && i == -1) {
                    int i7 = i6 + 2;
                    if (i7 < str2.length() && str2.charAt(i6 + 1) == '/' && str2.charAt(i7) == '/') {
                        i4 = i6 + 3;
                        z = false;
                        i5 = i6;
                        i6 = i7;
                    } else if (Intrinsics.areEqual(str, str2)) {
                        i3 = i6 + 1;
                        i5 = i6;
                        i6 = i3;
                        i4 = i6;
                    }
                }
            } else if (charAt == '/') {
                if (i3 == -1 && i2 == -1 && i == -1) {
                    i3 = i4 == -1 ? 0 : i6;
                    z = false;
                }
            } else if (charAt == '?') {
                if (i2 == -1 && i == -1) {
                    i2 = i6 + 1;
                }
            } else if (charAt == '#' && i == -1) {
                i = i6 + 1;
            }
            i6++;
        }
        int min = Math.min(i == -1 ? Integer.MAX_VALUE : i - 1, str.length());
        int min2 = Math.min(i2 == -1 ? Integer.MAX_VALUE : i2 - 1, min);
        if (i4 != -1) {
            str5 = str.substring(0, i5);
            Intrinsics.checkNotNullExpressionValue(str5, "substring(...)");
            str4 = str.substring(i4, Math.min(i3 != -1 ? i3 : Integer.MAX_VALUE, min2));
            Intrinsics.checkNotNullExpressionValue(str4, "substring(...)");
        } else {
            str4 = null;
            str5 = null;
        }
        if (i3 != -1) {
            str6 = str.substring(i3, min2);
            Intrinsics.checkNotNullExpressionValue(str6, "substring(...)");
        } else {
            str6 = null;
        }
        if (i2 != -1) {
            str7 = str.substring(i2, min);
            Intrinsics.checkNotNullExpressionValue(str7, "substring(...)");
        } else {
            str7 = null;
        }
        if (i != -1) {
            str8 = str.substring(i, str.length());
            Intrinsics.checkNotNullExpressionValue(str8, "substring(...)");
        } else {
            str8 = null;
        }
        byte[] bArr = new byte[Math.max(0, Math.max(getLength(str5), Math.max(getLength(str4), Math.max(getLength(str6), Math.max(getLength(str7), getLength(str8))))) - 2)];
        return new Uri(str, str3, str5 != null ? percentDecode(str5, bArr) : null, str4 != null ? percentDecode(str4, bArr) : null, str6 != null ? percentDecode(str6, bArr) : null, str7 != null ? percentDecode(str7, bArr) : null, str8 != null ? percentDecode(str8, bArr) : null);
    }

    private static final String percentDecode(String str, byte[] bArr) {
        int length = str.length();
        int i = 0;
        int max = Math.max(0, length - 2);
        int i2 = 0;
        while (true) {
            if (i >= max) {
                if (i == i2) {
                    return str;
                }
                if (i >= length) {
                    return StringsKt.decodeToString$default(bArr, 0, i2, false, 5, (Object) null);
                }
            } else if (str.charAt(i) == '%') {
                int i3 = i + 3;
                try {
                    String substring = str.substring(i + 1, i3);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    bArr[i2] = (byte) Integer.parseInt(substring, CharsKt.checkRadix(16));
                    i2++;
                    i = i3;
                } catch (NumberFormatException unused) {
                }
            }
            bArr[i2] = (byte) str.charAt(i);
            i2++;
            i++;
        }
    }

    private static final int getLength(String str) {
        if (str != null) {
            return str.length();
        }
        return 0;
    }
}
