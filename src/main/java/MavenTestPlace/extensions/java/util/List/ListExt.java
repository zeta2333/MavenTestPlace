package MavenTestPlace.extensions.java.util.List;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import java.util.List;

@Extension
public class ListExt {
  public static <E> void helloWorld(@This List<E>  thiz) {
    System.out.println("hello world!");
  }
}