package com.ss.android.socialbase.appdownloader.util.package_info;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class AXmlResourceParser implements XmlResourceParser {
    private int[] m_attributes;
    private int m_classAttribute;
    private boolean m_decreaseDepth;
    private int m_event;
    private int m_idAttribute;
    private int m_lineNumber;
    private int m_name;
    private int m_namespaceUri;
    private IntReader m_reader;
    private int[] m_resourceIDs;
    private StringBlock m_strings;
    private int m_styleAttribute;
    private boolean m_operational = false;
    private NamespaceStack m_namespaces = new NamespaceStack();

    public int getAttributeListValue(int i, String[] strArr, int i2) {
        return 0;
    }

    public int getAttributeListValue(String str, String str2, String[] strArr, int i) {
        return 0;
    }

    public String getAttributeType(int i) {
        return "CDATA";
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public int getColumnNumber() {
        return -1;
    }

    public boolean getFeature(String str) {
        return false;
    }

    public String getInputEncoding() {
        return null;
    }

    public Object getProperty(String str) {
        return null;
    }

    public boolean isAttributeDefault(int i) {
        return false;
    }

    public boolean isEmptyElementTag() throws XmlPullParserException {
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public boolean isWhitespace() throws XmlPullParserException {
        return false;
    }

    public AXmlResourceParser() {
        resetEventInfo();
    }

    public void open(InputStream inputStream) {
        close();
        if (inputStream != null) {
            this.m_reader = new IntReader(inputStream, false);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlResourceParser
    public void close() {
        if (this.m_operational) {
            this.m_operational = false;
            this.m_reader.close();
            this.m_reader = null;
            this.m_strings = null;
            this.m_resourceIDs = null;
            this.m_namespaces.reset();
            resetEventInfo();
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public int next() throws XmlPullParserException, IOException {
        if (this.m_reader == null) {
            throw new XmlPullParserException("Parser is not opened.", this, null);
        }
        try {
            doNext();
            return this.m_event;
        } catch (IOException e) {
            close();
            throw e;
        }
    }

    public int nextToken() throws XmlPullParserException, IOException {
        return next();
    }

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

    public void require(int i, String str, String str2) throws XmlPullParserException, IOException {
        if (i == getEventType() && ((str == null || str.equals(getNamespace())) && (str2 == null || str2.equals(getName())))) {
            return;
        }
        throw new XmlPullParserException(TYPES[i] + " is expected.", this, null);
    }

    public int getDepth() {
        return this.m_namespaces.getDepth() - 1;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public int getEventType() throws XmlPullParserException {
        return this.m_event;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public int getLineNumber() {
        return this.m_lineNumber;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public String getName() {
        int i;
        int i2 = this.m_name;
        if (i2 == -1 || !((i = this.m_event) == 2 || i == 3)) {
            return null;
        }
        return this.m_strings.getString(i2);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public String getText() {
        int i = this.m_name;
        if (i == -1 || this.m_event != 4) {
            return null;
        }
        return this.m_strings.getString(i);
    }

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

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public String getNamespace() {
        return this.m_strings.getString(this.m_namespaceUri);
    }

    public String getPrefix() {
        return this.m_strings.getString(this.m_namespaces.findPrefix(this.m_namespaceUri));
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public String getPositionDescription() {
        return "XML line #" + getLineNumber();
    }

    public int getNamespaceCount(int i) throws XmlPullParserException {
        return this.m_namespaces.getAccumulatedCount(i);
    }

    public String getNamespacePrefix(int i) throws XmlPullParserException {
        return this.m_strings.getString(this.m_namespaces.getPrefix(i));
    }

    public String getNamespaceUri(int i) throws XmlPullParserException {
        return this.m_strings.getString(this.m_namespaces.getUri(i));
    }

    public String getClassAttribute() {
        int i = this.m_classAttribute;
        if (i == -1) {
            return null;
        }
        return this.m_strings.getString(this.m_attributes[getAttributeOffset(i) + 2]);
    }

    public String getIdAttribute() {
        int i = this.m_idAttribute;
        if (i == -1) {
            return null;
        }
        return this.m_strings.getString(this.m_attributes[getAttributeOffset(i) + 2]);
    }

    public int getIdAttributeResourceValue(int i) {
        int i2 = this.m_idAttribute;
        if (i2 == -1) {
            return i;
        }
        int attributeOffset = getAttributeOffset(i2);
        int[] iArr = this.m_attributes;
        return iArr[attributeOffset + 3] != 1 ? i : iArr[attributeOffset + 4];
    }

    public int getStyleAttribute() {
        int i = this.m_styleAttribute;
        if (i == -1) {
            return 0;
        }
        return this.m_attributes[getAttributeOffset(i) + 4];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser, com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public int getAttributeCount() {
        if (this.m_event != 2) {
            return -1;
        }
        return this.m_attributes.length / 5;
    }

    public String getAttributeNamespace(int i) {
        int i2 = this.m_attributes[getAttributeOffset(i) + 0];
        return i2 == -1 ? "" : this.m_strings.getString(i2);
    }

    public String getAttributePrefix(int i) {
        int findPrefix = this.m_namespaces.findPrefix(this.m_attributes[getAttributeOffset(i) + 0]);
        return findPrefix == -1 ? "" : this.m_strings.getString(findPrefix);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser, com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public String getAttributeName(int i) {
        int i2 = this.m_attributes[getAttributeOffset(i) + 1];
        return i2 == -1 ? "" : this.m_strings.getString(i2);
    }

    public int getAttributeNameResource(int i) {
        int i2 = this.m_attributes[getAttributeOffset(i) + 1];
        int[] iArr = this.m_resourceIDs;
        if (iArr == null || i2 < 0 || i2 >= iArr.length) {
            return 0;
        }
        return iArr[i2];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public int getAttributeValueType(int i) {
        return this.m_attributes[getAttributeOffset(i) + 3];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public int getAttributeValueData(int i) {
        return this.m_attributes[getAttributeOffset(i) + 4];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser, com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public String getAttributeValue(int i) {
        int attributeOffset = getAttributeOffset(i);
        int[] iArr = this.m_attributes;
        if (iArr[attributeOffset + 3] == 3) {
            return this.m_strings.getString(iArr[attributeOffset + 2]);
        }
        int i2 = iArr[attributeOffset + 4];
        return "";
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public boolean getAttributeBooleanValue(int i, boolean z) {
        return getAttributeIntValue(i, z ? 1 : 0) != 0;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public float getAttributeFloatValue(int i, float f) {
        int attributeOffset = getAttributeOffset(i);
        int[] iArr = this.m_attributes;
        return iArr[attributeOffset + 3] == 4 ? Float.intBitsToFloat(iArr[attributeOffset + 4]) : f;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public int getAttributeIntValue(int i, int i2) {
        int attributeOffset = getAttributeOffset(i);
        int[] iArr = this.m_attributes;
        int i3 = iArr[attributeOffset + 3];
        return (i3 < 16 || i3 > 31) ? i2 : iArr[attributeOffset + 4];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public int getAttributeUnsignedIntValue(int i, int i2) {
        return getAttributeIntValue(i, i2);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public int getAttributeResourceValue(int i, int i2) {
        int attributeOffset = getAttributeOffset(i);
        int[] iArr = this.m_attributes;
        return iArr[attributeOffset + 3] == 1 ? iArr[attributeOffset + 4] : i2;
    }

    public String getAttributeValue(String str, String str2) {
        int findAttribute = findAttribute(str, str2);
        if (findAttribute == -1) {
            return null;
        }
        return getAttributeValue(findAttribute);
    }

    public boolean getAttributeBooleanValue(String str, String str2, boolean z) {
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? z : getAttributeBooleanValue(findAttribute, z);
    }

    public float getAttributeFloatValue(String str, String str2, float f) {
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? f : getAttributeFloatValue(findAttribute, f);
    }

    public int getAttributeIntValue(String str, String str2, int i) {
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? i : getAttributeIntValue(findAttribute, i);
    }

    public int getAttributeUnsignedIntValue(String str, String str2, int i) {
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? i : getAttributeUnsignedIntValue(findAttribute, i);
    }

    public int getAttributeResourceValue(String str, String str2, int i) {
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? i : getAttributeResourceValue(findAttribute, i);
    }

    public void setInput(InputStream inputStream, String str) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    public void setInput(Reader reader) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    public void defineEntityReplacementText(String str, String str2) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    public String getNamespace(String str) {
        throw new RuntimeException("Method is not supported.");
    }

    public void setProperty(String str, Object obj) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    public void setFeature(String str, boolean z) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    final StringBlock getStrings() {
        return this.m_strings;
    }

    private final int getAttributeOffset(int i) {
        if (this.m_event != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.m_attributes.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        return r0 / 5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int findAttribute(String str, String str2) {
        int find;
        int i;
        StringBlock stringBlock = this.m_strings;
        if (stringBlock == null || str2 == null || (find = stringBlock.find(str2)) == -1) {
            return -1;
        }
        int find2 = str != null ? this.m_strings.find(str) : -1;
        while (true) {
            int[] iArr = this.m_attributes;
            if (i == iArr.length) {
                break;
            }
            int i2 = i + 1;
            i = (find == iArr[i2] && (find2 == -1 || find2 == iArr[i + 0])) ? 0 : i2;
        }
        return -1;
    }

    private final void resetEventInfo() {
        this.m_event = -1;
        this.m_lineNumber = -1;
        this.m_name = -1;
        this.m_namespaceUri = -1;
        this.m_attributes = null;
        this.m_idAttribute = -1;
        this.m_classAttribute = -1;
        this.m_styleAttribute = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0188, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void doNext() throws IOException {
        int readInt;
        if (this.m_strings == null) {
            ChunkUtil.readCheckType(this.m_reader, 524291);
            this.m_reader.skipInt();
            this.m_strings = StringBlock.read(this.m_reader);
            this.m_namespaces.increaseDepth();
            this.m_operational = true;
        }
        int i = this.m_event;
        if (i != 1) {
            resetEventInfo();
            while (true) {
                if (this.m_decreaseDepth) {
                    this.m_decreaseDepth = false;
                    this.m_namespaces.decreaseDepth();
                }
                int i2 = 3;
                if (i == 3 && this.m_namespaces.getDepth() == 1 && this.m_namespaces.getCurrentCount() == 0) {
                    this.m_event = 1;
                    return;
                }
                int readInt2 = i == 0 ? 1048834 : this.m_reader.readInt();
                if (readInt2 == 524672) {
                    readInt = this.m_reader.readInt();
                    if (readInt < 8 || readInt % 4 != 0) {
                        break;
                    } else {
                        this.m_resourceIDs = this.m_reader.readIntArray((readInt / 4) - 2);
                    }
                } else {
                    if (readInt2 < 1048832 || readInt2 > 1048836) {
                        break;
                    }
                    if (readInt2 == 1048834 && i == -1) {
                        this.m_event = 0;
                        return;
                    }
                    this.m_reader.skipInt();
                    int readInt3 = this.m_reader.readInt();
                    this.m_reader.skipInt();
                    if (readInt2 != 1048832 && readInt2 != 1048833) {
                        this.m_lineNumber = readInt3;
                        if (readInt2 == 1048834) {
                            this.m_namespaceUri = this.m_reader.readInt();
                            this.m_name = this.m_reader.readInt();
                            this.m_reader.skipInt();
                            int readInt4 = this.m_reader.readInt();
                            this.m_idAttribute = (readInt4 >>> 16) - 1;
                            int i3 = readInt4 & com.ss.android.socialbase.appdownloader.util.parser.manifest.TypedValue.DENSITY_NONE;
                            int readInt5 = this.m_reader.readInt();
                            this.m_styleAttribute = (readInt5 >>> 16) - 1;
                            this.m_classAttribute = (65535 & readInt5) - 1;
                            this.m_attributes = this.m_reader.readIntArray(i3 * 5);
                            while (true) {
                                int[] iArr = this.m_attributes;
                                if (i2 < iArr.length) {
                                    iArr[i2] = iArr[i2] >>> 24;
                                    i2 += 5;
                                } else {
                                    this.m_namespaces.increaseDepth();
                                    this.m_event = 2;
                                    return;
                                }
                            }
                        } else {
                            if (readInt2 == 1048835) {
                                this.m_namespaceUri = this.m_reader.readInt();
                                this.m_name = this.m_reader.readInt();
                                this.m_event = 3;
                                this.m_decreaseDepth = true;
                                return;
                            }
                            if (readInt2 == 1048836) {
                                this.m_name = this.m_reader.readInt();
                                this.m_reader.skipInt();
                                this.m_reader.skipInt();
                                this.m_event = 4;
                                return;
                            }
                        }
                    } else if (readInt2 == 1048832) {
                        this.m_namespaces.push(this.m_reader.readInt(), this.m_reader.readInt());
                    } else {
                        this.m_reader.skipInt();
                        this.m_reader.skipInt();
                        this.m_namespaces.pop();
                    }
                }
            }
            throw new IOException("Invalid resource ids size (" + readInt + ").");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class NamespaceStack {
        private int[] m_data = new int[32];
        private int m_dataLength;
        private int m_depth;

        public final void reset() {
            this.m_dataLength = 0;
            this.m_depth = 0;
        }

        public final int getCurrentCount() {
            int i = this.m_dataLength;
            if (i == 0) {
                return 0;
            }
            return this.m_data[i - 1];
        }

        public final int getAccumulatedCount(int i) {
            int i2 = 0;
            if (this.m_dataLength != 0 && i >= 0) {
                int i3 = this.m_depth;
                if (i > i3) {
                    i = i3;
                }
                int i4 = 0;
                while (i != 0) {
                    int i5 = this.m_data[i4];
                    i2 += i5;
                    i4 += (i5 * 2) + 2;
                    i--;
                }
            }
            return i2;
        }

        public final void push(int i, int i2) {
            if (this.m_depth == 0) {
                increaseDepth();
            }
            ensureDataCapacity(2);
            int i3 = this.m_dataLength;
            int i4 = i3 - 1;
            int[] iArr = this.m_data;
            int i5 = iArr[i4];
            int i6 = (i4 - 1) - (i5 * 2);
            int i7 = i5 + 1;
            iArr[i6] = i7;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i7;
            this.m_dataLength = i3 + 2;
        }

        public final boolean pop() {
            int i;
            int[] iArr;
            int i2;
            int i3 = this.m_dataLength;
            if (i3 == 0 || (i2 = (iArr = this.m_data)[i3 - 1]) == 0) {
                return false;
            }
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.m_dataLength = i3 - 2;
            return true;
        }

        public final int getPrefix(int i) {
            return get(i, true);
        }

        public final int getUri(int i) {
            return get(i, false);
        }

        public final int findPrefix(int i) {
            return find(i, false);
        }

        public final int getDepth() {
            return this.m_depth;
        }

        public final void increaseDepth() {
            ensureDataCapacity(2);
            int i = this.m_dataLength;
            int[] iArr = this.m_data;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.m_dataLength = i + 2;
            this.m_depth++;
        }

        public final void decreaseDepth() {
            int i = this.m_dataLength;
            if (i != 0) {
                int i2 = i - 1;
                int i3 = this.m_data[i2] * 2;
                if ((i2 - 1) - i3 != 0) {
                    this.m_dataLength = i - (i3 + 2);
                    this.m_depth--;
                }
            }
        }

        private void ensureDataCapacity(int i) {
            int[] iArr = this.m_data;
            int length = iArr.length;
            int i2 = this.m_dataLength;
            int i3 = length - i2;
            if (i3 <= i) {
                int[] iArr2 = new int[(iArr.length + i3) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.m_data = iArr2;
            }
        }

        private final int find(int i, boolean z) {
            int i2 = this.m_dataLength;
            if (i2 == 0) {
                return -1;
            }
            int i3 = i2 - 1;
            for (int i4 = this.m_depth; i4 != 0; i4--) {
                i3 -= 2;
                for (int i5 = this.m_data[i3]; i5 != 0; i5--) {
                    if (z) {
                        int[] iArr = this.m_data;
                        if (iArr[i3] == i) {
                            return iArr[i3 + 1];
                        }
                    } else {
                        int[] iArr2 = this.m_data;
                        if (iArr2[i3 + 1] == i) {
                            return iArr2[i3];
                        }
                    }
                    i3 -= 2;
                }
            }
            return -1;
        }

        private final int get(int i, boolean z) {
            if (this.m_dataLength != 0 && i >= 0) {
                int i2 = 0;
                for (int i3 = this.m_depth; i3 != 0; i3--) {
                    int[] iArr = this.m_data;
                    int i4 = iArr[i2];
                    if (i < i4) {
                        int i5 = i2 + (i * 2) + 1;
                        if (!z) {
                            i5++;
                        }
                        return iArr[i5];
                    }
                    i -= i4;
                    i2 += (i4 * 2) + 2;
                }
            }
            return -1;
        }
    }
}
