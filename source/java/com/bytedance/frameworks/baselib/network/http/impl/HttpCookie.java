package com.bytedance.frameworks.baselib.network.http.impl;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes2.dex */
public class HttpCookie implements Cloneable {
    private static final String[] BROWSER_COMPATIBLE_DATE_FORMATS;
    private static final Set<String> RESERVED_NAMES;
    private static final ThreadLocal<DateFormat> STANDARD_DATE_FORMAT;
    private static Pattern VALID_IPV4_PATTERN = null;
    private static Pattern VALID_IPV6_PATTERN = null;
    private static final String ipv4Pattern = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
    private static final String ipv6Pattern = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";
    private String comment;
    private String commentURL;
    private boolean discard;
    private String domain;
    private boolean httpOnly;
    private final String name;
    private String path;
    private String portList;
    private boolean secure;
    private String value;
    private long maxAge = -1;
    private int version = 0;

    static {
        HashSet hashSet = new HashSet();
        RESERVED_NAMES = hashSet;
        hashSet.add("comment");
        hashSet.add("commenturl");
        hashSet.add("discard");
        hashSet.add("domain");
        hashSet.add("expires");
        hashSet.add("httponly");
        hashSet.add("max-age");
        hashSet.add("path");
        hashSet.add("port");
        hashSet.add("secure");
        hashSet.add("version");
        VALID_IPV4_PATTERN = null;
        VALID_IPV6_PATTERN = null;
        try {
            VALID_IPV4_PATTERN = Pattern.compile(ipv4Pattern, 2);
            VALID_IPV6_PATTERN = Pattern.compile(ipv6Pattern, 2);
        } catch (PatternSyntaxException unused) {
        }
        STANDARD_DATE_FORMAT = new ThreadLocal<DateFormat>() { // from class: com.bytedance.frameworks.baselib.network.http.impl.HttpCookie.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public DateFormat initialValue() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                return simpleDateFormat;
            }
        };
        BROWSER_COMPATIBLE_DATE_FORMATS = new String[]{"EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    }

    public static boolean domainMatches(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        String lowerCase = str2.toLowerCase(Locale.US);
        String lowerCase2 = str.toLowerCase(Locale.US);
        if (lowerCase.equals(lowerCase2) && (isFullyQualifiedDomainName(lowerCase, 0) || isIpAddress(lowerCase))) {
            return true;
        }
        if (!isFullyQualifiedDomainName(lowerCase, 0)) {
            return lowerCase2.equals(".local");
        }
        if (lowerCase2.length() == lowerCase.length() + 1 && lowerCase2.startsWith(LibrarianImpl.Constants.DOT) && lowerCase2.endsWith(lowerCase) && isFullyQualifiedDomainName(lowerCase2, 1)) {
            return true;
        }
        if (lowerCase.length() <= lowerCase2.length() || !lowerCase.endsWith(lowerCase2)) {
            return false;
        }
        return (lowerCase2.startsWith(LibrarianImpl.Constants.DOT) && isFullyQualifiedDomainName(lowerCase2, 1)) || lowerCase2.equals(".local");
    }

    public static boolean pathMatches(HttpCookie httpCookie, URI uri) {
        return matchablePath(uri.getPath()).startsWith(matchablePath(httpCookie.getPath()));
    }

    public static boolean secureMatches(HttpCookie httpCookie, URI uri) {
        return !httpCookie.getSecure() || "https".equalsIgnoreCase(uri.getScheme());
    }

    public static boolean portMatches(HttpCookie httpCookie, URI uri) {
        if (httpCookie.getPortlist() == null) {
            return true;
        }
        return Arrays.asList(httpCookie.getPortlist().split(",")).contains(Integer.toString(SerializableHttpCookie.getEffectivePort(uri.getScheme(), uri.getPort())));
    }

    private static String matchablePath(String str) {
        return str == null ? "/" : str.endsWith("/") ? str : str + "/";
    }

    private static boolean isFullyQualifiedDomainName(String str, int i) {
        int indexOf = str.indexOf(46, i + 1);
        return indexOf != -1 && indexOf < str.length() - 1;
    }

    public static List<HttpCookie> parse(String str) {
        return new CookieParser(str).parse();
    }

    /* loaded from: classes2.dex */
    static class CookieParser {
        private static final String ATTRIBUTE_NAME_TERMINATORS = ",;= \t";
        private static final String WHITESPACE = " \t";
        private final String input;
        private final String inputLowerCase;
        private int pos = 0;
        boolean hasExpires = false;
        boolean hasMaxAge = false;
        boolean hasVersion = false;

        CookieParser(String str) {
            this.input = str;
            this.inputLowerCase = str.toLowerCase(Locale.US);
        }

        public List<HttpCookie> parse() {
            int i;
            ArrayList arrayList = new ArrayList(2);
            if (this.inputLowerCase.startsWith("set-cookie2:")) {
                this.pos += 12;
                this.hasVersion = true;
                i = 0;
            } else {
                if (this.inputLowerCase.startsWith("set-cookie:")) {
                    this.pos += 11;
                }
                i = 1;
            }
            while (true) {
                String readAttributeName = readAttributeName(false);
                if (readAttributeName == null) {
                    if (arrayList.isEmpty()) {
                        throw new IllegalArgumentException("No cookies in " + this.input);
                    }
                    return arrayList;
                }
                if (!readEqualsSign()) {
                    throw new IllegalArgumentException("Expected '=' after " + readAttributeName + " in " + this.input);
                }
                HttpCookie httpCookie = new HttpCookie(readAttributeName, readAttributeValue(i != 0 ? ";" : ",;"));
                httpCookie.version = i ^ 1;
                arrayList.add(httpCookie);
                while (true) {
                    skipWhitespace();
                    if (this.pos != this.input.length()) {
                        if (this.input.charAt(this.pos) == ',') {
                            this.pos++;
                            break;
                        }
                        if (this.input.charAt(this.pos) == ';') {
                            this.pos++;
                        }
                        String readAttributeName2 = readAttributeName(true);
                        if (readAttributeName2 != null) {
                            setAttribute(httpCookie, readAttributeName2, readEqualsSign() ? readAttributeValue((i != 0 || "expires".equals(readAttributeName2) || "port".equals(readAttributeName2)) ? ";" : ";,") : null);
                        }
                    }
                }
            }
        }

        private void setAttribute(HttpCookie httpCookie, String str, String str2) {
            if (str.equals("comment") && httpCookie.comment == null) {
                httpCookie.comment = str2;
                return;
            }
            if (str.equals("commenturl") && httpCookie.commentURL == null) {
                httpCookie.commentURL = str2;
                return;
            }
            if (str.equals("discard")) {
                httpCookie.discard = true;
                return;
            }
            if (str.equals("domain") && httpCookie.domain == null) {
                if (!TextUtils.isEmpty(str2) && str2.charAt(0) == '.') {
                    str2 = str2.substring(1);
                }
                httpCookie.domain = str2;
                return;
            }
            if (str.equals("expires")) {
                this.hasExpires = true;
                if (httpCookie.maxAge == -1) {
                    Date parseDate = HttpCookie.parseDate(str2);
                    if (parseDate != null) {
                        httpCookie.setExpires(parseDate);
                        return;
                    } else {
                        httpCookie.maxAge = 0L;
                        return;
                    }
                }
                return;
            }
            if (str.equals("max-age")) {
                try {
                    long parseLong = Long.parseLong(str2);
                    this.hasMaxAge = true;
                    httpCookie.maxAge = parseLong;
                    return;
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException("Invalid max-age: " + str2);
                }
            }
            if (str.equals("path") && httpCookie.path == null) {
                httpCookie.path = str2;
                return;
            }
            if (str.equals("port") && httpCookie.portList == null) {
                if (str2 == null) {
                    str2 = "";
                }
                httpCookie.portList = str2;
            } else {
                if (str.equals("secure")) {
                    httpCookie.secure = true;
                    return;
                }
                if (str.equals("httponly")) {
                    httpCookie.httpOnly = true;
                } else {
                    if (!str.equals("version") || this.hasVersion) {
                        return;
                    }
                    httpCookie.version = Integer.parseInt(str2);
                }
            }
        }

        private String readAttributeName(boolean z) {
            skipWhitespace();
            int find = find(ATTRIBUTE_NAME_TERMINATORS);
            String str = z ? this.inputLowerCase : this.input;
            int i = this.pos;
            String substring = i < find ? str.substring(i, find) : null;
            this.pos = find;
            return substring;
        }

        private boolean readEqualsSign() {
            skipWhitespace();
            if (this.pos >= this.input.length() || this.input.charAt(this.pos) != '=') {
                return false;
            }
            this.pos++;
            return true;
        }

        private String readAttributeValue(String str) {
            skipWhitespace();
            int find = find(str);
            String substring = this.input.substring(this.pos, find);
            this.pos = find;
            return substring;
        }

        private int find(String str) {
            for (int i = this.pos; i < this.input.length(); i++) {
                if (str.indexOf(this.input.charAt(i)) != -1) {
                    return i;
                }
            }
            return this.input.length();
        }

        private void skipWhitespace() {
            while (this.pos < this.input.length() && WHITESPACE.indexOf(this.input.charAt(this.pos)) != -1) {
                this.pos++;
            }
        }
    }

    public HttpCookie(String str, String str2) {
        String trim = str.trim();
        if (!isValidName(trim)) {
            throw new IllegalArgumentException("Invalid name: " + str);
        }
        this.name = trim;
        this.value = str2;
    }

    private boolean isValidName(String str) {
        boolean z = (str.length() == 0 || str.startsWith("$") || RESERVED_NAMES.contains(str.toLowerCase(Locale.US))) ? false : true;
        if (z) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt < 0 || charAt >= 127 || charAt == ';' || charAt == ',') {
                    return false;
                }
                if (Character.isWhitespace(charAt) && charAt != ' ') {
                    return false;
                }
            }
        }
        return z;
    }

    public String getComment() {
        return this.comment;
    }

    public String getCommentURL() {
        return this.commentURL;
    }

    public boolean getDiscard() {
        return this.discard;
    }

    public String getDomain() {
        return this.domain;
    }

    public long getMaxAge() {
        return this.maxAge;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public String getPortlist() {
        return this.portList;
    }

    public boolean getSecure() {
        return this.secure;
    }

    public boolean getHttpOnly() {
        return this.httpOnly;
    }

    public String getValue() {
        return this.value;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean hasExpired() {
        long j = this.maxAge;
        return j != -1 && j <= 0;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setCommentURL(String str) {
        this.commentURL = str;
    }

    public void setDiscard(boolean z) {
        this.discard = z;
    }

    public void setDomain(String str) {
        this.domain = str == null ? null : str.toLowerCase(Locale.US);
    }

    public void setMaxAge(long j) {
        this.maxAge = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExpires(Date date) {
        this.maxAge = (date.getTime() - System.currentTimeMillis()) / 1000;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setPortlist(String str) {
        this.portList = str;
    }

    public void setSecure(boolean z) {
        this.secure = z;
    }

    public void setHttpOnly(boolean z) {
        this.httpOnly = z;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public void setVersion(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Bad version: " + i);
        }
        this.version = i;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HttpCookie)) {
            return false;
        }
        HttpCookie httpCookie = (HttpCookie) obj;
        return this.name.equalsIgnoreCase(httpCookie.getName()) && ((str = this.domain) == null ? httpCookie.domain == null : str.equalsIgnoreCase(httpCookie.domain)) && equals(this.path, httpCookie.path);
    }

    public int hashCode() {
        int hashCode = this.name.toLowerCase(Locale.US).hashCode();
        String str = this.domain;
        int hashCode2 = hashCode + (str == null ? 0 : str.toLowerCase(Locale.US).hashCode());
        String str2 = this.path;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return this.name + ContainerUtils.KEY_VALUE_DELIMITER + this.value;
    }

    private void appendAttribute(StringBuilder sb, String str, String str2) {
        if (str2 == null || sb == null) {
            return;
        }
        sb.append(";$");
        sb.append(str);
        sb.append("=\"");
        sb.append(str2);
        sb.append("\"");
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean isIpAddress(String str) {
        try {
            if (VALID_IPV4_PATTERN.matcher(str).matches()) {
                return true;
            }
            return VALID_IPV6_PATTERN.matcher(str).matches();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static Date parseDate(String str) {
        try {
            return STANDARD_DATE_FORMAT.get().parse(str);
        } catch (ParseException unused) {
            for (String str2 : BROWSER_COMPATIBLE_DATE_FORMATS) {
                try {
                    return new SimpleDateFormat(str2, Locale.US).parse(str);
                } catch (ParseException unused2) {
                }
            }
            return null;
        }
    }
}
