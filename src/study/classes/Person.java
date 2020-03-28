package study.classes;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Person implements Comparable<Person>
{
    private String name;
    private int age;
    private int height;
    private int weight;

    public Person(String name, int age, int height, int weight)
    {
        super();
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public int getAge()
    {
        return age;
    }


    public void setAge(int age)
    {
        this.age = age;
    }


    public int getHeight()
    {
        return height;
    }


    public void setHeight(int height)
    {
        this.height = height;
    }


    public int getWeight()
    {
        return weight;
    }


    public void setWeight(int weight)
    {
        this.weight = weight;
    }


    @Override
    public int compareTo(Person o)
    {
        // 大文字、小文字を無視してalphabet順に並べ替え
        return this.name.compareToIgnoreCase(o.name);
    }
    // 通常、インスタンスをprint outしてもHash値しかプリントされないためtoStringをoverrideしてどんな情報を表示したいか定義する
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Person) || obj == null)
        {
            return false;
        }
        Person person = (Person) obj;
        return this.name.equals(person.name)
                && this.age == person.age
                && this.height == person.height
                && this.weight == person.weight;
    }
//    @Override
//    public int hashCode()
//    {
//        int result = 17;
//        result = 31 * result + this.name.hashCode();
//        result = 31 * result + this.age;
//        result = 31 * result + this.height;
//        result = 31 * result + this.weight;
//        return result;
//    }
}
