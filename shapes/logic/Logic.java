package mooc.vandy.java4android.shapes.logic;

import java.util.Locale;

import mooc.vandy.java4android.shapes.ui.OutputInterface;

import static java.lang.String.format;

/
public class Logic
        implements LogicInterface {

    public static final String TAG = Logic.class.getName();


    private final OutputInterface mOut;


    public Logic(OutputInterface out) {
        mOut = out;
    }


    @Override
    public void process() {

        Shapes shapeForCalculations = mOut.getShape();

        double mLength = mOut.getLength();
        double mWidth = mOut.getWidth();
        double mHeight = mOut.getHeight();
        double mRadius = mOut.getRadius();

        switch (shapeForCalculations) {
            case Box:
                mOut.print("A "
                        + mLength
                        + " by "
                        + mWidth
                        + " by "
                        + mHeight
                        + " box has a volume of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", boxVolume(mLength, mWidth, mHeight)));
                mOut.println();

                mOut.print("A "
                        + mLength
                        + " by "
                        + mWidth
                        + " by "
                        + mHeight
                        + " box has a surface area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", boxSurfaceArea(mLength, mWidth, mHeight)));
                mOut.println();

            case Rectangle:
                mOut.print("A "
                        + mLength
                        + " by "
                        + mWidth
                        + " rectangle has a perimeter of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", rectanglePerimeter(mLength, mWidth)));
                mOut.println();

                mOut.print("A "
                        + mLength
                        + " by "
                        + mWidth
                        + " rectangle has area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", rectangleArea(mLength, mWidth)));
                mOut.println();
                break;
            case Sphere:
                mOut.print("A sphere with radius " + mRadius + " has a volume of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", sphereVolume(mRadius)));
                mOut.println();

                mOut.print("A sphere with radius " + mRadius + " has surface area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", sphereSurfaceArea(mRadius)));
                mOut.println();
                // Same here as with 'Box' above. If 'Sphere' is picked, it will run the
                // two sets of print statements above and the two below until the 'break;'
            case Circle:
                mOut.print("A circle with radius " + mRadius + " has a perimeter of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", circleCircumference(mRadius)));
                mOut.println();

                mOut.print("A circle with radius " + mRadius + " has area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", circleArea(mRadius)));
                mOut.println();
                break;
            case Triangle:
                mOut.print("A right triangle with base "
                        + mLength
                        + " and height "
                        + mWidth + " has a perimeter of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", rightTrianglePerimeter(mLength, mWidth)));
                mOut.println();

                mOut.print("A right triangle with base "
                        + mLength
                        + " and height "
                        + mWidth
                        + " has area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", rightTriangleArea(mLength, mWidth)));
                mOut.println();
                break;
            default:
                break;
        }
    }

    // TODO -- add your code here

    private double boxVolume(double length, double width, double height) {
        return length * width * height;
    }

    private double boxSurfaceArea(double length, double width, double height) {
        double topAndBottomArea = 2 * length * width;
        double sideArea = 2 * length * height + 2 * width * height;
        return topAndBottomArea + sideArea;
    }


    private double rectanglePerimeter(double length, double width) {
        return 2 * (length + width);
    }


    private double rectangleArea(double length, double width) {
        return length * width;
    }


    private double sphereVolume(double radius) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }


    private double sphereSurfaceArea(double radius) {
        return 4 * Math.PI * Math.pow(radius, 2);
    }


    private double circleCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    private double circleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }


    private double rightTrianglePerimeter(double base, double height) {
        double hypotenuse = Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
        return base + height + hypotenuse;
    }


    private double rightTriangleArea(double base, double height) {
        return 0.5 * base * height;
    }
}

