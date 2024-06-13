package  com.warship.leedcode.ext;

public class CheckRectanglesInter {

    public static void main(String[] args) {
        Rectangle r2 = new Rectangle(0, 3, 3, 1);
        Rectangle r1 = new Rectangle(1, 2, 2, 0);

        if (r1.intersects(r2)) {
            System.out.println("Rectangles are intersecting.");
        } else {
            System.out.println("Rectangles are not intersecting.");
        }
    }


    static class Rectangle {
        int x1, y1, x2, y2; // 左上角和右下角坐标

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public boolean intersects(Rectangle other) {
//            return x1 <= other.x2 && x2 >= other.x1 &&
//                    y1 >= other.y2 && y2 <= other.y1;

            if (x2 < other.x1) {
                return false;
            }
            if (y2 > other.y1) {
                return false;
            }
            if (x1 > other.x2) {
                return false;
            }
            if (y1 < other.y2) {
                return false;
            }
            return true;
        }
    }


    public static boolean areRectanglesIntersecting(Rectangle r1, Rectangle r2) {
        // 如果一个矩形在另一个矩形的上方或下方，不相交
        if (r1.y1 > r2.y2 || r2.y1 > r1.y2) {
            return false;
        }

        // 如果一个矩形在另一个矩形的左侧或右侧，不相交
        if (r1.x2 < r2.x1 || r2.x2 < r1.x1) {
            return false;
        }

        // 其他情况下相交
        return true;
    }
}
