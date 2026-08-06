package io.noties.markwon.html.jsoup.parser;

import io.noties.markwon.html.jsoup.UncheckedIOException;
import io.noties.markwon.html.jsoup.helper.Validate;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes6.dex */
public final class CharacterReader {
    static final char EOF = 65535;
    static final int maxBufferLen = 4096;
    private static final int maxStringCacheLen = 12;
    private static final int readAheadLimit = 3072;
    private int bufLength;
    private int bufMark;
    private int bufPos;
    private int bufSplitPoint;
    private final char[] charBuf;
    private final Reader reader;
    private int readerPos;
    private final String[] stringCache;

    public CharacterReader(Reader reader, int i) {
        this.stringCache = new String[128];
        Validate.notNull(reader);
        Validate.isTrue(reader.markSupported());
        this.reader = reader;
        this.charBuf = new char[4096];
        bufferUp();
    }

    public CharacterReader(Reader reader) {
        this(reader, 4096);
    }

    public CharacterReader(String str) {
        this(new StringReader(str), str.length());
    }

    private void bufferUp() {
        int i = this.bufPos;
        if (i < this.bufSplitPoint) {
            return;
        }
        try {
            this.reader.skip(i);
            this.reader.mark(4096);
            int read = this.reader.read(this.charBuf);
            this.reader.reset();
            if (read != -1) {
                this.bufLength = read;
                this.readerPos += this.bufPos;
                this.bufPos = 0;
                this.bufMark = 0;
                if (read > readAheadLimit) {
                    read = readAheadLimit;
                }
                this.bufSplitPoint = read;
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public int pos() {
        return this.readerPos + this.bufPos;
    }

    public boolean isEmpty() {
        bufferUp();
        return this.bufPos >= this.bufLength;
    }

    private boolean isEmptyNoBufferUp() {
        return this.bufPos >= this.bufLength;
    }

    public char current() {
        bufferUp();
        if (isEmptyNoBufferUp()) {
            return (char) 65535;
        }
        return this.charBuf[this.bufPos];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char consume() {
        bufferUp();
        char c = isEmptyNoBufferUp() ? (char) 65535 : this.charBuf[this.bufPos];
        this.bufPos++;
        return c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unconsume() {
        this.bufPos--;
    }

    public void advance() {
        this.bufPos++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mark() {
        this.bufMark = this.bufPos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rewindToMark() {
        this.bufPos = this.bufMark;
    }

    int nextIndexOf(char c) {
        bufferUp();
        for (int i = this.bufPos; i < this.bufLength; i++) {
            if (c == this.charBuf[i]) {
                return i - this.bufPos;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
    
        r2 = r1 + 1;
        r4 = (r9.length() + r2) - 1;
        r5 = r8.bufLength;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r1 >= r5) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r4 > r5) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        r5 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (r5 >= r4) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        if (r9.charAt(r3) != r8.charBuf[r5]) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r5 = r5 + 1;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        if (r5 != r4) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
    
        return r1 - r8.bufPos;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
    
        if (r0 != r8.charBuf[r1]) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        if (r1 >= r8.bufLength) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if (r0 == r8.charBuf[r1]) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int nextIndexOf(CharSequence charSequence) {
        bufferUp();
        char charAt = charSequence.charAt(0);
        int i = this.bufPos;
        while (i < this.bufLength) {
            int i2 = 1;
        }
        return -1;
    }

    public String consumeTo(char c) {
        int nextIndexOf = nextIndexOf(c);
        if (nextIndexOf != -1) {
            String cacheString = cacheString(this.charBuf, this.stringCache, this.bufPos, nextIndexOf);
            this.bufPos += nextIndexOf;
            return cacheString;
        }
        return consumeToEnd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String consumeTo(String str) {
        int nextIndexOf = nextIndexOf(str);
        if (nextIndexOf != -1) {
            String cacheString = cacheString(this.charBuf, this.stringCache, this.bufPos, nextIndexOf);
            this.bufPos += nextIndexOf;
            return cacheString;
        }
        return consumeToEnd();
    }

    public String consumeToAny(char... cArr) {
        bufferUp();
        int i = this.bufPos;
        int i2 = this.bufLength;
        char[] cArr2 = this.charBuf;
        loop0: while (this.bufPos < i2) {
            for (char c : cArr) {
                if (cArr2[this.bufPos] == c) {
                    break loop0;
                }
            }
            this.bufPos++;
        }
        int i3 = this.bufPos;
        return i3 > i ? cacheString(this.charBuf, this.stringCache, i, i3 - i) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String consumeToAnySorted(char... cArr) {
        bufferUp();
        int i = this.bufPos;
        int i2 = this.bufLength;
        char[] cArr2 = this.charBuf;
        while (true) {
            int i3 = this.bufPos;
            if (i3 >= i2 || Arrays.binarySearch(cArr, cArr2[i3]) >= 0) {
                break;
            }
            this.bufPos++;
        }
        int i4 = this.bufPos;
        return i4 > i ? cacheString(this.charBuf, this.stringCache, i, i4 - i) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return cacheString(r6.charBuf, r6.stringCache, r0, r3 - r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String consumeData() {
        char c;
        bufferUp();
        int i = this.bufPos;
        int i2 = this.bufLength;
        char[] cArr = this.charBuf;
        while (true) {
            int i3 = this.bufPos;
            if (i3 >= i2 || (c = cArr[i3]) == '&' || c == '<' || c == 0) {
                break;
            }
            this.bufPos = i3 + 1;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return cacheString(r6.charBuf, r6.stringCache, r0, r3 - r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String consumeTagName() {
        char c;
        bufferUp();
        int i = this.bufPos;
        int i2 = this.bufLength;
        char[] cArr = this.charBuf;
        while (true) {
            int i3 = this.bufPos;
            if (i3 >= i2 || (c = cArr[i3]) == '\t' || c == '\n' || c == '\r' || c == '\f' || c == ' ' || c == '/' || c == '>' || c == 0) {
                break;
            }
            this.bufPos = i3 + 1;
        }
        return "";
    }

    String consumeToEnd() {
        bufferUp();
        char[] cArr = this.charBuf;
        String[] strArr = this.stringCache;
        int i = this.bufPos;
        String cacheString = cacheString(cArr, strArr, i, this.bufLength - i);
        this.bufPos = this.bufLength;
        return cacheString;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String consumeLetterSequence() {
        char c;
        bufferUp();
        int i = this.bufPos;
        while (true) {
            int i2 = this.bufPos;
            if (i2 >= this.bufLength || (((c = this.charBuf[i2]) < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !Character.isLetter(c)))) {
                break;
            }
            this.bufPos++;
        }
        return cacheString(this.charBuf, this.stringCache, i, this.bufPos - i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String consumeLetterThenDigitSequence() {
        char c;
        bufferUp();
        int i = this.bufPos;
        while (true) {
            int i2 = this.bufPos;
            if (i2 >= this.bufLength || (((c = this.charBuf[i2]) < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !Character.isLetter(c)))) {
                break;
            }
            this.bufPos++;
        }
        while (!isEmptyNoBufferUp()) {
            char[] cArr = this.charBuf;
            int i3 = this.bufPos;
            char c2 = cArr[i3];
            if (c2 < '0' || c2 > '9') {
                break;
            }
            this.bufPos = i3 + 1;
        }
        return cacheString(this.charBuf, this.stringCache, i, this.bufPos - i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String consumeHexSequence() {
        int i;
        char c;
        bufferUp();
        int i2 = this.bufPos;
        while (true) {
            i = this.bufPos;
            if (i >= this.bufLength || (((c = this.charBuf[i]) < '0' || c > '9') && ((c < 'A' || c > 'F') && (c < 'a' || c > 'f')))) {
                break;
            }
            this.bufPos = i + 1;
        }
        return cacheString(this.charBuf, this.stringCache, i2, i - i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String consumeDigitSequence() {
        int i;
        char c;
        bufferUp();
        int i2 = this.bufPos;
        while (true) {
            i = this.bufPos;
            if (i >= this.bufLength || (c = this.charBuf[i]) < '0' || c > '9') {
                break;
            }
            this.bufPos = i + 1;
        }
        return cacheString(this.charBuf, this.stringCache, i2, i - i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean matches(char c) {
        return !isEmpty() && this.charBuf[this.bufPos] == c;
    }

    boolean matches(String str) {
        bufferUp();
        int length = str.length();
        if (length > this.bufLength - this.bufPos) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != this.charBuf[this.bufPos + i]) {
                return false;
            }
        }
        return true;
    }

    boolean matchesIgnoreCase(String str) {
        bufferUp();
        int length = str.length();
        if (length > this.bufLength - this.bufPos) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (Character.toUpperCase(str.charAt(i)) != Character.toUpperCase(this.charBuf[this.bufPos + i])) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean matchesAny(char... cArr) {
        if (isEmpty()) {
            return false;
        }
        bufferUp();
        char c = this.charBuf[this.bufPos];
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean matchesAnySorted(char[] cArr) {
        bufferUp();
        return !isEmpty() && Arrays.binarySearch(cArr, this.charBuf[this.bufPos]) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean matchesLetter() {
        if (isEmpty()) {
            return false;
        }
        char c = this.charBuf[this.bufPos];
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || Character.isLetter(c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean matchesDigit() {
        char c;
        return !isEmpty() && (c = this.charBuf[this.bufPos]) >= '0' && c <= '9';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean matchConsume(String str) {
        bufferUp();
        if (!matches(str)) {
            return false;
        }
        this.bufPos += str.length();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean matchConsumeIgnoreCase(String str) {
        if (!matchesIgnoreCase(str)) {
            return false;
        }
        this.bufPos += str.length();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean containsIgnoreCase(String str) {
        return nextIndexOf(str.toLowerCase(Locale.ENGLISH)) > -1 || nextIndexOf(str.toUpperCase(Locale.ENGLISH)) > -1;
    }

    public String toString() {
        char[] cArr = this.charBuf;
        int i = this.bufPos;
        return new String(cArr, i, this.bufLength - i);
    }

    private static String cacheString(char[] cArr, String[] strArr, int i, int i2) {
        if (i2 > 12) {
            return new String(cArr, i, i2);
        }
        if (i2 < 1) {
            return "";
        }
        int i3 = 0;
        int i4 = i;
        int i5 = 0;
        while (i3 < i2) {
            i5 = (i5 * 31) + cArr[i4];
            i3++;
            i4++;
        }
        int length = i5 & (strArr.length - 1);
        String str = strArr[length];
        if (str == null) {
            String str2 = new String(cArr, i, i2);
            strArr[length] = str2;
            return str2;
        }
        if (rangeEquals(cArr, i, i2, str)) {
            return str;
        }
        String str3 = new String(cArr, i, i2);
        strArr[length] = str3;
        return str3;
    }

    static boolean rangeEquals(char[] cArr, int i, int i2, String str) {
        if (i2 != str.length()) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 == 0) {
                return true;
            }
            int i5 = i + 1;
            int i6 = i3 + 1;
            if (cArr[i] != str.charAt(i3)) {
                return false;
            }
            i = i5;
            i2 = i4;
            i3 = i6;
        }
    }

    boolean rangeEquals(int i, int i2, String str) {
        return rangeEquals(this.charBuf, i, i2, str);
    }
}
