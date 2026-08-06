package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ExtraFieldUtils {
    private static final int WORD = 4;
    private static final Map<ZipShort, Class<?>> implementations = new ConcurrentHashMap();

    static {
        register(AsiExtraField.class);
        register(JarMarker.class);
        register(UnicodePathExtraField.class);
        register(UnicodeCommentExtraField.class);
        register(Zip64ExtendedInformationExtraField.class);
    }

    public static void register(Class<?> cls) {
        try {
            implementations.put(((ZipExtraField) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])).getHeaderId(), cls);
        } catch (ClassCastException unused) {
            throw new RuntimeException(cls + " doesn't implement ZipExtraField");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException(cls + "'s no-arg constructor is not public");
        } catch (InstantiationException unused3) {
            throw new RuntimeException(cls + " is not a concrete class");
        } catch (NoSuchMethodException unused4) {
            throw new RuntimeException(cls + "'s no-arg constructor not found");
        } catch (InvocationTargetException e) {
            throw new RuntimeException(cls + "'s no-arg constructor threw an exception:" + e.getMessage());
        }
    }

    public static ZipExtraField createExtraField(ZipShort zipShort) throws InstantiationException, IllegalAccessException {
        Class<?> cls = implementations.get(zipShort);
        if (cls != null) {
            try {
                return (ZipExtraField) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (NoSuchMethodException e) {
                throw ((InstantiationException) new InstantiationException().initCause(e));
            } catch (InvocationTargetException e2) {
                throw ((InstantiationException) new InstantiationException().initCause(e2.getTargetException()));
            }
        }
        UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
        unrecognizedExtraField.setHeaderId(zipShort);
        return unrecognizedExtraField;
    }

    public static ZipExtraField[] parse(byte[] bArr) throws ZipException {
        return parse(bArr, true, UnparseableExtraField.THROW);
    }

    public static ZipExtraField[] parse(byte[] bArr, boolean z) throws ZipException {
        return parse(bArr, z, UnparseableExtraField.THROW);
    }

    public static ZipExtraField[] parse(byte[] bArr, boolean z, UnparseableExtraField unparseableExtraField) throws ZipException {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            if (i > bArr.length - 4) {
                break;
            }
            ZipShort zipShort = new ZipShort(bArr, i);
            int value = new ZipShort(bArr, i + 2).getValue();
            int i2 = i + 4;
            if (i2 + value > bArr.length) {
                int key = unparseableExtraField.getKey();
                if (key == 0) {
                    throw new ZipException("bad extra field starting at " + i + ".  Block length of " + value + " bytes exceeds remaining data of " + ((bArr.length - i) - 4) + " bytes.");
                }
                if (key != 1) {
                    if (key == 2) {
                        UnparseableExtraFieldData unparseableExtraFieldData = new UnparseableExtraFieldData();
                        if (z) {
                            unparseableExtraFieldData.parseFromLocalFileData(bArr, i, bArr.length - i);
                        } else {
                            unparseableExtraFieldData.parseFromCentralDirectoryData(bArr, i, bArr.length - i);
                        }
                        arrayList.add(unparseableExtraFieldData);
                    } else {
                        throw new ZipException("unknown UnparseableExtraField key: " + unparseableExtraField.getKey());
                    }
                }
            } else {
                try {
                    ZipExtraField createExtraField = createExtraField(zipShort);
                    if (!z && (createExtraField instanceof CentralDirectoryParsingZipExtraField)) {
                        ((CentralDirectoryParsingZipExtraField) createExtraField).parseFromCentralDirectoryData(bArr, i2, value);
                        arrayList.add(createExtraField);
                        i += value + 4;
                    }
                    createExtraField.parseFromLocalFileData(bArr, i2, value);
                    arrayList.add(createExtraField);
                    i += value + 4;
                } catch (IllegalAccessException | InstantiationException e) {
                    throw new ZipException(e.getMessage());
                }
            }
        }
        return (ZipExtraField[]) arrayList.toArray(new ZipExtraField[arrayList.size()]);
    }

    public static byte[] mergeLocalFileDataData(ZipExtraField[] zipExtraFieldArr) {
        boolean z = zipExtraFieldArr.length > 0 && (zipExtraFieldArr[zipExtraFieldArr.length - 1] instanceof UnparseableExtraFieldData);
        int length = zipExtraFieldArr.length;
        if (z) {
            length--;
        }
        int i = length * 4;
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            i += zipExtraField.getLocalFileDataLength().getValue();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            System.arraycopy(zipExtraFieldArr[i3].getHeaderId().getBytes(), 0, bArr, i2, 2);
            System.arraycopy(zipExtraFieldArr[i3].getLocalFileDataLength().getBytes(), 0, bArr, i2 + 2, 2);
            byte[] localFileDataData = zipExtraFieldArr[i3].getLocalFileDataData();
            System.arraycopy(localFileDataData, 0, bArr, i2 + 4, localFileDataData.length);
            i2 += localFileDataData.length + 4;
        }
        if (z) {
            byte[] localFileDataData2 = zipExtraFieldArr[zipExtraFieldArr.length - 1].getLocalFileDataData();
            System.arraycopy(localFileDataData2, 0, bArr, i2, localFileDataData2.length);
        }
        return bArr;
    }

    public static byte[] mergeCentralDirectoryData(ZipExtraField[] zipExtraFieldArr) {
        boolean z = zipExtraFieldArr.length > 0 && (zipExtraFieldArr[zipExtraFieldArr.length - 1] instanceof UnparseableExtraFieldData);
        int length = zipExtraFieldArr.length;
        if (z) {
            length--;
        }
        int i = length * 4;
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            i += zipExtraField.getCentralDirectoryLength().getValue();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            System.arraycopy(zipExtraFieldArr[i3].getHeaderId().getBytes(), 0, bArr, i2, 2);
            System.arraycopy(zipExtraFieldArr[i3].getCentralDirectoryLength().getBytes(), 0, bArr, i2 + 2, 2);
            byte[] centralDirectoryData = zipExtraFieldArr[i3].getCentralDirectoryData();
            System.arraycopy(centralDirectoryData, 0, bArr, i2 + 4, centralDirectoryData.length);
            i2 += centralDirectoryData.length + 4;
        }
        if (z) {
            byte[] centralDirectoryData2 = zipExtraFieldArr[zipExtraFieldArr.length - 1].getCentralDirectoryData();
            System.arraycopy(centralDirectoryData2, 0, bArr, i2, centralDirectoryData2.length);
        }
        return bArr;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class UnparseableExtraField {
        public static final int READ_KEY = 2;
        public static final int SKIP_KEY = 1;
        public static final int THROW_KEY = 0;
        private final int key;
        public static final UnparseableExtraField THROW = new UnparseableExtraField(0);
        public static final UnparseableExtraField SKIP = new UnparseableExtraField(1);
        public static final UnparseableExtraField READ = new UnparseableExtraField(2);

        private UnparseableExtraField(int i) {
            this.key = i;
        }

        public int getKey() {
            return this.key;
        }
    }
}
