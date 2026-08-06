package com.bytedance.pia.core.utils;

import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: ManifestUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0002J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\u0012\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u000bH\u0007J&\u0010\u0016\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/pia/core/utils/ManifestUtils;", "", "()V", "HEAD_END", "", "LINK_END", "LINK_START", "MANIFEST_END", "MANIFEST_START_LEFT", "MANIFEST_START_RIGHT", "MAX_LOOK_BACK_SIZE", "", "extractPreloadLinks", "Lcom/google/gson/JsonObject;", "html", "mergeJsonObjects", "target", EventConstants.PARAM_SOURCE, "parseManifest", "Ljava/io/InputStream;", "encoding", "chunkSize", "parseManifestWithLink", "State", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ManifestUtils {
    private static final String HEAD_END = "</head>";
    public static final ManifestUtils INSTANCE = new ManifestUtils();
    private static final String LINK_END = ">";
    private static final String LINK_START = "<link";
    private static final String MANIFEST_END = "</script>";
    private static final String MANIFEST_START_LEFT = "<script pia-manifest";
    private static final String MANIFEST_START_RIGHT = "type=\"application/json\">";
    private static final int MAX_LOOK_BACK_SIZE = 32;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ManifestUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/pia/core/utils/ManifestUtils$State;", "", "(Ljava/lang/String;I)V", "Start", "ManifestStartLeft", "ManifestStartRight", LynxTimingPerformanceReportProcessor.KEY_END_SUFFIX, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum State {
        Start,
        ManifestStartLeft,
        ManifestStartRight,
        End
    }

    @JvmStatic
    public static final JsonObject parseManifest(InputStream inputStream) {
        return parseManifest$default(inputStream, null, 0, 3, null);
    }

    @JvmStatic
    public static final JsonObject parseManifest(InputStream inputStream, String str) {
        return parseManifest$default(inputStream, str, 0, 2, null);
    }

    @JvmStatic
    public static final JsonObject parseManifestWithLink(InputStream inputStream) {
        return parseManifestWithLink$default(inputStream, null, 0, 3, null);
    }

    @JvmStatic
    public static final JsonObject parseManifestWithLink(InputStream inputStream, String str) {
        return parseManifestWithLink$default(inputStream, str, 0, 2, null);
    }

    private ManifestUtils() {
    }

    @JvmStatic
    public static final JsonObject parseManifest(String html) {
        if (html == null) {
            html = "";
        }
        Charset charset = Charsets.UTF_8;
        if (html == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = html.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return parseManifestWithLink$default(new ByteArrayInputStream(bytes), null, 0, 3, null);
    }

    public static /* synthetic */ JsonObject parseManifestWithLink$default(InputStream inputStream, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            i = 1024;
        }
        return parseManifestWithLink(inputStream, str, i);
    }

    @JvmStatic
    public static final JsonObject parseManifestWithLink(InputStream inputStream, String str, int i) {
        Object obj;
        if (!Settings.INSTANCE.openParseLink()) {
            return parseManifest(inputStream, str, i);
        }
        if (inputStream == null) {
            return null;
        }
        State state = State.Start;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        StringBuilder sb = new StringBuilder();
        try {
            Result.Companion companion = Result.Companion;
            Sequence<char[]> asSequence = StreamUtils.asSequence(inputStream, str, i);
            StringBuilder sb2 = new StringBuilder();
            for (char[] cArr : asSequence) {
                int max = Math.max(0, sb2.length() - 32);
                sb2.append(cArr);
                sb.append(cArr);
                if (State.Start == state) {
                    Integer valueOf = Integer.valueOf(sb2.indexOf(MANIFEST_START_LEFT, max));
                    if (!(valueOf.intValue() != -1)) {
                        valueOf = null;
                    }
                    if (valueOf != null) {
                        int intValue = valueOf.intValue();
                        state = State.ManifestStartLeft;
                        sb2.delete(0, intValue + 20);
                        max = 0;
                    }
                }
                if (State.ManifestStartLeft == state) {
                    Integer valueOf2 = Integer.valueOf(sb2.indexOf(MANIFEST_START_RIGHT, max));
                    if (!(valueOf2.intValue() != -1)) {
                        valueOf2 = null;
                    }
                    if (valueOf2 != null) {
                        int intValue2 = valueOf2.intValue();
                        state = State.ManifestStartRight;
                        sb2.delete(0, intValue2 + 24);
                        max = 0;
                    }
                }
                if (State.ManifestStartRight == state) {
                    Integer valueOf3 = Integer.valueOf(sb2.indexOf(MANIFEST_END, max));
                    if (!(valueOf3.intValue() != -1)) {
                        valueOf3 = null;
                    }
                    if (valueOf3 != null) {
                        sb2.delete(valueOf3.intValue(), sb2.length());
                        try {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(GsonUtils.getParser().parse(sb2.toString()).getAsJsonObject());
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        objectRef.element = obj;
                        state = State.End;
                    }
                }
                if (sb.indexOf(HEAD_END, max) != -1) {
                    ManifestUtils manifestUtils = INSTANCE;
                    String sb3 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb3, "headBuilder.toString()");
                    JsonElement extractPreloadLinks = manifestUtils.extractPreloadLinks(sb3);
                    if (objectRef.element == null) {
                        if (extractPreloadLinks.size() <= 0) {
                            return null;
                        }
                        objectRef.element = new JsonObject();
                        Object obj2 = objectRef.element;
                        Intrinsics.checkNotNull(obj2);
                        ((JsonObject) obj2).add("resources", extractPreloadLinks);
                        return (JsonObject) objectRef.element;
                    }
                    if (extractPreloadLinks.size() > 0) {
                        Object obj3 = objectRef.element;
                        Intrinsics.checkNotNull(obj3);
                        JsonElement jsonElement = ((JsonObject) obj3).get("resources");
                        if (jsonElement != null && jsonElement.isJsonObject()) {
                            JsonObject asJsonObject = jsonElement.getAsJsonObject();
                            Intrinsics.checkNotNullExpressionValue(asJsonObject, "resources.asJsonObject");
                            manifestUtils.mergeJsonObjects(asJsonObject, extractPreloadLinks);
                        } else {
                            Object obj4 = objectRef.element;
                            Intrinsics.checkNotNull(obj4);
                            ((JsonObject) obj4).add("resources", extractPreloadLinks);
                        }
                    }
                    return (JsonObject) objectRef.element;
                }
            }
            Result.constructor-impl(sb2);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th2));
        }
        return (JsonObject) objectRef.element;
    }

    public static /* synthetic */ JsonObject parseManifest$default(InputStream inputStream, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            i = 1024;
        }
        return parseManifest(inputStream, str, i);
    }

    @JvmStatic
    public static final JsonObject parseManifest(InputStream inputStream, String str, int i) {
        Object obj;
        if (inputStream == null) {
            return null;
        }
        State state = State.Start;
        try {
            Result.Companion companion = Result.Companion;
            Sequence<char[]> asSequence = StreamUtils.asSequence(inputStream, str, i);
            StringBuilder sb = new StringBuilder();
            for (char[] cArr : asSequence) {
                int max = Math.max(0, sb.length() - 32);
                sb.append(cArr);
                if (State.Start == state) {
                    Integer valueOf = Integer.valueOf(sb.indexOf(MANIFEST_START_LEFT, max));
                    if (!(valueOf.intValue() != -1)) {
                        valueOf = null;
                    }
                    if (valueOf != null) {
                        int intValue = valueOf.intValue();
                        state = State.ManifestStartLeft;
                        sb.delete(0, intValue + 20);
                        max = 0;
                    }
                }
                if (State.ManifestStartLeft == state) {
                    Integer valueOf2 = Integer.valueOf(sb.indexOf(MANIFEST_START_RIGHT, max));
                    if (!(valueOf2.intValue() != -1)) {
                        valueOf2 = null;
                    }
                    if (valueOf2 != null) {
                        int intValue2 = valueOf2.intValue();
                        state = State.ManifestStartRight;
                        sb.delete(0, intValue2 + 24);
                        max = 0;
                    }
                }
                if (State.ManifestStartRight == state) {
                    Integer valueOf3 = Integer.valueOf(sb.indexOf(MANIFEST_END, max));
                    if (!(valueOf3.intValue() != -1)) {
                        valueOf3 = null;
                    }
                    if (valueOf3 != null) {
                        sb.delete(valueOf3.intValue(), sb.length());
                        try {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(GsonUtils.getParser().parse(sb.toString()).getAsJsonObject());
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        return (JsonObject) obj;
                    }
                }
                if (sb.indexOf(HEAD_END, max) != -1) {
                    return null;
                }
            }
            Result.constructor-impl(sb);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th2));
        }
        return null;
    }

    private final JsonObject mergeJsonObjects(JsonObject target, JsonObject source) {
        try {
            Set<Map.Entry> entrySet = source.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "source.entrySet()");
            for (Map.Entry entry : entrySet) {
                Intrinsics.checkNotNullExpressionValue(entry, "(key, value)");
                String str = (String) entry.getKey();
                JsonArray jsonArray = (JsonElement) entry.getValue();
                if (jsonArray instanceof JsonArray) {
                    if (target.has(str)) {
                        JsonArray asJsonArray = target.getAsJsonArray(str);
                        for (JsonElement jsonElement : (Iterable) jsonArray) {
                            if (!asJsonArray.contains(jsonElement)) {
                                asJsonArray.add(jsonElement);
                            }
                        }
                    } else {
                        target.add(str, jsonArray.deepCopy());
                    }
                }
            }
        } catch (Exception e) {
            Logger.e$default("mergeJsonObjectsError", e, null, 4, null);
        }
        return target;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e8, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final JsonObject extractPreloadLinks(String html) {
        int indexOf$default;
        int i;
        JsonObject jsonObject = new JsonObject();
        boolean z = false;
        int i2 = 0;
        while (true) {
            String str = html;
            int indexOf$default2 = StringsKt.indexOf$default(str, LINK_START, i2, false, 4, (Object) null);
            if (indexOf$default2 == -1 || (indexOf$default = StringsKt.indexOf$default(str, LINK_END, indexOf$default2, false, 4, (Object) null)) == -1) {
                break;
            }
            int i3 = indexOf$default + 1;
            if (html != null) {
                String substring = html.substring(indexOf$default2, i3);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String str2 = substring;
                if (StringsKt.contains$default(str2, "rel=\"preload\"", z, 2, (Object) null)) {
                    i = indexOf$default2;
                    int indexOf$default3 = StringsKt.indexOf$default(str2, "as=\"", 0, false, 6, (Object) null);
                    if (indexOf$default3 != -1) {
                        int i4 = indexOf$default3 + 4;
                        int indexOf$default4 = StringsKt.indexOf$default(str2, '\"', i4, false, 4, (Object) null);
                        if (indexOf$default4 != -1) {
                            int i5 = i + i4;
                            int i6 = i + indexOf$default4;
                            if (html != null) {
                                String substring2 = html.substring(i5, i6);
                                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                if (StringsKt.equals(substring2, "style", true)) {
                                    substring2 = "css";
                                }
                                String str3 = substring2;
                                int indexOf$default5 = StringsKt.indexOf$default(str2, "href=\"", 0, false, 6, (Object) null);
                                if (indexOf$default5 != -1) {
                                    int i7 = indexOf$default5 + 6;
                                    int indexOf$default6 = StringsKt.indexOf$default(str2, '\"', i7, false, 4, (Object) null);
                                    if (indexOf$default6 != -1) {
                                        int i8 = i + i7;
                                        int i9 = i + indexOf$default6;
                                        if (html != null) {
                                            String substring3 = html.substring(i8, i9);
                                            Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                            if (!jsonObject.has(str3)) {
                                                jsonObject.add(str3, new JsonArray());
                                            }
                                            jsonObject.getAsJsonArray(str3).add(substring3);
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                        }
                                    } else {
                                        continue;
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } else {
                    i = indexOf$default2;
                }
                i2 = i + 1;
                z = false;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
    }
}
