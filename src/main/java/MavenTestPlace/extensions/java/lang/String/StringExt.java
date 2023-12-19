package MavenTestPlace.extensions.java.lang.String;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.apache.commons.lang3.StringUtils;

@Extension
public class StringExt {
    public static void helloWorld(@This String str) {
        System.out.println("hello world!");
    }

    public static String[] split(@This String str, char separator) {
        return StringUtils.split(str, separator);
    }
}