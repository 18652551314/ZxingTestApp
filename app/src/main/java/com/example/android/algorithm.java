package com.example.android;

/**
 * Created by Android on 2018/3/20.
 */

public class algorithm {
    /**
     * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，
     * 假如兔子都不死，问每个月的兔子总数为多少？1.程序分析：兔子的规律为数列1,1,2,3,5,8,13,21....
     */
    public void quest1(int n) {
        int[] result = new int[n];
        int first = 0, second = 1;//前一个月和前两个月的兔子数
        for (int i = 0; i < n; i++) {
            result[i] = f(i);
        }
    }

    public int f(int x) {
        if (x == 1 || x == 2)
            return 1;
        else
            return f(x - 1) + f(x - 2);
    }

    /**
     * 判断101-200之间有多少个素数，并输出所有素数。
     * 判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，则表明此数不是素数，反之是素数。
     */
    public void quest2() {
        for (int i = 2; i <= 200; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                System.out.print(" " + i);
            }
        }
    }

    /**
     * 所有的 水仙花数例如：153是一个 水仙花数 ，因为153=1的三次方＋5的三次方＋3的三次方
     */
    public void quest3() {
        for (int i = 100; i < 999; i++) {
            int g = i % 10;
            int s = i / 10 % 10;
            int b = i / 100;
            if (i == (g * g * g + s * s * s + b * b * b)) System.out.print(" " + i);
        }
    }

    /**
     * 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
     */

    private void quest4(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                System.out.print(i);
                if (n != i) {
                    System.out.print("*");
                }
                quest4(n / i);
            }
        }
    }

    /**
     * 利用条件运算符的嵌套来完成此题：学习成绩=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
     */
    public String quest5(int n) {
        return n < 60 ? "C" : (n < 90 ? "B" : "A");
    }

    /**
     * 输入两个正整数m和n，求其最大公约数和最小公倍数。
     */
    int max = 1;
    int min = 1;

    public void quest6(int m, int n) {
        for (int i = 2; i < Math.max(m, n); i++) {
            if (i % m == 0 && i % n == 0) {
                max *= i;
                quest6(m / i, n / i);
            }
        }
        min = m * n / max / max;
    }

    /**
     * 输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
     * 1.程序分析：利用for循环语句,if条件语句。
     */
    public void quest7(String s) {
        int[] arr = new int[4];
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if ((c[i] >= 'a' && c[i] <= 'z') || (c[i] >= 'A' && c[i] <= 'Z')) {
                arr[0]++;
            } else if (c[i] == ' ') {
                arr[1]++;
            } else if (c[i] >= '0' && c[i] <= '9') {
                arr[2]++;
            } else {
                arr[3]++;
            }

        }
    }

    /**
     * 求s = a + aa + aaa + aaaa + aa...a的值，其中a是一个数字。例如2 + 22 + 222 + 2222 + 22222(此时共有5个数相加)，几个数相加有键盘控制。
     */

    public void quest8(int a) {
        int result = 0;
        for (int i = 0; i < a; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                temp += a * Math.pow(10, j);
            }
            result += temp;
        }
    }

    /**
     * 一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3。编程找出1000以内的所有完数。
     */
    public void quest9() {
        for (int i = 0; i < 1000; i++) {
            if (i == getchildsum(i)) System.out.print(i);
        }
    }

    private int getchildsum(int i) {
        int sum = 0;
        for (int j = 1; j < i; j++) {
            if (i % j == 0) sum += j;
        }
        return sum;
    }

    /**
     * ：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？
     */
    int sum = 0;

    public void quest10(int h, int n) {
        for (int i = 0; i < n; i++) {
            if (i == 0)
                sum += h / Math.pow(2, i);
            else
                sum += h / Math.pow(2, i) * 2;
        }

    }

    /**
     * 有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少
     */
    public void quest11(int n) {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if (i == j) continue;
                for (int k = 1; k < 5; k++) {
                    if (i == k || j == k) continue;
                    System.out.print(i * 100 + j * 10 + k);
                }
            }
        }

    }

    /**
     * 一个整数，它加上100后是一个完全平方数，加上168又是一个完全平方数，请问该数是多少？
     */
    public void quest12() {
        for (int x = 1; x < 100000; x++) {
            if (Math.sqrt(x + 100) % 1 == 0)
                if (Math.sqrt(x + 100 + 168) % 1 == 0)
                    System.out.println(x);
        }
    }

    /**
     * 输入某年某月某日，判断这一天是这一年的第几天？
     */
    public void quest13(int n, int y, int r) {
        int sum = r;
        for (int i = 1; i < y; i++) {
            switch (i - 1) {
                case 1:
                    sum += 31;
                    break;
                case 2:
                    if (n % 4 == 0) {
                        sum += 29;
                    } else {
                        sum += 28;
                    }
                    break;
                case 3:
                    sum += 31;
                    break;
                case 4:
                    sum += 30;
                    break;
                case 5:
                    sum += 31;
                    break;
                case 6:
                    sum += 30;
                    break;
                case 7:
                    sum += 31;
                    break;
                case 8:
                    sum += 31;
                    break;
                case 9:
                    sum += 30;
                    break;
                case 10:
                    sum += 31;
                    break;
                case 11:
                    sum += 30;
                    break;
                case 12:
                    sum += 31;
                    break;
            }
        }
        System.out.println(sum);
    }

    /**
     * 01
     * 02 03
     * 04 05 06
     * ...
     */
    public void quest14(int max) {
        int j = 0;
        for (int i = 1; i <= max; i++) {
            System.out.print(String.format("%02d", i) + "\t");
            if (j < i) {
                System.out.println();
                j++;
            }
        }
    }
    /**计算圆周率π的两种方法*/
    public void quest15() {
        cut(12);//切割次数
        cutCircle(20);
        jishuPI(0.000000001);//精度
    }
    /**
     * 计算公式为：
     * π≈3*2^n*y_n
     * 其中，n代表割圆次数，y_n代表圆中内嵌正6*n边形的边长
     */


    static void cut(int n){
        double y=1.0;
        for(int i=0;i<=n;i++){
            double π=3*Math.pow(2, i)*y;
            System.out.println("第"+i+"次切割,为正"+(6+6*i)+"边形，圆周率π≈"+π);
            y=Math.sqrt(2-Math.sqrt(4-y*y));
        }

    }
    static void cutCircle(int c){
        double r=1.0;//半径
        int n=6;//六边形
        double l=1.0;//正六边形边长
        double π=0;//圆周率
        for(int i=0;i<=c;i++){
           double h=Math.sqrt(r*r-(l/2)*(l/2));
            l = Math.sqrt((r - h) * (r - h) + (l / 2) * (l / 2));
            n = n*2;
            π=(l*n)/(r*2);
            System.out.println(c + "  " +π); // 填空
        }
    }
    /**
     * 无穷级数法
     * 求圆周率π的级数公式为：
     */
    static double jishuPI(double z){
        double sum=2;
        int n=1;
        int m=3;
        double t=2;
        while(t>z){
            t=t*n/m;
            sum=sum+t;
            n++;
            m+=2;
        }
        return sum;
    }
    /***/
    public void quest16(int n) {

    }

}

