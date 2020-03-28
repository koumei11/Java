package study.classes;

public class Class20200314
{

    public static void main(String[] args)
    {
//        BigInteger bigInteger1 = BigInteger.valueOf(10);
//        BigInteger bigInteger2 = BigInteger.valueOf(10000000);
//        BigInteger result = bigInteger1.add(bigInteger2);
//        System.out.println(result);
//        result = bigInteger1.multiply(bigInteger2);
//        System.out.println(result);
//
//        BigDecimal bigDecimal1 = new BigDecimal("0.1");
//        BigDecimal bigDecimal2 = new BigDecimal("0.2");
//        BigDecimal result2 = bigDecimal1.add(bigDecimal2);
//        System.out.println(result2);
//        result2 = bigDecimal1.multiply(bigDecimal2);
//        System.out.println(result2);

        ImaginaryNumber i1 = new ImaginaryNumber(10, 4);
        ImaginaryNumber i2 = new ImaginaryNumber(2, 5);
        System.out.println(Calculator.add(i1, i2));
        System.out.println(Calculator.add(i2, i1));
        System.out.println(Calculator.multiply(i1, i2));
        System.out.println(Calculator.multiply(i2, i1));
        System.out.println(Calculator.swapAdd(i1, i2));
        System.out.println(Calculator.swapMultiply(i2, i1));
    }

}
/**
 * 計算機class
 * @author kinjouhiroaki
 *
 */
class Calculator
{
    /**
     * 加算を行うmethod
     * @param a
     * @param b
     * @return Type
     */
    public static Add add(Add a, Add b) {
        return a.add(b);
    }
    /**
     * 加算の可換性を判定するmethod
     * @param a
     * @param b
     * @return boolean
     */
    public static boolean swapAdd(Add a, Add b) {
        return a.add(b).equals(b.add(a));
    }
    /**
     * 乗算を行うmethod
     * @param a
     * @param b
     * @return Type
     */
    public static Multiply multiply(Multiply a, Multiply b) {
        return a.multiply(b);
    }
    /**
     * 乗算の可換性を判定するmethod
     * @param a
     * @param b
     * @return boolean
     */
    public static boolean swapMultiply(Multiply a, Multiply b) {
        return a.multiply(b).equals(b.multiply(a));
    }
}
 /**
  * 計算機classを提供するlibrary内にある加算用のinterface
  * @author kinjouhiroaki
  *
  */
interface Add
{
    /**
     * 加算を行うmethod
     * @param b
     * @return Add
     */
    Add add(Add b);
}

/**
 * 計算機classを提供するlibrary内にある乗算用のinterface
 * @author kinjouhiroaki
 *
 */
interface Multiply
{
    /**
     * 乗算を行うmethod
     * @param b
     * @return Multiply
     */
    Multiply multiply(Multiply b);
}

/**
 * 独自class
 * @author kinjouhiroaki
 *
 */
class ImaginaryNumber implements Add, Multiply
{
    // field
    private int jitubu;
    private int kyobu;

    //constructor
    public ImaginaryNumber(int jitubu, int kyobu)
    {
        super();
        this.jitubu = jitubu;
        this.kyobu = kyobu;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Add add(Add b)
    {
        if(b instanceof ImaginaryNumber) {
            ImaginaryNumber b2 = (ImaginaryNumber) b;
            return new ImaginaryNumber(jitubu + b2.getJitubu(), kyobu + b2.getKyobu());
        }
        throw new IllegalArgumentException("ImaginaryNumber以外が渡されました");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Multiply multiply(Multiply b)
    {
        if (b instanceof ImaginaryNumber) {
            ImaginaryNumber b2 = (ImaginaryNumber) b;
            return new ImaginaryNumber(this.getJitubu() * b2.getJitubu(), this.getKyobu() * b2.getKyobu());
        }
        throw new IllegalArgumentException("ImaginaryNumber以外が渡されました");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof ImaginaryNumber) {
            ImaginaryNumber b2 = (ImaginaryNumber) obj;
            return (this.getJitubu() == b2.getJitubu()) && (this.getKyobu() == b2.getKyobu());
        }
        throw new IllegalArgumentException("ImaginaryNumber以外が渡されました");
    }

    // getter、setter
    public int getJitubu()
    {
        return jitubu;
    }

    public void setJitubu(int jitubu)
    {
        this.jitubu = jitubu;
    }

    public int getKyobu()
    {
        return kyobu;
    }

    public void setKyobu(int kyobu)
    {
        this.kyobu = kyobu;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return jitubu + " + " + kyobu + "i";
    }
}
