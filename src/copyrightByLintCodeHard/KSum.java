/**
 * 2015��7��13��
 * CH
 */
package copyrightByLintCodeHard;

/**
 * @author CH
 *
 */
public class KSum {
	int result = 0;

	public void combinationSumForCall(int[] candidates, int beginIndex, int k, int target) {
		if (target == 0 && k == 0) {
			result++;
			return;
		} else if (target <= 0 || k <= 0) {
			return;
		} else if (beginIndex > candidates.length - k) {
			return;
		}
		if (candidates[beginIndex] > target) {
			return;
		}
		if (candidates[beginIndex] * k > target) {
			return;
		}
		for (int i = beginIndex; i < candidates.length; i++) {
			if (candidates[i] > target) {
				break;
			}
			combinationSumForCall(candidates, i + 1, k - 1, target - candidates[i]);
		}
	}

	public int kSum(int A[], int k, int target) {
		// write your code here

		// ����һ TLE
		// for (int i = 0; i <= A.length-k; i++) {
		// combinationSumForCall(A, i+1, k-1, target-A[i]);
		// }
		// return result;

		// ������ TLE
		// if (A.length < k || k == 0)
		// return 0;
		//
		// if(k == 1){
		// for(int i=0;i<A.length;i++)
		// if(A[i] == target)
		// return 1;
		// return 0;
		// }
		// else {
		// int[] B = new int[A.length - 1];
		// if (A.length > 1)
		// System.arraycopy(A, 1, B, 0, A.length - 1);
		// return kSum(B, k - 1, target - A[0]) + kSum(B, k, target);
		// }

		// ˼·���ο����Ͻⷨ�����ǵ��������һ��������������ĺ�ΪN����ϸ���������
		// ��ʱ��һ��һά�������洢���Թ��ɵ�������������ͬ����һ������Ϊtarget���������洢���ݣ�
		// �����ǰj������ѡ��i�������͵Ĺ��ɷֲ����������ݾ���dp[i][j][target]�������½켴�ɡ�
		// dp[i][j][v]=dp[i][j-1][v]+dp[i-1][j-1][v-A[i]]
		int[][][] dp = new int[k + 1][A.length + 1][target + 1];

		for (int i = 1; i <= A.length; i++) {
			for (int j = i; j > 0; j--) {
				if (A[j - 1] <= target)
					dp[1][i][A[j - 1]] = 1;
			}
		}

		for (int m = 2; m <= k; m++) {
			for (int n = m; n <= A.length; n++) {
				for (int l = 0; l <= target; l++) {
					dp[m][n][l] = dp[m][n][l] + dp[m][n - 1][l];
					if (l + A[n - 1] <= target)
						dp[m][n][l + A[n - 1]] = dp[m][n][l + A[n - 1]] + dp[m - 1][n - 1][l];
				}
			}
		}

		return dp[k][A.length][target];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KSum t = new KSum();
		int[] nums = { 1, 3, 4, 5, 8, 10, 11, 12, 14, 17, 20, 22, 24, 25, 28, 30, 31, 34, 35, 37, 38, 40, 42, 44, 45,
				48, 51, 54, 56, 59, 60, 61, 63, 66 };

		System.out.println(t.kSum(nums, 24, 842));
	}

}
