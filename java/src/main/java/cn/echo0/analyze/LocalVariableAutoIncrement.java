package cn.echo0.analyze;

/**
 * @Author Ech0
 * @Email  ech0.extreme@foxmail.com
 * @Time   10/29/2017 07:55 PM
 */
public class LocalVariableAutoIncrement {

    private static void test() {
        int i = 0;
        i = i++;

        // 上边的两行代码对应字节码指令 ：
        /*
        0 : iconst_0    将int类型的常量0推送至操作数栈顶
        1 : istore_0    将栈顶int类型的变量存入第一个本地变量（位于局部变量表，是一个数组的结构以字长为单位，因为是static方法故在第一个位置即下标0处）
        2 : iload_0     将int类型的数值0推送到操作数栈顶
        3 : iinc 0,1    将局部变量表索引0处int类型的变量值加一
        6 : istore_0    将操作数栈顶的元素存入第一个本地变量（局部变量表中）
         */
        // 故执行完之后 i 的值仍为 0
    }

}
