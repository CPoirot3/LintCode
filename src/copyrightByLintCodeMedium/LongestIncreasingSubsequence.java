/**
 * 2015��7��19��
 * Poirot
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class LongestIncreasingSubsequence {
	public int longestIncreasingSubsequence(int[] nums) {
		// write your code here

		// ����һ O(n^2) by Poirot
		// if (nums.length <= 1) {
		// return nums.length;
		// }
		// int[] res = new int[nums.length];
		//
		// res[0]=1; //��ʼ������a[0]��β������������г���Ϊ1
		// for(int i=1;i<nums.length;i++)
		// {
		// res[i]=1; //b[i]��СֵΪ1
		// for(int j=0;j<i;j++)
		// if(nums[i]>=nums[j]&&res[j]+1>res[i])
		// res[i]=res[j]+1;
		// }
		// int max = res[0];
		// for (int i = 0; i < res.length; i++) {
		// if (res[i] > max) {
		// max = res[i];
		// }
		// }
		// return max;

		if (nums.length <= 1) {
			return nums.length;
		}
		int i, j, n = nums.length;
		int[] c = new int[nums.length + 1];
		c[0] = -1;
		c[1] = nums[0];
		int len = 1;// ��ʱֻ��c[1]�����������������еĳ���Ϊ1.
		for (int k = 0; k < c.length; k++) {
			System.out.print(c[k]+ " ");
		}
		System.out.println();
		for (i = 1; i < n; i++) {
			j = find(c, len, nums[i]); // c[j] >= nums[i];
			 
			c[j] = nums[i];
			for (int k = 0; k < c.length; k++) {
				System.out.print(c[k]+ " ");
			}
			System.out.println();
			if (j > len)// Ҫ����len,���ⲹ��һ�㣺�ɶ��ֲ��ҿ�֪jֻ���ܱ�len��1
				len = j;// ����len
		}
		for (int k = 0; k < c.length; k++) {
			System.out.print(c[k]+ " ");
		}
		System.out.println();
		return len;
	}

	int find(int[] a, int len, int n)// �޸ĺ�Ķ��ֲ��ң�������ֵΪx����a[x]>=n
	{
		int left = 0, right = len, mid = (left + right) / 2;
		while (left < right - 1) {
			if (n > a[mid])
				left = mid;
			else if (n < a[mid])
				right = mid;
			else
				left = mid;
			mid = (left + right) / 2;
		}
		if (a[right] < n) {
			return right + 1;
		}
		if (a[left] < n) {
			return right;
		} else {
			return left;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingSubsequence t = new LongestIncreasingSubsequence();
//		int[] nums = {4, 1,3,6,7,9,4,10,5,6};// {88,4,24,82,86,1,56,74,71,9,8,18,26,53,77,87,60,27,69,17,76,23,67,14,98,13,10,83,20,43,39,29,92,31,0,30,90,70,37,59};
		int[] nums = {2,2,2};
		// System.out.println(t.find(nums, 6, 1));
		System.out.println(t.longestIncreasingSubsequence(nums));
	}

}
