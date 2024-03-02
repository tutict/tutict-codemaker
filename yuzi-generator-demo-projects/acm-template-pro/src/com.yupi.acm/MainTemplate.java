package com.yupi.acm;

import java.util.Scanner;

/**
* @author hg;
*/
public class MainTemplate {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);

while (scanner.hasNext()) {

int n = scanner.nextInt();

int[] arr = new int[n];
for (int i = 0; i < n; ++i) {
arr[i] = scanner.nextInt();
}

int sum = 0;
for (int num : arr) {
sum += num;
}

System.out.println("lll" + sum);
}

scanner.close();
}
}