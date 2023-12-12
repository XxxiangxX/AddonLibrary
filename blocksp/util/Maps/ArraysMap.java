package blocksp.util.Maps;

import java.lang.reflect.Array;

public class ArraysMap<K,V> {
    private int maxNum;
    public int num = -1;
    public K[] key;
    public V[] value;
    public ArraysMap(Class<K> keys, Class<V> values, int array_long){
        key = (K[]) Array.newInstance(keys, array_long);
        value = (V[]) Array.newInstance(values, array_long);
    }
    public K[] getKeys(){
        return key;
    }
    public V[] getValues(){
        return value;
    }
    public K getKey(int num){
        if(key[num] != null) {
            return key[num];
        }
        return null;
    }
    public V getValue(int num){
        if(value[num] != null){
            return value[num];
        }
        return null;
    }
    //================ADD METHOD=======================
    public void add(K keys,V values){
        num++;
        int key_l = key.length;
        int value_l = value.length;
        for(int i = 0;i < key_l;i++){
            if(key[i] == keys && key[i] != null){
                value[i] = values;
                break;
            }else if(key[i] == null){
                for(int i1 = 0;i < key_l;i++){
                    if(key[i1] == null){
                        key[i1] = keys;
                        break;
                    }
                }
                for(int i2 = 0;i < value_l;i++){
                    if(value[i2] == null){
                        value[i2] = values;
                        break;
                    }
                }
            }
        }
    }
    //===========================================
    public void removeFormKey(K keys){
        num--;
        for(int i = 0;i < key.length;i++){
            if(key[i] != null && key[i] == keys){
                key[i] = null;
                value[i] = null;
                break;
            }else{
                if(i == key.length - 1){
                    throw new NullPointerException("cannot remove! Because system cannot find keys in the map");
                }
            }
        }
    }
}
