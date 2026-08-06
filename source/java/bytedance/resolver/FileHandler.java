package bytedance.resolver;

/* loaded from: classes2.dex */
public class FileHandler {
    private String name;
    private int option;
    private String parent;
    private String path;

    public FileHandler(String str, int i) {
        this.path = str;
        this.option = i;
    }

    public FileHandler(String str, String str2, int i) {
        this.parent = str;
        this.name = str2;
        this.option = i;
    }

    public String getPath() {
        return this.path;
    }

    public int getOption() {
        return this.option;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setOption(int i) {
        this.option = i;
    }

    public String getParent() {
        return this.parent;
    }

    public void setParent(String str) {
        this.parent = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
