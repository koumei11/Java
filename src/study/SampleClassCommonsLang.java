package study;

import org.apache.commons.lang3.StringUtils;

public class SampleClassCommonsLang
{
    public static void main(String[] args)
    {
        String str1 = "";
        String str2 = null;
        String str3 = "ああああ";

        System.out.println(StringUtils.isEmpty(str1));
        System.out.println(StringUtils.isEmpty(str2));
        System.out.println(StringUtils.isEmpty(str3));

        String str4 = "123";
        String str5 = "kofojgo";
        System.out.println(StringUtils.isAlpha(str4));
        System.out.println(StringUtils.isAlpha(str5));
        System.out.println(StringUtils.isNumeric(str4));
    }
}
