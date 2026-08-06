package bytedance.io;

import bytedance.core.FileManagerService;
import bytedance.io.exception.IllegalPathException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/* loaded from: classes2.dex */
public class BdRandomAccessFile extends RandomAccessFile {
    private static final FileManagerService fms = FileManagerService.getDefault();

    public BdRandomAccessFile(String str, String str2) throws FileNotFoundException, IllegalPathException {
        this(str != null ? new BdFile(str) : null, str2);
    }

    public BdRandomAccessFile(File file, String str) throws FileNotFoundException, IllegalPathException {
        super(fms.resolve(file), str);
    }
}
