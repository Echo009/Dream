# 保卫方案

[题目链接](https://www.nowcoder.com/test/question/e1967ae812ea42e7a3ce57ee1f83b686?pid=5715499&tid=13579606)

> 战争游戏的至关重要环节就要到来了，这次的结果将决定王国的生死存亡，小B负责首都的防卫工作。首都位于一个四面环山的盆地中，周围的n个小山构成一个环，作为预警措施，小B计划在每个小山上设置一个观察哨，日夜不停的瞭望周围发生的情况。 一旦发生外地入侵事件，山顶上的岗哨将点燃烽烟，若两个岗哨所在的山峰之间没有更高的山峰遮挡且两者之间有相连通路，则岗哨可以观察到另一个山峰上的烽烟是否点燃。由于小山处于环上，任意两个小山之间存在两个不同的连接通路。满足上述不遮挡的条件下，一座山峰上岗哨点燃的烽烟至少可以通过一条通路被另一端观察到。对于任意相邻的岗哨，一端的岗哨一定可以发现一端点燃的烽烟。 小B设计的这种保卫方案的一个重要特性是能够观测到对方烽烟的岗哨对的数量，她希望你能够帮她解决这个问题。 
输入描述:
输入中有多组测试数据，每一组测试数据的第一行为一个整数n(3<=n<=10^6),为首都周围的小山数量，第二行为n个整数，依次表示为小山的高度h（1<=h<=10^9）.


> 输出描述:
对每组测试数据，在单独的一行中输出能相互观察到的岗哨的对数。


    样例输入：
    5
    1 2 4 5 3
    样例输出：
    7
   
关键在于如何保证不重复计算。

在没有重复值的情况下，对于一个哨岗（除开最高的哨岗，和次高的哨岗），从左边和右边各自找到第一个比它本身高度要大的哨岗，那么对于每个哨岗就有两对，再加上最高和次高形成的一对，那么总数即是固定的，2(N-2)+1，即2N-3。

考虑有重复值的情况下，该如何统计 。 

利用单调栈的解法：

- 找到最高的一个哨岗，以其为起始点，一个方向遍历数组（环）
- 栈中需同时记录哨岗的高度以及哨岗出现次数（因为可能有重复元素）
- 在遍历过程中
    - 如果栈为空或者栈顶元素大于当前值，则直接入栈。
    - 如果栈顶元素值和当前值相等，则元素出现次数加一
    - 如果栈顶元素值小于当前值，则将栈顶元素弹出，并且算出以该栈顶元素为较矮的一方的哨岗对数，注意如果该栈顶元素出现次数不为1的时候需要统计内部成对数量[C(n,2)]
- 遍历完成后依次将栈中元素弹出，并且统计对数
    - 对于栈中剩下元素大于等于2的时候计算方式与之前一致
    - 栈中剩下元素等于1的时候，需要注意栈中元素出现次数，如果仅出现了一次，那么对于当前元素成对数则不需要乘以2，因为无论从哪个方向都只能找到同一个比它要高的哨岗

```java
public class ProtectScheme {
    
    public static class Pair {
        public final long value;
        public long times;

        public Pair(long value, long times) {
            this.value = value;
            this.times = times;
        }
    }

    public static long numOfPairs(long[] array) {
        Stack<Pair> stack = new Stack();
        int currentIndex = findMaxValueIndex(array);
        long num = 0;
        for (int i = 0; i < array.length; i++) {
            // 压栈
            if (stack.isEmpty() || stack.peek().value > array[currentIndex]) {
                stack.push(new Pair(array[currentIndex], 1));
            } else if (stack.peek().value == array[currentIndex]) {
                // 值相等
                Pair pair = stack.pop();
                pair.times++;
                stack.push(pair);
            } else {

                // 栈顶值小于当前值 ,  计算次数
                while (!stack.isEmpty() && stack.peek().value < array[currentIndex]) {
                    Pair pair = stack.pop();
                    // 计算本身可以形成的对
                    num += selfTimes(pair);
                    num += pair.times * 2;
                }
                if (stack.peek().value == array[currentIndex]) {
                    Pair pair = stack.pop();
                    pair.times++;
                    stack.push(pair);
                } else {
                    stack.push(new Pair(array[currentIndex], 1));
                }
            }
            currentIndex = nextIndex(array, currentIndex);
        }
        // 结算
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            // 计算本身可以形成的对
            num += selfTimes(pair);
            if (stack.size() >= 2) {
                // 因为是环形所以两端找到的都是最高的哨岗
                num += pair.times * 2;
            } else if (stack.size() == 1){
                // 最后栈中剩下的哨岗不止一座
                if (stack.peek().times > 1) {
                    num+=pair.times*2;
                }else{ num+=pair.times;}
            }
        }
        return num;
    }

    private static long selfTimes(Pair pair) {
        if (pair.times == 1) {
            return 0;
        } else {
            // Cn 2
            return pair.times * (pair.times - 1) / 2;
        }
    }

    /**
     * 获取下一个下标的值
     */
    private static int nextIndex(long[] array, int index) {
        return index == array.length - 1 ? 0 : ++index;
    }

    /**
     * 获取数组中最大值的下标
     */
    private static int findMaxValueIndex(long[] array) {
        int currentIndex = 0;
        long currentMaxVlue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (currentMaxVlue < array[i]) {
                currentIndex = i;
                currentMaxVlue = array[i];
            }
        }
        return currentIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
        }
        System.out.println(numOfPairs(array));
    }
}

```