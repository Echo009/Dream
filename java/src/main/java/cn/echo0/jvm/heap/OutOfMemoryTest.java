/*
*start code
*/
package cn.echo0.jvm.heap;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/1/31 18:53
 */
public class OutOfMemoryTest {

    public static void main(String[] args){

        List list = new LinkedList();
        while (true){
            Object item = new Object();
            list.add(item);
        }
    }

}
