package study.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.apache.commons.collections4.comparators.ReverseComparator;
import org.apache.commons.lang3.StringUtils;

public class Class20200319
{

    public static void main(String[] args)
    {
        // 配列
        int[] ints = {0, 15, 34, 2, 6};
        System.out.println(ints.length);
        System.out.println(ints[0]);
        Arrays.sort(ints);
        System.out.println(ints);
        System.out.println(Arrays.toString(ints));
        // Comparator<Integer> c = new MyComparator();
        // Arrays.sort(ints, c);

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
        Collections.sort(list);
        System.out.println(list);
        Comparator<Integer> c = new MyComparator();
        Collections.sort(list, c);
        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        list2.add("sato");
        list2.add("kinjo");
        list2.add("yamane");
        list2.add("ichikawa");
        list2.add("kobayashi");
        System.out.println(list2);
        // 辞書順(デフォルト)
        Collections.sort(list2);
        System.out.println(list2);
        // 長さ順
        Collections.sort(list2, new StringComparator());
        System.out.println(list2);
        // 無名関数を使っての並べ替え
        Collections.sort(list2, new Comparator<String>()
        {
            // apache commonsを使用して文字列の中のaの多さで並べ替え
            @Override
            public int compare(String o1, String o2)
            {
                return StringUtils.countMatches(o1, "a") - StringUtils.countMatches(o2, "a");
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
        /*
         * Collectionsのsortで並べ替えができるのはComparable<T>を実装したclassのみ
         * StringもIntegerもComparable<T>を実装しているからsortができている
         * Personをsortにかけても比べる対象が何なのかわからないため通常だとエラーになる
         * そこでPerson classにもComparable<T>(Tは対象にしたいものの型)を実装してcompareTo methodをoverrideする
         */
        Collections.sort(list3);
        System.out.println(list3);
        Collections.sort(list3, new Comparator<Person>()
        {
            /*
             *  一つに対してではなく複数項目に対して比較を行いたい場合は新たに無名関数の中で行う
             *  最初、体重で比べて体重が同じだった場合はPerson classで実装されているcompareToの処理内容の逆を行う
             *  しかしこの書き方だと比較したい項目が増えていった場合にifの中にnestしていかなければならない
             */
            @Override
            public int compare(Person o1, Person o2)
            {
                int weightResult = o1.getWeight() - o2.getWeight();
                if(weightResult == 0)
                {
                    return -o1.compareTo(o2);
                }

                return weightResult;
            }
        });
        System.out.println(list3);

        /*
         *  nestを深くしたくない場合はcommonsのlibraryを使うといい
         *  なお、ジェネリックスを使用したComparatorChain<T>はcommons-collections4のものだがBeanComparatorはcommons-collections3を参照しているのでどっちもビルドパスに追加しなければいけない
         *  ちなみにここでPerson classをpublicではなく修飾子なしで定義するとNoSuchMethodExceptionでageに対してgetterがないというエラーが発生する。しかしPerson classを見てみるとageにgetterは付いている。これはageに対するエラーではなくPersonがpublicではないためにそのパッケージ外、つまりBeanComparatorから参照できなくなってしまっていて起こるエラー。エラー文を見ただけではそのことに気がつかない。。
         *  beanutilsを使った方法
         */
        // ageで比較
        Collections.sort(list3, new BeanComparator<Person>("age"));
        System.out.println(list3);
        // BeanComparatorは第二引数を取れる。ageの逆順
        Collections.sort(list3, new BeanComparator<Person>("age", new ReverseComparator<>()));
        System.out.println(list3);
        // ComparatorChainを使って比較項目の指定ができる。入れた順=優先順位
        ComparatorChain<Person> chain = new ComparatorChain<>();
        chain.addComparator(new BeanComparator<Person>("weight"));
        // addComparatorの第二引数では逆順にするかどうかのbooleanを取れる
        chain.addComparator(new BeanComparator<Person>("name"), true);
        chain.addComparator(new BeanComparator<Person>("height"), true);
        chain.addComparator(new BeanComparator<Person>("age"));
        Collections.sort(list3, chain);
        System.out.println(list3);
    }
}

// ジェネリックスを使用したComparatorを実装
class MyComparator implements Comparator<Integer>
{
    /*
     * Comparatorを実装したclassは必ずcompareをoverrideしなければならない
     * compare methodは返ってくる値が何なのかは気にしない。正なのか負なのか0なのかが重要
     */
    @Override
    public int compare(Integer o1, Integer o2)
    {
        // o1 - o2で普通の小さい順に並べ替え
        return -(o1 - o2);
    }
}
// ジェネリックスを使用したComparatorを実装
class StringComparator implements Comparator<String>
{
    // 長さの短い順で並べ替え
    @Override
    public int compare(String o1, String o2)
    {
        return o1.length() - o2.length();
    }
}