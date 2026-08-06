package bytedance.core;

import bytedance.io.BdFile;
import bytedance.io.exception.IllegalPathException;
import bytedance.resolver.FileHandler;
import bytedance.resolver.FileResolver;
import bytedance.util.DtfsUtils;
import java.io.File;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class FileManagerService {
    public BdFileEventCallBack mBdFileEventCallBack;
    private List<FileResolver> resolvers;

    public String getDefaultParent() {
        return "/";
    }

    private FileManagerService() {
        this.resolvers = new LinkedList();
    }

    /* loaded from: classes2.dex */
    private static class DefaultFileManagerService {
        static final FileManagerService defaultManagerService = defaultFileManagerService();

        private DefaultFileManagerService() {
        }

        private static FileManagerService defaultFileManagerService() {
            return new FileManagerService();
        }
    }

    public static FileManagerService getDefault() {
        return DefaultFileManagerService.defaultManagerService;
    }

    public FileManagerService registerFirstResolver(FileResolver fileResolver) {
        FileResolver fileResolver2 = (FileResolver) DtfsUtils.checkNotNull(fileResolver, "resolver == null");
        if (!this.resolvers.contains(fileResolver2)) {
            this.resolvers.add(0, fileResolver2);
        }
        return this;
    }

    public FileManagerService registerResolver(FileResolver fileResolver) {
        FileResolver fileResolver2 = (FileResolver) DtfsUtils.checkNotNull(fileResolver, "resolver == null");
        if (!this.resolvers.contains(fileResolver2)) {
            this.resolvers.add(fileResolver2);
        }
        return this;
    }

    public FileManagerService unregisterResolver(FileResolver fileResolver) {
        FileResolver fileResolver2 = (FileResolver) DtfsUtils.checkNotNull(fileResolver, "resolver == null");
        if (this.resolvers.contains(fileResolver2)) {
            this.resolvers.remove(fileResolver2);
        }
        return this;
    }

    public void setBdFileEventCallBack(BdFileEventCallBack bdFileEventCallBack) {
        this.mBdFileEventCallBack = bdFileEventCallBack;
    }

    public String resolve(String str) throws IllegalPathException {
        if (str == null) {
            return str;
        }
        FileHandler fileHandler = new FileHandler(str, 0);
        return new RealResolverController(this.resolvers, 0, fileHandler).handle(fileHandler).getPath();
    }

    public String resolve(String str, String str2) throws IllegalPathException {
        if (str2 == null) {
            return str2;
        }
        if (str != null && !str.isEmpty()) {
            if (str2.isEmpty() || str2.equals("/")) {
                return resolve(str);
            }
            if (str2.charAt(0) == '/' && str.equals("/")) {
                return resolve(str2);
            }
            FileHandler fileHandler = new FileHandler(str, str2, 0);
            return new RealResolverController(this.resolvers, 0, fileHandler).handle(fileHandler).getPath();
        }
        return resolve(str2);
    }

    public String resolve(File file, String str) throws IllegalPathException {
        if (str == null) {
            return str;
        }
        if (file != null) {
            if (file.getPath().equals("")) {
                return resolve(getDefaultParent(), str);
            }
            return resolve(file.getPath(), str);
        }
        return resolve(str);
    }

    public String resolve(URI uri) throws IllegalPathException {
        if (!uri.isAbsolute()) {
            throw new IllegalArgumentException("URI is not absolute");
        }
        if (uri.isOpaque()) {
            throw new IllegalArgumentException("URI is not hierarchical");
        }
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equalsIgnoreCase("file")) {
            throw new IllegalArgumentException("URI scheme is not \"file\"");
        }
        if (uri.getAuthority() != null) {
            throw new IllegalArgumentException("URI has an authority component");
        }
        if (uri.getFragment() != null) {
            throw new IllegalArgumentException("URI has a fragment component");
        }
        if (uri.getQuery() != null) {
            throw new IllegalArgumentException("URI has a query component");
        }
        String path = uri.getPath();
        if (path.equals("")) {
            throw new IllegalArgumentException("URI path component is empty");
        }
        String fromURIPath = fromURIPath(path);
        if (File.separatorChar != '/') {
            fromURIPath = fromURIPath.replace('/', File.separatorChar);
        }
        return resolve(removeDupSlash(fromURIPath));
    }

    public BdFile resolve(File file) throws IllegalPathException {
        if (file instanceof BdFile) {
            return (BdFile) file;
        }
        return new BdFile(file.getPath());
    }

    public String removeDupSlash(String str) {
        int length = str.length();
        char[] charArray = str.toCharArray();
        int i = 0;
        char c = 0;
        int i2 = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 != '/' || c != '/') {
                charArray[i2] = c2;
                i2++;
            }
            i++;
            c = c2;
        }
        if (c == '/' && length > 1) {
            i2--;
        }
        return i2 != length ? new String(charArray, 0, i2) : str;
    }

    public int prefixLength(String str) {
        return (str.length() != 0 && str.charAt(0) == '/') ? 1 : 0;
    }

    public String fromURIPath(String str) {
        return (!str.endsWith("/") || str.length() <= 1) ? str : str.substring(0, str.length() - 1);
    }
}
