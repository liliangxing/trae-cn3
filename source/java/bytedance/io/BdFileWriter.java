package bytedance.io;

import bytedance.core.FileManagerService;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
public class BdFileWriter extends FileWriter {
    private static final FileManagerService fms = FileManagerService.getDefault();

    public BdFileWriter(String str) throws IOException {
        super(fms.resolve(str));
    }

    public BdFileWriter(String str, boolean z) throws IOException {
        super(fms.resolve(str), z);
    }

    public BdFileWriter(File file) throws IOException {
        super(fms.resolve(file));
    }

    public BdFileWriter(File file, boolean z) throws IOException {
        super(fms.resolve(file), z);
    }

    public BdFileWriter(FileDescriptor fileDescriptor) {
        super(fileDescriptor);
    }
}
