package ui.xo;


public class UiConnection {

    UiConnection() {

    }

    public native void start(int row,int column,String name1,String name2,Boolean b1,Boolean b2);

    public native int botMove();

    public native int end();

    public native int move(int x, int y);

    public native int isOver();

}
