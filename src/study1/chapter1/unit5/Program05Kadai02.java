package study1.chapter1.unit5;

public class Program05Kadai02
{

    public static void main(String[] args)
    {
        TypeA sample1 = new ClassC1();
        sample1.methodA();
        TypeB sample2 = new ClassC1();
        System.out.println(sample2.methodB());
        TypeC sample3 = new ClassC2();
        System.out.println(sample3.methodC("abcd"));
        TypeA sample4 = new ClassC3();
        sample4.methodA();
        AbstractC1 sample5 = new ClassC3();
        System.out.println(sample5.methodB());
        sample5.printSelf();
    }

}
/**
 * TypeA
 * @author kinjouhiroaki
 *
 */
interface TypeA
{
    /**
     * methodA
     */
    void methodA();
}
/**
 * TypeB
 * @author kinjouhiroaki
 *
 */
interface TypeB
{
    /**
     * methodB
     * @return int
     */
    int methodB();
}
/**
 * interface TypeC
 * @author kinjouhiroaki
 *
 */
interface TypeC extends TypeA, TypeB
{
    int FIELD_C = 777;

    /**
     * methodC
     * @param str
     * @return string
     */
    String methodC(String str);
}
/**
 * AbstractC1
 * @author kinjouhiroaki
 *
 */
abstract class AbstractC1 implements TypeA, TypeB
{
    public void printSelf() {
        System.out.println("This is AbstractC1!");
    }
}
/**
 * AbstractC2
 * @author kinjouhiroaki
 *
 */
abstract class AbstractC2 implements TypeC
{
    public void printSelf() {
        System.out.println("This is AbstractC2!");
    }
}
/**
 * classC1
 * @author kinjouhiroaki
 *
 */
class ClassC1 implements TypeA, TypeB
{
    /**
     * {@inheritDoc}
     */
    @Override
    public void methodA()
    {
        System.out.println("This is methodA from ClassC1!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int methodB()
    {
        int calc = 5 * 5;
        return calc;
    }
}
/**
 * ClassC2
 * @author kinjouhiroaki
 *
 */
class ClassC2 implements TypeC
{
    /**
     * {@inheritDoc}
     */
    @Override
    public void methodA()
    {
        System.out.println("This is methodA from ClassC2");

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int methodB()
    {
        int calc = 10 * 6;
        return calc;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String methodC(String str)
    {
        return (str != null) ? str : "";
    }
}
/**
 * ClassC3
 * @author kinjouhiroaki
 *
 */
class ClassC3 extends AbstractC1
{
    /**
     * {@inheritDoc}
     */
    @Override
    public void methodA()
    {
        System.out.println("This is methodA from ClassC3");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int methodB()
    {
        int calc = 8 * 8;
        return calc;
    }
}
/**
 * ClassC4
 * @author kinjouhiroaki
 *
 */
class ClassC4 extends AbstractC2
{
    /**
     * {@inheritDoc}
     */
    @Override
    public void methodA()
    {
        System.out.println("This is methodA from ClassC4");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int methodB()
    {
        int calc = 100 * 100;
        return calc;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String methodC(String str)
    {
        return str;
    }
}