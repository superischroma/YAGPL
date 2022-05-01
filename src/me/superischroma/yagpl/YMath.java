package me.superischroma.yagpl;

public final class YMath
{
    public YMath() throws IllegalAccessException
    {
        throw new IllegalAccessException(YConstants.CANNOT_CREATE_INSTANCE);
    }

    public static final double PI = 3.14159265358979323846;
    public static final double TAU = 6.283185307179586;

    /**
     * Calculate the factorial of integer x.
     * @param x An integer
     * @return The factorial of x
     */
    public static double ifac(int x)
    {
        if (x < 0) // no complex factorials allowed
            throw new IllegalArgumentException(YConstants.COMPLEX_NOT_SUPPORTED);
        double prod = 1.0;
        for (int i = x; i >= 1; i--)
            prod *= i;
        return prod;
    }

    /**
     * Calculate x^y where y is an integer
     * @param x A base
     * @param y An integer exponent
     * @return The result of x^y
     */
    public static double ipow(double x, int y)
    {
        boolean negativePower = y < 0;
        y = iabs(y);
        double prod = 1.0;
        for (int i = 1; i <= y; i++)
            prod *= x;
        return negativePower ? (1.0 / prod) : prod;
    }

    /**
     * Calculates the absolute value of integer x
     * @param x An integer
     * @return The absolute value of x
     */
    public static int iabs(int x)
    {
        return x < 0 ? -x : x;
    }

    /**
     * Calculates the absolute value of x
     * @param x A number
     * @return The absolute value of x
     */
    public static double abs(double x)
    {
        return x < 0.0 ? -x : x;
    }

    /**
     * Calculates the sine function at x (radians)
     * @param x A number
     * @param precision Precision to accurate values
     * @return The sine of x
     */
    public static double sin(double x, int precision)
    {
        double part = x % TAU;
        double sum = 0.0;
        for (int n = 0; n <= precision; n++)
            sum += ipow(-1, n) * ipow(part, 2 * n + 1) / ifac(2 * n + 1);
        return sum;
    }

    /**
     * Calculates the sine function at x (radians)
     * @param x A number
     * @return The sine of x
     */
    public static double sin(double x)
    {
        return sin(x, 18);
    }

    /**
     * Calculates the cosine function at x (radians)
     * @param x A number
     * @param precision Precision to accurate values
     * @return The cosine of x
     */
    public static double cos(double x, int precision)
    {
        double part = x % TAU;
        double sum = 0.0;
        for (int n = 0; n <= precision; n++)
        {
            sum += ipow(-1, n) * ipow(part, 2 * n) / ifac(2 * n);
            //System.out.println("after " + n + ": " + sum);
        }
        return sum;
    }

    /**
     * Calculates the cosine function at x (radians)
     * @param x A number
     * @return The cosine of x
     */
    public static double cos(double x)
    {
        return cos(x, 18);
    }

    public static double tan(double x, int precision)
    {
        return sin(x, precision) / cos(x, precision);
    }

    public static double tan(double x)
    {
        return tan(x, 18);
    }

    public static double exp(double x)
    {
        if (x < -4.0 || x > 4.0)
        {
            double prod = 1.0;
            int half = (int) (x / 2);
            prod *= exp(half);
            prod *= exp(x - half);
            return prod;
        }
        double sum = 0.0;
        for (int i = 0; i <= 25; i++) sum += ipow(x, i) / ifac(i);
        return sum;
    }

    public static double ln(double x)
    {
        if (x < 0.4 || x > 1.7)
        {
            double divsum = 0.0;
            divsum += ln(x / 1.7) + ln(1.7);
            return divsum;
        }
        double sum = 0.0;
        for (int i = 1; i <= 25; i++) sum += (ipow(-1.0, i - 1) * ipow(x - 1, i)) / i;
        return sum;
    }

    public static double pow(double x, double p)
    {
        return exp(p * ln(x));
    }
}