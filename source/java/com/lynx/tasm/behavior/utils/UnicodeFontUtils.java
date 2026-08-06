package com.lynx.tasm.behavior.utils;

import com.larus.business.markdown.impl.markwon.EmojiReader;
import com.lynx.tasm.behavior.PropertyIDConstants;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.ttm.player.MediaPlayer;
import java.lang.Character;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public class UnicodeFontUtils {
    public static final int DECODE_CJK_INSERT_WORD_JOINER = 2;
    public static final int DECODE_DEFAULT = 0;
    public static final int DECODE_INSERT_ZERO_WIDTH_CHAR = 1;

    /* JADX WARN: Multi-variable type inference failed */
    public static String decodeCSSContent(String str, int i) {
        int i2;
        InsertCharContext insertCharContext = null;
        Object[] objArr = 0;
        if (str == null) {
            return null;
        }
        if (i == 0 && str.indexOf(92) < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        if (i != 0) {
            insertCharContext = new InsertCharContext();
        }
        int i3 = 0;
        while (i3 < length) {
            if (str.charAt(i3) == '\\' && (i2 = i3 + 1) < length) {
                StringBuilder sb2 = new StringBuilder();
                for (i2 = i3 + 1; i2 < length && i2 < i3 + 5; i2++) {
                    char charAt = str.charAt(i2);
                    if ((charAt >= '0' && charAt <= '9') || ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z'))) {
                        sb2.append(charAt);
                    }
                }
                try {
                    sb.append((char) Integer.parseInt(sb2.toString(), 16));
                    i3 += sb2.length();
                } catch (Exception unused) {
                    sb.append(str.charAt(i3));
                }
            } else {
                sb.append(str.charAt(i3));
            }
            if (i != 0) {
                insertCharContext.InsertExtraChar(sb, i);
            }
            i3++;
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String decode(String str, int i) {
        int i2;
        int i3;
        int i4;
        int parseInt;
        InsertCharContext insertCharContext = null;
        Object[] objArr = 0;
        if (str == null) {
            return null;
        }
        if (i == 0 && str.indexOf(38) < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        if (i != 0) {
            insertCharContext = new InsertCharContext();
        }
        int i5 = 0;
        while (i5 < length) {
            if (str.charAt(i5) == '&' && (i4 = i5 + 1) < length && str.charAt(i4) == '#') {
                int i6 = i5 + 2;
                i3 = i6;
                while (i3 < length && i3 < i6 + 10 + 1) {
                    if (str.charAt(i3) == ';') {
                        break;
                    }
                    i3++;
                }
                i3 = -1;
                if (i3 == -1) {
                    sb.append(str.charAt(i5));
                } else {
                    try {
                        if (str.charAt(i6) == 'x') {
                            parseInt = Integer.parseInt(str.subSequence(i5 + 3, i3).toString(), 16);
                        } else {
                            parseInt = Integer.parseInt(str.subSequence(i6, i3).toString(), 10);
                        }
                        sb.appendCodePoint(parseInt);
                    } catch (Exception unused) {
                        sb.append(str.charAt(i5));
                    }
                }
                if (i != 0) {
                }
                i5++;
            } else {
                if (str.charAt(i5) != '&' || (i2 = i5 + 1) >= length) {
                    sb.append(str.charAt(i5));
                } else {
                    i3 = i2;
                    while (i3 < length && i3 < i5 + 7 + 1) {
                        char charAt = str.charAt(i3);
                        if (charAt == ';') {
                            break;
                        }
                        if ((charAt < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z')) {
                            break;
                        }
                        i3++;
                    }
                    i3 = -1;
                    if (i3 == -1) {
                        sb.append(str.charAt(i5));
                    } else {
                        int decodeEntity = decodeEntity(str.subSequence(i2, i3).toString());
                        if (decodeEntity > 0) {
                            sb.append((char) decodeEntity);
                        }
                    }
                }
                if (i != 0) {
                    insertCharContext.InsertExtraChar(sb, i);
                }
                i5++;
            }
            i5 = i3;
            if (i != 0) {
            }
            i5++;
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int decodeEntity(String str) {
        char c;
        str.hashCode();
        switch (str.hashCode()) {
            case -1419323836:
                if (str.equals("agrave")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1368034367:
                if (str.equals("cacute")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1339299958:
                if (str.equals("dagger")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1220935388:
                if (str.equals("hellip")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1196259461:
                if (str.equals("iacute")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1190290628:
                if (str.equals("igrave")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1093812015:
                if (str.equals("lsaquo")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1074341375:
                if (str.equals("middot")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -991722477:
                if (str.equals("permil")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -922037109:
                if (str.equals("rsaquo")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -874702154:
                if (str.equals("thinsp")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 3294:
                if (str.equals("ge")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 3309:
                if (str.equals("gt")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 3449:
                if (str.equals("le")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 3464:
                if (str.equals("lt")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 96708:
                if (str.equals("amp")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 107431:
                if (str.equals("lrm")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 113011:
                if (str.equals("rlm")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 121037:
                if (str.equals("zwj")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 3035411:
                if (str.equals("bull")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 3059573:
                if (str.equals("copy")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 3075965:
                if (str.equals("darr")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 3117317:
                if (str.equals("emsp")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 3118278:
                if (str.equals("ensp")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case 3354221:
                if (str.equals("mldr")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case 3374865:
                if (str.equals("nbsp")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case 3482377:
                if (str.equals("quot")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 3752377:
                if (str.equals("zwnj")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case 77382239:
                if (str.equals("Prime")) {
                    c = 28;
                    break;
                }
                c = 65535;
                break;
            case 92925156:
                if (str.equals("amacr")) {
                    c = 29;
                    break;
                }
                c = 65535;
                break;
            case 93596489:
                if (str.equals("bdquo")) {
                    c = 30;
                    break;
                }
                c = 65535;
                break;
            case 94431411:
                if (str.equals("caron")) {
                    c = 31;
                    break;
                }
                c = 65535;
                break;
            case 96619240:
                if (str.equals("emacr")) {
                    c = ' ';
                    break;
                }
                c = 65535;
                break;
            case 97692206:
                if (str.equals("frasl")) {
                    c = '!';
                    break;
                }
                c = 65535;
                break;
            case 100313324:
                if (str.equals("imacr")) {
                    c = '\"';
                    break;
                }
                c = 65535;
                break;
            case 102831699:
                if (str.equals("ldquo")) {
                    c = '#';
                    break;
                }
                c = 65535;
                break;
            case 103278564:
                if (str.equals("lsquo")) {
                    c = Typography.dollar;
                    break;
                }
                c = 65535;
                break;
            case 103739775:
                if (str.equals("mdash")) {
                    c = '%';
                    break;
                }
                c = 65535;
                break;
            case 104663296:
                if (str.equals("ndash")) {
                    c = '&';
                    break;
                }
                c = 65535;
                break;
            case 105832675:
                if (str.equals("oline")) {
                    c = '\'';
                    break;
                }
                c = 65535;
                break;
            case 106934911:
                if (str.equals("prime")) {
                    c = '(';
                    break;
                }
                c = 65535;
                break;
            case 108372825:
                if (str.equals("rdquo")) {
                    c = ')';
                    break;
                }
                c = 65535;
                break;
            case 108819690:
                if (str.equals("rsquo")) {
                    c = '*';
                    break;
                }
                c = 65535;
                break;
            case 109236764:
                if (str.equals("sbquo")) {
                    c = '+';
                    break;
                }
                c = 65535;
                break;
            case 110364486:
                if (str.equals("times")) {
                    c = ',';
                    break;
                }
                c = 65535;
                break;
            case 2039534506:
                if (str.equals("Dagger")) {
                    c = '-';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return MediaPlayer.MEDIA_PLAYER_OPTION_CLOCK_RESUME_RESET_EOF;
            case 1:
                return MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE;
            case 2:
                return AVMDLDataLoader.KeyIsEnableSpeedEngine;
            case 3:
                return 8230;
            case 4:
                return 237;
            case 5:
                return 236;
            case 6:
                return 8249;
            case 7:
                return 183;
            case '\b':
                return 8240;
            case '\t':
                return 8250;
            case '\n':
                return 8201;
            case 11:
                return 8805;
            case '\f':
                return 62;
            case '\r':
                return 8804;
            case 14:
                return 60;
            case 15:
                return 38;
            case 16:
                return 8206;
            case 17:
                return 8207;
            case 18:
                return EmojiReader.StateMachine.Joiner;
            case 19:
                return AVMDLDataLoader.KeyIsSpeedEngineSetting;
            case 20:
                return PropertyIDConstants.InsetInlineEnd;
            case 21:
                return 8595;
            case 22:
                return 8195;
            case 23:
                return 8194;
            case 24:
                return 8230;
            case 25:
                return 160;
            case 26:
                return 34;
            case 27:
                return 8204;
            case 28:
                return 8243;
            case 29:
                return 257;
            case 30:
                return AVMDLDataLoader.KeyIsCustomUA;
            case 31:
                return MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_VIDEO_DIFF_THRESHOLD;
            case ' ':
                return MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME;
            case '!':
                return 8260;
            case '\"':
                return 299;
            case '#':
                return AVMDLDataLoader.KeyIsEnableSpeedPredict;
            case '$':
                return AVMDLDataLoader.KeyIsLoaderFactoryP2PLevel;
            case '%':
                return 8212;
            case '&':
                return 8211;
            case '\'':
                return 8254;
            case '(':
                return 8242;
            case ')':
                return AVMDLDataLoader.KeyIsP2PConfigStr;
            case '*':
                return AVMDLDataLoader.KeyIsLoaderFactoryXYLibValue;
            case '+':
                return AVMDLDataLoader.KeyIsLoaderFactoryP2PStragetyLevel;
            case ',':
                return 215;
            case '-':
                return AVMDLDataLoader.KeyIsEnableSpeedReport;
            default:
                return -1;
        }
    }

    /* loaded from: classes7.dex */
    private static class InsertCharContext {
        private boolean mBreakCharBefore;
        private boolean mCjkBefore;
        private boolean mHighSurrogateBefore;

        private InsertCharContext() {
            this.mCjkBefore = false;
            this.mBreakCharBefore = false;
            this.mHighSurrogateBefore = false;
        }

        public void InsertExtraChar(StringBuilder sb, int i) {
            if (sb.length() == 0) {
                return;
            }
            if (Character.isHighSurrogate(sb.charAt(sb.length() - 1))) {
                this.mHighSurrogateBefore = true;
                return;
            }
            int length = sb.length() - (this.mHighSurrogateBefore ? 2 : 1);
            int codePointAt = sb.codePointAt(length);
            if (i == 1) {
                boolean isLatinOrSymbol = isLatinOrSymbol(codePointAt);
                if (isLatinOrSymbol || this.mBreakCharBefore) {
                    sb.delete(length, sb.length());
                    sb.append((char) 8203);
                    sb.appendCodePoint(codePointAt);
                    this.mBreakCharBefore = isLatinOrSymbol;
                }
            } else if (i == 2) {
                if (isCJK(codePointAt)) {
                    if (this.mCjkBefore) {
                        sb.delete(length, sb.length());
                        sb.append((char) 8288);
                        sb.appendCodePoint(codePointAt);
                    } else {
                        this.mCjkBefore = true;
                    }
                } else {
                    this.mCjkBefore = false;
                }
            }
            this.mHighSurrogateBefore = false;
        }

        public static boolean isLatinOrSymbol(int i) {
            Character.UnicodeBlock of = Character.UnicodeBlock.of(i);
            return of == Character.UnicodeBlock.BASIC_LATIN || of == Character.UnicodeBlock.LATIN_1_SUPPLEMENT || of == Character.UnicodeBlock.LATIN_EXTENDED_A || of == Character.UnicodeBlock.LATIN_EXTENDED_B || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CURRENCY_SYMBOLS || of == Character.UnicodeBlock.MATHEMATICAL_OPERATORS;
        }

        private static boolean isCJK(int i) {
            Character.UnicodeBlock of = Character.UnicodeBlock.of(i);
            return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || of == Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.KATAKANA || of == Character.UnicodeBlock.HIRAGANA || of == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS || of == Character.UnicodeBlock.HANGUL_JAMO || of == Character.UnicodeBlock.HANGUL_SYLLABLES;
        }
    }
}
