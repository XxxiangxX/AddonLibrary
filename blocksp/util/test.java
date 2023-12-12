package blocksp.util;

import blocksp.util.Maps.ArraysMap;


public class test {
    public static void main(String[] args) {
        ArraysMap<Integer,String> map = new ArraysMap<>(Integer.class,String.class,10);
        map.add(1,"jntm");
        System.out.println(map.getKey(0) + " : " +map.getValue(0));
        map.removeFormKey(1);
        System.out.println(map.getKey(0) + " : " +map.getValue(0));
        map.removeFormKey(114514);
        System.out.println(map.getKey(0) + " : " +map.getValue(0));
    }
}
