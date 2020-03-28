package study.classes;

import java.util.Arrays;
import java.util.Optional;

public class Seigyobun {

    public static void main(String[] args) {
        // 分岐
        String input = (args.length == 0) ? "なし" : "あり";
        System.out.println(input);

        String input2;
        if(args.length == 0) {
            input2 = "なし";
        } else if(args.length < 10) {
            input2 = "少し";
        } else {
            input2 = "たくさん";
        }
        System.out.println(input2);

        String input3;
        switch (args.length) {
        case 1:
            input3 = "１個";
            break;
        case 3:
            input3 = "３個";
            break;
        default:
           input3 = "１個でも３個でもない";
        }
        System.out.println(input3);

        // 繰り返し
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += Integer.parseInt(args[i]);
        }
        System.out.println(sum);

        int sum2 = 0;
        for (String string : args) {
            sum2 += Integer.parseInt(string);
        }
        System.out.println(sum2);

        int sum3 = 0;
        int num = 0;
        while (num < args.length) {
            sum3 += Integer.parseInt(args[num]);
            num++;
        }
        System.out.println(sum3);

        boolean exists1char = false;
        for(String arg : args) {
            if(arg.length() == 1) {
                exists1char = true;
                break;
            }
        }
        System.out.println(exists1char);

        int sum4 = 0;
        for (String string : args) {
            if(string.length() == 1) {
                sum4 += Integer.parseInt(string);
            }
        }
        System.out.println(sum4);

        int sum5 = 0;
        for (String string : args) {
            if(string.length() != 1) {
                continue;
            }
            sum5 += Integer.parseInt(string);
        }
        System.out.println(sum5);

        Optional<Integer> reduced = Arrays.stream(args)
                .filter(e -> e.length() == 1)
                .map(e -> Integer.parseInt(e))
                .reduce((a, b) -> a + b);
        // nullの場合、０。このようにnull専用のmethodが用意されている。
        int sum6 = reduced.orElse(0);
        System.out.println(sum6);
    }
}
