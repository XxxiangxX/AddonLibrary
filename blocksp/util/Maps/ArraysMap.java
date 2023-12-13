package blocksp.util.Maps;

import blocksp.util.Misc.NullException;
import blocksp.util.Misc.ValueAlreadyExistException;

import java.lang.reflect.Array;

public final class ArraysMap<K,V>{
    /**
     * 创建对象的方式: ArraysMap<(类名 className),(类名 className)> <变量名 varName> = new ArraysMap<>(<类名.class>,<类名.class>,<数组长度 array_long>);
     * 其中的类名与构建对象的类名是一样的，例如: ArraysMap<Integer,String> map = new ArraysMap<>(Integer.class,String.class,10);
     **/
    private final K[] key;
    private final V[] value;
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
    public V getValueFormKey(K keys){
        for(int i = 0;i < key.length;i++){
            if(key[i] == keys && key[i] != null){
                return value[i];
            }
        }
        return null;
    }
    public K getKeyFormValue(V value){

        return null;
    }
    public boolean containKey(K keys){
        for (K k : key) {
            if (k == keys && k != null) {
                return true;
            }
        }
        return false;
    }
    public void removeAll(){
        for(int i = 0;i < key.length;i++){
            key[i] = null;
            value[i] = null;
        }
    }

    //================ADD METHOD=======================
    public void add(K keys,V values){
        int key_l = key.length;
        for(int i = 0;i < key_l;i++){
            if(value[i] == values){
                throw new ValueAlreadyExistException();
            }else{
                if(key[i] == keys && key[i] != null){
                    value[i] = values;
                    break;
                }else if(key[i] == null){
                    key[i] = keys;
                    value[i] = values;
                    break;
                }
            }
        }
    }
    //==================REMOVE_KEY METHOD======================
    public void removeFormKey(K keys) throws NullException {
        for(int i = 0;i < key.length;i++){
            if(key[i] != null && key[i] == keys){
                key[i] = null;
                value[i] = null;
                break;
            }else{
                if(i == key.length - 1){
                    throw new NullException("cannot remove! Because system cannot find keys in the map");
                }
            }
        }
    }
    //=======================REMOVE_VALUE METHOD============================
    public void removeFormValue(V values) throws NullException {
        for(int i = 0;i < value.length;i++){
            if(value[i] != null && value[i] == values){
                key[i] = null;
                value[i] = null;
                break;
            }else{
                if(i == value.length - 1){
                    throw new NullException("cannot remove! Because system cannot find keys in the map");
                }
            }
        }
    }
}
