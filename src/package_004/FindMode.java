package package_004;
//听说很难，还是多看看吧,这里不是还顺了一手类和方法吗，多看看挺好的众数问题投票法最快
/**
 * 好好理解这两个方法，一个递归，一个投票看起来挺重要
 */

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */
public class FindMode {
    public static void main(String[] args) {
        int[] array = new int[]{1,1,1,2,3};
        System.out.println(MethodRecursive.manyNumRecursive(array));
        System.out.println(ManyNumVote.manyNumVote(array));

    }
}

/**
 * 递归方法求解类
 */

class MethodRecursive{

    /**
     * 调用方法
     * @param nums
     * @return
     */
    public static int manyNumRecursive(int[] nums){
        return manyNumRecursiveInternal(nums , 0 , nums.length - 1);
    }

    /**
     * 实现方法传入一个数组和区间，找到众数
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public  static int manyNumRecursiveInternal(int[] nums , int left , int right){
        //当所给区间只有一个元素
        if(left == right){
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftNum = manyNumRecursiveInternal(nums , left , mid);
        int rightNum = manyNumRecursiveInternal(nums , mid + 1 , right);
        if(leftNum == rightNum)
            return leftNum;
        int leftCount = numCount(nums , leftNum);
        int rightCount = numCount(nums , rightNum);
        return leftCount > rightCount ? leftCount : rightCount;

    }

    /**
     * 判断大小累计次数
     * @param nums
     * @param value
     * @return
     */
    public static int numCount(int[] nums , int value){
        int count = 0;
        for (int i:nums
             ) {
            if (value == i) {
                count++;
            }
        }
        return count;
    }


}

/**
 * 投票法
 */
class ManyNumVote {
    public static int manyNumVote(int nums[]) {
        //赞成count
        int count = 0;
        //candidate候选人
        Integer candidate = null;
        for (int i : nums
        ) {
            if (count == 0)
                candidate = i;
            if (candidate != i) {
                count -= 1;
            } else
                count++;
        }
        return candidate;
    }
}
