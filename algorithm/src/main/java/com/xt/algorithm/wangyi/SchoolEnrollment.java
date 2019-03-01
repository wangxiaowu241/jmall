/**
 * $Id: SchoolEnrollment.java,v 1.0 2019/1/30 10:17 AM wangxiaoteng
 *
 * @Copyright (c) 2019/1/30, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.wangyi;

import java.util.ArrayList;
import java.util.List;

/**
 * 网易校招算法题
 *
 * @author wangxiaoteng
 * @version $Id: SchoolEnrollment.java,v 1.0 2019/1/30 10:17 AM wangxiaoteng
 * @date 2019/1/30 下午10:17 AM
 */
public class SchoolEnrollment {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println("获得指定硬币的机器顺序为:" + getSpecialAmountCoin(10, list));
        getContraryNumber(1325);

        getPieceStringAverageLength("aaabbaaac");
    }

    /**
     * 一、获得特定数量硬币问题
     * <p>
     * 思路：从要获得的值开始入手，如果是偶数，说明上一个机器是2号机器，如果是奇数，说明上一个机器是1号机器，直至第一个机器
     *
     * @param number     要获得的指定硬币的数量
     * @param machineNum 空list即可
     *
     *                   <p>
     *                   小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,但是小易现在一枚魔法币都没有,但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
     *                   <p>
     *                   魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
     *                   <p>
     *                   魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
     *                   <p>
     *                   小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。
     *                   <p>
     *                   输入描述: 输入包括一行,包括一个正整数n(1 ≤ n ≤ 10^9),表示小易需要的魔法币数量。
     *                   <p>
     *                   输出描述: 输出一个字符串,每个字符表示该次小易选取投入的魔法机器。其中只包含字符'1'和'2'。
     *                   <p>
     *                   输入例子1: 10
     *                   <p>
     *                   输出例子1: 122
     *                   </p>
     */
    public static String getSpecialAmountCoin(Integer number, List<String> machineNum) {

        if (number <= 0) {
            //num=0，说明已经累计到第一个机器了，且第一个机器输出的值为偶数2，停止运行，输出机器号
            return listToStringAndReverse(machineNum);
        }
        if (number == 1) {
            //num=1，说明已经累计到第一个机器了，且第一个机器输出的值为奇数1，停止运行，输出机器号
            machineNum.add(String.valueOf(1));
            return listToStringAndReverse(machineNum);
        }

        if (number % 2 == 0) {
            //偶数
            machineNum.add(String.valueOf(2));
            return getSpecialAmountCoin((number - 2) / 2, machineNum);

        } else {
            //奇数
            machineNum.add(String.valueOf(1));
            return getSpecialAmountCoin(number / 2, machineNum);
        }

    }

    /**
     * 反向输出机器号
     *
     * @param machineNum
     * @return
     */
    public static String listToStringAndReverse(List<String> machineNum) {
        StringBuilder s = new StringBuilder();
        for (int i = machineNum.size() - 1; i >= 0; i--) {
            s.append(machineNum.get(i));
        }
        return s.toString();
    }

    /**
     * 二、求“相反数”问题
     *
     * @param number 输入的值
     *               <p>
     *               为了得到一个数的"相反数",我们将这个数的数字顺序颠倒,然后再加上原先的数得到"相反数"。
     *               <p>
     *               例如,为了得到1325的"相反数",首先我们将该数的数字顺序颠倒,我们得到5231,
     *               <p>
     *               之后再加上原先的数,我们得到5231+1325=6556.如果颠倒之后的数字有前缀零,前缀零将会被忽略。例如n = 100, 颠倒之后是1.
     *               <p>
     *               输入描述: 输入包括一个整数n,(1 ≤ n ≤ 10^5)
     *               <p>
     *               输出描述: 输出一个整数,表示n的相反数
     *               <p>
     *               输入例子1: 1325
     *               <p>
     *               输出例子1: 6556
     */
    public static void getContraryNumber(Integer number) {

        //1.先转成char数组
        char[] charArray = String.valueOf(number).toCharArray();
        //2.合成字符串list
        List<String> reverseNumberString = new ArrayList<>(charArray.length);
        for (int i = 0; i < charArray.length; i++) {
            reverseNumberString.add(String.valueOf(charArray[i]));
        }
        //3.字符串list反转，再转成数字类型
        Integer contraryNumber = Integer.valueOf(listToStringAndReverse(reverseNumberString));

        System.out.println(number + "的相反数为：" + (number + contraryNumber));
    }

    /**
     * 三、字符串碎片的平均长度
     *
     * @param pieceString 字符串碎片
     *
     *                    <p>
     *                    一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。牛牛现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。
     *                    <p>
     *                    输入描述: 输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s只含小写字母('a'-'z')
     *                    <p>
     *                    输出描述: 输出一个整数,表示所有碎片的平均长度,四舍五入保留两位小数。
     *                    <p>
     *                    如样例所示: s = "aaabbaaac" 所有碎片的平均长度 = (3 + 2 + 3 + 1) / 4 = 2.25
     *                    <p>
     *                    输入例子1: aaabbaaac
     *                    <p>
     *                    输出例子1: 2.25
     */
    public static void getPieceStringAverageLength(String pieceString) {
        float count = 1;
        for (int i = 0; i < pieceString.length() - 1; i++) {
            if (pieceString.charAt(i) != pieceString.charAt(i + 1)) {
                count++;
            }

        }
        System.out.println("字符串碎片" + pieceString + "的平均长度为：" + Float.valueOf(pieceString.length()) / count);
    }

}
