package com.ze.offer;

class 打印1到最大的n位数{
	public static void main(String[] args) {
		Print1ToMaxOfNDigits(3);
	}
	public static void Print1ToMaxOfNDigits(int n) {
		if (n <= 0)
			return;
		char[] number = new char[n + 1];
		number[n] = '\0';
		for (int i = 0; i < 10; ++i) {
			number[0] = (char) (i + '0');
			Print1ToMaxOfNDigitsRecursively(number, n, 0);
		}
		
	}

	public static void Print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
		if (index == length - 1) {
			PrintNumber(number);
			return;
		}
		for (int i = 0; i < 10; ++i) {
			number[index + 1] = (char) (i + '0');
			Print1ToMaxOfNDigitsRecursively(number, length, index + 1);
		}
	}

	private static void PrintNumber(char[] number) {
		boolean isBeginning0 = true;
		int nlength = number.length;
		for (int j = 0; j < nlength; j++) {
			if (isBeginning0 && number[j] != '0') {
				isBeginning0 = false;
			}
			if(!isBeginning0){
				System.out.print(number[j]);
			}
		}
	}
}