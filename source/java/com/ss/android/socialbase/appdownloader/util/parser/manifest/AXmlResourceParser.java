package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Logger;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AXmlResourceParser implements XmlResourceParser {
    private static final String ANDROID_RES_NS = "http://schemas.android.com/apk/res/android";
    private static final String ANDROID_RES_NS_AUTO = "http://schemas.android.com/apk/res-auto";
    private static final int ATTRIBUTE_IX_NAME = 1;
    private static final int ATTRIBUTE_IX_NAMESPACE_URI = 0;
    private static final int ATTRIBUTE_IX_VALUE_DATA = 4;
    private static final int ATTRIBUTE_IX_VALUE_STRING = 2;
    private static final int ATTRIBUTE_IX_VALUE_TYPE = 3;
    private static final int ATTRIBUTE_LENGTH = 5;
    private static final String E_NOT_SUPPORTED = "Method is not supported.";
    private static final Logger LOGGER = Logger.getLogger(AXmlResourceParser.class.getName());
    private static final int PRIVATE_PKG_ID = 127;
    private int[] mAttributes;
    private int mClassIndex;
    private int mEvent;
    private int mIdIndex;
    private ExtCountingDataInput mIn;
    private int mLineNumber;
    private int mNameIndex;
    private int mNamespaceIndex;
    private int[] mResourceIds;
    private StringBlock mStringBlock;
    private int mStyleIndex;
    private boolean m_decreaseDepth;
    private boolean isOperational = false;
    private final NamespaceStack mNamespaces = new NamespaceStack();

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeListValue(int i, String[] strArr, int i2) {
        return 0;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeListValue(String str, String str2, String[] strArr, int i) {
        return 0;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeType(int i) {
        return "CDATA";
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getColumnNumber() {
        return -1;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean getFeature(String str) {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getInputEncoding() {
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public Object getProperty(String str) {
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isAttributeDefault(int i) {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isEmptyElementTag() {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isWhitespace() {
        return false;
    }

    public AXmlResourceParser() {
        resetEventInfo();
    }

    public void open(InputStream inputStream) {
        close();
        if (inputStream != null) {
            this.mIn = new ExtCountingDataInput(new LittleEndianDataInputStream(inputStream));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser
    public void close() {
        if (this.isOperational) {
            this.isOperational = false;
            this.mIn = null;
            this.mStringBlock = null;
            this.mResourceIds = null;
            this.mNamespaces.reset();
            resetEventInfo();
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int next() throws XmlPullParserException, IOException {
        if (this.mIn == null) {
            throw new XmlPullParserException("Parser is not opened.", this, null);
        }
        try {
            doNext();
            return this.mEvent;
        } catch (IOException e) {
            close();
            throw e;
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int nextToken() throws XmlPullParserException, IOException {
        return next();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int nextTag() throws XmlPullParserException, IOException {
        int next = next();
        if (next == 4 && isWhitespace()) {
            next = next();
        }
        if (next == 2 || next == 3) {
            return next;
        }
        throw new XmlPullParserException("Expected start or end tag.", this, null);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String nextText() throws XmlPullParserException, IOException {
        if (getEventType() != 2) {
            throw new XmlPullParserException("Parser must be on START_TAG to read next text.", this, null);
        }
        int next = next();
        if (next != 4) {
            if (next == 3) {
                return "";
            }
            throw new XmlPullParserException("Parser must be on START_TAG or TEXT to read text.", this, null);
        }
        String text = getText();
        if (next() == 3) {
            return text;
        }
        throw new XmlPullParserException("Event TEXT must be immediately followed by END_TAG.", this, null);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void require(int i, String str, String str2) throws XmlPullParserException {
        if (i != getEventType() || ((str != null && !str.equals(getNamespace())) || (str2 != null && !str2.equals(getName())))) {
            throw new XmlPullParserException(TYPES[i] + " is expected.", this, null);
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getDepth() {
        return this.mNamespaces.getDepth() - 1;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getEventType() {
        return this.mEvent;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getLineNumber() {
        return this.mLineNumber;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getName() {
        int i = this.mNameIndex;
        if (i == -1) {
            return null;
        }
        int i2 = this.mEvent;
        if (i2 == 2 || i2 == 3) {
            return this.mStringBlock.getString(i);
        }
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getText() {
        int i = this.mNameIndex;
        if (i == -1 || this.mEvent != 4) {
            return null;
        }
        return this.mStringBlock.getString(i);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public char[] getTextCharacters(int[] iArr) {
        String text = getText();
        if (text == null) {
            return null;
        }
        iArr[0] = 0;
        iArr[1] = text.length();
        char[] cArr = new char[text.length()];
        text.getChars(0, text.length(), cArr, 0);
        return cArr;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace() {
        return this.mStringBlock.getString(this.mNamespaceIndex);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getPrefix() {
        return this.mStringBlock.getString(this.mNamespaces.findPrefix(this.mNamespaceIndex));
    }

    @Override // org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public String getPositionDescription() {
        return "XML line #" + getLineNumber();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getNamespaceCount(int i) {
        return this.mNamespaces.getAccumulatedCount(i);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespacePrefix(int i) {
        return this.mStringBlock.getString(this.mNamespaces.getPrefix(i));
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespaceUri(int i) {
        return this.mStringBlock.getString(this.mNamespaces.getUri(i));
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public String getClassAttribute() {
        int i = this.mClassIndex;
        if (i == -1) {
            return null;
        }
        return this.mStringBlock.getString(this.mAttributes[getAttributeOffset(i) + 2]);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public String getIdAttribute() {
        int i = this.mIdIndex;
        if (i == -1) {
            return null;
        }
        return this.mStringBlock.getString(this.mAttributes[getAttributeOffset(i) + 2]);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getIdAttributeResourceValue(int i) {
        int i2 = this.mIdIndex;
        if (i2 == -1) {
            return i;
        }
        int attributeOffset = getAttributeOffset(i2);
        int[] iArr = this.mAttributes;
        return iArr[attributeOffset + 3] != 1 ? i : iArr[attributeOffset + 4];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getStyleAttribute() {
        int i = this.mStyleIndex;
        if (i == -1) {
            return 0;
        }
        return this.mAttributes[getAttributeOffset(i) + 4];
    }

    @Override // org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeCount() {
        if (this.mEvent != 2) {
            return -1;
        }
        return this.mAttributes.length / 5;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeNamespace(int i) {
        int attributeOffset = getAttributeOffset(i);
        int i2 = this.mAttributes[attributeOffset + 0];
        ResID resID = new ResID(getAttributeNameResource(i));
        if (i2 == -1 && resID.pkgId == 1) {
            return ANDROID_RES_NS;
        }
        if (i2 == -1) {
            return "";
        }
        String string = this.mStringBlock.getString(i2);
        return (string == null || string.isEmpty()) ? resID.pkgId == 127 ? getNonDefaultNamespaceUri(attributeOffset) : ANDROID_RES_NS : string;
    }

    private String getNonDefaultNamespaceUri(int i) {
        return this.mStringBlock.getString(this.mNamespaces.getPrefix(i)) != null ? this.mStringBlock.getString(this.mNamespaces.getUri(i)) : ANDROID_RES_NS_AUTO;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributePrefix(int i) {
        int findPrefix = this.mNamespaces.findPrefix(this.mAttributes[getAttributeOffset(i) + 0]);
        return findPrefix == -1 ? "" : this.mStringBlock.getString(findPrefix);
    }

    @Override // org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public String getAttributeName(int i) {
        int i2 = this.mAttributes[getAttributeOffset(i) + 1];
        if (i2 == -1) {
            return "";
        }
        String string = this.mStringBlock.getString(i2);
        return string != null ? string : "APKTOOL_MISSING_" + Integer.toHexString(getAttributeNameResource(i));
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeNameResource(int i) {
        int i2 = this.mAttributes[getAttributeOffset(i) + 1];
        int[] iArr = this.mResourceIds;
        if (iArr == null || i2 < 0 || i2 >= iArr.length) {
            return 0;
        }
        return iArr[i2];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeValueType(int i) {
        return this.mAttributes[getAttributeOffset(i) + 3];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeValueData(int i) {
        return this.mAttributes[getAttributeOffset(i) + 4];
    }

    @Override // org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public String getAttributeValue(int i) {
        int attributeOffset = getAttributeOffset(i);
        int[] iArr = this.mAttributes;
        int i2 = iArr[attributeOffset + 3];
        int i3 = iArr[attributeOffset + 4];
        int i4 = iArr[attributeOffset + 2];
        if (i2 == 3) {
            return escapeXmlChars(this.mStringBlock.getString(i4));
        }
        if (i2 >= 16 && i2 <= 31) {
            return Integer.toString(i3);
        }
        return TypedValue.coerceToString(i2, i3);
    }

    private String escapeXmlChars(String str) {
        return str.replace("&", "&amp;").replace("<", "&lt;");
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public boolean getAttributeBooleanValue(int i, boolean z) {
        return getAttributeIntValue(i, z ? 1 : 0) != 0;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public float getAttributeFloatValue(int i, float f) {
        int attributeOffset = getAttributeOffset(i);
        int[] iArr = this.mAttributes;
        return iArr[attributeOffset + 3] == 4 ? Float.intBitsToFloat(iArr[attributeOffset + 4]) : f;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeIntValue(int i, int i2) {
        int attributeOffset = getAttributeOffset(i);
        int[] iArr = this.mAttributes;
        int i3 = iArr[attributeOffset + 3];
        return (i3 < 16 || i3 > 31) ? i2 : iArr[attributeOffset + 4];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeUnsignedIntValue(int i, int i2) {
        return getAttributeIntValue(i, i2);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeResourceValue(int i, int i2) {
        int attributeOffset = getAttributeOffset(i);
        int[] iArr = this.mAttributes;
        return iArr[attributeOffset + 3] == 1 ? iArr[attributeOffset + 4] : i2;
    }

    @Override // org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public String getAttributeValue(String str, String str2) {
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? "" : getAttributeValue(findAttribute);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public boolean getAttributeBooleanValue(String str, String str2, boolean z) {
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? z : getAttributeBooleanValue(findAttribute, z);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public float getAttributeFloatValue(String str, String str2, float f) {
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? f : getAttributeFloatValue(findAttribute, f);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeIntValue(String str, String str2, int i) {
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? i : getAttributeIntValue(findAttribute, i);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeUnsignedIntValue(String str, String str2, int i) {
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? i : getAttributeUnsignedIntValue(findAttribute, i);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeResourceValue(String str, String str2, int i) {
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? i : getAttributeResourceValue(findAttribute, i);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(InputStream inputStream, String str) {
        open(inputStream);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(Reader reader) throws XmlPullParserException {
        throw new XmlPullParserException(E_NOT_SUPPORTED);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void defineEntityReplacementText(String str, String str2) throws XmlPullParserException {
        throw new XmlPullParserException(E_NOT_SUPPORTED);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace(String str) {
        throw new RuntimeException(E_NOT_SUPPORTED);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setProperty(String str, Object obj) throws XmlPullParserException {
        throw new XmlPullParserException(E_NOT_SUPPORTED);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setFeature(String str, boolean z) throws XmlPullParserException {
        throw new XmlPullParserException(E_NOT_SUPPORTED);
    }

    private int getAttributeOffset(int i) {
        if (this.mEvent != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.mAttributes.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        return r0 / 5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int findAttribute(String str, String str2) {
        int find;
        int i;
        StringBlock stringBlock = this.mStringBlock;
        if (stringBlock == null || str2 == null || (find = stringBlock.find(str2)) == -1) {
            return -1;
        }
        int find2 = str != null ? this.mStringBlock.find(str) : -1;
        while (true) {
            int[] iArr = this.mAttributes;
            if (i == iArr.length) {
                break;
            }
            i = (find == iArr[i + 1] && (find2 == -1 || find2 == iArr[i + 0])) ? 0 : i + 5;
        }
        return -1;
    }

    private static String getPreferredString(String str, String str2) {
        if (str == null || str2 == null) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf("/");
        int lastIndexOf2 = str.lastIndexOf(Constants.COLON_SEPARATOR);
        if (lastIndexOf == -1) {
            return !str.equals(str2) ? str2 : str;
        }
        if (lastIndexOf2 == -1) {
            return str.substring(0, lastIndexOf) + "/" + str2;
        }
        return str;
    }

    private void resetEventInfo() {
        this.mEvent = -1;
        this.mLineNumber = -1;
        this.mNameIndex = -1;
        this.mNamespaceIndex = -1;
        this.mAttributes = null;
        this.mIdIndex = -1;
        this.mClassIndex = -1;
        this.mStyleIndex = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ba, code lost:
    
        r11.mIn.skipBytes(r11.mIn.readInt() - 8);
        com.ss.android.socialbase.appdownloader.util.parser.manifest.AXmlResourceParser.LOGGER.warning(java.lang.String.format("Unknown chunk type at: (0x%08x) skipping...", java.lang.Integer.valueOf(r11.mIn.position())));
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01df, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doNext() throws IOException {
        short readShort;
        short readShort2;
        int readInt;
        if (this.mStringBlock == null) {
            this.mIn.skipInt();
            this.mIn.skipInt();
            this.mStringBlock = StringBlock.readWithChunk(this.mIn);
            this.mNamespaces.increaseDepth();
            this.isOperational = true;
        }
        int i = this.mEvent;
        if (i == 1) {
            return;
        }
        resetEventInfo();
        while (true) {
            if (this.m_decreaseDepth) {
                this.m_decreaseDepth = false;
                this.mNamespaces.decreaseDepth();
            }
            int i2 = 3;
            if (i == 3 && this.mNamespaces.getDepth() == 1 && this.mNamespaces.getCurrentCount() == 0) {
                this.mEvent = 1;
                return;
            }
            if (i == 0) {
                readShort2 = 0;
                readShort = 258;
            } else {
                readShort = this.mIn.readShort();
                readShort2 = this.mIn.readShort();
            }
            if (readShort == 384) {
                readInt = this.mIn.readInt();
                if (readInt < 8 || readInt % 4 != 0) {
                    break;
                } else {
                    this.mResourceIds = this.mIn.readIntArray((readInt / 4) - 2);
                }
            } else {
                if (readShort < 256 || readShort > 383) {
                    break;
                }
                if (readShort == 258 && i == -1) {
                    this.mEvent = 0;
                    return;
                }
                this.mIn.skipInt();
                this.mLineNumber = this.mIn.readInt();
                this.mIn.skipInt();
                if (readShort == 256 || readShort == 257) {
                    if (readShort == 256) {
                        this.mNamespaces.push(this.mIn.readInt(), this.mIn.readInt());
                    } else {
                        this.mIn.skipInt();
                        this.mIn.skipInt();
                        this.mNamespaces.pop();
                    }
                    if (readShort2 > 16) {
                        int i3 = readShort2 - 16;
                        LOGGER.warning(String.format("AXML header larger than 0x10 bytes, skipping %d bytes.", Integer.valueOf(i3)));
                        this.mIn.skipBytes(i3);
                    }
                } else {
                    if (readShort == 258) {
                        this.mNamespaceIndex = this.mIn.readInt();
                        this.mNameIndex = this.mIn.readInt();
                        this.mIn.skipShort();
                        short readShort3 = this.mIn.readShort();
                        short readShort4 = this.mIn.readShort();
                        this.mIdIndex = this.mIn.readShort();
                        this.mClassIndex = this.mIn.readShort();
                        this.mStyleIndex = this.mIn.readShort();
                        int i4 = readShort4 * 5;
                        this.mAttributes = this.mIn.readIntArray(i4);
                        while (true) {
                            int[] iArr = this.mAttributes;
                            if (i2 >= iArr.length) {
                                break;
                            }
                            iArr[i2] = iArr[i2] >>> 24;
                            i2 += 5;
                        }
                        int i5 = i4 * 4;
                        int i6 = readShort3 * readShort4;
                        if (i5 < i6) {
                            int i7 = i6 - i5;
                            this.mIn.skipBytes(i7);
                            LOGGER.fine("Skipping " + i7 + " unknown bytes in attributes area.");
                        }
                        this.mNamespaces.increaseDepth();
                        this.mEvent = 2;
                        return;
                    }
                    if (readShort == 259) {
                        this.mNamespaceIndex = this.mIn.readInt();
                        this.mNameIndex = this.mIn.readInt();
                        this.mEvent = 3;
                        this.m_decreaseDepth = true;
                        return;
                    }
                    if (readShort == 260) {
                        this.mNameIndex = this.mIn.readInt();
                        this.mIn.skipInt();
                        this.mIn.skipInt();
                        this.mEvent = 4;
                        return;
                    }
                }
            }
        }
        throw new IOException("Invalid resource ids size (" + readInt + ").");
    }
}
