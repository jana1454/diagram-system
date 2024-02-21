package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import system.*;

import org.junit.Test;

public class StudentTests {

	@Test
	public void test01ragged() {
		char[][] array = new char[3][];
		array[0] = new char[7];
		array[1] = new char[6];
		array[2] = new char[8];
		assertTrue(TwoDimArrayUtil.isRagged(array) == true);
		
		char[][] array2 = new char[3][3];
		assertTrue(TwoDimArrayUtil.isRagged(array2) == false);
	}
	
	@Test
	public void test02rotateLeft() {
		char[][] array = {{'a', 'b', 'c', 'd'}, {'d', 'e', 'f', 'g'}, {'g', 'h', 'i', 'j'}};
		TwoDimArrayUtil.rotateLeftOneColumn(array);
		assertTrue(Arrays.deepToString(array).equals("[[b, c, d, a], [e, f, g, d], [h, i, j, g]]"));
		
		char[][] array2 = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
		TwoDimArrayUtil.rotateTopOneRow(array2);
		assertTrue(Arrays.deepToString(array2).equals("[[d, e, f], [g, h, i], [a, b, c]]"));
	}
	
	@Test
	public void test03appendLeftRight() {
		char[][] left = {{'g', 'h',}, {'i', 'j'}, {'k', 'l'}};
		char[][] right = {{'m'}, {'o'}, {'p'}};
		char[][] answer = TwoDimArrayUtil.appendLeftRight(left, right);
		System.out.println(Arrays.deepToString(answer));
		assertTrue(Arrays.deepToString(answer).equals("[[g, h, m], [i, j, o], [k, l, p]]"));
		
		char[][] left2 = {{'g', 'h',}, {'i', 'j'}, {'k', 'l'}};
		char[][] right2 = {{'m'}, {'o'}};
		char[][] answer2 = TwoDimArrayUtil.appendLeftRight(left2, right2);
		System.out.println(Arrays.deepToString(answer2));
		assertTrue(Arrays.deepToString(answer2).equals("[[g, h, m], [i, j, o], [k, l]]"));
		
		
	}
	
	@Test
	public void test03appendTopBottom() {
		char[][] top = {{'g', 'h',}, {'i', 'j'}, {'k', 'l'}};
		char[][] bottom = {{'m', 'k'}, {'o', 'l'}, {'p', 'i'}};
		char[][] answer = TwoDimArrayUtil.appendTopBottom(top, bottom);
		assertTrue(Arrays.deepToString(answer).equals("[[g, h], [i, j], [k, l], [m, k], [o, l], [p, i]]"));
		
		char[][] top2 = {{'g', 'h',}, {'i', 'j'}, {'k', 'l'}};
		char[][] bottom2 = {{'m'}, {'o'}};
		char[][] answer2 = TwoDimArrayUtil.appendTopBottom(top2, bottom2);
		assertTrue(Arrays.deepToString(answer2).equals("[[g, h], [i, j], [k, l], [m], [o]]"));
	}

}
