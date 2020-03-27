package com.jax.study.leetcode.util;

/**
 * 计算最大公约数和最小公倍数
 */
public class zdgys_zxgbs {
	public static void main(String[] args) {
		System.out.println(getBigDiv(40, 56));
		System.out.println(getSmallMul(20, 12));
		int num[] = { 12, 20, 8 };
		System.out.println(getMoreBigDiv(num, 3));
		System.out.println(getMoreSmallMul(num, 3));
	}
 
	public static int getBigDiv(int a, int b) {// 求两个数的最大公约数
		if (b == 0)
			return a;
		return getBigDiv(b, a % b);
	}
 
	public static int getSmallMul(int a, int b) {// 求两个数的最小公倍数
		return (a * b) / getBigDiv(a, b);
	}
 
	public static int getMoreBigDiv(int num[], int n) { // 求多个数的最大公约数
		if (n == 1)
			return num[n - 1];
		return getBigDiv(num[n - 1], getMoreBigDiv(num, n - 1));
	}
 
	public static int getMoreSmallMul(int num[], int n) {// 求多个数的最小公倍数
		if (n == 1)
			return num[n - 1];
		return getSmallMul(num[n - 1], getMoreSmallMul(num, n - 1));
	}
}