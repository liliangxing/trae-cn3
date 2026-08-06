package bytedance.jvm.time.format;

import java.text.DecimalFormatSymbols;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class DecimalStyle {
    private final char decimalSeparator;
    private final char negativeSign;
    private final char positiveSign;
    private final char zeroDigit;
    public static final DecimalStyle STANDARD = new DecimalStyle('0', '+', '-', '.');
    private static final ConcurrentMap<Locale, DecimalStyle> CACHE = new ConcurrentHashMap(16, 0.75f, 2);

    public static Set<Locale> getAvailableLocales() {
        Locale[] availableLocales = DecimalFormatSymbols.getAvailableLocales();
        HashSet hashSet = new HashSet(availableLocales.length);
        Collections.addAll(hashSet, availableLocales);
        return hashSet;
    }

    public static DecimalStyle ofDefaultLocale() {
        return of(Locale.getDefault());
    }

    public static DecimalStyle of(Locale locale) {
        Objects.requireNonNull(locale, "locale");
        ConcurrentMap<Locale, DecimalStyle> concurrentMap = CACHE;
        DecimalStyle decimalStyle = concurrentMap.get(locale);
        if (decimalStyle != null) {
            return decimalStyle;
        }
        concurrentMap.putIfAbsent(locale, create(locale));
        return concurrentMap.get(locale);
    }

    private static DecimalStyle create(Locale locale) {
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(locale);
        char zeroDigit = decimalFormatSymbols.getZeroDigit();
        char minusSign = decimalFormatSymbols.getMinusSign();
        char decimalSeparator = decimalFormatSymbols.getDecimalSeparator();
        if (zeroDigit == '0' && minusSign == '-' && decimalSeparator == '.') {
            return STANDARD;
        }
        return new DecimalStyle(zeroDigit, '+', minusSign, decimalSeparator);
    }

    private DecimalStyle(char c, char c2, char c3, char c4) {
        this.zeroDigit = c;
        this.positiveSign = c2;
        this.negativeSign = c3;
        this.decimalSeparator = c4;
    }

    public char getZeroDigit() {
        return this.zeroDigit;
    }

    public DecimalStyle withZeroDigit(char c) {
        return c == this.zeroDigit ? this : new DecimalStyle(c, this.positiveSign, this.negativeSign, this.decimalSeparator);
    }

    public char getPositiveSign() {
        return this.positiveSign;
    }

    public DecimalStyle withPositiveSign(char c) {
        return c == this.positiveSign ? this : new DecimalStyle(this.zeroDigit, c, this.negativeSign, this.decimalSeparator);
    }

    public char getNegativeSign() {
        return this.negativeSign;
    }

    public DecimalStyle withNegativeSign(char c) {
        return c == this.negativeSign ? this : new DecimalStyle(this.zeroDigit, this.positiveSign, c, this.decimalSeparator);
    }

    public char getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public DecimalStyle withDecimalSeparator(char c) {
        return c == this.decimalSeparator ? this : new DecimalStyle(this.zeroDigit, this.positiveSign, this.negativeSign, c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int convertToDigit(char c) {
        int i = c - this.zeroDigit;
        if (i < 0 || i > 9) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String convertNumberToI18N(String str) {
        char c = this.zeroDigit;
        if (c == '0') {
            return str;
        }
        int i = c - '0';
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            charArray[i2] = (char) (charArray[i2] + i);
        }
        return new String(charArray);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecimalStyle)) {
            return false;
        }
        DecimalStyle decimalStyle = (DecimalStyle) obj;
        return this.zeroDigit == decimalStyle.zeroDigit && this.positiveSign == decimalStyle.positiveSign && this.negativeSign == decimalStyle.negativeSign && this.decimalSeparator == decimalStyle.decimalSeparator;
    }

    public int hashCode() {
        return this.zeroDigit + this.positiveSign + this.negativeSign + this.decimalSeparator;
    }

    public String toString() {
        return "DecimalStyle[" + this.zeroDigit + this.positiveSign + this.negativeSign + this.decimalSeparator + "]";
    }
}
