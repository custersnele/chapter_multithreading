package be.pxl.ja.oefening4;

public class Package {
    public static int count = 0;

    private int id;

    public Package() {
        this.id = count++;
    }

    @Override
    public String toString() {
        return "#" + this.id;
    }
}
