package bytedance.io;

import bytedance.core.FileManagerService;
import bytedance.io.exception.IllegalPathException;
import bytedance.util.FsLogger;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.net.URI;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class BdFile extends File {
    private static final FileManagerService fms = FileManagerService.getDefault();

    public BdFile(String str) throws IllegalPathException {
        super(fms.resolve(str));
        setLastModified(System.currentTimeMillis());
    }

    public BdFile(String str, String str2) throws IllegalPathException {
        super(fms.resolve(str, str2));
        setLastModified(System.currentTimeMillis());
    }

    public BdFile(File file, String str) throws IllegalPathException {
        super(fms.resolve(file, str));
        setLastModified(System.currentTimeMillis());
    }

    public BdFile(URI uri) throws IllegalPathException {
        super(fms.resolve(uri));
        setLastModified(System.currentTimeMillis());
    }

    @Override // java.io.File
    public String getParent() {
        String parent = super.getParent();
        if (parent == null) {
            return null;
        }
        try {
            return new BdFile(parent).getPath();
        } catch (IllegalPathException e) {
            FsLogger.e(e.toString());
            return null;
        }
    }

    @Override // java.io.File
    public BdFile getParentFile() {
        String parent = super.getParent();
        if (parent == null) {
            return null;
        }
        try {
            return new BdFile(parent);
        } catch (IllegalPathException e) {
            FsLogger.e(e.toString());
            return null;
        }
    }

    @Override // java.io.File
    public BdFile getAbsoluteFile() {
        try {
            return new BdFile(getAbsolutePath());
        } catch (IllegalPathException e) {
            FsLogger.e(e.toString());
            return null;
        }
    }

    @Override // java.io.File
    public BdFile[] listFiles() {
        String[] list = list();
        if (list == null) {
            return null;
        }
        int length = list.length;
        BdFile[] bdFileArr = new BdFile[length];
        for (int i = 0; i < length; i++) {
            try {
                bdFileArr[i] = new BdFile(getPath(), list[i]);
            } catch (IllegalPathException e) {
                FsLogger.e(e.toString());
            }
        }
        return bdFileArr;
    }

    @Override // java.io.File
    public BdFile[] listFiles(FilenameFilter filenameFilter) {
        String[] list = list();
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (filenameFilter == null || filenameFilter.accept(this, str)) {
                try {
                    arrayList.add(new BdFile(getPath(), str));
                } catch (IllegalPathException e) {
                    FsLogger.e(e.toString());
                }
            }
        }
        return (BdFile[]) arrayList.toArray(new BdFile[arrayList.size()]);
    }

    @Override // java.io.File
    public BdFile[] listFiles(FileFilter fileFilter) {
        BdFile bdFile;
        String[] list = list();
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            try {
                bdFile = new BdFile(getPath(), str);
            } catch (IllegalPathException e) {
                FsLogger.e(e.toString());
                bdFile = null;
            }
            if (fileFilter == null || fileFilter.accept(bdFile)) {
                arrayList.add(bdFile);
            }
        }
        return (BdFile[]) arrayList.toArray(new BdFile[arrayList.size()]);
    }
}
