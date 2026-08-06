package com.bytedance.lynx.service.reporter.performance;

import android.net.Uri;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.lynx.tasm.core.ResManager;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LynxPerformanceReportProcessorUtils.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJB\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/lynx/service/reporter/performance/LynxPerformanceReportProcessorUtils;", "", "()V", "ERROR_END_IS_ZERO", "", "ERROR_START_AND_END_ARE_ZERO", "ERROR_START_IS_ZERO", "ERROR_START_TIME_GREATER_THAN_END_TIME", "calculateDuration", "", "startTime", "endTime", "formatPath", "", "path", "processEntry", "", "entry", "startSuffix", "endSuffix", "keyPrefix", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LynxPerformanceReportProcessorUtils {
    private static final int ERROR_END_IS_ZERO = -2;
    private static final int ERROR_START_AND_END_ARE_ZERO = -3;
    private static final int ERROR_START_IS_ZERO = -1;
    private static final int ERROR_START_TIME_GREATER_THAN_END_TIME = -4;
    public static final LynxPerformanceReportProcessorUtils INSTANCE = new LynxPerformanceReportProcessorUtils();

    private LynxPerformanceReportProcessorUtils() {
    }

    public final Number calculateDuration(Number startTime, Number endTime) {
        if (startTime == null) {
            if (endTime == null) {
                return (Number) (-3);
            }
            return (Number) (-1);
        }
        if (endTime == null) {
            return (Number) (-2);
        }
        double doubleValue = startTime.doubleValue();
        double doubleValue2 = endTime.doubleValue();
        if (doubleValue > doubleValue2) {
            return (Number) (-4);
        }
        return Double.valueOf(doubleValue2 - doubleValue);
    }

    public static /* synthetic */ Map processEntry$default(LynxPerformanceReportProcessorUtils lynxPerformanceReportProcessorUtils, Map map, String str, String str2, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = null;
        }
        return lynxPerformanceReportProcessorUtils.processEntry(map, str, str2, str3);
    }

    public final Map<String, Object> processEntry(Map<String, ? extends Object> entry, String startSuffix, String endSuffix, String keyPrefix) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(startSuffix, "startSuffix");
        Intrinsics.checkNotNullParameter(endSuffix, "endSuffix");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<String, ? extends Object> entry2 : entry.entrySet()) {
            String key = entry2.getKey();
            Object value = entry2.getValue();
            if (StringsKt.endsWith$default(key, startSuffix, false, 2, (Object) null)) {
                String removeSuffix = StringsKt.removeSuffix(key, (CharSequence) startSuffix);
                processEntry$processDurationPair(linkedHashSet, entry, linkedHashMap, keyPrefix, removeSuffix, key, removeSuffix + endSuffix);
            } else if (StringsKt.endsWith$default(key, endSuffix, false, 2, (Object) null)) {
                String removeSuffix2 = StringsKt.removeSuffix(key, (CharSequence) endSuffix);
                processEntry$processDurationPair(linkedHashSet, entry, linkedHashMap, keyPrefix, removeSuffix2, removeSuffix2 + startSuffix, key);
            } else {
                boolean z = value instanceof Map;
                if (z) {
                    Map<String, ? extends Object> map = z ? (Map) value : null;
                    if (map != null) {
                        linkedHashMap.putAll(processEntry(map, startSuffix, endSuffix, key));
                    } else {
                        linkedHashMap.put(processEntry$getKey(keyPrefix, key), value);
                    }
                } else {
                    linkedHashMap.put(processEntry$getKey(keyPrefix, key), value);
                }
            }
        }
        return linkedHashMap;
    }

    private static final String processEntry$getKey(String str, String str2) {
        String str3;
        if (str == null) {
            return str2;
        }
        StringBuilder append = new StringBuilder().append(str);
        if (str2.length() > 0) {
            StringBuilder sb = new StringBuilder();
            String upperCase = String.valueOf(str2.charAt(0)).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            StringBuilder append2 = sb.append((Object) upperCase);
            String substring = str2.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            str3 = append2.append(substring).toString();
        } else {
            str3 = str2;
        }
        String sb2 = append.append(str3).toString();
        return sb2 == null ? str2 : sb2;
    }

    private static final void processEntry$processDurationPair(Set<String> set, Map<String, ? extends Object> map, Map<String, Object> map2, String str, String str2, String str3, String str4) {
        if (set.contains(str2)) {
            return;
        }
        set.add(str2);
        String processEntry$getKey = processEntry$getKey(str, str2);
        Object obj = map.get(str3);
        Number number = obj instanceof Number ? (Number) obj : null;
        Object obj2 = map.get(str4);
        map2.put(processEntry$getKey, INSTANCE.calculateDuration(number, obj2 instanceof Number ? (Number) obj2 : null));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0078 A[Catch: Exception -> 0x00e6, TryCatch #0 {Exception -> 0x00e6, blocks: (B:25:0x0053, B:27:0x0060, B:28:0x0067, B:30:0x006c, B:35:0x0078, B:37:0x007d, B:39:0x0093, B:44:0x009f, B:45:0x00a8, B:47:0x00ad, B:52:0x00b9, B:56:0x00c7, B:57:0x00cc, B:59:0x00d5, B:63:0x00e2), top: B:24:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007d A[Catch: Exception -> 0x00e6, TryCatch #0 {Exception -> 0x00e6, blocks: (B:25:0x0053, B:27:0x0060, B:28:0x0067, B:30:0x006c, B:35:0x0078, B:37:0x007d, B:39:0x0093, B:44:0x009f, B:45:0x00a8, B:47:0x00ad, B:52:0x00b9, B:56:0x00c7, B:57:0x00cc, B:59:0x00d5, B:63:0x00e2), top: B:24:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009f A[Catch: Exception -> 0x00e6, TryCatch #0 {Exception -> 0x00e6, blocks: (B:25:0x0053, B:27:0x0060, B:28:0x0067, B:30:0x006c, B:35:0x0078, B:37:0x007d, B:39:0x0093, B:44:0x009f, B:45:0x00a8, B:47:0x00ad, B:52:0x00b9, B:56:0x00c7, B:57:0x00cc, B:59:0x00d5, B:63:0x00e2), top: B:24:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b9 A[Catch: Exception -> 0x00e6, TryCatch #0 {Exception -> 0x00e6, blocks: (B:25:0x0053, B:27:0x0060, B:28:0x0067, B:30:0x006c, B:35:0x0078, B:37:0x007d, B:39:0x0093, B:44:0x009f, B:45:0x00a8, B:47:0x00ad, B:52:0x00b9, B:56:0x00c7, B:57:0x00cc, B:59:0x00d5, B:63:0x00e2), top: B:24:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e2 A[Catch: Exception -> 0x00e6, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e6, blocks: (B:25:0x0053, B:27:0x0060, B:28:0x0067, B:30:0x006c, B:35:0x0078, B:37:0x007d, B:39:0x0093, B:44:0x009f, B:45:0x00a8, B:47:0x00ad, B:52:0x00b9, B:56:0x00c7, B:57:0x00cc, B:59:0x00d5, B:63:0x00e2), top: B:24:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String formatPath(String path) {
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        String str2 = path;
        boolean z4 = true;
        if (str2 == null || str2.length() == 0) {
            return path;
        }
        if (StringsKt.startsWith$default(path, ResManager.HTTP_SCHEME, false, 2, (Object) null) || StringsKt.startsWith$default(path, "https://", false, 2, (Object) null) || StringsKt.startsWith$default(path, "local_file://", false, 2, (Object) null)) {
            try {
                String path2 = Uri.parse(path).getPath();
                return path2 == null ? path : path2;
            } catch (Exception unused) {
                return path;
            }
        }
        if (!StringsKt.startsWith$default(path, "lynxview://", false, 2, (Object) null) && !StringsKt.startsWith$default(path, "aweme://", false, 2, (Object) null) && !StringsKt.startsWith$default(path, "sslocal://", false, 2, (Object) null) && !StringsKt.startsWith$default(path, "hybrid://", false, 2, (Object) null)) {
            return path;
        }
        try {
            Uri parse = Uri.parse(path);
            String queryParameter = parse.getQueryParameter(SchemaConstants.QUERY_KEY_SURL);
            if (queryParameter == null) {
                queryParameter = parse.getQueryParameter("url");
            }
            String str3 = queryParameter;
            if (str3 != null && str3.length() != 0) {
                z = false;
                if (z) {
                    return formatPath(queryParameter);
                }
                String queryParameter2 = parse.getQueryParameter("channel");
                String queryParameter3 = parse.getQueryParameter("bundle");
                StringBuilder sb = new StringBuilder();
                String str4 = queryParameter2;
                if (str4 != null && str4.length() != 0) {
                    z2 = false;
                    if (!z2) {
                        sb.append("channel=").append(queryParameter2);
                    }
                    str = queryParameter3;
                    if (str != null && str.length() != 0) {
                        z3 = false;
                        if (!z3) {
                            if (sb.length() > 0) {
                                sb.append(ContainerUtils.FIELD_DELIMITER);
                            }
                            sb.append("bundle=").append(queryParameter3);
                        }
                        if (sb.length() > 0) {
                            z4 = false;
                        }
                        return !z4 ? sb.toString() : path;
                    }
                    z3 = true;
                    if (!z3) {
                    }
                    if (sb.length() > 0) {
                    }
                    if (!z4) {
                    }
                }
                z2 = true;
                if (!z2) {
                }
                str = queryParameter3;
                if (str != null) {
                    z3 = false;
                    if (!z3) {
                    }
                    if (sb.length() > 0) {
                    }
                    if (!z4) {
                    }
                }
                z3 = true;
                if (!z3) {
                }
                if (sb.length() > 0) {
                }
                if (!z4) {
                }
            }
            z = true;
            if (z) {
            }
        } catch (Exception unused2) {
            return path;
        }
    }
}
