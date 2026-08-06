package com.ss.android.socialbase.appdownloader.util.parser.zip;

/* loaded from: classes7.dex */
public class UnicodeCommentExtraField extends AbstractUnicodeExtraField {
    public static final ZipShort UCOM_ID = new ZipShort(25461);

    public UnicodeCommentExtraField() {
    }

    public UnicodeCommentExtraField(String str, byte[] bArr, int i, int i2) {
        super(str, bArr, i, i2);
    }

    public UnicodeCommentExtraField(String str, byte[] bArr) {
        super(str, bArr);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return UCOM_ID;
    }
}
