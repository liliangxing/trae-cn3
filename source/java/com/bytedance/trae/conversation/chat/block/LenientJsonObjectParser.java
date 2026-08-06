package com.bytedance.trae.conversation.chat.block;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: LenientJsonObjectParser.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\tH\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;", "", "<init>", "()V", "parseTopLevelStrings", "", "", AccountMonitorConstants.CommonParameter.RAW, "skipWhitespace", "", "s", "start", "readJsonString", "Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;", "skipValue", "ReadResult", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class LenientJsonObjectParser {
    public static final LenientJsonObjectParser INSTANCE = new LenientJsonObjectParser();

    private LenientJsonObjectParser() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LenientJsonObjectParser.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;", "", "value", "", "complete", "", "nextIndex", "", "<init>", "(Ljava/lang/String;ZI)V", "getValue", "()Ljava/lang/String;", "getComplete", "()Z", "getNextIndex", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ReadResult {
        private final boolean complete;
        private final int nextIndex;
        private final String value;

        public static /* synthetic */ ReadResult copy$default(ReadResult readResult, String str, boolean z, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = readResult.value;
            }
            if ((i2 & 2) != 0) {
                z = readResult.complete;
            }
            if ((i2 & 4) != 0) {
                i = readResult.nextIndex;
            }
            return readResult.copy(str, z, i);
        }

        /* renamed from: component1, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getComplete() {
            return this.complete;
        }

        /* renamed from: component3, reason: from getter */
        public final int getNextIndex() {
            return this.nextIndex;
        }

        public final ReadResult copy(String value, boolean complete, int nextIndex) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new ReadResult(value, complete, nextIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReadResult)) {
                return false;
            }
            ReadResult readResult = (ReadResult) other;
            return Intrinsics.areEqual(this.value, readResult.value) && this.complete == readResult.complete && this.nextIndex == readResult.nextIndex;
        }

        public int hashCode() {
            return (((this.value.hashCode() * 31) + Boolean.hashCode(this.complete)) * 31) + Integer.hashCode(this.nextIndex);
        }

        public String toString() {
            return "ReadResult(value=" + this.value + ", complete=" + this.complete + ", nextIndex=" + this.nextIndex + ')';
        }

        public ReadResult(String str, boolean z, int i) {
            Intrinsics.checkNotNullParameter(str, "value");
            this.value = str;
            this.complete = z;
            this.nextIndex = i;
        }

        public final String getValue() {
            return this.value;
        }

        public final boolean getComplete() {
            return this.complete;
        }

        public final int getNextIndex() {
            return this.nextIndex;
        }
    }

    public final Map<String, String> parseTopLevelStrings(String raw) {
        char charAt;
        int skipWhitespace;
        Intrinsics.checkNotNullParameter(raw, AccountMonitorConstants.CommonParameter.RAW);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = raw.length();
        int skipWhitespace2 = skipWhitespace(raw, 0);
        if (skipWhitespace2 >= length || raw.charAt(skipWhitespace2) != '{') {
            return linkedHashMap;
        }
        loop0: do {
            int i = skipWhitespace2 + 1;
            while (true) {
                if (i < length) {
                    skipWhitespace2 = skipWhitespace(raw, i);
                    if (skipWhitespace2 < length) {
                        charAt = raw.charAt(skipWhitespace2);
                        if (charAt == '\"') {
                            ReadResult readJsonString = readJsonString(raw, skipWhitespace2);
                            if (!readJsonString.getComplete()) {
                                break loop0;
                            }
                            String value = readJsonString.getValue();
                            int skipWhitespace3 = skipWhitespace(raw, readJsonString.getNextIndex());
                            if (skipWhitespace3 >= length || raw.charAt(skipWhitespace3) != ':' || (skipWhitespace = skipWhitespace(raw, skipWhitespace3 + 1)) >= length) {
                                break loop0;
                            }
                            if (raw.charAt(skipWhitespace) == '\"') {
                                ReadResult readJsonString2 = readJsonString(raw, skipWhitespace);
                                linkedHashMap.put(value, readJsonString2.getValue());
                                if (!readJsonString2.getComplete()) {
                                    break loop0;
                                }
                                i = readJsonString2.getNextIndex();
                            } else {
                                ReadResult skipValue = skipValue(raw, skipWhitespace);
                                if (!skipValue.getComplete()) {
                                    break loop0;
                                }
                                i = skipValue.getNextIndex();
                            }
                        } else {
                            break;
                        }
                    } else {
                        break loop0;
                    }
                } else {
                    break loop0;
                }
            }
        } while (charAt == ',');
        return linkedHashMap;
    }

    private final int skipWhitespace(String s, int start) {
        while (start < s.length() && CharsKt.isWhitespace(s.charAt(start))) {
            start++;
        }
        return start;
    }

    private final ReadResult readJsonString(String s, int start) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int i = start + 1;
        while (i < length) {
            char charAt = s.charAt(i);
            if (charAt == '\"') {
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                return new ReadResult(sb2, true, i + 1);
            }
            if (charAt != '\\') {
                sb.append(charAt);
                i++;
            } else {
                int i2 = i + 1;
                if (i2 >= length) {
                    String sb3 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
                    return new ReadResult(sb3, false, length);
                }
                char charAt2 = s.charAt(i2);
                if (charAt2 == '\"') {
                    sb.append('\"');
                } else if (charAt2 == '/') {
                    sb.append('/');
                } else if (charAt2 == '\\') {
                    sb.append('\\');
                } else if (charAt2 == 'b') {
                    sb.append('\b');
                } else if (charAt2 == 'f') {
                    sb.append('\f');
                } else if (charAt2 == 'n') {
                    sb.append('\n');
                } else if (charAt2 == 'r') {
                    sb.append('\r');
                } else if (charAt2 == 't') {
                    sb.append('\t');
                } else if (charAt2 != 'u') {
                    sb.append(charAt2);
                } else {
                    int i3 = i + 6;
                    if (i3 <= length) {
                        String substring = s.substring(i + 2, i3);
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        Integer intOrNull = StringsKt.toIntOrNull(substring, 16);
                        if (intOrNull != null) {
                            sb.append((char) intOrNull.intValue());
                            i = i3;
                        } else {
                            sb.append(charAt2);
                        }
                    } else {
                        String sb4 = sb.toString();
                        Intrinsics.checkNotNullExpressionValue(sb4, "toString(...)");
                        return new ReadResult(sb4, false, length);
                    }
                }
                i += 2;
            }
        }
        String sb5 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb5, "toString(...)");
        return new ReadResult(sb5, false, length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0025, code lost:
    
        if (r4 != '}') goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ReadResult skipValue(String s, int start) {
        int length = s.length();
        int i = 0;
        while (start < length) {
            char charAt = s.charAt(start);
            if (charAt != '\"') {
                if (charAt != ',') {
                    if (charAt != '[') {
                        if (charAt != ']') {
                            if (charAt != '{') {
                            }
                        }
                        if (i == 0) {
                            return new ReadResult("", true, start);
                        }
                        i--;
                    }
                    i++;
                } else if (i == 0) {
                    return new ReadResult("", true, start);
                }
                start++;
            } else {
                ReadResult readJsonString = readJsonString(s, start);
                if (!readJsonString.getComplete()) {
                    return new ReadResult("", false, length);
                }
                start = readJsonString.getNextIndex();
            }
        }
        return new ReadResult("", false, length);
    }
}
