package com.yupi.acm;

import java.util.Scanner;

/**
* @author ${author}
*/
public class MainTemplate {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);

<#if loop>
while (scanner.hasNext()) {
</#if>

int n = scanner.nextInt();

int[] arr = new int[n];
for (int i = 0; i < n; ++i) {
arr[i] = scanner.nextInt();
}

int sum = 0;
for (int num : arr) {
sum += num;
}

System.out.println("${outputText}" + sum);
<#if loop>
}
</#if>

scanner.close();
}
}