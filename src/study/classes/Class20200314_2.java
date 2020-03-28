package study.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Class20200314_2
{

    public static void main(String[] args)
    {
        try
        {
            List list = new ArrayList();
            list.add(23);
            list.add("hello");
            for (Object object : list)
            {
                String str = (String) object;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        List<String> list = new ArrayList<>();
        list.add("23");
        list.add("hello");
        list.add("world");
        for (String string : list)
        {
            System.out.println(string);
        }
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            String string = (String) iterator.next();

        }

        IterableString iterableString = new IterableString("hellooo");
        for (Iterator iterator = iterableString.iterator(); iterator.hasNext();)
        {
            String string = (String) iterator.next();
            System.out.println(string);
        }

        for (String string : iterableString)
        {
            System.out.println(string);
        }

    }

}

class IterableString implements Iterable<String>
{
    private String str;

    public IterableString(String str)
    {
        super();
        this.str = str;
    }

    @Override
    public Iterator<String> iterator()
    {
        return new IterableStringIterator();
    }

    class IterableStringIterator implements Iterator<String>
    {
        private int count;
        @Override
        public boolean hasNext()
        {
            return str.length() > count;
        }

        @Override
        public String next()
        {
            String ret = str.substring(count);
            count++;
            return ret;
        }

    }
}
