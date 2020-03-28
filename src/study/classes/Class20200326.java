package study.classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

public class Class20200326
{
    public static void main(String[] args)
    {
        // List
        List<Integer> list = new ArrayList<>();
        /*
         * Listにはprimitive型というのは通常代入できない
         * 以下で代入しているのはint型の数値であるがListのなかで自動的にauto boxingされるため問題ない
         */
        list.add(0);
        list.add(15);
        list.add(34);
        list.add(2);
        list.add(6);
        list.add(11);
        // 条件指定でlistの中身を変えることができる。以下ではlistの中の値を変更する。listが変更されればtrueを返す
        boolean filter = CollectionUtils.filter(list, new IntegerPredicate());
        System.out.println(filter ? "変更あり" : "変更なし");
        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        list2.add("sato");
        list2.add("kinjo");
        list2.add("yamane");
        list2.add("ichikawa");
        list2.add("kobayashi");
        // 無名class。Predicateはinterfaceだが無名classで呼び出すことであたかも普通のclassのようにnewできmethodをoverrideできる
        CollectionUtils.filter(list2, new Predicate<String>()
        {

            @Override
            public boolean evaluate(String arg0)
            {
                return (arg0.length() >= 6) && (arg0.contains("o"));
            }
        });
        System.out.println(list2);

        List<Person> list3 = new ArrayList<>();
        list3.add(new Person("abeshi", 1, 6, 1));
        list3.add(new Person("tawaba", 2, 5, 1));
        list3.add(new Person("hidebu", 3, 4, 2));
        list3.add(new Person("takeshi", 4, 3, 2));
        list3.add(new Person("takashi", 5, 2, 3));
        list3.add(new Person("ando", 6, 1, 3));
        CollectionUtils.filter(list3, new Predicate<Person>()
        {
            @Override
            public boolean evaluate(Person arg0)
            {
                return (arg0.getName().length() >= 5) && (arg0.getAge() >= 4);
            }
        });
        System.out.println(list3);
        System.out.println();
        HashMap<Integer, String> hashMap = new HashMap<>();
        putSampleData(hashMap);
        System.out.println(hashMap);

        // LinkedHashMapは追加された順番で保持される。よって、順番を覚えてなければならいないためHashMapよりは遅くなる。
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        putSampleData(linkedHashMap);
        System.out.println(linkedHashMap);

        // TreeMapはkeyで並び替える
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        putSampleData(treeMap);
        System.out.println(treeMap);
        boolean containsKey = treeMap.containsKey(3);
        System.out.println(containsKey);

        HashMap<Person, String> hashMap2 = new HashMap<>();
        hashMap2.put(new Person("hamada", 30, 170, 65), "aaaa");
        hashMap2.put(new Person("imai", 20, 179, 70), "aaaa");
        hashMap2.put(new Person("iida", 38, 172, 64), "aaaa");
        hashMap2.put(new Person("kobayashi", 43, 171, 70), "aaaa");
        hashMap2.put(new Person("kinjo", 45, 176, 68), "aaaa");
        hashMap2.put(new Person("takei", 30, 180, 78), "aaaa");
        // Map
        boolean containsKey2 = hashMap2.containsKey(new Person("iida", 38, 172, 64));
        System.out.println(containsKey2);

        TreeMap<Person, Integer> treeMap2 = new TreeMap<>(new Comparator<Person>()
        {
            @Override
            public int compare(Person o1, Person o2)
            {
                return o1.getName().length() - o2.getName().length();
            }
        });

        treeMap2.put(new Person("hamada", 30, 170, 65), 1);
        treeMap2.put(new Person("kobayashi", 43, 171, 70), 1);
        treeMap2.put(new Person("takei", 30, 180, 78), 1);
        treeMap2.put(new Person("imai", 20, 179, 70), 1);
        System.out.println(treeMap2);
    }

    // Javaは参照渡しをするので引数で渡されたMapはこのmethod呼び出し時に変更される。C言語などは参照渡しをしないので同じようにしても値は変更されない。
    // 変数の前に*をつけてポインタを渡すことで同じ挙動にすることができる。
    private static void putSampleData(Map<Integer, String> hashMap)
    {
        hashMap.put(2, "two");
        hashMap.put(1, "one");
        hashMap.put(6, "six");
        hashMap.put(4, "four");
        hashMap.put(5, "five");
        hashMap.put(3, "three");
    }
}
// Predicate interfaceのevaluateをoverrideする。
class IntegerPredicate implements Predicate<Integer>
{
    // evaluateではlistの中の値に対してfilterする条件を書く
    @Override
    public boolean evaluate(Integer arg0)
    {
        return arg0 % 2 != 0;
    }
}
